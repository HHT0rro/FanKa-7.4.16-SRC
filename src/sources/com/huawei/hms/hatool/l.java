package com.huawei.hms.hatool;

import com.huawei.hms.ads.jsb.constant.Constant;
import com.inno.innosdk.pb.InnoMain;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l extends t {

    /* renamed from: b, reason: collision with root package name */
    private String f30158b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f30159c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f30160d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f30161e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f30162f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f30163g;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f30227a);
        jSONObject.put(InnoMain.INNO_KEY_OAID, this.f30163g);
        jSONObject.put(Constant.MAP_KEY_UUID, this.f30162f);
        jSONObject.put("upid", this.f30161e);
        jSONObject.put("imei", this.f30158b);
        jSONObject.put("sn", this.f30159c);
        jSONObject.put("udid", this.f30160d);
        return jSONObject;
    }

    public void b(String str) {
        this.f30158b = str;
    }

    public void c(String str) {
        this.f30163g = str;
    }

    public void d(String str) {
        this.f30159c = str;
    }

    public void e(String str) {
        this.f30160d = str;
    }

    public void f(String str) {
        this.f30161e = str;
    }

    public void g(String str) {
        this.f30162f = str;
    }
}
