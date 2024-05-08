package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class k<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private String f36131a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f36132b;

    /* renamed from: c, reason: collision with root package name */
    private j f36133c;

    /* renamed from: d, reason: collision with root package name */
    private Context f36134d;

    /* renamed from: e, reason: collision with root package name */
    private String f36135e;

    /* renamed from: f, reason: collision with root package name */
    private String f36136f;

    public k(Context context, String str, String str2, String str3, JSONObject jSONObject, j jVar) {
        this.f36134d = context;
        this.f36131a = str3;
        this.f36132b = jSONObject;
        this.f36133c = jVar;
        this.f36135e = str;
        this.f36136f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l a10 = l.a(this.f36134d);
            m mVar = new m(this.f36131a, this.f36132b);
            mVar.a(this.f36135e);
            mVar.b(this.f36136f);
            a10.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.k.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str) {
                    e.c("WeaponHttpTask sendLog response: --- " + str);
                    if (k.this.f36133c != null) {
                        k.this.f36133c.a(str);
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str) {
                    e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
                    if (k.this.f36133c != null) {
                        k.this.f36133c.b(str);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
