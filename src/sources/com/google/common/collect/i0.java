package com.google.common.collect;

import java.util.List;

/* compiled from: ListMultimap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface i0<K, V> extends j0<K, V> {
    @Override // com.google.common.collect.j0
    List<V> get(K k10);

    @Override // com.google.common.collect.j0
    List<V> removeAll(Object obj);

    @Override // com.google.common.collect.j0
    List<V> replaceValues(K k10, Iterable<? extends V> iterable);
}
