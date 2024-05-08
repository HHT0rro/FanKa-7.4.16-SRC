package com.jd.ad.sdk.jad_ob;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_sf.jad_an;

/* compiled from: JADUserInfoUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_hu {
    public static String jad_an(Context context) {
        String str = "";
        if (!jad_dq.jad_an.jad_an.jad_an(TTLiveConstants.BUNDLE_KEY)) {
            return "";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an(TTLiveConstants.BUNDLE_KEY, true)) {
            str = jad_anVar.jad_dq(TTLiveConstants.BUNDLE_KEY);
        } else if (context != null) {
            str = context.getPackageName();
            jad_anVar.jad_bo(TTLiveConstants.BUNDLE_KEY, str);
        }
        return str;
    }

    public static String jad_bo(Context context) {
        String str = "";
        if (!jad_dq.jad_an.jad_an.jad_an("carrier")) {
            return "";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("carrier", true)) {
            str = (String) jad_anVar.jad_bo("carrier");
        } else if (context != null) {
            str = com.jd.ad.sdk.jad_do.jad_jt.jad_bo(context);
            jad_anVar.jad_bo("carrier", str);
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        r0 = r3.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_cp(android.content.Context r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "processName"
            com.jd.ad.sdk.jad_ob.jad_dq r2 = com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an     // Catch: java.lang.Exception -> L66
            boolean r2 = r2.jad_an(r1)     // Catch: java.lang.Exception -> L66
            if (r2 != 0) goto Lf
            java.lang.String r5 = "jad_process_default"
            return r5
        Lf:
            boolean r2 = com.jd.ad.sdk.bl.initsdk.JADYunSdk.isSupportMultiProcess()     // Catch: java.lang.Exception -> L66
            if (r2 != 0) goto L1a
            java.lang.String r5 = jad_an(r5)     // Catch: java.lang.Exception -> L66
            return r5
        L1a:
            com.jd.ad.sdk.jad_sf.jad_an r2 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L66
            r3 = 1
            boolean r3 = r2.jad_an(r1, r3)     // Catch: java.lang.Exception -> L66
            if (r3 == 0) goto L28
            java.lang.String r0 = r2.jad_dq(r1)     // Catch: java.lang.Exception -> L66
            goto L6a
        L28:
            if (r5 == 0) goto L6a
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L56
            java.lang.String r3 = "activity"
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch: java.lang.Exception -> L56
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch: java.lang.Exception -> L56
            java.util.List r5 = r5.getRunningAppProcesses()     // Catch: java.lang.Exception -> L56
            if (r5 == 0) goto L5a
            java.util.Iterator r5 = r5.iterator2()     // Catch: java.lang.Exception -> L56
        L40:
            boolean r3 = r5.hasNext()     // Catch: java.lang.Exception -> L56
            if (r3 == 0) goto L5a
            java.lang.Object r3 = r5.next()     // Catch: java.lang.Exception -> L56
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Exception -> L56
            if (r3 == 0) goto L40
            int r4 = r3.pid     // Catch: java.lang.Exception -> L56
            if (r4 != r2) goto L40
            java.lang.String r5 = r3.processName     // Catch: java.lang.Exception -> L56
            r0 = r5
            goto L5a
        L56:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Exception -> L66
        L5a:
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L66
            if (r5 != 0) goto L6a
            com.jd.ad.sdk.jad_sf.jad_an r5 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L66
            r5.jad_bo(r1, r0)     // Catch: java.lang.Exception -> L66
            goto L6a
        L66:
            r5 = move-exception
            r5.printStackTrace()
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ob.jad_hu.jad_cp(android.content.Context):java.lang.String");
    }

    public static boolean jad_dq(Context context) {
        if (!jad_dq.jad_an.jad_an.jad_an("processName") || !JADYunSdk.isSupportMultiProcess()) {
            return true;
        }
        String jad_cp = jad_cp(context);
        String jad_an = jad_an(context);
        if (TextUtils.isEmpty(jad_an)) {
            jad_an = context.getPackageName();
        }
        if (!TextUtils.isEmpty(jad_an) && !TextUtils.isEmpty(jad_cp)) {
            if (!jad_an.equals(jad_cp)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_an() {
        /*
            java.lang.String r0 = ""
            com.jd.ad.sdk.jad_ob.jad_dq r1 = com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = r1.jad_bo     // Catch: java.lang.Exception -> L2d
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L2d
            if (r2 != 0) goto Lf
            java.lang.String r1 = r1.jad_bo     // Catch: java.lang.Exception -> L2d
            goto L25
        Lf:
            com.jd.ad.sdk.jad_sf.jad_an r2 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an     // Catch: java.lang.Exception -> L2d
            java.lang.String r3 = "didCustom"
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Object r2 = r2.jad_an(r3, r4)     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L2d
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L2d
            if (r3 != 0) goto L24
            r1.jad_bo = r2     // Catch: java.lang.Exception -> L2d
            goto L26
        L24:
            r1 = r0
        L25:
            r2 = r1
        L26:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L2d
            if (r1 != 0) goto L2d
            r0 = r2
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ob.jad_hu.jad_an():java.lang.String");
    }

    public static String jad_bo() {
        try {
            jad_dq jad_dqVar = jad_dq.jad_an.jad_an;
            if (!jad_dqVar.jad_an("oidCustom")) {
                return "";
            }
            String jad_bo = jad_dqVar.jad_bo();
            try {
                if (TextUtils.isEmpty(jad_bo)) {
                    return "";
                }
            } catch (Exception unused) {
            }
            return jad_bo;
        } catch (Exception unused2) {
            return "";
        }
    }
}
