package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NormalResultDataAdapter<T extends NormalOfflineCompoResultData> extends NormalResultData {
    private final T mOfflineCompoResultData;

    public NormalResultDataAdapter(T t2) {
        this.mOfflineCompoResultData = t2;
    }

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    @Override // com.kwad.sdk.core.network.NormalResultData
    public void parseResponse(c cVar) {
        super.parseResponse(cVar);
        this.mOfflineCompoResultData.parseResponse(cVar);
    }
}
