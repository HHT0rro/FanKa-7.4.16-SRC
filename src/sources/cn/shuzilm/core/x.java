package cn.shuzilm.core;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1799a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1800b;

    public x(String str, String str2) {
        this.f1799a = str;
        this.f1800b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Lock lock = Main.mLock;
            lock.lock();
            try {
                IDUService iDUService = DUConnection.duService;
                if (iDUService != null && iDUService.asBinder().isBinderAlive()) {
                    int unused = Main.f1711e = iDUService.setConfig(this.f1799a, this.f1800b);
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
