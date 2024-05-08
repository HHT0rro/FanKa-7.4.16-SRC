package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: Multimap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface j0<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(Object obj, Object obj2);

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(Object obj);

    Collection<V> get(K k10);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    k0<K> keys();

    boolean put(K k10, V v2);

    boolean putAll(j0<? extends K, ? extends V> j0Var);

    boolean putAll(K k10, Iterable<? extends V> iterable);

    boolean remove(Object obj, Object obj2);

    Collection<V> removeAll(Object obj);

    Collection<V> replaceValues(K k10, Iterable<? extends V> iterable);

    int size();

    Collection<V> values();
}
