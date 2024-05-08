package com.android.internal.org.bouncycastle.its.asn1;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SequenceOfOctetString extends ASN1Object {
    private byte[][] octetStrings;

    private SequenceOfOctetString(ASN1Sequence seq) {
        this.octetStrings = toByteArrays(seq);
    }

    public static SequenceOfOctetString getInstance(Object o10) {
        if (o10 instanceof SequenceOfOctetString) {
            return (SequenceOfOctetString) o10;
        }
        if (o10 != null) {
            return new SequenceOfOctetString(ASN1Sequence.getInstance(o10));
        }
        return null;
    }

    public int size() {
        return this.octetStrings.length;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        int i10 = 0;
        while (true) {
            byte[][] bArr = this.octetStrings;
            if (i10 != bArr.length) {
                v2.add(new DEROctetString(Arrays.clone(bArr[i10])));
                i10++;
            } else {
                return new DERSequence(v2);
            }
        }
    }

    static byte[][] toByteArrays(ASN1Sequence seq) {
        byte[][] octetStrings = new byte[seq.size()];
        for (int i10 = 0; i10 != seq.size(); i10++) {
            octetStrings[i10] = ASN1OctetString.getInstance(seq.getObjectAt(i10)).getOctets();
        }
        return octetStrings;
    }
}
