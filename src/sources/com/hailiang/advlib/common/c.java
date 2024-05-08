package com.hailiang.advlib.common;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Reflect.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f27121a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f27122b = true;

    /* compiled from: Reflect.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f27123a;

        public a(boolean z10) {
            this.f27123a = z10;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            try {
                return c.a(c.this.f27121a).a(name, objArr).c();
            } catch (ReflectException e2) {
                if (this.f27123a) {
                    Map map = (Map) c.this.f27121a;
                    int length = objArr == null ? 0 : objArr.length;
                    if (length == 0 && name.startsWith(MonitorConstants.CONNECT_TYPE_GET)) {
                        return map.get(c.h(name.substring(3)));
                    }
                    if (length == 0 && name.startsWith("is")) {
                        return map.get(c.h(name.substring(2)));
                    }
                    if (length == 1 && name.startsWith("set")) {
                        map.put(c.h(name.substring(3)), objArr[0]);
                        return null;
                    }
                }
                throw e2;
            }
        }
    }

    /* compiled from: Reflect.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b {
        public b() {
        }
    }

    public c(Class<?> cls) {
        this.f27121a = cls;
    }

    public static c b(String str, ClassLoader classLoader) throws ReflectException {
        return b(a(str, classLoader));
    }

    public static Class<?> c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    private Field d(String str) throws ReflectException {
        Class<?> e2 = e();
        try {
            return e2.getField(str);
        } catch (NoSuchFieldException e10) {
            do {
                try {
                    return (Field) a(e2.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    e2 = e2.getSuperclass();
                }
            } while (e2 != null);
            throw new ReflectException(e10);
        }
    }

    public static Class<?> e(String str) throws ReflectException {
        try {
            return Class.forName(str);
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public static c g(String str) throws ReflectException {
        return b(e(str));
    }

    public static String h(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f27121a.equals(((c) obj).c());
        }
        return false;
    }

    public <T> T f(String str) throws ReflectException {
        return (T) c(str).c();
    }

    public int hashCode() {
        return this.f27121a.hashCode();
    }

    public String toString() {
        return this.f27121a.toString();
    }

    public static c b(Class<?> cls) {
        return new c(cls);
    }

    public static c a(Object obj) {
        return new c(obj);
    }

    public static Object b(Object obj) {
        return obj instanceof c ? ((c) obj).c() : obj;
    }

    public Class<?> e() {
        if (this.f27122b) {
            return (Class) this.f27121a;
        }
        return this.f27121a.getClass();
    }

    public c(Object obj) {
        this.f27121a = obj;
    }

    public static <T extends AccessibleObject> T a(T t2) {
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

    public static Class<?>[] b(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            clsArr[i10] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    public Object d() {
        return this.f27121a;
    }

    public Map<String, c> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> e2 = e();
        do {
            for (Field field : e2.getDeclaredFields()) {
                if ((!this.f27122b) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, c(name));
                    }
                }
            }
            e2 = e2.getSuperclass();
        } while (e2 != null);
        return linkedHashMap;
    }

    public static c a(Constructor<?> constructor, Object... objArr) throws ReflectException {
        try {
            return a(((Constructor) a(constructor)).newInstance(objArr));
        } catch (Throwable th) {
            throw new ReflectException(th);
        }
    }

    public static c a(Method method, Object obj, Object... objArr) throws ReflectException {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return a(obj);
            }
            return a(method.invoke(obj, objArr));
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public c b(String str) throws ReflectException {
        return a(str, new Object[0]);
    }

    public static Class<?> a(String str, ClassLoader classLoader) throws ReflectException {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> e2 = e();
        for (Method method : e2.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : e2.getDeclaredMethods()) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            e2 = e2.getSuperclass();
        } while (e2 != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + ((Object) e()) + ".");
    }

    public c a(Field field, Object obj) throws ReflectException {
        try {
            field.setAccessible(true);
            field.set(this.f27121a, b(obj));
            return this;
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public <T> T c() {
        return (T) this.f27121a;
    }

    public c c(String str) throws ReflectException {
        try {
            return a(d(str).get(this.f27121a));
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public c a(String str, Object obj) throws ReflectException {
        try {
            Field d10 = d(str);
            d10.setAccessible(true);
            d10.set(this.f27121a, b(obj));
            return this;
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public c a(String str, Object... objArr) throws ReflectException {
        Class<?>[] b4 = b(objArr);
        try {
            try {
                return a(a(str, b4), this.f27121a, objArr);
            } catch (NoSuchMethodException unused) {
                return a(b(str, b4), this.f27121a, objArr);
            }
        } catch (NoSuchMethodException e2) {
            throw new ReflectException(e2);
        }
    }

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> e2 = e();
        try {
            return e2.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return e2.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    e2 = e2.getSuperclass();
                }
            } while (e2 != null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    public c a() throws ReflectException {
        return a(new Object[0]);
    }

    public c a(Object... objArr) throws ReflectException {
        Class<?>[] b4 = b(objArr);
        try {
            return a(e().getDeclaredConstructor(b4), objArr);
        } catch (NoSuchMethodException e2) {
            for (Constructor<?> constructor : e().getDeclaredConstructors()) {
                if (a(constructor.getParameterTypes(), b4)) {
                    return a(constructor, objArr);
                }
            }
            throw new ReflectException(e2);
        }
    }

    public <P> P a(Class<P> cls) {
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(this.f27121a instanceof Map));
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr2.length; i10++) {
            if (clsArr2[i10] != b.class && (c(clsArr2[i10]) == null || !c(clsArr[i10]).isAssignableFrom(c(clsArr2[i10])))) {
                return false;
            }
        }
        return true;
    }
}
