package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ar implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c VX;
    private a XM = new a();

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: id, reason: collision with root package name */
        public int f36632id;
        public int status;

        public a() {
        }
    }

    private void r(int i10, int i11) {
        com.kwad.sdk.core.webview.c.c cVar = this.VX;
        if (cVar != null) {
            a aVar = this.XM;
            aVar.f36632id = i10;
            aVar.status = 2;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VX = cVar;
    }

    public final void aP(int i10) {
        r(1, 2);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAnimationListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VX = null;
    }
}
