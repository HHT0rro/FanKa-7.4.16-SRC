package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a extends LinearLayout {
    public TextProgressBar BH;
    public AppScoreView Br;
    public View Hh;
    public TextView Ir;
    public TextView dH;
    public ValueAnimator jo;
    public ImageView kT;
    public TextView kU;

    /* renamed from: ya, reason: collision with root package name */
    public View f36621ya;

    /* renamed from: yb, reason: collision with root package name */
    public Button f36622yb;

    /* renamed from: yc, reason: collision with root package name */
    public Button f36623yc;
    public KsAppTagsView yi;
    public com.kwad.components.ad.i.a yl;
    private Runnable ym;

    public a(Context context) {
        this(context, null);
    }

    private void initView() {
        this.Hh = l.inflate(getContext(), getLayoutId(), this);
        this.kT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.kU = (TextView) findViewById(R.id.ksad_app_name);
        this.Br = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dH = (TextView) findViewById(R.id.ksad_app_download_count);
        this.Ir = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.BH = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.d.a.a.a(getContext(), 16.0f));
        this.BH.setTextColor(-1);
        this.yi = (KsAppTagsView) findViewById(R.id.ksad_reward_apk_info_tags);
        this.f36622yb = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.f36623yc = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.f36621ya = findViewById(R.id.ksad_reward_apk_info_install_container);
        this.yl = new com.kwad.components.ad.i.a(this.Hh);
    }

    private void mq() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.jo = ofFloat;
            ofFloat.setDuration(1200L);
            this.jo.setRepeatCount(-1);
            this.jo.setRepeatMode(1);
            this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.BH.setScaleY(floatValue);
                    a.this.BH.setScaleX(floatValue);
                }
            });
            this.jo.start();
        }
    }

    public final void D(@NonNull AdInfo adInfo) {
        int i10 = adInfo.status;
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            mq();
        } else {
            km();
        }
    }

    public void b(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        if (e.F(adTemplate)) {
            KSImageLoader.loadAppIcon(this.kT, com.kwad.sdk.core.response.b.a.cI(dQ), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.kT, com.kwad.sdk.core.response.b.a.cf(dQ), adTemplate, 12);
        }
        this.kU.setText(com.kwad.sdk.core.response.b.a.cc(dQ));
        if (!e.F(adTemplate)) {
            float aA = com.kwad.sdk.core.response.b.a.aA(dQ);
            if (aA >= 3.0f) {
                this.Br.setScore(aA);
                this.Br.setVisibility(0);
            } else {
                this.Br.setVisibility(8);
            }
            String az = com.kwad.sdk.core.response.b.a.az(dQ);
            if (!TextUtils.isEmpty(az)) {
                this.dH.setText(az);
                this.dH.setVisibility(0);
            } else {
                this.dH.setVisibility(8);
            }
        }
        this.Ir.setText(com.kwad.sdk.core.response.b.a.au(dQ));
        if (e.F(adTemplate)) {
            this.BH.setVisibility(8);
            this.f36621ya.setVisibility(0);
            this.f36623yc.setText("查看详情");
            Button button = this.f36622yb;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d.Cg());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb2.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.ym == null) {
                    this.ym = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.yl.hT();
                        }
                    };
                }
                this.f36621ya.postDelayed(this.ym, 1600L);
            }
        } else {
            this.BH.setVisibility(0);
            this.f36621ya.setVisibility(8);
            Runnable runnable = this.ym;
            if (runnable != null) {
                this.f36621ya.removeCallbacks(runnable);
                this.ym = null;
            }
            D(e.dQ(adTemplate));
        }
        if (e.F(adTemplate)) {
            List<String> dH = com.kwad.sdk.core.response.b.d.dH(adTemplate);
            if (dH.size() > 0) {
                this.yi.setVisibility(0);
            } else {
                this.yi.setVisibility(8);
            }
            this.yi.setAppTags(dH);
        }
    }

    public View getBtnInstallContainer() {
        return this.f36621ya;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.BH;
    }

    public final void km() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.jo.cancel();
            this.jo.end();
        }
        Runnable runnable = this.ym;
        if (runnable != null) {
            this.f36621ya.removeCallbacks(runnable);
            this.ym = null;
        }
        this.yl.mb();
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(l.wrapContextIfNeed(context), attributeSet, i10);
        initView();
    }
}
