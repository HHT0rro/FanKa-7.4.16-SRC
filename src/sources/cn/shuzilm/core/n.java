package cn.shuzilm.core;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class n implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        Lock lock2;
        Lock lock3;
        AIClient aIClient;
        lock = DUHelper.f1684f;
        if (lock.tryLock()) {
            try {
                AIClient unused = DUHelper.f1681c = new AIClient(DUHelper.mContext);
                aIClient = DUHelper.f1681c;
                aIClient.asynAI();
            } catch (Exception unused2) {
            } catch (Throwable th) {
                lock2 = DUHelper.f1684f;
                lock2.unlock();
                throw th;
            }
            lock3 = DUHelper.f1684f;
            lock3.unlock();
        }
    }
}
