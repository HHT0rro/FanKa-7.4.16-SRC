package com.huawei.hmf.orb.aidl.impl;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hmf.orb.aidl.IRemoteServiceBroker;
import com.huawei.hmf.orb.aidl.IRemoteServiceCallbacks;
import com.huawei.hmf.orb.aidl.communicate.AIDLInvoke;
import com.huawei.hmf.orb.aidl.communicate.RequestHeader;
import com.huawei.hmf.services.ui.internal.SecurityIntent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RemoteServiceBroker extends IRemoteServiceBroker.Stub {
    private IBinder aidlInvoke = new AIDLInvoke();
    private final IBindConnector mBindConnector;

    public RemoteServiceBroker(IBindConnector iBindConnector) {
        this.mBindConnector = iBindConnector;
    }

    @Override // com.huawei.hmf.orb.aidl.IRemoteServiceBroker
    public void getService(GetServiceRequest getServiceRequest, IRemoteServiceCallbacks iRemoteServiceCallbacks) throws RemoteException {
        if (getServiceRequest != null && getServiceRequest.getServiceId() == 0 && getServiceRequest.getBindIntent() != null) {
            Intent bindIntent = getServiceRequest.getBindIntent();
            RequestHeader from = RequestHeader.from(SecurityIntent.from(bindIntent).getBundleExtra(RequestHeader.getDescriptor()));
            if (!TextUtils.isEmpty(from.packageName)) {
                int onNewBind = this.mBindConnector.onNewBind(from.packageName, bindIntent);
                if (onNewBind == 0) {
                    iRemoteServiceCallbacks.onResult(onNewBind, this.aidlInvoke);
                    return;
                } else {
                    iRemoteServiceCallbacks.onResult(onNewBind, null);
                    return;
                }
            }
        }
        iRemoteServiceCallbacks.onResult(207135000, null);
    }
}
