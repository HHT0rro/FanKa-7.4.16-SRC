package java.util.concurrent;

import dalvik.annotation.optimization.ReachabilitySensitive;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ThreadPoolExecutor extends AbstractExecutorService {
    private static final int COUNT_BITS = 29;
    private static final int COUNT_MASK = 536870911;
    private static final boolean ONLY_ONE = true;
    private static final int RUNNING = -536870912;
    private static final int SHUTDOWN = 0;
    private static final int STOP = 536870912;
    private static final int TERMINATED = 1610612736;
    private static final int TIDYING = 1073741824;
    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
    private static final RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");
    private volatile boolean allowCoreThreadTimeOut;
    private long completedTaskCount;
    private volatile int corePoolSize;

    @ReachabilitySensitive
    private final AtomicInteger ctl;
    private volatile RejectedExecutionHandler handler;
    private volatile long keepAliveTime;
    private int largestPoolSize;
    private final ReentrantLock mainLock;
    private volatile int maximumPoolSize;
    private final Condition termination;
    private volatile ThreadFactory threadFactory;
    private final BlockingQueue<Runnable> workQueue;

    @ReachabilitySensitive
    private final HashSet<Worker> workers;

    private static int runStateOf(int c4) {
        return RUNNING & c4;
    }

    private static int workerCountOf(int c4) {
        return COUNT_MASK & c4;
    }

    private static int ctlOf(int rs, int wc2) {
        return rs | wc2;
    }

    private static boolean runStateLessThan(int c4, int s2) {
        return c4 < s2;
    }

    private static boolean runStateAtLeast(int c4, int s2) {
        return c4 >= s2;
    }

    private static boolean isRunning(int c4) {
        return c4 < 0;
    }

    private boolean compareAndIncrementWorkerCount(int expect) {
        return this.ctl.compareAndSet(expect, expect + 1);
    }

    private boolean compareAndDecrementWorkerCount(int expect) {
        return this.ctl.compareAndSet(expect, expect - 1);
    }

    private void decrementWorkerCount() {
        this.ctl.addAndGet(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        private static final long serialVersionUID = 6138294804551838833L;
        volatile long completedTasks;
        Runnable firstTask;
        final Thread thread;

        Worker(Runnable firstTask) {
            setState(-1);
            this.firstTask = firstTask;
            this.thread = ThreadPoolExecutor.this.getThreadFactory().newThread(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            ThreadPoolExecutor.this.runWorker(this);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean isHeldExclusively() {
            return getState() != 0;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryAcquire(int unused) {
            if (!compareAndSetState(0, 1)) {
                return false;
            }
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryRelease(int unused) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public void lock() {
            acquire(1);
        }

        public boolean tryLock() {
            return tryAcquire(1);
        }

        public void unlock() {
            release(1);
        }

        public boolean isLocked() {
            return isHeldExclusively();
        }

        void interruptIfStarted() {
            Thread t2;
            if (getState() >= 0 && (t2 = this.thread) != null && !t2.isInterrupted()) {
                try {
                    t2.interrupt();
                } catch (SecurityException e2) {
                }
            }
        }
    }

    private void advanceRunState(int targetState) {
        int c4;
        do {
            c4 = this.ctl.get();
            if (runStateAtLeast(c4, targetState)) {
                return;
            }
        } while (!this.ctl.compareAndSet(c4, ctlOf(targetState, workerCountOf(c4))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void tryTerminate() {
        while (true) {
            int c4 = this.ctl.get();
            if (!isRunning(c4) && !runStateAtLeast(c4, 1073741824)) {
                if (runStateLessThan(c4, 536870912) && !this.workQueue.isEmpty()) {
                    return;
                }
                if (workerCountOf(c4) != 0) {
                    interruptIdleWorkers(true);
                    return;
                }
                ReentrantLock mainLock = this.mainLock;
                mainLock.lock();
                try {
                    if (this.ctl.compareAndSet(c4, ctlOf(1073741824, 0))) {
                        try {
                            terminated();
                            return;
                        } finally {
                            this.ctl.set(ctlOf(TERMINATED, 0));
                            this.termination.signalAll();
                        }
                    }
                } finally {
                    mainLock.unlock();
                }
            } else {
                return;
            }
        }
    }

    private void checkShutdownAccess() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(shutdownPerm);
            Iterator<Worker> iterator2 = this.workers.iterator2();
            while (iterator2.hasNext()) {
                Worker w3 = iterator2.next();
                security.checkAccess(w3.thread);
            }
        }
    }

    private void interruptWorkers() {
        Iterator<Worker> iterator2 = this.workers.iterator2();
        while (iterator2.hasNext()) {
            Worker w3 = iterator2.next();
            w3.interruptIfStarted();
        }
    }

    private void interruptIdleWorkers(boolean onlyOne) {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            Iterator<Worker> iterator2 = this.workers.iterator2();
            while (iterator2.hasNext()) {
                Worker w3 = iterator2.next();
                Thread t2 = w3.thread;
                if (!t2.isInterrupted() && w3.tryLock()) {
                    try {
                        t2.interrupt();
                    } catch (SecurityException e2) {
                    } catch (Throwable th) {
                        w3.unlock();
                        throw th;
                    }
                    w3.unlock();
                }
                if (onlyOne) {
                    break;
                }
            }
        } finally {
            mainLock.unlock();
        }
    }

    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void reject(Runnable command) {
        this.handler.rejectedExecution(command, this);
    }

    void onShutdown() {
    }

    private List<Runnable> drainQueue() {
        BlockingQueue<Runnable> q10 = this.workQueue;
        ArrayList<Runnable> taskList = new ArrayList<>();
        q10.drainTo(taskList);
        if (!q10.isEmpty()) {
            for (Runnable r10 : (Runnable[]) q10.toArray(new Runnable[0])) {
                if (q10.remove(r10)) {
                    taskList.add(r10);
                }
            }
        }
        return taskList;
    }

    private boolean addWorker(Runnable firstTask, boolean core) {
        int c4 = this.ctl.get();
        while (true) {
            if (!runStateAtLeast(c4, 0) || (!runStateAtLeast(c4, 536870912) && firstTask == null && !this.workQueue.isEmpty())) {
                do {
                    if (workerCountOf(c4) >= ((core ? this.corePoolSize : this.maximumPoolSize) & COUNT_MASK)) {
                        return false;
                    }
                    if (!compareAndIncrementWorkerCount(c4)) {
                        c4 = this.ctl.get();
                    } else {
                        boolean workerStarted = false;
                        boolean workerAdded = false;
                        Worker w3 = null;
                        try {
                            w3 = new Worker(firstTask);
                            Thread t2 = w3.thread;
                            if (t2 != null) {
                                ReentrantLock mainLock = this.mainLock;
                                mainLock.lock();
                                try {
                                    int c10 = this.ctl.get();
                                    if (isRunning(c10) || (runStateLessThan(c10, 536870912) && firstTask == null)) {
                                        if (t2.getState() != Thread.State.NEW) {
                                            throw new IllegalThreadStateException();
                                        }
                                        this.workers.add(w3);
                                        workerAdded = true;
                                        int s2 = this.workers.size();
                                        if (s2 > this.largestPoolSize) {
                                            this.largestPoolSize = s2;
                                        }
                                    }
                                    if (workerAdded) {
                                        t2.start();
                                        workerStarted = true;
                                    }
                                } finally {
                                    mainLock.unlock();
                                }
                            }
                            return workerStarted;
                        } finally {
                            if (0 == 0) {
                                addWorkerFailed(w3);
                            }
                        }
                    }
                } while (!runStateAtLeast(c4, 0));
            }
        }
        return false;
    }

    private void addWorkerFailed(Worker w3) {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        if (w3 != null) {
            try {
                this.workers.remove(w3);
            } finally {
                mainLock.unlock();
            }
        }
        decrementWorkerCount();
        tryTerminate();
    }

    private void processWorkerExit(Worker w3, boolean completedAbruptly) {
        if (completedAbruptly) {
            decrementWorkerCount();
        }
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            this.completedTaskCount += w3.completedTasks;
            this.workers.remove(w3);
            mainLock.unlock();
            tryTerminate();
            int c4 = this.ctl.get();
            if (runStateLessThan(c4, 536870912)) {
                if (!completedAbruptly) {
                    int min = this.allowCoreThreadTimeOut ? 0 : this.corePoolSize;
                    if (min == 0 && !this.workQueue.isEmpty()) {
                        min = 1;
                    }
                    if (workerCountOf(c4) >= min) {
                        return;
                    }
                }
                addWorker(null, false);
            }
        } catch (Throwable th) {
            mainLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r4 = r8.workQueue.poll(r8.keepAliveTime, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        decrementWorkerCount();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Runnable getTask() {
        /*
            r8 = this;
            r0 = 0
        L1:
            java.util.concurrent.atomic.AtomicInteger r1 = r8.ctl
            int r1 = r1.get()
            r2 = 0
            boolean r3 = runStateAtLeast(r1, r2)
            r4 = 0
            if (r3 == 0) goto L23
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            boolean r3 = runStateAtLeast(r1, r3)
            if (r3 != 0) goto L1f
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r3 = r8.workQueue
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L23
        L1f:
            r8.decrementWorkerCount()
            return r4
        L23:
            int r3 = workerCountOf(r1)
            boolean r5 = r8.allowCoreThreadTimeOut
            r6 = 1
            if (r5 != 0) goto L30
            int r5 = r8.corePoolSize
            if (r3 <= r5) goto L31
        L30:
            r2 = r6
        L31:
            int r5 = r8.maximumPoolSize
            if (r3 > r5) goto L39
            if (r2 == 0) goto L44
            if (r0 == 0) goto L44
        L39:
            if (r3 > r6) goto L64
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r5 = r8.workQueue
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L44
            goto L64
        L44:
            if (r2 == 0) goto L53
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r4 = r8.workQueue     // Catch: java.lang.InterruptedException -> L61
            long r5 = r8.keepAliveTime     // Catch: java.lang.InterruptedException -> L61
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.InterruptedException -> L61
            java.lang.Object r4 = r4.poll(r5, r7)     // Catch: java.lang.InterruptedException -> L61
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.InterruptedException -> L61
            goto L5b
        L53:
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r4 = r8.workQueue     // Catch: java.lang.InterruptedException -> L61
            java.lang.Object r4 = r4.take()     // Catch: java.lang.InterruptedException -> L61
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.InterruptedException -> L61
        L5b:
            if (r4 == 0) goto L5f
            return r4
        L5f:
            r0 = 1
            goto L63
        L61:
            r4 = move-exception
            r0 = 0
        L63:
            goto L1
        L64:
            boolean r5 = r8.compareAndDecrementWorkerCount(r1)
            if (r5 == 0) goto L1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ThreadPoolExecutor.getTask():java.lang.Runnable");
    }

    /* JADX WARN: Finally extract failed */
    final void runWorker(Worker w3) {
        Thread wt = Thread.currentThread();
        Runnable task = w3.firstTask;
        w3.firstTask = null;
        w3.unlock();
        boolean completedAbruptly = true;
        while (true) {
            if (task == null) {
                try {
                    Runnable task2 = getTask();
                    task = task2;
                    if (task2 == null) {
                        completedAbruptly = false;
                        return;
                    }
                } finally {
                    processWorkerExit(w3, completedAbruptly);
                }
            }
            w3.lock();
            if ((runStateAtLeast(this.ctl.get(), 536870912) || (Thread.interrupted() && runStateAtLeast(this.ctl.get(), 536870912))) && !wt.isInterrupted()) {
                wt.interrupt();
            }
            try {
                beforeExecute(wt, task);
                try {
                    task.run();
                    afterExecute(task, null);
                    task = null;
                    w3.completedTasks++;
                    w3.unlock();
                } finally {
                }
            } catch (Throwable ex) {
                w3.completedTasks++;
                w3.unlock();
                throw ex;
            }
        }
    }

    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(), defaultHandler);
    }

    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, defaultHandler);
    }

    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(), handler);
    }

    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        this.ctl = new AtomicInteger(ctlOf(RUNNING, 0));
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mainLock = reentrantLock;
        this.workers = new HashSet<>();
        this.termination = reentrantLock.newCondition();
        if (corePoolSize < 0 || maximumPoolSize <= 0 || maximumPoolSize < corePoolSize || keepAliveTime < 0) {
            throw new IllegalArgumentException();
        }
        if (workQueue == null || threadFactory == null || handler == null) {
            throw new NullPointerException();
        }
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }
        int c4 = this.ctl.get();
        if (workerCountOf(c4) < this.corePoolSize) {
            if (addWorker(command, true)) {
                return;
            } else {
                c4 = this.ctl.get();
            }
        }
        if (isRunning(c4) && this.workQueue.offer(command)) {
            int recheck = this.ctl.get();
            if (!isRunning(recheck) && remove(command)) {
                reject(command);
                return;
            } else {
                if (workerCountOf(recheck) == 0) {
                    addWorker(null, false);
                    return;
                }
                return;
            }
        }
        if (!addWorker(command, false)) {
            reject(command);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            checkShutdownAccess();
            advanceRunState(0);
            interruptIdleWorkers();
            onShutdown();
            mainLock.unlock();
            tryTerminate();
        } catch (Throwable th) {
            mainLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            checkShutdownAccess();
            advanceRunState(536870912);
            interruptWorkers();
            List<Runnable> tasks = drainQueue();
            mainLock.unlock();
            tryTerminate();
            return tasks;
        } catch (Throwable th) {
            mainLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return runStateAtLeast(this.ctl.get(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStopped() {
        return runStateAtLeast(this.ctl.get(), 536870912);
    }

    public boolean isTerminating() {
        int c4 = this.ctl.get();
        return runStateAtLeast(c4, 0) && runStateLessThan(c4, TERMINATED);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return runStateAtLeast(this.ctl.get(), TERMINATED);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        while (runStateLessThan(this.ctl.get(), TERMINATED)) {
            try {
                if (nanos > 0) {
                    nanos = this.termination.awaitNanos(nanos);
                } else {
                    mainLock.unlock();
                    return false;
                }
            } catch (Throwable th) {
                mainLock.unlock();
                throw th;
            }
        }
        mainLock.unlock();
        return true;
    }

    @Deprecated(since = "9")
    protected void finalize() {
    }

    public void setThreadFactory(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException();
        }
        this.threadFactory = threadFactory;
    }

    public ThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    public void setRejectedExecutionHandler(RejectedExecutionHandler handler) {
        if (handler == null) {
            throw new NullPointerException();
        }
        this.handler = handler;
    }

    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.handler;
    }

    public void setCorePoolSize(int corePoolSize) {
        if (corePoolSize < 0) {
            throw new IllegalArgumentException();
        }
        int delta = corePoolSize - this.corePoolSize;
        this.corePoolSize = corePoolSize;
        if (workerCountOf(this.ctl.get()) > corePoolSize) {
            interruptIdleWorkers();
            return;
        }
        if (delta > 0) {
            int k10 = Math.min(delta, this.workQueue.size());
            while (true) {
                int k11 = k10 - 1;
                if (k10 > 0 && addWorker(null, true) && !this.workQueue.isEmpty()) {
                    k10 = k11;
                } else {
                    return;
                }
            }
        }
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public boolean prestartCoreThread() {
        return workerCountOf(this.ctl.get()) < this.corePoolSize && addWorker(null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensurePrestart() {
        int wc2 = workerCountOf(this.ctl.get());
        if (wc2 < this.corePoolSize) {
            addWorker(null, true);
        } else if (wc2 == 0) {
            addWorker(null, false);
        }
    }

    public int prestartAllCoreThreads() {
        int n10 = 0;
        while (addWorker(null, true)) {
            n10++;
        }
        return n10;
    }

    public boolean allowsCoreThreadTimeOut() {
        return this.allowCoreThreadTimeOut;
    }

    public void allowCoreThreadTimeOut(boolean value) {
        if (value && this.keepAliveTime <= 0) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        if (value != this.allowCoreThreadTimeOut) {
            this.allowCoreThreadTimeOut = value;
            if (value) {
                interruptIdleWorkers();
            }
        }
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        if (maximumPoolSize <= 0 || maximumPoolSize < this.corePoolSize) {
            throw new IllegalArgumentException();
        }
        this.maximumPoolSize = maximumPoolSize;
        if (workerCountOf(this.ctl.get()) > maximumPoolSize) {
            interruptIdleWorkers();
        }
    }

    public int getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    public void setKeepAliveTime(long time, TimeUnit unit) {
        if (time < 0) {
            throw new IllegalArgumentException();
        }
        if (time == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        long keepAliveTime = unit.toNanos(time);
        long delta = keepAliveTime - this.keepAliveTime;
        this.keepAliveTime = keepAliveTime;
        if (delta < 0) {
            interruptIdleWorkers();
        }
    }

    public long getKeepAliveTime(TimeUnit unit) {
        return unit.convert(this.keepAliveTime, TimeUnit.NANOSECONDS);
    }

    public BlockingQueue<Runnable> getQueue() {
        return this.workQueue;
    }

    public boolean remove(Runnable task) {
        boolean removed = this.workQueue.remove(task);
        tryTerminate();
        return removed;
    }

    public void purge() {
        BlockingQueue<Runnable> q10 = this.workQueue;
        try {
            Iterator<Runnable> it = q10.iterator2();
            while (it.hasNext()) {
                Runnable r10 = it.next();
                if ((r10 instanceof Future) && ((Future) r10).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException e2) {
            for (Object r11 : q10.toArray()) {
                if ((r11 instanceof Future) && ((Future) r11).isCancelled()) {
                    q10.remove(r11);
                }
            }
        }
        tryTerminate();
    }

    public int getPoolSize() {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            return runStateAtLeast(this.ctl.get(), 1073741824) ? 0 : this.workers.size();
        } finally {
            mainLock.unlock();
        }
    }

    public int getActiveCount() {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        int n10 = 0;
        try {
            Iterator<Worker> iterator2 = this.workers.iterator2();
            while (iterator2.hasNext()) {
                Worker w3 = iterator2.next();
                if (w3.isLocked()) {
                    n10++;
                }
            }
            return n10;
        } finally {
            mainLock.unlock();
        }
    }

    public int getLargestPoolSize() {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            return this.largestPoolSize;
        } finally {
            mainLock.unlock();
        }
    }

    public long getTaskCount() {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            long n10 = this.completedTaskCount;
            Iterator<Worker> iterator2 = this.workers.iterator2();
            while (iterator2.hasNext()) {
                Worker w3 = iterator2.next();
                n10 += w3.completedTasks;
                if (w3.isLocked()) {
                    n10++;
                }
            }
            return this.workQueue.size() + n10;
        } finally {
            mainLock.unlock();
        }
    }

    public long getCompletedTaskCount() {
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            long n10 = this.completedTaskCount;
            Iterator<Worker> iterator2 = this.workers.iterator2();
            while (iterator2.hasNext()) {
                Worker w3 = iterator2.next();
                n10 += w3.completedTasks;
            }
            return n10;
        } finally {
            mainLock.unlock();
        }
    }

    public String toString() {
        String runState;
        ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            long ncompleted = this.completedTaskCount;
            int nactive = 0;
            int nworkers = this.workers.size();
            Iterator<Worker> iterator2 = this.workers.iterator2();
            while (iterator2.hasNext()) {
                Worker w3 = iterator2.next();
                ncompleted += w3.completedTasks;
                if (w3.isLocked()) {
                    nactive++;
                }
            }
            mainLock.unlock();
            int c4 = this.ctl.get();
            if (isRunning(c4)) {
                runState = "Running";
            } else {
                runState = runStateAtLeast(c4, TERMINATED) ? "Terminated" : "Shutting down";
            }
            return super.toString() + "[" + runState + ", pool size = " + nworkers + ", active threads = " + nactive + ", queued tasks = " + this.workQueue.size() + ", completed tasks = " + ncompleted + "]";
        } catch (Throwable th) {
            mainLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beforeExecute(Thread t2, Runnable r10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterExecute(Runnable r10, Throwable t2) {
    }

    protected void terminated() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CallerRunsPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r10, ThreadPoolExecutor e2) {
            if (!e2.isShutdown()) {
                r10.run();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class AbortPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r10, ThreadPoolExecutor e2) {
            throw new RejectedExecutionException("Task " + r10.toString() + " rejected from " + e2.toString());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DiscardPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r10, ThreadPoolExecutor e2) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r10, ThreadPoolExecutor e2) {
            if (!e2.isShutdown()) {
                e2.getQueue().poll();
                e2.execute(r10);
            }
        }
    }
}
