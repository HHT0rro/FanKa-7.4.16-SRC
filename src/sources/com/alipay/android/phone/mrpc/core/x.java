package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private g f4287a;

    /* renamed from: b, reason: collision with root package name */
    private z f4288b = new z(this);

    public x(g gVar) {
        this.f4287a = gVar;
    }

    public final g a() {
        return this.f4287a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f4287a, cls, this.f4288b));
    }
}
