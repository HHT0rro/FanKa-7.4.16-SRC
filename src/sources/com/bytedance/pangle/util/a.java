package com.bytedance.pangle.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {
    public static void a(com.bytedance.pangle.wrapper.a aVar, Activity activity) {
        try {
            FieldUtils.writeField(aVar, "mTheme", (Object) null);
            FieldUtils.writeField((Object) aVar, "mThemeResource", (Object) 0);
            int[] a10 = a(activity);
            if (a10 == null) {
                return;
            }
            for (int i10 : a10) {
                if (i10 != 0) {
                    aVar.setWrapperActivityTheme(i10);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static int[] a(Activity activity) {
        Resources.Theme theme = activity.getTheme();
        if (theme == null) {
            return null;
        }
        try {
            if (i.h()) {
                Object readField = FieldUtils.readField(theme, "mThemeImpl");
                if (readField == null) {
                    return null;
                }
                try {
                    Object invokeMethod = MethodUtils.invokeMethod(readField, "getKey", new Object[0]);
                    if (invokeMethod != null) {
                        return (int[]) FieldUtils.readField(invokeMethod, "mResId");
                    }
                } catch (Exception unused) {
                }
                Object invoke = com.bytedance.pangle.b.b.a.a(readField.getClass(), "getKey", new Class[0]).invoke(readField, new Object[0]);
                if (invoke == null) {
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                    return null;
                }
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                return (int[]) com.bytedance.pangle.b.b.a.a(invoke.getClass(), "mResId").get(invoke);
            }
            if (Build.VERSION.SDK_INT > 22) {
                Object invokeMethod2 = MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
                if (invokeMethod2 == null) {
                    return null;
                }
                return (int[]) FieldUtils.readField(invokeMethod2, "mResId");
            }
            String str = (String) MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
            if (str == null) {
                return null;
            }
            String[] split = str.trim().replace("!", "").split(" ");
            int[] iArr = new int[split.length];
            for (int i10 = 0; i10 < split.length; i10++) {
                iArr[i10] = Integer.parseInt(split[i10], 16);
            }
            return iArr;
        } catch (Throwable th) {
            ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
            return null;
        }
    }

    public static void a(IPluginActivity iPluginActivity, Activity activity) {
        try {
            FieldUtils.writeField(iPluginActivity, "mTheme", (Object) null);
            FieldUtils.writeField((Object) iPluginActivity, "mThemeResource", (Object) 0);
            int[] a10 = a(activity);
            if (a10 == null) {
                return;
            }
            for (int i10 : a10) {
                if (i10 != 0) {
                    iPluginActivity.setProxyTheme2Plugin(i10);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
