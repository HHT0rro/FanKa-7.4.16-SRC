package com.huawei.quickcard.cardmanager.bi;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface Reporter {
    int getHostVersionCode(Context context);

    void reportDownload(Context context, CardReportBean cardReportBean);
}
