package com.google.common.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Throwables.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f25996a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f25997b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f25998c;

    static {
        Object b4 = b();
        f25996a = b4;
        f25997b = b4 == null ? null : a();
        f25998c = b4 != null ? d(b4) : null;
    }

    public static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    public static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Object obj) {
        try {
            Method c4 = c("getStackTraceDepth", Throwable.class);
            if (c4 == null) {
                return null;
            }
            c4.invoke(obj, new Throwable());
            return c4;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void f(Throwable th) {
        o.r(th);
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            return;
        }
        throw ((RuntimeException) th);
    }
}
