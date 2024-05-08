package he;

/* compiled from: PendingPostQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public g f49632a;

    /* renamed from: b, reason: collision with root package name */
    public g f49633b;

    public synchronized void a(g gVar) {
        try {
            if (gVar != null) {
                g gVar2 = this.f49633b;
                if (gVar2 != null) {
                    gVar2.f49631c = gVar;
                    this.f49633b = gVar;
                } else if (this.f49632a == null) {
                    this.f49633b = gVar;
                    this.f49632a = gVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized g b() {
        g gVar;
        gVar = this.f49632a;
        if (gVar != null) {
            g gVar2 = gVar.f49631c;
            this.f49632a = gVar2;
            if (gVar2 == null) {
                this.f49633b = null;
            }
        }
        return gVar;
    }

    public synchronized g c(int i10) throws InterruptedException {
        if (this.f49632a == null) {
            wait(i10);
        }
        return b();
    }
}
