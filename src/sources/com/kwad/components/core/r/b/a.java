package com.kwad.components.core.r.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.c;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends Presenter implements j {
    private FrameLayout SK;
    private aw SL;
    public boolean SM;
    public com.kwad.components.core.r.a.b SN;
    private com.kwad.components.core.l.a.a SO = new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.a.1
        @Override // com.kwad.components.core.l.a.a
        public final void c(c cVar) {
            a.this.qT();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void d(c cVar) {
            a.this.qU();
        }

        @Override // com.kwad.components.core.l.a.a
        public final void fP() {
        }

        @Override // com.kwad.components.core.l.a.a
        public final void fQ() {
            a.this.qV();
        }
    };
    private i gj;

    private void qS() {
        aw awVar = this.SL;
        if (awVar == null) {
            return;
        }
        if (!this.SM) {
            awVar.sr();
            this.SL.ss();
            this.SM = true;
            return;
        }
        awVar.sv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT() {
        qS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qU() {
        aw awVar = this.SL;
        if (awVar == null || !this.SM) {
            return;
        }
        awVar.sw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qV() {
        aw awVar = this.SL;
        if (awVar == null || !this.SM) {
            return;
        }
        awVar.st();
        this.SL.su();
        l lVar = this.SN.SD;
        if (lVar != null) {
            lVar.callbackDismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0481a c0481a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.SN = (com.kwad.components.core.r.a.b) Jx();
        this.SK = (FrameLayout) findViewById(R.id.ksad_js_container);
        i iVar = new i(getContext(), 1000, 0);
        this.gj = iVar;
        iVar.a(this.SN.SA);
        l lVar = this.SN.SD;
        if (lVar != null) {
            lVar.a(this.gj);
            this.gj.a(new g() { // from class: com.kwad.components.core.r.b.a.2
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    l lVar2 = a.this.SN.SD;
                    if (lVar2 != null) {
                        lVar2.callTKBridge(str);
                    }
                }
            });
            this.gj.a("hasTKBridge", Boolean.TRUE);
        }
        this.gj.a(getActivity(), this.SN.mAdResultData, this);
        this.SN.Ms.add(this.SO);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        qS();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.SK;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_activity";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return this.SN.SA.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final e getTouchCoordsView() {
        return this.SN.mRootContainer;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        qV();
        this.gj.jp();
        this.SN.Ms.remove(this.SO);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aJ) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.SL = awVar;
    }
}
