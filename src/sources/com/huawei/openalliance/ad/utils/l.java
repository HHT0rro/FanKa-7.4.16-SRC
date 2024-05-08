package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.huawei.hms.ads.eb;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l {
    public static final String B = "CN";
    private static final String C = "DeviceUtil";
    public static final String Code = "content";
    private static final int D = 2;
    private static final int F = 1;
    public static final String I = "/switch/query";
    private static final float S = 1.5f;
    public static final String V = "com.huawei.hwid.pps.apiprovider";
    public static final String Z = "isSwitchChecked";

    public static boolean B(Context context) {
        return "1".equalsIgnoreCase(k.Code(context).Code());
    }

    public static boolean C(Context context) {
        return "0".equalsIgnoreCase(k.Code(context).Code());
    }

    public static String Code() {
        String Code2 = ay.Code("ro.product.model");
        return TextUtils.isEmpty(Code2) ? Build.MODEL : Code2;
    }

    public static void Code(final am amVar, final Context context) {
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.l.1
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0090, code lost:
            
                r2.Code(false);
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0096, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
            
                if (r0 == null) goto L22;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r8 = this;
                    android.net.Uri$Builder r0 = new android.net.Uri$Builder
                    r0.<init>()
                    java.lang.String r1 = "content"
                    android.net.Uri$Builder r0 = r0.scheme(r1)
                    java.lang.String r1 = "com.huawei.hwid.pps.apiprovider"
                    android.net.Uri$Builder r0 = r0.authority(r1)
                    java.lang.String r1 = "/switch/query"
                    android.net.Uri$Builder r0 = r0.path(r1)
                    android.net.Uri r2 = r0.build()
                    android.content.Context r0 = r1
                    boolean r0 = com.huawei.openalliance.ad.utils.v.Code(r0, r2)
                    java.lang.String r7 = "DeviceUtil"
                    if (r0 != 0) goto L2b
                    java.lang.String r0 = "provider uri invalid."
                    com.huawei.hms.ads.gl.I(r7, r0)
                    return
                L2b:
                    r0 = 0
                    android.content.Context r1 = r1     // Catch: java.lang.Throwable -> L70
                    android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L70
                    r3 = 0
                    r4 = 0
                    r5 = 0
                    r6 = 0
                    android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L70
                    if (r0 == 0) goto L65
                    boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L70
                    if (r1 == 0) goto L65
                    java.lang.String r1 = "isSwitchChecked"
                    int r1 = r0.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L5f
                    java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L5f
                    java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L5f
                    java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5f
                    boolean r1 = r2.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L5f
                    com.huawei.openalliance.ad.utils.am r2 = r2     // Catch: java.lang.Throwable -> L5f
                    r2.Code(r1)     // Catch: java.lang.Throwable -> L5f
                    r0.close()
                    return
                L5f:
                    java.lang.String r1 = "loc_tag isBaseLocationSwitch Exception"
                    com.huawei.hms.ads.gl.Z(r7, r1)     // Catch: java.lang.Throwable -> L70
                    goto L6a
                L65:
                    java.lang.String r1 = "loc_tag isBaseLocationSwitch, cursor is null"
                    com.huawei.hms.ads.gl.I(r7, r1)     // Catch: java.lang.Throwable -> L70
                L6a:
                    if (r0 == 0) goto L90
                L6c:
                    r0.close()
                    goto L90
                L70:
                    r1 = move-exception
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
                    r2.<init>()     // Catch: java.lang.Throwable -> L97
                    java.lang.String r3 = "loc_tag isBaseLocationSwitch query error: "
                    r2.append(r3)     // Catch: java.lang.Throwable -> L97
                    java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> L97
                    java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Throwable -> L97
                    r2.append(r1)     // Catch: java.lang.Throwable -> L97
                    java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L97
                    com.huawei.hms.ads.gl.Z(r7, r1)     // Catch: java.lang.Throwable -> L97
                    if (r0 == 0) goto L90
                    goto L6c
                L90:
                    com.huawei.openalliance.ad.utils.am r0 = r2
                    r1 = 0
                    r0.Code(r1)
                    return
                L97:
                    r1 = move-exception
                    if (r0 == 0) goto L9d
                    r0.close()
                L9d:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.l.AnonymousClass1.run():void");
            }
        });
    }

    public static boolean Code(Context context) {
        am Code2 = am.Code(context);
        boolean V2 = Code2.V();
        Code(Code2, context);
        return V2;
    }

    public static int D(Context context) {
        return ((float) c.B(context)) / ((float) c.Z(context)) > 1.5f ? 2 : 1;
    }

    public static boolean F(Context context) {
        int D2;
        try {
            D2 = eb.Code(context).S();
        } catch (Throwable th) {
            D2 = D(context);
            gl.I(C, "getFoldableStatus %s", th.getClass().getSimpleName());
        }
        return D2 == 1;
    }

    public static int I(Context context) {
        am Code2 = am.Code(context);
        if (Code2.S() != null) {
            return Code2.S().intValue();
        }
        int I2 = k.Code(context).I();
        Code2.Code(I2);
        return I2;
    }

    public static Context L(Context context) {
        return V() ? context.createDeviceProtectedStorageContext() : context;
    }

    public static boolean S(Context context) {
        try {
            return c.I() ? HwFoldScreenManagerEx.isFoldable() : com.huawei.android.fsm.HwFoldScreenManagerEx.isFoldable();
        } catch (Throwable th) {
            gl.I(C, "isFoldablePhone exception: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public static boolean V() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean V(Context context) {
        am Code2 = am.Code(context);
        if (Code2.B() != null) {
            return Code2.B().booleanValue();
        }
        boolean V2 = k.Code(context).V();
        Code2.I(V2);
        return V2;
    }

    public static boolean Z(Context context) {
        boolean z10;
        boolean z11;
        am Code2 = am.Code(context);
        try {
            if (Code2.F() != null) {
                z11 = Code2.F().booleanValue();
            } else {
                z11 = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(1) != null;
                try {
                    Code2.Code(Boolean.valueOf(z11));
                } catch (Throwable th) {
                    z10 = z11;
                    th = th;
                    gl.I(C, "getHasAccAndRotate err: %s", th.getClass().getSimpleName());
                    return z10;
                }
            }
            return z11;
        } catch (Throwable th2) {
            th = th2;
            z10 = true;
        }
    }
}
