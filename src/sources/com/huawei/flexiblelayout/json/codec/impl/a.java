package com.huawei.flexiblelayout.json.codec.impl;

import android.text.TextUtils;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flexiblelayout.log.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Codec.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28170a = "Codec";

    public static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte);
    }

    public static boolean b(Class<?> cls) {
        return Boolean.class == cls || Boolean.TYPE == cls || Double.class == cls || Double.TYPE == cls || Float.class == cls || Float.TYPE == cls || Long.class == cls || Long.TYPE == cls || Integer.class == cls || Integer.TYPE == cls || Short.class == cls || Short.TYPE == cls || Byte.class == cls || Byte.TYPE == cls;
    }

    public String getJsonName(Field field) {
        JsonPacked jsonPacked;
        if (Modifier.isStatic(field.getModifiers()) || field.getType().equals(getClass()) || (jsonPacked = (JsonPacked) field.getAnnotation(JsonPacked.class)) == null) {
            return "";
        }
        String value = jsonPacked.value();
        return TextUtils.isEmpty(value) ? field.getName() : value;
    }

    public static Field[] a(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
            return declaredFields;
        }
        Field[] a10 = a((Class<?>) cls.getSuperclass());
        if (a10.length == 0) {
            return declaredFields;
        }
        if (declaredFields.length == 0) {
            return a10;
        }
        Field[] fieldArr = new Field[declaredFields.length + a10.length];
        System.arraycopy(a10, 0, fieldArr, 0, a10.length);
        System.arraycopy(declaredFields, 0, fieldArr, a10.length, declaredFields.length);
        return fieldArr;
    }

    public static Class<?> a(Field field, int i10) {
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
            if (actualTypeArguments.length > i10) {
                if (actualTypeArguments[i10] instanceof Class) {
                    return (Class) actualTypeArguments[i10];
                }
                try {
                    return Class.forName(a(actualTypeArguments[i10].toString()));
                } catch (ClassNotFoundException e2) {
                    Log.e(f28170a, "Failed to get generic type argument: " + e2.getMessage());
                }
            }
        }
        return null;
    }

    private static String a(String str) {
        int indexOf = str.indexOf("class ");
        if (indexOf < 0) {
            indexOf = 0;
        }
        int indexOf2 = str.indexOf("<");
        if (indexOf2 < 0) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }
}
