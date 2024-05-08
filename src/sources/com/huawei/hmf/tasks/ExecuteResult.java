package com.huawei.hmf.tasks;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ExecuteResult<TResult> {
    void cancel();

    void onComplete(Task<TResult> task);
}
