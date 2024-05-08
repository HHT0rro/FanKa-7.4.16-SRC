package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static String f4742a;

    public static boolean a(Context context, String str) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static void b(Context context, String str) {
        try {
            PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).commit();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            String a10 = com.alipay.sdk.encrypt.e.a(a(context), str2);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(a10)) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4433c, com.alipay.sdk.app.statistic.c.f4454x, String.format("%s,%s", str, str2));
            }
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, a10).commit();
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static String b(Context context, String str, String str2) {
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
            r0 = TextUtils.isEmpty(string) ? null : com.alipay.sdk.encrypt.e.b(a(context), string);
            if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(r0)) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4433c, com.alipay.sdk.app.statistic.c.f4453w, String.format("%s,%s", str, string));
            }
        } catch (Exception e2) {
            c.a(e2);
        }
        return r0;
    }

    private static String a(Context context) {
        String str;
        if (TextUtils.isEmpty(f4742a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                c.a(th);
                str = "";
            }
            f4742a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return f4742a;
    }
}
