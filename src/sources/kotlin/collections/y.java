package kotlin.collections;

import java.util.List;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReversedViews.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y extends x {
    @NotNull
    public static final <T> List<T> F(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        return new j0(list);
    }

    public static final int G(List<?> list, int i10) {
        if (new IntRange(0, s.l(list)).i(i10)) {
            return s.l(list) - i10;
        }
        throw new IndexOutOfBoundsException("Element index " + i10 + " must be in range [" + ((Object) new IntRange(0, s.l(list))) + "].");
    }
}
