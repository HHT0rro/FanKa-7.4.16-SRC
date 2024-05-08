package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* compiled from: SetMultimap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface w0<K, V> extends j0<K, V> {
    @Override // com.google.common.collect.j0
    Set<Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.j0
    Set<V> get(K k10);

    @Override // com.google.common.collect.j0
    Set<V> removeAll(Object obj);

    @Override // com.google.common.collect.j0
    Set<V> replaceValues(K k10, Iterable<? extends V> iterable);
}
