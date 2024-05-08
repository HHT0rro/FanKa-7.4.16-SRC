package com.huawei.hms.mlsdk.common.internal.client.event;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MonitorResult {
    public static final String SUCCESS = "SUCCESS";
    public static final String ZOOM_NOT_SUPPORT = "ZOOM_NOT_SUPPORT";
    private String code;
    private Object data;
    private String message;

    public static final MonitorResult ofFailureResult(String str) {
        return ofFailureResult(str, null, null);
    }

    public static final MonitorResult ofSuccessResult() {
        MonitorResult monitorResult = new MonitorResult();
        monitorResult.setCode(SUCCESS);
        monitorResult.setMessage(null);
        monitorResult.setData(null);
        return monitorResult;
    }

    public String getCode() {
        return this.code;
    }

    public Object getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public static final MonitorResult ofFailureResult(String str, String str2) {
        return ofFailureResult(str, str2, null);
    }

    public static final MonitorResult ofFailureResult(String str, String str2, Object obj) {
        MonitorResult monitorResult = new MonitorResult();
        monitorResult.setCode(str);
        monitorResult.setMessage(str2);
        monitorResult.setData(obj);
        return monitorResult;
    }
}
