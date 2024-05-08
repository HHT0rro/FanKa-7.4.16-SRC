package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* compiled from: SlidingWindow.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k0<T> extends b<T> implements RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Object[] f50934b;

    /* renamed from: c, reason: collision with root package name */
    public final int f50935c;

    /* renamed from: d, reason: collision with root package name */
    public int f50936d;

    /* renamed from: e, reason: collision with root package name */
    public int f50937e;

    /* compiled from: SlidingWindow.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends kotlin.collections.a<T> {

        /* renamed from: d, reason: collision with root package name */
        public int f50938d;

        /* renamed from: e, reason: collision with root package name */
        public int f50939e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ k0<T> f50940f;

        public a(k0<T> k0Var) {
            this.f50940f = k0Var;
            this.f50938d = k0Var.size();
            this.f50939e = k0Var.f50936d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.a
        public void a() {
            if (this.f50938d == 0) {
                b();
                return;
            }
            c(this.f50940f.f50934b[this.f50939e]);
            this.f50939e = (this.f50939e + 1) % this.f50940f.f50935c;
            this.f50938d--;
        }
    }

    public k0(@NotNull Object[] buffer, int i10) {
        kotlin.jvm.internal.s.i(buffer, "buffer");
        this.f50934b = buffer;
        if (i10 >= 0) {
            if (i10 <= buffer.length) {
                this.f50935c = buffer.length;
                this.f50937e = i10;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
    }

    public final void g(T t2) {
        if (!isFull()) {
            this.f50934b[(this.f50936d + size()) % this.f50935c] = t2;
            this.f50937e = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    @Override // kotlin.collections.b, java.util.List
    public T get(int i10) {
        b.Companion.a(i10, size());
        return (T) this.f50934b[(this.f50936d + i10) % this.f50935c];
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f50937e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final k0<T> h(int i10) {
        Object[] array;
        int i11 = this.f50935c;
        int d10 = ce.n.d(i11 + (i11 >> 1) + 1, i10);
        if (this.f50936d == 0) {
            array = Arrays.copyOf(this.f50934b, d10);
            kotlin.jvm.internal.s.h(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[d10]);
        }
        return new k0<>(array, size());
    }

    public final void i(int i10) {
        if (i10 >= 0) {
            if (!(i10 <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i10 + ", size = " + size()).toString());
            }
            if (i10 > 0) {
                int i11 = this.f50936d;
                int i12 = (i11 + i10) % this.f50935c;
                if (i11 > i12) {
                    l.l(this.f50934b, null, i11, this.f50935c);
                    l.l(this.f50934b, null, 0, i12);
                } else {
                    l.l(this.f50934b, null, i11, i12);
                }
                this.f50936d = i12;
                this.f50937e = size() - i10;
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i10).toString());
    }

    public final boolean isFull() {
        return size() == this.f50935c;
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    /* renamed from: iterator */
    public Iterator<T> iterator2() {
        return new a(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.s.i(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.s.h(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = this.f50936d; i11 < size && i12 < this.f50935c; i12++) {
            array[i11] = this.f50934b[i12];
            i11++;
        }
        while (i11 < size) {
            array[i11] = this.f50934b[i10];
            i11++;
            i10++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public k0(int i10) {
        this(new Object[i10], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
