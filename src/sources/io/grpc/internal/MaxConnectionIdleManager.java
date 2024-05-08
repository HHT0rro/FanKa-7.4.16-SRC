package io.grpc.internal;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MaxConnectionIdleManager {
    private static final Ticker systemTicker = new Ticker() { // from class: io.grpc.internal.MaxConnectionIdleManager.1
        @Override // io.grpc.internal.MaxConnectionIdleManager.Ticker
        public long nanoTime() {
            return System.nanoTime();
        }
    };
    private boolean isActive;
    private final long maxConnectionIdleInNanos;
    private long nextIdleMonitorTime;
    private ScheduledExecutorService scheduler;
    private boolean shutdownDelayed;
    private ScheduledFuture<?> shutdownFuture;
    private Runnable shutdownTask;
    private final Ticker ticker;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Ticker {
        long nanoTime();
    }

    public MaxConnectionIdleManager(long j10) {
        this(j10, systemTicker);
    }

    public void onTransportActive() {
        this.isActive = true;
        this.shutdownDelayed = true;
    }

    public void onTransportIdle() {
        this.isActive = false;
        ScheduledFuture<?> scheduledFuture = this.shutdownFuture;
        if (scheduledFuture == null) {
            return;
        }
        if (scheduledFuture.isDone()) {
            this.shutdownDelayed = false;
            this.shutdownFuture = this.scheduler.schedule(this.shutdownTask, this.maxConnectionIdleInNanos, TimeUnit.NANOSECONDS);
        } else {
            this.nextIdleMonitorTime = this.ticker.nanoTime() + this.maxConnectionIdleInNanos;
        }
    }

    public void onTransportTermination() {
        ScheduledFuture<?> scheduledFuture = this.shutdownFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.shutdownFuture = null;
        }
    }

    public void start(final Runnable runnable, final ScheduledExecutorService scheduledExecutorService) {
        this.scheduler = scheduledExecutorService;
        this.nextIdleMonitorTime = this.ticker.nanoTime() + this.maxConnectionIdleInNanos;
        LogExceptionRunnable logExceptionRunnable = new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.MaxConnectionIdleManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (MaxConnectionIdleManager.this.shutdownDelayed) {
                    if (MaxConnectionIdleManager.this.isActive) {
                        return;
                    }
                    MaxConnectionIdleManager maxConnectionIdleManager = MaxConnectionIdleManager.this;
                    maxConnectionIdleManager.shutdownFuture = scheduledExecutorService.schedule(maxConnectionIdleManager.shutdownTask, MaxConnectionIdleManager.this.nextIdleMonitorTime - MaxConnectionIdleManager.this.ticker.nanoTime(), TimeUnit.NANOSECONDS);
                    MaxConnectionIdleManager.this.shutdownDelayed = false;
                    return;
                }
                runnable.run();
                MaxConnectionIdleManager.this.shutdownFuture = null;
            }
        });
        this.shutdownTask = logExceptionRunnable;
        this.shutdownFuture = scheduledExecutorService.schedule(logExceptionRunnable, this.maxConnectionIdleInNanos, TimeUnit.NANOSECONDS);
    }

    public MaxConnectionIdleManager(long j10, Ticker ticker) {
        this.maxConnectionIdleInNanos = j10;
        this.ticker = ticker;
    }
}
