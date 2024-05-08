package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("lock")
    public boolean f27060b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f27059a = new Object();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("lock")
    public final Queue<c0> f27061c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference<Thread> f27062d = new AtomicReference<>();

    public void a(@RecentlyNonNull Executor executor, @RecentlyNonNull Runnable runnable) {
        synchronized (this.f27059a) {
            if (this.f27060b) {
                this.f27061c.add(new c0(executor, runnable, null));
            } else {
                this.f27060b = true;
                d(executor, runnable);
            }
        }
    }

    public final void d(Executor executor, final Runnable runnable) {
        try {
            executor.execute(new Runnable(this, runnable) { // from class: com.google.mlkit.common.sdkinternal.a0

                /* renamed from: b, reason: collision with root package name */
                public final n f27038b;

                /* renamed from: c, reason: collision with root package name */
                public final Runnable f27039c;

                {
                    this.f27038b = this;
                    this.f27039c = runnable;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    n nVar = this.f27038b;
                    Runnable runnable2 = this.f27039c;
                    d0 d0Var = new d0(nVar, null);
                    try {
                        runnable2.run();
                        d0Var.close();
                    } catch (Throwable th) {
                        try {
                            d0Var.close();
                        } catch (Throwable th2) {
                            com.google.android.gms.internal.mlkit_common.u.a(th, th2);
                        }
                        throw th;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            e();
        }
    }

    public final void e() {
        synchronized (this.f27059a) {
            if (this.f27061c.isEmpty()) {
                this.f27060b = false;
            } else {
                c0 remove = this.f27061c.remove();
                d(remove.f27042a, remove.f27043b);
            }
        }
    }
}
