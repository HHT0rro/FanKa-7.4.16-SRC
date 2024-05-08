package com.wangmai.tanx.processer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import appa.appa.appe.appd;
import appa.appa.appf.appb;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener;
import com.alimm.tanx.core.ad.ad.feed.ITanxVideoView;
import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.bean.CreativeItem;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.huawei.openalliance.ad.constant.u;
import com.wangmai.bean.NativeProcessorBean;
import com.wangmai.common.Ilistener.IWMAppDownloadListener;
import com.wangmai.common.Ilistener.IWMCommonListener;
import com.wangmai.common.nativepot.AdBaseInfo;
import com.wangmai.common.nativepot.HtmlBean;
import com.wangmai.common.nativepot.NativeWMResponse;
import com.wangmai.common.nativepot.WMVideoBean;
import com.wangmai.common.nativepot.WMVideoControl;
import com.wangmai.common.nativepot.WMVideoListener;
import com.wangmai.common.nativepot.WMVideoOption;
import com.wangmai.common.utils.Utils;
import com.wangmai.common.utils.WMResources;
import com.wangmai.tanx.R;
import com.wangmai.tanx.TanxSdkHelper;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class TanxWMNativePotProcesser extends appd {
    private static final String TAG = "TanxNativePotProcesser";
    ITanxFeedAd iTanxFeedAd;
    ITanxRequestLoader iTanxRequestLoader;
    List<ITanxFeedAd> mAdList;
    TanxAdView nativeAdContainer;
    private NativeProcessorBean nativeProcessorBean;
    NativeWMResponse nativeWMResponse;
    View videoView;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* renamed from: com.wangmai.tanx.processer.TanxWMNativePotProcesser$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class AnonymousClass1 implements IWMCommonListener {
        final /* synthetic */ NativeProcessorBean val$bean;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* renamed from: com.wangmai.tanx.processer.TanxWMNativePotProcesser$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class C07081 implements ITanxRequestLoader.ITanxRequestListener<ITanxFeedAd> {
            C07081() {
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError) {
                if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[xt.mw native pot] 广告请求失败(onError)");
                    if (tanxError != null) {
                        sb2.append(u.bD);
                        sb2.append(tanxError.getCode());
                        sb2.append(",");
                        sb2.append(tanxError.getMessage());
                    }
                    TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd(sb2.toString());
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List<ITanxFeedAd> list) {
                try {
                    if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                        if (list != null && !list.isEmpty()) {
                            TanxWMNativePotProcesser.this.mAdList = list;
                            TanxWMNativePotProcesser.this.iTanxFeedAd = TanxWMNativePotProcesser.this.mAdList.get(0);
                            long adPrice = TanxWMNativePotProcesser.this.iTanxFeedAd.getBiddingInfo().getAdPrice();
                            appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] 响应成功 ecpm:" + adPrice);
                            TanxWMNativePotProcesser.this.setDspPrice((int) adPrice);
                            TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onAdRequest();
                            final CreativeItem creativeItem = TanxWMNativePotProcesser.this.iTanxFeedAd.getBidInfo().getCreativeItem();
                            TanxWMNativePotProcesser.this.nativeWMResponse = new NativeWMResponse() { // from class: com.wangmai.tanx.processer.TanxWMNativePotProcesser.1.1.1
                                @Override // com.wangmai.common.nativepot.NativeWMResponse
                                public void bindToAdContainer(final ViewGroup viewGroup, final View view) {
                                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] bindToAdContainer");
                                    if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                                        TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().appb();
                                    }
                                    view.post(new Runnable() { // from class: com.wangmai.tanx.processer.TanxWMNativePotProcesser.1.1.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                if (((appd) TanxWMNativePotProcesser.this).autoGenerateAdLogo) {
                                                    ImageView imageView = new ImageView(TanxWMNativePotProcesser.this.getApplicationContext());
                                                    imageView.setImageDrawable(WMResources.resources.getDrawable(R.mipmap.tanx_ad_logo));
                                                    int dip2px = Utils.dip2px(TanxWMNativePotProcesser.this.getApplicationContext(), 48.0f);
                                                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dip2px, dip2px / 3);
                                                    layoutParams.gravity = 80;
                                                    layoutParams.setMargins(15, 0, 0, 15);
                                                    imageView.setLayoutParams(layoutParams);
                                                    viewGroup.addView(imageView);
                                                }
                                                int width = view.getWidth();
                                                int height = view.getHeight();
                                                appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "mediaAdView.width:" + width, "mediaAdView.height:" + height);
                                                viewGroup.getLayoutParams().width = width;
                                                viewGroup.getLayoutParams().height = height;
                                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                                                appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.topMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(marginLayoutParams.bottomMargin));
                                                ((ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()).setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                                                marginLayoutParams.setMargins(0, 0, 0, 0);
                                            } catch (Throwable th) {
                                                appa.appa.appf.appd.appb(TanxWMNativePotProcesser.TAG, "[xt.mw native pot]  bindToAdContainer error:" + th);
                                            }
                                        }
                                    });
                                    viewGroup.addView(view);
                                }

                                @Override // com.wangmai.common.nativepot.NativeWMResponse
                                public ViewGroup buildContainer(boolean z10) {
                                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] buildContainer");
                                    ((appd) TanxWMNativePotProcesser.this).autoGenerateAdLogo = z10;
                                    TanxWMNativePotProcesser tanxWMNativePotProcesser = TanxWMNativePotProcesser.this;
                                    tanxWMNativePotProcesser.nativeAdContainer = new TanxAdView(tanxWMNativePotProcesser.getApplicationContext());
                                    TanxWMNativePotProcesser.this.nativeAdContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    return TanxWMNativePotProcesser.this.nativeAdContainer;
                                }

                                @Override // com.wangmai.common.nativepot.NativeWMResponse
                                public HtmlBean buildHtmlView() {
                                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] buildHtmlView not support!");
                                    return null;
                                }

                                @Override // com.wangmai.common.nativepot.NativeWMResponse
                                public WMVideoBean buildVideoView(WMVideoOption wMVideoOption, WMVideoListener wMVideoListener) {
                                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] buildVideoView");
                                    return TanxWMNativePotProcesser.this.createVideoView(creativeItem, wMVideoOption.isSilence(), wMVideoListener);
                                }

                                @Override // com.wangmai.common.nativepot.NativeWMResponse
                                public AdBaseInfo getBaseInfo() {
                                    try {
                                        AdBaseInfo adBaseInfo = new AdBaseInfo();
                                        adBaseInfo.setInteractionType(AdBaseInfo.InteractionType.NORMAL);
                                        if (TanxWMNativePotProcesser.this.iTanxFeedAd.getAdType() == 4) {
                                            adBaseInfo.setMaterialType(AdBaseInfo.MaterialType.VIDEO);
                                            adBaseInfo.setVideoWidth(Integer.parseInt(creativeItem.getVideoWidth()));
                                            adBaseInfo.setVideoHeight(Integer.parseInt(creativeItem.getVideoHeight()));
                                        } else {
                                            adBaseInfo.setMaterialType(AdBaseInfo.MaterialType.NORMAL);
                                            adBaseInfo.setImageUrl(creativeItem.getImageUrl());
                                            adBaseInfo.setPictureWidth(Integer.parseInt(creativeItem.getImageWidth()));
                                            adBaseInfo.setPictureHeight(Integer.parseInt(creativeItem.getImageHeight()));
                                        }
                                        if (!TextUtils.isEmpty(creativeItem.getTitle())) {
                                            if (TextUtils.isEmpty(creativeItem.getDescription()) && !TextUtils.isEmpty(creativeItem.getAdvName())) {
                                                adBaseInfo.setTitle(creativeItem.getAdvName());
                                                adBaseInfo.setDesc(creativeItem.getTitle());
                                            } else {
                                                adBaseInfo.setTitle(creativeItem.getTitle());
                                                adBaseInfo.setDesc(creativeItem.getDescription());
                                            }
                                        }
                                        adBaseInfo.setIconURL(creativeItem.getImgSm());
                                        return adBaseInfo;
                                    } catch (Throwable th) {
                                        appa.appa.appf.appd.appb(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] getBaseInfo error:" + th.toString());
                                        return null;
                                    }
                                }

                                @Override // com.wangmai.common.nativepot.NativeWMResponse
                                public void notifyAdViewShow() {
                                }

                                @Override // com.wangmai.common.nativepot.NativeWMResponse
                                public void registerClickableViews(List<View> list2) {
                                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] registerClickableViews");
                                    TanxWMNativePotProcesser tanxWMNativePotProcesser = TanxWMNativePotProcesser.this;
                                    TanxAdView tanxAdView = tanxWMNativePotProcesser.nativeAdContainer;
                                    if (tanxAdView != null) {
                                        tanxWMNativePotProcesser.bindFeedAdView(tanxAdView, null);
                                        return;
                                    }
                                    appa.appa.appf.appd.appb(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] buildContainer方法未调用");
                                    if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                                        TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("buildContainer方法未调用");
                                    }
                                }

                                @Override // com.wangmai.common.nativepot.NativeWMResponse
                                public void setAppDownloadListener(IWMAppDownloadListener iWMAppDownloadListener) {
                                }
                            };
                            if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                                TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNativePresent(TanxWMNativePotProcesser.this.nativeWMResponse);
                                return;
                            }
                            return;
                        }
                        TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("[xt.mw native pot] 暂无填充");
                    }
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] error:" + th.toString());
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                    TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("[xt.mw native pot] 请求超时(onTimeOut)");
                }
            }
        }

        AnonymousClass1(NativeProcessorBean nativeProcessorBean) {
            this.val$bean = nativeProcessorBean;
        }

        @Override // com.wangmai.common.Ilistener.IWMCommonListener
        public void fail(String str) {
            if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd(str);
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMCommonListener
        public void success() {
            TanxWMNativePotProcesser.this.iTanxRequestLoader = TanxCoreSdk.getSDKManager().createRequestLoader(TanxWMNativePotProcesser.this.getApplicationContext());
            TanxWMNativePotProcesser.this.iTanxRequestLoader.request(new TanxAdSlot.Builder().adCount(1).pid(this.val$bean.getSlotId()).setCacheUnderWifi(false).setPlayUnderWifi(false).setNotAutoPlay(false).setVideoParam(new VideoParam(false, false)).setFeedBackDialog(true).build(), new C07081());
        }
    }

    public TanxWMNativePotProcesser(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindFeedAdView(TanxAdView tanxAdView, View view) {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null) {
            iTanxFeedAd.bindFeedAdView(tanxAdView, view, new ITanxFeedInteractionListener() { // from class: com.wangmai.tanx.processer.TanxWMNativePotProcesser.4
                @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
                public void onAdClose() {
                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] onAdClose");
                }

                @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
                public void onAdDislike() {
                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] onAdDislike");
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
                public void onAdClicked(TanxAdView tanxAdView2, ITanxFeedAd iTanxFeedAd2) {
                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] onAdClicked");
                    if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                        TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onClick();
                    }
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
                public void onAdShow(ITanxFeedAd iTanxFeedAd2) {
                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] onAdShow");
                    if (TanxWMNativePotProcesser.this.checkProcessorBean()) {
                        TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onExposure();
                        TanxWMNativePotProcesser.this.nativeProcessorBean.getAdListener().appa();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        NativeProcessorBean nativeProcessorBean = this.nativeProcessorBean;
        return (nativeProcessorBean == null || nativeProcessorBean.getAdListener() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WMVideoBean createVideoView(CreativeItem creativeItem, final boolean z10, final WMVideoListener wMVideoListener) {
        try {
            if (!TextUtils.isEmpty(creativeItem.getVideo())) {
                final ITanxVideoView iTanxVideoView = this.iTanxFeedAd.getITanxVideoView(getApplicationContext());
                this.videoView = iTanxVideoView.getVideoAdView(new ITanxFeedVideoAdListener() { // from class: com.wangmai.tanx.processer.TanxWMNativePotProcesser.2
                    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
                    public void onError(TanxError tanxError) {
                        appa.appa.appf.appd.appe(TanxWMNativePotProcesser.TAG, "DJ.MW NativePot onVideoError：视频播放错误：" + tanxError.getMessage());
                        WMVideoListener wMVideoListener2 = wMVideoListener;
                        if (wMVideoListener2 != null) {
                            wMVideoListener2.onError(tanxError.getMessage());
                        }
                    }

                    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
                    public void onProgressUpdate(long j10, long j11) {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] onProgressUpdate：进度更新");
                    }

                    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
                    public void onVideoAdPaused(ITanxFeedAd iTanxFeedAd) {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot]  onVideoStart：视频暂停播放");
                    }

                    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
                    public void onVideoAdStartPlay(ITanxFeedAd iTanxFeedAd) {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot]  onVideoStart：视频开始播放");
                        WMVideoListener wMVideoListener2 = wMVideoListener;
                        if (wMVideoListener2 != null) {
                            wMVideoListener2.onStart();
                        }
                    }

                    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
                    public void onVideoComplete() {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] onVideoCompleted：视频播放完成");
                        WMVideoListener wMVideoListener2 = wMVideoListener;
                        if (wMVideoListener2 != null) {
                            wMVideoListener2.onComplete();
                        }
                    }

                    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
                    public void onVideoError(TanxPlayerError tanxPlayerError) {
                        appa.appa.appf.appd.appe(TanxWMNativePotProcesser.TAG, "DJ.MW NativePot onVideoError：视频播放错误：" + tanxPlayerError.getMessage());
                        WMVideoListener wMVideoListener2 = wMVideoListener;
                        if (wMVideoListener2 != null) {
                            wMVideoListener2.onError(tanxPlayerError.getMessage());
                        }
                    }

                    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
                    public void onVideoLoad(ITanxFeedAd iTanxFeedAd) {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot]  onVideoLoad：视频准备就绪");
                        if (z10) {
                            iTanxVideoView.setVolume(0);
                        }
                    }
                });
                return new WMVideoBean(new WMVideoControl() { // from class: com.wangmai.tanx.processer.TanxWMNativePotProcesser.3
                    @Override // com.wangmai.common.nativepot.WMVideoControl
                    public void pause() {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] videoControl pause：点击暂停");
                        ITanxVideoView iTanxVideoView2 = iTanxVideoView;
                        if (iTanxVideoView2 != null) {
                            iTanxVideoView2.pause();
                        }
                    }

                    @Override // com.wangmai.common.nativepot.WMVideoControl
                    public void resume() {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] videoControl resume：点击恢复");
                        ITanxVideoView iTanxVideoView2 = iTanxVideoView;
                        if (iTanxVideoView2 != null) {
                            iTanxVideoView2.play();
                        }
                    }

                    @Override // com.wangmai.common.nativepot.WMVideoControl
                    public void setSilence(boolean z11) {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] videoControl setSilence：" + z11);
                        ITanxVideoView iTanxVideoView2 = iTanxVideoView;
                        if (iTanxVideoView2 != null) {
                            if (z11) {
                                iTanxVideoView2.setVolume(0);
                            } else {
                                iTanxVideoView2.setVolume(1);
                            }
                        }
                    }

                    @Override // com.wangmai.common.nativepot.WMVideoControl
                    public void start() {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] videoControl start：点击播放");
                        ITanxVideoView iTanxVideoView2 = iTanxVideoView;
                        if (iTanxVideoView2 != null) {
                            iTanxVideoView2.play();
                        }
                    }

                    @Override // com.wangmai.common.nativepot.WMVideoControl
                    public void stop() {
                        appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] videoControl stop：not support!");
                    }
                }, this.videoView);
            }
            appa.appa.appf.appd.appb(TAG, "[xt.mw native pot] buildVideoView 只能用于 AdBaseInfo.Info.VIDEO 的对象");
            if (checkProcessorBean()) {
                this.nativeProcessorBean.getAdListener().onNoAd("buildVideoView 只能用于 AdBaseInfo.Info.VIDEO 的对象");
            }
            return null;
        } catch (Throwable th) {
            appa.appa.appf.appd.appb(TAG, "[xt.mw native pot] createVideoView error:" + th.getMessage());
            if (checkProcessorBean()) {
                this.nativeProcessorBean.getAdListener().onNoAd("createVideoView error:" + th.getMessage());
            }
            return null;
        }
    }

    @Override // appa.appa.appe.appd
    public void nativeAd(NativeProcessorBean nativeProcessorBean) {
        appa.appa.appf.appd.appa(TAG, "[xt.mw native pot] load appId:" + nativeProcessorBean.getAppId(), "appKey:" + nativeProcessorBean.getAppKey(), "slotId:" + nativeProcessorBean.getSlotId());
        this.nativeProcessorBean = nativeProcessorBean;
        TanxSdkHelper.getInstance().init(getApplication(), nativeProcessorBean.getAppId(), nativeProcessorBean.getAppKey(), new AnonymousClass1(nativeProcessorBean));
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
        try {
            appa.appa.appf.appd.appa(TAG, "[xt.mw native pot] onDestroy");
            if (this.videoView != null) {
                appb.appb(this.videoView);
                appb.appa(this.videoView);
                this.videoView.destroyDrawingCache();
                this.videoView = null;
            }
            if (this.nativeAdContainer != null) {
                appb.appb(this.nativeAdContainer);
                appb.appa(this.nativeAdContainer);
                this.nativeAdContainer.destroyDrawingCache();
                this.nativeAdContainer = null;
            }
            if (this.nativeWMResponse != null) {
                this.nativeWMResponse = null;
            }
            if (this.nativeProcessorBean != null) {
                this.nativeProcessorBean.setAdListener(null);
                this.nativeProcessorBean = null;
            }
            if (this.mAdList != null) {
                this.mAdList.clear();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(TAG, "[xt.mw native pot] onDestroy error:" + th.toString());
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, final String str2, String str3) {
        try {
            if (this.iTanxRequestLoader == null || this.iTanxFeedAd == null) {
                return;
            }
            TanxBiddingInfo biddingInfo = this.iTanxFeedAd.getBiddingInfo();
            biddingInfo.setBidResult(false);
            biddingInfo.setWinPrice(Double.parseDouble(str2));
            this.iTanxFeedAd.setBiddingResult(biddingInfo);
            this.iTanxRequestLoader.biddingResult(this.mAdList, new ITanxRequestLoader.OnBiddingListener<ITanxFeedAd>() { // from class: com.wangmai.tanx.processer.TanxWMNativePotProcesser.6
                @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
                public void onResult(List<ITanxFeedAd> list) {
                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] sendLossNotification completed!", "winPrice=" + str2);
                }
            });
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(TAG, "[xt.mw native pot] sendLossNotification fail:" + th);
        }
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(final String str, final String str2) {
        try {
            if (this.iTanxRequestLoader == null || this.iTanxFeedAd == null) {
                return;
            }
            TanxBiddingInfo biddingInfo = this.iTanxFeedAd.getBiddingInfo();
            biddingInfo.setBidResult(true);
            biddingInfo.setWinPrice(Double.parseDouble(str));
            this.iTanxFeedAd.setBiddingResult(biddingInfo);
            this.iTanxRequestLoader.biddingResult(this.mAdList, new ITanxRequestLoader.OnBiddingListener<ITanxFeedAd>() { // from class: com.wangmai.tanx.processer.TanxWMNativePotProcesser.5
                @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
                public void onResult(List<ITanxFeedAd> list) {
                    appa.appa.appf.appd.appa(TanxWMNativePotProcesser.TAG, "[xt.mw native pot] sendWinNotification completed!", "winPrice=" + str, "lossPrice=" + str2);
                }
            });
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(TAG, "[[xt.mw native pot] sendWinNotification fail:" + th);
        }
    }
}
