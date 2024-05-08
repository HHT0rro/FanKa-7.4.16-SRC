package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface MultiValuedMap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsKey(Object obj);

    boolean containsMapping(Object obj, Object obj2);

    boolean containsValue(Object obj);

    Collection<Map.Entry<K, V>> entries();

    Collection<V> get(K k10);

    boolean isEmpty();

    Set<K> keySet();

    MultiSet<K> keys();

    MapIterator<K, V> mapIterator();

    boolean put(K k10, V v2);

    boolean putAll(K k10, Iterable<? extends V> iterable);

    boolean putAll(Map<? extends K, ? extends V> map);

    boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap);

    Collection<V> remove(Object obj);

    boolean removeMapping(Object obj, Object obj2);

    int size();

    Collection<V> values();
}
