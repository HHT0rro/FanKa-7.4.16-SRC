package com.alibaba.fastjson.util;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class IdentityHashMap<K, V> {
    public static final int DEFAULT_SIZE = 8192;
    private final Entry<K, V>[] buckets;
    private final int indexMask;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Entry<K, V> {
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K k10, V v2, int i10, Entry<K, V> entry) {
            this.key = k10;
            this.value = v2;
            this.next = entry;
            this.hashCode = i10;
        }
    }

    public IdentityHashMap() {
        this(8192);
    }

    public void clear() {
        Arrays.fill(this.buckets, (Object) null);
    }

    public Class findClass(String str) {
        int i10 = 0;
        while (true) {
            Entry<K, V>[] entryArr = this.buckets;
            if (i10 >= entryArr.length) {
                return null;
            }
            Entry<K, V> entry = entryArr[i10];
            if (entry != null) {
                for (Entry<K, V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    K k10 = entry.key;
                    if (k10 instanceof Class) {
                        Class cls = (Class) k10;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i10++;
        }
    }

    public final V get(K k10) {
        for (Entry<K, V> entry = this.buckets[System.identityHashCode(k10) & this.indexMask]; entry != null; entry = entry.next) {
            if (k10 == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean put(K k10, V v2) {
        int identityHashCode = System.identityHashCode(k10);
        int i10 = this.indexMask & identityHashCode;
        for (Entry<K, V> entry = this.buckets[i10]; entry != null; entry = entry.next) {
            if (k10 == entry.key) {
                entry.value = v2;
                return true;
            }
        }
        this.buckets[i10] = new Entry<>(k10, v2, identityHashCode, this.buckets[i10]);
        return false;
    }

    public IdentityHashMap(int i10) {
        this.indexMask = i10 - 1;
        this.buckets = new Entry[i10];
    }
}
