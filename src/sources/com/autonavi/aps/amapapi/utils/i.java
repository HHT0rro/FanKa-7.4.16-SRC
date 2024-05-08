package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SPUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {
    public static SharedPreferences.Editor a(Context context, String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }

    public static void a(SharedPreferences.Editor editor, String str) {
        try {
            editor.remove(str);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, long j10) {
        try {
            editor.putLong(str, j10);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsLong");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z10) {
        try {
            editor.putBoolean(str, z10);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "updatePrefsBoolean");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        try {
            editor.putString(str, str2);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsStr");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i10) {
        try {
            editor.putInt(str, i10);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "setPrefsInt");
        }
    }

    public static long a(Context context, String str, String str2, long j10) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j10);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsLong");
            return j10;
        }
    }

    public static int a(Context context, String str, String str2, int i10) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i10);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsInt");
            return i10;
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z10) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z10);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsBoolean");
            return z10;
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            b.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static String a(Context context) {
        return context == null ? "00:00:00:00:00:00" : a(context, "pref", "smac", "00:00:00:00:00:00");
    }
}
