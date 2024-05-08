package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bd implements com.kwad.sdk.core.webview.c.a {
    private a Yg;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void sh();
    }

    public bd(a aVar) {
        this.Yg = aVar;
    }

    private void sx() {
        if (com.kwad.components.core.e.c.b.nr()) {
            return;
        }
        bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.bd.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (bd.this.Yg != null) {
                    bd.this.Yg.sh();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        sx();
    }
}
