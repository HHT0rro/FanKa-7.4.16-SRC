package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.o4;

/* compiled from: OnResultCallbackDelegate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class e extends IOnResultCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    private final OnResultCallback f30309a;

    /* renamed from: b, reason: collision with root package name */
    private String f30310b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f30311c;

    public e(OnResultCallback onResultCallback, boolean z10) {
        this.f30309a = onResultCallback;
        this.f30311c = z10;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnResultCallback
    public void onResult(HmsScan[] hmsScanArr) throws RemoteException {
        o4.d("OnResultCallbackDelegat", "result callback sdk continueScan" + this.f30311c);
        if (this.f30311c) {
            this.f30309a.onResult(hmsScanArr);
            return;
        }
        if (hmsScanArr == null || hmsScanArr.length <= 0 || hmsScanArr[0] == null || TextUtils.equals(this.f30310b, hmsScanArr[0].getOriginalValue())) {
            return;
        }
        this.f30310b = hmsScanArr[0].getOriginalValue();
        o4.d("OnResultCallbackDelegat", "result callback sdk continueScan" + this.f30311c);
        this.f30309a.onResult(hmsScanArr);
    }
}
