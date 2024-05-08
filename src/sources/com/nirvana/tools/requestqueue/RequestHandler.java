package com.nirvana.tools.requestqueue;

import com.nirvana.tools.core.ExecutorManager;
import com.nirvana.tools.requestqueue.Response;
import com.nirvana.tools.requestqueue.strategy.CallbackStrategy;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RunnableScheduledFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RequestHandler<T extends Response> {

    /* renamed from: a, reason: collision with root package name */
    public List<Callback<T>> f37693a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public RequestHandler<T>.a f37694b;

    /* renamed from: c, reason: collision with root package name */
    public Request<T> f37695c;

    /* renamed from: d, reason: collision with root package name */
    private DoneAction f37696d;

    /* renamed from: com.nirvana.tools.requestqueue.RequestHandler$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37704a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f37705b;

        static {
            int[] iArr = new int[CallbackStrategy.values().length];
            f37705b = iArr;
            try {
                iArr[CallbackStrategy.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37705b[CallbackStrategy.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ThreadStrategy.values().length];
            f37704a = iArr2;
            try {
                iArr2[ThreadStrategy.THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37704a[ThreadStrategy.THREAD_MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37704a[ThreadStrategy.SAME_WITH_CALLABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface DoneAction {
        void run(RequestHandler requestHandler);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private Runnable f37709d;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f37708c = false;

        /* renamed from: a, reason: collision with root package name */
        public RunnableScheduledFuture<?> f37706a = null;

        public a(Runnable runnable) {
            this.f37709d = runnable;
        }

        public final synchronized void a() {
            if (this.f37709d != null) {
                ExecutorManager.getInstance().removeFromMain(this.f37709d);
            }
            if (this.f37706a != null) {
                ExecutorManager.getInstance().removeFromThread(this.f37706a);
            }
            this.f37708c = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f37708c) {
                return;
            }
            try {
                T call = RequestHandler.this.f37695c.getAction().call();
                if (this.f37708c) {
                    return;
                }
                RequestHandler.this.a((RequestHandler) call);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public RequestHandler(Request<T> request, DoneAction doneAction) {
        this.f37695c = request;
        this.f37696d = doneAction;
    }

    public final void a() {
        if (this.f37694b == null) {
            Runnable runnable = new Runnable() { // from class: com.nirvana.tools.requestqueue.RequestHandler.3
                @Override // java.lang.Runnable
                public final void run() {
                    RequestHandler.this.a((RequestHandler) RequestHandler.this.f37695c.getAction().onTimeout());
                }
            };
            this.f37694b = new a(runnable);
            int i10 = AnonymousClass4.f37704a[this.f37695c.getThreadStrategy().ordinal()];
            if (i10 == 1) {
                ExecutorManager.getInstance().scheduleFuture(this.f37694b);
                this.f37694b.f37706a = ExecutorManager.getInstance().scheduleFutureDelay(runnable, this.f37695c.getTimeout());
            } else {
                if (i10 != 2) {
                    throw new IllegalArgumentException("Request Callable ThreadStrategy Illegal");
                }
                ExecutorManager.getInstance().postMain(this.f37694b);
                ExecutorManager.getInstance().postMain(runnable, this.f37695c.getTimeout());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x003a, B:10:0x0042, B:15:0x0024, B:16:0x002f, B:17:0x0033), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(com.nirvana.tools.requestqueue.Request<T> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.nirvana.tools.requestqueue.Callback r0 = r6.getCallback()     // Catch: java.lang.Throwable -> L4d
            long r1 = r6.getTimeout()     // Catch: java.lang.Throwable -> L4d
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L4d
            long r1 = r1 + r3
            r0.setExpiredTime(r1)     // Catch: java.lang.Throwable -> L4d
            int[] r0 = com.nirvana.tools.requestqueue.RequestHandler.AnonymousClass4.f37705b     // Catch: java.lang.Throwable -> L4d
            com.nirvana.tools.requestqueue.strategy.CallbackStrategy r1 = r6.getCallbackStrategy()     // Catch: java.lang.Throwable -> L4d
            int r1 = r1.ordinal()     // Catch: java.lang.Throwable -> L4d
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L4d
            r1 = 1
            if (r0 == r1) goto L33
            r1 = 2
            if (r0 == r1) goto L24
            goto L3a
        L24:
            java.util.List<com.nirvana.tools.requestqueue.Callback<T extends com.nirvana.tools.requestqueue.Response>> r0 = r5.f37693a     // Catch: java.lang.Throwable -> L4d
            r0.clear()     // Catch: java.lang.Throwable -> L4d
            java.util.List<com.nirvana.tools.requestqueue.Callback<T extends com.nirvana.tools.requestqueue.Response>> r0 = r5.f37693a     // Catch: java.lang.Throwable -> L4d
            com.nirvana.tools.requestqueue.Callback r1 = r6.getCallback()     // Catch: java.lang.Throwable -> L4d
        L2f:
            r0.add(r1)     // Catch: java.lang.Throwable -> L4d
            goto L3a
        L33:
            java.util.List<com.nirvana.tools.requestqueue.Callback<T extends com.nirvana.tools.requestqueue.Response>> r0 = r5.f37693a     // Catch: java.lang.Throwable -> L4d
            com.nirvana.tools.requestqueue.Callback r1 = r6.getCallback()     // Catch: java.lang.Throwable -> L4d
            goto L2f
        L3a:
            java.util.List<com.nirvana.tools.requestqueue.Callback<T extends com.nirvana.tools.requestqueue.Response>> r0 = r5.f37693a     // Catch: java.lang.Throwable -> L4d
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L4b
            java.util.List<com.nirvana.tools.requestqueue.Callback<T extends com.nirvana.tools.requestqueue.Response>> r0 = r5.f37693a     // Catch: java.lang.Throwable -> L4d
            com.nirvana.tools.requestqueue.Callback r6 = r6.getCallback()     // Catch: java.lang.Throwable -> L4d
            r0.add(r6)     // Catch: java.lang.Throwable -> L4d
        L4b:
            monitor-exit(r5)
            return
        L4d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nirvana.tools.requestqueue.RequestHandler.a(com.nirvana.tools.requestqueue.Request):void");
    }

    public final synchronized void a(final T t2) {
        long j10 = 0;
        if (this.f37693a.size() > 0) {
            ArrayList arrayList = new ArrayList(this.f37693a.size());
            Iterator<Callback<T>> iterator2 = this.f37693a.iterator2();
            while (iterator2.hasNext()) {
                final Callback<T> next = iterator2.next();
                if (t2.isTimeout()) {
                    long currentTimeMillis = System.currentTimeMillis() - next.getExpiredTime();
                    if (currentTimeMillis > next.getThreshold()) {
                        if (j10 > currentTimeMillis) {
                            j10 = currentTimeMillis;
                        }
                    }
                }
                int i10 = AnonymousClass4.f37704a[next.getThreadStrategy().ordinal()];
                if (i10 == 1) {
                    ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.nirvana.tools.requestqueue.RequestHandler.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            next.onResult(t2);
                        }
                    });
                } else if (i10 == 2) {
                    ExecutorManager.getInstance().postMain(new Runnable() { // from class: com.nirvana.tools.requestqueue.RequestHandler.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            next.onResult(t2);
                        }
                    });
                } else if (i10 == 3) {
                    arrayList.add(next);
                }
                iterator2.remove();
            }
            Iterator<E> iterator22 = arrayList.iterator2();
            while (iterator22.hasNext()) {
                ((Callback) iterator22.next()).onResult(t2);
            }
            arrayList.clear();
            if (this.f37693a.isEmpty()) {
                DoneAction doneAction = this.f37696d;
                if (doneAction != null) {
                    doneAction.run(this);
                }
            } else {
                Request<T> request = this.f37695c;
                if (request != null) {
                    request.setTimeout(j10);
                }
                a();
            }
        }
    }
}
