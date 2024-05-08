package com.huawei.hmf.orb.aidl.client;

import android.os.Looper;
import com.huawei.hmf.orb.aidl.client.Result;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class PendingResult<R extends Result> {
    public abstract R await();

    public abstract R await(long j10, TimeUnit timeUnit);

    public abstract void setResultCallback(Looper looper, ResultCallback<R> resultCallback);

    public abstract void setResultCallback(ResultCallback<R> resultCallback);
}
