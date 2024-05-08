package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import d5.o;

/* compiled from: ConstantBitrateSeekMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class c implements i {

    /* renamed from: a, reason: collision with root package name */
    public final long f20038a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20039b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20040c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20041d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20042e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20043f;

    public c(long j10, long j11, int i10, int i11) {
        this.f20038a = j10;
        this.f20039b = j11;
        this.f20040c = i11 == -1 ? 1 : i11;
        this.f20042e = i10;
        if (j10 == -1) {
            this.f20041d = -1L;
            this.f20043f = -9223372036854775807L;
        } else {
            this.f20041d = j10 - j11;
            this.f20043f = f(j10, j11, i10);
        }
    }

    public static long f(long j10, long j11, int i10) {
        return ((Math.max(0L, j10 - j11) * 8) * 1000000) / i10;
    }

    public final long a(long j10) {
        long j11 = (j10 * this.f20042e) / 8000000;
        int i10 = this.f20040c;
        return this.f20039b + j0.s((j11 / i10) * i10, 0L, this.f20041d - i10);
    }

    public long b(long j10) {
        return f(j10, this.f20039b, this.f20042e);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        if (this.f20041d == -1) {
            return new i.a(new o(0L, this.f20039b));
        }
        long a10 = a(j10);
        long b4 = b(a10);
        o oVar = new o(b4, a10);
        if (b4 < j10) {
            int i10 = this.f20040c;
            if (i10 + a10 < this.f20038a) {
                long j11 = a10 + i10;
                return new i.a(oVar, new o(b(j11), j11));
            }
        }
        return new i.a(oVar);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return this.f20041d != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f20043f;
    }
}
