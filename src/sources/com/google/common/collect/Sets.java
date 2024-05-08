package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Sets {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a<E> extends c<E> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f26468b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Set f26469c;

        /* renamed from: com.google.common.collect.Sets$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class C0232a extends AbstractIterator<E> {

            /* renamed from: d, reason: collision with root package name */
            public final Iterator<E> f26470d;

            public C0232a() {
                this.f26470d = a.this.f26468b.iterator2();
            }

            @Override // com.google.common.collect.AbstractIterator
            public E a() {
                while (this.f26470d.hasNext()) {
                    E next = this.f26470d.next();
                    if (a.this.f26469c.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f26468b = set;
            this.f26469c = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i1<E> iterator2() {
            return new C0232a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f26468b.contains(obj) && this.f26469c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f26468b.containsAll(collection) && this.f26469c.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f26469c, this.f26468b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> iterator2 = this.f26468b.iterator2();
            int i10 = 0;
            while (iterator2.hasNext()) {
                if (this.f26469c.contains(iterator2.next())) {
                    i10++;
                }
            }
            return i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Sets.h(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) com.google.common.base.o.r(collection));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class c<E> extends AbstractSet<E> {
        public /* synthetic */ c(x0 x0Var) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public c() {
        }
    }

    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(Set<?> set) {
        Iterator<?> iterator2 = set.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    public static <E> c<E> c(Set<E> set, Set<?> set2) {
        com.google.common.base.o.s(set, "set1");
        com.google.common.base.o.s(set2, "set2");
        return new a(set, set2);
    }

    public static <E> HashSet<E> d() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> e(int i10) {
        return new HashSet<>(Maps.e(i10));
    }

    public static <E> Set<E> f() {
        return Collections.newSetFromMap(Maps.r());
    }

    public static <E> LinkedHashSet<E> g() {
        return new LinkedHashSet<>();
    }

    public static boolean h(Set<?> set, Collection<?> collection) {
        com.google.common.base.o.r(collection);
        if (collection instanceof k0) {
            collection = ((k0) collection).elementSet();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return Iterators.s(set.iterator2(), collection);
        }
        return i(set, collection.iterator2());
    }

    public static boolean i(Set<?> set, Iterator<?> it) {
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= set.remove(it.next());
        }
        return z10;
    }

    public static <E> NavigableSet<E> j(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class UnmodifiableNavigableSet<E> extends d0<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) com.google.common.base.o.r(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return this.delegate.ceiling(e2);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.y(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.descendingSet;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.descendingSet = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.descendingSet = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return this.delegate.floor(e2);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z10) {
            return Sets.j(this.delegate.headSet(e2, z10));
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return this.delegate.higher(e2);
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return this.delegate.lower(e2);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z10, E e10, boolean z11) {
            return Sets.j(this.delegate.subSet(e2, z10, e10, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z10) {
            return Sets.j(this.delegate.tailSet(e2, z10));
        }

        @Override // com.google.common.collect.d0, com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }
    }
}
