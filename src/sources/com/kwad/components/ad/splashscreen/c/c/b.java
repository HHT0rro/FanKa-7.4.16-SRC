package com.kwad.components.ad.splashscreen.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.webview.tachikoma.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends i {
    public b(Context context, int i10, int i11) {
        super(context, i10, i11);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void f(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dr(sJ()))) {
            return;
        }
        com.kwad.components.ad.splashscreen.monitor.b.kV().c(sJ(), str2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void g(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dr(sJ()))) {
            return;
        }
        com.kwad.components.ad.splashscreen.monitor.b.kV().d(sJ(), str2);
    }
}
