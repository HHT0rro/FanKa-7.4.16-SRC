package com.mobile.auth.gatewayauth.model.pns_vendor_query;

import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.jsoner.Jsoner;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UploadRB implements Jsoner {
    private PscInfoUploadResponse alibaba_aliqin_psc_info_upload_response;

    public static UploadRB fromJson(String str) {
        try {
            UploadRB uploadRB = new UploadRB();
            try {
                if (!TextUtils.isEmpty(str)) {
                    uploadRB.fromJson(new JSONObject(str));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return uploadRB;
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
        try {
            PscInfoUploadResponse pscInfoUploadResponse = new PscInfoUploadResponse();
            if (jSONObject != null) {
                pscInfoUploadResponse.fromJson(jSONObject.optJSONObject("alibaba_aliqin_psc_info_upload_response"));
            }
            setAlibaba_aliqin_psc_info_upload_response(pscInfoUploadResponse);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public PscInfoUploadResponse getAlibaba_aliqin_psc_info_upload_response() {
        try {
            return this.alibaba_aliqin_psc_info_upload_response;
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

    public void setAlibaba_aliqin_psc_info_upload_response(PscInfoUploadResponse pscInfoUploadResponse) {
        try {
            this.alibaba_aliqin_psc_info_upload_response = pscInfoUploadResponse;
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
                PscInfoUploadResponse pscInfoUploadResponse = this.alibaba_aliqin_psc_info_upload_response;
                jSONObject.putOpt("alibaba_aliqin_psc_info_upload_response", pscInfoUploadResponse == null ? new JSONObject() : pscInfoUploadResponse.toJson());
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
