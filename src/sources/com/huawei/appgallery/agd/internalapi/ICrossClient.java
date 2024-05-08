package com.huawei.appgallery.agd.internalapi;

import android.content.Context;
import com.huawei.appgallery.agd.api.AgdApiClient;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appmarket.framework.coreservice.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ICrossClient {
    public static final String KEY_START_DOWNLOAD_REQUEST = "startDownloadV2IPCRequest";

    Status crossClientTaskProcess(Context context, BaseIPCRequest baseIPCRequest);

    boolean isCrossClient(AgdApiClient agdApiClient);
}
