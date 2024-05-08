package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j extends t {
    private boolean aMu;
    private String aMv;
    private String aMw;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.aMu = false;
        this.aMv = "";
        this.aMw = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i10 >= bArr.length) {
                break;
            }
            if (bArr[i10] == 0) {
                iArr[i11] = i10;
                i11++;
                if (i11 == 1) {
                    i10 += 2;
                }
                if (i11 == 3) {
                    break;
                }
            }
            i10++;
        }
        if (i11 != 3) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.key = b.d(dVar.data, 0, iArr[0]);
        int i12 = iArr[0] + 1;
        byte[] bArr2 = dVar.data;
        boolean z10 = bArr2[i12] != 0;
        this.aMu = z10;
        int i13 = i12 + 1;
        if (z10 && bArr2[i13] != 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.aMv = b.d(dVar.data, i13, iArr[1] - i13);
        this.aMw = b.e(dVar.data, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i14 = iArr[2] + 1;
        if (this.aMu) {
            byte[] bArr3 = dVar.data;
            this.aMO = b.j(b.b(bArr3, i14, bArr3.length - i14, false));
        } else {
            byte[] bArr4 = dVar.data;
            this.aMO = b.e(bArr4, i14, bArr4.length - i14);
        }
    }
}
