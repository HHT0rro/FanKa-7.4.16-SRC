package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class y0 extends t0 {

    /* renamed from: f, reason: collision with root package name */
    public String f30245f;

    /* renamed from: g, reason: collision with root package name */
    public String f30246g;

    /* renamed from: h, reason: collision with root package name */
    private String f30247h;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f30247h);
        jSONObject.put("_emui_ver", this.f30228a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f30245f);
        jSONObject.put("_mnc", this.f30246g);
        jSONObject.put("_package_name", this.f30229b);
        jSONObject.put("_app_ver", this.f30230c);
        jSONObject.put("_lib_ver", "2.2.0.314");
        jSONObject.put("_channel", this.f30231d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f30232e);
        return jSONObject;
    }

    public void f(String str) {
        this.f30245f = str;
    }

    public void g(String str) {
        this.f30246g = str;
    }

    public void h(String str) {
        this.f30247h = str;
    }
}
