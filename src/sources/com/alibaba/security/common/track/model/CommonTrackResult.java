package com.alibaba.security.common.track.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CommonTrackResult extends BaseTrackResult {
    public static final int ERROR_CODE = -1;
    public static final int SUCCESS_CODE = 0;
    public int errorCode;
    public String message;

    public CommonTrackResult(int i10, String str) {
        this.errorCode = i10;
        this.message = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public CommonTrackResult(String str) {
        this.errorCode = 0;
        this.message = str;
    }

    public CommonTrackResult() {
        this.errorCode = 0;
        this.message = "";
    }
}
