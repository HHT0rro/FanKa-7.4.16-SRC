package com.huawei.hmf.orb.aidl.client;

import com.huawei.hmf.orb.aidl.IAIDLInvoke;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ApiClient {
    String getAppID();

    String getPackageName();

    IAIDLInvoke getService();

    boolean isConnected();
}
