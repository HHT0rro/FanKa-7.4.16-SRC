package com.huawei.appmarket.service.externalservice.distribution.download.request;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ResumeTaskIPCRequest extends BaseIPCRequest {
    public static final Parcelable.Creator<ResumeTaskIPCRequest> CREATOR = new AutoParcelable.AutoCreator(ResumeTaskIPCRequest.class);

    @EnableAutoParcel(1)
    private String mPackageName;

    @EnableAutoParcel(2)
    private int mSupportFunction = 0;

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.resumeTask";
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setSupportFunction(int i10) {
        this.mSupportFunction = i10;
    }
}
