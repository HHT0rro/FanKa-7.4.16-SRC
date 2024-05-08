package com.kwad.components.ad.splashscreen.c.a;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bm;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g extends com.kwad.components.ad.splashscreen.c.c.c implements com.kwad.sdk.core.h.c {

    /* renamed from: ld, reason: collision with root package name */
    private FrameLayout f36616ld;
    private aw wz;

    private void Z(int i10) {
        a.C0516a c0516a = new a.C0516a();
        bm bmVar = this.Dg.mTimerHelper;
        if (bmVar != null) {
            c0516a.duration = bmVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b b4 = new com.kwad.sdk.core.adlog.c.b().cT(6).b(c0516a);
        if (i10 == 2) {
            b4.cL(14);
        } else {
            b4.cL(1);
        }
        com.kwad.sdk.core.adlog.c.b(this.Dg.mAdTemplate, b4, (JSONObject) null);
    }

    private void lE() {
        this.Dg.mRootContainer.findViewById(R.id.splash_play_card_view).setVisibility(8);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.sv();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.sw();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Dg.Cs.a(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.sr();
            this.wz.ss();
        }
        lE();
        this.f36616ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.f36616ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash_end_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ds(this.Dg.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36616ld = (FrameLayout) findViewById(R.id.splash_end_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
        super.onUnbind();
        this.Dg.Cs.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
        lE();
        this.f36616ld.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        aVar.width = com.kwad.sdk.d.a.a.px2dip(getContext(), this.Dg.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.d.a.a.px2dip(getContext(), this.Dg.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        Z(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.Dg.kS();
        } else {
            com.kwad.components.ad.splashscreen.monitor.a.kT().l(this.Dg.mAdTemplate);
            this.Dg.kO();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wz = awVar;
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(qVar, bVar);
        qVar.c(a(bVar));
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Dg.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.a.g.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    g.this.Dg.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.a.g.1.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            g.this.Dg.kB();
                        }
                    });
                }
            }
        });
    }
}
