package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private OnCanceledListener f28858a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f28859b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f28860c = new Object();

    public b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f28858a = onCanceledListener;
        this.f28859b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f28860c) {
            this.f28858a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.f28859b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this.f28860c) {
                        if (b.this.f28858a != null) {
                            b.this.f28858a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
