package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class ResultTransform<R extends Result, S extends Result> {
    @NonNull
    public Status a(@RecentlyNonNull Status status) {
        return status;
    }

    @RecentlyNullable
    @WorkerThread
    public abstract PendingResult<S> b(@RecentlyNonNull R r10);
}
