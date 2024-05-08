package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Sets.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n0 extends m0 {
    @NotNull
    public static final <T> Set<T> g(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.s.i(set, "<this>");
        kotlin.jvm.internal.s.i(elements, "elements");
        Integer u10 = t.u(elements);
        if (u10 != null) {
            size = set.size() + u10.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(h0.c(size));
        linkedHashSet.addAll(set);
        x.x(linkedHashSet, elements);
        return linkedHashSet;
    }
}
