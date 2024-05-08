package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import d0.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            d0.a b4 = b(context, str, str2, str3);
            d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", b4.toString());
        }
    }

    public static synchronized void a(String str) {
        synchronized (a.class) {
            d.a(str);
        }
    }

    public static synchronized void a(Throwable th) {
        synchronized (a.class) {
            d.c(th);
        }
    }

    private static d0.a b(Context context, String str, String str2, String str3) {
        String str4;
        try {
            str4 = context.getPackageName();
        } catch (Throwable unused) {
            str4 = "";
        }
        return new d0.a(Build.MODEL, str4, "APPSecuritySDK-ALIPAY", "3.2.2-20180331", str, str2, str3);
    }
}
