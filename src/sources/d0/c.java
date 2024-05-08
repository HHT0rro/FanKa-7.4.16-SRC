package d0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f48603b;

    public c(b bVar) {
        this.f48603b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f48603b.d();
        } catch (Exception e2) {
            d.c(e2);
        }
    }
}
