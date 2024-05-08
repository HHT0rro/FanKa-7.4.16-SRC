package com.mobile.auth.n;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f37524a = new ThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Thread.UncaughtExceptionHandler f37525a;

        public a() {
            this.f37525a = new Thread.UncaughtExceptionHandler() { // from class: com.mobile.auth.n.n.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    th.printStackTrace();
                }
            };
        }

        public a(final Context context, final com.cmic.sso.sdk.a aVar) {
            this.f37525a = new Thread.UncaughtExceptionHandler() { // from class: com.mobile.auth.n.n.a.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    aVar.a().f11427a.add(th);
                    com.mobile.auth.g.e.b(context).a("200025", "发生未知错误", aVar, null);
                }
            };
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(this.f37525a);
            a();
            Thread.currentThread().setUncaughtExceptionHandler(null);
        }
    }

    public static void a(a aVar) {
        try {
            f37524a.execute(aVar);
        } catch (Exception e2) {
            aVar.f37525a.uncaughtException(Thread.currentThread(), e2);
        }
    }
}
