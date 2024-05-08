package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.internal.BackoffPolicy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ExponentialBackoffPolicy implements BackoffPolicy {
    private Random random = new Random();
    private long initialBackoffNanos = TimeUnit.SECONDS.toNanos(1);
    private long maxBackoffNanos = TimeUnit.MINUTES.toNanos(2);
    private double multiplier = 1.6d;
    private double jitter = 0.2d;
    private long nextBackoffNanos = this.initialBackoffNanos;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Provider implements BackoffPolicy.Provider {
        @Override // io.grpc.internal.BackoffPolicy.Provider
        public BackoffPolicy get() {
            return new ExponentialBackoffPolicy();
        }
    }

    private long uniformRandom(double d10, double d11) {
        o.d(d11 >= d10);
        return (long) ((this.random.nextDouble() * (d11 - d10)) + d10);
    }

    @Override // io.grpc.internal.BackoffPolicy
    public long nextBackoffNanos() {
        long j10 = this.nextBackoffNanos;
        double d10 = j10;
        this.nextBackoffNanos = Math.min((long) (this.multiplier * d10), this.maxBackoffNanos);
        double d11 = this.jitter;
        return j10 + uniformRandom((-d11) * d10, d11 * d10);
    }

    public ExponentialBackoffPolicy setInitialBackoffNanos(long j10) {
        this.initialBackoffNanos = j10;
        return this;
    }

    public ExponentialBackoffPolicy setJitter(double d10) {
        this.jitter = d10;
        return this;
    }

    public ExponentialBackoffPolicy setMaxBackoffNanos(long j10) {
        this.maxBackoffNanos = j10;
        return this;
    }

    public ExponentialBackoffPolicy setMultiplier(double d10) {
        this.multiplier = d10;
        return this;
    }

    public ExponentialBackoffPolicy setRandom(Random random) {
        this.random = random;
        return this;
    }
}
