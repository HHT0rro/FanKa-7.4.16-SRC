package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Executors.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q0 implements Executor {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final CoroutineDispatcher f51458b;

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        this.f51458b.dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @NotNull
    public String toString() {
        return this.f51458b.toString();
    }
}
