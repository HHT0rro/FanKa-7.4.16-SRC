package com.ishumei.smantifraud.l111l1111llIl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111I1l {
    public static Object l1111l111111Il(Object obj, String str) {
        return l1111l111111Il(obj, l1111l111111Il(obj.getClass(), str, (Class[]) null), new Object[0]);
    }

    public static Object l1111l111111Il(Object obj, String str, Class[] clsArr, Object[] objArr) {
        return l1111l111111Il(obj, l1111l111111Il(obj.getClass(), str, clsArr), objArr);
    }

    private static Object l1111l111111Il(Object obj, Field field) {
        field.setAccessible(true);
        return field.get(obj);
    }

    private static Object l1111l111111Il(Object obj, Method method, Object... objArr) {
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }

    private static Object l1111l111111Il(String str, String str2) {
        return l1111l111111Il((Object) null, l1111l111111Il(Class.forName(str), str2, (Class[]) null), new Object[0]);
    }

    public static Object l1111l111111Il(String str, String str2, Class[] clsArr, Object[] objArr) {
        return l1111l111111Il((Object) null, l1111l111111Il(Class.forName(str), str2, clsArr), objArr);
    }

    private static Field l1111l111111Il(Class<?> cls, String str) {
        try {
            try {
                return cls.getField(str);
            } catch (NoSuchFieldException unused) {
                return cls.getDeclaredField(str);
            }
        } catch (NoSuchFieldException e2) {
            if (cls.getSuperclass() != null) {
                return l1111l111111Il((Class<?>) cls.getSuperclass(), str);
            }
            throw e2;
        }
    }

    private static Method l1111l111111Il(Class<?> cls, String str, Class[] clsArr) {
        try {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
                return cls.getDeclaredMethod(str, clsArr);
            }
        } catch (NoSuchMethodException e2) {
            if (cls.getSuperclass() != null) {
                return l1111l111111Il(cls.getSuperclass(), str, clsArr);
            }
            throw e2;
        }
    }

    private static Field[] l1111l111111Il(Class cls) {
        return cls.getDeclaredFields();
    }

    private static Field[] l1111l111111Il(Object obj) {
        return obj.getClass().getDeclaredFields();
    }

    private static Field[] l1111l111111Il(String str) {
        return Class.forName(str).getDeclaredFields();
    }

    public static Object l111l11111lIl(Object obj, String str) {
        return l1111l111111Il(obj, l1111l111111Il(obj.getClass(), str));
    }

    private static Object l111l11111lIl(String str, String str2) {
        return l1111l111111Il((Object) null, l1111l111111Il(Class.forName(str), str2));
    }
}
