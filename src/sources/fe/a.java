package fe;

import ce.n;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.i0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Dispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a extends ExecutorCoroutineDispatcher implements Executor {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f49324c = new a();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final CoroutineDispatcher f49325d;

    static {
        int d10;
        l lVar = l.f49344b;
        d10 = i0.d("kotlinx.coroutines.io.parallelism", n.b(64, g0.a()), 0, 0, 12, null);
        f49325d = lVar.limitedParallelism(d10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        f49325d.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        f49325d.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int i10) {
        return l.f49344b.limitedParallelism(i10);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "Dispatchers.IO";
    }
}
