package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
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
public final class f {
    public static void a(KsScene ksScene, @NonNull final e eVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        com.kwad.components.ad.reward.monitor.c.a(false, covert.getPosId());
        boolean a10 = m.re().a(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0478a().e(new ImpInfo(covert)).aJ(a10).a(new i() { // from class: com.kwad.components.ad.fullscreen.f.2
            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void bK() {
                com.kwad.components.ad.reward.monitor.c.b(false, SceneImpl.this.posId);
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.fullscreen.f.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                List list;
                String str;
                com.kwad.components.ad.reward.monitor.c.c(false, SceneImpl.this.posId);
                List<AdTemplate> a11 = f.a(SceneImpl.this, adResultData.getAdTemplateList());
                String str2 = "onFullScreenVideoAdCacheFailed";
                if (a11.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg);
                    com.kwad.sdk.utils.i.ap("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.yU());
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : a11) {
                    arrayList.add(new g(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                    com.kwad.components.ad.reward.monitor.d.a(adTemplate, z10, obtainVideoPreCacheConfig);
                }
                final AdTemplate adTemplate2 = (AdTemplate) a11.get(0);
                com.kwad.components.ad.reward.monitor.c.a(false, adTemplate2, a11.size(), elapsedRealtime);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, a11.size());
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        try {
                            eVar.a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            s.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
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
                final ArrayList arrayList2 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(false, adTemplate2);
                final boolean CF = com.kwad.sdk.core.config.d.CF();
                for (final KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd).getAdTemplate();
                    AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate3);
                    if (!com.kwad.sdk.core.response.b.a.bd(dQ) && !com.kwad.sdk.core.response.b.a.cL(dQ)) {
                        list = a11;
                        str = str2;
                        com.kwad.components.ad.c.b.a(adTemplate3, false, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            @Override // com.kwad.components.ad.c.a
                            public final void V() {
                                com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                f.a(adTemplate2, eVar, arrayList2);
                            }

                            @Override // com.kwad.components.ad.c.a
                            public final void W() {
                                if (CF) {
                                    f.a(adTemplate2, eVar, arrayList);
                                }
                            }
                        });
                    } else {
                        list = a11;
                        str = str2;
                        arrayList2.add(ksFullScreenVideoAd);
                        f.a(adTemplate2, eVar, arrayList2);
                    }
                    a11 = list;
                    str2 = str;
                }
                List list2 = a11;
                String str3 = str2;
                com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (!CF && arrayList2.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.avz;
                    onError(eVar2.errorCode, eVar2.msg);
                    com.kwad.sdk.utils.i.ap("fullAd_", str3);
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.b(false, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i10, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(false, i10, str, SceneImpl.this.getPosId());
                if (i10 != com.kwad.sdk.core.network.e.avy.errorCode && i10 != com.kwad.sdk.core.network.e.avt.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(false, i10);
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        eVar.onError(i10, str);
                    }
                });
            }
        }).qy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final e eVar, final List<KsFullScreenVideoAd> list) {
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.fullscreen.f.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.sdk.utils.i.ap("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.M().b(List.this);
                eVar.b(adTemplate, List.this);
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
                if (1 == com.kwad.sdk.core.response.b.a.be(dQ) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dQ))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bd(dQ)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.cL(dQ)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
