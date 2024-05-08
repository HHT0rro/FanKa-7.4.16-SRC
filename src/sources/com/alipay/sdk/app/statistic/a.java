package com.alipay.sdk.app.statistic;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4427a = "alipay_cashier_statistic_record";

    /* renamed from: b, reason: collision with root package name */
    private static c f4428b;

    public static void a(Context context) {
        if (f4428b != null) {
            return;
        }
        f4428b = new c(context);
    }

    public static synchronized void b(Context context, String str) {
        synchronized (a.class) {
            c cVar = f4428b;
            if (cVar == null) {
                return;
            }
            a(context, cVar.a(str));
            f4428b = null;
        }
    }

    public static void a(Context context, String str) {
        new Thread(new b(context, str)).start();
    }

    public static void a(String str, Throwable th) {
        if (f4428b == null || th == null) {
            return;
        }
        f4428b.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(String str, String str2, Throwable th, String str3) {
        c cVar = f4428b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, th, str3);
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar = f4428b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, th);
    }

    public static void a(String str, String str2, String str3) {
        c cVar = f4428b;
        if (cVar == null) {
            return;
        }
        cVar.a(str, str2, str3);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            c cVar = new c(context);
            cVar.a(str, str2, str3);
            a(context, cVar.a(""));
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
