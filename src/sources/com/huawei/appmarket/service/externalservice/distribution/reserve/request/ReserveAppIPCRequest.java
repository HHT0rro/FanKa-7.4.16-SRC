package com.huawei.appmarket.service.externalservice.distribution.reserve.request;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequireVersion;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

@RequireVersion(120601000)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReserveAppIPCRequest extends BaseIPCRequest {
    public static final Parcelable.Creator<ReserveAppIPCRequest> CREATOR = new AutoParcelable.AutoCreator(ReserveAppIPCRequest.class);

    @EnableAutoParcel(5)
    private String mAdvInfo;

    @EnableAutoParcel(7)
    private String mCallType = "AGDSDKORDER";

    @EnableAutoParcel(3)
    private String mDownloadParams;

    @EnableAutoParcel(6)
    private String mInstallType;

    @EnableAutoParcel(1)
    private String mPackageName;

    @EnableAutoParcel(4)
    private String mReferrer;

    @EnableAutoParcel(2)
    private String mediaPkgSign;

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.reserveApp";
    }

    public void setAdvInfo(String str) {
        this.mAdvInfo = str;
    }

    public void setDownloadParams(String str) {
        this.mDownloadParams = str;
    }

    public void setInstallType(String str) {
        this.mInstallType = str;
    }

    public void setMediaPkgSign(String str) {
        this.mediaPkgSign = str;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setReferrer(String str) {
        this.mReferrer = str;
    }
}
