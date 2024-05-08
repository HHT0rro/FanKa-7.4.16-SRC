package com.huawei.appmarket.service.externalservice.distribution.download.request;

import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AbsStartDownloadIPCRequest extends BaseIPCRequest {

    @EnableAutoParcel(6)
    private String mContentId;

    @EnableAutoParcel(5)
    private int mAdvPlatform = 0;

    @EnableAutoParcel(7)
    private int mDownloadFlag = 0;

    public int getAdvPlatform() {
        return this.mAdvPlatform;
    }

    public String getContentId() {
        return this.mContentId;
    }

    public int getDownloadFlag() {
        return this.mDownloadFlag;
    }

    public void setAdvPlatform(int i10) {
        this.mAdvPlatform = i10;
    }

    public void setContentId(String str) {
        this.mContentId = str;
    }

    public void setDownloadFlag(int i10) {
        this.mDownloadFlag = i10;
    }
}
