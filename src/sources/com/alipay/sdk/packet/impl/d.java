package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alibaba.security.realidentity.common.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d extends com.alipay.sdk.packet.e {

    /* renamed from: t, reason: collision with root package name */
    public static final String f4648t = "log_v";

    @Override // com.alipay.sdk.packet.e
    public String a(String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.packet.e
    public Map<String, String> a(boolean z10, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.alipay.sdk.packet.e.f4629a, String.valueOf(z10));
        hashMap.put(com.alipay.sdk.packet.e.f4632d, "application/octet-stream");
        hashMap.put(com.alipay.sdk.packet.e.f4635g, "CBC");
        return hashMap;
    }

    @Override // com.alipay.sdk.packet.e
    public JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.packet.e
    public String c() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put(com.alipay.sdk.packet.e.f4638j, BuildConfig.VERSION_NAME);
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(f4648t, "1.0");
        return a(hashMap, hashMap2);
    }

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(Context context, String str) throws Throwable {
        return a(context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }
}
