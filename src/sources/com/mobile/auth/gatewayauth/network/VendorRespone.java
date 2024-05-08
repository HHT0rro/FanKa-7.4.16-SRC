package com.mobile.auth.gatewayauth.network;

import com.alicom.tools.serialization.JSONType;
import com.alicom.tools.serialization.JSONUtils;
import com.alicom.tools.serialization.JSONer;
import com.alicom.tools.serialization.JSONerTag;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VendorRespone implements JSONer {

    @JSONerTag(keyName = "Code")
    private String Code;

    @JSONerTag(keyName = "Data")
    private List<VendorListRespone> Data;

    @JSONerTag(keyName = "Message")
    private String Message;

    @JSONerTag(keyName = "RequestId")
    private String RequestId;

    @Override // com.alicom.tools.serialization.JSONer
    public void fromJson(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        try {
            JSONUtils.fromJson(jSONObject, this, (List<Field>) null);
            if (jSONObject != null) {
                if (jSONObject.optJSONObject("Data") != null) {
                    jSONArray = jSONObject.optJSONObject("Data").optJSONArray("List");
                }
                setData(JSONUtils.parseJsonArray2JsonerList(jSONArray, new JSONType<VendorListRespone>() { // from class: com.mobile.auth.gatewayauth.network.VendorRespone.1
                }));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public String getCode() {
        try {
            return this.Code;
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

    public List<VendorListRespone> getData() {
        try {
            return this.Data;
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

    public String getMessage() {
        try {
            return this.Message;
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

    public String getRequestId() {
        try {
            return this.RequestId;
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

    public void setCode(String str) {
        try {
            this.Code = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setData(List<VendorListRespone> list) {
        try {
            this.Data = list;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setMessage(String str) {
        try {
            this.Message = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setRequestId(String str) {
        try {
            this.RequestId = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.alicom.tools.serialization.JSONer
    public JSONObject toJson() {
        try {
            return JSONUtils.toJson(this, null);
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
