package he;

import java.util.logging.Level;
import org.greenrobot.eventbus.EventBus;

/* compiled from: BackgroundPoster.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b implements Runnable, i {

    /* renamed from: b, reason: collision with root package name */
    public final h f49605b = new h();

    /* renamed from: c, reason: collision with root package name */
    public final EventBus f49606c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f49607d;

    public b(EventBus eventBus) {
        this.f49606c = eventBus;
    }

    @Override // he.i
    public void a(m mVar, Object obj) {
        g a10 = g.a(mVar, obj);
        synchronized (this) {
            this.f49605b.a(a10);
            if (!this.f49607d) {
                this.f49607d = true;
                this.f49606c.d().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                g c4 = this.f49605b.c(1000);
                if (c4 == null) {
                    synchronized (this) {
                        c4 = this.f49605b.b();
                        if (c4 == null) {
                            return;
                        }
                    }
                }
                this.f49606c.g(c4);
            } catch (InterruptedException e2) {
                this.f49606c.e().b(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f49607d = false;
            }
        }
    }
}
