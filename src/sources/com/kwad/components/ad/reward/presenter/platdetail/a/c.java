package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private AdInfo mAdInfo;
    private ImageView vl;
    private TextView vm;
    private boolean vn = false;
    private View vo = null;
    private long vp = -1;
    private final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (c.this.vp >= 0) {
                if (j11 > Math.min(Math.min(c.this.vp, com.kwad.sdk.core.response.b.a.ag(c.this.mAdInfo)), j10)) {
                    c.this.in();
                }
            }
        }
    };
    private final com.kwad.components.ad.reward.e.e hw = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.2
        @Override // com.kwad.components.ad.reward.e.e
        public final void ce() {
            c.a(c.this, true);
            c.this.in();
        }
    };

    private void ca() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        this.qo.oJ.a(this.gO);
        this.qo.oU.add(this.hw);
        long af = com.kwad.sdk.core.response.b.a.af(this.mAdInfo);
        this.vp = af;
        if (af == 0) {
            this.vo.setVisibility(0);
        } else {
            this.vo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in() {
        if (this.vo.getVisibility() == 0) {
            return;
        }
        this.vo.setAlpha(0.0f);
        this.vo.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.vo.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vo) {
            f.a(this.qo, this.vn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vl = (ImageView) findViewById(R.id.ksad_detail_close_btn);
        this.vm = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.reward.a.b.gq())) {
            this.vm.setText(com.kwad.components.ad.reward.a.b.gq());
            this.vo = this.vm;
        } else {
            if (com.kwad.components.ad.reward.a.b.gp() == 0) {
                this.vl.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.vl.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.vo = this.vl;
        }
        this.vo.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.gO);
        this.qo.oU.remove(this.hw);
        this.vo.setVisibility(8);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.vn = true;
        return true;
    }
}
