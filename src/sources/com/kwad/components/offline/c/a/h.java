package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h implements IOfflineTKRenderListener {
    private final p adr;

    public h(p pVar) {
        this.adr = pVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        p pVar = this.adr;
        if (pVar != null) {
            pVar.onFailed(th);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        p pVar = this.adr;
        if (pVar != null) {
            pVar.onSuccess();
        }
    }
}
