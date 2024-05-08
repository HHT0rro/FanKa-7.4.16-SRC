package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class PendingResult<R extends Result> {
    public abstract R await();

    public abstract R await(long j10, TimeUnit timeUnit);

    @Deprecated
    public abstract void cancel();

    public <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> resultConvert) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public abstract boolean isCanceled();

    public abstract void setResultCallback(Looper looper, ResultCallback<R> resultCallback);

    public abstract void setResultCallback(ResultCallback<R> resultCallback);

    @Deprecated
    public abstract void setResultCallback(ResultCallback<R> resultCallback, long j10, TimeUnit timeUnit);
}
