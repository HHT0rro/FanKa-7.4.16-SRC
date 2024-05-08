package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkPLTE.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class n extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int f1128i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f1129j;

    public n(ar.com.hjg.pngj.k kVar) {
        super("PLTE", kVar);
        this.f1128i = 0;
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        i(dVar.f1492a / 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < this.f1128i) {
            byte[] bArr = dVar.f1495d;
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            h(i10, bArr[i11] & 255, bArr[i12] & 255, bArr[i13] & 255);
            i10++;
            i11 = i13 + 1;
        }
    }

    public void h(int i10, int i11, int i12, int i13) {
        this.f1129j[i10] = (i11 << 16) | (i12 << 8) | i13;
    }

    public void i(int i10) {
        this.f1128i = i10;
        if (i10 >= 1 && i10 <= 256) {
            int[] iArr = this.f1129j;
            if (iArr == null || iArr.length != i10) {
                this.f1129j = new int[i10];
                return;
            }
            return;
        }
        throw new PngjException("invalid pallette - nentries=" + this.f1128i);
    }
}
