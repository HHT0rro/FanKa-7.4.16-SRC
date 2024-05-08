package com.huawei.hmf.orb.aidl;

import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.orb.aidl.client.ApiClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface DatagramTransport {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface CallBack {
        void onCallback(int i10, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, CallBack callBack);

    void send(ApiClient apiClient, CallBack callBack);
}
