package com.huawei.hms.aaid.threads;

import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.o;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AsyncExec {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f28924a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("SeqIO"), new ThreadPoolExecutor.AbortPolicy());

    public static void submitSeqIO(Runnable runnable) {
        try {
            f28924a.execute(new o(runnable));
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("submit seq io task failed, Exception:");
            sb2.append((Object) e2);
        }
    }
}
