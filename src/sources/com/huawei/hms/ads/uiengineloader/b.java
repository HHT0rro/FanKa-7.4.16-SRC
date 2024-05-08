package com.huawei.hms.ads.uiengineloader;

import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.os.Build;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f29437a = 27;

    /* renamed from: b, reason: collision with root package name */
    private static final String f29438b = "DeviceUtil";

    public static String a(String str) {
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(d() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
                } catch (ClassNotFoundException unused) {
                }
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            }
            cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Throwable th) {
            aa.c(f29438b, "getSystemProperties Exception:" + th.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a() {
        /*
            java.lang.String r0 = "HONOR"
            java.lang.String r1 = "HUAWEI"
            r2 = 0
            java.lang.String r3 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L47
            boolean r4 = r3.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L47
            r5 = 1
            if (r4 != 0) goto L25
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L47
            boolean r1 = r4.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L47
            if (r1 != 0) goto L25
            boolean r1 = r3.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L47
            if (r1 != 0) goto L25
            boolean r0 = r4.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L23
            goto L25
        L23:
            r0 = 0
            goto L26
        L25:
            r0 = 1
        L26:
            if (r0 != 0) goto L64
            java.lang.String r1 = "com.huawei.android.os.BuildEx$VERSION"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "EMUI_SDK_INT"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch: java.lang.Throwable -> L43
            r3 = 0
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L43
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L43
            int r0 = r1.intValue()     // Catch: java.lang.Throwable -> L43
            if (r0 <= 0) goto L63
            r2 = 1
            goto L63
        L43:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L48
        L47:
            r0 = move-exception
        L48:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "isHuaweiPhone Error:"
            r1.<init>(r3)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "DeviceUtil"
            com.huawei.hms.ads.uiengineloader.aa.d(r1, r0)
        L63:
            r0 = r2
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.b.a():boolean");
    }

    private static boolean b() {
        if (!a()) {
            String a10 = a(com.huawei.hms.ads.dynamic.a.f29123r);
            if (!(!TextUtils.isEmpty(a10) && a10.startsWith(com.huawei.hms.ads.dynamic.a.f29124s))) {
                return false;
            }
        }
        return true;
    }

    private static boolean c() {
        String a10 = a(com.huawei.hms.ads.dynamic.a.f29123r);
        return !TextUtils.isEmpty(a10) && a10.startsWith(com.huawei.hms.ads.dynamic.a.f29124s);
    }

    private static boolean d() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            aa.d(f29438b, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
            return false;
        }
    }
}
