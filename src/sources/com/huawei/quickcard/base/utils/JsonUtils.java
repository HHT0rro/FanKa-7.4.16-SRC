package com.huawei.quickcard.base.utils;

import androidx.annotation.NonNull;
import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsonUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum MapOptions {
        TIER_SINGLE,
        TIER_ALL
    }

    private static void a(JSONObject jSONObject, Map<String, Object> map) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.isNull(next) ? null : jSONObject.opt(next);
            if (opt instanceof JSONObject) {
                HashMap hashMap = new HashMap();
                a((JSONObject) opt, hashMap);
                map.put(next, hashMap);
            } else if (opt instanceof JSONArray) {
                ArrayList arrayList = new ArrayList();
                a((JSONArray) opt, arrayList);
                map.put(next, arrayList);
            } else {
                map.put(next, opt);
            }
        }
    }

    private static void b(JSONObject jSONObject, Map<String, Object> map) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            map.put(next, jSONObject.isNull(next) ? null : jSONObject.opt(next));
        }
    }

    @NonNull
    public static JSONArray createJsonArray(String str) {
        if (str == null) {
            return new JSONArray();
        }
        try {
            return new JSONArray(str);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    @NonNull
    public static JSONObject createJsonObject(String str) {
        if (str == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static Object get(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.get(str);
        }
        return null;
    }

    public static double getDouble(JSONObject jSONObject, String str, double d10) {
        return jSONObject.optDouble(str, d10);
    }

    public static int getInt(JSONObject jSONObject, String str, int i10) {
        try {
            Integer integer = getInteger(jSONObject, str);
            return integer == null ? i10 : integer.intValue();
        } catch (JSONException unused) {
            return i10;
        }
    }

    public static Integer getInteger(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        return null;
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            return getJSONArray(jSONObject, str);
        } catch (JSONException unused) {
            return jSONArray;
        }
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            return getJSONObject(jSONObject, str);
        } catch (JSONException unused) {
            return jSONObject2;
        }
    }

    public static Long getLong(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        return null;
    }

    public static String getString(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    public static boolean isProbablyArray(String str) {
        return str != null && str.startsWith("[") && str.endsWith("]");
    }

    public static boolean isProbablyObject(String str) {
        return str != null && str.startsWith("{") && str.endsWith(i.f4738d);
    }

    @NonNull
    public static List<Object> json2List(String str) {
        return json2List(createJsonArray(str));
    }

    @NonNull
    public static Map<String, Object> json2Map(String str) {
        return json2Map(createJsonObject(str));
    }

    public static String toJsonString(@NonNull Map<String, ?> map) {
        return new JSONObject(map).toString();
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.getJSONArray(str);
        }
        return null;
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.getJSONObject(str);
        }
        return null;
    }

    @NonNull
    public static List<Object> json2List(JSONArray jSONArray) {
        return json2List(jSONArray, MapOptions.TIER_SINGLE);
    }

    @NonNull
    public static Map<String, Object> json2Map(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        json2Map(jSONObject, hashMap);
        return hashMap;
    }

    public static Integer getInteger(JSONObject jSONObject, String str, int i10) {
        try {
            return getInteger(jSONObject, str);
        } catch (JSONException unused) {
            return Integer.valueOf(i10);
        }
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        try {
            return getString(jSONObject, str);
        } catch (JSONException unused) {
            return str2;
        }
    }

    @NonNull
    public static List<Object> json2List(String str, MapOptions mapOptions) {
        return json2List(createJsonArray(str), mapOptions);
    }

    @NonNull
    public static List<Object> json2List(JSONArray jSONArray, MapOptions mapOptions) {
        ArrayList arrayList = new ArrayList();
        json2List(jSONArray, arrayList, mapOptions);
        return arrayList;
    }

    @NonNull
    public static Map<String, Object> json2Map(String str, MapOptions mapOptions) {
        return json2Map(createJsonObject(str), mapOptions);
    }

    private static void b(JSONArray jSONArray, @NonNull List<Object> list) {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            list.add(jSONArray.isNull(i10) ? null : jSONArray.opt(i10));
        }
    }

    public static Map<String, Object> json2Map(JSONObject jSONObject, MapOptions mapOptions) {
        HashMap hashMap = new HashMap();
        json2Map(jSONObject, hashMap, mapOptions);
        return hashMap;
    }

    public static void json2List(JSONArray jSONArray, List<Object> list) {
        json2List(jSONArray, list, MapOptions.TIER_SINGLE);
    }

    public static void json2List(JSONArray jSONArray, List<Object> list, MapOptions mapOptions) {
        if (jSONArray == null) {
            return;
        }
        if (mapOptions == MapOptions.TIER_ALL) {
            a(jSONArray, list);
        } else {
            b(jSONArray, list);
        }
    }

    public static void json2Map(JSONObject jSONObject, Map<String, Object> map) {
        json2Map(jSONObject, map, MapOptions.TIER_SINGLE);
    }

    public static void json2Map(JSONObject jSONObject, Map<String, Object> map, MapOptions mapOptions) {
        if (jSONObject == null) {
            return;
        }
        if (mapOptions == MapOptions.TIER_ALL) {
            a(jSONObject, map);
        } else {
            b(jSONObject, map);
        }
    }

    private static void a(JSONArray jSONArray, @NonNull List<Object> list) {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object opt = jSONArray.isNull(i10) ? null : jSONArray.opt(i10);
            if (opt instanceof JSONObject) {
                HashMap hashMap = new HashMap();
                a((JSONObject) opt, hashMap);
                list.add(hashMap);
            } else if (opt instanceof JSONArray) {
                ArrayList arrayList = new ArrayList();
                a((JSONArray) opt, arrayList);
                list.add(arrayList);
            } else {
                list.add(opt);
            }
        }
    }
}
