package com.huawei.appmarket.service.externalservice.distribution.adsview.request;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequireVersion;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

@RequireVersion(110101000)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GenerateAdsViewIPCRequest extends BaseIPCRequest {
    public static final Parcelable.Creator<GenerateAdsViewIPCRequest> CREATOR = new AutoParcelable.AutoCreator(GenerateAdsViewIPCRequest.class);
    public static final String METHOD = "method.generateAdsView";

    @EnableAutoParcel(5)
    private int mAdsType;

    @EnableAutoParcel(6)
    private ApplicationInfo mAppInfo;

    @EnableAutoParcel(7)
    private Bundle mExtraMsg;

    @EnableAutoParcel(3)
    private String mInstallSourcePkg;

    @EnableAutoParcel(1)
    private String mPkg;

    @EnableAutoParcel(4)
    private int mUiVersion;

    @EnableAutoParcel(2)
    private String mUuid;

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return METHOD;
    }

    public void setAdsType(int i10) {
        this.mAdsType = i10;
    }

    public void setAppInfo(ApplicationInfo applicationInfo) {
        this.mAppInfo = applicationInfo;
    }

    public void setExtraMsg(Bundle bundle) {
        this.mExtraMsg = bundle;
    }

    public void setInstallSourcePkg(String str) {
        this.mInstallSourcePkg = str;
    }

    public void setPkg(String str) {
        this.mPkg = str;
    }

    public void setUiVersion(int i10) {
        this.mUiVersion = i10;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }
}
