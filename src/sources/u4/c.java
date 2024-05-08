package u4;

/* compiled from: TimeModule_EventClockFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements com.google.android.datatransport.runtime.dagger.internal.b<u4.a> {

    /* compiled from: TimeModule_EventClockFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f53822a = new c();
    }

    public static c a() {
        return a.f53822a;
    }

    public static u4.a b() {
        return (u4.a) com.google.android.datatransport.runtime.dagger.internal.d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u4.a get() {
        return b();
    }
}
