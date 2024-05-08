package com.kwad.components.ad.splashscreen.c.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f extends com.kwad.components.ad.splashscreen.c.e {
    public com.kwad.components.ad.splashscreen.f ER = new com.kwad.components.ad.splashscreen.f() { // from class: com.kwad.components.ad.splashscreen.c.a.f.1
        @Override // com.kwad.components.ad.splashscreen.f
        public final void kw() {
            f.this.a(new e(), true);
            f.this.a(new g(), true);
        }
    };

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Dg.a(this.ER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Dg.b(this.ER);
    }
}
