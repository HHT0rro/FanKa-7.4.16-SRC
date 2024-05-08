package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: _CollectionsJvm.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class z extends y {
    @NotNull
    public static final <R> List<R> H(@NotNull Iterable<?> iterable, @NotNull Class<R> klass) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(klass, "klass");
        return (List) I(iterable, new ArrayList(), klass);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C I(@NotNull Iterable<?> iterable, @NotNull C destination, @NotNull Class<R> klass) {
        kotlin.jvm.internal.s.i(iterable, "<this>");
        kotlin.jvm.internal.s.i(destination, "destination");
        kotlin.jvm.internal.s.i(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final <T> void J(@NotNull List<T> list) {
        kotlin.jvm.internal.s.i(list, "<this>");
        Collections.reverse(list);
    }
}
