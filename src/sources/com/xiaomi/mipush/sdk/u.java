package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.openalliance.ad.constant.bg;
import com.vivo.push.PushClientConstants;
import com.xiaomi.push.g7;
import com.xiaomi.push.n6;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class u {
    public static HashMap<String, String> a(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("appToken", o0.c(context).m());
            hashMap.put("regId", MiPushClient.D(context));
            hashMap.put("appId", o0.c(context).d());
            hashMap.put("regResource", o0.c(context).v());
            if (!g7.k()) {
                String E = n6.E(context);
                if (!TextUtils.isEmpty(E)) {
                    hashMap.put("imeiMd5", com.xiaomi.push.p0.b(E));
                }
            }
            hashMap.put("isMIUI", String.valueOf(g7.f()));
            hashMap.put("miuiVersion", g7.c());
            hashMap.put("devId", n6.i(context, true));
            hashMap.put(bk.f9900i, Build.MODEL);
            hashMap.put(PushClientConstants.TAG_PKG_NAME, context.getPackageName());
            hashMap.put(bg.e.Code, "3_7_6");
            hashMap.put("androidVersion", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            hashMap.put("andId", n6.C(context));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("clientInterfaceId", str);
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }
}
