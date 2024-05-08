package com.tencent.liteav.base.util;

import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a<T> {

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0636a<T> f42873b;

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<T> f42872a = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<T> f42874c = new WeakReference<>(null);

    /* renamed from: com.tencent.liteav.base.util.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0636a<T> {
        T a();
    }

    public a(InterfaceC0636a<T> interfaceC0636a) {
        this.f42873b = interfaceC0636a;
    }

    private T b() {
        T t2 = this.f42874c.get();
        if (t2 == null) {
            synchronized (this) {
                t2 = this.f42874c.get();
                if (t2 == null) {
                    t2 = this.f42873b.a();
                    this.f42874c = new WeakReference<>(t2);
                }
            }
        }
        return t2;
    }

    public final T a() {
        T t2 = this.f42872a.get();
        if (t2 != null) {
            return t2;
        }
        T b4 = b();
        this.f42872a.set(b4);
        return b4;
    }
}
