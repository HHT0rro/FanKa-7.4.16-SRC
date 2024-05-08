package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: UByteArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h implements Collection<g>, zd.a {

    /* compiled from: UByteArray.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<g>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final byte[] f50948b;

        /* renamed from: c, reason: collision with root package name */
        public int f50949c;

        public a(@NotNull byte[] array) {
            s.i(array, "array");
            this.f50948b = array;
        }

        public byte a() {
            int i10 = this.f50949c;
            byte[] bArr = this.f50948b;
            if (i10 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f50949c));
            }
            this.f50949c = i10 + 1;
            return g.b(bArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f50949c < this.f50948b.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ g next() {
            return g.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static Iterator<g> b(byte[] bArr) {
        return new a(bArr);
    }
}
