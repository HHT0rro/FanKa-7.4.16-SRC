package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    private static final String TAG = "ResultCallbacks";

    public abstract void onFailure(Status status);

    public abstract void onSuccess(R r10);

    @Override // com.huawei.hms.support.api.client.ResultCallback
    public final void onResult(R r10) {
        try {
            Status status = r10.getStatus();
            if (status.isSuccess()) {
                onSuccess(r10);
            } else {
                onFailure(status);
                if (r10 instanceof Releasable) {
                    ((Releasable) r10).release();
                }
            }
        } catch (Exception e2) {
            HMSLog.w(TAG, "Failed to release " + ((Object) r10) + ", reason: " + ((Object) e2));
        }
    }
}
