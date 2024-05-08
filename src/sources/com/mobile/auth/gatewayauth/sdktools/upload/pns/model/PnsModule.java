package com.mobile.auth.gatewayauth.sdktools.upload.pns.model;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.jsoner.JsonerTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PnsModule {

    @JsonerTag(keyName = "limited_info")
    private PnsLimitedInfo limitedInfo;

    @JsonerTag(keyName = "upload_log")
    private PnsUploadLog uploadLog;

    public PnsLimitedInfo getLimitedInfo() {
        try {
            return this.limitedInfo;
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

    public PnsUploadLog getUploadLog() {
        try {
            return this.uploadLog;
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

    public void setLimitedInfo(PnsLimitedInfo pnsLimitedInfo) {
        try {
            this.limitedInfo = pnsLimitedInfo;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setUploadLog(PnsUploadLog pnsUploadLog) {
        try {
            this.uploadLog = pnsUploadLog;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
