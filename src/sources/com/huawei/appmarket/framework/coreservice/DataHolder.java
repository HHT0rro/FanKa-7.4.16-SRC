package com.huawei.appmarket.framework.coreservice;

import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequestHeader;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DataHolder<R extends BaseIPCRequest> extends AutoParcelable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new AutoParcelable.AutoCreator(DataHolder.class);

    @EnableAutoParcel(1)
    private String mMethod;

    @EnableAutoParcel(2)
    private RequestHeader mHeader = null;

    @EnableAutoParcel(3)
    private R mRequest = null;

    public void a(R r10) {
        this.mRequest = r10;
    }

    public void b(RequestHeader requestHeader) {
        this.mHeader = requestHeader;
    }

    public void c(String str) {
        this.mMethod = str;
    }
}
