package com.tencent.cloud.huiyansdkface.wejson;

import android.text.TextUtils;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeJson {
    private static final String EMPTY_ARR = "[]";
    private static final String EMPTY_MAP = "{}";
    private static final String[] replacementArr = new String[128];
    private boolean cutLongStr = false;
    private int longStringLength = 262144;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TypeToken<T> {
        public Type type() {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            }
            throw new RuntimeException("weJson:get type failed");
        }
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            replacementArr[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = replacementArr;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    private <T> T fromArr(JSONArray jSONArray, Class cls) throws WeJsonException {
        T t2 = (T) Array.newInstance((Class<?>) cls, jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Array.set(t2, i10, fromJsonData(getObject(jSONArray, i10), cls));
        }
        return t2;
    }

    private <T> T fromArr(JSONArray jSONArray, GenericArrayType genericArrayType) throws WeJsonException {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        T t2 = (T) Array.newInstance((Class<?>) getClassOfType(genericComponentType), jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Array.set(t2, i10, fromJsonData(getObject(jSONArray, i10), genericComponentType));
        }
        return t2;
    }

    private Object fromJsonData(Object obj, Type type) throws WeJsonException {
        return obj instanceof JSONArray ? fromJsonArr((JSONArray) obj, type) : obj instanceof JSONObject ? fromJsonObj((JSONObject) obj, type) : obj;
    }

    private List fromList(JSONArray jSONArray, Class<List> cls, Type type) throws WeJsonException {
        List newInstance;
        if (cls.getName().equals("java.util.List")) {
            newInstance = new ArrayList();
        } else {
            try {
                newInstance = cls.newInstance();
            } catch (Exception e2) {
                throw new WeJsonException("创建List类型失败,该列表不支持无参实例化", e2);
            }
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object object = getObject(jSONArray, i10);
            if (type != null || (object instanceof JSONObject) || (object instanceof JSONArray)) {
                if (object instanceof JSONArray) {
                    object = fromJsonArr((JSONArray) object, type);
                } else if (object instanceof JSONObject) {
                    object = fromJsonObj((JSONObject) object, type);
                }
            }
            newInstance.add(object);
        }
        return newInstance;
    }

    private Map fromMap(JSONObject jSONObject, Class<Map> cls, Type type) throws WeJsonException {
        Map newInstance;
        if (cls.getName().equals("java.util.Map")) {
            newInstance = new HashMap();
        } else {
            try {
                newInstance = cls.newInstance();
            } catch (Exception e2) {
                throw new WeJsonException("创建Map类型失败,该Map不支持无参实例化", e2);
            }
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object object = getObject(jSONObject, next);
            if (object == null) {
                object = null;
            } else if (type != null || (object instanceof JSONObject) || (object instanceof JSONArray)) {
                object = fromJsonData(object, ((object instanceof JSONObject) && type == null) ? Map.class : ((object instanceof JSONArray) && type == null) ? List.class : type);
            }
            newInstance.put(next, object);
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object fromPojo(JSONObject jSONObject, Type type) throws WeJsonException {
        Object valueOf;
        Method method;
        Type type2 = type;
        ArrayList arrayList = new ArrayList();
        Class classOfType = getClassOfType(type2);
        for (Class cls = classOfType; cls != null && !cls.equals(Object.class); cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                arrayList.add(field);
            }
        }
        Object obj = null;
        if (arrayList.size() == 0) {
            return null;
        }
        try {
            Object newInstance = classOfType.newInstance();
            int i10 = 0;
            while (i10 < arrayList.size()) {
                Field field2 = (Field) arrayList.get(i10);
                String name = field2.getName();
                if (!name.contains("$")) {
                    int modifiers = field2.getModifiers();
                    Object opt = jSONObject.opt(name);
                    if (opt != null) {
                        Object fromJsonData = fromJsonData(opt, getMemberType(type2, field2, opt));
                        if (JSONObject.NULL.equals(fromJsonData)) {
                            fromJsonData = obj;
                        }
                        Class<?> type3 = field2.getType();
                        boolean z10 = type3.equals(Double.class) || type3.equals(Double.TYPE);
                        boolean z11 = type3.equals(Float.class) || type3.equals(Float.TYPE);
                        boolean z12 = type3.equals(Long.class) || type3.equals(Long.TYPE);
                        if ((modifiers & 1) != 0) {
                            try {
                                if (fromJsonData instanceof Number) {
                                    if (z10) {
                                        valueOf = Double.valueOf(((Number) fromJsonData).doubleValue());
                                    } else if (z11) {
                                        valueOf = Float.valueOf(((Number) fromJsonData).floatValue());
                                    } else if (z12) {
                                        valueOf = Long.valueOf(((Number) fromJsonData).longValue());
                                    }
                                    field2.set(newInstance, valueOf);
                                }
                                field2.set(newInstance, fromJsonData);
                            } catch (IllegalAccessException e2) {
                                throw new WeJsonException("设置成员变量值失败.", e2);
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("set");
                            sb2.append(name.substring(0, 1).toUpperCase());
                            sb2.append(name.length() == 1 ? "" : name.substring(1));
                            try {
                                method = classOfType.getMethod(sb2.toString(), type3);
                                try {
                                } catch (IllegalAccessException e10) {
                                    throw new WeJsonException("调用set方法失败.", e10);
                                } catch (InvocationTargetException e11) {
                                    throw new WeJsonException("调用set方法失败.", e11);
                                }
                            } catch (NoSuchMethodException unused) {
                            }
                            if (!(fromJsonData instanceof Number)) {
                                method.invoke(newInstance, fromJsonData);
                                i10++;
                                type2 = type;
                                obj = null;
                            } else if (z10) {
                                method.invoke(newInstance, Double.valueOf(((Number) fromJsonData).doubleValue()));
                            } else if (z11) {
                                method.invoke(newInstance, Float.valueOf(((Number) fromJsonData).floatValue()));
                            } else if (z12) {
                                method.invoke(newInstance, Long.valueOf(((Number) fromJsonData).longValue()));
                            } else {
                                method.invoke(newInstance, fromJsonData);
                            }
                        }
                    }
                }
                i10++;
                type2 = type;
                obj = null;
            }
            return newInstance;
        } catch (Exception e12) {
            throw new WeJsonException("必须为该类型提供一个无参构造方法:" + classOfType.getName(), e12);
        }
    }

    private Class getClassOfType(Type type) {
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        boolean z10 = type instanceof TypeVariable;
        return null;
    }

    private Type getComponentTypeOfList(Type type, JSONArray jSONArray) throws WeJsonException {
        Class cls;
        while (true) {
            if (type instanceof Class) {
                cls = (Class) type;
                Type typeOfList = getTypeOfList(type, "java.util.List", jSONArray);
                if (typeOfList != null) {
                    return typeOfList;
                }
            } else {
                if (!(type instanceof ParameterizedType)) {
                    throw new WeJsonException("unsupported type:" + ((Object) type));
                }
                cls = (Class) ((ParameterizedType) type).getRawType();
                Type typeOfList2 = getTypeOfList(type, "java.util.List", jSONArray);
                if (typeOfList2 != null) {
                    return typeOfList2;
                }
            }
            type = cls.getGenericSuperclass();
        }
    }

    private <T> Type getMemberType(Type type, Field field, Object obj) throws WeJsonException {
        Type genericType = field.getGenericType();
        if (genericType instanceof TypeVariable) {
            Class classOfType = getClassOfType(type);
            if (type instanceof ParameterizedType) {
                return ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Type genericSuperclass = classOfType.getGenericSuperclass();
            return genericSuperclass instanceof ParameterizedType ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : getValueType(obj);
        }
        if ((genericType instanceof ParameterizedType) || (genericType instanceof Class) || (genericType instanceof GenericArrayType)) {
            return genericType;
        }
        throw new WeJsonException("unsupported member type:" + ((Object) genericType));
    }

    private Object getObject(JSONArray jSONArray, int i10) throws WeJsonException {
        try {
            return jSONArray.get(i10);
        } catch (JSONException e2) {
            throw new WeJsonException("JSONArray.get() cause JSONException", e2);
        }
    }

    private Object getObject(JSONObject jSONObject, String str) throws WeJsonException {
        try {
            return jSONObject.get(str);
        } catch (JSONException e2) {
            throw new WeJsonException("JSONObject.get() cause JSONException", e2);
        }
    }

    private <T> Type getSubType(Type type, Field field, Object obj) throws WeJsonException {
        Type genericType = field.getGenericType();
        Class classOfType = getClassOfType(type);
        if (genericType instanceof TypeVariable) {
            Type genericSuperclass = classOfType.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                throw new WeJsonException("缺少泛型信息:" + ((Object) classOfType));
            }
            Type type2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            if (!(type2 instanceof Class)) {
                if (!(type2 instanceof ParameterizedType)) {
                    throw new WeJsonException("不支持嵌套泛型");
                }
                Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                if (type3 instanceof Class) {
                    return (Class) type3;
                }
                throw new WeJsonException("不支持这种嵌套模式");
            }
            Type genericSuperclass2 = ((Class) type2).getGenericSuperclass();
            if (!(genericSuperclass2 instanceof ParameterizedType)) {
                return null;
            }
            Type type4 = ((ParameterizedType) genericSuperclass2).getActualTypeArguments()[0];
            if (type4 instanceof Class) {
                return (Class) type4;
            }
            throw new WeJsonException("不支持这种嵌套模式");
        }
        if (List.class.isAssignableFrom(field.getType())) {
            if (!(genericType instanceof ParameterizedType)) {
                throw new WeJsonException("缺少泛型类型声明:" + field.getName());
            }
            Type type5 = ((ParameterizedType) genericType).getActualTypeArguments()[0];
            if (type5 instanceof Class) {
                return (Class) type5;
            }
            throw new WeJsonException("不支持嵌套泛型:" + field.getName());
        }
        if (Map.class.isAssignableFrom(field.getType())) {
            if (!(genericType instanceof ParameterizedType)) {
                throw new WeJsonException("缺少泛型类型声明:" + field.getName());
            }
            Type type6 = ((ParameterizedType) genericType).getActualTypeArguments()[1];
            if (type6 instanceof Class) {
                return (Class) type6;
            }
            throw new WeJsonException("不支持嵌套泛型:" + field.getName());
        }
        if (genericType instanceof ParameterizedType) {
            Type type7 = ((ParameterizedType) genericType).getActualTypeArguments()[0];
            if (type7 instanceof Class) {
                return (Class) type7;
            }
            throw new WeJsonException("不支持嵌套泛型:" + field.getName());
        }
        if (genericType instanceof WildcardType) {
            throw new WeJsonException("不支持WildcardType类型的泛型:" + field.getName());
        }
        if (!(genericType instanceof GenericArrayType)) {
            return null;
        }
        Type genericComponentType = ((GenericArrayType) genericType).getGenericComponentType();
        return genericComponentType instanceof ParameterizedType ? (Class) ((ParameterizedType) genericComponentType).getRawType() : (Class) genericComponentType;
    }

    private Type getTypeOfList(Type type, String str, JSONArray jSONArray) throws WeJsonException {
        Class cls;
        boolean z10 = type instanceof Class;
        if (z10) {
            cls = (Class) type;
        } else {
            if (!(type instanceof ParameterizedType)) {
                throw new WeJsonException("unsupported type of list:" + ((Object) type));
            }
            cls = (Class) ((ParameterizedType) type).getRawType();
        }
        if (!cls.equals(List.class) && !cls.equals(ArrayList.class) && !cls.equals(LinkedList.class)) {
            return null;
        }
        if (z10) {
            return getValueType(jSONArray.opt(0));
        }
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        return null;
    }

    private Type getValueType(Object obj) {
        return obj == null ? String.class : obj instanceof JSONObject ? Map.class : obj instanceof JSONArray ? List.class : obj instanceof String ? String.class : obj instanceof Integer ? Integer.class : obj instanceof Long ? Long.class : obj instanceof Boolean ? Boolean.class : obj instanceof Double ? Double.class : String.class;
    }

    private <T> boolean isPrimitivePackageType(T t2) {
        return (t2 instanceof Integer) || (t2 instanceof Short) || (t2 instanceof Long) || (t2 instanceof Byte) || (t2 instanceof Boolean) || (t2 instanceof Float) || (t2 instanceof Double) || (t2 instanceof Character);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void process(StringBuilder sb2, T t2) {
        if (!t2.getClass().isPrimitive()) {
            if (t2 instanceof String) {
                String str = (String) t2;
                if (this.cutLongStr && str.length() > this.longStringLength) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str.substring(0, 256));
                    sb3.append(".....");
                    sb3.append(str.length() - 512);
                    sb3.append(".........");
                    sb3.append(str.substring(str.length() - 256));
                    str = sb3.toString();
                }
                string(sb2, str);
                return;
            }
            if (!isPrimitivePackageType(t2)) {
                if (t2.getClass().isArray()) {
                    processArr(sb2, (Object[]) t2);
                    return;
                }
                if (t2 instanceof Iterable) {
                    processIterable(sb2, (Iterable) t2);
                    return;
                } else if (t2 instanceof Map) {
                    processMap(sb2, (Map) t2);
                    return;
                } else {
                    processObj(sb2, t2);
                    return;
                }
            }
        }
        sb2.append((Object) t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void processArr(StringBuilder sb2, Object[] objArr) {
        if (objArr.length == 0) {
            sb2.append("[]");
            return;
        }
        sb2.append('[');
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (objArr[i10] != null) {
                process(sb2, objArr[i10]);
                if (i10 < objArr.length - 1) {
                    sb2.append(',');
                }
            }
        }
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == ',') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append(']');
    }

    private void processIterable(StringBuilder sb2, Iterable iterable) {
        sb2.append('[');
        for (Object obj : iterable) {
            if (obj != null) {
                process(sb2, obj);
                sb2.append(',');
            }
        }
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == ',') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append(']');
    }

    private void processMap(StringBuilder sb2, Map<String, Object> map) {
        if (map.size() == 0) {
            sb2.append(EMPTY_MAP);
            return;
        }
        sb2.append('{');
        int i10 = 0;
        int size = map.size();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (key != null && !key.equals("") && value != null && (!(value instanceof String) || !entry.equals(""))) {
                sb2.append('\"');
                sb2.append(key);
                sb2.append('\"');
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                process(sb2, value);
                if (i10 < size - 1) {
                    sb2.append(',');
                }
                i10++;
            }
        }
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == ',') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append('}');
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void processObj(StringBuilder sb2, T t2) {
        int i10;
        StringBuilder sb3;
        String message;
        Object invoke;
        ArrayList arrayList = new ArrayList();
        Class<?> cls = t2.getClass();
        Class<?> cls2 = cls;
        while (true) {
            i10 = 0;
            if (cls2 == null || cls2.equals(Object.class)) {
                break;
            }
            Field[] declaredFields = cls2.getDeclaredFields();
            while (i10 < declaredFields.length) {
                arrayList.add(declaredFields[i10]);
                i10++;
            }
            cls2 = cls2.getSuperclass();
        }
        if (arrayList.size() == 0) {
            sb2.append(EMPTY_MAP);
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            Field field = (Field) arrayList.get(i11);
            int modifiers = field.getModifiers();
            if ((modifiers & 8) == 0) {
                String name = field.getName();
                if (!name.contains("$")) {
                    if ((modifiers & 1) != 0) {
                        Object obj = null;
                        try {
                            obj = field.get(t2);
                        } catch (IllegalAccessException e2) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("read public field value failed:");
                            sb4.append(e2.getMessage());
                        }
                        if (obj != null) {
                            hashMap.put(name, obj);
                        }
                    } else {
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(MonitorConstants.CONNECT_TYPE_GET);
                            sb5.append(name.substring(0, 1).toUpperCase());
                            sb5.append(name.length() == 1 ? "" : name.substring(1));
                            Method method = cls.getMethod(sb5.toString(), new Class[0]);
                            if (method != null && (invoke = method.invoke(t2, new Object[0])) != null) {
                                hashMap.put(name, invoke);
                            }
                        } catch (IllegalAccessException e10) {
                            sb3 = new StringBuilder();
                            sb3.append("read field value by getter method failed:");
                            message = e10.getMessage();
                            sb3.append(message);
                        } catch (NoSuchMethodException unused) {
                        } catch (InvocationTargetException e11) {
                            sb3 = new StringBuilder();
                            sb3.append("read field value by getter method failed:");
                            message = e11.getMessage();
                            sb3.append(message);
                        }
                    }
                }
            }
        }
        sb2.append('{');
        int size = hashMap.size();
        for (Map.Entry entry : hashMap.entrySet()) {
            i10++;
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                sb2.append('\"');
                sb2.append(str);
                sb2.append('\"');
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                process(sb2, value);
                if (i10 < size) {
                    sb2.append(',');
                }
            }
        }
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == ',') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append('}');
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void string(java.lang.StringBuilder r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String[] r0 = com.tencent.cloud.huiyansdkface.wejson.WeJson.replacementArr
            java.lang.String r1 = "\""
            r8.append(r1)
            int r2 = r9.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r8.append(r9, r4, r3)
        L2e:
            r8.append(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r8.append(r9, r4, r2)
        L3b:
            r8.append(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.wejson.WeJson.string(java.lang.StringBuilder, java.lang.String):void");
    }

    public <T> T fromJson(String str, Class<T> cls) throws WeJsonException {
        return (T) fromJson(str, (Type) cls);
    }

    public <T> T fromJson(String str, Type type) throws WeJsonException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (type == null) {
            throw new WeJsonException("必须指定typeOfT");
        }
        String trim = str.trim();
        if (trim.startsWith("[")) {
            try {
                T t2 = (T) fromJsonArr(new JSONArray(trim), type);
                if (t2 != null) {
                    return t2;
                }
            } catch (Exception e2) {
                throw new WeJsonException("json resolve err:" + e2.getMessage(), e2);
            }
        } else if (trim.startsWith("{")) {
            try {
                return (T) fromJsonObj(new JSONObject(trim), type);
            } catch (Exception e10) {
                throw new WeJsonException("json resolve err:" + e10.getMessage(), e10);
            }
        }
        throw new WeJsonException("illegal json format");
    }

    public <T> T fromJsonArr(JSONArray jSONArray, Type type) throws WeJsonException {
        if (type == null) {
            type = List.class;
        }
        if (type instanceof ParameterizedType) {
            Class<List> cls = (Class) ((ParameterizedType) type).getRawType();
            if (List.class.isAssignableFrom(cls)) {
                return (T) fromList(jSONArray, cls, getComponentTypeOfList(type, jSONArray));
            }
            throw new WeJsonException("unsupported type:" + ((Object) cls));
        }
        if (type instanceof GenericArrayType) {
            return (T) fromArr(jSONArray, (GenericArrayType) type);
        }
        if (type instanceof Class) {
            Class<List> cls2 = (Class) type;
            if (cls2.isArray()) {
                return (T) fromArr(jSONArray, cls2.getComponentType());
            }
            if (List.class.isAssignableFrom(cls2)) {
                return (T) fromList(jSONArray, cls2, getComponentTypeOfList(cls2, jSONArray));
            }
        }
        throw new WeJsonException("unsupported type:" + ((Object) type));
    }

    public Object fromJsonObj(JSONObject jSONObject, Type type) throws WeJsonException {
        if (type == null) {
            type = Map.class;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<Map> cls = (Class) parameterizedType.getRawType();
            return (Map.class.isAssignableFrom(cls) || HashMap.class.isAssignableFrom(cls)) ? fromMap(jSONObject, cls, parameterizedType.getActualTypeArguments()[1]) : fromPojo(jSONObject, type);
        }
        if (type instanceof Class) {
            return (type.equals(Map.class) || type.equals(HashMap.class)) ? fromMap(jSONObject, (Class) type, null) : fromPojo(jSONObject, type);
        }
        throw new WeJsonException("unsupported type:" + ((Object) type));
    }

    public void setCutLongStr(boolean z10) {
        this.cutLongStr = z10;
    }

    public void setLongStringLength(int i10) {
        if (i10 < 600) {
            i10 = 600;
        }
        this.longStringLength = i10;
    }

    public <T> String toJson(T t2) {
        return toJson(t2, 0);
    }

    public <T> String toJson(T t2, int i10) {
        if (t2 == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        process(sb2, t2);
        return sb2.toString();
    }
}
