package com.kwad.components.core.webview.tachikoma.c;

import android.app.Activity;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends com.kwad.sdk.mvp.a {
    public StyleTemplate SA;
    public com.kwad.components.core.webview.tachikoma.e.c Sy;
    public e YI;
    public k aaA;
    public com.kwad.components.core.webview.tachikoma.k aaB;
    public boolean aaC;
    public e.a aaD;
    public com.kwad.sdk.widget.e aaz;
    public Activity mActivity;
    public AdResultData mAdResultData;
    public String xn;
    public long xs;

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.YI = null;
        this.mActivity = null;
        this.aaz = null;
    }
}
