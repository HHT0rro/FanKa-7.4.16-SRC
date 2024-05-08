package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterator.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g<T> implements Iterator<T>, zd.a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final T[] f51018b;

    /* renamed from: c, reason: collision with root package name */
    public int f51019c;

    public g(@NotNull T[] array) {
        s.i(array, "array");
        this.f51018b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51019c < this.f51018b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f51018b;
            int i10 = this.f51019c;
            this.f51019c = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f51019c--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
