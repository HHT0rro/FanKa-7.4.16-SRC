package com.bytedance.pangle.util;

import android.os.Build;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {
    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return false;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT <= 23;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT < 23;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT <= 25;
    }

    public static boolean f() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 26 && i10 <= 28;
    }

    public static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 29 && i10 <= 30;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean j() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 28) {
            return i10 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 31) {
            return i10 == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
