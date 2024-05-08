package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface g<R extends f, T extends BaseResultData> {
    @WorkerThread
    void onError(@NonNull R r10, int i10, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r10);

    @WorkerThread
    void onSuccess(@NonNull R r10, @NonNull T t2);
}
