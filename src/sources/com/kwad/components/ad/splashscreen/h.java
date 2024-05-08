package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.e.d.a;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bm;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class h extends com.kwad.sdk.mvp.a {
    public int CB;
    public int CC;
    public long CD;
    public long CE;
    public long CF;
    public long CG;
    public long CH;
    public long CI;
    public long CJ;
    private KsSplashScreenAd.SplashScreenAdInteractionListener Ce;

    @Nullable
    public com.kwad.components.ad.splashscreen.e.a Cq;
    public StyleTemplate Cr;
    public com.kwad.sdk.core.h.a Cs;
    public AdResultData mAdResultData;

    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public bm mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    private List<g> Ct = new CopyOnWriteArrayList();
    private List<f> Cu = new CopyOnWriteArrayList();
    public boolean Cv = false;
    private boolean Cw = false;
    public boolean Cx = false;
    public boolean Cy = false;
    public boolean Cz = false;
    public long CA = SystemClock.elapsedRealtime();
    public boolean isWebTimeout = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar);
    }

    public static boolean U(AdTemplate adTemplate) {
        AdMatrixInfo.SplashPlayCardTKInfo dd2;
        return com.kwad.sdk.core.config.d.BV() && (dd2 = com.kwad.sdk.core.response.b.b.dd(adTemplate)) != null && !TextUtils.isEmpty(dd2.templateId) && dd2.renderType == 1;
    }

    private void kP() {
        kQ();
        Iterator<g> iterator2 = this.Ct.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().kA();
        }
    }

    private void kQ() {
        long dl;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        SplashMonitorInfo elementTypes = new SplashMonitorInfo().setStatus(8).setElementTypes(com.kwad.components.core.webview.tachikoma.d.a.sY().sZ());
        bm bmVar = this.mTimerHelper;
        SplashMonitorInfo rotateComposeTimeout = elementTypes.setShowEndTime(bmVar != null ? bmVar.getTime() : -1L).setRotateComposeTimeout(this.Cz);
        if (U(this.mAdTemplate)) {
            dl = com.kwad.sdk.core.response.b.b.de(this.mAdTemplate);
        } else {
            dl = com.kwad.sdk.core.response.b.b.dl(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
        }
        com.kwad.sdk.commercial.b.k(rotateComposeTimeout.setTkDefaultTimeout(dl).setSoSource(this.CB).setSoLoadTime(this.CD).setOfflineSource(this.CC).setOfflineLoadTime(this.CE).setTkFileLoadTime(this.CF).setTkInitTime(this.CG).setTkRenderTime(this.CH).setNativeLoadTime(this.CI).setWebTimeout(this.isWebTimeout).setWebLoadTime(this.CJ).setInteractiveStyle(com.kwad.sdk.core.response.b.b.dv(dQ)).setInteractivityDefaultStyle(com.kwad.sdk.core.response.b.b.dw(dQ)).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setAdTemplate(this.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.d.a.sY().ta();
    }

    private void kR() {
        Iterator<f> iterator2 = this.Cu.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().kw();
        }
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    public static boolean r(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.de(adInfo) && com.kwad.sdk.core.response.b.a.bd(adInfo);
    }

    public final void Q(Context context) {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        com.kwad.components.ad.splashscreen.local.a.R(context);
        com.kwad.components.core.s.b.qY().a(this.mAdTemplate, null, null);
        com.kwad.sdk.commercial.d.c.bz(this.mAdTemplate);
        kC();
    }

    public final void X(int i10) {
        Iterator<g> iterator2 = this.Ct.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().W(i10);
        }
    }

    public final void a(int i10, Context context, final int i11, int i12, final a aVar) {
        com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        com.kwad.components.core.e.d.a.a(new a.C0461a(context).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(i12).ao(i12 == 1).am(i11).al(i10).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.components.ad.splashscreen.monitor.a.kT().Y(h.this.mAdTemplate);
                if (h.this.Ce != null) {
                    h.this.Ce.onAdClicked();
                }
                com.kwad.components.ad.splashscreen.monitor.a.kT().W(h.this.mAdTemplate);
                JSONObject jSONObject = new JSONObject();
                try {
                    com.kwad.components.ad.splashscreen.e.a aVar2 = h.this.Cq;
                    if (aVar2 != null) {
                        jSONObject.put("duration", aVar2.getCurrentPosition());
                    }
                } catch (JSONException e2) {
                    com.kwad.sdk.core.e.c.printStackTrace(e2);
                }
                com.kwad.sdk.core.adlog.c.b f10 = new com.kwad.sdk.core.adlog.c.b().cK(i11).f(h.this.mRootContainer.getTouchCoords());
                com.kwad.sdk.core.adlog.c.a(h.this.mAdTemplate, f10, jSONObject);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b(f10);
                }
            }
        }));
    }

    public final void c(int i10, Context context, int i11, int i12) {
        a(i10, context, i11, i12, null);
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    @MainThread
    public final void i(int i10, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(i10, str);
        }
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, i10, String.valueOf(str));
        kP();
    }

    @MainThread
    public final void kB() {
        this.mAdTemplate.converted = true;
        com.kwad.components.ad.splashscreen.monitor.a.kT().Y(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        com.kwad.components.ad.splashscreen.monitor.a.kT().W(this.mAdTemplate);
    }

    @MainThread
    public final void kC() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        if (this.Cw) {
            return;
        }
        this.Cw = true;
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.f(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.c.af(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.a.kT().m(this.mAdTemplate);
        com.kwad.sdk.a.a.c.zM().bj(true);
        bm bmVar = this.mTimerHelper;
        if (bmVar != null) {
            bmVar.startTiming();
        }
    }

    @MainThread
    public final void kD() {
        com.kwad.components.ad.splashscreen.monitor.a.kT().l(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.kT().n(this.mAdTemplate);
    }

    public final void kE() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, "onMediaPlayError");
        }
    }

    public final void kF() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    public final void kG() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    public final void kH() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
    }

    public final void kI() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    public final void kJ() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogShow();
        }
    }

    public final void kK() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
        }
    }

    public final void kL() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
        }
    }

    @MainThread
    public final void kM() {
        if (this.Cv) {
            return;
        }
        this.Cv = true;
        if (r(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate)) && !this.mAdTemplate.converted) {
            kR();
        } else {
            a.C0516a c0516a = new a.C0516a();
            bm bmVar = this.mTimerHelper;
            if (bmVar != null) {
                c0516a.duration = bmVar.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(14).cT(22).b(c0516a), (JSONObject) null);
            com.kwad.components.ad.splashscreen.monitor.a.kT().l(this.mAdTemplate);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            com.kwad.components.ad.splashscreen.monitor.a.kT().n(this.mAdTemplate);
        }
        kP();
    }

    @MainThread
    public final void kN() {
        com.kwad.components.ad.splashscreen.monitor.a.kT().l(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.kT().n(this.mAdTemplate);
    }

    @MainThread
    public final void kO() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Ce;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.kT().n(this.mAdTemplate);
        kP();
    }

    public final void kS() {
        this.mRootContainer.post(new ay() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.nr()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.kN();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Cq;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.h.a aVar2 = this.Cs;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Ce = splashScreenAdInteractionListener;
    }

    public final void b(g gVar) {
        this.Ct.remove(gVar);
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Cu.remove(fVar);
    }

    public final void a(g gVar) {
        this.Ct.add(gVar);
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Cu.add(fVar);
    }
}
