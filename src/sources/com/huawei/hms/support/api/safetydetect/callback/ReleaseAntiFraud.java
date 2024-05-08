package com.huawei.hms.support.api.safetydetect.callback;

import android.content.Context;
import com.huawei.hms.support.api.safetydetect.exception.SafetyDetectException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ReleaseAntiFraud extends AbstractTaskApiCall<Void> {
    public ReleaseAntiFraud(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return AbstractTaskApiCall.HMS_VERSION_MIN_402;
    }

    @Override // com.huawei.hms.support.api.safetydetect.callback.AbstractTaskApiCall
    public Void newResponse(String str, int i10, String str2) throws SafetyDetectException {
        return null;
    }
}
