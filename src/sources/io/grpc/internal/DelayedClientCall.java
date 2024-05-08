package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.o;
import com.huawei.openalliance.ad.constant.bg;
import io.grpc.Attributes;
import io.grpc.ClientCall;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DelayedClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Executor callExecutor;
    private final Context context;
    private DelayedListener<RespT> delayedListener;
    private Status error;
    private final ScheduledFuture<?> initialDeadlineMonitor;
    private ClientCall.Listener<RespT> listener;
    private volatile boolean passThrough;
    private List<Runnable> pendingRunnables = new ArrayList();
    private ClientCall<ReqT, RespT> realCall;
    private static final Logger logger = Logger.getLogger(DelayedClientCall.class.getName());
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.internal.DelayedClientCall.8
        @Override // io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.ClientCall
        public void request(int i10) {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object obj) {
        }

        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class CloseListenerRunnable extends ContextRunnable {
        public final ClientCall.Listener<RespT> listener;
        public final Status status;

        public CloseListenerRunnable(ClientCall.Listener<RespT> listener, Status status) {
            super(DelayedClientCall.this.context);
            this.listener = listener;
            this.status = status;
        }

        @Override // io.grpc.internal.ContextRunnable
        public void runInContext() {
            this.listener.onClose(this.status, new Metadata());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DelayedListener<RespT> extends ClientCall.Listener<RespT> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientCall.Listener<RespT> realListener;

        public DelayedListener(ClientCall.Listener<RespT> listener) {
            this.realListener = listener;
        }

        private void delayOrExecute(Runnable runnable) {
            synchronized (this) {
                if (!this.passThrough) {
                    this.pendingCallbacks.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainPendingCallbacks() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    if (this.pendingCallbacks.isEmpty()) {
                        this.pendingCallbacks = null;
                        this.passThrough = true;
                        return;
                    } else {
                        list = this.pendingCallbacks;
                        this.pendingCallbacks = arrayList;
                    }
                }
                Iterator iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    ((Runnable) iterator2.next()).run();
                }
                list.clear();
                arrayList = list;
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(final Status status, final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedListener.this.realListener.onClose(status, metadata);
                }
            });
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(final Metadata metadata) {
            if (this.passThrough) {
                this.realListener.onHeaders(metadata);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onHeaders(metadata);
                    }
                });
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onMessage(final RespT respt) {
            if (this.passThrough) {
                this.realListener.onMessage(respt);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onMessage(respt);
                    }
                });
            }
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.DelayedListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedListener.this.realListener.onReady();
                    }
                });
            }
        }
    }

    public DelayedClientCall(Executor executor, ScheduledExecutorService scheduledExecutorService, Deadline deadline) {
        this.callExecutor = (Executor) o.s(executor, "callExecutor");
        o.s(scheduledExecutorService, "scheduler");
        this.context = Context.current();
        this.initialDeadlineMonitor = scheduleDeadlineIfNeeded(scheduledExecutorService, deadline);
    }

    private void delayOrExecute(Runnable runnable) {
        synchronized (this) {
            if (!this.passThrough) {
                this.pendingRunnables.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        if (r0.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        r0 = r1.iterator2();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drainPendingCalls() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.pendingRunnables     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L24
            r0 = 0
            r3.pendingRunnables = r0     // Catch: java.lang.Throwable -> L42
            r0 = 1
            r3.passThrough = r0     // Catch: java.lang.Throwable -> L42
            io.grpc.internal.DelayedClientCall$DelayedListener<RespT> r0 = r3.delayedListener     // Catch: java.lang.Throwable -> L42
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.callExecutor
            io.grpc.internal.DelayedClientCall$1DrainListenerRunnable r2 = new io.grpc.internal.DelayedClientCall$1DrainListenerRunnable
            r2.<init>()
            r1.execute(r2)
        L23:
            return
        L24:
            java.util.List<java.lang.Runnable> r1 = r3.pendingRunnables     // Catch: java.lang.Throwable -> L42
            r3.pendingRunnables = r0     // Catch: java.lang.Throwable -> L42
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L42
            java.util.Iterator r0 = r1.iterator2()
        L2d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3d
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L2d
        L3d:
            r1.clear()
            r0 = r1
            goto L5
        L42:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L42
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DelayedClientCall.drainPendingCalls():void");
    }

    private boolean isAbeforeB(Deadline deadline, Deadline deadline2) {
        if (deadline2 == null) {
            return true;
        }
        if (deadline == null) {
            return false;
        }
        return deadline.isBefore(deadline2);
    }

    private ScheduledFuture<?> scheduleDeadlineIfNeeded(ScheduledExecutorService scheduledExecutorService, Deadline deadline) {
        Deadline deadline2 = this.context.getDeadline();
        if (deadline == null && deadline2 == null) {
            return null;
        }
        long timeRemaining = deadline != null ? deadline.timeRemaining(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (deadline2 != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (deadline2.timeRemaining(timeUnit) < timeRemaining) {
                timeRemaining = deadline2.timeRemaining(timeUnit);
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb2 = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(timeRemaining)));
                    if (deadline == null) {
                        sb2.append(" Explicit call timeout was not set.");
                    } else {
                        sb2.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(deadline.timeRemaining(timeUnit))));
                    }
                    logger2.fine(sb2.toString());
                }
            }
        }
        long abs = Math.abs(timeRemaining);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = abs / timeUnit2.toNanos(1L);
        long abs2 = Math.abs(timeRemaining) % timeUnit2.toNanos(1L);
        final StringBuilder sb3 = new StringBuilder();
        String str = isAbeforeB(deadline2, deadline) ? "Context" : "CallOptions";
        if (timeRemaining < 0) {
            sb3.append("ClientCall started after ");
            sb3.append(str);
            sb3.append(" deadline was exceeded. Deadline has been exceeded for ");
        } else {
            sb3.append("Deadline ");
            sb3.append(str);
            sb3.append(" will be exceeded in ");
        }
        sb3.append(nanos);
        sb3.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
        sb3.append("s. ");
        return scheduledExecutorService.schedule(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.1DeadlineExceededRunnable
            @Override // java.lang.Runnable
            public void run() {
                DelayedClientCall.this.cancel(Status.DEADLINE_EXCEEDED.withDescription(sb3.toString()), true);
            }
        }, timeRemaining, TimeUnit.NANOSECONDS);
    }

    private void setRealCall(ClientCall<ReqT, RespT> clientCall) {
        ClientCall<ReqT, RespT> clientCall2 = this.realCall;
        o.B(clientCall2 == null, "realCall already set to %s", clientCall2);
        ScheduledFuture<?> scheduledFuture = this.initialDeadlineMonitor;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.realCall = clientCall;
    }

    public void callCancelled() {
    }

    @Override // io.grpc.ClientCall
    public final void cancel(String str, Throwable th) {
        Status withDescription;
        Status status = Status.CANCELLED;
        if (str != null) {
            withDescription = status.withDescription(str);
        } else {
            withDescription = status.withDescription("Call cancelled without message");
        }
        if (th != null) {
            withDescription = withDescription.withCause(th);
        }
        cancel(withDescription, false);
    }

    @Override // io.grpc.ClientCall
    public final Attributes getAttributes() {
        ClientCall<ReqT, RespT> clientCall;
        synchronized (this) {
            clientCall = this.realCall;
        }
        if (clientCall != null) {
            return clientCall.getAttributes();
        }
        return Attributes.EMPTY;
    }

    public final ClientCall<ReqT, RespT> getRealCall() {
        return this.realCall;
    }

    @Override // io.grpc.ClientCall
    public final void halfClose() {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.7
            @Override // java.lang.Runnable
            public void run() {
                DelayedClientCall.this.realCall.halfClose();
            }
        });
    }

    @Override // io.grpc.ClientCall
    public final boolean isReady() {
        if (this.passThrough) {
            return this.realCall.isReady();
        }
        return false;
    }

    @Override // io.grpc.ClientCall
    public final void request(final int i10) {
        if (this.passThrough) {
            this.realCall.request(i10);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.6
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.request(i10);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void sendMessage(final ReqT reqt) {
        if (this.passThrough) {
            this.realCall.sendMessage(reqt);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.sendMessage(reqt);
                }
            });
        }
    }

    public final Runnable setCall(ClientCall<ReqT, RespT> clientCall) {
        synchronized (this) {
            if (this.realCall != null) {
                return null;
            }
            setRealCall((ClientCall) o.s(clientCall, "call"));
            return new ContextRunnable(this.context) { // from class: io.grpc.internal.DelayedClientCall.1
                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    DelayedClientCall.this.drainPendingCalls();
                }
            };
        }
    }

    @Override // io.grpc.ClientCall
    public final void setMessageCompression(final boolean z10) {
        if (this.passThrough) {
            this.realCall.setMessageCompression(z10);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.5
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.setMessageCompression(z10);
                }
            });
        }
    }

    @Override // io.grpc.ClientCall
    public final void start(final ClientCall.Listener<RespT> listener, final Metadata metadata) {
        Status status;
        boolean z10;
        o.y(this.listener == null, "already started");
        synchronized (this) {
            this.listener = (ClientCall.Listener) o.s(listener, bg.e.f32299p);
            status = this.error;
            z10 = this.passThrough;
            if (!z10) {
                DelayedListener<RespT> delayedListener = new DelayedListener<>(listener);
                this.delayedListener = delayedListener;
                listener = delayedListener;
            }
        }
        if (status != null) {
            this.callExecutor.execute(new CloseListenerRunnable(listener, status));
        } else if (z10) {
            this.realCall.start(listener, metadata);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.2
                @Override // java.lang.Runnable
                public void run() {
                    DelayedClientCall.this.realCall.start(listener, metadata);
                }
            });
        }
    }

    public String toString() {
        return j.c(this).d("realCall", this.realCall).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cancel(final Status status, boolean z10) {
        boolean z11;
        ClientCall.Listener<RespT> listener;
        synchronized (this) {
            if (this.realCall == null) {
                setRealCall(NOOP_CALL);
                z11 = false;
                listener = this.listener;
                this.error = status;
            } else {
                if (z10) {
                    return;
                }
                z11 = true;
                listener = null;
            }
            if (z11) {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedClientCall.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedClientCall.this.realCall.cancel(status.getDescription(), status.getCause());
                    }
                });
            } else {
                if (listener != null) {
                    this.callExecutor.execute(new CloseListenerRunnable(listener, status));
                }
                drainPendingCalls();
            }
            callCancelled();
        }
    }
}
