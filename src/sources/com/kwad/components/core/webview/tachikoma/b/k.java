package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k extends com.kwad.sdk.core.response.a.a {
    public int aak;
    public int aal = -1;
    public int aam;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.t.putValue(jSONObject, "insertScreenAdShowStrategy", this.aak);
        com.kwad.sdk.utils.t.putValue(jSONObject, "isAutoShow", this.aam);
        int i10 = this.aal;
        if (i10 != -1) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i10);
        }
        return jSONObject;
    }
}
