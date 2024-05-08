package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.k0;
import com.google.common.primitives.Ints;
import com.huawei.quickcard.base.Attributes;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class TreeMultiset<E> extends h<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient e<E> header;
    private final transient GeneralRange<E> range;
    private final transient f<e<E>> rootReference;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return eVar.f26529b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f26531d;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f26530c;
            }
        };

        public abstract int nodeAggregate(e<?> eVar);

        public abstract long treeAggregate(e<?> eVar);

        /* synthetic */ Aggregate(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends Multisets.b<E> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f26519b;

        public a(e eVar) {
            this.f26519b = eVar;
        }

        @Override // com.google.common.collect.k0.a
        public int getCount() {
            int w3 = this.f26519b.w();
            return w3 == 0 ? TreeMultiset.this.count(getElement()) : w3;
        }

        @Override // com.google.common.collect.k0.a
        public E getElement() {
            return (E) this.f26519b.x();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements Iterator<k0.a<E>> {

        /* renamed from: b, reason: collision with root package name */
        public e<E> f26521b;

        /* renamed from: c, reason: collision with root package name */
        public k0.a<E> f26522c;

        public b() {
            this.f26521b = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k0.a<E> next() {
            if (hasNext()) {
                TreeMultiset treeMultiset = TreeMultiset.this;
                e<E> eVar = this.f26521b;
                Objects.requireNonNull(eVar);
                k0.a<E> wrapEntry = treeMultiset.wrapEntry(eVar);
                this.f26522c = wrapEntry;
                if (this.f26521b.L() == TreeMultiset.this.header) {
                    this.f26521b = null;
                } else {
                    this.f26521b = this.f26521b.L();
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f26521b == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooHigh(this.f26521b.x())) {
                return true;
            }
            this.f26521b = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.o.y(this.f26522c != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f26522c.getElement(), 0);
            this.f26522c = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c implements Iterator<k0.a<E>> {

        /* renamed from: b, reason: collision with root package name */
        public e<E> f26524b;

        /* renamed from: c, reason: collision with root package name */
        public k0.a<E> f26525c = null;

        public c() {
            this.f26524b = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k0.a<E> next() {
            if (hasNext()) {
                Objects.requireNonNull(this.f26524b);
                k0.a<E> wrapEntry = TreeMultiset.this.wrapEntry(this.f26524b);
                this.f26525c = wrapEntry;
                if (this.f26524b.z() == TreeMultiset.this.header) {
                    this.f26524b = null;
                } else {
                    this.f26524b = this.f26524b.z();
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f26524b == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooLow(this.f26524b.x())) {
                return true;
            }
            this.f26524b = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.o.y(this.f26525c != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.f26525c.getElement(), 0);
            this.f26525c = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26527a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f26527a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26527a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class f<T> {

        /* renamed from: a, reason: collision with root package name */
        public T f26537a;

        public f() {
        }

        public void a(T t2, T t10) {
            if (this.f26537a == t2) {
                this.f26537a = t10;
                return;
            }
            throw new ConcurrentModificationException();
        }

        public void b() {
            this.f26537a = null;
        }

        public T c() {
            return this.f26537a;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public TreeMultiset(f<e<E>> fVar, GeneralRange<E> generalRange, e<E> eVar) {
        super(generalRange.comparator());
        this.rootReference = fVar;
        this.range = generalRange;
        this.header = eVar;
    }

    private long aggregateAboveRange(Aggregate aggregate, e<E> eVar) {
        long treeAggregate;
        long aggregateAboveRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(l0.a(this.range.getUpperEndpoint()), eVar.x());
        if (compare > 0) {
            return aggregateAboveRange(aggregate, eVar.f26534g);
        }
        if (compare == 0) {
            int i10 = d.f26527a[this.range.getUpperBoundType().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return aggregate.treeAggregate(eVar.f26534g);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregate.treeAggregate(eVar.f26534g);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f26534g) + aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregateAboveRange(aggregate, eVar.f26533f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, e<E> eVar) {
        long treeAggregate;
        long aggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(l0.a(this.range.getLowerEndpoint()), eVar.x());
        if (compare < 0) {
            return aggregateBelowRange(aggregate, eVar.f26533f);
        }
        if (compare == 0) {
            int i10 = d.f26527a[this.range.getLowerBoundType().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return aggregate.treeAggregate(eVar.f26533f);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregate.treeAggregate(eVar.f26533f);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f26533f) + aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregateBelowRange(aggregate, eVar.f26534g);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        e<E> c4 = this.rootReference.c();
        long treeAggregate = aggregate.treeAggregate(c4);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, c4);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, c4) : treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> firstNode() {
        e<E> L;
        e<E> c4 = this.rootReference.c();
        if (c4 == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            Object a10 = l0.a(this.range.getLowerEndpoint());
            L = c4.s(comparator(), a10);
            if (L == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(a10, L.x()) == 0) {
                L = L.L();
            }
        } else {
            L = this.header.L();
        }
        if (L == this.header || !this.range.contains(L.x())) {
            return null;
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> lastNode() {
        e<E> z10;
        e<E> c4 = this.rootReference.c();
        if (c4 == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            Object a10 = l0.a(this.range.getUpperEndpoint());
            z10 = c4.v(comparator(), a10);
            if (z10 == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(a10, z10.x()) == 0) {
                z10 = z10.z();
            }
        } else {
            z10 = this.header.z();
        }
        if (z10 == this.header || !this.range.contains(z10.x())) {
            return null;
        }
        return z10;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        v0.a(h.class, "comparator").b(this, comparator);
        v0.a(TreeMultiset.class, Attributes.Style.RANGE).b(this, GeneralRange.all(comparator));
        v0.a(TreeMultiset.class, "rootReference").b(this, new f(null));
        e eVar = new e();
        v0.a(TreeMultiset.class, "header").b(this, eVar);
        successor(eVar, eVar);
        v0.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2) {
        eVar.f26536i = eVar2;
        eVar2.f26535h = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k0.a<E> wrapEntry(e<E> eVar) {
        return new a(eVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        v0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int add(E e2, int i10) {
        m.b(i10, "occurrences");
        if (i10 == 0) {
            return count(e2);
        }
        com.google.common.base.o.d(this.range.contains(e2));
        e<E> c4 = this.rootReference.c();
        if (c4 == null) {
            comparator().compare(e2, e2);
            e<E> eVar = new e<>(e2, i10);
            e<E> eVar2 = this.header;
            successor(eVar2, eVar, eVar2);
            this.rootReference.a(c4, eVar);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c4, c4.o(comparator(), e2, i10, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (!this.range.hasLowerBound() && !this.range.hasUpperBound()) {
            e<E> L = this.header.L();
            while (true) {
                e<E> eVar = this.header;
                if (L != eVar) {
                    e<E> L2 = L.L();
                    L.f26529b = 0;
                    L.f26533f = null;
                    L.f26534g = null;
                    L.f26535h = null;
                    L.f26536i = null;
                    L = L2;
                } else {
                    successor(eVar, eVar);
                    this.rootReference.b();
                    return;
                }
            }
        } else {
            Iterators.d(entryIterator());
        }
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a1, com.google.common.collect.y0
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.k0
    public int count(Object obj) {
        try {
            e<E> c4 = this.rootReference.c();
            if (this.range.contains(obj) && c4 != null) {
                return c4.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.h
    public Iterator<k0.a<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a1
    public /* bridge */ /* synthetic */ a1 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.d
    public int distinctElements() {
        return Ints.l(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        return Multisets.e(entryIterator());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.d, com.google.common.collect.k0
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d
    public Iterator<k0.a<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a1
    public /* bridge */ /* synthetic */ k0.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.a1
    public a1<E> headMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e2, boundType)), this.header);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a1
    public /* bridge */ /* synthetic */ k0.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a1
    public /* bridge */ /* synthetic */ k0.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.a1
    public /* bridge */ /* synthetic */ k0.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int remove(Object obj, int i10) {
        m.b(i10, "occurrences");
        if (i10 == 0) {
            return count(obj);
        }
        e<E> c4 = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && c4 != null) {
                this.rootReference.a(c4, c4.E(comparator(), obj, i10, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int setCount(E e2, int i10) {
        m.b(i10, "count");
        if (!this.range.contains(e2)) {
            com.google.common.base.o.d(i10 == 0);
            return 0;
        }
        e<E> c4 = this.rootReference.c();
        if (c4 == null) {
            if (i10 > 0) {
                add(e2, i10);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c4, c4.K(comparator(), e2, i10, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return Ints.l(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h, com.google.common.collect.a1
    public /* bridge */ /* synthetic */ a1 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.a1
    public a1<E> tailMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e2, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        if (comparator == null) {
            return new TreeMultiset<>(Ordering.natural());
        }
        return new TreeMultiset<>(comparator);
    }

    public static int distinctElements(e<?> eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.f26530c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2, e<T> eVar3) {
        successor(eVar, eVar2);
        successor(eVar2, eVar3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        g0.a(create, iterable);
        return create;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        e<E> eVar = new e<>();
        this.header = eVar;
        successor(eVar, eVar);
        this.rootReference = new f<>(null);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public boolean setCount(E e2, int i10, int i11) {
        m.b(i11, "newCount");
        m.b(i10, "oldCount");
        com.google.common.base.o.d(this.range.contains(e2));
        e<E> c4 = this.rootReference.c();
        if (c4 != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c4, c4.J(comparator(), e2, i10, i11, iArr));
            return iArr[0] == i10;
        }
        if (i10 != 0) {
            return false;
        }
        if (i11 > 0) {
            add(e2, i11);
        }
        return true;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class e<E> {

        /* renamed from: a, reason: collision with root package name */
        public final E f26528a;

        /* renamed from: b, reason: collision with root package name */
        public int f26529b;

        /* renamed from: c, reason: collision with root package name */
        public int f26530c;

        /* renamed from: d, reason: collision with root package name */
        public long f26531d;

        /* renamed from: e, reason: collision with root package name */
        public int f26532e;

        /* renamed from: f, reason: collision with root package name */
        public e<E> f26533f;

        /* renamed from: g, reason: collision with root package name */
        public e<E> f26534g;

        /* renamed from: h, reason: collision with root package name */
        public e<E> f26535h;

        /* renamed from: i, reason: collision with root package name */
        public e<E> f26536i;

        public e(E e2, int i10) {
            com.google.common.base.o.d(i10 > 0);
            this.f26528a = e2;
            this.f26529b = i10;
            this.f26531d = i10;
            this.f26530c = 1;
            this.f26532e = 1;
            this.f26533f = null;
            this.f26534g = null;
        }

        public static long M(e<?> eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f26531d;
        }

        public static int y(e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f26532e;
        }

        public final e<E> A() {
            int r10 = r();
            if (r10 == -2) {
                Objects.requireNonNull(this.f26534g);
                if (this.f26534g.r() > 0) {
                    this.f26534g = this.f26534g.I();
                }
                return H();
            }
            if (r10 != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f26533f);
            if (this.f26533f.r() < 0) {
                this.f26533f = this.f26533f.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.f26532e = Math.max(y(this.f26533f), y(this.f26534g)) + 1;
        }

        public final void D() {
            this.f26530c = TreeMultiset.distinctElements(this.f26533f) + 1 + TreeMultiset.distinctElements(this.f26534g);
            this.f26531d = this.f26529b + M(this.f26533f) + M(this.f26534g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> E(Comparator<? super E> comparator, E e2, int i10, int[] iArr) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                e<E> eVar = this.f26533f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f26533f = eVar.E(comparator, e2, i10, iArr);
                if (iArr[0] > 0) {
                    if (i10 >= iArr[0]) {
                        this.f26530c--;
                        this.f26531d -= iArr[0];
                    } else {
                        this.f26531d -= i10;
                    }
                }
                return iArr[0] == 0 ? this : A();
            }
            if (compare > 0) {
                e<E> eVar2 = this.f26534g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f26534g = eVar2.E(comparator, e2, i10, iArr);
                if (iArr[0] > 0) {
                    if (i10 >= iArr[0]) {
                        this.f26530c--;
                        this.f26531d -= iArr[0];
                    } else {
                        this.f26531d -= i10;
                    }
                }
                return A();
            }
            int i11 = this.f26529b;
            iArr[0] = i11;
            if (i10 >= i11) {
                return u();
            }
            this.f26529b = i11 - i10;
            this.f26531d -= i10;
            return this;
        }

        public final e<E> F(e<E> eVar) {
            e<E> eVar2 = this.f26534g;
            if (eVar2 == null) {
                return this.f26533f;
            }
            this.f26534g = eVar2.F(eVar);
            this.f26530c--;
            this.f26531d -= eVar.f26529b;
            return A();
        }

        public final e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f26533f;
            if (eVar2 == null) {
                return this.f26534g;
            }
            this.f26533f = eVar2.G(eVar);
            this.f26530c--;
            this.f26531d -= eVar.f26529b;
            return A();
        }

        public final e<E> H() {
            com.google.common.base.o.x(this.f26534g != null);
            e<E> eVar = this.f26534g;
            this.f26534g = eVar.f26533f;
            eVar.f26533f = this;
            eVar.f26531d = this.f26531d;
            eVar.f26530c = this.f26530c;
            B();
            eVar.C();
            return eVar;
        }

        public final e<E> I() {
            com.google.common.base.o.x(this.f26533f != null);
            e<E> eVar = this.f26533f;
            this.f26533f = eVar.f26534g;
            eVar.f26534g = this;
            eVar.f26531d = this.f26531d;
            eVar.f26530c = this.f26530c;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> J(Comparator<? super E> comparator, E e2, int i10, int i11, int[] iArr) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                e<E> eVar = this.f26533f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return (i10 != 0 || i11 <= 0) ? this : p(e2, i11);
                }
                this.f26533f = eVar.J(comparator, e2, i10, i11, iArr);
                if (iArr[0] == i10) {
                    if (i11 == 0 && iArr[0] != 0) {
                        this.f26530c--;
                    } else if (i11 > 0 && iArr[0] == 0) {
                        this.f26530c++;
                    }
                    this.f26531d += i11 - iArr[0];
                }
                return A();
            }
            if (compare > 0) {
                e<E> eVar2 = this.f26534g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return (i10 != 0 || i11 <= 0) ? this : q(e2, i11);
                }
                this.f26534g = eVar2.J(comparator, e2, i10, i11, iArr);
                if (iArr[0] == i10) {
                    if (i11 == 0 && iArr[0] != 0) {
                        this.f26530c--;
                    } else if (i11 > 0 && iArr[0] == 0) {
                        this.f26530c++;
                    }
                    this.f26531d += i11 - iArr[0];
                }
                return A();
            }
            int i12 = this.f26529b;
            iArr[0] = i12;
            if (i10 == i12) {
                if (i11 == 0) {
                    return u();
                }
                this.f26531d += i11 - i12;
                this.f26529b = i11;
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> K(Comparator<? super E> comparator, E e2, int i10, int[] iArr) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                e<E> eVar = this.f26533f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return i10 > 0 ? p(e2, i10) : this;
                }
                this.f26533f = eVar.K(comparator, e2, i10, iArr);
                if (i10 == 0 && iArr[0] != 0) {
                    this.f26530c--;
                } else if (i10 > 0 && iArr[0] == 0) {
                    this.f26530c++;
                }
                this.f26531d += i10 - iArr[0];
                return A();
            }
            if (compare > 0) {
                e<E> eVar2 = this.f26534g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return i10 > 0 ? q(e2, i10) : this;
                }
                this.f26534g = eVar2.K(comparator, e2, i10, iArr);
                if (i10 == 0 && iArr[0] != 0) {
                    this.f26530c--;
                } else if (i10 > 0 && iArr[0] == 0) {
                    this.f26530c++;
                }
                this.f26531d += i10 - iArr[0];
                return A();
            }
            iArr[0] = this.f26529b;
            if (i10 == 0) {
                return u();
            }
            this.f26531d += i10 - r3;
            this.f26529b = i10;
            return this;
        }

        public final e<E> L() {
            e<E> eVar = this.f26536i;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e<E> o(Comparator<? super E> comparator, E e2, int i10, int[] iArr) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                e<E> eVar = this.f26533f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return p(e2, i10);
                }
                int i11 = eVar.f26532e;
                e<E> o10 = eVar.o(comparator, e2, i10, iArr);
                this.f26533f = o10;
                if (iArr[0] == 0) {
                    this.f26530c++;
                }
                this.f26531d += i10;
                return o10.f26532e == i11 ? this : A();
            }
            if (compare > 0) {
                e<E> eVar2 = this.f26534g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return q(e2, i10);
                }
                int i12 = eVar2.f26532e;
                e<E> o11 = eVar2.o(comparator, e2, i10, iArr);
                this.f26534g = o11;
                if (iArr[0] == 0) {
                    this.f26530c++;
                }
                this.f26531d += i10;
                return o11.f26532e == i12 ? this : A();
            }
            int i13 = this.f26529b;
            iArr[0] = i13;
            long j10 = i10;
            com.google.common.base.o.d(((long) i13) + j10 <= ZipUtils.UPPER_UNIXTIME_BOUND);
            this.f26529b += i10;
            this.f26531d += j10;
            return this;
        }

        public final e<E> p(E e2, int i10) {
            this.f26533f = new e<>(e2, i10);
            TreeMultiset.successor(z(), this.f26533f, this);
            this.f26532e = Math.max(2, this.f26532e);
            this.f26530c++;
            this.f26531d += i10;
            return this;
        }

        public final e<E> q(E e2, int i10) {
            e<E> eVar = new e<>(e2, i10);
            this.f26534g = eVar;
            TreeMultiset.successor(this, eVar, L());
            this.f26532e = Math.max(2, this.f26532e);
            this.f26530c++;
            this.f26531d += i10;
            return this;
        }

        public final int r() {
            return y(this.f26533f) - y(this.f26534g);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> s(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                e<E> eVar = this.f26533f;
                return eVar == null ? this : (e) com.google.common.base.j.a(eVar.s(comparator, e2), this);
            }
            if (compare == 0) {
                return this;
            }
            e<E> eVar2 = this.f26534g;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.s(comparator, e2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int t(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                e<E> eVar = this.f26533f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.t(comparator, e2);
            }
            if (compare > 0) {
                e<E> eVar2 = this.f26534g;
                if (eVar2 == null) {
                    return 0;
                }
                return eVar2.t(comparator, e2);
            }
            return this.f26529b;
        }

        public String toString() {
            return Multisets.g(x(), w()).toString();
        }

        public final e<E> u() {
            int i10 = this.f26529b;
            this.f26529b = 0;
            TreeMultiset.successor(z(), L());
            e<E> eVar = this.f26533f;
            if (eVar == null) {
                return this.f26534g;
            }
            e<E> eVar2 = this.f26534g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.f26532e >= eVar2.f26532e) {
                e<E> z10 = z();
                z10.f26533f = this.f26533f.F(z10);
                z10.f26534g = this.f26534g;
                z10.f26530c = this.f26530c - 1;
                z10.f26531d = this.f26531d - i10;
                return z10.A();
            }
            e<E> L = L();
            L.f26534g = this.f26534g.G(L);
            L.f26533f = this.f26533f;
            L.f26530c = this.f26530c - 1;
            L.f26531d = this.f26531d - i10;
            return L.A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> v(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, x());
            if (compare > 0) {
                e<E> eVar = this.f26534g;
                return eVar == null ? this : (e) com.google.common.base.j.a(eVar.v(comparator, e2), this);
            }
            if (compare == 0) {
                return this;
            }
            e<E> eVar2 = this.f26533f;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.v(comparator, e2);
        }

        public int w() {
            return this.f26529b;
        }

        public E x() {
            return (E) l0.a(this.f26528a);
        }

        public final e<E> z() {
            e<E> eVar = this.f26535h;
            Objects.requireNonNull(eVar);
            return eVar;
        }

        public e() {
            this.f26528a = null;
            this.f26529b = 1;
        }
    }
}
