package ar.com.hjg.pngj.chunks;

/* compiled from: PngChunkTRNS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class t extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int f1146i;

    /* renamed from: j, reason: collision with root package name */
    public int f1147j;

    /* renamed from: k, reason: collision with root package name */
    public int f1148k;

    /* renamed from: l, reason: collision with root package name */
    public int f1149l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f1150m;

    public t(ar.com.hjg.pngj.k kVar) {
        super("tRNS", kVar);
        this.f1150m = new int[0];
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        ar.com.hjg.pngj.k kVar = this.f1080e;
        if (kVar.f1185f) {
            this.f1146i = ar.com.hjg.pngj.o.g(dVar.f1495d, 0);
            return;
        }
        if (kVar.f1186g) {
            int length = dVar.f1495d.length;
            this.f1150m = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                this.f1150m[i10] = dVar.f1495d[i10] & 255;
            }
            return;
        }
        this.f1147j = ar.com.hjg.pngj.o.g(dVar.f1495d, 0);
        this.f1148k = ar.com.hjg.pngj.o.g(dVar.f1495d, 2);
        this.f1149l = ar.com.hjg.pngj.o.g(dVar.f1495d, 4);
    }
}
