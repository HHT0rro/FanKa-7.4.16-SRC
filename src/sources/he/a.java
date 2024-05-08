package he;

import org.greenrobot.eventbus.EventBus;

/* compiled from: AsyncPoster.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements Runnable, i {

    /* renamed from: b, reason: collision with root package name */
    public final h f49603b = new h();

    /* renamed from: c, reason: collision with root package name */
    public final EventBus f49604c;

    public a(EventBus eventBus) {
        this.f49604c = eventBus;
    }

    @Override // he.i
    public void a(m mVar, Object obj) {
        this.f49603b.a(g.a(mVar, obj));
        this.f49604c.d().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        g b4 = this.f49603b.b();
        if (b4 != null) {
            this.f49604c.g(b4);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
