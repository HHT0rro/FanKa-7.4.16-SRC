package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkSBIT.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class o extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int f1130i;

    /* renamed from: j, reason: collision with root package name */
    public int f1131j;

    /* renamed from: k, reason: collision with root package name */
    public int f1132k;

    /* renamed from: l, reason: collision with root package name */
    public int f1133l;

    /* renamed from: m, reason: collision with root package name */
    public int f1134m;

    public o(ar.com.hjg.pngj.k kVar) {
        super("sBIT", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (dVar.f1492a == h()) {
            if (this.f1080e.f1185f) {
                this.f1130i = ar.com.hjg.pngj.o.f(dVar.f1495d, 0);
                if (this.f1080e.f1184e) {
                    this.f1131j = ar.com.hjg.pngj.o.f(dVar.f1495d, 1);
                    return;
                }
                return;
            }
            this.f1132k = ar.com.hjg.pngj.o.f(dVar.f1495d, 0);
            this.f1133l = ar.com.hjg.pngj.o.f(dVar.f1495d, 1);
            this.f1134m = ar.com.hjg.pngj.o.f(dVar.f1495d, 2);
            if (this.f1080e.f1184e) {
                this.f1131j = ar.com.hjg.pngj.o.f(dVar.f1495d, 3);
                return;
            }
            return;
        }
        throw new PngjException("bad chunk length " + ((Object) dVar));
    }

    public final int h() {
        ar.com.hjg.pngj.k kVar = this.f1080e;
        int i10 = kVar.f1185f ? 1 : 3;
        return kVar.f1184e ? i10 + 1 : i10;
    }
}
