package com.alibaba.security.common.utils.statusbar;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StatusBarUtil {
    public static boolean FlymeSetStatusBarLightMode(Activity activity, boolean z10) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i10 = declaredField.getInt(null);
            int i11 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z10 ? i11 | i10 : (~i10) & i11);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean MIUISetStatusBarLightMode(Activity activity, boolean z10) {
        try {
            Class<?> cls = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(8192);
            Class<?> cls2 = activity.getWindow().getClass();
            int i10 = cls.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls);
            Class<Integer> cls3 = Integer.TYPE;
            Method method = cls2.getMethod("setExtraFlags", cls3, cls3);
            Window window2 = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z10 ? i10 : 0);
            objArr[1] = Integer.valueOf(i10);
            method.invoke(window2, objArr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getPxFromDp(Context context, float f10) {
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static void setContentTopPadding(Activity activity, int i10) {
        ((ViewGroup) activity.getWindow().findViewById(16908290)).setPadding(0, i10, 0, 0);
    }

    public static void setNavigationBarStatusBarTranslucent(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(1792);
        activity.getWindow().setNavigationBarColor(0);
        activity.getWindow().setStatusBarColor(0);
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public static void setStatusBarColor(Activity activity, int i10) {
        StatusBarLollipopCompact.setStatusBarColor(activity, i10);
    }

    public static void setStatusBarLightMode(Activity activity, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (MIUISetStatusBarLightMode(activity, true) || FlymeSetStatusBarLightMode(activity, true)) {
            activity.getWindow().setStatusBarColor(i10);
        }
        if (i11 >= 23) {
            activity.getWindow().setBackgroundDrawableResource(17170445);
            activity.getWindow().getDecorView().setSystemUiVisibility(9216);
            activity.getWindow().setStatusBarColor(i10);
            View childAt = ((ViewGroup) activity.getWindow().findViewById(16908290)).getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
                ViewCompat.requestApplyInsets(childAt);
            }
        }
    }

    public static void translucentStatusBar(Activity activity) {
        translucentStatusBar(activity, false);
    }

    public static void translucentStatusBar(Activity activity, boolean z10) {
        StatusBarLollipopCompact.translucentStatusBar(activity, z10);
    }
}
