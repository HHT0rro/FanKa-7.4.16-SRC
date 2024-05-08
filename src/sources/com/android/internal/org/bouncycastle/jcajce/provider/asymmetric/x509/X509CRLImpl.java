package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1InputStream;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.util.ASN1Dump;
import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.CRLDistPoint;
import com.android.internal.org.bouncycastle.asn1.x509.CRLNumber;
import com.android.internal.org.bouncycastle.asn1.x509.CertificateList;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.asn1.x509.Extensions;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralNames;
import com.android.internal.org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import com.android.internal.org.bouncycastle.asn1.x509.TBSCertList;
import com.android.internal.org.bouncycastle.asn1.x509.Time;
import com.android.internal.org.bouncycastle.jcajce.CompositePublicKey;
import com.android.internal.org.bouncycastle.jcajce.io.OutputStreamFactory;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import com.android.internal.org.bouncycastle.jce.X509Principal;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Strings;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
abstract class X509CRLImpl extends X509CRL {
    protected JcaJceHelper bcHelper;

    /* renamed from: c, reason: collision with root package name */
    protected CertificateList f9244c;
    protected boolean isIndirect;
    protected String sigAlgName;
    protected byte[] sigAlgParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509CRLImpl(JcaJceHelper bcHelper, CertificateList c4, String sigAlgName, byte[] sigAlgParams, boolean isIndirect) {
        this.bcHelper = bcHelper;
        this.f9244c = c4;
        this.sigAlgName = sigAlgName;
        this.sigAlgParams = sigAlgParams;
        this.isIndirect = isIndirect;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set extns = getCriticalExtensionOIDs();
        if (extns == null) {
            return false;
        }
        extns.remove(Extension.issuingDistributionPoint.getId());
        extns.remove(Extension.deltaCRLIndicator.getId());
        return !extns.isEmpty();
    }

