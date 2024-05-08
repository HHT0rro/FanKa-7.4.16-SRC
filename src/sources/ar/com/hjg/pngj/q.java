package ar.com.hjg.pngj;

import java.io.File;

/* compiled from: PngReaderApng.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class q extends r {

    /* renamed from: h, reason: collision with root package name */
    public Boolean f1209h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1210i;

    /* renamed from: j, reason: collision with root package name */
    public ar.com.hjg.pngj.chunks.a f1211j;

    /* renamed from: k, reason: collision with root package name */
    public ar.com.hjg.pngj.chunks.d f1212k;

    /* renamed from: l, reason: collision with root package name */
    public int f1213l;

    /* compiled from: PngReaderApng.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends c {
        public a(boolean z10) {
            super(z10);
        }

        @Override // ar.com.hjg.pngj.c, ar.com.hjg.pngj.b
        public DeflatedChunksSet e(String str) {
            j jVar = new j(str, u(), this.f1062m);
            jVar.p(this.f1065p);
            return jVar;
        }

        @Override // ar.com.hjg.pngj.b
        public boolean k(String str) {
            return str.equals("IDAT") || str.equals("fdAT");
        }

        @Override // ar.com.hjg.pngj.c, ar.com.hjg.pngj.b
        public void l(ChunkReader chunkReader) {
            super.l(chunkReader);
            if (chunkReader.c().f1494c.equals("fcTL")) {
                q qVar = q.this;
                qVar.f1213l++;
                q.this.f1212k = (ar.com.hjg.pngj.chunks.d) qVar.f1204c.t().get(r0.size() - 1);
                if (chunkReader.c().e() == q.this.f1212k.d().e()) {
                    q.this.g().E(q.this.f1212k.l());
                    return;
                }
                throw new PngjInputException("something went wrong");
            }
        }

        @Override // ar.com.hjg.pngj.c, ar.com.hjg.pngj.b
        public boolean n(int i10, String str) {
            return super.n(i10, str);
        }

        @Override // ar.com.hjg.pngj.c, ar.com.hjg.pngj.b
        public void o(int i10, String str, long j10) {
            super.o(i10, str, j10);
        }

        @Override // ar.com.hjg.pngj.c
        public boolean q(String str) {
            return super.q(str) && !str.equals(Boolean.valueOf(str.equals("fdAT")));
        }
    }

    public q(File file) {
        super(file);
        this.f1209h = null;
        this.f1210i = false;
        this.f1213l = -1;
        c("fcTL");
    }

    @Override // ar.com.hjg.pngj.p
    public c b() {
        return new a(false);
    }

    @Override // ar.com.hjg.pngj.p
    public void d() {
        super.d();
    }

    public int o() {
        if (p()) {
            return this.f1211j.h();
        }
        return 0;
    }

    public boolean p() {
        if (this.f1209h == null) {
            ar.com.hjg.pngj.chunks.a aVar = (ar.com.hjg.pngj.chunks.a) e().c("acTL");
            this.f1211j = aVar;
            this.f1209h = Boolean.valueOf(aVar != null);
            this.f1210i = this.f1212k != null;
        }
        return this.f1209h.booleanValue();
    }
}
