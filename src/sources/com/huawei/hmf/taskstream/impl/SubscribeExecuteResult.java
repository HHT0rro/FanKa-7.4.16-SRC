package com.huawei.hmf.taskstream.impl;

import com.huawei.hmf.taskstream.Disposable;
import com.huawei.hmf.taskstream.ExecuteResult;
import com.huawei.hmf.taskstream.Observer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SubscribeExecuteResult implements ExecuteResult {
    private Disposable result;

    public SubscribeExecuteResult(Disposable disposable) {
        this.result = disposable;
    }

    @Override // com.huawei.hmf.taskstream.ExecuteResult
    public final void onComplete(Observer observer) {
        if (observer != null) {
            observer.onSubscribe(this.result);
        }
    }
}
