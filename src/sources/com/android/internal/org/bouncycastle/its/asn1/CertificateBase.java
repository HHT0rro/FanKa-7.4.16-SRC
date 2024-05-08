package com.android.internal.org.bouncycastle.its.asn1;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERSequence;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CertificateBase extends ASN1Object {
    private CertificateType type;
    private byte[] version;

    /* JADX INFO: Access modifiers changed from: protected */
    public CertificateBase(ASN1Sequence seq) {
    }

    public static CertificateBase getInstance(Object o10) {
        if (o10 instanceof ImplicitCertificate) {
            return (ImplicitCertificate) o10;
        }
        if (o10 instanceof ExplicitCertificate) {
            return (ExplicitCertificate) o10;
        }
        if (o10 != null) {
            ASN1Sequence seq = ASN1Sequence.getInstance(o10);
            if (seq.getObjectAt(1).equals(CertificateType.Implicit)) {
                return ImplicitCertificate.getInstance(seq);
            }
            if (seq.getObjectAt(1).equals(CertificateType.Explicit)) {
                return ExplicitCertificate.getInstance(seq);
            }
            throw new IllegalArgumentException("unknown certificate type");
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        return new DERSequence(v2);
    }
}
