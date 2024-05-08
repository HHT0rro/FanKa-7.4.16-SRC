package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private OnFailureListener f28876a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f28877b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f28878c = new Object();

    public f(Executor executor, OnFailureListener onFailureListener) {
        this.f28876a = onFailureListener;
        this.f28877b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f28878c) {
            this.f28876a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.f28877b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (f.this.f28878c) {
                    if (f.this.f28876a != null) {
                        f.this.f28876a.onFailure(task.getException());
                    }
                }
            }
        });
    }
}
