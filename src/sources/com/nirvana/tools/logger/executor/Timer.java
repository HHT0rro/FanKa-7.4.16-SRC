package com.nirvana.tools.logger.executor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Timer {
    private static final int MESSAGE_ACTION = 1;
    private static final int MESSAGE_PAUSE = 3;
    private static final int MESSAGE_QUIT = 2;
    private static AtomicInteger sTimerCount = new AtomicInteger();
    private volatile boolean isWorking;
    private Runnable mAction;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private long mTimeInterval;

    public Timer(long j10, Runnable runnable) {
        this.mTimeInterval = 500L;
        if (j10 > 0) {
            this.mTimeInterval = j10;
        }
        if (runnable != null) {
            this.mAction = runnable;
            HandlerThread handlerThread = new HandlerThread("TimeThread" + sTimerCount.getAndAdd(1));
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.isWorking = true;
            Handler handler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.nirvana.tools.logger.executor.Timer.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what != 1) {
                        removeCallbacksAndMessages(null);
                        Timer.this.quit();
                    } else {
                        Timer.this.mAction.run();
                        sendEmptyMessageDelayed(1, Timer.this.mTimeInterval);
                    }
                }
            };
            this.mHandler = handler;
            handler.obtainMessage(1).sendToTarget();
        }
    }

    public boolean isWorking() {
        return this.isWorking;
    }

    public void pause() {
        this.isWorking = false;
        this.mHandler.removeMessages(1);
    }

    public void quit() {
        this.isWorking = false;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.obtainMessage(2).sendToTarget();
        }
    }

    public void resume() {
        this.isWorking = true;
        this.mHandler.obtainMessage(1).sendToTarget();
    }
}
