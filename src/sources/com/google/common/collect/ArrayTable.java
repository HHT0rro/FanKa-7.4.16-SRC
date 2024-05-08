package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Tables;
import com.google.common.collect.d1;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ArrayTable<R, C, V> extends i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ArrayTable<R, C, V>.f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient ArrayTable<R, C, V>.h rowMap;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends com.google.common.collect.a<d1.a<R, C, V>> {
        public a(int i10) {
            super(i10);
        }

        @Override // com.google.common.collect.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d1.a<R, C, V> a(int i10) {
            return ArrayTable.this.getCell(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends Tables.b<R, C, V> {

        /* renamed from: b, reason: collision with root package name */
        public final int f26190b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26191c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f26192d;

        public b(int i10) {
            this.f26192d = i10;
            this.f26190b = i10 / ArrayTable.this.columnList.size();
            this.f26191c = i10 % ArrayTable.this.columnList.size();
        }

        @Override // com.google.common.collect.d1.a
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.f26191c);
        }

        @Override // com.google.common.collect.d1.a
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.f26190b);
        }

        @Override // com.google.common.collect.d1.a
        public V getValue() {
            return (V) ArrayTable.this.at(this.f26190b, this.f26191c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends com.google.common.collect.a<V> {
        public c(int i10) {
            super(i10);
        }

        @Override // com.google.common.collect.a
        public V a(int i10) {
            return (V) ArrayTable.this.getValue(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class d<K, V> extends Maps.l<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableMap<K, Integer> f26195b;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends com.google.common.collect.b<K, V> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f26196b;

            public a(int i10) {
                this.f26196b = i10;
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.c(this.f26196b);
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public V getValue() {
                return (V) d.this.e(this.f26196b);
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public V setValue(V v2) {
                return (V) d.this.f(this.f26196b, v2);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends com.google.common.collect.a<Map.Entry<K, V>> {
            public b(int i10) {
                super(i10);
            }

            @Override // com.google.common.collect.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a(int i10) {
                return d.this.b(i10);
            }
        }

        public /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        public Map.Entry<K, V> b(int i10) {
            com.google.common.base.o.p(i10, size());
            return new a(i10);
        }

        public K c(int i10) {
            return this.f26195b.h().asList().get(i10);
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f26195b.containsKey(obj);
        }

        public abstract String d();

        public abstract V e(int i10);

        public abstract V f(int i10, V v2);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer num = this.f26195b.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f26195b.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return this.f26195b.h();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k10, V v2) {
            Integer num = this.f26195b.get(k10);
            if (num != null) {
                return f(num.intValue(), v2);
            }
            String d10 = d();
            String valueOf = String.valueOf(k10);
            String valueOf2 = String.valueOf(this.f26195b.h());
            StringBuilder sb2 = new StringBuilder(String.valueOf(d10).length() + 9 + valueOf.length() + valueOf2.length());
            sb2.append(d10);
            sb2.append(" ");
            sb2.append(valueOf);
            sb2.append(" not in ");
            sb2.append(valueOf2);
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f26195b.size();
        }

        public d(ImmutableMap<K, Integer> immutableMap) {
            this.f26195b = immutableMap;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class e extends d<R, V> {

        /* renamed from: c, reason: collision with root package name */
        public final int f26199c;

        public e(int i10) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f26199c = i10;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i10) {
            return (V) ArrayTable.this.at(i10, this.f26199c);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i10, V v2) {
            return (V) ArrayTable.this.set(i10, this.f26199c, v2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class f extends d<C, Map<R, V>> {
        public /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map<R, V> e(int i10) {
            return new e(i10);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<R, V> put(C c4, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<R, V> f(int i10, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class g extends d<C, V> {

        /* renamed from: c, reason: collision with root package name */
        public final int f26202c;

        public g(int i10) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f26202c = i10;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i10) {
            return (V) ArrayTable.this.at(this.f26202c, i10);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i10, V v2) {
            return (V) ArrayTable.this.set(this.f26202c, i10, v2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class h extends d<R, Map<C, V>> {
        public /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map<C, V> e(int i10) {
            return new g(i10);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<C, V> put(R r10, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<C, V> f(int i10, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        com.google.common.base.o.d(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = Maps.k(copyOf);
        this.columnKeyToIndex = Maps.k(copyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, copyOf.size(), copyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d1.a<R, C, V> getCell(int i10) {
        return new b(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i10) {
        return at(i10 / this.columnList.size(), i10 % this.columnList.size());
    }

    public V at(int i10, int i11) {
        com.google.common.base.o.p(i10, this.rowList.size());
        com.google.common.base.o.p(i11, this.columnList.size());
        return this.array[i10][i11];
    }

    @Override // com.google.common.collect.i
    public Iterator<d1.a<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public Set<d1.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.d1
    public Map<R, V> column(C c4) {
        com.google.common.base.o.r(c4);
        Integer num = this.columnKeyToIndex.get(c4);
        if (num == null) {
            return Collections.emptyMap();
        }
        return new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.d1
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f(this, null);
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean containsValue(Object obj) {
        for (V[] vArr : this.array) {
            for (V v2 : vArr) {
                if (com.google.common.base.l.a(obj, v2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public V erase(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public V put(R r10, C c4, V v2) {
        com.google.common.base.o.r(r10);
        com.google.common.base.o.r(c4);
        Integer num = this.rowKeyToIndex.get(r10);
        com.google.common.base.o.n(num != null, "Row %s not in %s", r10, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c4);
        com.google.common.base.o.n(num2 != null, "Column %s not in %s", c4, this.columnList);
        return set(num.intValue(), num2.intValue(), v2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public void putAll(d1<? extends R, ? extends C, ? extends V> d1Var) {
        super.putAll(d1Var);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.d1
    public Map<C, V> row(R r10) {
        com.google.common.base.o.r(r10);
        Integer num = this.rowKeyToIndex.get(r10);
        if (num == null) {
            return Collections.emptyMap();
        }
        return new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.d1
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar != null) {
            return hVar;
        }
        ArrayTable<R, C, V>.h hVar2 = new h(this, null);
        this.rowMap = hVar2;
        return hVar2;
    }

    public V set(int i10, int i11, V v2) {
        com.google.common.base.o.p(i10, this.rowList.size());
        com.google.common.base.o.p(i11, this.columnList.size());
        V[][] vArr = this.array;
        V v10 = vArr[i10][i11];
        vArr[i10][i11] = v2;
        return v10;
    }

    @Override // com.google.common.collect.d1
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i10], 0, vArr[i10], 0, vArr2[i10].length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.i
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(d1<R, C, ? extends V> d1Var) {
        if (d1Var instanceof ArrayTable) {
            return new ArrayTable<>((ArrayTable) d1Var);
        }
        return new ArrayTable<>(d1Var);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.h();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(d1<R, C, ? extends V> d1Var) {
        this(d1Var.rowKeySet(), d1Var.columnKeySet());
        putAll(d1Var);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i10], 0, vArr[i10], 0, vArr2[i10].length);
        }
    }
}
