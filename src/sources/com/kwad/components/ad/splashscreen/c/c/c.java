package com.kwad.components.ad.splashscreen.c.c;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.c.e;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class c extends e implements j {
    private b Fl;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0481a c0481a) {
        String str = c0481a.VR;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1929947611:
                if (str.equals("adShowCallback")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1291763712:
                if (str.equals("adDownloadConfirmTipCancel")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1228923142:
                if (str.equals("adCloseCallback")) {
                    c4 = 2;
                    break;
                }
                break;
            case -532703741:
                if (str.equals("adDownloadConfirmTipShow")) {
                    c4 = 3;
                    break;
                }
                break;
            case -268512828:
                if (str.equals("adDownloadConfirmTipDismiss")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1609027339:
                if (str.equals("adAutoCloseCallback")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1699234957:
                if (str.equals("adShowErrorCallback")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1852274314:
                if (str.equals("adClickCallback")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.Dg.kF();
                return;
            case 1:
                this.Dg.kK();
                return;
            case 2:
                this.Dg.kH();
                return;
            case 3:
                this.Dg.kJ();
                return;
            case 4:
                this.Dg.kL();
                return;
            case 5:
                this.Dg.kG();
                return;
            case 6:
                this.Dg.kE();
                return;
            case 7:
                this.Dg.kI();
                return;
            default:
                return;
        }
    }

    public void a(aw awVar) {
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

    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        int lJ = lJ();
        b bVar = new b(getContext(), lJ, lJ);
        this.Fl = bVar;
        bVar.a((Activity) null, this.Dg.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.Dg.mRootContainer;
    }

    public int lJ() {
        return 1000;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Fl.jp();
    }
}
