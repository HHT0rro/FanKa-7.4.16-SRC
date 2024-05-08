package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.common.base.o;
import com.google.common.base.r;
import com.google.common.util.concurrent.p;
import io.grpc.Status;
import io.grpc.internal.ClientTransport;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class KeepAliveManager {
    private final boolean keepAliveDuringTransportIdle;
    private final KeepAlivePinger keepAlivePinger;
    private final long keepAliveTimeInNanos;
    private final long keepAliveTimeoutInNanos;
    private ScheduledFuture<?> pingFuture;
    private final ScheduledExecutorService scheduler;
    private final Runnable sendPing;
    private final Runnable shutdown;
    private ScheduledFuture<?> shutdownFuture;
    private State state;
    private final r stopwatch;
    private static final long MIN_KEEPALIVE_TIME_NANOS = TimeUnit.SECONDS.toNanos(10);
    private static final long MIN_KEEPALIVE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(10);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ClientKeepAlivePinger implements KeepAlivePinger {
        private final ConnectionClientTransport transport;

        public ClientKeepAlivePinger(ConnectionClientTransport connectionClientTransport) {
            this.transport = connectionClientTransport;
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void onPingTimeout() {
            this.transport.shutdownNow(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone"));
        }

        @Override // io.grpc.internal.KeepAliveManager.KeepAlivePinger
        public void ping() {
            this.transport.ping(new ClientTransport.PingCallback() { // from class: io.grpc.internal.KeepAliveManager.ClientKeepAlivePinger.1
                @Override // io.grpc.internal.ClientTransport.PingCallback
                public void onFailure(Throwable th) {
                    ClientKeepAlivePinger.this.transport.shutdownNow(Status.UNAVAILABLE.withDescription("Keepalive failed. The connection is likely gone"));
                }

                @Override // io.grpc.internal.ClientTransport.PingCallback
                public void onSuccess(long j10) {
                }
            }, p.a());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface KeepAlivePinger {
        void onPingTimeout();

        void ping();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum State {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public KeepAliveManager(KeepAlivePinger keepAlivePinger, ScheduledExecutorService scheduledExecutorService, long j10, long j11, boolean z10) {
        this(keepAlivePinger, scheduledExecutorService, r.d(), j10, j11, z10);
    }

    public static long clampKeepAliveTimeInNanos(long j10) {
        return Math.max(j10, MIN_KEEPALIVE_TIME_NANOS);
    }

    public static long clampKeepAliveTimeoutInNanos(long j10) {
        return Math.max(j10, MIN_KEEPALIVE_TIMEOUT_NANOS);
    }

    public synchronized void onDataReceived() {
        this.stopwatch.g().h();
        State state = this.state;
        State state2 = State.PING_SCHEDULED;
        if (state == state2) {
            this.state = State.PING_DELAYED;
        } else if (state == State.PING_SENT || state == State.IDLE_AND_PING_SENT) {
            ScheduledFuture<?> scheduledFuture = this.shutdownFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (this.state == State.IDLE_AND_PING_SENT) {
                this.state = State.IDLE;
            } else {
                this.state = state2;
                o.y(this.pingFuture == null, "There should be no outstanding pingFuture");
                this.pingFuture = this.scheduler.schedule(this.sendPing, this.keepAliveTimeInNanos, TimeUnit.NANOSECONDS);
            }
        }
    }

    public synchronized void onTransportActive() {
        State state = this.state;
        if (state == State.IDLE) {
            this.state = State.PING_SCHEDULED;
            if (this.pingFuture == null) {
                ScheduledExecutorService scheduledExecutorService = this.scheduler;
                Runnable runnable = this.sendPing;
                long j10 = this.keepAliveTimeInNanos;
                r rVar = this.stopwatch;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                this.pingFuture = scheduledExecutorService.schedule(runnable, j10 - rVar.e(timeUnit), timeUnit);
            }
        } else if (state == State.IDLE_AND_PING_SENT) {
            this.state = State.PING_SENT;
        }
    }

    public synchronized void onTransportIdle() {
        if (this.keepAliveDuringTransportIdle) {
            return;
        }
        State state = this.state;
        if (state == State.PING_SCHEDULED || state == State.PING_DELAYED) {
            this.state = State.IDLE;
        }
        if (this.state == State.PING_SENT) {
            this.state = State.IDLE_AND_PING_SENT;
        }
    }

    public synchronized void onTransportStarted() {
        if (this.keepAliveDuringTransportIdle) {
            onTransportActive();
        }
    }

    public synchronized void onTransportTermination() {
        State state = this.state;
        State state2 = State.DISCONNECTED;
        if (state != state2) {
            this.state = state2;
            ScheduledFuture<?> scheduledFuture = this.shutdownFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledFuture<?> scheduledFuture2 = this.pingFuture;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
                this.pingFuture = null;
            }
        }
    }

    public KeepAliveManager(KeepAlivePinger keepAlivePinger, ScheduledExecutorService scheduledExecutorService, r rVar, long j10, long j11, boolean z10) {
        this.state = State.IDLE;
        this.shutdown = new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.KeepAliveManager.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z11;
                synchronized (KeepAliveManager.this) {
                    State state = KeepAliveManager.this.state;
                    State state2 = State.DISCONNECTED;
                    if (state != state2) {
                        KeepAliveManager.this.state = state2;
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    KeepAliveManager.this.keepAlivePinger.onPingTimeout();
                }
            }
        });
        this.sendPing = new LogExceptionRunnable(new Runnable() { // from class: io.grpc.internal.KeepAliveManager.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z11;
                synchronized (KeepAliveManager.this) {
                    KeepAliveManager.this.pingFuture = null;
                    State state = KeepAliveManager.this.state;
                    State state2 = State.PING_SCHEDULED;
                    if (state == state2) {
                        z11 = true;
                        KeepAliveManager.this.state = State.PING_SENT;
                        KeepAliveManager keepAliveManager = KeepAliveManager.this;
                        keepAliveManager.shutdownFuture = keepAliveManager.scheduler.schedule(KeepAliveManager.this.shutdown, KeepAliveManager.this.keepAliveTimeoutInNanos, TimeUnit.NANOSECONDS);
                    } else {
                        if (KeepAliveManager.this.state == State.PING_DELAYED) {
                            KeepAliveManager keepAliveManager2 = KeepAliveManager.this;
                            ScheduledExecutorService scheduledExecutorService2 = keepAliveManager2.scheduler;
                            Runnable runnable = KeepAliveManager.this.sendPing;
                            long j12 = KeepAliveManager.this.keepAliveTimeInNanos;
                            r rVar2 = KeepAliveManager.this.stopwatch;
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            keepAliveManager2.pingFuture = scheduledExecutorService2.schedule(runnable, j12 - rVar2.e(timeUnit), timeUnit);
                            KeepAliveManager.this.state = state2;
                        }
                        z11 = false;
                    }
                }
                if (z11) {
                    KeepAliveManager.this.keepAlivePinger.ping();
                }
            }
        });
        this.keepAlivePinger = (KeepAlivePinger) o.s(keepAlivePinger, "keepAlivePinger");
        this.scheduler = (ScheduledExecutorService) o.s(scheduledExecutorService, "scheduler");
        this.stopwatch = (r) o.s(rVar, NotificationCompat.CATEGORY_STOPWATCH);
        this.keepAliveTimeInNanos = j10;
        this.keepAliveTimeoutInNanos = j11;
        this.keepAliveDuringTransportIdle = z10;
        rVar.g().h();
    }
}
