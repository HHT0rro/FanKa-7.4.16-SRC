package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.push.ew;
import com.xiaomi.push.g7;
import com.xiaomi.push.hv;
import com.xiaomi.push.ia;
import com.xiaomi.push.ip;
import com.xiaomi.push.jb;
import com.xiaomi.push.o6;
import com.xiaomi.push.x3;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class z0 {
    public static void a(Context context, Intent intent, Uri uri) {
        x3 b4;
        ew ewVar;
        if (context == null) {
            return;
        }
        h0.g(context).l();
        if (x3.b(context.getApplicationContext()).c() == null) {
            x3.b(context.getApplicationContext()).l(o0.c(context.getApplicationContext()).d(), context.getPackageName(), kc.j.d(context.getApplicationContext()).a(hv.AwakeInfoUploadWaySwitch.a(), 0), new p0());
            kc.j.d(context).h(new b1(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            b4 = x3.b(context.getApplicationContext());
            ewVar = ew.ACTIVITY;
        } else {
            if (!(context instanceof Service) || intent == null) {
                if (uri == null || TextUtils.isEmpty(uri.toString())) {
                    return;
                }
                x3.b(context.getApplicationContext()).h(ew.PROVIDER, context, null, uri.toString());
                return;
            }
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                b4 = x3.b(context.getApplicationContext());
                ewVar = ew.SERVICE_COMPONENT;
            } else {
                b4 = x3.b(context.getApplicationContext());
                ewVar = ew.SERVICE_ACTION;
            }
        }
        b4.h(ewVar, context, intent, null);
    }

    public static void b(Context context, ip ipVar) {
        boolean i10 = kc.j.d(context).i(hv.AwakeAppPingSwitch.a(), false);
        int a10 = kc.j.d(context).a(hv.AwakeAppPingFrequency.a(), 0);
        if (a10 >= 0 && a10 < 30) {
            fc.c.m("aw_ping: frquency need > 30s.");
            a10 = 30;
        }
        boolean z10 = a10 >= 0 ? i10 : false;
        if (!g7.f()) {
            c(context, ipVar, z10, a10);
        } else if (z10) {
            com.xiaomi.push.n.c(context.getApplicationContext()).k(new a1(ipVar, context), a10);
        }
    }

    public static final <T extends jb<T, ?>> void c(Context context, T t2, boolean z10, int i10) {
        byte[] c4 = o6.c(t2);
        if (c4 == null) {
            fc.c.i("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z10);
        intent.putExtra("extra_help_ping_frequency", i10);
        intent.putExtra("mipush_payload", c4);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        h0.g(context).o(intent);
    }

    public static void d(Context context, String str) {
        fc.c.i("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put("description", "ping message");
        ip ipVar = new ip();
        ipVar.b(o0.c(context).d());
        ipVar.d(context.getPackageName());
        ipVar.c(ia.AwakeAppResponse.f329a);
        ipVar.a(kc.m.a());
        ipVar.f468a = hashMap;
        b(context, ipVar);
    }

    public static void e(Context context, String str, int i10, String str2) {
        ip ipVar = new ip();
        ipVar.b(str);
        ipVar.a(new HashMap());
        ipVar.m3017a().put("extra_aw_app_online_cmd", String.valueOf(i10));
        ipVar.m3017a().put("extra_help_aw_info", str2);
        ipVar.a(kc.m.a());
        byte[] c4 = o6.c(ipVar);
        if (c4 == null) {
            fc.c.i("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", c4);
        h0.g(context).o(intent);
    }
}
