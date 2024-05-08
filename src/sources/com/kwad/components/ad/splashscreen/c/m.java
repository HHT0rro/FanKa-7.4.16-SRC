package com.kwad.components.ad.splashscreen.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class m extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.c {
    private boolean CW;
    private com.kwad.components.ad.splashscreen.d DB;
    private ViewGroup DE;
    private KsShakeView DF;
    private TextView DG;
    private com.kwad.sdk.core.g.d eg;
    private Vibrator eh;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i10) {
    }

    @Override // com.kwad.sdk.core.g.b
    public final void aV() {
        com.kwad.sdk.core.adlog.c.bN(this.Dg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.m.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                m.this.Dg.CI = SystemClock.elapsedRealtime() - m.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        if (viewStub != null) {
            this.DE = (ViewGroup) viewStub.inflate();
        } else {
            this.DE = (ViewGroup) findViewById(R.id.ksad_shake_root);
        }
        this.DG = (TextView) this.DE.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.DE.findViewById(R.id.ksad_shake_view);
        this.DF = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void j(int i10, String str) {
        TextView textView = this.DG;
        if (textView != null) {
            if (i10 == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kA() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lj() {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        this.DB = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, dQ, hVar.mApkDownloadHelper, 2);
        this.CW = com.kwad.sdk.core.response.b.d.dF(this.Dg.mAdTemplate);
        new com.kwad.sdk.widget.f(this.DF.getContext(), this.DF, this);
        this.Dg.a(this);
        TextView textView = this.DG;
        if (textView != null) {
            textView.setText(this.DB.ku());
        }
        KsShakeView ksShakeView = this.DF;
        if (ksShakeView != null) {
            ksShakeView.ac(this.DB.kv());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lk() {
        ViewGroup viewGroup = this.DE;
        if (viewGroup == null || this.Dg == null) {
            return;
        }
        viewGroup.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Dg.mAdTemplate, 185, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.d.a.sY().aW(185);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void ll() {
        float cT = com.kwad.sdk.core.response.b.b.cT(this.Dg.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(cT);
            this.eg = dVar2;
            dVar2.a(this);
            return;
        }
        dVar.e(cT);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lm() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bi(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void ln() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lo() {
        this.DF.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.m.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                m.this.DF.lV();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onClick: " + ((Object) view));
        if (!view.equals(this.DF) || (hVar = this.Dg) == null || (adTemplate = hVar.mAdTemplate) == null || !com.kwad.sdk.core.response.b.b.dF(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            return;
        }
        this.Dg.c(1, getContext(), 158, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", CardContext.ON_UNBIND_FUNC);
        com.kwad.components.ad.splashscreen.h hVar = this.Dg;
        if (hVar != null) {
            hVar.b(this);
        }
        KsShakeView ksShakeView = this.DF;
        if (ksShakeView != null) {
            ksShakeView.lW();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d10) {
        boolean nr = com.kwad.components.core.e.c.b.nr();
        if (!this.Dg.Cs.tz() || nr) {
            return;
        }
        this.DF.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.c.m.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m mVar = m.this;
                com.kwad.components.ad.splashscreen.h hVar = mVar.Dg;
                if (hVar != null) {
                    hVar.a(1, mVar.getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.c.m.3.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.l(d10);
                        }
                    });
                }
                m.this.DF.lV();
            }
        });
        bn.a(getContext(), this.eh);
        ln();
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.CW);
        if (this.CW && (hVar = this.Dg) != null) {
            hVar.c(1, view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onSingleTap: " + ((Object) view));
        if (com.kwad.sdk.core.response.b.b.dF(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate)) && (hVar = this.Dg) != null) {
            hVar.c(1, getContext(), 158, 1);
        }
    }
}
