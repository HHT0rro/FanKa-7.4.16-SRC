package com.mobile.auth.f;

import android.text.TextUtils;
import com.mobile.auth.BuildConfig;
import com.mobile.auth.f.a;
import com.mobile.auth.n.k;
import com.mobile.auth.n.n;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static b f36789c;

    /* renamed from: a, reason: collision with root package name */
    private com.mobile.auth.f.a f36790a;

    /* renamed from: b, reason: collision with root package name */
    private final com.mobile.auth.f.a f36791b;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f36792d = false;

    /* renamed from: e, reason: collision with root package name */
    private a f36793e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(com.mobile.auth.f.a aVar);
    }

    private b(boolean z10) {
        com.mobile.auth.f.a a10 = new a.C0556a().a();
        this.f36791b = a10;
        if (z10) {
            this.f36790a = a10;
        } else {
            this.f36790a = d();
        }
    }

    public static b a(boolean z10) {
        if (f36789c == null) {
            synchronized (b.class) {
                if (f36789c == null) {
                    f36789c = new b(z10);
                }
            }
        }
        return f36789c;
    }

    private String a(String str, String str2) {
        String str3;
        String[] split = str.split("&");
        int length = split.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str3 = "";
                break;
            }
            str3 = split[i10];
            if (str3.contains(str2)) {
                break;
            }
            i10++;
        }
        return !TextUtils.isEmpty(str3) ? str3.substring(str3.lastIndexOf("=") + 1) : str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        k.a b4 = k.b("sso_config_xf");
        try {
            if (jSONObject.has("client_valid")) {
                b4.a("client_valid", System.currentTimeMillis() + (Integer.parseInt(jSONObject.getString("client_valid")) * 60 * 60 * 1000));
            }
            if (jSONObject.has("Configlist")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("Configlist");
                if (jSONObject2.has("CHANGE_HOST")) {
                    String string = jSONObject2.getString("CHANGE_HOST");
                    if (string.contains("M007")) {
                        String a10 = a(string, "M007");
                        if (!TextUtils.isEmpty(a10)) {
                            b4.a("logHost", a10);
                        }
                    }
                    if (string.contains("M008")) {
                        String a11 = a(string, "M008");
                        if (!TextUtils.isEmpty(a11)) {
                            b4.a("https_get_phone_scrip_host", a11);
                        }
                    }
                    if (string.contains("M009")) {
                        String a12 = a(string, "M009");
                        if (!TextUtils.isEmpty(a12)) {
                            b4.a("config_host", a12);
                        }
                    }
                } else {
                    b4.a("logHost");
                    b4.a("https_get_phone_scrip_host");
                    b4.a("config_host");
                }
                a(jSONObject2, "CLOSE_FRIEND_WAPKS", "0", b4);
                a(jSONObject2, "CLOSE_LOGS_VERSION", "0", b4);
                a(jSONObject2, "CLOSE_IPV4_LIST", "0", b4);
                a(jSONObject2, "CLOSE_IPV6_LIST", "0", b4);
                a(jSONObject2, "CLOSE_M008_SDKVERSION_LIST", "0", b4);
                a(jSONObject2, "CLOSE_M008_APPID_LIST", "0", b4);
                if (jSONObject2.has("LOGS_CONTROL")) {
                    String[] split = jSONObject2.getString("LOGS_CONTROL").replace("h", "").split("&");
                    if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        try {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            b4.a("maxFailedLogTimes", parseInt);
                            b4.a("pauseTime", parseInt2);
                        } catch (Exception unused) {
                            com.mobile.auth.n.c.a("UmcConfigHandle", "解析日志上报限制时间次数异常");
                        }
                    }
                } else {
                    b4.a("maxFailedLogTimes");
                    b4.a("pauseTime");
                }
            }
            b4.b();
        } catch (Exception e2) {
            com.mobile.auth.n.c.a("UmcConfigHandle", "配置项异常，配置失效");
            e2.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject, String str, String str2, k.a aVar) {
        if (!jSONObject.has(str)) {
            aVar.a(str);
            return;
        }
        String optString = jSONObject.optString(str, str2);
        if ("CLOSE_FRIEND_WAPKS".equals(str)) {
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            if (!optString.contains("CU") && !optString.contains("CT") && !optString.contains("CM")) {
                return;
            }
        } else if (!"0".equals(optString) && !"1".equals(optString)) {
            return;
        }
        aVar.a(str, jSONObject.optString(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.cmic.sso.sdk.a aVar) {
        if (this.f36792d) {
            com.mobile.auth.n.c.a("UmcConfigHandle", "正在获取配置中...");
        } else {
            this.f36792d = true;
            com.mobile.auth.l.a.a().a(false, aVar, new com.mobile.auth.l.d() { // from class: com.mobile.auth.f.b.1
                @Override // com.mobile.auth.l.d
                public void a(String str, String str2, JSONObject jSONObject) {
                    try {
                        if ("103000".equals(str)) {
                            b.this.a(jSONObject);
                            k.a("sdk_config_version", BuildConfig.CMCC_SDK_VERSION);
                            b bVar = b.this;
                            bVar.f36790a = bVar.d();
                            if (b.this.f36793e != null) {
                                b.this.f36793e.a(b.this.f36790a);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    b.this.f36792d = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mobile.auth.f.a d() {
        return new a.C0556a().a(d.b(this.f36791b.a())).c(d.a(this.f36791b.c())).b(d.b(this.f36791b.b())).d(d.c(this.f36791b.d())).d(d.a(this.f36791b.h())).e(d.b(this.f36791b.i())).a(d.e(this.f36791b.e())).b(d.d(this.f36791b.f())).c(d.c(this.f36791b.g())).f(d.f(this.f36791b.j())).a(d.a(this.f36791b.k())).b(d.b(this.f36791b.l())).a();
    }

    public com.mobile.auth.f.a a() {
        return this.f36791b;
    }

    public void a(final com.cmic.sso.sdk.a aVar) {
        if (d.a()) {
            n.a(new n.a() { // from class: com.mobile.auth.f.b.2
                @Override // com.mobile.auth.n.n.a
                public void a() {
                    com.mobile.auth.n.c.b("UmcConfigHandle", "开始拉取配置..");
                    b.this.b(aVar);
                }
            });
        }
    }

    public void a(a aVar) {
        this.f36793e = aVar;
    }

    public com.mobile.auth.f.a b() {
        return this.f36790a;
    }

    public void c() {
        k.a b4 = k.b("sso_config_xf");
        b4.c();
        b4.b();
    }
}
