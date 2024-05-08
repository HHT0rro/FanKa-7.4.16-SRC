package com.huawei.quickcard.utils;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.utils.JsonUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsonUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum MapOptions {
        TIER_SINGLE,
        TIER_ALL
    }

    private static JsonUtils.MapOptions a(MapOptions mapOptions) {
        if (MapOptions.TIER_ALL == mapOptions) {
            return JsonUtils.MapOptions.TIER_ALL;
        }
        return JsonUtils.MapOptions.TIER_SINGLE;
    }

    @NonNull
    @Deprecated
    public static JSONArray createJsonArray(String str) {
        return com.huawei.quickcard.base.utils.JsonUtils.createJsonArray(str);
    }

    @NonNull
    @Deprecated
    public static JSONObject createJsonObject(String str) {
        return com.huawei.quickcard.base.utils.JsonUtils.createJsonObject(str);
    }

    @Deprecated
    public static Object get(JSONObject jSONObject, String str) throws JSONException {
        return com.huawei.quickcard.base.utils.JsonUtils.get(jSONObject, str);
    }

    @Deprecated
    public static double getDouble(JSONObject jSONObject, String str, double d10) {
        return com.huawei.quickcard.base.utils.JsonUtils.getDouble(jSONObject, str, d10);
    }

    @Deprecated
    public static Integer getInteger(JSONObject jSONObject, String str) throws JSONException {
        return com.huawei.quickcard.base.utils.JsonUtils.getInteger(jSONObject, str);
    }

    @Deprecated
    public static JSONArray getJSONArray(JSONObject jSONObject, String str) throws JSONException {
        return com.huawei.quickcard.base.utils.JsonUtils.getJSONArray(jSONObject, str);
    }

    @Deprecated
    public static JSONObject getJSONObject(JSONObject jSONObject, String str) throws JSONException {
        return com.huawei.quickcard.base.utils.JsonUtils.getJSONObject(jSONObject, str);
    }

    @Deprecated
    public static Long getLong(JSONObject jSONObject, String str) throws JSONException {
        return com.huawei.quickcard.base.utils.JsonUtils.getLong(jSONObject, str);
    }

    @Deprecated
    public static String getString(JSONObject jSONObject, String str) throws JSONException {
        return com.huawei.quickcard.base.utils.JsonUtils.getString(jSONObject, str);
    }

    @Deprecated
    public static boolean isProbablyArray(String str) {
        return com.huawei.quickcard.base.utils.JsonUtils.isProbablyArray(str);
    }

    @Deprecated
    public static boolean isProbablyObject(String str) {
        return com.huawei.quickcard.base.utils.JsonUtils.isProbablyObject(str);
    }

    @NonNull
    @Deprecated
    public static List<Object> json2List(String str) {
        return com.huawei.quickcard.base.utils.JsonUtils.json2List(str);
    }

    @NonNull
    @Deprecated
    public static Map<String, Object> json2Map(String str) {
        return com.huawei.quickcard.base.utils.JsonUtils.json2Map(str);
    }

    @Deprecated
    public static String toJsonString(@NonNull Map<String, ?> map) {
        return com.huawei.quickcard.base.utils.JsonUtils.toJsonString(map);
    }

    @Deprecated
    public static Integer getInteger(JSONObject jSONObject, String str, int i10) {
        return com.huawei.quickcard.base.utils.JsonUtils.getInteger(jSONObject, str, i10);
    }

    @Deprecated
    public static String getString(JSONObject jSONObject, String str, String str2) {
        return com.huawei.quickcard.base.utils.JsonUtils.getString(jSONObject, str, str2);
    }

    @NonNull
    @Deprecated
    public static List<Object> json2List(JSONArray jSONArray) {
        return com.huawei.quickcard.base.utils.JsonUtils.json2List(jSONArray);
    }

    @NonNull
    @Deprecated
    public static Map<String, Object> json2Map(JSONObject jSONObject) {
        return com.huawei.quickcard.base.utils.JsonUtils.json2Map(jSONObject);
    }

    @NonNull
    @Deprecated
    public static List<Object> json2List(String str, MapOptions mapOptions) {
        return com.huawei.quickcard.base.utils.JsonUtils.json2List(str, a(mapOptions));
    }

    @NonNull
    @Deprecated
    public static Map<String, Object> json2Map(String str, MapOptions mapOptions) {
        return com.huawei.quickcard.base.utils.JsonUtils.json2Map(str, a(mapOptions));
    }

    @NonNull
    @Deprecated
    public static List<Object> json2List(JSONArray jSONArray, MapOptions mapOptions) {
        return com.huawei.quickcard.base.utils.JsonUtils.json2List(jSONArray, a(mapOptions));
    }

    @Deprecated
    public static Map<String, Object> json2Map(JSONObject jSONObject, MapOptions mapOptions) {
        return com.huawei.quickcard.base.utils.JsonUtils.json2Map(jSONObject, a(mapOptions));
    }

    @Deprecated
    public static void json2List(JSONArray jSONArray, List<Object> list) {
        com.huawei.quickcard.base.utils.JsonUtils.json2List(jSONArray, list);
    }

    @Deprecated
    public static void json2Map(JSONObject jSONObject, Map<String, Object> map) {
        com.huawei.quickcard.base.utils.JsonUtils.json2Map(jSONObject, map);
    }

    @Deprecated
    public static void json2List(JSONArray jSONArray, List<Object> list, MapOptions mapOptions) {
        com.huawei.quickcard.base.utils.JsonUtils.json2List(jSONArray, list, a(mapOptions));
    }

    @Deprecated
    public static void json2Map(JSONObject jSONObject, Map<String, Object> map, MapOptions mapOptions) {
        com.huawei.quickcard.base.utils.JsonUtils.json2Map(jSONObject, map, a(mapOptions));
    }
}
