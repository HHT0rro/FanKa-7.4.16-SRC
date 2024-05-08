package com.kwad.components.ad.k;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    public View HK;
    private String HM;
    private a HN;

    @Nullable
    private InterfaceC0424b HO;
    public KsAdWebView cL;
    public com.kwad.sdk.core.webview.b cO;
    public aw cQ;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a cR;
    private AdBaseFrameLayout dB;

    /* renamed from: da, reason: collision with root package name */
    private FrameLayout f36538da;
    private com.kwad.components.core.webview.b fX;
    public AdTemplate mAdTemplate;

    @Nullable
    private JSONObject mReportExtData;
    private bb yt;
    private List<AdTemplate> HI = new ArrayList();

    @NonNull
    private List<c> HJ = new ArrayList();
    private int cP = -1;
    public boolean HL = false;
    private com.kwad.components.core.webview.c fY = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.ad.k.b.1
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            b bVar2 = b.this;
            bVar2.cO = bVar;
            bVar2.b(bVar);
            b.this.a(aVar);
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i10, String str) {
            b.this.HL = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            b bVar = b.this;
            bVar.HL = true;
            bVar.fo();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.k.b.1.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (b.this.HN != null) {
                        b.this.HN.iA();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            b.this.cP = aVar.status;
            com.kwad.sdk.core.e.c.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + ((Object) aVar) + "，targetUrl: " + b.this.HM);
            if (aVar.isSuccess() && b.this.HO != null) {
                b.this.HO.hJ();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            b.this.cQ = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.cR != null) {
                b.this.cR.a(aVar);
            }
        }
    };
    private ai.b cT = new ai.b() { // from class: com.kwad.components.ad.k.b.2
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            b.this.mj();
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void iA();
    }

    /* renamed from: com.kwad.components.ad.k.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InterfaceC0424b {
        void hJ();
    }

    public b() {
    }

    private void aH() {
        int i10 = this.cP;
        com.kwad.sdk.core.e.c.w("PlayEndWebCard", "show webCard fail, reason: " + (i10 == -1 ? "timeout" : i10 != 1 ? "h5error" : "others"));
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    public String B(AdTemplate adTemplate) {
        String str = this.HM;
        return str == null ? com.kwad.sdk.core.response.b.b.cy(this.mAdTemplate) : str;
    }

    public final void ag(boolean z10) {
        this.yt.ag(true);
    }

    public final boolean ar() {
        if (bx()) {
            aw awVar = this.cQ;
            if (awVar != null) {
                awVar.sr();
            }
            FrameLayout frameLayout = this.f36538da;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.cQ == null || !fk()) {
                return true;
            }
            this.cQ.ss();
            return true;
        }
        FrameLayout frameLayout2 = this.f36538da;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(4);
        }
        aH();
        return false;
    }

    public boolean bx() {
        return this.cP == 1;
    }

    public void fj() {
        this.f36538da.removeAllViews();
        this.f36538da.setVisibility(4);
        this.HK = l.inflate(this.f36538da.getContext(), getLayoutId(), this.f36538da);
        KsAdWebView ksAdWebView = (KsAdWebView) this.f36538da.findViewById(R.id.ksad_web_card_webView);
        this.cL = ksAdWebView;
        if (ksAdWebView != null) {
            boolean z10 = false;
            ksAdWebView.setBackgroundColor(0);
            this.cL.getBackground().setAlpha(0);
            this.fX = new com.kwad.components.core.webview.b();
            b.a f10 = new b.a().az(this.mAdTemplate).aF(B(this.mAdTemplate)).d(this.cL).e(this.mReportExtData).k(this.dB).f(this.HJ.get(0));
            if (this.HJ.size() > 1 && this.HI.size() > 1) {
                z10 = true;
            }
            this.fX.a(f10.aS(z10).a(this.fY));
            this.cL.loadUrl(B(this.mAdTemplate));
            fm();
        }
    }

    public boolean fk() {
        return true;
    }

    public void fm() {
    }

    public void fn() {
    }

    public void fo() {
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public String getName() {
        return "PlayEndWebCard";
    }

    public final void lW() {
        com.kwad.components.core.webview.b bVar = this.fX;
        if (bVar != null) {
            bVar.jp();
        }
    }

    public final void mj() {
        if (bq.a(this.cL, 50, false)) {
            aw awVar = this.cQ;
            if (awVar != null) {
                awVar.st();
            }
            this.f36538da.setVisibility(4);
            aw awVar2 = this.cQ;
            if (awVar2 != null) {
                awVar2.su();
            }
        }
    }

    public final void release() {
        this.HO = null;
    }

    public void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.cR = aVar;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i10) {
        this.HJ.add(cVar);
        this.dB = adBaseFrameLayout;
        this.f36538da = frameLayout;
        this.mAdTemplate = adTemplate;
        fj();
    }

    public b(@Nullable JSONObject jSONObject, @Nullable String str) {
        this.mReportExtData = jSONObject;
        this.HM = str;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2) {
        this.HJ = list2;
        this.dB = adBaseFrameLayout;
        this.f36538da = frameLayout;
        if (list != null && list.size() > 0) {
            this.HI = list;
            this.mAdTemplate = list.get(0);
        }
        fj();
    }

    public final void a(@Nullable InterfaceC0424b interfaceC0424b) {
        this.HO = interfaceC0424b;
        this.f36538da.setVisibility(4);
        this.cP = -1;
        String B = B(this.mAdTemplate);
        com.kwad.sdk.core.e.c.d("PlayEndWebCard", "startPreloadWebView url : " + B);
        if (TextUtils.isEmpty(B) || this.cL == null) {
            return;
        }
        fn();
        this.cL.loadUrl(B);
    }

    public final void a(a aVar) {
        this.HN = aVar;
    }

    public void a(com.kwad.components.core.webview.a aVar) {
        if (this.HJ.size() > 1 && this.HI.size() > 1) {
            aVar.a(new aa(this.cO, this.HJ.get(0), this.cR, (byte) 0));
            aVar.a(new x(this.cO, this.HJ, this.cR));
            aVar.a(new am(this.HI, this.HJ));
        }
        bb bbVar = new bb();
        this.yt = bbVar;
        aVar.a(bbVar);
        aVar.a(new ai(this.cT));
    }
}
