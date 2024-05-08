package hc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gc.c f49569b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f49570c;

    public d(b bVar, gc.c cVar) {
        this.f49570c = bVar;
        this.f49569b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f49570c.u(this.f49569b);
    }
}
