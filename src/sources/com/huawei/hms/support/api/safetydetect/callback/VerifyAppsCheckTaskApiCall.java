package com.huawei.hms.support.api.safetydetect.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.safetydetect.VerifyAppsCheckEnabledResp;
import com.huawei.hms.support.api.safetydetect.exception.SafetyDetectException;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VerifyAppsCheckTaskApiCall extends AbstractTaskApiCall<VerifyAppsCheckEnabledResp> {
    public VerifyAppsCheckTaskApiCall(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hms.support.api.safetydetect.callback.AbstractTaskApiCall
    public VerifyAppsCheckEnabledResp newResponse(String str, int i10, String str2) throws SafetyDetectException {
        try {
            VerifyAppsCheckEnabledResp verifyAppsCheckEnabledResp = new VerifyAppsCheckEnabledResp(str);
            verifyAppsCheckEnabledResp.setRtnCode(i10);
            verifyAppsCheckEnabledResp.setErrorReason(str2);
            return verifyAppsCheckEnabledResp;
        } catch (JSONException e2) {
            throw new SafetyDetectException(e2.getLocalizedMessage());
        }
    }
}
