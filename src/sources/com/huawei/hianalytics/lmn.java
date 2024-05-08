package com.huawei.hianalytics;

import android.content.Context;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class lmn {
    public static lmn ghi = new lmn();
    public Context lmn;
    public final Object klm = new Object();
    public HiAnalyticsInstance ikl = null;
    public ExecutorService ijk = Executors.newSingleThreadExecutor();
    public long hij = 86400000;

    public final boolean lmn() {
        long lmn = j0.lmn("abtest", "expdata_refresh_time", -1L) + this.hij;
        boolean z10 = lmn == 0 || lmn < System.currentTimeMillis();
        if (z10) {
            HiLog.i("ABTestManager", "Achieving Request Cycle");
        } else {
            HiLog.i("ABTestManager", "Not reaching the request cycle");
        }
        return z10;
    }
}
