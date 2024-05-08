package com.alimm.tanx.core.request;

import com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxError extends Exception {
    public static final String ERROR_ADINFO_ADCOUNT_NULL = "adInfo adCount is null";
    public static final String ERROR_ADINFO_NULL = "adInfo is null";
    public static final String ERROR_AD_SWITCH_CLOSE = "ad switch close";
    public static final String ERROR_TIMEOUT = "timeout";
    public int code;
    public String message;
    public String reqId;

    public TanxError(String str) {
        super(str);
        this.reqId = "";
        this.message = "";
        this.code = AbstractAdglAnimation.INVALIDE_VALUE;
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public String getReqId() {
        return this.reqId;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "TanxError :  reqId: " + this.reqId + "\n ErrorCode:" + this.code + " \n message:" + this.message;
    }

    public TanxError(String str, String str2) {
        super(str2 + " \n reqId: " + str);
        this.code = AbstractAdglAnimation.INVALIDE_VALUE;
        this.reqId = str;
        this.message = str2;
    }

    public TanxError(String str, int i10, String str2) {
        super("\n reqId: " + str + "\n ErrorCode:" + i10 + " \n message:" + str2);
        this.reqId = str;
        this.code = i10;
        this.message = str2;
    }
}
