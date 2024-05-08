package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.MultimapBuilder;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MergingMediaSource extends e<Integer> {

    /* renamed from: v, reason: collision with root package name */
    public static final w0 f21151v = new w0.c().p("MergingMediaSource").a();

    /* renamed from: k, reason: collision with root package name */
    public final boolean f21152k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f21153l;

    /* renamed from: m, reason: collision with root package name */
    public final s[] f21154m;

    /* renamed from: n, reason: collision with root package name */
    public final Timeline[] f21155n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList<s> f21156o;

    /* renamed from: p, reason: collision with root package name */
    public final g f21157p;

    /* renamed from: q, reason: collision with root package name */
    public final Map<Object, Long> f21158q;

    /* renamed from: r, reason: collision with root package name */
    public final com.google.common.collect.j0<Object, c> f21159r;

    /* renamed from: s, reason: collision with root package name */
    public int f21160s;

    /* renamed from: t, reason: collision with root package name */
    public long[][] f21161t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public IllegalMergeException f21162u;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        public IllegalMergeException(int i10) {
            this.reason = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends k {

        /* renamed from: d, reason: collision with root package name */
        public final long[] f21163d;

        /* renamed from: e, reason: collision with root package name */
        public final long[] f21164e;

        public a(Timeline timeline, Map<Object, Long> map) {
            super(timeline);
            int p10 = timeline.p();
            this.f21164e = new long[timeline.p()];
            Timeline.c cVar = new Timeline.c();
            for (int i10 = 0; i10 < p10; i10++) {
                this.f21164e[i10] = timeline.n(i10, cVar).f19680n;
            }
            int i11 = timeline.i();
            this.f21163d = new long[i11];
            Timeline.b bVar = new Timeline.b();
            for (int i12 = 0; i12 < i11; i12++) {
                timeline.g(i12, bVar, true);
                long longValue = ((Long) com.google.android.exoplayer2.util.a.e(map.get(bVar.f19657b))).longValue();
                long[] jArr = this.f21163d;
                jArr[i12] = longValue == Long.MIN_VALUE ? bVar.f19659d : longValue;
                long j10 = bVar.f19659d;
                if (j10 != -9223372036854775807L) {
                    long[] jArr2 = this.f21164e;
                    int i13 = bVar.f19658c;
                    jArr2[i13] = jArr2[i13] - (j10 - jArr[i12]);
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
            super.g(i10, bVar, z10);
            bVar.f19659d = this.f21163d[i10];
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.c o(int i10, Timeline.c cVar, long j10) {
            long j11;
            super.o(i10, cVar, j10);
            long j12 = this.f21164e[i10];
            cVar.f19680n = j12;
            if (j12 != -9223372036854775807L) {
                long j13 = cVar.f19679m;
                if (j13 != -9223372036854775807L) {
                    j11 = Math.min(j13, j12);
                    cVar.f19679m = j11;
                    return cVar;
                }
            }
            j11 = cVar.f19679m;
            cVar.f19679m = j11;
            return cVar;
        }
    }

    public MergingMediaSource(s... sVarArr) {
        this(false, sVarArr);
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.a
    public void B(@Nullable o6.v vVar) {
        super.B(vVar);
        for (int i10 = 0; i10 < this.f21154m.length; i10++) {
            K(Integer.valueOf(i10), this.f21154m[i10]);
        }
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.a
    public void D() {
        super.D();
        Arrays.fill(this.f21155n, (Object) null);
        this.f21160s = -1;
        this.f21162u = null;
        this.f21156o.clear();
        Collections.addAll(this.f21156o, this.f21154m);
    }

    public final void M() {
        Timeline.b bVar = new Timeline.b();
        for (int i10 = 0; i10 < this.f21160s; i10++) {
            long j10 = -this.f21155n[0].f(i10, bVar).m();
            int i11 = 1;
            while (true) {
                Timeline[] timelineArr = this.f21155n;
                if (i11 < timelineArr.length) {
                    this.f21161t[i10][i11] = j10 - (-timelineArr[i11].f(i10, bVar).m());
                    i11++;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.e
    @Nullable
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public s.a F(Integer num, s.a aVar) {
        if (num.intValue() == 0) {
            return aVar;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.e
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void I(Integer num, s sVar, Timeline timeline) {
        if (this.f21162u != null) {
            return;
        }
        if (this.f21160s == -1) {
            this.f21160s = timeline.i();
        } else if (timeline.i() != this.f21160s) {
            this.f21162u = new IllegalMergeException(0);
            return;
        }
        if (this.f21161t.length == 0) {
            this.f21161t = (long[][]) Array.newInstance((Class<?>) long.class, this.f21160s, this.f21155n.length);
        }
        this.f21156o.remove(sVar);
        this.f21155n[num.intValue()] = timeline;
        if (this.f21156o.isEmpty()) {
            if (this.f21152k) {
                M();
            }
            Timeline timeline2 = this.f21155n[0];
            if (this.f21153l) {
                P();
                timeline2 = new a(timeline2, this.f21158q);
            }
            C(timeline2);
        }
    }

    public final void P() {
        Timeline[] timelineArr;
        Timeline.b bVar = new Timeline.b();
        for (int i10 = 0; i10 < this.f21160s; i10++) {
            long j10 = Long.MIN_VALUE;
            int i11 = 0;
            while (true) {
                timelineArr = this.f21155n;
                if (i11 >= timelineArr.length) {
                    break;
                }
                long i12 = timelineArr[i11].f(i10, bVar).i();
                if (i12 != -9223372036854775807L) {
                    long j11 = i12 + this.f21161t[i10][i11];
                    if (j10 == Long.MIN_VALUE || j11 < j10) {
                        j10 = j11;
                    }
                }
                i11++;
            }
            Object m10 = timelineArr[0].m(i10);
            this.f21158q.put(m10, Long.valueOf(j10));
            Iterator<c> iterator2 = this.f21159r.get(m10).iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().r(0L, j10);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        s[] sVarArr = this.f21154m;
        return sVarArr.length > 0 ? sVarArr[0].d() : f21151v;
    }

    @Override // com.google.android.exoplayer2.source.s
    public p e(s.a aVar, o6.b bVar, long j10) {
        int length = this.f21154m.length;
        p[] pVarArr = new p[length];
        int b4 = this.f21155n[0].b(aVar.f21883a);
        for (int i10 = 0; i10 < length; i10++) {
            pVarArr[i10] = this.f21154m[i10].e(aVar.c(this.f21155n[i10].m(b4)), bVar, j10 - this.f21161t[b4][i10]);
        }
        b0 b0Var = new b0(this.f21157p, this.f21161t[b4], pVarArr);
        if (!this.f21153l) {
            return b0Var;
        }
        c cVar = new c(b0Var, true, 0L, ((Long) com.google.android.exoplayer2.util.a.e(this.f21158q.get(aVar.f21883a))).longValue());
        this.f21159r.put(aVar.f21883a, cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.s
    public void f() throws IOException {
        IllegalMergeException illegalMergeException = this.f21162u;
        if (illegalMergeException == null) {
            super.f();
            return;
        }
        throw illegalMergeException;
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        if (this.f21153l) {
            c cVar = (c) pVar;
            Iterator<Map.Entry<Object, c>> iterator2 = this.f21159r.entries().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                Map.Entry<Object, c> next = iterator2.next();
                if (next.getValue().equals(cVar)) {
                    this.f21159r.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            pVar = cVar.f21238b;
        }
        b0 b0Var = (b0) pVar;
        int i10 = 0;
        while (true) {
            s[] sVarArr = this.f21154m;
            if (i10 >= sVarArr.length) {
                return;
            }
            sVarArr[i10].j(b0Var.a(i10));
            i10++;
        }
    }

    public MergingMediaSource(boolean z10, s... sVarArr) {
        this(z10, false, sVarArr);
    }

    public MergingMediaSource(boolean z10, boolean z11, s... sVarArr) {
        this(z10, z11, new h(), sVarArr);
    }

    public MergingMediaSource(boolean z10, boolean z11, g gVar, s... sVarArr) {
        this.f21152k = z10;
        this.f21153l = z11;
        this.f21154m = sVarArr;
        this.f21157p = gVar;
        this.f21156o = new ArrayList<>(Arrays.asList(sVarArr));
        this.f21160s = -1;
        this.f21155n = new Timeline[sVarArr.length];
        this.f21161t = new long[0];
        this.f21158q = new HashMap();
        this.f21159r = MultimapBuilder.a().a().e();
    }
}
