package com.google.common.collect;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* compiled from: ForwardingSortedMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class c0<K, V> extends v<K, V> implements SortedMap<K, V> {
    public static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.z
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    public SortedMap<K, V> headMap(K k10) {
        return delegate().headMap(k10);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v
    public boolean standardContainsKey(Object obj) {
        try {
            return unsafeCompare(comparator(), tailMap(obj).firstKey(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    public SortedMap<K, V> standardSubMap(K k10, K k11) {
        com.google.common.base.o.e(unsafeCompare(comparator(), k10, k11) <= 0, "fromKey must be <= toKey");
        return tailMap(k10).headMap(k11);
    }

    public SortedMap<K, V> subMap(K k10, K k11) {
        return delegate().subMap(k10, k11);
    }

    public SortedMap<K, V> tailMap(K k10) {
        return delegate().tailMap(k10);
    }
}
