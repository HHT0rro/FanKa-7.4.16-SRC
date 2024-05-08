package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IOfflineCompoRequestListener<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    @WorkerThread
    void onError(@NonNull R r10, int i10, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r10);

    @WorkerThread
    void onSuccess(@NonNull R r10, @NonNull T t2);
}
