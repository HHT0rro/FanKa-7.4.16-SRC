package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.g7;
import com.xiaomi.push.hq;
import com.xiaomi.push.ip;
import com.xiaomi.push.n6;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        if (g7.k()) {
            return;
        }
        context = MiPushClient.f46947b;
        if (n6.D(context) == null) {
            context8 = MiPushClient.f46947b;
            if (!com.xiaomi.push.d0.a(context8).mo2931a()) {
                return;
            }
        }
        ip ipVar = new ip();
        context2 = MiPushClient.f46947b;
        ipVar.b(o0.c(context2).d());
        ipVar.c("client_info_update");
        ipVar.a(kc.m.a());
        ipVar.a(new HashMap());
        String str = "";
        context3 = MiPushClient.f46947b;
        String D = n6.D(context3);
        if (!TextUtils.isEmpty(D)) {
            str = "" + com.xiaomi.push.p0.b(D);
        }
        context4 = MiPushClient.f46947b;
        String F = n6.F(context4);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(F)) {
            str = str + "," + F;
        }
        if (!TextUtils.isEmpty(str)) {
            ipVar.m3017a().put("imei_md5", str);
        }
        context5 = MiPushClient.f46947b;
        com.xiaomi.push.d0.a(context5).c(ipVar.m3017a());
        context6 = MiPushClient.f46947b;
        n6.k(context6, ipVar.f468a);
        int c4 = n6.c();
        if (c4 >= 0) {
            ipVar.m3017a().put("space_id", Integer.toString(c4));
        }
        context7 = MiPushClient.f46947b;
        h0.g(context7).v(ipVar, hq.Notification, false, null);
    }
}
