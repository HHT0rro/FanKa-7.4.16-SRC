package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface BidiMap<K, V> extends IterableMap<K, V> {
    K getKey(Object obj);

    BidiMap<V, K> inverseBidiMap();

    @Override // java.util.Map
    V put(K k10, V v2);

    K removeValue(Object obj);

    @Override // java.util.Map
    /* bridge */ /* synthetic */ Collection values();

    @Override // java.util.Map
    Set<V> values();
}
