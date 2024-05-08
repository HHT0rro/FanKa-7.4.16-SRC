package com.huawei.appmarket.service.externalservice.distribution.download.request;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;
import com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class UnregisterDownloadCallbackIPCRequest extends BaseIPCRequest {
    public static final Parcelable.Creator<UnregisterDownloadCallbackIPCRequest> CREATOR = new AutoParcelable.AutoCreator(UnregisterDownloadCallbackIPCRequest.class);

    @EnableAutoParcel(2)
    private IDownloadCallback mCallback;

    @EnableAutoParcel(1)
    private String mPackageName;

    public IDownloadCallback getCallback() {
        return this.mCallback;
    }

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.unregisterDownloadCallback";
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setCallback(IDownloadCallback iDownloadCallback) {
        this.mCallback = iDownloadCallback;
    }

    public void setPackageName(@Nullable String str) {
        this.mPackageName = str;
    }
}
