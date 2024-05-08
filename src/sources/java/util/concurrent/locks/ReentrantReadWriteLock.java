package java.util.concurrent.locks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ReentrantReadWriteLock implements ReadWriteLock, Serializable {
    private static final long serialVersionUID = -6992448646407690164L;
    private final ReadLock readerLock;
    final Sync sync;
    private final WriteLock writerLock;

    public ReentrantReadWriteLock() {
        this(false);
    }

    public ReentrantReadWriteLock(boolean fair) {
        this.sync = fair ? new FairSync() : new NonfairSync();
        this.readerLock = new ReadLock(this);
        this.writerLock = new WriteLock(this);
    }

    @Override // java.util.concurrent.locks.ReadWriteLock
    public WriteLock writeLock() {
        return this.writerLock;
    }

    @Override // java.util.concurrent.locks.ReadWriteLock
    public ReadLock readLock() {
        return this.readerLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Sync extends AbstractQueuedSynchronizer {
        static final int EXCLUSIVE_MASK = 65535;
        static final int MAX_COUNT = 65535;
        static final int SHARED_SHIFT = 16;
        static final int SHARED_UNIT = 65536;
        private static final long serialVersionUID = 6317671515068378041L;
        private transient HoldCounter cachedHoldCounter;
        private transient Thread firstReader;
        private transient int firstReaderHoldCount;
        private transient ThreadLocalHoldCounter readHolds = new ThreadLocalHoldCounter();

        abstract boolean readerShouldBlock();

        abstract boolean writerShouldBlock();

        static int sharedCount(int c4) {
            return c4 >>> 16;
        }

        static int exclusiveCount(int c4) {
            return 65535 & c4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class HoldCounter {
            int count;
            final long tid = LockSupport.getThreadId(Thread.currentThread());

            HoldCounter() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            ThreadLocalHoldCounter() {
            }

            @Override // java.lang.ThreadLocal
            public HoldCounter initialValue() {
                return new HoldCounter();
            }
        }

        Sync() {
            setState(getState());
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryRelease(int releases) {
            if (!isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            int nextc = getState() - releases;
            boolean free = exclusiveCount(nextc) == 0;
            if (free) {
                setExclusiveOwnerThread(null);
            }
            setState(nextc);
            return free;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryAcquire(int acquires) {
            Thread current = Thread.currentThread();
            int c4 = getState();
            int w3 = exclusiveCount(c4);
            if (c4 != 0) {
                if (w3 == 0 || current != getExclusiveOwnerThread()) {
                    return false;
                }
                if (exclusiveCount(acquires) + w3 > 65535) {
                    throw new Error("Maximum lock count exceeded");
                }
                setState(c4 + acquires);
                return true;
            }
            if (writerShouldBlock() || !compareAndSetState(c4, c4 + acquires)) {
                return false;
            }
            setExclusiveOwnerThread(current);
            return true;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean tryReleaseShared(int unused) {
            int c4;
            int nextc;
            Thread current = Thread.currentThread();
            if (this.firstReader == current) {
                int i10 = this.firstReaderHoldCount;
                if (i10 == 1) {
                    this.firstReader = null;
                } else {
                    this.firstReaderHoldCount = i10 - 1;
                }
            } else {
                HoldCounter rh = this.cachedHoldCounter;
                if (rh == null || rh.tid != LockSupport.getThreadId(current)) {
                    rh = this.readHolds.get();
                }
                int count = rh.count;
                if (count <= 1) {
                    this.readHolds.remove();
                    if (count <= 0) {
                        throw unmatchedUnlockException();
                    }
                }
                rh.count--;
            }
            do {
                c4 = getState();
                nextc = c4 - 65536;
            } while (!compareAndSetState(c4, nextc));
            return nextc == 0;
        }

        private static IllegalMonitorStateException unmatchedUnlockException() {
            return new IllegalMonitorStateException("attempt to unlock read lock, not locked by current thread");
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final int tryAcquireShared(int unused) {
            Thread current = Thread.currentThread();
            int c4 = getState();
            if (exclusiveCount(c4) != 0 && getExclusiveOwnerThread() != current) {
                return -1;
            }
            int r10 = sharedCount(c4);
            if (!readerShouldBlock() && r10 < 65535 && compareAndSetState(c4, 65536 + c4)) {
                if (r10 == 0) {
                    this.firstReader = current;
                    this.firstReaderHoldCount = 1;
                } else if (this.firstReader == current) {
                    this.firstReaderHoldCount++;
                } else {
                    HoldCounter rh = this.cachedHoldCounter;
                    if (rh == null || rh.tid != LockSupport.getThreadId(current)) {
                        HoldCounter holdCounter = this.readHolds.get();
                        rh = holdCounter;
                        this.cachedHoldCounter = holdCounter;
                    } else if (rh.count == 0) {
                        this.readHolds.set(rh);
                    }
                    rh.count++;
                }
                return 1;
            }
            return fullTryAcquireShared(current);
        }

        final int fullTryAcquireShared(Thread current) {
            int c4;
            HoldCounter rh = null;
            do {
                c4 = getState();
                if (exclusiveCount(c4) != 0) {
                    if (getExclusiveOwnerThread() != current) {
                        return -1;
                    }
                } else if (readerShouldBlock() && this.firstReader != current) {
                    if (rh == null && ((rh = this.cachedHoldCounter) == null || rh.tid != LockSupport.getThreadId(current))) {
                        HoldCounter rh2 = this.readHolds.get();
                        rh = rh2;
                        if (rh.count == 0) {
                            this.readHolds.remove();
                        }
                    }
                    if (rh.count == 0) {
                        return -1;
                    }
                }
                if (sharedCount(c4) == 65535) {
                    throw new Error("Maximum lock count exceeded");
                }
            } while (!compareAndSetState(c4, 65536 + c4));
            if (sharedCount(c4) == 0) {
                this.firstReader = current;
                this.firstReaderHoldCount = 1;
            } else if (this.firstReader == current) {
                this.firstReaderHoldCount++;
            } else {
                if (rh == null) {
                    rh = this.cachedHoldCounter;
                }
                if (rh == null || rh.tid != LockSupport.getThreadId(current)) {
                    HoldCounter rh3 = this.readHolds.get();
                    rh = rh3;
                } else if (rh.count == 0) {
                    this.readHolds.set(rh);
                }
                rh.count++;
                this.cachedHoldCounter = rh;
            }
            return 1;
        }

        final boolean tryWriteLock() {
            Thread current = Thread.currentThread();
            int c4 = getState();
            if (c4 != 0) {
                int w3 = exclusiveCount(c4);
                if (w3 == 0 || current != getExclusiveOwnerThread()) {
                    return false;
                }
                if (w3 == 65535) {
                    throw new Error("Maximum lock count exceeded");
                }
            }
            if (!compareAndSetState(c4, c4 + 1)) {
                return false;
            }
            setExclusiveOwnerThread(current);
            return true;
        }

        final boolean tryReadLock() {
            int c4;
            int r10;
            Thread current = Thread.currentThread();
            do {
                c4 = getState();
                if (exclusiveCount(c4) != 0 && getExclusiveOwnerThread() != current) {
                    return false;
                }
                r10 = sharedCount(c4);
                if (r10 == 65535) {
                    throw new Error("Maximum lock count exceeded");
                }
            } while (!compareAndSetState(c4, 65536 + c4));
            if (r10 == 0) {
                this.firstReader = current;
                this.firstReaderHoldCount = 1;
            } else if (this.firstReader == current) {
                this.firstReaderHoldCount++;
            } else {
                HoldCounter rh = this.cachedHoldCounter;
                if (rh == null || rh.tid != LockSupport.getThreadId(current)) {
                    HoldCounter holdCounter = this.readHolds.get();
                    rh = holdCounter;
                    this.cachedHoldCounter = holdCounter;
                } else if (rh.count == 0) {
                    this.readHolds.set(rh);
                }
                rh.count++;
            }
            return true;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        final AbstractQueuedSynchronizer.ConditionObject newCondition() {
            return new AbstractQueuedSynchronizer.ConditionObject();
        }

        final Thread getOwner() {
            if (exclusiveCount(getState()) == 0) {
                return null;
            }
            return getExclusiveOwnerThread();
        }

        final int getReadLockCount() {
            return sharedCount(getState());
        }

        final boolean isWriteLocked() {
            return exclusiveCount(getState()) != 0;
        }

        final int getWriteHoldCount() {
            if (isHeldExclusively()) {
                return exclusiveCount(getState());
            }
            return 0;
        }

        final int getReadHoldCount() {
            if (getReadLockCount() == 0) {
                return 0;
            }
            Thread current = Thread.currentThread();
            if (this.firstReader == current) {
                return this.firstReaderHoldCount;
            }
            HoldCounter rh = this.cachedHoldCounter;
            if (rh != null && rh.tid == LockSupport.getThreadId(current)) {
                return rh.count;
            }
            int count = this.readHolds.get().count;
            if (count == 0) {
                this.readHolds.remove();
            }
            return count;
        }

        private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
            s2.defaultReadObject();
            this.readHolds = new ThreadLocalHoldCounter();
            setState(0);
        }

        final int getCount() {
            return getState();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = -8159625535654395037L;

        NonfairSync() {
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.Sync
        final boolean writerShouldBlock() {
            return false;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.Sync
        final boolean readerShouldBlock() {
            return apparentlyFirstQueuedIsExclusive();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -2274990926593161451L;

        FairSync() {
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.Sync
        final boolean writerShouldBlock() {
            return hasQueuedPredecessors();
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.Sync
        final boolean readerShouldBlock() {
            return hasQueuedPredecessors();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ReadLock implements Lock, Serializable {
        private static final long serialVersionUID = -5992448646407690164L;
        private final Sync sync;

        /* JADX INFO: Access modifiers changed from: protected */
        public ReadLock(ReentrantReadWriteLock lock) {
            this.sync = lock.sync;
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            this.sync.acquireShared(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            this.sync.acquireSharedInterruptibly(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return this.sync.tryReadLock();
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            return this.sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            this.sync.releaseShared(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            int r10 = this.sync.getReadLockCount();
            return super.toString() + "[Read locks = " + r10 + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class WriteLock implements Lock, Serializable {
        private static final long serialVersionUID = -4992448646407690164L;
        private final Sync sync;

        /* JADX INFO: Access modifiers changed from: protected */
        public WriteLock(ReentrantReadWriteLock lock) {
            this.sync = lock.sync;
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            this.sync.acquire(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            this.sync.acquireInterruptibly(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return this.sync.tryWriteLock();
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            return this.sync.tryAcquireNanos(1, unit.toNanos(timeout));
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            this.sync.release(1);
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return this.sync.newCondition();
        }

        public String toString() {
            String str;
            Thread o10 = this.sync.getOwner();
            StringBuilder append = new StringBuilder().append(super.toString());
            if (o10 == null) {
                str = "[Unlocked]";
            } else {
                str = "[Locked by thread " + o10.getName() + "]";
            }
            return append.append(str).toString();
        }

        public boolean isHeldByCurrentThread() {
            return this.sync.isHeldExclusively();
        }

        public int getHoldCount() {
            return this.sync.getWriteHoldCount();
        }
    }

    public final boolean isFair() {
        return this.sync instanceof FairSync;
    }

    protected Thread getOwner() {
        return this.sync.getOwner();
    }

    public int getReadLockCount() {
        return this.sync.getReadLockCount();
    }

    public boolean isWriteLocked() {
        return this.sync.isWriteLocked();
    }

    public boolean isWriteLockedByCurrentThread() {
        return this.sync.isHeldExclusively();
    }

    public int getWriteHoldCount() {
        return this.sync.getWriteHoldCount();
    }

    public int getReadHoldCount() {
        return this.sync.getReadHoldCount();
    }

    protected Collection<Thread> getQueuedWriterThreads() {
        return this.sync.getExclusiveQueuedThreads();
    }

    protected Collection<Thread> getQueuedReaderThreads() {
        return this.sync.getSharedQueuedThreads();
    }

    public final boolean hasQueuedThreads() {
        return this.sync.hasQueuedThreads();
    }

    public final boolean hasQueuedThread(Thread thread) {
        return this.sync.isQueued(thread);
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    protected Collection<Thread> getQueuedThreads() {
        return this.sync.getQueuedThreads();
    }

    public boolean hasWaiters(Condition condition) {
        if (condition == null) {
            throw new NullPointerException();
        }
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject)) {
            throw new IllegalArgumentException("not owner");
        }
        return this.sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    public int getWaitQueueLength(Condition condition) {
        if (condition == null) {
            throw new NullPointerException();
        }
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject)) {
            throw new IllegalArgumentException("not owner");
        }
        return this.sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    protected Collection<Thread> getWaitingThreads(Condition condition) {
        if (condition == null) {
            throw new NullPointerException();
        }
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject)) {
            throw new IllegalArgumentException("not owner");
        }
        return this.sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    public String toString() {
        int c4 = this.sync.getCount();
        int w3 = Sync.exclusiveCount(c4);
        int r10 = Sync.sharedCount(c4);
        return super.toString() + "[Write locks = " + w3 + ", Read locks = " + r10 + "]";
    }
}
