package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private a xk;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void R(int i10);
    }

    public h(a aVar) {
        this.xk = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.xk != null) {
            int i10 = 0;
            try {
                i10 = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.xk.R(i10);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xk = null;
    }
}
