package sun.util.locale;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class LocaleObjectCache<K, V> {
    private final ConcurrentMap<K, CacheEntry<K, V>> map;
    private final ReferenceQueue<V> queue;

    protected abstract V createObject(K k10);

    public LocaleObjectCache() {
        this(16, 0.75f, 16);
    }

    public LocaleObjectCache(int initialCapacity, float loadFactor, int concurrencyLevel) {
        this.queue = new ReferenceQueue<>();
        this.map = new ConcurrentHashMap(initialCapacity, loadFactor, concurrencyLevel);
    }

    public V get(K key) {
        V value = null;
        cleanStaleEntries();
        CacheEntry<K, V> entry = this.map.get(key);
        if (entry != null) {
            value = entry.get();
        }
        if (value == null) {
            K key2 = normalizeKey(key);
            V newVal = createObject(key2);
            if (key2 == null || newVal == null) {
                return null;
            }
            CacheEntry<K, V> newEntry = new CacheEntry<>(key2, newVal, this.queue);
            CacheEntry<K, V> entry2 = this.map.putIfAbsent(key2, newEntry);
            if (entry2 == null) {
                return newVal;
            }
            V value2 = entry2.get();
            if (value2 == null) {
                this.map.put(key2, newEntry);
                return newVal;
            }
            return value2;
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V put(K key, V value) {
        CacheEntry<K, V> entry = new CacheEntry<>(key, value, this.queue);
        CacheEntry<K, V> oldEntry = this.map.put(key, entry);
        if (oldEntry == null) {
            return null;
        }
        return oldEntry.get();
    }

    public void cleanStaleEntries() {
        while (true) {
            CacheEntry<K, V> entry = (CacheEntry) this.queue.poll();
            if (entry != null) {
                this.map.remove(entry.getKey(), entry);
            } else {
                return;
            }
        }
    }

    protected K normalizeKey(K key) {
        return key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CacheEntry<K, V> extends SoftReference<V> {
        private K key;

        CacheEntry(K key, V value, ReferenceQueue<V> queue) {
            super(value, queue);
            this.key = key;
        }

        K getKey() {
            return this.key;
        }
    }
}
