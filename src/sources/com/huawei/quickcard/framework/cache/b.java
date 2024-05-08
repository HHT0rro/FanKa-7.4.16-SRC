package com.huawei.quickcard.framework.cache;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b<K, V> implements CacheInterface<K, V> {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f33833b = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private final Map<K, V> f33834a = new HashMap();

    @Override // com.huawei.quickcard.framework.cache.CacheInterface
    public void clear() {
        synchronized (f33833b) {
            this.f33834a.clear();
        }
    }

    @Override // com.huawei.quickcard.framework.cache.CacheInterface
    public V get(K k10) {
        V v2;
        synchronized (f33833b) {
            v2 = this.f33834a.get(k10);
        }
        return v2;
    }

    @Override // com.huawei.quickcard.framework.cache.CacheInterface
    public boolean has(K k10) {
        boolean containsKey;
        synchronized (f33833b) {
            containsKey = this.f33834a.containsKey(k10);
        }
        return containsKey;
    }

    @Override // com.huawei.quickcard.framework.cache.CacheInterface
    public void put(K k10, V v2) {
        synchronized (f33833b) {
            this.f33834a.put(k10, v2);
        }
    }

    @Override // com.huawei.quickcard.framework.cache.CacheInterface
    public V remove(K k10) {
        V remove;
        synchronized (f33833b) {
            remove = this.f33834a.remove(k10);
        }
        return remove;
    }
}
