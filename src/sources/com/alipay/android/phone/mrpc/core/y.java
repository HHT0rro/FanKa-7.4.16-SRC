package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class y implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public g f4289a;

    /* renamed from: b, reason: collision with root package name */
    public Class<?> f4290b;

    /* renamed from: c, reason: collision with root package name */
    public z f4291c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f4289a = gVar;
        this.f4290b = cls;
        this.f4291c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f4291c.a(method, objArr);
    }
}
