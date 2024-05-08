package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Iterable<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f25946b;

        /* renamed from: com.google.common.base.Optional$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class C0222a extends AbstractIterator<T> {

            /* renamed from: d, reason: collision with root package name */
            public final Iterator<? extends Optional<? extends T>> f25947d;

            public C0222a() {
                this.f25947d = (Iterator) o.r(a.this.f25946b.iterator2());
            }

            @Override // com.google.common.base.AbstractIterator
            public T a() {
                while (this.f25947d.hasNext()) {
                    Optional<? extends T> next = this.f25947d.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        public a(Iterable iterable) {
            this.f25946b = iterable;
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return new C0222a();
        }
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T t2) {
        return t2 == null ? absent() : new Present(t2);
    }

    public static <T> Optional<T> of(T t2) {
        return new Present(o.r(t2));
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        o.r(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(t<? extends T> tVar);

    public abstract T or(T t2);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(g<? super T, V> gVar);
}
