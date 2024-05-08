package com.huawei.hms.push.task;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ProfileTask extends BaseVoidTask {
    public ProfileTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 2;
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50004300;
    }
}
