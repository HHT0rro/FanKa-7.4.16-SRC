package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Tables;
import com.google.common.collect.d1;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableTable<R, C, V> extends i<R, C, V> implements Serializable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        private SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        public Object readResolve() {
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i10 = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            ImmutableList.a aVar = new ImmutableList.a(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i10 < objArr2.length) {
                    aVar.a(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i10]], this.columnKeys[this.cellColumnIndices[i10]], objArr2[i10]));
                    i10++;
                } else {
                    return RegularImmutableTable.forOrderedComponents(aVar.k(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a<R, C, V> {

        /* renamed from: a, reason: collision with root package name */
        public final List<d1.a<R, C, V>> f26313a = Lists.j();

        /* renamed from: b, reason: collision with root package name */
        public Comparator<? super R> f26314b;

        /* renamed from: c, reason: collision with root package name */
        public Comparator<? super C> f26315c;

        public ImmutableTable<R, C, V> a() {
            return b();
        }

        public ImmutableTable<R, C, V> b() {
            int size = this.f26313a.size();
            if (size == 0) {
                return ImmutableTable.of();
            }
            if (size != 1) {
                return RegularImmutableTable.forCells(this.f26313a, this.f26314b, this.f26315c);
            }
            return new SingletonImmutableTable((d1.a) g0.i(this.f26313a));
        }

        public a<R, C, V> c(d1.a<? extends R, ? extends C, ? extends V> aVar) {
            if (aVar instanceof Tables.ImmutableCell) {
                com.google.common.base.o.s(aVar.getRowKey(), "row");
                com.google.common.base.o.s(aVar.getColumnKey(), "column");
                com.google.common.base.o.s(aVar.getValue(), "value");
                this.f26313a.add(aVar);
            } else {
                d(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
            }
            return this;
        }

        public a<R, C, V> d(R r10, C c4, V v2) {
            this.f26313a.add(ImmutableTable.cellOf(r10, c4, v2));
            return this;
        }
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a<>();
    }

    public static <R, C, V> d1.a<R, C, V> cellOf(R r10, C c4, V v2) {
        return Tables.c(com.google.common.base.o.s(r10, "rowKey"), com.google.common.base.o.s(c4, "columnKey"), com.google.common.base.o.s(v2, "value"));
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(d1<? extends R, ? extends C, ? extends V> d1Var) {
        if (d1Var instanceof ImmutableTable) {
            return (ImmutableTable) d1Var;
        }
        return copyOf(d1Var.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((ImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.d1
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean contains(Object obj, Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.i
    public abstract ImmutableSet<d1.a<R, C, V>> createCellSet();

    public abstract SerializedForm createSerializedForm();

    @Override // com.google.common.collect.i
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    @Deprecated
    public final V put(R r10, C c4, V v2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    @Deprecated
    public final void putAll(d1<? extends R, ? extends C, ? extends V> d1Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d1
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((ImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.d1
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.d1
    public abstract /* synthetic */ int size();

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i
    public final Iterator<V> valuesIterator() {
        throw new AssertionError((Object) "should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r10, C c4, V v2) {
        return new SingletonImmutableTable(r10, c4, v2);
    }

    @Override // com.google.common.collect.i
    public final i1<d1.a<R, C, V>> cellIterator() {
        throw new AssertionError((Object) "should never be called");
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public ImmutableSet<d1.a<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.d1
    public ImmutableMap<R, V> column(C c4) {
        com.google.common.base.o.s(c4, "columnKey");
        return (ImmutableMap) com.google.common.base.j.a((ImmutableMap) columnMap().get(c4), ImmutableMap.of());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public ImmutableSet<C> columnKeySet() {
        return columnMap().h();
    }

    @Override // com.google.common.collect.d1
    public ImmutableMap<C, V> row(R r10) {
        com.google.common.base.o.s(r10, "rowKey");
        return (ImmutableMap) com.google.common.base.j.a((ImmutableMap) rowMap().get(r10), ImmutableMap.of());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public ImmutableSet<R> rowKeySet() {
        return rowMap().h();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends d1.a<? extends R, ? extends C, ? extends V>> iterable) {
        a builder = builder();
        Iterator<? extends d1.a<? extends R, ? extends C, ? extends V>> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            builder.c(iterator2.next());
        }
        return builder.a();
    }
}
