package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: SortedSetMultimap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface c1<K, V> extends w0<K, V> {
    @Override // com.google.common.collect.w0, com.google.common.collect.j0
    SortedSet<V> get(K k10);

    @Override // com.google.common.collect.w0, com.google.common.collect.j0
    SortedSet<V> removeAll(Object obj);

    @Override // com.google.common.collect.w0, com.google.common.collect.j0
    SortedSet<V> replaceValues(K k10, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
