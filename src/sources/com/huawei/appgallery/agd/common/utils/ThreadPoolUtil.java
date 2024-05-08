package com.huawei.appgallery.agd.common.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ThreadPoolUtil {
    public static final ThreadPoolExecutor CORE_THREAD_POOL;
    public static final ThreadPoolExecutor SERIAL_THREAD;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        CORE_THREAD_POOL = new ThreadPoolExecutor(2, 4, 10L, timeUnit, new LinkedBlockingQueue());
        SERIAL_THREAD = new ThreadPoolExecutor(0, 1, 10L, timeUnit, new LinkedBlockingQueue());
    }
}
