package com.alibaba.security.realidentity.business.bucket;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.r;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BucketParams implements Serializable {
    public boolean isSuccessful = false;
    public ErrorCode mCurrentErrorCode;
    public String mVerifyToken;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ErrorCode implements Serializable {
        public RPResult audit;
        public String errorCode;
        public String errorMsg;
        public int globalErrorCode;

        public ErrorCode() {
        }

        public static ErrorCode createAuditNotCode() {
            ErrorCode errorCode = new ErrorCode();
            errorCode.audit = RPResult.AUDIT_NOT;
            return errorCode;
        }

        public static ErrorCode createAuditPassCode() {
            ErrorCode errorCode = new ErrorCode();
            errorCode.audit = RPResult.AUDIT_PASS;
            return errorCode;
        }

        public ErrorCode(RPResult rPResult, String str, String str2, int i10) {
            this.audit = rPResult;
            this.errorCode = str;
            this.errorMsg = str2;
            this.globalErrorCode = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();
    }

    public BucketParams() {
        ErrorCode errorCode = new ErrorCode();
        this.mCurrentErrorCode = errorCode;
        errorCode.globalErrorCode = -10000;
        errorCode.errorCode = String.valueOf(-10000);
    }

    public boolean dispatch(r rVar) {
        this.mVerifyToken = rVar.b();
        onDelivering(rVar);
        return true;
    }

    public boolean finishTask(Context context, boolean z10, a aVar, Object... objArr) {
        return true;
    }

    public Bundle getBundle() {
        return new Bundle();
    }

    public ErrorCode getErrorCode() {
        return this.mCurrentErrorCode;
    }

    public BusinessHttpWrapper getRpcRequest() {
        return null;
    }

    public String getVerifyToken() {
        return this.mVerifyToken;
    }

    public abstract boolean onDelivering(r rVar);

    public abstract ErrorCode parseErrorCode();

    public void setCurrentErrorCode(ErrorCode errorCode) {
        this.mCurrentErrorCode = errorCode;
    }

    public void setVerifyToken(String str) {
        this.mVerifyToken = str;
    }
}
