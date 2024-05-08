package com.huawei.quickcard.utils;

import android.content.Context;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.h0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DeviceInfoUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34261a = "DeviceInfoUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final int f34262b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f34263c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f34264d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f34265e = 3;

    public static int getDeviceScreenHeight(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        CardLogUtils.w("Unexpected branch");
        return 0;
    }

    public static int getDeviceScreenWidth(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        CardLogUtils.w("Unexpected branch");
        return 0;
    }

    public static String getDeviceType() {
        String systemPropertiesGet = systemPropertiesGet("ro.build.characteristics");
        return systemPropertiesGet == null ? "" : systemPropertiesGet;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String systemPropertiesGet(java.lang.String r8) {
        /*
            java.lang.String r0 = "DeviceInfoUtils"
            r1 = 0
            r2 = 1
            r3 = 0
            java.lang.String r4 = "android.os.SystemProperties"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L18 java.lang.NoSuchMethodException -> L1f java.lang.ClassNotFoundException -> L26
            java.lang.String r5 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L19 java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L27
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r1] = r7     // Catch: java.lang.Exception -> L19 java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L27
            java.lang.reflect.Method r5 = r4.getDeclaredMethod(r5, r6)     // Catch: java.lang.Exception -> L19 java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L27
            goto L2d
        L18:
            r4 = r3
        L19:
            java.lang.String r5 = "other error when getProperty1."
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r5)
            goto L2c
        L1f:
            r4 = r3
        L20:
            java.lang.String r5 = "method not found."
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r5)
            goto L2c
        L26:
            r4 = r3
        L27:
            java.lang.String r5 = "class not found."
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r5)
        L2c:
            r5 = r3
        L2d:
            if (r5 == 0) goto L5c
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L45 java.lang.reflect.InvocationTargetException -> L4b java.lang.IllegalArgumentException -> L51 java.lang.IllegalAccessException -> L57
            r2[r1] = r8     // Catch: java.lang.Exception -> L45 java.lang.reflect.InvocationTargetException -> L4b java.lang.IllegalArgumentException -> L51 java.lang.IllegalAccessException -> L57
            java.lang.Object r8 = r5.invoke(r4, r2)     // Catch: java.lang.Exception -> L45 java.lang.reflect.InvocationTargetException -> L4b java.lang.IllegalArgumentException -> L51 java.lang.IllegalAccessException -> L57
            boolean r1 = r8 instanceof java.lang.String     // Catch: java.lang.Exception -> L45 java.lang.reflect.InvocationTargetException -> L4b java.lang.IllegalArgumentException -> L51 java.lang.IllegalAccessException -> L57
            if (r1 == 0) goto L3f
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L45 java.lang.reflect.InvocationTargetException -> L4b java.lang.IllegalArgumentException -> L51 java.lang.IllegalAccessException -> L57
            r3 = r8
            goto L5c
        L3f:
            java.lang.String r8 = "mGetMethod is not String"
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r8)     // Catch: java.lang.Exception -> L45 java.lang.reflect.InvocationTargetException -> L4b java.lang.IllegalArgumentException -> L51 java.lang.IllegalAccessException -> L57
            goto L5c
        L45:
            java.lang.String r8 = "other error when getProperty2."
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r8)
            goto L5c
        L4b:
            java.lang.String r8 = "illegal invocation."
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r8)
            goto L5c
        L51:
            java.lang.String r8 = "illegal argument."
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r8)
            goto L5c
        L57:
            java.lang.String r8 = "illegal access."
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r8)
        L5c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.utils.DeviceInfoUtils.systemPropertiesGet(java.lang.String):java.lang.String");
    }

    public static h0 transformFoldState(int i10) {
        if (i10 == 1) {
            return h0.EXPAND;
        }
        if (i10 == 2) {
            return h0.FOLDED;
        }
        if (i10 == 3) {
            return h0.HALF_FOLDED;
        }
        return h0.UNKNOWN;
    }
}
