package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements com.google.common.base.p<C> {
    private static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    private static final long serialVersionUID = 0;
    public final Cut<C> lowerBound;
    public final Cut<C> upperBound;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        public static final Ordering<Range<?>> INSTANCE = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            return p.k().f(range.lowerBound, range2.lowerBound).f(range.upperBound, range2.upperBound).j();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26461a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f26461a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26461a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements com.google.common.base.g<Range, Cut> {

        /* renamed from: b, reason: collision with root package name */
        public static final b f26462b = new b();

        @Override // com.google.common.base.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cut apply(Range range) {
            return range.lowerBound;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c implements com.google.common.base.g<Range, Cut> {

        /* renamed from: b, reason: collision with root package name */
        public static final c f26463b = new c();

        @Override // com.google.common.base.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cut apply(Range range) {
            return range.upperBound;
        }
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) com.google.common.base.o.r(cut);
        this.upperBound = (Cut) com.google.common.base.o.r(cut2);
        if (cut.compareTo((Cut) cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            String valueOf = String.valueOf(toString(cut, cut2));
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid range: ".concat(valueOf) : new String("Invalid range: "));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c4) {
        return create(Cut.belowValue(c4), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c4) {
        return create(Cut.belowAll(), Cut.aboveValue(c4));
    }

    public static <C extends Comparable<?>> Range<C> closed(C c4, C c10) {
        return create(Cut.belowValue(c4), Cut.aboveValue(c10));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c4, C c10) {
        return create(Cut.belowValue(c4), Cut.belowValue(c10));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c4, BoundType boundType) {
        int i10 = a.f26461a[boundType.ordinal()];
        if (i10 == 1) {
            return greaterThan(c4);
        }
        if (i10 == 2) {
            return atLeast(c4);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        com.google.common.base.o.r(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> iterator2 = iterable.iterator2();
        Comparable comparable = (Comparable) com.google.common.base.o.r(iterator2.next());
        Comparable comparable2 = comparable;
        while (iterator2.hasNext()) {
            Comparable comparable3 = (Comparable) com.google.common.base.o.r(iterator2.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c4) {
        return create(Cut.aboveValue(c4), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c4) {
        return create(Cut.belowAll(), Cut.belowValue(c4));
    }

    public static <C extends Comparable<?>> com.google.common.base.g<Range<C>, Cut<C>> lowerBoundFn() {
        return b.f26462b;
    }

    public static <C extends Comparable<?>> Range<C> open(C c4, C c10) {
        return create(Cut.aboveValue(c4), Cut.belowValue(c10));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c4, C c10) {
        return create(Cut.aboveValue(c4), Cut.aboveValue(c10));
    }

    public static <C extends Comparable<?>> Range<C> range(C c4, BoundType boundType, C c10, BoundType boundType2) {
        com.google.common.base.o.r(boundType);
        com.google.common.base.o.r(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return create(boundType == boundType3 ? Cut.aboveValue(c4) : Cut.belowValue(c4), boundType2 == boundType3 ? Cut.belowValue(c10) : Cut.aboveValue(c10));
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c4) {
        return closed(c4, c4);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c4, BoundType boundType) {
        int i10 = a.f26461a[boundType.ordinal()];
        if (i10 == 1) {
            return lessThan(c4);
        }
        if (i10 == 2) {
            return atMost(c4);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> com.google.common.base.g<Range<C>, Cut<C>> upperBoundFn() {
        return c.f26463b;
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        com.google.common.base.o.r(discreteDomain);
        Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
    }

    public boolean contains(C c4) {
        com.google.common.base.o.r(c4);
        return this.lowerBound.isLessThan(c4) && !this.upperBound.isLessThan(c4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (g0.j(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) sortedSet.first()) && contains((Comparable) sortedSet.last());
            }
        }
        Iterator<? extends C> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            if (!contains(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((Cut) range.upperBound) >= 0;
    }

    @Override // com.google.common.base.p
    public boolean equals(Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public Range<C> gap(Range<C> range) {
        if (this.lowerBound.compareTo((Cut) range.upperBound) < 0 && range.lowerBound.compareTo((Cut) this.upperBound) < 0) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(range);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 39 + valueOf2.length());
            sb2.append("Ranges have a nonempty intersection: ");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            throw new IllegalArgumentException(sb2.toString());
        }
        boolean z10 = this.lowerBound.compareTo((Cut) range.lowerBound) < 0;
        Range<C> range2 = z10 ? this : range;
        if (!z10) {
            range = this;
        }
        return create(range2.upperBound, range.lowerBound);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        Cut<C> cut = compareTo >= 0 ? this.lowerBound : range.lowerBound;
        Cut<C> cut2 = compareTo2 <= 0 ? this.upperBound : range.upperBound;
        com.google.common.base.o.n(cut.compareTo((Cut) cut2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return create(cut, cut2);
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo < 0 || compareTo2 > 0) {
            return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }

    private static String toString(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb2 = new StringBuilder(16);
        cut.describeAsLowerBound(sb2);
        sb2.append("..");
        cut2.describeAsUpperBound(sb2);
        return sb2.toString();
    }

    @Override // com.google.common.base.p
    @Deprecated
    public boolean apply(C c4) {
        return contains(c4);
    }
}
