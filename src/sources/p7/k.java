package p7;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k implements d<Void> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f52916a;

    public k(j jVar, e eVar) {
        this.f52916a = eVar;
    }

    @Override // p7.d
    public final /* synthetic */ void onSuccess(Void r12) {
        this.f52916a.onCanceled();
    }
}
