package com.danlan.android.cognition.common;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Reflection {
    public static Method getMethod1(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method2 = getMethod2(cls, str, clsArr);
            try {
                method2.setAccessible(true);
            } catch (Throwable unused) {
            }
            return method2;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Method getMethod2(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable unused) {
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused2) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static boolean isNative(Class<?> cls, String str, Class<?>... clsArr) {
        Method method1 = getMethod1(cls, str, clsArr);
        return method1 != null && Modifier.isNative(method1.getModifiers());
    }
}
