package com.jd.ad.sdk.fdt.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_do.jad_bo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ScreenUtils {
    private ScreenUtils() {
    }

    public static float dip2px(Context context, float f10) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        return context == null ? f10 : (f10 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int getDensityDpi(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).densityDpi;
    }

    public static int getDimSize() {
        return Resources.getSystem().getConfiguration().screenLayout & 15;
    }

    public static int getDirection(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getConfiguration().orientation;
    }

    public static DisplayMetrics getDisplay(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static int getPhoneHeight(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).heightPixels;
    }

    public static int getPhoneWidth(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).widthPixels;
    }

    public static int getScreenDensity() {
        int i10 = Resources.getSystem().getDisplayMetrics().densityDpi;
        if (i10 == 0) {
            return 1;
        }
        if (i10 < 140) {
            return 0;
        }
        return i10 > 200 ? 2 : 1;
    }

    public static int getScreenDpi(@NonNull Context context) {
        WindowManager windowManager;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (SecurityException e2) {
            e2.printStackTrace();
            windowManager = null;
        }
        if (windowManager == null) {
            return 1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static int getScreenSize() {
        int i10 = Resources.getSystem().getConfiguration().screenLayout & 15;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    i11 = 4;
                    if (i10 != 4) {
                        return 0;
                    }
                }
            }
        }
        return i11;
    }

    public static int[] getScreenSize(@NonNull Context context) {
        WindowManager windowManager;
        int[] iArr = new int[2];
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (SecurityException e2) {
            e2.printStackTrace();
            windowManager = null;
        }
        if (windowManager == null) {
            return iArr;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        iArr[0] = i10;
        iArr[1] = i11;
        return iArr;
    }

    public static float getShowHeight(Context context, float f10, float f11) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return f11;
        }
        float dip2px = dip2px(context, f10);
        float dip2px2 = dip2px(context, f11);
        float phoneWidth = getPhoneWidth(context);
        return dip2px > phoneWidth ? (dip2px2 * phoneWidth) / phoneWidth : dip2px2;
    }

    public static int getXdpi(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) getDisplay(context).xdpi;
    }

    public static int getYdpi(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) getDisplay(context).ydpi;
    }

    public static int px2dip(Context context, float f10) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
