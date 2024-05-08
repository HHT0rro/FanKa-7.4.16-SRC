package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ci {

    /* renamed from: a, reason: collision with root package name */
    private Context f35928a;

    /* renamed from: b, reason: collision with root package name */
    private int f35929b;

    public ci(Context context, int i10) {
        this.f35928a = context;
        this.f35929b = i10;
    }

    public JSONObject a() {
        long currentTimeMillis;
        JSONObject jSONObject;
        JSONArray a10;
        try {
            currentTimeMillis = System.currentTimeMillis();
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        if (!WeaponHI.as) {
            return null;
        }
        h a11 = h.a(this.f35928a, "re_po_rt");
        int b4 = a11.b(df.f36076o, 0);
        boolean e2 = a11.e("a1_p_s_p_s");
        boolean e10 = a11.e("a1_p_s_p_s_c_b");
        if (b4 == 1 && ((e2 || e10) && (a10 = new w(this.f35928a).a(0)) != null)) {
            jSONObject.put("10000", a10);
            try {
                jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        }
        return null;
    }

    public String a(String str) {
        JSONObject a10;
        try {
            JSONObject a11 = new cm(str, ck.f35942l).a(this.f35928a);
            if (a11 == null || (a10 = a()) == null) {
                return null;
            }
            a11.put("module_section", a10);
            return a11.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
