package com.google.android.datatransport.runtime.dagger.internal;

/* compiled from: InstanceFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c<T> implements b<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final c<Object> f19409b = new c<>(null);

    /* renamed from: a, reason: collision with root package name */
    public final T f19410a;

    public c(T t2) {
        this.f19410a = t2;
    }

    public static <T> b<T> a(T t2) {
        return new c(d.c(t2, "instance cannot be null"));
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.f19410a;
    }
}
