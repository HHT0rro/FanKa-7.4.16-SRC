package u4;

/* compiled from: TimeModule_UptimeClockFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements com.google.android.datatransport.runtime.dagger.internal.b<u4.a> {

    /* compiled from: TimeModule_UptimeClockFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f53823a = new d();
    }

    public static d a() {
        return a.f53823a;
    }

    public static u4.a c() {
        return (u4.a) com.google.android.datatransport.runtime.dagger.internal.d.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u4.a get() {
        return c();
    }
}
