package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Iterators {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a<T> extends i1<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f26316b;

        public a(Iterator it) {
            this.f26316b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26316b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f26316b.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b<T> extends AbstractIterator<T> {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Iterator f26317d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.p f26318e;

        public b(Iterator it, com.google.common.base.p pVar) {
            this.f26317d = it;
            this.f26318e = pVar;
        }

        @Override // com.google.common.collect.AbstractIterator
        public T a() {
            while (this.f26317d.hasNext()) {
                T t2 = (T) this.f26317d.next();
                if (this.f26318e.apply(t2)) {
                    return t2;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c<F, T> extends f1<F, T> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.g f26319c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterator it, com.google.common.base.g gVar) {
            super(it);
            this.f26319c = gVar;
        }

        @Override // com.google.common.collect.f1
        public T a(F f10) {
            return (T) this.f26319c.apply(f10);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d<T> extends i1<T> {

        /* renamed from: b, reason: collision with root package name */
        public boolean f26320b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f26321c;

        public d(Object obj) {
            this.f26321c = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f26320b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f26320b) {
                this.f26320b = true;
                return (T) this.f26321c;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class e<T> extends com.google.common.collect.a<T> {

        /* renamed from: f, reason: collision with root package name */
        public static final j1<Object> f26322f = new e(new Object[0], 0, 0, 0);

        /* renamed from: d, reason: collision with root package name */
        public final T[] f26323d;

        /* renamed from: e, reason: collision with root package name */
        public final int f26324e;

        public e(T[] tArr, int i10, int i11, int i12) {
            super(i11, i12);
            this.f26323d = tArr;
            this.f26324e = i10;
        }

        @Override // com.google.common.collect.a
        public T a(int i10) {
            return this.f26323d[this.f26324e + i10];
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class f<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public Iterator<? extends T> f26325b;

        /* renamed from: c, reason: collision with root package name */
        public Iterator<? extends T> f26326c = Iterators.h();

        /* renamed from: d, reason: collision with root package name */
        public Iterator<? extends Iterator<? extends T>> f26327d;

        /* renamed from: e, reason: collision with root package name */
        public Deque<Iterator<? extends Iterator<? extends T>>> f26328e;

        public f(Iterator<? extends Iterator<? extends T>> it) {
            this.f26327d = (Iterator) com.google.common.base.o.r(it);
        }

        public final Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f26327d;
                if (it != null && it.hasNext()) {
                    return this.f26327d;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f26328e;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f26327d = this.f26328e.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) com.google.common.base.o.r(this.f26326c)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> a10 = a();
                this.f26327d = a10;
                if (a10 == null) {
                    return false;
                }
                Iterator<? extends T> next = a10.next();
                this.f26326c = next;
                if (next instanceof f) {
                    f fVar = (f) next;
                    this.f26326c = fVar.f26326c;
                    if (this.f26328e == null) {
                        this.f26328e = new ArrayDeque();
                    }
                    this.f26328e.addFirst(this.f26327d);
                    if (fVar.f26328e != null) {
                        while (!fVar.f26328e.isEmpty()) {
                            this.f26328e.addFirst(fVar.f26328e.removeLast());
                        }
                    }
                    this.f26327d = fVar.f26327d;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.f26326c;
                this.f26325b = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> it = this.f26325b;
            if (it != null) {
                it.remove();
                this.f26325b = null;
                return;
            }
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class g<T> extends i1<T> {

        /* renamed from: b, reason: collision with root package name */
        public final Queue<p0<T>> f26329b;

        public g(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.f26329b = new PriorityQueue(2, new Comparator() { // from class: com.google.common.collect.h0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int b4;
                    b4 = Iterators.g.b(Comparator.this, (p0) obj, (p0) obj2);
                    return b4;
                }
            });
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f26329b.add(Iterators.q(it));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ int b(Comparator comparator, p0 p0Var, p0 p0Var2) {
            return comparator.compare(p0Var.peek(), p0Var2.peek());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f26329b.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            p0<T> remove = this.f26329b.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.f26329b.add(remove);
            }
            return next;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class h<E> implements p0<E> {

        /* renamed from: b, reason: collision with root package name */
        public final Iterator<? extends E> f26330b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f26331c;

        /* renamed from: d, reason: collision with root package name */
        public E f26332d;

        public h(Iterator<? extends E> it) {
            this.f26330b = (Iterator) com.google.common.base.o.r(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26331c || this.f26330b.hasNext();
        }

        @Override // com.google.common.collect.p0, java.util.Iterator
        public E next() {
            if (!this.f26331c) {
                return this.f26330b.next();
            }
            E e2 = (E) l0.a(this.f26332d);
            this.f26331c = false;
            this.f26332d = null;
            return e2;
        }

        @Override // com.google.common.collect.p0
        public E peek() {
            if (!this.f26331c) {
                this.f26332d = this.f26330b.next();
                this.f26331c = true;
            }
            return (E) l0.a(this.f26332d);
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.o.y(!this.f26331c, "Can't remove after you've peeked at next");
            this.f26330b.remove();
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.o.r(collection);
        com.google.common.base.o.r(it);
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= collection.add(it.next());
        }
        return z10;
    }

    public static int b(Iterator<?> it, int i10) {
        com.google.common.base.o.r(it);
        int i11 = 0;
        com.google.common.base.o.e(i10 >= 0, "numberToAdvance must be nonnegative");
        while (i11 < i10 && it.hasNext()) {
            it.next();
            i11++;
        }
        return i11;
    }

    public static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    public static void d(Iterator<?> it) {
        com.google.common.base.o.r(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> it) {
        return new f(it);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:
    
        if (r2.hasNext() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
    
        if (r3.equals(r2.next()) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0020, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0001, code lost:
    
        if (r3 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
    
        if (r2.hasNext() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r2.next() != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(java.util.Iterator<?> r2, java.lang.Object r3) {
        /*
            r0 = 1
            if (r3 != 0) goto L10
        L3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L21
            java.lang.Object r3 = r2.next()
            if (r3 != 0) goto L3
            return r0
        L10:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L21
            java.lang.Object r1 = r2.next()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L10
            return r0
        L21:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.f(java.util.Iterator, java.lang.Object):boolean");
    }

    public static boolean g(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.l.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> i1<T> h() {
        return i();
    }

    public static <T> j1<T> i() {
        return (j1<T>) e.f26322f;
    }

    public static <T> Iterator<T> j() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> i1<T> k(Iterator<T> it, com.google.common.base.p<? super T> pVar) {
        com.google.common.base.o.r(it);
        com.google.common.base.o.r(pVar);
        return new b(it, pVar);
    }

    public static <T> T l(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T m(Iterator<? extends T> it, T t2) {
        return it.hasNext() ? (T) l(it) : t2;
    }

    public static <T> T n(Iterator<? extends T> it, T t2) {
        return it.hasNext() ? it.next() : t2;
    }

    public static <T> T o(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected one element but was: <");
        sb2.append((Object) next);
        for (int i10 = 0; i10 < 4 && it.hasNext(); i10++) {
            sb2.append(", ");
            sb2.append((Object) it.next());
        }
        if (it.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append('>');
        throw new IllegalArgumentException(sb2.toString());
    }

    public static <T> i1<T> p(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        com.google.common.base.o.s(iterable, "iterators");
        com.google.common.base.o.s(comparator, "comparator");
        return new g(iterable, comparator);
    }

    public static <T> p0<T> q(Iterator<? extends T> it) {
        if (it instanceof h) {
            return (h) it;
        }
        return new h(it);
    }

    public static <T> T r(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static boolean s(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.o.r(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean t(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.o.r(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> i1<T> u(T t2) {
        return new d(t2);
    }

    public static int v(Iterator<?> it) {
        long j10 = 0;
        while (it.hasNext()) {
            it.next();
            j10++;
        }
        return Ints.l(j10);
    }

    public static String w(Iterator<?> it) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z10 = true;
        while (it.hasNext()) {
            if (!z10) {
                sb2.append(", ");
            }
            z10 = false;
            sb2.append(it.next());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static <F, T> Iterator<T> x(Iterator<F> it, com.google.common.base.g<? super F, ? extends T> gVar) {
        com.google.common.base.o.r(gVar);
        return new c(it, gVar);
    }

    public static <T> i1<T> y(Iterator<? extends T> it) {
        com.google.common.base.o.r(it);
        if (it instanceof i1) {
            return (i1) it;
        }
        return new a(it);
    }
}
