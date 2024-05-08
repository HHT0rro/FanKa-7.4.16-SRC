package com.google.android.datatransport.runtime.scheduling.persistence;

/* compiled from: EventStoreModule_SchemaVersionFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements com.google.android.datatransport.runtime.dagger.internal.b<Integer> {

    /* compiled from: EventStoreModule_SchemaVersionFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final f f19442a = new f();
    }

    public static f a() {
        return a.f19442a;
    }

    public static int c() {
        return d.b();
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
