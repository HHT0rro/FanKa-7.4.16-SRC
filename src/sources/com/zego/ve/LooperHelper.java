package com.zego.ve;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LooperHelper {
    private static LooperHelper gInstance;
    private Handler mHandler;
    private HandlerThread mThread;

    public LooperHelper() {
        this.mThread = null;
        this.mHandler = null;
        HandlerThread handlerThread = new HandlerThread("dead-loop");
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper());
    }

    public static LooperHelper getInstance() {
        if (gInstance == null) {
            gInstance = new LooperHelper();
        }
        return gInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int on_run(long j10, int i10);

    public static int postMsg(final long j10, final int i10) {
        getInstance().mHandler.post(new Runnable() { // from class: com.zego.ve.LooperHelper.1
            @Override // java.lang.Runnable
            public void run() {
                LooperHelper.on_run(j10, i10);
            }
        });
        return 0;
    }
}
