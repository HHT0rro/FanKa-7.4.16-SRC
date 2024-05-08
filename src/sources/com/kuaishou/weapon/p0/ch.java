package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ch {

    /* renamed from: a, reason: collision with root package name */
    private Context f35926a;

    /* renamed from: b, reason: collision with root package name */
    private int f35927b;

    public ch(Context context, int i10) {
        this.f35926a = context;
        this.f35927b = i10;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.f35926a, "re_po_rt").b(df.f36086y, 1) != 1) {
                return null;
            }
            try {
                JSONArray a10 = new x().a(this.f35926a);
                if (a10 != null && a10.length() > 0) {
                    jSONObject.put("10000", a10);
                    jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a10;
        try {
            JSONObject a11 = new cm(str, ck.f35942l).a(this.f35926a);
            if (a11 != null && (a10 = a()) != null && a10.length() != 0) {
                a11.put("module_section", a10);
                return a11.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
