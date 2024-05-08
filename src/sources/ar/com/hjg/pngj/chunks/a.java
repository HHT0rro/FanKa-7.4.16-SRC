package ar.com.hjg.pngj.chunks;

/* compiled from: PngChunkACTL.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int f1084i;

    /* renamed from: j, reason: collision with root package name */
    public int f1085j;

    public a(ar.com.hjg.pngj.k kVar) {
        super("acTL", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        this.f1084i = ar.com.hjg.pngj.o.i(dVar.f1495d, 0);
        this.f1085j = ar.com.hjg.pngj.o.i(dVar.f1495d, 4);
    }

    public int h() {
        return this.f1084i;
    }

    public int i() {
        return this.f1085j;
    }
}
