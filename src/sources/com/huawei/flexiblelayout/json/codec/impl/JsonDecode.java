package com.huawei.flexiblelayout.json.codec.impl;

import android.text.TextUtils;
import com.huawei.flexiblelayout.json.codec.JsonException;
import com.huawei.flexiblelayout.json.codec.Jsonable;
import com.huawei.flexiblelayout.log.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonDecode extends a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f28165c = "JsonDecode";

    /* renamed from: b, reason: collision with root package name */
    private final Object f28166b;

    public JsonDecode(Object obj) {
        this.f28166b = obj;
    }

    private Object a(Field field, Class<?> cls, Object obj) throws JsonException {
        if (Map.class.isAssignableFrom(cls)) {
            Class<?> a10 = a.a(field, 1);
            if (a10 != null) {
                if (obj instanceof JSONObject) {
                    return a(a10, (JSONObject) obj);
                }
                throw new JsonException("Is not a JSONObject, jsonValue:" + obj);
            }
            throw new JsonException("Generic type argument is null.");
        }
        if (List.class.isAssignableFrom(cls)) {
            Class<?> a11 = a.a(field, 0);
            if (a11 != null) {
                if (obj instanceof JSONArray) {
                    return a(a11, (JSONArray) obj);
                }
                throw new JsonException("Is not a JSONArray, jsonValue:" + obj);
            }
            throw new JsonException("Generic type argument is null.");
        }
        if (!cls.isArray()) {
            return a(cls, obj);
        }
        throw new JsonException("Unsupported type: " + ((Object) cls));
    }

    public void fromJson(JSONObject jSONObject) throws JsonException, IllegalAccessException {
        Object opt;
        Object a10;
        for (Field field : a.a(this.f28166b.getClass())) {
            field.setAccessible(true);
            String jsonName = getJsonName(field);
            if (!TextUtils.isEmpty(jsonName) && (opt = jSONObject.opt(jsonName)) != null && opt != JSONObject.NULL && (a10 = a(field, field.getType(), opt)) != null) {
                field.set(this.f28166b, a10);
            }
        }
    }

    public Object instanceFromValue(Class<?> cls, Object obj) {
        return null;
    }

    public JsonDecode newSelf(Object obj) {
        return new JsonDecode(obj);
    }

    private Object a(Class<?> cls, Object obj) throws JsonException {
        if (String.class.equals(cls)) {
            return com.huawei.flexiblelayout.json.a.e(obj);
        }
        if (a.b(cls)) {
            return com.huawei.flexiblelayout.json.a.b(cls, obj);
        }
        if (JSONObject.class.equals(cls) || JSONArray.class.equals(cls)) {
            return obj;
        }
        if (Jsonable.class.isAssignableFrom(cls) && !cls.isInterface()) {
            try {
                Object newInstance = cls.newInstance();
                newSelf(newInstance).fromJson((JSONObject) obj);
                return newInstance;
            } catch (IllegalAccessException | InstantiationException e2) {
                throw new JsonException("Failed to instance: " + ((Object) cls), e2);
            }
        }
        try {
            Object instanceFromValue = instanceFromValue(cls, obj);
            if (instanceFromValue != null) {
                return instanceFromValue;
            }
            if (cls.isInstance(obj)) {
                return obj;
            }
            throw new JsonException("Unsupported type, field: " + ((Object) cls));
        } catch (Exception e10) {
            throw new JsonException("Failed to instance: " + ((Object) cls), e10);
        }
    }

    private Object a(Class<?> cls, JSONArray jSONArray) throws JsonException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object opt = jSONArray.opt(i10);
            if (opt != null) {
                opt = a(cls, opt);
            }
            if (opt != null) {
                if (cls.equals(opt.getClass())) {
                    arrayList.add(opt);
                } else {
                    Log.e(f28165c, "listFromJson error, memberClass:" + ((Object) cls) + ", valueClass:" + ((Object) opt.getClass()));
                }
            }
        }
        return arrayList;
    }

    private Object a(Class<?> cls, JSONObject jSONObject) throws JsonException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null) {
                opt = a(cls, opt);
            }
            if (opt != null) {
                if (cls.equals(opt.getClass())) {
                    linkedHashMap.put(next, opt);
                } else {
                    Log.e(f28165c, "mapFromJson error, memberClass:" + ((Object) cls) + ", valueClass:" + ((Object) opt.getClass()));
                }
            }
        }
        return linkedHashMap;
    }
}
