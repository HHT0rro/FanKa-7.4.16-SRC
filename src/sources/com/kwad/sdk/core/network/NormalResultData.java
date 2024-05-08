package com.kwad.sdk.core.network;

import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NormalResultData extends BaseResultData {
    public int code;
    public String data;
    public Map<String, String> header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.avs;
        this.header = null;
    }
}
