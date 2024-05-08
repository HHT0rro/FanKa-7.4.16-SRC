package com.ss.android.socialbase.downloader.impls;

import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.ipc.c;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultRetryDelayTimeCalculator implements IRetryDelayTimeCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i10, int i11) {
        if (i10 == 1) {
            return c.Code;
        }
        if (i10 == 2) {
            return 15000L;
        }
        if (i10 == 3) {
            return 30000L;
        }
        if (i10 > 3) {
            return u.as;
        }
        return 0L;
    }
}
