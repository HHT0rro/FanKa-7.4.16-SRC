package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* compiled from: _ArraysJvm.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l extends k {

    /* compiled from: _ArraysJvm.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends b<Byte> implements RandomAccess {

        /* renamed from: b */
        public final /* synthetic */ byte[] f50941b;

        public a(byte[] bArr) {
            this.f50941b = bArr;
        }

        public boolean b(byte b4) {
            return m.r(this.f50941b, b4);
        }

        @Override // kotlin.collections.b, java.util.List
        @NotNull
        /* renamed from: c */
        public Byte get(int i10) {
            return Byte.valueOf(this.f50941b[i10]);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return b(((Number) obj).byteValue());
            }
            return false;
        }

        public int f(byte b4) {
            return m.C(this.f50941b, b4);
        }

        public int g(byte b4) {
            return m.H(this.f50941b, b4);
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f50941b.length;
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return f(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50941b.length == 0;
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return g(((Number) obj).byteValue());
            }
            return -1;
        }
    }

    @NotNull
    public static final List<Byte> c(@NotNull byte[] bArr) {
        kotlin.jvm.internal.s.i(bArr, "<this>");
        return new a(bArr);
    }

    @NotNull
    public static final <T> List<T> d(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        List<T> a10 = n.a(tArr);
        kotlin.jvm.internal.s.h(a10, "asList(this)");
        return a10;
    }

    @NotNull
    public static final byte[] e(@NotNull byte[] bArr, @NotNull byte[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.s.i(bArr, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        System.arraycopy((Object) bArr, i11, (Object) destination, i10, i12 - i11);
        return destination;
    }

    @NotNull
    public static final <T> T[] f(@NotNull T[] tArr, @NotNull T[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        System.arraycopy(tArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ byte[] g(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return e(bArr, bArr2, i10, i11, i12);
    }

    public static /* synthetic */ Object[] h(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return f(objArr, objArr2, i10, i11, i12);
    }

    @NotNull
    public static final byte[] i(@NotNull byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.s.i(bArr, "<this>");
        j.b(i11, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.s.h(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final <T> T[] j(@NotNull T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        j.b(i11, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
        kotlin.jvm.internal.s.h(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final void k(@NotNull int[] iArr, int i10, int i11, int i12) {
        kotlin.jvm.internal.s.i(iArr, "<this>");
        Arrays.fill(iArr, i11, i12, i10);
    }

    public static final <T> void l(@NotNull T[] tArr, T t2, int i10, int i11) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t2);
    }

    public static /* synthetic */ void m(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        k(iArr, i10, i11, i12);
    }

    public static /* synthetic */ void n(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        l(objArr, obj, i10, i11);
    }

    @NotNull
    public static final <T> T[] o(@NotNull T[] tArr, @NotNull T[] elements) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        kotlin.jvm.internal.s.i(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.s.h(result, "result");
        return result;
    }

    public static final <T> void p(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void q(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        kotlin.jvm.internal.s.i(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
