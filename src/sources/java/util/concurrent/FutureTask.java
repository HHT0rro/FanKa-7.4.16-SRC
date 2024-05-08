package java.util.concurrent;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.locks.LockSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FutureTask<V> implements RunnableFuture<V> {
    private static final int CANCELLED = 4;
    private static final int COMPLETING = 1;
    private static final int EXCEPTIONAL = 3;
    private static final int INTERRUPTED = 6;
    private static final int INTERRUPTING = 5;
    private static final int NEW = 0;
    private static final int NORMAL = 2;
    private static final VarHandle RUNNER;
    private static final VarHandle STATE;
    private static final VarHandle WAITERS;
    private Callable<V> callable;
    private Object outcome;
    private volatile Thread runner;
    private volatile int state;
    private volatile WaitNode waiters;

    /* JADX WARN: Multi-variable type inference failed */
    private V report(int i10) throws ExecutionException {
        V v2 = (V) this.outcome;
        if (i10 == 2) {
            return v2;
        }
        if (i10 >= 4) {
            throw new CancellationException();
        }
        throw new ExecutionException((Throwable) v2);
    }

    public FutureTask(Callable<V> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        this.callable = callable;
        this.state = 0;
    }

    public FutureTask(Runnable runnable, V result) {
        this.callable = Executors.callable(runnable, result);
        this.state = 0;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.state >= 4;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.state != 0;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (this.state == 0) {
            VarHandle varHandle = STATE;
            if ((boolean) varHandle.compareAndSet(this, 0, mayInterruptIfRunning ? 5 : 4)) {
                if (mayInterruptIfRunning) {
                    try {
                        try {
                            Thread t2 = this.runner;
                            if (t2 != null) {
                                t2.interrupt();
                            }
                            (void) varHandle.setRelease(this, 6);
                        } catch (Throwable th) {
                            (void) STATE.setRelease(this, 6);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        finishCompletion();
                        throw th2;
                    }
                }
                finishCompletion();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        int s2 = this.state;
        if (s2 <= 1) {
            s2 = awaitDone(false, 0L);
        }
        return report(s2);
    }

    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (unit == null) {
            throw new NullPointerException();
        }
        int s2 = this.state;
        if (s2 <= 1) {
            int awaitDone = awaitDone(true, unit.toNanos(timeout));
            s2 = awaitDone;
            if (awaitDone <= 1) {
                throw new TimeoutException();
            }
        }
        return report(s2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void done() {
    }

    protected void set(V v2) {
        VarHandle varHandle = STATE;
        if ((boolean) varHandle.compareAndSet(this, 0, 1)) {
            this.outcome = v2;
            (void) varHandle.setRelease(this, 2);
            finishCompletion();
        }
    }

    protected void setException(Throwable t2) {
        VarHandle varHandle = STATE;
        if ((boolean) varHandle.compareAndSet(this, 0, 1)) {
            this.outcome = t2;
            (void) varHandle.setRelease(this, 3);
            finishCompletion();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x003c, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003f, code lost:
    
        setException(r6);
        r6 = null;
        r7 = false;
     */
    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r9 = this;
            int r0 = r9.state
            if (r0 != 0) goto L62
            java.lang.invoke.VarHandle r0 = java.util.concurrent.FutureTask.RUNNER
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r2 = 0
            boolean r0 = (boolean) r0.compareAndSet(r9, r2, r1)
            if (r0 != 0) goto L13
            goto L62
        L13:
            r0 = 5
            java.util.concurrent.Callable<V> r1 = r9.callable     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L4c
            int r3 = r9.state     // Catch: java.lang.Throwable -> L57
            if (r3 != 0) goto L4c
            r3 = 0
        L1d:
            java.util.concurrent.FutureTask$WaitNode r4 = r9.waiters     // Catch: java.lang.Throwable -> L57
            r5 = r4
        L20:
            if (r4 != 0) goto L23
            goto L31
        L23:
            java.lang.Thread r6 = r4.thread     // Catch: java.lang.Throwable -> L57
            if (r6 == 0) goto L2c
            java.lang.Thread r7 = r9.runner     // Catch: java.lang.Throwable -> L57
            r6.setBlockOwner(r7)     // Catch: java.lang.Throwable -> L57
        L2c:
            java.util.concurrent.FutureTask$WaitNode r7 = r4.next     // Catch: java.lang.Throwable -> L57
            if (r7 != r3) goto L4a
        L31:
            r3 = r5
            java.util.concurrent.FutureTask$WaitNode r6 = r9.waiters     // Catch: java.lang.Throwable -> L57
            if (r5 != r6) goto L1d
            java.lang.Object r6 = r1.call()     // Catch: java.lang.Throwable -> L3c
            r7 = 1
            goto L44
        L3c:
            r6 = move-exception
            r7 = 0
            r8 = 0
            r9.setException(r6)     // Catch: java.lang.Throwable -> L57
            r6 = r7
            r7 = r8
        L44:
            if (r7 == 0) goto L4c
            r9.set(r6)     // Catch: java.lang.Throwable -> L57
            goto L4c
        L4a:
            r4 = r7
            goto L20
        L4c:
            r9.runner = r2
            int r1 = r9.state
            if (r1 < r0) goto L55
            r9.handlePossibleCancellationInterrupt(r1)
        L55:
            return
        L57:
            r1 = move-exception
            r9.runner = r2
            int r2 = r9.state
            if (r2 < r0) goto L61
            r9.handlePossibleCancellationInterrupt(r2)
        L61:
            throw r1
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.FutureTask.run():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean runAndReset() {
        int s2;
        if (this.state == 0) {
            if ((boolean) RUNNER.compareAndSet(this, null, Thread.currentThread())) {
                boolean ran = false;
                int s10 = this.state;
                try {
                    Callable<V> c4 = this.callable;
                    if (c4 != null && s10 == 0) {
                        try {
                            c4.call();
                            ran = true;
                        } catch (Throwable ex) {
                            setException(ex);
                        }
                    }
                    return ran && s2 == 0;
                } finally {
                    this.runner = null;
                    s2 = this.state;
                    if (s2 >= 5) {
                        handlePossibleCancellationInterrupt(s2);
                    }
                }
            }
        }
        return false;
    }

    private void handlePossibleCancellationInterrupt(int s2) {
        if (s2 == 5) {
            while (this.state == 5) {
                Thread.yield();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class WaitNode {
        volatile WaitNode next;
        volatile Thread thread = Thread.currentThread();

        WaitNode() {
        }
    }

    private void finishCompletion() {
        while (true) {
            WaitNode waitNode = this.waiters;
            WaitNode q10 = waitNode;
            if (waitNode == null) {
                break;
            }
            if ((boolean) WAITERS.weakCompareAndSet(this, q10, null)) {
                while (true) {
                    Thread t2 = q10.thread;
                    if (t2 != null) {
                        q10.thread = null;
                        LockSupport.unpark(t2);
                    }
                    WaitNode next = q10.next;
                    if (next == null) {
                        break;
                    }
                    q10.next = null;
                    q10 = next;
                }
            }
        }
        done();
        this.callable = null;
    }

    private int awaitDone(boolean timed, long nanos) throws InterruptedException {
        long elapsed;
        long startTime = 0;
        WaitNode q10 = null;
        boolean queued = false;
        while (true) {
            int s2 = this.state;
            if (s2 > 1) {
                if (q10 != null) {
                    q10.thread = null;
                }
                return s2;
            }
            if (s2 == 1) {
                Thread.yield();
            } else {
                if (Thread.interrupted()) {
                    removeWaiter(q10);
                    throw new InterruptedException();
                }
                if (q10 == null) {
                    if (timed && nanos <= 0) {
                        return s2;
                    }
                    q10 = new WaitNode();
                } else if (!queued) {
                    VarHandle varHandle = WAITERS;
                    WaitNode waitNode = this.waiters;
                    q10.next = waitNode;
                    queued = (boolean) varHandle.weakCompareAndSet(this, waitNode, q10);
                } else if (timed) {
                    if (startTime == 0) {
                        startTime = System.nanoTime();
                        if (startTime == 0) {
                            startTime = 1;
                        }
                        elapsed = nanos;
                    } else {
                        long parkNanos = System.nanoTime();
                        long elapsed2 = parkNanos - startTime;
                        if (elapsed2 >= nanos) {
                            removeWaiter(q10);
                            return this.state;
                        }
                        elapsed = nanos - elapsed2;
                    }
                    if (this.state < 1) {
                        Thread r10 = this.runner;
                        if (r10 != null) {
                            LockSupport.parkNanos(this, elapsed, r10.getNativeTidFutex());
                        } else {
                            LockSupport.parkNanos(this, elapsed);
                        }
                    }
                } else {
                    Thread r11 = this.runner;
                    if (r11 != null) {
                        LockSupport.park(this, r11.getNativeTidFutex());
                    } else {
                        LockSupport.park(this);
                    }
                }
            }
        }
    }

    private void removeWaiter(WaitNode node) {
        if (node != null) {
            node.thread = null;
            while (true) {
                WaitNode pred = null;
                WaitNode q10 = this.waiters;
                while (q10 != null) {
                    WaitNode s2 = q10.next;
                    if (q10.thread != null) {
                        pred = q10;
                    } else if (pred != null) {
                        pred.next = s2;
                        if (pred.thread == null) {
                            break;
                        }
                    } else if (!(boolean) WAITERS.compareAndSet(this, q10, s2)) {
                        break;
                    }
                    q10 = s2;
                }
                return;
            }
        }
    }

    public String toString() {
        String status;
        switch (this.state) {
            case 2:
                status = "[Completed normally]";
                break;
            case 3:
                status = "[Completed exceptionally: " + this.outcome + "]";
                break;
            case 4:
            case 5:
            case 6:
                status = "[Cancelled]";
                break;
            default:
                status = "[Not completed]";
                break;
        }
        return super.toString() + status;
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            STATE = l10.findVarHandle(FutureTask.class, "state", Integer.TYPE);
            RUNNER = l10.findVarHandle(FutureTask.class, "runner", Thread.class);
            WAITERS = l10.findVarHandle(FutureTask.class, "waiters", WaitNode.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
