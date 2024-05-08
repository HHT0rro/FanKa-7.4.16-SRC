package com.android.internal.org.bouncycastle.asn1;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DLSequence extends ASN1Sequence {
    private int bodyLength;

    public DLSequence() {
        this.bodyLength = -1;
    }

    public DLSequence(ASN1Encodable element) {
        super(element);
        this.bodyLength = -1;
    }

    public DLSequence(ASN1EncodableVector elementVector) {
        super(elementVector);
        this.bodyLength = -1;
    }

    public DLSequence(ASN1Encodable[] elements) {
        super(elements);
        this.bodyLength = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DLSequence(ASN1Encodable[] elements, boolean clone) {
        super(elements, clone);
        this.bodyLength = -1;
    }

    private int getBodyLength() throws IOException {
        if (this.bodyLength < 0) {
            int count = this.elements.length;
            int totalLength = 0;
            for (int i10 = 0; i10 < count; i10++) {
                ASN1Primitive dlObject = this.elements[i10].toASN1Primitive().toDLObject();
                totalLength += dlObject.encodedLength();
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
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Sequence, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream out, boolean withTag) throws IOException {
        if (withTag) {
            out.write(48);
        }
        ASN1OutputStream dlOut = out.getDLSubStream();
        int count = this.elements.length;
        if (this.bodyLength >= 0 || count > 16) {
            int totalLength = getBodyLength();
            out.writeLength(totalLength);
            for (int i10 = 0; i10 < count; i10++) {
                dlOut.writePrimitive(this.elements[i10].toASN1Primitive(), true);
            }
            return;
        }
        int totalLength2 = 0;
        ASN1Primitive[] dlObjects = new ASN1Primitive[count];
        for (int i11 = 0; i11 < count; i11++) {
            ASN1Primitive dlObject = this.elements[i11].toASN1Primitive().toDLObject();
            dlObjects[i11] = dlObject;
            totalLength2 += dlObject.encodedLength();
        }
        this.bodyLength = totalLength2;
        out.writeLength(totalLength2);
        for (int i12 = 0; i12 < count; i12++) {
            dlOut.writePrimitive(dlObjects[i12], true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Sequence, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
