package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(com.kwad.sdk.core.request.model.a.EZ());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getAppInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
