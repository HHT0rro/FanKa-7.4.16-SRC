package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.tachikoma.a.w;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class m extends w {

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String name = "backPressed";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerBackPressedListener";
    }

    public final void jg() {
        b(new a());
    }
}
