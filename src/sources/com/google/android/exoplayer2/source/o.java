package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.w0;

/* compiled from: MaskingMediaSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o extends e<Void> {

    /* renamed from: k, reason: collision with root package name */
    public final s f21835k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f21836l;

    /* renamed from: m, reason: collision with root package name */
    public final Timeline.c f21837m;

    /* renamed from: n, reason: collision with root package name */
    public final Timeline.b f21838n;

    /* renamed from: o, reason: collision with root package name */
    public a f21839o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public n f21840p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21841q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21842r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f21843s;

    /* compiled from: MaskingMediaSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends k {

        /* renamed from: f, reason: collision with root package name */
        public static final Object f21844f = new Object();

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final Object f21845d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public final Object f21846e;

        public a(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            super(timeline);
            this.f21845d = obj;
            this.f21846e = obj2;
        }

        public static a u(w0 w0Var) {
            return new a(new b(w0Var), Timeline.c.f19663r, f21844f);
        }

        public static a v(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            return new a(timeline, obj, obj2);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public int b(Object obj) {
            Object obj2;
            Timeline timeline = this.f21765c;
            if (f21844f.equals(obj) && (obj2 = this.f21846e) != null) {
                obj = obj2;
            }
            return timeline.b(obj);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
            this.f21765c.g(i10, bVar, z10);
            if (com.google.android.exoplayer2.util.j0.c(bVar.f19657b, this.f21846e) && z10) {
                bVar.f19657b = f21844f;
            }
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Object m(int i10) {
            Object m10 = this.f21765c.m(i10);
            return com.google.android.exoplayer2.util.j0.c(m10, this.f21846e) ? f21844f : m10;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.c o(int i10, Timeline.c cVar, long j10) {
            this.f21765c.o(i10, cVar, j10);
            if (com.google.android.exoplayer2.util.j0.c(cVar.f19667a, this.f21845d)) {
                cVar.f19667a = Timeline.c.f19663r;
            }
            return cVar;
        }

        public a t(Timeline timeline) {
            return new a(timeline, this.f21845d, this.f21846e);
        }
    }

    /* compiled from: MaskingMediaSource.java */
    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends Timeline {

        /* renamed from: c, reason: collision with root package name */
        public final w0 f21847c;

        public b(w0 w0Var) {
            this.f21847c = w0Var;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int b(Object obj) {
            return obj == a.f21844f ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
            bVar.r(z10 ? 0 : null, z10 ? a.f21844f : null, 0, -9223372036854775807L, 0L, com.google.android.exoplayer2.source.ads.a.f21205g, true);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int i() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object m(int i10) {
            return a.f21844f;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.c o(int i10, Timeline.c cVar, long j10) {
            cVar.g(Timeline.c.f19663r, this.f21847c, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            cVar.f19678l = true;
            return cVar;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int p() {
            return 1;
        }
    }

    public o(s sVar, boolean z10) {
        this.f21835k = sVar;
        this.f21836l = z10 && sVar.s();
        this.f21837m = new Timeline.c();
        this.f21838n = new Timeline.b();
        Timeline g3 = sVar.g();
        if (g3 != null) {
            this.f21839o = a.v(g3, null, null);
            this.f21843s = true;
        } else {
            this.f21839o = a.u(sVar.d());
        }
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.a
    public void B(@Nullable o6.v vVar) {
        super.B(vVar);
        if (this.f21836l) {
            return;
        }
        this.f21841q = true;
        K(null, this.f21835k);
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.a
    public void D() {
        this.f21842r = false;
        this.f21841q = false;
        super.D();
    }

    @Override // com.google.android.exoplayer2.source.s
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public n e(s.a aVar, o6.b bVar, long j10) {
        n nVar = new n(aVar, bVar, j10);
        nVar.w(this.f21835k);
        if (this.f21842r) {
            nVar.a(aVar.c(O(aVar.f21883a)));
        } else {
            this.f21840p = nVar;
            if (!this.f21841q) {
                this.f21841q = true;
                K(null, this.f21835k);
            }
        }
        return nVar;
    }

    public final Object N(Object obj) {
        return (this.f21839o.f21846e == null || !this.f21839o.f21846e.equals(obj)) ? obj : a.f21844f;
    }

    public final Object O(Object obj) {
        return (this.f21839o.f21846e == null || !obj.equals(a.f21844f)) ? obj : this.f21839o.f21846e;
    }

    @Override // com.google.android.exoplayer2.source.e
    @Nullable
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public s.a F(Void r12, s.a aVar) {
        return aVar.c(N(aVar.f21883a));
    }

    public Timeline Q() {
        return this.f21839o;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00bb  */
    @Override // com.google.android.exoplayer2.source.e
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void I(java.lang.Void r13, com.google.android.exoplayer2.source.s r14, com.google.android.exoplayer2.Timeline r15) {
        /*
            r12 = this;
            boolean r13 = r12.f21842r
            if (r13 == 0) goto L19
            com.google.android.exoplayer2.source.o$a r13 = r12.f21839o
            com.google.android.exoplayer2.source.o$a r13 = r13.t(r15)
            r12.f21839o = r13
            com.google.android.exoplayer2.source.n r13 = r12.f21840p
            if (r13 == 0) goto Lae
            long r13 = r13.c()
            r12.S(r13)
            goto Lae
        L19:
            boolean r13 = r15.q()
            if (r13 == 0) goto L36
            boolean r13 = r12.f21843s
            if (r13 == 0) goto L2a
            com.google.android.exoplayer2.source.o$a r13 = r12.f21839o
            com.google.android.exoplayer2.source.o$a r13 = r13.t(r15)
            goto L32
        L2a:
            java.lang.Object r13 = com.google.android.exoplayer2.Timeline.c.f19663r
            java.lang.Object r14 = com.google.android.exoplayer2.source.o.a.f21844f
            com.google.android.exoplayer2.source.o$a r13 = com.google.android.exoplayer2.source.o.a.v(r15, r13, r14)
        L32:
            r12.f21839o = r13
            goto Lae
        L36:
            com.google.android.exoplayer2.Timeline$c r13 = r12.f21837m
            r14 = 0
            r15.n(r14, r13)
            com.google.android.exoplayer2.Timeline$c r13 = r12.f21837m
            long r0 = r13.c()
            com.google.android.exoplayer2.Timeline$c r13 = r12.f21837m
            java.lang.Object r13 = r13.f19667a
            com.google.android.exoplayer2.source.n r2 = r12.f21840p
            if (r2 == 0) goto L74
            long r2 = r2.o()
            com.google.android.exoplayer2.source.o$a r4 = r12.f21839o
            com.google.android.exoplayer2.source.n r5 = r12.f21840p
            com.google.android.exoplayer2.source.s$a r5 = r5.f21811b
            java.lang.Object r5 = r5.f21883a
            com.google.android.exoplayer2.Timeline$b r6 = r12.f21838n
            r4.h(r5, r6)
            com.google.android.exoplayer2.Timeline$b r4 = r12.f21838n
            long r4 = r4.m()
            long r4 = r4 + r2
            com.google.android.exoplayer2.source.o$a r2 = r12.f21839o
            com.google.android.exoplayer2.Timeline$c r3 = r12.f21837m
            com.google.android.exoplayer2.Timeline$c r14 = r2.n(r14, r3)
            long r2 = r14.c()
            int r14 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r14 == 0) goto L74
            r10 = r4
            goto L75
        L74:
            r10 = r0
        L75:
            com.google.android.exoplayer2.Timeline$c r7 = r12.f21837m
            com.google.android.exoplayer2.Timeline$b r8 = r12.f21838n
            r9 = 0
            r6 = r15
            android.util.Pair r14 = r6.j(r7, r8, r9, r10)
            java.lang.Object r0 = r14.first
            java.lang.Object r14 = r14.second
            java.lang.Long r14 = (java.lang.Long) r14
            long r1 = r14.longValue()
            boolean r14 = r12.f21843s
            if (r14 == 0) goto L94
            com.google.android.exoplayer2.source.o$a r13 = r12.f21839o
            com.google.android.exoplayer2.source.o$a r13 = r13.t(r15)
            goto L98
        L94:
            com.google.android.exoplayer2.source.o$a r13 = com.google.android.exoplayer2.source.o.a.v(r15, r13, r0)
        L98:
            r12.f21839o = r13
            com.google.android.exoplayer2.source.n r13 = r12.f21840p
            if (r13 == 0) goto Lae
            r12.S(r1)
            com.google.android.exoplayer2.source.s$a r13 = r13.f21811b
            java.lang.Object r14 = r13.f21883a
            java.lang.Object r14 = r12.O(r14)
            com.google.android.exoplayer2.source.s$a r13 = r13.c(r14)
            goto Laf
        Lae:
            r13 = 0
        Laf:
            r14 = 1
            r12.f21843s = r14
            r12.f21842r = r14
            com.google.android.exoplayer2.source.o$a r14 = r12.f21839o
            r12.C(r14)
            if (r13 == 0) goto Lc6
            com.google.android.exoplayer2.source.n r14 = r12.f21840p
            java.lang.Object r14 = com.google.android.exoplayer2.util.a.e(r14)
            com.google.android.exoplayer2.source.n r14 = (com.google.android.exoplayer2.source.n) r14
            r14.a(r13)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.o.I(java.lang.Void, com.google.android.exoplayer2.source.s, com.google.android.exoplayer2.Timeline):void");
    }

    public final void S(long j10) {
        n nVar = this.f21840p;
        int b4 = this.f21839o.b(nVar.f21811b.f21883a);
        if (b4 == -1) {
            return;
        }
        long j11 = this.f21839o.f(b4, this.f21838n).f19659d;
        if (j11 != -9223372036854775807L && j10 >= j11) {
            j10 = Math.max(0L, j11 - 1);
        }
        nVar.u(j10);
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f21835k.d();
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.s
    public void f() {
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        ((n) pVar).v();
        if (pVar == this.f21840p) {
            this.f21840p = null;
        }
    }
}
