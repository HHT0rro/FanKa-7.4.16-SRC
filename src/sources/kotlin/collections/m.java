package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _Arrays.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m extends l {
    public static final <T> int A(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        return tArr.length - 1;
    }

    @Nullable
    public static final <T> T B(@NotNull T[] tArr, int i10) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        if (i10 < 0 || i10 > A(tArr)) {
            return null;
        }
        return tArr[i10];
    }

    public static final int C(@NotNull byte[] bArr, byte b4) {
        kotlin.jvm.internal.s.i(bArr, "<this>");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (b4 == bArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final int D(@NotNull char[] cArr, char c4) {
        kotlin.jvm.internal.s.i(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c4 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final <T> int E(@NotNull T[] tArr, T t2) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        int i10 = 0;
        if (t2 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.s.d(t2, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final int F(@NotNull int[] iArr) {
        kotlin.jvm.internal.s.i(iArr, "<this>");
        if (!(iArr.length == 0)) {
            return iArr[z(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T G(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        if (!(tArr.length == 0)) {
            return tArr[A(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int H(@NotNull byte[] bArr, byte b4) {
        kotlin.jvm.internal.s.i(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (b4 == bArr[length]) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    public static final char I(@NotNull char[] cArr) {
        kotlin.jvm.internal.s.i(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static final <T> T J(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public static final List<Byte> K(@NotNull byte[] bArr, @NotNull IntRange indices) {
        kotlin.jvm.internal.s.i(bArr, "<this>");
        kotlin.jvm.internal.s.i(indices, "indices");
        return indices.isEmpty() ? s.j() : l.c(l.i(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C L(@NotNull T[] tArr, @NotNull C destination) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        for (T t2 : tArr) {
            destination.add(t2);
        }
        return destination;
    }

    @NotNull
    public static final <T> List<T> M(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return s.j();
        }
        if (length != 1) {
            return N(tArr);
        }
        return r.e(tArr[0]);
    }

    @NotNull
    public static final <T> List<T> N(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        return new ArrayList(s.g(tArr));
    }

    @NotNull
    public static final <T> Set<T> O(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return m0.d();
        }
        if (length != 1) {
            return (Set) L(tArr, new LinkedHashSet(h0.c(tArr.length)));
        }
        return l0.c(tArr[0]);
    }

    public static final boolean r(@NotNull byte[] bArr, byte b4) {
        kotlin.jvm.internal.s.i(bArr, "<this>");
        return C(bArr, b4) >= 0;
    }

    public static final boolean s(@NotNull char[] cArr, char c4) {
        kotlin.jvm.internal.s.i(cArr, "<this>");
        return D(cArr, c4) >= 0;
    }

    public static final <T> boolean t(@NotNull T[] tArr, T t2) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        return E(tArr, t2) >= 0;
    }

    @NotNull
    public static final <T> List<T> u(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        return (List) v(tArr, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C v(@NotNull T[] tArr, @NotNull C destination) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        for (T t2 : tArr) {
            if (t2 != null) {
                destination.add(t2);
            }
        }
        return destination;
    }

    public static final int w(@NotNull int[] iArr) {
        kotlin.jvm.internal.s.i(iArr, "<this>");
        if (!(iArr.length == 0)) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T x(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        if (!(tArr.length == 0)) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <T> IntRange y(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        return new IntRange(0, A(tArr));
    }

    public static final int z(@NotNull int[] iArr) {
        kotlin.jvm.internal.s.i(iArr, "<this>");
        return iArr.length - 1;
    }
}
