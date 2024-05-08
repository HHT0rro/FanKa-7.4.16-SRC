package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;
import org.jetbrains.annotations.NotNull;

/* compiled from: SetsJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l0 {
    @NotNull
    public static final <E> Set<E> a(@NotNull Set<E> builder) {
        kotlin.jvm.internal.s.i(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    @NotNull
    public static final <E> Set<E> b(int i10) {
        return new SetBuilder(i10);
    }

    @NotNull
    public static final <T> Set<T> c(T t2) {
        Set<T> singleton = Collections.singleton(t2);
        kotlin.jvm.internal.s.h(singleton, "singleton(element)");
        return singleton;
    }
}
