package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ResponseWrap {

    /* renamed from: a, reason: collision with root package name */
    private String f29733a;

    /* renamed from: b, reason: collision with root package name */
    private ResponseHeader f29734b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f29734b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f29734b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f29734b.setStatusCode(JsonUtil.getIntValue(jSONObject, MonitorConstants.STATUS_CODE));
            this.f29734b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f29734b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f29734b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f29734b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f29734b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f29734b.setPkgName(JsonUtil.getStringValue(jSONObject, MonitorConstants.PKG_NAME));
            this.f29734b.setSessionId(JsonUtil.getStringValue(jSONObject, ExposeManager.UtArgsNames.sessionId));
            this.f29734b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.f29734b.setResolution(JsonUtil.getStringValue(jSONObject, "resolution"));
            this.f29733a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e2) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e2.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f29733a)) {
            this.f29733a = new JSONObject().toString();
        }
        return this.f29733a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f29734b;
    }

    public void setBody(String str) {
        this.f29733a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f29734b = responseHeader;
    }

    public String toJson() {
        if (this.f29734b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MonitorConstants.STATUS_CODE, this.f29734b.getStatusCode());
            jSONObject.put("error_code", this.f29734b.getErrorCode());
            jSONObject.put("error_reason", this.f29734b.getErrorReason());
            jSONObject.put("srv_name", this.f29734b.getSrvName());
            jSONObject.put("api_name", this.f29734b.getApiName());
            jSONObject.put("app_id", this.f29734b.getAppID());
            jSONObject.put(MonitorConstants.PKG_NAME, this.f29734b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.f29734b.getTransactionId());
            jSONObject.put("resolution", this.f29734b.getResolution());
            String sessionId = this.f29734b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put(ExposeManager.UtArgsNames.sessionId, sessionId);
            }
            if (!TextUtils.isEmpty(this.f29733a)) {
                jSONObject.put("body", this.f29733a);
            }
        } catch (JSONException e2) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f29733a + "', responseHeader=" + ((Object) this.f29734b) + '}';
    }
}
