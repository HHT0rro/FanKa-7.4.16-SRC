package com.huawei.openalliance.ad.ipc;

import com.huawei.hms.ads.annotation.AllApi;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface RemoteCallResultCallback<T> {
    void onRemoteCallResult(String str, CallResult<T> callResult);
}
