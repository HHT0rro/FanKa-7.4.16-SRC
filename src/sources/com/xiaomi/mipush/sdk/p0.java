package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.a4;
import com.xiaomi.push.hq;
import com.xiaomi.push.ia;
import com.xiaomi.push.ip;
import com.xiaomi.push.s3;
import com.xiaomi.push.x3;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class p0 implements a4 {
    @Override // com.xiaomi.push.a4
    public void a(Context context, HashMap<String, String> hashMap) {
        ip ipVar = new ip();
        ipVar.b(x3.b(context).d());
        ipVar.d(x3.b(context).n());
        ipVar.c(ia.AwakeAppResponse.f329a);
        ipVar.a(kc.m.a());
        ipVar.f468a = hashMap;
        h0.g(context).w(ipVar, hq.Notification, true, null, true);
        fc.c.i("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.a4
    public void b(Context context, HashMap<String, String> hashMap) {
        fc.c.i("MoleInfo：\u3000" + s3.e(hashMap));
        String str = hashMap.get("event_type");
        String str2 = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(str)) {
            z0.d(context, str2);
        }
    }

    @Override // com.xiaomi.push.a4
    public void c(Context context, HashMap<String, String> hashMap) {
        n.b("category_awake_app", "wake_up_app", 1L, s3.c(hashMap));
        fc.c.i("MoleInfo：\u3000send data in app layer");
    }
}
