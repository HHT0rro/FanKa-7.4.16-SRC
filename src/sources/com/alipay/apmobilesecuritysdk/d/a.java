package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (a.class) {
            String c4 = z.a.c(map, "appchannel", "");
            hashMap = new HashMap();
            hashMap.put("AA1", context.getPackageName());
            b0.a.a();
            hashMap.put("AA2", b0.a.b(context));
            hashMap.put("AA3", "APPSecuritySDK-ALIPAY");
            hashMap.put("AA4", "3.2.2-20180331");
            hashMap.put("AA6", c4);
        }
        return hashMap;
    }
}
