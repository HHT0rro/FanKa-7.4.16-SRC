package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiskCacheWriteLocker {
    private final Map<String, WriteLock> locks = new HashMap();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class WriteLock {
        public int interestedThreads;
        public final Lock lock = new ReentrantLock();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool = new ArrayDeque();

        public WriteLock obtain() {
            WriteLock poll;
            synchronized (this.pool) {
                poll = this.pool.poll();
            }
            return poll == null ? new WriteLock() : poll;
        }

        public void offer(WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }

    public void acquire(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = this.locks.get(str);
            if (writeLock == null) {
                writeLock = this.writeLockPool.obtain();
                this.locks.put(str, writeLock);
            }
            writeLock.interestedThreads++;
        }
        writeLock.lock.lock();
    }

    public void release(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.checkNotNull(this.locks.get(str));
            int i10 = writeLock.interestedThreads;
            if (i10 >= 1) {
                int i11 = i10 - 1;
                writeLock.interestedThreads = i11;
                if (i11 == 0) {
                    WriteLock remove = this.locks.remove(str);
                    if (remove.equals(writeLock)) {
                        this.writeLockPool.offer(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + ((Object) writeLock) + ", but actually removed: " + ((Object) remove) + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.interestedThreads);
            }
        }
        writeLock.lock.unlock();
    }
}
