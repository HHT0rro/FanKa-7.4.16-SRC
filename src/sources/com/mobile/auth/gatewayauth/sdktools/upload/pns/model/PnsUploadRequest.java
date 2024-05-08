package com.mobile.auth.gatewayauth.sdktools.upload.pns.model;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.jsoner.JSONUtils;
import com.nirvana.tools.jsoner.JsonType;
import com.nirvana.tools.jsoner.Jsoner;
import java.io.Serializable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PnsUploadRequest implements Jsoner, Serializable {
    private static final long serialVersionUID = -7838291328068778271L;
    private List<UploadLogDTO> uploadLogDTOList;
    private List<UploadMonitorDTO> uploadMonitorDTOList;

    @Override // com.nirvana.tools.jsoner.Jsoner
    public void fromJson(JSONObject jSONObject) {
        try {
            setUploadLogDTOList(JSONUtils.parseJsonArray2JsonerList(jSONObject.optJSONArray("uploadLogDTOList"), new JsonType<UploadLogDTO>() { // from class: com.mobile.auth.gatewayauth.sdktools.upload.pns.model.PnsUploadRequest.1
            }));
            setUploadMonitorDTOList(JSONUtils.parseJsonArray2JsonerList(jSONObject.optJSONArray("uploadMonitorDTOList"), new JsonType<UploadMonitorDTO>() { // from class: com.mobile.auth.gatewayauth.sdktools.upload.pns.model.PnsUploadRequest.2
            }));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public List<UploadLogDTO> getUploadLogDTOList() {
        try {
            return this.uploadLogDTOList;
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

    public List<UploadMonitorDTO> getUploadMonitorDTOList() {
        try {
            return this.uploadMonitorDTOList;
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

    public PnsUploadRequest setUploadLogDTOList(List<UploadLogDTO> list) {
        try {
            this.uploadLogDTOList = list;
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

    public PnsUploadRequest setUploadMonitorDTOList(List<UploadMonitorDTO> list) {
        try {
            this.uploadMonitorDTOList = list;
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

    @Override // com.nirvana.tools.jsoner.Jsoner
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uploadLogDTOList", JSONUtils.jsonerList2JsonArray(this.uploadLogDTOList));
                jSONObject.put("uploadMonitorDTOList", JSONUtils.jsonerList2JsonArray(this.uploadMonitorDTOList));
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

    public String toString() {
        try {
            return "PnsUploadRequest{uploadLogDTOList=" + ((Object) this.uploadLogDTOList) + ", uploadMonitorDTOList=" + ((Object) this.uploadMonitorDTOList) + '}';
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
