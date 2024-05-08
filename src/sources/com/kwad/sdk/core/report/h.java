package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h extends com.kwad.sdk.core.response.a.a {
    public int axF;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h bW(AdTemplate adTemplate) {
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.b.e.ea(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.b.e.dN(adTemplate);
        int ee2 = com.kwad.sdk.core.response.b.e.ee(adTemplate);
        hVar.score = ee2;
        hVar.axF = ee2 > 0 ? 1 : 0;
        return hVar;
    }

    public final String EL() {
        return toJson().toString();
    }
}
