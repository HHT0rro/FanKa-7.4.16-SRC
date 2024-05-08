package com.huawei.hmf.tasks;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult tresult) throws Exception;
}
