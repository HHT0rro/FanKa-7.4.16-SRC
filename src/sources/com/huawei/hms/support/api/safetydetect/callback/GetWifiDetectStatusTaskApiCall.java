package com.huawei.hms.support.api.safetydetect.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.safetydetect.WifiDetectResponse;
import com.huawei.hms.support.api.safetydetect.exception.SafetyDetectException;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class GetWifiDetectStatusTaskApiCall extends AbstractTaskApiCall<WifiDetectResponse> {
    public static final int HMS_VERSION_MIN_403 = 40003000;

    public GetWifiDetectStatusTaskApiCall(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return HMS_VERSION_MIN_403;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hms.support.api.safetydetect.callback.AbstractTaskApiCall
    public WifiDetectResponse newResponse(String str, int i10, String str2) throws SafetyDetectException {
        try {
            WifiDetectResponse wifiDetectResponse = new WifiDetectResponse(str);
            wifiDetectResponse.setRtnCode(i10);
            wifiDetectResponse.setErrorReason(str2);
            return wifiDetectResponse;
        } catch (JSONException e2) {
            throw new SafetyDetectException(e2.getLocalizedMessage());
        }
    }
}
