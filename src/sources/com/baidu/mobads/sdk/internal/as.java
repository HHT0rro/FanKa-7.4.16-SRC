package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class as {

    /* renamed from: a, reason: collision with root package name */
    public static bs f9826a = bs.a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f9827b = "com.baidu.mobads.sdk.internal.as";

    public static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Exception e2) {
                f9826a.a(f9827b, Log.getStackTraceString(e2));
            }
        }
        return null;
    }

    public static Field b(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e2) {
                f9826a.b(f9827b, Log.getStackTraceString(e2));
            }
        }
        return null;
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Class<?> a10 = a(str, classLoader);
            if (a10 == null) {
                return null;
            }
            Method declaredMethod = a10.getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Field b(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e2) {
                f9826a.b(f9827b, Log.getStackTraceString(e2));
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (NoSuchMethodException unused) {
            return false;
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return false;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        Field b4 = b(obj, str);
        if (b4 == null) {
            return null;
        }
        b4.setAccessible(true);
        try {
            return b4.get(obj);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(Class cls, String str) {
        Field b4 = b((Class<?>) cls, str);
        if (b4 == null) {
            return null;
        }
        b4.setAccessible(true);
        try {
            return b4.get(cls);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj.getClass(), obj, str, a(objArr), objArr);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Class<?>[] a(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i10 = 0; i10 < length; i10++) {
                clsArr[i10] = objArr[i10].getClass();
            }
            return clsArr;
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (a(cls, str, clsArr)) {
                return b(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a10 = a(str, classLoader);
            if (a10 != null) {
                return a10.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a10 = a(str);
            if (a10 != null) {
                return a10.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, InvocationHandler invocationHandler) {
        Class<?> a10 = a(str, classLoader);
        if (a10 != null) {
            return Proxy.newProxyInstance(a10.getClassLoader(), new Class[]{a10}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, InvocationHandler invocationHandler) {
        Class<?> a10 = a(str);
        if (a10 != null) {
            return Proxy.newProxyInstance(a10.getClassLoader(), new Class[]{a10}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a10 = a(str, classLoader);
            if (a10 == null || (declaredMethod = a10.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a10 = a(str);
            if (a10 == null || (declaredMethod = a10.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(ClassLoader classLoader, String str, String str2) {
        try {
            return a((Class) Class.forName(str, true, classLoader), str2);
        } catch (Exception e2) {
            f9826a.b(f9827b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static ClassLoader a(Context context) {
        return ao.a(by.a(context), context.getFilesDir().getAbsolutePath(), (String) null, as.class.getClassLoader());
    }
}
