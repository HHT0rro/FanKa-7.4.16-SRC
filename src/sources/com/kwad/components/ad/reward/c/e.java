package com.kwad.components.ad.reward.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private String TAG;
    private com.kwad.sdk.core.webview.c.c ns;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String rq;
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.e.c.d(str, "create: ");
    }

    private void E(String str) {
        if (TextUtils.isEmpty(str) || this.ns == null) {
            return;
        }
        a aVar = new a();
        aVar.rq = str;
        this.ns.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.e.c.d(this.TAG, "handleJsCall: " + ((Object) cVar));
        this.ns = cVar;
    }

    public final void gQ() {
        com.kwad.sdk.core.e.c.d(this.TAG, "notifyDialogClose: ");
        E("close");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.e.c.d(this.TAG, "onDestroy: ");
        this.ns = null;
    }
}
