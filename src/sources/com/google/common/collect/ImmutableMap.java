package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    public static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                /* renamed from: iterator */
                public i1<Map.Entry<K, V>> iterator2() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract i1<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        /* renamed from: keySet */
        public /* bridge */ /* synthetic */ Set h() {
            return super.h();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends i1<Map.Entry<K, ImmutableSet<V>>> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f26261b;

            /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public class C0227a extends com.google.common.collect.b<K, ImmutableSet<V>> {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f26262b;

                public C0227a(a aVar, Map.Entry entry) {
                    this.f26262b = entry;
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f26262b.getKey();
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.f26262b.getValue());
                }
            }

            public a(MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
                this.f26261b = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0227a(this, (Map.Entry) this.f26261b.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f26261b.hasNext();
            }
        }

        private MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.h();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public i1<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(this, ImmutableMap.this.entrySet().iterator2());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SerializedForm<K, V> implements Serializable {
        private static final boolean USE_LEGACY_SERIALIZATION = true;
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        public SerializedForm(ImmutableMap<K, V> immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            i1<Map.Entry<K, V>> iterator2 = immutableMap.entrySet().iterator2();
            int i10 = 0;
            while (iterator2.hasNext()) {
                Map.Entry<K, V> next = iterator2.next();
                objArr[i10] = next.getKey();
                objArr2[i10] = next.getValue();
                i10++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object legacyReadResolve() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            b<K, V> makeBuilder = makeBuilder(objArr.length);
            for (int i10 = 0; i10 < objArr.length; i10++) {
                makeBuilder.g(objArr[i10], objArr2[i10]);
            }
            return makeBuilder.d();
        }

        public b<K, V> makeBuilder(int i10) {
            return new b<>(i10);
        }

        public final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof ImmutableSet)) {
                return legacyReadResolve();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            ImmutableCollection immutableCollection = (ImmutableCollection) this.values;
            b<K, V> makeBuilder = makeBuilder(immutableSet.size());
            i1 iterator2 = immutableSet.iterator2();
            i1 iterator22 = immutableCollection.iterator2();
            while (iterator2.hasNext()) {
                makeBuilder.g(iterator2.next(), iterator22.next());
            }
            return makeBuilder.d();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends i1<K> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i1 f26263b;

        public a(ImmutableMap immutableMap, i1 i1Var) {
            this.f26263b = i1Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26263b.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f26263b.next()).getKey();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Comparator<? super V> f26264a;

        /* renamed from: b, reason: collision with root package name */
        public Object[] f26265b;

        /* renamed from: c, reason: collision with root package name */
        public int f26266c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f26267d;

        /* renamed from: e, reason: collision with root package name */
        public a f26268e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final Object f26269a;

            /* renamed from: b, reason: collision with root package name */
            public final Object f26270b;

            /* renamed from: c, reason: collision with root package name */
            public final Object f26271c;

            public a(Object obj, Object obj2, Object obj3) {
                this.f26269a = obj;
                this.f26270b = obj2;
                this.f26271c = obj3;
            }

            public IllegalArgumentException a() {
                String valueOf = String.valueOf(this.f26269a);
                String valueOf2 = String.valueOf(this.f26270b);
                String valueOf3 = String.valueOf(this.f26269a);
                String valueOf4 = String.valueOf(this.f26271c);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
                sb2.append("Multiple entries with same key: ");
                sb2.append(valueOf);
                sb2.append("=");
                sb2.append(valueOf2);
                sb2.append(" and ");
                sb2.append(valueOf3);
                sb2.append("=");
                sb2.append(valueOf4);
                return new IllegalArgumentException(sb2.toString());
            }
        }

        public b() {
            this(4);
        }

        public static <V> void k(Object[] objArr, int i10, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 2;
                Object obj = objArr[i12];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i12 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i11] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i10, Ordering.from(comparator).onResultOf(Maps.K()));
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                objArr[i14] = entryArr[i13].getKey();
                objArr[i14 + 1] = entryArr[i13].getValue();
            }
        }

        public ImmutableMap<K, V> a() {
            return d();
        }

        public final ImmutableMap<K, V> b(boolean z10) {
            Object[] objArr;
            a aVar;
            a aVar2;
            if (z10 && (aVar2 = this.f26268e) != null) {
                throw aVar2.a();
            }
            int i10 = this.f26266c;
            if (this.f26264a == null) {
                objArr = this.f26265b;
            } else {
                if (this.f26267d) {
                    this.f26265b = Arrays.copyOf(this.f26265b, i10 * 2);
                }
                objArr = this.f26265b;
                if (!z10) {
                    objArr = f(objArr, this.f26266c);
                    if (objArr.length < this.f26265b.length) {
                        i10 = objArr.length >>> 1;
                    }
                }
                k(objArr, i10, this.f26264a);
            }
            this.f26267d = true;
            RegularImmutableMap create = RegularImmutableMap.create(i10, objArr, this);
            if (!z10 || (aVar = this.f26268e) == null) {
                return create;
            }
            throw aVar.a();
        }

        public ImmutableMap<K, V> c() {
            return b(false);
        }

        public ImmutableMap<K, V> d() {
            return b(true);
        }

        public final void e(int i10) {
            int i11 = i10 * 2;
            Object[] objArr = this.f26265b;
            if (i11 > objArr.length) {
                this.f26265b = Arrays.copyOf(objArr, ImmutableCollection.b.e(objArr.length, i11));
                this.f26267d = false;
            }
        }

        public final Object[] f(Object[] objArr, int i10) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                Object obj = objArr[i11 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i11);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i10 - bitSet.cardinality()) * 2];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10 * 2) {
                if (bitSet.get(i12 >>> 1)) {
                    i12 += 2;
                } else {
                    int i14 = i13 + 1;
                    int i15 = i12 + 1;
                    Object obj2 = objArr[i12];
                    Objects.requireNonNull(obj2);
                    objArr2[i13] = obj2;
                    i13 = i14 + 1;
                    i12 = i15 + 1;
                    Object obj3 = objArr[i15];
                    Objects.requireNonNull(obj3);
                    objArr2[i14] = obj3;
                }
            }
            return objArr2;
        }

        public b<K, V> g(K k10, V v2) {
            e(this.f26266c + 1);
            m.a(k10, v2);
            Object[] objArr = this.f26265b;
            int i10 = this.f26266c;
            objArr[i10 * 2] = k10;
            objArr[(i10 * 2) + 1] = v2;
            this.f26266c = i10 + 1;
            return this;
        }

        public b<K, V> h(Map.Entry<? extends K, ? extends V> entry) {
            return g(entry.getKey(), entry.getValue());
        }

        public b<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                e(this.f26266c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                h(iterator2.next());
            }
            return this;
        }

        public b<K, V> j(Map<? extends K, ? extends V> map) {
            return i(map.entrySet());
        }

        public b(int i10) {
            this.f26265b = new Object[i10 * 2];
            this.f26266c = 0;
            this.f26267d = false;
        }
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    public static <K, V> b<K, V> builderWithExpectedSize(int i10) {
        m.b(i10, "expectedSize");
        return new b<>(i10);
    }

    public static void checkNoConflict(boolean z10, String str, Object obj, Object obj2) {
        if (!z10) {
            throw conflictException(str, obj, obj2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34 + valueOf.length() + valueOf2.length());
        sb2.append("Multiple entries with same ");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(valueOf);
        sb2.append(" and ");
        sb2.append(valueOf2);
        return new IllegalArgumentException(sb2.toString());
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k10, V v2) {
        m.a(k10, v2);
        return new AbstractMap.SimpleImmutableEntry(k10, v2);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf(Arrays.asList(entryArr));
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Maps.i(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v2) {
        V v10 = get(obj);
        return v10 != null ? v10 : v2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.b(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public i1<K> keyIterator() {
        return new a(this, entrySet().iterator2());
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.z(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2) {
        m.a(k10, v2);
        return RegularImmutableMap.create(1, new Object[]{k10, v2});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public ImmutableSet<K> h() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10) {
        m.a(k10, v2);
        m.a(k11, v10);
        return RegularImmutableMap.create(2, new Object[]{k10, v2, k11, v10});
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        bVar.i(iterable);
        return bVar.a();
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        return RegularImmutableMap.create(3, new Object[]{k10, v2, k11, v10, k12, v11});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        return RegularImmutableMap.create(4, new Object[]{k10, v2, k11, v10, k12, v11, k13, v12});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        return RegularImmutableMap.create(5, new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        return RegularImmutableMap.create(6, new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        m.a(k16, v15);
        return RegularImmutableMap.create(7, new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15, K k17, V v16) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        m.a(k16, v15);
        m.a(k17, v16);
        return RegularImmutableMap.create(8, new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15, k17, v16});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15, K k17, V v16, K k18, V v17) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        m.a(k16, v15);
        m.a(k17, v16);
        m.a(k18, v17);
        return RegularImmutableMap.create(9, new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15, k17, v16, k18, v17});
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15, K k17, V v16, K k18, V v17, K k19, V v18) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        m.a(k16, v15);
        m.a(k17, v16);
        m.a(k18, v17);
        m.a(k19, v18);
        return RegularImmutableMap.create(10, new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15, k17, v16, k18, v17, k19, v18});
    }
}
