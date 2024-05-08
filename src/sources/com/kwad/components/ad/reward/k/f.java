package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean xi;
    }

    public void U(boolean z10) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.k.f.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                boolean z10;
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    z10 = aVar.xi;
                } catch (Exception unused) {
                    z10 = false;
                }
                f.this.U(z10);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
