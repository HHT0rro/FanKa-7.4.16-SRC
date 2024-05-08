package com.cupidapp.live.base.view;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewPaddingUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class s {
    public static final void a(@NotNull View view, int i10) {
        kotlin.jvm.internal.s.i(view, "view");
        if (Build.VERSION.SDK_INT >= 23) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            kotlin.jvm.internal.s.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i10;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static final void b(@NotNull Context context, @NotNull View view) {
        kotlin.jvm.internal.s.i(context, "<this>");
        kotlin.jvm.internal.s.i(view, "view");
        if (Build.VERSION.SDK_INT >= 23) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            kotlin.jvm.internal.s.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin += z0.h.m(context);
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
