package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;

/* compiled from: Log.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f23009a = true;

    public static String a(String str, @Nullable Throwable th) {
        String e2 = e(th);
        if (TextUtils.isEmpty(e2)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace = e2.replace("\n", "\n  ");
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + String.valueOf(replace).length());
        sb2.append(valueOf);
        sb2.append("\n  ");
        sb2.append(replace);
        sb2.append('\n');
        return sb2.toString();
    }

    public static void b(String str, String str2) {
    }

    public static void c(String str, String str2) {
    }

    public static void d(String str, String str2, @Nullable Throwable th) {
        c(str, a(str2, th));
    }

    @Nullable
    public static String e(@Nullable Throwable th) {
        if (th == null) {
            return null;
        }
        if (g(th)) {
            return "UnknownHostException (no network)";
        }
        if (!f23009a) {
            return th.getMessage();
        }
        return Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    public static void f(String str, String str2) {
    }

    public static boolean g(@Nullable Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void h(String str, String str2) {
    }

    public static void i(String str, String str2, @Nullable Throwable th) {
        h(str, a(str2, th));
    }
}
