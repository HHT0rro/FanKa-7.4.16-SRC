package com.alibaba.security.realidentity.business.submit;

import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.r;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SubmitHttpParams extends AbsSubmitHttpParams {
    private SubmitHttpResponse submitHttpResponse;

    public BusinessRequest assemable() {
        return new BusinessRequest(SubmitHttpRequest.class, new SubmitHttpRequest(this.mVerifyToken));
    }

    @Override // com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public HttpBucketParams doTransform(HttpResponse httpResponse) {
        if (httpResponse instanceof SubmitHttpResponse) {
            this.submitHttpResponse = (SubmitHttpResponse) httpResponse;
        }
        return this;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        return new BusinessHttpWrapper(SubmitHttpResponse.class, assemable());
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(r rVar) {
        return false;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        SubmitHttpResponse submitHttpResponse = this.submitHttpResponse;
        if (submitHttpResponse == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", "submit fail by response is null", GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
        }
        if (submitHttpResponse.isSuccessful()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "submit result success", 0);
        }
        int status = this.submitHttpResponse.getStatus();
        if (status > 1 && status < 100) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_FAIL, String.valueOf(status), this.submitHttpResponse.getMsg(), status);
        }
        int code = this.submitHttpResponse.getCode();
        return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, String.valueOf(code), this.submitHttpResponse.getMsg(), code);
    }
}
