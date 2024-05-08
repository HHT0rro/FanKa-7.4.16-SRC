package com.google.android.exoplayer2.util;

import androidx.annotation.GuardedBy;
import com.android.internal.os.PowerProfile;

/* compiled from: TimestampAdjuster.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public long f22980a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public long f22981b;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    public long f22982c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Long> f22983d = new ThreadLocal<>();

    public f0(long j10) {
        g(j10);
    }

    public static long f(long j10) {
        return (j10 * 1000000) / 90000;
    }

    public static long i(long j10) {
        return (j10 * 90000) / 1000000;
    }

    public static long j(long j10) {
        return i(j10) % 8589934592L;
    }

    public synchronized long a(long j10) {
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f22981b == -9223372036854775807L) {
            long j11 = this.f22980a;
            if (j11 == 9223372036854775806L) {
                j11 = ((Long) a.e(this.f22983d.get())).longValue();
            }
            this.f22981b = j11 - j10;
            notifyAll();
        }
        this.f22982c = j10;
        return j10 + this.f22981b;
    }

    public synchronized long b(long j10) {
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j11 = this.f22982c;
        if (j11 != -9223372036854775807L) {
            long i10 = i(j11);
            long j12 = (PowerProfile.SUBSYSTEM_MODEM + i10) / 8589934592L;
            long j13 = ((j12 - 1) * 8589934592L) + j10;
            j10 += j12 * 8589934592L;
            if (Math.abs(j13 - i10) < Math.abs(j10 - i10)) {
                j10 = j13;
            }
        }
        return a(f(j10));
    }

    public synchronized long c() {
        long j10;
        j10 = this.f22980a;
        if (j10 == Long.MAX_VALUE || j10 == 9223372036854775806L) {
            j10 = -9223372036854775807L;
        }
        return j10;
    }

    public synchronized long d() {
        long c4;
        long j10 = this.f22982c;
        if (j10 != -9223372036854775807L) {
            c4 = j10 + this.f22981b;
        } else {
            c4 = c();
        }
        return c4;
    }

    public synchronized long e() {
        return this.f22981b;
    }

    public synchronized void g(long j10) {
        this.f22980a = j10;
        this.f22981b = j10 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f22982c = -9223372036854775807L;
    }

    public synchronized void h(boolean z10, long j10) throws InterruptedException {
        a.g(this.f22980a == 9223372036854775806L);
        if (this.f22981b != -9223372036854775807L) {
            return;
        }
        if (z10) {
            this.f22983d.set(Long.valueOf(j10));
        } else {
            while (this.f22981b == -9223372036854775807L) {
                wait();
            }
        }
    }
}
