package g5;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d5.d;
import d5.e;
import d5.h;
import d5.i;
import d5.n;
import java.io.IOException;
import java.util.Map;

/* compiled from: FlvExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements Extractor {

    /* renamed from: q, reason: collision with root package name */
    public static final i f49369q = new i() { // from class: g5.a
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] h10;
            h10 = b.h();
            return h10;
        }
    };

    /* renamed from: f, reason: collision with root package name */
    public e f49375f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f49377h;

    /* renamed from: i, reason: collision with root package name */
    public long f49378i;

    /* renamed from: j, reason: collision with root package name */
    public int f49379j;

    /* renamed from: k, reason: collision with root package name */
    public int f49380k;

    /* renamed from: l, reason: collision with root package name */
    public int f49381l;

    /* renamed from: m, reason: collision with root package name */
    public long f49382m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f49383n;

    /* renamed from: o, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.flv.a f49384o;

    /* renamed from: p, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.flv.b f49385p;

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f49370a = new ParsableByteArray(4);

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f49371b = new ParsableByteArray(9);

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f49372c = new ParsableByteArray(11);

    /* renamed from: d, reason: collision with root package name */
    public final ParsableByteArray f49373d = new ParsableByteArray();

    /* renamed from: e, reason: collision with root package name */
    public final c f49374e = new c();

    /* renamed from: g, reason: collision with root package name */
    public int f49376g = 1;

    public static /* synthetic */ Extractor[] h() {
        return new Extractor[]{new b()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        if (j10 == 0) {
            this.f49376g = 1;
            this.f49377h = false;
        } else {
            this.f49376g = 3;
        }
        this.f49379j = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(e eVar) {
        this.f49375f = eVar;
    }

    public final void d() {
        if (this.f49383n) {
            return;
        }
        this.f49375f.r(new i.b(-9223372036854775807L));
        this.f49383n = true;
    }

    public final long e() {
        if (this.f49377h) {
            return this.f49378i + this.f49382m;
        }
        if (this.f49374e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.f49382m;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d dVar, n nVar) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f49375f);
        while (true) {
            int i10 = this.f49376g;
            if (i10 != 1) {
                if (i10 == 2) {
                    m(dVar);
                } else if (i10 != 3) {
                    if (i10 == 4) {
                        if (k(dVar)) {
                            return 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (!l(dVar)) {
                    return -1;
                }
            } else if (!j(dVar)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d dVar) throws IOException {
        dVar.j(this.f49370a.d(), 0, 3);
        this.f49370a.P(0);
        if (this.f49370a.G() != 4607062) {
            return false;
        }
        dVar.j(this.f49370a.d(), 0, 2);
        this.f49370a.P(0);
        if ((this.f49370a.J() & 250) != 0) {
            return false;
        }
        dVar.j(this.f49370a.d(), 0, 4);
        this.f49370a.P(0);
        int n10 = this.f49370a.n();
        dVar.m();
        dVar.q(n10);
        dVar.j(this.f49370a.d(), 0, 4);
        this.f49370a.P(0);
        return this.f49370a.n() == 0;
    }

    public final ParsableByteArray i(d dVar) throws IOException {
        if (this.f49381l > this.f49373d.b()) {
            ParsableByteArray parsableByteArray = this.f49373d;
            parsableByteArray.N(new byte[Math.max(parsableByteArray.b() * 2, this.f49381l)], 0);
        } else {
            this.f49373d.P(0);
        }
        this.f49373d.O(this.f49381l);
        dVar.readFully(this.f49373d.d(), 0, this.f49381l);
        return this.f49373d;
    }

    public final boolean j(d dVar) throws IOException {
        if (!dVar.f(this.f49371b.d(), 0, 9, true)) {
            return false;
        }
        this.f49371b.P(0);
        this.f49371b.Q(4);
        int D = this.f49371b.D();
        boolean z10 = (D & 4) != 0;
        boolean z11 = (D & 1) != 0;
        if (z10 && this.f49384o == null) {
            this.f49384o = new com.google.android.exoplayer2.extractor.flv.a(this.f49375f.c(8, 1));
        }
        if (z11 && this.f49385p == null) {
            this.f49385p = new com.google.android.exoplayer2.extractor.flv.b(this.f49375f.c(9, 2));
        }
        this.f49375f.l();
        this.f49379j = (this.f49371b.n() - 9) + 4;
        this.f49376g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean k(d5.d r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.e()
            int r2 = r9.f49380k
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 0
            r6 = 1
            r7 = 8
            if (r2 != r7) goto L24
            com.google.android.exoplayer2.extractor.flv.a r7 = r9.f49384o
            if (r7 == 0) goto L24
            r9.d()
            com.google.android.exoplayer2.extractor.flv.a r2 = r9.f49384o
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.i(r10)
            boolean r5 = r2.a(r10, r0)
        L22:
            r10 = 1
            goto L75
        L24:
            r7 = 9
            if (r2 != r7) goto L3a
            com.google.android.exoplayer2.extractor.flv.b r7 = r9.f49385p
            if (r7 == 0) goto L3a
            r9.d()
            com.google.android.exoplayer2.extractor.flv.b r2 = r9.f49385p
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.i(r10)
            boolean r5 = r2.a(r10, r0)
            goto L22
        L3a:
            r7 = 18
            if (r2 != r7) goto L6f
            boolean r2 = r9.f49383n
            if (r2 != 0) goto L6f
            g5.c r2 = r9.f49374e
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r9.i(r10)
            boolean r5 = r2.a(r10, r0)
            g5.c r10 = r9.f49374e
            long r0 = r10.d()
            int r10 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r10 == 0) goto L22
            d5.e r10 = r9.f49375f
            com.google.android.exoplayer2.extractor.h r2 = new com.google.android.exoplayer2.extractor.h
            g5.c r7 = r9.f49374e
            long[] r7 = r7.e()
            g5.c r8 = r9.f49374e
            long[] r8 = r8.f()
            r2.<init>(r7, r8, r0)
            r10.r(r2)
            r9.f49383n = r6
            goto L22
        L6f:
            int r0 = r9.f49381l
            r10.r(r0)
            r10 = 0
        L75:
            boolean r0 = r9.f49377h
            if (r0 != 0) goto L8f
            if (r5 == 0) goto L8f
            r9.f49377h = r6
            g5.c r0 = r9.f49374e
            long r0 = r0.d()
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto L8b
            long r0 = r9.f49382m
            long r0 = -r0
            goto L8d
        L8b:
            r0 = 0
        L8d:
            r9.f49378i = r0
        L8f:
            r0 = 4
            r9.f49379j = r0
            r0 = 2
            r9.f49376g = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.b.k(d5.d):boolean");
    }

    public final boolean l(d dVar) throws IOException {
        if (!dVar.f(this.f49372c.d(), 0, 11, true)) {
            return false;
        }
        this.f49372c.P(0);
        this.f49380k = this.f49372c.D();
        this.f49381l = this.f49372c.G();
        this.f49382m = this.f49372c.G();
        this.f49382m = ((this.f49372c.D() << 24) | this.f49382m) * 1000;
        this.f49372c.Q(3);
        this.f49376g = 4;
        return true;
    }

    public final void m(d dVar) throws IOException {
        dVar.r(this.f49379j);
        this.f49379j = 0;
        this.f49376g = 3;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
