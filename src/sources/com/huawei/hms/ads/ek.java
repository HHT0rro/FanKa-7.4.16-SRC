package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ek extends ec {
    private static final int B = 32;
    private static final int C = 8;
    private static final byte[] F = new byte[0];
    public static final String I = "CN";
    private static el S = null;
    private static final String Z = "ThirdDeviceImpl";

    public ek(Context context) {
        super(context);
    }

    private static el I(Context context) {
        el elVar;
        synchronized (F) {
            if (S == null) {
                S = new ek(context);
            }
            elVar = S;
        }
        return elVar;
    }

    public static el V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public int Code(View view) {
        int identifier;
        DisplayCutout displayCutout;
        int i10 = -1;
        if (view == null) {
            return -1;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && view.getRootWindowInsets() != null && (displayCutout = view.getRootWindowInsets().getDisplayCutout()) != null) {
                List<Rect> boundingRects = displayCutout.getBoundingRects();
                if (!aa.Code(boundingRects)) {
                    i10 = boundingRects.get(0).height();
                }
            }
            if (i10 < 0 && (identifier = this.Code.getResources().getIdentifier("notch_height", "dimen", "android")) > 0) {
                i10 = this.Code.getResources().getDimensionPixelSize(identifier);
            }
            if (i10 >= 0) {
                return i10;
            }
            int identifier2 = this.Code.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier2 > 0) {
                i10 = this.Code.getResources().getDimensionPixelSize(identifier2);
            }
            if (i10 == 0) {
                return 110;
            }
            return i10;
        } catch (Throwable th) {
            gl.V(Z, "getNotchHeight err: %s", th.getClass().getSimpleName());
            return i10;
        }
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean Code() {
        return "CN".equalsIgnoreCase(fr.Code(this.Code).W());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean Code(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Notch"
            java.lang.String r1 = "ThirdDeviceImpl"
            r2 = 1
            r3 = 0
            java.lang.String r4 = "android.os.SystemProperties"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Throwable -> L38
            java.lang.String r5 = "getInt"
            r6 = 2
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> L38
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r3] = r8     // Catch: java.lang.Throwable -> L38
            java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L38
            r7[r2] = r8     // Catch: java.lang.Throwable -> L38
            java.lang.reflect.Method r5 = r4.getMethod(r5, r7)     // Catch: java.lang.Throwable -> L38
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L38
            java.lang.String r7 = "ro.miui.notch"
            r6[r3] = r7     // Catch: java.lang.Throwable -> L38
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L38
            r6[r2] = r7     // Catch: java.lang.Throwable -> L38
            java.lang.Object r4 = r5.invoke(r4, r6)     // Catch: java.lang.Throwable -> L38
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L38
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L38
            if (r4 != 0) goto L36
            goto L55
        L36:
            r4 = 1
            goto L56
        L38:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "isNotchEnable mi Throwable:"
            r5.append(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.huawei.hms.ads.gl.I(r1, r4)
        L55:
            r4 = 0
        L56:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            r5[r3] = r6
            java.lang.String r6 = "isNotchEnable xiaomi, hasNotch = %s"
            com.huawei.hms.ads.gl.Code(r1, r6, r5)
            if (r4 != 0) goto L8d
            android.content.pm.PackageManager r5 = r10.getPackageManager()     // Catch: java.lang.Throwable -> L70
            java.lang.String r6 = "com.oppo.feature.screen.heteromorphism"
            boolean r4 = r5.hasSystemFeature(r6)     // Catch: java.lang.Throwable -> L70
            goto L8d
        L70:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isNotchEnable oppo Throwable:"
            r6.append(r7)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.huawei.hms.ads.gl.I(r1, r5)
        L8d:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            r5[r3] = r6
            java.lang.String r6 = "isNotchEnable oppo, hasNotch = %s"
            com.huawei.hms.ads.gl.Code(r1, r6, r5)
            if (r4 != 0) goto Le6
            java.lang.ClassLoader r10 = r10.getClassLoader()     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.String r5 = "android.util.FtFeature"
            java.lang.Class r10 = r10.loadClass(r5)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.String r5 = "isFeatureSupport"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.Class<java.lang.Integer> r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            r6[r3] = r7     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.reflect.Method r5 = r10.getMethod(r5, r6)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            r7 = 32
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            r6[r3] = r7     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.Object r6 = r5.invoke(r10, r6)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            boolean r4 = r6.booleanValue()     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            r7 = 8
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            r6[r3] = r7     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.Object r10 = r5.invoke(r10, r6)     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            boolean r4 = r10.booleanValue()     // Catch: java.lang.Exception -> Ldb java.lang.NoSuchMethodException -> Lde java.lang.ClassNotFoundException -> Le1
            goto Le6
        Ldb:
            java.lang.String r10 = "hasNotchAtVivo Exception"
            goto Le3
        Lde:
            java.lang.String r10 = "hasNotchAtVivo NoSuchMethodException"
            goto Le3
        Le1:
            java.lang.String r10 = "hasNotchAtVivo ClassNotFoundException"
        Le3:
            com.huawei.hms.ads.gl.Z(r0, r10)
        Le6:
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            r10[r3] = r0
            java.lang.String r0 = "isNotchEnable vivo, hasNotch = %s"
            com.huawei.hms.ads.gl.Code(r1, r0, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ek.Code(android.content.Context):boolean");
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean V() {
        return Code();
    }
}
