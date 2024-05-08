package com.huawei.hms.support.api.safetydetect.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.safetydetect.RiskTokenResponse;
import com.huawei.hms.support.api.safetydetect.exception.SafetyDetectException;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class GetRiskTokenApiCall extends AbstractTaskApiCall<RiskTokenResponse> {
    public GetRiskTokenApiCall(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return AbstractTaskApiCall.HMS_VERSION_MIN_402;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hms.support.api.safetydetect.callback.AbstractTaskApiCall
    public RiskTokenResponse newResponse(String str, int i10, String str2) throws SafetyDetectException {
        try {
            return new RiskTokenResponse(str);
        } catch (JSONException e2) {
            throw new SafetyDetectException(e2.getLocalizedMessage());
        }
    }
}
