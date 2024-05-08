package p7;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f52925b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f52926c;

    public o(n nVar, f fVar) {
        this.f52926c = nVar;
        this.f52925b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        d dVar;
        d dVar2;
        obj = this.f52926c.f52923b;
        synchronized (obj) {
            dVar = this.f52926c.f52924c;
            if (dVar != null) {
                dVar2 = this.f52926c.f52924c;
                dVar2.onSuccess(this.f52925b.f());
            }
        }
    }
}
