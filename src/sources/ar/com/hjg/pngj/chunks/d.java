package ar.com.hjg.pngj.chunks;

/* compiled from: PngChunkFCTL.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d extends c.g {

    /* renamed from: i, reason: collision with root package name */
    public int f1099i;

    /* renamed from: j, reason: collision with root package name */
    public int f1100j;

    /* renamed from: k, reason: collision with root package name */
    public int f1101k;

    /* renamed from: l, reason: collision with root package name */
    public int f1102l;

    /* renamed from: m, reason: collision with root package name */
    public int f1103m;

    /* renamed from: n, reason: collision with root package name */
    public int f1104n;

    /* renamed from: o, reason: collision with root package name */
    public int f1105o;

    /* renamed from: p, reason: collision with root package name */
    public byte f1106p;

    /* renamed from: q, reason: collision with root package name */
    public byte f1107q;

    public d(ar.com.hjg.pngj.k kVar) {
        super("fcTL", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        this.f1099i = ar.com.hjg.pngj.o.i(dVar.f1495d, 0);
        this.f1100j = ar.com.hjg.pngj.o.i(dVar.f1495d, 4);
        this.f1101k = ar.com.hjg.pngj.o.i(dVar.f1495d, 8);
        this.f1102l = ar.com.hjg.pngj.o.i(dVar.f1495d, 12);
        this.f1103m = ar.com.hjg.pngj.o.i(dVar.f1495d, 16);
        this.f1104n = ar.com.hjg.pngj.o.g(dVar.f1495d, 20);
        this.f1105o = ar.com.hjg.pngj.o.g(dVar.f1495d, 22);
        byte[] bArr = dVar.f1495d;
        this.f1106p = bArr[24];
        this.f1107q = bArr[25];
    }

    public byte h() {
        return this.f1107q;
    }

    public int i() {
        return this.f1105o;
    }

    public int j() {
        return this.f1104n;
    }

    public byte k() {
        return this.f1106p;
    }

    public ar.com.hjg.pngj.k l() {
        int i10 = this.f1100j;
        int i11 = this.f1101k;
        ar.com.hjg.pngj.k kVar = this.f1080e;
        return new ar.com.hjg.pngj.k(i10, i11, kVar.f1182c, kVar.f1184e, kVar.f1185f, kVar.f1186g);
    }

    public int m() {
        return this.f1102l;
    }

    public int n() {
        return this.f1103m;
    }
}
