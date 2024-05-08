package r4;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* compiled from: DefaultScheduler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final c f53266b;

    /* renamed from: c, reason: collision with root package name */
    public final TransportContext f53267c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.datatransport.e f53268d;

    /* renamed from: e, reason: collision with root package name */
    public final EventInternal f53269e;

    public a(c cVar, TransportContext transportContext, com.google.android.datatransport.e eVar, EventInternal eventInternal) {
        this.f53266b = cVar;
        this.f53267c = transportContext;
        this.f53268d = eVar;
        this.f53269e = eventInternal;
    }

    public static Runnable a(c cVar, TransportContext transportContext, com.google.android.datatransport.e eVar, EventInternal eventInternal) {
        return new a(cVar, transportContext, eVar, eventInternal);
    }

    @Override // java.lang.Runnable
    public void run() {
        c.c(this.f53266b, this.f53267c, this.f53268d, this.f53269e);
    }
}
