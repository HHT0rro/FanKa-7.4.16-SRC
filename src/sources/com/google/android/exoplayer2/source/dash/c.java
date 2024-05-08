package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import o6.r;
import o6.v;
import x5.e;
import x5.f;
import x5.g;
import x5.h;
import x5.k;
import x5.m;
import x5.n;
import x5.o;
import x5.p;
import z5.i;
import z5.j;

/* compiled from: DefaultDashChunkSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class c implements com.google.android.exoplayer2.source.dash.a {

    /* renamed from: a, reason: collision with root package name */
    public final r f21327a;

    /* renamed from: b, reason: collision with root package name */
    public final y5.b f21328b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f21329c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21330d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f21331e;

    /* renamed from: f, reason: collision with root package name */
    public final long f21332f;

    /* renamed from: g, reason: collision with root package name */
    public final int f21333g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final d.c f21334h;

    /* renamed from: i, reason: collision with root package name */
    public final b[] f21335i;

    /* renamed from: j, reason: collision with root package name */
    public ExoTrackSelection f21336j;

    /* renamed from: k, reason: collision with root package name */
    public z5.c f21337k;

    /* renamed from: l, reason: collision with root package name */
    public int f21338l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public IOException f21339m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21340n;

    /* compiled from: DefaultDashChunkSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements a.InterfaceC0194a {

        /* renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0208a f21341a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21342b;

        /* renamed from: c, reason: collision with root package name */
        public final g.a f21343c;

        public a(a.InterfaceC0208a interfaceC0208a) {
            this(interfaceC0208a, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0194a
        public com.google.android.exoplayer2.source.dash.a a(r rVar, z5.c cVar, y5.b bVar, int i10, int[] iArr, ExoTrackSelection exoTrackSelection, int i11, long j10, boolean z10, List<Format> list, @Nullable d.c cVar2, @Nullable v vVar) {
            com.google.android.exoplayer2.upstream.a a10 = this.f21341a.a();
            if (vVar != null) {
                a10.d(vVar);
            }
            return new c(this.f21343c, rVar, cVar, bVar, i10, iArr, exoTrackSelection, i11, a10, j10, this.f21342b, z10, list, cVar2);
        }

        public a(a.InterfaceC0208a interfaceC0208a, int i10) {
            this(e.f54488k, interfaceC0208a, i10);
        }

        public a(g.a aVar, a.InterfaceC0208a interfaceC0208a, int i10) {
            this.f21343c = aVar;
            this.f21341a = interfaceC0208a;
            this.f21342b = i10;
        }
    }

    /* compiled from: DefaultDashChunkSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final g f21344a;

        /* renamed from: b, reason: collision with root package name */
        public final j f21345b;

        /* renamed from: c, reason: collision with root package name */
        public final z5.b f21346c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final y5.e f21347d;

        /* renamed from: e, reason: collision with root package name */
        public final long f21348e;

        /* renamed from: f, reason: collision with root package name */
        public final long f21349f;

        public b(long j10, j jVar, z5.b bVar, @Nullable g gVar, long j11, @Nullable y5.e eVar) {
            this.f21348e = j10;
            this.f21345b = jVar;
            this.f21346c = bVar;
            this.f21349f = j11;
            this.f21344a = gVar;
            this.f21347d = eVar;
        }

        @CheckResult
        public b b(long j10, j jVar) throws BehindLiveWindowException {
            long e2;
            long e10;
            y5.e l10 = this.f21345b.l();
            y5.e l11 = jVar.l();
            if (l10 == null) {
                return new b(j10, jVar, this.f21346c, this.f21344a, this.f21349f, l10);
            }
            if (!l10.i()) {
                return new b(j10, jVar, this.f21346c, this.f21344a, this.f21349f, l11);
            }
            long f10 = l10.f(j10);
            if (f10 == 0) {
                return new b(j10, jVar, this.f21346c, this.f21344a, this.f21349f, l11);
            }
            long g3 = l10.g();
            long c4 = l10.c(g3);
            long j11 = (f10 + g3) - 1;
            long c10 = l10.c(j11) + l10.a(j11, j10);
            long g10 = l11.g();
            long c11 = l11.c(g10);
            long j12 = this.f21349f;
            if (c10 == c11) {
                e2 = j11 + 1;
            } else {
                if (c10 < c11) {
                    throw new BehindLiveWindowException();
                }
                if (c11 < c4) {
                    e10 = j12 - (l11.e(c4, j10) - g3);
                    return new b(j10, jVar, this.f21346c, this.f21344a, e10, l11);
                }
                e2 = l10.e(c11, j10);
            }
            e10 = j12 + (e2 - g10);
            return new b(j10, jVar, this.f21346c, this.f21344a, e10, l11);
        }

        @CheckResult
        public b c(y5.e eVar) {
            return new b(this.f21348e, this.f21345b, this.f21346c, this.f21344a, this.f21349f, eVar);
        }

        @CheckResult
        public b d(z5.b bVar) {
            return new b(this.f21348e, this.f21345b, bVar, this.f21344a, this.f21349f, this.f21347d);
        }

        public long e(long j10) {
            return this.f21347d.b(this.f21348e, j10) + this.f21349f;
        }

        public long f() {
            return this.f21347d.g() + this.f21349f;
        }

        public long g(long j10) {
            return (e(j10) + this.f21347d.j(this.f21348e, j10)) - 1;
        }

        public long h() {
            return this.f21347d.f(this.f21348e);
        }

        public long i(long j10) {
            return k(j10) + this.f21347d.a(j10 - this.f21349f, this.f21348e);
        }

        public long j(long j10) {
            return this.f21347d.e(j10, this.f21348e) + this.f21349f;
        }

        public long k(long j10) {
            return this.f21347d.c(j10 - this.f21349f);
        }

        public i l(long j10) {
            return this.f21347d.h(j10 - this.f21349f);
        }

        public boolean m(long j10, long j11) {
            return this.f21347d.i() || j11 == -9223372036854775807L || i(j10) <= j11;
        }
    }

    /* compiled from: DefaultDashChunkSource.java */
    /* renamed from: com.google.android.exoplayer2.source.dash.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0195c extends x5.b {

        /* renamed from: e, reason: collision with root package name */
        public final b f21350e;

        /* renamed from: f, reason: collision with root package name */
        public final long f21351f;

        public C0195c(b bVar, long j10, long j11, long j12) {
            super(j10, j11);
            this.f21350e = bVar;
            this.f21351f = j12;
        }

        @Override // x5.o
        public long a() {
            c();
            return this.f21350e.i(d());
        }

        @Override // x5.o
        public long b() {
            c();
            return this.f21350e.k(d());
        }
    }

    public c(g.a aVar, r rVar, z5.c cVar, y5.b bVar, int i10, int[] iArr, ExoTrackSelection exoTrackSelection, int i11, com.google.android.exoplayer2.upstream.a aVar2, long j10, int i12, boolean z10, List<Format> list, @Nullable d.c cVar2) {
        this.f21327a = rVar;
        this.f21337k = cVar;
        this.f21328b = bVar;
        this.f21329c = iArr;
        this.f21336j = exoTrackSelection;
        this.f21330d = i11;
        this.f21331e = aVar2;
        this.f21338l = i10;
        this.f21332f = j10;
        this.f21333g = i12;
        this.f21334h = cVar2;
        long g3 = cVar.g(i10);
        ArrayList<j> n10 = n();
        this.f21335i = new b[exoTrackSelection.length()];
        int i13 = 0;
        while (i13 < this.f21335i.length) {
            j jVar = n10.get(exoTrackSelection.c(i13));
            z5.b j11 = bVar.j(jVar.f54938c);
            b[] bVarArr = this.f21335i;
            if (j11 == null) {
                j11 = jVar.f54938c.get(0);
            }
            int i14 = i13;
            bVarArr[i14] = new b(g3, jVar, j11, e.f54488k.a(i11, jVar.f54937b, z10, list, cVar2), 0L, jVar.l());
            i13 = i14 + 1;
        }
    }

    @Override // x5.j
    public void a() throws IOException {
        IOException iOException = this.f21339m;
        if (iOException == null) {
            this.f21327a.a();
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void b(ExoTrackSelection exoTrackSelection) {
        this.f21336j = exoTrackSelection;
    }

    @Override // x5.j
    public void c(long j10, long j11, List<? extends n> list, h hVar) {
        int i10;
        int i11;
        o[] oVarArr;
        long j12;
        long j13;
        if (this.f21339m != null) {
            return;
        }
        long j14 = j11 - j10;
        long d10 = com.google.android.exoplayer2.h.d(this.f21337k.f54889a) + com.google.android.exoplayer2.h.d(this.f21337k.d(this.f21338l).f54923b) + j11;
        d.c cVar = this.f21334h;
        if (cVar == null || !cVar.h(d10)) {
            long d11 = com.google.android.exoplayer2.h.d(j0.X(this.f21332f));
            long m10 = m(d11);
            n nVar = list.isEmpty() ? null : list.get(list.size() - 1);
            int length = this.f21336j.length();
            o[] oVarArr2 = new o[length];
            int i12 = 0;
            while (i12 < length) {
                b bVar = this.f21335i[i12];
                if (bVar.f21347d == null) {
                    oVarArr2[i12] = o.f54558a;
                    i10 = i12;
                    i11 = length;
                    oVarArr = oVarArr2;
                    j12 = j14;
                    j13 = d11;
                } else {
                    long e2 = bVar.e(d11);
                    long g3 = bVar.g(d11);
                    i10 = i12;
                    i11 = length;
                    oVarArr = oVarArr2;
                    j12 = j14;
                    j13 = d11;
                    long o10 = o(bVar, nVar, j11, e2, g3);
                    if (o10 < e2) {
                        oVarArr[i10] = o.f54558a;
                    } else {
                        oVarArr[i10] = new C0195c(bVar, o10, g3, m10);
                    }
                }
                i12 = i10 + 1;
                d11 = j13;
                oVarArr2 = oVarArr;
                length = i11;
                j14 = j12;
            }
            long j15 = j14;
            long j16 = d11;
            this.f21336j.i(j10, j15, l(j16, j10), list, oVarArr2);
            b r10 = r(this.f21336j.a());
            g gVar = r10.f21344a;
            if (gVar != null) {
                j jVar = r10.f21345b;
                i n10 = gVar.e() == null ? jVar.n() : null;
                i m11 = r10.f21347d == null ? jVar.m() : null;
                if (n10 != null || m11 != null) {
                    hVar.f54515a = p(r10, this.f21331e, this.f21336j.m(), this.f21336j.u(), this.f21336j.r(), n10, m11);
                    return;
                }
            }
            long j17 = r10.f21348e;
            boolean z10 = j17 != -9223372036854775807L;
            if (r10.h() == 0) {
                hVar.f54516b = z10;
                return;
            }
            long e10 = r10.e(j16);
            long g10 = r10.g(j16);
            boolean z11 = z10;
            long o11 = o(r10, nVar, j11, e10, g10);
            if (o11 < e10) {
                this.f21339m = new BehindLiveWindowException();
                return;
            }
            if (o11 > g10 || (this.f21340n && o11 >= g10)) {
                hVar.f54516b = z11;
                return;
            }
            if (z11 && r10.k(o11) >= j17) {
                hVar.f54516b = true;
                return;
            }
            int min = (int) Math.min(this.f21333g, (g10 - o11) + 1);
            if (j17 != -9223372036854775807L) {
                while (min > 1 && r10.k((min + o11) - 1) >= j17) {
                    min--;
                }
            }
            hVar.f54515a = q(r10, this.f21331e, this.f21330d, this.f21336j.m(), this.f21336j.u(), this.f21336j.r(), o11, min, list.isEmpty() ? j11 : -9223372036854775807L, m10);
        }
    }

    @Override // x5.j
    public int d(long j10, List<? extends n> list) {
        if (this.f21339m == null && this.f21336j.length() >= 2) {
            return this.f21336j.k(j10, list);
        }
        return list.size();
    }

    @Override // x5.j
    public void f(f fVar) {
        com.google.android.exoplayer2.extractor.b d10;
        if (fVar instanceof m) {
            int t2 = this.f21336j.t(((m) fVar).f54509d);
            b bVar = this.f21335i[t2];
            if (bVar.f21347d == null && (d10 = bVar.f21344a.d()) != null) {
                this.f21335i[t2] = bVar.c(new y5.g(d10, bVar.f21345b.f54939d));
            }
        }
        d.c cVar = this.f21334h;
        if (cVar != null) {
            cVar.i(fVar);
        }
    }

    @Override // x5.j
    public long g(long j10, p1 p1Var) {
        for (b bVar : this.f21335i) {
            if (bVar.f21347d != null) {
                long j11 = bVar.j(j10);
                long k10 = bVar.k(j11);
                long h10 = bVar.h();
                return p1Var.a(j10, k10, (k10 >= j10 || (h10 != -1 && j11 >= (bVar.f() + h10) - 1)) ? k10 : bVar.k(j11 + 1));
            }
        }
        return j10;
    }

    @Override // x5.j
    public boolean h(f fVar, boolean z10, h.c cVar, com.google.android.exoplayer2.upstream.h hVar) {
        h.b b4;
        if (!z10) {
            return false;
        }
        d.c cVar2 = this.f21334h;
        if (cVar2 != null && cVar2.j(fVar)) {
            return true;
        }
        if (!this.f21337k.f54892d && (fVar instanceof n)) {
            IOException iOException = cVar.f22894c;
            if ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode == 404) {
                b bVar = this.f21335i[this.f21336j.t(fVar.f54509d)];
                long h10 = bVar.h();
                if (h10 != -1 && h10 != 0) {
                    if (((n) fVar).f() > (bVar.f() + h10) - 1) {
                        this.f21340n = true;
                        return true;
                    }
                }
            }
        }
        b bVar2 = this.f21335i[this.f21336j.t(fVar.f54509d)];
        z5.b j10 = this.f21328b.j(bVar2.f21345b.f54938c);
        if (j10 != null && !bVar2.f21346c.equals(j10)) {
            return true;
        }
        h.a k10 = k(this.f21336j, bVar2.f21345b.f54938c);
        if ((!k10.a(2) && !k10.a(1)) || (b4 = hVar.b(k10, cVar)) == null || !k10.a(b4.f22890a)) {
            return false;
        }
        int i10 = b4.f22890a;
        if (i10 == 2) {
            ExoTrackSelection exoTrackSelection = this.f21336j;
            return exoTrackSelection.o(exoTrackSelection.t(fVar.f54509d), b4.f22891b);
        }
        if (i10 != 1) {
            return false;
        }
        this.f21328b.e(bVar2.f21346c, b4.f22891b);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void i(z5.c cVar, int i10) {
        try {
            this.f21337k = cVar;
            this.f21338l = i10;
            long g3 = cVar.g(i10);
            ArrayList<j> n10 = n();
            for (int i11 = 0; i11 < this.f21335i.length; i11++) {
                j jVar = n10.get(this.f21336j.c(i11));
                b[] bVarArr = this.f21335i;
                bVarArr[i11] = bVarArr[i11].b(g3, jVar);
            }
        } catch (BehindLiveWindowException e2) {
            this.f21339m = e2;
        }
    }

    @Override // x5.j
    public boolean j(long j10, f fVar, List<? extends n> list) {
        if (this.f21339m != null) {
            return false;
        }
        return this.f21336j.h(j10, fVar, list);
    }

    public final h.a k(ExoTrackSelection exoTrackSelection, List<z5.b> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (exoTrackSelection.b(i11, elapsedRealtime)) {
                i10++;
            }
        }
        int f10 = y5.b.f(list);
        return new h.a(f10, f10 - this.f21328b.g(list), length, i10);
    }

    public final long l(long j10, long j11) {
        if (!this.f21337k.f54892d) {
            return -9223372036854775807L;
        }
        return Math.max(0L, Math.min(m(j10), this.f21335i[0].i(this.f21335i[0].g(j10))) - j11);
    }

    public final long m(long j10) {
        z5.c cVar = this.f21337k;
        long j11 = cVar.f54889a;
        if (j11 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j10 - com.google.android.exoplayer2.h.d(j11 + cVar.d(this.f21338l).f54923b);
    }

    public final ArrayList<j> n() {
        List<z5.a> list = this.f21337k.d(this.f21338l).f54924c;
        ArrayList<j> arrayList = new ArrayList<>();
        for (int i10 : this.f21329c) {
            arrayList.addAll(list.get(i10).f54881c);
        }
        return arrayList;
    }

    public final long o(b bVar, @Nullable n nVar, long j10, long j11, long j12) {
        if (nVar != null) {
            return nVar.f();
        }
        return j0.s(bVar.j(j10), j11, j12);
    }

    public f p(b bVar, com.google.android.exoplayer2.upstream.a aVar, Format format, int i10, Object obj, @Nullable i iVar, @Nullable i iVar2) {
        i iVar3 = iVar;
        j jVar = bVar.f21345b;
        if (iVar3 != null) {
            i a10 = iVar3.a(iVar2, bVar.f21346c.f54885a);
            if (a10 != null) {
                iVar3 = a10;
            }
        } else {
            iVar3 = iVar2;
        }
        return new m(aVar, y5.f.a(jVar, bVar.f21346c.f54885a, iVar3, 0), format, i10, obj, bVar.f21344a);
    }

    public f q(b bVar, com.google.android.exoplayer2.upstream.a aVar, int i10, Format format, int i11, Object obj, long j10, int i12, long j11, long j12) {
        j jVar = bVar.f21345b;
        long k10 = bVar.k(j10);
        i l10 = bVar.l(j10);
        if (bVar.f21344a == null) {
            return new p(aVar, y5.f.a(jVar, bVar.f21346c.f54885a, l10, bVar.m(j10, j12) ? 0 : 8), format, i11, obj, k10, bVar.i(j10), j10, i10, format);
        }
        int i13 = 1;
        int i14 = 1;
        while (i13 < i12) {
            i a10 = l10.a(bVar.l(i13 + j10), bVar.f21346c.f54885a);
            if (a10 == null) {
                break;
            }
            i14++;
            i13++;
            l10 = a10;
        }
        long j13 = (i14 + j10) - 1;
        long i15 = bVar.i(j13);
        long j14 = bVar.f21348e;
        return new k(aVar, y5.f.a(jVar, bVar.f21346c.f54885a, l10, bVar.m(j13, j12) ? 0 : 8), format, i11, obj, k10, i15, j11, (j14 == -9223372036854775807L || j14 > i15) ? -9223372036854775807L : j14, j10, i14, -jVar.f54939d, bVar.f21344a);
    }

    public final b r(int i10) {
        b bVar = this.f21335i[i10];
        z5.b j10 = this.f21328b.j(bVar.f21345b.f54938c);
        if (j10 == null || j10.equals(bVar.f21346c)) {
            return bVar;
        }
        b d10 = bVar.d(j10);
        this.f21335i[i10] = d10;
        return d10;
    }

    @Override // x5.j
    public void release() {
        for (b bVar : this.f21335i) {
            g gVar = bVar.f21344a;
            if (gVar != null) {
                gVar.release();
            }
        }
    }
}
