package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Thread;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.LockSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ForkJoinTask<V> implements Future<V>, Serializable {
    private static final int ABNORMAL = 65536;
    private static final VarHandle AUX;
    private static final int DONE = Integer.MIN_VALUE;
    private static final int SMASK = 65535;
    private static final VarHandle STATUS;
    private static final int THROWN = 131072;
    private static final int UNCOMPENSATE = 65536;
    private static final long serialVersionUID = -7721805057305804111L;
    private volatile transient Aux aux;
    volatile int status;

    protected abstract boolean exec();

    public abstract V getRawResult();

    protected abstract void setRawResult(V v2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Aux {
        private static final VarHandle NEXT;
        final Throwable ex;
        Aux next;
        final Thread thread;

        Aux(Thread thread, Throwable ex) {
            this.thread = thread;
            this.ex = ex;
        }

        final boolean casNext(Aux c4, Aux v2) {
            return (boolean) NEXT.compareAndSet(this, c4, v2);
        }

        static {
            try {
                NEXT = MethodHandles.lookup().findVarHandle(Aux.class, "next", Aux.class);
            } catch (ReflectiveOperationException e2) {
                throw new ExceptionInInitializerError(e2);
            }
        }
    }

    private int getAndBitwiseOrStatus(int v2) {
        return (int) STATUS.getAndBitwiseOr(this, v2);
    }

    private boolean casStatus(int c4, int v2) {
        return (boolean) STATUS.compareAndSet(this, c4, v2);
    }

    private boolean casAux(Aux c4, Aux v2) {
        return (boolean) AUX.compareAndSet(this, c4, v2);
    }

    private void signalWaiters() {
        Aux a10;
        do {
            Aux aux = this.aux;
            a10 = aux;
            if (aux == null || a10.ex != null) {
                return;
            }
        } while (!casAux(a10, null));
        while (a10 != null) {
            Thread t2 = a10.thread;
            if (t2 != Thread.currentThread() && t2 != null) {
                LockSupport.unpark(t2);
            }
            a10 = a10.next;
        }
    }

    private int setDone() {
        int s2 = Integer.MIN_VALUE | getAndBitwiseOrStatus(Integer.MIN_VALUE);
        signalWaiters();
        return s2;
    }

    private int trySetCancelled() {
        int s2;
        while (true) {
            int i10 = this.status;
            s2 = i10;
            if (i10 < 0) {
                break;
            }
            int s10 = (-2147418112) | s2;
            if (casStatus(s2, s10)) {
                s2 = s10;
                break;
            }
        }
        signalWaiters();
        return s2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int trySetThrown(Throwable ex) {
        int s2;
        Aux a10;
        Aux h10 = new Aux(Thread.currentThread(), ex);
        Aux p10 = null;
        boolean installed = false;
        while (true) {
            int i10 = this.status;
            s2 = i10;
            if (i10 < 0) {
                break;
            }
            if (!installed && ((a10 = this.aux) == null || a10.ex == null)) {
                boolean casAux = casAux(a10, h10);
                installed = casAux;
                if (casAux) {
                    p10 = a10;
                }
            }
            if (installed) {
                int s10 = (-2147287040) | s2;
                if (casStatus(s2, s10)) {
                    s2 = s10;
                    break;
                }
            }
        }
        while (p10 != null) {
            LockSupport.unpark(p10.thread);
            p10 = p10.next;
        }
        return s2;
    }

    int trySetException(Throwable ex) {
        return trySetThrown(ex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isExceptionalStatus(int s2) {
        return (131072 & s2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int doExec() {
        boolean completed;
        int i10 = this.status;
        int s2 = i10;
        if (i10 >= 0) {
            try {
                completed = exec();
            } catch (Throwable rex) {
                s2 = trySetException(rex);
                completed = false;
            }
            if (completed) {
                return setDone();
            }
            return s2;
        }
        return s2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x017c, code lost:
    
        if (r0 == null) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0186, code lost:
    
        if (casAux(r2, r13) == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x017e, code lost:
    
        r0.casNext(r0, r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int awaitDone(java.util.concurrent.ForkJoinPool r27, boolean r28, boolean r29, boolean r30, long r31) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinTask.awaitDone(java.util.concurrent.ForkJoinPool, boolean, boolean, boolean, long):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void cancelIgnoringExceptions(Future<?> t2) {
        if (t2 != null) {
            try {
                t2.cancel(true);
            } catch (Throwable th) {
            }
        }
    }

    private Throwable getThrowableException() {
        Aux a10 = this.aux;
        if (a10 == null) {
            return null;
        }
        Throwable ex = a10.ex;
        if (ex != null && a10.thread != Thread.currentThread()) {
            Constructor<?> noArgCtor = null;
            Constructor<?> oneArgCtor = null;
            try {
                Constructor<?>[] constructors = ex.getClass().getConstructors();
                int length = constructors.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    Constructor<?> c4 = constructors[i10];
                    Class<?>[] ps = c4.getParameterTypes();
                    if (ps.length == 0) {
                        noArgCtor = c4;
                    } else if (ps.length == 1 && ps[0] == Throwable.class) {
                        oneArgCtor = c4;
                        break;
                    }
                    i10++;
                }
                if (oneArgCtor != null) {
                    return (Throwable) oneArgCtor.newInstance(ex);
                }
                if (noArgCtor == null) {
                    return ex;
                }
                Throwable rx = (Throwable) noArgCtor.newInstance(new Object[0]);
                rx.initCause(ex);
                return rx;
            } catch (Exception e2) {
            }
        }
        return ex;
    }

    private Throwable getException(int s2) {
        Throwable ex;
        if ((65536 & s2) != 0) {
            return ((131072 & s2) == 0 || (ex = getThrowableException()) == null) ? new CancellationException() : ex;
        }
        return null;
    }

    private void reportException(int s2) {
        uncheckedThrow((131072 & s2) != 0 ? getThrowableException() : null);
    }

    private void reportExecutionException(int s2) {
        Throwable ex = null;
        if (s2 == 65536) {
            ex = new InterruptedException();
        } else if (s2 >= 0) {
            ex = new TimeoutException();
        } else if ((131072 & s2) != 0) {
            Throwable throwableException = getThrowableException();
            ex = throwableException;
            if (throwableException != null) {
                ex = new ExecutionException(ex);
            }
        }
        uncheckedThrow(ex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void rethrow(Throwable ex) {
        uncheckedThrow(ex);
    }

    static <T extends Throwable> void uncheckedThrow(Throwable t2) throws Throwable {
        if (t2 == null) {
            throw new CancellationException();
        }
    }

    public final ForkJoinTask<V> fork() {
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread w3 = (ForkJoinWorkerThread) t2;
            w3.workQueue.push(this, w3.pool);
        } else {
            ForkJoinPool.common.externalPush(this);
        }
        return this;
    }

    public final V join() {
        int i10 = this.status;
        int s2 = i10;
        if (i10 >= 0) {
            s2 = awaitDone(null, false, false, false, 0L);
        }
        if ((65536 & s2) != 0) {
            reportException(s2);
        }
        return getRawResult();
    }

    public final V invoke() {
        int doExec = doExec();
        int s2 = doExec;
        if (doExec >= 0) {
            s2 = awaitDone(null, true, false, false, 0L);
        }
        if ((65536 & s2) != 0) {
            reportException(s2);
        }
        return getRawResult();
    }

    public static void invokeAll(ForkJoinTask<?> t12, ForkJoinTask<?> t2) {
        if (t12 == null || t2 == null) {
            throw new NullPointerException();
        }
        t2.fork();
        int doExec = t12.doExec();
        int s12 = doExec;
        if (doExec >= 0) {
            s12 = t12.awaitDone(null, true, false, false, 0L);
        }
        if ((s12 & 65536) != 0) {
            cancelIgnoringExceptions(t2);
            t12.reportException(s12);
        } else {
            int s2 = t2.awaitDone(null, false, false, false, 0L);
            if ((65536 & s2) != 0) {
                t2.reportException(s2);
            }
        }
    }

    public static void invokeAll(ForkJoinTask<?>... tasks) {
        Throwable ex = null;
        int last = tasks.length - 1;
        int i10 = last;
        while (true) {
            if (i10 < 0) {
                break;
            }
            ForkJoinTask<?> t2 = tasks[i10];
            if (t2 == null) {
                ex = new NullPointerException();
                break;
            }
            if (i10 == 0) {
                int doExec = t2.doExec();
                int s2 = doExec;
                if (doExec >= 0) {
                    s2 = t2.awaitDone(null, true, false, false, 0L);
                }
                if ((s2 & 65536) != 0) {
                    ex = t2.getException(s2);
                }
            } else {
                t2.fork();
                i10--;
            }
        }
        if (ex == null) {
            for (int i11 = 1; i11 <= last; i11++) {
                ForkJoinTask<?> t10 = tasks[i11];
                if (t10 != null) {
                    int i12 = t10.status;
                    int s10 = i12;
                    if (i12 >= 0) {
                        s10 = t10.awaitDone(null, false, false, false, 0L);
                    }
                    if ((s10 & 65536) != 0) {
                        Throwable exception = t10.getException(s10);
                        ex = exception;
                        if (exception != null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (ex != null) {
            for (int i13 = 1; i13 <= last; i13++) {
                cancelIgnoringExceptions(tasks[i13]);
            }
            rethrow(ex);
        }
    }

    public static <T extends ForkJoinTask<?>> Collection<T> invokeAll(Collection<T> tasks) {
        if (!(tasks instanceof RandomAccess) || !(tasks instanceof List)) {
            invokeAll((ForkJoinTask<?>[]) tasks.toArray(new ForkJoinTask[0]));
            return tasks;
        }
        List<? extends ForkJoinTask<?>> ts = (List) tasks;
        Throwable ex = null;
        int last = ts.size() - 1;
        int i10 = last;
        while (true) {
            if (i10 < 0) {
                break;
            }
            ForkJoinTask<?> t2 = ts.get(i10);
            if (t2 == null) {
                ex = new NullPointerException();
                break;
            }
            if (i10 == 0) {
                int doExec = t2.doExec();
                int s2 = doExec;
                if (doExec >= 0) {
                    s2 = t2.awaitDone(null, true, false, false, 0L);
                }
                if ((s2 & 65536) != 0) {
                    ex = t2.getException(s2);
                }
            } else {
                t2.fork();
                i10--;
            }
        }
        if (ex == null) {
            for (int i11 = 1; i11 <= last; i11++) {
                ForkJoinTask<?> t10 = ts.get(i11);
                if (t10 != null) {
                    int i12 = t10.status;
                    int s10 = i12;
                    if (i12 >= 0) {
                        s10 = t10.awaitDone(null, false, false, false, 0L);
                    }
                    if ((s10 & 65536) != 0) {
                        Throwable exception = t10.getException(s10);
                        ex = exception;
                        if (exception != null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (ex != null) {
            for (int i13 = 1; i13 <= last; i13++) {
                cancelIgnoringExceptions((Future) ts.get(i13));
            }
            rethrow(ex);
        }
        return tasks;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return (trySetCancelled() & 196608) == 65536;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.status < 0;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return (this.status & 196608) == 65536;
    }

    public final boolean isCompletedAbnormally() {
        return (this.status & 65536) != 0;
    }

    public final boolean isCompletedNormally() {
        return (this.status & (-2147418112)) == Integer.MIN_VALUE;
    }

    public final Throwable getException() {
        return getException(this.status);
    }

    public void completeExceptionally(Throwable ex) {
        Throwable th;
        if ((ex instanceof RuntimeException) || (ex instanceof Error)) {
            th = ex;
        } else {
            th = new RuntimeException(ex);
        }
        trySetException(th);
    }

    public void complete(V value) {
        try {
            setRawResult(value);
            setDone();
        } catch (Throwable rex) {
            trySetException(rex);
        }
    }

    public final void quietlyComplete() {
        setDone();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        int s2 = awaitDone(null, false, true, false, 0L);
        if ((65536 & s2) != 0) {
            reportExecutionException(s2);
        }
        return getRawResult();
    }

    @Override // java.util.concurrent.Future
    public final V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        long nanos = unit.toNanos(timeout);
        int s2 = awaitDone(null, false, true, true, nanos);
        if (s2 >= 0 || (65536 & s2) != 0) {
            reportExecutionException(s2);
        }
        return getRawResult();
    }

    public final void quietlyJoin() {
        if (this.status >= 0) {
            awaitDone(null, false, false, false, 0L);
        }
    }

    public final void quietlyInvoke() {
        if (doExec() >= 0) {
            awaitDone(null, true, false, false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void awaitPoolInvoke(ForkJoinPool pool) {
        awaitDone(pool, false, false, false, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void awaitPoolInvoke(ForkJoinPool pool, long nanos) {
        awaitDone(pool, false, true, true, nanos);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final V joinForPoolInvoke(ForkJoinPool pool) {
        int s2 = awaitDone(pool, false, false, false, 0L);
        if ((65536 & s2) != 0) {
            reportException(s2);
        }
        return getRawResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final V getForPoolInvoke(ForkJoinPool pool) throws InterruptedException, ExecutionException {
        int s2 = awaitDone(pool, false, true, false, 0L);
        if ((65536 & s2) != 0) {
            reportExecutionException(s2);
        }
        return getRawResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final V getForPoolInvoke(ForkJoinPool pool, long nanos) throws InterruptedException, ExecutionException, TimeoutException {
        int s2 = awaitDone(pool, false, true, true, nanos);
        if (s2 >= 0 || (65536 & s2) != 0) {
            reportExecutionException(s2);
        }
        return getRawResult();
    }

    public static void helpQuiesce() {
        ForkJoinWorkerThread w3;
        ForkJoinPool p10;
        Thread t2 = Thread.currentThread();
        if ((t2 instanceof ForkJoinWorkerThread) && (p10 = (w3 = (ForkJoinWorkerThread) t2).pool) != null) {
            p10.helpQuiescePool(w3.workQueue, Long.MAX_VALUE, false);
        } else {
            ForkJoinPool.common.externalHelpQuiescePool(Long.MAX_VALUE, false);
        }
    }

    public void reinitialize() {
        this.aux = null;
        this.status = 0;
    }

    public static ForkJoinPool getPool() {
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) t2).pool;
        }
        return null;
    }

    public static boolean inForkJoinPool() {
        return Thread.currentThread() instanceof ForkJoinWorkerThread;
    }

    public boolean tryUnfork() {
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            ForkJoinPool.WorkQueue q10 = ((ForkJoinWorkerThread) t2).workQueue;
            return q10 != null && q10.tryUnpush(this);
        }
        ForkJoinPool.WorkQueue q11 = ForkJoinPool.commonQueue();
        return q11 != null && q11.externalTryUnpush(this);
    }

    public static int getQueuedTaskCount() {
        ForkJoinPool.WorkQueue q10;
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            q10 = ((ForkJoinWorkerThread) t2).workQueue;
        } else {
            q10 = ForkJoinPool.commonQueue();
        }
        if (q10 == null) {
            return 0;
        }
        return q10.queueSize();
    }

    public static int getSurplusQueuedTaskCount() {
        return ForkJoinPool.getSurplusQueuedTaskCount();
    }

    protected static ForkJoinTask<?> peekNextLocalTask() {
        ForkJoinPool.WorkQueue q10;
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            q10 = ((ForkJoinWorkerThread) t2).workQueue;
        } else {
            q10 = ForkJoinPool.commonQueue();
        }
        if (q10 == null) {
            return null;
        }
        return q10.peek();
    }

    protected static ForkJoinTask<?> pollNextLocalTask() {
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) t2).workQueue.nextLocalTask();
        }
        return null;
    }

    protected static ForkJoinTask<?> pollTask() {
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread w3 = (ForkJoinWorkerThread) t2;
            return w3.pool.nextTaskFor(w3.workQueue);
        }
        return null;
    }

    protected static ForkJoinTask<?> pollSubmission() {
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) t2).pool.pollSubmission();
        }
        return null;
    }

    public final short getForkJoinTaskTag() {
        return (short) this.status;
    }

    public final short setForkJoinTaskTag(short newValue) {
        int s2;
        do {
            s2 = this.status;
        } while (!casStatus(s2, ((-65536) & s2) | (65535 & newValue)));
        return (short) s2;
    }

    public final boolean compareAndSetForkJoinTaskTag(short expect, short update) {
        int s2;
        do {
            s2 = this.status;
            if (((short) s2) != expect) {
                return false;
            }
        } while (!casStatus(s2, ((-65536) & s2) | (65535 & update)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class AdaptedRunnable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 5232453952276885070L;
        T result;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedRunnable(Runnable runnable, T result) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
            this.result = result;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(T v2) {
            this.result = v2;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + ((Object) this.runnable) + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class AdaptedRunnableAction extends ForkJoinTask<Void> implements RunnableFuture<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedRunnableAction(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void v2) {
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + ((Object) this.runnable) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class RunnableExecuteAction extends ForkJoinTask<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RunnableExecuteAction(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException();
            }
            this.runnable = runnable;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(Void v2) {
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java.util.concurrent.ForkJoinTask
        int trySetException(Throwable ex) {
            Thread t2;
            Thread.UncaughtExceptionHandler h10;
            int s2 = trySetThrown(ex);
            if (isExceptionalStatus(s2) && (h10 = (t2 = Thread.currentThread()).getUncaughtExceptionHandler()) != null) {
                try {
                    h10.uncaughtException(t2, ex);
                } catch (Throwable th) {
                }
            }
            return s2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class AdaptedCallable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 2838392045355241008L;
        final Callable<? extends T> callable;
        T result;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedCallable(Callable<? extends T> callable) {
            if (callable == null) {
                throw new NullPointerException();
            }
            this.callable = callable;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(T v2) {
            this.result = v2;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            try {
                this.result = this.callable.call();
                return true;
            } catch (RuntimeException rex) {
                throw rex;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + ((Object) this.callable) + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class AdaptedInterruptibleCallable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 2838392045355241008L;
        final Callable<? extends T> callable;
        T result;
        volatile transient Thread runner;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedInterruptibleCallable(Callable<? extends T> callable) {
            if (callable == null) {
                throw new NullPointerException();
            }
            this.callable = callable;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(T v2) {
            this.result = v2;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            Thread.interrupted();
            this.runner = Thread.currentThread();
            try {
                try {
                    try {
                        if (!isDone()) {
                            this.result = this.callable.call();
                        }
                        this.runner = null;
                        Thread.interrupted();
                        return true;
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } catch (RuntimeException rex) {
                    throw rex;
                }
            } catch (Throwable th) {
                this.runner = null;
                Thread.interrupted();
                throw th;
            }
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // java.util.concurrent.ForkJoinTask, java.util.concurrent.Future
        public final boolean cancel(boolean mayInterruptIfRunning) {
            Thread t2;
            boolean stat = super.cancel(false);
            if (mayInterruptIfRunning && (t2 = this.runner) != null) {
                try {
                    t2.interrupt();
                } catch (Throwable th) {
                }
            }
            return stat;
        }

        public String toString() {
            return super.toString() + "[Wrapped task = " + ((Object) this.callable) + "]";
        }
    }

    public static ForkJoinTask<?> adapt(Runnable runnable) {
        return new AdaptedRunnableAction(runnable);
    }

    public static <T> ForkJoinTask<T> adapt(Runnable runnable, T result) {
        return new AdaptedRunnable(runnable, result);
    }

    public static <T> ForkJoinTask<T> adapt(Callable<? extends T> callable) {
        return new AdaptedCallable(callable);
    }

    private static <T> ForkJoinTask<T> adaptInterruptible(Callable<? extends T> callable) {
        return new AdaptedInterruptibleCallable(callable);
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        Aux a10 = this.aux;
        s2.writeObject(a10 == null ? null : a10.ex);
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        Object ex = s2.readObject();
        if (ex != null) {
            trySetThrown((Throwable) ex);
        }
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            STATUS = l10.findVarHandle(ForkJoinTask.class, "status", Integer.TYPE);
            AUX = l10.findVarHandle(ForkJoinTask.class, "aux", Aux.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
