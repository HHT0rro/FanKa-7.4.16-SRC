package com.huawei.appgallery.agd.serverreq.json;

import androidx.annotation.NonNull;
import com.alipay.sdk.util.i;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.appgallery.agd.serverreq.ServerReqLog;
import com.huawei.appgallery.agd.serverreq.json.annotation.FieldSecurity;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import com.huawei.secure.android.common.util.SafeString;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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
    private static final char COMMA = ',';
    private static final String END_FLAG = "_";
    private static final int END_FLAG_LENGTH = 1;
    private static final String TAG = "JsonBean";
    private static boolean isDebug;

    private void appendJsonBean(StringBuilder sb2, JsonBean jsonBean, boolean z10) throws IllegalAccessException {
        if (z10) {
            jsonBean.toFilterJson(sb2);
        } else {
            jsonBean.toJson(sb2);
        }
    }

    private void formatJsonStr(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            int i10 = length - 1;
            if (sb2.charAt(i10) == ',') {
                sb2.delete(i10, length);
            }
        }
    }

    private boolean isCanPrint(String str, Field field) {
        if (str == null) {
            return false;
        }
        return str.endsWith("_") || field.isAnnotationPresent(NetworkTransmission.class);
    }

    public static boolean isFieldPrivacy(Field field) {
        Annotation[] declaredAnnotations;
        if (isDebug || (declaredAnnotations = field.getDeclaredAnnotations()) == null || declaredAnnotations.length < 1) {
            return false;
        }
        for (Annotation annotation : declaredAnnotations) {
            if ((annotation instanceof FieldSecurity) && ((FieldSecurity) annotation).security() == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean isPrimitive(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        try {
            return ((Class) cls.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isValidField(String str, Field field) {
        if (str == null || field == null) {
            return false;
        }
        return str.endsWith("_") || field.isAnnotationPresent(NetworkTransmission.class);
    }

    private Object jsonBeanFromJson(Class cls, Object obj) throws InstantiationException, IllegalAccessException, IllegalArgumentException, JSONException {
        JsonBean jsonBean = (JsonBean) cls.newInstance();
        jsonBean.fromJson((JSONObject) obj);
        return jsonBean;
    }

    private void listToJson(StringBuilder sb2, List list, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        String str;
        int size = list.size();
        if (size <= 0) {
            str = "[]";
        } else {
            sb2.append("[");
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = list.get(i10);
                if (obj != null) {
                    valueToJson(sb2, obj, z10);
                    sb2.append(COMMA);
                }
            }
            formatJsonStr(sb2);
            str = "]";
        }
        sb2.append(str);
    }

    private Object mapFromJson(Class cls, Object obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException {
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
            Object valueFromJson = valueFromJson(cls, null, jSONObject.get(next));
            if (valueFromJson != null) {
                if (cls.equals(valueFromJson.getClass())) {
                    linkedHashMap.put(next, valueFromJson);
                } else {
                    ServerReqLog.LOG.e(TAG, "mapFromJson error, memberClass");
                }
            }
        }
        return linkedHashMap;
    }

    private void mapToJson(StringBuilder sb2, Map map, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        String str;
        if (map.size() <= 0) {
            str = "{}";
        } else {
            sb2.append("{");
            Iterator iterator2 = map.entrySet().iterator2();
            while (true) {
                Map.Entry entry = (Map.Entry) iterator2.next();
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    sb2.append("\"");
                    sb2.append(str2);
                    sb2.append("\":");
                    valueToJson(sb2, value, z10);
                }
                if (!iterator2.hasNext()) {
                    break;
                } else {
                    sb2.append(COMMA);
                }
            }
            str = i.f4738d;
        }
        sb2.append(str);
    }

    private Object parsePrimitiveType(Class cls, Object obj) {
        if ((obj instanceof Double) && ("float".equals(cls.getName()) || "java.lang.Float".equals(cls.getName()))) {
            return Float.valueOf(((Double) obj).floatValue());
        }
        boolean z10 = obj instanceof Integer;
        return (z10 && ("short".equals(cls.getName()) || "java.lang.Short".equals(cls.getName()))) ? Short.valueOf(((Integer) obj).shortValue()) : z10 ? ("long".equals(cls.getName()) || "java.lang.Long".equals(cls.getName())) ? Long.valueOf(((Integer) obj).longValue()) : obj : obj;
    }

    private void processValueError(Field field, Object obj) {
        ServerReqLog serverReqLog;
        String str;
        StringBuilder sb2;
        String message;
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
            } catch (IllegalAccessException e2) {
                serverReqLog = ServerReqLog.LOG;
                str = TAG;
                sb2 = new StringBuilder();
                sb2.append("processValueError Throwable:");
                message = e2.getMessage();
                sb2.append(message);
                serverReqLog.e(str, sb2.toString());
            } catch (NumberFormatException e10) {
                serverReqLog = ServerReqLog.LOG;
                str = TAG;
                sb2 = new StringBuilder();
                sb2.append("processValueError NumberFormatException:");
                message = e10.getMessage();
                sb2.append(message);
                serverReqLog.e(str, sb2.toString());
            }
        }
    }

    public static void setIsDebug(boolean z10) {
        isDebug = z10;
    }

    private Object valueFromJson(Class cls, Class cls2, Object obj) throws IllegalAccessException, IllegalArgumentException, InstantiationException, ClassNotFoundException, JSONException {
        if (isPrimitive(cls)) {
            return parsePrimitiveType(cls, obj);
        }
        if (cls.equals(String.class) || cls.equals(JSONObject.class)) {
            return obj;
        }
        if (List.class.isAssignableFrom(cls)) {
            return listFromJson(cls2, obj);
        }
        if (JsonBean.class.isAssignableFrom(cls)) {
            if (!cls.equals(JsonBean.class)) {
                return jsonBeanFromJson(cls, obj);
            }
            throw new IllegalArgumentException("error type, type:" + ((Object) cls));
        }
        if (Map.class.isAssignableFrom(cls)) {
            return mapFromJson(cls2, obj);
        }
        throw new IllegalArgumentException("unsupport type, Type:" + ((Object) cls));
    }

    private void valueToJson(@NonNull StringBuilder sb2, @NonNull Object obj, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        String valueOf;
        if (obj instanceof String) {
            valueOf = JSONObject.quote(obj.toString());
        } else {
            if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Short)) {
                if (obj instanceof JsonBean) {
                    appendJsonBean(sb2, (JsonBean) obj, z10);
                    return;
                } else if (obj instanceof List) {
                    listToJson(sb2, (List) obj, z10);
                    return;
                } else {
                    if (obj instanceof Map) {
                        mapToJson(sb2, (Map) obj, z10);
                        return;
                    }
                    return;
                }
            }
            valueOf = String.valueOf(obj);
        }
        sb2.append(valueOf);
    }

    public void fromJson(JSONObject jSONObject) throws IllegalArgumentException, JSONException {
        Field[] declaredFields = ReflectAPI.getDeclaredFields(getClass());
        Object obj = null;
        for (int i10 = 0; i10 < declaredFields.length; i10++) {
            Field field = declaredFields[i10];
            field.setAccessible(true);
            String name = field.getName();
            if (isValidField(name, field)) {
                if (name.endsWith("_")) {
                    name = SafeString.substring(name, 0, name.length() - END_FLAG_LENGTH);
                }
                if (jSONObject.has(name)) {
                    Object obj2 = jSONObject.get(name);
                    if (!JSONObject.NULL.equals(obj2)) {
                        try {
                            obj = valueFromJson(field.getType(), ReflectAPI.getMapListGenericType(field), obj2);
                            declaredFields[i10].set(this, obj);
                        } catch (ClassNotFoundException e2) {
                            e = e2;
                            ServerReqLog.LOG.e(TAG, getClass().getName() + ".fromJson error, fieldName:" + name + ",cause: " + e.getMessage());
                            processValueError(field, obj);
                        } catch (IllegalAccessException e10) {
                            e = e10;
                            ServerReqLog.LOG.e(TAG, getClass().getName() + ".fromJson error, fieldName:" + name + ",cause: " + e.getMessage());
                            processValueError(field, obj);
                        } catch (IllegalArgumentException e11) {
                            e = e11;
                            ServerReqLog.LOG.e(TAG, getClass().getName() + ".fromJson error, fieldName:" + name + ",cause: " + e.getMessage());
                            processValueError(field, obj);
                        } catch (InstantiationException e12) {
                            e = e12;
                            ServerReqLog.LOG.e(TAG, getClass().getName() + ".fromJson error, fieldName:" + name + ",cause: " + e.getMessage());
                            processValueError(field, obj);
                        } catch (JSONException unused) {
                            ServerReqLog.LOG.e(TAG, getClass().getName() + ".fromJson error, fieldName:" + name + " :JSONException");
                            processValueError(field, obj);
                        }
                    }
                }
            }
        }
    }

    public String getSafeData() {
        try {
            StringBuilder sb2 = new StringBuilder(512);
            toFilterJson(sb2);
            return sb2.toString();
        } catch (IllegalAccessException | IllegalArgumentException unused) {
            ServerReqLog.LOG.e(TAG, "safe data to json error");
            return null;
        }
    }

    public Object listFromJson(Class cls, Object obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        }
        if (!(obj instanceof JSONArray)) {
            throw new IllegalArgumentException("jsonobject is not JSONArray, jsonValue:" + obj);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = (JSONArray) obj;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object valueFromJson = valueFromJson(cls, null, jSONArray.get(i10));
            if (valueFromJson != null) {
                if (cls.equals(valueFromJson.getClass())) {
                    arrayList.add(valueFromJson);
                } else {
                    ServerReqLog.LOG.e(TAG, "listFromJson error, memberClass");
                }
            }
        }
        return arrayList;
    }

    public void toFilterJson(StringBuilder sb2) throws IllegalAccessException, IllegalArgumentException {
        Field[] declaredFields = ReflectAPI.getDeclaredFields(getClass());
        if (declaredFields.length <= 0) {
            return;
        }
        sb2.append("{");
        for (Field field : declaredFields) {
            field.setAccessible(true);
            String name = field.getName();
            if (isCanPrint(name, field)) {
                if (name.endsWith("_")) {
                    name = SafeString.substring(name, 0, name.length() - END_FLAG_LENGTH);
                }
                Object obj = field.get(this);
                if (isFieldPrivacy(field)) {
                    sb2.append("\"");
                    sb2.append(name);
                    sb2.append("\":\"");
                    sb2.append(StringUtils.SENSITIVE_CODE);
                    sb2.append("\"");
                } else if (obj != null) {
                    sb2.append("\"");
                    sb2.append(name);
                    sb2.append("\":");
                    valueToJson(sb2, obj, true);
                }
                sb2.append(COMMA);
            }
        }
        formatJsonStr(sb2);
        sb2.append(i.f4738d);
    }

    public String toJson() throws IllegalAccessException, IllegalArgumentException {
        StringBuilder sb2 = new StringBuilder(512);
        toJson(sb2);
        return sb2.toString();
    }

    public void toJson(StringBuilder sb2) throws IllegalAccessException, IllegalArgumentException {
        Field[] declaredFields = ReflectAPI.getDeclaredFields(getClass());
        if (declaredFields.length <= 0) {
            return;
        }
        sb2.append("{");
        for (Field field : declaredFields) {
            field.setAccessible(true);
            String name = field.getName();
            if (isValidField(name, field)) {
                if (name.endsWith("_")) {
                    name = SafeString.substring(name, 0, name.length() - END_FLAG_LENGTH);
                }
                Object obj = field.get(this);
                if (obj != null) {
                    sb2.append("\"");
                    sb2.append(name);
                    sb2.append("\":");
                    valueToJson(sb2, obj, false);
                    sb2.append(COMMA);
                }
            }
        }
        formatJsonStr(sb2);
        sb2.append(i.f4738d);
    }
}
