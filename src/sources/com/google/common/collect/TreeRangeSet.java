package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    private transient Set<Range<C>> asDescendingSetOfRanges;
    private transient Set<Range<C>> asRanges;
    private transient s0<C> complement;
    public final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class Complement extends TreeRangeSet<C> {
        public Complement() {
            super(new c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.s0
        public s0<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C c4) {
            return !TreeRangeSet.this.contains(c4);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public SubRangeSet(com.google.common.collect.Range<C> r5) {
            /*
                r3 = this;
                com.google.common.collect.TreeRangeSet.this = r4
                com.google.common.collect.TreeRangeSet$e r0 = new com.google.common.collect.TreeRangeSet$e
                com.google.common.collect.Range r1 = com.google.common.collect.Range.all()
                java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> r4 = r4.rangesByLowerBound
                r2 = 0
                r0.<init>(r1, r5, r4)
                r3.<init>(r0)
                r3.restriction = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeRangeSet.SubRangeSet.<init>(com.google.common.collect.TreeRangeSet, com.google.common.collect.Range):void");
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void add(Range<C> range) {
            com.google.common.base.o.n(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C c4) {
            return this.restriction.contains(c4) && TreeRangeSet.this.contains(c4);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f, com.google.common.collect.s0
        public boolean encloses(Range<C> range) {
            Range rangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public Range<C> rangeContaining(C c4) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c4) && (rangeContaining = TreeRangeSet.this.rangeContaining(c4)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.s0
        public s0<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            if (range.isConnected(this.restriction)) {
                return new SubRangeSet(this, this.restriction.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class b extends s<Range<C>> implements Set<Range<C>> {

        /* renamed from: b, reason: collision with root package name */
        public final Collection<Range<C>> f26538b;

        public b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.f26538b = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }

        @Override // com.google.common.collect.s, com.google.common.collect.z
        public Collection<Range<C>> delegate() {
            return this.f26538b;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class c<C extends Comparable<?>> extends com.google.common.collect.e<Cut<C>, Range<C>> {

        /* renamed from: b, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f26539b;

        /* renamed from: c, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f26540c;

        /* renamed from: d, reason: collision with root package name */
        public final Range<Cut<C>> f26541d;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d, reason: collision with root package name */
            public Cut<C> f26542d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Cut f26543e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ p0 f26544f;

            public a(Cut cut, p0 p0Var) {
                this.f26543e = cut;
                this.f26544f = p0Var;
                this.f26542d = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                Range create;
                if (!c.this.f26541d.upperBound.isLessThan(this.f26542d) && this.f26542d != Cut.aboveAll()) {
                    if (this.f26544f.hasNext()) {
                        Range range = (Range) this.f26544f.next();
                        create = Range.create(this.f26542d, range.lowerBound);
                        this.f26542d = range.upperBound;
                    } else {
                        create = Range.create(this.f26542d, Cut.aboveAll());
                        this.f26542d = Cut.aboveAll();
                    }
                    return Maps.j(create.lowerBound, create);
                }
                return (Map.Entry) b();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d, reason: collision with root package name */
            public Cut<C> f26546d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Cut f26547e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ p0 f26548f;

            public b(Cut cut, p0 p0Var) {
                this.f26547e = cut;
                this.f26548f = p0Var;
                this.f26546d = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (this.f26546d == Cut.belowAll()) {
                    return (Map.Entry) b();
                }
                if (this.f26548f.hasNext()) {
                    Range range = (Range) this.f26548f.next();
                    Range create = Range.create(range.upperBound, this.f26546d);
                    this.f26546d = range.lowerBound;
                    if (c.this.f26541d.lowerBound.isLessThan(create.lowerBound)) {
                        return Maps.j(create.lowerBound, create);
                    }
                } else if (c.this.f26541d.lowerBound.isLessThan(Cut.belowAll())) {
                    Range create2 = Range.create(Cut.belowAll(), this.f26546d);
                    this.f26546d = Cut.belowAll();
                    return Maps.j(Cut.belowAll(), create2);
                }
                return (Map.Entry) b();
            }
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Collection<Range<C>> values;
            Cut cut;
            if (this.f26541d.hasLowerBound()) {
                values = this.f26540c.tailMap(this.f26541d.lowerEndpoint(), this.f26541d.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                values = this.f26540c.values();
            }
            p0 q10 = Iterators.q(values.iterator2());
            if (this.f26541d.contains(Cut.belowAll()) && (!q10.hasNext() || ((Range) q10.peek()).lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            } else if (q10.hasNext()) {
                cut = ((Range) q10.next()).upperBound;
            } else {
                return Iterators.h();
            }
            return new a(cut, q10);
        }

        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Cut<C> aboveAll;
            Cut<C> higherKey;
            if (this.f26541d.hasUpperBound()) {
                aboveAll = this.f26541d.upperEndpoint();
            } else {
                aboveAll = Cut.aboveAll();
            }
            p0 q10 = Iterators.q(this.f26540c.headMap(aboveAll, this.f26541d.hasUpperBound() && this.f26541d.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator2());
            if (q10.hasNext()) {
                if (((Range) q10.peek()).upperBound == Cut.aboveAll()) {
                    higherKey = ((Range) q10.next()).lowerBound;
                } else {
                    higherKey = this.f26539b.higherKey(((Range) q10.peek()).upperBound);
                }
            } else if (this.f26541d.contains(Cut.belowAll()) && !this.f26539b.containsKey(Cut.belowAll())) {
                higherKey = this.f26539b.higherKey(Cut.belowAll());
            } else {
                return Iterators.h();
            }
            return new b((Cut) com.google.common.base.j.a(higherKey, Cut.aboveAll()), q10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z10) {
            return g(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z10, Cut<C> cut2, boolean z11) {
            return g(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        public final NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (!this.f26541d.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new c(this.f26539b, range.intersection(this.f26541d));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z10) {
            return g(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.v(a());
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f26539b = navigableMap;
            this.f26540c = new d(navigableMap);
            this.f26541d = range;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class e<C extends Comparable<?>> extends com.google.common.collect.e<Cut<C>, Range<C>> {

        /* renamed from: b, reason: collision with root package name */
        public final Range<Cut<C>> f26556b;

        /* renamed from: c, reason: collision with root package name */
        public final Range<C> f26557c;

        /* renamed from: d, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f26558d;

        /* renamed from: e, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f26559e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Iterator f26560d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Cut f26561e;

            public a(Iterator it, Cut cut) {
                this.f26560d = it;
                this.f26561e = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f26560d.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f26560d.next();
                if (this.f26561e.isLessThan(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(e.this.f26557c);
                return Maps.j(intersection.lowerBound, intersection);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Iterator f26563d;

            public b(Iterator it) {
                this.f26563d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f26563d.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f26563d.next();
                if (e.this.f26557c.lowerBound.compareTo((Cut) range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(e.this.f26557c);
                if (e.this.f26556b.contains(intersection.lowerBound)) {
                    return Maps.j(intersection.lowerBound, intersection);
                }
                return (Map.Entry) b();
            }
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> iterator2;
            if (this.f26557c.isEmpty()) {
                return Iterators.h();
            }
            if (this.f26556b.upperBound.isLessThan(this.f26557c.lowerBound)) {
                return Iterators.h();
            }
            if (this.f26556b.lowerBound.isLessThan(this.f26557c.lowerBound)) {
                iterator2 = this.f26559e.tailMap(this.f26557c.lowerBound, false).values().iterator2();
            } else {
                iterator2 = this.f26558d.tailMap(this.f26556b.lowerBound.endpoint(), this.f26556b.lowerBoundType() == BoundType.CLOSED).values().iterator2();
            }
            return new a(iterator2, (Cut) Ordering.natural().min(this.f26556b.upperBound, Cut.belowValue(this.f26557c.upperBound)));
        }

        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            if (this.f26557c.isEmpty()) {
                return Iterators.h();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f26556b.upperBound, Cut.belowValue(this.f26557c.upperBound));
            return new b(this.f26558d.headMap((Cut) cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator2());
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f26556b.contains(cut) && cut.compareTo(this.f26557c.lowerBound) >= 0 && cut.compareTo(this.f26557c.upperBound) < 0) {
                        if (cut.equals(this.f26557c.lowerBound)) {
                            Range range = (Range) Maps.M(this.f26558d.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.f26557c.lowerBound) > 0) {
                                return range.intersection(this.f26557c);
                            }
                        } else {
                            Range<C> range2 = this.f26558d.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.f26557c);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z10) {
            return h(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z10, Cut<C> cut2, boolean z11) {
            return h(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        public final NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            if (!range.isConnected(this.f26556b)) {
                return ImmutableSortedMap.of();
            }
            return new e(this.f26556b.intersection(range), this.f26557c, this.f26558d);
        }

        @Override // java.util.NavigableMap
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z10) {
            return h(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.v(a());
        }

        public e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f26556b = (Range) com.google.common.base.o.r(range);
            this.f26557c = (Range) com.google.common.base.o.r(range2);
            this.f26558d = (NavigableMap) com.google.common.base.o.r(navigableMap);
            this.f26559e = new d(navigableMap);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        com.google.common.base.o.r(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // com.google.common.collect.f
    public void add(Range<C> range) {
        com.google.common.base.o.r(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(cut) >= 0) {
                if (value.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (value2.upperBound.compareTo(cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void addAll(s0 s0Var) {
        super.addAll(s0Var);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.s0
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.s0
    public s0<C> complement() {
        s0<C> s0Var = this.complement;
        if (s0Var != null) {
            return s0Var;
        }
        Complement complement = new Complement();
        this.complement = complement;
        return complement;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    public boolean encloses(Range<C> range) {
        com.google.common.base.o.r(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(s0 s0Var) {
        return super.enclosesAll(s0Var);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.f
    public boolean intersects(Range<C> range) {
        com.google.common.base.o.r(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.f
    public Range<C> rangeContaining(C c4) {
        com.google.common.base.o.r(c4);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c4));
        if (floorEntry == null || !floorEntry.getValue().contains(c4)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.f
    public void remove(Range<C> range) {
        com.google.common.base.o.r(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    public /* bridge */ /* synthetic */ void removeAll(s0 s0Var) {
        super.removeAll(s0Var);
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null && lastEntry != null) {
            return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.s0
    public s0<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(this, range);
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(s0<C> s0Var) {
        TreeRangeSet<C> create = create();
        create.addAll(s0Var);
        return create;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class d<C extends Comparable<?>> extends com.google.common.collect.e<Cut<C>, Range<C>> {

        /* renamed from: b, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f26550b;

        /* renamed from: c, reason: collision with root package name */
        public final Range<Cut<C>> f26551c;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Iterator f26552d;

            public a(Iterator it) {
                this.f26552d = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f26552d.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f26552d.next();
                if (d.this.f26551c.upperBound.isLessThan(range.upperBound)) {
                    return (Map.Entry) b();
                }
                return Maps.j(range.upperBound, range);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ p0 f26554d;

            public b(p0 p0Var) {
                this.f26554d = p0Var;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f26554d.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f26554d.next();
                if (d.this.f26551c.lowerBound.isLessThan(range.upperBound)) {
                    return Maps.j(range.upperBound, range);
                }
                return (Map.Entry) b();
            }
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f26550b = navigableMap;
            this.f26551c = Range.all();
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> iterator2;
            if (!this.f26551c.hasLowerBound()) {
                iterator2 = this.f26550b.values().iterator2();
            } else {
                Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f26550b.lowerEntry(this.f26551c.lowerEndpoint());
                if (lowerEntry == null) {
                    iterator2 = this.f26550b.values().iterator2();
                } else if (this.f26551c.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                    iterator2 = this.f26550b.tailMap(lowerEntry.getKey(), true).values().iterator2();
                } else {
                    iterator2 = this.f26550b.tailMap(this.f26551c.lowerEndpoint(), true).values().iterator2();
                }
            }
            return new a(iterator2);
        }

        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Collection<Range<C>> values;
            if (this.f26551c.hasUpperBound()) {
                values = this.f26550b.headMap(this.f26551c.upperEndpoint(), false).descendingMap().values();
            } else {
                values = this.f26550b.descendingMap().values();
            }
            p0 q10 = Iterators.q(values.iterator2());
            if (q10.hasNext() && this.f26551c.upperBound.isLessThan(((Range) q10.peek()).upperBound)) {
                q10.next();
            }
            return new b(q10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f26551c.contains(cut) && (lowerEntry = this.f26550b.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z10) {
            return g(Range.upTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z10, Cut<C> cut2, boolean z11) {
            return g(Range.range(cut, BoundType.forBoolean(z10), cut2, BoundType.forBoolean(z11)));
        }

        public final NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (range.isConnected(this.f26551c)) {
                return new d(this.f26550b, range.intersection(this.f26551c));
            }
            return ImmutableSortedMap.of();
        }

        @Override // java.util.NavigableMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z10) {
            return g(Range.downTo(cut, BoundType.forBoolean(z10)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f26551c.equals(Range.all())) {
                return this.f26550b.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.f26551c.equals(Range.all())) {
                return this.f26550b.size();
            }
            return Iterators.v(a());
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f26550b = navigableMap;
            this.f26551c = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
