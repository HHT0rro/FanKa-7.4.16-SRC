package ar.com.hjg.pngj.chunks;

/* compiled from: PngChunkFDAT.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e extends c.g {

    /* renamed from: i, reason: collision with root package name */
    public int f1108i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f1109j;

    /* renamed from: k, reason: collision with root package name */
    public int f1110k;

    public e(ar.com.hjg.pngj.k kVar) {
        super("fdAT", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        this.f1108i = ar.com.hjg.pngj.o.i(dVar.f1495d, 0);
        this.f1110k = dVar.f1492a - 4;
        this.f1109j = dVar.f1495d;
    }
}
