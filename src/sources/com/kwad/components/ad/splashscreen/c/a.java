package com.kwad.components.ad.splashscreen.c;

import android.view.View;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends e implements com.kwad.sdk.widget.c {
    private View CV;
    private boolean CW;

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.Dg.c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar == null) {
            return;
        }
        this.CW = com.kwad.sdk.core.response.b.d.dF(hVar.mAdTemplate);
        boolean n10 = com.kwad.components.ad.splashscreen.h.n(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate));
        this.CV.setVisibility(n10 ? 0 : 8);
        if (n10) {
            new com.kwad.sdk.widget.f(this.CV.getContext(), this.CV, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.sdk.core.e.c.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.CW);
        if (this.CW) {
            this.Dg.c(1, view.getContext(), 153, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.CV = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
