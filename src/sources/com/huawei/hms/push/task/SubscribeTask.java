package com.huawei.hms.push.task;

import com.huawei.hms.support.api.safetydetect.callback.GetWifiDetectStatusTaskApiCall;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SubscribeTask extends BaseVoidTask {
    public SubscribeTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return GetWifiDetectStatusTaskApiCall.HMS_VERSION_MIN_403;
    }
}
