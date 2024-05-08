package com.huawei.flexiblelayout.json.codec.impl;

import android.text.TextUtils;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import com.huawei.flexiblelayout.json.codec.Jsonable;
import com.huawei.flexiblelayout.log.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonReaderDecode extends a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f28168c = "JsonReaderDecode";

    /* renamed from: b, reason: collision with root package name */
    private final Object f28169b;

    public JsonReaderDecode(Object obj) {
        this.f28169b = obj;
    }

    private Object a(Field field, Class<?> cls, Object obj) {
        if (Map.class.isAssignableFrom(cls)) {
            Class<?> a10 = a.a(field, 1);
            if (a10 == null) {
                Log.e(f28168c, "Failed to get generic type argument, field: " + ((Object) cls));
                return null;
            }
            if (!(obj instanceof FLImmutableMap)) {
                Log.e(f28168c, "Expected is a JsonObjReader, but is a " + ((Object) obj.getClass()) + ".");
                return null;
            }
            return a(a10, (FLImmutableMap) obj);
        }
        if (List.class.isAssignableFrom(cls)) {
            Class<?> a11 = a.a(field, 0);
            if (a11 == null) {
                Log.e(f28168c, "Failed to get generic type argument, field: " + ((Object) cls));
                return null;
            }
            if (!(obj instanceof FLImmutableArray)) {
                Log.e(f28168c, "Expected value is a JsonArrReader, but is a " + ((Object) obj.getClass()) + ".");
                return null;
            }
            return a(a11, (FLImmutableArray) obj);
        }
        if (cls.isArray()) {
            Log.e(f28168c, "Unsupported array, field: " + ((Object) cls));
            return null;
        }
        return a(cls, obj);
    }

    public void fromJson(FLImmutableMap fLImmutableMap) {
        Object obj;
        Object a10;
        for (Field field : a.a(this.f28169b.getClass())) {
            field.setAccessible(true);
            String jsonName = getJsonName(field);
            if (!TextUtils.isEmpty(jsonName) && (obj = fLImmutableMap.get(jsonName)) != null && (a10 = a(field, field.getType(), obj)) != null) {
                try {
                    field.set(this.f28169b, a10);
                } catch (IllegalAccessException | IllegalArgumentException unused) {
                }
            }
        }
    }

    public Object instanceFromValue(Class<?> cls, Object obj) {
        return null;
    }

    public JsonReaderDecode newSelf(Object obj) {
        return new JsonReaderDecode(obj);
    }

    private Object a(Class<?> cls, Object obj) {
        if (String.class.equals(cls)) {
            return com.huawei.flexiblelayout.json.a.e(obj);
        }
        if (a.b(cls)) {
            return com.huawei.flexiblelayout.json.a.b(cls, obj);
        }
        if (JSONObject.class.equals(cls)) {
            if (!(obj instanceof FLImmutableMap)) {
                Log.e(f28168c, "Expected value is a JsonObjReader, but is a " + ((Object) obj.getClass()) + ".");
                return null;
            }
            try {
                return com.huawei.flexiblelayout.json.a.a((MapModel) obj);
            } catch (JSONException unused) {
                Log.e(f28168c, "JSONException when converting JsonObjReader to JSONObject.");
            }
        } else if (JSONArray.class.equals(cls)) {
            if (!(obj instanceof FLImmutableArray)) {
                Log.e(f28168c, "Expected value is a JsonArrReader, but is a " + ((Object) obj.getClass()) + ".");
                return null;
            }
            try {
                return com.huawei.flexiblelayout.json.a.a((ListModel) obj);
            } catch (JSONException unused2) {
                Log.e(f28168c, "JSONException when converting JsonArrReader to JSONArray.");
            }
        } else if (Jsonable.class.isAssignableFrom(cls) && !cls.isInterface()) {
            if (!(obj instanceof FLImmutableMap)) {
                Log.e(f28168c, "Expected value is a JsonObjReader, but is a " + ((Object) obj.getClass()) + ".");
                return null;
            }
            try {
                Object newInstance = cls.newInstance();
                newSelf(newInstance).fromJson((FLImmutableMap) obj);
                return newInstance;
            } catch (IllegalAccessException | InstantiationException e2) {
                Log.e(f28168c, "Failed to instance, field: " + ((Object) cls), e2);
            }
        } else {
            try {
                Object instanceFromValue = instanceFromValue(cls, obj);
                if (instanceFromValue != null) {
                    return instanceFromValue;
                }
                if (cls.isInstance(obj)) {
                    return obj;
                }
            } catch (Exception e10) {
                Log.e(f28168c, "Failed to instance, field: " + ((Object) cls), e10);
                return null;
            }
        }
        Log.e(f28168c, "Unsupported type, field: " + ((Object) cls));
        return null;
    }

    private Object a(Class<?> cls, FLImmutableArray fLImmutableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < fLImmutableArray.size(); i10++) {
            Object obj = fLImmutableArray.get(i10);
            if (obj != null) {
                obj = a(cls, obj);
            }
            if (obj != null) {
                if (cls.equals(obj.getClass())) {
                    arrayList.add(obj);
                } else {
                    Log.e(f28168c, "listFromJson error, memberClass:" + ((Object) cls) + ", valueClass:" + ((Object) obj.getClass()));
                }
            }
        }
        return arrayList;
    }

    private Object a(Class<?> cls, FLImmutableMap fLImmutableMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = fLImmutableMap.size();
        String[] keys = fLImmutableMap.keys();
        for (int i10 = 0; i10 < size; i10++) {
            String str = keys[i10];
            Object obj = fLImmutableMap.get(str);
            if (obj != null) {
                obj = a(cls, obj);
            }
            if (obj != null) {
                if (cls.equals(obj.getClass())) {
                    linkedHashMap.put(str, obj);
                } else {
                    Log.e(f28168c, "mapFromJson error, memberClass:" + ((Object) cls) + ", valueClass:" + ((Object) obj.getClass()));
                }
            }
        }
        return linkedHashMap;
    }
}
