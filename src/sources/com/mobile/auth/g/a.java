package com.mobile.auth.g;

import android.content.Context;
import android.content.Intent;
import com.cmic.sso.sdk.view.a;
import com.mobile.auth.g.e;
import com.mobile.auth.n.n;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends e {

    /* renamed from: f, reason: collision with root package name */
    private static a f36802f;

    /* renamed from: g, reason: collision with root package name */
    private com.cmic.sso.sdk.view.a f36803g;

    /* renamed from: h, reason: collision with root package name */
    private com.cmic.sso.sdk.view.e f36804h;

    private a(Context context) {
        super(context);
        this.f36804h = null;
    }

    public static a a(Context context) {
        if (f36802f == null) {
            synchronized (a.class) {
                if (f36802f == null) {
                    f36802f = new a(context);
                }
            }
        }
        return f36802f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, com.cmic.sso.sdk.a aVar) {
        String b4 = aVar.b("traceId");
        Intent intent = new Intent();
        intent.putExtra("traceId", b4);
        com.mobile.auth.n.e.a(aVar.b("traceId"), aVar);
        intent.setClassName(context, "com.cmic.sso.sdk.view.LoginAuthActivity");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public com.cmic.sso.sdk.view.a a() {
        if (this.f36803g == null) {
            this.f36803g = new a.C0134a().a();
        }
        return this.f36803g;
    }

    @Override // com.mobile.auth.g.e
    public void a(com.cmic.sso.sdk.a aVar) {
        final e.a aVar2 = new e.a(aVar);
        this.f36822d.postDelayed(aVar2, this.f36821c);
        this.f36819a.a(aVar, new d() { // from class: com.mobile.auth.g.a.2
            @Override // com.mobile.auth.g.d
            public void a(String str, String str2, com.cmic.sso.sdk.a aVar3, JSONObject jSONObject) {
                com.mobile.auth.n.c.b("onBusinessComplete", "onBusinessComplete");
                a.this.f36822d.removeCallbacks(aVar2);
                if (!"103000".equals(str) || com.mobile.auth.n.e.a(aVar3.b("traceId"))) {
                    a.this.a(str, str2, aVar3, jSONObject);
                } else {
                    a.b(a.this.f36820b, aVar3);
                }
            }
        });
    }

    @Override // com.mobile.auth.g.e
    public void a(String str, String str2, b bVar) {
        a(str, str2, bVar, -1);
    }

    public void a(final String str, final String str2, final b bVar, int i10) {
        final com.cmic.sso.sdk.a a10 = a(bVar);
        a10.a("SDKRequestCode", i10);
        n.a(new n.a(this.f36820b, a10) { // from class: com.mobile.auth.g.a.1
            @Override // com.mobile.auth.n.n.a
            public void a() {
                if (a.this.a(a10, str, str2, "mobileAuth", 0, bVar)) {
                    a.super.a(a10);
                }
            }
        });
    }

    public void a(String str, JSONObject jSONObject) {
        com.cmic.sso.sdk.view.e eVar = this.f36804h;
        if (eVar != null) {
            eVar.a(str, jSONObject);
        }
    }

    public void b() {
        try {
            if (com.cmic.sso.sdk.view.f.a().b() != null) {
                com.cmic.sso.sdk.view.f.a().b().a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.mobile.auth.n.c.a("AuthnHelper", "关闭授权页失败");
        }
    }

    public long c() {
        return this.f36821c;
    }
}
