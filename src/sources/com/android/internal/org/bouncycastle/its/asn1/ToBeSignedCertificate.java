package com.android.internal.org.bouncycastle.its.asn1;

import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ToBeSignedCertificate extends ASN1Object {
    private ToBeSignedCertificate(ASN1Sequence seq) {
    }

    public static ToBeSignedCertificate getInstance(Object src) {
        if (src instanceof ToBeSignedCertificate) {
            return (ToBeSignedCertificate) src;
        }
        if (src != null) {
            return new ToBeSignedCertificate(ASN1Sequence.getInstance(src));
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
