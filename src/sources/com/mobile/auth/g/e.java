package com.mobile.auth.g;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.mobile.auth.n.g;
import com.mobile.auth.n.h;
import com.mobile.auth.n.j;
import com.mobile.auth.n.k;
import com.mobile.auth.n.m;
import com.mobile.auth.n.n;
import com.mobile.auth.n.o;
import com.mobile.auth.n.q;
import com.mobile.auth.n.r;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    private static e f36818f;

    /* renamed from: a, reason: collision with root package name */
    public final c f36819a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f36820b;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f36822d;

    /* renamed from: e, reason: collision with root package name */
    public String f36823e;

    /* renamed from: c, reason: collision with root package name */
    public long f36821c = 8000;

    /* renamed from: g, reason: collision with root package name */
    private final Object f36824g = new Object();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final com.cmic.sso.sdk.a f36842b;

        public a(com.cmic.sso.sdk.a aVar) {
            this.f36842b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a10 = (r.a(e.this.f36820b).a() || !this.f36842b.b("doNetworkSwitch", false)) ? f.a("200023", "登录超时") : f.a("102508", "数据网络切换失败");
            e.this.a(a10.optString("resultCode", "200023"), a10.optString("resultString", "登录超时"), this.f36842b, a10);
        }
    }

    public e(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f36820b = applicationContext;
        this.f36822d = new Handler(applicationContext.getMainLooper());
        this.f36819a = c.a(applicationContext);
        r.a(applicationContext);
        k.a(applicationContext);
        j.a(applicationContext);
        n.a(new n.a() { // from class: com.mobile.auth.g.e.1
            @Override // com.mobile.auth.n.n.a
            public void a() {
                String b4 = k.b("AID", "");
                com.mobile.auth.n.c.b("AuthnHelperCore", "aid = " + b4);
                if (TextUtils.isEmpty(b4)) {
                    e.this.a();
                }
                com.mobile.auth.n.c.b("AuthnHelperCore", com.mobile.auth.n.b.a(e.this.f36820b, true) ? "生成androidkeystore成功" : "生成androidkeystore失败");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String str = "%" + q.b();
        com.mobile.auth.n.c.b("AuthnHelperCore", "generate aid = " + str);
        k.a("AID", str);
    }

    private void a(final Context context, final String str, final com.cmic.sso.sdk.a aVar) {
        n.a(new n.a() { // from class: com.mobile.auth.g.e.5
            @Override // com.mobile.auth.n.n.a
            public void a() {
                if ("200023".equals(str)) {
                    SystemClock.sleep(8000L);
                }
                new com.cmic.sso.sdk.d.d().a(context, str, aVar);
            }
        });
    }

    public static void a(boolean z10) {
        com.mobile.auth.n.c.a(z10);
    }

    public static e b(Context context) {
        if (f36818f == null) {
            synchronized (e.class) {
                if (f36818f == null) {
                    f36818f = new e(context);
                }
            }
        }
        return f36818f;
    }

    public com.cmic.sso.sdk.a a(b bVar) {
        com.cmic.sso.sdk.a aVar = new com.cmic.sso.sdk.a(64);
        String c4 = q.c();
        aVar.a(new com.cmic.sso.sdk.d.b());
        aVar.a("traceId", c4);
        com.mobile.auth.n.c.a("traceId", c4);
        if (bVar != null) {
            com.mobile.auth.n.e.a(c4, bVar);
        }
        return aVar;
    }

    public void a(long j10) {
        this.f36821c = j10;
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        final a aVar2 = new a(aVar);
        this.f36822d.postDelayed(aVar2, this.f36821c);
        this.f36819a.a(aVar, new d() { // from class: com.mobile.auth.g.e.3
            @Override // com.mobile.auth.g.d
            public void a(String str, String str2, com.cmic.sso.sdk.a aVar3, JSONObject jSONObject) {
                e.this.f36822d.removeCallbacks(aVar2);
                e.this.a(str, str2, aVar3, jSONObject);
            }
        });
    }

    public void a(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        try {
            String b4 = aVar.b("traceId");
            final int b10 = aVar.b("SDKRequestCode", -1);
            if (com.mobile.auth.n.e.a(b4)) {
                return;
            }
            synchronized (this) {
                final b c4 = com.mobile.auth.n.e.c(b4);
                if (jSONObject == null || !jSONObject.optBoolean("keepListener", false)) {
                    com.mobile.auth.n.e.b(b4);
                }
                if (c4 == null) {
                    return;
                }
                aVar.a("systemEndTime", SystemClock.elapsedRealtime());
                aVar.a("endtime", o.a());
                int c10 = aVar.c("logintype");
                if (jSONObject == null) {
                    jSONObject = f.a(str, str2);
                }
                final JSONObject a10 = c10 == 3 ? f.a(str, aVar, jSONObject) : f.a(str, str2, aVar, jSONObject);
                a10.put("scripExpiresIn", String.valueOf(h.a()));
                this.f36822d.post(new Runnable() { // from class: com.mobile.auth.g.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c4.a(b10, a10);
                    }
                });
                com.mobile.auth.f.c.a(this.f36820b).a(aVar);
                if (!aVar.b().j() && !q.a(aVar.b())) {
                    a(this.f36820b, str, aVar);
                }
                if (com.mobile.auth.n.e.a()) {
                    r.a(this.f36820b).b();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(final String str, final String str2, final b bVar) {
        final com.cmic.sso.sdk.a a10 = a(bVar);
        n.a(new n.a(this.f36820b, a10) { // from class: com.mobile.auth.g.e.2
            @Override // com.mobile.auth.n.n.a
            public void a() {
                if (e.this.a(a10, str, str2, "mobileAuth", 0, bVar)) {
                    e.this.a(a10);
                }
            }
        });
    }

    public boolean a(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i10, b bVar) {
        boolean a10;
        String str4;
        String str5;
        com.mobile.auth.f.a a11 = com.mobile.auth.f.c.a(this.f36820b).a();
        aVar.a(a11);
        aVar.a("use2048PublicKey", "rsa2048".equals(this.f36823e));
        aVar.a("systemStartTime", SystemClock.elapsedRealtime());
        aVar.a("starttime", o.a());
        aVar.a("loginMethod", str3);
        aVar.a(com.alipay.sdk.sys.a.f4665f, str2);
        aVar.a("appid", str);
        aVar.a(CardEventType.ACTION_TIME_OUT, String.valueOf(this.f36821c));
        boolean a12 = g.a(this.f36820b, com.kuaishou.weapon.p0.g.f36117c);
        com.mobile.auth.n.c.a("AuthnHelperCore", "有READ_PHONE_STATE权限？" + a12);
        aVar.a("hsaReadPhoneStatePermission", a12);
        boolean a13 = m.a(this.f36820b);
        com.mobile.auth.h.a.a().a(this.f36820b, a12, a13);
        aVar.a("networkClass", com.mobile.auth.h.a.a().a(this.f36820b));
        String b4 = j.a().b();
        String c4 = j.a().c();
        String a14 = j.a().a(c4);
        aVar.a("operator", c4);
        aVar.a("operatortype", a14);
        aVar.a("logintype", i10);
        com.mobile.auth.n.c.b("AuthnHelperCore", "subId = " + b4);
        if (!TextUtils.isEmpty(b4)) {
            com.mobile.auth.n.c.a("AuthnHelperCore", "使用subId作为缓存key = " + b4);
            aVar.a("scripType", "subid");
            aVar.a("scripKey", b4);
        } else if (!TextUtils.isEmpty(c4)) {
            com.mobile.auth.n.c.a("AuthnHelperCore", "使用operator作为缓存key = " + c4);
            aVar.a("scripType", "operator");
            aVar.a("scripKey", c4);
        }
        int a15 = m.a(this.f36820b, a13);
        aVar.a("networktype", a15);
        if (!a13) {
            aVar.a("authType", String.valueOf(0));
            str4 = "200010";
            str5 = "无法识别sim卡或没有sim卡";
        } else if (bVar == null) {
            str4 = "102203";
            str5 = "listener不能为空";
        } else {
            if (!a11.g()) {
                if (TextUtils.isEmpty(str == null ? "" : str.trim())) {
                    str4 = "102203";
                    str5 = "appId 不能为空";
                } else {
                    if (TextUtils.isEmpty(str2 == null ? "" : str2.trim())) {
                        str4 = "102203";
                        str5 = "appkey不能为空";
                    } else if (a15 == 0) {
                        str4 = "102101";
                        str5 = "未检测到网络";
                    } else if ((!"2".equals(a14) || !a11.f()) && (!"3".equals(a14) || !a11.e())) {
                        synchronized (this.f36824g) {
                            a10 = h.a(aVar);
                            if (a10) {
                                aVar.a("securityphone", k.b("securityphone", ""));
                                if (3 != i10) {
                                    String a16 = h.a(this.f36820b);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("解密phoneScript ");
                                    sb2.append(!TextUtils.isEmpty(a16));
                                    com.mobile.auth.n.c.b("AuthnHelperCore", sb2.toString());
                                    if (TextUtils.isEmpty(a16)) {
                                        a10 = false;
                                    } else {
                                        aVar.a("phonescrip", a16);
                                    }
                                    h.a(true, false);
                                }
                            }
                            aVar.a("isCacheScrip", a10);
                            com.mobile.auth.n.c.b("AuthnHelperCore", "isCachePhoneScrip = " + a10);
                        }
                        if (a15 != 2 || a10) {
                            return true;
                        }
                        str4 = "102103";
                        str5 = "无数据网络";
                    }
                }
            }
            str4 = "200082";
            str5 = "服务器繁忙，请稍后重试";
        }
        a(str4, str5, aVar, null);
        return false;
    }

    public JSONObject c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                boolean a10 = m.a(this.f36820b);
                com.mobile.auth.h.a.a().a(context, g.a(context, com.kuaishou.weapon.p0.g.f36117c), a10);
                String a11 = j.a().a((String) null);
                int a12 = m.a(context, a10);
                jSONObject.put("operatortype", a11);
                jSONObject.put("networktype", a12 + "");
                com.mobile.auth.n.c.b("AuthnHelperCore", "网络类型: " + a12);
                com.mobile.auth.n.c.b("AuthnHelperCore", "运营商类型: " + a11);
                return jSONObject;
            } catch (Exception unused) {
                jSONObject.put("errorDes", "发生未知错误");
                return jSONObject;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public void d() {
        try {
            h.a(true, true);
            com.mobile.auth.n.c.b("AuthnHelperCore", "删除scrip");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
