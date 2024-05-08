package com.huawei.hms.ads;

import android.os.Build;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class gl {
    private static gm Code = new gm();

    private static boolean B() {
        return Code.Code(6);
    }

    public static void Code(int i10, String str, String str2) {
        Code.Code(i10, str, str2);
        Code.Code(str2, "\n============================================================================\n====== " + V() + "\n====== Brand: " + Build.BRAND + " Model: " + Build.MODEL + " Release: " + Build.VERSION.RELEASE + " API: " + Build.VERSION.SDK_INT + "\n============================================================================");
    }

    public static void Code(int i10, String str, String str2, Throwable th) {
        Code.Code(i10, str, str2, th);
    }

    public static void Code(int i10, Throwable th) {
        Code.Code(i10, "", th);
    }

    public static void Code(String str, String str2) {
        Code.V(3, str, str2);
    }

    public static void Code(String str, String str2, Object... objArr) {
        if (!Code() || str2 == null) {
            return;
        }
        Code(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static boolean Code() {
        return Code.Code(3);
    }

    public static void I(String str, String str2) {
        Code.V(5, str, str2);
    }

    public static void I(String str, String str2, Object... objArr) {
        if (!Z() || str2 == null) {
            return;
        }
        I(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    private static boolean I() {
        return Code.Code(4);
    }

    private static String V() {
        return "HiAd-13.4.62.302";
    }

    public static void V(String str, String str2) {
        Code.V(4, str, str2);
    }

    public static void V(String str, String str2, Object... objArr) {
        if (!I() || str2 == null) {
            return;
        }
        V(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    public static void Z(String str, String str2) {
        Code.V(6, str, str2);
    }

    public static void Z(String str, String str2, Object... objArr) {
        if (!B() || str2 == null) {
            return;
        }
        Z(str, String.format(Locale.ENGLISH, str2, objArr));
    }

    private static boolean Z() {
        return Code.Code(5);
    }
}
