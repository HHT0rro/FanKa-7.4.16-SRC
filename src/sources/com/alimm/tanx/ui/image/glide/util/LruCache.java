package com.alimm.tanx.ui.image.glide.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LruCache<T, Y> {
    public final LinkedHashMap<T, Y> cache = new LinkedHashMap<>(100, 0.75f, true);
    public int currentSize = 0;
    public final int initialMaxSize;
    public int maxSize;

    public LruCache(int i10) {
        this.initialMaxSize = i10;
        this.maxSize = i10;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public boolean contains(T t2) {
        return this.cache.containsKey(t2);
    }

    public Y get(T t2) {
        return this.cache.get(t2);
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getSize(Y y10) {
        return 1;
    }

    public void onItemEvicted(T t2, Y y10) {
    }

    public Y put(T t2, Y y10) {
        if (getSize(y10) >= this.maxSize) {
            onItemEvicted(t2, y10);
            return null;
        }
        Y put = this.cache.put(t2, y10);
        if (y10 != null) {
            this.currentSize += getSize(y10);
        }
        if (put != null) {
            this.currentSize -= getSize(put);
        }
        evict();
        return put;
    }

    public Y remove(T t2) {
        Y remove = this.cache.remove(t2);
        if (remove != null) {
            this.currentSize -= getSize(remove);
        }
        return remove;
    }

    public void setSizeMultiplier(float f10) {
        if (f10 >= 0.0f) {
            this.maxSize = Math.round(this.initialMaxSize * f10);
            evict();
            return;
        }
        throw new IllegalArgumentException("Multiplier must be >= 0");
    }

    public void trimToSize(int i10) {
        while (this.currentSize > i10) {
            Map.Entry<T, Y> next = this.cache.entrySet().iterator2().next();
            Y value = next.getValue();
            this.currentSize -= getSize(value);
            T key = next.getKey();
            this.cache.remove(key);
            onItemEvicted(key, value);
        }
    }
}
