package com.inno.innosdk.utils.u;

import android.text.TextUtils;

/* compiled from: InnoLog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f35670a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f35671b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f35672c = "HH";

    public static void a(Object obj) {
        a(f35672c, obj);
    }

    public static void b(Object obj) {
        if (f35671b && f35670a) {
            b(f35672c, obj);
        }
    }

    public static String c(Object obj) {
        String trim;
        if (obj == null) {
            trim = "[null]";
        } else {
            trim = obj.toString().trim().length() == 0 ? "[\"\"]" : obj.toString().trim();
        }
        return String.valueOf(trim);
    }

    public static void a(Object obj, Object obj2) {
        if (f35671b && f35670a) {
            c(obj);
            c(obj2);
        }
    }

    public static void b(Object obj, Object obj2) {
        if (f35671b && f35670a) {
            c(obj);
            c(obj2);
        }
    }

    public static void a(Throwable th) {
        if (f35671b && f35670a) {
            StringBuilder sb2 = new StringBuilder();
            Exception exc = (Exception) th;
            sb2.append("Exception:");
            sb2.append((Object) exc.getClass());
            sb2.append(",");
            sb2.append("Message:");
            sb2.append(exc.getMessage());
            sb2.append(",");
            sb2.append("Trace:");
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                sb2.append(stackTraceElement.toString());
                sb2.append(",");
            }
            b(sb2.toString());
        }
    }

    public static void a(String str) {
        if (!f35671b || !f35670a || TextUtils.isEmpty(str) || str.length() <= 3072) {
            return;
        }
        while (str.length() > 3072) {
            String substring = str.substring(0, 3072);
            str = str.replace(substring, "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(">> ");
            sb2.append(substring);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(">> ");
        sb3.append(str);
    }
}
