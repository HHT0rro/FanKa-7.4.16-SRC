package com.wangmai.qumeng.processer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import appa.appa.appb.appa;
import appa.appa.appe.appg;
import appa.appa.appf.appd;
import com.hailiang.advlib.api.AiClkAdManager;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.AppInformation;
import com.hailiang.advlib.core.IMultiAdObject;
import com.hailiang.advlib.core.IMultiAdRequest;
import com.wangmai.bean.RewardVideoProcessorBean;
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
public class QuMWMRewardVideoProcesser extends appg {
    private static final String TAG = "QuMRewardProcesser";
    IMultiAdObject mIMultiAdObject;
    private RewardVideoProcessorBean rewardVideoProcessorBean;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class QMADRewardVideoListener implements AdRequestParam.ADRewardVideoListener {
        QMADRewardVideoListener() {
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public void onAdClick(Bundle bundle) {
            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onClick();
            }
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public void onAdClose(Bundle bundle) {
            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onAdClose();
            }
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public void onAdShow(Bundle bundle) {
            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onExposure();
                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().appa();
            }
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public void onReward(Bundle bundle) {
            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onRewarded(true, bundle);
            }
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public void onSkippedVideo(Bundle bundle) {
            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onAdClose();
            }
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public void onVideoComplete(Bundle bundle) {
            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onVideoComplete();
            }
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADRewardVideoListener
        public void onVideoError(Bundle bundle) {
            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onVideoError("播放失败");
            }
        }
    }

