package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.s;
import com.google.common.collect.ImmutableList;

/* compiled from: MediaPeriodQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final Timeline.b f19688a = new Timeline.b();

    /* renamed from: b, reason: collision with root package name */
    public final Timeline.c f19689b = new Timeline.c();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final w4.h1 f19690c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f19691d;

    /* renamed from: e, reason: collision with root package name */
    public long f19692e;

    /* renamed from: f, reason: collision with root package name */
    public int f19693f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19694g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public x0 f19695h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public x0 f19696i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public x0 f19697j;

    /* renamed from: k, reason: collision with root package name */
    public int f19698k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Object f19699l;

    /* renamed from: m, reason: collision with root package name */
    public long f19700m;

    public a1(@Nullable w4.h1 h1Var, Handler handler) {
        this.f19690c = h1Var;
        this.f19691d = handler;
    }

    public static s.a B(Timeline timeline, Object obj, long j10, long j11, Timeline.b bVar) {
        timeline.h(obj, bVar);
        int e2 = bVar.e(j10);
        if (e2 == -1) {
            return new s.a(obj, j11, bVar.d(j10));
        }
        return new s.a(obj, e2, bVar.j(e2), j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(ImmutableList.a aVar, s.a aVar2) {
        this.f19690c.h2(aVar.k(), aVar2);
    }

    public s.a A(Timeline timeline, Object obj, long j10) {
        return B(timeline, obj, j10, C(timeline, obj), this.f19688a);
    }

    public final long C(Timeline timeline, Object obj) {
        int b4;
        int i10 = timeline.h(obj, this.f19688a).f19658c;
        Object obj2 = this.f19699l;
        if (obj2 != null && (b4 = timeline.b(obj2)) != -1 && timeline.f(b4, this.f19688a).f19658c == i10) {
            return this.f19700m;
        }
        for (x0 x0Var = this.f19695h; x0Var != null; x0Var = x0Var.j()) {
            if (x0Var.f23233b.equals(obj)) {
                return x0Var.f23237f.f23249a.f21886d;
            }
        }
        for (x0 x0Var2 = this.f19695h; x0Var2 != null; x0Var2 = x0Var2.j()) {
            int b10 = timeline.b(x0Var2.f23233b);
            if (b10 != -1 && timeline.f(b10, this.f19688a).f19658c == i10) {
                return x0Var2.f23237f.f23249a.f21886d;
            }
        }
        long j10 = this.f19692e;
        this.f19692e = 1 + j10;
        if (this.f19695h == null) {
            this.f19699l = obj;
            this.f19700m = j10;
        }
        return j10;
    }

    public boolean D() {
        x0 x0Var = this.f19697j;
        return x0Var == null || (!x0Var.f23237f.f23257i && x0Var.q() && this.f19697j.f23237f.f23253e != -9223372036854775807L && this.f19698k < 100);
    }

    public final boolean E(Timeline timeline) {
        x0 x0Var = this.f19695h;
        if (x0Var == null) {
            return true;
        }
        int b4 = timeline.b(x0Var.f23233b);
        while (true) {
            b4 = timeline.d(b4, this.f19688a, this.f19689b, this.f19693f, this.f19694g);
            while (x0Var.j() != null && !x0Var.f23237f.f23255g) {
                x0Var = x0Var.j();
            }
            x0 j10 = x0Var.j();
            if (b4 == -1 || j10 == null || timeline.b(j10.f23233b) != b4) {
                break;
            }
            x0Var = j10;
        }
        boolean z10 = z(x0Var);
        x0Var.f23237f = r(timeline, x0Var.f23237f);
        return !z10;
    }

    public boolean F(Timeline timeline, long j10, long j11) {
        y0 y0Var;
        x0 x0Var = this.f19695h;
        x0 x0Var2 = null;
        while (x0Var != null) {
            y0 y0Var2 = x0Var.f23237f;
            if (x0Var2 == null) {
                y0Var = r(timeline, y0Var2);
            } else {
                y0 i10 = i(timeline, x0Var2, j10);
                if (i10 == null) {
                    return !z(x0Var2);
                }
                if (!e(y0Var2, i10)) {
                    return !z(x0Var2);
                }
                y0Var = i10;
            }
            x0Var.f23237f = y0Var.a(y0Var2.f23251c);
            if (!d(y0Var2.f23253e, y0Var.f23253e)) {
                x0Var.A();
                long j12 = y0Var.f23253e;
                return (z(x0Var) || (x0Var == this.f19696i && !x0Var.f23237f.f23254f && ((j11 > Long.MIN_VALUE ? 1 : (j11 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j11 > ((j12 > (-9223372036854775807L) ? 1 : (j12 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : x0Var.z(j12)) ? 1 : (j11 == ((j12 > (-9223372036854775807L) ? 1 : (j12 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : x0Var.z(j12)) ? 0 : -1)) >= 0))) ? false : true;
            }
            x0Var2 = x0Var;
            x0Var = x0Var.j();
        }
        return true;
    }

    public boolean G(Timeline timeline, int i10) {
        this.f19693f = i10;
        return E(timeline);
    }

    public boolean H(Timeline timeline, boolean z10) {
        this.f19694g = z10;
        return E(timeline);
    }

    @Nullable
    public x0 b() {
        x0 x0Var = this.f19695h;
        if (x0Var == null) {
            return null;
        }
        if (x0Var == this.f19696i) {
            this.f19696i = x0Var.j();
        }
        this.f19695h.t();
        int i10 = this.f19698k - 1;
        this.f19698k = i10;
        if (i10 == 0) {
            this.f19697j = null;
            x0 x0Var2 = this.f19695h;
            this.f19699l = x0Var2.f23233b;
            this.f19700m = x0Var2.f23237f.f23249a.f21886d;
        }
        this.f19695h = this.f19695h.j();
        x();
        return this.f19695h;
    }

    public x0 c() {
        x0 x0Var = this.f19696i;
        com.google.android.exoplayer2.util.a.g((x0Var == null || x0Var.j() == null) ? false : true);
        this.f19696i = this.f19696i.j();
        x();
        return this.f19696i;
    }

    public final boolean d(long j10, long j11) {
        return j10 == -9223372036854775807L || j10 == j11;
    }

    public final boolean e(y0 y0Var, y0 y0Var2) {
        return y0Var.f23250b == y0Var2.f23250b && y0Var.f23249a.equals(y0Var2.f23249a);
    }

    public void f() {
        if (this.f19698k == 0) {
            return;
        }
        x0 x0Var = (x0) com.google.android.exoplayer2.util.a.i(this.f19695h);
        this.f19699l = x0Var.f23233b;
        this.f19700m = x0Var.f23237f.f23249a.f21886d;
        while (x0Var != null) {
            x0Var.t();
            x0Var = x0Var.j();
        }
        this.f19695h = null;
        this.f19697j = null;
        this.f19696i = null;
        this.f19698k = 0;
        x();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r1 != (-9223372036854775807L)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.x0 g(com.google.android.exoplayer2.n1[] r12, n6.i r13, o6.b r14, com.google.android.exoplayer2.d1 r15, com.google.android.exoplayer2.y0 r16, com.google.android.exoplayer2.trackselection.TrackSelectorResult r17) {
        /*
            r11 = this;
            r0 = r11
            r8 = r16
            com.google.android.exoplayer2.x0 r1 = r0.f19697j
            if (r1 != 0) goto L1e
            com.google.android.exoplayer2.source.s$a r1 = r8.f23249a
            boolean r1 = r1.b()
            if (r1 == 0) goto L1b
            long r1 = r8.f23251c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L1b
            goto L2c
        L1b:
            r1 = 0
            goto L2c
        L1e:
            long r1 = r1.l()
            com.google.android.exoplayer2.x0 r3 = r0.f19697j
            com.google.android.exoplayer2.y0 r3 = r3.f23237f
            long r3 = r3.f23253e
            long r1 = r1 + r3
            long r3 = r8.f23250b
            long r1 = r1 - r3
        L2c:
            r3 = r1
            com.google.android.exoplayer2.x0 r10 = new com.google.android.exoplayer2.x0
            r1 = r10
            r2 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r1.<init>(r2, r3, r5, r6, r7, r8, r9)
            com.google.android.exoplayer2.x0 r1 = r0.f19697j
            if (r1 == 0) goto L43
            r1.w(r10)
            goto L47
        L43:
            r0.f19695h = r10
            r0.f19696i = r10
        L47:
            r1 = 0
            r0.f19699l = r1
            r0.f19697j = r10
            int r1 = r0.f19698k
            int r1 = r1 + 1
            r0.f19698k = r1
            r11.x()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a1.g(com.google.android.exoplayer2.n1[], n6.i, o6.b, com.google.android.exoplayer2.d1, com.google.android.exoplayer2.y0, com.google.android.exoplayer2.trackselection.TrackSelectorResult):com.google.android.exoplayer2.x0");
    }

    @Nullable
    public final y0 h(e1 e1Var) {
        return k(e1Var.f19994a, e1Var.f19995b, e1Var.f19996c, e1Var.f20012s);
    }

    @Nullable
    public final y0 i(Timeline timeline, x0 x0Var, long j10) {
        long j11;
        y0 y0Var = x0Var.f23237f;
        long l10 = (x0Var.l() + y0Var.f23253e) - j10;
        if (y0Var.f23255g) {
            long j12 = 0;
            int d10 = timeline.d(timeline.b(y0Var.f23249a.f21883a), this.f19688a, this.f19689b, this.f19693f, this.f19694g);
            if (d10 == -1) {
                return null;
            }
            int i10 = timeline.g(d10, this.f19688a, true).f19658c;
            Object obj = this.f19688a.f19657b;
            long j13 = y0Var.f23249a.f21886d;
            if (timeline.n(i10, this.f19689b).f19681o == d10) {
                Pair<Object, Long> k10 = timeline.k(this.f19689b, this.f19688a, i10, -9223372036854775807L, Math.max(0L, l10));
                if (k10 == null) {
                    return null;
                }
                obj = k10.first;
                long longValue = ((Long) k10.second).longValue();
                x0 j14 = x0Var.j();
                if (j14 != null && j14.f23233b.equals(obj)) {
                    j13 = j14.f23237f.f23249a.f21886d;
                } else {
                    j13 = this.f19692e;
                    this.f19692e = 1 + j13;
                }
                j11 = longValue;
                j12 = -9223372036854775807L;
            } else {
                j11 = 0;
            }
            return k(timeline, B(timeline, obj, j11, j13, this.f19688a), j12, j11);
        }
        s.a aVar = y0Var.f23249a;
        timeline.h(aVar.f21883a, this.f19688a);
        if (aVar.b()) {
            int i11 = aVar.f21884b;
            int a10 = this.f19688a.a(i11);
            if (a10 == -1) {
                return null;
            }
            int k11 = this.f19688a.k(i11, aVar.f21885c);
            if (k11 < a10) {
                return l(timeline, aVar.f21883a, i11, k11, y0Var.f23251c, aVar.f21886d);
            }
            long j15 = y0Var.f23251c;
            if (j15 == -9223372036854775807L) {
                Timeline.c cVar = this.f19689b;
                Timeline.b bVar = this.f19688a;
                Pair<Object, Long> k12 = timeline.k(cVar, bVar, bVar.f19658c, -9223372036854775807L, Math.max(0L, l10));
                if (k12 == null) {
                    return null;
                }
                j15 = ((Long) k12.second).longValue();
            }
            return m(timeline, aVar.f21883a, Math.max(n(timeline, aVar.f21883a, aVar.f21884b), j15), y0Var.f23251c, aVar.f21886d);
        }
        int j16 = this.f19688a.j(aVar.f21887e);
        if (j16 == this.f19688a.a(aVar.f21887e)) {
            return m(timeline, aVar.f21883a, n(timeline, aVar.f21883a, aVar.f21887e), y0Var.f23253e, aVar.f21886d);
        }
        return l(timeline, aVar.f21883a, aVar.f21887e, j16, y0Var.f23253e, aVar.f21886d);
    }

    @Nullable
    public x0 j() {
        return this.f19697j;
    }

    @Nullable
    public final y0 k(Timeline timeline, s.a aVar, long j10, long j11) {
        timeline.h(aVar.f21883a, this.f19688a);
        if (aVar.b()) {
            return l(timeline, aVar.f21883a, aVar.f21884b, aVar.f21885c, j10, aVar.f21886d);
        }
        return m(timeline, aVar.f21883a, j11, j10, aVar.f21886d);
    }

    public final y0 l(Timeline timeline, Object obj, int i10, int i11, long j10, long j11) {
        s.a aVar = new s.a(obj, i10, i11, j11);
        long b4 = timeline.h(aVar.f21883a, this.f19688a).b(aVar.f21884b, aVar.f21885c);
        long g3 = i11 == this.f19688a.j(i10) ? this.f19688a.g() : 0L;
        return new y0(aVar, (b4 == -9223372036854775807L || g3 < b4) ? g3 : Math.max(0L, b4 - 1), j10, -9223372036854775807L, b4, this.f19688a.p(aVar.f21884b), false, false, false);
    }

    public final y0 m(Timeline timeline, Object obj, long j10, long j11, long j12) {
        long j13 = j10;
        timeline.h(obj, this.f19688a);
        int d10 = this.f19688a.d(j13);
        s.a aVar = new s.a(obj, j12, d10);
        boolean s2 = s(aVar);
        boolean u10 = u(timeline, aVar);
        boolean t2 = t(timeline, aVar, s2);
        boolean z10 = d10 != -1 && this.f19688a.p(d10);
        long f10 = d10 != -1 ? this.f19688a.f(d10) : -9223372036854775807L;
        long j14 = (f10 == -9223372036854775807L || f10 == Long.MIN_VALUE) ? this.f19688a.f19659d : f10;
        if (j14 != -9223372036854775807L && j13 >= j14) {
            j13 = Math.max(0L, j14 - 1);
        }
        return new y0(aVar, j13, j11, f10, j14, z10, s2, u10, t2);
    }

    public final long n(Timeline timeline, Object obj, int i10) {
        timeline.h(obj, this.f19688a);
        long f10 = this.f19688a.f(i10);
        if (f10 == Long.MIN_VALUE) {
            return this.f19688a.f19659d;
        }
        return f10 + this.f19688a.h(i10);
    }

    @Nullable
    public y0 o(long j10, e1 e1Var) {
        x0 x0Var = this.f19697j;
        if (x0Var == null) {
            return h(e1Var);
        }
        return i(e1Var.f19994a, x0Var, j10);
    }

    @Nullable
    public x0 p() {
        return this.f19695h;
    }

    @Nullable
    public x0 q() {
        return this.f19696i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.y0 r(com.google.android.exoplayer2.Timeline r19, com.google.android.exoplayer2.y0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.exoplayer2.source.s$a r3 = r2.f23249a
            boolean r12 = r0.s(r3)
            boolean r13 = r0.u(r1, r3)
            boolean r14 = r0.t(r1, r3, r12)
            com.google.android.exoplayer2.source.s$a r4 = r2.f23249a
            java.lang.Object r4 = r4.f21883a
            com.google.android.exoplayer2.Timeline$b r5 = r0.f19688a
            r1.h(r4, r5)
            boolean r1 = r3.b()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L35
            int r1 = r3.f21887e
            if (r1 != r4) goto L2e
            goto L35
        L2e:
            com.google.android.exoplayer2.Timeline$b r7 = r0.f19688a
            long r7 = r7.f(r1)
            goto L36
        L35:
            r7 = r5
        L36:
            boolean r1 = r3.b()
            if (r1 == 0) goto L48
            com.google.android.exoplayer2.Timeline$b r1 = r0.f19688a
            int r5 = r3.f21884b
            int r6 = r3.f21885c
            long r5 = r1.b(r5, r6)
        L46:
            r9 = r5
            goto L5c
        L48:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L55
            r5 = -9223372036854775808
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            com.google.android.exoplayer2.Timeline$b r1 = r0.f19688a
            long r5 = r1.i()
            goto L46
        L5c:
            boolean r1 = r3.b()
            if (r1 == 0) goto L6c
            com.google.android.exoplayer2.Timeline$b r1 = r0.f19688a
            int r4 = r3.f21884b
            boolean r1 = r1.p(r4)
            r11 = r1
            goto L7d
        L6c:
            int r1 = r3.f21887e
            if (r1 == r4) goto L7b
            com.google.android.exoplayer2.Timeline$b r4 = r0.f19688a
            boolean r1 = r4.p(r1)
            if (r1 == 0) goto L7b
            r1 = 1
            r11 = 1
            goto L7d
        L7b:
            r1 = 0
            r11 = 0
        L7d:
            com.google.android.exoplayer2.y0 r15 = new com.google.android.exoplayer2.y0
            long r4 = r2.f23250b
            long r1 = r2.f23251c
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a1.r(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.y0):com.google.android.exoplayer2.y0");
    }

    public final boolean s(s.a aVar) {
        return !aVar.b() && aVar.f21887e == -1;
    }

    public final boolean t(Timeline timeline, s.a aVar, boolean z10) {
        int b4 = timeline.b(aVar.f21883a);
        return !timeline.n(timeline.f(b4, this.f19688a).f19658c, this.f19689b).f19675i && timeline.r(b4, this.f19688a, this.f19689b, this.f19693f, this.f19694g) && z10;
    }

    public final boolean u(Timeline timeline, s.a aVar) {
        if (s(aVar)) {
            return timeline.n(timeline.h(aVar.f21883a, this.f19688a).f19658c, this.f19689b).f19682p == timeline.b(aVar.f21883a);
        }
        return false;
    }

    public boolean v(com.google.android.exoplayer2.source.p pVar) {
        x0 x0Var = this.f19697j;
        return x0Var != null && x0Var.f23232a == pVar;
    }

    public final void x() {
        if (this.f19690c != null) {
            final ImmutableList.a builder = ImmutableList.builder();
            for (x0 x0Var = this.f19695h; x0Var != null; x0Var = x0Var.j()) {
                builder.a(x0Var.f23237f.f23249a);
            }
            x0 x0Var2 = this.f19696i;
            final s.a aVar = x0Var2 == null ? null : x0Var2.f23237f.f23249a;
            this.f19691d.post(new Runnable() { // from class: com.google.android.exoplayer2.z0
                @Override // java.lang.Runnable
                public final void run() {
                    a1.this.w(builder, aVar);
                }
            });
        }
    }

    public void y(long j10) {
        x0 x0Var = this.f19697j;
        if (x0Var != null) {
            x0Var.s(j10);
        }
    }

    public boolean z(x0 x0Var) {
        boolean z10 = false;
        com.google.android.exoplayer2.util.a.g(x0Var != null);
        if (x0Var.equals(this.f19697j)) {
            return false;
        }
        this.f19697j = x0Var;
        while (x0Var.j() != null) {
            x0Var = x0Var.j();
            if (x0Var == this.f19696i) {
                this.f19696i = this.f19695h;
                z10 = true;
            }
            x0Var.t();
            this.f19698k--;
        }
        this.f19697j.w(null);
        x();
        return z10;
    }
}
