package cn.shuzilm.core;

import java.util.concurrent.locks.Lock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1805a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1806b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DUListener f1807c;

    public z(String str, String str2, DUListener dUListener) {
        this.f1805a = str;
        this.f1806b = str2;
        this.f1807c = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Lock lock = Main.mLock;
            lock.lock();
            try {
                IDUService iDUService = DUConnection.duService;
                if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                    iDUService.getQueryIDAsyn(this.f1805a, this.f1806b, this.f1807c);
                }
                lock.unlock();
            } catch (Throwable th) {
                Main.mLock.unlock();
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
