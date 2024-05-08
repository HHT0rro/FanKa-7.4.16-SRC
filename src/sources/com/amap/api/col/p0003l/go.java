package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fm;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetReuestParam.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class go {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6124a = fv.c("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: b, reason: collision with root package name */
    private static final String f6125b = fv.c("FbGJzX3Nkaw");

    /* renamed from: c, reason: collision with root package name */
    private static final String f6126c = fv.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");

    /* renamed from: d, reason: collision with root package name */
    private static final String f6127d = fv.c("FQU5EU0RLMTA");

    /* renamed from: e, reason: collision with root package name */
    private static final String f6128e = fv.c("FMTAw");

    /* renamed from: f, reason: collision with root package name */
    private static boolean f6129f = false;

    /* renamed from: g, reason: collision with root package name */
    private String f6130g = "";

    public static fm.a a() {
        return new fm.a() { // from class: com.amap.api.col.3l.go.1

            /* renamed from: a, reason: collision with root package name */
            private go f6131a = new go();

            @Override // com.amap.api.col.3l.fm.a
            public final id a(byte[] bArr, Map<String, String> map) {
                return new hv(bArr, map);
            }

            @Override // com.amap.api.col.3l.fm.a
            public final Map<String, String> b() {
                return this.f6131a.b();
            }

            @Override // com.amap.api.col.3l.fm.a
            public final String a() {
                return go.c();
            }

            @Override // com.amap.api.col.3l.fm.a
            public final String a(Context context, String str) {
                return go.a(context, str);
            }

            @Override // com.amap.api.col.3l.fm.a
            public final String a(String str, String str2, String str3, String str4) {
                return this.f6131a.a(str, str2, str3, str4);
            }
        };
    }

    public static String c() {
        return gp.a();
    }

    private String d() {
        if (!TextUtils.isEmpty(this.f6130g)) {
            return this.f6130g;
        }
        String a10 = fn.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < a10.length(); i10++) {
            stringBuffer.append((char) (a10.charAt(i10) - (i10 % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i11 = 0; i11 < stringBuffer2.length() / 2; i11++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i11) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i11)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.f6130g = stringBuffer4;
        return stringBuffer4;
    }

    public final synchronized Map<String, String> b() {
        if (f6129f) {
            return null;
        }
        f6129f = true;
        HashMap hashMap = new HashMap();
        hashMap.put(fv.c("FZW50"), fv.c("FMg"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(fv.c("SY2hhbm5lbD0"));
        String str = f6125b;
        sb2.append(str);
        sb2.append(fv.c("SJmRpdj0"));
        String str2 = f6127d;
        sb2.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(fv.c("FQA"));
        stringBuffer.append(f6126c);
        String a10 = gr.a(stringBuffer.toString());
        sb2.append(fv.c("FJnNpZ249"));
        sb2.append(a10.toUpperCase(Locale.US));
        sb2.append(fv.c("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(fv.c("FaW4"), gm.a(hs.a(sb2.toString().getBytes(), f6124a.getBytes())));
        hashMap.put(fv.c("Sa2V5dA"), f6128e);
        return hashMap;
    }

    public static String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(fv.c("UY29kZQ")) != 1) {
                return "";
            }
            String optString = new JSONObject(jSONObject.optString(fv.c("FZGF0YQ"))).optString(fv.c("FYWRpdQ"));
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            gp.a(optString);
            gk.a(context).a(optString);
            return optString;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(fv.c("LdGlk"), str);
            jSONObject.put(fv.c("FZGl1"), str2);
            jSONObject.put(fv.c("AZGl1Mg"), str3);
            jSONObject.put(fv.c("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String a10 = gr.a();
        if (!TextUtils.isEmpty(a10)) {
            String a11 = gm.a(hs.a((jSONObject2 + "\u0000").getBytes(), a10.getBytes()));
            if (!TextUtils.isEmpty(a11)) {
                try {
                    return fv.c("Fa2V5PQ") + URLEncoder.encode(gm.a(gq.a(a10.getBytes("utf-8"), gq.a(d())))) + fv.c("SJmRhdGE9") + URLEncoder.encode(a11);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }
}
