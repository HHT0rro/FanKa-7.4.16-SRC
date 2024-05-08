package com.kwad.components.core.webview.tachikoma.c;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.utils.bi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends a {
    private FrameLayout SK;
    private e YI;
    private p aaE;
    private aw aaF;
    private com.kwad.components.core.webview.tachikoma.e.d aaG = new com.kwad.components.core.webview.tachikoma.e.d() { // from class: com.kwad.components.core.webview.tachikoma.c.c.2
        @Override // com.kwad.components.core.webview.tachikoma.e.d
        public final void fR() {
            if (c.this.aaF != null) {
                c.this.aaF.sr();
                c.this.aaF.ss();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.d
        public final void fZ() {
            if (c.this.aaF != null) {
                c.this.aaF.st();
                c.this.aaF.su();
            }
        }
    };
    private String xn;

    /* JADX INFO: Access modifiers changed from: private */
    public void sV() {
        e.a aVar = this.aay.aaD;
        if (aVar != null) {
            aVar.fT();
        }
        com.kwad.components.core.webview.tachikoma.d.b.tc().s(getTkTemplateId(), getTKReaderScene());
        k kVar = this.aay.aaA;
        if (kVar != null) {
            kVar.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0481a c0481a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        e eVar = this.YI;
        if (eVar != null) {
            eVar.a(this.aaG);
        }
        if (this.aay.aaA != null) {
            this.gj.a(new g() { // from class: com.kwad.components.core.webview.tachikoma.c.c.1
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    c.this.aay.aaA.callTKBridge(str);
                }
            });
            this.aay.aaA.a(this.gj);
            this.gj.a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        k kVar = this.aay.aaA;
        if (kVar != null) {
            kVar.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
        super.bG();
        b bVar = this.aay;
        if (bVar.aaC) {
            com.kwad.components.core.webview.tachikoma.e.c cVar = bVar.Sy;
            if (cVar != null) {
                cVar.F(true);
                return;
            }
            return;
        }
        e eVar = this.YI;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.e.c cVar2 = this.aay.Sy;
        if (cVar2 != null) {
            cVar2.ga();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.SK;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        StyleTemplate styleTemplate = this.aay.SA;
        if (styleTemplate != null) {
            return styleTemplate.templateId;
        }
        return this.xn;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.SK = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a
    public final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.aay;
        this.xn = bVar2.xn;
        this.YI = bVar2.YI;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        aVar.width = (int) ((bi.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((bi.getScreenHeight(getContext()) / aJ) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
        this.aaE = pVar;
        long j10 = this.aay.xs;
        if (pVar == null || j10 <= 0) {
            return;
        }
        y yVar = new y();
        yVar.nE = (int) ((((float) j10) / 1000.0f) + 0.5f);
        this.aaE.a(yVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.aaF = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        super.a(tVar);
        e eVar = this.YI;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.aay.Sy;
        if (cVar != null) {
            cVar.F(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        k kVar = this.aay.aaA;
        if (kVar != null) {
            kVar.callbackDialogDismiss();
        }
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.YI;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.YI.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.c.c.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        c.this.YI.e(this);
                        c.this.sV();
                    }
                });
            } else {
                sV();
            }
            this.YI.dismiss();
            return;
        }
        sV();
    }
}
