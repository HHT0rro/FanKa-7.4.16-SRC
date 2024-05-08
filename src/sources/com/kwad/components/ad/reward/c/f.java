package com.kwad.components.ad.reward.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private d qg;

    public f(d dVar) {
        this.qg = dVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qg = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.c.f.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (f.this.qg != null) {
                        f.this.qg.a(bVar);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
    }
}
