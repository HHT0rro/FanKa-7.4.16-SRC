package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bb implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c VX;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int Yc;

        public a(int i10) {
            this.Yc = i10;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VX = cVar;
    }

    public final void ag(boolean z10) {
        if (this.VX == null) {
            com.kwad.sdk.core.e.c.d("WebCardRewardTaskStatusHandler", "notifyTaskStatus , status:" + (z10 ? 1 : 0));
        } else {
            this.VX.a(new a(z10 ? 1 : 0));
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
