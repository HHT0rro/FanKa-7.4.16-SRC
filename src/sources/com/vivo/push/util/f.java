package com.vivo.push.util;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ClientReportUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    public static boolean a(long j10, long j11) {
        u.d("ClientReportUtil", "report message: " + j10 + ", reportType: " + j11);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j11);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j10));
        String a10 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a10)) {
            hashMap.put("remoteAppId", a10);
        }
        xVar.a(hashMap);
        com.vivo.push.m.a().a(xVar);
        return true;
    }

    public static boolean a(long j10, HashMap<String, String> hashMap) {
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j10);
        xVar.a(hashMap);
        xVar.d();
        com.vivo.push.m.a().a(xVar);
        return true;
    }
}
