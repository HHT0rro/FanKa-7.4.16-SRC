package com.alibaba.security.realidentity.business.upload;

import com.alibaba.security.realidentity.build.ah;
import com.alibaba.security.realidentity.build.r;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AbsUploadFileParams extends BucketParams {
    public int mUploadErrorCode;
    private List<ah> uploadTaskList;

    public List<ah> getUploadTaskList() {
        return this.uploadTaskList;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(r rVar) {
        return true;
    }

    public void setUploadErrorCode(int i10) {
        this.mUploadErrorCode = i10;
    }

    public void setUploadTaskList(List<ah> list) {
        this.uploadTaskList = list;
    }
}
