package sun.security.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import sun.security.util.Cache;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: Cache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class MemoryCache<K, V> extends Cache<K, V> {
    private static final boolean DEBUG = false;
    private static final float LOAD_FACTOR = 0.75f;
    private final Map<K, CacheEntry<K, V>> cacheMap;
    private long lifetime;
    private int maxSize;
    private long nextExpirationTime;
    private final ReferenceQueue<V> queue;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* compiled from: Cache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface CacheEntry<K, V> {
        long getExpirationTime();

        K getKey();

        V getValue();

        void invalidate();

        boolean isValid(long j10);
    }

    public MemoryCache(boolean soft, int maxSize) {
        this(soft, maxSize, 0);
    }

    public MemoryCache(boolean soft, int maxSize, int lifetime) {
        this.nextExpirationTime = Long.MAX_VALUE;
        this.maxSize = maxSize;
        this.lifetime = lifetime * 1000;
        if (soft) {
            this.queue = new ReferenceQueue<>();
        } else {
            this.queue = null;
        }
        this.cacheMap = new LinkedHashMap(1, 0.75f, true);
    }

    private void emptyQueue() {
        CacheEntry<K, V> remove;
        if (this.queue == null) {
            return;
        }
        this.cacheMap.size();
        while (true) {
            CacheEntry<K, V> cacheEntry = (CacheEntry) this.queue.poll();
            if (cacheEntry != null) {
                K key = cacheEntry.getKey();
                if (key != null && (remove = this.cacheMap.remove(key)) != null && cacheEntry != remove) {
                    this.cacheMap.put(key, remove);
                }
            } else {
                return;
            }
        }
    }

    private void expungeExpiredEntries() {
        emptyQueue();
        if (this.lifetime == 0) {
            return;
        }
        int cnt = 0;
        long time = System.currentTimeMillis();
        if (this.nextExpirationTime > time) {
            return;
        }
        this.nextExpirationTime = Long.MAX_VALUE;
        Iterator<CacheEntry<K, V>> t2 = this.cacheMap.values().iterator2();
        while (t2.hasNext()) {
            CacheEntry<K, V> entry = t2.next();
            if (!entry.isValid(time)) {
                t2.remove();
                cnt++;
            } else if (this.nextExpirationTime > entry.getExpirationTime()) {
                this.nextExpirationTime = entry.getExpirationTime();
            }
        }
    }

    @Override // sun.security.util.Cache
    public synchronized int size() {
        expungeExpiredEntries();
        return this.cacheMap.size();
    }

    @Override // sun.security.util.Cache
    public synchronized void clear() {
        if (this.queue != null) {
            for (CacheEntry<K, V> entry : this.cacheMap.values()) {
                entry.invalidate();
            }
            do {
            } while (this.queue.poll() != null);
        }
        this.cacheMap.clear();
    }

    @Override // sun.security.util.Cache
    public synchronized void put(K key, V value) {
        emptyQueue();
        long j10 = 0;
        if (this.lifetime != 0) {
            j10 = this.lifetime + System.currentTimeMillis();
        }
        long expirationTime = j10;
        if (expirationTime < this.nextExpirationTime) {
            this.nextExpirationTime = expirationTime;
        }
        CacheEntry<K, V> newEntry = newEntry(key, value, expirationTime, this.queue);
        CacheEntry<K, V> oldEntry = this.cacheMap.put(key, newEntry);
        if (oldEntry != null) {
            oldEntry.invalidate();
            return;
        }
        if (this.maxSize > 0 && this.cacheMap.size() > this.maxSize) {
            expungeExpiredEntries();
            if (this.cacheMap.size() > this.maxSize) {
                Iterator<CacheEntry<K, V>> t2 = this.cacheMap.values().iterator2();
                CacheEntry<K, V> lruEntry = t2.next();
                t2.remove();
                lruEntry.invalidate();
            }
        }
    }

    @Override // sun.security.util.Cache
    public synchronized V get(Object key) {
        emptyQueue();
        CacheEntry<K, V> entry = this.cacheMap.get(key);
        if (entry == null) {
            return null;
        }
        long j10 = 0;
        if (this.lifetime != 0) {
            j10 = System.currentTimeMillis();
        }
        long time = j10;
        if (!entry.isValid(time)) {
            this.cacheMap.remove(key);
            return null;
        }
        return entry.getValue();
    }

    @Override // sun.security.util.Cache
    public synchronized void remove(Object key) {
        emptyQueue();
        CacheEntry<K, V> entry = this.cacheMap.remove(key);
        if (entry != null) {
            entry.invalidate();
        }
    }

    @Override // sun.security.util.Cache
    public synchronized V pull(Object key) {
        emptyQueue();
        CacheEntry<K, V> entry = this.cacheMap.remove(key);
        if (entry == null) {
            return null;
        }
        long j10 = 0;
        if (this.lifetime != 0) {
            j10 = System.currentTimeMillis();
        }
        long time = j10;
        if (!entry.isValid(time)) {
            return null;
        }
        V value = entry.getValue();
        entry.invalidate();
        return value;
    }

    @Override // sun.security.util.Cache
    public synchronized void setCapacity(int size) {
        expungeExpiredEntries();
        if (size > 0 && this.cacheMap.size() > size) {
            Iterator<CacheEntry<K, V>> t2 = this.cacheMap.values().iterator2();
            for (int i10 = this.cacheMap.size() - size; i10 > 0; i10--) {
                CacheEntry<K, V> lruEntry = t2.next();
                t2.remove();
                lruEntry.invalidate();
            }
        }
        this.maxSize = size > 0 ? size : 0;
    }

    @Override // sun.security.util.Cache
    public synchronized void setTimeout(int timeout) {
        emptyQueue();
        this.lifetime = timeout > 0 ? timeout * 1000 : 0L;
    }

    @Override // sun.security.util.Cache
    public synchronized void accept(Cache.CacheVisitor<K, V> visitor) {
        expungeExpiredEntries();
        Map<K, V> cached = getCachedEntries();
        visitor.visit(cached);
    }

    private Map<K, V> getCachedEntries() {
        Map<K, V> kvmap = new HashMap<>(this.cacheMap.size());
        for (CacheEntry<K, V> entry : this.cacheMap.values()) {
            kvmap.put(entry.getKey(), entry.getValue());
        }
        return kvmap;
    }

    protected CacheEntry<K, V> newEntry(K key, V value, long expirationTime, ReferenceQueue<V> queue) {
        if (queue != null) {
            return new SoftCacheEntry(key, value, expirationTime, queue);
        }
        return new HardCacheEntry(key, value, expirationTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* compiled from: Cache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class HardCacheEntry<K, V> implements CacheEntry<K, V> {
        private long expirationTime;
        private K key;
        private V value;

        HardCacheEntry(K key, V value, long expirationTime) {
            this.key = key;
            this.value = value;
            this.expirationTime = expirationTime;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public K getKey() {
            return this.key;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public V getValue() {
            return this.value;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public long getExpirationTime() {
            return this.expirationTime;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public boolean isValid(long currentTime) {
            boolean valid = currentTime <= this.expirationTime;
            if (!valid) {
                invalidate();
            }
            return valid;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public void invalidate() {
            this.key = null;
            this.value = null;
            this.expirationTime = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* compiled from: Cache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SoftCacheEntry<K, V> extends SoftReference<V> implements CacheEntry<K, V> {
        private long expirationTime;
        private K key;

        SoftCacheEntry(K key, V value, long expirationTime, ReferenceQueue<V> queue) {
            super(value, queue);
            this.key = key;
            this.expirationTime = expirationTime;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public K getKey() {
            return this.key;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public V getValue() {
            return get();
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public long getExpirationTime() {
            return this.expirationTime;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public boolean isValid(long currentTime) {
            boolean valid = currentTime <= this.expirationTime && get() != null;
            if (!valid) {
                invalidate();
            }
            return valid;
        }

        @Override // sun.security.util.MemoryCache.CacheEntry
        public void invalidate() {
            clear();
            this.key = null;
            this.expirationTime = -1L;
        }
    }
}
