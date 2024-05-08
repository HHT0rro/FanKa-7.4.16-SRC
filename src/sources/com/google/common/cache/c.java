package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* compiled from: Cache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface c<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K k10, Callable<? extends V> callable) throws ExecutionException;

    ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable);

    V getIfPresent(Object obj);

    void invalidate(Object obj);

    void invalidateAll();

    void invalidateAll(Iterable<? extends Object> iterable);

    void put(K k10, V v2);

    void putAll(Map<? extends K, ? extends V> map);

    long size();

    d stats();
}
