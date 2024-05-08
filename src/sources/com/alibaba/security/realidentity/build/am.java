package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.log.RPLogging;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: CrashInvocationHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class am implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3083a = "CrashHandler";

    /* renamed from: b, reason: collision with root package name */
    private Object f3084b;

    private am(Object obj) {
        this.f3084b = obj;
    }

    private static void a() {
        RPLogging.d(f3083a, "uncaught exp before");
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        RPLogging.d(f3083a, "uncaught exp before");
        return method.invoke(this.f3084b, objArr);
    }
}
