package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class j implements com.kwad.sdk.core.webview.c.a {
    public void a(com.kwad.components.core.webview.tachikoma.b.n nVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.n nVar = new com.kwad.components.core.webview.tachikoma.b.n();
        try {
            nVar.parseJson(new JSONObject(str));
            a(nVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openURL";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}