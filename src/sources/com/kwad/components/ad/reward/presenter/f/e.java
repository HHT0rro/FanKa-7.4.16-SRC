package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.aw;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e implements g.a {
    private boolean wA;
    private boolean wB;
    private aw wz;

    private void iY() {
        aw awVar = this.wz;
        if (awVar == null || !this.wB) {
            return;
        }
        if (!this.wA) {
            awVar.sr();
            this.wz.ss();
            this.wA = true;
            return;
        }
        awVar.sv();
    }

    public final void b(aw awVar) {
        this.wz = awVar;
    }

    public final void bF() {
        iY();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fU() {
        this.wB = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
        this.wB = true;
        iY();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fW() {
        this.wB = false;
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.sw();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fX() {
        this.wB = false;
    }

    public final void iZ() {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
    }

    public final void y(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void z(com.kwad.components.ad.reward.g gVar) {
        aw awVar = this.wz;
        if (awVar != null) {
            awVar.st();
            this.wz.su();
        }
        gVar.b(this);
    }
}
