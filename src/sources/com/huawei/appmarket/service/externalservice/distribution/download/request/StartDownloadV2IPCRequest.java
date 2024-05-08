package com.huawei.appmarket.service.externalservice.distribution.download.request;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequireVersion;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

@RequireVersion(110101000)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class StartDownloadV2IPCRequest extends AbsStartDownloadIPCRequest {
    public static final Parcelable.Creator<StartDownloadV2IPCRequest> CREATOR = new AutoParcelable.AutoCreator(StartDownloadV2IPCRequest.class);
    public static final String KEY_DEVICE_ID = "deviceId";
    public static final String KEY_DEVICE_ID_TYPE = "deviceIdType";
    public static final String KEY_SERVICE_COUNTRY = "serviceCountry";
    public static final int SUPPORT_ALLOW_MOBILE_NETWORK_DOWNLOAD = 2;
    public static final int SUPPORT_FUNCTION_DEFAULT = 0;
    public static final int SUPPORT_RESERVE_DOWNLOAD = 4;
    public static final int SUPPORT_SHOW_NETWORK_DIALOG = 1;

    @EnableAutoParcel(2)
    private String mAdvInfo;

    @EnableAutoParcel(10)
    private String mAppInfo;

    @EnableAutoParcel(11)
    private String mCallType;

    @EnableAutoParcel(3)
    private String mDownloadParams;

    @EnableAutoParcel(9)
    private String mInstallType;

    @EnableAutoParcel(12)
    private String mJsonData;

    @EnableAutoParcel(1)
    private String mPackageName;

    @EnableAutoParcel(4)
    private String mReferrer;

    @EnableAutoParcel(8)
    private int mSupportFunction = 0;

    public String getAdvInfo() {
        return this.mAdvInfo;
    }

    public String getDownloadParams() {
        return this.mDownloadParams;
    }

    public String getInstallType() {
        return this.mInstallType;
    }

    public String getJsonData() {
        return this.mJsonData;
    }

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.startDownloadTaskV2";
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getReferrer() {
        return this.mReferrer;
    }

    public int getSupportFunction() {
        return this.mSupportFunction;
    }

    public void setAdvInfo(String str) {
        this.mAdvInfo = str;
    }

    public void setAppInfo(String str) {
        this.mAppInfo = str;
    }

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public void setCallType(String str) {
        this.mCallType = str;
    }

    public void setDownloadParams(String str) {
        this.mDownloadParams = str;
    }

    public void setInstallType(String str) {
        this.mInstallType = str;
    }

    public void setJsonData(String str) {
        this.mJsonData = str;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setReferrer(String str) {
        this.mReferrer = str;
    }

    public void setSupportFunction(int i10) {
        this.mSupportFunction = i10;
    }
}
