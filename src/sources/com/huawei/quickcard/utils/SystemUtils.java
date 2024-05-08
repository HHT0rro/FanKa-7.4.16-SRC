package com.huawei.quickcard.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.ThemeMode;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.ReflectUtils;
import com.huawei.quickcard.f0;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo;
import com.huawei.quickcard.m0;
import com.huawei.quickcard.o0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SystemUtils {

    /* renamed from: a, reason: collision with root package name */
    private static IManufacturerDeviceInfo f34304a;

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(Object obj, @NonNull Class<T> cls, boolean z10) {
        if (!z10) {
            Objects.requireNonNull(obj, "can not be null");
        }
        if (cls.isInstance(obj) || obj == 0) {
            return obj;
        }
        throw new ClassCastException("can not cast to " + cls.getSimpleName());
    }

    public static void adaptUiMode(@NonNull Configuration configuration, @NonNull ThemeMode themeMode) {
        boolean isDarkThemeEnabled = isDarkThemeEnabled(configuration);
        if (themeMode == ThemeMode.LIGHT && isDarkThemeEnabled) {
            configuration.uiMode = buildConfigUiMode(configuration, 16);
        } else {
            if (themeMode != ThemeMode.DARK || isDarkThemeEnabled) {
                return;
            }
            configuration.uiMode = buildConfigUiMode(configuration, 32);
        }
    }

    public static void allowSystemUiMode(@NonNull View view, @NonNull Configuration configuration, CardContext cardContext) {
        Configuration configuration2 = view.getContext().getApplicationContext().getResources().getConfiguration();
        int i10 = configuration.uiMode;
        int i11 = configuration2.uiMode;
        if (i10 != i11) {
            configuration.uiMode = i11;
            refreshUiMode(cardContext, configuration);
        }
    }

    public static int buildConfigUiMode(@NonNull Configuration configuration, int i10) {
        return (configuration.uiMode & (-49)) | i10;
    }

    public static IManufacturerDeviceInfo getManufacturerDeviceInfo() {
        return f34304a;
    }

    public static String getOsType() {
        IManufacturerDeviceInfo iManufacturerDeviceInfo = f34304a;
        return iManufacturerDeviceInfo != null ? iManufacturerDeviceInfo.osType() : "android";
    }

    public static int getScreenHeight(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public static int getScreenWidth(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    public static int getUserId() {
        int i10 = -999;
        try {
            Class<?> cls = Class.forName("android.os.UserHandle");
            i10 = ((Integer) a(cls.getDeclaredMethod("myUserId", new Class[0]).invoke(cls, new Object[0]), Integer.class, true)).intValue();
            CardLogUtils.d("getUserId", "getUserId:" + i10);
            return i10;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e2) {
            CardLogUtils.d("getUserId", " getUserId wrong", e2);
            return i10;
        }
    }

    public static void initManufacturerDeviceInfo() {
        String str = Build.MANUFACTURER;
        if ("HUAWEI".equals(str)) {
            f34304a = new o0();
        } else if ("HONOR".equals(str)) {
            f34304a = new m0();
        } else {
            f34304a = new f0(str);
        }
    }

    public static boolean isDarkThemeEnabled(Context context) {
        if (context == null) {
            return false;
        }
        return isDarkThemeEnabled(context.getResources().getConfiguration());
    }

    public static boolean isHarmonyOS() {
        try {
            return IManufacturerDeviceInfo.OS_HARMONY.equals(ReflectUtils.reflectPublicMethod("com.huawei.system.BuildEx", "getOsBrand"));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isOverAPI28() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean isQVersion() {
        return Build.VERSION.SDK_INT > 28;
    }

    public static boolean isQVersionDark(Context context) {
        if (context == null) {
            return false;
        }
        return isQVersionDark(context.getResources().getConfiguration());
    }

    public static void refreshUiMode(CardContext cardContext, Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ConfigBean.Field.UI_MODE);
        cardContext.onConfigChanged(arrayList, configuration, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String systemPropertiesGet(java.lang.String r8) {
        /*
            java.lang.String r0 = "utils"
            r1 = 0
            r2 = 1
            r3 = 0
            java.lang.String r4 = "android.os.SystemProperties"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L1e java.lang.NoSuchMethodException -> L26 java.lang.ClassNotFoundException -> L2e
            java.lang.String r5 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L18 java.lang.NoSuchMethodException -> L1a java.lang.ClassNotFoundException -> L1c
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r1] = r7     // Catch: java.lang.Exception -> L18 java.lang.NoSuchMethodException -> L1a java.lang.ClassNotFoundException -> L1c
            java.lang.reflect.Method r5 = r4.getDeclaredMethod(r5, r6)     // Catch: java.lang.Exception -> L18 java.lang.NoSuchMethodException -> L1a java.lang.ClassNotFoundException -> L1c
            goto L36
        L18:
            r5 = move-exception
            goto L20
        L1a:
            r5 = move-exception
            goto L28
        L1c:
            r5 = move-exception
            goto L30
        L1e:
            r5 = move-exception
            r4 = r3
        L20:
            java.lang.String r6 = "other error when getProperty1."
            com.huawei.quickcard.base.log.CardLogUtils.e(r0, r6, r5)
            goto L35
        L26:
            r5 = move-exception
            r4 = r3
        L28:
            java.lang.String r6 = "method not found."
            com.huawei.quickcard.base.log.CardLogUtils.e(r0, r6, r5)
            goto L35
        L2e:
            r5 = move-exception
            r4 = r3
        L30:
            java.lang.String r6 = "class not found."
            com.huawei.quickcard.base.log.CardLogUtils.e(r0, r6, r5)
        L35:
            r5 = r3
        L36:
            if (r5 == 0) goto L69
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L4e java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalArgumentException -> L5c java.lang.IllegalAccessException -> L63
            r2[r1] = r8     // Catch: java.lang.Exception -> L4e java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalArgumentException -> L5c java.lang.IllegalAccessException -> L63
            java.lang.Object r8 = r5.invoke(r4, r2)     // Catch: java.lang.Exception -> L4e java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalArgumentException -> L5c java.lang.IllegalAccessException -> L63
            boolean r1 = r8 instanceof java.lang.String     // Catch: java.lang.Exception -> L4e java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalArgumentException -> L5c java.lang.IllegalAccessException -> L63
            if (r1 == 0) goto L48
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L4e java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalArgumentException -> L5c java.lang.IllegalAccessException -> L63
            r3 = r8
            goto L69
        L48:
            java.lang.String r8 = "mGetMethod is not String"
            com.huawei.quickcard.base.log.CardLogUtils.e(r0, r8)     // Catch: java.lang.Exception -> L4e java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalArgumentException -> L5c java.lang.IllegalAccessException -> L63
            goto L69
        L4e:
            r8 = move-exception
            java.lang.String r1 = "other error when getProperty2."
            com.huawei.quickcard.base.log.CardLogUtils.e(r0, r1, r8)
            goto L69
        L55:
            r8 = move-exception
            java.lang.String r1 = "illegal invocation."
            com.huawei.quickcard.base.log.CardLogUtils.e(r0, r1, r8)
            goto L69
        L5c:
            r8 = move-exception
            java.lang.String r1 = "illegal argument."
            com.huawei.quickcard.base.log.CardLogUtils.e(r0, r1, r8)
            goto L69
        L63:
            r8 = move-exception
            java.lang.String r1 = "illegal access."
            com.huawei.quickcard.base.log.CardLogUtils.e(r0, r1, r8)
        L69:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.utils.SystemUtils.systemPropertiesGet(java.lang.String):java.lang.String");
    }

    public static boolean isDarkThemeEnabled(Configuration configuration) {
        if (isQVersion()) {
            return isQVersionDark(configuration);
        }
        return isDarkThemeEnabled();
    }

    public static boolean isQVersionDark(@NonNull Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    public static boolean isDarkThemeEnabled() {
        try {
            if (!Attributes.UiMode.DARK.equals(systemPropertiesGet("persist.deep.theme_" + getUserId()))) {
                if (!Attributes.UiMode.DARK.equals(systemPropertiesGet("persist.deep.theme"))) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            CardLogUtils.w(Attributes.UiMode.DARK, "read deep theme flag failed.", e2);
            return false;
        }
    }
}
