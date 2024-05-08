package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class v extends t {
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i10 = 0;
        while (true) {
            bArr = dVar.data;
            if (i10 >= bArr.length) {
                i10 = -1;
                break;
            } else if (bArr[i10] == 0) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0 || i10 > bArr.length - 2) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("bad zTXt chunk: no separator found"));
        }
        this.key = b.d(dVar.data, 0, i10);
        if (dVar.data[i10 + 1] != 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        this.aMO = b.i(b.b(dVar.data, i10 + 2, (r5.length - i10) - 2, false));
    }
}
