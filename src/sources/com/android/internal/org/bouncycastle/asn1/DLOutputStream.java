package com.android.internal.org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DLOutputStream extends ASN1OutputStream {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DLOutputStream(OutputStream os) {
        super(os);
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1OutputStream
    void writePrimitive(ASN1Primitive primitive, boolean withTag) throws IOException {
        primitive.toDLObject().encode(this, withTag);
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1OutputStream
    ASN1OutputStream getDLSubStream() {
        return this;
    }
}
