package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NormalRequestListenerAdapter<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> implements g<NormalRequestAdapter<R>, NormalResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public NormalRequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    @Override // com.kwad.sdk.core.network.g
    public void onError(@NonNull NormalRequestAdapter<R> normalRequestAdapter, int i10, String str) {
        this.mRequestListener.onError(normalRequestAdapter.getOfflineCompoRequest(), i10, str);
    }

    @Override // com.kwad.sdk.core.network.g
    public void onStartRequest(@NonNull NormalRequestAdapter<R> normalRequestAdapter) {
        this.mRequestListener.onStartRequest(normalRequestAdapter.getOfflineCompoRequest());
    }

    @Override // com.kwad.sdk.core.network.g
    public void onSuccess(@NonNull NormalRequestAdapter<R> normalRequestAdapter, @NonNull NormalResultDataAdapter<T> normalResultDataAdapter) {
        this.mRequestListener.onSuccess(normalRequestAdapter.getOfflineCompoRequest(), normalResultDataAdapter.getOfflineCompoResultData());
    }
}
