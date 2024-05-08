package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* compiled from: DoubleCheck.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a<T> implements Provider<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f19406c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Provider<T> f19407a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f19408b = f19406c;

    public a(Provider<T> provider) {
        this.f19407a = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> a(P p10) {
        d.b(p10);
        return p10 instanceof a ? p10 : new a(p10);
    }

    public static Object b(Object obj, Object obj2) {
        if (!(obj != f19406c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t2 = (T) this.f19408b;
        Object obj = f19406c;
        if (t2 == obj) {
            synchronized (this) {
                t2 = (T) this.f19408b;
                if (t2 == obj) {
                    t2 = this.f19407a.get();
                    this.f19408b = b(this.f19408b, t2);
                    this.f19407a = null;
                }
            }
        }
        return t2;
    }
}
