package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import com.huawei.openalliance.ad.constant.as;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (b.class) {
            hashMap = new HashMap();
            String c4 = z.a.c(map, "tid", "");
            String c10 = z.a.c(map, com.alipay.sdk.cons.b.f4545g, "");
            String c11 = z.a.c(map, as.f32242q, "");
            String c12 = z.a.c(map, "appName", "");
            String c13 = z.a.c(map, "appKeyClient", "");
            String c14 = z.a.c(map, "tmxSessionId", "");
            String f10 = h.f(context);
            String c15 = z.a.c(map, "sessionId", "");
            hashMap.put("AC1", c4);
            hashMap.put("AC2", c10);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f10);
            hashMap.put("AC5", c11);
            hashMap.put("AC6", c14);
            hashMap.put("AC7", "");
            hashMap.put("AC8", c12);
            hashMap.put("AC9", c13);
            if (z.a.g(c15)) {
                hashMap.put("AC10", c15);
            }
        }
        return hashMap;
    }
}
