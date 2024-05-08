package com.irisdt.util;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UploadTaskHandler {
    private final Handler taskHandler;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final UploadTaskHandler INSTANCE = new UploadTaskHandler();

        private InstanceHolder() {
        }
    }

    public static UploadTaskHandler getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void removeAllRunnable() {
        this.taskHandler.removeCallbacksAndMessages(null);
    }

    public void removeRunnable(Runnable runnable) {
        this.taskHandler.removeCallbacks(runnable);
    }

    public void stop() {
        removeAllRunnable();
    }

    public void uploadDelay(Runnable runnable, long j10) {
        this.taskHandler.postDelayed(runnable, j10);
    }

    public void uploadNow(Runnable runnable) {
        this.taskHandler.post(runnable);
    }

    private UploadTaskHandler() {
        HandlerThread handlerThread = new HandlerThread("UploadHandlerThread");
        handlerThread.start();
        this.taskHandler = new Handler(handlerThread.getLooper());
    }
}
