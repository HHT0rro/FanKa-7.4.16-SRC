package java.util.concurrent;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService {
    private static final long DEFAULT_KEEPALIVE_MILLIS = 10;
    private static final AtomicLong sequencer = new AtomicLong();
    private volatile boolean continueExistingPeriodicTasksAfterShutdown;
    private volatile boolean executeExistingDelayedTasksAfterShutdown;
    volatile boolean removeOnCancel;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ScheduledFutureTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
        int heapIndex;
        RunnableScheduledFuture<V> outerTask;
        private final long period;
        private final long sequenceNumber;
        private volatile long time;

        ScheduledFutureTask(Runnable r10, V result, long triggerTime, long sequenceNumber) {
            super(r10, result);
            this.outerTask = this;
            this.time = triggerTime;
            this.period = 0L;
            this.sequenceNumber = sequenceNumber;
        }

        ScheduledFutureTask(Runnable r10, V result, long triggerTime, long period, long sequenceNumber) {
            super(r10, result);
            this.outerTask = this;
            this.time = triggerTime;
            this.period = period;
            this.sequenceNumber = sequenceNumber;
        }

        ScheduledFutureTask(Callable<V> callable, long triggerTime, long sequenceNumber) {
            super(callable);
            this.outerTask = this;
            this.time = triggerTime;
            this.period = 0L;
            this.sequenceNumber = sequenceNumber;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed other) {
            if (other == this) {
                return 0;
            }
            if (other instanceof ScheduledFutureTask) {
                ScheduledFutureTask<?> x10 = (ScheduledFutureTask) other;
                long diff = this.time - x10.time;
                if (diff < 0) {
                    return -1;
                }
                return (diff <= 0 && this.sequenceNumber < x10.sequenceNumber) ? -1 : 1;
            }
            long diff2 = getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS);
            if (diff2 < 0) {
                return -1;
            }
            return diff2 > 0 ? 1 : 0;
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return this.period != 0;
        }

        private void setNextRunTime() {
            long p10 = this.period;
            if (p10 > 0) {
                this.time += p10;
            } else {
                this.time = ScheduledThreadPoolExecutor.this.triggerTime(-p10);
            }
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            boolean cancelled = super.cancel(mayInterruptIfRunning);
            if (cancelled && ScheduledThreadPoolExecutor.this.removeOnCancel && this.heapIndex >= 0) {
                ScheduledThreadPoolExecutor.this.remove(this);
            }
            return cancelled;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            if (!ScheduledThreadPoolExecutor.this.canRunInCurrentRunState(this)) {
                cancel(false);
                return;
            }
            if (!isPeriodic()) {
                super.run();
            } else if (super.runAndReset()) {
                setNextRunTime();
                ScheduledThreadPoolExecutor.this.reExecutePeriodic(this.outerTask);
            }
        }
    }

    boolean canRunInCurrentRunState(RunnableScheduledFuture<?> task) {
        if (!isShutdown()) {
            return true;
        }
        if (isStopped()) {
            return false;
        }
        if (task.isPeriodic()) {
            return this.continueExistingPeriodicTasksAfterShutdown;
        }
        return this.executeExistingDelayedTasksAfterShutdown;
    }

    private void delayedExecute(RunnableScheduledFuture<?> task) {
        if (isShutdown()) {
            reject(task);
            return;
        }
        super.getQueue().add(task);
        if (!canRunInCurrentRunState(task) && remove(task)) {
            task.cancel(false);
        } else {
            ensurePrestart();
        }
    }

    void reExecutePeriodic(RunnableScheduledFuture<?> task) {
        if (canRunInCurrentRunState(task)) {
            super.getQueue().add(task);
            if (canRunInCurrentRunState(task) || !remove(task)) {
                ensurePrestart();
                return;
            }
        }
        task.cancel(false);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    void onShutdown() {
        BlockingQueue<Runnable> q10 = super.getQueue();
        boolean keepDelayed = getExecuteExistingDelayedTasksAfterShutdownPolicy();
        boolean keepPeriodic = getContinueExistingPeriodicTasksAfterShutdownPolicy();
        for (Object e2 : q10.toArray()) {
            if (e2 instanceof RunnableScheduledFuture) {
                RunnableScheduledFuture<?> t2 = (RunnableScheduledFuture) e2;
                if (!t2.isPeriodic() ? keepDelayed : keepPeriodic) {
                    if (!t2.isCancelled()) {
                    }
                }
                if (q10.remove(t2)) {
                    t2.cancel(false);
                }
            }
        }
        tryTerminate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        return task;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task) {
        return task;
    }

    public ScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 10L, TimeUnit.MILLISECONDS, new DelayedWorkQueue());
        this.executeExistingDelayedTasksAfterShutdown = true;
    }

    public ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, Integer.MAX_VALUE, 10L, TimeUnit.MILLISECONDS, new DelayedWorkQueue(), threadFactory);
        this.executeExistingDelayedTasksAfterShutdown = true;
    }

    public ScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 10L, TimeUnit.MILLISECONDS, new DelayedWorkQueue(), handler);
        this.executeExistingDelayedTasksAfterShutdown = true;
    }

    public ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 10L, TimeUnit.MILLISECONDS, new DelayedWorkQueue(), threadFactory, handler);
        this.executeExistingDelayedTasksAfterShutdown = true;
    }

    private long triggerTime(long delay, TimeUnit unit) {
        return triggerTime(unit.toNanos(delay >= 0 ? delay : 0L));
    }

    long triggerTime(long delay) {
        return System.nanoTime() + (delay < 4611686018427387903L ? delay : overflowFree(delay));
    }

    private long overflowFree(long delay) {
        Delayed head = (Delayed) super.getQueue().peek();
        if (head != null) {
            long headDelay = head.getDelay(TimeUnit.NANOSECONDS);
            if (headDelay < 0 && delay - headDelay < 0) {
                return headDelay + Long.MAX_VALUE;
            }
            return delay;
        }
        return delay;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        if (command == null || unit == null) {
            throw new NullPointerException();
        }
        RunnableScheduledFuture<Void> t2 = decorateTask(command, new ScheduledFutureTask(command, null, triggerTime(delay, unit), sequencer.getAndIncrement()));
        delayedExecute(t2);
        return t2;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        if (callable == null || unit == null) {
            throw new NullPointerException();
        }
        RunnableScheduledFuture<V> t2 = decorateTask(callable, new ScheduledFutureTask(callable, triggerTime(delay, unit), sequencer.getAndIncrement()));
        delayedExecute(t2);
        return t2;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        if (command == null || unit == null) {
            throw new NullPointerException();
        }
        if (period <= 0) {
            throw new IllegalArgumentException();
        }
        ScheduledFutureTask<Void> sft = new ScheduledFutureTask<>(command, null, triggerTime(initialDelay, unit), unit.toNanos(period), sequencer.getAndIncrement());
        RunnableScheduledFuture<V> decorateTask = decorateTask(command, sft);
        sft.outerTask = decorateTask;
        delayedExecute(decorateTask);
        return decorateTask;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        if (command == null || unit == null) {
            throw new NullPointerException();
        }
        if (delay <= 0) {
            throw new IllegalArgumentException();
        }
        ScheduledFutureTask<Void> sft = new ScheduledFutureTask<>(command, null, triggerTime(initialDelay, unit), -unit.toNanos(delay), sequencer.getAndIncrement());
        RunnableScheduledFuture<V> decorateTask = decorateTask(command, sft);
        sft.outerTask = decorateTask;
        delayedExecute(decorateTask);
        return decorateTask;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable command) {
        schedule(command, 0L, TimeUnit.NANOSECONDS);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable task) {
        return schedule(task, 0L, TimeUnit.NANOSECONDS);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable task, T result) {
        return schedule(Executors.callable(task, result), 0L, TimeUnit.NANOSECONDS);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> task) {
        return schedule(task, 0L, TimeUnit.NANOSECONDS);
    }

    public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean value) {
        this.continueExistingPeriodicTasksAfterShutdown = value;
        if (!value && isShutdown()) {
            onShutdown();
        }
    }

    public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
        return this.continueExistingPeriodicTasksAfterShutdown;
    }

    public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean value) {
        this.executeExistingDelayedTasksAfterShutdown = value;
        if (!value && isShutdown()) {
            onShutdown();
        }
    }

    public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
        return this.executeExistingDelayedTasksAfterShutdown;
    }

    public void setRemoveOnCancelPolicy(boolean value) {
        this.removeOnCancel = value;
    }

    public boolean getRemoveOnCancelPolicy() {
        return this.removeOnCancel;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        return super.getQueue();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class DelayedWorkQueue extends AbstractQueue<Runnable> implements BlockingQueue<Runnable> {
        private static final int INITIAL_CAPACITY = 16;
        private final Condition available;
        private Thread leader;
        private final ReentrantLock lock;
        private RunnableScheduledFuture<?>[] queue = new RunnableScheduledFuture[16];
        private int size;

        DelayedWorkQueue() {
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.available = reentrantLock.newCondition();
        }

        private static void setIndex(RunnableScheduledFuture<?> f10, int idx) {
            if (f10 instanceof ScheduledFutureTask) {
                ((ScheduledFutureTask) f10).heapIndex = idx;
            }
        }

        private void siftUp(int k10, RunnableScheduledFuture<?> key) {
            while (k10 > 0) {
                int parent = (k10 - 1) >>> 1;
                RunnableScheduledFuture<?> e2 = this.queue[parent];
                if (key.compareTo(e2) >= 0) {
                    break;
                }
                this.queue[k10] = e2;
                setIndex(e2, k10);
                k10 = parent;
            }
            this.queue[k10] = key;
            setIndex(key, k10);
        }

        private void siftDown(int k10, RunnableScheduledFuture<?> key) {
            int half = this.size >>> 1;
            while (k10 < half) {
                int child = (k10 << 1) + 1;
                RunnableScheduledFuture<?>[] runnableScheduledFutureArr = this.queue;
                RunnableScheduledFuture<?> c4 = runnableScheduledFutureArr[child];
                int right = child + 1;
                if (right < this.size && c4.compareTo(runnableScheduledFutureArr[right]) > 0) {
                    child = right;
                    c4 = this.queue[right];
                }
                if (key.compareTo(c4) <= 0) {
                    break;
                }
                this.queue[k10] = c4;
                setIndex(c4, k10);
                k10 = child;
            }
            this.queue[k10] = key;
            setIndex(key, k10);
        }

        private void grow() {
            RunnableScheduledFuture<?>[] runnableScheduledFutureArr = this.queue;
            int oldCapacity = runnableScheduledFutureArr.length;
            int newCapacity = (oldCapacity >> 1) + oldCapacity;
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            this.queue = (RunnableScheduledFuture[]) Arrays.copyOf(runnableScheduledFutureArr, newCapacity);
        }

        private int indexOf(Object x10) {
            if (x10 != null) {
                if (x10 instanceof ScheduledFutureTask) {
                    int i10 = ((ScheduledFutureTask) x10).heapIndex;
                    if (i10 >= 0 && i10 < this.size && this.queue[i10] == x10) {
                        return i10;
                    }
                    return -1;
                }
                for (int i11 = 0; i11 < this.size; i11++) {
                    if (x10.equals(this.queue[i11])) {
                        return i11;
                    }
                }
                return -1;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object x10) {
            ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return indexOf(x10) != -1;
            } finally {
                lock.unlock();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object x10) {
            ReentrantLock lock = this.lock;
            lock.lock();
            try {
                int i10 = indexOf(x10);
                if (i10 >= 0) {
                    setIndex(this.queue[i10], -1);
                    int s2 = this.size - 1;
                    this.size = s2;
                    RunnableScheduledFuture<?>[] runnableScheduledFutureArr = this.queue;
                    RunnableScheduledFuture<?> replacement = runnableScheduledFutureArr[s2];
                    runnableScheduledFutureArr[s2] = null;
                    if (s2 != i10) {
                        siftDown(i10, replacement);
                        if (this.queue[i10] == replacement) {
                            siftUp(i10, replacement);
                        }
                    }
                    return true;
                }
                lock.unlock();
                return false;
            } finally {
                lock.unlock();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return this.size;
            } finally {
                lock.unlock();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.concurrent.BlockingQueue
        public int remainingCapacity() {
            return Integer.MAX_VALUE;
        }

        @Override // java.util.Queue
        public RunnableScheduledFuture<?> peek() {
            ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return this.queue[0];
            } finally {
                lock.unlock();
            }
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(Runnable x10) {
            if (x10 == null) {
                throw new NullPointerException();
            }
            RunnableScheduledFuture<?> e2 = (RunnableScheduledFuture) x10;
            ReentrantLock lock = this.lock;
            lock.lock();
            try {
                int i10 = this.size;
                if (i10 >= this.queue.length) {
                    grow();
                }
                this.size = i10 + 1;
                if (i10 == 0) {
                    this.queue[0] = e2;
                    setIndex(e2, 0);
                } else {
                    siftUp(i10, e2);
                }
                if (this.queue[0] == e2) {
                    this.leader = null;
                    this.available.signal();
                }
                lock.unlock();
                return true;
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }

        @Override // java.util.concurrent.BlockingQueue
        public void put(Runnable e2) {
            offer(e2);
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Runnable e2) {
            return offer(e2);
        }

        @Override // java.util.concurrent.BlockingQueue
        public boolean offer(Runnable e2, long timeout, TimeUnit unit) {
            return offer(e2);
        }

        private RunnableScheduledFuture<?> finishPoll(RunnableScheduledFuture<?> f10) {
            int s2 = this.size - 1;
            this.size = s2;
            RunnableScheduledFuture<?>[] runnableScheduledFutureArr = this.queue;
            RunnableScheduledFuture<?> x10 = runnableScheduledFutureArr[s2];
            runnableScheduledFutureArr[s2] = null;
            if (s2 != 0) {
                siftDown(0, x10);
            }
            setIndex(f10, -1);
            return f10;
        }

        @Override // java.util.Queue
        public RunnableScheduledFuture<?> poll() {
            RunnableScheduledFuture<?> runnableScheduledFuture;
            ReentrantLock lock = this.lock;
            lock.lock();
            try {
                RunnableScheduledFuture<?> first = this.queue[0];
                if (first != null && first.getDelay(TimeUnit.NANOSECONDS) <= 0) {
                    runnableScheduledFuture = finishPoll(first);
                    return runnableScheduledFuture;
                }
                runnableScheduledFuture = null;
                return runnableScheduledFuture;
            } finally {
                lock.unlock();
            }
        }

        @Override // java.util.concurrent.BlockingQueue
        public Runnable take() throws InterruptedException {
            RunnableScheduledFuture<?> first;
            ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            while (true) {
                try {
                    first = this.queue[0];
                    if (first == null) {
                        this.available.await();
                    } else {
                        long delay = first.getDelay(TimeUnit.NANOSECONDS);
                        if (delay <= 0) {
                            break;
                        }
                        if (this.leader != null) {
                            this.available.await();
                        } else {
                            Thread thisThread = Thread.currentThread();
                            this.leader = thisThread;
                            try {
                                this.available.awaitNanos(delay);
                            } finally {
                                if (this.leader == thisThread) {
                                    this.leader = null;
                                }
                            }
                        }
                    }
                } finally {
                    if (this.leader == null && this.queue[0] != null) {
                        this.available.signal();
                    }
                    lock.unlock();
                }
            }
            return finishPoll(first);
        }

        @Override // java.util.concurrent.BlockingQueue
        public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
            long nanos = unit.toNanos(timeout);
            ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            while (true) {
                try {
                    RunnableScheduledFuture<?> first = this.queue[0];
                    if (first != null) {
                        long delay = first.getDelay(TimeUnit.NANOSECONDS);
                        if (delay <= 0) {
                            return finishPoll(first);
                        }
                        if (nanos <= 0) {
                            if (this.leader == null && this.queue[0] != null) {
                                this.available.signal();
                            }
                            lock.unlock();
                            return null;
                        }
                        if (nanos >= delay && this.leader == null) {
                            Thread thisThread = Thread.currentThread();
                            this.leader = thisThread;
                            try {
                                long timeLeft = this.available.awaitNanos(delay);
                                nanos -= delay - timeLeft;
                                if (this.leader == thisThread) {
                                    this.leader = null;
                                }
                            } catch (Throwable th) {
                                if (this.leader == thisThread) {
                                    this.leader = null;
                                }
                                throw th;
                            }
                        }
                        nanos = this.available.awaitNanos(nanos);
                    } else {
                        if (nanos <= 0) {
                            if (this.leader == null && first != null) {
                                this.available.signal();
                            }
                            lock.unlock();
                            return null;
                        }
                        nanos = this.available.awaitNanos(nanos);
                    }
                } finally {
                    if (this.leader == null && this.queue[0] != null) {
                        this.available.signal();
                    }
                    lock.unlock();
                }
            }
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ReentrantLock lock = this.lock;
            lock.lock();
            for (int i10 = 0; i10 < this.size; i10++) {
                try {
                    RunnableScheduledFuture<?>[] runnableScheduledFutureArr = this.queue;
                    RunnableScheduledFuture<?> t2 = runnableScheduledFutureArr[i10];
                    if (t2 != null) {
                        runnableScheduledFutureArr[i10] = null;
                        setIndex(t2, -1);
                    }
                } finally {
                    lock.unlock();
                }
            }
            this.size = 0;
        }

        @Override // java.util.concurrent.BlockingQueue
        public int drainTo(Collection<? super Runnable> c4) {
            return drainTo(c4, Integer.MAX_VALUE);
        }

        @Override // java.util.concurrent.BlockingQueue
        public int drainTo(Collection<? super Runnable> c4, int maxElements) {
            Objects.requireNonNull(c4);
            if (c4 == this) {
                throw new IllegalArgumentException();
            }
            if (maxElements <= 0) {
                return 0;
            }
            ReentrantLock lock = this.lock;
            lock.lock();
            int n10 = 0;
            while (n10 < maxElements) {
                try {
                    RunnableScheduledFuture<?> first = this.queue[0];
                    if (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0) {
                        break;
                    }
                    c4.add(first);
                    finishPoll(first);
                    n10++;
                } finally {
                    lock.unlock();
                }
            }
            return n10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return Arrays.copyOf(this.queue, this.size, Object[].class);
            } finally {
                lock.unlock();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int length = tArr.length;
                int i10 = this.size;
                if (length < i10) {
                    return (T[]) Arrays.copyOf(this.queue, i10, tArr.getClass());
                }
                System.arraycopy(this.queue, 0, tArr, 0, i10);
                int length2 = tArr.length;
                int i11 = this.size;
                if (length2 > i11) {
                    tArr[i11] = null;
                }
                return tArr;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Runnable> iterator2() {
            ReentrantLock lock = this.lock;
            lock.lock();
            try {
                return new Itr((RunnableScheduledFuture[]) Arrays.copyOf(this.queue, this.size));
            } finally {
                lock.unlock();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private class Itr implements Iterator<Runnable> {
            final RunnableScheduledFuture<?>[] array;
            int cursor;
            int lastRet = -1;

            Itr(RunnableScheduledFuture<?>[] array) {
                this.array = array;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.cursor < this.array.length;
            }

            @Override // java.util.Iterator
            public Runnable next() {
                int i10 = this.cursor;
                RunnableScheduledFuture<?>[] runnableScheduledFutureArr = this.array;
                if (i10 >= runnableScheduledFutureArr.length) {
                    throw new NoSuchElementException();
                }
                this.cursor = i10 + 1;
                this.lastRet = i10;
                return runnableScheduledFutureArr[i10];
            }

            @Override // java.util.Iterator
            public void remove() {
                int i10 = this.lastRet;
                if (i10 < 0) {
                    throw new IllegalStateException();
                }
                DelayedWorkQueue.this.remove(this.array[i10]);
                this.lastRet = -1;
            }
        }
    }
}
