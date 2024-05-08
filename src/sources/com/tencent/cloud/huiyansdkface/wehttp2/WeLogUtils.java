package com.tencent.cloud.huiyansdkface.wehttp2;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeLogUtils {
    private static void a(JSONArray jSONArray, int i10) throws JSONException {
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            Object obj = jSONArray.get(i11);
            if (obj instanceof String) {
                jSONArray.put(i11, getShortString((String) obj, i10));
            } else if (obj instanceof JSONArray) {
                a((JSONArray) obj, i10);
            } else if (obj instanceof JSONObject) {
                a((JSONObject) obj, i10);
            }
        }
    }

    private static void a(JSONObject jSONObject, int i10) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof String) {
                jSONObject.put(next, getShortString((String) opt, i10));
            } else if (opt instanceof JSONArray) {
                a((JSONArray) opt, i10);
            } else if (opt instanceof JSONObject) {
                a((JSONObject) opt, i10);
            }
        }
    }

    public static Object getShortString(String str, int i10) {
        if (str.length() <= i10) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = i10 / 2;
        sb2.append(str.substring(0, i11));
        sb2.append(".....");
        sb2.append((str.length() - i11) - i11);
        sb2.append("omitted.........");
        sb2.append(str.substring(str.length() - i11));
        return sb2.toString();
    }

    public static String toPrettyJson(String str, boolean z10, int i10) throws JSONException {
        String trim = str.trim();
        if (trim.startsWith("[")) {
            JSONArray jSONArray = new JSONArray(trim);
            if (z10) {
                a(jSONArray, i10);
            }
            return jSONArray.toString(4);
        }
        if (!trim.startsWith("{")) {
            return trim;
        }
        JSONObject jSONObject = new JSONObject(trim);
        if (z10) {
            a(jSONObject, i10);
        }
        return jSONObject.toString(4);
    }
}
