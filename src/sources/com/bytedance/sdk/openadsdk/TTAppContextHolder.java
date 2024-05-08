package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.ej;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TTAppContextHolder {

    /* renamed from: m, reason: collision with root package name */
    private static volatile Context f11070m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static volatile Application f11071m;

        static {
            try {
                Object dk = dk();
                f11071m = (Application) dk.getClass().getMethod("getApplication", new Class[0]).invoke(dk, new Object[0]);
                ej.l("MyApplication", "application get success");
            } catch (Throwable th) {
                ej.ej("MyApplication", "application get failed", th);
            }
        }

        private static Object dk() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                ej.ej("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application m() {
            return f11071m;
        }
    }

    public static Context getContext() {
        if (f11070m == null) {
            setContext(null);
        }
        return f11070m;
    }

    public static synchronized void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            if (f11070m == null) {
                if (context != null) {
                    f11070m = context.getApplicationContext();
                } else if (m.m() != null) {
                    try {
                        f11070m = m.m();
                        if (f11070m != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
