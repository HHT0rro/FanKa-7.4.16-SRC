package com.huawei.appgallery.agd.serverreq.json;

import android.text.TextUtils;
import com.huawei.appgallery.agd.serverreq.ServerReqLog;
import com.huawei.secure.android.common.util.SafeString;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ReflectAPI {

    /* renamed from: a, reason: collision with root package name */
    public static final String f27532a = "ReflectAPI";

    public static Class a(Field field, int i10) {
        Type[] actualTypeArguments;
        Type genericType = field.getGenericType();
        if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > i10) {
            try {
                if (actualTypeArguments[i10] instanceof Class) {
                    return (Class) actualTypeArguments[i10];
                }
                String obj = actualTypeArguments[i10].toString();
                int indexOf = obj.indexOf("class ");
                if (indexOf < 0) {
                    indexOf = 0;
                }
                int indexOf2 = obj.indexOf("<");
                if (indexOf2 < 0) {
                    indexOf2 = obj.length();
                }
                return Class.forName(SafeString.substring(obj, indexOf, indexOf2));
            } catch (ClassNotFoundException e2) {
                ServerReqLog.LOG.e(f27532a, "getType exception!" + e2.getMessage());
            }
        }
        return null;
    }

    public static Field[] getDeclaredFields(Class cls) {
        Field[] declaredFields = cls.getSuperclass() != null ? getDeclaredFields(cls.getSuperclass()) : null;
        Field[] declaredFields2 = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            Field[] fieldArr = new Field[declaredFields2.length + declaredFields.length];
            System.arraycopy(declaredFields, 0, fieldArr, 0, declaredFields.length);
            System.arraycopy(declaredFields2, 0, fieldArr, declaredFields.length, declaredFields2.length);
            declaredFields2 = fieldArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields2) {
            if (field.getName().indexOf("$") < 0) {
                arrayList.add(field);
            }
        }
        if (arrayList.size() == declaredFields2.length) {
            return declaredFields2;
        }
        Field[] fieldArr2 = new Field[arrayList.size()];
        arrayList.toArray(fieldArr2);
        return fieldArr2;
    }

    public static Class getMapListGenericType(Field field) {
        int i10;
        if (Map.class.isAssignableFrom(field.getType())) {
            i10 = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i10 = 0;
        }
        return a(field, i10);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Not such method:");
                sb2.append(str);
                sb2.append(e2.getMessage());
            }
        }
        return null;
    }
}
