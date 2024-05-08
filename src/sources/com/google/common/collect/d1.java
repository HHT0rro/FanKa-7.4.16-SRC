package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: Table.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface d1<R, C, V> {

    /* compiled from: Table.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a<R, C, V> {
        C getColumnKey();

        R getRowKey();

        V getValue();
    }

    Set<a<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C c4);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(Object obj, Object obj2);

    boolean containsColumn(Object obj);

    boolean containsRow(Object obj);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    V get(Object obj, Object obj2);

    int hashCode();

    boolean isEmpty();

    V put(R r10, C c4, V v2);

    void putAll(d1<? extends R, ? extends C, ? extends V> d1Var);

    V remove(Object obj, Object obj2);

    Map<C, V> row(R r10);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
