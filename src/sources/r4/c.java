package r4;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;
import o4.k;
import s4.o;

/* compiled from: DefaultScheduler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class c implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f53273f = Logger.getLogger(com.google.android.datatransport.runtime.d.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final o f53274a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f53275b;

    /* renamed from: c, reason: collision with root package name */
    public final o4.d f53276c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.datatransport.runtime.scheduling.persistence.b f53277d;

    /* renamed from: e, reason: collision with root package name */
    public final t4.a f53278e;

    @Inject
    public c(Executor executor, o4.d dVar, o oVar, com.google.android.datatransport.runtime.scheduling.persistence.b bVar, t4.a aVar) {
        this.f53275b = executor;
        this.f53276c = dVar;
        this.f53274a = oVar;
        this.f53277d = bVar;
        this.f53278e = aVar;
    }

    public static /* synthetic */ Object b(c cVar, TransportContext transportContext, EventInternal eventInternal) {
        cVar.f53277d.v(transportContext, eventInternal);
        cVar.f53274a.a(transportContext, 1);
        return null;
    }

    public static /* synthetic */ void c(c cVar, TransportContext transportContext, com.google.android.datatransport.e eVar, EventInternal eventInternal) {
        try {
            k kVar = cVar.f53276c.get(transportContext.b());
            if (kVar == null) {
                String format = String.format("Transport backend '%s' is not registered", transportContext.b());
                f53273f.warning(format);
                eVar.a(new IllegalArgumentException(format));
            } else {
                cVar.f53278e.a(b.a(cVar, transportContext, kVar.b(eventInternal)));
                eVar.a(null);
            }
        } catch (Exception e2) {
            f53273f.warning("Error scheduling event " + e2.getMessage());
            eVar.a(e2);
        }
    }

    @Override // r4.e
    public void a(TransportContext transportContext, EventInternal eventInternal, com.google.android.datatransport.e eVar) {
        this.f53275b.execute(a.a(this, transportContext, eVar, eventInternal));
    }
}
