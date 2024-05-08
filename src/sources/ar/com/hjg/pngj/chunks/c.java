package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkCHRM.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public double f1091i;

    /* renamed from: j, reason: collision with root package name */
    public double f1092j;

    /* renamed from: k, reason: collision with root package name */
    public double f1093k;

    /* renamed from: l, reason: collision with root package name */
    public double f1094l;

    /* renamed from: m, reason: collision with root package name */
    public double f1095m;

    /* renamed from: n, reason: collision with root package name */
    public double f1096n;

    /* renamed from: o, reason: collision with root package name */
    public double f1097o;

    /* renamed from: p, reason: collision with root package name */
    public double f1098p;

    public c(ar.com.hjg.pngj.k kVar) {
        super("cHRM", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (dVar.f1492a == 32) {
            this.f1091i = ar.com.hjg.pngj.o.c(ar.com.hjg.pngj.o.i(dVar.f1495d, 0));
            this.f1092j = ar.com.hjg.pngj.o.c(ar.com.hjg.pngj.o.i(dVar.f1495d, 4));
            this.f1093k = ar.com.hjg.pngj.o.c(ar.com.hjg.pngj.o.i(dVar.f1495d, 8));
            this.f1094l = ar.com.hjg.pngj.o.c(ar.com.hjg.pngj.o.i(dVar.f1495d, 12));
            this.f1095m = ar.com.hjg.pngj.o.c(ar.com.hjg.pngj.o.i(dVar.f1495d, 16));
            this.f1096n = ar.com.hjg.pngj.o.c(ar.com.hjg.pngj.o.i(dVar.f1495d, 20));
            this.f1097o = ar.com.hjg.pngj.o.c(ar.com.hjg.pngj.o.i(dVar.f1495d, 24));
            this.f1098p = ar.com.hjg.pngj.o.c(ar.com.hjg.pngj.o.i(dVar.f1495d, 28));
            return;
        }
        throw new PngjException("bad chunk " + ((Object) dVar));
    }
}
