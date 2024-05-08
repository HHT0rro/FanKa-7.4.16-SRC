package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class f0 {
    public static String lmn;

    public static boolean lmn() {
        String str = c.klm().lmn.f28754k;
        if (TextUtils.isEmpty(str)) {
            str = j0.lmn("Privacy_MY", "public_key_time_interval", "");
            c.klm().lmn.f28754k = str;
        }
        String str2 = c.klm().lmn.f28755l;
        if (TextUtils.isEmpty(str2)) {
            str2 = j0.lmn("Privacy_MY", "public_key_time_last", "");
            c.klm().lmn.f28755l = str2;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        try {
            return System.currentTimeMillis() - Long.parseLong(str2) > ((long) Integer.parseInt(str));
        } catch (NumberFormatException e2) {
            StringBuilder b4 = e9.a.b("checkCachePubKey NumberFormatException :");
            b4.append(e2.getMessage());
            HiLog.sw("GetPublicKey", b4.toString());
            return true;
        }
    }
}
