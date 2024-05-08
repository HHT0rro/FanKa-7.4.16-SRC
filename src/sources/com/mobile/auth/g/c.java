package com.mobile.auth.g;

import android.content.Context;
import com.cmic.sso.sdk.b;
import com.mobile.auth.n.l;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f36812c;

    /* renamed from: a, reason: collision with root package name */
    private final com.mobile.auth.l.a f36813a = com.mobile.auth.l.a.a();

    /* renamed from: b, reason: collision with root package name */
    private final Context f36814b;

    private c(Context context) {
        this.f36814b = context.getApplicationContext();
    }

    public static c a(Context context) {
        if (f36812c == null) {
            synchronized (c.class) {
                if (f36812c == null) {
                    f36812c = new c(context);
                }
            }
        }
        return f36812c;
    }

    private void a(com.cmic.sso.sdk.a aVar) {
        String packageName = this.f36814b.getPackageName();
        String a10 = com.mobile.auth.n.d.a(l.a(this.f36814b, packageName));
        aVar.a("apppackage", packageName);
        aVar.a("appsign", a10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.mobile.auth.g.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.cmic.sso.sdk.a r21, com.mobile.auth.g.d r22, java.lang.String r23, java.lang.String r24, org.json.JSONObject r25) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.g.c.a(com.cmic.sso.sdk.a, com.mobile.auth.g.d, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    private void b(com.cmic.sso.sdk.a aVar) {
        byte[] bArr = new byte[0];
        if (aVar.b("use2048PublicKey", false)) {
            com.mobile.auth.n.c.a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
            bArr = com.mobile.auth.n.a.a();
        } else {
            com.mobile.auth.n.c.a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
            try {
                bArr = UUID.randomUUID().toString().substring(0, 16).getBytes("utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        byte[] a10 = com.mobile.auth.n.a.a();
        aVar.a(b.a.f11420a, bArr);
        aVar.a(b.a.f11421b, a10);
        aVar.a("authType", "3");
    }

    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        com.mobile.auth.n.c.b("AuthnBusiness", "LoginCheck method start");
        int c4 = aVar.c("logintype");
        if (!aVar.b("isCacheScrip", false)) {
            b(aVar, dVar);
            return;
        }
        String b4 = aVar.b("securityphone", "");
        if (c4 == 3) {
            dVar.a("103000", "true", aVar, f.a(b4));
        } else {
            b(aVar, dVar);
        }
    }

    public void b(final com.cmic.sso.sdk.a aVar, final d dVar) {
        String str;
        com.mobile.auth.n.c.b("AuthnBusiness", "getScripAndToken start");
        a(aVar);
        if (!aVar.b("isCacheScrip", false)) {
            b(aVar);
        }
        if (aVar.c("logintype") != 1) {
            str = aVar.c("logintype") == 0 ? "50" : "200";
            this.f36813a.a(aVar, new com.mobile.auth.l.d() { // from class: com.mobile.auth.g.c.1
                @Override // com.mobile.auth.l.d
                public void a(String str2, String str3, JSONObject jSONObject) {
                    c.this.a(aVar, dVar, str2, str3, jSONObject);
                }
            });
        }
        aVar.a("userCapaid", str);
        this.f36813a.a(aVar, new com.mobile.auth.l.d() { // from class: com.mobile.auth.g.c.1
            @Override // com.mobile.auth.l.d
            public void a(String str2, String str3, JSONObject jSONObject) {
                c.this.a(aVar, dVar, str2, str3, jSONObject);
            }
        });
    }
}
