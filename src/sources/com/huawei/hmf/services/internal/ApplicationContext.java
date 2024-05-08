package com.huawei.hmf.services.internal;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ApplicationContext {
    private static volatile Context context;

    /* renamed from: com.huawei.hmf.services.internal.ApplicationContext$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class AnonymousClass1 implements Runnable {
        public final /* synthetic */ CountDownLatch val$mutex;

        public AnonymousClass1(CountDownLatch countDownLatch) {
            this.val$mutex = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context unused = ApplicationContext.context = ApplicationContext.access$100();
            this.val$mutex.countDown();
        }
    }

    public static /* synthetic */ Context access$100() {
        return obtainContext();
    }

    public static Context getContext() {
        if (context == null) {
            synchronized (ApplicationContext.class) {
                if (context == null) {
                    context = obtainContext();
                }
            }
        }
        return context;
    }

    private static Context obtainContext() {
        try {
            try {
                return ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0])).getApplicationContext();
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return ((Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null)).getApplicationContext();
        }
    }

    public static void setContext(Context context2) {
        if (context == null) {
            context = context2.getApplicationContext();
        }
    }
}
