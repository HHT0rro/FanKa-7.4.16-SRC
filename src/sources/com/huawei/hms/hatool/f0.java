package com.huawei.hms.hatool;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f0 extends k0 {

    /* renamed from: g, reason: collision with root package name */
    private String f30101g = "";

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f30155d);
        jSONObject.put("appid", this.f30152a);
        jSONObject.put("hmac", this.f30101g);
        jSONObject.put("chifer", this.f30157f);
        jSONObject.put("timestamp", this.f30153b);
        jSONObject.put("servicetag", this.f30154c);
        jSONObject.put("requestid", this.f30156e);
        return jSONObject;
    }

    public void g(String str) {
        this.f30101g = str;
    }
}
