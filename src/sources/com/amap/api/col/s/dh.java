package com.amap.api.col.s;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: PrivacyUploadRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dh extends cd {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f7686a = null;

    /* renamed from: b, reason: collision with root package name */
    public Context f7687b = null;

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return cc.a().b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // com.amap.api.col.s.dz
    public final String d() {
        return "core";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> f() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.5");
        hashMap.put("X-INFO", bz.a(this.f7687b));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] h() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f7686a;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    stringBuffer.append(next + "=" + URLEncoder.encode(this.f7686a.get(next).toString(), "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String f10 = bw.f(this.f7687b);
            stringBuffer.append("&key=".concat(String.valueOf(f10)));
            String a10 = bz.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a10)));
            stringBuffer.append("&scode=" + bz.a(this.f7687b, a10, "key=".concat(String.valueOf(f10))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
