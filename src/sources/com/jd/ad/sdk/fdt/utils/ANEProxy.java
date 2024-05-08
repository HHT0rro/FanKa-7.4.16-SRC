package com.jd.ad.sdk.fdt.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ANEProxy {
    public static synchronized String ja(String str) {
        String jad_cp;
        synchronized (ANEProxy.class) {
            jad_cp = ANE.jad_cp(str);
        }
        return jad_cp;
    }

    public static synchronized String jb(String str) {
        String jad_an;
        synchronized (ANEProxy.class) {
            jad_an = ANE.jad_an(str);
        }
        return jad_an;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        if (r3.endsWith(com.alipay.sdk.util.i.f4738d) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String jc(java.lang.String r3) {
        /*
            java.lang.Class<com.jd.ad.sdk.fdt.utils.ANEProxy> r0 = com.jd.ad.sdk.fdt.utils.ANEProxy.class
            monitor-enter(r0)
            java.lang.Class<com.jd.ad.sdk.fdt.utils.ANE> r1 = com.jd.ad.sdk.fdt.utils.ANE.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L4c
            int r2 = com.jd.ad.sdk.fdt.utils.ANE.jad_an     // Catch: java.lang.Throwable -> L49
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L11
        Le:
            java.lang.String r3 = ""
            goto L46
        L11:
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = "{"
            boolean r2 = r3.startsWith(r2)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L26
            java.lang.String r2 = "}"
            boolean r2 = r3.endsWith(r2)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L26
            goto L46
        L26:
            java.lang.String r2 = ""
            java.lang.String r3 = com.jd.ad.sdk.fdt.utils.ANE.jad_an(r3)     // Catch: java.lang.Throwable -> L2d
            goto L36
        L2d:
            r3 = move-exception
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)     // Catch: java.lang.Throwable -> L49
            com.jd.ad.sdk.logger.Logger.d(r3)     // Catch: java.lang.Throwable -> L49
            r3 = r2
        L36:
            java.lang.String r2 = "{"
            boolean r2 = r3.startsWith(r2)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto Le
            java.lang.String r2 = "}"
            boolean r2 = r3.endsWith(r2)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto Le
        L46:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4c
            monitor-exit(r0)
            return r3
        L49:
            r3 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4c
            throw r3     // Catch: java.lang.Throwable -> L4c
        L4c:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.fdt.utils.ANEProxy.jc(java.lang.String):java.lang.String");
    }

    public static synchronized String jd(String str) {
        String jad_dq;
        synchronized (ANEProxy.class) {
            jad_dq = ANE.jad_dq(str);
        }
        return jad_dq;
    }

    public static synchronized String je(String str) {
        String jad_bo;
        synchronized (ANEProxy.class) {
            jad_bo = ANE.jad_bo(str);
        }
        return jad_bo;
    }
}
