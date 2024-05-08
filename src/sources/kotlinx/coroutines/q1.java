package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q1 {
    @NotNull
    public static final v a(@Nullable n1 n1Var) {
        return s1.a(n1Var);
    }

    public static /* synthetic */ v b(n1 n1Var, int i10, Object obj) {
        return s1.b(n1Var, i10, obj);
    }

    public static final void c(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        s1.c(coroutineContext, cancellationException);
    }

    public static final void e(@NotNull l<?> lVar, @NotNull Future<?> future) {
        r1.a(lVar, future);
    }

    @NotNull
    public static final t0 f(@NotNull n1 n1Var, @NotNull t0 t0Var) {
        return s1.e(n1Var, t0Var);
    }

    public static final void g(@NotNull CoroutineContext coroutineContext) {
        s1.f(coroutineContext);
    }

    public static final void h(@NotNull n1 n1Var) {
        s1.g(n1Var);
    }

    @NotNull
    public static final n1 i(@NotNull CoroutineContext coroutineContext) {
        return s1.h(coroutineContext);
    }
}
