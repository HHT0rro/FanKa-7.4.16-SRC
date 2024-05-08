package com.google.android.exoplayer2;

import androidx.annotation.Nullable;

/* compiled from: SeekParameters.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p1 {

    /* renamed from: c, reason: collision with root package name */
    public static final p1 f21051c;

    /* renamed from: d, reason: collision with root package name */
    public static final p1 f21052d;

    /* renamed from: e, reason: collision with root package name */
    public static final p1 f21053e;

    /* renamed from: f, reason: collision with root package name */
    public static final p1 f21054f;

    /* renamed from: g, reason: collision with root package name */
    public static final p1 f21055g;

    /* renamed from: a, reason: collision with root package name */
    public final long f21056a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21057b;

    static {
        p1 p1Var = new p1(0L, 0L);
        f21051c = p1Var;
        f21052d = new p1(Long.MAX_VALUE, Long.MAX_VALUE);
        f21053e = new p1(Long.MAX_VALUE, 0L);
        f21054f = new p1(0L, Long.MAX_VALUE);
        f21055g = p1Var;
    }

    public p1(long j10, long j11) {
        com.google.android.exoplayer2.util.a.a(j10 >= 0);
        com.google.android.exoplayer2.util.a.a(j11 >= 0);
        this.f21056a = j10;
        this.f21057b = j11;
    }

    public long a(long j10, long j11, long j12) {
        long j13 = this.f21056a;
        if (j13 == 0 && this.f21057b == 0) {
            return j10;
        }
        long Q0 = com.google.android.exoplayer2.util.j0.Q0(j10, j13, Long.MIN_VALUE);
        long b4 = com.google.android.exoplayer2.util.j0.b(j10, this.f21057b, Long.MAX_VALUE);
        boolean z10 = Q0 <= j11 && j11 <= b4;
        boolean z11 = Q0 <= j12 && j12 <= b4;
        return (z10 && z11) ? Math.abs(j11 - j10) <= Math.abs(j12 - j10) ? j11 : j12 : z10 ? j11 : z11 ? j12 : Q0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p1.class != obj.getClass()) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return this.f21056a == p1Var.f21056a && this.f21057b == p1Var.f21057b;
    }

    public int hashCode() {
        return (((int) this.f21056a) * 31) + ((int) this.f21057b);
    }
}
