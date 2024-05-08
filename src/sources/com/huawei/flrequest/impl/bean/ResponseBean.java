package com.huawei.flrequest.impl.bean;

import androidx.annotation.NonNull;
import com.huawei.flrequest.api.FLResponseType;
import com.huawei.serverrequest.api.ServerResponse;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ResponseBean extends JsonBean {
    public static final int RTN_CODE_DEFAULT = -1000;
    private static final String RTN_CODE_KEY = "rtnCode";
    public static final int RTN_CODE_SUCCESS = 0;
    private static final String RTN_DESC_KEY = "rtnDesc";
    private JSONObject mResponseJson;
    private int mRtnCode = -1000;
    private String mRtnDesc = "";
    private FLResponseType mResponseType = FLResponseType.FROM_SERVER;

    public JSONObject getResponseJSON() {
        return this.mResponseJson;
    }

    @NonNull
    public ServerResponse.ResponseType getResponseType() {
        FLResponseType fLResponseType = FLResponseType.FROM_CACHE;
        FLResponseType fLResponseType2 = this.mResponseType;
        if (fLResponseType == fLResponseType2) {
            return ServerResponse.ResponseType.FROM_CACHE;
        }
        if (FLResponseType.FROM_SERVER == fLResponseType2) {
            return ServerResponse.ResponseType.FROM_SERVER;
        }
        throw new RuntimeException("unsupported response type: " + ((Object) this.mResponseType));
    }

    public int getRtnCode() {
        return this.mRtnCode;
    }

    public String getRtnDesc() {
        return this.mRtnDesc;
    }

    public boolean isSuccess() {
        return getRtnCode() == 0;
    }

    public void setResponseJSON(JSONObject jSONObject) {
        this.mResponseJson = jSONObject;
        this.mRtnCode = jSONObject.optInt(RTN_CODE_KEY, -1000);
        this.mRtnDesc = jSONObject.optString(RTN_DESC_KEY);
    }

    public void setResponseType(FLResponseType fLResponseType) {
        this.mResponseType = fLResponseType;
    }

    public void setRtnCode(int i10) {
        this.mRtnCode = i10;
    }
}
