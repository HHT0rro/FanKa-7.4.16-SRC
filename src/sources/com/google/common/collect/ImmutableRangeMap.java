package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements r0<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        public SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        public Object createRangeMap() {
            a aVar = new a();
            i1<Map.Entry<Range<K>, V>> iterator2 = this.mapOfRanges.entrySet().iterator2();
            while (iterator2.hasNext()) {
                Map.Entry<Range<K>, V> next = iterator2.next();
                aVar.b(next.getKey(), next.getValue());
            }
            return aVar.a();
        }

        public Object readResolve() {
            if (this.mapOfRanges.isEmpty()) {
                return ImmutableRangeMap.of();
            }
            return createRangeMap();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a<K extends Comparable<?>, V> {

        /* renamed from: a, reason: collision with root package name */
        public final List<Map.Entry<Range<K>, V>> f26292a = Lists.j();

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f26292a, Range.rangeLexOrdering().onKeys());
            ImmutableList.a aVar = new ImmutableList.a(this.f26292a.size());
            ImmutableList.a aVar2 = new ImmutableList.a(this.f26292a.size());
            for (int i10 = 0; i10 < this.f26292a.size(); i10++) {
                Range<K> key = this.f26292a.get(i10).getKey();
                if (i10 > 0) {
                    Range<K> key2 = this.f26292a.get(i10 - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        String valueOf = String.valueOf(key2);
                        String valueOf2 = String.valueOf(key);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 47 + valueOf2.length());
                        sb2.append("Overlapping ranges: range ");
                        sb2.append(valueOf);
                        sb2.append(" overlaps with entry ");
                        sb2.append(valueOf2);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                aVar.a(key);
                aVar2.a(this.f26292a.get(i10).getValue());
            }
            return new ImmutableRangeMap<>(aVar.k(), aVar2.k());
        }

        public a<K, V> b(Range<K> range, V v2) {
            com.google.common.base.o.r(range);
            com.google.common.base.o.r(v2);
            com.google.common.base.o.m(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f26292a.add(Maps.j(range, v2));
            return this;
        }
    }

    public ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(r0<K, ? extends V> r0Var) {
        if (r0Var instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) r0Var;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = r0Var.asMapOfRanges();
        ImmutableList.a aVar = new ImmutableList.a(asMapOfRanges.size());
        ImmutableList.a aVar2 = new ImmutableList.a(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            aVar.a(entry.getKey());
            aVar2.a(entry.getValue());
        }
        return new ImmutableRangeMap<>(aVar.k(), aVar2.k());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof r0) {
            return asMapOfRanges().equals(((r0) obj).asMapOfRanges());
        }
        return false;
    }

    public V get(K k10) {
        int a10 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k10), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a10 != -1 && this.ranges.get(a10).contains(k10)) {
            return this.values.get(a10);
        }
        return null;
    }

    public Map.Entry<Range<K>, V> getEntry(K k10) {
        int a10 = SortedLists.a(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k10), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a10 == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(a10);
        if (range.contains(k10)) {
            return Maps.j(range, this.values.get(a10));
        }
        return null;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public final void put(Range<K> range, V v2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(r0<K, V> r0Var) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putCoalescing(Range<K> range, V v2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (!this.ranges.isEmpty()) {
            return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v2) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v2));
    }

    @Override // 
    /* renamed from: asDescendingMapOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<Range<K>, V> mo2850asDescendingMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // com.google.common.collect.r0
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Override // 
    /* renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> mo2851subRangeMap(final Range<K> range) {
        if (((Range) com.google.common.base.o.r(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.ranges;
        com.google.common.base.g upperBoundFn = Range.upperBoundFn();
        Cut<K> cut = range.lowerBound;
        SortedLists.KeyPresentBehavior keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        SortedLists.KeyAbsentBehavior keyAbsentBehavior = SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        final int a10 = SortedLists.a(immutableList, upperBoundFn, cut, keyPresentBehavior, keyAbsentBehavior);
        int a11 = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, keyAbsentBehavior);
        if (a10 >= a11) {
            return of();
        }
        final int i10 = a11 - a10;
        return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(this, new ImmutableList<Range<K>>() { // from class: com.google.common.collect.ImmutableRangeMap.1
            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return i10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<K> get(int i11) {
                com.google.common.base.o.p(i11, i10);
                if (i11 != 0 && i11 != i10 - 1) {
                    return (Range) ImmutableRangeMap.this.ranges.get(i11 + a10);
                }
                return ((Range) ImmutableRangeMap.this.ranges.get(i11 + a10)).intersection(range);
            }
        }, this.values.subList(a10, a11)) { // from class: com.google.common.collect.ImmutableRangeMap.2
            @Override // com.google.common.collect.ImmutableRangeMap
            /* renamed from: asDescendingMapOfRanges */
            public /* bridge */ /* synthetic */ Map mo2850asDescendingMapOfRanges() {
                return super.mo2850asDescendingMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.r0
            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return super.asMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap
            /* renamed from: subRangeMap, reason: merged with bridge method [inline-methods] */
            public ImmutableRangeMap<K, V> mo2851subRangeMap(Range<K> range2) {
                if (range.isConnected(range2)) {
                    return this.mo2851subRangeMap((Range) range2.intersection(range));
                }
                return ImmutableRangeMap.of();
            }
        };
    }
}
