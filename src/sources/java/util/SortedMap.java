package java.util;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface SortedMap<K, V> extends Map<K, V> {
    Comparator<? super K> comparator();

    @Override // java.util.Map
    Set<Map.Entry<K, V>> entrySet();

    K firstKey();

    SortedMap<K, V> headMap(K k10);

    @Override // java.util.Map
    Set<K> keySet();

    K lastKey();

    SortedMap<K, V> subMap(K k10, K k11);

    SortedMap<K, V> tailMap(K k10);

    @Override // java.util.Map
    Collection<V> values();
}
