package ar.com.hjg.pngj;

import java.io.File;
import java.io.InputStream;

/* compiled from: PngReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final k f1202a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1203b;

    /* renamed from: c, reason: collision with root package name */
    public final c f1204c;

    /* renamed from: d, reason: collision with root package name */
    public final a f1205d;

    /* renamed from: e, reason: collision with root package name */
    public final c.k f1206e;

    /* renamed from: f, reason: collision with root package name */
    public int f1207f;

    /* renamed from: g, reason: collision with root package name */
    public i<Object> f1208g;

    public p(InputStream inputStream, boolean z10) {
        this.f1207f = -1;
        a aVar = new a(inputStream);
        this.f1205d = aVar;
        aVar.f(z10);
        c b4 = b();
        this.f1204c = b4;
        boolean z11 = true;
        try {
            aVar.g(true);
            if (aVar.d(b4, 36)) {
                this.f1202a = b4.y();
                if (b4.w() == null) {
                    z11 = false;
                }
                this.f1203b = z11;
                j(5024024L);
                k(901001001L);
                l(2024024L);
                b4.p("fdAT");
                b4.p("fcTL");
                this.f1206e = new c.k(b4.f1064o);
                i(n.c());
                this.f1207f = -1;
                return;
            }
            throw new PngjInputException("error reading first 21 bytes");
        } catch (RuntimeException e2) {
            this.f1205d.a();
            this.f1204c.c();
            throw e2;
        }
    }

    public void a() {
        try {
            c cVar = this.f1204c;
            if (cVar != null) {
                cVar.c();
            }
        } catch (Exception e2) {
            o.f1196a.warning("error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f1205d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public c b() {
        throw null;
    }

    public void c(String str) {
        this.f1204c.r(str);
    }

    public void d() {
        try {
            if (this.f1204c.s()) {
                h();
            }
            if (this.f1204c.x() != null && !this.f1204c.x().i()) {
                this.f1204c.x().e();
            }
            while (!this.f1204c.j() && this.f1205d.b(this.f1204c) > 0) {
            }
        } finally {
            a();
        }
    }

    public c.e e() {
        return f(true);
    }

    public c.e f(boolean z10) {
        if (z10 && this.f1204c.s()) {
            h();
        }
        return this.f1204c.f1064o;
    }

    public c g() {
        return this.f1204c;
    }

    public void h() {
        c cVar;
        do {
            cVar = this.f1204c;
            if (cVar.f1063n >= 4) {
                return;
            }
        } while (this.f1205d.b(cVar) > 0);
        throw new PngjInputException("premature ending reading first chunks");
    }

    public void i(i<Object> iVar) {
        this.f1208g = iVar;
    }

    public void j(long j10) {
        this.f1204c.A(j10);
    }

    public void k(long j10) {
        this.f1204c.B(j10);
    }

    public void l(long j10) {
        this.f1204c.C(j10);
    }

    public String toString() {
        return this.f1202a.toString() + " interlaced=" + this.f1203b;
    }

    public p(File file) {
        this(o.d(file), true);
    }
}
