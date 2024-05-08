package ar.com.hjg.pngj.chunks;

/* compiled from: PngChunkBKGD.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int f1086i;

    /* renamed from: j, reason: collision with root package name */
    public int f1087j;

    /* renamed from: k, reason: collision with root package name */
    public int f1088k;

    /* renamed from: l, reason: collision with root package name */
    public int f1089l;

    /* renamed from: m, reason: collision with root package name */
    public int f1090m;

    public b(ar.com.hjg.pngj.k kVar) {
        super("bKGD", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        ar.com.hjg.pngj.k kVar = this.f1080e;
        if (kVar.f1185f) {
            this.f1086i = ar.com.hjg.pngj.o.g(dVar.f1495d, 0);
        } else {
            if (kVar.f1186g) {
                this.f1090m = dVar.f1495d[0] & 255;
                return;
            }
            this.f1087j = ar.com.hjg.pngj.o.g(dVar.f1495d, 0);
            this.f1088k = ar.com.hjg.pngj.o.g(dVar.f1495d, 2);
            this.f1089l = ar.com.hjg.pngj.o.g(dVar.f1495d, 4);
        }
    }
}
