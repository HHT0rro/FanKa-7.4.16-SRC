package com.kwad.components.core.page.c.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public com.kwad.components.core.page.a.a OI;

    @Nullable
    public KsAdWebView.c OJ;

    @Nullable
    public f.a OL;

    @Nullable
    public at.b OM;
    public boolean ON = false;
    public boolean OO = false;

    @NonNull
    public AdWebViewActivityProxy.a Os;

    @NonNull
    public ViewGroup gS;

    @NonNull
    public AdTemplate mAdTemplate;

    @NonNull
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;

    @NonNull
    public Context mContext;

    @Nullable
    public String mPageTitle;

    @NonNull
    public String mPageUrl;
    public boolean mShowPermission;

    @Nullable
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private void aG(boolean z10) {
        this.OO = true;
    }

    public final void a(KsAdWebView.c cVar) {
        this.OJ = cVar;
    }

    public final boolean pi() {
        return this.mShowPermission;
    }

    public final void pn() {
        at.b bVar = this.OM;
        if (bVar != null) {
            bVar.pF();
        }
    }

    public final boolean pt() {
        return this.OO;
    }

    public final boolean pu() {
        return !pi();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.OJ = null;
        this.OL = null;
        this.mWebCardCloseListener = null;
        this.OM = null;
    }

    public final void setWebCardCloseListener(@Nullable com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public final void a(f.a aVar) {
        this.OL = aVar;
    }

    public final void a(at.b bVar) {
        this.OM = bVar;
        aG(true);
    }
}
