package com.android.internal.org.bouncycastle.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1InputStream;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.internal.org.bouncycastle.asn1.x509.TBSCertificate;
import com.android.internal.org.bouncycastle.asn1.x509.Time;
import com.android.internal.org.bouncycastle.asn1.x509.V3TBSCertificateGenerator;
import com.android.internal.org.bouncycastle.asn1.x509.X509ExtensionsGenerator;
import com.android.internal.org.bouncycastle.asn1.x509.X509Name;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import com.android.internal.org.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import com.android.internal.org.bouncycastle.jce.X509Principal;
import com.android.internal.org.bouncycastle.x509.extension.X509ExtensionUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X509V3CertificateGenerator {
    private AlgorithmIdentifier sigAlgId;
    private ASN1ObjectIdentifier sigOID;
    private String signatureAlgorithm;
    private final JcaJceHelper bcHelper = new BCJcaJceHelper();
    private final CertificateFactory certificateFactory = new CertificateFactory();
    private V3TBSCertificateGenerator tbsGen = new V3TBSCertificateGenerator();
    private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();

    public void reset() {
        this.tbsGen = new V3TBSCertificateGenerator();
        this.extGenerator.reset();
    }

    public void setSerialNumber(BigInteger serialNumber) {
        if (serialNumber.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("serial number must be a positive integer");
        }
        this.tbsGen.setSerialNumber(new ASN1Integer(serialNumber));
    }

    public void setIssuerDN(X500Principal issuer) {
        try {
            this.tbsGen.setIssuer(new X509Principal(issuer.getEncoded()));
        } catch (IOException e2) {
            throw new IllegalArgumentException("can't process principal: " + ((Object) e2));
        }
    }

    public void setIssuerDN(X509Name issuer) {
        this.tbsGen.setIssuer(issuer);
    }

    public void setNotBefore(Date date) {
        this.tbsGen.setStartDate(new Time(date));
    }

    public void setNotAfter(Date date) {
        this.tbsGen.setEndDate(new Time(date));
    }

    public void setSubjectDN(X500Principal subject) {
        try {
            this.tbsGen.setSubject(new X509Principal(subject.getEncoded()));
        } catch (IOException e2) {
            throw new IllegalArgumentException("can't process principal: " + ((Object) e2));
        }
    }

    public void setSubjectDN(X509Name subject) {
        this.tbsGen.setSubject(subject);
    }

    public void setPublicKey(PublicKey key) throws IllegalArgumentException {
        try {
            this.tbsGen.setSubjectPublicKeyInfo(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(key.getEncoded()).readObject()));
        } catch (Exception e2) {
            throw new IllegalArgumentException("unable to process key - " + e2.toString());
        }
    }

    public void setSignatureAlgorithm(String signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
        try {
            ASN1ObjectIdentifier algorithmOID = X509Util.getAlgorithmOID(signatureAlgorithm);
            this.sigOID = algorithmOID;
            AlgorithmIdentifier sigAlgID = X509Util.getSigAlgID(algorithmOID, signatureAlgorithm);
            this.sigAlgId = sigAlgID;
            this.tbsGen.setSignature(sigAlgID);
        } catch (Exception e2) {
            throw new IllegalArgumentException("Unknown signature type requested: " + signatureAlgorithm);
        }
    }

    public void setSubjectUniqueID(boolean[] uniqueID) {
        this.tbsGen.setSubjectUniqueID(booleanToBitString(uniqueID));
    }

    public void setIssuerUniqueID(boolean[] uniqueID) {
        this.tbsGen.setIssuerUniqueID(booleanToBitString(uniqueID));
    }

    private DERBitString booleanToBitString(boolean[] id2) {
        byte[] bytes = new byte[(id2.length + 7) / 8];
        for (int i10 = 0; i10 != id2.length; i10++) {
            int i11 = i10 / 8;
            bytes[i11] = (byte) (bytes[i11] | (id2[i10] ? 1 << (7 - (i10 % 8)) : 0));
        }
        int i12 = id2.length;
        int pad = i12 % 8;
        if (pad == 0) {
            return new DERBitString(bytes);
        }
        return new DERBitString(bytes, 8 - pad);
    }

    public void addExtension(String oid, boolean critical, ASN1Encodable value) {
        addExtension(new ASN1ObjectIdentifier(oid), critical, value);
    }

    public void addExtension(ASN1ObjectIdentifier oid, boolean critical, ASN1Encodable value) {
        this.extGenerator.addExtension(new ASN1ObjectIdentifier(oid.getId()), critical, value);
    }

    public void addExtension(String oid, boolean critical, byte[] value) {
        addExtension(new ASN1ObjectIdentifier(oid), critical, value);
    }

    public void addExtension(ASN1ObjectIdentifier oid, boolean critical, byte[] value) {
        this.extGenerator.addExtension(new ASN1ObjectIdentifier(oid.getId()), critical, value);
    }

    public void copyAndAddExtension(String oid, boolean critical, X509Certificate cert) throws CertificateParsingException {
        byte[] extValue = cert.getExtensionValue(oid);
        if (extValue == null) {
            throw new CertificateParsingException("extension " + oid + " not present");
        }
        try {
            ASN1Encodable value = X509ExtensionUtil.fromExtensionValue(extValue);
            addExtension(oid, critical, value);
        } catch (IOException e2) {
            throw new CertificateParsingException(e2.toString());
        }
    }

    public void copyAndAddExtension(ASN1ObjectIdentifier oid, boolean critical, X509Certificate cert) throws CertificateParsingException {
        copyAndAddExtension(oid.getId(), critical, cert);
    }

    public X509Certificate generateX509Certificate(PrivateKey key) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509Certificate(key, "BC", null);
        } catch (NoSuchProviderException e2) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public X509Certificate generateX509Certificate(PrivateKey key, SecureRandom random) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509Certificate(key, "BC", random);
        } catch (NoSuchProviderException e2) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public X509Certificate generateX509Certificate(PrivateKey key, String provider) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        return generateX509Certificate(key, provider, null);
    }

    public X509Certificate generateX509Certificate(PrivateKey key, String provider, SecureRandom random) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        try {
            return generate(key, provider, random);
        } catch (InvalidKeyException e2) {
            throw e2;
        } catch (NoSuchProviderException e10) {
            throw e10;
        } catch (SignatureException e11) {
            throw e11;
        } catch (GeneralSecurityException e12) {
            throw new SecurityException("exception: " + ((Object) e12));
        }
    }

    public X509Certificate generate(PrivateKey key) throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(key, (SecureRandom) null);
    }

    public X509Certificate generate(PrivateKey key, SecureRandom random) throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertificate tbsCert = generateTbsCert();
        try {
            byte[] signature = X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, key, random, tbsCert);
            try {
                return generateJcaObject(tbsCert, signature);
            } catch (Exception e2) {
                throw new ExtCertificateEncodingException("exception producing certificate object", e2);
            }
        } catch (IOException e10) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e10);
        }
    }

    public X509Certificate generate(PrivateKey key, String provider) throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(key, provider, null);
    }

    public X509Certificate generate(PrivateKey key, String provider, SecureRandom random) throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertificate tbsCert = generateTbsCert();
        try {
            byte[] signature = X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, provider, key, random, tbsCert);
            try {
                return generateJcaObject(tbsCert, signature);
            } catch (Exception e2) {
                throw new ExtCertificateEncodingException("exception producing certificate object", e2);
            }
        } catch (IOException e10) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e10);
        }
    }

    private TBSCertificate generateTbsCert() {
        if (!this.extGenerator.isEmpty()) {
            this.tbsGen.setExtensions(this.extGenerator.generate());
        }
        return this.tbsGen.generateTBSCertificate();
    }

    private X509Certificate generateJcaObject(TBSCertificate tbsCert, byte[] signature) throws Exception {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        v2.add(tbsCert);
        v2.add(this.sigAlgId);
        v2.add(new DERBitString(signature));
        return (X509Certificate) this.certificateFactory.engineGenerateCertificate(new ByteArrayInputStream(new DERSequence(v2).getEncoded(ASN1Encoding.DER)));
    }

    public Iterator getSignatureAlgNames() {
        return X509Util.getAlgNames();
    }
}
