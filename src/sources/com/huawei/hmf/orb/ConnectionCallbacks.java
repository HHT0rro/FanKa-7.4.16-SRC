package com.huawei.hmf.orb;

import com.huawei.hmf.orb.exception.ConnectRemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ConnectionCallbacks {
    void onConnected();

    void onConnectionFailed(ConnectRemoteException connectRemoteException);

    void onDisconnected();
}
