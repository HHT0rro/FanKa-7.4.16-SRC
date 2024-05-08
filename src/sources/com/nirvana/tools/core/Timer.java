package com.nirvana.tools.core;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Timer {
    private volatile boolean isCancel;
    private AtomicBoolean isTimeout;
    private Handler mHandler;
    private Runnable mTimeoutCallback;
    private Runnable mTimeoutRunnable;
    private long mTimeoutStamp;

    public Timer(long j10, Runnable runnable) {
        this(j10, runnable, Looper.getMainLooper());
    }

    public Timer(long j10, Runnable runnable, Looper looper) {
        this.isTimeout = new AtomicBoolean(false);
        this.isCancel = false;
        this.mTimeoutStamp = j10;
        this.mTimeoutCallback = runnable;
        this.mHandler = new Handler(looper);
    }

    public boolean isTimeout() {
        return this.isTimeout.get();
    }

    public synchronized boolean notTimeoutAndStop() {
        boolean isTimeout;
        isTimeout = isTimeout();
        stop();
        return !isTimeout;
    }

    public void start() {
        if (this.mTimeoutCallback == null || this.mTimeoutStamp <= 0) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.nirvana.tools.core.Timer.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (Timer.this) {
                    if (!Timer.this.isCancel) {
                        Timer.this.isTimeout.set(true);
                        Timer.this.mTimeoutCallback.run();
                    }
                }
            }
        };
        this.mTimeoutRunnable = runnable;
        this.mHandler.postDelayed(runnable, this.mTimeoutStamp);
    }

    public synchronized void stop() {
        this.isCancel = true;
        Runnable runnable = this.mTimeoutRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        this.mTimeoutCallback = null;
        this.mTimeoutRunnable = null;
    }
}
