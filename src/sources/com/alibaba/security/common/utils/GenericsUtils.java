package com.alibaba.security.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GenericsUtils {
    public static Class getSuperClassGenericType(Class cls) {
        return getSuperClassGenericType(cls, 0);
    }

    public static Class getSuperClassGenericType(Class cls, int i10) throws IndexOutOfBoundsException {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (i10 >= actualTypeArguments.length || i10 < 0 || !(actualTypeArguments[i10] instanceof Class)) {
            return Object.class;
        }
        return (Class) actualTypeArguments[i10];
    }
}
