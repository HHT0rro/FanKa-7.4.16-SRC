package com.bytedance.sdk.openadsdk.ej.m;

import android.util.Pair;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ISplashCardListener;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.ej.m.ej.dk;
import com.bytedance.sdk.openadsdk.hc.m.m.m.hc;
import com.bytedance.sdk.openadsdk.hc.m.m.m.n;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.m.m.ej;
import com.bytedance.sdk.openadsdk.mediation.m.m.l;
import com.bytedance.sdk.openadsdk.mediation.m.m.np;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class m {

    /* renamed from: com.bytedance.sdk.openadsdk.ej.m.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class C0129m implements TTAdNative {

        /* renamed from: m, reason: collision with root package name */
        private final m f11189m;

        public C0129m(m mVar) {
            this.f11189m = mVar;
        }

        private ValueSet m(AdSlot adSlot) {
            a k10 = a.k(dk.dk(adSlot));
            k10.h(8302, MediationAdClassLoader.getInstance());
            if (adSlot.getMediationAdSlot() != null) {
                k10.h(260026, new np(adSlot.getMediationAdSlot()));
                k10.h(260027, adSlot.getMediationAdSlot());
            }
            return k10.a();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f11189m.w(m(adSlot), new n(nativeExpressAdListener));
            } catch (Exception e2) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    nativeExpressAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.f11189m.ej(m(adSlot), new com.bytedance.sdk.openadsdk.mediation.m.m.dk(drawFeedAdListener));
            } catch (Exception e2) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    drawFeedAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f11189m.e(m(adSlot), new n(nativeExpressAdListener));
            } catch (Exception e2) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    nativeExpressAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f11189m.m(m(adSlot), new ej(feedAdListener));
            } catch (Exception e2) {
                if (feedAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    feedAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.f11189m.n(m(adSlot), new l(fullScreenVideoAdListener));
            } catch (Exception e2) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    fullScreenVideoAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.f11189m.l(m(adSlot), new com.bytedance.sdk.openadsdk.hc.m.m.m.np(nativeAdListener));
            } catch (Exception e2) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    nativeAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f11189m.hc(m(adSlot), new n(nativeExpressAdListener));
            } catch (Exception e2) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    nativeExpressAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.f11189m.np(m(adSlot), new hc(rewardVideoAdListener));
            } catch (Exception e2) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    rewardVideoAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener, int i10) {
            m(adSlot, splashAdListener, i10);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f11189m.dk(m(adSlot), new ej(feedAdListener));
            } catch (Exception e2) {
                if (feedAdListener != null) {
                    Pair<Integer, String> m10 = this.f11189m.m(e2);
                    feedAdListener.onError(((Integer) m10.first).intValue(), (String) m10.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i10) {
            try {
                this.f11189m.m(m(adSlot), new com.bytedance.sdk.openadsdk.hc.m.m.m.m(cSJSplashAdListener), i10);
            } catch (Exception e2) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> m10 = this.f11189m.m(e2);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.ej.m.m.m.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) m10.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) m10.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.SplashAdListener splashAdListener) {
            m(adSlot, splashAdListener, -1);
        }

        private void m(AdSlot adSlot, final TTAdNative.SplashAdListener splashAdListener, int i10) {
            loadSplashAd(adSlot, new TTAdNative.CSJSplashAdListener() { // from class: com.bytedance.sdk.openadsdk.ej.m.m.m.2
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadFail(CSJAdError cSJAdError) {
                    String str;
                    if (splashAdListener != null) {
                        int i11 = -1;
                        if (cSJAdError != null) {
                            i11 = cSJAdError.getCode();
                            str = cSJAdError.getMsg();
                        } else {
                            str = "splash load fail";
                        }
                        if (i11 == 23) {
                            splashAdListener.onTimeout();
                        } else {
                            splashAdListener.onError(i11, str);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadSuccess() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                    String str;
                    if (splashAdListener != null) {
                        int i11 = -1;
                        if (cSJAdError != null) {
                            i11 = cSJAdError.getCode();
                            str = cSJAdError.getMsg();
                        } else {
                            str = "splash render fail";
                        }
                        if (i11 == 23) {
                            splashAdListener.onTimeout();
                        } else {
                            splashAdListener.onError(i11, str);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                    if (splashAdListener == null) {
                        return;
                    }
                    splashAdListener.onSplashAdLoad(C0129m.this.m(cSJSplashAd));
                }
            }, i10);
        }

        public TTSplashAd m(final CSJSplashAd cSJSplashAd) {
            if (cSJSplashAd == null) {
                return null;
            }
            final TTSplashAd.AdInteractionListener[] adInteractionListenerArr = new TTSplashAd.AdInteractionListener[1];
            return new TTSplashAd() { // from class: com.bytedance.sdk.openadsdk.ej.m.m.m.3
                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public int getInteractionType() {
                    CSJSplashAd cSJSplashAd2 = cSJSplashAd;
                    if (cSJSplashAd2 == null) {
                        return 0;
                    }
                    return cSJSplashAd2.getInteractionType();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public Map<String, Object> getMediaExtraInfo() {
                    return cSJSplashAd.getMediaExtraInfo();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public MediationSplashManager getMediationManager() {
                    return cSJSplashAd.getMediationManager();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public int[] getSplashClickEyeSizeToDp() {
                    return cSJSplashAd.getSplashClickEyeSizeToDp();
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public View getSplashView() {
                    CSJSplashAd cSJSplashAd2 = cSJSplashAd;
                    if (cSJSplashAd2 == null) {
                        return null;
                    }
                    return cSJSplashAd2.getSplashView();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void loss(Double d10, String str, String str2) {
                    cSJSplashAd.loss(d10, str, str2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
                    if (tTAppDownloadListener == null) {
                        return;
                    }
                    cSJSplashAd.setDownloadListener(tTAppDownloadListener);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setNotAllowSdkCountdown() {
                    cSJSplashAd.hideSkipButton();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void setPrice(Double d10) {
                    cSJSplashAd.setPrice(d10);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashCardListener(final ISplashCardListener iSplashCardListener) {
                    if (iSplashCardListener == null) {
                        return;
                    }
                    cSJSplashAd.setSplashCardListener(new CSJSplashAd.SplashCardListener() { // from class: com.bytedance.sdk.openadsdk.ej.m.m.m.3.3
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardClick() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            TTSplashAd.AdInteractionListener[] adInteractionListenerArr2 = adInteractionListenerArr;
                            if (adInteractionListenerArr2[0] != null) {
                                adInteractionListenerArr2[0].onAdClicked(cSJSplashAd.getSplashView(), cSJSplashAd.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardClose() {
                            iSplashCardListener.onSplashClickEyeClose();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                        public void onSplashCardReadyToShow(CSJSplashAd cSJSplashAd2) {
                            iSplashCardListener.setSupportSplashClickEye(true);
                            iSplashCardListener.onSplashEyeReady();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashClickEyeListener(final ISplashClickEyeListener iSplashClickEyeListener) {
                    if (iSplashClickEyeListener == null) {
                        return;
                    }
                    cSJSplashAd.setSplashClickEyeListener(new CSJSplashAd.SplashClickEyeListener() { // from class: com.bytedance.sdk.openadsdk.ej.m.m.m.3.2
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeClick() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            TTSplashAd.AdInteractionListener[] adInteractionListenerArr2 = adInteractionListenerArr;
                            if (adInteractionListenerArr2[0] != null) {
                                adInteractionListenerArr2[0].onAdClicked(cSJSplashAd.getSplashView(), cSJSplashAd.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeClose() {
                            iSplashClickEyeListener.onSplashClickEyeAnimationFinish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                        public void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd2) {
                            iSplashClickEyeListener.isSupportSplashClickEye(true);
                            iSplashClickEyeListener.onSplashClickEyeAnimationStart();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void setSplashInteractionListener(final TTSplashAd.AdInteractionListener adInteractionListener) {
                    CSJSplashAd cSJSplashAd2;
                    if (adInteractionListener == null || (cSJSplashAd2 = cSJSplashAd) == null) {
                        return;
                    }
                    adInteractionListenerArr[0] = adInteractionListener;
                    cSJSplashAd2.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.bytedance.sdk.openadsdk.ej.m.m.m.3.1
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClick(CSJSplashAd cSJSplashAd3) {
                            if (cSJSplashAd3 == null) {
                                adInteractionListener.onAdClicked(null, -1);
                            } else {
                                adInteractionListener.onAdClicked(cSJSplashAd3.getSplashView(), cSJSplashAd3.getInteractionType());
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClose(CSJSplashAd cSJSplashAd3, int i10) {
                            if (i10 == 1) {
                                adInteractionListener.onAdSkip();
                            } else if (i10 == 2 || i10 == 4) {
                                adInteractionListener.onAdTimeOver();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdShow(CSJSplashAd cSJSplashAd3) {
                            if (cSJSplashAd3 == null) {
                                adInteractionListener.onAdShow(null, -1);
                            } else {
                                adInteractionListener.onAdShow(cSJSplashAd3.getSplashView(), cSJSplashAd3.getInteractionType());
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void splashClickEyeAnimationFinish() {
                    cSJSplashAd.showSplashClickEyeView(null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void startClickEye(boolean z10) {
                    cSJSplashAd.startClickEye();
                }

                @Override // com.bytedance.sdk.openadsdk.TTClientBidding
                public void win(Double d10) {
                    cSJSplashAd.win(d10);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd
                public void startClickEye() {
                    cSJSplashAd.startClickEye();
                }
            };
        }
    }

    public abstract void dk(ValueSet valueSet, Bridge bridge);

    public abstract void e(ValueSet valueSet, Bridge bridge);

    public abstract void ej(ValueSet valueSet, Bridge bridge);

    public abstract void hc(ValueSet valueSet, Bridge bridge);

    public abstract void l(ValueSet valueSet, Bridge bridge);

    public abstract Pair<Integer, String> m(Exception exc);

    public TTAdNative m() {
        return new C0129m(this);
    }

    public abstract void m(ValueSet valueSet, Bridge bridge);

    public abstract void m(ValueSet valueSet, Bridge bridge, int i10);

    public abstract void n(ValueSet valueSet, Bridge bridge);

    public abstract void np(ValueSet valueSet, Bridge bridge);

    public abstract void w(ValueSet valueSet, Bridge bridge);
}
