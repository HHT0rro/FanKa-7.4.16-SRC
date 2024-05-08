package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f27047b = new Object();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    @GuardedBy("lock")
    public static g f27048c;

    /* renamed from: a, reason: collision with root package name */
    public Handler f27049a;

    public g(Looper looper) {
        this.f27049a = new com.google.android.gms.internal.mlkit_common.a(looper);
    }

    @RecentlyNonNull
    public static g a() {
        g gVar;
        synchronized (f27047b) {
            if (f27048c == null) {
                HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                handlerThread.start();
                f27048c = new g(handlerThread.getLooper());
            }
            gVar = f27048c;
        }
        return gVar;
    }

    @RecentlyNonNull
    public static Executor d() {
        return zzh.zza;
    }

    @RecentlyNonNull
    public <ResultT> p7.f<ResultT> b(@RecentlyNonNull final Callable<ResultT> callable) {
        final p7.g gVar = new p7.g();
        c(new Runnable(callable, gVar) { // from class: com.google.mlkit.common.sdkinternal.s

            /* renamed from: b, reason: collision with root package name */
            public final Callable f27068b;

            /* renamed from: c, reason: collision with root package name */
            public final p7.g f27069c;

            {
                this.f27068b = callable;
                this.f27069c = gVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Callable callable2 = this.f27068b;
                p7.g gVar2 = this.f27069c;
                try {
                    gVar2.c(callable2.call());
                } catch (MlKitException e2) {
                    gVar2.b(e2);
                } catch (Exception e10) {
                    gVar2.b(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e10));
                }
            }
        });
        return gVar.a();
    }

    public void c(@RecentlyNonNull Runnable runnable) {
        d().execute(runnable);
    }
}
