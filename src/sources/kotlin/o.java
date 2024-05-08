package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UShortArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class o implements Collection<n>, zd.a {

    /* compiled from: UShortArray.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<n>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final short[] f51046b;

        /* renamed from: c, reason: collision with root package name */
        public int f51047c;

        public a(@NotNull short[] array) {
            s.i(array, "array");
            this.f51046b = array;
        }

        public short a() {
            int i10 = this.f51047c;
            short[] sArr = this.f51046b;
            if (i10 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f51047c));
            }
            this.f51047c = i10 + 1;
            return n.b(sArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f51047c < this.f51046b.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ n next() {
            return n.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<n> b(short[] sArr) {
        return new a(sArr);
    }
}
