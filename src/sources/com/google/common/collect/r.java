package com.google.common.collect;

import com.google.common.base.Optional;
import java.util.Iterator;

/* compiled from: FluentIterable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class r<E> implements Iterable<E> {

    /* renamed from: b, reason: collision with root package name */
    public final Optional<Iterable<E>> f26615b;

    /* compiled from: FluentIterable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends r<E> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterable f26616c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f26616c = iterable2;
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return this.f26616c.iterator2();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FluentIterable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b<T> extends r<T> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterable[] f26617c;

        /* compiled from: FluentIterable.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends com.google.common.collect.a<Iterator<? extends T>> {
            public a(int i10) {
                super(i10);
            }

            @Override // com.google.common.collect.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> a(int i10) {
                return b.this.f26617c[i10].iterator2();
            }
        }

        public b(Iterable[] iterableArr) {
            this.f26617c = iterableArr;
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return Iterators.e(new a(this.f26617c.length));
        }
    }

    public r() {
        this.f26615b = Optional.absent();
    }

    public static <T> r<T> b(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return c(iterable, iterable2);
    }

    public static <T> r<T> c(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            com.google.common.base.o.r(iterable);
        }
        return new b(iterableArr);
    }

    public static <E> r<E> g(Iterable<E> iterable) {
        if (iterable instanceof r) {
            return (r) iterable;
        }
        return new a(iterable, iterable);
    }

    public final r<E> f(com.google.common.base.p<? super E> pVar) {
        return g(g0.d(h(), pVar));
    }

    public final Iterable<E> h() {
        return this.f26615b.or((Optional<Iterable<E>>) this);
    }

    public final ImmutableSet<E> i() {
        return ImmutableSet.copyOf(h());
    }

    public String toString() {
        return g0.n(h());
    }

    public r(Iterable<E> iterable) {
        this.f26615b = Optional.of(iterable);
    }
}
