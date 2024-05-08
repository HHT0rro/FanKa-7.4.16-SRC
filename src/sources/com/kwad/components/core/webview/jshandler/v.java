package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class v implements com.kwad.sdk.core.webview.c.a {
    public void a(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.components.core.webview.tachikoma.b.x xVar = new com.kwad.components.core.webview.tachikoma.b.x();
        try {
            xVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
        bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.v.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (xVar.sR()) {
                    v.this.a(xVar);
                    return;
                }
                if (xVar.sT()) {
                    v.this.d(xVar);
                } else if (xVar.sS()) {
                    v.this.c(xVar);
                } else if (xVar.isFailed()) {
                    v.this.b(xVar);
                }
            }
        });
    }

    public void b(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    public void c(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    public void d(com.kwad.components.core.webview.tachikoma.b.x xVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateVideoPlayStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
