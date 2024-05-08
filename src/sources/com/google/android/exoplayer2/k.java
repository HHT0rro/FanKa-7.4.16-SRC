package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.w0;
import com.google.common.primitives.Longs;

/* compiled from: DefaultLivePlaybackSpeedControl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k implements u0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f20723a;

    /* renamed from: b, reason: collision with root package name */
    public final float f20724b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20725c;

    /* renamed from: d, reason: collision with root package name */
    public final float f20726d;

    /* renamed from: e, reason: collision with root package name */
    public final long f20727e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20728f;

    /* renamed from: g, reason: collision with root package name */
    public final float f20729g;

    /* renamed from: h, reason: collision with root package name */
    public long f20730h;

    /* renamed from: i, reason: collision with root package name */
    public long f20731i;

    /* renamed from: j, reason: collision with root package name */
    public long f20732j;

    /* renamed from: k, reason: collision with root package name */
    public long f20733k;

    /* renamed from: l, reason: collision with root package name */
    public long f20734l;

    /* renamed from: m, reason: collision with root package name */
    public long f20735m;

    /* renamed from: n, reason: collision with root package name */
    public float f20736n;

    /* renamed from: o, reason: collision with root package name */
    public float f20737o;

    /* renamed from: p, reason: collision with root package name */
    public float f20738p;

    /* renamed from: q, reason: collision with root package name */
    public long f20739q;

    /* renamed from: r, reason: collision with root package name */
    public long f20740r;

    /* renamed from: s, reason: collision with root package name */
    public long f20741s;

    /* compiled from: DefaultLivePlaybackSpeedControl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public float f20742a = 0.97f;

        /* renamed from: b, reason: collision with root package name */
        public float f20743b = 1.03f;

        /* renamed from: c, reason: collision with root package name */
        public long f20744c = 1000;

        /* renamed from: d, reason: collision with root package name */
        public float f20745d = 1.0E-7f;

        /* renamed from: e, reason: collision with root package name */
        public long f20746e = h.d(20);

        /* renamed from: f, reason: collision with root package name */
        public long f20747f = h.d(500);

        /* renamed from: g, reason: collision with root package name */
        public float f20748g = 0.999f;

        public k a() {
            return new k(this.f20742a, this.f20743b, this.f20744c, this.f20745d, this.f20746e, this.f20747f, this.f20748g);
        }
    }

    public static long h(long j10, long j11, float f10) {
        return (((float) j10) * f10) + ((1.0f - f10) * ((float) j11));
    }

    @Override // com.google.android.exoplayer2.u0
    public void a(w0.f fVar) {
        this.f20730h = h.d(fVar.f23211a);
        this.f20733k = h.d(fVar.f23212b);
        this.f20734l = h.d(fVar.f23213c);
        float f10 = fVar.f23214d;
        if (f10 == -3.4028235E38f) {
            f10 = this.f20723a;
        }
        this.f20737o = f10;
        float f11 = fVar.f23215e;
        if (f11 == -3.4028235E38f) {
            f11 = this.f20724b;
        }
        this.f20736n = f11;
        g();
    }

    @Override // com.google.android.exoplayer2.u0
    public float b(long j10, long j11) {
        if (this.f20730h == -9223372036854775807L) {
            return 1.0f;
        }
        i(j10, j11);
        if (this.f20739q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.f20739q < this.f20725c) {
            return this.f20738p;
        }
        this.f20739q = SystemClock.elapsedRealtime();
        f(j10);
        long j12 = j10 - this.f20735m;
        if (Math.abs(j12) < this.f20727e) {
            this.f20738p = 1.0f;
        } else {
            this.f20738p = com.google.android.exoplayer2.util.j0.q((this.f20726d * ((float) j12)) + 1.0f, this.f20737o, this.f20736n);
        }
        return this.f20738p;
    }

    @Override // com.google.android.exoplayer2.u0
    public long c() {
        return this.f20735m;
    }

    @Override // com.google.android.exoplayer2.u0
    public void d() {
        long j10 = this.f20735m;
        if (j10 == -9223372036854775807L) {
            return;
        }
        long j11 = j10 + this.f20728f;
        this.f20735m = j11;
        long j12 = this.f20734l;
        if (j12 != -9223372036854775807L && j11 > j12) {
            this.f20735m = j12;
        }
        this.f20739q = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.u0
    public void e(long j10) {
        this.f20731i = j10;
        g();
    }

    public final void f(long j10) {
        long j11 = this.f20740r + (this.f20741s * 3);
        if (this.f20735m > j11) {
            float d10 = (float) h.d(this.f20725c);
            this.f20735m = Longs.h(j11, this.f20732j, this.f20735m - (((this.f20738p - 1.0f) * d10) + ((this.f20736n - 1.0f) * d10)));
            return;
        }
        long s2 = com.google.android.exoplayer2.util.j0.s(j10 - (Math.max(0.0f, this.f20738p - 1.0f) / this.f20726d), this.f20735m, j11);
        this.f20735m = s2;
        long j12 = this.f20734l;
        if (j12 == -9223372036854775807L || s2 <= j12) {
            return;
        }
        this.f20735m = j12;
    }

    public final void g() {
        long j10 = this.f20730h;
        if (j10 != -9223372036854775807L) {
            long j11 = this.f20731i;
            if (j11 != -9223372036854775807L) {
                j10 = j11;
            }
            long j12 = this.f20733k;
            if (j12 != -9223372036854775807L && j10 < j12) {
                j10 = j12;
            }
            long j13 = this.f20734l;
            if (j13 != -9223372036854775807L && j10 > j13) {
                j10 = j13;
            }
        } else {
            j10 = -9223372036854775807L;
        }
        if (this.f20732j == j10) {
            return;
        }
        this.f20732j = j10;
        this.f20735m = j10;
        this.f20740r = -9223372036854775807L;
        this.f20741s = -9223372036854775807L;
        this.f20739q = -9223372036854775807L;
    }

    public final void i(long j10, long j11) {
        long j12 = j10 - j11;
        long j13 = this.f20740r;
        if (j13 == -9223372036854775807L) {
            this.f20740r = j12;
            this.f20741s = 0L;
        } else {
            long max = Math.max(j12, h(j13, j12, this.f20729g));
            this.f20740r = max;
            this.f20741s = h(this.f20741s, Math.abs(j12 - max), this.f20729g);
        }
    }

    public k(float f10, float f11, long j10, float f12, long j11, long j12, float f13) {
        this.f20723a = f10;
        this.f20724b = f11;
        this.f20725c = j10;
        this.f20726d = f12;
        this.f20727e = j11;
        this.f20728f = j12;
        this.f20729g = f13;
        this.f20730h = -9223372036854775807L;
        this.f20731i = -9223372036854775807L;
        this.f20733k = -9223372036854775807L;
        this.f20734l = -9223372036854775807L;
        this.f20737o = f10;
        this.f20736n = f11;
        this.f20738p = 1.0f;
        this.f20739q = -9223372036854775807L;
        this.f20732j = -9223372036854775807L;
        this.f20735m = -9223372036854775807L;
        this.f20740r = -9223372036854775807L;
        this.f20741s = -9223372036854775807L;
    }
}
