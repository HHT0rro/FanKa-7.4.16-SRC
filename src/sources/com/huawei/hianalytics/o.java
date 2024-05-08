package com.huawei.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.log.LogTag;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class o {
    public static final String lmn = LogTag.get(o.class, new Class[0]);

    public static String ikl(Context context, String str, String str2) {
        w lmn2 = d.lmn(str, str2);
        if (!TextUtils.isEmpty(lmn2 != null ? lmn2.ijk : "")) {
            w lmn3 = d.lmn(str, str2);
            return lmn3 != null ? lmn3.ijk : "";
        }
        e eVar = c.klm().lmn;
        if (TextUtils.isEmpty(eVar.f28746c)) {
            String klm = l.klm(context);
            eVar.f28746c = i0.lmn(TTLiveConstants.INIT_CHANNEL, klm, 256) ? klm : "";
        }
        return eVar.f28746c;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String klm(java.lang.String r4, java.lang.String r5) {
        /*
            com.huawei.hianalytics.w r0 = com.huawei.hianalytics.d.lmn(r4, r5)
            java.lang.String r1 = ""
            if (r0 == 0) goto Lb
            java.lang.String r0 = r0.f28848b
            goto Lc
        Lb:
            r0 = r1
        Lc:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L6c
            com.huawei.hianalytics.w r0 = com.huawei.hianalytics.d.lmn(r4, r5)
            if (r0 == 0) goto L1b
            boolean r0 = r0.bcd
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 == 0) goto L6d
            com.huawei.hianalytics.w r0 = com.huawei.hianalytics.d.lmn(r4, r5)
            if (r0 == 0) goto L27
            java.lang.String r0 = r0.lmn
            goto L28
        L27:
            r0 = r1
        L28:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L5c
            java.lang.String r0 = "global_v2"
            java.lang.String r1 = com.huawei.hianalytics.j0.lmn(r0, r4, r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L5b
            int r2 = r1.length()
            r3 = 32
            if (r2 <= r3) goto L52
            java.lang.String r2 = "HiAnalytics_Sdk_Uuid_Sp_Key"
            java.lang.String r2 = ua.a.d(r2, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L52
            com.huawei.hianalytics.j0.klm(r0, r4, r2)
            r1 = r2
        L52:
            com.huawei.hianalytics.w r4 = com.huawei.hianalytics.d.lmn(r4, r5)
            if (r4 == 0) goto L5d
            r4.lmn = r1
            goto L5d
        L5b:
            r0 = r1
        L5c:
            r1 = r0
        L5d:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L6d
            android.content.Context r4 = com.huawei.hianalytics.d.lmn()
            java.lang.String r1 = com.huawei.hianalytics.l.ghi(r4)
            goto L6d
        L6c:
            r1 = r0
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.o.klm(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String lmn(Context context, String str, String str2) {
        String str3;
        String str4;
        x klm = d.klm(str, str2);
        if (klm == null || (str3 = klm.fgh) == null) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str3)) {
            x klm2 = d.klm(str, str2);
            return (klm2 == null || (str4 = klm2.fgh) == null) ? "" : str4;
        }
        HiLog.i(lmn, "getAndroidId(): to getConfigByType()");
        x klm3 = d.klm(str, str2);
        if (!(klm3 != null && klm3.ijk)) {
            return "";
        }
        if (TextUtils.isEmpty(c.klm().lmn.hij)) {
            c.klm().lmn.hij = l.lmn(context);
        }
        return c.klm().lmn.hij;
    }

    public static String klm(Context context, String str, String str2) {
        if (FrameworkConstant.DataType.STRING_OPER.equals(str2)) {
            return ikl(context, str, str2);
        }
        if (FrameworkConstant.DataType.STRING_MAINT.equals(str2)) {
            return ikl(context, str, str2);
        }
        if (FrameworkConstant.DataType.STRING_DIFFPRIVACY.equals(str2)) {
            return ikl(context, str, str2);
        }
        if (FrameworkConstant.DataType.STRING_PREINS.equals(str2)) {
            return ikl(context, str, str2);
        }
        HiLog.w(lmn, "getChannel(): Invalid type: " + str2);
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String lmn(java.lang.String r4, java.lang.String r5) {
        /*
            com.huawei.hianalytics.w r0 = com.huawei.hianalytics.d.lmn(r4, r5)
            if (r0 == 0) goto L9
            boolean r0 = r0.bcd
            goto La
        L9:
            r0 = 0
        La:
            java.lang.String r1 = ""
            if (r0 == 0) goto L5c
            com.huawei.hianalytics.w r0 = com.huawei.hianalytics.d.lmn(r4, r5)
            if (r0 == 0) goto L17
            java.lang.String r0 = r0.lmn
            goto L18
        L17:
            r0 = r1
        L18:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L4c
            java.lang.String r0 = "global_v2"
            java.lang.String r1 = com.huawei.hianalytics.j0.lmn(r0, r4, r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L4b
            int r2 = r1.length()
            r3 = 32
            if (r2 <= r3) goto L42
            java.lang.String r2 = "HiAnalytics_Sdk_Uuid_Sp_Key"
            java.lang.String r2 = ua.a.d(r2, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L42
            com.huawei.hianalytics.j0.klm(r0, r4, r2)
            r1 = r2
        L42:
            com.huawei.hianalytics.w r4 = com.huawei.hianalytics.d.lmn(r4, r5)
            if (r4 == 0) goto L4d
            r4.lmn = r1
            goto L4d
        L4b:
            r0 = r1
        L4c:
            r1 = r0
        L4d:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L63
            android.content.Context r4 = com.huawei.hianalytics.d.lmn()
            java.lang.String r1 = com.huawei.hianalytics.l.ghi(r4)
            goto L63
        L5c:
            java.lang.String r4 = com.huawei.hianalytics.o.lmn
            java.lang.String r5 = "getSdkUUID is empty,UUID enable is false"
            com.huawei.hianalytics.core.log.HiLog.sw(r4, r5)
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.o.lmn(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void lmn(int i10) {
        c.klm().lmn.efg = i10;
    }

    public static void lmn(boolean z10) {
        Objects.requireNonNull(c.klm().lmn);
    }

    public static void lmn(String str) {
        c.klm().lmn.f28747d = str;
    }
}
