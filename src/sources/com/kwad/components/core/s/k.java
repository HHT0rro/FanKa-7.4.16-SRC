package com.kwad.components.core.s;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.sdk.utils.s;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method Ti;
    private static Method Tj;
    private static Field Tk;

    static {
        try {
            Ti = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            Tj = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        }
        try {
            Tk = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = ((Integer) s.c((Class<?>) View.class, "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR")).intValue();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    private static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z10) {
        try {
            int intValue = ((Integer) s.getField(layoutParams, str)).intValue();
            int intValue2 = ((Integer) s.getField(layoutParams, "meizuFlags")).intValue();
            int i10 = z10 ? intValue | intValue2 : (~intValue) & intValue2;
            if (intValue2 == i10) {
                return false;
            }
            s.a(layoutParams, "meizuFlags", Integer.valueOf(i10));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(Activity activity, boolean z10) {
        a(activity, true, true);
    }

    private static void g(View view, boolean z10) {
        int i10;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z10) {
            i10 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i10 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i10 != systemUiVisibility) {
            view.setSystemUiVisibility(i10);
        }
    }

    private static void setStatusBarColor(Window window, int i10) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = Tk;
        if (field != null) {
            try {
                if (field.getInt(attributes) != 0) {
                    Tk.set(attributes, 0);
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void a(Window window, boolean z10) {
        if (Build.VERSION.SDK_INT < 23) {
            a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z10);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            g(decorView, z10);
            setStatusBarColor(window, 0);
        }
    }

    private static void a(Activity activity, boolean z10, boolean z11) {
        Method method = Tj;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z10));
                return;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return;
            } catch (InvocationTargetException e10) {
                e10.printStackTrace();
                return;
            }
        }
        a(activity.getWindow(), z10);
    }
}
