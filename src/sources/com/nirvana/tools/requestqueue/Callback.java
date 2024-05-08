package com.nirvana.tools.requestqueue;

import com.nirvana.tools.requestqueue.Response;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class Callback<T extends Response> {
    public long mExpiredTime = 0;
    public ThreadStrategy mThreadStrategy;
    public long mThreshold;

    public Callback(ThreadStrategy threadStrategy, long j10) {
        this.mThreadStrategy = threadStrategy;
        this.mThreshold = j10;
    }

    public long getExpiredTime() {
        return this.mExpiredTime;
    }

    public ThreadStrategy getThreadStrategy() {
        return this.mThreadStrategy;
    }

    public long getThreshold() {
        return this.mThreshold;
    }

    public abstract void onResult(T t2);

    public void setExpiredTime(long j10) {
        this.mExpiredTime = j10;
    }
}
