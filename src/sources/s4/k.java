package s4;

/* compiled from: WorkInitializer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final m f53612b;

    public k(m mVar) {
        this.f53612b = mVar;
    }

    public static Runnable a(m mVar) {
        return new k(mVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.f53617d.a(l.a(this.f53612b));
    }
}
