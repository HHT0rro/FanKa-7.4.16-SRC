package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DefaultExecutor.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k0 extends y0 implements Runnable {

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final k0 f51428g;

    /* renamed from: h, reason: collision with root package name */
    public static final long f51429h;

    static {
        Long l10;
        k0 k0Var = new k0();
        f51428g = k0Var;
        x0.E(k0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f51429h = timeUnit.toNanos(l10.longValue());
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public Thread J() {
        Thread thread = _thread;
        return thread == null ? b0() : thread;
    }

    @Override // kotlinx.coroutines.z0
    public void K(long j10, @NotNull y0.c cVar) {
        f0();
    }

    @Override // kotlinx.coroutines.y0
    public void P(@NotNull Runnable runnable) {
        if (c0()) {
            f0();
        }
        super.P(runnable);
    }

    public final synchronized void a0() {
        if (d0()) {
            debugStatus = 3;
            U();
            notifyAll();
        }
    }

    public final synchronized Thread b0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean c0() {
        return debugStatus == 4;
    }

    public final boolean d0() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    public final synchronized boolean e0() {
        if (d0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final void f0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.y0, kotlinx.coroutines.m0
    @NotNull
    public t0 l(long j10, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return X(j10, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean R;
        j2.f51426a.c(this);
        c.a();
        try {
            if (!e0()) {
                if (R) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long S = S();
                if (S == Long.MAX_VALUE) {
                    c.a();
                    long nanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f51429h + nanoTime;
                    }
                    long j11 = j10 - nanoTime;
                    if (j11 <= 0) {
                        _thread = null;
                        a0();
                        c.a();
                        if (R()) {
                            return;
                        }
                        J();
                        return;
                    }
                    S = ce.n.e(S, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (S > 0) {
                    if (d0()) {
                        _thread = null;
                        a0();
                        c.a();
                        if (R()) {
                            return;
                        }
                        J();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, S);
                }
            }
        } finally {
            _thread = null;
            a0();
            c.a();
            if (!R()) {
                J();
            }
        }
    }

    @Override // kotlinx.coroutines.y0, kotlinx.coroutines.x0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
