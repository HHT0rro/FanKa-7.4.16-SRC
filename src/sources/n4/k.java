package n4;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.runtime.TransportContext;

/* compiled from: TransportImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k<T> implements com.google.android.datatransport.c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final TransportContext f52117a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52118b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.datatransport.a f52119c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.datatransport.b<T, byte[]> f52120d;

    /* renamed from: e, reason: collision with root package name */
    public final l f52121e;

    public k(TransportContext transportContext, String str, com.google.android.datatransport.a aVar, com.google.android.datatransport.b<T, byte[]> bVar, l lVar) {
        this.f52117a = transportContext;
        this.f52118b = str;
        this.f52119c = aVar;
        this.f52120d = bVar;
        this.f52121e = lVar;
    }

    public static /* synthetic */ void b(Exception exc) {
    }

    @Override // com.google.android.datatransport.c
    public void a(Event<T> event) {
        c(event, j.b());
    }

    public void c(Event<T> event, com.google.android.datatransport.e eVar) {
        this.f52121e.a(h.a().e(this.f52117a).c(event).f(this.f52118b).d(this.f52120d).b(this.f52119c).a(), eVar);
    }
}
