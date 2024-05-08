package com.mobile.auth.gatewayauth.model.psc_certify_id;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.model.TopErrorResponse;
import com.nirvana.tools.jsoner.JSONUtils;
import com.nirvana.tools.jsoner.JsonType;
import com.nirvana.tools.jsoner.Jsoner;
import com.nirvana.tools.jsoner.JsonerTag;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GetCertifyIdRB implements Jsoner {
    private static final String KEY_RESPONSE = "alibaba_aliqin_ta_pns_living_create_response";
    private static final String KEY_TOP_ERROR_RESPONSE = "error_response";

    @JsonerTag(keyName = KEY_TOP_ERROR_RESPONSE)
    private TopErrorResponse errorResponse;

    @JsonerTag(keyName = KEY_RESPONSE)
    private GetCertifyIdTopResponse response;

    @Override // com.nirvana.tools.jsoner.Jsoner
    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setResponse((GetCertifyIdTopResponse) JSONUtils.fromJson(jSONObject.optJSONObject(KEY_RESPONSE), (JsonType) new JsonType<GetCertifyIdTopResponse>() { // from class: com.mobile.auth.gatewayauth.model.psc_certify_id.GetCertifyIdRB.1
                }, (List<Field>) null));
                setErrorResponse((TopErrorResponse) JSONUtils.fromJson(jSONObject.optJSONObject(KEY_TOP_ERROR_RESPONSE), (JsonType) new JsonType<TopErrorResponse>() { // from class: com.mobile.auth.gatewayauth.model.psc_certify_id.GetCertifyIdRB.2
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

    public GetCertifyIdTopResponse getResponse() {
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

    public void setResponse(GetCertifyIdTopResponse getCertifyIdTopResponse) {
        try {
            this.response = getCertifyIdTopResponse;
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
                GetCertifyIdTopResponse getCertifyIdTopResponse = this.response;
                jSONObject.put(KEY_RESPONSE, getCertifyIdTopResponse == null ? new JSONObject() : getCertifyIdTopResponse.toJson());
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
