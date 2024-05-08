package com.kwad.components.ad.g.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.c.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private c ns;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        this.ns = cVar;
    }

    public final void eE() {
        c cVar = this.ns;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ns = null;
    }
}
