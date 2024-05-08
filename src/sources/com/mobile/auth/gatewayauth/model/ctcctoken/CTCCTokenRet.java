package com.mobile.auth.gatewayauth.model.ctcctoken;

import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.jsoner.JSONUtils;
import com.nirvana.tools.jsoner.JsonType;
import com.nirvana.tools.jsoner.Jsoner;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CTCCTokenRet implements Jsoner {
    private Data data;
    private String msg;
    private String reqId;
    private int result;

    public static CTCCTokenRet fromJson(String str) {
        try {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    CTCCTokenRet cTCCTokenRet = (CTCCTokenRet) JSONUtils.fromJson(jSONObject, (JsonType) new JsonType<CTCCTokenRet>() { // from class: com.mobile.auth.gatewayauth.model.ctcctoken.CTCCTokenRet.1
                    }, (List<Field>) null);
                    cTCCTokenRet.setData((Data) JSONUtils.fromJson(jSONObject.optJSONObject("data"), (JsonType) new JsonType<Data>() { // from class: com.mobile.auth.gatewayauth.model.ctcctoken.CTCCTokenRet.2
                    }, (List<Field>) null));
                    return cTCCTokenRet;
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
        try {
            JSONUtils.fromJson(jSONObject, this, (List<Field>) null);
            if (jSONObject != null) {
                setData((Data) JSONUtils.fromJson(jSONObject.optJSONObject("data"), (JsonType) new JsonType<Data>() { // from class: com.mobile.auth.gatewayauth.model.ctcctoken.CTCCTokenRet.3
                }, (List<Field>) null));
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public Data getData() {
        try {
            return this.data;
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

    public String getMsg() {
        try {
            return this.msg;
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

    public String getReqId() {
        try {
            return this.reqId;
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

    public int getResult() {
        try {
            return this.result;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
    }

    public void setData(Data data) {
        try {
            this.data = data;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setMsg(String str) {
        try {
            this.msg = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setReqId(String str) {
        try {
            this.reqId = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setResult(int i10) {
        try {
            this.result = i10;
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
            JSONObject json = JSONUtils.toJson(this, null);
            try {
                Data data = this.data;
                json.put("data", data == null ? new JSONObject() : data.toJson());
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
}
