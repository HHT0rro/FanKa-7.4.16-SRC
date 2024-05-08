package com.android.internal.org.bouncycastle.jce.provider;

import com.android.internal.org.bouncycastle.asn1.ASN1BitString;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1InputStream;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1String;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.DERIA5String;
import com.android.internal.org.bouncycastle.asn1.DERNull;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import com.android.internal.org.bouncycastle.asn1.misc.NetscapeCertType;
import com.android.internal.org.bouncycastle.asn1.misc.NetscapeRevocationURL;
import com.android.internal.org.bouncycastle.asn1.misc.VerisignCzagExtension;
import com.android.internal.org.bouncycastle.asn1.util.ASN1Dump;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.BasicConstraints;
import com.android.internal.org.bouncycastle.asn1.x509.Certificate;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.asn1.x509.Extensions;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralName;
import com.android.internal.org.bouncycastle.asn1.x509.KeyUsage;
import com.android.internal.org.bouncycastle.asn1.x509.X509Name;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.android.internal.org.bouncycastle.jce.X509Principal;
import com.android.internal.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Integers;
import com.android.internal.org.bouncycastle.util.Strings;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X509CertificateObject extends X509Certificate implements PKCS12BagAttributeCarrier {
    private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
    private BasicConstraints basicConstraints;

    /* renamed from: c, reason: collision with root package name */
    private Certificate f9258c;
    private byte[] encoded;
    private int hashValue;
    private boolean hashValueSet;
    private boolean[] keyUsage;

    public X509CertificateObject(Certificate c4) throws CertificateParsingException {
        this.f9258c = c4;
        try {
            byte[] bytes = getExtensionBytes("2.5.29.19");
            if (bytes != null) {
                this.basicConstraints = BasicConstraints.getInstance(ASN1Primitive.fromByteArray(bytes));
            }
            try {
                byte[] bytes2 = getExtensionBytes("2.5.29.15");
                if (bytes2 != null) {
                    ASN1BitString bits = DERBitString.getInstance(ASN1Primitive.fromByteArray(bytes2));
                    byte[] bytes3 = bits.getBytes();
                    int length = (bytes3.length * 8) - bits.getPadBits();
                    int i10 = 9;
                    if (length >= 9) {
                        i10 = length;
                    }
                    this.keyUsage = new boolean[i10];
                    for (int i11 = 0; i11 != length; i11++) {
                        this.keyUsage[i11] = (bytes3[i11 / 8] & (128 >>> (i11 % 8))) != 0;
                    }
                    return;
                }
                this.keyUsage = null;
            } catch (Exception e2) {
                throw new CertificateParsingException("cannot construct KeyUsage: " + ((Object) e2));
            }
        } catch (Exception e10) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + ((Object) e10));
        }
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.getTime() > getNotAfter().getTime()) {
            throw new CertificateExpiredException("certificate expired on " + this.f9258c.getEndDate().getTime());
        }
        if (date.getTime() < getNotBefore().getTime()) {
            throw new CertificateNotYetValidException("certificate not valid till " + this.f9258c.getStartDate().getTime());
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.f9258c.getVersionNumber();
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.f9258c.getSerialNumber().getValue();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return new X509Principal(this.f9258c.getIssuer());
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f9258c.getIssuer().getEncoded());
        } catch (IOException e2) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return new X509Principal(this.f9258c.getSubject());
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        try {
            return new X500Principal(this.f9258c.getSubject().getEncoded());
        } catch (IOException e2) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.f9258c.getStartDate().getDate();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.f9258c.getEndDate().getDate();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.f9258c.getTBSCertificate().getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.f9258c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        String algName;
        Provider prov = Security.getProvider("BC");
        if (prov != null && (algName = prov.getProperty("Alg.Alias.Signature." + getSigAlgOID())) != null) {
            return algName;
        }
        Provider[] provs = Security.getProviders();
        for (int i10 = 0; i10 != provs.length; i10++) {
            String algName2 = provs[i10].getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (algName2 != null) {
                return algName2;
            }
        }
        return getSigAlgOID();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.f9258c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        if (this.f9258c.getSignatureAlgorithm().getParameters() == null) {
            return null;
        }
        try {
            return this.f9258c.getSignatureAlgorithm().getParameters().toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        DERBitString id2 = this.f9258c.getTBSCertificate().getIssuerUniqueId();
        if (id2 != null) {
            byte[] bytes = id2.getBytes();
            boolean[] boolId = new boolean[(bytes.length * 8) - id2.getPadBits()];
            for (int i10 = 0; i10 != boolId.length; i10++) {
                boolId[i10] = (bytes[i10 / 8] & (128 >>> (i10 % 8))) != 0;
            }
            return boolId;
        }
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        DERBitString id2 = this.f9258c.getTBSCertificate().getSubjectUniqueId();
        if (id2 != null) {
            byte[] bytes = id2.getBytes();
            boolean[] boolId = new boolean[(bytes.length * 8) - id2.getPadBits()];
            for (int i10 = 0; i10 != boolId.length; i10++) {
                boolId[i10] = (bytes[i10 / 8] & (128 >>> (i10 % 8))) != 0;
            }
            return boolId;
        }
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.keyUsage;
    }

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] bytes = getExtensionBytes("2.5.29.37");
        if (bytes != null) {
            try {
                ASN1InputStream dIn = new ASN1InputStream(bytes);
                ASN1Sequence seq = (ASN1Sequence) dIn.readObject();
                List list = new ArrayList();
                for (int i10 = 0; i10 != seq.size(); i10++) {
                    list.add(((ASN1ObjectIdentifier) seq.getObjectAt(i10)).getId());
                }
                return Collections.unmodifiableList(list);
            } catch (Exception e2) {
                throw new CertificateParsingException("error processing extended key usage extension");
            }
        }
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        BasicConstraints basicConstraints = this.basicConstraints;
        if (basicConstraints == null || !basicConstraints.isCA()) {
            return -1;
        }
        if (this.basicConstraints.getPathLenConstraint() == null) {
            return Integer.MAX_VALUE;
        }
        return this.basicConstraints.getPathLenConstraint().intValue();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return getAlternativeNames(getExtensionBytes(Extension.subjectAlternativeName.getId()));
    }

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return getAlternativeNames(getExtensionBytes(Extension.issuerAlternativeName.getId()));
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        if (getVersion() == 3) {
            Set set = new HashSet();
            Extensions extensions = this.f9258c.getTBSCertificate().getExtensions();
            if (extensions != null) {
                Enumeration e2 = extensions.oids();
                while (e2.hasMoreElements()) {
                    ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e2.nextElement();
                    Extension ext = extensions.getExtension(oid);
                    if (ext.isCritical()) {
                        set.add(oid.getId());
                    }
                }
                return set;
            }
            return null;
        }
        return null;
    }

    private byte[] getExtensionBytes(String oid) {
        Extension ext;
        Extensions exts = this.f9258c.getTBSCertificate().getExtensions();
        if (exts != null && (ext = exts.getExtension(new ASN1ObjectIdentifier(oid))) != null) {
            return ext.getExtnValue().getOctets();
        }
        return null;
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String oid) {
        Extension ext;
        Extensions exts = this.f9258c.getTBSCertificate().getExtensions();
        if (exts != null && (ext = exts.getExtension(new ASN1ObjectIdentifier(oid))) != null) {
            try {
                return ext.getExtnValue().getEncoded();
            } catch (Exception e2) {
                throw new IllegalStateException("error parsing " + e2.toString());
            }
        }
        return null;
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() == 3) {
            Set set = new HashSet();
            Extensions extensions = this.f9258c.getTBSCertificate().getExtensions();
            if (extensions != null) {
                Enumeration e2 = extensions.oids();
                while (e2.hasMoreElements()) {
                    ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e2.nextElement();
                    Extension ext = extensions.getExtension(oid);
                    if (!ext.isCritical()) {
                        set.add(oid.getId());
                    }
                }
                return set;
            }
            return null;
        }
        return null;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Extensions extensions;
        if (getVersion() == 3 && (extensions = this.f9258c.getTBSCertificate().getExtensions()) != null) {
            Enumeration e2 = extensions.oids();
            while (e2.hasMoreElements()) {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e2.nextElement();
                String oidId = oid.getId();
                if (!oidId.equals(RFC3280CertPathUtilities.KEY_USAGE) && !oidId.equals(RFC3280CertPathUtilities.CERTIFICATE_POLICIES) && !oidId.equals(RFC3280CertPathUtilities.POLICY_MAPPINGS) && !oidId.equals(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY) && !oidId.equals(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS) && !oidId.equals(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT) && !oidId.equals(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR) && !oidId.equals(RFC3280CertPathUtilities.POLICY_CONSTRAINTS) && !oidId.equals(RFC3280CertPathUtilities.BASIC_CONSTRAINTS) && !oidId.equals(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME) && !oidId.equals(RFC3280CertPathUtilities.NAME_CONSTRAINTS)) {
                    Extension ext = extensions.getExtension(oid);
                    if (ext.isCritical()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.getPublicKey(this.f9258c.getSubjectPublicKeyInfo());
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            if (this.encoded == null) {
                this.encoded = this.f9258c.getEncoded(ASN1Encoding.DER);
            }
            return this.encoded;
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        }
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof java.security.cert.Certificate)) {
            return false;
        }
        java.security.cert.Certificate other = (java.security.cert.Certificate) o10;
        try {
            byte[] b12 = getEncoded();
            byte[] b22 = other.getEncoded();
            return Arrays.areEqual(b12, b22);
        } catch (CertificateEncodingException e2) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public synchronized int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = calculateHashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }

    private int calculateHashCode() {
        int hashCode = 0;
        try {
            byte[] certData = getEncoded();
            for (int i10 = 1; i10 < certData.length; i10++) {
                hashCode += certData[i10] * i10;
            }
            return hashCode;
        } catch (CertificateEncodingException e2) {
            return 0;
        }
    }

    @Override // com.android.internal.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier oid, ASN1Encodable attribute) {
        this.attrCarrier.setBagAttribute(oid, attribute);
    }

    @Override // com.android.internal.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier oid) {
        return this.attrCarrier.getBagAttribute(oid);
    }

    @Override // com.android.internal.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        StringBuffer buf = new StringBuffer();
        String nl = Strings.lineSeparator();
        buf.append("  [0]         Version: ").append(getVersion()).append(nl);
        buf.append("         SerialNumber: ").append((Object) getSerialNumber()).append(nl);
        buf.append("             IssuerDN: ").append((Object) getIssuerDN()).append(nl);
        buf.append("           Start Date: ").append((Object) getNotBefore()).append(nl);
        buf.append("           Final Date: ").append((Object) getNotAfter()).append(nl);
        buf.append("            SubjectDN: ").append((Object) getSubjectDN()).append(nl);
        buf.append("           Public Key: ").append((Object) getPublicKey()).append(nl);
        buf.append("  Signature Algorithm: ").append(getSigAlgName()).append(nl);
        byte[] sig = getSignature();
        buf.append("            Signature: ").append(new String(Hex.encode(sig, 0, 20))).append(nl);
        for (int i10 = 20; i10 < sig.length; i10 += 20) {
            if (i10 < sig.length - 20) {
                buf.append("                       ").append(new String(Hex.encode(sig, i10, 20))).append(nl);
            } else {
                buf.append("                       ").append(new String(Hex.encode(sig, i10, sig.length - i10))).append(nl);
            }
        }
        Extensions extensions = this.f9258c.getTBSCertificate().getExtensions();
        if (extensions != null) {
            Enumeration e2 = extensions.oids();
            if (e2.hasMoreElements()) {
                buf.append("       Extensions: \n");
            }
            while (e2.hasMoreElements()) {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e2.nextElement();
                Extension ext = extensions.getExtension(oid);
                if (ext.getExtnValue() != null) {
                    byte[] octs = ext.getExtnValue().getOctets();
                    ASN1InputStream dIn = new ASN1InputStream(octs);
                    buf.append("                       critical(").append(ext.isCritical()).append(") ");
                    try {
                        if (oid.equals((ASN1Primitive) Extension.basicConstraints)) {
                            buf.append((Object) BasicConstraints.getInstance(dIn.readObject())).append(nl);
                        } else if (oid.equals((ASN1Primitive) Extension.keyUsage)) {
                            buf.append((Object) KeyUsage.getInstance(dIn.readObject())).append(nl);
                        } else if (oid.equals((ASN1Primitive) MiscObjectIdentifiers.netscapeCertType)) {
                            buf.append((Object) new NetscapeCertType((DERBitString) dIn.readObject())).append(nl);
                        } else if (oid.equals((ASN1Primitive) MiscObjectIdentifiers.netscapeRevocationURL)) {
                            buf.append((Object) new NetscapeRevocationURL((DERIA5String) dIn.readObject())).append(nl);
                        } else if (oid.equals((ASN1Primitive) MiscObjectIdentifiers.verisignCzagExtension)) {
                            buf.append((Object) new VerisignCzagExtension((DERIA5String) dIn.readObject())).append(nl);
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
        return buf.toString();
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        String sigName = X509SignatureUtil.getSignatureName(this.f9258c.getSignatureAlgorithm());
        try {
            signature = Signature.getInstance(sigName, "BC");
        } catch (Exception e2) {
            signature = Signature.getInstance(sigName);
        }
        checkSignature(key, signature);
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey key, String sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        String sigName = X509SignatureUtil.getSignatureName(this.f9258c.getSignatureAlgorithm());
        if (sigProvider != null) {
            signature = Signature.getInstance(sigName, sigProvider);
        } else {
            signature = Signature.getInstance(sigName);
        }
        checkSignature(key, signature);
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey key, Provider sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature;
        String sigName = X509SignatureUtil.getSignatureName(this.f9258c.getSignatureAlgorithm());
        if (sigProvider != null) {
            signature = Signature.getInstance(sigName, sigProvider);
        } else {
            signature = Signature.getInstance(sigName);
        }
        checkSignature(key, signature);
    }

    private void checkSignature(PublicKey key, Signature signature) throws CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (!isAlgIdEqual(this.f9258c.getSignatureAlgorithm(), this.f9258c.getTBSCertificate().getSignature())) {
            throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
        }
        ASN1Encodable params = this.f9258c.getSignatureAlgorithm().getParameters();
        X509SignatureUtil.setSignatureParameters(signature, params);
        signature.initVerify(key);
        signature.update(getTBSCertificate());
        if (!signature.verify(getSignature())) {
            throw new SignatureException("certificate does not verify with supplied key");
        }
    }

    private boolean isAlgIdEqual(AlgorithmIdentifier id1, AlgorithmIdentifier id2) {
        if (!id1.getAlgorithm().equals((ASN1Primitive) id2.getAlgorithm())) {
            return false;
        }
        if (id1.getParameters() == null) {
            return id2.getParameters() == null || id2.getParameters().equals(DERNull.INSTANCE);
        }
        if (id2.getParameters() == null) {
            return id1.getParameters() == null || id1.getParameters().equals(DERNull.INSTANCE);
        }
        return id1.getParameters().equals(id2.getParameters());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0033. Please report as an issue. */
    private static Collection getAlternativeNames(byte[] extVal) throws CertificateParsingException {
        if (extVal == null) {
            return null;
        }
        try {
            Collection temp = new ArrayList();
            Enumeration it = ASN1Sequence.getInstance(extVal).getObjects();
            while (it.hasMoreElements()) {
                GeneralName genName = GeneralName.getInstance(it.nextElement());
                List list = new ArrayList();
                list.add(Integers.valueOf(genName.getTagNo()));
                switch (genName.getTagNo()) {
                    case 0:
                    case 3:
                    case 5:
                        list.add(genName.getEncoded());
                        temp.add(Collections.unmodifiableList(list));
                    case 1:
                    case 2:
                    case 6:
                        list.add(((ASN1String) genName.getName()).getString());
                        temp.add(Collections.unmodifiableList(list));
                    case 4:
                        list.add(X509Name.getInstance(genName.getName()).toString(true, X509Name.DefaultSymbols));
                        temp.add(Collections.unmodifiableList(list));
                    case 7:
                        byte[] addrBytes = DEROctetString.getInstance(genName.getName()).getOctets();
                        try {
                            String addr = InetAddress.getByAddress(addrBytes).getHostAddress();
                            list.add(addr);
                            temp.add(Collections.unmodifiableList(list));
                        } catch (UnknownHostException e2) {
                        }
                    case 8:
                        list.add(ASN1ObjectIdentifier.getInstance(genName.getName()).getId());
                        temp.add(Collections.unmodifiableList(list));
                    default:
                        throw new IOException("Bad tag number: " + genName.getTagNo());
                }
            }
            if (temp.size() == 0) {
                return null;
            }
            return Collections.unmodifiableCollection(temp);
        } catch (Exception e10) {
            throw new CertificateParsingException(e10.getMessage());
        }
    }
}
