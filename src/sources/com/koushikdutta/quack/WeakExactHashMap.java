package com.koushikdutta.quack;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class WeakExactHashMap<K, V> {
    private HashMap<Entry<K>, V> map = new HashMap<>();
    private int purgeThreshold = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Entry<K> {
        public int hash;
        public WeakReference<K> key;

        public Entry(K k10) {
            if (k10 != null) {
                this.key = new WeakReference<>(k10);
                this.hash = k10.hashCode();
                return;
            }
            throw new IllegalArgumentException("key can not be null");
        }

        public boolean equals(Object obj) {
            Entry entry = (Entry) obj;
            K k10 = this.key.get();
            return k10 != null && entry.key.get() == k10;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    private void maybePurge() {
        if (this.map.size() < this.purgeThreshold) {
            return;
        }
        purge();
    }

    public void clear() {
        this.map.clear();
    }

    public V get(K k10) {
        maybePurge();
        return this.map.get(new Entry(k10));
    }

    public int purge() {
        int size = this.map.size();
        Iterator<Entry<K>> iterator2 = this.map.h().iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().key.get() == null) {
                iterator2.remove();
            }
        }
        int size2 = this.map.size();
        setPurgeThreshold(size2 * 2);
        return size - size2;
    }

    public V put(K k10, V v2) {
        maybePurge();
        return this.map.put(new Entry<>(k10), v2);
    }

    public void setPurgeThreshold(int i10) {
        this.purgeThreshold = i10;
    }

    public int size() {
        return this.map.size();
    }
}
