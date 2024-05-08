package com.kwad.components.core.e.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class g extends KSFrameLayout {
    private final d JJ;
    private a JS;
    private final d JU;
    private final com.kwad.components.core.widget.a.b bQ;
    private final AdTemplate mAdTemplate;
    private Presenter mPresenter;
    private boolean nZ;

    public g(@NonNull Context context, AdTemplate adTemplate, d dVar) {
        super(context);
        this.JU = new d() { // from class: com.kwad.components.core.e.a.g.1
            @Override // com.kwad.components.core.e.a.d
            public final void ne() {
                g.this.dJ();
            }
        };
        this.mAdTemplate = adTemplate;
        this.JJ = dVar;
        this.bQ = new com.kwad.components.core.widget.a.b(this, 70);
        initMVP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ() {
        if (this.nZ) {
            return;
        }
        this.nZ = true;
        this.JJ.ne();
    }

    private void initMVP() {
        this.JS = nl();
        Presenter onCreatePresenter = onCreatePresenter();
        this.mPresenter = onCreatePresenter;
        onCreatePresenter.G(this);
        this.mPresenter.k(this.JS);
    }

    private a nl() {
        a aVar = new a();
        aVar.JH = this;
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.JI = this.bQ;
        aVar.JJ = this.JU;
        return aVar;
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        com.kwad.sdk.core.e.c.d("InstalledActivateView", "onViewAttached");
        this.bQ.tw();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.sdk.core.e.c.d("InstalledActivateView", "onViewDetached");
        this.bQ.release();
        this.mPresenter.destroy();
        this.JS.release();
        dJ();
    }
}
