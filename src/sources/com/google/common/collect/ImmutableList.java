package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final j1<Object> EMPTY_ITR = new b(RegularImmutableList.EMPTY, 0);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        public ReverseImmutableList(ImmutableList<E> immutableList) {
            this.forwardList = immutableList;
        }

        private int reverseIndex(int i10) {
            return (size() - 1) - i10;
        }

        private int reversePosition(int i10) {
            return size() - i10;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.forwardList.contains(obj);
        }

        @Override // java.util.List
        public E get(int i10) {
            com.google.common.base.o.p(i10, size());
            return this.forwardList.get(reverseIndex(i10));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int lastIndexOf = this.forwardList.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return reverseIndex(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.forwardList.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public /* bridge */ /* synthetic */ Iterator iterator2() {
            return super.iterator2();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int indexOf = this.forwardList.indexOf(obj);
            if (indexOf >= 0) {
                return reverseIndex(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.forwardList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i10, int i11) {
            com.google.common.base.o.w(i10, i11, size());
            return this.forwardList.subList(reversePosition(i11), reversePosition(i10)).reverse();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class SubList extends ImmutableList<E> {
        public final transient int length;
        public final transient int offset;

        public SubList(int i10, int i11) {
            this.offset = i10;
            this.length = i11;
        }

        @Override // java.util.List
        public E get(int i10) {
            com.google.common.base.o.p(i10, this.length);
            return ImmutableList.this.get(i10 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public /* bridge */ /* synthetic */ Iterator iterator2() {
            return super.iterator2();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i10, int i11) {
            com.google.common.base.o.w(i10, i11, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i12 = this.offset;
            return immutableList.subList(i10 + i12, i11 + i12);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a<E> extends ImmutableCollection.a<E> {
        public a() {
            this(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e2) {
            super.f(e2);
            return this;
        }

        public a<E> j(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        public ImmutableList<E> k() {
            this.f26259c = true;
            return ImmutableList.asImmutableList(this.f26257a, this.f26258b);
        }

        public a(int i10) {
            super(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b<E> extends com.google.common.collect.a<E> {

        /* renamed from: d, reason: collision with root package name */
        public final ImmutableList<E> f26260d;

        public b(ImmutableList<E> immutableList, int i10) {
            super(immutableList.size(), i10);
            this.f26260d = immutableList;
        }

        @Override // com.google.common.collect.a
        public E a(int i10) {
            return this.f26260d.get(i10);
        }
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i10) {
        m.b(i10, "expectedSize");
        return new a<>(i10);
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(m0.b(objArr));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        com.google.common.base.o.r(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator2());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) g0.m(iterable, new Comparable[0]);
        m0.b(comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @Deprecated
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return Lists.e(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.f(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.h(this, obj);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e2) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> subListUnchecked(int i10, int i11) {
        return new SubList(i10, i11 - i10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i10) {
        if (i10 == 0) {
            return of();
        }
        return new RegularImmutableList(objArr, i10);
    }

    public static <E> ImmutableList<E> of(E e2) {
        return construct(e2);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public i1<E> iterator2() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i10, int i11) {
        com.google.common.base.o.w(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return of();
        }
        return subListUnchecked(i10, i11);
    }

    public static <E> ImmutableList<E> of(E e2, E e10) {
        return construct(e2, e10);
    }

    @Override // java.util.List
    public j1<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11) {
        return construct(e2, e10, e11);
    }

    @Override // java.util.List
    public j1<E> listIterator(int i10) {
        com.google.common.base.o.u(i10, size());
        if (isEmpty()) {
            return (j1<E>) EMPTY_ITR;
        }
        return new b(this, i10);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
            return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
        }
        return construct(collection.toArray());
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12) {
        return construct(e2, e10, e11, e12);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.o.r(comparator);
        Object[] l10 = g0.l(iterable);
        m0.b(l10);
        Arrays.sort(l10, comparator);
        return asImmutableList(l10);
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12, E e13) {
        return construct(e2, e10, e11, e12, e13);
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12, E e13, E e14) {
        return construct(e2, e10, e11, e12, e13, e14);
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E e15) {
        return construct(e2, e10, e11, e12, e13, e14, e15);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().a(next).j(it).k();
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        return construct(e2, e10, e11, e12, e13, e14, e15, e16);
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17) {
        return construct(e2, e10, e11, e12, e13, e14, e15, e16, e17);
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18) {
        return construct(e2, e10, e11, e12, e13, e14, e15, e16, e17, e18);
    }

    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19) {
        return construct(e2, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e20, E... eArr) {
        com.google.common.base.o.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e2;
        objArr[1] = e10;
        objArr[2] = e11;
        objArr[3] = e12;
        objArr[4] = e13;
        objArr[5] = e14;
        objArr[6] = e15;
        objArr[7] = e16;
        objArr[8] = e17;
        objArr[9] = e18;
        objArr[10] = e19;
        objArr[11] = e20;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return construct(objArr);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        return construct((Object[]) eArr.clone());
    }
}
