package com.tencent.cloud.huiyansdkface.okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OptionalMethod<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f42000a;

    /* renamed from: b, reason: collision with root package name */
    private final String f42001b;

    /* renamed from: c, reason: collision with root package name */
    private final Class[] f42002c;

    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f42000a = cls;
        this.f42001b = str;
        this.f42002c = clsArr;
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f42001b;
        if (str == null) {
            return null;
        }
        Method a10 = a(cls, str, this.f42002c);
        if (a10 == null || (cls2 = this.f42000a) == null || cls2.isAssignableFrom(a10.getReturnType())) {
            return a10;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object invoke(T t2, Object... objArr) throws InvocationTargetException {
        Method a10 = a(t2.getClass());
        if (a10 == null) {
            throw new AssertionError((Object) ("Method " + this.f42001b + " not supported for object " + ((Object) t2)));
        }
        try {
            return a10.invoke(t2, objArr);
        } catch (IllegalAccessException e2) {
            AssertionError assertionError = new AssertionError((Object) ("Unexpectedly could not call: " + ((Object) a10)));
            assertionError.initCause(e2);
            throw assertionError;
        }
    }

    public Object invokeOptional(T t2, Object... objArr) throws InvocationTargetException {
        Method a10 = a(t2.getClass());
        if (a10 == null) {
            return null;
        }
        try {
            return a10.invoke(t2, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object invokeOptionalWithoutCheckedException(T t2, Object... objArr) {
        try {
            return invokeOptional(t2, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError((Object) "Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object invokeWithoutCheckedException(T t2, Object... objArr) {
        try {
            return invoke(t2, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError((Object) "Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean isSupported(T t2) {
        return a(t2.getClass()) != null;
    }
}
