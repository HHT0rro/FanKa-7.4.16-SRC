package com.google.common.collect;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: RowSortedTable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface u0<R, C, V> extends d1<R, C, V> {
    @Override // com.google.common.collect.d1
    SortedSet<R> rowKeySet();

    @Override // com.google.common.collect.d1
    SortedMap<R, Map<C, V>> rowMap();
}
