package cn.shuzilm.core;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1801a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1802b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1803c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DUListener f1804d;

    public y(String str, String str2, String str3, DUListener dUListener) {
        this.f1801a = str;
        this.f1802b = str2;
        this.f1803c = str3;
        this.f1804d = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Main.mLock.lock();
        try {
            try {
                IDUService iDUService = DUConnection.duService;
                if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                    iDUService.onEventAsyn(this.f1801a, this.f1802b, this.f1803c, this.f1804d);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            Main.mLock.unlock();
        }
    }
}