    private Set getExtensionOIDs(boolean critical) {
        Extensions extensions;
        if (getVersion() == 2 && (extensions = this.f9244c.getTBSCertList().getExtensions()) != null) {
            Set set = new HashSet();
            Enumeration e2 = extensions.oids();
            while (e2.hasMoreElements()) {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e2.nextElement();
                Extension ext = extensions.getExtension(oid);
                if (critical == ext.isCritical()) {
                    set.add(oid.getId());
                }
            }
            return set;
        }
        return null;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String oid) {
        ASN1OctetString extValue = getExtensionValue(this.f9244c, oid);
        if (extValue != null) {
            try {
                return extValue.getEncoded();
            } catch (Exception e2) {
                throw new IllegalStateException("error parsing " + e2.toString());
            }
        }
        return null;
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        try {
            return this.f9244c.getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new CRLException(e2.toString());
        }
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey key) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        doVerify(key, new SignatureCreator() { // from class: com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLImpl.1
            @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.SignatureCreator
            public Signature createSignature(String sigName) throws NoSuchAlgorithmException, NoSuchProviderException {
                try {
                    return X509CRLImpl.this.bcHelper.createSignature(sigName);
                } catch (Exception e2) {
                    return Signature.getInstance(sigName);
                }
            }
        });
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey key, final String sigProvider) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        doVerify(key, new SignatureCreator() { // from class: com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLImpl.2
            @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.SignatureCreator
            public Signature createSignature(String sigName) throws NoSuchAlgorithmException, NoSuchProviderException {
                String str = sigProvider;
                if (str != null) {
                    return Signature.getInstance(sigName, str);
                }
                return Signature.getInstance(sigName);
            }
        });
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey key, final Provider sigProvider) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        try {
            doVerify(key, new SignatureCreator() { // from class: com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLImpl.3
                @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.SignatureCreator
                public Signature createSignature(String sigName) throws NoSuchAlgorithmException, NoSuchProviderException {
                    if (sigProvider != null) {
                        return Signature.getInstance(X509CRLImpl.this.getSigAlgName(), sigProvider);
                    }
                    return Signature.getInstance(X509CRLImpl.this.getSigAlgName());
                }
            });
        } catch (NoSuchProviderException e2) {
            throw new NoSuchAlgorithmException("provider issue: " + e2.getMessage());
        }
    }

    private void doVerify(PublicKey key, SignatureCreator sigCreator) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException {
        if (!this.f9244c.getSignatureAlgorithm().equals(this.f9244c.getTBSCertList().getSignature())) {
            throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
        }
        if ((key instanceof CompositePublicKey) && X509SignatureUtil.isCompositeAlgorithm(this.f9244c.getSignatureAlgorithm())) {
            List<PublicKey> pubKeys = ((CompositePublicKey) key).getPublicKeys();
            ASN1Sequence keySeq = ASN1Sequence.getInstance(this.f9244c.getSignatureAlgorithm().getParameters());
            ASN1Sequence sigSeq = ASN1Sequence.getInstance(DERBitString.getInstance(this.f9244c.getSignature()).getBytes());
            boolean success = false;
            for (int i10 = 0; i10 != pubKeys.size(); i10++) {
                if (pubKeys.get(i10) != null) {
                    AlgorithmIdentifier sigAlg = AlgorithmIdentifier.getInstance(keySeq.getObjectAt(i10));
                    String sigName = X509SignatureUtil.getSignatureName(sigAlg);
                    Signature signature = sigCreator.createSignature(sigName);
                    SignatureException sigExc = null;
                    try {
                        checkSignature(pubKeys.get(i10), signature, sigAlg.getParameters(), DERBitString.getInstance(sigSeq.getObjectAt(i10)).getBytes());
                        success = true;
                    } catch (SignatureException e2) {
                        sigExc = e2;
                    }
                    if (sigExc != null) {
                        throw sigExc;
                    }
                }
            }
            if (!success) {
                throw new InvalidKeyException("no matching key found");
            }
            return;
        }
        if (X509SignatureUtil.isCompositeAlgorithm(this.f9244c.getSignatureAlgorithm())) {
            ASN1Sequence keySeq2 = ASN1Sequence.getInstance(this.f9244c.getSignatureAlgorithm().getParameters());
            ASN1Sequence sigSeq2 = ASN1Sequence.getInstance(DERBitString.getInstance(this.f9244c.getSignature()).getBytes());
            boolean success2 = false;
            for (int i11 = 0; i11 != sigSeq2.size(); i11++) {
                AlgorithmIdentifier sigAlg2 = AlgorithmIdentifier.getInstance(keySeq2.getObjectAt(i11));
                String sigName2 = X509SignatureUtil.getSignatureName(sigAlg2);
                SignatureException sigExc2 = null;
                try {
                    Signature signature2 = sigCreator.createSignature(sigName2);
                    checkSignature(key, signature2, sigAlg2.getParameters(), DERBitString.getInstance(sigSeq2.getObjectAt(i11)).getBytes());
                    success2 = true;
                } catch (InvalidKeyException e10) {
                } catch (NoSuchAlgorithmException e11) {
                } catch (SignatureException e12) {
                    sigExc2 = e12;
                }
                if (sigExc2 != null) {
                    throw sigExc2;
                }
            }
            if (!success2) {
                throw new InvalidKeyException("no matching key found");
            }
            return;
        }
        Signature sig = sigCreator.createSignature(getSigAlgName());
        byte[] bArr = this.sigAlgParams;
        if (bArr == null) {
            checkSignature(key, sig, null, getSignature());
            return;
        }
        try {
            checkSignature(key, sig, ASN1Primitive.fromByteArray(bArr), getSignature());
        } catch (IOException e13) {
            throw new SignatureException("cannot decode signature parameters: " + e13.getMessage());
        }
    }

    private void checkSignature(PublicKey key, Signature sig, ASN1Encodable sigAlgParams, byte[] encSig) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException {
        if (sigAlgParams != null) {
            X509SignatureUtil.setSignatureParameters(sig, sigAlgParams);
        }
        sig.initVerify(key);
        try {
            OutputStream sigOut = new BufferedOutputStream(OutputStreamFactory.createStream(sig), 512);
            this.f9244c.getTBSCertList().encodeTo(sigOut, ASN1Encoding.DER);
            sigOut.close();
            if (!sig.verify(encSig)) {
                throw new SignatureException("CRL does not verify with supplied public key.");
            }
        } catch (IOException e2) {
            throw new CRLException(e2.toString());
        }
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return this.f9244c.getVersionNumber();
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return new X509Principal(X500Name.getInstance(this.f9244c.getIssuer().toASN1Primitive()));
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f9244c.getIssuer().getEncoded());
        } catch (IOException e2) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return this.f9244c.getThisUpdate().getDate();
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        Time nextUpdate = this.f9244c.getNextUpdate();
        if (nextUpdate == null) {
            return null;
        }
        return nextUpdate.getDate();
    }

    private Set loadCRLEntries() {
        Extension currentCaName;
        Set entrySet = new HashSet();
        Enumeration certs = this.f9244c.getRevokedCertificateEnumeration();
        X500Name previousCertificateIssuer = null;
        while (certs.hasMoreElements()) {
            TBSCertList.CRLEntry entry = (TBSCertList.CRLEntry) certs.nextElement();
            X509CRLEntryObject crlEntry = new X509CRLEntryObject(entry, this.isIndirect, previousCertificateIssuer);
            entrySet.add(crlEntry);
            if (this.isIndirect && entry.hasExtensions() && (currentCaName = entry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                previousCertificateIssuer = X500Name.getInstance(GeneralNames.getInstance(currentCaName.getParsedValue()).getNames()[0].getName());
            }
        }
        return entrySet;
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger serialNumber) {
        Extension currentCaName;
        Enumeration certs = this.f9244c.getRevokedCertificateEnumeration();
        X500Name previousCertificateIssuer = null;
        while (certs.hasMoreElements()) {
            TBSCertList.CRLEntry entry = (TBSCertList.CRLEntry) certs.nextElement();
            if (entry.getUserCertificate().hasValue(serialNumber)) {
                return new X509CRLEntryObject(entry, this.isIndirect, previousCertificateIssuer);
            }
            if (this.isIndirect && entry.hasExtensions() && (currentCaName = entry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                previousCertificateIssuer = X500Name.getInstance(GeneralNames.getInstance(currentCaName.getParsedValue()).getNames()[0].getName());
            }
        }
        return null;
    }

    @Override // java.security.cert.X509CRL
    public Set getRevokedCertificates() {
        Set entrySet = loadCRLEntries();
        if (!entrySet.isEmpty()) {
            return Collections.unmodifiableSet(entrySet);
        }
        return null;
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() throws CRLException {
        try {
            return this.f9244c.getTBSCertList().getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new CRLException(e2.toString());
        }
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        return this.f9244c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        return this.sigAlgName;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        return this.f9244c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        return Arrays.clone(this.sigAlgParams);
    }

    @Override // java.security.cert.CRL
    public String toString() {
        StringBuffer buf = new StringBuffer();
        String nl = Strings.lineSeparator();
        buf.append("              Version: ").append(getVersion()).append(nl);
        buf.append("             IssuerDN: ").append((Object) getIssuerDN()).append(nl);
        buf.append("          This update: ").append((Object) getThisUpdate()).append(nl);
        buf.append("          Next update: ").append((Object) getNextUpdate()).append(nl);
        buf.append("  Signature Algorithm: ").append(getSigAlgName()).append(nl);
        X509SignatureUtil.prettyPrintSignature(getSignature(), buf, nl);
        Extensions extensions = this.f9244c.getTBSCertList().getExtensions();
        if (extensions != null) {
            Enumeration e2 = extensions.oids();
            if (e2.hasMoreElements()) {
                buf.append("           Extensions: ").append(nl);
            }
            while (e2.hasMoreElements()) {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e2.nextElement();
                Extension ext = extensions.getExtension(oid);
                if (ext.getExtnValue() != null) {
                    byte[] octs = ext.getExtnValue().getOctets();
                    ASN1InputStream dIn = new ASN1InputStream(octs);
                    buf.append("                       critical(").append(ext.isCritical()).append(") ");
                    try {
                        if (oid.equals((ASN1Primitive) Extension.cRLNumber)) {
                            buf.append((Object) new CRLNumber(ASN1Integer.getInstance(dIn.readObject()).getPositiveValue())).append(nl);
                        } else if (oid.equals((ASN1Primitive) Extension.deltaCRLIndicator)) {
                            buf.append("Base CRL: " + ((Object) new CRLNumber(ASN1Integer.getInstance(dIn.readObject()).getPositiveValue()))).append(nl);
                        } else if (oid.equals((ASN1Primitive) Extension.issuingDistributionPoint)) {
                            buf.append((Object) IssuingDistributionPoint.getInstance(dIn.readObject())).append(nl);
                        } else if (oid.equals((ASN1Primitive) Extension.cRLDistributionPoints)) {
                            buf.append((Object) CRLDistPoint.getInstance(dIn.readObject())).append(nl);
                        } else if (oid.equals((ASN1Primitive) Extension.freshestCRL)) {
                            buf.append((Object) CRLDistPoint.getInstance(dIn.readObject())).append(nl);
                        } else {
                            buf.append(oid.getId());
                            buf.append(" value = ").append(ASN1Dump.dumpAsString(dIn.readObject())).append(nl);
                        }
                    } catch (Exception e10) {
                        buf.append(oid.getId());
                        buf.append(" value = ").append("*****").append(nl);
                    }
                } else {
                    buf.append(nl);
                }
            }
        }
        Set set = getRevokedCertificates();
        if (set != null) {
            Iterator it = set.iterator2();
            while (it.hasNext()) {
                buf.append(it.next());
                buf.append(nl);
            }
        }
        return buf.toString();
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate cert) {
        X500Name issuer;
        Extension currentCaName;
        if (!cert.getType().equals(e.f29912b)) {
            throw new IllegalArgumentException("X.509 CRL used with non X.509 Cert");
        }
        Enumeration certs = this.f9244c.getRevokedCertificateEnumeration();
        X500Name caName = this.f9244c.getIssuer();
        if (certs.hasMoreElements()) {
            BigInteger serial = ((X509Certificate) cert).getSerialNumber();
            while (certs.hasMoreElements()) {
                TBSCertList.CRLEntry entry = TBSCertList.CRLEntry.getInstance(certs.nextElement());
                if (this.isIndirect && entry.hasExtensions() && (currentCaName = entry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                    caName = X500Name.getInstance(GeneralNames.getInstance(currentCaName.getParsedValue()).getNames()[0].getName());
                }
                if (entry.getUserCertificate().hasValue(serial)) {
                    if (cert instanceof X509Certificate) {
                        issuer = X500Name.getInstance(((X509Certificate) cert).getIssuerX500Principal().getEncoded());
                    } else {
                        try {
                            issuer = com.android.internal.org.bouncycastle.asn1.x509.Certificate.getInstance(cert.getEncoded()).getIssuer();
                        } catch (CertificateEncodingException e2) {
                            throw new IllegalArgumentException("Cannot process certificate: " + e2.getMessage());
                        }
                    }
                    return caName.equals(issuer);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] getExtensionOctets(CertificateList c4, String oid) {
        ASN1OctetString extValue = getExtensionValue(c4, oid);
        if (extValue != null) {
            return extValue.getOctets();
        }
        return null;
    }

    protected static ASN1OctetString getExtensionValue(CertificateList c4, String oid) {
        Extension ext;
        Extensions exts = c4.getTBSCertList().getExtensions();
        if (exts != null && (ext = exts.getExtension(new ASN1ObjectIdentifier(oid))) != null) {
            return ext.getExtnValue();
        }
        return null;
    }
}
