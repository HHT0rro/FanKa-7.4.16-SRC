package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class at implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c VX;
    private c XQ;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int status;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void pF();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void pI();
    }

    public at(c cVar) {
        this.XQ = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VX = cVar;
        c cVar2 = this.XQ;
        if (cVar2 != null) {
            cVar2.pI();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VX = null;
    }

    public final void sq() {
        if (this.VX != null) {
            a aVar = new a();
            aVar.status = 1;
            this.VX.a(aVar);
        }
    }
}
