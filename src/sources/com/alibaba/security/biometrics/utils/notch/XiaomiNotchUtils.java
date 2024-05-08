package com.alibaba.security.biometrics.utils.notch;

import android.content.Context;
import android.view.Window;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class XiaomiNotchUtils {
    public static final int FLAG_NOTCH_HORIZONTAL = 1024;
    public static final int FLAG_NOTCH_PORTRAIT = 512;
    public static final int FLAG_NOTCH_SUPPORT = 256;

    public static boolean hasNotch(Context context) {
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(Window window) {
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(window, 768);
        } catch (Exception unused) {
        }
    }
}
