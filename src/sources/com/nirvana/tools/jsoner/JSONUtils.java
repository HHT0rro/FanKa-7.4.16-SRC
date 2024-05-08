package com.nirvana.tools.jsoner;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class JSONUtils {
    private static final JsonCache JSON_CACHE = new JsonCache();

    public static <T> T fromJson(JSONObject jSONObject, JsonType<T> jsonType, List<Field> list) {
        T newInstance = jsonType.newInstance();
        if (!(newInstance instanceof Jsoner)) {
            return (T) fromJson(jSONObject, newInstance, list);
        }
        ((Jsoner) newInstance).fromJson(jSONObject);
        return newInstance;
    }

    public static <T> T fromJson(JSONObject jSONObject, T t2, List<Field> list) {
        if (jSONObject != null && t2 != null) {
            Class<?> cls = t2.getClass();
            JsonCache jsonCache = JSON_CACHE;
            a jsonClass = jsonCache.getJsonClass(cls);
            if (jsonClass == null) {
                jsonClass = new a(cls);
                jsonCache.putJsonClass(cls, jsonClass);
            }
            List<Field> list2 = jsonClass.f37687a;
            if (list2 != null && list2.size() > 0) {
                for (Field field : list2) {
                    b a10 = jsonClass.a(field.getName());
                    if (a10 == null) {
                        a10 = new b(field);
                        jsonClass.a(field.getName(), a10);
                    }
                    if (!a10.f37691c) {
                        String str = a10.f37689a;
                        if (jSONObject.has(str)) {
                            if (a10.a()) {
                                setOriginalType(field, str, jSONObject, t2);
                            } else if (a10.b()) {
                                try {
                                    field.setAccessible(true);
                                    Jsoner jsoner = (Jsoner) a10.f37690b.newInstance();
                                    Object opt = jSONObject.opt(str);
                                    if (opt instanceof JSONObject) {
                                        jsoner.fromJson((JSONObject) opt);
                                    } else if (opt instanceof String) {
                                        jsoner.fromJson(new JSONObject(String.valueOf(opt)));
                                    }
                                    field.set(t2, jsoner);
                                    field = null;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (field != null && list != null) {
                            list.add(field);
                        }
                    }
                }
            }
        }
        return t2;
    }

    public static boolean isOriginalBoolean(Class<?> cls) {
        return Boolean.TYPE.equals(cls) || Boolean.class.equals(cls) || boolean[].class.equals(cls) || Boolean[].class.equals(cls);
    }

    public static boolean isOriginalChar(Class<?> cls) {
        return Byte.TYPE.equals(cls) || Byte.class.equals(cls) || byte[].class.equals(cls) || Byte[].class.equals(cls) || Character.TYPE.equals(cls) || Character.class.equals(cls) || char[].class.equals(cls) || Character[].class.equals(cls);
    }

    public static boolean isOriginalNumber(Class<?> cls) {
        return Integer.TYPE.equals(cls) || Integer.class.equals(cls) || int[].class.equals(cls) || Integer[].class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || short[].class.equals(cls) || Short[].class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || long[].class.equals(cls) || Long[].class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls) || float[].class.equals(cls) || Float[].class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || double[].class.equals(cls) || Double[].class.equals(cls);
    }

    public static boolean isOriginalString(Class<?> cls) {
        return String.class.equals(cls) || StringBuilder.class.equals(cls) || String[].class.equals(cls) || StringBuilder[].class.equals(cls) || StringBuffer.class.equals(cls) || CharSequence.class.equals(cls) || StringBuffer[].class.equals(cls) || CharSequence[].class.equals(cls);
    }

    public static Map<String, Integer> json2MapForStringInteger(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(jSONObject.length());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, Integer.valueOf(jSONObject.getInt(next)));
            }
            return hashMap;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> json2MapForStringString(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return json2MapForStringString(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> json2MapForStringString(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.length() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(jSONObject.length());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T extends Jsoner> JSONArray jsonerCollection2JsonArray(Collection<T> collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection != null && collection.size() > 0) {
            Iterator<T> iterator2 = collection.iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(iterator2.next().toJson());
            }
        }
        return jSONArray;
    }

    public static JSONArray jsonerCollectionString2JsonArray(Collection<String> collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection != null && collection.size() > 0) {
            Iterator<String> iterator2 = collection.iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(iterator2.next());
            }
        }
        return jSONArray;
    }

    public static <T extends Jsoner> JSONArray jsonerList2JsonArray(List<T> list) {
        return jsonerCollection2JsonArray(list);
    }

    public static <T extends Jsoner> List<T> parseJsonArray2JsonerList(String str, JsonType<T> jsonType) {
        try {
            return parseJsonArray2JsonerList(new JSONArray(str), jsonType);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T extends Jsoner> List<T> parseJsonArray2JsonerList(JSONArray jSONArray, JsonType<T> jsonType) {
        if (jSONArray == null) {
            return null;
        }
        try {
            int length = jSONArray.length();
            if (length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    T newInstance = jsonType.newInstance();
                    newInstance.fromJson(jSONObject);
                    arrayList.add(newInstance);
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean setOriginalType(Field field, String str, JSONObject jSONObject, Object obj) {
        Object valueOf;
        try {
            field.setAccessible(true);
            Class<?> type = field.getType();
            if (String.class.equals(type)) {
                valueOf = jSONObject.optString(str);
            } else {
                if (!Boolean.TYPE.equals(type) && !Boolean.class.equals(type)) {
                    if (!Integer.TYPE.equals(type) && !Integer.class.equals(type)) {
                        if (!Long.TYPE.equals(type) && !Long.class.equals(type)) {
                            if (!Double.TYPE.equals(type) && !Double.class.equals(type)) {
                                valueOf = jSONObject.opt(str);
                            }
                            valueOf = Double.valueOf(jSONObject.optDouble(str));
                        }
                        valueOf = Long.valueOf(jSONObject.optLong(str));
                    }
                    valueOf = Integer.valueOf(jSONObject.optInt(str));
                }
                valueOf = Boolean.valueOf(jSONObject.optBoolean(str));
            }
            field.set(obj, valueOf);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static JSONObject toJson(Object obj, List<Field> list) {
        return toJson(obj, list, false);
    }

    public static JSONObject toJson(Object obj, List<Field> list, boolean z10) {
        JSONObject json;
        JSONObject jSONObject = new JSONObject();
        Class<?> cls = obj.getClass();
        JsonCache jsonCache = JSON_CACHE;
        a jsonClass = jsonCache.getJsonClass(cls);
        if (jsonClass == null) {
            jsonClass = new a(cls);
            jsonCache.putJsonClass(cls, jsonClass);
        }
        List<Field> list2 = jsonClass.f37687a;
        if (list2 != null && list2.size() > 0) {
            for (Field field : list2) {
                b a10 = jsonClass.a(field.getName());
                if (a10 == null) {
                    a10 = new b(field);
                    jsonClass.a(field.getName(), a10);
                }
                if (!a10.f37691c) {
                    if (a10.a()) {
                        try {
                            field.setAccessible(true);
                            Object obj2 = field.get(obj);
                            if (!z10 || obj2 != null) {
                                jSONObject.put(a10.f37689a, obj2);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        if (a10.b()) {
                            field.setAccessible(true);
                            Jsoner jsoner = (Jsoner) field.get(obj);
                            if (jsoner != null && ((json = jsoner.toJson()) != null || !z10)) {
                                jSONObject.put(a10.f37689a, json);
                            }
                        }
                        if (field != null && list != null) {
                            list.add(field);
                        }
                    }
                    field = null;
                    if (field != null) {
                        list.add(field);
                    }
                }
            }
        }
        return jSONObject;
    }
}
