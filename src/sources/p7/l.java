package p7;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f52917b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f52918c;

    public l(m mVar, f fVar) {
        this.f52918c = mVar;
        this.f52917b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        c cVar;
        c cVar2;
        obj = this.f52918c.f52920b;
        synchronized (obj) {
            cVar = this.f52918c.f52921c;
            if (cVar != null) {
                cVar2 = this.f52918c.f52921c;
                cVar2.onFailure((Exception) com.google.android.gms.common.internal.h.h(this.f52917b.e()));
            }
        }
    }
}
