package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class a<E> extends b<E> {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f26257a;

        /* renamed from: b, reason: collision with root package name */
        public int f26258b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f26259c;

        public a(int i10) {
            m.b(i10, "initialCapacity");
            this.f26257a = new Object[i10];
            this.f26258b = 0;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b<E> b(E... eArr) {
            g(eArr, eArr.length);
            return this;
        }

        public a<E> f(E e2) {
            com.google.common.base.o.r(e2);
            h(this.f26258b + 1);
            Object[] objArr = this.f26257a;
            int i10 = this.f26258b;
            this.f26258b = i10 + 1;
            objArr[i10] = e2;
            return this;
        }

        public final void g(Object[] objArr, int i10) {
            m0.c(objArr, i10);
            h(this.f26258b + i10);
            System.arraycopy(objArr, 0, this.f26257a, this.f26258b, i10);
            this.f26258b += i10;
        }

        public final void h(int i10) {
            Object[] objArr = this.f26257a;
            if (objArr.length < i10) {
                this.f26257a = Arrays.copyOf(objArr, b.e(objArr.length, i10));
                this.f26259c = false;
            } else if (this.f26259c) {
                this.f26257a = (Object[]) objArr.clone();
                this.f26259c = false;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b<E> {
        public static int e(int i10, int i11) {
            if (i11 < 0) {
                throw new AssertionError((Object) "cannot store more than MAX_VALUE elements");
            }
            int i12 = i10 + (i10 >> 1) + 1;
            if (i12 < i11) {
                i12 = Integer.highestOneBit(i11 - 1) << 1;
            }
            if (i12 < 0) {
                return Integer.MAX_VALUE;
            }
            return i12;
        }

        public abstract b<E> a(E e2);

        public b<E> b(E... eArr) {
            for (E e2 : eArr) {
                a(e2);
            }
            return this;
        }

        public b<E> c(Iterable<? extends E> iterable) {
            Iterator<? extends E> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                a(iterator2.next());
            }
            return this;
        }

        public b<E> d(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
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

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public int copyIntoArray(Object[] objArr, int i10) {
        i1<E> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            objArr[i10] = iterator2.next();
            i10++;
        }
        return i10;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public abstract i1<E> iterator2();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.o.r(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) q0.a(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) m0.e(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
