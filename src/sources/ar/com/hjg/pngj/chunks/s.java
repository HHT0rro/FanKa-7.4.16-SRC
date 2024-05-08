package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkTIME.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class s extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int f1140i;

    /* renamed from: j, reason: collision with root package name */
    public int f1141j;

    /* renamed from: k, reason: collision with root package name */
    public int f1142k;

    /* renamed from: l, reason: collision with root package name */
    public int f1143l;

    /* renamed from: m, reason: collision with root package name */
    public int f1144m;

    /* renamed from: n, reason: collision with root package name */
    public int f1145n;

    public s(ar.com.hjg.pngj.k kVar) {
        super("tIME", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (dVar.f1492a == 7) {
            this.f1140i = ar.com.hjg.pngj.o.g(dVar.f1495d, 0);
            this.f1141j = ar.com.hjg.pngj.o.f(dVar.f1495d, 2);
            this.f1142k = ar.com.hjg.pngj.o.f(dVar.f1495d, 3);
            this.f1143l = ar.com.hjg.pngj.o.f(dVar.f1495d, 4);
            this.f1144m = ar.com.hjg.pngj.o.f(dVar.f1495d, 5);
            this.f1145n = ar.com.hjg.pngj.o.f(dVar.f1495d, 6);
            return;
        }
        throw new PngjException("bad chunk " + ((Object) dVar));
    }
}
