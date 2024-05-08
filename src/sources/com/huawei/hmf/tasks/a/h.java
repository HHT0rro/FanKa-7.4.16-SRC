package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class h<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private OnSuccessListener<TResult> f28883a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f28884b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f28885c = new Object();

    public h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f28883a = onSuccessListener;
        this.f28884b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f28885c) {
            this.f28883a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.f28884b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (h.this.f28885c) {
                    if (h.this.f28883a != null) {
                        h.this.f28883a.onSuccess(task.getResult());
                    }
                }
            }
        });
    }
}
