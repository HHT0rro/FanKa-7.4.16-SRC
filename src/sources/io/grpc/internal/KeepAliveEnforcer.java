package io.grpc.internal;

import com.google.common.base.o;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class KeepAliveEnforcer {
    public static final long IMPLICIT_PERMIT_TIME_NANOS = TimeUnit.HOURS.toNanos(2);
    public static final int MAX_PING_STRIKES = 2;
    private final long epoch;
    private boolean hasOutstandingCalls;
    private long lastValidPingTime;
    private final long minTimeNanos;
    private final boolean permitWithoutCalls;
    private int pingStrikes;
    private final Ticker ticker;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SystemTicker implements Ticker {
        public static final SystemTicker INSTANCE = new SystemTicker();

        @Override // io.grpc.internal.KeepAliveEnforcer.Ticker
        public long nanoTime() {
            return System.nanoTime();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Ticker {
        long nanoTime();
    }

    public KeepAliveEnforcer(boolean z10, long j10, TimeUnit timeUnit) {
        this(z10, j10, timeUnit, SystemTicker.INSTANCE);
    }

    private static long compareNanos(long j10, long j11) {
        return j10 - j11;
    }

    public void onTransportActive() {
        this.hasOutstandingCalls = true;
    }

    public void onTransportIdle() {
        this.hasOutstandingCalls = false;
    }

    public boolean pingAcceptable() {
        long nanoTime = this.ticker.nanoTime();
        if (!(this.hasOutstandingCalls || this.permitWithoutCalls ? compareNanos(this.lastValidPingTime + this.minTimeNanos, nanoTime) <= 0 : compareNanos(this.lastValidPingTime + IMPLICIT_PERMIT_TIME_NANOS, nanoTime) <= 0)) {
            int i10 = this.pingStrikes + 1;
            this.pingStrikes = i10;
            return i10 <= 2;
        }
        this.lastValidPingTime = nanoTime;
        return true;
    }

    public void resetCounters() {
        this.lastValidPingTime = this.epoch;
        this.pingStrikes = 0;
    }

    public KeepAliveEnforcer(boolean z10, long j10, TimeUnit timeUnit, Ticker ticker) {
        o.j(j10 >= 0, "minTime must be non-negative: %s", j10);
        this.permitWithoutCalls = z10;
        this.minTimeNanos = Math.min(timeUnit.toNanos(j10), IMPLICIT_PERMIT_TIME_NANOS);
        this.ticker = ticker;
        long nanoTime = ticker.nanoTime();
        this.epoch = nanoTime;
        this.lastValidPingTime = nanoTime;
    }
}
