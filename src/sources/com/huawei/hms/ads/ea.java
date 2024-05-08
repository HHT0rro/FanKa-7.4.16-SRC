package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ea {
    private static final byte[] B = new byte[0];
    private static final String Code = "DeviceManager";
    private static final String I = "02";
    private static final String V = "ro.build.2b2c.partner.ext_channel";
    private static volatile el Z;

    public static boolean B(Context context) {
        return V(context) || Code();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean C(android.content.Context r7) {
        /*
            java.lang.String r0 = "HONOR"
            java.lang.String r1 = "DeviceManager"
            java.lang.String r2 = "HUAWEI"
            android.content.Context r7 = r7.getApplicationContext()
            com.huawei.openalliance.ad.utils.am r7 = com.huawei.openalliance.ad.utils.am.Code(r7)
            java.lang.String r3 = r7.Z()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 1
            if (r4 != 0) goto L23
            java.lang.String r7 = java.lang.String.valueOf(r5)
            boolean r7 = android.text.TextUtils.equals(r7, r3)
            goto La1
        L23:
            r3 = 0
            java.lang.String r4 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L77 java.lang.RuntimeException -> L80
            boolean r6 = r4.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L77 java.lang.RuntimeException -> L80
            if (r6 != 0) goto L43
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L77 java.lang.RuntimeException -> L80
            boolean r2 = r6.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L77 java.lang.RuntimeException -> L80
            if (r2 != 0) goto L43
            boolean r2 = r4.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L77 java.lang.RuntimeException -> L80
            if (r2 != 0) goto L43
            boolean r0 = r6.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L77 java.lang.RuntimeException -> L80
            if (r0 == 0) goto L41
            goto L43
        L41:
            r0 = 0
            goto L44
        L43:
            r0 = 1
        L44:
            if (r0 != 0) goto L75
            boolean r2 = com.huawei.openalliance.ad.utils.c.I()     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L71
            if (r2 == 0) goto L53
            java.lang.String r2 = "com.hihonor.android.os.Build$VERSION"
        L4e:
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L71
            goto L56
        L53:
            java.lang.String r2 = "com.huawei.android.os.BuildEx$VERSION"
            goto L4e
        L56:
            java.lang.String r4 = "EMUI_SDK_INT"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L71
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L71
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L71
            int r0 = r2.intValue()     // Catch: java.lang.Throwable -> L6d java.lang.RuntimeException -> L71
            if (r0 <= 0) goto L6a
            goto L6b
        L6a:
            r5 = 0
        L6b:
            r0 = r5
            goto L75
        L6d:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L78
        L71:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L81
        L75:
            r3 = r0
            goto L9d
        L77:
            r0 = move-exception
        L78:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "isHuaweiPhone Error:"
            goto L88
        L80:
            r0 = move-exception
        L81:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "isHuaweiPhone RuntimeException:"
        L88:
            r2.append(r4)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.huawei.hms.ads.gl.Z(r1, r0)
        L9d:
            r7.V(r3)
            r7 = r3
        La1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ea.C(android.content.Context):boolean");
    }

    public static el Code(Context context) {
        if (Z == null) {
            synchronized (B) {
                if (Z == null) {
                    Z = I(context) ? ei.V(context) : Z(context) ? eg.V(context) : Code() ? ef.V(context) : ek.V(context);
                }
            }
        }
        return Z;
    }

    private static boolean Code() {
        String Code2 = com.huawei.openalliance.ad.utils.ay.Code("ro.build.2b2c.partner.ext_channel");
        return !TextUtils.isEmpty(Code2) && Code2.startsWith("02");
    }

    public static boolean I(Context context) {
        com.huawei.openalliance.ad.utils.am Code2 = com.huawei.openalliance.ad.utils.am.Code(context);
        String L = Code2.L();
        if (!TextUtils.isEmpty(L)) {
            return TextUtils.equals(String.valueOf(true), L);
        }
        boolean z10 = V(context) && !Z(context);
        Code2.Z(z10);
        return z10;
    }

    public static boolean V(Context context) {
        return C(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT >= 33) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean Z(android.content.Context r4) {
        /*
            com.huawei.openalliance.ad.utils.am r4 = com.huawei.openalliance.ad.utils.am.Code(r4)
            java.lang.String r0 = r4.a()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r1 != 0) goto L18
            java.lang.String r4 = java.lang.String.valueOf(r2)
            boolean r4 = android.text.TextUtils.equals(r4, r0)
            goto L56
        L18:
            r0 = 0
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = "HONOR"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L30
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L33
            r3 = 31
            if (r1 < r3) goto L30
            int r1 = com.hihonor.android.os.Build.VERSION.MAGIC_SDK_INT     // Catch: java.lang.Throwable -> L33
            r3 = 33
            if (r1 < r3) goto L30
            goto L31
        L30:
            r2 = 0
        L31:
            r0 = r2
            goto L52
        L33:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isHonor6UpPhone Error:"
            r2.append(r3)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "DeviceManager"
            com.huawei.hms.ads.gl.Z(r2, r1)
        L52:
            r4.B(r0)
            r4 = r0
        L56:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ea.Z(android.content.Context):boolean");
    }
}
