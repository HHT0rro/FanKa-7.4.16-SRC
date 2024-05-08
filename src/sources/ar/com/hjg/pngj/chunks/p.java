package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkSPLT.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class p extends c.g {

    /* renamed from: i, reason: collision with root package name */
    public String f1135i;

    /* renamed from: j, reason: collision with root package name */
    public int f1136j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f1137k;

    public p(ar.com.hjg.pngj.k kVar) {
        super("sPLT", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        byte[] bArr;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            bArr = dVar.f1495d;
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
            this.f1135i = c.b.j(bArr, 0, i16);
            int f10 = ar.com.hjg.pngj.o.f(dVar.f1495d, i16 + 1);
            this.f1136j = f10;
            int i17 = i16 + 2;
            int length = (dVar.f1495d.length - i17) / (f10 == 8 ? 6 : 10);
            this.f1137k = new int[length * 5];
            int i18 = i17;
            int i19 = 0;
            while (i15 < length) {
                if (this.f1136j == 8) {
                    int i20 = i18 + 1;
                    i11 = ar.com.hjg.pngj.o.f(dVar.f1495d, i18);
                    int i21 = i20 + 1;
                    i12 = ar.com.hjg.pngj.o.f(dVar.f1495d, i20);
                    int i22 = i21 + 1;
                    i13 = ar.com.hjg.pngj.o.f(dVar.f1495d, i21);
                    i10 = i22 + 1;
                    i14 = ar.com.hjg.pngj.o.f(dVar.f1495d, i22);
                } else {
                    int g3 = ar.com.hjg.pngj.o.g(dVar.f1495d, i18);
                    int i23 = i18 + 2;
                    int g10 = ar.com.hjg.pngj.o.g(dVar.f1495d, i23);
                    int i24 = i23 + 2;
                    int g11 = ar.com.hjg.pngj.o.g(dVar.f1495d, i24);
                    int i25 = i24 + 2;
                    int g12 = ar.com.hjg.pngj.o.g(dVar.f1495d, i25);
                    i10 = i25 + 2;
                    i11 = g3;
                    i12 = g10;
                    i13 = g11;
                    i14 = g12;
                }
                int g13 = ar.com.hjg.pngj.o.g(dVar.f1495d, i10);
                int[] iArr = this.f1137k;
                int i26 = i19 + 1;
                iArr[i19] = i11;
                int i27 = i26 + 1;
                iArr[i26] = i12;
                int i28 = i27 + 1;
                iArr[i27] = i13;
                int i29 = i28 + 1;
                iArr[i28] = i14;
                iArr[i29] = g13;
                i15++;
                i19 = i29 + 1;
                i18 = i10 + 2;
            }
            return;
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }

    public String h() {
        return this.f1135i;
    }
}
