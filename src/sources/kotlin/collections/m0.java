package kotlin.collections;

import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sets.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m0 extends l0 {
    @NotNull
    public static final <T> Set<T> d() {
        return EmptySet.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Set<T> e(@NotNull Set<? extends T> set) {
        kotlin.jvm.internal.s.i(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : l0.c(set.iterator2().next());
        }
        return d();
    }

    @NotNull
    public static final <T> Set<T> f(@NotNull T... elements) {
        kotlin.jvm.internal.s.i(elements, "elements");
        return elements.length > 0 ? m.O(elements) : d();
    }
}
