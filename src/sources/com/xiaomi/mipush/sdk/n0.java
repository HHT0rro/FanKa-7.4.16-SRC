package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.g7;
import com.xiaomi.push.hq;
import com.xiaomi.push.i7;
import com.xiaomi.push.ia;
import com.xiaomi.push.ip;
import com.xiaomi.push.n6;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f47043b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f47044c;

    public n0(Context context, boolean z10) {
        this.f47043b = context;
        this.f47044c = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        String g3;
        String g10;
        Map<String, String> map;
        String g11;
        String str;
        String f10;
        String f11;
        fc.c.i("do sync info");
        ip ipVar = new ip(kc.m.a(), false);
        o0 c4 = o0.c(this.f47043b);
        ipVar.c(ia.SyncInfo.f329a);
        ipVar.b(c4.d());
        ipVar.d(this.f47043b.getPackageName());
        HashMap hashMap = new HashMap();
        ipVar.f468a = hashMap;
        Context context = this.f47043b;
        i7.c(hashMap, "app_version", com.xiaomi.push.g.e(context, context.getPackageName()));
        Map<String, String> map2 = ipVar.f468a;
        Context context2 = this.f47043b;
        i7.c(map2, "app_version_code", Integer.toString(com.xiaomi.push.g.a(context2, context2.getPackageName())));
        i7.c(ipVar.f468a, "push_sdk_vn", "3_7_6");
        i7.c(ipVar.f468a, "push_sdk_vc", Integer.toString(30706));
        i7.c(ipVar.f468a, "token", c4.m());
        n6.k(this.f47043b, ipVar.f468a);
        if (!g7.k()) {
            String b4 = com.xiaomi.push.p0.b(n6.D(this.f47043b));
            String F = n6.F(this.f47043b);
            if (!TextUtils.isEmpty(F)) {
                b4 = b4 + "," + F;
            }
            if (!TextUtils.isEmpty(b4)) {
                i7.c(ipVar.f468a, "imei_md5", b4);
            }
        }
        com.xiaomi.push.d0.a(this.f47043b).c(ipVar.f468a);
        i7.c(ipVar.f468a, "reg_id", c4.q());
        i7.c(ipVar.f468a, "reg_secret", c4.t());
        i7.c(ipVar.f468a, "accept_time", MiPushClient.u(this.f47043b).replace(",", "-"));
        if (this.f47044c) {
            Map<String, String> map3 = ipVar.f468a;
            f10 = m0.f(MiPushClient.v(this.f47043b));
            i7.c(map3, "aliases_md5", f10);
            Map<String, String> map4 = ipVar.f468a;
            f11 = m0.f(MiPushClient.w(this.f47043b));
            i7.c(map4, "topics_md5", f11);
            map = ipVar.f468a;
            g11 = m0.f(MiPushClient.x(this.f47043b));
            str = "accounts_md5";
        } else {
            Map<String, String> map5 = ipVar.f468a;
            g3 = m0.g(MiPushClient.v(this.f47043b));
            i7.c(map5, "aliases", g3);
            Map<String, String> map6 = ipVar.f468a;
            g10 = m0.g(MiPushClient.w(this.f47043b));
            i7.c(map6, "topics", g10);
            map = ipVar.f468a;
            g11 = m0.g(MiPushClient.x(this.f47043b));
            str = "user_accounts";
        }
        i7.c(map, str, g11);
        h0.g(this.f47043b).v(ipVar, hq.Notification, false, null);
    }
}
