package com.kwad.components.core.page.c;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends c {
    private WebView NY;
    private int OD = -1;
    private ViewGroup OE;
    private final a OF;
    private com.kwad.components.core.webview.a cN;
    private com.kwad.sdk.core.webview.b cO;
    private AdTemplate mAdTemplate;
    private final boolean mIsRewardLandPage;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void aA(int i10);
    }

    public f(a aVar, boolean z10) {
        this.OF = aVar;
        this.mIsRewardLandPage = z10;
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void au(String str) {
        az();
        this.NY.loadUrl(str);
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.OE = this.OE;
        bVar2.NY = this.NY;
    }

    private void az() {
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.NY);
        this.cN = aVar;
        a(aVar);
        this.NY.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.core.page.c.f.2
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(f.this.NY.getContext(), new AdWebViewActivityProxy.a.C0472a().as(bVar.title).at(bVar.url).aC(true).as(f.this.mAdTemplate).pl());
            }
        };
    }

    private aq.b ps() {
        return new aq.b() { // from class: com.kwad.components.core.page.c.f.1
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar) {
                f.this.OD = aVar.status;
                if (f.this.OF != null) {
                    f.this.OF.aA(aVar.status);
                }
                if (aVar.status == 1) {
                    f.this.OE.setVisibility(0);
                } else {
                    f.this.NY.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.c.c, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.OB.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String cw = com.kwad.sdk.core.response.b.b.cw(adTemplate);
        if (!TextUtils.isEmpty(cw)) {
            ax();
            au(cw);
        } else {
            a aVar = this.OF;
            if (aVar != null) {
                aVar.aA(this.OD);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.NY = (WebView) findViewById(R.id.ksad_landing_page_webview);
        this.OE = (ViewGroup) findViewById(R.id.ksad_web_card_container);
        this.NY.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        aA();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.e.c.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.OB.mAdTemplate);
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new az(this.cO, cVar));
        aVar.a(new ac(this.cO));
        aVar.a(new aw());
        aVar.a(new aq(ps(), com.kwad.sdk.core.response.b.b.cw(this.mAdTemplate)));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new l(this.cO));
        aVar.a(new ao(getOpenNewPageListener()));
        aVar.a(new aa(this.cO, cVar, null, (byte) 0));
        aVar.a(new x(this.cO, cVar, null, 2, this.mIsRewardLandPage));
    }
}
