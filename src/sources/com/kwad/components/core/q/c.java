package com.kwad.components.core.q;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.w;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.core.webview.tachikoma.d;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.c.c {
    private d qP() {
        return new d() { // from class: com.kwad.components.core.q.c.1
            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                w wVar = new w();
                wVar.aav = a.qH().qO() + 1;
                cVar.a(wVar);
            }
        };
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        qVar.c(qP());
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.c, com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        if (webCloseStatus.interactSuccess) {
            e eVar = this.aay.YI;
            if (eVar != null) {
                eVar.dismiss();
                return;
            }
            return;
        }
        this.aay.mActivity.finish();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
    }
}
