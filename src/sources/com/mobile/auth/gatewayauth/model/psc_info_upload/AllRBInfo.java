package com.mobile.auth.gatewayauth.model.psc_info_upload;

import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.model.TopErrorResponse;
import com.nirvana.tools.jsoner.JSONUtils;
import com.nirvana.tools.jsoner.JsonType;
import com.nirvana.tools.jsoner.Jsoner;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AllRBInfo implements Jsoner {
    private static final String KEY_RESPONSE = "alibaba_aliqin_pns_vendor_querylist_response";
    private static final String KEY_TOP_ERROR_RESPONSE = "error_response";
    private TopErrorResponse errorResponse;
    private PnsVendorQueryResponse response;

    public static AllRBInfo fromJson(String str) {
        try {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return (AllRBInfo) JSONUtils.fromJson(new JSONObject(str), (JsonType) new JsonType<AllRBInfo>() { // from class: com.mobile.auth.gatewayauth.model.psc_info_upload.AllRBInfo.1
                    }, (List<Field>) null);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return null;
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

    @Override // com.nirvana.tools.jsoner.Jsoner
    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setResponse((PnsVendorQueryResponse) JSONUtils.fromJson(jSONObject.optJSONObject(KEY_RESPONSE), (JsonType) new JsonType<PnsVendorQueryResponse>() { // from class: com.mobile.auth.gatewayauth.model.psc_info_upload.AllRBInfo.2
                }, (List<Field>) null));
                setErrorResponse((TopErrorResponse) JSONUtils.fromJson(jSONObject.optJSONObject(KEY_TOP_ERROR_RESPONSE), (JsonType) new JsonType<TopErrorResponse>() { // from class: com.mobile.auth.gatewayauth.model.psc_info_upload.AllRBInfo.3
                }, (List<Field>) null));
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public TopErrorResponse getErrorResponse() {
        try {
            return this.errorResponse;
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

    public PnsVendorQueryResponse getResponse() {
        try {
            return this.response;
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

    public void setErrorResponse(TopErrorResponse topErrorResponse) {
        try {
            this.errorResponse = topErrorResponse;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setResponse(PnsVendorQueryResponse pnsVendorQueryResponse) {
        try {
            this.response = pnsVendorQueryResponse;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.nirvana.tools.jsoner.Jsoner
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                PnsVendorQueryResponse pnsVendorQueryResponse = this.response;
                jSONObject.put(KEY_RESPONSE, pnsVendorQueryResponse == null ? new JSONObject() : pnsVendorQueryResponse.toJson());
                TopErrorResponse topErrorResponse = this.errorResponse;
                jSONObject.put(KEY_TOP_ERROR_RESPONSE, topErrorResponse == null ? new JSONObject() : topErrorResponse.toJson());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
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
