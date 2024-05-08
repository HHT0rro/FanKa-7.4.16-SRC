package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KsAuthorIconView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class o extends s implements View.OnClickListener {
    private TextView lw;
    private com.kwad.components.ad.reward.g qo;
    private KsLogoView zK;
    private KsLogoView zL;
    private KsAuthorIconView zM;
    private RelativeLayout zN;
    private String zP;
    private TextView zk;
    private TextView zl;
    private boolean zO = false;
    private Runnable zQ = new Runnable() { // from class: com.kwad.components.ad.reward.n.o.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.d.a.a.a(o.this.lw, o.this.zP, KsLogoView.a(o.this.zK));
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                o.this.lw.setText(o.this.zP);
                o.this.lw.setVisibility(0);
            }
        }
    };

    public o(com.kwad.components.ad.reward.g gVar) {
        this.qo = gVar;
    }

    private static void h(View view, int i10) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.d.a.a.a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.sz;
        if (viewGroup == null) {
            return;
        }
        this.zM = (KsAuthorIconView) viewGroup.findViewById(R.id.ksad_live_author_icon);
        this.zk = (TextView) this.sz.findViewById(R.id.kwad_actionbar_title);
        this.lw = (TextView) this.sz.findViewById(R.id.kwad_actionbar_des_text);
        this.zl = (TextView) this.sz.findViewById(R.id.ksad_live_actionbar_btn);
        this.zL = (KsLogoView) this.sz.findViewById(R.id.ksad_reward_live_kwai_logo);
        if (!this.zO) {
            this.zN = (RelativeLayout) this.sz.findViewById(R.id.ksad_reward_origin_live_relative);
        }
        this.sz.setOnClickListener(this);
        this.zl.setOnClickListener(this);
        this.zM.setOnClickListener(this);
        this.lw.setOnClickListener(this);
        this.zk.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ab(boolean z10) {
        super.ab(z10);
        Context context = this.sz.getContext();
        if (ai.LZ()) {
            return;
        }
        if (!this.zO) {
            this.sz.findViewById(R.id.ksad_reward_origin_live_base1).setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.zN.getLayoutParams();
            Resources resources = context.getResources();
            int i10 = R.dimen.ksad_live_subscribe_card_width_horizontal;
            layoutParams.width = resources.getDimensionPixelSize(i10);
            this.zN.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.zl.getLayoutParams();
            layoutParams2.width = context.getResources().getDimensionPixelSize(i10);
            this.zl.setLayoutParams(layoutParams2);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.sz.getLayoutParams();
        layoutParams3.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.sz.setLayoutParams(layoutParams3);
        h(this.sz, 85);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.zl)) {
            this.qo.a(1, view.getContext(), 29, 1);
            return;
        }
        if (view.equals(this.zM)) {
            this.qo.a(1, view.getContext(), 30, 1);
            return;
        }
        if (view.equals(this.lw)) {
            this.qo.a(1, view.getContext(), 32, 1);
        } else if (view.equals(this.zk)) {
            this.qo.a(1, view.getContext(), 31, 1);
        } else if (view.equals(this.sz)) {
            this.qo.a(1, view.getContext(), 53, 2);
        }
    }

    private void b(AdTemplate adTemplate) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.zk.setText(com.kwad.sdk.core.response.b.a.cc(dQ));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.zM.setVisibility(0);
        this.zM.b(adTemplate);
        this.zM.a(eVar);
        this.zl.setText(com.kwad.sdk.core.response.b.a.aE(dQ));
        if (com.kwad.sdk.core.response.b.a.bf(dQ) == 8) {
            this.zL.setVisibility(0);
            this.zL.aD(adTemplate);
            this.lw.setText(com.kwad.sdk.core.response.b.a.au(dQ));
        } else {
            this.zP = com.kwad.sdk.core.response.b.a.au(dQ);
            KsLogoView ksLogoView = new KsLogoView(this.sz.getContext(), false);
            this.zK = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.n.o.1
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void kc() {
                    o.this.lw.post(o.this.zQ);
                }
            });
            this.zK.aD(adTemplate);
            this.zL.setVisibility(8);
        }
    }

    public final void a(ViewGroup viewGroup, int i10) {
        if (i10 == 8) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_shop_stub, R.id.ksad_reward_origin_live_root);
            this.zO = true;
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_base_stub, R.id.ksad_reward_origin_live_root);
            this.zO = false;
        }
        initView();
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        b(rVar.getAdTemplate());
    }
}
