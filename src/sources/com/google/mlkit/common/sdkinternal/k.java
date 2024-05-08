package com.google.mlkit.common.sdkinternal;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class k {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f27055b = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    @RecentlyNonNull
    public final n f27054a = new n();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f27056c = new AtomicBoolean(false);

    @RecentlyNonNull
    public <T> p7.f<T> a(@RecentlyNonNull final Executor executor, @RecentlyNonNull final Callable<T> callable, @RecentlyNonNull final p7.a aVar) {
        com.google.android.gms.common.internal.h.j(this.f27055b.get() > 0);
        if (aVar.a()) {
            return p7.i.a();
        }
        final p7.b bVar = new p7.b();
        final p7.g gVar = new p7.g(bVar.b());
        this.f27054a.a(new Executor(executor, aVar, bVar, gVar) { // from class: com.google.mlkit.common.sdkinternal.x

            /* renamed from: b, reason: collision with root package name */
            public final Executor f27074b;

            /* renamed from: c, reason: collision with root package name */
            public final p7.a f27075c;

            /* renamed from: d, reason: collision with root package name */
            public final p7.b f27076d;

            /* renamed from: e, reason: collision with root package name */
            public final p7.g f27077e;

            {
                this.f27074b = executor;
                this.f27075c = aVar;
                this.f27076d = bVar;
                this.f27077e = gVar;
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                Executor executor2 = this.f27074b;
                p7.a aVar2 = this.f27075c;
                p7.b bVar2 = this.f27076d;
                p7.g gVar2 = this.f27077e;
                try {
                    executor2.execute(runnable);
                } catch (RuntimeException e2) {
                    if (aVar2.a()) {
                        bVar2.a();
                    } else {
                        gVar2.b(e2);
                    }
                    throw e2;
                }
            }
        }, new Runnable(this, aVar, bVar, callable, gVar) { // from class: com.google.mlkit.common.sdkinternal.y

            /* renamed from: b, reason: collision with root package name */
            public final k f27078b;

            /* renamed from: c, reason: collision with root package name */
            public final p7.a f27079c;

            /* renamed from: d, reason: collision with root package name */
            public final p7.b f27080d;

            /* renamed from: e, reason: collision with root package name */
            public final Callable f27081e;

            /* renamed from: f, reason: collision with root package name */
            public final p7.g f27082f;

            {
                this.f27078b = this;
                this.f27079c = aVar;
                this.f27080d = bVar;
                this.f27081e = callable;
                this.f27082f = gVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f27078b.f(this.f27079c, this.f27080d, this.f27081e, this.f27082f);
            }
        });
        return gVar.a();
    }

    @VisibleForTesting
    @WorkerThread
    public abstract void b() throws MlKitException;

    public void c() {
        this.f27055b.incrementAndGet();
    }

    @WorkerThread
    public abstract void d();

    public void e(@RecentlyNonNull Executor executor) {
        com.google.android.gms.common.internal.h.j(this.f27055b.get() > 0);
        this.f27054a.a(executor, new Runnable(this) { // from class: com.google.mlkit.common.sdkinternal.w

            /* renamed from: b, reason: collision with root package name */
            public final k f27073b;

            {
                this.f27073b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f27073b.g();
            }
        });
    }

    public final /* synthetic */ void f(p7.a aVar, p7.b bVar, Callable callable, p7.g gVar) {
        try {
            if (aVar.a()) {
                bVar.a();
                return;
            }
            try {
                if (!this.f27056c.get()) {
                    b();
                    this.f27056c.set(true);
                }
                if (aVar.a()) {
                    bVar.a();
                    return;
                }
                Object call = callable.call();
                if (aVar.a()) {
                    bVar.a();
                } else {
                    gVar.c(call);
                }
            } catch (RuntimeException e2) {
                throw new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e2);
            }
        } catch (Exception e10) {
            if (aVar.a()) {
                bVar.a();
            } else {
                gVar.b(e10);
            }
        }
    }

    public final /* synthetic */ void g() {
        int decrementAndGet = this.f27055b.decrementAndGet();
        com.google.android.gms.common.internal.h.j(decrementAndGet >= 0);
        if (decrementAndGet == 0) {
            d();
            this.f27056c.set(false);
        }
    }
}
