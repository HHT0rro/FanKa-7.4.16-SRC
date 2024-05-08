package com.google.common.collect;

import com.google.common.collect.k0;
import com.google.common.primitives.Ints;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient long[] cumulativeCounts;
    public final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;
    private static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    public static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int i10) {
        long[] jArr = this.cumulativeCounts;
        int i11 = this.offset;
        return (int) (jArr[(i11 + i10) + 1] - jArr[i11 + i10]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
    public int count(Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return getCount(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a1
    public k0.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public k0.a<E> getEntry(int i10) {
        return Multisets.g(this.elementSet.asList().get(i10), getCount(i10));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i10, int i11) {
        com.google.common.base.o.w(i10, i11, this.length);
        if (i10 == i11) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return (i10 == 0 && i11 == this.length) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i10, i11), this.cumulativeCounts, this.offset + i10, i11 - i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a1
    public /* bridge */ /* synthetic */ a1 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a1
    public k0.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i10 = this.offset;
        return Ints.l(jArr[this.length + i10] - jArr[i10]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a1
    public /* bridge */ /* synthetic */ a1 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((RegularImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a1
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e2, com.google.common.base.o.r(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a1
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e2, com.google.common.base.o.r(boundType) == BoundType.CLOSED), this.length);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i10, int i11) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i10;
        this.length = i11;
    }
}
