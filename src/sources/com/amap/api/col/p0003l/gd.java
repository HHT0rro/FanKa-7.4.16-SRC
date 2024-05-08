package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseAAIDRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class gd extends fp {

    /* renamed from: k, reason: collision with root package name */
    public Context f6046k;

    public gd(Context context) {
        this.f6046k = context;
        setConnectionTimeout(5000);
        setSoTimeout(5000);
    }

    @Override // com.amap.api.col.p0003l.id
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", fj.f(this.f6046k));
        String a10 = fl.a();
        String a11 = fl.a(this.f6046k, a10, fv.b(hashMap));
        hashMap.put("ts", a10);
        hashMap.put("scode", a11);
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.id
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.6");
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.6", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.id
    public String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0003l.id
    public String getURL() {
        return fo.a().b() ? "https://restapi.amap.com/rest/aaid/get" : "http://restapi.amap.com/rest/aaid/get";
    }
}
