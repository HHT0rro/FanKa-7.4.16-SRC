package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Executors.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d1 extends ExecutorCoroutineDispatcher implements m0 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Executor f51182c;

    public d1(@NotNull Executor executor) {
        this.f51182c = executor;
        kotlinx.coroutines.internal.e.a(A());
    }

    @NotNull
    public Executor A() {
        return this.f51182c;
    }

    public final ScheduledFuture<?> B(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            x(coroutineContext, e2);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor A = A();
        ExecutorService executorService = A instanceof ExecutorService ? (ExecutorService) A : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            Executor A = A();
            c.a();
            A.execute(runnable);
        } catch (RejectedExecutionException e2) {
            c.a();
            x(coroutineContext, e2);
            r0.b().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof d1) && ((d1) obj).A() == A();
    }

    public int hashCode() {
        return System.identityHashCode(A());
    }

    @Override // kotlinx.coroutines.m0
    public void k(long j10, @NotNull l<? super kotlin.p> lVar) {
        Executor A = A();
        ScheduledExecutorService scheduledExecutorService = A instanceof ScheduledExecutorService ? (ScheduledExecutorService) A : null;
        ScheduledFuture<?> B = scheduledExecutorService != null ? B(scheduledExecutorService, new e2(this, lVar), lVar.getContext(), j10) : null;
        if (B != null) {
            q1.e(lVar, B);
        } else {
            k0.f51428g.k(j10, lVar);
        }
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public t0 l(long j10, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        Executor A = A();
        ScheduledExecutorService scheduledExecutorService = A instanceof ScheduledExecutorService ? (ScheduledExecutorService) A : null;
        ScheduledFuture<?> B = scheduledExecutorService != null ? B(scheduledExecutorService, runnable, coroutineContext, j10) : null;
        if (B != null) {
            return new s0(B);
        }
        return k0.f51428g.l(j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return A().toString();
    }

    public final void x(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        q1.c(coroutineContext, c1.a("The task was rejected", rejectedExecutionException));
    }
}
