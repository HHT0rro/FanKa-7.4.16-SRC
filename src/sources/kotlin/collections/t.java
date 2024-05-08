package kotlin.collections;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Iterables.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class t extends s {
    public static final <T> int t(@NotNull Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }

    @Nullable
    public static final <T> Integer u(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }
}
