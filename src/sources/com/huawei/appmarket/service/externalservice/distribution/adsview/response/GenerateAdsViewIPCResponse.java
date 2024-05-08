package com.huawei.appmarket.service.externalservice.distribution.adsview.response;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GenerateAdsViewIPCResponse extends BaseIPCResponse {
    public static final Parcelable.Creator<GenerateAdsViewIPCResponse> CREATOR = new AutoParcelable.AutoCreator(GenerateAdsViewIPCResponse.class);

    @EnableAutoParcel(2)
    private int mAdsType;

    @EnableAutoParcel(1)
    private int mResult;

    @EnableAutoParcel(3)
    private String mUuid;

    public int getAdsType() {
        return this.mAdsType;
    }

    public int getResult() {
        return this.mResult;
    }

    public String getUuid() {
        return this.mUuid;
    }
}
