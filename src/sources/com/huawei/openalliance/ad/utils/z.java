package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class z {
    private static final String B = "z";
    private static final Map<Class, h> C;
    private static final char I = ',';
    private static final String Z = "__";
    private static final Class[] Code = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Character.class, Boolean.class};
    private static final Class[] V = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Boolean.class};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements h<Boolean, Object> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Boolean V(Object obj) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof String) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements h<Byte, Number> {
        private b() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Byte V(Number number) {
            return Byte.valueOf(number.byteValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c implements h<Double, Number> {
        private c() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Double V(Number number) {
            return Double.valueOf(number.doubleValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d implements h<Float, Number> {
        private d() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Float V(Number number) {
            return Float.valueOf(number.floatValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class e implements h<Integer, Number> {
        private e() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Integer V(Number number) {
            return Integer.valueOf(number.intValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class f implements h<Long, Number> {
        private f() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Long V(Number number) {
            return Long.valueOf(number.longValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class g implements h<Short, Number> {
        private g() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Short V(Number number) {
            return Short.valueOf(number.shortValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface h<D, S> {
        D V(S s2);
    }

    static {
        HashMap hashMap = new HashMap();
        C = hashMap;
        e eVar = new e();
        hashMap.put(Integer.TYPE, eVar);
        hashMap.put(Integer.class, eVar);
        f fVar = new f();
        hashMap.put(Long.TYPE, fVar);
        hashMap.put(Long.class, fVar);
        d dVar = new d();
        hashMap.put(Float.TYPE, dVar);
        hashMap.put(Float.class, dVar);
        c cVar = new c();
        hashMap.put(Double.TYPE, cVar);
        hashMap.put(Double.class, cVar);
        g gVar = new g();
        hashMap.put(Short.TYPE, gVar);
        hashMap.put(Short.class, gVar);
        b bVar = new b();
        hashMap.put(Byte.TYPE, bVar);
        hashMap.put(Byte.class, bVar);
        a aVar = new a();
        hashMap.put(Boolean.TYPE, aVar);
        hashMap.put(Boolean.class, aVar);
    }

    private static Object Code(Class cls, Class cls2, Object obj) {
        if (V(cls)) {
            return Code(cls, obj);
        }
        if (List.class.isAssignableFrom(cls)) {
            return V(cls, cls2, obj);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return Code(cls, cls2, null, obj);
        }
        if (obj instanceof JSONObject) {
            return Code((JSONObject) obj, cls, new Class[]{cls2});
        }
        if (obj instanceof JSONArray) {
            return Code((JSONArray) obj, cls, new Class[]{cls2});
        }
        throw Code("value from json error, field class: %s", cls);
    }

    private static Object Code(Class cls, Object obj) {
        h hVar;
        if (String.class == cls) {
            return au.Code(obj);
        }
        if ((cls.isPrimitive() || Number.class.isAssignableFrom(cls)) && (obj instanceof Number)) {
            obj = (Number) obj;
            hVar = C.get(cls);
            if (hVar == null) {
                gl.I(B, "cannot find value reader for: %s", cls);
                return null;
            }
            return hVar.V(obj);
        }
        if (cls != Boolean.class) {
            return obj;
        }
        hVar = C.get(cls);
        if (hVar == null) {
            gl.I(B, "cannot find value reader for: %s", cls);
            return null;
        }
        return hVar.V(obj);
    }

    public static <T> T Code(String str, Class<T> cls, Class... clsArr) {
        if (TextUtils.isEmpty(str)) {
            throw Code(false, "Input json string cannot be empty!", new Object[0]);
        }
        Code((Class) cls);
        return (T) I(str, cls, clsArr);
    }

    private static <T> T Code(JSONArray jSONArray, Class<T> cls, Class[] clsArr) {
        if (!List.class.isAssignableFrom(cls)) {
            throw Code("Obj class (%s) is not List type", cls);
        }
        Class cls2 = null;
        if (clsArr != null && clsArr.length > 0) {
            cls2 = clsArr[0];
        }
        return (T) V(cls, cls2, jSONArray);
    }

    private static <T> T Code(JSONObject jSONObject, Class<T> cls, Class[] clsArr) {
        Class cls2;
        if (Collection.class.isAssignableFrom(cls)) {
            throw Code("Obj class %s is Collection type which mismatches with JsonObject", cls);
        }
        if (cls.isArray()) {
            throw Code("Obj class %s is array type which mismatches with JsonObject", cls);
        }
        if (!Map.class.isAssignableFrom(cls)) {
            try {
                return (T) Code(jSONObject, cls.getConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception unused) {
                throw Code("New instance failed for %s", cls);
            }
        }
        if (clsArr == null || clsArr.length <= 0) {
            cls2 = null;
        } else {
            Class cls3 = clsArr[0];
            cls2 = clsArr.length > 1 ? clsArr[1] : null;
            r0 = cls3;
        }
        return (T) Code(cls, r0, cls2, jSONObject);
    }

    private static <T> T Code(JSONObject jSONObject, T t2) {
        Object opt;
        for (Field field : an.Code(t2.getClass())) {
            Field Code2 = an.Code(field, true);
            if (V(Code2) && (opt = jSONObject.opt(Code(Code2))) != null && JSONObject.NULL != opt) {
                Code(t2, Code2, opt);
            }
        }
        return t2;
    }

    public static <T> T Code(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            gl.Code(B, "%s is not exist or Json object is null", str);
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return (T) jSONObject.get(str);
            }
            return null;
        } catch (Throwable unused) {
            gl.I(B, "getFromJsonObject JSONException");
            return null;
        }
    }

    public static String Code(Object obj) {
        try {
            return Code(obj, false);
        } catch (IllegalAccessException unused) {
            throw Code("toJson error", new Object[0]);
        }
    }

    private static String Code(Object obj, boolean z10) {
        if (obj == null) {
            return "";
        }
        Code((Class) obj.getClass());
        return obj instanceof List ? Code((List) obj, z10) : obj instanceof Map ? Code((Map) obj, z10) : V(obj, z10);
    }

    private static String Code(Field field) {
        com.huawei.openalliance.ad.annotations.c cVar = (com.huawei.openalliance.ad.annotations.c) field.getAnnotation(com.huawei.openalliance.ad.annotations.c.class);
        if (cVar != null && !TextUtils.isEmpty(cVar.Code())) {
            return cVar.Code();
        }
        String name = field.getName();
        return name.endsWith(Z) ? name.substring(0, name.length() - 2) : name;
    }

    private static String Code(List list, boolean z10) {
        if (list.size() <= 0) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String I2 = I(list.get(i10), z10);
            if (I2 != null) {
                sb2.append(I2);
                sb2.append(I);
            }
        }
        Code(sb2);
        sb2.append(']');
        return sb2.toString();
    }

    private static String Code(Map map, boolean z10) {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        Set<Map.Entry> entrySet = map.entrySet();
        int i10 = 0;
        int size = entrySet.size();
        for (Map.Entry entry : entrySet) {
            i10++;
            String str = (String) entry.getKey();
            String I2 = I(entry.getValue(), z10);
            if (I2 != null) {
                sb2.append('\"');
                sb2.append(str);
                sb2.append("\":");
                sb2.append(I2);
            }
            if (i10 < size && I2 != null) {
                sb2.append(I);
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    private static Map Code(Class cls, Class cls2, Class cls3, Object obj) {
        Map map;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (cls3 == null) {
            cls3 = String.class;
        }
        if (!(obj instanceof JSONObject)) {
            throw Code("jsonVal not JSONObject", new Object[0]);
        }
        if (Map.class == cls) {
            map = new LinkedHashMap();
        } else {
            if (!Map.class.isAssignableFrom(cls)) {
                throw Code("%s is not Map type", cls);
            }
            try {
                map = (Map) cls.newInstance();
            } catch (IllegalAccessException unused) {
                throw Code("Fail to initiate %s", cls);
            } catch (InstantiationException unused2) {
                throw Code("Fail to initiate %s", cls);
            }
        }
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object Code2 = Code(cls2, cls3, jSONObject.get(next));
            if (Code2 != null) {
                if (cls2.isAssignableFrom(Code2.getClass())) {
                    map.put(next, Code2);
                } else {
                    gl.Z(B, "mapFromJson err, memberC:" + ((Object) cls2) + ", valueC:" + ((Object) Code2.getClass()));
                }
            }
        }
        return map;
    }

    public static Map<String, String> Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(trim);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next).toString().trim());
            }
            return hashMap;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static JSONException Code(String str, Object... objArr) {
        return Code(true, str, objArr);
    }

    private static JSONException Code(boolean z10, String str, Object... objArr) {
        String format = String.format(Locale.ENGLISH, str, objArr);
        if (z10) {
            gl.I(B, format);
        }
        return new JSONException(format);
    }

    private static void Code(Class cls) {
        if (cls.isPrimitive()) {
            throw Code("Root obj class (%s) cannot be primitive type!", cls);
        }
        int length = Code.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (cls == Code[i10]) {
                throw Code("Root obj class (%s) is invalid", cls);
            }
        }
    }

    private static void Code(Object obj, Field field, Object obj2) {
        Object obj3 = null;
        try {
            obj3 = Code(field.getType(), an.Code(field), obj2);
            field.set(obj, obj3);
        } catch (RuntimeException unused) {
            gl.I(B, obj.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + ((Object) field));
        } catch (Exception unused2) {
            gl.I(B, obj.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + ((Object) field));
            V(obj, field, obj3);
        }
    }

    private static void Code(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }

    private static <T> T I(String str, Class<T> cls, Class[] clsArr) {
        try {
            try {
                return (T) Code(new JSONObject(str), cls, clsArr);
            } catch (JSONException unused) {
                return (T) Code(new JSONArray(str), cls, clsArr);
            }
        } catch (JSONException unused2) {
            throw Code("Input string is not valid json string!", new Object[0]);
        }
    }

    private static String I(Object obj, boolean z10) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof String) && !(obj instanceof Character)) {
            return I(obj) ? obj.toString() : obj instanceof List ? Code((List) obj, z10) : obj instanceof Map ? Code((Map) obj, z10) : obj.getClass().isArray() ? Z(obj, z10) : Code(obj, z10);
        }
        return "\"" + au.Z(obj.toString()) + "\"";
    }

    private static boolean I(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Double) || (obj instanceof Short);
    }

    public static <T> T V(String str, Class<T> cls, Class... clsArr) {
        String str2;
        StringBuilder sb2;
        try {
            return (T) Code(str, cls, clsArr);
        } catch (JSONException e2) {
            e = e2;
            str2 = B;
            sb2 = new StringBuilder();
            sb2.append("toObject ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(str2, sb2.toString());
            return null;
        } catch (Exception e10) {
            e = e10;
            str2 = B;
            sb2 = new StringBuilder();
            sb2.append("toObject ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(str2, sb2.toString());
            return null;
        }
    }

    public static String V(Object obj) {
        try {
            return Code(obj);
        } catch (JSONException unused) {
            gl.I(B, "toJson jsex");
            return "";
        }
    }

    private static String V(Object obj, boolean z10) {
        Field[] Code2 = an.Code(obj.getClass());
        if (Code2.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        int length = Code2.length;
        for (int i10 = 0; i10 < length; i10++) {
            Code2[i10] = an.Code(Code2[i10], true);
            if (V(Code2[i10])) {
                String Code3 = Code(Code2[i10]);
                Object obj2 = Code2[i10].get(obj);
                String I2 = (z10 && Code2[i10].isAnnotationPresent(com.huawei.openalliance.ad.annotations.a.class)) ? obj2 != null ? "\"******\"" : null : I(obj2, z10);
                if (I2 != null) {
                    sb2.append('\"');
                    sb2.append(Code3);
                    sb2.append("\":");
                    sb2.append(I2);
                    if (i10 < length - 1) {
                        sb2.append(I);
                    }
                }
            }
        }
        Code(sb2);
        sb2.append('}');
        return sb2.toString();
    }

    private static List V(Class cls, Class cls2, Object obj) {
        List list;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (!(obj instanceof JSONArray)) {
            throw Code("jsonobj is not JSONArray", new Object[0]);
        }
        if (cls == List.class) {
            list = new ArrayList();
        } else {
            if (!List.class.isAssignableFrom(cls)) {
                throw Code("%s is not List type", cls);
            }
            try {
                list = (List) cls.newInstance();
            } catch (IllegalAccessException unused) {
                throw Code("Fail to initiate %s", cls);
            } catch (InstantiationException unused2) {
                throw Code("Fail to initiate %s", cls);
            }
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object Code2 = Code(cls2, (Class) null, jSONArray.get(i10));
            if (Code2 != null) {
                if (cls2.isAssignableFrom(Code2.getClass())) {
                    list.add(Code2);
                } else {
                    gl.Z(B, "listFromJson error, memberC:" + ((Object) cls2) + ", valueC:" + ((Object) Code2.getClass()));
                }
            }
        }
        return list;
    }

    private static void V(Object obj, Field field, Object obj2) {
        Object valueOf;
        if (obj2 == null || !(obj2 instanceof String)) {
            return;
        }
        try {
            Class<?> type = field.getType();
            if (type.isPrimitive()) {
                if (Integer.TYPE == type) {
                    valueOf = Integer.valueOf(Integer.parseInt((String) obj2));
                } else if (Float.TYPE == type) {
                    valueOf = Float.valueOf(Float.parseFloat((String) obj2));
                } else if (Long.TYPE == type) {
                    valueOf = Long.valueOf(Long.parseLong((String) obj2));
                } else if (Boolean.TYPE == type) {
                    valueOf = Boolean.valueOf(Boolean.parseBoolean((String) obj2));
                } else if (Double.TYPE == type) {
                    valueOf = Double.valueOf(Double.parseDouble((String) obj2));
                } else if (Short.TYPE == type) {
                    valueOf = Short.valueOf(Short.parseShort((String) obj2));
                } else if (Byte.TYPE == type) {
                    valueOf = Byte.valueOf(Byte.parseByte((String) obj2));
                } else if (Character.TYPE != type) {
                    return;
                } else {
                    valueOf = Character.valueOf(((String) obj2).charAt(0));
                }
                field.set(obj, valueOf);
            }
        } catch (Throwable unused) {
            gl.Z(B, "processValueError");
        }
    }

    private static boolean V(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        int length = V.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (cls == V[i10]) {
                return true;
            }
        }
        return false;
    }

    private static boolean V(Field field) {
        if (field == null) {
            return false;
        }
        String name = field.getName();
        return (Modifier.isStatic(field.getModifiers()) || name == null || name.contains("$") || field.isAnnotationPresent(com.huawei.openalliance.ad.annotations.d.class)) ? false : true;
    }

    private static String Z(Object obj, boolean z10) {
        int length = Array.getLength(obj);
        if (length <= 0) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (int i10 = 0; i10 < length; i10++) {
            String I2 = I(Array.get(obj, i10), z10);
            if (I2 != null) {
                sb2.append(I2);
                sb2.append(I);
            }
        }
        Code(sb2);
        sb2.append(']');
        return sb2.toString();
    }
}
