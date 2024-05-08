package com.mobile.auth.gatewayauth.sdktools.upload.pns.model;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.jsoner.JSONUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UploadMonitorDTO extends BaseUploadDTO {
    private static final long serialVersionUID = -7916879376930002080L;
    private String action;
    private String apiLevel;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f37363c;

    @Override // com.mobile.auth.gatewayauth.sdktools.upload.pns.model.BaseUploadDTO, com.nirvana.tools.jsoner.Jsoner
    public void fromJson(JSONObject jSONObject) {
        try {
            super.fromJson(jSONObject);
            setC(JSONUtils.json2MapForStringString(jSONObject.optJSONObject("c")));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public String getAction() {
        try {
            return this.action;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public String getApiLevel() {
        try {
            return this.apiLevel;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public Map<String, String> getC() {
        try {
            return this.f37363c;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public UploadMonitorDTO setAction(String str) {
        try {
            this.action = str;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public UploadMonitorDTO setApiLevel(String str) {
        try {
            this.apiLevel = str;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public UploadMonitorDTO setC(Map<String, String> map) {
        try {
            this.f37363c = map;
            return this;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.sdktools.upload.pns.model.BaseUploadDTO, com.nirvana.tools.jsoner.Jsoner
    public JSONObject toJson() {
        try {
            JSONObject json = super.toJson();
            try {
                json.put("c", new JSONObject(this.f37363c));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return json;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    @Override // com.mobile.auth.gatewayauth.sdktools.upload.pns.model.BaseUploadDTO
    public String toString() {
        try {
            return super.toString() + "UploadMonitorDTO{action='" + this.action + "', apiLevel='" + this.apiLevel + "', c=" + ((Object) this.f37363c) + '}';
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }
}
