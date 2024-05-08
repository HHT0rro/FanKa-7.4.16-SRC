package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LruCache<T, Y> {
    private final Map<T, Entry<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Entry<Y> {
        public final int size;
        public final Y value;

        public Entry(Y y10, int i10) {
            this.value = y10;
            this.size = i10;
        }
    }

    public LruCache(long j10) {
        this.initialMaxSize = j10;
        this.maxSize = j10;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(@NonNull T t2) {
        return this.cache.containsKey(t2);
    }

    @Nullable
    public synchronized Y get(@NonNull T t2) {
        Entry<Y> entry;
        entry = this.cache.get(t2);
        return entry != null ? entry.value : null;
    }

    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public int getSize(@Nullable Y y10) {
        return 1;
    }

    public void onItemEvicted(@NonNull T t2, @Nullable Y y10) {
    }

    @Nullable
    public synchronized Y put(@NonNull T t2, @Nullable Y y10) {
        int size = getSize(y10);
        long j10 = size;
        if (j10 >= this.maxSize) {
            onItemEvicted(t2, y10);
            return null;
        }
        if (y10 != null) {
            this.currentSize += j10;
        }
        Entry<Y> put = this.cache.put(t2, y10 == null ? null : new Entry<>(y10, size));
        if (put != null) {
            this.currentSize -= put.size;
            if (!put.value.equals(y10)) {
                onItemEvicted(t2, put.value);
            }
        }
        evict();
        return put != null ? put.value : null;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t2) {
        Entry<Y> remove = this.cache.remove(t2);
        if (remove == null) {
            return null;
        }
        this.currentSize -= remove.size;
        return remove.value;
    }

    public synchronized void setSizeMultiplier(float f10) {
        if (f10 >= 0.0f) {
            this.maxSize = Math.round(((float) this.initialMaxSize) * f10);
            evict();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    public synchronized void trimToSize(long j10) {
        while (this.currentSize > j10) {
            Iterator<Map.Entry<T, Entry<Y>>> iterator2 = this.cache.entrySet().iterator2();
            Map.Entry<T, Entry<Y>> next = iterator2.next();
            Entry<Y> value = next.getValue();
            this.currentSize -= value.size;
            T key = next.getKey();
            iterator2.remove();
            onItemEvicted(key, value.value);
        }
    }
}
