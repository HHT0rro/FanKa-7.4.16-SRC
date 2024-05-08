package com.android.internal.org.bouncycastle.asn1;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BERSequence extends ASN1Sequence {
    public BERSequence() {
    }

    public BERSequence(ASN1Encodable element) {
        super(element);
    }

    public BERSequence(ASN1EncodableVector elementVector) {
        super(elementVector);
    }

    public BERSequence(ASN1Encodable[] elements) {
        super(elements);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int count = this.elements.length;
        int totalLength = 0;
        for (int i10 = 0; i10 < count; i10++) {
            ASN1Primitive p10 = this.elements[i10].toASN1Primitive();
            totalLength += p10.encodedLength();
        }
        int i11 = totalLength + 2;
        return i11 + 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Sequence, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream out, boolean withTag) throws IOException {
        out.writeEncodedIndef(withTag, 48, this.elements);
    }
}