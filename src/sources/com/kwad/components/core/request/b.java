package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private final List<a> Rp;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void qp();
    }

    /* renamed from: com.kwad.components.core.request.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0477b {
        private static final b Rq = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    public static b qn() {
        return C0477b.Rq;
    }

    public final void a(a aVar) {
        this.Rp.add(aVar);
    }

    public final void b(a aVar) {
        this.Rp.remove(aVar);
    }

    public final void qo() {
        for (a aVar : this.Rp) {
            if (aVar != null) {
                try {
                    aVar.qp();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    private b() {
        this.Rp = new CopyOnWriteArrayList();
    }
}
