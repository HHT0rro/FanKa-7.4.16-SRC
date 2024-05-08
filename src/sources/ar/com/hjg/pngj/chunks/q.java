package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkSRGB.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class q extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int f1138i;

    public q(ar.com.hjg.pngj.k kVar) {
        super("sRGB", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (dVar.f1492a == 1) {
            this.f1138i = ar.com.hjg.pngj.o.f(dVar.f1495d, 0);
            return;
        }
        throw new PngjException("bad chunk length " + ((Object) dVar));
    }
}
