package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import jdk.internal.util.ArraysSupport;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayDeque.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i<E> extends e<E> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f50928e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final Object[] f50929f = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    public int f50930b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Object[] f50931c = f50929f;

    /* renamed from: d, reason: collision with root package name */
    public int f50932d;

    /* compiled from: ArrayDeque.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(int i10, int i11) {
            int i12 = i10 + (i10 >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            if (i12 - ArraysSupport.SOFT_MAX_ARRAY_LENGTH <= 0) {
                return i12;
            }
            if (i11 > 2147483639) {
                return Integer.MAX_VALUE;
            }
            return ArraysSupport.SOFT_MAX_ARRAY_LENGTH;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + elements.size());
        b(i(this.f50930b + size()), elements);
        return true;
    }

    public final void addFirst(E e2) {
        ensureCapacity(size() + 1);
        int f10 = f(this.f50930b);
        this.f50930b = f10;
        this.f50931c[f10] = e2;
        this.f50932d = size() + 1;
    }

    public final void addLast(E e2) {
        ensureCapacity(size() + 1);
        this.f50931c[i(this.f50930b + size())] = e2;
        this.f50932d = size() + 1;
    }

    public final void b(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> iterator2 = collection.iterator2();
        int length = this.f50931c.length;
        while (i10 < length && iterator2.hasNext()) {
            this.f50931c[i10] = iterator2.next();
            i10++;
        }
        int i11 = this.f50930b;
        for (int i12 = 0; i12 < i11 && iterator2.hasNext(); i12++) {
            this.f50931c[i12] = iterator2.next();
        }
        this.f50932d = size() + collection.size();
    }

    public final void c(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f50931c;
        l.f(objArr2, objArr, 0, this.f50930b, objArr2.length);
        Object[] objArr3 = this.f50931c;
        int length = objArr3.length;
        int i11 = this.f50930b;
        l.f(objArr3, objArr, length - i11, 0, i11);
        this.f50930b = 0;
        this.f50931c = objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        int i10 = i(this.f50930b + size());
        int i11 = this.f50930b;
        if (i11 < i10) {
            l.l(this.f50931c, null, i11, i10);
        } else if (!isEmpty()) {
            Object[] objArr = this.f50931c;
            l.l(objArr, null, this.f50930b, objArr.length);
            l.l(this.f50931c, null, 0, i10);
        }
        this.f50930b = 0;
        this.f50932d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void ensureCapacity(int i10) {
        if (i10 >= 0) {
            Object[] objArr = this.f50931c;
            if (i10 <= objArr.length) {
                return;
            }
            if (objArr == f50929f) {
                this.f50931c = new Object[ce.n.b(i10, 10)];
                return;
            } else {
                c(f50928e.a(objArr.length, i10));
                return;
            }
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final int f(int i10) {
        return i10 == 0 ? m.A(this.f50931c) : i10 - 1;
    }

    public final int g(int i10) {
        if (i10 == m.A(this.f50931c)) {
            return 0;
        }
        return i10 + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        b.Companion.a(i10, size());
        return (E) this.f50931c[i(this.f50930b + i10)];
    }

    @Override // kotlin.collections.e
    public int getSize() {
        return this.f50932d;
    }

    public final int h(int i10) {
        return i10 < 0 ? i10 + this.f50931c.length : i10;
    }

    public final int i(int i10) {
        Object[] objArr = this.f50931c;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i10;
        int i11 = i(this.f50930b + size());
        int i12 = this.f50930b;
        if (i12 < i11) {
            while (i12 < i11) {
                if (kotlin.jvm.internal.s.d(obj, this.f50931c[i12])) {
                    i10 = this.f50930b;
                } else {
                    i12++;
                }
            }
            return -1;
        }
        if (i12 < i11) {
            return -1;
        }
        int length = this.f50931c.length;
        while (true) {
            if (i12 >= length) {
                for (int i13 = 0; i13 < i11; i13++) {
                    if (kotlin.jvm.internal.s.d(obj, this.f50931c[i13])) {
                        i12 = i13 + this.f50931c.length;
                        i10 = this.f50930b;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.s.d(obj, this.f50931c[i12])) {
                i10 = this.f50930b;
                break;
            }
            i12++;
        }
        return i12 - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f50931c[i(this.f50930b + s.l(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int A;
        int i10;
        int i11 = i(this.f50930b + size());
        int i12 = this.f50930b;
        if (i12 < i11) {
            A = i11 - 1;
            if (i12 <= A) {
                while (!kotlin.jvm.internal.s.d(obj, this.f50931c[A])) {
                    if (A != i12) {
                        A--;
                    }
                }
                i10 = this.f50930b;
                return A - i10;
            }
            return -1;
        }
        if (i12 > i11) {
            int i13 = i11 - 1;
            while (true) {
                if (-1 < i13) {
                    if (kotlin.jvm.internal.s.d(obj, this.f50931c[i13])) {
                        A = i13 + this.f50931c.length;
                        i10 = this.f50930b;
                        break;
                    }
                    i13--;
                } else {
                    A = m.A(this.f50931c);
                    int i14 = this.f50930b;
                    if (i14 <= A) {
                        while (!kotlin.jvm.internal.s.d(obj, this.f50931c[A])) {
                            if (A != i14) {
                                A--;
                            }
                        }
                        i10 = this.f50930b;
                    }
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        int i10;
        kotlin.jvm.internal.s.i(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if (!(this.f50931c.length == 0)) {
                int i11 = i(this.f50930b + size());
                int i12 = this.f50930b;
                if (i12 < i11) {
                    i10 = i12;
                    while (i12 < i11) {
                        Object obj = this.f50931c[i12];
                        if (!elements.contains(obj)) {
                            this.f50931c[i10] = obj;
                            i10++;
                        } else {
                            z10 = true;
                        }
                        i12++;
                    }
                    l.l(this.f50931c, null, i10, i11);
                } else {
                    int length = this.f50931c.length;
                    int i13 = i12;
                    boolean z11 = false;
                    while (i12 < length) {
                        Object[] objArr = this.f50931c;
                        Object obj2 = objArr[i12];
                        objArr[i12] = null;
                        if (!elements.contains(obj2)) {
                            this.f50931c[i13] = obj2;
                            i13++;
                        } else {
                            z11 = true;
                        }
                        i12++;
                    }
                    i10 = i(i13);
                    for (int i14 = 0; i14 < i11; i14++) {
                        Object[] objArr2 = this.f50931c;
                        Object obj3 = objArr2[i14];
                        objArr2[i14] = null;
                        if (!elements.contains(obj3)) {
                            this.f50931c[i10] = obj3;
                            i10 = g(i10);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    this.f50932d = h(i10 - this.f50930b);
                }
            }
        }
        return z10;
    }

    @Override // kotlin.collections.e
    public E removeAt(int i10) {
        b.Companion.a(i10, size());
        if (i10 == s.l(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        int i11 = i(this.f50930b + i10);
        E e2 = (E) this.f50931c[i11];
        if (i10 < (size() >> 1)) {
            int i12 = this.f50930b;
            if (i11 >= i12) {
                Object[] objArr = this.f50931c;
                l.f(objArr, objArr, i12 + 1, i12, i11);
            } else {
                Object[] objArr2 = this.f50931c;
                l.f(objArr2, objArr2, 1, 0, i11);
                Object[] objArr3 = this.f50931c;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i13 = this.f50930b;
                l.f(objArr3, objArr3, i13 + 1, i13, objArr3.length - 1);
            }
            Object[] objArr4 = this.f50931c;
            int i14 = this.f50930b;
            objArr4[i14] = null;
            this.f50930b = g(i14);
        } else {
            int i15 = i(this.f50930b + s.l(this));
            if (i11 <= i15) {
                Object[] objArr5 = this.f50931c;
                l.f(objArr5, objArr5, i11, i11 + 1, i15 + 1);
            } else {
                Object[] objArr6 = this.f50931c;
                l.f(objArr6, objArr6, i11, i11 + 1, objArr6.length);
                Object[] objArr7 = this.f50931c;
                objArr7[objArr7.length - 1] = objArr7[0];
                l.f(objArr7, objArr7, 0, 1, i15 + 1);
            }
            this.f50931c[i15] = null;
        }
        this.f50932d = size() - 1;
        return e2;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.f50931c;
            int i10 = this.f50930b;
            E e2 = (E) objArr[i10];
            objArr[i10] = null;
            this.f50930b = g(i10);
            this.f50932d = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int i10 = i(this.f50930b + s.l(this));
            Object[] objArr = this.f50931c;
            E e2 = (E) objArr[i10];
            objArr[i10] = null;
            this.f50932d = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        int i10;
        kotlin.jvm.internal.s.i(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if (!(this.f50931c.length == 0)) {
                int i11 = i(this.f50930b + size());
                int i12 = this.f50930b;
                if (i12 < i11) {
                    i10 = i12;
                    while (i12 < i11) {
                        Object obj = this.f50931c[i12];
                        if (elements.contains(obj)) {
                            this.f50931c[i10] = obj;
                            i10++;
                        } else {
                            z10 = true;
                        }
                        i12++;
                    }
                    l.l(this.f50931c, null, i10, i11);
                } else {
                    int length = this.f50931c.length;
                    int i13 = i12;
                    boolean z11 = false;
                    while (i12 < length) {
                        Object[] objArr = this.f50931c;
                        Object obj2 = objArr[i12];
                        objArr[i12] = null;
                        if (elements.contains(obj2)) {
                            this.f50931c[i13] = obj2;
                            i13++;
                        } else {
                            z11 = true;
                        }
                        i12++;
                    }
                    i10 = i(i13);
                    for (int i14 = 0; i14 < i11; i14++) {
                        Object[] objArr2 = this.f50931c;
                        Object obj3 = objArr2[i14];
                        objArr2[i14] = null;
                        if (elements.contains(obj3)) {
                            this.f50931c[i10] = obj3;
                            i10 = g(i10);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    this.f50932d = h(i10 - this.f50930b);
                }
            }
        }
        return z10;
    }

    @Override // kotlin.collections.e, java.util.AbstractList, java.util.List
    public E set(int i10, E e2) {
        b.Companion.a(i10, size());
        int i11 = i(this.f50930b + i10);
        Object[] objArr = this.f50931c;
        E e10 = (E) objArr[i11];
        objArr[i11] = e2;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.s.i(array, "array");
        if (array.length < size()) {
            array = (T[]) j.a(array, size());
        }
        int i10 = i(this.f50930b + size());
        int i11 = this.f50930b;
        if (i11 < i10) {
            l.h(this.f50931c, array, 0, i11, i10, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f50931c;
            l.f(objArr, array, 0, this.f50930b, objArr.length);
            Object[] objArr2 = this.f50931c;
            l.f(objArr2, array, objArr2.length - this.f50930b, 0, i10);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @Override // kotlin.collections.e, java.util.AbstractList, java.util.List
    public void add(int i10, E e2) {
        b.Companion.b(i10, size());
        if (i10 == size()) {
            addLast(e2);
            return;
        }
        if (i10 == 0) {
            addFirst(e2);
            return;
        }
        ensureCapacity(size() + 1);
        int i11 = i(this.f50930b + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int f10 = f(i11);
            int f11 = f(this.f50930b);
            int i12 = this.f50930b;
            if (f10 >= i12) {
                Object[] objArr = this.f50931c;
                objArr[f11] = objArr[i12];
                l.f(objArr, objArr, i12, i12 + 1, f10 + 1);
            } else {
                Object[] objArr2 = this.f50931c;
                l.f(objArr2, objArr2, i12 - 1, i12, objArr2.length);
                Object[] objArr3 = this.f50931c;
                objArr3[objArr3.length - 1] = objArr3[0];
                l.f(objArr3, objArr3, 0, 1, f10 + 1);
            }
            this.f50931c[f10] = e2;
            this.f50930b = f11;
        } else {
            int i13 = i(this.f50930b + size());
            if (i11 < i13) {
                Object[] objArr4 = this.f50931c;
                l.f(objArr4, objArr4, i11 + 1, i11, i13);
            } else {
                Object[] objArr5 = this.f50931c;
                l.f(objArr5, objArr5, 1, 0, i13);
                Object[] objArr6 = this.f50931c;
                objArr6[0] = objArr6[objArr6.length - 1];
                l.f(objArr6, objArr6, i11 + 1, i11, objArr6.length - 1);
            }
            this.f50931c[i11] = e2;
        }
        this.f50932d = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        b.Companion.b(i10, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(elements);
        }
        ensureCapacity(size() + elements.size());
        int i11 = i(this.f50930b + size());
        int i12 = i(this.f50930b + i10);
        int size = elements.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i13 = this.f50930b;
            int i14 = i13 - size;
            if (i12 < i13) {
                Object[] objArr = this.f50931c;
                l.f(objArr, objArr, i14, i13, objArr.length);
                if (size >= i12) {
                    Object[] objArr2 = this.f50931c;
                    l.f(objArr2, objArr2, objArr2.length - size, 0, i12);
                } else {
                    Object[] objArr3 = this.f50931c;
                    l.f(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f50931c;
                    l.f(objArr4, objArr4, 0, size, i12);
                }
            } else if (i14 >= 0) {
                Object[] objArr5 = this.f50931c;
                l.f(objArr5, objArr5, i14, i13, i12);
            } else {
                Object[] objArr6 = this.f50931c;
                i14 += objArr6.length;
                int i15 = i12 - i13;
                int length = objArr6.length - i14;
                if (length >= i15) {
                    l.f(objArr6, objArr6, i14, i13, i12);
                } else {
                    l.f(objArr6, objArr6, i14, i13, i13 + length);
                    Object[] objArr7 = this.f50931c;
                    l.f(objArr7, objArr7, 0, this.f50930b + length, i12);
                }
            }
            this.f50930b = i14;
            b(h(i12 - size), elements);
        } else {
            int i16 = i12 + size;
            if (i12 < i11) {
                int i17 = size + i11;
                Object[] objArr8 = this.f50931c;
                if (i17 <= objArr8.length) {
                    l.f(objArr8, objArr8, i16, i12, i11);
                } else if (i16 >= objArr8.length) {
                    l.f(objArr8, objArr8, i16 - objArr8.length, i12, i11);
                } else {
                    int length2 = i11 - (i17 - objArr8.length);
                    l.f(objArr8, objArr8, 0, length2, i11);
                    Object[] objArr9 = this.f50931c;
                    l.f(objArr9, objArr9, i16, i12, length2);
                }
            } else {
                Object[] objArr10 = this.f50931c;
                l.f(objArr10, objArr10, size, 0, i11);
                Object[] objArr11 = this.f50931c;
                if (i16 >= objArr11.length) {
                    l.f(objArr11, objArr11, i16 - objArr11.length, i12, objArr11.length);
                } else {
                    l.f(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f50931c;
                    l.f(objArr12, objArr12, i16, i12, objArr12.length - size);
                }
            }
            b(i12, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
