package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Lists {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        public final E first;
        public final E[] rest;

        public OnePlusArrayList(E e2, E[] eArr) {
            this.first = e2;
            this.rest = (E[]) ((Object[]) com.google.common.base.o.r(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i10) {
            com.google.common.base.o.p(i10, size());
            return i10 == 0 ? this.first : this.rest[i10 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.math.d.g(this.rest.length, 1);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        public StringAsImmutableList(String str) {
            this.string = str;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.string.length();
        }

        @Override // java.util.List
        public Character get(int i10) {
            com.google.common.base.o.p(i10, size());
            return Character.valueOf(this.string.charAt(i10));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i10, int i11) {
            com.google.common.base.o.w(i10, i11, size());
            return Lists.c(this.string.substring(i10, i11));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final List<F> fromList;
        public final com.google.common.base.g<? super F, ? extends T> function;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends g1<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.f1
            public T a(F f10) {
                return TransformingRandomAccessList.this.function.apply(f10);
            }
        }

        public TransformingRandomAccessList(List<F> list, com.google.common.base.g<? super F, ? extends T> gVar) {
            this.fromList = (List) com.google.common.base.o.r(list);
            this.function = (com.google.common.base.g) com.google.common.base.o.r(gVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i10) {
            return this.function.apply(this.fromList.get(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new a(this.fromList.listIterator(i10));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i10) {
            return this.function.apply(this.fromList.remove(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.fromList.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        public final List<F> fromList;
        public final com.google.common.base.g<? super F, ? extends T> function;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends g1<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.f1
            public T a(F f10) {
                return TransformingSequentialList.this.function.apply(f10);
            }
        }

        public TransformingSequentialList(List<F> list, com.google.common.base.g<? super F, ? extends T> gVar) {
            this.fromList = (List) com.google.common.base.o.r(list);
            this.function = (com.google.common.base.g) com.google.common.base.o.r(gVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new a(this.fromList.listIterator(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.fromList.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        public final E first;
        public final E[] rest;
        public final E second;

        public TwoPlusArrayList(E e2, E e10, E[] eArr) {
            this.first = e2;
            this.second = e10;
            this.rest = (E[]) ((Object[]) com.google.common.base.o.r(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i10) {
            if (i10 == 0) {
                return this.first;
            }
            if (i10 != 1) {
                com.google.common.base.o.p(i10, size());
                return this.rest[i10 - 2];
            }
            return this.second;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.math.d.g(this.rest.length, 2);
        }
    }

    public static <E> List<E> a(E e2, E[] eArr) {
        return new OnePlusArrayList(e2, eArr);
    }

    public static <T> List<T> b(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static ImmutableList<Character> c(String str) {
        return new StringAsImmutableList((String) com.google.common.base.o.r(str));
    }

    public static int d(int i10) {
        m.b(i10, "arraySize");
        return Ints.l(i10 + 5 + (i10 / 10));
    }

    public static boolean e(List<?> list, Object obj) {
        if (obj == com.google.common.base.o.r(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.g(list.iterator2(), list2.iterator2());
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!com.google.common.base.l.a(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static int f(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return g(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.l.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int g(List<?> list, Object obj) {
        int size = list.size();
        int i10 = 0;
        if (obj == null) {
            while (i10 < size) {
                if (list.get(i10) == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < size) {
            if (obj.equals(list.get(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int h(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return i(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.l.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int i(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> j() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> k(Iterable<? extends E> iterable) {
        com.google.common.base.o.r(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>((Collection) iterable);
        }
        return l(iterable.iterator2());
    }

    public static <E> ArrayList<E> l(Iterator<? extends E> it) {
        ArrayList<E> j10 = j();
        Iterators.a(j10, it);
        return j10;
    }

    @SafeVarargs
    public static <E> ArrayList<E> m(E... eArr) {
        com.google.common.base.o.r(eArr);
        ArrayList<E> arrayList = new ArrayList<>(d(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <E> ArrayList<E> n(int i10) {
        m.b(i10, "initialArraySize");
        return new ArrayList<>(i10);
    }

    public static <E> ArrayList<E> o(int i10) {
        return new ArrayList<>(d(i10));
    }

    public static <F, T> List<T> p(List<F> list, com.google.common.base.g<? super F, ? extends T> gVar) {
        if (list instanceof RandomAccess) {
            return new TransformingRandomAccessList(list, gVar);
        }
        return new TransformingSequentialList(list, gVar);
    }
}
