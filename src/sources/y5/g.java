package y5;

import z5.i;

/* compiled from: DashWrappingSegmentIndex.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements e {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.extractor.b f54669a;

    /* renamed from: b, reason: collision with root package name */
    public final long f54670b;

    public g(com.google.android.exoplayer2.extractor.b bVar, long j10) {
        this.f54669a = bVar;
        this.f54670b = j10;
    }

    @Override // y5.e
    public long a(long j10, long j11) {
        return this.f54669a.f20035d[(int) j10];
    }

    @Override // y5.e
    public long b(long j10, long j11) {
        return 0L;
    }

    @Override // y5.e
    public long c(long j10) {
        return this.f54669a.f20036e[(int) j10] - this.f54670b;
    }

    @Override // y5.e
    public long d(long j10, long j11) {
        return -9223372036854775807L;
    }

    @Override // y5.e
    public long e(long j10, long j11) {
        return this.f54669a.a(j10 + this.f54670b);
    }

    @Override // y5.e
    public long f(long j10) {
        return this.f54669a.f20032a;
    }

    @Override // y5.e
    public long g() {
        return 0L;
    }

    @Override // y5.e
    public i h(long j10) {
        return new i(null, this.f54669a.f20034c[(int) j10], r0.f20033b[r9]);
    }

    @Override // y5.e
    public boolean i() {
        return true;
    }

    @Override // y5.e
    public long j(long j10, long j11) {
        return this.f54669a.f20032a;
    }
}
