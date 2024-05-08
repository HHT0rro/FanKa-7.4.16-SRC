package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c extends CancellationToken {

    /* renamed from: a, reason: collision with root package name */
    public final List<Runnable> f28862a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Object f28863b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f28864c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f28864c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.f28863b) {
            if (this.f28864c) {
                runnable.run();
            } else {
                this.f28862a.add(runnable);
            }
        }
        return this;
    }
}
