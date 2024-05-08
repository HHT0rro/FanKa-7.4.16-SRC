package kotlin.jvm.internal;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterator.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h {
    @NotNull
    public static final <T> Iterator<T> a(@NotNull T[] array) {
        s.i(array, "array");
        return new g(array);
    }
}
