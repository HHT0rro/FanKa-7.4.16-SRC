package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Arrays;

/* compiled from: SPUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hl {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f6256a;

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f6257b;

    /* renamed from: c, reason: collision with root package name */
    private String f6258c;

    public hl(String str) {
        this.f6258c = fq.b(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, fv.g(a(context, fv.a(str3))));
            a(edit);
        } catch (Throwable unused) {
        }
    }

    public static byte[] b(Context context, byte[] bArr) {
        try {
            return fn.a(a(context), bArr, b(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    private static byte[] b(Context context) {
        byte[] bArr = f6257b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] copyOfRange = Arrays.copyOfRange(a(context), 0, a(context).length / 2);
        f6257b = copyOfRange;
        return copyOfRange;
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            gy.b(th, "csp", "gsv");
            return str3;
        }
    }

    public static byte[] a(Context context, byte[] bArr) {
        try {
            return fn.b(a(context), bArr, b(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    private static byte[] a(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f6256a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = fj.f(context).getBytes();
        f6256a = bytes;
        return bytes;
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return fv.a(b(context, fv.d(context.getSharedPreferences(str, 0).getString(str2, ""))));
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
                gv.a(th, "sp", "ge");
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
            gv.a(th, "sp", "cm");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z10) {
        try {
            editor.putBoolean(str, z10);
        } catch (Throwable th) {
            gy.b(th, "csp", "setPrefsStr");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i10) {
        try {
            editor.putInt(str, i10);
        } catch (Throwable th) {
            gy.b(th, "csp", "putPrefsInt");
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z10) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z10);
        } catch (Throwable th) {
            gy.b(th, "csp", "gbv");
            return z10;
        }
    }

    public static int a(Context context, String str, String str2, int i10) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i10);
        } catch (Throwable th) {
            gy.b(th, "csp", "giv");
            return i10;
        }
    }

    public static long a(Context context, String str, String str2, long j10) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j10);
        } catch (Throwable th) {
            gy.b(th, "csp", "glv");
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
            gy.b(th, "csp", "plv");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                gv.a(th, "sp", "ps");
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
                gv.a(th, "sp", "rk");
            }
        }
    }
}
