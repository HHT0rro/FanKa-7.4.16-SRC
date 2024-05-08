package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.ads.eb;
import com.huawei.hms.ads.gl;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ax {
    public static int Code(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0 && I(context) && Z(context)) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int Code(Context context, float f10) {
        if (context != null && f10 > 0.0f) {
            return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static int Code(Context context, int i10) {
        return i10 == 0 ? c.B(context) : c.Z(context);
    }

    public static String Code(String str, Context context) {
        StringBuilder sb2;
        String str2;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(eb.Code(context).C());
                } catch (ClassNotFoundException unused) {
                }
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            }
            cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (RuntimeException e2) {
            e = e2;
            sb2 = new StringBuilder();
            str2 = "getSystemProperties RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            gl.I("SysUtil", sb2.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            sb2 = new StringBuilder();
            str2 = "getSystemProperties Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            gl.I("SysUtil", sb2.toString());
            return null;
        }
    }

    private static boolean I(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int b4 = c.b(context);
            gl.Code("SysUtil", "isGesture: %s", Integer.valueOf(b4));
            if (b4 != 0) {
                return false;
            }
        } else {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z10 = identifier > 0 ? resources.getBoolean(identifier) : false;
            String Code = Code("qemu.hw.mainkeys", context);
            if ("1".equals(Code)) {
                return false;
            }
            if (!"0".equals(Code)) {
                return z10;
            }
        }
        return true;
    }

    public static int V(Context context, int i10) {
        return i10 == 0 ? c.Z(context) : c.B(context);
    }

    public static void V(Context context) {
        if (context == null) {
            return;
        }
        com.huawei.openalliance.ad.ipc.g.V(context).Code("removeExSplashBlock", null, null, null);
    }

    private static boolean Z(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i10 - displayMetrics2.heightPixels > 0 || i11 - displayMetrics2.widthPixels > 0;
    }
}
