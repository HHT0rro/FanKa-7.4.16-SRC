package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1BitString;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.x509.BasicConstraints;
import com.android.internal.org.bouncycastle.asn1.x509.Certificate;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import com.android.internal.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class X509CertificateObject extends X509CertificateImpl implements PKCS12BagAttributeCarrier {
    private PKCS12BagAttributeCarrier attrCarrier;
    private final Object cacheLock;
    private byte[] encoded;
    private volatile int hashValue;
    private volatile boolean hashValueSet;
    private X509CertificateInternal internalCertificateValue;
    private X500Principal issuerValue;
    private PublicKey publicKeyValue;
    private X500Principal subjectValue;
    private long[] validityValues;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509CertificateObject(JcaJceHelper bcHelper, Certificate c4) throws CertificateParsingException {
        super(bcHelper, c4, createBasicConstraints(c4), createKeyUsage(c4), createSigAlgName(c4), createSigAlgParams(c4));
        this.cacheLock = new Object();
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        long checkTime = date.getTime();
        long[] validityValues = getValidityValues();
        if (checkTime > validityValues[1]) {
            throw new CertificateExpiredException("certificate expired on " + this.f9245c.getEndDate().getTime());
        }
        if (checkTime < validityValues[0]) {
            throw new CertificateNotYetValidException("certificate not valid till " + this.f9245c.getStartDate().getTime());
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        X500Principal x500Principal;
        synchronized (this.cacheLock) {
            X500Principal x500Principal2 = this.issuerValue;
            if (x500Principal2 != null) {
                return x500Principal2;
            }
            X500Principal temp = super.getIssuerX500Principal();
            synchronized (this.cacheLock) {
                if (this.issuerValue == null) {
                    this.issuerValue = temp;
                }
                x500Principal = this.issuerValue;
            }
            return x500Principal;
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.Certificate
    public PublicKey getPublicKey() {
        PublicKey publicKey;
        synchronized (this.cacheLock) {
            PublicKey publicKey2 = this.publicKeyValue;
            if (publicKey2 != null) {
                return publicKey2;
            }
            PublicKey temp = super.getPublicKey();
            if (temp == null) {
                return null;
            }
            synchronized (this.cacheLock) {
                if (this.publicKeyValue == null) {
                    this.publicKeyValue = temp;
                }
                publicKey = this.publicKeyValue;
            }
            return publicKey;
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        X500Principal x500Principal;
        synchronized (this.cacheLock) {
            X500Principal x500Principal2 = this.subjectValue;
            if (x500Principal2 != null) {
                return x500Principal2;
            }
            X500Principal temp = super.getSubjectX500Principal();
            synchronized (this.cacheLock) {
                if (this.subjectValue == null) {
                    this.subjectValue = temp;
                }
                x500Principal = this.subjectValue;
            }
            return x500Principal;
        }
    }

    public long[] getValidityValues() {
        long[] jArr;
        synchronized (this.cacheLock) {
            long[] jArr2 = this.validityValues;
            if (jArr2 != null) {
                return jArr2;
            }
            long[] temp = {super.getNotBefore().getTime(), super.getNotAfter().getTime()};
            synchronized (this.cacheLock) {
                if (this.validityValues == null) {
                    this.validityValues = temp;
                }
                jArr = this.validityValues;
            }
            return jArr;
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            if (this.encoded == null) {
                this.encoded = this.f9245c.getEncoded(ASN1Encoding.DER);
            }
            return this.encoded;
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        }
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object other) {
        ASN1BitString signature;
        if (other == this) {
            return true;
        }
        if (other instanceof X509CertificateObject) {
            X509CertificateObject otherBC = (X509CertificateObject) other;
            if (this.hashValueSet && otherBC.hashValueSet) {
                if (this.hashValue != otherBC.hashValue) {
                    return false;
                }
            } else if ((this.internalCertificateValue == null || otherBC.internalCertificateValue == null) && (signature = this.f9245c.getSignature()) != null && !signature.equals(otherBC.f9245c.getSignature())) {
                return false;
            }
        }
        return getInternalCertificate().equals(other);
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = getInternalCertificate().hashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }

    public int originalHashCode() {
        int hashCode = 0;
        try {
            byte[] certData = getInternalCertificate().getEncoded();
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

    private X509CertificateInternal getInternalCertificate() {
        byte[] encoding;
        X509CertificateInternal x509CertificateInternal;
        synchronized (this.cacheLock) {
            X509CertificateInternal x509CertificateInternal2 = this.internalCertificateValue;
            if (x509CertificateInternal2 != null) {
                return x509CertificateInternal2;
            }
            try {
                byte[] encoding2 = getEncoded();
                encoding = encoding2;
            } catch (CertificateEncodingException e2) {
                encoding = null;
            }
            X509CertificateInternal temp = new X509CertificateInternal(this.bcHelper, this.f9245c, this.basicConstraints, this.keyUsage, this.sigAlgName, this.sigAlgParams, encoding);
            synchronized (this.cacheLock) {
                if (this.internalCertificateValue == null) {
                    this.internalCertificateValue = temp;
                }
                x509CertificateInternal = this.internalCertificateValue;
            }
            return x509CertificateInternal;
        }
    }

    private static BasicConstraints createBasicConstraints(Certificate c4) throws CertificateParsingException {
        try {
            byte[] extOctets = getExtensionOctets(c4, "2.5.29.19");
            if (extOctets == null) {
                return null;
            }
            return BasicConstraints.getInstance(ASN1Primitive.fromByteArray(extOctets));
        } catch (Exception e2) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + ((Object) e2));
        }
    }

    private static boolean[] createKeyUsage(Certificate c4) throws CertificateParsingException {
        try {
            byte[] extOctets = getExtensionOctets(c4, "2.5.29.15");
            if (extOctets == null) {
                return null;
            }
            ASN1BitString bits = DERBitString.getInstance(ASN1Primitive.fromByteArray(extOctets));
            byte[] bytes = bits.getBytes();
            int length = (bytes.length * 8) - bits.getPadBits();
            int i10 = 9;
            if (length >= 9) {
                i10 = length;
            }
            boolean[] keyUsage = new boolean[i10];
            for (int i11 = 0; i11 != length; i11++) {
                keyUsage[i11] = (bytes[i11 / 8] & (128 >>> (i11 % 8))) != 0;
            }
            return keyUsage;
        } catch (Exception e2) {
            throw new CertificateParsingException("cannot construct KeyUsage: " + ((Object) e2));
        }
    }

    private static String createSigAlgName(Certificate c4) throws CertificateParsingException {
        try {
            return X509SignatureUtil.getSignatureName(c4.getSignatureAlgorithm());
        } catch (Exception e2) {
            throw new CertificateParsingException("cannot construct SigAlgName: " + ((Object) e2));
        }
    }

    private static byte[] createSigAlgParams(Certificate c4) throws CertificateParsingException {
        try {
            ASN1Encodable parameters = c4.getSignatureAlgorithm().getParameters();
            if (parameters == null) {
                return null;
            }
            return parameters.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (Exception e2) {
            throw new CertificateParsingException("cannot construct SigAlgParams: " + ((Object) e2));
        }
    }
}
