package com.android.internal.org.bouncycastle.cert;

import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.AttCertValidityPeriod;
import com.android.internal.org.bouncycastle.asn1.x509.Attribute;
import com.android.internal.org.bouncycastle.asn1.x509.AttributeCertificate;
import com.android.internal.org.bouncycastle.asn1.x509.AttributeCertificateInfo;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.asn1.x509.Extensions;
import com.android.internal.org.bouncycastle.operator.ContentVerifier;
import com.android.internal.org.bouncycastle.operator.ContentVerifierProvider;
import com.android.internal.org.bouncycastle.util.Encodable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X509AttributeCertificateHolder implements Encodable, Serializable {
    private static Attribute[] EMPTY_ARRAY = new Attribute[0];
    private static final long serialVersionUID = 20170722001L;
    private transient AttributeCertificate attrCert;
    private transient Extensions extensions;

    private static AttributeCertificate parseBytes(byte[] certEncoding) throws IOException {
        try {
            return AttributeCertificate.getInstance(CertUtils.parseNonEmptyASN1(certEncoding));
        } catch (ClassCastException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        } catch (IllegalArgumentException e10) {
            throw new CertIOException("malformed data: " + e10.getMessage(), e10);
        }
    }

    public X509AttributeCertificateHolder(byte[] certEncoding) throws IOException {
        this(parseBytes(certEncoding));
    }

    public X509AttributeCertificateHolder(AttributeCertificate attrCert) {
        init(attrCert);
    }

    private void init(AttributeCertificate attrCert) {
        this.attrCert = attrCert;
        this.extensions = attrCert.getAcinfo().getExtensions();
    }

    @Override // com.android.internal.org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return this.attrCert.getEncoded();
    }

    public int getVersion() {
        return this.attrCert.getAcinfo().getVersion().intValueExact() + 1;
    }

    public BigInteger getSerialNumber() {
        return this.attrCert.getAcinfo().getSerialNumber().getValue();
    }

    public AttributeCertificateHolder getHolder() {
        return new AttributeCertificateHolder((ASN1Sequence) this.attrCert.getAcinfo().getHolder().toASN1Primitive());
    }

    public AttributeCertificateIssuer getIssuer() {
        return new AttributeCertificateIssuer(this.attrCert.getAcinfo().getIssuer());
    }

    public Date getNotBefore() {
        return CertUtils.recoverDate(this.attrCert.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime());
    }

    public Date getNotAfter() {
        return CertUtils.recoverDate(this.attrCert.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime());
    }

    public Attribute[] getAttributes() {
        ASN1Sequence seq = this.attrCert.getAcinfo().getAttributes();
        Attribute[] attrs = new Attribute[seq.size()];
        for (int i10 = 0; i10 != seq.size(); i10++) {
            attrs[i10] = Attribute.getInstance(seq.getObjectAt(i10));
        }
        return attrs;
    }

    public Attribute[] getAttributes(ASN1ObjectIdentifier type) {
        ASN1Sequence seq = this.attrCert.getAcinfo().getAttributes();
        List list = new ArrayList();
        for (int i10 = 0; i10 != seq.size(); i10++) {
            Attribute attr = Attribute.getInstance(seq.getObjectAt(i10));
            if (attr.getAttrType().equals((ASN1Primitive) type)) {
                list.add(attr);
            }
        }
        int i11 = list.size();
        if (i11 == 0) {
            return EMPTY_ARRAY;
        }
        return (Attribute[]) list.toArray(new Attribute[list.size()]);
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public Extension getExtension(ASN1ObjectIdentifier oid) {
        Extensions extensions = this.extensions;
        if (extensions != null) {
            return extensions.getExtension(oid);
        }
        return null;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public List getExtensionOIDs() {
        return CertUtils.getExtensionOIDs(this.extensions);
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.extensions);
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public boolean[] getIssuerUniqueID() {
        return CertUtils.bitStringToBoolean(this.attrCert.getAcinfo().getIssuerUniqueID());
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.attrCert.getSignatureAlgorithm();
    }

    public byte[] getSignature() {
        return this.attrCert.getSignatureValue().getOctets();
    }

    public AttributeCertificate toASN1Structure() {
        return this.attrCert;
    }

    public boolean isValidOn(Date date) {
        AttCertValidityPeriod certValidityPeriod = this.attrCert.getAcinfo().getAttrCertValidityPeriod();
        return (date.before(CertUtils.recoverDate(certValidityPeriod.getNotBeforeTime())) || date.after(CertUtils.recoverDate(certValidityPeriod.getNotAfterTime()))) ? false : true;
    }

    public boolean isSignatureValid(ContentVerifierProvider verifierProvider) throws CertException {
        AttributeCertificateInfo acinfo = this.attrCert.getAcinfo();
        if (!CertUtils.isAlgIdEqual(acinfo.getSignature(), this.attrCert.getSignatureAlgorithm())) {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
        try {
            ContentVerifier verifier = verifierProvider.get(acinfo.getSignature());
            OutputStream sOut = verifier.getOutputStream();
            acinfo.encodeTo(sOut, ASN1Encoding.DER);
            sOut.close();
            return verifier.verify(getSignature());
        } catch (Exception e2) {
            throw new CertException("unable to process signature: " + e2.getMessage(), e2);
        }
    }

    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof X509AttributeCertificateHolder)) {
            return false;
        }
        X509AttributeCertificateHolder other = (X509AttributeCertificateHolder) o10;
        return this.attrCert.equals(other.attrCert);
    }

    public int hashCode() {
        return this.attrCert.hashCode();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        init(AttributeCertificate.getInstance(in.readObject()));
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(getEncoded());
    }
}
