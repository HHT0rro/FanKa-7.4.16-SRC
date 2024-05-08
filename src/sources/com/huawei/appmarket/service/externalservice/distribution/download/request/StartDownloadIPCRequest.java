package com.huawei.appmarket.service.externalservice.distribution.download.request;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequireVersion;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

@RequireVersion(100102000)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class StartDownloadIPCRequest extends AbsStartDownloadIPCRequest {
    public static final Parcelable.Creator<StartDownloadIPCRequest> CREATOR = new AutoParcelable.AutoCreator(StartDownloadIPCRequest.class);
    public static final int DOWNLOAD_FLAG_BROADCAST = 1;
    public static final int DOWNLOAD_FLAG_DEFAULT = 0;
    public static final int DOWNLOAD_FLAG_MIN_DETAIL = 2;
    public static final int PLATFORM_OTHER = 0;
    public static final int PLATFORM_PPS = 1;

    @EnableAutoParcel(2)
    private String mAdvInfo;

    @EnableAutoParcel(3)
    private String mDownloadParams;

    @EnableAutoParcel(1)
    private String mPackageName;

    @EnableAutoParcel(4)
    private String mReferrer;

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.startDownloadTask";
    }

    public void setAdvInfo(String str) {
        this.mAdvInfo = str;
    }

    public void setDownloadParams(String str) {
        this.mDownloadParams = str;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setReferrer(String str) {
        this.mReferrer = str;
    }
}
