package com.cupidapp.live.base.utils;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: OSUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i0 f12331a = new i0();

    public final String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
            kotlin.jvm.internal.s.g(invoke, "null cannot be cast to non-null type kotlin.String");
            return (String) invoke;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public final boolean b() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public final boolean c() {
        String MANUFACTURER = Build.MANUFACTURER;
        kotlin.jvm.internal.s.h(MANUFACTURER, "MANUFACTURER");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.s.h(locale, "getDefault()");
        String lowerCase = MANUFACTURER.toLowerCase(locale);
        kotlin.jvm.internal.s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return StringsKt__StringsKt.K(lowerCase, "huawei", false, 2, null);
    }

    public final boolean d() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public final boolean e() {
        String MANUFACTURER = Build.MANUFACTURER;
        kotlin.jvm.internal.s.h(MANUFACTURER, "MANUFACTURER");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.s.h(locale, "getDefault()");
        String lowerCase = MANUFACTURER.toLowerCase(locale);
        kotlin.jvm.internal.s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return StringsKt__StringsKt.K(lowerCase, "samsung", false, 2, null);
    }
}
