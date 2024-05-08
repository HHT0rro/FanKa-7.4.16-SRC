package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o extends w {
    private a ZO;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        boolean isMuted();
    }

    public final void a(a aVar) {
        this.ZO = aVar;
    }

    public final void c(com.kwad.components.core.webview.tachikoma.b.m mVar) {
        super.b(mVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMuteStateListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        if (this.ZO != null) {
            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
            mVar.aao = this.ZO.isMuted();
            cVar.a(mVar);
        }
    }
}
