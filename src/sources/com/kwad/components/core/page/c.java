package com.kwad.components.core.page;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.e;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.page.c.a.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends com.kwad.components.core.l.c<com.kwad.components.core.page.c.a.b> {
    private AdWebViewActivityProxy.a Os;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean mAutoShow;
    private Context mContext;
    private com.kwad.components.core.page.a.a mLandPageViewListener;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private c(Context context) {
        super(context);
    }

    public static c a(Context context, AdWebViewActivityProxy.a aVar) {
        c cVar = new c(context);
        cVar.b(context, aVar);
        return cVar;
    }

    private void b(Context context, AdWebViewActivityProxy.a aVar) {
        this.Os = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.pg();
        this.mPageTitle = aVar.pf();
        this.mShowPermission = aVar.pi();
        this.mAutoShow = aVar.pk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.c
    /* renamed from: pm, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.page.c.a.b kt() {
        com.kwad.components.core.page.c.a.b bVar = new com.kwad.components.core.page.c.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.Os = this.Os;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mAutoShow = this.mAutoShow;
        bVar.mShowPermission = this.mShowPermission;
        bVar.OI = this.mLandPageViewListener;
        bVar.setWebCardCloseListener(this.mWebCardCloseListener);
        bVar.gS = this.lD;
        return bVar;
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.release();
            this.mAdWebView = null;
        }
    }

    public final boolean getCanInterceptBackClick() {
        return ((com.kwad.components.core.page.c.a.b) this.mPresenter.Jx()).pt();
    }

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        return R.layout.ksad_activity_ad_webview;
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
    }

    @Override // com.kwad.components.core.l.c
    public final void kr() {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        presenter.a(new e());
        if (com.kwad.sdk.core.response.b.e.F(((com.kwad.components.core.page.c.a.b) this.Mu).mAdTemplate)) {
            presenter.a(new com.kwad.components.core.page.c.a.c());
        }
        if (com.kwad.sdk.core.response.b.a.aO(com.kwad.sdk.core.response.b.e.dQ(((com.kwad.components.core.page.c.a.b) this.Mu).mAdTemplate)) && com.kwad.components.core.q.a.qH().qN() && com.kwad.components.core.q.a.qH().qI() == 1) {
            presenter.a(new com.kwad.components.core.page.c.a.d());
        }
        presenter.a(new g());
        return presenter;
    }

    public final void pn() {
        ((com.kwad.components.core.page.c.a.b) this.mPresenter.Jx()).pn();
    }

    public final void setLandPageViewListener(com.kwad.components.core.page.a.a aVar) {
        this.mLandPageViewListener = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
        if (this.mAdWebView != null || bVar == null) {
            return;
        }
        bVar.b(null);
    }
}
