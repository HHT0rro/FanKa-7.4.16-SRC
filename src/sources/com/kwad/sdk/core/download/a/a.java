package com.kwad.sdk.core.download.a;

import com.kwad.sdk.api.KsAppDownloadListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    public a() {
    }

    public final String nX() {
        return this.downloadId;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i10) {
    }

    public a(String str) {
        this.downloadId = str;
    }
}
