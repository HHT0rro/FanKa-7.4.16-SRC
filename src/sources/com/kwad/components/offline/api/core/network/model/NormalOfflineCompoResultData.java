package com.kwad.components.offline.api.core.network.model;

import com.kwad.sdk.core.network.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NormalOfflineCompoResultData extends BaseOfflineCompoResultData {
    public int code;
    public String data;
    public String header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.avs;
        this.header = null;
    }
}
