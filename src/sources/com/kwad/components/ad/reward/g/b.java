package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    public static void a(KsScene ksScene, @NonNull final c cVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        d.b(covert);
        com.kwad.components.ad.reward.monitor.c.a(true, covert.getPosId());
        boolean a10 = m.re().a(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0478a().e(new ImpInfo(covert)).aJ(a10).a(new i() { // from class: com.kwad.components.ad.reward.g.b.2
            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void bK() {
                com.kwad.components.ad.reward.monitor.c.b(true, SceneImpl.this.posId);
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.reward.g.b.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                List list;
                ArrayList arrayList;
                com.kwad.components.ad.reward.monitor.c.c(true, SceneImpl.this.posId);
                List a11 = b.a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (a11.isEmpty()) {
                    onError(e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.avy.msg : adResultData.testErrorMsg);
                    com.kwad.sdk.utils.i.ap("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.yU());
                final ArrayList<KsRewardVideoAd> arrayList2 = new ArrayList();
                final AdTemplate adTemplate = (AdTemplate) a11.get(0);
                arrayList2.add(new KsRewardVideoAdControl(adResultData));
                com.kwad.components.ad.reward.monitor.d.a(adTemplate, z10, obtainVideoPreCacheConfig);
                com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) a11.get(0), a11.size(), elapsedRealtime);
                d.a(SceneImpl.this, a11.size());
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        try {
                            KsAdLoadManager.M().b(arrayList2);
                            cVar.c(adTemplate, arrayList2);
                        } catch (Throwable unused) {
                        }
                        try {
                            s.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList2.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                        com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                        a11.get(0);
                        com.kwad.sdk.core.response.b.e.dQ((AdTemplate) a11.get(0));
                    }
                } catch (Exception unused) {
                }
                ArrayList arrayList3 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(true, adTemplate);
                final boolean CF = com.kwad.sdk.core.config.d.CF();
                boolean z11 = false;
                for (final KsRewardVideoAd ksRewardVideoAd : arrayList2) {
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                    AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate2);
                    if (adTemplate2.isNativeRewardPreview || com.kwad.sdk.core.response.b.a.cL(dQ)) {
                        list = a11;
                        arrayList = arrayList3;
                    } else if (com.kwad.sdk.core.response.b.a.bd(dQ)) {
                        arrayList = arrayList3;
                        list = a11;
                    } else {
                        final ArrayList arrayList4 = arrayList3;
                        com.kwad.components.ad.c.b.a(adTemplate2, true, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                            @Override // com.kwad.components.ad.c.a
                            public final void V() {
                                com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList4.add(ksRewardVideoAd);
                                b.a(adTemplate, cVar, arrayList4);
                            }

                            @Override // com.kwad.components.ad.c.a
                            public final void W() {
                                if (CF) {
                                    b.a(adTemplate, cVar, arrayList2);
                                }
                            }
                        });
                        a11 = a11;
                        arrayList3 = arrayList3;
                    }
                    arrayList.add(ksRewardVideoAd);
                    b.a(adTemplate, cVar, arrayList);
                    arrayList3 = arrayList;
                    a11 = list;
                    z11 = true;
                }
                ArrayList arrayList5 = arrayList3;
                List list2 = a11;
                com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (!CF && !z11 && arrayList5.isEmpty()) {
                    e eVar = e.avz;
                    onError(eVar.errorCode, eVar.msg);
                    com.kwad.sdk.utils.i.ap("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.b(true, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i10, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(true, i10, str, SceneImpl.this.getPosId());
                if (i10 != e.avy.errorCode && i10 != e.avt.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(true, i10);
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        cVar.onError(i10, str);
                    }
                });
            }
        }).qy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final c cVar, final List<KsRewardVideoAd> list) {
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.g.b.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.utils.i.ap("rewardAd_", "onRewardVideoAdCacheSuccess");
                c.this.d(adTemplate, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
                int be2 = com.kwad.sdk.core.response.b.a.be(dQ);
                if (adTemplate.isNativeRewardPreview) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.cL(dQ)) {
                    arrayList.add(adTemplate);
                } else if (1 == be2 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dQ))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bd(dQ)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
