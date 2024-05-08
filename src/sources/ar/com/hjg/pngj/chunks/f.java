package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkGAMA.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public double f1111i;

    public f(ar.com.hjg.pngj.k kVar) {
        super("gAMA", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (dVar.f1492a == 4) {
            this.f1111i = ar.com.hjg.pngj.o.i(dVar.f1495d, 0) / 100000.0d;
            return;
        }
        throw new PngjException("bad chunk " + ((Object) dVar));
    }
}
