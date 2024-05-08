package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static e f30092b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Long> f30093c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Context f30094a;

    public static e a() {
        return b();
    }

    private static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            if (f30092b == null) {
                f30092b = new e();
            }
            eVar = f30092b;
        }
        return eVar;
    }

    private void b(Context context) {
        String str;
        String d10 = o.d(context);
        q0.a(d10);
        if (q1.b().a()) {
            String a10 = d.a(context, "global_v2", "app_ver", "");
            d.b(context, "global_v2", "app_ver", d10);
            q0.b(a10);
            if (!TextUtils.isEmpty(a10)) {
                if (a10.equals(d10)) {
                    return;
                }
                v.c("hmsSdk", "the appVers are different!");
                a().a("", "alltype", a10);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        v.c("hmsSdk", str);
    }

    public void a(Context context) {
        this.f30094a = context;
        b(context);
        s.c().b().h(o.a());
    }

    public void a(String str, int i10) {
        if (this.f30094a == null) {
            v.e("hmsSdk", "onReport() null context or SDK was not init.");
        } else {
            v.c("hmsSdk", "onReport: Before calling runtaskhandler()");
            a(str, n1.a(i10), q0.g());
        }
    }

    public void a(String str, int i10, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i10) {
            currentTimeMillis = n1.a("yyyy-MM-dd", currentTimeMillis);
        }
        b0.c().a(new a0(str2, jSONObject, str, n1.a(i10), currentTimeMillis));
    }

    public void a(String str, int i10, String str2, JSONObject jSONObject, long j10) {
        new i1(str, n1.a(i10), str2, jSONObject.toString(), j10).a();
    }

    public void a(String str, String str2) {
        if (!a1.a(str, str2)) {
            v.c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long j10 = a1.j(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j10 <= 30000) {
            v.f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        v.a("hmsSdk", "begin to call onReport!");
        a1.a(str, str2, currentTimeMillis);
        a(str, str2, q0.g());
    }

    public void a(String str, String str2, String str3) {
        Context context = this.f30094a;
        if (context == null) {
            v.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String b4 = r0.b(context);
        if (a1.e(str, str2) && !"WIFI".equals(b4)) {
            v.c("hmsSdk", "strNetworkType is :" + b4);
            return;
        }
        if ("unknown".equals(b4) || "none".equals(b4) || "2G".equals(b4)) {
            v.e("hmsSdk", "The network is bad.");
        } else {
            b0.c().a(new v0(str, str2, str3));
        }
    }
}
