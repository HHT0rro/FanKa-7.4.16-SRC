package androidx.collection;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArraySet.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ArraySetKt {
    @NotNull
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>();
    }

    @NotNull
    public static final <T> ArraySet<T> arraySetOf(@NotNull T... values) {
        s.j(values, "values");
        ArraySet<T> arraySet = new ArraySet<>(values.length);
        for (T t2 : values) {
            arraySet.add(t2);
        }
        return arraySet;
    }
}
