package com.google.common.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class Ordering<T> implements Comparator<T> {
    public static final int LEFT_IS_GREATER = 1;
    public static final int RIGHT_IS_GREATER = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        public final Object value;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public IncomparableValueException(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r1 = r0.length()
                int r1 = r1 + 22
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                java.lang.String r1 = "Cannot compare value: "
                r2.append(r1)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r3.<init>(r0)
                r3.value = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Ordering.IncomparableValueException.<init>(java.lang.Object):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends Ordering<Object> {

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f26458b = new AtomicInteger(0);

        /* renamed from: c, reason: collision with root package name */
        public final ConcurrentMap<Object, Integer> f26459c = q0.i(new MapMaker()).i();

        public final Integer a(Object obj) {
            Integer num = this.f26459c.get(obj);
            if (num != null) {
                return num;
            }
            Integer valueOf = Integer.valueOf(this.f26458b.getAndIncrement());
            Integer putIfAbsent = this.f26459c.putIfAbsent(obj, valueOf);
            return putIfAbsent != null ? putIfAbsent : valueOf;
        }

        public int b(Object obj) {
            return System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int b4 = b(obj);
            int b10 = b(obj2);
            if (b4 != b10) {
                return b4 < b10 ? -1 : 1;
            }
            int compareTo = a(obj).compareTo(a(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final Ordering<Object> f26460a = new a();
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.f26460a;
    }

    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    public static <T> Ordering<T> from(Comparator<T> comparator) {
        if (comparator instanceof Ordering) {
            return (Ordering) comparator;
        }
        return new ComparatorOrdering(comparator);
    }

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, T t2) {
        return Collections.binarySearch(list, t2, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t2, T t10);

    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) com.google.common.base.o.r(comparator));
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i10) {
        return reverse().leastOf(iterable, i10);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> iterator2 = iterable.iterator2();
        if (!iterator2.hasNext()) {
            return true;
        }
        T next = iterator2.next();
        while (iterator2.hasNext()) {
            T next2 = iterator2.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> iterator2 = iterable.iterator2();
        if (!iterator2.hasNext()) {
            return true;
        }
        T next = iterator2.next();
        while (iterator2.hasNext()) {
            T next2 = iterator2.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i10) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i10 * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i10) {
                    array = Arrays.copyOf(array, i10);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator2(), i10);
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.l());
    }

    public <F> Ordering<F> onResultOf(com.google.common.base.g<F, ? extends T> gVar) {
        return new ByFunctionOrdering(gVar, this);
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] l10 = g0.l(iterable);
        Arrays.sort(l10, this);
        return Lists.k(Arrays.asList(l10));
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    public static <T> Ordering<T> explicit(T t2, T... tArr) {
        return explicit(Lists.a(t2, tArr));
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i10) {
        return reverse().leastOf(it, i10);
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return (Ordering) com.google.common.base.o.r(ordering);
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator2());
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator2());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(E e2, E e10) {
        return compare(e2, e10) >= 0 ? e2 : e10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(E e2, E e10) {
        return compare(e2, e10) <= 0 ? e2 : e10;
    }

    public <E extends T> E max(E e2, E e10, E e11, E... eArr) {
        E e12 = (E) max(max(e2, e10), e11);
        for (E e13 : eArr) {
            e12 = (E) max(e12, e13);
        }
        return e12;
    }

    public <E extends T> E min(E e2, E e10, E e11, E... eArr) {
        E e12 = (E) min(min(e2, e10), e11);
        for (E e13 : eArr) {
            e12 = (E) min(e12, e13);
        }
        return e12;
    }

    public <E extends T> List<E> leastOf(Iterator<E> it, int i10) {
        com.google.common.base.o.r(it);
        m.b(i10, "k");
        if (i10 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i10 >= 1073741823) {
            ArrayList l10 = Lists.l(it);
            Collections.sort(l10, this);
            if (l10.size() > i10) {
                l10.subList(i10, l10.size()).clear();
            }
            l10.trimToSize();
            return Collections.unmodifiableList(l10);
        }
        e1 a10 = e1.a(i10, this);
        a10.c(it);
        return a10.f();
    }
}
