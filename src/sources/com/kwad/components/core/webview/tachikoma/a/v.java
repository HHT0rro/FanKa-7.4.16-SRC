package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class v implements com.kwad.sdk.core.webview.c.a {
    private a ZS;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.b.m mVar);
    }

    public final void a(a aVar) {
        this.ZS = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateVideoMuteState";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ZS = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.ZS != null) {
            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
            try {
                mVar.parseJson(new JSONObject(str));
                this.ZS.b(mVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
