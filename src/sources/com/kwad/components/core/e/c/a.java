package com.kwad.components.core.e.c;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.components.core.e.c.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a extends KSFrameLayout {
    private final b Ke;
    private final b.C0460b Kf;
    private d Kg;
    private InterfaceC0459a Kh;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.e.c.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InterfaceC0459a {
        void nq();
    }

    public a(Context context, b bVar, b.C0460b c0460b) {
        super(context);
        this.mContext = context;
        this.Ke = bVar;
        this.Kf = c0460b;
        this.mAdTemplate = c0460b.adTemplate;
        l.inflate(context, R.layout.ksad_download_dialog_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        a(adBaseFrameLayout, "rootView is null");
        a((KsAdWebView) adBaseFrameLayout.findViewById(R.id.ksad_download_tips_web_card_webView), "webView is null");
    }

    private void a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + a.class.getClassLoader().getClass().getName());
    }

    private static Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    private d np() {
        d dVar = new d();
        dVar.Ke = this.Ke;
        dVar.Kf = this.Kf;
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        return dVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.Kg = np();
        Presenter af = af();
        this.mPresenter = af;
        af.G(this.mRootContainer);
        this.mPresenter.k(this.Kg);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        d dVar = this.Kg;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0459a interfaceC0459a = this.Kh;
        if (interfaceC0459a != null) {
            interfaceC0459a.nq();
        }
    }

    public final void setChangeListener(InterfaceC0459a interfaceC0459a) {
        this.Kh = interfaceC0459a;
    }
}
