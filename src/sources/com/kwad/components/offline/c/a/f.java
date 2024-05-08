package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.c.g adp;

    public f(com.kwad.sdk.core.webview.c.g gVar) {
        this.adp = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.c.g gVar = this.adp;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
