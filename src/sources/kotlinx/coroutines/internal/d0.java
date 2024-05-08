package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlinx.coroutines.internal.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentLinkedList.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d0<S extends c0<S>> {
    @NotNull
    public static <S extends c0<S>> Object a(@Nullable Object obj) {
        return obj;
    }

    @NotNull
    public static final S b(Object obj) {
        f0 f0Var;
        f0Var = f.f51381a;
        if (obj == f0Var) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    public static final boolean c(Object obj) {
        f0 f0Var;
        f0Var = f.f51381a;
        return obj == f0Var;
    }
}
