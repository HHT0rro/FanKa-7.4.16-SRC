package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UIntArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j implements Collection<i>, zd.a {

    /* compiled from: UIntArray.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<i>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final int[] f51003b;

        /* renamed from: c, reason: collision with root package name */
        public int f51004c;

        public a(@NotNull int[] array) {
            s.i(array, "array");
            this.f51003b = array;
        }

        public int a() {
            int i10 = this.f51004c;
            int[] iArr = this.f51003b;
            if (i10 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f51004c));
            }
            this.f51004c = i10 + 1;
            return i.b(iArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f51004c < this.f51003b.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ i next() {
            return i.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<i> b(int[] iArr) {
        return new a(iArr);
    }
}
