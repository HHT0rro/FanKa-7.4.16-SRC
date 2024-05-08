package com.huawei.flexiblelayout.common;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: ViewTagUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f27929a = 1660944384;

    /* renamed from: b, reason: collision with root package name */
    private static final int f27930b = 16777215;

    public static <T> T a(@NonNull View view, @NonNull String str, @NonNull Class<T> cls) {
        T t2 = (T) view.getTag(a(str));
        if (t2 == null || !cls.isAssignableFrom(t2.getClass())) {
            return null;
        }
        return t2;
    }

    public static void a(@NonNull View view, @NonNull String str, @Nullable Object obj) {
        view.setTag(a(str), obj);
    }

    public static int a(@NonNull String str) {
        return (str.hashCode() & 16777215) | 1660944384;
    }
}
