package com.android.internal.org.bouncycastle.asn1.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.DERSequence;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AttributeCertificateInfo extends ASN1Object {
    private AttCertValidityPeriod attrCertValidityPeriod;
    private ASN1Sequence attributes;
    private Extensions extensions;
    private Holder holder;
    private AttCertIssuer issuer;
    private DERBitString issuerUniqueID;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signature;
    private ASN1Integer version;

    public static AttributeCertificateInfo getInstance(ASN1TaggedObject obj, boolean explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    public static AttributeCertificateInfo getInstance(Object obj) {
        if (obj instanceof AttributeCertificateInfo) {
            return (AttributeCertificateInfo) obj;
        }
        if (obj != null) {
            return new AttributeCertificateInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private AttributeCertificateInfo(ASN1Sequence seq) {
        int start;
        if (seq.size() < 6 || seq.size() > 9) {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }
        if (seq.getObjectAt(0) instanceof ASN1Integer) {
            this.version = ASN1Integer.getInstance(seq.getObjectAt(0));
            start = 1;
        } else {
            this.version = new ASN1Integer(0L);
            start = 0;
        }
        this.holder = Holder.getInstance(seq.getObjectAt(start));
        this.issuer = AttCertIssuer.getInstance(seq.getObjectAt(start + 1));
        this.signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(start + 2));
        this.serialNumber = ASN1Integer.getInstance(seq.getObjectAt(start + 3));
        this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(seq.getObjectAt(start + 4));
        this.attributes = ASN1Sequence.getInstance(seq.getObjectAt(start + 5));
        for (int i10 = start + 6; i10 < seq.size(); i10++) {
            ASN1Encodable obj = seq.getObjectAt(i10);
            if (obj instanceof DERBitString) {
                this.issuerUniqueID = DERBitString.getInstance(seq.getObjectAt(i10));
            } else if ((obj instanceof ASN1Sequence) || (obj instanceof Extensions)) {
                this.extensions = Extensions.getInstance(seq.getObjectAt(i10));
            }
        }
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public Holder getHolder() {
        return this.holder;
    }

    public AttCertIssuer getIssuer() {
        return this.issuer;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AttCertValidityPeriod getAttrCertValidityPeriod() {
        return this.attrCertValidityPeriod;
    }

    public ASN1Sequence getAttributes() {
        return this.attributes;
    }

    public DERBitString getIssuerUniqueID() {
        return this.issuerUniqueID;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(9);
        if (this.version.intValueExact() != 0) {
            v2.add(this.version);
        }
        v2.add(this.holder);
        v2.add(this.issuer);
        v2.add(this.signature);
        v2.add(this.serialNumber);
        v2.add(this.attrCertValidityPeriod);
        v2.add(this.attributes);
        DERBitString dERBitString = this.issuerUniqueID;
        if (dERBitString != null) {
            v2.add(dERBitString);
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            v2.add(extensions);
        }
        return new DERSequence(v2);
    }
}
