package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.i;
import kotlin.collections.l;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ListBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ListBuilder<E> extends kotlin.collections.e<E> implements RandomAccess, Serializable {

    @NotNull
    private E[] array;

    @Nullable
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;

    @Nullable
    private final ListBuilder<E> root;

    /* compiled from: ListBuilder.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<E> implements ListIterator<E>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final ListBuilder<E> f50912b;

        /* renamed from: c, reason: collision with root package name */
        public int f50913c;

        /* renamed from: d, reason: collision with root package name */
        public int f50914d;

        public a(@NotNull ListBuilder<E> list, int i10) {
            s.i(list, "list");
            this.f50912b = list;
            this.f50913c = i10;
            this.f50914d = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            ListBuilder<E> listBuilder = this.f50912b;
            int i10 = this.f50913c;
            this.f50913c = i10 + 1;
            listBuilder.add(i10, e2);
            this.f50914d = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f50913c < ((ListBuilder) this.f50912b).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f50913c > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f50913c < ((ListBuilder) this.f50912b).length) {
                int i10 = this.f50913c;
                this.f50913c = i10 + 1;
                this.f50914d = i10;
                return (E) ((ListBuilder) this.f50912b).array[((ListBuilder) this.f50912b).offset + this.f50914d];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f50913c;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i10 = this.f50913c;
            if (i10 > 0) {
                int i11 = i10 - 1;
                this.f50913c = i11;
                this.f50914d = i11;
                return (E) ((ListBuilder) this.f50912b).array[((ListBuilder) this.f50912b).offset + this.f50914d];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f50913c - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i10 = this.f50914d;
            if (i10 != -1) {
                this.f50912b.remove(i10);
                this.f50913c = this.f50914d;
                this.f50914d = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            int i10 = this.f50914d;
            if (i10 != -1) {
                this.f50912b.set(i10, e2);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i10, int i11, boolean z10, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i10;
        this.length = i11;
        this.isReadOnly = z10;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void addAllInternal(int i10, Collection<? extends E> collection, int i11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i10, collection, i11);
            this.array = this.backing.array;
            this.length += i11;
        } else {
            insertAtInternal(i10, i11);
            Iterator<? extends E> iterator2 = collection.iterator2();
            for (int i12 = 0; i12 < i11; i12++) {
                this.array[i10 + i12] = iterator2.next();
            }
        }
    }

    private final void addAtInternal(int i10, E e2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i10, e2);
            this.array = this.backing.array;
            this.length++;
        } else {
            insertAtInternal(i10, 1);
            this.array[i10] = e2;
        }
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        return b.a(this.array, this.offset, this.length, list);
    }

    private final void ensureCapacity(int i10) {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        if (i10 >= 0) {
            E[] eArr = this.array;
            if (i10 > eArr.length) {
                this.array = (E[]) b.e(this.array, i.f50928e.a(eArr.length, i10));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i10) {
        ensureCapacity(this.length + i10);
    }

    private final void insertAtInternal(int i10, int i11) {
        ensureExtraCapacity(i11);
        E[] eArr = this.array;
        l.f(eArr, eArr, i10 + i11, i10, this.offset + this.length);
        this.length += i11;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    private final E removeAtInternal(int i10) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i10);
        }
        E[] eArr = this.array;
        E e2 = eArr[i10];
        l.f(eArr, eArr, i10, i10 + 1, this.offset + this.length);
        b.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e2;
    }

    private final void removeRangeInternal(int i10, int i11) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i10, i11);
        } else {
            E[] eArr = this.array;
            l.f(eArr, eArr, i10, i10 + i11, this.length);
            E[] eArr2 = this.array;
            int i12 = this.length;
            b.g(eArr2, i12 - i11, i12);
        }
        this.length -= i11;
    }

    private final int retainOrRemoveAllInternal(int i10, int i11, Collection<? extends E> collection, boolean z10) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i10, i11, collection, z10);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.array[i14]) == z10) {
                E[] eArr = this.array;
                i12++;
                eArr[i13 + i10] = eArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        E[] eArr2 = this.array;
        l.f(eArr2, eArr2, i10 + i13, i11 + i10, this.length);
        E[] eArr3 = this.array;
        int i16 = this.length;
        b.g(eArr3, i16 - i15, i16);
        this.length -= i15;
        return i15;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        s.i(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    @NotNull
    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        kotlin.collections.b.Companion.a(i10, this.length);
        return this.array[this.offset + i10];
    }

    @Override // kotlin.collections.e
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public int hashCode() {
        return b.b(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.length; i10++) {
            if (s.d(this.array[this.offset + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i10 = this.length - 1; i10 >= 0; i10--) {
            if (s.d(this.array[this.offset + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
    }

    @Override // kotlin.collections.e
    public E removeAt(int i10) {
        checkIsMutable();
        kotlin.collections.b.Companion.a(i10, this.length);
        return removeAtInternal(this.offset + i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        s.i(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
    }

    @Override // kotlin.collections.e, java.util.AbstractList, java.util.List
    public E set(int i10, E e2) {
        checkIsMutable();
        kotlin.collections.b.Companion.a(i10, this.length);
        E[] eArr = this.array;
        int i11 = this.offset;
        E e10 = eArr[i11 + i10];
        eArr[i11 + i10] = e2;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int i10, int i11) {
        kotlin.collections.b.Companion.c(i10, i11, this.length);
        E[] eArr = this.array;
        int i12 = this.offset + i10;
        int i13 = i11 - i10;
        boolean z10 = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i12, i13, z10, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @NotNull
    public <T> T[] toArray(@NotNull T[] destination) {
        s.i(destination, "destination");
        int length = destination.length;
        int i10 = this.length;
        if (length < i10) {
            E[] eArr = this.array;
            int i11 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i11, i10 + i11, destination.getClass());
            s.h(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.array;
        int i12 = this.offset;
        l.f(eArr2, destination, 0, i12, i10 + i12);
        int length2 = destination.length;
        int i13 = this.length;
        if (length2 > i13) {
            destination[i13] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        return b.c(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i10) {
        kotlin.collections.b.Companion.b(i10, this.length);
        return new a(this, i10);
    }

    @Override // kotlin.collections.e, java.util.AbstractList, java.util.List
    public void add(int i10, E e2) {
        checkIsMutable();
        kotlin.collections.b.Companion.b(i10, this.length);
        addAtInternal(this.offset + i10, e2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @NotNull Collection<? extends E> elements) {
        s.i(elements, "elements");
        checkIsMutable();
        kotlin.collections.b.Companion.b(i10, this.length);
        int size = elements.size();
        addAllInternal(this.offset + i10, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @NotNull
    public Object[] toArray() {
        E[] eArr = this.array;
        int i10 = this.offset;
        return l.j(eArr, i10, this.length + i10);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i10) {
        this(b.d(i10), 0, 0, false, null, null);
    }
}
