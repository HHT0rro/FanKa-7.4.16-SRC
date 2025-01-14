package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l implements com.kwad.sdk.core.webview.c.a {
    public com.kwad.sdk.core.webview.b Wf;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements com.kwad.sdk.core.b {
        private String Jj;
        private AdTemplate adTemplate;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.Jj = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.Jj);
            return jSONObject;
        }
    }

    public l(com.kwad.sdk.core.webview.b bVar) {
        this.Wf = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.download.a.dx(com.kwad.sdk.core.response.b.e.dQ(a(aVar)).adConversionInfo.appDownloadUrl);
            cVar.a(null);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            cVar.onError(-1, th.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "cancelAppDownloadForAd";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    private AdTemplate a(a aVar) {
        if (aVar.adTemplate != null) {
            return aVar.adTemplate;
        }
        return this.Wf.cV(aVar.Jj);
    }
}
