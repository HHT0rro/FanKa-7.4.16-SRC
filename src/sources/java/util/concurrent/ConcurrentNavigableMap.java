package java.util.concurrent;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ConcurrentNavigableMap<K, V> extends ConcurrentMap<K, V>, NavigableMap<K, V> {
    @Override // java.util.NavigableMap
    NavigableSet<K> descendingKeySet();

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> descendingMap();

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> headMap(K k10);

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> headMap(K k10, boolean z10);

    @Override // java.util.Map
    /* renamed from: keySet */
    NavigableSet<K> h();

    @Override // java.util.NavigableMap
    NavigableSet<K> navigableKeySet();

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> subMap(K k10, K k11);

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11);

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> tailMap(K k10);

    @Override // java.util.NavigableMap
    ConcurrentNavigableMap<K, V> tailMap(K k10, boolean z10);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* bridge */ /* synthetic */ default NavigableMap headMap(Object obj, boolean z10) {
        return headMap((ConcurrentNavigableMap<K, V>) obj, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* bridge */ /* synthetic */ default SortedMap headMap(Object obj) {
        return headMap((ConcurrentNavigableMap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* bridge */ /* synthetic */ default NavigableMap subMap(Object obj, boolean z10, Object obj2, boolean z11) {
        return subMap((boolean) obj, z10, (boolean) obj2, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* bridge */ /* synthetic */ default NavigableMap tailMap(Object obj, boolean z10) {
        return tailMap((ConcurrentNavigableMap<K, V>) obj, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* bridge */ /* synthetic */ default SortedMap tailMap(Object obj) {
        return tailMap((ConcurrentNavigableMap<K, V>) obj);
    }
}
