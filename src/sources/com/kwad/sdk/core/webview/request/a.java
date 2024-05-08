package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.g;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends d {
    private String aER;
    private String mUrl;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.mUrl = str;
        this.aER = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e2) {
            c.printStackTrace(e2);
            jSONObject = null;
        }
        c.d("WebCardGetDataRequest", "mBodyParams1 size=" + this.mBodyParams.length());
        if (jSONObject != null) {
            c.d("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        }
        t.merge(this.mBodyParams, jSONObject);
        c.d("WebCardGetDataRequest", "mBodyParams2 size=" + this.mBodyParams.length());
        addHeader("user-agent", p.getUserAgent());
        c.d("WebCardGetDataRequest", "user-agent" + p.getUserAgent());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        return g.xV() + this.mUrl;
    }
}
