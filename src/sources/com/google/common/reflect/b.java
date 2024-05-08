package com.google.common.reflect;

import com.google.common.base.o;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* compiled from: Reflection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        o.r(invocationHandler);
        o.m(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
