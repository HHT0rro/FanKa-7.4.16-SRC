package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static Random azS = new Random();

    public static int a(boolean z10, @NonNull AdInfo adInfo) {
        return (z10 ? adInfo.adMatrixInfo.adDataV2.neoTKInfo : adInfo.adMatrixInfo.adDataV2.fullScreenInfo).renderType;
    }

    @Nullable
    private static String cA(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, e.dQ(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static String cB(@NonNull AdTemplate adTemplate) {
        if (cC(adTemplate)) {
            return cA(adTemplate);
        }
        return a.aS(e.dQ(adTemplate));
    }

    private static boolean cC(@NonNull AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || a.bZ(adTemplate) || !dj(e.dQ(adTemplate))) ? false : true;
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo cD(@NonNull AdTemplate adTemplate) {
        if (cE(adTemplate)) {
            return cc(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo;
        }
        return cc(adTemplate).adDataV2.feedInfo;
    }

    private static boolean cE(@NonNull AdTemplate adTemplate) {
        return a.cL(e.dQ(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo cF(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    public static String cG(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cD(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    private static AdMatrixInfo.FeedTKInfo cH(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.feedTKCardInfo;
    }

    @Nullable
    public static String cI(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cF(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    @Nullable
    public static boolean cJ(@NonNull AdTemplate adTemplate) {
        return cD(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    @Nullable
    public static boolean cK(@NonNull AdTemplate adTemplate) {
        return cD(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    public static int cL(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cD(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    public static double cM(@NonNull AdTemplate adTemplate) {
        return e.dQ(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean cN(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cG(adTemplate));
    }

    public static boolean cO(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cH(adTemplate).templateId);
    }

    public static String cP(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo cH = cH(adTemplate);
        return TextUtils.isEmpty(cH.templateId) ? "ksad-feed-card" : cH.templateId;
    }

    public static boolean cQ(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cI(adTemplate));
    }

    public static float cR(@NonNull AdTemplate adTemplate) {
        int i10;
        try {
            i10 = e.dQ(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            i10 = 7;
        }
        if (i10 > 0) {
            return i10;
        }
        return 7.0f;
    }

    public static boolean cS(@NonNull AdTemplate adTemplate) {
        try {
            return e.dQ(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return false;
        }
    }

    public static float cT(@NonNull AdTemplate adTemplate) {
        int i10;
        try {
            i10 = e.dQ(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            i10 = 7;
        }
        return i10;
    }

    public static AdMatrixInfo.RotateInfo cU(@NonNull AdTemplate adTemplate) {
        try {
            return e.dQ(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return null;
        }
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate cV(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.complianceCardInfo;
    }

    @Nullable
    public static String cW(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cV(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static boolean cX(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cW(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate cY(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    public static String cZ(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cY(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    @NonNull
    public static AdMatrixInfo cc(@NonNull AdTemplate adTemplate) {
        if (e.dI(adTemplate)) {
            return e.dQ(adTemplate).adMatrixInfo;
        }
        return new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cd(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).styles.templateList;
    }

    @NonNull
    public static AdMatrixInfo.AdDataV2 ce(@NonNull AdTemplate adTemplate) {
        return e.dQ(adTemplate).adMatrixInfo.adDataV2;
    }

    public static FeedSlideConf cf(@NonNull AdTemplate adTemplate) {
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData l10 = l(adTemplate, cD(adTemplate).templateId);
        try {
            JSONObject optJSONObject = new JSONObject(l10 != null ? l10.data : "").optJSONObject("slideInfo");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("angle")) != null && optJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean cg(@NonNull AdTemplate adTemplate) {
        return n(adTemplate, ch(adTemplate).templateId);
    }

    @NonNull
    private static AdMatrixInfo.InterstitialCardInfo ch(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    public static String ci(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cc(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.ActionBarInfoNew cj(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.actionBarInfo;
    }

    @Nullable
    public static String ck(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        int dK = e.dK(adTemplate);
        boolean z10 = dK == 3 || dK == 2;
        if (a.cL(dQ)) {
            return "";
        }
        if (z10 && a.cb(adTemplate)) {
            AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, db(adTemplate).templateId);
            return k10 != null ? k10.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate k11 = k(adTemplate, cj(adTemplate).templateId);
        return k11 != null ? k11.templateUrl : "";
    }

    public static long cl(@NonNull AdTemplate adTemplate) {
        return cj(adTemplate).maxTimeOut;
    }

    public static boolean cm(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(ck(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.AggregationCardInfo cn(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.aggregationCardInfo;
    }

    @Nullable
    public static String co(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cn(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static long cp(@NonNull AdTemplate adTemplate) {
        return m(adTemplate, cn(adTemplate).templateId);
    }

    public static long cq(@NonNull AdTemplate adTemplate) {
        return cn(adTemplate).changeTime * 1000;
    }

    public static int cr(@NonNull AdTemplate adTemplate) {
        return cn(adTemplate).maxTimesPerDay;
    }

    public static long cs(@NonNull AdTemplate adTemplate) {
        return cn(adTemplate).intervalTime;
    }

    public static boolean ct(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        return !a.aF(dQ) && a.at(dQ);
    }

    public static boolean cu(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(co(adTemplate)) && cp(adTemplate) > 0) {
            return ai.isOrientationPortrait();
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate cv(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    public static String cw(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cv(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.EndCardInfo cx(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.endCardInfo;
    }

    @Nullable
    public static String cy(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cx(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static boolean cz(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cy(adTemplate));
    }

    public static boolean dA(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean dB(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean dC(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean dD(@NonNull AdInfo adInfo) {
        try {
            int i10 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
            return i10 == 4 || i10 == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dE(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean dF(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static long dG(@NonNull AdInfo adInfo) {
        try {
            long j10 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j10 <= 0) {
                return 1500L;
            }
            return j10;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean dH(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static float dI(@NonNull AdInfo adInfo) {
        int i10;
        try {
            i10 = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            i10 = 7;
        }
        return i10;
    }

    public static float dJ(@NonNull AdInfo adInfo) {
        int i10;
        try {
            i10 = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            i10 = 7;
        }
        return i10;
    }

    public static String dK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String dL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String dM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String dN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts dO(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts dP(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean dQ(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean dR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static boolean dS(@NonNull AdInfo adInfo) {
        return (a.bH(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) ? false : true;
    }

    public static int dT(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String dU(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static boolean dV(@NonNull AdInfo adInfo) {
        return a.bd(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId);
    }

    public static boolean da(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cZ(adTemplate));
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo db(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo dc(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dd(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static boolean de(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean df(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dg(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean dh(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean di(@NonNull AdInfo adInfo) {
        if (dj(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dj(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dk(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static long dl(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dm(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dn(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    /* renamed from: do, reason: not valid java name */
    public static boolean m2865do(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static String dp(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.cutIconUrl;
    }

    public static String dq(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.refreshIconUrl;
    }

    public static String dr(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.convertIconUrl;
    }

    public static int ds(@NonNull AdInfo adInfo) {
        try {
            int i10 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i10 != 2) {
                return 1;
            }
            return i10;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return 1;
        }
    }

    public static boolean dt(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    public static boolean du(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int dv(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int dw(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean dx(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean dy(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean dz(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean ep(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).bW(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || a.cR(adInfo) || a.bH(adInfo)) ? false : true;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate k(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : cc(adTemplate).styles.templateList) {
            if (bg.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @Nullable
    private static AdMatrixInfo.TemplateData l(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : cc(adTemplate).adDataV2.templateDataList) {
            if (bg.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long m(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData l10 = l(adTemplate, str);
        if (l10 != null) {
            return l10.templateDelayTime;
        }
        return 0L;
    }

    private static boolean n(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData l10 = l(adTemplate, str);
        try {
            JSONObject optJSONObject = new JSONObject(l10 != null ? l10.data : "").optJSONObject("autoCallAppInfo");
            if (optJSONObject != null) {
                return !TextUtils.isEmpty(optJSONObject.optString("adTitle"));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String dA(AdTemplate adTemplate) {
        return ce(adTemplate).feedTKCardInfo.templateId;
    }

    public static long de(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int df(@NonNull AdTemplate adTemplate) {
        return cc(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static boolean dg(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        if (g(dQ) || e.ec(adTemplate)) {
            return false;
        }
        return !(cj(adTemplate).cardType == 4) && e.dQ(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && dQ.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean dh(AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        if (g(dQ) || e.ec(adTemplate)) {
            return false;
        }
        return ((cj(adTemplate).cardType == 4) || e.dQ(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || dQ.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static boolean dj(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static long dk(@NonNull AdTemplate adTemplate) {
        long j10 = ce(adTemplate).installedActivateInfo.showTime;
        if (j10 > 0) {
            return j10;
        }
        return 0L;
    }

    public static String dl(AdTemplate adTemplate) {
        return ce(adTemplate).topFloorTKInfo.templateId;
    }

    public static String dm(AdTemplate adTemplate) {
        return ce(adTemplate).neoTKInfo.templateId;
    }

    public static String dn(AdTemplate adTemplate) {
        return ce(adTemplate).videoLiveTKInfo.templateId;
    }

    /* renamed from: do, reason: not valid java name */
    public static String m2864do(AdTemplate adTemplate) {
        return ce(adTemplate).videoImageTKInfo.templateId;
    }

    public static String dp(AdTemplate adTemplate) {
        return ce(adTemplate).fullScreenInfo.templateId;
    }

    public static String dq(AdTemplate adTemplate) {
        return ce(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String dr(AdTemplate adTemplate) {
        return ce(adTemplate).splashPlayCardTKInfo.templateId;
    }

    public static String dt(AdTemplate adTemplate) {
        return ce(adTemplate).interstitialCardInfo.templateId;
    }

    public static String du(AdTemplate adTemplate) {
        return ce(adTemplate).confirmTKInfo.templateId;
    }

    public static String dv(AdTemplate adTemplate) {
        return ce(adTemplate).activityTKInfo.templateId;
    }

    public static String dw(AdTemplate adTemplate) {
        return ce(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String dx(AdTemplate adTemplate) {
        return ce(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String dy(AdTemplate adTemplate) {
        return ce(adTemplate).pushTKInfo.templateId;
    }

    public static String dz(AdTemplate adTemplate) {
        return ce(adTemplate).preLandingPageTKInfo.templateId;
    }

    @Nullable
    public static AdMatrixInfo.PreLandingPageTKInfo di(@NonNull AdTemplate adTemplate) {
        return e.dQ(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static String ds(AdTemplate adTemplate) {
        return ce(adTemplate).splashEndCardTKInfo.templateId;
    }
}
