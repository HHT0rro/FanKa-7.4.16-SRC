package com.huawei.hmf.tasks;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task) throws Exception;
}
