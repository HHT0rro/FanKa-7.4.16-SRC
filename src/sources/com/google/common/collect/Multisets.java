package com.google.common.collect;

import com.google.common.collect.Sets;
import com.google.common.collect.k0;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Multisets {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ImmutableEntry<E> extends b<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        public ImmutableEntry(E e2, int i10) {
            this.element = e2;
            this.count = i10;
            m.b(i10, "count");
        }

        @Override // com.google.common.collect.k0.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.k0.a
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UnmodifiableMultiset<E> extends y<E> implements Serializable {
        private static final long serialVersionUID = 0;
        public final k0<? extends E> delegate;
        public transient Set<E> elementSet;
        public transient Set<k0.a<E>> entrySet;

        public UnmodifiableMultiset(k0<? extends E> k0Var) {
            this.delegate = k0Var;
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.y, com.google.common.collect.k0
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            Set<E> createElementSet = createElementSet();
            this.elementSet = createElementSet;
            return createElementSet;
        }

        @Override // com.google.common.collect.y, com.google.common.collect.k0
        public Set<k0.a<E>> entrySet() {
            Set<k0.a<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<k0.a<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return Iterators.y(this.delegate.iterator2());
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.k0
        public int setCount(E e2, int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.k0
        public int add(E e2, int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.k0
        public int remove(Object obj, int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.k0
        public boolean setCount(E e2, int i10, int i11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.s, com.google.common.collect.z
        public k0<E> delegate() {
            return this.delegate;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a<E> extends f1<k0.a<E>, E> {
        public a(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.f1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(k0.a<E> aVar) {
            return aVar.getElement();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b<E> implements k0.a<E> {
        public boolean equals(Object obj) {
            if (!(obj instanceof k0.a)) {
                return false;
            }
            k0.a aVar = (k0.a) obj;
            return getCount() == aVar.getCount() && com.google.common.base.l.a(getElement(), aVar.getElement());
        }

        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.k0.a
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
            sb2.append(valueOf);
            sb2.append(" x ");
            sb2.append(count);
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class c<E> extends Sets.b<E> {
        public abstract k0<E> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return b().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return b().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().entrySet().size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class d<E> extends Sets.b<k0.a<E>> {
        public abstract k0<E> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof k0.a)) {
                return false;
            }
            k0.a aVar = (k0.a) obj;
            return aVar.getCount() > 0 && b().count(aVar.getElement()) == aVar.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof k0.a) {
                k0.a aVar = (k0.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return b().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class e<E> implements Iterator<E> {

        /* renamed from: b, reason: collision with root package name */
        public final k0<E> f26450b;

        /* renamed from: c, reason: collision with root package name */
        public final Iterator<k0.a<E>> f26451c;

        /* renamed from: d, reason: collision with root package name */
        public k0.a<E> f26452d;

        /* renamed from: e, reason: collision with root package name */
        public int f26453e;

        /* renamed from: f, reason: collision with root package name */
        public int f26454f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f26455g;

        public e(k0<E> k0Var, Iterator<k0.a<E>> it) {
            this.f26450b = k0Var;
            this.f26451c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26453e > 0 || this.f26451c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.f26453e == 0) {
                    k0.a<E> next = this.f26451c.next();
                    this.f26452d = next;
                    int count = next.getCount();
                    this.f26453e = count;
                    this.f26454f = count;
                }
                this.f26453e--;
                this.f26455g = true;
                k0.a<E> aVar = this.f26452d;
                Objects.requireNonNull(aVar);
                return aVar.getElement();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f26455g);
            if (this.f26454f == 1) {
                this.f26451c.remove();
            } else {
                k0<E> k0Var = this.f26450b;
                k0.a<E> aVar = this.f26452d;
                Objects.requireNonNull(aVar);
                k0Var.remove(aVar.getElement());
            }
            this.f26454f--;
            this.f26455g = false;
        }
    }

    public static <E> boolean a(k0<E> k0Var, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(k0Var);
        return true;
    }

    public static <E> boolean b(k0<E> k0Var, k0<? extends E> k0Var2) {
        if (k0Var2 instanceof AbstractMapBasedMultiset) {
            return a(k0Var, (AbstractMapBasedMultiset) k0Var2);
        }
        if (k0Var2.isEmpty()) {
            return false;
        }
        for (k0.a<? extends E> aVar : k0Var2.entrySet()) {
            k0Var.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    public static <E> boolean c(k0<E> k0Var, Collection<? extends E> collection) {
        com.google.common.base.o.r(k0Var);
        com.google.common.base.o.r(collection);
        if (collection instanceof k0) {
            return b(k0Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(k0Var, collection.iterator2());
    }

    public static <T> k0<T> d(Iterable<T> iterable) {
        return (k0) iterable;
    }

    public static <E> Iterator<E> e(Iterator<k0.a<E>> it) {
        return new a(it);
    }

    public static boolean f(k0<?> k0Var, Object obj) {
        if (obj == k0Var) {
            return true;
        }
        if (obj instanceof k0) {
            k0 k0Var2 = (k0) obj;
            if (k0Var.size() == k0Var2.size() && k0Var.entrySet().size() == k0Var2.entrySet().size()) {
                for (k0.a aVar : k0Var2.entrySet()) {
                    if (k0Var.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> k0.a<E> g(E e2, int i10) {
        return new ImmutableEntry(e2, i10);
    }

    public static int h(Iterable<?> iterable) {
        if (iterable instanceof k0) {
            return ((k0) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> Iterator<E> i(k0<E> k0Var) {
        return new e(k0Var, k0Var.entrySet().iterator2());
    }

    public static int j(k0<?> k0Var) {
        long j10 = 0;
        while (k0Var.entrySet().iterator2().hasNext()) {
            j10 += r4.next().getCount();
        }
        return Ints.l(j10);
    }

    public static boolean k(k0<?> k0Var, Collection<?> collection) {
        if (collection instanceof k0) {
            collection = ((k0) collection).elementSet();
        }
        return k0Var.elementSet().removeAll(collection);
    }

    public static boolean l(k0<?> k0Var, Collection<?> collection) {
        com.google.common.base.o.r(collection);
        if (collection instanceof k0) {
            collection = ((k0) collection).elementSet();
        }
        return k0Var.elementSet().retainAll(collection);
    }

    public static <E> int m(k0<E> k0Var, E e2, int i10) {
        m.b(i10, "count");
        int count = k0Var.count(e2);
        int i11 = i10 - count;
        if (i11 > 0) {
            k0Var.add(e2, i11);
        } else if (i11 < 0) {
            k0Var.remove(e2, -i11);
        }
        return count;
    }

    public static <E> boolean n(k0<E> k0Var, E e2, int i10, int i11) {
        m.b(i10, "oldCount");
        m.b(i11, "newCount");
        if (k0Var.count(e2) != i10) {
            return false;
        }
        k0Var.setCount(e2, i11);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> k0<E> o(k0<? extends E> k0Var) {
        return ((k0Var instanceof UnmodifiableMultiset) || (k0Var instanceof ImmutableMultiset)) ? k0Var : new UnmodifiableMultiset((k0) com.google.common.base.o.r(k0Var));
    }

    public static <E> a1<E> p(a1<E> a1Var) {
        return new UnmodifiableSortedMultiset((a1) com.google.common.base.o.r(a1Var));
    }
}
