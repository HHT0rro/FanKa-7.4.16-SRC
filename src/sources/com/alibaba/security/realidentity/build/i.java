package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.http.HttpRequestManager;
import com.alibaba.security.realidentity.http.IHttpCallback;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RPEasyTrack.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class i extends d {

    /* renamed from: g, reason: collision with root package name */
    public static final int f3876g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static final int f3877h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static final int f3878i = 2;

    /* renamed from: j, reason: collision with root package name */
    private static final String f3879j = "RPEasyTrack";

    /* renamed from: k, reason: collision with root package name */
    private static String f3880k = null;

    /* renamed from: l, reason: collision with root package name */
    private static JSONObject f3881l = null;

    /* renamed from: m, reason: collision with root package name */
    private static final int f3882m = 10000;

    /* renamed from: n, reason: collision with root package name */
    private static final int f3883n = 1024;

    /* renamed from: o, reason: collision with root package name */
    private static String f3884o = "|:|";

    /* renamed from: p, reason: collision with root package name */
    private static String f3885p = "\\|:\\|";

    /* renamed from: q, reason: collision with root package name */
    private static boolean f3886q;

    /* renamed from: r, reason: collision with root package name */
    private static StringBuffer f3887r = new StringBuffer();

    /* renamed from: s, reason: collision with root package name */
    private Runnable f3888s = new Runnable() { // from class: com.alibaba.security.realidentity.build.i.1
        @Override // java.lang.Runnable
        public final void run() {
            i.this.b();
        }
    };

    public static void a(String str) {
        f3880k = str;
    }

    public static void b(String str) {
        f3881l = JsonUtils.toJsonObject(str);
    }

    private static String c() {
        return new SimpleDateFormat(TimeUtils.STARD_FROMAT).format(new Date());
    }

    private static JSONObject d(Map map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.alibaba.security.realidentity.build.d
    public final void a(String str, String str2, Object obj, Object obj2, Object obj3, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (obj != null) {
            hashMap2.put("arg1", obj);
        }
        if (obj2 != null) {
            hashMap2.put("arg2", obj2);
        }
        if (obj3 != null) {
            hashMap2.put("arg3", obj3);
        }
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        a(0, str, str2, hashMap2);
    }

    @Override // com.alibaba.security.realidentity.build.d
    public final void b() {
        String str;
        this.f3391f.removeCallbacks(this.f3888s);
        if (f3887r.length() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            str = new String(f3887r.toString().getBytes("UTF-8"), "UTF-8");
        } catch (Exception e2) {
            RPLogging.e(f3879j, String.valueOf(e2.getMessage()));
            str = null;
        }
        String[] split = str != null ? str.split(f3885p) : null;
        if (split != null) {
            for (String str2 : split) {
                jSONArray.put(str2);
            }
        }
        f3887r.setLength(0);
        if (f3881l == null) {
            new HashMap().put(aq.f3108d, f3880k);
            JSONObject jSONObject = f3881l;
            if (jSONObject != null) {
                f3881l = JsonUtils.toJsonObject(jSONObject.toString());
            }
            a(jSONArray);
            return;
        }
        a(jSONArray);
    }

    private static String c(Map map) {
        JSONObject d10 = d(map);
        return d10 == null ? "" : d10.toString();
    }

    @Override // com.alibaba.security.realidentity.build.d
    public final void a(String str, String str2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        a(1, str, str2, hashMap2);
    }

    @Override // com.alibaba.security.realidentity.build.d
    public final void a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        a(2, "liveness", null, hashMap);
    }

    @Override // com.alibaba.security.realidentity.build.d
    public final void a(int i10, String str, String str2, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("__ts", c());
        hashMap.put("__name", String.valueOf(str));
        hashMap.put("source", Integer.valueOf(i10));
        if (str2 != null) {
            hashMap.put("eventId", str2);
        }
        hashMap.putAll(map);
        String b4 = b(hashMap);
        if (f3887r.length() > 0) {
            f3887r.append(f3884o);
        }
        f3887r.append(b4);
        if (f3887r.length() > 1024) {
            b();
        } else {
            if (f3886q) {
                return;
            }
            this.f3391f.postDelayed(this.f3888s, 10000L);
        }
    }

    private static String b(Map<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z10 = true;
        for (String str : map.h()) {
            String a10 = a(map.get(str));
            String a11 = a((Object) str);
            if (a10 != null && a11 != null) {
                if (z10) {
                    stringBuffer.append(a11 + "=" + a10);
                    z10 = false;
                } else {
                    stringBuffer.append(",");
                    stringBuffer.append(a11 + "=" + a10);
                }
            }
        }
        return stringBuffer.toString();
    }

    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((Integer) obj).intValue());
            return sb2.toString();
        }
        if (obj instanceof Long) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(((Long) obj).longValue());
            return sb3.toString();
        }
        if (obj instanceof Double) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(((Double) obj).doubleValue());
            return sb4.toString();
        }
        if (obj instanceof Float) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(((Float) obj).floatValue());
            return sb5.toString();
        }
        if (obj instanceof Short) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append((int) ((Short) obj).shortValue());
            return sb6.toString();
        }
        if (obj instanceof Byte) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append((int) ((Byte) obj).byteValue());
            return sb7.toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        if (obj instanceof Character) {
            return ((Character) obj).toString();
        }
        return obj.toString();
    }

    private static JSONArray b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                String[] split = String.valueOf(jSONArray.get(i10)).split(",");
                JSONObject jSONObject = new JSONObject();
                StringBuffer stringBuffer = new StringBuffer();
                String str = null;
                String str2 = null;
                for (String str3 : split) {
                    if (str3 != null) {
                        String[] split2 = str3.split("=");
                        if (split2.length > 1 && (str3.startsWith("__ts") || str3.startsWith("__name"))) {
                            if (str3.startsWith("__ts")) {
                                str = split2[1];
                            } else {
                                str2 = split2[1];
                            }
                        } else {
                            if (stringBuffer.length() > 0) {
                                stringBuffer.append("|");
                            }
                            if (split2.length > 1) {
                                stringBuffer.append(split2[0] + com.huawei.openalliance.ad.constant.u.bD + split2[1]);
                            } else {
                                stringBuffer.append(str3);
                            }
                        }
                    }
                }
                if (str == null) {
                    str = c();
                }
                String valueOf = String.valueOf(str2);
                jSONObject.put("ts", str);
                jSONObject.put("name", valueOf);
                jSONObject.put("details", stringBuffer.toString());
                jSONArray2.put(jSONObject);
            } catch (JSONException e2) {
                RPLogging.e(f3879j, "[toEventsParam]" + e2.getMessage());
                e2.printStackTrace();
            }
        }
        return jSONArray2;
    }

    private static void a(JSONArray jSONArray) {
        HashMap hashMap = new HashMap();
        hashMap.put(aq.f3108d, f3880k);
        hashMap.put(aq.f3110f, f3881l);
        hashMap.put("events", b(jSONArray));
        HttpRequestManager.getInstance().asyncRequest(j.a.f3944a.f3894d, a.f3001g, c(hashMap), (IHttpCallback) null, false, true);
    }
}
