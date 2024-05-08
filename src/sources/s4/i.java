package s4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: Uploader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f53598a;

    /* renamed from: b, reason: collision with root package name */
    public final o4.d f53599b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.datatransport.runtime.scheduling.persistence.b f53600c;

    /* renamed from: d, reason: collision with root package name */
    public final o f53601d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f53602e;

    /* renamed from: f, reason: collision with root package name */
    public final t4.a f53603f;

    /* renamed from: g, reason: collision with root package name */
    public final u4.a f53604g;

    @Inject
    public i(Context context, o4.d dVar, com.google.android.datatransport.runtime.scheduling.persistence.b bVar, o oVar, Executor executor, t4.a aVar, u4.a aVar2) {
        this.f53598a = context;
        this.f53599b = dVar;
        this.f53600c = bVar;
        this.f53601d = oVar;
        this.f53602e = executor;
        this.f53603f = aVar;
        this.f53604g = aVar2;
    }

    public static /* synthetic */ Object c(i iVar, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i10) {
        if (backendResponse.c() == BackendResponse.Status.TRANSIENT_ERROR) {
            iVar.f53600c.s(iterable);
            iVar.f53601d.a(transportContext, i10 + 1);
            return null;
        }
        iVar.f53600c.h(iterable);
        if (backendResponse.c() == BackendResponse.Status.OK) {
            iVar.f53600c.c(transportContext, iVar.f53604g.getTime() + backendResponse.b());
        }
        if (!iVar.f53600c.q(transportContext)) {
            return null;
        }
        iVar.f53601d.a(transportContext, 1);
        return null;
    }

    public static /* synthetic */ Object d(i iVar, TransportContext transportContext, int i10) {
        iVar.f53601d.a(transportContext, i10 + 1);
        return null;
    }

    public static /* synthetic */ void e(i iVar, TransportContext transportContext, int i10, Runnable runnable) {
        try {
            try {
                t4.a aVar = iVar.f53603f;
                com.google.android.datatransport.runtime.scheduling.persistence.b bVar = iVar.f53600c;
                bVar.getClass();
                aVar.a(g.a(bVar));
                if (!iVar.a()) {
                    iVar.f53603f.a(h.a(iVar, transportContext, i10));
                } else {
                    iVar.f(transportContext, i10);
                }
            } catch (SynchronizationException unused) {
                iVar.f53601d.a(transportContext, i10 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f53598a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void f(TransportContext transportContext, int i10) {
        BackendResponse a10;
        o4.k kVar = this.f53599b.get(transportContext.b());
        Iterable iterable = (Iterable) this.f53603f.a(e.a(this, transportContext));
        if (iterable.iterator2().hasNext()) {
            if (kVar == null) {
                p4.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                a10 = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator iterator2 = iterable.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(((PersistedEvent) iterator2.next()).getEvent());
                }
                a10 = kVar.a(o4.e.a().b(arrayList).c(transportContext.c()).a());
            }
            this.f53603f.a(f.a(this, a10, iterable, transportContext, i10));
        }
    }

    public void g(TransportContext transportContext, int i10, Runnable runnable) {
        this.f53602e.execute(d.a(this, transportContext, i10, runnable));
    }
}
