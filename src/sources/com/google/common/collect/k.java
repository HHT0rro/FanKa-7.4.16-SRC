package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* compiled from: BiMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface k<K, V> extends Map<K, V> {
    V forcePut(K k10, V v2);

    k<V, K> inverse();

    @Override // java.util.Map
    Set<V> values();
}
