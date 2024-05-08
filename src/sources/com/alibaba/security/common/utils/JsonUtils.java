package com.alibaba.security.common.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.security.common.json.RPJSON;
import com.alibaba.security.common.json.RPJSONArray;
import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.RPJSONObject;
import com.alibaba.security.common.json.parser.Feature;
import com.alibaba.security.common.json.serializer.SerializerFeature;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static boolean isJsonString(String str) {
        try {
            RPJSON.parseObject(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final <T> List<T> parseArray(String str, Class<T> cls) {
        return RPJSON.parseArray(str, cls);
    }

    public static <T> List<T> parseJsonArray(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return RPJSON.parseArray(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        return (T) parseObject(str, cls, false);
    }

    public static String stringifyBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        RPJSONObject rPJSONObject = new RPJSONObject();
        for (String str : bundle.keySet()) {
            if (bundle.get(str) != null) {
                rPJSONObject.put(str, bundle.get(str));
            }
        }
        return RPJSON.toJSONString(rPJSONObject, SerializerFeature.WriteMapNullValue);
    }

    public static String toJSON(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return RPJSON.toJSONString(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static RPJSONArray toJSONArray(Object obj) throws RPJSONException {
        RPJSONArray rPJSONArray = new RPJSONArray();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i10 = 0; i10 < length; i10++) {
                rPJSONArray.add(Array.get(obj, i10));
            }
            return rPJSONArray;
        }
        throw new RPJSONException("Not a primitive array: " + ((Object) obj.getClass()));
    }

    public static JSONObject toJsonObject(Map map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static String toJsonString(Map map) {
        JSONObject jsonObject = toJsonObject(map);
        return jsonObject == null ? "" : jsonObject.toString();
    }

    public static Map<String, Object> parseObject(String str) {
        return RPJSON.parseObject(str);
    }

    public static <T> T parseObject(String str, Type type) {
        return (T) RPJSON.parseObject(str, type, new Feature[0]);
    }

    public static <T> T parseObject(String str, Class<T> cls, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z10) {
            try {
                return (T) RPJSON.parseObject(str, cls);
            } catch (Exception unused) {
                return null;
            }
        }
        return (T) RPJSON.parseObject(str, cls);
    }

    public static JSONObject toJsonObject(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }
}
