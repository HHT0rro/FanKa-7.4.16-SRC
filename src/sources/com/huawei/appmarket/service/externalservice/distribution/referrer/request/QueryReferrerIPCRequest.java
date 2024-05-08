package com.huawei.appmarket.service.externalservice.distribution.referrer.request;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class QueryReferrerIPCRequest extends BaseIPCRequest {
    public static final Parcelable.Creator<QueryReferrerIPCRequest> CREATOR = new AutoParcelable.AutoCreator(QueryReferrerIPCRequest.class);

    @EnableAutoParcel(1)
    private String mPackageName;

    @Override // com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest
    public String getMethod() {
        return "method.getInstallReferred";
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }
}
