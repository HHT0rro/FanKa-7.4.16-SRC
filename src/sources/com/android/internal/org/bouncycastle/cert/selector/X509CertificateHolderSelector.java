package com.android.internal.org.bouncycastle.cert.selector;

import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.cert.X509CertificateHolder;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Selector;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X509CertificateHolderSelector implements Selector {
    private X500Name issuer;
    private BigInteger serialNumber;
    private byte[] subjectKeyId;

    public X509CertificateHolderSelector(byte[] subjectKeyId) {
        this(null, null, subjectKeyId);
    }

    public X509CertificateHolderSelector(X500Name issuer, BigInteger serialNumber) {
        this(issuer, serialNumber, null);
    }

    public X509CertificateHolderSelector(X500Name issuer, BigInteger serialNumber, byte[] subjectKeyId) {
        this.issuer = issuer;
        this.serialNumber = serialNumber;
        this.subjectKeyId = subjectKeyId;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public byte[] getSubjectKeyIdentifier() {
        return Arrays.clone(this.subjectKeyId);
    }

    public int hashCode() {
        int code = Arrays.hashCode(this.subjectKeyId);
        BigInteger bigInteger = this.serialNumber;
        if (bigInteger != null) {
            code ^= bigInteger.hashCode();
        }
        X500Name x500Name = this.issuer;
        if (x500Name != null) {
            return code ^ x500Name.hashCode();
        }
        return code;
    }

    public boolean equals(Object o10) {
        if (!(o10 instanceof X509CertificateHolderSelector)) {
            return false;
        }
        X509CertificateHolderSelector id2 = (X509CertificateHolderSelector) o10;
        return Arrays.areEqual(this.subjectKeyId, id2.subjectKeyId) && equalsObj(this.serialNumber, id2.serialNumber) && equalsObj(this.issuer, id2.issuer);
    }

    private boolean equalsObj(Object a10, Object b4) {
        return a10 != null ? a10.equals(b4) : b4 == null;
    }

    @Override // com.android.internal.org.bouncycastle.util.Selector
    public boolean match(Object obj) {
        if (obj instanceof X509CertificateHolder) {
            X509CertificateHolder certHldr = (X509CertificateHolder) obj;
            if (getSerialNumber() != null) {
                IssuerAndSerialNumber iAndS = new IssuerAndSerialNumber(certHldr.toASN1Structure());
                return iAndS.getName().equals(this.issuer) && iAndS.getSerialNumber().hasValue(this.serialNumber);
            }
            if (this.subjectKeyId != null) {
                Extension ext = certHldr.getExtension(Extension.subjectKeyIdentifier);
                if (ext == null) {
                    return Arrays.areEqual(this.subjectKeyId, MSOutlookKeyIdCalculator.calculateKeyId(certHldr.getSubjectPublicKeyInfo()));
                }
                byte[] subKeyID = ASN1OctetString.getInstance(ext.getParsedValue()).getOctets();
                return Arrays.areEqual(this.subjectKeyId, subKeyID);
            }
        } else if (obj instanceof byte[]) {
            return Arrays.areEqual(this.subjectKeyId, (byte[]) obj);
        }
        return false;
    }

    @Override // com.android.internal.org.bouncycastle.util.Selector
    public Object clone() {
        return new X509CertificateHolderSelector(this.issuer, this.serialNumber, this.subjectKeyId);
    }
}
