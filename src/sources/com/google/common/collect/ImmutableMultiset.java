package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.k0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements k0<E> {
    private transient ImmutableList<E> asList;
    private transient ImmutableSet<k0.a<E>> entrySet;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class EntrySet extends IndexedImmutableSet<k0.a<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof k0.a)) {
                return false;
            }
            k0.a aVar = (k0.a) obj;
            return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        public /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public k0.a<E> get(int i10) {
            return ImmutableMultiset.this.getEntry(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class EntrySetSerializedForm<E> implements Serializable {
        public final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends i1<E> {

        /* renamed from: b, reason: collision with root package name */
        public int f26286b;

        /* renamed from: c, reason: collision with root package name */
        public E f26287c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Iterator f26288d;

        public a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.f26288d = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26286b > 0 || this.f26288d.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f26286b <= 0) {
                k0.a aVar = (k0.a) this.f26288d.next();
                this.f26287c = (E) aVar.getElement();
                this.f26286b = aVar.getCount();
            }
            this.f26286b--;
            E e2 = this.f26287c;
            Objects.requireNonNull(e2);
            return e2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b<E> extends ImmutableCollection.b<E> {

        /* renamed from: a, reason: collision with root package name */
        public n0<E> f26289a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f26290b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f26291c;

        public b() {
            this(4);
        }

        public static <T> n0<T> l(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e2) {
            return j(e2, 1);
        }

        public b<E> g(E... eArr) {
            super.b(eArr);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b<E> h(Iterable<? extends E> iterable) {
            Objects.requireNonNull(this.f26289a);
            if (iterable instanceof k0) {
                k0 d10 = Multisets.d(iterable);
                n0 l10 = l(d10);
                if (l10 != null) {
                    n0<E> n0Var = this.f26289a;
                    n0Var.d(Math.max(n0Var.C(), l10.C()));
                    for (int e2 = l10.e(); e2 >= 0; e2 = l10.s(e2)) {
                        j(l10.i(e2), l10.k(e2));
                    }
                } else {
                    Set<k0.a<E>> entrySet = d10.entrySet();
                    n0<E> n0Var2 = this.f26289a;
                    n0Var2.d(Math.max(n0Var2.C(), entrySet.size()));
                    for (k0.a<E> aVar : d10.entrySet()) {
                        j(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        public b<E> i(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        public b<E> j(E e2, int i10) {
            Objects.requireNonNull(this.f26289a);
            if (i10 == 0) {
                return this;
            }
            if (this.f26290b) {
                this.f26289a = new n0<>(this.f26289a);
                this.f26291c = false;
            }
            this.f26290b = false;
            com.google.common.base.o.r(e2);
            n0<E> n0Var = this.f26289a;
            n0Var.u(e2, i10 + n0Var.f(e2));
            return this;
        }

        public ImmutableMultiset<E> k() {
            Objects.requireNonNull(this.f26289a);
            if (this.f26289a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.f26291c) {
                this.f26289a = new n0<>(this.f26289a);
                this.f26291c = false;
            }
            this.f26290b = true;
            return new RegularImmutableMultiset(this.f26289a);
        }

        public b(int i10) {
            this.f26290b = false;
            this.f26291c = false;
            this.f26289a = n0.c(i10);
        }

        public b(boolean z10) {
            this.f26290b = false;
            this.f26291c = false;
            this.f26289a = null;
        }
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new b().g(eArr).k();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends k0.a<? extends E>> collection) {
        b bVar = new b(collection.size());
        for (k0.a<? extends E> aVar : collection) {
            bVar.j(aVar.getElement(), aVar.getCount());
        }
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<k0.a<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.k0
    @Deprecated
    public final int add(E e2, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList = super.asList();
        this.asList = asList;
        return asList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i10) {
        i1<k0.a<E>> iterator2 = entrySet().iterator2();
        while (iterator2.hasNext()) {
            k0.a<E> next = iterator2.next();
            Arrays.fill(objArr, i10, next.getCount() + i10, next.getElement());
            i10 += next.getCount();
        }
        return i10;
    }

    public abstract /* synthetic */ int count(Object obj);

    @Override // com.google.common.collect.k0
    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    public abstract k0.a<E> getEntry(int i10);

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.b(entrySet());
    }

    @Override // com.google.common.collect.k0
    @Deprecated
    public final int remove(Object obj, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.k0
    @Deprecated
    public final int setCount(E e2, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        b bVar = new b(Multisets.h(iterable));
        bVar.h(iterable);
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> of(E e2) {
        return copyFromElements(e2);
    }

    @Override // com.google.common.collect.k0
    public ImmutableSet<k0.a<E>> entrySet() {
        ImmutableSet<k0.a<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<k0.a<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public i1<E> iterator2() {
        return new a(this, entrySet().iterator2());
    }

    @Override // com.google.common.collect.k0
    @Deprecated
    public final boolean setCount(E e2, int i10, int i11) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e10) {
        return copyFromElements(e2, e10);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e10, E e11) {
        return copyFromElements(e2, e10, e11);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e10, E e11, E e12) {
        return copyFromElements(e2, e10, e11, e12);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e10, E e11, E e12, E e13) {
        return copyFromElements(e2, e10, e11, e12, e13);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E... eArr) {
        return new b().a(e2).a(e10).a(e11).a(e12).a(e13).a(e14).g(eArr).k();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new b().i(it).k();
    }
}
