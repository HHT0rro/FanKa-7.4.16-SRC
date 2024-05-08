package com.alibaba.security.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DisplayUtils {
    private static final String TAG = "DisplayUtils";

    public static int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getDisplayCircleRadius(Context context) {
        return (Math.min(getHeight(context), getWidth(context)) / 2) - dip2px(context, 50.0f);
    }

    public static int getHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static boolean isInHuaweiMagicWindow(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return false;
        }
        String configuration2 = configuration.toString();
        return configuration2.contains("hwMultiwindow-magic") || configuration2.contains("hw-magic-windows");
    }

    public static void setScreenBrightness(Activity activity, int i10) {
        if (i10 >= 0 && i10 <= 255) {
            try {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.screenBrightness = i10 / 255.0f;
                activity.getWindow().setAttributes(attributes);
            } catch (Throwable unused) {
            }
        }
    }
}
