package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractList.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class b<E> extends AbstractCollection<E> implements List<E> {

    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: AbstractList.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void c(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            }
            if (i10 <= i11) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
        }

        public final boolean d(@NotNull Collection<?> c4, @NotNull Collection<?> other) {
            kotlin.jvm.internal.s.i(c4, "c");
            kotlin.jvm.internal.s.i(other, "other");
            if (c4.size() != other.size()) {
                return false;
            }
            Iterator<?> iterator2 = other.iterator2();
            Iterator<?> iterator22 = c4.iterator2();
            while (iterator22.hasNext()) {
                if (!kotlin.jvm.internal.s.d(iterator22.next(), iterator2.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(@NotNull Collection<?> c4) {
            kotlin.jvm.internal.s.i(c4, "c");
            Iterator<?> iterator2 = c4.iterator2();
            int i10 = 1;
            while (iterator2.hasNext()) {
                Object next = iterator2.next();
                i10 = (i10 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i10;
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: kotlin.collections.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class C0775b implements Iterator<E>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        public int f50905b;

        public C0775b() {
        }

        public final int a() {
            return this.f50905b;
        }

        public final void b(int i10) {
            this.f50905b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f50905b < b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                b<E> bVar = b.this;
                int i10 = this.f50905b;
                this.f50905b = i10 + 1;
                return bVar.get(i10);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class c extends b<E>.C0775b implements ListIterator<E> {
        public c(int i10) {
            super();
            b.Companion.b(i10, b.this.size());
            b(i10);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                b<E> bVar = b.this;
                b(a() - 1);
                return bVar.get(a());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class d<E> extends b<E> implements RandomAccess {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final b<E> f50908b;

        /* renamed from: c, reason: collision with root package name */
        public final int f50909c;

        /* renamed from: d, reason: collision with root package name */
        public int f50910d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull b<? extends E> list, int i10, int i11) {
            kotlin.jvm.internal.s.i(list, "list");
            this.f50908b = list;
            this.f50909c = i10;
            b.Companion.c(i10, i11, list.size());
            this.f50910d = i11 - i10;
        }

        @Override // kotlin.collections.b, java.util.List
        public E get(int i10) {
            b.Companion.a(i10, this.f50910d);
            return this.f50908b.get(this.f50909c + i10);
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f50910d;
        }
    }

    @Override // java.util.List
    public void add(int i10, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.d(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i10);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Companion.e(this);
    }

    @Override // java.util.List
    public int indexOf(E e2) {
        Iterator<E> iterator2 = iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            if (kotlin.jvm.internal.s.d(iterator2.next(), e2)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new C0775b();
    }

    @Override // java.util.List
    public int lastIndexOf(E e2) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.s.d(listIterator.previous(), e2)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i10, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i10) {
        return new c(i10);
    }
}
