package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SysIntegrityResp extends BaseResp {
    public String result;

    public SysIntegrityResp() {
    }

    public SysIntegrityResp(String str) throws JSONException {
        this.result = new JSONObject(str).optString("jwsResult");
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
