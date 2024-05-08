package com.nirvana.tools.logger.executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class AbstractSafeRunnable implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            safeRun();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void safeRun();
}
