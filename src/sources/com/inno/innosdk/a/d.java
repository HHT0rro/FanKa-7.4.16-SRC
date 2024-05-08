package com.inno.innosdk.a;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: ThreadPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        new e("rejected").newThread(runnable).start();
    }
}
