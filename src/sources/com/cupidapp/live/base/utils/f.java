package com.cupidapp.live.base.utils;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.cupidapp.live.AppApplication;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DisplayCutoutUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static DisplayMetrics f12315b;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f12314a = new f();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12316c = true;

    public final void a() {
        f12316c = true;
    }

    @Nullable
    public final List<Rect> b(@NotNull Window window) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        kotlin.jvm.internal.s.i(window, "window");
        if (Build.VERSION.SDK_INT < 28 || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
            return null;
        }
        return displayCutout.getBoundingRects();
    }

    @NotNull
    public final DisplayMetrics c() {
        if (f12315b == null || f12316c) {
            f12316c = false;
            AppApplication.a aVar = AppApplication.f11612d;
            DisplayMetrics displayMetrics = aVar.h().getResources().getDisplayMetrics();
            f12315b = displayMetrics;
            if (displayMetrics == null) {
                DisplayMetrics displayMetrics2 = Resources.getSystem().getDisplayMetrics();
                f12315b = displayMetrics2;
                if (displayMetrics2 == null) {
                    Object systemService = aVar.h().getSystemService("window");
                    kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                    f12315b = new DisplayMetrics();
                    ((WindowManager) systemService).getDefaultDisplay().getMetrics(f12315b);
                }
            }
        }
        DisplayMetrics displayMetrics3 = f12315b;
        kotlin.jvm.internal.s.f(displayMetrics3);
        return displayMetrics3;
    }
}
