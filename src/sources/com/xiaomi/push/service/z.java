package com.xiaomi.push.service;

import android.content.Context;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.n7;
import com.xiaomi.push.service.aq;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public final String f48360a;

    /* renamed from: b, reason: collision with root package name */
    public final String f48361b;

    /* renamed from: c, reason: collision with root package name */
    public final String f48362c;

    /* renamed from: d, reason: collision with root package name */
    public final String f48363d;

    /* renamed from: e, reason: collision with root package name */
    public final String f48364e;

    /* renamed from: f, reason: collision with root package name */
    public final String f48365f;

    /* renamed from: g, reason: collision with root package name */
    public final int f48366g;

    public z(String str, String str2, String str3, String str4, String str5, String str6, int i10) {
        this.f48360a = str;
        this.f48361b = str2;
        this.f48362c = str3;
        this.f48363d = str4;
        this.f48364e = str5;
        this.f48365f = str6;
        this.f48366g = i10;
    }

    public static boolean c() {
        try {
            return n7.c(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && c();
    }

    public static boolean e(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public aq.b a(XMPushService xMPushService) {
        aq.b bVar = new aq.b(xMPushService);
        b(bVar, xMPushService, xMPushService.N(), "c");
        return bVar;
    }

    public aq.b b(aq.b bVar, Context context, v vVar, String str) {
        bVar.f48222a = context.getPackageName();
        bVar.f48223b = this.f48360a;
        bVar.f48230i = this.f48362c;
        bVar.f48224c = this.f48361b;
        bVar.f48229h = "5";
        bVar.f48225d = "XMPUSH-PASS";
        bVar.f48226e = false;
        bVar.f48227f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s", HiAnalyticsConstant.BI_KEY_SDK_VER, 39, "cpvn", "3_7_6", "cpvc", 30706, "aapn", e(context) ? com.xiaomi.push.g.h(context) : "", "country_code", kc.a.c(context).f(), AgConnectInfo.AgConnectKey.REGION, kc.a.c(context).a());
        bVar.f48228g = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", "appid", e(context) ? "1000271" : this.f48363d, "locale", Locale.getDefault().toString(), "miid", n7.e(context));
        if (d(context)) {
            bVar.f48228g += String.format(",%1$s:%2$s", "ab", str);
        }
        bVar.f48232k = vVar;
        return bVar;
    }
}
