package com.wangmai.qumeng.processer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import appa.appa.appe.appd;
import com.hailiang.advlib.api.AiClkAdManager;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.AppInformation;
import com.hailiang.advlib.core.IAppDownloadListener;
import com.hailiang.advlib.core.IMultiAdObject;
import com.hailiang.advlib.core.IMultiAdRequest;
import com.wangmai.appsdkdex.utils.VisibilityUtils;
import com.wangmai.bean.NativeProcessorBean;
import com.wangmai.common.Ilistener.IWMAppDownloadListener;
import com.wangmai.common.Ilistener.IWMCommonListener;
import com.wangmai.common.bean.MaterialInformationBean;
import com.wangmai.common.nativepot.AdBaseInfo;
import com.wangmai.common.nativepot.HtmlBean;
import com.wangmai.common.nativepot.NativeWMResponse;
import com.wangmai.common.nativepot.WMVideoBean;
import com.wangmai.common.nativepot.WMVideoControl;
import com.wangmai.common.nativepot.WMVideoListener;
import com.wangmai.common.nativepot.WMVideoOption;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.Utils;
import com.wangmai.common.utils.WMResources;
import com.wangmai.qumeng.QuMengSdkInitHelper;
import com.wangmai.qumeng.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class QuMWMNativePotProcesser extends appd {
    private static final String TAG = "QuMWMNativePotProc";
    private IWMAppDownloadListener appDownloadListener;
    private IMultiAdObject mIMultiAdObject;
    private NativeProcessorBean nativeProcessorBean;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* renamed from: com.wangmai.qumeng.processer.QuMWMNativePotProcesser$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class AnonymousClass1 implements IWMCommonListener {
        final /* synthetic */ NativeProcessorBean val$bean;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* renamed from: com.wangmai.qumeng.processer.QuMWMNativePotProcesser$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class C07011 implements AdRequestParam.ADLoadListener {
            C07011() {
            }

            @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
            public void onADLoaded(IMultiAdObject iMultiAdObject) {
                if (iMultiAdObject == null) {
                    if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                        QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("[mq.mw native pot] 暂无填充");
                        return;
                    }
                    return;
                }
                QuMWMNativePotProcesser.this.mIMultiAdObject = iMultiAdObject;
                QuMWMNativePotProcesser quMWMNativePotProcesser = QuMWMNativePotProcesser.this;
                quMWMNativePotProcesser.setDspPrice(quMWMNativePotProcesser.mIMultiAdObject.getECPM());
                appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] 加载成功，ecpm=" + QuMWMNativePotProcesser.this.getDspPrice());
                NativeWMResponse nativeWMResponse = new NativeWMResponse() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.1.1.1
                    private RelativeLayout containerView;

                    @Override // com.wangmai.common.nativepot.NativeWMResponse
                    public void bindToAdContainer(final ViewGroup viewGroup, final View view) {
                        if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                            QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().appb();
                        }
                        view.post(new Runnable() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.1.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (((appd) QuMWMNativePotProcesser.this).autoGenerateAdLogo) {
                                        ImageView imageView = new ImageView(QuMWMNativePotProcesser.this.getApplicationContext());
                                        imageView.setImageDrawable(WMResources.resources.getDrawable(R.mipmap.qm_ad_logo));
                                        int dip2px = Utils.dip2px(QuMWMNativePotProcesser.this.getApplicationContext(), 48.0f);
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px / 3);
                                        layoutParams.addRule(12);
                                        layoutParams.setMargins(15, 0, 0, 15);
                                        imageView.setLayoutParams(layoutParams);
                                        viewGroup.addView(imageView);
                                    }
                                    int width = view.getWidth();
                                    int height = view.getHeight();
                                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "mediaAdView.width:" + width, "mediaAdView.height:" + height);
                                    viewGroup.getLayoutParams().width = width;
                                    viewGroup.getLayoutParams().height = height;
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.topMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(marginLayoutParams.bottomMargin));
                                    ((ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()).setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                                    marginLayoutParams.setMargins(0, 0, 0, 0);
                                    View twistView = QuMWMNativePotProcesser.this.mIMultiAdObject.getTwistView(QuMWMNativePotProcesser.this.getApplicationContext());
                                    if (twistView != null) {
                                        int dip2px2 = Utils.dip2px(QuMWMNativePotProcesser.this.getApplicationContext(), 168.0f);
                                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
                                        layoutParams2.addRule(13);
                                        twistView.setLayoutParams(layoutParams2);
                                        viewGroup.addView(twistView);
                                    }
                                } catch (Throwable th) {
                                    appa.appa.appf.appd.appb(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] bindToAdContainer error:" + th);
                                }
                            }
                        });
                        viewGroup.addView(view);
                    }

                    @Override // com.wangmai.common.nativepot.NativeWMResponse
                    public ViewGroup buildContainer(boolean z10) {
                        ((appd) QuMWMNativePotProcesser.this).autoGenerateAdLogo = z10;
                        this.containerView = new RelativeLayout(QuMWMNativePotProcesser.this.getApplicationContext());
                        this.containerView.setGravity(17);
                        this.containerView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                        return this.containerView;
                    }

                    @Override // com.wangmai.common.nativepot.NativeWMResponse
                    public HtmlBean buildHtmlView() {
                        appa.appa.appf.appd.appb(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] buildHtmlView 只能用于 AdBaseInfo.Info.HTML 的对象");
                        if (!QuMWMNativePotProcesser.this.checkProcessorBean()) {
                            return null;
                        }
                        QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("buildHtmlView 只能用于 AdBaseInfo.Info.HTML 的对象");
                        return null;
                    }

                    @Override // com.wangmai.common.nativepot.NativeWMResponse
                    public WMVideoBean buildVideoView(WMVideoOption wMVideoOption, WMVideoListener wMVideoListener) {
                        if (QuMWMNativePotProcesser.this.mIMultiAdObject.getMaterialType() == 4 || QuMWMNativePotProcesser.this.mIMultiAdObject.getMaterialType() == 9) {
                            return QuMWMNativePotProcesser.this.createVideoView(wMVideoListener);
                        }
                        appa.appa.appf.appd.appb(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] buildVideoView 只能用于 AdBaseInfo.Info.VIDEO 的对象");
                        if (!QuMWMNativePotProcesser.this.checkProcessorBean()) {
                            return null;
                        }
                        QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("buildVideoView 只能用于 AdBaseInfo.Info.VIDEO 的对象");
                        return null;
                    }

                    @Override // com.wangmai.common.nativepot.NativeWMResponse
                    public AdBaseInfo getBaseInfo() {
                        AdBaseInfo adBaseInfo = new AdBaseInfo();
                        Pair<Integer, Integer> mediaSize = QuMWMNativePotProcesser.this.mIMultiAdObject.getMediaSize();
                        int materialType = QuMWMNativePotProcesser.this.mIMultiAdObject.getMaterialType();
                        if (materialType == 1 || materialType == 2 || materialType == 3) {
                            adBaseInfo.setMaterialType(AdBaseInfo.MaterialType.NORMAL);
                            List<String> imageUrls = QuMWMNativePotProcesser.this.mIMultiAdObject.getImageUrls();
                            if (imageUrls != null) {
                                if (imageUrls.size() == 1) {
                                    adBaseInfo.setImageUrl(imageUrls.get(0));
                                } else {
                                    adBaseInfo.setImageUrls(imageUrls);
                                }
                                if (mediaSize != null) {
                                    adBaseInfo.setPictureWidth(((Integer) mediaSize.first).intValue());
                                    adBaseInfo.setPictureHeight(((Integer) mediaSize.second).intValue());
                                }
                            } else {
                                appa.appa.appf.appd.appb(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] images is null");
                            }
                        } else {
                            if (materialType != 4 && materialType != 9) {
                                appa.appa.appf.appd.appb(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] 未知的广告数据类型");
                                if (!QuMWMNativePotProcesser.this.checkProcessorBean()) {
                                    return null;
                                }
                                QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("[mq.mw native pot] 未知的物料类型");
                                return null;
                            }
                            adBaseInfo.setMaterialType(AdBaseInfo.MaterialType.VIDEO);
                            if (mediaSize != null) {
                                adBaseInfo.setVideoWidth(((Integer) mediaSize.first).intValue());
                                adBaseInfo.setVideoHeight(((Integer) mediaSize.second).intValue());
                            }
                        }
                        adBaseInfo.setTitle(QuMWMNativePotProcesser.this.mIMultiAdObject.getTitle());
                        adBaseInfo.setIconURL(QuMWMNativePotProcesser.this.mIMultiAdObject.getAppLogoUrl());
                        adBaseInfo.setDesc(QuMWMNativePotProcesser.this.mIMultiAdObject.getDesc());
                        AppInformation appInformation = QuMWMNativePotProcesser.this.mIMultiAdObject.getAppInformation();
                        if (QuMWMNativePotProcesser.this.mIMultiAdObject.getInteractionType() != 2) {
                            adBaseInfo.setInteractionType(AdBaseInfo.InteractionType.NORMAL);
                        } else if (appInformation != null) {
                            QuMWMNativePotProcesser.this.setDownloadListener();
                            AdBaseInfo.WMDownloadAppInfo wMDownloadAppInfo = new AdBaseInfo.WMDownloadAppInfo();
                            adBaseInfo.setInteractionType(AdBaseInfo.InteractionType.DOWNLOAD);
                            wMDownloadAppInfo.setAppName(QuMWMNativePotProcesser.this.mIMultiAdObject.getAppName());
                            wMDownloadAppInfo.setAppVersion(appInformation.getAppVersion());
                            wMDownloadAppInfo.setAppDeveloper(appInformation.getDevelopers());
                            wMDownloadAppInfo.setAppDescUrl(appInformation.getFunctionDescUrl());
                            wMDownloadAppInfo.setPermissionUrl(appInformation.getPermissionProtocolUrl());
                            wMDownloadAppInfo.setPrivacyUrl(appInformation.getPrivacyProtocolUrl());
                            wMDownloadAppInfo.setAppIconUrl(QuMWMNativePotProcesser.this.mIMultiAdObject.getAppLogoUrl());
                            adBaseInfo.setDownloadAppInfo(wMDownloadAppInfo);
                        } else if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                            appa.appa.appf.appd.appb(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] 下载要素缺失");
                            QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("[mq.mw native pot] 下载要素缺失");
                        }
                        return adBaseInfo;
                    }

                    @Override // com.wangmai.common.nativepot.NativeWMResponse
                    public void notifyAdViewShow() {
                    }

                    @Override // com.wangmai.common.nativepot.NativeWMResponse
                    public void registerClickableViews(final List<View> list) {
                        RelativeLayout relativeLayout = this.containerView;
                        if (relativeLayout != null) {
                            relativeLayout.post(new Runnable() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.1.1.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (C07021.this.containerView.getParent() != null && C07021.this.containerView.getWidth() != 0 && C07021.this.containerView.getHeight() != 0 && C07021.this.containerView.getAlpha() != 0.0f && C07021.this.containerView.getVisibility() == 0) {
                                        C07021 c07021 = C07021.this;
                                        QuMWMNativePotProcesser.this.bindView(c07021.containerView, list);
                                    } else {
                                        appa.appa.appf.appd.appb(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] containerView加载异常,请检查广告加载流程是否正确或containerView是否正常显示");
                                        if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                                            QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("containerView加载异常,请检查广告加载流程是否正确或containerView是否正常显示");
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        appa.appa.appf.appd.appb(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] buildContainer方法未调用");
                        if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                            QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd("buildContainer方法未调用");
                        }
                    }

                    @Override // com.wangmai.common.nativepot.NativeWMResponse
                    public void setAppDownloadListener(IWMAppDownloadListener iWMAppDownloadListener) {
                        QuMWMNativePotProcesser.this.appDownloadListener = iWMAppDownloadListener;
                    }
                };
                if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                    QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNativePresent(nativeWMResponse);
                }
                QuMWMNativePotProcesser.this.buildMaterialInformation();
            }

            @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
            public void onAdFailed(String str) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[mq.mw native pot] 请求失败(onAdFailed):");
                sb2.append(str);
                appa.appa.appf.appd.appe(QuMWMNativePotProcesser.TAG, sb2.toString());
                if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                    QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd(sb2.toString());
                }
            }
        }

        AnonymousClass1(NativeProcessorBean nativeProcessorBean) {
            this.val$bean = nativeProcessorBean;
        }

        @Override // com.wangmai.common.Ilistener.IWMCommonListener
        public void fail(String str) {
            appa.appa.appf.appd.appe(QuMWMNativePotProcesser.TAG, str);
            if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd(str);
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMCommonListener
        public void success() {
            AdRequestParam build = new AdRequestParam.Builder().adslotID(this.val$bean.getSlotId()).adType(3).adLoadListener(new C07011()).build();
            IMultiAdRequest createAdRequest = AiClkAdManager.getInstance().createAdRequest();
            if (createAdRequest != null) {
                createAdRequest.invokeADV(build);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[mq.mw native pot] 请求失败:IMultiAdRequest为空");
            appa.appa.appf.appd.appe(QuMWMNativePotProcesser.TAG, sb2.toString());
            if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onNoAd(sb2.toString());
            }
        }
    }

    public QuMWMNativePotProcesser(Context context) {
        super(context);
    }

    private void addVisibleChangedListener(ViewGroup viewGroup, final View view) {
        VisibilityUtils.getInstance().addVisibleChangedListener(viewGroup, new VisibilityUtils.ViewVisibilityChangeListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.2
            @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
            public void invisible() {
                View view2 = view;
                if (view2 == null || view2.getVisibility() != 0) {
                    return;
                }
                view.setVisibility(8);
            }

            @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
            public void visible() {
                View view2 = view;
                if (view2 == null || view2.getVisibility() != 8) {
                    return;
                }
                view.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(ViewGroup viewGroup, List<View> list) {
        if (this.mIMultiAdObject != null) {
            if (list == null) {
                list = new ArrayList<>();
                list.add(viewGroup);
            }
            this.mIMultiAdObject.bindEvent(viewGroup, list, new IMultiAdObject.ADEventListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.5
                @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
                public void onADExposed() {
                    if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                        QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onExposure();
                        QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().appa();
                    }
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
                public void onAdClick() {
                    if (QuMWMNativePotProcesser.this.checkProcessorBean()) {
                        QuMWMNativePotProcesser.this.nativeProcessorBean.getAdListener().onClick();
                    }
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
                public void onAdFailed(String str) {
                    appa.appa.appf.appd.appe(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] 渲染失败:" + str);
                    QuMWMNativePotProcesser.this.checkProcessorBean();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildMaterialInformation() {
        try {
            int nextInt = new Random().nextInt(10000);
            appa.appa.appf.appd.appa(TAG, "本次采集概率阈值：" + nextInt);
            if (!checkProcessorBean() || nextInt > this.nativeProcessorBean.getMaterialCollectRand()) {
                appa.appa.appf.appd.appa(TAG, "不满足素材采集概率，放弃本次采集", Integer.valueOf(nextInt));
                return;
            }
            String title = this.mIMultiAdObject.getTitle();
            String desc = this.mIMultiAdObject.getDesc();
            String landingPageUrl = this.mIMultiAdObject.getLandingPageUrl();
            int ecpm = this.mIMultiAdObject.getECPM();
            int materialType = this.mIMultiAdObject.getMaterialType();
            int interactionType = this.mIMultiAdObject.getInteractionType();
            appa.appa.appf.appd.appa(TAG, "title:" + title);
            appa.appa.appf.appd.appa(TAG, "desc:" + desc);
            appa.appa.appf.appd.appa(TAG, "ecpm:" + ecpm);
            appa.appa.appf.appd.appa(TAG, "ladingPageUrl:" + landingPageUrl);
            appa.appa.appf.appd.appa(TAG, "materialType:" + materialType);
            appa.appa.appf.appd.appa(TAG, "interactionType:" + interactionType);
            MaterialInformationBean materialInformationBean = new MaterialInformationBean(this.nativeProcessorBean.getRequestId(), this.nativeProcessorBean.getMediaAdSlotId(), this.nativeProcessorBean.getDemandPlatformId(), this.nativeProcessorBean.getSlotId());
            MaterialInformationBean.AdMaterialInfo adMaterialInfo = new MaterialInformationBean.AdMaterialInfo();
            adMaterialInfo.setTitle(title);
            adMaterialInfo.setDesc(desc);
            adMaterialInfo.setPrice(ecpm);
            adMaterialInfo.setLandingpage(landingPageUrl);
            int materialType2 = this.mIMultiAdObject.getMaterialType();
            if (materialType2 == 1 || materialType2 == 2 || materialType2 == 3) {
                appa.appa.appf.appd.appa(TAG, "当前广告物料类型为图片");
                adMaterialInfo.setType(1);
                List<String> imageUrls = this.mIMultiAdObject.getImageUrls();
                appa.appa.appf.appd.appa(TAG, "图片物料地址：" + ((Object) imageUrls));
                if (imageUrls != null && !imageUrls.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Pair<Integer, Integer> mediaSize = this.mIMultiAdObject.getMediaSize();
                    for (String str : imageUrls) {
                        MaterialInformationBean.AdMaterialInfo.Image image = new MaterialInformationBean.AdMaterialInfo.Image();
                        image.setUrl(str);
                        if (mediaSize != null) {
                            image.setW(((Integer) mediaSize.first).intValue());
                            image.setH(((Integer) mediaSize.second).intValue());
                        }
                        arrayList.add(image);
                    }
                    adMaterialInfo.setImage(arrayList);
                }
            } else if (materialType2 != 4 && materialType2 != 9) {
                appa.appa.appf.appd.appe(TAG, "当前广告物料类型未知");
                adMaterialInfo.setType(9);
            } else {
                appa.appa.appf.appd.appa(TAG, "当前广告物料类型为视频");
                adMaterialInfo.setType(2);
                List<String> imageUrls2 = this.mIMultiAdObject.getImageUrls();
                appa.appa.appf.appd.appa(TAG, "图片物料地址：" + ((Object) imageUrls2));
                if (imageUrls2 != null && !imageUrls2.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    Pair<Integer, Integer> mediaSize2 = this.mIMultiAdObject.getMediaSize();
                    MaterialInformationBean.AdMaterialInfo.Video video = new MaterialInformationBean.AdMaterialInfo.Video();
                    for (String str2 : imageUrls2) {
                        if (str2.endsWith(".mp4")) {
                            video.setUrl(str2);
                            if (mediaSize2 != null) {
                                video.setW(((Integer) mediaSize2.first).intValue());
                                video.setH(((Integer) mediaSize2.second).intValue());
                            }
                        } else {
                            MaterialInformationBean.AdMaterialInfo.Image image2 = new MaterialInformationBean.AdMaterialInfo.Image();
                            image2.setUrl(str2);
                            if (mediaSize2 != null) {
                                image2.setW(((Integer) mediaSize2.first).intValue());
                                image2.setH(((Integer) mediaSize2.second).intValue());
                            }
                            arrayList2.add(image2);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        adMaterialInfo.setImage(arrayList2);
                    }
                    if (!TextUtils.isEmpty(video.getUrl())) {
                        adMaterialInfo.setVideo(video);
                    }
                }
            }
            int interactionType2 = this.mIMultiAdObject.getInteractionType();
            if (interactionType2 == 1) {
                appa.appa.appf.appd.appa(TAG, "当前交互类型为打开落地页广告");
                adMaterialInfo.setAction_type(2);
            } else if (interactionType2 != 2) {
                appa.appa.appf.appd.appe(TAG, "当前交互类型未知");
                adMaterialInfo.setAction_type(9);
            } else {
                appa.appa.appf.appd.appa(TAG, "当前交互类型为下载类广告");
                adMaterialInfo.setAction_type(1);
                AppInformation appInformation = this.mIMultiAdObject.getAppInformation();
                if (appInformation != null) {
                    appa.appa.appf.appd.appa(TAG, "下载应用信息：" + GsonUtils.getInstance().toJson(appInformation));
                    MaterialInformationBean.AdMaterialInfo.AppInformation appInformation2 = new MaterialInformationBean.AdMaterialInfo.AppInformation();
                    appInformation2.setName(this.mIMultiAdObject.getAppName());
                    appInformation2.setVer(appInformation.getAppVersion());
                    appInformation2.setDeveloper(appInformation.getDevelopers());
                    appInformation2.setPrivacy_policy_url(appInformation.getPrivacyProtocolUrl());
                    appInformation2.setDesc_url(appInformation.getFunctionDescUrl());
                    appInformation2.setPermission_url(appInformation.getPermissionProtocolUrl());
                    adMaterialInfo.setDownload_app(appInformation2);
                }
            }
            materialInformationBean.setAdm(adMaterialInfo);
            sendMaterialInformation(materialInformationBean);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(TAG, "buildMaterialInformation error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        NativeProcessorBean nativeProcessorBean = this.nativeProcessorBean;
        return (nativeProcessorBean == null || nativeProcessorBean.getAdListener() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WMVideoBean createVideoView(final WMVideoListener wMVideoListener) {
        try {
            View videoView = this.mIMultiAdObject.getVideoView(getApplicationContext());
            this.mIMultiAdObject.setOnMediaStateListener(new IMultiAdObject.MediaStateListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.3
                @Override // com.hailiang.advlib.core.IMultiAdObject.MediaStateListener
                public void onVideoCompleted() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] onVideoCompleted：视频播放完成");
                    WMVideoListener wMVideoListener2 = wMVideoListener;
                    if (wMVideoListener2 != null) {
                        wMVideoListener2.onComplete();
                    }
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.MediaStateListener
                public void onVideoPause() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot]  onVideoStart：视频暂停播放");
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.MediaStateListener
                public void onVideoReady() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot]  onVideoLoad：视频准备就绪");
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.MediaStateListener
                public void onVideoResume() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot]  onVideoStart：视频恢复播放");
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.MediaStateListener
                public void onVideoStart() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot]  onVideoStart：视频开始播放");
                    WMVideoListener wMVideoListener2 = wMVideoListener;
                    if (wMVideoListener2 != null) {
                        wMVideoListener2.onStart();
                    }
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.MediaStateListener
                public void onVideoStop() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] onVideoCompleted：视频停止播放");
                }
            });
            return new WMVideoBean(new WMVideoControl() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.4
                @Override // com.wangmai.common.nativepot.WMVideoControl
                public void pause() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] videoControl pause：not support!");
                }

                @Override // com.wangmai.common.nativepot.WMVideoControl
                public void resume() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] videoControl resume：not support!");
                }

                @Override // com.wangmai.common.nativepot.WMVideoControl
                public void setSilence(boolean z10) {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] videoControl setSilence：not support! " + z10);
                }

                @Override // com.wangmai.common.nativepot.WMVideoControl
                public void start() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] videoControl start：not support!");
                }

                @Override // com.wangmai.common.nativepot.WMVideoControl
                public void stop() {
                    appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "[mq.mw native pot] videoControl stop：not support!");
                }
            }, videoView);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb(TAG, "[mq.mw native pot] createVideoView error:" + th.getMessage());
            if (!checkProcessorBean()) {
                return null;
            }
            this.nativeProcessorBean.getAdListener().onNoAd("createVideoView error:" + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean downloadListenerIsAvailable() {
        return this.appDownloadListener != null;
    }

    private void setADStateListener() {
        IMultiAdObject iMultiAdObject = this.mIMultiAdObject;
        if (iMultiAdObject != null) {
            iMultiAdObject.setADStateListener(new IMultiAdObject.ADStateListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.6
                @Override // com.hailiang.advlib.core.IMultiAdObject.ADStateListener
                public void onAdEvent(int i10, Bundle bundle) {
                    if (i10 == 2) {
                        QuMWMNativePotProcesser.this.checkProcessorBean();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloadListener() {
        this.mIMultiAdObject.setDownloadListener(new IAppDownloadListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativePotProcesser.7
            @Override // com.hailiang.advlib.core.IAppDownloadListener
            public void onDownloadActive(long j10, long j11, String str) {
                int i10 = (int) ((j11 / j10) * 100);
                appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "下载中：" + i10);
                if (QuMWMNativePotProcesser.this.downloadListenerIsAvailable()) {
                    QuMWMNativePotProcesser.this.appDownloadListener.onProgressUpdate(i10);
                }
            }

            @Override // com.hailiang.advlib.core.IAppDownloadListener
            public void onDownloadCompleted(String str) {
                appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "下载完成");
                if (QuMWMNativePotProcesser.this.downloadListenerIsAvailable()) {
                    QuMWMNativePotProcesser.this.appDownloadListener.onDownloadFinished();
                }
            }

            @Override // com.hailiang.advlib.core.IAppDownloadListener
            public void onDownloadFailed() {
                appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "下载失败");
                if (QuMWMNativePotProcesser.this.downloadListenerIsAvailable()) {
                    QuMWMNativePotProcesser.this.appDownloadListener.onDownloadFailed();
                }
            }

            @Override // com.hailiang.advlib.core.IAppDownloadListener
            public void onDownloadPaused(long j10, long j11, String str) {
                appa.appa.appf.appd.appa(QuMWMNativePotProcesser.TAG, "下载暂停");
                if (QuMWMNativePotProcesser.this.downloadListenerIsAvailable()) {
                    QuMWMNativePotProcesser.this.appDownloadListener.onDownloadPaused();
                }
            }

            @Override // com.hailiang.advlib.core.IAppDownloadListener
            public void onIdle() {
            }

            @Override // com.hailiang.advlib.core.IAppDownloadListener
            public void onInstalled(String str) {
            }
        });
    }

    @Override // appa.appa.appe.appd
    public void nativeAd(NativeProcessorBean nativeProcessorBean) {
        try {
            appa.appa.appf.appd.appa(TAG, "[mq.mw native pot] load appId:" + nativeProcessorBean.getAppId(), "slotId:" + nativeProcessorBean.getSlotId());
            this.nativeProcessorBean = nativeProcessorBean;
            QuMengSdkInitHelper.getInstance().init(getApplicationContext(), nativeProcessorBean.getAppId(), new AnonymousClass1(nativeProcessorBean));
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(TAG, "[mq.mw native pot] 加载错误:" + ((Object) th));
            if (checkProcessorBean()) {
                this.nativeProcessorBean.getAdListener().onNoAd("[mq.mw native pot] 加载错误:" + th.getMessage());
            }
        }
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
        try {
            if (this.mIMultiAdObject != null) {
                this.mIMultiAdObject.destroy();
                this.mIMultiAdObject = null;
            }
            if (this.nativeProcessorBean != null) {
                this.nativeProcessorBean.setAdListener(null);
                this.nativeProcessorBean = null;
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(TAG, "[mq.mw native pot] onDestroy error:" + th);
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, String str2, String str3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // appa.appa.appa.appa
    public void sendMaterialInformation(MaterialInformationBean materialInformationBean) {
        super.sendMaterialInformation(materialInformationBean);
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(String str, String str2) {
    }
}
