package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r {
    private Handler Code;

    public r(Handler handler) {
        this.Code = handler;
    }

    private boolean Code() {
        Looper looper;
        Handler handler = this.Code;
        if (handler == null || (looper = handler.getLooper()) == null) {
            return false;
        }
        return Thread.currentThread() == looper.getThread();
    }

    public void Code(Runnable runnable) {
        Code(runnable, null, 0L);
    }

    public void Code(Runnable runnable, long j10) {
        Code(runnable, null, j10);
    }

    public void Code(Runnable runnable, String str) {
        Code(runnable, str, 0L);
    }

    public void Code(Runnable runnable, String str, long j10) {
        if (this.Code == null || runnable == null) {
            return;
        }
        if (j10 < 0) {
            j10 = 0;
        }
        az azVar = new az(runnable);
        if (j10 == 0 && Code()) {
            azVar.run();
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() + j10;
        try {
            Message obtain = Message.obtain(this.Code, azVar);
            obtain.setAsynchronous(true);
            obtain.obj = str;
            this.Code.sendMessageAtTime(obtain, uptimeMillis);
        } catch (Throwable unused) {
            this.Code.postAtTime(azVar, str, uptimeMillis);
        }
    }

    public void Code(String str) {
        Handler handler = this.Code;
        if (handler == null || str == null) {
            return;
        }
        handler.removeCallbacksAndMessages(str);
    }
}
