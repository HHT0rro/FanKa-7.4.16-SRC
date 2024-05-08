package com.amap.api.col.p0003l;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: PrivacyUploadRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hf extends fp {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f6247a = null;

    /* renamed from: b, reason: collision with root package name */
    public Context f6248b = null;

    @Override // com.amap.api.col.p0003l.id
    public final byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f6247a;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    stringBuffer.append(next + "=" + URLEncoder.encode(this.f6247a.get(next).toString(), "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String f10 = fj.f(this.f6248b);
            stringBuffer.append("&key=".concat(String.valueOf(f10)));
            String a10 = fl.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a10)));
            stringBuffer.append("&scode=" + fl.a(this.f6248b, a10, "key=".concat(String.valueOf(f10))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.6");
        hashMap.put("X-INFO", fl.b(this.f6248b));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.6", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        return fo.a().b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
