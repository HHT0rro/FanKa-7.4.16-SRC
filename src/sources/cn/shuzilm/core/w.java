package cn.shuzilm.core;

import java.util.concurrent.locks.Lock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1797a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1798b;

    public w(String str, String str2) {
        this.f1797a = str;
        this.f1798b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Lock lock = Main.mLock;
            lock.lock();
            try {
                IDUService iDUService = DUConnection.duService;
                if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                    int unused = Main.f1711e = iDUService.setData(this.f1797a, this.f1798b);
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
