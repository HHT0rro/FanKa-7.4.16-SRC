package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.hailiang.advlib.core.ADEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DeviceUtils implements NotConfused {
    public static final String TAG = "DeviceUtils";

    public static Point getAppWindowSize(@NonNull Context context) {
        Point point = new Point();
        new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        } catch (Exception e2) {
            LogUtils.d(TAG, "getAppWindowSize size failed.", e2);
        }
        LogUtils.d(TAG, "getAppWindowSize: appWindowSize = " + ((Object) point));
        return point;
    }

    public static int getNavigationBarHeight(@NonNull Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static int getRealHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int getRealWidth(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int getStatusBarHeight(@NonNull Context context) {
        if (context == null) {
            return 50;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static boolean isHuaweiDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && (lowerCase.contains("huawei") || lowerCase.contains("honor"));
    }

    public static boolean isNavigationBarShow(@NonNull Context context) {
        if (isXiaomiDevice()) {
            return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0;
        }
        if (isHuaweiDevice()) {
            return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0;
        }
        if (isVivoDevice()) {
            return Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        LogUtils.d(TAG, "isNavigationBarShow: sY = " + point.y + ", rY = " + point2.y);
        int i10 = point2.y;
        int i11 = point.y;
        return i10 != i11 && Math.abs(i10 - i11) >= getNavigationBarHeight(context);
    }

    public static boolean isOppoDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && lowerCase.contains("oppo");
    }

    public static boolean isSamsungDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && lowerCase.contains("samsung");
    }

    public static boolean isVivoDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && lowerCase.contains(ADEvent.VIVO);
    }

    public static boolean isXiaomiDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        return !TextUtils.isEmpty(lowerCase) && lowerCase.contains(ADEvent.XIAOMI);
    }
}
