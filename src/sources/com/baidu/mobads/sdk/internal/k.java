package com.baidu.mobads.sdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class k {
    public static JSONArray a(double[] dArr) {
        JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (double d10 : dArr) {
                try {
                    jSONArray2.put(d10);
                } catch (Exception e2) {
                    e = e2;
                    jSONArray = jSONArray2;
                    bs.a().a(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e10) {
            e = e10;
        }
    }

    public static JSONArray a(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < list.size(); i10++) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i11 = 0; i11 < list.get(i10).length; i11++) {
                    jSONArray2.put(list.get(i10)[i11]);
                }
                jSONArray.put(jSONArray2);
            } catch (Exception e2) {
                bs.a().a(e2);
            }
        }
        return jSONArray;
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
        } catch (Exception unused) {
            bs.a().a("json2HashMap error");
        }
        return hashMap;
    }

    public static JSONObject a(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(hashMap);
        } catch (Exception unused) {
            bs.a().a("hashMap2Json error");
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    public static Object a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "";
    }

    public static Bitmap a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        int length;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    HashMap hashMap = new HashMap(map);
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    int i10 = 0;
                    for (String str : ArticleInfo.PREDEFINED_KEYS) {
                        if (hashMap.containsKey(str)) {
                            String str2 = (String) hashMap.remove(str);
                            if (!TextUtils.isEmpty(str2) && (length = str2.length() + i10) < 150) {
                                hashMap2.put(str, str2);
                                i10 = length;
                            }
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        Set<String> h10 = hashMap.h();
                        JSONArray jSONArray = new JSONArray();
                        for (String str3 : h10) {
                            if (!TextUtils.isEmpty(str3)) {
                                String str4 = (String) hashMap.get(str3);
                                if (!TextUtils.isEmpty(str4)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("k", str3);
                                    jSONObject.put(com.kuaishou.weapon.p0.t.f36218c, str4);
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("ext", jSONArray.toString());
                            if (jSONObject2.toString().length() < 3000) {
                                hashMap2.put("ext", jSONObject2.toString());
                            }
                        }
                    }
                    return hashMap2;
                }
            } catch (Throwable unused) {
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }
}
