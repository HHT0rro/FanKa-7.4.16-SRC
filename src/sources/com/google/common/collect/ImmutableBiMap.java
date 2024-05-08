package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements k<K, V> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public a<K, V> makeBuilder(int i10) {
            return new a<>(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> a() {
            return d();
        }

        @Override // com.google.common.collect.ImmutableMap.b
        @Deprecated
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public ImmutableBiMap<K, V> d() {
            int i10 = this.f26266c;
            if (i10 == 0) {
                return ImmutableBiMap.of();
            }
            if (this.f26264a != null) {
                if (this.f26267d) {
                    this.f26265b = Arrays.copyOf(this.f26265b, i10 * 2);
                }
                ImmutableMap.b.k(this.f26265b, this.f26266c, this.f26264a);
            }
            this.f26267d = true;
            return new RegularImmutableBiMap(this.f26265b, this.f26266c);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(K k10, V v2) {
            super.g(k10, v2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<K, V> h(Map.Entry<? extends K, ? extends V> entry) {
            super.h(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.i(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<K, V> j(Map<? extends K, ? extends V> map) {
            super.j(map);
            return this;
        }

        public a(int i10) {
            super(i10);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int i10) {
        m.b(i10, "expectedSize");
        return new a<>(i10);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf((Iterable) Arrays.asList(entryArr));
    }

    @Override // com.google.common.collect.k
    @Deprecated
    public final V forcePut(K k10, V v2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.k
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2) {
        m.a(k10, v2);
        return new RegularImmutableBiMap(new Object[]{k10, v2}, 1);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError((Object) "should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10) {
        m.a(k10, v2);
        m.a(k11, v10);
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().h();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4).i(iterable).a();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10, k12, v11}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10, k12, v11, k13, v12}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13}, 5);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14}, 6);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        m.a(k16, v15);
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15}, 7);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15, K k17, V v16) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        m.a(k16, v15);
        m.a(k17, v16);
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15, k17, v16}, 8);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15, K k17, V v16, K k18, V v17) {
        m.a(k10, v2);
        m.a(k11, v10);
        m.a(k12, v11);
        m.a(k13, v12);
        m.a(k14, v13);
        m.a(k15, v14);
        m.a(k16, v15);
        m.a(k17, v16);
        m.a(k18, v17);
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15, k17, v16, k18, v17}, 9);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13, K k15, V v14, K k16, V v15, K k17, V v16, K k18, V v17, K k19, V v18) {
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
        return new RegularImmutableBiMap(new Object[]{k10, v2, k11, v10, k12, v11, k13, v12, k14, v13, k15, v14, k16, v15, k17, v16, k18, v17, k19, v18}, 10);
    }
}
