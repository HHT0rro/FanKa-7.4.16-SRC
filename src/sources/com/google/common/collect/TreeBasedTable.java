package com.google.common.collect;

import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Factory<C, V> implements com.google.common.base.t<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        public final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // com.google.common.base.t
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends AbstractIterator<C> {

        /* renamed from: d, reason: collision with root package name */
        public C f26512d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Iterator f26513e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Comparator f26514f;

        public a(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.f26513e = it;
            this.f26514f = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            while (this.f26513e.hasNext()) {
                C c4 = (C) this.f26513e.next();
                C c10 = this.f26512d;
                if (!(c10 != null && this.f26514f.compare(c4, c10) == 0)) {
                    this.f26512d = c4;
                    return c4;
                }
            }
            this.f26512d = null;
            return b();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends StandardTable<R, C, V>.g implements SortedMap<C, V> {

        /* renamed from: e, reason: collision with root package name */
        public final C f26515e;

        /* renamed from: f, reason: collision with root package name */
        public final C f26516f;

        /* renamed from: g, reason: collision with root package name */
        public transient SortedMap<C, V> f26517g;

        public b(TreeBasedTable treeBasedTable, R r10) {
            this(r10, null, null);
        }

        @Override // com.google.common.collect.StandardTable.g
        public void c() {
            j();
            SortedMap<C, V> sortedMap = this.f26517g;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.f26495b);
            this.f26517g = null;
            this.f26496c = null;
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return i(obj) && super.containsKey(obj);
        }

        public int f(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            d();
            Map<C, V> map = this.f26496c;
            if (map != null) {
                return (C) ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.g
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> b() {
            j();
            SortedMap<C, V> sortedMap = this.f26517g;
            if (sortedMap == null) {
                return null;
            }
            C c4 = this.f26515e;
            if (c4 != null) {
                sortedMap = sortedMap.tailMap(c4);
            }
            C c10 = this.f26516f;
            return c10 != null ? sortedMap.headMap(c10) : sortedMap;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public SortedSet<C> h() {
            return new Maps.o(this);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<C, V> headMap(C c4) {
            com.google.common.base.o.d(i(com.google.common.base.o.r(c4)));
            return new b(this.f26495b, this.f26515e, c4);
        }

        public boolean i(Object obj) {
            C c4;
            C c10;
            return obj != null && ((c4 = this.f26515e) == null || f(c4, obj) <= 0) && ((c10 = this.f26516f) == null || f(c10, obj) > 0);
        }

        public void j() {
            SortedMap<C, V> sortedMap = this.f26517g;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f26495b))) {
                this.f26517g = (SortedMap) TreeBasedTable.this.backingMap.get(this.f26495b);
            }
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            d();
            Map<C, V> map = this.f26496c;
            if (map != null) {
                return (C) ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public V put(C c4, V v2) {
            com.google.common.base.o.d(i(com.google.common.base.o.r(c4)));
            return (V) super.put(c4, v2);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<C, V> subMap(C c4, C c10) {
            com.google.common.base.o.d(i(com.google.common.base.o.r(c4)) && i(com.google.common.base.o.r(c10)));
            return new b(this.f26495b, c4, c10);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<C, V> tailMap(C c4) {
            com.google.common.base.o.d(i(com.google.common.base.o.r(c4)));
            return new b(this.f26495b, c4, this.f26516f);
        }

        public b(R r10, C c4, C c10) {
            super(r10);
            this.f26515e = c4;
            this.f26516f = c10;
            com.google.common.base.o.d(c4 == null || c10 == null || f(c4, c10) <= 0);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$createColumnKeyIterator$0(Map map) {
        return map.h().iterator2();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> columnComparator = columnComparator();
        return new a(this, Iterators.p(g0.o(this.backingMap.values(), new com.google.common.base.g() { // from class: com.google.common.collect.h1
            @Override // com.google.common.base.g
            public final Object apply(Object obj) {
                Iterator lambda$createColumnKeyIterator$0;
                lambda$createColumnKeyIterator$0 = TreeBasedTable.lambda$createColumnKeyIterator$0((Map) obj);
                return lambda$createColumnKeyIterator$0;
            }
        }), columnComparator), columnComparator);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ void putAll(d1 d1Var) {
        super.putAll(d1Var);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((TreeBasedTable<R, C, V>) obj);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        com.google.common.base.o.r(comparator);
        com.google.common.base.o.r(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.d1
    public SortedMap<C, V> row(R r10) {
        return new b(this, r10);
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.d1
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.d1
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
