package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements com.kwad.sdk.core.webview.c.c {
    private final IOfflineCompoCallBackFunction adh;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.adh = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void a(com.kwad.sdk.core.b bVar) {
        String jSONObject = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.adh;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void onError(int i10, String str) {
        String jSONObject = new com.kwad.sdk.core.webview.c.e(i10, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.adh;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(jSONObject);
        }
    }
}
