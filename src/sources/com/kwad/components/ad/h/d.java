package com.kwad.components.ad.h;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends KSFrameLayout implements j, com.kwad.sdk.core.h.c {
    public static String nU = "PUSH_VIEW_TAG";
    private final com.kwad.components.core.widget.a.b bQ;
    private aw cQ;
    private i gj;
    private AdTemplate nV;
    private com.kwad.components.ad.b.a.b nW;
    private boolean nX;
    private ViewGroup nY;
    private boolean nZ;

    public d(@NonNull Context context, AdTemplate adTemplate) {
        super(context);
        this.nX = false;
        setTag(nU);
        this.nV = adTemplate;
        this.bQ = new com.kwad.components.core.widget.a.b(this, 100);
        this.gj = new i(-1L, getContext()) { // from class: com.kwad.components.ad.h.d.1
            {
                super(-1L, r4);
            }

            @Override // com.kwad.components.core.webview.tachikoma.i
            public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, q qVar, ViewGroup viewGroup) {
                super.a(bVar, cVar, qVar, viewGroup);
                qVar.c(new x(bVar, cVar, this) { // from class: com.kwad.components.ad.h.d.1.1
                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void K(int i10) {
                        super.K(i10);
                        if (i10 == 3) {
                            d.this.a((WebCloseStatus) null);
                        }
                    }
                });
            }
        };
        this.gj.a((Activity) null, com.kwad.sdk.core.response.b.c.dB(this.nV), this);
    }

    private void destroy() {
        this.gj.jp();
        ViewGroup viewGroup = this.nY;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ() {
        if (this.nZ) {
            return;
        }
        this.nZ = true;
        eT();
        destroy();
    }

    private void eR() {
        com.kwad.components.ad.b.a.b bVar = this.nW;
        if (bVar != null) {
            bVar.T();
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sr();
            this.cQ.ss();
        }
    }

    private void eT() {
        com.kwad.components.ad.b.a.b bVar = this.nW;
        if (bVar != null) {
            bVar.U();
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.st();
            this.cQ.su();
        }
    }

    private boolean eU() {
        try {
            com.kwad.sdk.core.c.b.DD();
            final Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                View findViewById = currentActivity.getWindow().getDecorView().findViewById(16908290);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.nY = (ViewGroup) findViewById;
                this.nY.addView(this, new ViewGroup.LayoutParams(-1, -1));
                com.kwad.sdk.core.c.b.DD();
                com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.h.d.2
                    @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                    /* renamed from: onActivityDestroyed */
                    public final void b(Activity activity) {
                        super.b(activity);
                        com.kwad.sdk.core.c.b.DD();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        if (activity.equals(currentActivity)) {
                            d.this.eQ();
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0481a c0481a) {
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

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.e.c.d("PushAdView", "onPageVisible: ");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sv();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.e.c.d("PushAdView", "onPageInvisible: ");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sw();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.bQ.a(this);
        this.bQ.tw();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        this.bQ.release();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aJ = com.kwad.sdk.d.a.a.aJ(getContext());
        float screenHeight = com.kwad.sdk.d.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.d.a.a.getScreenWidth(getContext()) / aJ) + 0.5f);
        aVar.height = (int) ((screenHeight / aJ) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        com.kwad.sdk.core.e.c.d("PushAdView", "onTkLoadSuccess");
        this.nX = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    public final boolean c(com.kwad.components.ad.b.a.b bVar) {
        this.nW = bVar;
        if (!this.nX || !eU()) {
            return false;
        }
        eR();
        return true;
    }

    public final boolean eS() {
        return this.nX;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_push_ad";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dy(this.nV);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.e.c.d("PushAdView", "onTkLoadFailed");
        this.nX = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.e.c.d("PushAdView", "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.cQ = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable WebCloseStatus webCloseStatus) {
        eQ();
    }
}
