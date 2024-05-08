package com.huawei.appmarket.service.externalservice.distribution.referrer.response;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class QueryReferrerResponse extends BaseIPCResponse {
    public static final Parcelable.Creator<QueryReferrerResponse> CREATOR = new AutoParcelable.AutoCreator(QueryReferrerResponse.class);

    @EnableAutoParcel(2)
    private long mClickTimestampSeconds;

    @EnableAutoParcel(1)
    private String mInstallReferrer;

    @EnableAutoParcel(3)
    private long mInstallTimestampSeconds;

    public long getClickTimestampSeconds() {
        return this.mClickTimestampSeconds;
    }

    public String getInstallReferrer() {
        return this.mInstallReferrer;
    }

    public long getInstallTimestampSeconds() {
        return this.mInstallTimestampSeconds;
    }
}
