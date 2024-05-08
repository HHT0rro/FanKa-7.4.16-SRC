package com.huawei.quickcard.framework.cache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface CacheInterface<K, V> {
    void clear();

    V get(K k10);

    boolean has(K k10);

    void put(K k10, V v2);

    V remove(K k10);
}
