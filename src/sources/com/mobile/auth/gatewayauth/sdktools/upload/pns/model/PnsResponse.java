package com.mobile.auth.gatewayauth.sdktools.upload.pns.model;

import com.huawei.openalliance.ad.constant.ax;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.nirvana.tools.jsoner.JsonerTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PnsResponse {

    @JsonerTag(keyName = ax.f32264g)
    private String requestId;

    @JsonerTag(keyName = "result")
    private PnsResult result;

    public String getRequestId() {
        try {
            return this.requestId;
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

    public PnsResult getResult() {
        try {
            return this.result;
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

    public void setRequestId(String str) {
        try {
            this.requestId = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setResult(PnsResult pnsResult) {
        try {
            this.result = pnsResult;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
