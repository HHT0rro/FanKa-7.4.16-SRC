package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.w0;

/* compiled from: SinglePeriodTimeline.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n0 extends Timeline {

    /* renamed from: p, reason: collision with root package name */
    public static final Object f21820p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public static final w0 f21821q = new w0.c().p("SinglePeriodTimeline").t(Uri.EMPTY).a();

    /* renamed from: c, reason: collision with root package name */
    public final long f21822c;

    /* renamed from: d, reason: collision with root package name */
    public final long f21823d;

    /* renamed from: e, reason: collision with root package name */
    public final long f21824e;

    /* renamed from: f, reason: collision with root package name */
    public final long f21825f;

    /* renamed from: g, reason: collision with root package name */
    public final long f21826g;

    /* renamed from: h, reason: collision with root package name */
    public final long f21827h;

    /* renamed from: i, reason: collision with root package name */
    public final long f21828i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f21829j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f21830k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f21831l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public final Object f21832m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public final w0 f21833n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public final w0.f f21834o;

    public n0(long j10, boolean z10, boolean z11, boolean z12, @Nullable Object obj, w0 w0Var) {
        this(j10, j10, 0L, 0L, z10, z11, z12, obj, w0Var);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int b(Object obj) {
        return f21820p.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
        com.google.android.exoplayer2.util.a.c(i10, 0, 1);
        return bVar.q(null, z10 ? f21820p : null, 0, this.f21825f, -this.f21827h);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int i() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Object m(int i10) {
        com.google.android.exoplayer2.util.a.c(i10, 0, 1);
        return f21820p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 > r5) goto L10;
     */
    @Override // com.google.android.exoplayer2.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.Timeline.c o(int r25, com.google.android.exoplayer2.Timeline.c r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            com.google.android.exoplayer2.util.a.c(r3, r1, r2)
            long r1 = r0.f21828i
            boolean r14 = r0.f21830k
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r14 == 0) goto L2e
            boolean r5 = r0.f21831l
            if (r5 != 0) goto L2e
            r5 = 0
            int r7 = (r27 > r5 ? 1 : (r27 == r5 ? 0 : -1))
            if (r7 == 0) goto L2e
            long r5 = r0.f21826g
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L27
        L24:
            r16 = r3
            goto L30
        L27:
            long r1 = r1 + r27
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L2e
            goto L24
        L2e:
            r16 = r1
        L30:
            java.lang.Object r4 = com.google.android.exoplayer2.Timeline.c.f19663r
            com.google.android.exoplayer2.w0 r5 = r0.f21833n
            java.lang.Object r6 = r0.f21832m
            long r7 = r0.f21822c
            long r9 = r0.f21823d
            long r11 = r0.f21824e
            boolean r13 = r0.f21829j
            com.google.android.exoplayer2.w0$f r15 = r0.f21834o
            long r1 = r0.f21826g
            r18 = r1
            r20 = 0
            r21 = 0
            long r1 = r0.f21827h
            r22 = r1
            r3 = r26
            com.google.android.exoplayer2.Timeline$c r1 = r3.g(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.n0.o(int, com.google.android.exoplayer2.Timeline$c, long):com.google.android.exoplayer2.Timeline$c");
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int p() {
        return 1;
    }

    public n0(long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, @Nullable Object obj, w0 w0Var) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j10, j11, j12, j13, z10, z11, false, obj, w0Var, z12 ? w0Var.f23164c : null);
    }

    public n0(long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z10, boolean z11, boolean z12, @Nullable Object obj, w0 w0Var, @Nullable w0.f fVar) {
        this.f21822c = j10;
        this.f21823d = j11;
        this.f21824e = j12;
        this.f21825f = j13;
        this.f21826g = j14;
        this.f21827h = j15;
        this.f21828i = j16;
        this.f21829j = z10;
        this.f21830k = z11;
        this.f21831l = z12;
        this.f21832m = obj;
        this.f21833n = (w0) com.google.android.exoplayer2.util.a.e(w0Var);
        this.f21834o = fVar;
    }
}
