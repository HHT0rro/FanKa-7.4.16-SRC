package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private a ZQ;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.b.t tVar);
    }

    public final void a(a aVar) {
        this.ZQ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ZQ = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.ZQ != null) {
            com.kwad.components.core.webview.tachikoma.b.t tVar = new com.kwad.components.core.webview.tachikoma.b.t();
            try {
                try {
                    tVar.parseJson(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.ZQ.b(tVar);
            }
        }
    }
}
