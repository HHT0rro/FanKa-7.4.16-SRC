package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {
    public static void a(@RecentlyNonNull boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(@RecentlyNonNull boolean z10, @RecentlyNonNull Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c(@RecentlyNonNull boolean z10, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void d(@RecentlyNonNull Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + 36 + String.valueOf(name).length());
            sb2.append("Must be called on ");
            sb2.append(name2);
            sb2.append(" thread, but got ");
            sb2.append(name);
            sb2.append(".");
            throw new IllegalStateException(sb2.toString());
        }
    }

    @RecentlyNonNull
    public static String e(@RecentlyNonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    @RecentlyNonNull
    public static String f(@RecentlyNonNull String str, @RecentlyNonNull Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void g(@RecentlyNonNull String str) {
        if (b7.m.a()) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T> T h(@Nullable T t2) {
        Objects.requireNonNull(t2, "null reference");
        return t2;
    }

    @NonNull
    public static <T> T i(@RecentlyNonNull T t2, @RecentlyNonNull Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void j(@RecentlyNonNull boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void k(@RecentlyNonNull boolean z10, @RecentlyNonNull Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void l(@RecentlyNonNull boolean z10, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z10) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
