package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;

/* compiled from: OnLightVisibleCallBackDelegata.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class d extends IOnLightCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    private final OnLightVisibleCallBack f30308a;

    public d(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.f30308a = onLightVisibleCallBack;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnLightCallback
    public void onVisibleChanged(boolean z10) throws RemoteException {
        this.f30308a.onVisibleChanged(z10);
    }
}
