package com.huawei.hwwidgetsupport;

import androidx.annotation.NonNull;

/* compiled from: ClassNameHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f31999a = "com.huawei.uikit.hwviewpager.widget.HwViewPager";

    /* renamed from: b, reason: collision with root package name */
    private static final String f32000b = "com.huawei.uikit.";

    /* renamed from: c, reason: collision with root package name */
    private static final String f32001c = "com.huawei.uikit.phone.";

    /* renamed from: d, reason: collision with root package name */
    private static final String f32002d = "com.huawei.uikit.tv.";

    /* renamed from: e, reason: collision with root package name */
    private static final String f32003e = "com.huawei.uikit.watch.";

    /* renamed from: f, reason: collision with root package name */
    private static final String f32004f = "com.huawei.uikit.car.";

    @NonNull
    public static String a(@NonNull String str) {
        return str.replace(f32000b, f32004f);
    }

    @NonNull
    public static String b(@NonNull String str) {
        return str.replace(f32000b, f32001c);
    }

    @NonNull
    public static String c(@NonNull String str) {
        return str.replace(f32000b, f32002d);
    }

    @NonNull
    public static String d(@NonNull String str) {
        return str.replace(f32000b, f32003e);
    }

    public static boolean e(@NonNull String str) {
        return (g(str) || h(str) || i(str) || f(str)) ? false : true;
    }

    public static boolean f(@NonNull String str) {
        return str.startsWith(f32004f);
    }

    public static boolean g(@NonNull String str) {
        return str.startsWith(f32001c);
    }

    public static boolean h(@NonNull String str) {
        return str.startsWith(f32002d);
    }

    public static boolean i(@NonNull String str) {
        return str.startsWith(f32003e);
    }
}
