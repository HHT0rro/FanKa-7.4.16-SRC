package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.z;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* compiled from: ForwardingCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class e<K, V> extends z implements c<K, V> {
    @Override // com.google.common.cache.c
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.cache.c
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // com.google.common.collect.z
    public abstract c<K, V> delegate();

    @Override // com.google.common.cache.c
    public V get(K k10, Callable<? extends V> callable) throws ExecutionException {
        return delegate().get(k10, callable);
    }

    @Override // com.google.common.cache.c
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable) {
        return delegate().getAllPresent(iterable);
    }

    @Override // com.google.common.cache.c
    public V getIfPresent(Object obj) {
        return delegate().getIfPresent(obj);
    }

    @Override // com.google.common.cache.c
    public void invalidate(Object obj) {
        delegate().invalidate(obj);
    }

    @Override // com.google.common.cache.c
    public void invalidateAll(Iterable<? extends Object> iterable) {
        delegate().invalidateAll(iterable);
    }

    @Override // com.google.common.cache.c
    public void put(K k10, V v2) {
        delegate().put(k10, v2);
    }

    @Override // com.google.common.cache.c
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // com.google.common.cache.c
    public long size() {
        return delegate().size();
    }

    @Override // com.google.common.cache.c
    public d stats() {
        return delegate().stats();
    }

    @Override // com.google.common.cache.c
    public void invalidateAll() {
        delegate().invalidateAll();
    }
}
