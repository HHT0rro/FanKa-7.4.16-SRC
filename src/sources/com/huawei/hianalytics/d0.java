package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d0 {
    public static d0 klm;
    public ThreadPoolExecutor lmn;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class lmn implements Runnable {
        public Runnable lmn;

        public lmn(Runnable runnable) {
            this.lmn = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.lmn;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception e2) {
                    StringBuilder b4 = e9.a.b("InnerTask : Exception has happened,From internal operations!");
                    b4.append(e2.getMessage());
                    HiLog.w("ThreadPool", b4.toString());
                } catch (Throwable th) {
                    StringBuilder b10 = e9.a.b("InnerTask : Error has happened,From internal operations!");
                    b10.append(th.getMessage());
                    HiLog.w("ThreadPool", b10.toString());
                }
            }
        }
    }

    static {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(5000);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        new ThreadPoolExecutor(0, 3, 60000L, timeUnit, linkedBlockingQueue);
        new ThreadPoolExecutor(0, 3, 60000L, timeUnit, new LinkedBlockingQueue(5000));
        klm = new d0(1);
    }

    public d0(int i10) {
        this.lmn = new ThreadPoolExecutor(0, i10, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000));
    }

    public void lmn(Runnable runnable) {
        try {
            this.lmn.execute(new lmn(runnable));
        } catch (RejectedExecutionException unused) {
            HiLog.w("ThreadPool", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
