package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: Iterables.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class g0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a<T> extends r<T> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterable f26580c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.p f26581d;

        public a(Iterable iterable, com.google.common.base.p pVar) {
            this.f26580c = iterable;
            this.f26581d = pVar;
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return Iterators.k(this.f26580c.iterator2(), this.f26581d);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b<T> extends r<T> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterable f26582c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.g f26583d;

        public b(Iterable iterable, com.google.common.base.g gVar) {
            this.f26582c = iterable;
            this.f26583d = gVar;
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return Iterators.x(this.f26582c.iterator2(), this.f26583d);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c<T> extends r<T> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterable f26584c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f26585d;

        /* compiled from: Iterables.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements Iterator<T> {

            /* renamed from: b, reason: collision with root package name */
            public boolean f26586b = true;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f26587c;

            public a(c cVar, Iterator it) {
                this.f26587c = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f26587c.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t2 = (T) this.f26587c.next();
                this.f26586b = false;
                return t2;
            }

            @Override // java.util.Iterator
            public void remove() {
                m.e(!this.f26586b);
                this.f26587c.remove();
            }
        }

        public c(Iterable iterable, int i10) {
            this.f26584c = iterable;
            this.f26585d = i10;
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            Iterable iterable = this.f26584c;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f26585d), list.size()).iterator2();
            }
            Iterator<T> iterator2 = iterable.iterator2();
            Iterators.b(iterator2, this.f26585d);
            return new a(this, iterator2);
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        return Iterators.a(collection, ((Iterable) com.google.common.base.o.r(iterable)).iterator2());
    }

    public static <E> Collection<E> b(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.l(iterable.iterator2());
    }

    public static <T> Iterable<T> c(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return r.b(iterable, iterable2);
    }

    public static <T> Iterable<T> d(Iterable<T> iterable, com.google.common.base.p<? super T> pVar) {
        com.google.common.base.o.r(iterable);
        com.google.common.base.o.r(pVar);
        return new a(iterable, pVar);
    }

    public static <T> T e(Iterable<? extends T> iterable, T t2) {
        return (T) Iterators.n(iterable.iterator2(), t2);
    }

    public static <T> T f(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return (T) h(list);
            }
            throw new NoSuchElementException();
        }
        return (T) Iterators.l(iterable.iterator2());
    }

    public static <T> T g(Iterable<? extends T> iterable, T t2) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t2;
            }
            if (iterable instanceof List) {
                return (T) h(Lists.b(iterable));
            }
        }
        return (T) Iterators.m(iterable.iterator2(), t2);
    }

    public static <T> T h(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T i(Iterable<T> iterable) {
        return (T) Iterators.o(iterable.iterator2());
    }

    public static boolean j(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator2().hasNext();
    }

    public static <T> Iterable<T> k(Iterable<T> iterable, int i10) {
        com.google.common.base.o.r(iterable);
        com.google.common.base.o.e(i10 >= 0, "number to skip cannot be negative");
        return new c(iterable, i10);
    }

    public static Object[] l(Iterable<?> iterable) {
        return b(iterable).toArray();
    }

    public static <T> T[] m(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) b(iterable).toArray(tArr);
    }

    public static String n(Iterable<?> iterable) {
        return Iterators.w(iterable.iterator2());
    }

    public static <F, T> Iterable<T> o(Iterable<F> iterable, com.google.common.base.g<? super F, ? extends T> gVar) {
        com.google.common.base.o.r(iterable);
        com.google.common.base.o.r(gVar);
        return new b(iterable, gVar);
    }
}
