package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Delay.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface m0 {

    /* compiled from: Delay.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        @NotNull
        public static t0 a(@NotNull m0 m0Var, long j10, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
            return l0.a().l(j10, runnable, coroutineContext);
        }
    }

    void k(long j10, @NotNull l<? super kotlin.p> lVar);

    @NotNull
    t0 l(long j10, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext);
}
