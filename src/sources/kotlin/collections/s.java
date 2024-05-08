package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Collections.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s extends r {
    @NotNull
    public static final <T> ArrayList<T> f(@NotNull T... elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new h(elements, true));
    }

    @NotNull
    public static final <T> Collection<T> g(@NotNull T[] tArr) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        return new h(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int h(@NotNull List<? extends T> list, @Nullable T t2, int i10, int i11) {
        kotlin.jvm.internal.s.i(list, "<this>");
        q(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int a10 = qd.a.a(list.get(i13), t2);
            if (a10 < 0) {
                i10 = i13 + 1;
            } else {
                if (a10 <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int i(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return h(list, comparable, i10, i11);
    }

    @NotNull
    public static final <T> List<T> j() {
        return EmptyList.INSTANCE;
    }

    @NotNull
    public static final IntRange k(@NotNull Collection<?> collection) {
        kotlin.jvm.internal.s.i(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static final <T> int l(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        return list.size() - 1;
    }

    @NotNull
    public static final <T> List<T> m(@NotNull T... elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        return elements.length > 0 ? l.d(elements) : j();
    }

    @NotNull
    public static final <T> List<T> n(@NotNull T... elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        return m.u(elements);
    }

    @NotNull
    public static final <T> List<T> o(@NotNull T... elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new h(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> p(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : r.e(list.get(0));
        }
        return j();
    }

    public static final void q(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        }
        if (i12 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
    }

    public static final void r() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final void s() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
