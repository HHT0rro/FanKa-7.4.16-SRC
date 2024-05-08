package com.google.android.gms.internal.vision;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p6 {

    /* renamed from: c, reason: collision with root package name */
    public static final p6 f25583c = new p6();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<Class<?>, t6<?>> f25585b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final v6 f25584a = new u5();

    public static p6 a() {
        return f25583c;
    }

    public final <T> t6<T> b(Class<T> cls) {
        b5.f(cls, "messageType");
        t6<T> t6Var = (t6) this.f25585b.get(cls);
        if (t6Var != null) {
            return t6Var;
        }
        t6<T> a10 = this.f25584a.a(cls);
        b5.f(cls, "messageType");
        b5.f(a10, "schema");
        t6<T> t6Var2 = (t6) this.f25585b.putIfAbsent(cls, a10);
        return t6Var2 != null ? t6Var2 : a10;
    }

    public final <T> t6<T> c(T t2) {
        return b(t2.getClass());
    }
}
