package com.huawei.hianalytics.util;

import android.content.Context;
import com.huawei.hianalytics.core.log.HiLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class HiAnalyticTools {
    public static void enableLog(Context context) {
        enableLog(context, 3);
    }

    public static void enableLog(Context context, int i10) {
        HiLog.init(i10, "FormalHASDK");
    }
}
