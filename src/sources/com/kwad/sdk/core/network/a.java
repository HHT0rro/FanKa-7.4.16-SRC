package com.kwad.sdk.core.network;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ay;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a<R extends f> {
    private static final ExecutorService sExecutors = GlobalThreadPools.FH();
    private Future<?> mTask;

    @CallSuper
    public void cancel() {
        Future<?> future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }

    @NonNull
    public abstract R createRequest();

    public void fetch() {
        this.mTask = getExecutor().submit(new ay() { // from class: com.kwad.sdk.core.network.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.fetchImpl();
            }
        });
    }

    @WorkerThread
    public abstract void fetchImpl();

    public ExecutorService getExecutor() {
        return sExecutors;
    }

    public abstract void onResponse(R r10, c cVar);
}
