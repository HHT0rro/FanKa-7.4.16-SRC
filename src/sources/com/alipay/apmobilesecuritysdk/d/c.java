package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        b0.b b4 = b0.b.b();
        HashMap hashMap = new HashMap();
        f a10 = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String d10 = b0.b.d(context);
        String g3 = b0.b.g(context);
        String y10 = b0.b.y(context);
        String E = b0.b.E(context);
        String C = b0.b.C(context);
        if (a10 != null) {
            if (z.a.d(d10)) {
                d10 = a10.a();
            }
            if (z.a.d(g3)) {
                g3 = a10.b();
            }
            if (z.a.d(y10)) {
                y10 = a10.c();
            }
            if (z.a.d(E)) {
                E = a10.d();
            }
            if (z.a.d(C)) {
                C = a10.e();
            }
        }
        f fVar = new f(d10, g3, y10, E, C);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
        }
        hashMap.put("AD1", d10);
        hashMap.put("AD2", g3);
        hashMap.put("AD3", b0.b.o(context));
        hashMap.put("AD5", b0.b.s(context));
        hashMap.put("AD6", b0.b.u(context));
        hashMap.put("AD7", b0.b.w(context));
        hashMap.put("AD8", y10);
        hashMap.put("AD9", b0.b.A(context));
        hashMap.put("AD10", C);
        hashMap.put("AD11", b0.b.l());
        hashMap.put("AD12", b4.n());
        hashMap.put("AD13", b0.b.p());
        hashMap.put("AD14", b0.b.t());
        hashMap.put("AD15", b0.b.v());
        hashMap.put("AD16", b0.b.x());
        hashMap.put("AD17", "");
        hashMap.put("AD18", E);
        hashMap.put("AD19", b0.b.G(context));
        hashMap.put("AD20", b0.b.z());
        hashMap.put("AD21", b0.b.j());
        hashMap.put("AD22", "");
        hashMap.put("AD23", b0.b.B());
        hashMap.put("AD24", z.a.l(b0.b.q(context)));
        hashMap.put("AD26", b0.b.m(context));
        hashMap.put("AD27", b0.b.L());
        hashMap.put("AD28", b0.b.P());
        hashMap.put("AD29", b0.b.S());
        hashMap.put("AD30", b0.b.N());
        hashMap.put("AD31", b0.b.R());
        hashMap.put("AD32", b0.b.H());
        hashMap.put("AD33", b0.b.J());
        hashMap.put("AD34", b0.b.M(context));
        hashMap.put("AD35", b0.b.O(context));
        hashMap.put("AD36", b0.b.K(context));
        hashMap.put("AD37", b0.b.F());
        hashMap.put("AD38", b0.b.D());
        hashMap.put("AD39", b0.b.i(context));
        hashMap.put("AD40", b0.b.k(context));
        hashMap.put("AD41", b0.b.f());
        hashMap.put("AD42", b0.b.h());
        hashMap.put("AL3", b0.b.I(context));
        return hashMap;
    }
}
