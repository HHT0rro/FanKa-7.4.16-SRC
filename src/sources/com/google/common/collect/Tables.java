package com.google.common.collect;

import com.google.common.collect.d1;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Tables {

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.common.base.g<? extends Map<?, ?>, ? extends Map<?, ?>> f26511a = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class ImmutableCell<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final C columnKey;
        private final R rowKey;
        private final V value;

        public ImmutableCell(R r10, C c4, V v2) {
            this.rowKey = r10;
            this.columnKey = c4;
            this.value = v2;
        }

        @Override // com.google.common.collect.d1.a
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.d1.a
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.d1.a
        public V getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements u0<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(u0<R, ? extends C, ? extends V> u0Var) {
            super(u0Var);
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.e0, com.google.common.collect.d1
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.e0, com.google.common.collect.d1
        public SortedMap<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableSortedMap(Maps.E(delegate().rowMap(), Tables.a()));
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.e0, com.google.common.collect.z
        public u0<R, C, V> delegate() {
            return (u0) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UnmodifiableTable<R, C, V> extends e0<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final d1<? extends R, ? extends C, ? extends V> delegate;

        public UnmodifiableTable(d1<? extends R, ? extends C, ? extends V> d1Var) {
            this.delegate = (d1) com.google.common.base.o.r(d1Var);
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public Set<d1.a<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public Map<R, V> column(C c4) {
            return Collections.unmodifiableMap(super.column(c4));
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(Maps.D(super.columnMap(), Tables.a()));
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public V put(R r10, C c4, V v2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public void putAll(d1<? extends R, ? extends C, ? extends V> d1Var) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public V remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public Map<C, V> row(R r10) {
            return Collections.unmodifiableMap(super.row(r10));
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public Map<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableMap(Maps.D(super.rowMap(), Tables.a()));
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.d1
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        @Override // com.google.common.collect.e0, com.google.common.collect.z
        public d1<R, C, V> delegate() {
            return this.delegate;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements com.google.common.base.g<Map<Object, Object>, Map<Object, Object>> {
        @Override // com.google.common.base.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b<R, C, V> implements d1.a<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d1.a)) {
                return false;
            }
            d1.a aVar = (d1.a) obj;
            return com.google.common.base.l.a(getRowKey(), aVar.getRowKey()) && com.google.common.base.l.a(getColumnKey(), aVar.getColumnKey()) && com.google.common.base.l.a(getValue(), aVar.getValue());
        }

        public int hashCode() {
            return com.google.common.base.l.b(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            String valueOf = String.valueOf(getRowKey());
            String valueOf2 = String.valueOf(getColumnKey());
            String valueOf3 = String.valueOf(getValue());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + valueOf2.length() + valueOf3.length());
            sb2.append("(");
            sb2.append(valueOf);
            sb2.append(",");
            sb2.append(valueOf2);
            sb2.append(")=");
            sb2.append(valueOf3);
            return sb2.toString();
        }
    }

    public static /* synthetic */ com.google.common.base.g a() {
        return d();
    }

    public static boolean b(d1<?, ?, ?> d1Var, Object obj) {
        if (obj == d1Var) {
            return true;
        }
        if (obj instanceof d1) {
            return d1Var.cellSet().equals(((d1) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> d1.a<R, C, V> c(R r10, C c4, V v2) {
        return new ImmutableCell(r10, c4, v2);
    }

    public static <K, V> com.google.common.base.g<Map<K, V>, Map<K, V>> d() {
        return (com.google.common.base.g<Map<K, V>, Map<K, V>>) f26511a;
    }
}
