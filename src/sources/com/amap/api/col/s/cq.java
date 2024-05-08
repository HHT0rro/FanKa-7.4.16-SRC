package com.amap.api.col.s;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseAAIDRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class cq extends cd {

    /* renamed from: k, reason: collision with root package name */
    public Context f7576k;

    public cq(Context context) {
        this.f7576k = context;
        a(5000);
        b(5000);
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return cc.a().b() ? "https://restapi.amap.com/rest/aaid/get" : "http://restapi.amap.com/rest/aaid/get";
    }

    @Override // com.amap.api.col.s.dz
    public final String d() {
        return "core";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", bw.f(this.f7576k));
        String a10 = bz.a();
        String a11 = bz.a(this.f7576k, a10, ci.b(hashMap));
        hashMap.put("ts", a10);
        hashMap.put("scode", a11);
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.5");
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
