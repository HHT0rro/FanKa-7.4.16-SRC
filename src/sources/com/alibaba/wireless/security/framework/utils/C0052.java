package com.alibaba.wireless.security.framework.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* renamed from: com.alibaba.wireless.security.framework.utils.г, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0052 {

    /* renamed from: а, reason: contains not printable characters */
    private final Object f60;

    /* renamed from: б, reason: contains not printable characters */
    private final boolean f61 = false;

    /* renamed from: com.alibaba.wireless.security.framework.utils.г$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class C0053 {
        private C0053() {
        }
    }

    private C0052(Object obj) {
        this.f60 = obj;
    }

    /* renamed from: а, reason: contains not printable characters */
    public static C0052 m1832(Object obj) {
        return new C0052(obj);
    }

    /* renamed from: а, reason: contains not printable characters */
    private static C0052 m1833(Method method, Object obj, Object... objArr) throws C0054 {
        try {
            m1835(method);
            if (method.getReturnType() != Void.TYPE) {
                return m1832(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return m1832(obj);
        } catch (Exception e2) {
            throw new C0054(e2);
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static Class<?> m1834(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    /* renamed from: а, reason: contains not printable characters */
    public static <T extends AccessibleObject> T m1835(T t2) {
        if (t2 == null) {
            return null;
        }
        if (t2 instanceof Member) {
            Member member = (Member) t2;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t2;
            }
        }
        if (!t2.isAccessible()) {
            t2.setAccessible(true);
        }
        return t2;
    }

    /* renamed from: а, reason: contains not printable characters */
    private Method m1836(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> m1843 = m1843();
        try {
            return m1843.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return m1843.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    m1843 = m1843.getSuperclass();
                }
            } while (m1843 != null);
            throw new NoSuchMethodException();
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    private boolean m1837(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && m1838(method.getParameterTypes(), clsArr);
    }

    /* renamed from: а, reason: contains not printable characters */
    private boolean m1838(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr2.length; i10++) {
            if (clsArr2[i10] != C0053.class && !m1834(clsArr[i10]).isAssignableFrom(m1834(clsArr2[i10]))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: а, reason: contains not printable characters */
    private static Class<?>[] m1839(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            clsArr[i10] = obj == null ? C0053.class : obj.getClass();
        }
        return clsArr;
    }

    /* renamed from: б, reason: contains not printable characters */
    private Method m1840(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> m1843 = m1843();
        for (Method method : m1843.getMethods()) {
            if (m1837(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : m1843.getDeclaredMethods()) {
                if (m1837(method2, str, clsArr)) {
                    return method2;
                }
            }
            m1843 = m1843.getSuperclass();
        } while (m1843 != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + ((Object) m1843()) + ".");
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0052) {
            return this.f60.equals(((C0052) obj).m1842());
        }
        return false;
    }

    public int hashCode() {
        return this.f60.hashCode();
    }

    public String toString() {
        return this.f60.toString();
    }

    /* renamed from: а, reason: contains not printable characters */
    public C0052 m1841(String str, Object... objArr) throws C0054 {
        Class<?>[] m1839 = m1839(objArr);
        try {
            try {
                return m1833(m1836(str, m1839), this.f60, objArr);
            } catch (NoSuchMethodException unused) {
                return m1833(m1840(str, m1839), this.f60, objArr);
            }
        } catch (NoSuchMethodException e2) {
            throw new C0054(e2);
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public <T> T m1842() {
        return (T) this.f60;
    }

    /* renamed from: б, reason: contains not printable characters */
    public Class<?> m1843() {
        return this.f61 ? (Class) this.f60 : this.f60.getClass();
    }
}
