package com.kwad.components.ad.fullscreen.c;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.fullscreen.c.a.e;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements j {

    /* renamed from: hc, reason: collision with root package name */
    private View f36486hc;

    /* renamed from: hd, reason: collision with root package name */
    private View f36487hd;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            c.this.i(false);
        }
    };

    public c() {
        a(new e());
        a(new com.kwad.components.ad.fullscreen.c.b.a());
    }

    private void bX() {
        com.kwad.components.ad.reward.g gVar = this.qo;
        if (gVar.f36543pa || gVar.oZ) {
            return;
        }
        this.f36486hc.setVisibility(0);
        this.f36487hd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z10) {
        com.kwad.components.ad.reward.g gVar = this.qo;
        if ((gVar.f36543pa || gVar.oZ) && !z10) {
            this.f36486hc.setVisibility(8);
            this.f36487hd.setVisibility(8);
        } else {
            this.f36486hc.setVisibility(8);
            this.f36487hd.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qo.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eX().a(this);
        this.f36486hc.setVisibility(0);
        this.f36487hd.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        bX();
        if (this.qo.oZ && this.f36487hd.getVisibility() == 0) {
            this.f36487hd.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        i(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36486hc = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.f36487hd = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eX().b(this);
    }
}
