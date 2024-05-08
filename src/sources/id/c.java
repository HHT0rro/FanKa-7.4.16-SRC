package id;

import com.tanx.exposer.framework.connectivity.tanxc_do;

/* compiled from: AdMonitorRetryManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f49888b;

    public c(b bVar) {
        this.f49888b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        tanxc_do tanxc_doVar = tanxc_do.c.f38989a;
        tanxc_do.a aVar = this.f49888b.f49883g;
        synchronized (tanxc_doVar) {
            if (rc.b.f53376a) {
                rc.b.a("NetworkStateObserver", "addNetworkChangeListener: listener = " + ((Object) aVar));
            }
            tanxc_doVar.f38982b.add(aVar);
            aVar.a(tanxc_doVar.f38985e);
        }
    }
}
