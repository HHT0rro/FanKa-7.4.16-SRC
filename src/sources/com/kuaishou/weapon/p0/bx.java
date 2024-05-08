package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class bx {

    /* renamed from: a, reason: collision with root package name */
    private static String f35887a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);

    /* renamed from: b, reason: collision with root package name */
    private static String f35888b = c.b(f35888b, 2);

    /* renamed from: b, reason: collision with root package name */
    private static String f35888b = c.b(f35888b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String c4 = c(context);
        if (TextUtils.isEmpty(c4)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        b(context, c4);
        return str2;
    }

    public static String b(Context context) {
        String c4 = c(context);
        String d10 = d(context);
        if (!TextUtils.isEmpty(c4) && TextUtils.equals(c4, d10)) {
            return c4;
        }
        if (!TextUtils.isEmpty(c4)) {
            b(context, c4);
            return c4;
        }
        if (TextUtils.isEmpty(d10)) {
            return "";
        }
        a(context, d10);
        return d10;
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f35887a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return df.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext())) {
                Settings.System.putString(context.getContentResolver(), f35887a, str);
            }
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        df.a(context).d(str);
    }
}
