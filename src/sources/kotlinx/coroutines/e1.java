package kotlinx.coroutines;

import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Executors.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e1 {
    @NotNull
    public static final CoroutineDispatcher a(@NotNull Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        q0 q0Var = executor instanceof q0 ? (q0) executor : null;
        return (q0Var == null || (coroutineDispatcher = q0Var.f51458b) == null) ? new d1(executor) : coroutineDispatcher;
    }
}
