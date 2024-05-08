package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ap {
    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.e.c.printStackTrace(runtimeException);
    }

    public static String ax(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void checkArgument(boolean z10, @Nullable Object obj) {
        if (z10) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static <T> T checkNotNull(T t2) {
        return (T) g(t2, "");
    }

    public static void f(Object... objArr) {
        for (int i10 = 0; i10 < 2; i10++) {
            checkNotNull(objArr[i10]);
        }
    }

    public static <T> T g(T t2, @Nullable String str) {
        if (t2 == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t2;
    }

    public static String gH(String str) {
        return ax(str, "");
    }
}
