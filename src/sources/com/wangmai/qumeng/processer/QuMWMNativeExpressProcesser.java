package com.wangmai.qumeng.processer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import appa.appa.appe.appc;
import appa.appa.appf.appd;
import com.hailiang.advlib.api.AiClkAdManager;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.AppInformation;
import com.hailiang.advlib.core.IMultiAdObject;
import com.hailiang.advlib.core.IMultiAdRequest;
import com.wangmai.bean.ExpressProcessorBean;
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
public class QuMWMNativeExpressProcesser extends appc {
    private static final String TAG = "QuMNativeExpressProc";
    private ExpressProcessorBean expressProcessorBean;
    private IMultiAdObject mIMultiAdObject;

    public QuMWMNativeExpressProcesser(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(ViewGroup viewGroup) {
        IMultiAdObject iMultiAdObject = this.mIMultiAdObject;
        if (iMultiAdObject != null) {
            iMultiAdObject.bindView(viewGroup, new IMultiAdObject.ADEventListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativeExpressProcesser.2
                @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
                public void onADExposed() {
                    if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                        QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onExposure();
                        QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().appa();
                    }
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
                public void onAdClick() {
                    if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                        QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onClick();
                    }
                }

                @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
                public void onAdFailed(String str) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[mq.mw native express] 渲染失败:");
                    sb2.append(str);
                    appd.appe(QuMWMNativeExpressProcesser.TAG, sb2.toString());
                    if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                        QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().appa(sb2.toString());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildMaterialInformation() {
        try {
            int nextInt = new Random().nextInt(10000);
            appd.appa(TAG, "本次采集概率阈值：" + nextInt);
            if (!checkProcessorBean() || nextInt > this.expressProcessorBean.getMaterialCollectRand()) {
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
            MaterialInformationBean materialInformationBean = new MaterialInformationBean(this.expressProcessorBean.getRequestId(), this.expressProcessorBean.getMediaAdSlotId(), this.expressProcessorBean.getDemandPlatformId(), this.expressProcessorBean.getSlotId());
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
        ExpressProcessorBean expressProcessorBean = this.expressProcessorBean;
        return (expressProcessorBean == null || expressProcessorBean.getAdListener() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setADStateListener() {
        IMultiAdObject iMultiAdObject = this.mIMultiAdObject;
        if (iMultiAdObject != null) {
            iMultiAdObject.setADStateListener(new IMultiAdObject.ADStateListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativeExpressProcesser.3
                @Override // com.hailiang.advlib.core.IMultiAdObject.ADStateListener
                public void onAdEvent(int i10, Bundle bundle) {
                    if (i10 == 2 && QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                        QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onAdClose();
                    }
                }
            });
        }
    }

    @Override // appa.appa.appe.appc
    public void nativeExpressAd(final ExpressProcessorBean expressProcessorBean) {
        try {
            appd.appa(TAG, "[mq.mw native express] load appId:" + expressProcessorBean.getAppId(), "slotId:" + expressProcessorBean.getSlotId());
            this.expressProcessorBean = expressProcessorBean;
            QuMengSdkInitHelper.getInstance().init(getApplicationContext(), expressProcessorBean.getAppId(), new IWMCommonListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativeExpressProcesser.1
                @Override // com.wangmai.common.Ilistener.IWMCommonListener
                public void fail(String str) {
                    appd.appe(QuMWMNativeExpressProcesser.TAG, str);
                    if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                        QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd(str);
                    }
                }

                @Override // com.wangmai.common.Ilistener.IWMCommonListener
                public void success() {
                    AdRequestParam build = new AdRequestParam.Builder().adslotID(expressProcessorBean.getSlotId()).adType(3).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.wangmai.qumeng.processer.QuMWMNativeExpressProcesser.1.1
                        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
                        public void onADLoaded(IMultiAdObject iMultiAdObject) {
                            if (iMultiAdObject == null) {
                                if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                                    QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd("[mq.mw native express] 暂无填充");
                                    return;
                                }
                                return;
                            }
                            QuMWMNativeExpressProcesser.this.mIMultiAdObject = iMultiAdObject;
                            QuMWMNativeExpressProcesser quMWMNativeExpressProcesser = QuMWMNativeExpressProcesser.this;
                            quMWMNativeExpressProcesser.setDspPrice(quMWMNativeExpressProcesser.mIMultiAdObject.getECPM());
                            appd.appa(QuMWMNativeExpressProcesser.TAG, "[mq.mw native express] 加载成功，ecpm=" + QuMWMNativeExpressProcesser.this.getDspPrice());
                            ViewGroup adsParent = QuMWMNativeExpressProcesser.this.checkProcessorBean() ? QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdsParent() : null;
                            if (adsParent != null) {
                                QuMWMNativeExpressProcesser.this.bindView(adsParent);
                                if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                                    QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onRenderSuccess(adsParent, 0, 0);
                                    QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onAdRequest();
                                }
                                QuMWMNativeExpressProcesser.this.setADStateListener();
                            } else {
                                appd.appe(QuMWMNativeExpressProcesser.TAG, "[mq.mw native express] 加载失败 adTemplateContent为空");
                                if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                                    QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd("[mq.mw native express] 加载失败 adTemplateContent为空");
                                }
                            }
                            QuMWMNativeExpressProcesser.this.buildMaterialInformation();
                        }

                        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
                        public void onAdFailed(String str) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[mq.mw native express] 请求失败(onAdFailed):");
                            sb2.append(str);
                            appd.appe(QuMWMNativeExpressProcesser.TAG, sb2.toString());
                            if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                                QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd(sb2.toString());
                            }
                        }
                    }).build();
                    IMultiAdRequest createAdRequest = AiClkAdManager.getInstance().createAdRequest();
                    if (createAdRequest != null) {
                        createAdRequest.invokeADV(build);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[mq.mw native express] 请求失败:IMultiAdRequest为空");
                    appd.appe(QuMWMNativeExpressProcesser.TAG, sb2.toString());
                    if (QuMWMNativeExpressProcesser.this.checkProcessorBean()) {
                        QuMWMNativeExpressProcesser.this.expressProcessorBean.getAdListener().onNoAd(sb2.toString());
                    }
                }
            });
        } catch (Throwable th) {
            appd.appe(TAG, "[mq.mw native express] 加载错误:" + ((Object) th));
            if (checkProcessorBean()) {
                this.expressProcessorBean.getAdListener().onNoAd("[mq.mw native express] 加载错误:" + th.getMessage());
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
            if (this.expressProcessorBean != null) {
                this.expressProcessorBean.setAdListener(null);
                this.expressProcessorBean = null;
            }
        } catch (Throwable th) {
            appd.appe(TAG, "[mq.mw native express] onDestroy error:" + th);
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
