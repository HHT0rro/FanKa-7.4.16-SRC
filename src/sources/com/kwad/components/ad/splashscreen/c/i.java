package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class i extends e implements com.kwad.sdk.core.h.c {

    /* renamed from: le, reason: collision with root package name */
    private static long f36620le = 400;
    private com.kwad.components.ad.splashscreen.f.a Dt;
    private Vibrator eh;

    private void lp() {
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.f.a aVar = this.Dt;
            if (aVar == null) {
                this.Dt = new com.kwad.components.ad.splashscreen.f.a(getContext(), this.Dg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.i.1
                    {
                        super(r3);
                    }

                    @Override // com.kwad.components.ad.splashscreen.f.a
                    public final void k(int i10, String str) {
                        i.this.j(i10, str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.Dg.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Dt);
            }
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        if (this.Dg.Cv) {
            return;
        }
        lm();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        ln();
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar == null) {
            return;
        }
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(hVar.mAdTemplate);
        ll();
        lj();
        if (com.kwad.sdk.core.response.b.a.aF(dQ)) {
            lp();
        }
        lk();
        lo();
        this.Dg.Cs.a(this);
    }

    public abstract void initView();

    public abstract void j(int i10, String str);

    public abstract void lj();

    public abstract void lk();

    public abstract void ll();

    public abstract void lm();

    public abstract void ln();

    public abstract void lo();

    public final void lq() {
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        bn.a(getContext(), this.eh);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Dg.Cs.b(this);
        ln();
        bn.b(getContext(), this.eh);
    }
}
