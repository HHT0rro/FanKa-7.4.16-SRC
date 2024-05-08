package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ImmutableRangeSet<C extends Comparable> extends f<C> implements Serializable {
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class AsSet extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;
        private transient Integer size;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends AbstractIterator<C> {

            /* renamed from: d, reason: collision with root package name */
            public final Iterator<Range<C>> f26293d;

            /* renamed from: e, reason: collision with root package name */
            public Iterator<C> f26294e = Iterators.h();

            public a() {
                this.f26293d = ImmutableRangeSet.this.ranges.iterator2();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.f26294e.hasNext()) {
                    if (this.f26293d.hasNext()) {
                        this.f26294e = ContiguousSet.create(this.f26293d.next(), AsSet.this.domain).iterator2();
                    } else {
                        return (C) b();
                    }
                }
                return this.f26294e.next();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends AbstractIterator<C> {

            /* renamed from: d, reason: collision with root package name */
            public final Iterator<Range<C>> f26296d;

            /* renamed from: e, reason: collision with root package name */
            public Iterator<C> f26297e = Iterators.h();

            public b() {
                this.f26296d = ImmutableRangeSet.this.ranges.reverse().iterator2();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.f26297e.hasNext()) {
                    if (this.f26296d.hasNext()) {
                        this.f26297e = ContiguousSet.create(this.f26296d.next(), AsSet.this.domain).descendingIterator();
                    } else {
                        return (C) b();
                    }
                }
                return this.f26297e.next();
            }
        }

        public AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Objects.requireNonNull(obj);
            Comparable comparable = (Comparable) obj;
            long j10 = 0;
            i1 iterator2 = ImmutableRangeSet.this.ranges.iterator2();
            while (iterator2.hasNext()) {
                if (((Range) iterator2.next()).contains(comparable)) {
                    return Ints.l(j10 + ContiguousSet.create(r3, this.domain).indexOf(comparable));
                }
                j10 += ContiguousSet.create(r3, this.domain).size();
            }
            throw new AssertionError((Object) "impossible");
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.size;
            if (num == null) {
                long j10 = 0;
                i1 iterator2 = ImmutableRangeSet.this.ranges.iterator2();
                while (iterator2.hasNext()) {
                    j10 += ContiguousSet.create((Range) iterator2.next(), this.domain).size();
                    if (j10 >= ZipUtils.UPPER_UNIXTIME_BOUND) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.l(j10));
                this.size = num;
            }
            return num.intValue();
        }

        public ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet(this.domain);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public i1<C> descendingIterator() {
            return new b();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> headSetImpl(C c4, boolean z10) {
            return subSet(Range.upTo(c4, BoundType.forBoolean(z10)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public i1<C> iterator2() {
            return new a();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> subSetImpl(C c4, boolean z10, C c10, boolean z11) {
            if (!z10 && !z11 && Range.compareOrThrow(c4, c10) == 0) {
                return ImmutableSortedSet.of();
            }
            return subSet(Range.range(c4, BoundType.forBoolean(z10), c10, BoundType.forBoolean(z11)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> tailSetImpl(C c4, boolean z10) {
            return subSet(Range.downTo(c4, BoundType.forBoolean(z10)));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        public AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        /* JADX WARN: Multi-variable type inference failed */
        public ComplementRanges() {
            boolean hasLowerBound = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedBelow = hasLowerBound;
            boolean hasUpperBound = ((Range) g0.f(ImmutableRangeSet.this.ranges)).hasUpperBound();
            this.positiveBoundedAbove = hasUpperBound;
            int size = ImmutableRangeSet.this.ranges.size() - 1;
            size = hasLowerBound ? size + 1 : size;
            this.size = hasUpperBound ? size + 1 : size;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<C> get(int i10) {
            Cut<C> cut;
            Cut<C> cut2;
            com.google.common.base.o.p(i10, this.size);
            if (this.positiveBoundedBelow) {
                cut = i10 == 0 ? Cut.belowAll() : ((Range) ImmutableRangeSet.this.ranges.get(i10 - 1)).upperBound;
            } else {
                cut = ((Range) ImmutableRangeSet.this.ranges.get(i10)).upperBound;
            }
            if (this.positiveBoundedAbove && i10 == this.size - 1) {
                cut2 = Cut.aboveAll();
            } else {
                cut2 = ((Range) ImmutableRangeSet.this.ranges.get(i10 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
            }
            return Range.create(cut, cut2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        public SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        public Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (this.ranges.equals(ImmutableList.of(Range.all()))) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet(this.ranges);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a<C extends Comparable<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final List<Range<C>> f26299a = Lists.j();

        public a<C> a(Range<C> range) {
            com.google.common.base.o.m(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f26299a.add(range);
            return this;
        }

        public a<C> b(Iterable<Range<C>> iterable) {
            Iterator<Range<C>> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                a(iterator2.next());
            }
            return this;
        }

        public ImmutableRangeSet<C> c() {
            ImmutableList.a aVar = new ImmutableList.a(this.f26299a.size());
            Collections.sort(this.f26299a, Range.rangeLexOrdering());
            p0 q10 = Iterators.q(this.f26299a.iterator2());
            while (q10.hasNext()) {
                Range range = (Range) q10.next();
                while (q10.hasNext()) {
                    Range<C> range2 = (Range) q10.peek();
                    if (range.isConnected(range2)) {
                        com.google.common.base.o.n(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                        range = range.span((Range) q10.next());
                    }
                }
                aVar.a(range);
            }
            ImmutableList k10 = aVar.k();
            if (k10.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (k10.size() == 1 && ((Range) g0.i(k10)).equals(Range.all())) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet<>(k10);
        }
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> a<C> builder() {
        return new a<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(s0<C> s0Var) {
        com.google.common.base.o.r(s0Var);
        if (s0Var.isEmpty()) {
            return of();
        }
        if (s0Var.encloses(Range.all())) {
            return all();
        }
        if (s0Var instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) s0Var;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) s0Var.asRanges()));
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
        int size;
        if (!this.ranges.isEmpty() && !range.isEmpty()) {
            if (range.encloses(span())) {
                return this.ranges;
            }
            final int a10 = range.hasLowerBound() ? SortedLists.a(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
            if (range.hasUpperBound()) {
                size = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
            } else {
                size = this.ranges.size();
            }
            final int i10 = size - a10;
            if (i10 == 0) {
                return ImmutableList.of();
            }
            return (ImmutableList<Range<C>>) new ImmutableList<Range<C>>() { // from class: com.google.common.collect.ImmutableRangeSet.1
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
                public Range<C> get(int i11) {
                    com.google.common.base.o.p(i11, i10);
                    if (i11 != 0 && i11 != i10 - 1) {
                        return (Range) ImmutableRangeSet.this.ranges.get(i11 + a10);
                    }
                    return ((Range) ImmutableRangeSet.this.ranges.get(i11 + a10)).intersection(range);
                }
            };
        }
        return ImmutableList.of();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // com.google.common.collect.f
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.f
    @Deprecated
    public void addAll(s0<C> s0Var) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        com.google.common.base.o.r(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new AsSet(discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(s0<C> s0Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(s0Var);
        return copyOf(create);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    public boolean encloses(Range<C> range) {
        int b4 = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return b4 != -1 && this.ranges.get(b4).encloses(range);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(s0 s0Var) {
        return super.enclosesAll(s0Var);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(s0<C> s0Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(s0Var.complement());
        return copyOf(create);
    }

    @Override // com.google.common.collect.f
    public boolean intersects(Range<C> range) {
        int b4 = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (b4 < this.ranges.size() && this.ranges.get(b4).isConnected(range) && !this.ranges.get(b4).intersection(range).isEmpty()) {
            return true;
        }
        if (b4 > 0) {
            int i10 = b4 - 1;
            if (this.ranges.get(i10).isConnected(range) && !this.ranges.get(i10).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // com.google.common.collect.f
    public Range<C> rangeContaining(C c4) {
        int b4 = SortedLists.b(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c4), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (b4 == -1) {
            return null;
        }
        Range<C> range = this.ranges.get(b4);
        if (range.contains(c4)) {
            return range;
        }
        return null;
    }

    @Override // com.google.common.collect.f
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    @Deprecated
    public void removeAll(s0<C> s0Var) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (!this.ranges.isEmpty()) {
            return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public ImmutableRangeSet<C> union(s0<C> s0Var) {
        return unionOf(g0.c(asRanges(), s0Var.asRanges()));
    }

    public Object writeReplace() {
        return new SerializedForm(this.ranges);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        com.google.common.base.o.r(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return all();
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // com.google.common.collect.f
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: asDescendingSetOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<Range<C>> m2852asDescendingSetOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    @Override // com.google.common.collect.s0
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    @Override // com.google.common.collect.s0
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> all = all();
            this.complement = all;
            return all;
        }
        if (this.ranges.size() == 1 && this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> of = of();
            this.complement = of;
            return of;
        }
        ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
        this.complement = immutableRangeSet2;
        return immutableRangeSet2;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.f
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.s0
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new a().b(iterable).c();
    }
}
