package com.jd.ad.sdk.jad_vi;

import com.jd.ad.sdk.logger.Logger;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: EventExecutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_er {
    public static final ScheduledThreadPoolExecutor jad_an;

    /* compiled from: EventExecutor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_an implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Logger.d("execute rejected");
        }
    }

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        jad_an = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new jad_an());
    }
}
