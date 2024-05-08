package com.huawei.hms.ads.uiengineloader;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29498a = "EmuiUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29499b = "EMUI_SDK_INT";

    /* renamed from: c, reason: collision with root package name */
    private static final String f29500c = "com.huawei.android.os.BuildEx$VERSION";

    /* renamed from: d, reason: collision with root package name */
    private static final int f29501d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f29502e = 7;

    /* renamed from: f, reason: collision with root package name */
    private static final int f29503f = 8;

    /* renamed from: g, reason: collision with root package name */
    private static final int f29504g = 9;

    /* renamed from: h, reason: collision with root package name */
    private static final int f29505h = 10;

    /* renamed from: i, reason: collision with root package name */
    private static final int f29506i = 11;

    /* renamed from: j, reason: collision with root package name */
    private static final int f29507j = 14;

    /* renamed from: k, reason: collision with root package name */
    private static final int f29508k = 15;

    /* renamed from: l, reason: collision with root package name */
    private static final int f29509l = 17;

    /* renamed from: m, reason: collision with root package name */
    private static final int f29510m = 30;

    /* renamed from: n, reason: collision with root package name */
    private static final int f29511n = 31;

    /* renamed from: o, reason: collision with root package name */
    private static final int f29512o = 40;

    /* renamed from: p, reason: collision with root package name */
    private static final int f29513p = 41;

    /* renamed from: q, reason: collision with root package name */
    private static final int f29514q = 50;

    /* renamed from: r, reason: collision with root package name */
    private static final int f29515r = 60;

    /* renamed from: s, reason: collision with root package name */
    private static final int f29516s = 81;

    /* renamed from: t, reason: collision with root package name */
    private static final int f29517t = 90;

    /* renamed from: u, reason: collision with root package name */
    private static int f29518u = -1;

    /* renamed from: v, reason: collision with root package name */
    private static int f29519v = d();

    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.w.<clinit>():void");
    }

    public static boolean a() {
        return f29518u == 50;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b() {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.w.b():void");
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.version.emui");
            aa.a(f29498a, "isNeed2UseHwEmui :");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    f29518u = 30;
                    return;
                }
                if (str.contains("EmotionUI_3.1")) {
                    f29518u = 31;
                    return;
                }
                if (str.contains("EmotionUI_4.0")) {
                    f29518u = 40;
                    return;
                }
                if (str.contains("EmotionUI_4.1")) {
                    f29518u = 41;
                    return;
                }
                if (str.contains("EmotionUI_5.0")) {
                    f29518u = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    f29518u = 60;
                } else {
                    f29518u = -1;
                }
            }
        } catch (Throwable th) {
            aa.d(f29498a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int d() {
        /*
            java.lang.String r0 = "EmuiUtil"
            r1 = 0
            java.lang.String r2 = "com.huawei.android.os.BuildEx$VERSION"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L1f java.lang.NoSuchFieldException -> L22 java.lang.IllegalAccessException -> L25 java.lang.ClassNotFoundException -> L28
            java.lang.String r3 = "EMUI_SDK_INT"
            java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L1f java.lang.NoSuchFieldException -> L22 java.lang.IllegalAccessException -> L25 java.lang.ClassNotFoundException -> L28
            r4 = 1
            java.lang.reflect.Field[] r5 = new java.lang.reflect.Field[r4]     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L1f java.lang.NoSuchFieldException -> L22 java.lang.IllegalAccessException -> L25 java.lang.ClassNotFoundException -> L28
            r5[r1] = r3     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L1f java.lang.NoSuchFieldException -> L22 java.lang.IllegalAccessException -> L25 java.lang.ClassNotFoundException -> L28
            java.lang.reflect.AccessibleObject.setAccessible(r5, r4)     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L1f java.lang.NoSuchFieldException -> L22 java.lang.IllegalAccessException -> L25 java.lang.ClassNotFoundException -> L28
            java.lang.Object r0 = r3.get(r2)     // Catch: java.lang.Exception -> L1c java.lang.SecurityException -> L1f java.lang.NoSuchFieldException -> L22 java.lang.IllegalAccessException -> L25 java.lang.ClassNotFoundException -> L28
            goto L2e
        L1c:
            java.lang.String r2 = "getEMUIVersionCode exception "
            goto L2a
        L1f:
            java.lang.String r2 = "getEMUIVersionCode SecurityException"
            goto L2a
        L22:
            java.lang.String r2 = "getEMUIVersionCode NoSuchFieldException"
            goto L2a
        L25:
            java.lang.String r2 = "getEMUIVersionCode IllegalAccessException"
            goto L2a
        L28:
            java.lang.String r2 = "getEMUIVersionCode ClassNotFoundException"
        L2a:
            com.huawei.hms.ads.uiengineloader.aa.c(r0, r2)
            r0 = 0
        L2e:
            boolean r2 = r0 instanceof java.lang.Integer
            if (r2 != 0) goto L33
            return r1
        L33:
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.w.d():int");
    }
}
