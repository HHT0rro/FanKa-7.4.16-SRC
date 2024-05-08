package java.util.concurrent;

import java.lang.Thread;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.ForkJoinPool;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ForkJoinWorkerThread extends Thread {
    final ForkJoinPool pool;
    final ForkJoinPool.WorkQueue workQueue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ForkJoinWorkerThread(ThreadGroup group, ForkJoinPool pool, boolean useSystemClassLoader, boolean isInnocuous) {
        super(group, (Runnable) null, pool.nextWorkerThreadName(), 0L);
        this.pool = pool;
        Thread.UncaughtExceptionHandler handler = pool.ueh;
        this.workQueue = new ForkJoinPool.WorkQueue(this, isInnocuous);
        super.setDaemon(true);
        if (handler != null) {
            super.setUncaughtExceptionHandler(handler);
        }
        if (useSystemClassLoader) {
            super.setContextClassLoader(ClassLoader.getSystemClassLoader());
        }
    }

    ForkJoinWorkerThread(ThreadGroup group, ForkJoinPool pool) {
        this(group, pool, false, false);
    }

    protected ForkJoinWorkerThread(ForkJoinPool pool) {
        this(null, pool, false, false);
    }

    public ForkJoinPool getPool() {
        return this.pool;
    }

    public int getPoolIndex() {
        return this.workQueue.getPoolIndex();
    }

    protected void onStart() {
    }

    protected void onTermination(Throwable exception) {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Throwable exception = null;
        ForkJoinPool p10 = this.pool;
        ForkJoinPool.WorkQueue w3 = this.workQueue;
        if (p10 != null && w3 != null) {
            try {
                p10.registerWorker(w3);
                onStart();
                p10.runWorker(w3);
                try {
                    onTermination(null);
                } catch (Throwable ex) {
                    if (0 == 0) {
                        exception = ex;
                    }
                }
            } catch (Throwable ex2) {
                exception = ex2;
                try {
                    onTermination(exception);
                } catch (Throwable th) {
                }
            }
            p10.deregisterWorker(this, exception);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class InnocuousForkJoinWorkerThread extends ForkJoinWorkerThread {
        private static final ThreadGroup innocuousThreadGroup = (ThreadGroup) AccessController.doPrivileged(new PrivilegedAction<ThreadGroup>() { // from class: java.util.concurrent.ForkJoinWorkerThread.InnocuousForkJoinWorkerThread.1
            @Override // java.security.PrivilegedAction
            public ThreadGroup run() {
                ThreadGroup group = Thread.currentThread().getThreadGroup();
                while (true) {
                    ThreadGroup p10 = group.getParent();
                    if (p10 != null) {
                        group = p10;
                    } else {
                        return new ThreadGroup(group, "InnocuousForkJoinWorkerThreadGroup");
                    }
                }
            }
        });

        /* JADX INFO: Access modifiers changed from: package-private */
        public InnocuousForkJoinWorkerThread(ForkJoinPool pool) {
            super(innocuousThreadGroup, pool, true, true);
        }

        @Override // java.lang.Thread
        public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler x10) {
        }

        @Override // java.lang.Thread
        public void setContextClassLoader(ClassLoader cl) {
            if (cl != null && ClassLoader.getSystemClassLoader() != cl) {
                throw new SecurityException("setContextClassLoader");
            }
        }
    }
}
