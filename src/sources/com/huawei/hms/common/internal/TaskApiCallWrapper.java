package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f29741a;

    /* renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource<TResult> f29742b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource) {
        super(1);
        this.f29741a = taskApiCall;
        this.f29742b = taskCompletionSource;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f29741a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.f29742b;
    }
}
