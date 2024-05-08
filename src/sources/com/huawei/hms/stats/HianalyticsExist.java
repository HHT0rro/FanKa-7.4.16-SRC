package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HianalyticsExist {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f31806a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f31807b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f31808c;

    public static boolean isHianalyticsExist() {
        synchronized (f31806a) {
            if (!f31807b) {
                f31807b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f31808c);
            }
        }
        return f31808c;
    }
}
