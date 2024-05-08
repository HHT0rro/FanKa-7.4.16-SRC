package com.alimm.tanx.core.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class TanxCountDownTimer implements NotConfused {
    public static final int MSG = 1;
    public static final String TAG = "TanxCountDownTimer";
    public static final int TIMER_CANCELLED = 3;
    public static final int TIMER_INIT = 0;
    public static final int TIMER_PAUSE = 2;
    public static final int TIMER_START = 1;
    public final long mCountdownInterval;
    public final long mMillisInFuture;
    public long mPauseLeftInFuture;
    public long mStopTimeInFuture;
    public volatile int nowType = 0;
    public final Handler mHandler = new Handler() { // from class: com.alimm.tanx.core.utils.TanxCountDownTimer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j10;
            synchronized (TanxCountDownTimer.this) {
                if (TanxCountDownTimer.this.nowType == 3) {
                    return;
                }
                if (TanxCountDownTimer.this.nowType == 2) {
                    return;
                }
                long elapsedRealtime = TanxCountDownTimer.this.mStopTimeInFuture - SystemClock.elapsedRealtime();
                long j11 = 0;
                if (elapsedRealtime <= 0) {
                    TanxCountDownTimer.this.onFinish();
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    TanxCountDownTimer.this.onTick(elapsedRealtime);
                    long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    if (elapsedRealtime < TanxCountDownTimer.this.mCountdownInterval) {
                        j10 = elapsedRealtime - elapsedRealtime3;
                        if (j10 < 0) {
                            sendMessageDelayed(obtainMessage(1), j11);
                        }
                    } else {
                        j10 = TanxCountDownTimer.this.mCountdownInterval - elapsedRealtime3;
                        while (j10 < 0) {
                            j10 += TanxCountDownTimer.this.mCountdownInterval;
                        }
                    }
                    j11 = j10;
                    sendMessageDelayed(obtainMessage(1), j11);
                }
            }
        }
    };

    public TanxCountDownTimer(long j10, long j11) {
        this.mMillisInFuture = j10;
        this.mCountdownInterval = j11;
    }

    public final synchronized void cancel() {
        this.nowType = 3;
        this.mHandler.removeMessages(1);
        LogUtils.d("myTimer cancel:", this.mPauseLeftInFuture + "");
    }

    public int getNowType() {
        return this.nowType;
    }

    public boolean isCancelled() {
        return this.nowType == 3;
    }

    public boolean isPaused() {
        return this.nowType == 2;
    }

    public boolean isStart() {
        return this.nowType == 1;
    }

    public abstract void onFinish();

    public abstract void onTick(long j10);

    public final synchronized void pause() {
        if (this.nowType == 1) {
            this.nowType = 2;
            this.mPauseLeftInFuture = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
            this.mHandler.removeMessages(1);
            LogUtils.d(TAG, "myTimer pause:" + this.mPauseLeftInFuture);
        }
    }

    public final synchronized TanxCountDownTimer resume() {
        if (this.nowType == 2) {
            this.nowType = 1;
            if (this.mPauseLeftInFuture <= 0) {
                onFinish();
                return this;
            }
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mPauseLeftInFuture;
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            LogUtils.d("myTimer resume:", this.mStopTimeInFuture + "");
        }
        return this;
    }

    public final synchronized TanxCountDownTimer start() {
        if (this.nowType == 0) {
            this.nowType = 1;
            if (this.mMillisInFuture <= 0) {
                onFinish();
                return this;
            }
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            LogUtils.d("myTimer start:", this.mStopTimeInFuture + "");
        }
        return this;
    }

    public final synchronized TanxCountDownTimer updateTime(long j10) {
        this.mPauseLeftInFuture = j10;
        return this;
    }
}
