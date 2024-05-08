package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RetryDelayTimeParamCalculator implements IRetryDelayTimeCalculator {
    private final long[] mTimeArray;

    public RetryDelayTimeParamCalculator(String str) {
        this.mTimeArray = parseTimeArray(str);
    }

    private long[] parseTimeArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i10 = 0; i10 < split.length; i10++) {
                jArr[i10] = Long.parseLong(split[i10]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i10, int i11) {
        long[] jArr = this.mTimeArray;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i12 = i10 - 1;
        if (i12 < 0) {
            i12 = 0;
        }
        if (i12 > jArr.length - 1) {
            i12 = jArr.length - 1;
        }
        return jArr[i12];
    }
}
