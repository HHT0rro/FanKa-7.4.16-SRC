package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends com.kwad.sdk.core.network.b {

    @NonNull
    public final Map<String, String> aHo;

    public c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.aHo = hashMap;
        hashMap.put("did", str);
        hashMap.put("sid", str2);
        hashMap.put("fileExtend", str3);
        hashMap.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.aHo;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return "https://" + com.kwad.sdk.core.network.idc.a.DU().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}
