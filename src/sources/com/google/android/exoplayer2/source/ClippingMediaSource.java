package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ClippingMediaSource extends e<Void> {

    /* renamed from: k, reason: collision with root package name */
    public final s f21135k;

    /* renamed from: l, reason: collision with root package name */
    public final long f21136l;

    /* renamed from: m, reason: collision with root package name */
    public final long f21137m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f21138n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f21139o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f21140p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList<c> f21141q;

    /* renamed from: r, reason: collision with root package name */
    public final Timeline.c f21142r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public a f21143s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public IllegalClippingException f21144t;

    /* renamed from: u, reason: collision with root package name */
    public long f21145u;

    /* renamed from: v, reason: collision with root package name */
    public long f21146v;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public IllegalClippingException(int r4) {
            /*
                r3 = this;
                java.lang.String r0 = getReasonDescription(r4)
                java.lang.String r0 = java.lang.String.valueOf(r0)
                int r1 = r0.length()
                java.lang.String r2 = "Illegal clipping: "
                if (r1 == 0) goto L15
                java.lang.String r0 = r2.concat(r0)
                goto L1a
            L15:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
            L1a:
                r3.<init>(r0)
                r3.reason = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException.<init>(int):void");
        }

        private static String getReasonDescription(int i10) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends k {

        /* renamed from: d, reason: collision with root package name */
        public final long f21147d;

        /* renamed from: e, reason: collision with root package name */
        public final long f21148e;

        /* renamed from: f, reason: collision with root package name */
        public final long f21149f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f21150g;

        public a(Timeline timeline, long j10, long j11) throws IllegalClippingException {
            super(timeline);
            boolean z10 = false;
            if (timeline.i() == 1) {
                Timeline.c n10 = timeline.n(0, new Timeline.c());
                long max = Math.max(0L, j10);
                if (!n10.f19678l && max != 0 && !n10.f19674h) {
                    throw new IllegalClippingException(1);
                }
                long max2 = j11 == Long.MIN_VALUE ? n10.f19680n : Math.max(0L, j11);
                long j12 = n10.f19680n;
                if (j12 != -9223372036854775807L) {
                    max2 = max2 > j12 ? j12 : max2;
                    if (max > max2) {
                        throw new IllegalClippingException(2);
                    }
                }
                this.f21147d = max;
                this.f21148e = max2;
                this.f21149f = max2 == -9223372036854775807L ? -9223372036854775807L : max2 - max;
                if (n10.f19675i && (max2 == -9223372036854775807L || (j12 != -9223372036854775807L && max2 == j12))) {
                    z10 = true;
                }
                this.f21150g = z10;
                return;
            }
            throw new IllegalClippingException(0);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
            this.f21765c.g(0, bVar, z10);
            long m10 = bVar.m() - this.f21147d;
            long j10 = this.f21149f;
            return bVar.q(bVar.f19656a, bVar.f19657b, 0, j10 == -9223372036854775807L ? -9223372036854775807L : j10 - m10, m10);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.c o(int i10, Timeline.c cVar, long j10) {
            this.f21765c.o(0, cVar, 0L);
            long j11 = cVar.f19683q;
            long j12 = this.f21147d;
            cVar.f19683q = j11 + j12;
            cVar.f19680n = this.f21149f;
            cVar.f19675i = this.f21150g;
            long j13 = cVar.f19679m;
            if (j13 != -9223372036854775807L) {
                long max = Math.max(j13, j12);
                cVar.f19679m = max;
                long j14 = this.f21148e;
                if (j14 != -9223372036854775807L) {
                    max = Math.min(max, j14);
                }
                cVar.f19679m = max - this.f21147d;
            }
            long e2 = com.google.android.exoplayer2.h.e(this.f21147d);
            long j15 = cVar.f19671e;
            if (j15 != -9223372036854775807L) {
                cVar.f19671e = j15 + e2;
            }
            long j16 = cVar.f19672f;
            if (j16 != -9223372036854775807L) {
                cVar.f19672f = j16 + e2;
            }
            return cVar;
        }
    }

    public ClippingMediaSource(s sVar, long j10, long j11, boolean z10, boolean z11, boolean z12) {
        com.google.android.exoplayer2.util.a.a(j10 >= 0);
        this.f21135k = (s) com.google.android.exoplayer2.util.a.e(sVar);
        this.f21136l = j10;
        this.f21137m = j11;
        this.f21138n = z10;
        this.f21139o = z11;
        this.f21140p = z12;
        this.f21141q = new ArrayList<>();
        this.f21142r = new Timeline.c();
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.a
    public void B(@Nullable o6.v vVar) {
        super.B(vVar);
        K(null, this.f21135k);
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.a
    public void D() {
        super.D();
        this.f21144t = null;
        this.f21143s = null;
    }

    @Override // com.google.android.exoplayer2.source.e
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void I(Void r12, s sVar, Timeline timeline) {
        if (this.f21144t != null) {
            return;
        }
        N(timeline);
    }

    public final void N(Timeline timeline) {
        long j10;
        long j11;
        timeline.n(0, this.f21142r);
        long e2 = this.f21142r.e();
        if (this.f21143s != null && !this.f21141q.isEmpty() && !this.f21139o) {
            long j12 = this.f21145u - e2;
            j11 = this.f21137m != Long.MIN_VALUE ? this.f21146v - e2 : Long.MIN_VALUE;
            j10 = j12;
        } else {
            long j13 = this.f21136l;
            long j14 = this.f21137m;
            if (this.f21140p) {
                long c4 = this.f21142r.c();
                j13 += c4;
                j14 += c4;
            }
            this.f21145u = e2 + j13;
            this.f21146v = this.f21137m != Long.MIN_VALUE ? e2 + j14 : Long.MIN_VALUE;
            int size = this.f21141q.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f21141q.get(i10).r(this.f21145u, this.f21146v);
            }
            j10 = j13;
            j11 = j14;
        }
        try {
            a aVar = new a(timeline, j10, j11);
            this.f21143s = aVar;
            C(aVar);
        } catch (IllegalClippingException e10) {
            this.f21144t = e10;
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f21135k.d();
    }

    @Override // com.google.android.exoplayer2.source.s
    public p e(s.a aVar, o6.b bVar, long j10) {
        c cVar = new c(this.f21135k.e(aVar, bVar, j10), this.f21138n, this.f21145u, this.f21146v);
        this.f21141q.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.s
    public void f() throws IOException {
        IllegalClippingException illegalClippingException = this.f21144t;
        if (illegalClippingException == null) {
            super.f();
            return;
        }
        throw illegalClippingException;
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        com.google.android.exoplayer2.util.a.g(this.f21141q.remove(pVar));
        this.f21135k.j(((c) pVar).f21238b);
        if (!this.f21141q.isEmpty() || this.f21139o) {
            return;
        }
        N(((a) com.google.android.exoplayer2.util.a.e(this.f21143s)).f21765c);
    }
}
