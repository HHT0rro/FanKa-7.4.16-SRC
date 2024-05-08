package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.k0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements a1<E> {
    public transient ImmutableSortedMultiset<E> descendingMultiset;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SerializedForm<E> implements Serializable {
        public final Comparator<? super E> comparator;
        public final int[] counts;
        public final E[] elements;

        public SerializedForm(a1<E> a1Var) {
            this.comparator = a1Var.comparator();
            int size = a1Var.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i10 = 0;
            for (k0.a<E> aVar : a1Var.entrySet()) {
                this.elements[i10] = aVar.getElement();
                this.counts[i10] = aVar.getCount();
                i10++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i10 = 0; i10 < length; i10++) {
                aVar.j(this.elements[i10], this.counts[i10]);
            }
            return aVar.k();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a<E> extends ImmutableMultiset.b<E> {

        /* renamed from: d, reason: collision with root package name */
        public final Comparator<? super E> f26307d;

        /* renamed from: e, reason: collision with root package name */
        public E[] f26308e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f26309f;

        /* renamed from: g, reason: collision with root package name */
        public int f26310g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f26311h;

        public a(Comparator<? super E> comparator) {
            super(true);
            this.f26307d = (Comparator) com.google.common.base.o.r(comparator);
            this.f26308e = (E[]) new Object[4];
            this.f26309f = new int[4];
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e2) {
            return j(e2, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public a<E> g(E... eArr) {
            for (E e2 : eArr) {
                a(e2);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<E> h(Iterable<? extends E> iterable) {
            if (iterable instanceof k0) {
                for (k0.a<E> aVar : ((k0) iterable).entrySet()) {
                    j(aVar.getElement(), aVar.getCount());
                }
            } else {
                Iterator<? extends E> iterator2 = iterable.iterator2();
                while (iterator2.hasNext()) {
                    a(iterator2.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<E> i(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<E> j(E e2, int i10) {
            com.google.common.base.o.r(e2);
            m.b(i10, "occurrences");
            if (i10 == 0) {
                return this;
            }
            u();
            E[] eArr = this.f26308e;
            int i11 = this.f26310g;
            eArr[i11] = e2;
            this.f26309f[i11] = i10;
            this.f26310g = i11 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMultiset<E> k() {
            t();
            int i10 = this.f26310g;
            if (i10 == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.f26307d);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.f26307d, i10, this.f26308e);
            long[] jArr = new long[this.f26310g + 1];
            int i11 = 0;
            while (i11 < this.f26310g) {
                int i12 = i11 + 1;
                jArr[i12] = jArr[i11] + this.f26309f[i11];
                i11 = i12;
            }
            this.f26311h = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.f26310g);
        }

        public final void s(boolean z10) {
            int i10 = this.f26310g;
            if (i10 == 0) {
                return;
            }
            Object[] objArr = (E[]) Arrays.copyOf(this.f26308e, i10);
            Arrays.sort(objArr, this.f26307d);
            int i11 = 1;
            for (int i12 = 1; i12 < objArr.length; i12++) {
                if (this.f26307d.compare((Object) objArr[i11 - 1], (Object) objArr[i12]) < 0) {
                    objArr[i11] = objArr[i12];
                    i11++;
                }
            }
            Arrays.fill(objArr, i11, this.f26310g, (Object) null);
            if (z10) {
                int i13 = i11 * 4;
                int i14 = this.f26310g;
                if (i13 > i14 * 3) {
                    objArr = (E[]) Arrays.copyOf(objArr, com.google.common.math.d.g(i14, (i14 / 2) + 1));
                }
            }
            int[] iArr = new int[objArr.length];
            for (int i15 = 0; i15 < this.f26310g; i15++) {
                int binarySearch = Arrays.binarySearch(objArr, 0, i11, this.f26308e[i15], this.f26307d);
                int[] iArr2 = this.f26309f;
                if (iArr2[i15] >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + iArr2[i15];
                } else {
                    iArr[binarySearch] = ~iArr2[i15];
                }
            }
            this.f26308e = (E[]) objArr;
            this.f26309f = iArr;
            this.f26310g = i11;
        }

        public final void t() {
            s(false);
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = this.f26310g;
                if (i10 < i12) {
                    int[] iArr = this.f26309f;
                    if (iArr[i10] > 0) {
                        E[] eArr = this.f26308e;
                        eArr[i11] = eArr[i10];
                        iArr[i11] = iArr[i10];
                        i11++;
                    }
                    i10++;
                } else {
                    Arrays.fill(this.f26308e, i11, i12, (Object) null);
                    Arrays.fill(this.f26309f, i11, this.f26310g, 0);
                    this.f26310g = i11;
                    return;
                }
            }
        }

        public final void u() {
            int i10 = this.f26310g;
            E[] eArr = this.f26308e;
            if (i10 == eArr.length) {
                s(true);
            } else if (this.f26311h) {
                this.f26308e = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.f26311h = false;
        }
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(a1<E> a1Var) {
        return copyOfSortedEntries(a1Var.comparator(), Lists.k(a1Var.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<k0.a<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.a aVar = new ImmutableList.a(collection.size());
        long[] jArr = new long[collection.size() + 1];
        Iterator<k0.a<E>> iterator2 = collection.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            aVar.a(iterator2.next().getElement());
            int i11 = i10 + 1;
            jArr[i11] = jArr[i10] + r5.getCount();
            i10 = i11;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(aVar.k(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.a1, com.google.common.collect.y0
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
    public abstract /* synthetic */ int count(Object obj);

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract /* synthetic */ k0.a<E> firstEntry();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ a1 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    public abstract /* synthetic */ k0.a<E> lastEntry();

    @Override // com.google.common.collect.a1
    @Deprecated
    public final k0.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a1
    @Deprecated
    public final k0.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a1
    public /* bridge */ /* synthetic */ a1 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ a1 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            if (isEmpty()) {
                immutableSortedMultiset = emptyMultiset(Ordering.from(comparator()).reverse());
            } else {
                immutableSortedMultiset = new DescendingImmutableSortedMultiset<>(this);
            }
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a1
    public ImmutableSortedMultiset<E> subMultiset(E e2, BoundType boundType, E e10, BoundType boundType2) {
        com.google.common.base.o.n(comparator().compare(e2, e10) <= 0, "Expected lowerBound <= upperBound but %s > %s", e2, e10);
        return tailMultiset((ImmutableSortedMultiset<E>) e2, boundType).headMultiset((ImmutableSortedMultiset<E>) e10, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        com.google.common.base.o.r(comparator);
        return new a(comparator).i(it).k();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new a(comparator).h(iterable).k();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList n10 = Lists.n(comparableArr.length + 6);
        Collections.addAll(n10, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(n10, comparableArr);
        return copyOf(Ordering.natural(), n10);
    }
}
