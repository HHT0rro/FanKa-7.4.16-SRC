package com.huawei.appmarket.service.externalservice.distribution.download.request;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequireVersion;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

@RequireVersion(110102000)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GetRecommendCardReq extends BaseIPCRequest {
    public static final Parcelable.Creator<GetRecommendCardReq> CREATOR = new AutoParcelable.AutoCreator(GetRecommendCardReq.class);

    /* renamed from: c, reason: collision with root package name */
    public long f27675c;

    @EnableAutoParcel(8)
    private final boolean isSupportChunkReceive = true;

    @EnableAutoParcel(6)
    private String mCallType;

    @EnableAutoParcel(1)
    private String mCardId;

    @EnableAutoParcel(2)
    private String mChannelId;

    @EnableAutoParcel(4)
    private String mContextIntent;

    @EnableAutoParcel(9)
    private String mJsonData;

    @EnableAutoParcel(3)
    private String mReferrer;

    @EnableAutoParcel(5)
    private String mUserProfile;

    @EnableAutoParcel(7)
    private String mUuid;

    public String getCardId() {
        return this.mCardId;
    }

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.getRecommendCard";
    }

    public long getReqStartTime() {
        return this.f27675c;
    }

    public String getUuid() {
        return this.mUuid;
    }

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public void setCallType(String str) {
        this.mCallType = str;
    }

    public void setCardId(String str) {
        this.mCardId = str;
    }

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setContextIntent(String str) {
        this.mContextIntent = str;
    }

    public void setJsonData(String str) {
        this.mJsonData = str;
    }

    public void setReferrer(String str) {
        this.mReferrer = str;
    }

    public void setReqStartTime(long j10) {
        this.f27675c = j10;
    }

    public void setUserProfile(String str) {
        this.mUserProfile = str;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }
}
