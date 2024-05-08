package com.inno.innosdk.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CommonJsonParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {
    public static Map<String, Object> a(String str) {
        try {
            return a(new JSONObject(str.replace("\\", "^%^%174%^%^")));
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    public static Object a(Object obj) {
        if (obj != null) {
            if (obj instanceof JSONArray) {
                return a((JSONArray) obj);
            }
            if (obj instanceof JSONObject) {
                return a((JSONObject) obj);
            }
            if ((obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double)) {
                return obj;
            }
            if (obj instanceof String) {
                return ((String) obj).replace("^%^%174%^%^", "\\");
            }
        }
        return null;
    }

    public static Collection<Object> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object obj = jSONArray.get(i10);
            if (obj != null) {
                arrayList.add(a(obj));
            }
        }
        return arrayList;
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap(16);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null) {
                hashMap.put(next, a(opt));
            }
        }
        return hashMap;
    }
}
