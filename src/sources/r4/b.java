package r4;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import t4.a;

/* compiled from: DefaultScheduler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class b implements a.InterfaceC0823a {

    /* renamed from: a, reason: collision with root package name */
    public final c f53270a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f53271b;

    /* renamed from: c, reason: collision with root package name */
    public final EventInternal f53272c;

    public b(c cVar, TransportContext transportContext, EventInternal eventInternal) {
        this.f53270a = cVar;
        this.f53271b = transportContext;
        this.f53272c = eventInternal;
    }

    public static a.InterfaceC0823a a(c cVar, TransportContext transportContext, EventInternal eventInternal) {
        return new b(cVar, transportContext, eventInternal);
    }

    @Override // t4.a.InterfaceC0823a
    public Object execute() {
        return c.b(this.f53270a, this.f53271b, this.f53272c);
    }
}
