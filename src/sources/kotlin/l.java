package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ULongArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l implements Collection<k>, zd.a {

    /* compiled from: ULongArray.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<k>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final long[] f51041b;

        /* renamed from: c, reason: collision with root package name */
        public int f51042c;

        public a(@NotNull long[] array) {
            s.i(array, "array");
            this.f51041b = array;
        }

        public long a() {
            int i10 = this.f51042c;
            long[] jArr = this.f51041b;
            if (i10 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f51042c));
            }
            this.f51042c = i10 + 1;
            return k.b(jArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f51042c < this.f51041b.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ k next() {
            return k.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<k> b(long[] jArr) {
        return new a(jArr);
    }
}
