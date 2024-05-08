package com.wangmai.qumeng.processer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import appa.appa.appb.appa;
import appa.appa.appe.apph;
import appa.appa.appf.appd;
import com.hailiang.advlib.api.AiClkAdManager;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.AppInformation;
import com.hailiang.advlib.core.IMultiAdObject;
import com.hailiang.advlib.core.IMultiAdRequest;
import com.wangmai.bean.SplashProcessorBean;
import com.wangmai.common.Ilistener.IWMCommonListener;
import com.wangmai.common.bean.MaterialInformationBean;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.qumeng.QuMengSdkInitHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class QuMWMSplashProccesser extends apph {
    private static final String TAG = "QuMWMSplashProccesser";
    IMultiAdObject mIMultiAdObject;
    SplashProcessorBean splashProcessorBean;

    public QuMWMSplashProccesser(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildMaterialInformation() {
        try {
            int nextInt = new Random().nextInt(10000);
            appd.appa(TAG, "本次采集概率阈值：" + nextInt);
            if (!checkProcessorBean() || nextInt > this.splashProcessorBean.getMaterialCollectRand()) {
                appd.appa(TAG, "不满足素材采集概率，放弃本次采集", Integer.valueOf(nextInt));
                return;
            }
            String title = this.mIMultiAdObject.getTitle();
            String desc = this.mIMultiAdObject.getDesc();
            String landingPageUrl = this.mIMultiAdObject.getLandingPageUrl();
            int ecpm = this.mIMultiAdObject.getECPM();
            int materialType = this.mIMultiAdObject.getMaterialType();
            int interactionType = this.mIMultiAdObject.getInteractionType();
            appd.appa(TAG, "title:" + title);
            appd.appa(TAG, "desc:" + desc);
            appd.appa(TAG, "ecpm:" + ecpm);
            appd.appa(TAG, "ladingPageUrl:" + landingPageUrl);
            appd.appa(TAG, "materialType:" + materialType);
            appd.appa(TAG, "interactionType:" + interactionType);
            MaterialInformationBean materialInformationBean = new MaterialInformationBean(this.splashProcessorBean.getRequestId(), this.splashProcessorBean.getMediaAdSlotId(), this.splashProcessorBean.getDemandPlatformId(), this.splashProcessorBean.getSlotId());
            MaterialInformationBean.AdMaterialInfo adMaterialInfo = new MaterialInformationBean.AdMaterialInfo();
            adMaterialInfo.setTitle(title);
            adMaterialInfo.setDesc(desc);
            adMaterialInfo.setPrice(ecpm);
            adMaterialInfo.setLandingpage(landingPageUrl);
            int materialType2 = this.mIMultiAdObject.getMaterialType();
            if (materialType2 == 1 || materialType2 == 2 || materialType2 == 3) {
                appd.appa(TAG, "当前广告物料类型为图片");
                adMaterialInfo.setType(1);
                List<String> imageUrls = this.mIMultiAdObject.getImageUrls();
                appd.appa(TAG, "图片物料地址：" + ((Object) imageUrls));
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
                appd.appe(TAG, "当前广告物料类型未知");
                adMaterialInfo.setType(9);
            } else {
                appd.appa(TAG, "当前广告物料类型为视频");
                adMaterialInfo.setType(2);
                List<String> imageUrls2 = this.mIMultiAdObject.getImageUrls();
                appd.appa(TAG, "图片物料地址：" + ((Object) imageUrls2));
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
                appd.appa(TAG, "当前交互类型为打开落地页广告");
                adMaterialInfo.setAction_type(2);
            } else if (interactionType2 != 2) {
                appd.appe(TAG, "当前交互类型未知");
                adMaterialInfo.setAction_type(9);
            } else {
                appd.appa(TAG, "当前交互类型为下载类广告");
                adMaterialInfo.setAction_type(1);
                AppInformation appInformation = this.mIMultiAdObject.getAppInformation();
                if (appInformation != null) {
                    appd.appa(TAG, "下载应用信息：" + GsonUtils.getInstance().toJson(appInformation));
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
            appd.appe(TAG, "buildMaterialInformation error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        SplashProcessorBean splashProcessorBean = this.splashProcessorBean;
        return (splashProcessorBean == null || splashProcessorBean.getAdListener() == null) ? false : true;
    }

    private void setADStateListener(IMultiAdObject iMultiAdObject) {
        if (iMultiAdObject != null) {
            iMultiAdObject.setADStateListener(new IMultiAdObject.ADStateListener() { // from class: com.wangmai.qumeng.processer.QuMWMSplashProccesser.3
                @Override // com.hailiang.advlib.core.IMultiAdObject.ADStateListener
                public void onAdEvent(int i10, Bundle bundle) {
                    if (i10 == 12) {
                        appd.appa(QuMWMSplashProccesser.TAG, "下载类型广告，点击出现下载合规弹窗回调");
                    } else if (i10 == 13) {
                        appd.appa(QuMWMSplashProccesser.TAG, "下载类型广告，下载合规弹窗回调");
                    }
                }
            });
        }
    }

    @Override // appa.appa.appe.apph
    public void load(final SplashProcessorBean splashProcessorBean) {
        try {
            appd.appa(TAG, "[mq.mw splash] load appId:" + splashProcessorBean.getAppId(), "slotId:" + splashProcessorBean.getSlotId());
            this.splashProcessorBean = splashProcessorBean;
            QuMengSdkInitHelper.getInstance().init(getApplication(), splashProcessorBean.getAppId(), new IWMCommonListener() { // from class: com.wangmai.qumeng.processer.QuMWMSplashProccesser.1
                @Override // com.wangmai.common.Ilistener.IWMCommonListener
                public void fail(String str) {
                    appd.appe(QuMWMSplashProccesser.TAG, str);
                    if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                        QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onNoAd(str);
                    }
                }

                @Override // com.wangmai.common.Ilistener.IWMCommonListener
                public void success() {
                    Bundle bundle = new Bundle();
                    bundle.putInt("countdown_time", 5);
                    AdRequestParam build = new AdRequestParam.Builder().adslotID(splashProcessorBean.getSlotId()).adType(6).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.wangmai.qumeng.processer.QuMWMSplashProccesser.1.1
                        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
                        public void onADLoaded(IMultiAdObject iMultiAdObject) {
                            if (iMultiAdObject == null) {
                                if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                                    QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onNoAd("[mq.mw splash] 暂无填充");
                                    return;
                                }
                                return;
                            }
                            QuMWMSplashProccesser quMWMSplashProccesser = QuMWMSplashProccesser.this;
                            quMWMSplashProccesser.mIMultiAdObject = iMultiAdObject;
                            quMWMSplashProccesser.setDspPrice(quMWMSplashProccesser.mIMultiAdObject.getECPM());
                            appd.appa(QuMWMSplashProccesser.TAG, "[mq.mw splash] 加载成功，ecpm=" + QuMWMSplashProccesser.this.getDspPrice());
                            if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                                QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onAdRequest();
                            }
                            QuMWMSplashProccesser.this.buildMaterialInformation();
                        }

                        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
                        public void onAdFailed(String str) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[mq.mw splash] 请求失败(onAdFailed):");
                            sb2.append(str);
                            appd.appe(QuMWMSplashProccesser.TAG, sb2.toString());
                            if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                                QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onNoAd(sb2.toString());
                            }
                        }
                    }).extraBundle(bundle).build();
                    IMultiAdRequest createAdRequest = AiClkAdManager.getInstance().createAdRequest();
                    if (createAdRequest != null) {
                        createAdRequest.invokeADV(build);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[mq.mw splash] 请求失败:IMultiAdRequest为空");
                    appd.appe(QuMWMSplashProccesser.TAG, sb2.toString());
                    if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                        QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onNoAd(sb2.toString());
                    }
                }
            });
        } catch (Throwable th) {
            appd.appe(TAG, "[mq.mw splash] 加载错误:" + ((Object) th));
            if (checkProcessorBean()) {
                this.splashProcessorBean.getAdListener().onNoAd("[mq.mw splash] 加载错误:" + th.getMessage());
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
            if (this.splashProcessorBean != null) {
                this.splashProcessorBean.setAdListener(null);
                this.splashProcessorBean = null;
            }
        } catch (Throwable th) {
            appd.appe(TAG, "[mq.mw splash] onDestroy error:" + th);
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, String str2, String str3) {
    }

    @Override // appa.appa.appa.appa
    public void sendMaterialInformation(MaterialInformationBean materialInformationBean) {
        super.sendMaterialInformation(materialInformationBean);
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(String str, String str2) {
    }

    @Override // appa.appa.appe.apph
    public void show(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.mIMultiAdObject != null) {
                    if (checkProcessorBean()) {
                        this.splashProcessorBean.getAdListener().appa(appa.NOT_SUPPORT);
                    }
                    this.mIMultiAdObject.showSplashView(viewGroup, new IMultiAdObject.SplashEventListener() { // from class: com.wangmai.qumeng.processer.QuMWMSplashProccesser.2
                        @Override // com.hailiang.advlib.core.IMultiAdObject.SplashEventListener
                        public void onObClicked() {
                            if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                                QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onClick();
                            }
                        }

                        @Override // com.hailiang.advlib.core.IMultiAdObject.SplashEventListener
                        public void onObShow() {
                            if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                                QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onExposure();
                                QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().appa();
                            }
                        }

                        @Override // com.hailiang.advlib.core.IMultiAdObject.SplashEventListener
                        public void onObSkip() {
                            if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                                QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onAdDismissed();
                            }
                        }

                        @Override // com.hailiang.advlib.core.IMultiAdObject.SplashEventListener
                        public void onObTimeOver() {
                            appd.appa(QuMWMSplashProccesser.TAG, "onObTimeOver");
                            if (QuMWMSplashProccesser.this.checkProcessorBean()) {
                                QuMWMSplashProccesser.this.splashProcessorBean.getAdListener().onAdDismissed();
                            }
                        }
                    });
                    return;
                }
            } catch (Throwable th) {
                appd.appe(TAG, "[mq.mw splash] 展示失败：" + ((Object) th));
                if (checkProcessorBean()) {
                    this.splashProcessorBean.getAdListener().appa("[mq.mw splash] 展示失败:" + th.getMessage());
                    return;
                }
                return;
            }
        }
        appd.appe(TAG, "[mq.mw splash] 展示失败(IMultiAdObject或者splashContainer为空)");
        if (checkProcessorBean()) {
            this.splashProcessorBean.getAdListener().appa("[mq.mw splash] 展示失败(mIMultiAdObject或者splashContainer为空)");
        }
    }
}
