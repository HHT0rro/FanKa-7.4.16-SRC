package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

/* compiled from: ForwardingConcurrentMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class t<K, V> extends v<K, V> implements ConcurrentMap<K, V> {
    @Override // com.google.common.collect.v, com.google.common.collect.z
    public abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k10, V v2) {
        return delegate().putIfAbsent(k10, v2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k10, V v2) {
        return delegate().replace(k10, v2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k10, V v2, V v10) {
        return delegate().replace(k10, v2, v10);
    }
}
