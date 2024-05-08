package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bg;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class n extends d implements View.OnClickListener {
    private ViewGroup gS;
    private TextView yA;
    private LinearLayout zA;
    private KsPriceView zB;
    private TextView zC;
    private View zD;
    private KSCornerImageView zE;
    private b zF;
    private a zG;
    private ViewGroup zt;
    private KSCornerImageView zz;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void ht();
    }

    public n(ViewGroup viewGroup, b bVar) {
        this.gS = viewGroup;
        this.zF = bVar;
        initView();
    }

    public static /* synthetic */ View a(n nVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void initView() {
        this.zt = (ViewGroup) this.gS.findViewById(R.id.ksad_reward_order_root);
        this.zz = (KSCornerImageView) this.gS.findViewById(R.id.ksad_reward_order_icon);
        this.yA = (TextView) this.gS.findViewById(R.id.ksad_reward_order_title);
        this.zA = (LinearLayout) this.gS.findViewById(R.id.ksad_reward_order_coupon_list);
        this.zB = (KsPriceView) this.gS.findViewById(R.id.ksad_reward_order_price);
        this.zC = (TextView) this.gS.findViewById(R.id.ksad_reward_order_btn_buy);
        this.zD = this.gS.findViewById(R.id.ksad_reward_order_text_area);
        this.zE = (KSCornerImageView) this.gS.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.zC.setText(com.kwad.components.ad.d.b.Y());
        this.zC.setOnClickListener(this);
        this.zz.setOnClickListener(this);
        this.zD.setOnClickListener(this);
        Context context = this.gS.getContext();
        if (ai.LZ()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.gS.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.gS.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gF() {
        return this.zt;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.zF == null) {
            return;
        }
        if (view.equals(this.zC)) {
            this.zF.gJ();
        } else if (view.equals(this.zz)) {
            this.zF.ih();
        } else if (view.equals(this.zD)) {
            this.zF.ii();
        }
    }

    public final void a(a aVar) {
        this.zG = aVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.sdk.core.response.b.a.cP(com.kwad.sdk.core.response.b.e.dQ(rVar.getAdTemplate())), rVar.getAdTemplate());
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.zz, adProductInfo.getIcon(), adTemplate);
        this.yA.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.zA.setVisibility(8);
            this.zG.ht();
        } else {
            this.zA.setVisibility(0);
            this.zA.post(new ay() { // from class: com.kwad.components.ad.reward.n.n.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        n nVar = n.this;
                        View a10 = n.a(nVar, nVar.zA.getContext(), couponInfo, n.this.zA);
                        ViewGroup.LayoutParams layoutParams = a10.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        n.this.zA.addView(a10, layoutParams);
                        com.kwad.components.core.s.i.a(new com.kwad.components.core.widget.e(), n.this.zA);
                    }
                    if (n.this.zG != null) {
                        if (n.this.zA.getChildCount() > 0) {
                            n.this.zA.getChildAt(0).post(new ay() { // from class: com.kwad.components.ad.reward.n.n.1.1
                                @Override // com.kwad.sdk.utils.ay
                                public final void doTask() {
                                    n.this.zG.ht();
                                }
                            });
                        } else {
                            n.this.zG.ht();
                        }
                    }
                }
            });
        }
        this.zB.h(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String Z = com.kwad.components.ad.d.b.Z();
        if (bg.isNullString(Z)) {
            return;
        }
        KSImageLoader.loadImage(this.zE, Z, adTemplate);
    }

    private static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.n.l.a(context, R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }
}
