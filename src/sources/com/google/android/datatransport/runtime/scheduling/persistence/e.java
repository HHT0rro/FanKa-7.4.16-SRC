package com.google.android.datatransport.runtime.scheduling.persistence;

/* compiled from: EventStoreModule_DbNameFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements com.google.android.datatransport.runtime.dagger.internal.b<String> {

    /* compiled from: EventStoreModule_DbNameFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final e f19440a = new e();
    }

    public static e a() {
        return a.f19440a;
    }

    public static String b() {
        return (String) com.google.android.datatransport.runtime.dagger.internal.d.c(d.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
