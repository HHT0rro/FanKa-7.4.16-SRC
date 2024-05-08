package io.grpc.internal;

import com.google.common.base.r;
import io.grpc.internal.ClientTransport;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Http2Ping {
    private static final Logger log = Logger.getLogger(Http2Ping.class.getName());
    private Map<ClientTransport.PingCallback, Executor> callbacks = new LinkedHashMap();
    private boolean completed;
    private final long data;
    private Throwable failureCause;
    private long roundTripTimeNanos;
    private final r stopwatch;

    public Http2Ping(long j10, r rVar) {
        this.data = j10;
        this.stopwatch = rVar;
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback pingCallback, final long j10) {
        return new Runnable() { // from class: io.grpc.internal.Http2Ping.1
            @Override // java.lang.Runnable
            public void run() {
                ClientTransport.PingCallback.this.onSuccess(j10);
            }
        };
    }

    private static void doExecute(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            log.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void notifyFailed(ClientTransport.PingCallback pingCallback, Executor executor, Throwable th) {
        doExecute(executor, asRunnable(pingCallback, th));
    }

    public void addCallback(ClientTransport.PingCallback pingCallback, Executor executor) {
        synchronized (this) {
            if (!this.completed) {
                this.callbacks.put(pingCallback, executor);
            } else {
                Throwable th = this.failureCause;
                doExecute(executor, th != null ? asRunnable(pingCallback, th) : asRunnable(pingCallback, this.roundTripTimeNanos));
            }
        }
    }

    public boolean complete() {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            long e2 = this.stopwatch.e(TimeUnit.NANOSECONDS);
            this.roundTripTimeNanos = e2;
            Map<ClientTransport.PingCallback, Executor> map = this.callbacks;
            this.callbacks = null;
            for (Map.Entry<ClientTransport.PingCallback, Executor> entry : map.entrySet()) {
                doExecute(entry.getValue(), asRunnable(entry.getKey(), e2));
            }
            return true;
        }
    }

    public void failed(Throwable th) {
        synchronized (this) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            this.failureCause = th;
            Map<ClientTransport.PingCallback, Executor> map = this.callbacks;
            this.callbacks = null;
            for (Map.Entry<ClientTransport.PingCallback, Executor> entry : map.entrySet()) {
                notifyFailed(entry.getKey(), entry.getValue(), th);
            }
        }
    }

    public long payload() {
        return this.data;
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback pingCallback, final Throwable th) {
        return new Runnable() { // from class: io.grpc.internal.Http2Ping.2
            @Override // java.lang.Runnable
            public void run() {
                ClientTransport.PingCallback.this.onFailure(th);
            }
        };
    }
}
