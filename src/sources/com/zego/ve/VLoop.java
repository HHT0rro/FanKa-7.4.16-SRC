package com.zego.ve;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VLoop implements Handler.Callback {
    private static final int MESSAGE_DELAYED = 3;
    private static final int MESSAGE_EXIT = 1;
    private static final int MESSAGE_LOOP = 2;
    private static final int MESSAGE_START = 0;
    private static final String TAG = "vloop-";
    private long pthis = 0;
    private HandlerThread mThread = null;
    private Handler mHandler = null;
    private String mNativeTag = null;
    private boolean mIsRunning = false;
    private final Object lock = new Object();

    private static native int on_end(long j10);

    private static native int on_msg_delayed(long j10, long j11);

    private static native int on_run_loop(long j10);

    private static native int on_start(long j10);

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            synchronized (this.lock) {
                if (this.mIsRunning) {
                    int i10 = message.what;
                    if (i10 == 2) {
                        on_run_loop(this.pthis);
                    } else if (i10 == 3) {
                        on_msg_delayed(this.pthis, ((Long) message.obj).longValue());
                    } else if (i10 == 0) {
                        on_start(this.pthis);
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public int postMessage() {
        this.mHandler.sendEmptyMessage(2);
        return 0;
    }

    public int postMessageDelayed(long j10, long j11) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = Long.valueOf(j10);
        this.mHandler.sendMessageDelayed(obtain, j11);
        return 0;
    }

    public int setThis(long j10, String str) {
        this.pthis = j10;
        this.mNativeTag = str;
        return 0;
    }

    public int startLoop() {
        HandlerThread handlerThread = new HandlerThread(TAG + this.mNativeTag);
        this.mThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mThread.getLooper(), this);
        this.mHandler = handler;
        handler.sendEmptyMessage(0);
        this.mIsRunning = true;
        return 0;
    }

    public int stopLoop() {
        synchronized (this.lock) {
            this.mIsRunning = false;
            this.mHandler.removeCallbacksAndMessages(this);
            this.mHandler = null;
        }
        this.mThread.quitSafely();
        this.mThread = null;
        on_end(this.pthis);
        return 0;
    }
}
