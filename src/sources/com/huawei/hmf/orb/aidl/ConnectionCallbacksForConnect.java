package com.huawei.hmf.orb.aidl;

import com.huawei.hmf.orb.ConnectionCallbacks;
import com.huawei.hmf.orb.exception.ConnectRemoteException;

/* compiled from: AIDLConnector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class ConnectionCallbacksForConnect implements ConnectionCallbacks {
    private final ConnectionCallbacks mCallbacks;

    public ConnectionCallbacksForConnect(ConnectionCallbacks connectionCallbacks) {
        this.mCallbacks = connectionCallbacks;
    }

    @Override // com.huawei.hmf.orb.ConnectionCallbacks
    public void onConnected() {
        this.mCallbacks.onConnected();
    }

    @Override // com.huawei.hmf.orb.ConnectionCallbacks
    public void onConnectionFailed(ConnectRemoteException connectRemoteException) {
        this.mCallbacks.onConnectionFailed(connectRemoteException);
    }

    @Override // com.huawei.hmf.orb.ConnectionCallbacks
    public void onDisconnected() {
        this.mCallbacks.onDisconnected();
    }
}
