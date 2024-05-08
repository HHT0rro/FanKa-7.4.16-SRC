package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

/* compiled from: LoadingCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface f<K, V> extends c<K, V>, com.google.common.base.g<K, V> {
    @Override // com.google.common.base.g
    @Deprecated
    V apply(K k10);

    V get(K k10) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k10);

    void refresh(K k10);
}
