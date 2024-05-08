package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g implements IOfflineTKCallHandler {
    private final n adq;

    public g(n nVar) {
        this.adq = nVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        n nVar = this.adq;
        if (nVar != null) {
            nVar.callJS(str);
        }
    }
}
