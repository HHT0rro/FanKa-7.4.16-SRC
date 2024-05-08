package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements u0<R, C, V> {
    private static final long serialVersionUID = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends StandardTable<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        public b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.sortedBackingMap().comparator();
        }

        @Override // com.google.common.collect.Maps.u
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> g() {
            return new Maps.o(this);
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().firstKey();
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> h() {
            return (SortedSet) super.h();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<R, Map<C, V>> headMap(R r10) {
            com.google.common.base.o.r(r10);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(r10), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) StandardRowSortedTable.this.sortedBackingMap().lastKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<R, Map<C, V>> subMap(R r10, R r11) {
            com.google.common.base.o.r(r10);
            com.google.common.base.o.r(r11);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(r10, r11), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<R, Map<C, V>> tailMap(R r10) {
            com.google.common.base.o.r(r10);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(r10), StandardRowSortedTable.this.factory).rowMap();
        }
    }

    public StandardRowSortedTable(SortedMap<R, Map<C, V>> sortedMap, com.google.common.base.t<? extends Map<C, V>> tVar) {
        super(sortedMap, tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) this.backingMap;
    }

    @Override // com.google.common.collect.StandardTable
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new b();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().h();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.d1
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
