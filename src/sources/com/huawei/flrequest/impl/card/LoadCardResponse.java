package com.huawei.flrequest.impl.card;

import com.huawei.flrequest.api.FLCardResponse;
import com.huawei.flrequest.impl.bean.ResponseBean;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LoadCardResponse extends ResponseBean implements FLCardResponse {
    @Override // com.huawei.flrequest.api.FLCardResponse
    public JSONArray getCards() {
        JSONObject responseJSON = getResponseJSON();
        if (responseJSON != null) {
            return responseJSON.optJSONArray("cards");
        }
        return null;
    }

    @Override // com.huawei.flrequest.api.FLCardResponse
    public JSONObject getRedirects() {
        JSONObject responseJSON = getResponseJSON();
        if (responseJSON != null) {
            return responseJSON.optJSONObject("override");
        }
        return null;
    }
}
