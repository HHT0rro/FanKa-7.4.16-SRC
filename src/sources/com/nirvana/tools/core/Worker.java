package com.nirvana.tools.core;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Worker {
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private String mWorkerId;

    public Worker(String str) {
        this.mHandlerThread = null;
        HandlerThread handlerThread = new HandlerThread("nirvana_base_worker_".concat(String.valueOf(str)));
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mWorkerId = str;
    }

    private void doRelease() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mHandlerThread = null;
            this.mHandler = null;
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        doRelease();
    }

    public String getWorkerId() {
        return this.mWorkerId;
    }

    public synchronized void post(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public synchronized void postDelayed(Runnable runnable, long j10) {
        Handler handler = this.mHandler;
        if (handler != null) {
            if (j10 > 0) {
                handler.postDelayed(runnable, j10);
                return;
            }
            handler.post(runnable);
        }
    }

    public synchronized void release() {
        doRelease();
    }
}
