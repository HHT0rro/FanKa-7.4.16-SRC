package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import c0.e;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String a10;
        if (context == null || z.a.d(str)) {
            return null;
        }
        if (!z.a.d(str2)) {
            try {
                a10 = e.a(context, str, str2, "");
                if (z.a.d(a10)) {
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return a0.c.f(a0.c.a(), a10);
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (z.a.d(str) || z.a.d(str2)) {
                return null;
            }
            try {
                String a10 = c0.b.a(str);
                if (z.a.d(a10)) {
                    return null;
                }
                String string = new JSONObject(a10).getString(str2);
                if (z.a.d(string)) {
                    return null;
                }
                return a0.c.f(a0.c.a(), string);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!z.a.d(str) && !z.a.d(str2) && context != null) {
            try {
                String b4 = a0.c.b(a0.c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, b4);
                e.b(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (z.a.d(str) || z.a.d(str2)) {
                return;
            }
            try {
                String a10 = c0.b.a(str);
                JSONObject jSONObject = new JSONObject();
                if (z.a.g(a10)) {
                    try {
                        jSONObject = new JSONObject(a10);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                }
                jSONObject.put(str2, a0.c.b(a0.c.a(), str3));
                jSONObject.toString();
                try {
                    System.clearProperty(str);
                } catch (Throwable unused2) {
                }
                if (c0.c.b()) {
                    String str4 = ".SystemConfig" + File.separator + str;
                    if (c0.c.b()) {
                        File file = new File(Environment.getExternalStorageDirectory(), str4);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
