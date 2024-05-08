package com.android.internal.org.bouncycastle.its.asn1;

import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RectangularRegion extends ASN1Object {
    private RectangularRegion(ASN1Sequence seq) {
    }

    public static RectangularRegion getInstance(Object o10) {
        if (o10 instanceof RectangularRegion) {
            return (RectangularRegion) o10;
        }
        if (o10 != null) {
            return new RectangularRegion(ASN1Sequence.getInstance(o10));
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
