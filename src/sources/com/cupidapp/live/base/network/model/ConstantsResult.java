package com.cupidapp.live.base.network.model;

import com.cupidapp.live.startup.model.FKExpressModel;
import com.cupidapp.live.startup.model.FKStartupMediaModel;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConstantsResult {

    @Nullable
    private MatchPageActivityModel activityView;

    @Nullable
    private final FKExpressModel adFeedParam;

    @Nullable
    private final LinkDictTipsModel addServicesTips;

    @Nullable
    private final AndroidUpdateVersionModel androidUpdateVersion;

    @Nullable
    private final LinkDictTipsModel antifraudTips;

    @Nullable
    private final LinkDictTipsModel billingVipTips;

    @Nullable
    private final Boolean checkStrategyPopup;

    @Nullable
    private final String cityCode;

    @Nullable
    private String clientIp;

    @Nullable
    private final LinkDictTipsModel connectionTips;

    @Nullable
    private ServiceInfoModel connector;

    @Nullable
    private String customAppIcon;
    private int defaultTabIndex;

    @Nullable
    private EnableButtonsModel enableButtons;

    @Nullable
    private final Boolean enableHWExSplash;

    @Nullable
    private final Integer feedActionUploadSizeRule;

    @Nullable
    private final Integer feedActionUploadTimeSecondRule;

    @Nullable
    private final Boolean grayModeOpen;

    @Nullable
    private final Map<String, String> hwPushCategory;

    @Nullable
    private final LivePathModel livePaths;

    @Nullable
    private final LivePopupWindowModel livePopupWindow;

    @Nullable
    private final Integer liveShowIntervalInMatch;

    @Nullable
    private final LivePromotionModel liveTabPromotionInfo;

    @Nullable
    private final Boolean locationPrioritySwitch;

    @Nullable
    private Integer matchFilterSettingType;

    @Nullable
    private final Integer matchTabRedDotWaitSecondWhenChangeTab;

    @Nullable
    private final MatchWebTabInfoModel matchWebTabInfo;

    @Nullable
    private Integer nearbyFilterSettingType;

    @Nullable
    private Boolean openPersonalizedRecommendation;

    @Nullable
    private final List<PrefetchResourcesModel> prefetchResources;

    @Nullable
    private final List<PrefetchResourcesModel> prefetchResourcesAlt;

    @Nullable
    private Integer recommendPostTabSwitch;

    @NotNull
    private final List<Map<String, String>> reportType;

    @Nullable
    private final FKStartupMediaModel splashAdNew;

    @Nullable
    private final LinkDictTipsModel startLiveTips;

    @Nullable
    private final LinkDictTipsModel superLikeTerms;

    @Nullable
    private final String superlikeDefaultTabGroup;

    @NotNull
    private final ConstantsUrlModel urlModel;

    @NotNull
    private final List<String> urlWhiteList;

    @Nullable
    private final SocialGameConfigModel vasConf;

    @Nullable
    private final Boolean vasPolling;

    @Nullable
    private final Integer vasPollingInterval;

    @Nullable
    private final Boolean vasSubExpireMsgRemind;
    private final int videoMaxSeconds;

    /* JADX WARN: Multi-variable type inference failed */
    public ConstantsResult(@NotNull ConstantsUrlModel urlModel, @Nullable AndroidUpdateVersionModel androidUpdateVersionModel, @NotNull List<? extends Map<String, String>> reportType, @Nullable ServiceInfoModel serviceInfoModel, @Nullable Integer num, @Nullable Integer num2, int i10, @Nullable List<PrefetchResourcesModel> list, @Nullable List<PrefetchResourcesModel> list2, int i11, @Nullable LivePopupWindowModel livePopupWindowModel, @Nullable String str, @Nullable LinkDictTipsModel linkDictTipsModel, @Nullable LinkDictTipsModel linkDictTipsModel2, @Nullable LinkDictTipsModel linkDictTipsModel3, @Nullable LinkDictTipsModel linkDictTipsModel4, @Nullable String str2, @Nullable LinkDictTipsModel linkDictTipsModel5, @Nullable LinkDictTipsModel linkDictTipsModel6, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6, @Nullable MatchPageActivityModel matchPageActivityModel, @NotNull List<String> urlWhiteList, @Nullable FKStartupMediaModel fKStartupMediaModel, @Nullable FKExpressModel fKExpressModel, @Nullable Boolean bool, @Nullable String str3, @Nullable SocialGameConfigModel socialGameConfigModel, @Nullable LivePromotionModel livePromotionModel, @Nullable LivePathModel livePathModel, @Nullable Integer num7, @Nullable Boolean bool2, @Nullable Integer num8, @Nullable String str4, @Nullable Boolean bool3, @Nullable Map<String, String> map, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable MatchWebTabInfoModel matchWebTabInfoModel, @Nullable EnableButtonsModel enableButtonsModel, @Nullable Boolean bool7) {
        s.i(urlModel, "urlModel");
        s.i(reportType, "reportType");
        s.i(urlWhiteList, "urlWhiteList");
        this.urlModel = urlModel;
        this.androidUpdateVersion = androidUpdateVersionModel;
        this.reportType = reportType;
        this.connector = serviceInfoModel;
        this.matchFilterSettingType = num;
        this.nearbyFilterSettingType = num2;
        this.defaultTabIndex = i10;
        this.prefetchResources = list;
        this.prefetchResourcesAlt = list2;
        this.videoMaxSeconds = i11;
        this.livePopupWindow = livePopupWindowModel;
        this.cityCode = str;
        this.antifraudTips = linkDictTipsModel;
        this.billingVipTips = linkDictTipsModel2;
        this.addServicesTips = linkDictTipsModel3;
        this.superLikeTerms = linkDictTipsModel4;
        this.clientIp = str2;
        this.startLiveTips = linkDictTipsModel5;
        this.connectionTips = linkDictTipsModel6;
        this.feedActionUploadTimeSecondRule = num3;
        this.feedActionUploadSizeRule = num4;
        this.liveShowIntervalInMatch = num5;
        this.recommendPostTabSwitch = num6;
        this.activityView = matchPageActivityModel;
        this.urlWhiteList = urlWhiteList;
        this.splashAdNew = fKStartupMediaModel;
        this.adFeedParam = fKExpressModel;
        this.openPersonalizedRecommendation = bool;
        this.customAppIcon = str3;
        this.vasConf = socialGameConfigModel;
        this.liveTabPromotionInfo = livePromotionModel;
        this.livePaths = livePathModel;
        this.matchTabRedDotWaitSecondWhenChangeTab = num7;
        this.vasPolling = bool2;
        this.vasPollingInterval = num8;
        this.superlikeDefaultTabGroup = str4;
        this.enableHWExSplash = bool3;
        this.hwPushCategory = map;
        this.locationPrioritySwitch = bool4;
        this.grayModeOpen = bool5;
        this.vasSubExpireMsgRemind = bool6;
        this.matchWebTabInfo = matchWebTabInfoModel;
        this.enableButtons = enableButtonsModel;
        this.checkStrategyPopup = bool7;
    }

    private final FKStartupMediaModel component26() {
        return this.splashAdNew;
    }

    @NotNull
    public final ConstantsUrlModel component1() {
        return this.urlModel;
    }

    public final int component10() {
        return this.videoMaxSeconds;
    }

    @Nullable
    public final LivePopupWindowModel component11() {
        return this.livePopupWindow;
    }

    @Nullable
    public final String component12() {
        return this.cityCode;
    }

    @Nullable
    public final LinkDictTipsModel component13() {
        return this.antifraudTips;
    }

    @Nullable
    public final LinkDictTipsModel component14() {
        return this.billingVipTips;
    }

    @Nullable
    public final LinkDictTipsModel component15() {
        return this.addServicesTips;
    }

    @Nullable
    public final LinkDictTipsModel component16() {
        return this.superLikeTerms;
    }

    @Nullable
    public final String component17() {
        return this.clientIp;
    }

    @Nullable
    public final LinkDictTipsModel component18() {
        return this.startLiveTips;
    }

    @Nullable
    public final LinkDictTipsModel component19() {
        return this.connectionTips;
    }

    @Nullable
    public final AndroidUpdateVersionModel component2() {
        return this.androidUpdateVersion;
    }

    @Nullable
    public final Integer component20() {
        return this.feedActionUploadTimeSecondRule;
    }

    @Nullable
    public final Integer component21() {
        return this.feedActionUploadSizeRule;
    }

    @Nullable
    public final Integer component22() {
        return this.liveShowIntervalInMatch;
    }

    @Nullable
    public final Integer component23() {
        return this.recommendPostTabSwitch;
    }

    @Nullable
    public final MatchPageActivityModel component24() {
        return this.activityView;
    }

    @NotNull
    public final List<String> component25() {
        return this.urlWhiteList;
    }

    @Nullable
    public final FKExpressModel component27() {
        return this.adFeedParam;
    }

    @Nullable
    public final Boolean component28() {
        return this.openPersonalizedRecommendation;
    }

    @Nullable
    public final String component29() {
        return this.customAppIcon;
    }

    @NotNull
    public final List<Map<String, String>> component3() {
        return this.reportType;
    }

    @Nullable
    public final SocialGameConfigModel component30() {
        return this.vasConf;
    }

    @Nullable
    public final LivePromotionModel component31() {
        return this.liveTabPromotionInfo;
    }

    @Nullable
    public final LivePathModel component32() {
        return this.livePaths;
    }

    @Nullable
    public final Integer component33() {
        return this.matchTabRedDotWaitSecondWhenChangeTab;
    }

    @Nullable
    public final Boolean component34() {
        return this.vasPolling;
    }

    @Nullable
    public final Integer component35() {
        return this.vasPollingInterval;
    }

    @Nullable
    public final String component36() {
        return this.superlikeDefaultTabGroup;
    }

    @Nullable
    public final Boolean component37() {
        return this.enableHWExSplash;
    }

    @Nullable
    public final Map<String, String> component38() {
        return this.hwPushCategory;
    }

    @Nullable
    public final Boolean component39() {
        return this.locationPrioritySwitch;
    }

    @Nullable
    public final ServiceInfoModel component4() {
        return this.connector;
    }

    @Nullable
    public final Boolean component40() {
        return this.grayModeOpen;
    }

    @Nullable
    public final Boolean component41() {
        return this.vasSubExpireMsgRemind;
    }

    @Nullable
    public final MatchWebTabInfoModel component42() {
        return this.matchWebTabInfo;
    }

    @Nullable
    public final EnableButtonsModel component43() {
        return this.enableButtons;
    }

    @Nullable
    public final Boolean component44() {
        return this.checkStrategyPopup;
    }

    @Nullable
    public final Integer component5() {
        return this.matchFilterSettingType;
    }

    @Nullable
    public final Integer component6() {
        return this.nearbyFilterSettingType;
    }

    public final int component7() {
        return this.defaultTabIndex;
    }

    @Nullable
    public final List<PrefetchResourcesModel> component8() {
        return this.prefetchResources;
    }

    @Nullable
    public final List<PrefetchResourcesModel> component9() {
        return this.prefetchResourcesAlt;
    }

    @NotNull
    public final ConstantsResult copy(@NotNull ConstantsUrlModel urlModel, @Nullable AndroidUpdateVersionModel androidUpdateVersionModel, @NotNull List<? extends Map<String, String>> reportType, @Nullable ServiceInfoModel serviceInfoModel, @Nullable Integer num, @Nullable Integer num2, int i10, @Nullable List<PrefetchResourcesModel> list, @Nullable List<PrefetchResourcesModel> list2, int i11, @Nullable LivePopupWindowModel livePopupWindowModel, @Nullable String str, @Nullable LinkDictTipsModel linkDictTipsModel, @Nullable LinkDictTipsModel linkDictTipsModel2, @Nullable LinkDictTipsModel linkDictTipsModel3, @Nullable LinkDictTipsModel linkDictTipsModel4, @Nullable String str2, @Nullable LinkDictTipsModel linkDictTipsModel5, @Nullable LinkDictTipsModel linkDictTipsModel6, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6, @Nullable MatchPageActivityModel matchPageActivityModel, @NotNull List<String> urlWhiteList, @Nullable FKStartupMediaModel fKStartupMediaModel, @Nullable FKExpressModel fKExpressModel, @Nullable Boolean bool, @Nullable String str3, @Nullable SocialGameConfigModel socialGameConfigModel, @Nullable LivePromotionModel livePromotionModel, @Nullable LivePathModel livePathModel, @Nullable Integer num7, @Nullable Boolean bool2, @Nullable Integer num8, @Nullable String str4, @Nullable Boolean bool3, @Nullable Map<String, String> map, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable MatchWebTabInfoModel matchWebTabInfoModel, @Nullable EnableButtonsModel enableButtonsModel, @Nullable Boolean bool7) {
        s.i(urlModel, "urlModel");
        s.i(reportType, "reportType");
        s.i(urlWhiteList, "urlWhiteList");
        return new ConstantsResult(urlModel, androidUpdateVersionModel, reportType, serviceInfoModel, num, num2, i10, list, list2, i11, livePopupWindowModel, str, linkDictTipsModel, linkDictTipsModel2, linkDictTipsModel3, linkDictTipsModel4, str2, linkDictTipsModel5, linkDictTipsModel6, num3, num4, num5, num6, matchPageActivityModel, urlWhiteList, fKStartupMediaModel, fKExpressModel, bool, str3, socialGameConfigModel, livePromotionModel, livePathModel, num7, bool2, num8, str4, bool3, map, bool4, bool5, bool6, matchWebTabInfoModel, enableButtonsModel, bool7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConstantsResult)) {
            return false;
        }
        ConstantsResult constantsResult = (ConstantsResult) obj;
        return s.d(this.urlModel, constantsResult.urlModel) && s.d(this.androidUpdateVersion, constantsResult.androidUpdateVersion) && s.d(this.reportType, constantsResult.reportType) && s.d(this.connector, constantsResult.connector) && s.d(this.matchFilterSettingType, constantsResult.matchFilterSettingType) && s.d(this.nearbyFilterSettingType, constantsResult.nearbyFilterSettingType) && this.defaultTabIndex == constantsResult.defaultTabIndex && s.d(this.prefetchResources, constantsResult.prefetchResources) && s.d(this.prefetchResourcesAlt, constantsResult.prefetchResourcesAlt) && this.videoMaxSeconds == constantsResult.videoMaxSeconds && s.d(this.livePopupWindow, constantsResult.livePopupWindow) && s.d(this.cityCode, constantsResult.cityCode) && s.d(this.antifraudTips, constantsResult.antifraudTips) && s.d(this.billingVipTips, constantsResult.billingVipTips) && s.d(this.addServicesTips, constantsResult.addServicesTips) && s.d(this.superLikeTerms, constantsResult.superLikeTerms) && s.d(this.clientIp, constantsResult.clientIp) && s.d(this.startLiveTips, constantsResult.startLiveTips) && s.d(this.connectionTips, constantsResult.connectionTips) && s.d(this.feedActionUploadTimeSecondRule, constantsResult.feedActionUploadTimeSecondRule) && s.d(this.feedActionUploadSizeRule, constantsResult.feedActionUploadSizeRule) && s.d(this.liveShowIntervalInMatch, constantsResult.liveShowIntervalInMatch) && s.d(this.recommendPostTabSwitch, constantsResult.recommendPostTabSwitch) && s.d(this.activityView, constantsResult.activityView) && s.d(this.urlWhiteList, constantsResult.urlWhiteList) && s.d(this.splashAdNew, constantsResult.splashAdNew) && s.d(this.adFeedParam, constantsResult.adFeedParam) && s.d(this.openPersonalizedRecommendation, constantsResult.openPersonalizedRecommendation) && s.d(this.customAppIcon, constantsResult.customAppIcon) && s.d(this.vasConf, constantsResult.vasConf) && s.d(this.liveTabPromotionInfo, constantsResult.liveTabPromotionInfo) && s.d(this.livePaths, constantsResult.livePaths) && s.d(this.matchTabRedDotWaitSecondWhenChangeTab, constantsResult.matchTabRedDotWaitSecondWhenChangeTab) && s.d(this.vasPolling, constantsResult.vasPolling) && s.d(this.vasPollingInterval, constantsResult.vasPollingInterval) && s.d(this.superlikeDefaultTabGroup, constantsResult.superlikeDefaultTabGroup) && s.d(this.enableHWExSplash, constantsResult.enableHWExSplash) && s.d(this.hwPushCategory, constantsResult.hwPushCategory) && s.d(this.locationPrioritySwitch, constantsResult.locationPrioritySwitch) && s.d(this.grayModeOpen, constantsResult.grayModeOpen) && s.d(this.vasSubExpireMsgRemind, constantsResult.vasSubExpireMsgRemind) && s.d(this.matchWebTabInfo, constantsResult.matchWebTabInfo) && s.d(this.enableButtons, constantsResult.enableButtons) && s.d(this.checkStrategyPopup, constantsResult.checkStrategyPopup);
    }

    @Nullable
    public final MatchPageActivityModel getActivityView() {
        return this.activityView;
    }

    @Nullable
    public final FKExpressModel getAdFeedParam() {
        return this.adFeedParam;
    }

    @Nullable
    public final LinkDictTipsModel getAddServicesTips() {
        return this.addServicesTips;
    }

    @Nullable
    public final AndroidUpdateVersionModel getAndroidUpdateVersion() {
        return this.androidUpdateVersion;
    }

    @Nullable
    public final LinkDictTipsModel getAntifraudTips() {
        return this.antifraudTips;
    }

    @Nullable
    public final LinkDictTipsModel getBillingVipTips() {
        return this.billingVipTips;
    }

    @Nullable
    public final Boolean getCheckStrategyPopup() {
        return this.checkStrategyPopup;
    }

    @Nullable
    public final String getCityCode() {
        return this.cityCode;
    }

    @Nullable
    public final String getClientIp() {
        return this.clientIp;
    }

    @Nullable
    public final LinkDictTipsModel getConnectionTips() {
        return this.connectionTips;
    }

    @Nullable
    public final ServiceInfoModel getConnector() {
        return this.connector;
    }

    @Nullable
    public final String getCustomAppIcon() {
        return this.customAppIcon;
    }

    public final int getDefaultTabIndex() {
        return this.defaultTabIndex;
    }

    @Nullable
    public final EnableButtonsModel getEnableButtons() {
        return this.enableButtons;
    }

    @Nullable
    public final Boolean getEnableHWExSplash() {
        return this.enableHWExSplash;
    }

    @Nullable
    public final Integer getFeedActionUploadSizeRule() {
        return this.feedActionUploadSizeRule;
    }

    @Nullable
    public final Integer getFeedActionUploadTimeSecondRule() {
        return this.feedActionUploadTimeSecondRule;
    }

    @Nullable
    public final Boolean getGrayModeOpen() {
        return this.grayModeOpen;
    }

    @Nullable
    public final Map<String, String> getHwPushCategory() {
        return this.hwPushCategory;
    }

    @Nullable
    public final LivePathModel getLivePaths() {
        return this.livePaths;
    }

    @Nullable
    public final LivePopupWindowModel getLivePopupWindow() {
        return this.livePopupWindow;
    }

    @Nullable
    public final Integer getLiveShowIntervalInMatch() {
        return this.liveShowIntervalInMatch;
    }

    @Nullable
    public final LivePromotionModel getLiveTabPromotionInfo() {
        return this.liveTabPromotionInfo;
    }

    @Nullable
    public final Boolean getLocationPrioritySwitch() {
        return this.locationPrioritySwitch;
    }

    @Nullable
    public final Integer getMatchFilterSettingType() {
        return this.matchFilterSettingType;
    }

    @Nullable
    public final Integer getMatchTabRedDotWaitSecondWhenChangeTab() {
        return this.matchTabRedDotWaitSecondWhenChangeTab;
    }

    @Nullable
    public final MatchWebTabInfoModel getMatchWebTabInfo() {
        return this.matchWebTabInfo;
    }

    @Nullable
    public final Integer getNearbyFilterSettingType() {
        return this.nearbyFilterSettingType;
    }

    @Nullable
    public final Boolean getOpenPersonalizedRecommendation() {
        return this.openPersonalizedRecommendation;
    }

    @Nullable
    public final List<PrefetchResourcesModel> getPrefetchResources() {
        return this.prefetchResources;
    }

    @Nullable
    public final List<PrefetchResourcesModel> getPrefetchResourcesAlt() {
        return this.prefetchResourcesAlt;
    }

    @Nullable
    public final Integer getRecommendPostTabSwitch() {
        return this.recommendPostTabSwitch;
    }

    @NotNull
    public final List<Map<String, String>> getReportType() {
        return this.reportType;
    }

    @Nullable
    public final Integer getSplashCacheTimeInterval() {
        FKStartupMediaModel fKStartupMediaModel = this.splashAdNew;
        if (fKStartupMediaModel != null) {
            return Integer.valueOf(fKStartupMediaModel.getCacheTimeInterval());
        }
        return null;
    }

    public final int getSplashColdBootInterval() {
        FKStartupMediaModel fKStartupMediaModel = this.splashAdNew;
        if (fKStartupMediaModel != null) {
            return fKStartupMediaModel.getColdBootInterval();
        }
        return 1;
    }

    @Nullable
    public final Integer getSplashHotBootInterval() {
        FKStartupMediaModel fKStartupMediaModel = this.splashAdNew;
        if (fKStartupMediaModel != null) {
            return Integer.valueOf(fKStartupMediaModel.getHotBootInterval());
        }
        return null;
    }

    @Nullable
    public final LinkDictTipsModel getStartLiveTips() {
        return this.startLiveTips;
    }

    @Nullable
    public final LinkDictTipsModel getSuperLikeTerms() {
        return this.superLikeTerms;
    }

    @Nullable
    public final String getSuperlikeDefaultTabGroup() {
        return this.superlikeDefaultTabGroup;
    }

    @NotNull
    public final ConstantsUrlModel getUrlModel() {
        return this.urlModel;
    }

    @NotNull
    public final List<String> getUrlWhiteList() {
        return this.urlWhiteList;
    }

    @Nullable
    public final SocialGameConfigModel getVasConf() {
        return this.vasConf;
    }

    @Nullable
    public final Boolean getVasPolling() {
        return this.vasPolling;
    }

    @Nullable
    public final Integer getVasPollingInterval() {
        return this.vasPollingInterval;
    }

    @Nullable
    public final Boolean getVasSubExpireMsgRemind() {
        return this.vasSubExpireMsgRemind;
    }

    public final int getVideoMaxSeconds() {
        return this.videoMaxSeconds;
    }

    public int hashCode() {
        int hashCode = this.urlModel.hashCode() * 31;
        AndroidUpdateVersionModel androidUpdateVersionModel = this.androidUpdateVersion;
        int hashCode2 = (((hashCode + (androidUpdateVersionModel == null ? 0 : androidUpdateVersionModel.hashCode())) * 31) + this.reportType.hashCode()) * 31;
        ServiceInfoModel serviceInfoModel = this.connector;
        int hashCode3 = (hashCode2 + (serviceInfoModel == null ? 0 : serviceInfoModel.hashCode())) * 31;
        Integer num = this.matchFilterSettingType;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.nearbyFilterSettingType;
        int hashCode5 = (((hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.defaultTabIndex) * 31;
        List<PrefetchResourcesModel> list = this.prefetchResources;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        List<PrefetchResourcesModel> list2 = this.prefetchResourcesAlt;
        int hashCode7 = (((hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.videoMaxSeconds) * 31;
        LivePopupWindowModel livePopupWindowModel = this.livePopupWindow;
        int hashCode8 = (hashCode7 + (livePopupWindowModel == null ? 0 : livePopupWindowModel.hashCode())) * 31;
        String str = this.cityCode;
        int hashCode9 = (hashCode8 + (str == null ? 0 : str.hashCode())) * 31;
        LinkDictTipsModel linkDictTipsModel = this.antifraudTips;
        int hashCode10 = (hashCode9 + (linkDictTipsModel == null ? 0 : linkDictTipsModel.hashCode())) * 31;
        LinkDictTipsModel linkDictTipsModel2 = this.billingVipTips;
        int hashCode11 = (hashCode10 + (linkDictTipsModel2 == null ? 0 : linkDictTipsModel2.hashCode())) * 31;
        LinkDictTipsModel linkDictTipsModel3 = this.addServicesTips;
        int hashCode12 = (hashCode11 + (linkDictTipsModel3 == null ? 0 : linkDictTipsModel3.hashCode())) * 31;
        LinkDictTipsModel linkDictTipsModel4 = this.superLikeTerms;
        int hashCode13 = (hashCode12 + (linkDictTipsModel4 == null ? 0 : linkDictTipsModel4.hashCode())) * 31;
        String str2 = this.clientIp;
        int hashCode14 = (hashCode13 + (str2 == null ? 0 : str2.hashCode())) * 31;
        LinkDictTipsModel linkDictTipsModel5 = this.startLiveTips;
        int hashCode15 = (hashCode14 + (linkDictTipsModel5 == null ? 0 : linkDictTipsModel5.hashCode())) * 31;
        LinkDictTipsModel linkDictTipsModel6 = this.connectionTips;
        int hashCode16 = (hashCode15 + (linkDictTipsModel6 == null ? 0 : linkDictTipsModel6.hashCode())) * 31;
        Integer num3 = this.feedActionUploadTimeSecondRule;
        int hashCode17 = (hashCode16 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.feedActionUploadSizeRule;
        int hashCode18 = (hashCode17 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.liveShowIntervalInMatch;
        int hashCode19 = (hashCode18 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.recommendPostTabSwitch;
        int hashCode20 = (hashCode19 + (num6 == null ? 0 : num6.hashCode())) * 31;
        MatchPageActivityModel matchPageActivityModel = this.activityView;
        int hashCode21 = (((hashCode20 + (matchPageActivityModel == null ? 0 : matchPageActivityModel.hashCode())) * 31) + this.urlWhiteList.hashCode()) * 31;
        FKStartupMediaModel fKStartupMediaModel = this.splashAdNew;
        int hashCode22 = (hashCode21 + (fKStartupMediaModel == null ? 0 : fKStartupMediaModel.hashCode())) * 31;
        FKExpressModel fKExpressModel = this.adFeedParam;
        int hashCode23 = (hashCode22 + (fKExpressModel == null ? 0 : fKExpressModel.hashCode())) * 31;
        Boolean bool = this.openPersonalizedRecommendation;
        int hashCode24 = (hashCode23 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.customAppIcon;
        int hashCode25 = (hashCode24 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SocialGameConfigModel socialGameConfigModel = this.vasConf;
        int hashCode26 = (hashCode25 + (socialGameConfigModel == null ? 0 : socialGameConfigModel.hashCode())) * 31;
        LivePromotionModel livePromotionModel = this.liveTabPromotionInfo;
        int hashCode27 = (hashCode26 + (livePromotionModel == null ? 0 : livePromotionModel.hashCode())) * 31;
        LivePathModel livePathModel = this.livePaths;
        int hashCode28 = (hashCode27 + (livePathModel == null ? 0 : livePathModel.hashCode())) * 31;
        Integer num7 = this.matchTabRedDotWaitSecondWhenChangeTab;
        int hashCode29 = (hashCode28 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Boolean bool2 = this.vasPolling;
        int hashCode30 = (hashCode29 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num8 = this.vasPollingInterval;
        int hashCode31 = (hashCode30 + (num8 == null ? 0 : num8.hashCode())) * 31;
        String str4 = this.superlikeDefaultTabGroup;
        int hashCode32 = (hashCode31 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool3 = this.enableHWExSplash;
        int hashCode33 = (hashCode32 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Map<String, String> map = this.hwPushCategory;
        int hashCode34 = (hashCode33 + (map == null ? 0 : map.hashCode())) * 31;
        Boolean bool4 = this.locationPrioritySwitch;
        int hashCode35 = (hashCode34 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.grayModeOpen;
        int hashCode36 = (hashCode35 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.vasSubExpireMsgRemind;
        int hashCode37 = (hashCode36 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        MatchWebTabInfoModel matchWebTabInfoModel = this.matchWebTabInfo;
        int hashCode38 = (hashCode37 + (matchWebTabInfoModel == null ? 0 : matchWebTabInfoModel.hashCode())) * 31;
        EnableButtonsModel enableButtonsModel = this.enableButtons;
        int hashCode39 = (hashCode38 + (enableButtonsModel == null ? 0 : enableButtonsModel.hashCode())) * 31;
        Boolean bool7 = this.checkStrategyPopup;
        return hashCode39 + (bool7 != null ? bool7.hashCode() : 0);
    }

    public final void setActivityView(@Nullable MatchPageActivityModel matchPageActivityModel) {
        this.activityView = matchPageActivityModel;
    }

    public final void setClientIp(@Nullable String str) {
        this.clientIp = str;
    }

    public final void setConnector(@Nullable ServiceInfoModel serviceInfoModel) {
        this.connector = serviceInfoModel;
    }

    public final void setCustomAppIcon(@Nullable String str) {
        this.customAppIcon = str;
    }

    public final void setDefaultTabIndex(int i10) {
        this.defaultTabIndex = i10;
    }

    public final void setEnableButtons(@Nullable EnableButtonsModel enableButtonsModel) {
        this.enableButtons = enableButtonsModel;
    }

    public final void setMatchFilterSettingType(@Nullable Integer num) {
        this.matchFilterSettingType = num;
    }

    public final void setNearbyFilterSettingType(@Nullable Integer num) {
        this.nearbyFilterSettingType = num;
    }

    public final void setOpenPersonalizedRecommendation(@Nullable Boolean bool) {
        this.openPersonalizedRecommendation = bool;
    }

    public final void setRecommendPostTabSwitch(@Nullable Integer num) {
        this.recommendPostTabSwitch = num;
    }

    public final boolean showRecommendTab() {
        Integer num = this.recommendPostTabSwitch;
        return num != null && num.intValue() == 1;
    }

    @NotNull
    public String toString() {
        ConstantsUrlModel constantsUrlModel = this.urlModel;
        AndroidUpdateVersionModel androidUpdateVersionModel = this.androidUpdateVersion;
        List<Map<String, String>> list = this.reportType;
        ServiceInfoModel serviceInfoModel = this.connector;
        Integer num = this.matchFilterSettingType;
        Integer num2 = this.nearbyFilterSettingType;
        int i10 = this.defaultTabIndex;
        List<PrefetchResourcesModel> list2 = this.prefetchResources;
        List<PrefetchResourcesModel> list3 = this.prefetchResourcesAlt;
        int i11 = this.videoMaxSeconds;
        LivePopupWindowModel livePopupWindowModel = this.livePopupWindow;
        String str = this.cityCode;
        LinkDictTipsModel linkDictTipsModel = this.antifraudTips;
        LinkDictTipsModel linkDictTipsModel2 = this.billingVipTips;
        LinkDictTipsModel linkDictTipsModel3 = this.addServicesTips;
        LinkDictTipsModel linkDictTipsModel4 = this.superLikeTerms;
        String str2 = this.clientIp;
        LinkDictTipsModel linkDictTipsModel5 = this.startLiveTips;
        LinkDictTipsModel linkDictTipsModel6 = this.connectionTips;
        Integer num3 = this.feedActionUploadTimeSecondRule;
        Integer num4 = this.feedActionUploadSizeRule;
        Integer num5 = this.liveShowIntervalInMatch;
        Integer num6 = this.recommendPostTabSwitch;
        MatchPageActivityModel matchPageActivityModel = this.activityView;
        List<String> list4 = this.urlWhiteList;
        FKStartupMediaModel fKStartupMediaModel = this.splashAdNew;
        FKExpressModel fKExpressModel = this.adFeedParam;
        Boolean bool = this.openPersonalizedRecommendation;
        String str3 = this.customAppIcon;
        SocialGameConfigModel socialGameConfigModel = this.vasConf;
        LivePromotionModel livePromotionModel = this.liveTabPromotionInfo;
        LivePathModel livePathModel = this.livePaths;
        Integer num7 = this.matchTabRedDotWaitSecondWhenChangeTab;
        Boolean bool2 = this.vasPolling;
        Integer num8 = this.vasPollingInterval;
        return "ConstantsResult(urlModel=" + ((Object) constantsUrlModel) + ", androidUpdateVersion=" + ((Object) androidUpdateVersionModel) + ", reportType=" + ((Object) list) + ", connector=" + ((Object) serviceInfoModel) + ", matchFilterSettingType=" + ((Object) num) + ", nearbyFilterSettingType=" + ((Object) num2) + ", defaultTabIndex=" + i10 + ", prefetchResources=" + ((Object) list2) + ", prefetchResourcesAlt=" + ((Object) list3) + ", videoMaxSeconds=" + i11 + ", livePopupWindow=" + ((Object) livePopupWindowModel) + ", cityCode=" + str + ", antifraudTips=" + ((Object) linkDictTipsModel) + ", billingVipTips=" + ((Object) linkDictTipsModel2) + ", addServicesTips=" + ((Object) linkDictTipsModel3) + ", superLikeTerms=" + ((Object) linkDictTipsModel4) + ", clientIp=" + str2 + ", startLiveTips=" + ((Object) linkDictTipsModel5) + ", connectionTips=" + ((Object) linkDictTipsModel6) + ", feedActionUploadTimeSecondRule=" + ((Object) num3) + ", feedActionUploadSizeRule=" + ((Object) num4) + ", liveShowIntervalInMatch=" + ((Object) num5) + ", recommendPostTabSwitch=" + ((Object) num6) + ", activityView=" + ((Object) matchPageActivityModel) + ", urlWhiteList=" + ((Object) list4) + ", splashAdNew=" + ((Object) fKStartupMediaModel) + ", adFeedParam=" + ((Object) fKExpressModel) + ", openPersonalizedRecommendation=" + ((Object) bool) + ", customAppIcon=" + str3 + ", vasConf=" + ((Object) socialGameConfigModel) + ", liveTabPromotionInfo=" + ((Object) livePromotionModel) + ", livePaths=" + ((Object) livePathModel) + ", matchTabRedDotWaitSecondWhenChangeTab=" + ((Object) num7) + ", vasPolling=" + ((Object) bool2) + ", vasPollingInterval=" + ((Object) num8) + ", superlikeDefaultTabGroup=" + this.superlikeDefaultTabGroup + ", enableHWExSplash=" + ((Object) this.enableHWExSplash) + ", hwPushCategory=" + ((Object) this.hwPushCategory) + ", locationPrioritySwitch=" + ((Object) this.locationPrioritySwitch) + ", grayModeOpen=" + ((Object) this.grayModeOpen) + ", vasSubExpireMsgRemind=" + ((Object) this.vasSubExpireMsgRemind) + ", matchWebTabInfo=" + ((Object) this.matchWebTabInfo) + ", enableButtons=" + ((Object) this.enableButtons) + ", checkStrategyPopup=" + ((Object) this.checkStrategyPopup) + ")";
    }

    public /* synthetic */ ConstantsResult(ConstantsUrlModel constantsUrlModel, AndroidUpdateVersionModel androidUpdateVersionModel, List list, ServiceInfoModel serviceInfoModel, Integer num, Integer num2, int i10, List list2, List list3, int i11, LivePopupWindowModel livePopupWindowModel, String str, LinkDictTipsModel linkDictTipsModel, LinkDictTipsModel linkDictTipsModel2, LinkDictTipsModel linkDictTipsModel3, LinkDictTipsModel linkDictTipsModel4, String str2, LinkDictTipsModel linkDictTipsModel5, LinkDictTipsModel linkDictTipsModel6, Integer num3, Integer num4, Integer num5, Integer num6, MatchPageActivityModel matchPageActivityModel, List list4, FKStartupMediaModel fKStartupMediaModel, FKExpressModel fKExpressModel, Boolean bool, String str3, SocialGameConfigModel socialGameConfigModel, LivePromotionModel livePromotionModel, LivePathModel livePathModel, Integer num7, Boolean bool2, Integer num8, String str4, Boolean bool3, Map map, Boolean bool4, Boolean bool5, Boolean bool6, MatchWebTabInfoModel matchWebTabInfoModel, EnableButtonsModel enableButtonsModel, Boolean bool7, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(constantsUrlModel, androidUpdateVersionModel, list, serviceInfoModel, num, num2, (i12 & 64) != 0 ? 0 : i10, list2, list3, (i12 & 512) != 0 ? 15 : i11, livePopupWindowModel, str, linkDictTipsModel, linkDictTipsModel2, linkDictTipsModel3, linkDictTipsModel4, str2, linkDictTipsModel5, linkDictTipsModel6, num3, num4, num5, (i12 & 4194304) != 0 ? 0 : num6, matchPageActivityModel, list4, fKStartupMediaModel, fKExpressModel, bool, str3, socialGameConfigModel, livePromotionModel, livePathModel, (i13 & 1) != 0 ? 15 : num7, bool2, num8, str4, bool3, map, bool4, bool5, bool6, matchWebTabInfoModel, enableButtonsModel, bool7);
    }
}
