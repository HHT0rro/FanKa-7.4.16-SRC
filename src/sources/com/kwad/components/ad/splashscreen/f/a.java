package com.kwad.components.ad.splashscreen.f;

import android.text.TextUtils;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a extends com.kwad.sdk.core.download.a.a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dQ(adTemplate);
    }

    private void i(int i10, int i11) {
        String a10 = com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, i10, i11);
        if (TextUtils.isEmpty(a10)) {
            return;
        }
        k(i10, a10);
    }

    public abstract void k(int i10, String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        i(7, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        i(8, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        i(0, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        i(12, 0);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i10) {
        i(4, i10);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i10) {
        i(2, i10);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
