package com.kwad.components.ad.splashscreen.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.quickcard.CardContext;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bm;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends e implements com.kwad.sdk.core.h.c {
    private TextView CY;
    private com.kwad.components.ad.splashscreen.widget.a CZ;
    private AdInfo.AdPreloadInfo Da;
    private boolean Db = false;
    private View Dc;

    /* renamed from: sd, reason: collision with root package name */
    private AdInfo f36618sd;

    private SplashSkipViewModel kW() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        AdInfo adInfo = this.f36618sd;
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        int i10 = adSplashInfo.imageDisplaySecond;
        if (i10 <= 0) {
            i10 = 5;
        }
        int min = Math.min(adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.b.a.L(adInfo));
        if (com.kwad.sdk.core.response.b.a.bc(this.f36618sd)) {
            i10 = min;
        }
        splashSkipViewModel.skipSecond = i10;
        return splashSkipViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX() {
        com.kwad.components.ad.splashscreen.monitor.a.kT().l(this.Dg.mAdTemplate);
        this.Dg.kO();
        JSONObject jSONObject = new JSONObject();
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            try {
                jSONObject.put("duration", aVar.getCurrentPosition());
            } catch (JSONException e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
        }
        a.C0516a c0516a = new a.C0516a();
        bm bmVar = this.Dg.mTimerHelper;
        if (bmVar != null) {
            c0516a.duration = bmVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b(this.Dg.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(1).cT(22).b(c0516a), jSONObject);
    }

    private synchronized void kZ() {
        if (!this.Db && this.CZ != null) {
            if (com.kwad.sdk.core.response.b.a.cx(this.f36618sd) && com.kwad.sdk.core.response.b.a.cy(this.f36618sd)) {
                com.kwad.sdk.core.adlog.c.b(this.Dg.mAdTemplate, 124, (JSONObject) null);
                this.Db = true;
            }
        }
    }

    private void t(AdInfo adInfo) {
        findViewById(com.kwad.components.ad.splashscreen.f.c.z(adInfo) ? R.id.ksad_splash_right_top_root : R.id.ksad_splash_left_top_root).setVisibility(0);
    }

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cv(adInfo);
    }

    private void v(AdInfo adInfo) {
        this.CY = (TextView) findViewById(com.kwad.components.ad.splashscreen.f.c.z(adInfo) ? R.id.ksad_splash_preload_right_tips : R.id.ksad_splash_preload_left_tips);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.Da = adPreloadInfo;
        if (adPreloadInfo != null && !bg.isNullString(adPreloadInfo.preloadTips)) {
            this.CY.setVisibility(0);
            this.CY.setText(this.Da.preloadTips);
        } else {
            this.CY.setVisibility(8);
        }
    }

    private void w(AdInfo adInfo) {
        this.Dc = findViewById(R.id.ksad_skip_view_area);
        if (com.kwad.sdk.core.response.b.a.cw(adInfo) && adInfo.adSplashInfo.skipButtonPosition == 0) {
            this.Dc.setVisibility(0);
            this.Dc.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.kX();
                }
            });
            this.Dc.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.c.3
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    ((View) c.this.CZ).post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.c.3.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            int aa2 = c.this.CZ.aa(35);
                            ViewGroup.LayoutParams layoutParams = c.this.Dc.getLayoutParams();
                            layoutParams.width = aa2 + com.kwad.sdk.d.a.a.a(c.this.Dg.mRootContainer.getContext(), 66.0f);
                            c.this.Dc.setLayoutParams(layoutParams);
                        }
                    });
                }
            });
            return;
        }
        this.Dc.setVisibility(8);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", "onPageVisible");
        this.CZ.B(this.f36618sd);
        kZ();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", "onPageInvisible");
        this.CZ.A(this.f36618sd);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("SkipAdPresenter", CardContext.ON_BIND_FUNC);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        this.f36618sd = dQ;
        t(dQ);
        v(this.f36618sd);
        if (u(this.f36618sd)) {
            this.CZ = (com.kwad.components.ad.splashscreen.widget.a) findViewById(com.kwad.components.ad.splashscreen.f.c.z(this.f36618sd) ? R.id.ksad_splash_skip_right_view : R.id.ksad_splash_skip_left_view);
        } else {
            this.CZ = (com.kwad.components.ad.splashscreen.widget.a) findViewById(com.kwad.components.ad.splashscreen.f.c.z(this.f36618sd) ? R.id.ksad_splash_circle_skip_right_view : R.id.ksad_splash_circle_skip_left_view);
        }
        this.CZ.a(kW(), this.f36618sd);
        this.CZ.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.c.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void Y(int i10) {
                c.this.Dg.X(i10);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void la() {
                c.this.kX();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void lb() {
                c.this.kY();
            }
        });
        w(this.f36618sd);
        this.Dg.Cs.a(this);
    }

    public final void kY() {
        this.Dg.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.c.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.nr()) {
                    c.this.Dg.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.Dg.kM();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Dg.Cs.b(this);
        this.CZ.bf();
    }
}
