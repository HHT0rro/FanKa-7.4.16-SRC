package hc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gc.b f49567b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f49568c;

    public c(b bVar, gc.b bVar2) {
        this.f49568c = bVar;
        this.f49567b = bVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f49568c.t(this.f49567b);
    }
}
