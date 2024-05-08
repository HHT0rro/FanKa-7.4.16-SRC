package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkHIST.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int[] f1112i;

    public g(ar.com.hjg.pngj.k kVar) {
        super("hIST", kVar);
        this.f1112i = new int[0];
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (this.f1080e.f1186g) {
            this.f1112i = new int[dVar.f1495d.length / 2];
            int i10 = 0;
            while (true) {
                int[] iArr = this.f1112i;
                if (i10 >= iArr.length) {
                    return;
                }
                iArr[i10] = ar.com.hjg.pngj.o.g(dVar.f1495d, i10 * 2);
                i10++;
            }
        } else {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
    }
}
