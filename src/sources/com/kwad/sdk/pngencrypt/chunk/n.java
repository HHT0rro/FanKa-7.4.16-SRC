package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n extends k {
    private String aMC;
    private int aMD;
    private int[] aME;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String Kw() {
        return this.aMC;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            bArr = dVar.data;
            if (i16 >= bArr.length) {
                i16 = -1;
                break;
            } else if (bArr[i16] == 0) {
                break;
            } else {
                i16++;
            }
        }
        if (i16 > 0 && i16 <= bArr.length - 2) {
            this.aMC = b.d(bArr, 0, i16);
            int e2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i16 + 1);
            this.aMD = e2;
            int i17 = i16 + 2;
            int length = (dVar.data.length - i17) / (e2 == 8 ? 6 : 10);
            this.aME = new int[length * 5];
            int i18 = i17;
            int i19 = 0;
            while (i15 < length) {
                if (this.aMD == 8) {
                    int i20 = i18 + 1;
                    i11 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i18);
                    int i21 = i20 + 1;
                    i12 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i20);
                    int i22 = i21 + 1;
                    i13 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i21);
                    i10 = i22 + 1;
                    i14 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i22);
                } else {
                    int f10 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i18);
                    int i23 = i18 + 2;
                    int f11 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i23);
                    int i24 = i23 + 2;
                    int f12 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i24);
                    int i25 = i24 + 2;
                    int f13 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i25);
                    i10 = i25 + 2;
                    i11 = f10;
                    i12 = f11;
                    i13 = f12;
                    i14 = f13;
                }
                int f14 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i10);
                int[] iArr = this.aME;
                int i26 = i19 + 1;
                iArr[i19] = i11;
                int i27 = i26 + 1;
                iArr[i26] = i12;
                int i28 = i27 + 1;
                iArr[i27] = i13;
                int i29 = i28 + 1;
                iArr[i28] = i14;
                iArr[i29] = f14;
                i15++;
                i19 = i29 + 1;
                i18 = i10 + 2;
            }
            return;
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }
}
