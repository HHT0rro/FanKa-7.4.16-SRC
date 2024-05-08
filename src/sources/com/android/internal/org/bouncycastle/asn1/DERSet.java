package com.android.internal.org.bouncycastle.asn1;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DERSet extends ASN1Set {
    private int bodyLength;

    public static DERSet convert(ASN1Set set) {
        return (DERSet) set.toDERObject();
    }

    public DERSet() {
        this.bodyLength = -1;
    }

    public DERSet(ASN1Encodable element) {
        super(element);
        this.bodyLength = -1;
    }

    public DERSet(ASN1EncodableVector elementVector) {
        super(elementVector, true);
        this.bodyLength = -1;
    }

    public DERSet(ASN1Encodable[] elements) {
        super(elements, true);
        this.bodyLength = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DERSet(boolean isSorted, ASN1Encodable[] elements) {
        super(checkSorted(isSorted), elements);
        this.bodyLength = -1;
    }

    private int getBodyLength() throws IOException {
        if (this.bodyLength < 0) {
            int count = this.elements.length;
            int totalLength = 0;
            for (int i10 = 0; i10 < count; i10++) {
                ASN1Primitive derObject = this.elements[i10].toASN1Primitive().toDERObject();
                totalLength += derObject.encodedLength();
            }
            this.bodyLength = totalLength;
        }
        int count2 = this.bodyLength;
        return count2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int length = getBodyLength();
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Set, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream out, boolean withTag) throws IOException {
        if (withTag) {
            out.write(49);
        }
        DEROutputStream derOut = out.getDERSubStream();
        int count = this.elements.length;
        if (this.bodyLength >= 0 || count > 16) {
            int totalLength = getBodyLength();
            out.writeLength(totalLength);
            for (int i10 = 0; i10 < count; i10++) {
                this.elements[i10].toASN1Primitive().toDERObject().encode(derOut, true);
            }
            return;
        }
        int totalLength2 = 0;
        ASN1Primitive[] derObjects = new ASN1Primitive[count];
        for (int i11 = 0; i11 < count; i11++) {
            ASN1Primitive derObject = this.elements[i11].toASN1Primitive().toDERObject();
            derObjects[i11] = derObject;
            totalLength2 += derObject.encodedLength();
        }
        this.bodyLength = totalLength2;
        out.writeLength(totalLength2);
        for (int i12 = 0; i12 < count; i12++) {
            derObjects[i12].encode(derOut, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Set, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this.isSorted ? this : super.toDERObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Set, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    private static boolean checkSorted(boolean isSorted) {
        if (!isSorted) {
            throw new IllegalStateException("DERSet elements should always be in sorted order");
        }
        return isSorted;
    }
}
