package com.huawei.appgallery.agd.api;

import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appmarket.framework.coreservice.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ResultCallback<R extends BaseIPCResponse> {
    void onResult(Status<R> status);
}
