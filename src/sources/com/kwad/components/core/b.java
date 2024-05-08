package com.kwad.components.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.constant.TanxAdType;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.kwad.components.ad.b.d;
import com.kwad.components.ad.b.f;
import com.kwad.components.ad.b.g;
import com.kwad.components.ad.b.h;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        com.kwad.components.ad.b.a aVar = (com.kwad.components.ad.b.a) c.f(com.kwad.components.ad.b.a.class);
        return aVar != null ? aVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.b.a aVar = (com.kwad.components.ad.b.a) c.f(com.kwad.components.ad.b.a.class);
        return aVar != null ? aVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.sdk.j.a.ak(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        com.kwad.components.ad.b.c cVar = (com.kwad.components.ad.b.c) c.f(com.kwad.components.ad.b.c.class);
        if (cVar != null) {
            cVar.loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.4
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i10, String str) {
                    feedAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            com.kwad.sdk.j.a.al(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
            e eVar = e.avv;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        com.kwad.sdk.j.a.ak("draw", "request");
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) c.f(com.kwad.components.ad.b.b.class);
        if (bVar != null) {
            bVar.loadDrawAd(ksScene, new KsLoadManager.DrawAdListener() { // from class: com.kwad.components.core.b.5
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                    drawAdListener.onDrawAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onError(int i10, String str) {
                    drawAdListener.onError(i10, str);
                }
            });
            com.kwad.sdk.j.a.al("draw", "request");
        } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
            e eVar = e.avv;
            drawAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.sdk.j.a.ak(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        com.kwad.components.ad.b.c cVar = (com.kwad.components.ad.b.c) c.f(com.kwad.components.ad.b.c.class);
        if (cVar != null) {
            cVar.loadFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.3
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i10, String str) {
                    feedAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            com.kwad.sdk.j.a.al(IAdInterListener.AdProdType.PRODUCT_FEEDS, "request");
        } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
            e eVar = e.avv;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.kwad.sdk.j.a.ak("fullscreen", "request");
        d dVar = (d) c.f(d.class);
        if (dVar != null) {
            dVar.loadFullScreenVideoAd(ksScene, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.kwad.components.core.b.1
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onError(int i10, String str) {
                    fullScreenVideoAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoResult(list);
                }
            });
            com.kwad.sdk.j.a.al("fullscreen", "request");
        } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
            e eVar = e.avv;
            fullScreenVideoAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        com.kwad.sdk.j.a.ak("interstitial", "request");
        com.kwad.components.ad.b.e eVar = (com.kwad.components.ad.b.e) c.f(com.kwad.components.ad.b.e.class);
        if (eVar != null) {
            eVar.loadInterstitialAd(ksScene, new KsLoadManager.InterstitialAdListener() { // from class: com.kwad.components.core.b.8
                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onError(int i10, String str) {
                    interstitialAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                    interstitialAdListener.onInterstitialAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onRequestResult(int i10) {
                    interstitialAdListener.onRequestResult(i10);
                }
            });
            com.kwad.sdk.j.a.al("interstitial", "request");
        } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
            e eVar2 = e.avv;
            interstitialAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        com.kwad.sdk.j.a.ak(AgdManager.SOURCE_NATIVE, "request");
        f fVar = (f) c.f(f.class);
        if (fVar != null) {
            fVar.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.6
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i10, String str) {
                    nativeAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            });
            com.kwad.sdk.j.a.al(AgdManager.SOURCE_NATIVE, "request");
        } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
            e eVar = e.avv;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        com.kwad.sdk.j.a.ak(TanxAdType.REWARD_STRING, "request");
        g gVar = (g) c.f(g.class);
        if (gVar != null) {
            gVar.loadRewardVideoAd(ksScene, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.core.b.2
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i10, String str) {
                    rewardVideoAdListener.onError(i10, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoResult(list);
                }
            });
        } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
            e eVar = e.avv;
            rewardVideoAdListener.onError(eVar.errorCode, eVar.msg);
        }
        com.kwad.sdk.j.a.al(TanxAdType.REWARD_STRING, "request");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        try {
            com.kwad.sdk.j.a.ak("splash", "request");
            h hVar = (h) c.f(h.class);
            if (hVar != null) {
                hVar.loadSplashScreenAd(ksScene, new KsLoadManager.SplashScreenAdListener() { // from class: com.kwad.components.core.b.7
                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onError(int i10, String str) {
                        splashScreenAdListener.onError(i10, str);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onRequestResult(int i10) {
                        splashScreenAdListener.onRequestResult(i10);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                    }
                });
                com.kwad.sdk.j.a.al("splash", "request");
            } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
                e eVar = e.avv;
                splashScreenAdListener.onError(eVar.errorCode, eVar.msg);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.avD;
            splashScreenAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        com.kwad.components.ad.b.a aVar = (com.kwad.components.ad.b.a) c.f(com.kwad.components.ad.b.a.class);
        if (aVar != null) {
            return aVar.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        f fVar = (f) c.f(f.class);
        if (fVar != null) {
            fVar.loadNativeAd(str, nativeAdListener);
        } else if (com.kwad.components.ad.e.a.f36424md.booleanValue()) {
            e eVar = e.avv;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
