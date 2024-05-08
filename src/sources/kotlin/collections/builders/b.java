package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ListBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {
    public static final /* synthetic */ boolean a(Object[] objArr, int i10, int i11, List list) {
        return h(objArr, i10, i11, list);
    }

    public static final /* synthetic */ int b(Object[] objArr, int i10, int i11) {
        return i(objArr, i10, i11);
    }

    public static final /* synthetic */ String c(Object[] objArr, int i10, int i11) {
        return j(objArr, i10, i11);
    }

    @NotNull
    public static final <E> E[] d(int i10) {
        if (i10 >= 0) {
            return (E[]) new Object[i10];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    @NotNull
    public static final <T> T[] e(@NotNull T[] tArr, int i10) {
        s.i(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i10);
        s.h(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    public static final <E> void f(@NotNull E[] eArr, int i10) {
        s.i(eArr, "<this>");
        eArr[i10] = null;
    }

    public static final <E> void g(@NotNull E[] eArr, int i10, int i11) {
        s.i(eArr, "<this>");
        while (i10 < i11) {
            f(eArr, i10);
            i10++;
        }
    }

    public static final <T> boolean h(T[] tArr, int i10, int i11, List<?> list) {
        if (i11 != list.size()) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (!s.d(tArr[i10 + i12], list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    public static final <T> int i(T[] tArr, int i10, int i11) {
        int i12 = 1;
        for (int i13 = 0; i13 < i11; i13++) {
            T t2 = tArr[i10 + i13];
            i12 = (i12 * 31) + (t2 != null ? t2.hashCode() : 0);
        }
        return i12;
    }

    public static final <T> String j(T[] tArr, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder((i11 * 3) + 2);
        sb2.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append((Object) tArr[i10 + i12]);
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        s.h(sb3, "sb.toString()");
        return sb3;
    }
}
