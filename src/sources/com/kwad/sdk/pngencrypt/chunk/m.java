package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m extends p {
    private int aMA;
    private int[] aMB;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.aMA = 0;
    }

    private void dW(int i10) {
        this.aMA = i10;
        if (i10 > 0 && i10 <= 256) {
            int[] iArr = this.aMB;
            if (iArr == null || iArr.length != i10) {
                this.aMB = new int[i10];
                return;
            }
            return;
        }
        throw new PngjException("invalid pallette - nentries=" + this.aMA);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        dW(dVar.len / 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < this.aMA) {
            byte[] bArr = dVar.data;
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            a(i10, bArr[i11] & 255, bArr[i12] & 255, bArr[i13] & 255);
            i10++;
            i11 = i13 + 1;
        }
    }

    private void a(int i10, int i11, int i12, int i13) {
        this.aMB[i10] = (i11 << 16) | (i12 << 8) | i13;
    }
}
