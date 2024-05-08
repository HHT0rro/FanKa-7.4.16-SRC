package com.kwad.components.ad.splashscreen.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k extends e implements com.kwad.sdk.core.h.c {
    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.Dg.Q(getContext());
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Dg.Cs.a(this);
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.Z(this.Dg.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.ab(this.Dg.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cz(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate))) {
            this.Dg.Q(getContext());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Dg.Cs.b(this);
    }
}
