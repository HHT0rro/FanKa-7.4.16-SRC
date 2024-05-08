package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.c.j;
import com.kwad.components.ad.splashscreen.c.o;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.core.l.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private KsSplashScreenAd.SplashScreenAdInteractionListener Ce;
    private com.kwad.components.ad.splashscreen.f.d Cf;
    private com.kwad.sdk.core.h.b bT;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private KsVideoPlayConfig mVideoPlayConfig;

    private c(Context context, AdResultData adResultData) {
        super(context);
        this.mAdResultData = adResultData;
        AdTemplate n10 = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n10;
        this.mAdScene = n10.mAdScene;
        oJ();
    }

    private static StyleTemplate S(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dr(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k10 != null) {
            styleTemplate.templateId = k10.templateId;
            styleTemplate.templateMd5 = k10.templateMd5;
            styleTemplate.templateUrl = k10.templateUrl;
            styleTemplate.templateVersionCode = (int) k10.templateVersionCode;
        }
        return styleTemplate;
    }

    private static Presenter T(AdTemplate adTemplate) {
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        Presenter presenter = new Presenter();
        a(presenter, dQ);
        if (h.U(adTemplate)) {
            presenter.a(new com.kwad.components.ad.splashscreen.c.b.a());
        } else {
            presenter.a(new j());
        }
        return presenter;
    }

    private int getSplashLayoutId() {
        return R.layout.ksad_splash_screen_layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.c
    /* renamed from: kq, reason: merged with bridge method [inline-methods] */
    public h kt() {
        com.kwad.components.ad.splashscreen.f.d dVar = new com.kwad.components.ad.splashscreen.f.d(this.lD, com.kwad.sdk.core.response.b.a.cA(this.mAdInfo));
        this.Cf = dVar;
        dVar.a(this.bT);
        this.Cf.tw();
        if (this.mVideoPlayConfig == null) {
            this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        }
        h hVar = new h();
        hVar.d(this.mAdResultData);
        hVar.setSplashScreenAdListener(this.Ce);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.Cs = this.Cf;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.Cr = S(this.mAdTemplate);
        hVar.mTimerHelper = new bm();
        if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.e.a aVar = new com.kwad.components.ad.splashscreen.e.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.Cq = aVar;
            hVar.Cs.a(aVar);
        }
        hVar.Cs.a(a(hVar));
        return hVar;
    }

    private void ks() {
        com.kwad.sdk.a.a.c.zM().zP();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        post(new ay() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                AdTemplate adTemplate = c.this.mAdTemplate;
                AdInfo unused = c.this.mAdInfo;
                if (h.U(adTemplate) || ((h) c.this.Mu).Cq == null) {
                    return;
                }
                ((h) c.this.Mu).Cq.lO();
            }
        });
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.setOnDismissListener(null);
            this.mApkDownloadHelper.setOnShowListener(null);
        }
        this.Cf.tx();
        ks();
    }

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mVideoPlayConfig = build;
        this.mAdTemplate.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.l.c
    public final boolean kp() {
        return true;
    }

    @Override // com.kwad.components.core.l.c
    public final void kr() {
        this.mRootContainer = (AdBaseFrameLayout) this.lD.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.lD.findViewById(R.id.ksad_splash_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (com.kwad.sdk.d.a.a.Au() || !c.n(c.this.mAdInfo) || c.this.Mu == null) {
                    return;
                }
                ((h) c.this.Mu).c(1, view.getContext(), 53, 2);
            }
        });
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return T(this.mAdTemplate);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean nt = dialogInterface instanceof com.kwad.components.core.e.c.b ? ((com.kwad.components.core.e.c.b) dialogInterface).nt() : false;
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
            if (splashScreenAdInteractionListener != null) {
                if (nt) {
                    splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
                } else {
                    splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
    }

    public final void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.bT = bVar;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Ce = splashScreenAdInteractionListener;
        T t2 = this.Mu;
        if (t2 != 0) {
            ((h) t2).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }

    public static c a(Context context, @NonNull AdResultData adResultData, boolean z10, com.kwad.sdk.core.h.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        c cVar;
        AdTemplate n10 = com.kwad.sdk.core.response.b.c.n(adResultData);
        c cVar2 = null;
        try {
            com.kwad.sdk.j.a.ak("splash", "show");
            n10.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.aa(n10);
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.a(n10, k.zd().zz(), z10);
            cVar = new c(l.wrapContextIfNeed(context), adResultData);
        } catch (Throwable th) {
            th = th;
        }
        try {
            cVar.setPageExitListener(bVar);
            cVar.setSplashScreenAdListener(splashScreenAdInteractionListener);
            com.kwad.sdk.j.a.al("splash", "show");
            return cVar;
        } catch (Throwable th2) {
            th = th2;
            cVar2 = cVar;
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.a(n10, th.toString(), z10);
            if (k.zd().yp()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                return cVar2;
            }
            throw th;
        }
    }

    private com.kwad.sdk.core.h.c a(final h hVar) {
        return new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                bm bmVar = hVar.mTimerHelper;
                if (bmVar != null) {
                    bmVar.No();
                }
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                bm bmVar = hVar.mTimerHelper;
                if (bmVar != null) {
                    bmVar.Np();
                }
            }
        };
    }

    private static void a(Presenter presenter, AdInfo adInfo) {
        presenter.a(new com.kwad.components.ad.splashscreen.c.k());
        presenter.a(new o());
        if (h.r(adInfo)) {
            presenter.a(new com.kwad.components.ad.splashscreen.c.a.f());
        }
    }
}
