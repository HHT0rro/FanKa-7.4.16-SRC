package com.xiaomi.push;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f47872a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f47873a;

        /* renamed from: b, reason: collision with root package name */
        public final T f47874b;
    }

    static {
        HashMap hashMap = new HashMap();
        f47872a = hashMap;
        Class<Boolean> cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        Class<Integer> cls2 = Integer.TYPE;
        hashMap.put(Integer.class, cls2);
        Class<Float> cls3 = Float.TYPE;
        hashMap.put(Float.class, cls3);
        Class<Long> cls4 = Long.TYPE;
        hashMap.put(Long.class, cls4);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(cls, cls);
        Class<Byte> cls5 = Byte.TYPE;
        hashMap.put(cls5, cls5);
        Class<Character> cls6 = Character.TYPE;
        hashMap.put(cls6, cls6);
        Class<Short> cls7 = Short.TYPE;
        hashMap.put(cls7, cls7);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        Class<Double> cls8 = Double.TYPE;
        hashMap.put(cls8, cls8);
    }

    public static <T> T a(Class<? extends Object> cls, Object obj, String str) {
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static <T> T b(Class<? extends Object> cls, String str) {
        try {
            return (T) a(cls, null, str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static <T> T c(Class<?> cls, String str, Object... objArr) {
        return (T) h(cls, str, k(objArr)).invoke(null, l(objArr));
    }

    public static <T> T d(Object obj, String str) {
        try {
            return (T) a(obj.getClass(), obj, str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static <T> T e(Object obj, String str, Object... objArr) {
        try {
            return (T) m(obj, str, objArr);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Meet exception when call Method '");
            sb2.append(str);
            sb2.append("' in ");
            sb2.append(obj);
            return null;
        }
    }

    public static <T> T f(String str, String str2) {
        try {
            return (T) a(n7.c(null, str), null, str2);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return null;
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static <T> T g(String str, String str2, Object... objArr) {
        try {
            return (T) c(n7.c(null, str), str2, objArr);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Meet exception when call Method '");
            sb2.append(str2);
            sb2.append("' in ");
            sb2.append(str);
            return null;
        }
    }

    public static Method h(Class<?> cls, String str, Class<?>... clsArr) {
        Method i10 = i(cls.getDeclaredMethods(), str, clsArr);
        if (i10 != null) {
            i10.setAccessible(true);
            return i10;
        }
        if (cls.getSuperclass() != null) {
            return h(cls.getSuperclass(), str, clsArr);
        }
        throw new NoSuchMethodException();
    }

    public static Method i(Method[] methodArr, String str, Class<?>[] clsArr) {
        Objects.requireNonNull(str, "Method name must not be null.");
        for (Method method : methodArr) {
            if (method.getName().equals(str) && j(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    public static boolean j(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            if (clsArr2[i10] != null && !clsArr[i10].isAssignableFrom(clsArr2[i10])) {
                Map<Class<?>, Class<?>> map = f47872a;
                if (!map.containsKey(clsArr[i10]) || !map.get(clsArr[i10]).equals(map.get(clsArr2[i10]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Class<?>[] k(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null || !(obj instanceof a)) {
                clsArr[i10] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i10] = ((a) obj).f47873a;
            }
        }
        return clsArr;
    }

    public static Object[] l(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i10] = obj;
            } else {
                objArr2[i10] = ((a) obj).f47874b;
            }
        }
        return objArr2;
    }

    public static <T> T m(Object obj, String str, Object... objArr) {
        return (T) h(obj.getClass(), str, k(objArr)).invoke(obj, l(objArr));
    }
}
