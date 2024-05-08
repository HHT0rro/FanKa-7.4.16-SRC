package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VerifyAppsCheckEnabledResp extends BaseResp {
    public boolean result;

    public VerifyAppsCheckEnabledResp(String str) throws JSONException {
        this.result = new JSONObject(str).optBoolean("result");
    }

    public boolean getResult() {
        return this.result;
    }

    public void setResult(boolean z10) {
        this.result = z10;
    }
}
