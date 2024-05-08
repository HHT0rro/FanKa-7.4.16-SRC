package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.huawei.quickcard.base.Attributes;
import com.mobile.auth.n.f;
import com.mobile.auth.n.k;
import com.mobile.auth.n.m;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private com.cmic.sso.sdk.a f11456a;

    private static void a(b bVar, com.cmic.sso.sdk.a aVar) {
        if (bVar == null || aVar == null) {
            return;
        }
        bVar.b(aVar.b("appid", ""));
        bVar.f(m.a());
        bVar.i(aVar.b("interfaceType", ""));
        bVar.h(aVar.b("interfaceCode", ""));
        bVar.g(aVar.b("interfaceElasped", ""));
        bVar.l(aVar.b(CardEventType.ACTION_TIME_OUT));
        bVar.s(aVar.b("traceId"));
        bVar.v(aVar.b("networkClass"));
        bVar.n(aVar.b("simCardNum"));
        bVar.o(aVar.b("operatortype"));
        bVar.p(m.b());
        bVar.q(m.c());
        bVar.y(String.valueOf(aVar.b("networktype", 0)));
        bVar.t(aVar.b("starttime"));
        bVar.w(aVar.b("endtime"));
        bVar.m(String.valueOf(aVar.b("systemEndTime", 0L) - aVar.b("systemStartTime", 0L)));
        bVar.d(aVar.b("imsiState"));
        bVar.z(k.b("AID", ""));
        bVar.A(aVar.b("operatortype"));
        bVar.B(aVar.b("scripType"));
        com.mobile.auth.n.c.a("SendLog", "traceId" + aVar.b("traceId"));
    }

    private void a(JSONObject jSONObject) {
        com.mobile.auth.l.a.a().a(jSONObject, this.f11456a, new com.mobile.auth.l.d() { // from class: com.cmic.sso.sdk.d.d.1
            @Override // com.mobile.auth.l.d
            public void a(String str, String str2, JSONObject jSONObject2) {
                long j10;
                com.mobile.auth.f.a b4 = d.this.f11456a.b();
                HashMap hashMap = new HashMap();
                if (!str.equals("103000")) {
                    if (b4.l() != 0 && b4.k() != 0) {
                        int a10 = k.a("logFailTimes", 0) + 1;
                        if (a10 >= b4.k()) {
                            hashMap.put("logFailTimes", 0);
                            j10 = System.currentTimeMillis();
                        } else {
                            hashMap.put("logFailTimes", Integer.valueOf(a10));
                        }
                    }
                    k.a(hashMap);
                }
                hashMap.put("logFailTimes", 0);
                j10 = 0;
                hashMap.put("logCloseTime", Long.valueOf(j10));
                k.a(hashMap);
            }
        });
    }

    public void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        String str2 = "";
        try {
            b a10 = aVar.a();
            String b4 = f.b(context);
            a10.e(str);
            a10.x(aVar.b("loginMethod", ""));
            a10.r(aVar.b("isCacheScrip", false) ? "scrip" : "pgw");
            a10.j(f.a(context));
            if (!TextUtils.isEmpty(b4)) {
                str2 = b4;
            }
            a10.k(str2);
            a10.c(aVar.b("hsaReadPhoneStatePermission", false) ? "1" : "0");
            a(a10, aVar);
            JSONArray jSONArray = null;
            if (a10.f11427a.size() > 0) {
                jSONArray = new JSONArray();
                Iterator<Throwable> iterator2 = a10.f11427a.iterator2();
                while (iterator2.hasNext()) {
                    Throwable next = iterator2.next();
                    StringBuffer stringBuffer = new StringBuffer();
                    JSONObject jSONObject = new JSONObject();
                    for (StackTraceElement stackTraceElement : next.getStackTrace()) {
                        stringBuffer.append("\n");
                        stringBuffer.append(stackTraceElement.toString());
                    }
                    jSONObject.put("message", next.toString());
                    jSONObject.put(Attributes.Component.STACK, stringBuffer.toString());
                    jSONArray.put(jSONObject);
                }
                a10.f11427a.clear();
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                a10.a(jSONArray);
            }
            com.mobile.auth.n.c.a("SendLog", "登录日志");
            a(a10.b(), aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar) {
        this.f11456a = aVar;
        a(jSONObject);
    }
}