    public QuMWMRewardVideoProcesser(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildMaterialInformation() {
        try {
            int nextInt = new Random().nextInt(10000);
            appd.appa(TAG, "本次采集概率阈值：" + nextInt);
            if (!checkProcessorBean() || nextInt > this.rewardVideoProcessorBean.getMaterialCollectRand()) {
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
            MaterialInformationBean materialInformationBean = new MaterialInformationBean(this.rewardVideoProcessorBean.getRequestId(), this.rewardVideoProcessorBean.getMediaAdSlotId(), this.rewardVideoProcessorBean.getDemandPlatformId(), this.rewardVideoProcessorBean.getSlotId());
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
        RewardVideoProcessorBean rewardVideoProcessorBean = this.rewardVideoProcessorBean;
        return (rewardVideoProcessorBean == null || rewardVideoProcessorBean.getAdListener() == null) ? false : true;
    }

    @Override // appa.appa.appe.appg
    public void absReward(final RewardVideoProcessorBean rewardVideoProcessorBean) {
        try {
            appd.appa(TAG, "[mq.mw reward] load appId:" + rewardVideoProcessorBean.getAppId(), "slotId:" + rewardVideoProcessorBean.getSlotId());
            this.rewardVideoProcessorBean = rewardVideoProcessorBean;
            QuMengSdkInitHelper.getInstance().init(getApplicationContext(), rewardVideoProcessorBean.getAppId(), new IWMCommonListener() { // from class: com.wangmai.qumeng.processer.QuMWMRewardVideoProcesser.1
                @Override // com.wangmai.common.Ilistener.IWMCommonListener
                public void fail(String str) {
                    appd.appe(QuMWMRewardVideoProcesser.TAG, str);
                    if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                        QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onNoAd(str);
                    }
                }

                @Override // com.wangmai.common.Ilistener.IWMCommonListener
                public void success() {
                    AdRequestParam build = new AdRequestParam.Builder().adslotID(rewardVideoProcessorBean.getSlotId()).adType(4).adLoadListener(new AdRequestParam.ADLoadListener() { // from class: com.wangmai.qumeng.processer.QuMWMRewardVideoProcesser.1.1
                        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
                        public void onADLoaded(IMultiAdObject iMultiAdObject) {
                            if (iMultiAdObject == null) {
                                if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                                    QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onNoAd("[mq.mw reward] 暂无填充");
                                    return;
                                }
                                return;
                            }
                            QuMWMRewardVideoProcesser quMWMRewardVideoProcesser = QuMWMRewardVideoProcesser.this;
                            quMWMRewardVideoProcesser.mIMultiAdObject = iMultiAdObject;
                            quMWMRewardVideoProcesser.setDspPrice(quMWMRewardVideoProcesser.mIMultiAdObject.getECPM());
                            appd.appa(QuMWMRewardVideoProcesser.TAG, "[mq.mw reward] 加载成功，ecpm=" + QuMWMRewardVideoProcesser.this.getDspPrice());
                            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onAdRequest();
                                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onAdLoad();
                            }
                            QuMWMRewardVideoProcesser.this.buildMaterialInformation();
                        }

                        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
                        public void onAdFailed(String str) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[mq.mw reward] 请求失败(onAdFailed):");
                            sb2.append(str);
                            appd.appe(QuMWMRewardVideoProcesser.TAG, sb2.toString());
                            if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                                QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onNoAd(sb2.toString());
                            }
                        }
                    }).build();
                    IMultiAdRequest createAdRequest = AiClkAdManager.getInstance().createAdRequest();
                    if (createAdRequest != null) {
                        createAdRequest.invokeADV(build);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[mq.mw reward] 请求失败:IMultiAdRequest为空");
                    appd.appe(QuMWMRewardVideoProcesser.TAG, sb2.toString());
                    if (QuMWMRewardVideoProcesser.this.checkProcessorBean()) {
                        QuMWMRewardVideoProcesser.this.rewardVideoProcessorBean.getAdListener().onNoAd(sb2.toString());
                    }
                }
            });
        } catch (Throwable th) {
            appd.appe(TAG, "[mq.mw reward] 加载错误:" + ((Object) th));
            if (checkProcessorBean()) {
                this.rewardVideoProcessorBean.getAdListener().onNoAd("[mq.mw reward] 加载错误:" + th.getMessage());
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
            if (this.rewardVideoProcessorBean != null) {
                this.rewardVideoProcessorBean.setAdListener(null);
                this.rewardVideoProcessorBean = null;
            }
        } catch (Throwable th) {
            appd.appe(TAG, "[mq.mw reward] onDestroy error:" + th);
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

    @Override // appa.appa.appe.appg
    public void show(Context context) {
        try {
            if (this.mIMultiAdObject != null) {
                if (checkProcessorBean()) {
                    this.rewardVideoProcessorBean.getAdListener().appa(appa.NOT_READY);
                }
                if (context != null && (context instanceof Activity)) {
                    this.mIMultiAdObject.showRewardVideo((Activity) context, new QMADRewardVideoListener());
                    return;
                }
                if (getTaskTopActivity() != null && getTaskTopActivity().get() != null) {
                    this.mIMultiAdObject.showRewardVideo(getTaskTopActivity().get(), new QMADRewardVideoListener());
                    return;
                }
                appd.appe(TAG, "[mq.mw reward] 展示失败(Context为空或不是Activity实例)");
                if (checkProcessorBean()) {
                    this.rewardVideoProcessorBean.getAdListener().appa("[mq.mw reward] 展示失败(Context为空或不是Activity实例)");
                    return;
                }
                return;
            }
            appd.appe(TAG, "[mq.mw reward] 展示失败(IMultiAdObject为空)");
            if (checkProcessorBean()) {
                this.rewardVideoProcessorBean.getAdListener().appa(appa.NOT_READY);
                this.rewardVideoProcessorBean.getAdListener().appa("展示失败(IMultiAdObject为空)");
            }
        } catch (Throwable th) {
            appd.appe(TAG, "[mq.mw reward] 展示失败：" + ((Object) th));
            if (checkProcessorBean()) {
                this.rewardVideoProcessorBean.getAdListener().appa("[mq.mw reward] 展示失败:" + th.getMessage());
            }
        }
    }
}
