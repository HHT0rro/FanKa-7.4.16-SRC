package com.google.android.exoplayer2;

import android.net.Uri;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.ads.a;
import com.google.android.exoplayer2.w0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class Timeline {

    /* renamed from: a, reason: collision with root package name */
    public static final Timeline f19653a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final g<Timeline> f19654b = a5.a.f700a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends Timeline {
        @Override // com.google.android.exoplayer2.Timeline
        public int b(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public b g(int i10, b bVar, boolean z10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int i() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object m(int i10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public c o(int i10, c cVar, long j10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int p() {
            return 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: h, reason: collision with root package name */
        public static final g<b> f19655h = a5.a.f700a;

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public Object f19656a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f19657b;

        /* renamed from: c, reason: collision with root package name */
        public int f19658c;

        /* renamed from: d, reason: collision with root package name */
        public long f19659d;

        /* renamed from: e, reason: collision with root package name */
        public long f19660e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f19661f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.android.exoplayer2.source.ads.a f19662g = com.google.android.exoplayer2.source.ads.a.f21205g;

        public int a(int i10) {
            return this.f19662g.a(i10).f21216b;
        }

        public long b(int i10, int i11) {
            a.C0193a a10 = this.f19662g.a(i10);
            if (a10.f21216b != -1) {
                return a10.f21219e[i11];
            }
            return -9223372036854775807L;
        }

        public int c() {
            return this.f19662g.f21209b;
        }

        public int d(long j10) {
            return this.f19662g.b(j10, this.f19659d);
        }

        public int e(long j10) {
            return this.f19662g.c(j10, this.f19659d);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return com.google.android.exoplayer2.util.j0.c(this.f19656a, bVar.f19656a) && com.google.android.exoplayer2.util.j0.c(this.f19657b, bVar.f19657b) && this.f19658c == bVar.f19658c && this.f19659d == bVar.f19659d && this.f19660e == bVar.f19660e && this.f19661f == bVar.f19661f && com.google.android.exoplayer2.util.j0.c(this.f19662g, bVar.f19662g);
        }

        public long f(int i10) {
            return this.f19662g.a(i10).f21215a;
        }

        public long g() {
            return this.f19662g.f21210c;
        }

        public long h(int i10) {
            return this.f19662g.a(i10).f21220f;
        }

        public int hashCode() {
            Object obj = this.f19656a;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f19657b;
            int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f19658c) * 31;
            long j10 = this.f19659d;
            int i10 = (hashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f19660e;
            return ((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f19661f ? 1 : 0)) * 31) + this.f19662g.hashCode();
        }

        public long i() {
            return this.f19659d;
        }

        public int j(int i10) {
            return this.f19662g.a(i10).c();
        }

        public int k(int i10, int i11) {
            return this.f19662g.a(i10).d(i11);
        }

        public long l() {
            return h.e(this.f19660e);
        }

        public long m() {
            return this.f19660e;
        }

        public int n() {
            return this.f19662g.f21212e;
        }

        public boolean o(int i10) {
            return !this.f19662g.a(i10).e();
        }

        public boolean p(int i10) {
            return this.f19662g.a(i10).f21221g;
        }

        public b q(@Nullable Object obj, @Nullable Object obj2, int i10, long j10, long j11) {
            return r(obj, obj2, i10, j10, j11, com.google.android.exoplayer2.source.ads.a.f21205g, false);
        }

        public b r(@Nullable Object obj, @Nullable Object obj2, int i10, long j10, long j11, com.google.android.exoplayer2.source.ads.a aVar, boolean z10) {
            this.f19656a = obj;
            this.f19657b = obj2;
            this.f19658c = i10;
            this.f19659d = j10;
            this.f19660e = j11;
            this.f19662g = aVar;
            this.f19661f = z10;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: r, reason: collision with root package name */
        public static final Object f19663r = new Object();

        /* renamed from: s, reason: collision with root package name */
        public static final Object f19664s = new Object();

        /* renamed from: t, reason: collision with root package name */
        public static final w0 f19665t = new w0.c().p("com.google.android.exoplayer2.Timeline").t(Uri.EMPTY).a();

        /* renamed from: u, reason: collision with root package name */
        public static final g<c> f19666u = a5.a.f700a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        @Deprecated
        public Object f19668b;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f19670d;

        /* renamed from: e, reason: collision with root package name */
        public long f19671e;

        /* renamed from: f, reason: collision with root package name */
        public long f19672f;

        /* renamed from: g, reason: collision with root package name */
        public long f19673g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f19674h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f19675i;

        /* renamed from: j, reason: collision with root package name */
        @Deprecated
        public boolean f19676j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public w0.f f19677k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f19678l;

        /* renamed from: m, reason: collision with root package name */
        public long f19679m;

        /* renamed from: n, reason: collision with root package name */
        public long f19680n;

        /* renamed from: o, reason: collision with root package name */
        public int f19681o;

        /* renamed from: p, reason: collision with root package name */
        public int f19682p;

        /* renamed from: q, reason: collision with root package name */
        public long f19683q;

        /* renamed from: a, reason: collision with root package name */
        public Object f19667a = f19663r;

        /* renamed from: c, reason: collision with root package name */
        public w0 f19669c = f19665t;

        public long a() {
            return com.google.android.exoplayer2.util.j0.X(this.f19673g);
        }

        public long b() {
            return h.e(this.f19679m);
        }

        public long c() {
            return this.f19679m;
        }

        public long d() {
            return h.e(this.f19680n);
        }

        public long e() {
            return this.f19683q;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !c.class.equals(obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            return com.google.android.exoplayer2.util.j0.c(this.f19667a, cVar.f19667a) && com.google.android.exoplayer2.util.j0.c(this.f19669c, cVar.f19669c) && com.google.android.exoplayer2.util.j0.c(this.f19670d, cVar.f19670d) && com.google.android.exoplayer2.util.j0.c(this.f19677k, cVar.f19677k) && this.f19671e == cVar.f19671e && this.f19672f == cVar.f19672f && this.f19673g == cVar.f19673g && this.f19674h == cVar.f19674h && this.f19675i == cVar.f19675i && this.f19678l == cVar.f19678l && this.f19679m == cVar.f19679m && this.f19680n == cVar.f19680n && this.f19681o == cVar.f19681o && this.f19682p == cVar.f19682p && this.f19683q == cVar.f19683q;
        }

        public boolean f() {
            com.google.android.exoplayer2.util.a.g(this.f19676j == (this.f19677k != null));
            return this.f19677k != null;
        }

        public c g(Object obj, @Nullable w0 w0Var, @Nullable Object obj2, long j10, long j11, long j12, boolean z10, boolean z11, @Nullable w0.f fVar, long j13, long j14, int i10, int i11, long j15) {
            w0.g gVar;
            this.f19667a = obj;
            this.f19669c = w0Var != null ? w0Var : f19665t;
            this.f19668b = (w0Var == null || (gVar = w0Var.f23163b) == null) ? null : gVar.f23223h;
            this.f19670d = obj2;
            this.f19671e = j10;
            this.f19672f = j11;
            this.f19673g = j12;
            this.f19674h = z10;
            this.f19675i = z11;
            this.f19676j = fVar != null;
            this.f19677k = fVar;
            this.f19679m = j13;
            this.f19680n = j14;
            this.f19681o = i10;
            this.f19682p = i11;
            this.f19683q = j15;
            this.f19678l = false;
            return this;
        }

        public int hashCode() {
            int hashCode = (((217 + this.f19667a.hashCode()) * 31) + this.f19669c.hashCode()) * 31;
            Object obj = this.f19670d;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            w0.f fVar = this.f19677k;
            int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 31;
            long j10 = this.f19671e;
            int i10 = (hashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f19672f;
            int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f19673g;
            int i12 = (((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f19674h ? 1 : 0)) * 31) + (this.f19675i ? 1 : 0)) * 31) + (this.f19678l ? 1 : 0)) * 31;
            long j13 = this.f19679m;
            int i13 = (i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            long j14 = this.f19680n;
            int i14 = (((((i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.f19681o) * 31) + this.f19682p) * 31;
            long j15 = this.f19683q;
            return i14 + ((int) (j15 ^ (j15 >>> 32)));
        }
    }

    public int a(boolean z10) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z10) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i10, b bVar, c cVar, int i11, boolean z10) {
        int i12 = f(i10, bVar).f19658c;
        if (n(i12, cVar).f19682p != i10) {
            return i10 + 1;
        }
        int e2 = e(i12, i11, z10);
        if (e2 == -1) {
            return -1;
        }
        return n(e2, cVar).f19681o;
    }

    public int e(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == c(z10)) {
                return -1;
            }
            return i10 + 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == c(z10) ? a(z10) : i10 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.p() != p() || timeline.i() != i()) {
            return false;
        }
        c cVar = new c();
        b bVar = new b();
        c cVar2 = new c();
        b bVar2 = new b();
        for (int i10 = 0; i10 < p(); i10++) {
            if (!n(i10, cVar).equals(timeline.n(i10, cVar2))) {
                return false;
            }
        }
        for (int i11 = 0; i11 < i(); i11++) {
            if (!g(i11, bVar, true).equals(timeline.g(i11, bVar2, true))) {
                return false;
            }
        }
        return true;
    }

    public final b f(int i10, b bVar) {
        return g(i10, bVar, false);
    }

    public abstract b g(int i10, b bVar, boolean z10);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public int hashCode() {
        c cVar = new c();
        b bVar = new b();
        int p10 = 217 + p();
        for (int i10 = 0; i10 < p(); i10++) {
            p10 = (p10 * 31) + n(i10, cVar).hashCode();
        }
        int i11 = (p10 * 31) + i();
        for (int i12 = 0; i12 < i(); i12++) {
            i11 = (i11 * 31) + g(i12, bVar, true).hashCode();
        }
        return i11;
    }

    public abstract int i();

    public final Pair<Object, Long> j(c cVar, b bVar, int i10, long j10) {
        return (Pair) com.google.android.exoplayer2.util.a.e(k(cVar, bVar, i10, j10, 0L));
    }

    @Nullable
    public final Pair<Object, Long> k(c cVar, b bVar, int i10, long j10, long j11) {
        com.google.android.exoplayer2.util.a.c(i10, 0, p());
        o(i10, cVar, j11);
        if (j10 == -9223372036854775807L) {
            j10 = cVar.c();
            if (j10 == -9223372036854775807L) {
                return null;
            }
        }
        int i11 = cVar.f19681o;
        f(i11, bVar);
        while (i11 < cVar.f19682p && bVar.f19660e != j10) {
            int i12 = i11 + 1;
            if (f(i12, bVar).f19660e > j10) {
                break;
            }
            i11 = i12;
        }
        g(i11, bVar, true);
        long j12 = j10 - bVar.f19660e;
        long j13 = bVar.f19659d;
        if (j13 != -9223372036854775807L) {
            j12 = Math.min(j12, j13 - 1);
        }
        long max = Math.max(0L, j12);
        if (max == 9) {
            com.google.android.exoplayer2.util.m.c("XXX", "YYY");
        }
        return Pair.create(com.google.android.exoplayer2.util.a.e(bVar.f19657b), Long.valueOf(max));
    }

    public int l(int i10, int i11, boolean z10) {
        if (i11 == 0) {
            if (i10 == a(z10)) {
                return -1;
            }
            return i10 - 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == a(z10) ? c(z10) : i10 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i10);

    public final c n(int i10, c cVar) {
        return o(i10, cVar, 0L);
    }

    public abstract c o(int i10, c cVar, long j10);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }

    public final boolean r(int i10, b bVar, c cVar, int i11, boolean z10) {
        return d(i10, bVar, cVar, i11, z10) == -1;
    }
}
