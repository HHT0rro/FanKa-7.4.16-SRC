package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;
import org.jetbrains.annotations.NotNull;

/* compiled from: CollectionsJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r {
    @NotNull
    public static final <E> List<E> a(@NotNull List<E> builder) {
        kotlin.jvm.internal.s.i(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    @NotNull
    public static final <T> Object[] b(@NotNull T[] tArr, boolean z10) {
        kotlin.jvm.internal.s.i(tArr, "<this>");
        if (z10 && kotlin.jvm.internal.s.d(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.s.h(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    @NotNull
    public static final <E> List<E> c() {
        return new ListBuilder();
    }

    @NotNull
    public static final <E> List<E> d(int i10) {
        return new ListBuilder(i10);
    }

    @NotNull
    public static final <T> List<T> e(T t2) {
        List<T> singletonList = Collections.singletonList(t2);
        kotlin.jvm.internal.s.h(singletonList, "singletonList(element)");
        return singletonList;
    }
}
