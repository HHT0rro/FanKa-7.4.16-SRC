package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.cons.b;
import com.huawei.openalliance.ad.constant.as;
import java.util.HashMap;
import java.util.Map;
import z.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        String a10;
        synchronized (SecurityClientMobile.class) {
            HashMap hashMap = new HashMap();
            hashMap.put(b.f4545g, a.c(map, b.f4545g, ""));
            hashMap.put("tid", a.c(map, "tid", ""));
            hashMap.put(as.f32242q, a.c(map, as.f32242q, ""));
            APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
            a10 = com.alipay.apmobilesecuritysdk.a.a.a(context);
        }
        return a10;
    }
}
