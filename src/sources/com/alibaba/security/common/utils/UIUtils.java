package com.alibaba.security.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UIUtils {
    private static final String TAG = "Utils";

    public static void chmod(String str, String str2) {
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2);
        } catch (IOException unused) {
        }
    }

    public static int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static String getMobileName() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String getOsVersion() {
        return getOsVersionInt() + "";
    }

    public static int getOsVersionInt() {
        return Build.VERSION.SDK_INT;
    }

    public static String getPhoneType() {
        return Build.MODEL;
    }

    public static float getScaledDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static float getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int getTitleBarHeight(Activity activity) {
        return activity.getWindow().findViewById(16908290).getTop() - getStatusBarHeight(activity);
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static <T extends View> T getView(Activity activity, int i10) {
        return (T) activity.findViewById(i10);
    }

    public static boolean hasSDCard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void hideInputMethod(Activity activity) {
        hideInputMethod(activity, activity.getCurrentFocus());
    }

    public static int px2dip(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void setForceDarkAllowed(View view, boolean z10) {
        if (view != null && Build.VERSION.SDK_INT > 28) {
            try {
                view.getClass().getMethod("setForceDarkAllowed", Boolean.TYPE).invoke(view, Boolean.valueOf(z10));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    public static void showInputMethod(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.showSoftInput(view, 0);
    }

    public static int sp2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static <T extends View> T getView(View view, int i10) {
        return (T) view.findViewById(i10);
    }

    public static void hideInputMethod(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
