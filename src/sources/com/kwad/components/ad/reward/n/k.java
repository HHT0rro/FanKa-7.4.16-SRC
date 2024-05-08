package com.kwad.components.ad.reward.n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k extends d implements com.kwad.sdk.widget.c {
    private TextView hz;
    private KSCornerImageView lv;
    private TextView lw;
    private com.kwad.components.ad.reward.g qo;
    private KsPriceView yH;
    private TextView yK;
    private TextView yL;
    private View yM;
    private ViewStub zf;
    private ViewGroup zg;
    private KsStyledTextButton zh;
    private KsStyledTextButton zi;

    public k(com.kwad.components.ad.reward.g gVar, ViewStub viewStub) {
        this.zf = viewStub;
        this.qo = gVar;
    }

    private void d(View view, boolean z10) {
        if (view.equals(this.zi)) {
            this.qo.a(2, view.getContext(), z10 ? 38 : 153, 1);
        } else if (view.equals(this.zh)) {
            this.qo.a(2, view.getContext(), z10 ? 37 : 153, 1);
        } else if (view.equals(this.zg)) {
            this.qo.a(2, view.getContext(), z10 ? 2 : 153, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(rVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.I(rVar.getAdTemplate()));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.qo.mAdTemplate)) {
            d(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gF() {
        return this.zg;
    }

    public final void hide() {
        ViewGroup viewGroup = this.zg;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public k(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup) {
        this.zg = viewGroup;
        this.qo = gVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        KSImageLoader.loadAppIcon(this.lv, aVar.gf(), adTemplate, 8);
        this.hz.setText(aVar.getTitle());
        this.lw.setText(aVar.gg());
        int dimensionPixelSize = this.zg.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.yH.getConfig().ae(dimensionPixelSize).ag(dimensionPixelSize).af(this.zg.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.yH.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String gW = aVar.gW();
        this.yM.setVisibility(TextUtils.isEmpty(gW) ? 8 : 0);
        if (gW != null) {
            this.yK.setText(gW);
        }
        this.yL.setText(aVar.gX());
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        d(view, true);
    }
}
