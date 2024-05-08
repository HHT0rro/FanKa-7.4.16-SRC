package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f28870a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final int f28871b;

    /* renamed from: c, reason: collision with root package name */
    private final i<Void> f28872c;

    /* renamed from: d, reason: collision with root package name */
    private int f28873d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f28874e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28875f;

    public e(int i10, i<Void> iVar) {
        this.f28871b = i10;
        this.f28872c = iVar;
    }

    private void a() {
        if (this.f28873d >= this.f28871b) {
            if (this.f28874e != null) {
                this.f28872c.a(new ExecutionException("a task failed", this.f28874e));
            } else if (this.f28875f) {
                this.f28872c.a();
            } else {
                this.f28872c.a((i<Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f28870a) {
            this.f28873d++;
            this.f28875f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f28870a) {
            this.f28873d++;
            this.f28874e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.f28870a) {
            this.f28873d++;
            a();
        }
    }
}
