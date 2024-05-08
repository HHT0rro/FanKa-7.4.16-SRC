package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Arrays;

/* compiled from: SPUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class di {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f7688a;

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f7689b;

    /* renamed from: c, reason: collision with root package name */
    private String f7690c;

    public di(String str) {
        this.f7690c = ce.a(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, ci.g(a(context, ci.a(str3))));
            a(edit);
        } catch (Throwable unused) {
        }
    }

    public static byte[] b(Context context, byte[] bArr) {
        try {
            return cb.a(a(context), bArr, b(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    private static byte[] b(Context context) {
        byte[] bArr = f7689b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] copyOfRange = Arrays.copyOfRange(a(context), 0, a(context).length / 2);
        f7689b = copyOfRange;
        return copyOfRange;
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            df.c(th, "csp", "gsv");
            return str3;
        }
    }

    public static byte[] a(Context context, byte[] bArr) {
        try {
            return cb.b(a(context), bArr, b(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    private static byte[] a(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f7688a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = bw.f(context).getBytes();
        f7688a = bytes;
        return bytes;
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return ci.a(b(context, ci.d(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static SharedPreferences.Editor a(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                dc.a(th, "sp", "ge");
            }
        }
        return null;
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (Throwable th) {
            dc.a(th, "sp", "cm");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z10) {
        try {
            editor.putBoolean(str, z10);
        } catch (Throwable th) {
            df.c(th, "csp", "setPrefsStr");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i10) {
        try {
            editor.putInt(str, i10);
        } catch (Throwable th) {
            df.c(th, "csp", "putPrefsInt");
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z10) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z10);
        } catch (Throwable th) {
            df.c(th, "csp", "gbv");
            return z10;
        }
    }

    public static int a(Context context, String str, String str2, int i10) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i10);
        } catch (Throwable th) {
            df.c(th, "csp", "giv");
            return i10;
        }
    }

    public static long a(Context context, String str, String str2, long j10) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j10);
        } catch (Throwable th) {
            df.c(th, "csp", "glv");
            return j10;
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, long j10) {
        if (editor == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j10);
        } catch (Throwable th) {
            df.c(th, "csp", "plv");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                dc.a(th, "sp", "ps");
            }
        }
    }

    public static void a(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (Throwable th) {
                dc.a(th, "sp", "rk");
            }
        }
    }
}
