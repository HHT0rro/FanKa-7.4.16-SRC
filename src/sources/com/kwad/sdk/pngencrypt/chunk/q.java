package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i10 = 0;
        while (true) {
            bArr = dVar.data;
            if (i10 >= bArr.length || bArr[i10] == 0) {
                break;
            } else {
                i10++;
            }
        }
        this.key = b.d(bArr, 0, i10);
        int i11 = i10 + 1;
        byte[] bArr2 = dVar.data;
        this.aMO = i11 < bArr2.length ? b.d(bArr2, i11, bArr2.length - i11) : "";
    }
}
