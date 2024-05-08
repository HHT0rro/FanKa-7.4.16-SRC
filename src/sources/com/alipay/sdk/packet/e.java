package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.app.i;
import com.alipay.sdk.net.a;
import com.alipay.sdk.util.m;
import com.alipay.sdk.util.n;
import io.microshow.rxffmpeg.BuildConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4629a = "msp-gzip";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4630b = "Msp-Param";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4631c = "Operation-Type";

    /* renamed from: d, reason: collision with root package name */
    public static final String f4632d = "content-type";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4633e = "Version";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4634f = "AppId";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4635g = "des-mode";

    /* renamed from: h, reason: collision with root package name */
    public static final String f4636h = "namespace";

    /* renamed from: i, reason: collision with root package name */
    public static final String f4637i = "api_name";

    /* renamed from: j, reason: collision with root package name */
    public static final String f4638j = "api_version";

    /* renamed from: k, reason: collision with root package name */
    public static final String f4639k = "data";

    /* renamed from: l, reason: collision with root package name */
    public static final String f4640l = "params";

    /* renamed from: m, reason: collision with root package name */
    public static final String f4641m = "public_key";

    /* renamed from: n, reason: collision with root package name */
    public static final String f4642n = "device";

    /* renamed from: o, reason: collision with root package name */
    public static final String f4643o = "action";

    /* renamed from: p, reason: collision with root package name */
    public static final String f4644p = "type";

    /* renamed from: q, reason: collision with root package name */
    public static final String f4645q = "method";

    /* renamed from: r, reason: collision with root package name */
    public boolean f4646r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4647s = true;

    public Map<String, String> a(boolean z10, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(f4629a, String.valueOf(z10));
        hashMap.put(f4631c, "alipay.msp.cashier.dispatch.bytes");
        hashMap.put(f4632d, "application/octet-stream");
        hashMap.put(f4633e, "2.0");
        hashMap.put(f4634f, "TAOBAO");
        hashMap.put(f4630b, a.a(str));
        hashMap.put(f4635g, "CBC");
        return hashMap;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return BuildConfig.VERSION_NAME;
    }

    public String c() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(f4642n, Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put("api_name", "com.alipay.mcpay");
        hashMap.put(f4638j, b());
        return a(hashMap, new HashMap<>());
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public String a(String str, JSONObject jSONObject) {
        com.alipay.sdk.sys.b a10 = com.alipay.sdk.sys.b.a();
        com.alipay.sdk.tid.b a11 = com.alipay.sdk.tid.b.a(a10.b());
        JSONObject a12 = com.alipay.sdk.util.b.a(new JSONObject(), jSONObject);
        try {
            a12.put("tid", a11.a());
            a12.put(com.alipay.sdk.cons.b.f4540b, a10.c().a(a11));
            a12.put(com.alipay.sdk.cons.b.f4543e, n.b(a10.b(), i.f4411a));
            a12.put(com.alipay.sdk.cons.b.f4544f, n.a(a10.b()));
            a12.put(com.alipay.sdk.cons.b.f4542d, str);
            a12.put(com.alipay.sdk.cons.b.f4546h, com.alipay.sdk.cons.a.f4521d);
            a12.put(com.alipay.sdk.cons.b.f4545g, a10.e());
            a12.put(com.alipay.sdk.cons.b.f4548j, a11.b());
            a12.put(com.alipay.sdk.cons.b.f4549k, a10.c().a(a10.b()));
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
        return a12.toString();
    }

    private static boolean a(a.b bVar) {
        return Boolean.valueOf(a(bVar, f4629a)).booleanValue();
    }

    private static String a(a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.f4620a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public String a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (hashMap2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            String optString = jSONObject.getJSONObject("params").optString(f4641m, null);
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            com.alipay.sdk.sys.b.a().c().a(optString);
            return true;
        } catch (JSONException e2) {
            com.alipay.sdk.util.c.a(e2);
            return false;
        }
    }

    public b a(Context context) throws Throwable {
        return a(context, "");
    }

    public b a(Context context, String str) throws Throwable {
        return a(context, str, m.a(context));
    }

    public b a(Context context, String str, String str2) throws Throwable {
        return a(context, str, str2, true);
    }

    public b a(Context context, String str, String str2, boolean z10) throws Throwable {
        com.alipay.sdk.util.c.b("", "PacketTask::request url >" + str2);
        c cVar = new c(this.f4647s);
        d a10 = cVar.a(new b(c(), a(str, a())), this.f4646r);
        a.b a11 = com.alipay.sdk.net.a.a(context, new a.C0097a(str2, a(a10.a(), str), a10.b()));
        if (a11 != null) {
            b a12 = cVar.a(new d(a(a11), a11.f4622c));
            return (a12 != null && a(a12.a()) && z10) ? a(context, str, str2, false) : a12;
        }
        throw new RuntimeException("Response is null.");
    }
}
