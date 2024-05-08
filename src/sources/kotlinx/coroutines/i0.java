package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineScope.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i0 {
    @NotNull
    public static final h0 a(@NotNull CoroutineContext coroutineContext) {
        if (coroutineContext.get(n1.C0) == null) {
            coroutineContext = coroutineContext.plus(q1.b(null, 1, null));
        }
        return new kotlinx.coroutines.internal.h(coroutineContext);
    }

    @Nullable
    public static final <R> Object b(@NotNull Function2<? super h0, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        kotlinx.coroutines.internal.b0 b0Var = new kotlinx.coroutines.internal.b0(continuation.getContext(), continuation);
        Object e2 = ee.b.e(b0Var, b0Var, function2);
        if (e2 == sd.a.d()) {
            td.f.c(continuation);
        }
        return e2;
    }
}
