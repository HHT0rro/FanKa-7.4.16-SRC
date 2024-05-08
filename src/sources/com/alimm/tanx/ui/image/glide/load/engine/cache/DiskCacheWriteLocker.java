package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class DiskCacheWriteLocker {
    public final Map<Key, WriteLock> locks = new HashMap();
    public final WriteLockPool writeLockPool = new WriteLockPool();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class WriteLock {
        public int interestedThreads;
        public final Lock lock;

        public WriteLock() {
            this.lock = new ReentrantLock();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class WriteLockPool {
        public static final int MAX_POOL_SIZE = 10;
        public final Queue<WriteLock> pool;

        public WriteLockPool() {
            this.pool = new ArrayDeque();
        }

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

    public void acquire(Key key) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = this.locks.get(key);
            if (writeLock == null) {
                writeLock = this.writeLockPool.obtain();
                this.locks.put(key, writeLock);
            }
            writeLock.interestedThreads++;
        }
        writeLock.lock.lock();
    }

    public void release(Key key) {
        WriteLock writeLock;
        int i10;
        synchronized (this) {
            writeLock = this.locks.get(key);
            if (writeLock != null && (i10 = writeLock.interestedThreads) > 0) {
                int i11 = i10 - 1;
                writeLock.interestedThreads = i11;
                if (i11 == 0) {
                    WriteLock remove = this.locks.remove(key);
                    if (remove.equals(writeLock)) {
                        this.writeLockPool.offer(remove);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Removed the wrong lock, expected to remove: ");
                        sb2.append((Object) writeLock);
                        sb2.append(", but actually removed: ");
                        sb2.append((Object) remove);
                        sb2.append(", key: ");
                        sb2.append((Object) key);
                        throw new IllegalStateException(sb2.toString());
                    }
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cannot release a lock that is not held, key: ");
            sb3.append((Object) key);
            sb3.append(", interestedThreads: ");
            sb3.append(writeLock == null ? 0 : writeLock.interestedThreads);
            throw new IllegalArgumentException(sb3.toString());
        }
        writeLock.lock.unlock();
    }
}
