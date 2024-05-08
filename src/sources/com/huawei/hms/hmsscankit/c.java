package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;

/* compiled from: OnErrorCallbackDelegate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class c extends IOnErrorCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    private final OnErrorCallback f30307a;

    public c(OnErrorCallback onErrorCallback) {
        this.f30307a = onErrorCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnErrorCallback
    public void onError(int i10) throws RemoteException {
        if (this.f30307a != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onError: ErrorCode：");
            sb2.append(i10);
            this.f30307a.onError(i10);
        }
    }
}
