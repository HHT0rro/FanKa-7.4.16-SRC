package com.android.internal.org.bouncycastle.its.asn1;

import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERSequence;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SequenceOfRectangularRegion extends ASN1Object {
    private final RectangularRegion[] sequence;

    private SequenceOfRectangularRegion(ASN1Sequence seq) {
        this.sequence = new RectangularRegion[seq.size()];
        for (int i10 = 0; i10 != seq.size(); i10++) {
            this.sequence[i10] = RectangularRegion.getInstance(seq.getObjectAt(i10));
        }
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.sequence);
    }
}
