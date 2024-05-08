package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private a xe;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.b.p pVar);
    }

    public final void a(a aVar) {
        this.xe = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xe = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.p pVar = new com.kwad.components.core.webview.tachikoma.b.p();
        try {
            pVar.parseJson(new JSONObject(str));
            a aVar = this.xe;
            if (aVar != null) {
                aVar.a(pVar);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
