package com.google.common.collect;

import com.google.common.collect.k0;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.zip.ZipUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    private static final long serialVersionUID = 0;
    public transient n0<E> backingMap;
    public transient long size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends AbstractMapBasedMultiset<E>.c<E> {
        public a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        public E b(int i10) {
            return AbstractMapBasedMultiset.this.backingMap.i(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends AbstractMapBasedMultiset<E>.c<k0.a<E>> {
        public b() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public k0.a<E> b(int i10) {
            return AbstractMapBasedMultiset.this.backingMap.g(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public int f26185b;

        /* renamed from: c, reason: collision with root package name */
        public int f26186c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f26187d;

        public c() {
            this.f26185b = AbstractMapBasedMultiset.this.backingMap.e();
            this.f26187d = AbstractMapBasedMultiset.this.backingMap.f26596d;
        }

        public final void a() {
            if (AbstractMapBasedMultiset.this.backingMap.f26596d != this.f26187d) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f26185b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T b4 = b(this.f26185b);
                int i10 = this.f26185b;
                this.f26186c = i10;
                this.f26185b = AbstractMapBasedMultiset.this.backingMap.s(i10);
                return b4;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f26186c != -1);
            AbstractMapBasedMultiset.this.size -= r0.backingMap.x(this.f26186c);
            this.f26185b = AbstractMapBasedMultiset.this.backingMap.t(this.f26185b, this.f26186c);
            this.f26186c = -1;
            this.f26187d = AbstractMapBasedMultiset.this.backingMap.f26596d;
        }
    }

    public AbstractMapBasedMultiset(int i10) {
        this.backingMap = newBackingMap(i10);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h10 = v0.h(objectInputStream);
        this.backingMap = newBackingMap(3);
        v0.g(this, objectInputStream, h10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        v0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public final int add(E e2, int i10) {
        if (i10 == 0) {
            return count(e2);
        }
        com.google.common.base.o.h(i10 > 0, "occurrences cannot be negative: %s", i10);
        int m10 = this.backingMap.m(e2);
        if (m10 == -1) {
            this.backingMap.u(e2, i10);
            this.size += i10;
            return 0;
        }
        int k10 = this.backingMap.k(m10);
        long j10 = i10;
        long j11 = k10 + j10;
        com.google.common.base.o.j(j11 <= ZipUtils.UPPER_UNIXTIME_BOUND, "too many occurrences: %s", j11);
        this.backingMap.B(m10, (int) j11);
        this.size += j10;
        return k10;
    }

    public void addTo(k0<? super E> k0Var) {
        com.google.common.base.o.r(k0Var);
        int e2 = this.backingMap.e();
        while (e2 >= 0) {
            k0Var.add(this.backingMap.i(e2), this.backingMap.k(e2));
            e2 = this.backingMap.s(e2);
        }
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.k0
    public final int count(Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.d
    public final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.d
    public final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.d
    public final Iterator<k0.a<E>> entryIterator() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator<E> iterator2() {
        return Multisets.i(this);
    }

    public abstract n0<E> newBackingMap(int i10);

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public final int remove(Object obj, int i10) {
        if (i10 == 0) {
            return count(obj);
        }
        com.google.common.base.o.h(i10 > 0, "occurrences cannot be negative: %s", i10);
        int m10 = this.backingMap.m(obj);
        if (m10 == -1) {
            return 0;
        }
        int k10 = this.backingMap.k(m10);
        if (k10 > i10) {
            this.backingMap.B(m10, k10 - i10);
        } else {
            this.backingMap.x(m10);
            i10 = k10;
        }
        this.size -= i10;
        return k10;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public final int setCount(E e2, int i10) {
        m.b(i10, "count");
        n0<E> n0Var = this.backingMap;
        int v2 = i10 == 0 ? n0Var.v(e2) : n0Var.u(e2, i10);
        this.size += i10 - v2;
        return v2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return Ints.l(this.size);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public final boolean setCount(E e2, int i10, int i11) {
        m.b(i10, "oldCount");
        m.b(i11, "newCount");
        int m10 = this.backingMap.m(e2);
        if (m10 == -1) {
            if (i10 != 0) {
                return false;
            }
            if (i11 > 0) {
                this.backingMap.u(e2, i11);
                this.size += i11;
            }
            return true;
        }
        if (this.backingMap.k(m10) != i10) {
            return false;
        }
        if (i11 == 0) {
            this.backingMap.x(m10);
            this.size -= i10;
        } else {
            this.backingMap.B(m10, i11);
            this.size += i11 - i10;
        }
        return true;
    }
}
