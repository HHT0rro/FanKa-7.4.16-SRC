package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public Executor f28865a;

    /* renamed from: b, reason: collision with root package name */
    private OnCompleteListener<TResult> f28866b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f28867c = new Object();

    public d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f28866b = onCompleteListener;
        this.f28865a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f28867c) {
            this.f28866b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.f28865a.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this.f28867c) {
                    if (d.this.f28866b != null) {
                        d.this.f28866b.onComplete(task);
                    }
                }
            }
        });
    }
}
