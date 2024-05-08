package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: CoroutineExceptionHandler.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e0 {
    public static final void a(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        try {
            c0 c0Var = (c0) coroutineContext.get(c0.B0);
            if (c0Var != null) {
                c0Var.m(coroutineContext, th);
            } else {
                d0.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            d0.a(coroutineContext, b(th, th2));
        }
    }

    @NotNull
    public static final Throwable b(@NotNull Throwable th, @NotNull Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.a.a(runtimeException, th);
        return runtimeException;
    }
}
