package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e {
    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!k.zd().ys()) {
            com.kwad.sdk.core.e.c.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.e.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    KsLoadManager.InterstitialAdListener.this.onError(com.kwad.sdk.core.network.e.avy.errorCode, com.kwad.sdk.core.network.e.avy.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        boolean a10 = m.re().a(covert, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        covert.setAdStyle(13);
        com.kwad.components.ad.interstitial.report.c.dQ().i(covert.getPosId());
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0478a().e(new ImpInfo(covert)).aJ(a10).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.interstitial.e.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg);
                    i.ap("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.e.2.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                        com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                        adTemplateList.get(0);
                        com.kwad.sdk.core.response.b.e.dQ(adTemplateList.get(0));
                    }
                } catch (Exception unused) {
                }
                com.kwad.components.ad.interstitial.report.c.dQ().a(adTemplateList.get(0), z10);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, adTemplateList.size());
                SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = SceneImpl.this;
                        }
                        String K = com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
                        if (!com.kwad.sdk.core.response.b.b.cS(adTemplate)) {
                            com.kwad.components.ad.interstitial.report.realtime.a.dU();
                            com.kwad.components.ad.interstitial.report.realtime.a.w(adTemplate);
                        }
                        AdResultData a11 = com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate);
                        if (!TextUtils.isEmpty(K)) {
                            boolean j10 = com.kwad.components.ad.interstitial.a.a.j(adTemplate);
                            if (com.kwad.sdk.core.config.d.BA() || j10) {
                                arrayList.add(new b(SceneImpl.this, a11));
                            }
                        } else {
                            arrayList.add(new b(SceneImpl.this, a11));
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    onError(com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg);
                    com.kwad.components.ad.interstitial.report.realtime.a.dU();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(com.kwad.sdk.core.network.e.avy);
                    i.ap("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.interstitial.report.c.dQ().b(adTemplateList.get(0), z10);
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.e.2.3
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        i.ap("insertAd_", "onInterstitialAdCacheSuccess");
                        interstitialAdListener.onInterstitialAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i10, final String str) {
                com.kwad.components.ad.interstitial.report.c.dQ().a(i10, str, SceneImpl.this.getPosId());
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.e.2.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        interstitialAdListener.onError(i10, str);
                    }
                });
            }
        }).qy());
    }
}
