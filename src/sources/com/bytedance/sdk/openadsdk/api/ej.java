package com.bytedance.sdk.openadsdk.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej {
    private static int dk = 4;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f11075m;

    public static void dk(String str, String str2) {
    }

    public static void dk(String str, String str2, Throwable th) {
    }

    public static void ej(String str, String str2) {
    }

    public static void ej(String str, String str2, Throwable th) {
    }

    public static void l(String str, String str2) {
    }

    public static void m(int i10) {
        dk = i10;
    }

    public static void m(String str, String str2) {
    }

    public static void m(String str, String str2, Throwable th) {
    }

    public static void np(String str, String str2) {
    }

    public static void m() {
        f11075m = true;
        m(3);
    }

    public static void m(String str) {
        if (f11075m) {
            l("TTLogger", str);
        }
    }

    public static void m(String str, Object... objArr) {
        if (f11075m && objArr != null && dk <= 5) {
            m(objArr);
        }
    }

    private static String m(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb2.append(obj.toString());
            } else {
                sb2.append(" null ");
            }
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
