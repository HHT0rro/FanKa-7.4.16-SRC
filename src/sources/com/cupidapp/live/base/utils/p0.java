package com.cupidapp.live.base.utils;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.ColorInt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StatusBarUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class p0 {
    public static final void a(@NotNull Activity activity) {
        kotlin.jvm.internal.s.i(activity, "<this>");
        activity.getWindow().addFlags(1024);
    }

    public static final void b(@Nullable Activity activity, boolean z10, @ColorInt int i10) {
        if (activity == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                activity.getWindow().clearFlags(67108864);
                if (z10) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(1280);
                } else {
                    activity.getWindow().getDecorView().setSystemUiVisibility(9216);
                }
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().setStatusBarColor(i10);
                return;
            }
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().setStatusBarColor(-16777216);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void c(Activity activity, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        b(activity, z10, i10);
    }
}
