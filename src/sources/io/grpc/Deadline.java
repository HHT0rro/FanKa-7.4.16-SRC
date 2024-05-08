package io.grpc;

import com.huawei.flexiblelayout.parser.cardmanager.d;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Deadline implements Comparable<Deadline> {
    private static final long MAX_OFFSET;
    private static final long MIN_OFFSET;
    private static final long NANOS_PER_SECOND;
    private static final SystemTicker SYSTEM_TICKER = new SystemTicker();
    private final long deadlineNanos;
    private volatile boolean expired;
    private final Ticker ticker;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SystemTicker extends Ticker {
        private SystemTicker() {
        }

        @Override // io.grpc.Deadline.Ticker
        public long nanoTime() {
            return System.nanoTime();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Ticker {
        public abstract long nanoTime();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        MAX_OFFSET = nanos;
        MIN_OFFSET = -nanos;
        NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1L);
    }

    private Deadline(Ticker ticker, long j10, boolean z10) {
        this(ticker, ticker.nanoTime(), j10, z10);
    }

    public static Deadline after(long j10, TimeUnit timeUnit) {
        return after(j10, timeUnit, SYSTEM_TICKER);
    }

    private static <T> T checkNotNull(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private void checkTicker(Deadline deadline) {
        if (this.ticker == deadline.ticker) {
            return;
        }
        throw new AssertionError((Object) ("Tickers (" + ((Object) this.ticker) + " and " + ((Object) deadline.ticker) + ") don't match. Custom Ticker should only be used in tests!"));
    }

    public static Ticker getSystemTicker() {
        return SYSTEM_TICKER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Deadline)) {
            return false;
        }
        Deadline deadline = (Deadline) obj;
        Ticker ticker = this.ticker;
        if (ticker != null ? ticker == deadline.ticker : deadline.ticker == null) {
            return this.deadlineNanos == deadline.deadlineNanos;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.asList(this.ticker, Long.valueOf(this.deadlineNanos)).hashCode();
    }

    public boolean isBefore(Deadline deadline) {
        checkTicker(deadline);
        return this.deadlineNanos - deadline.deadlineNanos < 0;
    }

    public boolean isExpired() {
        if (!this.expired) {
            if (this.deadlineNanos - this.ticker.nanoTime() > 0) {
                return false;
            }
            this.expired = true;
        }
        return true;
    }

    public Deadline minimum(Deadline deadline) {
        checkTicker(deadline);
        return isBefore(deadline) ? this : deadline;
    }

    public Deadline offset(long j10, TimeUnit timeUnit) {
        return j10 == 0 ? this : new Deadline(this.ticker, this.deadlineNanos, timeUnit.toNanos(j10), isExpired());
    }

    public ScheduledFuture<?> runOnExpiration(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        checkNotNull(runnable, d.a.f28343b);
        checkNotNull(scheduledExecutorService, "scheduler");
        return scheduledExecutorService.schedule(runnable, this.deadlineNanos - this.ticker.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public long timeRemaining(TimeUnit timeUnit) {
        long nanoTime = this.ticker.nanoTime();
        if (!this.expired && this.deadlineNanos - nanoTime <= 0) {
            this.expired = true;
        }
        return timeUnit.convert(this.deadlineNanos - nanoTime, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long timeRemaining = timeRemaining(TimeUnit.NANOSECONDS);
        long abs = Math.abs(timeRemaining);
        long j10 = NANOS_PER_SECOND;
        long j11 = abs / j10;
        long abs2 = Math.abs(timeRemaining) % j10;
        StringBuilder sb2 = new StringBuilder();
        if (timeRemaining < 0) {
            sb2.append('-');
        }
        sb2.append(j11);
        if (abs2 > 0) {
            sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
        }
        sb2.append("s from now");
        if (this.ticker != SYSTEM_TICKER) {
            sb2.append(" (ticker=" + ((Object) this.ticker) + ")");
        }
        return sb2.toString();
    }

    private Deadline(Ticker ticker, long j10, long j11, boolean z10) {
        this.ticker = ticker;
        long min = Math.min(MAX_OFFSET, Math.max(MIN_OFFSET, j11));
        this.deadlineNanos = j10 + min;
        this.expired = z10 && min <= 0;
    }

    public static Deadline after(long j10, TimeUnit timeUnit, Ticker ticker) {
        checkNotNull(timeUnit, "units");
        return new Deadline(ticker, timeUnit.toNanos(j10), true);
    }

    @Override // java.lang.Comparable
    public int compareTo(Deadline deadline) {
        checkTicker(deadline);
        long j10 = this.deadlineNanos - deadline.deadlineNanos;
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }
}
