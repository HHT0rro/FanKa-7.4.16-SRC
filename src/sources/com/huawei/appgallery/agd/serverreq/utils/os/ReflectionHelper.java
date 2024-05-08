package com.huawei.appgallery.agd.serverreq.utils.os;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReflectionHelper {
    public static Object invokeMethod(Method method, Object obj, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return method.invoke(obj, objArr);
    }

    public static Class<?> loadClass(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public static Method loadMethod(Class<?> cls, String str, Object... objArr) throws ClassNotFoundException, NoSuchMethodException {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj instanceof Class) {
                clsArr[i10] = (Class) obj;
            } else if (obj instanceof String) {
                clsArr[i10] = loadClass((String) obj);
            }
        }
        return cls.getMethod(str, clsArr);
    }
}
