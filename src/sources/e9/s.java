package e9;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.agdpro.impl.reward.AgdRewardAd;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.huawei.appgallery.agd.base.api.DownloadStatus;
import com.huawei.appgallery.agd.base.util.DeepLinkUtils;
import com.huawei.appgallery.agd.core.api.CoreConstants;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.IAgdAd;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.core.internalapi.CoreApi;
import com.huawei.appgallery.agd.core.internalapi.OpenEventInfo;
import com.huawei.appgallery.agd.pageframe.api.AgdExposureInfo;
import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.huawei.appgallery.agd.pageframe.api.IPageCallback;
import com.huawei.appgallery.agd.pageframe.api.PageApi;
import com.huawei.appgallery.agd.serverreq.BuildConfig;
import com.huawei.appmarket.service.externalservice.distribution.download.request.PauseTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.ResumeTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import java.util.List;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class s implements IPageCallback {
    public final String a(int i10) {
        return i10 != -2 ? i10 != -1 ? i10 != 2 ? i10 != 8 ? i10 != 4 ? i10 != 5 ? "Other error" : "Download fail" : "Download success" : "Download interrupted" : "Install success" : "Install fail" : "Silent install fail";
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.IPageCallback
    public void onAppExposure(@NonNull AgdExposureInfo agdExposureInfo) {
        e eVar = e.f48945d;
        StringBuilder b4 = a.b("onAppExposure ");
        b4.append(agdExposureInfo.toString());
        eVar.i("PageCallbackImpl", b4.toString());
        eVar.i("EventReporter", "reportExposureEvent() called with: agdExposureInfo = [" + ((Object) agdExposureInfo) + "]");
        OpenEventInfo openEventInfo = new OpenEventInfo(1, agdExposureInfo.getLayoutId(), agdExposureInfo.getDetailIdList());
        openEventInfo.setReferrer(agdExposureInfo.getReferrer());
        CoreApi.reportEvent(agdExposureInfo.getSlotId(), openEventInfo);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.huawei.appgallery.agd.pageframe.api.IPageCallback
    public void onCardAction(@NonNull CardEventInfo cardEventInfo) {
        char c4;
        char c10;
        n nVar = new n();
        IAgdAd ad2 = AgdAdManager.getAd(cardEventInfo.uniqueId);
        if (ad2 == null) {
            e.f48945d.e("CardActionDispatcher", "dispatchCardEvent ad is empty");
            t.e(cardEventInfo, MaintKey.EVENT_AGD_GLOBAL_ERROR, "ad is empty", cardEventInfo.adWapUrl);
            if (!TextUtils.equals(cardEventInfo.type, "exposure")) {
                return;
            }
        }
        String str = cardEventInfo.type;
        str.hashCode();
        switch (str.hashCode()) {
            case -1926005497:
                if (str.equals("exposure")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -1641913779:
                if (str.equals(CardEventType.CLICK_ACTION_VIDEO_ERROR)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -1632258501:
                if (str.equals("videoPause")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -1313942207:
                if (str.equals(CardEventType.ACTION_TIME_OUT)) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case -1273977221:
                if (str.equals("openFastApp")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case -1267953720:
                if (str.equals("videoProgress")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case -1263202134:
                if (str.equals("openWeb")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case -1177422000:
                if (str.equals("openDeeplink")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case -934426579:
                if (str.equals("resume")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case -8778899:
                if (str.equals(CardEventType.CLICK_ACTION_CARD_BIND)) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case 3357525:
                if (str.equals(CardEventType.CLICK_ACTION_MORE)) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 3532159:
                if (str.equals("skip")) {
                    c4 = 11;
                    break;
                }
                c4 = 65535;
                break;
            case 94756344:
                if (str.equals("close")) {
                    c4 = '\f';
                    break;
                }
                c4 = 65535;
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c4 = CharUtils.CR;
                    break;
                }
                c4 = 65535;
                break;
            case 187958017:
                if (str.equals("openNative")) {
                    c4 = 14;
                    break;
                }
                c4 = 65535;
                break;
            case 660473070:
                if (str.equals(CardEventType.CLICK_ACTION_VIDEO_FINISH)) {
                    c4 = 15;
                    break;
                }
                c4 = 65535;
                break;
            case 884870824:
                if (str.equals("openAppDetail")) {
                    c4 = 16;
                    break;
                }
                c4 = 65535;
                break;
            case 1000390722:
                if (str.equals("videoReplay")) {
                    c4 = 17;
                    break;
                }
                c4 = 65535;
                break;
            case 1000489096:
                if (str.equals("videoResume")) {
                    c4 = 18;
                    break;
                }
                c4 = 65535;
                break;
            case 1332749620:
                if (str.equals("videoMute")) {
                    c4 = 19;
                    break;
                }
                c4 = 65535;
                break;
            case 1332829775:
                if (str.equals(CardEventType.CLICK_ACTION_VIDEO_PLAY)) {
                    c4 = 20;
                    break;
                }
                c4 = 65535;
                break;
            case 1957569947:
                if (str.equals("install")) {
                    c4 = 21;
                    break;
                }
                c4 = 65535;
                break;
            case 2125815379:
                if (str.equals("videoSoundOn")) {
                    c4 = 22;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                e eVar = e.f48945d;
                a.c("handleExpose with cardEventInfo: ", cardEventInfo, eVar, "CardActionDispatcher");
                String str2 = cardEventInfo.slotId;
                if (TextUtils.isEmpty(str2)) {
                    eVar.e("CardActionDispatcher", "slotId null, return");
                    break;
                } else {
                    AgdAdManager.putSlotIdAndAdId(str2, cardEventInfo.adId);
                    if (PageApi.getCallBack() == null) {
                        eVar.e("CardActionDispatcher", "callback null, return");
                        break;
                    } else {
                        AgdExposureInfo agdExposureInfo = new AgdExposureInfo();
                        agdExposureInfo.setLayoutId(cardEventInfo.layoutId);
                        agdExposureInfo.addDetailId(cardEventInfo.detailId);
                        agdExposureInfo.setSlotId(str2);
                        agdExposureInfo.setReferrer(str2);
                        PageApi.getCallBack().onAppExposure(agdExposureInfo);
                        break;
                    }
                }
            case 1:
                t.e(cardEventInfo, MaintKey.EVENT_VIDEO_START_PALY, "video play error", cardEventInfo.adVideoUrl);
                break;
            case 2:
                a.c("handleClickVideoPause with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                if (ad2 instanceof b) {
                    b bVar = (b) ad2;
                    if (bVar.d() != null) {
                        bVar.d().onVideoPause();
                    }
                }
                t.e(cardEventInfo, MaintKey.EVENT_VIDEO_PLAY_PAUSE, "", cardEventInfo.adVideoUrl);
                t.g(5, cardEventInfo);
                OperationBi.reportVideoViewAction("videoPause", nVar.a(ad2), cardEventInfo.slotId);
                break;
            case 3:
                a.c("handleActionTimeOut with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                t.c(10, cardEventInfo);
                break;
            case 4:
                e eVar2 = e.f48945d;
                a.c("handleClickOpenFastApp with clickInfo: ", cardEventInfo, eVar2, "CardActionDispatcher");
                Activity b4 = nVar.b(cardEventInfo);
                String str3 = cardEventInfo.adFastLink;
                if (!TextUtils.isEmpty(str3) && b4 != null) {
                    try {
                        nVar.g(cardEventInfo);
                        nVar.d("openFastApp", cardEventInfo);
                        Intent intent = new Intent();
                        intent.setData(Uri.parse(str3));
                        intent.setPackage("com.huawei.fastapp");
                        intent.setFlags(268435456);
                        b4.startActivity(intent);
                        t.e(cardEventInfo, MaintKey.EVENT_FAST_APP_START_ERROR, "", str3);
                        break;
                    } catch (Exception e2) {
                        a.b("handleClickOpenFastApp failed : ").append(e2.getMessage());
                        t.e(cardEventInfo, MaintKey.EVENT_FAST_APP_START_ERROR, e2.getMessage(), str3);
                        break;
                    }
                } else {
                    eVar2.e("CardActionDispatcher", "handleClickOpenFastApp fastAppLink or activity is null");
                    t.e(cardEventInfo, MaintKey.EVENT_FAST_APP_START_ERROR, "fastAppLink or activity is null", str3);
                    break;
                }
            case 5:
                a.c("handleClickVideoProgress with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                if (ad2 instanceof b) {
                    b bVar2 = (b) ad2;
                    if (bVar2.d() != null) {
                        bVar2.d().onVideoProgress(cardEventInfo.videoProgress, cardEventInfo.videoDuration);
                        break;
                    }
                }
                break;
            case 6:
                nVar.f(cardEventInfo);
                break;
            case 7:
            case '\n':
                e eVar3 = e.f48945d;
                a.c("handleClickOpenDeepLink with clickInfo: ", cardEventInfo, eVar3, "CardActionDispatcher");
                Activity b10 = nVar.b(cardEventInfo);
                if (!TextUtils.isEmpty(cardEventInfo.adDeeplink) && b10 != null) {
                    nVar.g(cardEventInfo);
                    t.e(cardEventInfo, MaintKey.EVENT_DEEPLINK_START_ERROR, DeepLinkUtils.jumpDeeplink(b10, cardEventInfo.adDeeplink) ? "" : "jump fail", cardEventInfo.adDeeplink);
                    nVar.d("openDeeplink", cardEventInfo);
                    break;
                } else {
                    eVar3.e("CardActionDispatcher", "handleClickOpenDeepLink deepLink or activity is null");
                    t.e(cardEventInfo, MaintKey.EVENT_DEEPLINK_START_ERROR, "deepLink is empty", cardEventInfo.adDeeplink);
                    break;
                }
            case '\b':
            case '\r':
            case 16:
            case 21:
                e eVar4 = e.f48945d;
                a.c("handleClickInstall with clickInfo: ", cardEventInfo, eVar4, "CardActionDispatcher");
                if (TextUtils.isEmpty(cardEventInfo.packageName)) {
                    eVar4.i("CardActionDispatcher", "handleClickInstall packageName is empty");
                    break;
                } else {
                    if (TextUtils.isEmpty(cardEventInfo.packageName)) {
                        eVar4.e("DownloadTask", "process packageName null");
                    } else if (cardEventInfo.flContext.getActivity() == null) {
                        eVar4.e("DownloadTask", "process activity null");
                    } else {
                        a.d(a.b("dealDownloadClick type: "), cardEventInfo.type, eVar4, "DownloadTask");
                        String str4 = cardEventInfo.type;
                        str4.hashCode();
                        switch (str4.hashCode()) {
                            case -934426579:
                                if (str4.equals("resume")) {
                                    c10 = 0;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 106440182:
                                if (str4.equals("pause")) {
                                    c10 = 1;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 884870824:
                                if (str4.equals("openAppDetail")) {
                                    c10 = 2;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 1957569947:
                                if (str4.equals("install")) {
                                    c10 = 3;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            default:
                                c10 = 65535;
                                break;
                        }
                        switch (c10) {
                            case 0:
                                ResumeTaskIPCRequest resumeTaskIPCRequest = new ResumeTaskIPCRequest();
                                resumeTaskIPCRequest.setPackageName(cardEventInfo.packageName);
                                AgdManager.resumeTask(cardEventInfo.flContext.getActivity(), resumeTaskIPCRequest, cardEventInfo.slotId, AgdManager.SOURCE_AGD_PRO);
                                break;
                            case 1:
                                PauseTaskIPCRequest pauseTaskIPCRequest = new PauseTaskIPCRequest();
                                pauseTaskIPCRequest.setPackageName(cardEventInfo.packageName);
                                AgdManager.pauseTask(cardEventInfo.flContext.getActivity(), pauseTaskIPCRequest, cardEventInfo.slotId, AgdManager.SOURCE_AGD_PRO);
                                break;
                            case 2:
                            case 3:
                                AgdAdManager.putPackNameAndAdId(cardEventInfo.packageName, cardEventInfo.uniqueId);
                                a.d(a.b("download appName is: "), cardEventInfo.packageName, eVar4, "DownloadTask");
                                StringBuilder b11 = a.b("download downloadFlag is: ");
                                b11.append(cardEventInfo.downloadFlag);
                                b11.append(", installType ");
                                a.d(b11, cardEventInfo.installType, eVar4, "DownloadTask");
                                StringBuilder b12 = a.b("downloadParams is: ");
                                b12.append(cardEventInfo.downloadParams);
                                eVar4.d("DownloadTask", b12.toString());
                                StartDownloadV2IPCRequest startDownloadV2IPCRequest = new StartDownloadV2IPCRequest();
                                startDownloadV2IPCRequest.setSupportFunction(1);
                                startDownloadV2IPCRequest.setPackageName(cardEventInfo.packageName);
                                startDownloadV2IPCRequest.setInstallType(cardEventInfo.installType);
                                startDownloadV2IPCRequest.setDownloadFlag(cardEventInfo.downloadFlag);
                                startDownloadV2IPCRequest.setDownloadParams(cardEventInfo.downloadParams);
                                startDownloadV2IPCRequest.setReferrer(cardEventInfo.slotId);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(CoreConstants.AGD_PRO_VER, BuildConfig.VERSION_CODE);
                                    jSONObject.put(CoreConstants.MEDIA_PKG_SIGN, AgdAdManager.getConfig().getMediaPkgSign());
                                } catch (JSONException unused) {
                                    e.f48945d.e("DownloadTask", "put agd pro version code fail");
                                }
                                startDownloadV2IPCRequest.setJsonData(jSONObject.toString());
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("name", cardEventInfo.appName);
                                    jSONObject2.put("icon", cardEventInfo.iconUri);
                                } catch (JSONException unused2) {
                                    e.f48945d.e("DownloadTask", "appInfo JSONException ");
                                }
                                startDownloadV2IPCRequest.setAppInfo(jSONObject2.toString());
                                startDownloadV2IPCRequest.setMediaPkg(AgdAdManager.getConfig().getMediaPkgName());
                                AgdManager.startDownloadTaskV2(cardEventInfo.flContext.getActivity(), startDownloadV2IPCRequest, cardEventInfo.slotId, cardEventInfo.layoutId, AgdManager.SOURCE_AGD_PRO);
                                break;
                        }
                    }
                    nVar.g(cardEventInfo);
                    if (!TextUtils.isEmpty(cardEventInfo.type) && cardEventInfo.type.equals("openAppDetail")) {
                        nVar.d("openAppDetail", cardEventInfo);
                        break;
                    } else {
                        nVar.d(OperationBi.CLICK_TYPE_INSTALL, cardEventInfo);
                        break;
                    }
                }
                break;
            case '\t':
                MaintBi.report(new MaintData.Builder(MaintKey.EVENT_QUICK_CARD_BIND).setSlotId(cardEventInfo.slotId).setUniqueId(cardEventInfo.uniqueId).setInstallType(cardEventInfo.installType).setAdId(cardEventInfo.adId).setLayoutName(cardEventInfo.layoutId).setTaskPackageName(cardEventInfo.packageName).setTotalTime(nVar.a(ad2)).build());
                break;
            case 11:
                a.c("handleClickSkip with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                nVar.d("skip", cardEventInfo);
                t.c(9, cardEventInfo);
                break;
            case '\f':
                a.c("handleClickClose with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                if (ad2 instanceof b) {
                    b bVar3 = (b) ad2;
                    if (bVar3.a() != null) {
                        bVar3.a().onDislikeClick();
                        t.c(8, cardEventInfo);
                        break;
                    }
                }
                if (!(ad2 instanceof AgdRewardAd)) {
                    MaintBi.reportAdClose(cardEventInfo.slotId, cardEventInfo.uniqueId, cardEventInfo.adId);
                    t.c(8, cardEventInfo);
                    OperationBi.reportAdCallBackOperate("close", cardEventInfo.slotId);
                    break;
                }
                break;
            case 14:
                e eVar5 = e.f48945d;
                a.c("handleClickOpenNative with clickInfo: ", cardEventInfo, eVar5, "CardActionDispatcher");
                Activity b13 = nVar.b(cardEventInfo);
                String str5 = cardEventInfo.packageName;
                if (!TextUtils.isEmpty(str5) && b13 != null) {
                    Intent launchIntentForPackage = b13.getPackageManager().getLaunchIntentForPackage(str5);
                    if (launchIntentForPackage == null) {
                        eVar5.e("CardActionDispatcher", "handleClickOpenNative intent is null, return pkgName " + str5);
                        t.e(cardEventInfo, MaintKey.EVENT_NATIVE_APP_START_ERROR, "intent is null", cardEventInfo.packageName);
                        break;
                    } else {
                        nVar.g(cardEventInfo);
                        nVar.d("openNative", cardEventInfo);
                        launchIntentForPackage.addFlags(268435456);
                        try {
                            b13.startActivity(launchIntentForPackage);
                            t.e(cardEventInfo, MaintKey.EVENT_NATIVE_APP_START_ERROR, "", cardEventInfo.packageName);
                            break;
                        } catch (Exception e10) {
                            e.f48945d.e("CardActionDispatcher", "handleClickOpenNative failed " + str5);
                            t.e(cardEventInfo, MaintKey.EVENT_NATIVE_APP_START_ERROR, e10.getMessage(), cardEventInfo.packageName);
                            break;
                        }
                    }
                } else {
                    eVar5.e("CardActionDispatcher", "handleClickOpenNative pkgName or activity is null");
                    t.e(cardEventInfo, MaintKey.EVENT_NATIVE_APP_START_ERROR, "pkgName or activity is null", cardEventInfo.packageName);
                    break;
                }
            case 15:
                a.c("handleClickVideoFinish with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                if (ad2 instanceof b) {
                    b bVar4 = (b) ad2;
                    if (bVar4.d() != null) {
                        bVar4.d().onVideoComplete();
                    }
                }
                t.e(cardEventInfo, MaintKey.EVENT_VIDEO_PLAY_COMPLETED, "", cardEventInfo.adVideoUrl);
                t.g(7, cardEventInfo);
                OperationBi.reportVideoViewAction(OperationBi.ACTION_VIDEO_COMPLETE, nVar.a(ad2), cardEventInfo.slotId);
                break;
            case 17:
                a.c("handleClickVideoReplay with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                if (ad2 instanceof b) {
                    b bVar5 = (b) ad2;
                    if (bVar5.d() != null) {
                        bVar5.d().onVideoRenew();
                    }
                }
                OperationBi.reportVideoViewAction("videoReplay", nVar.a(ad2), cardEventInfo.slotId);
                break;
            case 18:
                a.c("handleClickVideoResume with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                if (ad2 instanceof b) {
                    b bVar6 = (b) ad2;
                    if (bVar6.d() != null) {
                        bVar6.d().onVideoResume();
                    }
                }
                t.e(cardEventInfo, MaintKey.EVENT_VIDEO_PLAY_RESUME, "", cardEventInfo.adVideoUrl);
                t.g(6, cardEventInfo);
                OperationBi.reportVideoViewAction("videoResume", nVar.a(ad2), cardEventInfo.slotId);
                break;
            case 19:
                a.c("handleClickMute with cardEventInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                OperationBi.reportVideoViewAction("videoMute", nVar.a(ad2), cardEventInfo.slotId);
                break;
            case 20:
                a.c("handleClickVideoPlay with clickInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                if (ad2 instanceof b) {
                    b bVar7 = (b) ad2;
                    if (bVar7.d() != null) {
                        bVar7.d().onVideoStart();
                    }
                }
                MaintBi.report(new MaintData.Builder(MaintKey.EVENT_VIDEO_START_PALY).setSlotId(cardEventInfo.slotId).setUniqueId(cardEventInfo.uniqueId).setInstallType(cardEventInfo.installType).setAdId(cardEventInfo.adId).setLayoutName(cardEventInfo.layoutId).setTaskPackageName(cardEventInfo.packageName).setUri(cardEventInfo.adVideoUrl).setTotalTime(nVar.a(ad2)).build());
                t.g(4, cardEventInfo);
                OperationBi.reportVideoViewAction(OperationBi.ACTION_VIDEO_START, nVar.a(ad2), cardEventInfo.slotId);
                break;
            case 22:
                a.c("handleClickSoundOn with cardEventInfo: ", cardEventInfo, e.f48945d, "CardActionDispatcher");
                OperationBi.reportVideoViewAction("videoSoundOn", nVar.a(ad2), cardEventInfo.slotId);
                break;
        }
        if (ad2 != null) {
            if (ad2 instanceof l) {
                ((l) ad2).i(cardEventInfo);
                return;
            }
            if (ad2 instanceof AgdRewardAd) {
                ((AgdRewardAd) ad2).i().onCardEvent(cardEventInfo);
                return;
            }
            if (ad2 instanceof i) {
                ((i) ad2).e(cardEventInfo);
                return;
            }
            e eVar6 = e.f48945d;
            StringBuilder b14 = a.b("dispatchToAd failed, type ");
            b14.append(cardEventInfo.type);
            b14.append(" ");
            b14.append(cardEventInfo.uniqueId);
            eVar6.e("CardActionDispatcher", b14.toString());
        }
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.IPageCallback
    public void onStatusChange(@NonNull DownloadStatus downloadStatus) {
        if (TextUtils.isEmpty(downloadStatus.packageName)) {
            e.f48945d.e("PageCallbackImpl", "onStatusChange: packageName is null");
            return;
        }
        e eVar = e.f48945d;
        eVar.i("PageCallbackImpl", "onStatusChange: " + ((Object) downloadStatus));
        List<IAgdAd> adListByPackage = AgdAdManager.getAdListByPackage(downloadStatus.packageName);
        if (adListByPackage != null && adListByPackage.size() != 0) {
            for (IAgdAd iAgdAd : adListByPackage) {
                if (iAgdAd != null && (iAgdAd instanceof b)) {
                    String slotId = iAgdAd.getAdSlot().getSlotId();
                    e.f48945d.i("PageCallbackImpl", "onStatusChange: slotId: " + slotId);
                    b bVar = (b) iAgdAd;
                    if (bVar.b() != null) {
                        bVar.b().onDownloadStatus(downloadStatus);
                    }
                    int agAppStatus = downloadStatus.getAgAppStatus();
                    int i10 = downloadStatus.status;
                    if (i10 == 6 || i10 == 7 || i10 == 2) {
                        MaintBi.reportAgdDownloadFail(a(agAppStatus), downloadStatus.packageName, slotId);
                    } else if (i10 == 5 || i10 == 4) {
                        MaintBi.reportAgdAppInstallFail(a(agAppStatus), downloadStatus.packageName, slotId);
                    }
                }
            }
            return;
        }
        eVar.e("PageCallbackImpl", "onAppInstallState templateAd is empty");
    }
}
