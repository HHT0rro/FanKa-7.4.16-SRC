package com.huawei.hmf.tasks;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract CancellationToken register(Runnable runnable);
}
