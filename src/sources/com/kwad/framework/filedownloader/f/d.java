package com.kwad.framework.filedownloader.f;

import android.util.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public static boolean ail;

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        a(6, obj, th, str, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        a(4, obj, str, objArr);
    }

    public static void c(Object obj, String str, Object... objArr) {
        a(3, obj, str, objArr);
    }

    public static void d(Object obj, String str, Object... objArr) {
        a(5, obj, str, objArr);
    }

    public static void e(Object obj, String str, Object... objArr) {
        a(2, obj, str, objArr);
    }

    private static String f(Object obj) {
        StringBuilder sb2 = new StringBuilder("FileDownloader.");
        sb2.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb2.toString();
    }

    public static void a(Object obj, String str, Object... objArr) {
        a(6, obj, str, objArr);
    }

    private static void a(int i10, Object obj, String str, Object... objArr) {
        a(i10, obj, null, str, objArr);
    }

    private static void a(int i10, Object obj, Throwable th, String str, Object... objArr) {
        if ((i10 >= 5) || ail) {
            Log.println(i10, f(obj), f.b(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }
}
