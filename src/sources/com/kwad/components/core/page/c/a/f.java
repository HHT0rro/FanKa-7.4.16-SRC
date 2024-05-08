package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends com.kwad.components.core.page.c.a.a {
    private boolean Pg;
    private com.kwad.components.core.b.a mTitleBarHelper;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void aB(int i10);
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.OH.mPageTitle)) {
            return this.OH.mPageTitle;
        }
        List<AdInfo> list = this.OH.mAdTemplate.adInfoList;
        return (list == null || list.size() <= 0 || this.OH.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.b.a.cc(com.kwad.sdk.core.response.b.e.dQ(this.OH.mAdTemplate));
    }

    private void pD() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.OH.gS);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.ah(true);
        this.mTitleBarHelper.a(new a.InterfaceC0450a() { // from class: com.kwad.components.core.page.c.a.f.1
            @Override // com.kwad.components.core.b.a.InterfaceC0450a
            public final void u(View view) {
                f.this.x(view);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0450a
            public final void v(View view) {
                f.this.y(view);
            }
        });
        ViewGroup gF = this.mTitleBarHelper.gF();
        AdTemplate adTemplate = this.OH.mAdTemplate;
        int i10 = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.b.a.bZ(adTemplate) && !com.kwad.sdk.core.response.b.b.di(com.kwad.sdk.core.response.b.e.dQ(this.OH.mAdTemplate))) {
            i10 = 8;
        }
        gF.setVisibility(i10);
        this.OH.a(new a() { // from class: com.kwad.components.core.page.c.a.f.2
            @Override // com.kwad.components.core.page.c.a.f.a
            public final void aB(int i11) {
                f.this.mTitleBarHelper.gF().setVisibility(i11 == 1 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        KsAdWebView ksAdWebView = this.OH.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.OH.mAdWebView.goBack();
            if (this.Pg) {
                com.kwad.sdk.core.adlog.c.bM(this.OH.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.a aVar = this.OH.OI;
        if (aVar != null) {
            aVar.pd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(View view) {
        com.kwad.components.core.page.a.a aVar = this.OH.OI;
        if (aVar != null) {
            aVar.pe();
        }
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = this.OH;
        this.Pg = TextUtils.equals(bVar.mPageUrl, com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.dQ(bVar.mAdTemplate)));
        pD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
