package com.huawei.appgallery.agd.serverreq.bean;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ResponseBean extends JsonBean {
    public static final int ERROR = 1;
    public static final int NETWORK_ERROR = 3;
    public static final int OK = 0;
    public static final int REQ_PARAM_ERROR = 5;
    public static final int RTN_CODE_OK = 0;
    public static final int TIMEOUT = 2;
    private String originalData;

    @NetworkTransmission
    private String rtnDesc;
    private int responseType = 1;
    private int responseCode = 1;
    private int rtnCode_ = 0;
    private int httpStatusCode = -1;
    private int errCause = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ErrorCause {
        public static final int EMPTY_RESDATA = 4;
        public static final int JSON_ERROR = 2;
        public static final int NORMAL = 0;
        public static final int NO_NETWORK = 1;
        public static final int PARAM_ERROR = 3;
        public static final int UNKNOWN_EXCEPTION = 5;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ResponseDataType {
        public static final int FROM_CACHE = 0;
        public static final int FROM_NETWORK = 1;
        public static final int FROM_NETWORK_ORIGINAL_DATA = 2;
    }

    public static int getResponseCode(ResponseBean responseBean) {
        return responseBean.getResponseCode();
    }

    public static String getSafeData(ResponseBean responseBean) {
        return responseBean.getSafeData();
    }

    public static void setErrCause(ResponseBean responseBean, int i10) {
        responseBean.setErrCause(i10);
    }

    public static void setHttpStatusCode(ResponseBean responseBean, int i10) {
        responseBean.setHttpStatusCode(i10);
    }

    public static void setResponseCode(ResponseBean responseBean, int i10) {
        responseBean.setResponseCode(i10);
    }

    public String getOriginalData() {
        return this.originalData;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public int getResponseType() {
        return this.responseType;
    }

    public int getRtnCode_() {
        return this.rtnCode_;
    }

    public String getRtnDesc() {
        return this.rtnDesc;
    }

    public void setErrCause(int i10) {
        this.errCause = i10;
    }

    public void setHttpStatusCode(int i10) {
        this.httpStatusCode = i10;
    }

    public void setOriginalData(String str) {
        this.originalData = str;
    }

    public void setResponseCode(int i10) {
        this.responseCode = i10;
    }

    public void setResponseType(int i10) {
        this.responseType = i10;
    }

    public void setRtnCode_(int i10) {
        this.rtnCode_ = i10;
    }

    public void setRtnDesc(String str) {
        this.rtnDesc = str;
    }
}
