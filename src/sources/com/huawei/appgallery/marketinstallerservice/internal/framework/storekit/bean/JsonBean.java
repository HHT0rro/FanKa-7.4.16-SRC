package com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean;

import com.alipay.sdk.util.i;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class JsonBean {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements PrivilegedAction<Field> {

        /* renamed from: a, reason: collision with root package name */
        public Field f27616a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f27617b;

        public a(Field field, boolean z10) {
            this.f27616a = field;
            this.f27617b = z10;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Field run() {
            this.f27616a.setAccessible(this.f27617b);
            return this.f27616a;
        }
    }

    public static String arrayToJson(Array array) {
        int length = Array.getLength(array);
        if (length <= 0) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (int i10 = 0; i10 < length; i10++) {
            String c4 = c(Array.get(array, i10));
            if (c4 != null) {
                sb2.append(c4);
                sb2.append(',');
            }
        }
        e(sb2);
        sb2.append("]");
        return sb2.toString();
    }

    public static String c(Object obj) {
        if (obj == null) {
            return "\"null\"";
        }
        if (obj instanceof String) {
            return "\"" + obj.toString() + "\"";
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Short)) {
            return String.valueOf(obj);
        }
        if (obj instanceof JsonBean) {
            return ((JsonBean) obj).toJson();
        }
        if (obj instanceof List) {
            return listToJson((List) obj);
        }
        if (obj instanceof Map) {
            return mapToJson((Map) obj);
        }
        if (obj.getClass().isArray()) {
            return arrayToJson((Array) obj);
        }
        return null;
    }

    public static void e(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }

    public static String listToJson(List list) {
        if (list.size() <= 0) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (int i10 = 0; i10 < list.size(); i10++) {
            String c4 = c(list.get(i10));
            if (c4 != null) {
                sb2.append(c4);
                sb2.append(',');
            }
        }
        e(sb2);
        sb2.append("]");
        return sb2.toString();
    }

    public static String mapToJson(Map map) {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        Iterator iterator2 = map.entrySet().iterator2();
        while (true) {
            Map.Entry entry = (Map.Entry) iterator2.next();
            String str = (String) entry.getKey();
            String c4 = c(entry.getValue());
            if (c4 != null) {
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                sb2.append(c4);
            }
            if (!iterator2.hasNext()) {
                sb2.append(i.f4738d);
                return sb2.toString();
            }
            if (c4 != null) {
                sb2.append(',');
            }
        }
    }

    public final Object a(Class cls, Class cls2, Object obj) {
        if (cls.isPrimitive() || String.class.toString().equals(cls.toString())) {
            return ("float".equals(cls.getName()) && (obj instanceof Double)) ? Float.valueOf(((Double) obj).floatValue()) : obj;
        }
        if (List.class.isAssignableFrom(cls)) {
            return b(cls2, obj);
        }
        if (JsonBean.class.isAssignableFrom(cls)) {
            if (!cls.toString().equals(JsonBean.class.toString())) {
                return h(cls, obj);
            }
            throw new IllegalArgumentException("error type, type:" + ((Object) cls));
        }
        if (Map.class.isAssignableFrom(cls)) {
            return g(cls2, obj);
        }
        throw new IllegalArgumentException("unsupport type, Type:" + ((Object) cls));
    }

    public Object b(Class cls, Object obj) {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        }
        if (!(obj instanceof JSONArray)) {
            throw new IllegalArgumentException("jsonobject is not JSONArray, jsonValue:" + obj);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = (JSONArray) obj;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object a10 = a(cls, null, jSONArray.get(i10));
            if (a10 != null) {
                if (a10.getClass().toString().equals(cls.toString())) {
                    arrayList.add(a10);
                } else {
                    fa.a.c("JsonBean", "listFromJson error, memberClass:" + ((Object) cls) + ", valueClass:" + ((Object) a10.getClass()));
                }
            }
        }
        return arrayList;
    }

    public final Field d(Field field, boolean z10) {
        return (Field) AccessController.doPrivileged(new a(field, z10));
    }

    public final void f(Field field, Object obj) {
        Object valueOf;
        if (obj instanceof String) {
            try {
                Class<?> type = field.getType();
                if (type.isPrimitive()) {
                    String name = type.getName();
                    if (IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL.equals(name)) {
                        valueOf = Integer.valueOf(Integer.parseInt((String) obj));
                    } else if ("float".equals(name)) {
                        valueOf = Float.valueOf(Float.parseFloat((String) obj));
                    } else if ("long".equals(name)) {
                        valueOf = Long.valueOf(Long.parseLong((String) obj));
                    } else if ("boolean".equals(name)) {
                        valueOf = Boolean.valueOf(Boolean.parseBoolean((String) obj));
                    } else if ("double".equals(name)) {
                        valueOf = Double.valueOf(Double.parseDouble((String) obj));
                    } else if ("short".equals(name)) {
                        valueOf = Short.valueOf(Short.parseShort((String) obj));
                    } else if ("byte".equals(name)) {
                        valueOf = Byte.valueOf(Byte.parseByte((String) obj));
                    } else if (!"char".equals(name)) {
                        return;
                    } else {
                        valueOf = Character.valueOf(((String) obj).charAt(0));
                    }
                    field.set(this, valueOf);
                }
            } catch (Throwable unused) {
                fa.a.c("JsonBean", "processValueError error!");
            }
        }
    }

    public void fromJson(JSONObject jSONObject) {
        StringBuilder sb2;
        String str;
        Field[] c4 = ha.a.c(getClass());
        Object obj = null;
        for (int i10 = 0; i10 < c4.length; i10++) {
            Field field = c4[i10];
            String name = field.getName();
            if (c4[i10].isAnnotationPresent(InstallerNetTransmission.class) && jSONObject.has(name)) {
                Object obj2 = jSONObject.get(name);
                if (!JSONObject.NULL.equals(obj2)) {
                    boolean isAccessible = field.isAccessible();
                    Field d10 = d(field, true);
                    try {
                        obj = a(d10.getType(), ha.a.a(d10), obj2);
                        c4[i10].set(this, obj);
                    } catch (ClassNotFoundException e2) {
                        e = e2;
                        sb2 = new StringBuilder();
                        sb2.append(getClass().getName());
                        str = ".fromJson error ClassNotFoundException, fieldName:";
                        sb2.append(str);
                        sb2.append(name);
                        fa.a.b("JsonBean", sb2.toString(), e);
                        f(d10, obj);
                        d(d10, isAccessible);
                    } catch (IllegalAccessException e10) {
                        e = e10;
                        sb2 = new StringBuilder();
                        sb2.append(getClass().getName());
                        str = ".fromJson error IllegalAccessException, fieldName:";
                        sb2.append(str);
                        sb2.append(name);
                        fa.a.b("JsonBean", sb2.toString(), e);
                        f(d10, obj);
                        d(d10, isAccessible);
                    } catch (IllegalArgumentException e11) {
                        e = e11;
                        sb2 = new StringBuilder();
                        sb2.append(getClass().getName());
                        str = ".fromJson error IllegalArgumentException, fieldName:";
                        sb2.append(str);
                        sb2.append(name);
                        fa.a.b("JsonBean", sb2.toString(), e);
                        f(d10, obj);
                        d(d10, isAccessible);
                    } catch (InstantiationException e12) {
                        e = e12;
                        sb2 = new StringBuilder();
                        sb2.append(getClass().getName());
                        str = ".fromJson error InstantiationException, fieldName:";
                        sb2.append(str);
                        sb2.append(name);
                        fa.a.b("JsonBean", sb2.toString(), e);
                        f(d10, obj);
                        d(d10, isAccessible);
                    } catch (JSONException unused) {
                        fa.a.c("JsonBean", getClass().getName() + ".fromJson error JSONException, fieldName:" + name + " :JSONException");
                        f(d10, obj);
                        d(d10, isAccessible);
                    }
                    d(d10, isAccessible);
                }
            }
        }
    }

    public Object g(Class cls, Object obj) {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        }
        if (!(obj instanceof JSONObject)) {
            throw new IllegalArgumentException("jsonobject is not JSONObject, jsonValue:" + obj);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object a10 = a(cls, null, jSONObject.get(next));
            if (a10 != null) {
                if (a10.getClass().toString().equals(cls.toString())) {
                    linkedHashMap.put(next, a10);
                } else {
                    fa.a.c("JsonBean", "mapFromJson error, memberClass:" + ((Object) cls) + ", valueClass:" + ((Object) a10.getClass()));
                }
            }
        }
        return linkedHashMap;
    }

    public final Object h(Class cls, Object obj) {
        JsonBean jsonBean = (JsonBean) cls.newInstance();
        jsonBean.fromJson((JSONObject) obj);
        return jsonBean;
    }

    public String toJson() {
        Object obj;
        Field[] c4 = ha.a.c(getClass());
        if (c4.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        for (int i10 = 0; i10 < c4.length; i10++) {
            Field field = c4[i10];
            String name = field.getName();
            if (field.isAnnotationPresent(InstallerNetTransmission.class)) {
                boolean isAccessible = field.isAccessible();
                Field d10 = d(field, true);
                try {
                    try {
                        obj = d10.get(this);
                    } catch (IllegalAccessException unused) {
                        fa.a.c("JsonBean", "can not access");
                        obj = null;
                    }
                    String c10 = c(obj);
                    if (c10 != null) {
                        sb2.append("\"");
                        sb2.append(name);
                        sb2.append("\":");
                        sb2.append(c10);
                        sb2.append(',');
                    } else {
                        fa.a.c("JsonBean", "valueToJson error, field:" + ((Object) c4[i10]));
                    }
                } finally {
                    d(d10, isAccessible);
                }
            }
        }
        e(sb2);
        sb2.append(i.f4738d);
        return sb2.toString();
    }
}
