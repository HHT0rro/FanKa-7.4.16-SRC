package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ai;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements j {
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.e.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            e.this.is();
        }
    };
    private View vv;
    private View vw;
    private ImageView vx;

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.d.a());
    }

    private void ir() {
        if (!this.qo.f36543pa) {
            this.vw.setVisibility(8);
        }
        this.vv.setVisibility(0);
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qo.mAdTemplate) && ai.LZ()) {
            this.vx.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vv.setVisibility(0);
        this.vw.setVisibility(8);
        this.qo.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eX().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        ir();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        is();
    }

    public final void is() {
        if (this.qo.f36543pa) {
            this.vv.setVisibility(8);
        } else {
            this.vv.setVisibility(8);
            this.vw.setVisibility(0);
        }
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qo.mAdTemplate) && ai.LZ()) {
            this.vx.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vv = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.vw = findViewById(R.id.ksad_play_end_top_toolbar);
        this.vx = (ImageView) findViewById(R.id.ksad_blur_end_cover);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ir();
        this.qo.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eX().b(this);
        this.vw.setVisibility(8);
    }
}
