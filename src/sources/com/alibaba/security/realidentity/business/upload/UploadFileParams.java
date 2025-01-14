package com.alibaba.security.realidentity.business.upload;

import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.realidentity.build.r;
import com.alibaba.security.realidentity.business.bucket.BucketParams;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UploadFileParams extends AbsUploadFileParams {
    @Override // com.alibaba.security.realidentity.business.upload.AbsUploadFileParams, com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(r rVar) {
        return super.onDelivering(rVar);
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        if (this.mUploadErrorCode == 0) {
            BucketParams.ErrorCode createAuditPassCode = BucketParams.ErrorCode.createAuditPassCode();
            createAuditPassCode.globalErrorCode = 0;
            createAuditPassCode.errorCode = String.valueOf(0);
            createAuditPassCode.errorMsg = "success";
            return createAuditPassCode;
        }
        BucketParams.ErrorCode createAuditNotCode = BucketParams.ErrorCode.createAuditNotCode();
        createAuditNotCode.globalErrorCode = GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR;
        createAuditNotCode.errorCode = String.valueOf(GlobalErrorCode.ERROR_UPLOAD_BIO_PIC_ERROR);
        createAuditNotCode.errorMsg = "uploadFile onError";
        return createAuditNotCode;
    }
}
