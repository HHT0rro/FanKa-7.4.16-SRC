package com.huawei.flrequest.impl.card;

import com.huawei.flrequest.api.FLCardUrisResponse;
import com.huawei.flrequest.impl.bean.ResponseBean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardUrisResponse extends ResponseBean implements FLCardUrisResponse {
    @Override // com.huawei.flrequest.api.FLCardUrisResponse
    public JSONObject getOverride() {
        JSONObject responseJSON = getResponseJSON();
        if (responseJSON != null) {
            return responseJSON.optJSONObject("override");
        }
        return null;
    }

    @Override // com.huawei.flrequest.api.FLCardUrisResponse
    public JSONArray getUris() {
        JSONObject responseJSON = getResponseJSON();
        if (responseJSON != null) {
            return responseJSON.optJSONArray("uris");
        }
        return null;
    }
}
