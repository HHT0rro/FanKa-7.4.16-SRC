package com.cupidapp.live.vip.wrapper;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'Nearby' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: VipPurchaseEntranceType.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseEntranceType {
    private static final /* synthetic */ VipPurchaseEntranceType[] $VALUES;
    public static final VipPurchaseEntranceType AiIdentify;
    public static final VipPurchaseEntranceType ContactFilter;
    public static final VipPurchaseEntranceType ContactManager;
    public static final VipPurchaseEntranceType ContactSuperFilter;
    public static final VipPurchaseEntranceType CustomChatBubble;
    public static final VipPurchaseEntranceType DailyHeart;
    public static final VipPurchaseEntranceType DynEntrance;
    public static final VipPurchaseEntranceType FeedNoAd;
    public static final VipPurchaseEntranceType FeedSpread;
    public static final VipPurchaseEntranceType FeedTop;
    public static final VipPurchaseEntranceType Filter;
    public static final VipPurchaseEntranceType FilterCommon;
    public static final VipPurchaseEntranceType GuideMap;
    public static final VipPurchaseEntranceType HiddenDelFootmark;
    public static final VipPurchaseEntranceType HiddenFootmark;
    public static final VipPurchaseEntranceType HiddenFootmarkPrivacySetting;
    public static final VipPurchaseEntranceType IntelligentFilter;
    public static final VipPurchaseEntranceType IntelligentFilterInMatch;
    public static final VipPurchaseEntranceType IntelligentFilterInSearch;
    public static final VipPurchaseEntranceType MBTIFilter;
    public static final VipPurchaseEntranceType MapFilter;
    public static final VipPurchaseEntranceType MaskPartyPrivilege;
    public static final VipPurchaseEntranceType MyAlohaGet;
    public static final VipPurchaseEntranceType NearByMapFilter;
    public static final VipPurchaseEntranceType NearByMapFloatFilter;
    public static final VipPurchaseEntranceType Nearby;
    public static final VipPurchaseEntranceType NearbyCardHeart;
    public static final VipPurchaseEntranceType NearbyUnLock;
    public static final VipPurchaseEntranceType NotifyAlohaYou;
    public static final VipPurchaseEntranceType PersonalAppIcon;
    public static final VipPurchaseEntranceType PersonalFrame;
    public static final VipPurchaseEntranceType PrivacyHideActive;
    public static final VipPurchaseEntranceType PrivacyHideLocation;
    public static final VipPurchaseEntranceType PrivacyHideMe;
    public static final VipPurchaseEntranceType PrivacyHideVipIcon;
    public static final VipPurchaseEntranceType RainbowRecommend;
    public static final VipPurchaseEntranceType RcmdFilterGuide;
    public static final VipPurchaseEntranceType RcmdSSVIPFilterGuide;
    public static final VipPurchaseEntranceType RcmdSuperFilterGuide;
    public static final VipPurchaseEntranceType Roaming;
    public static final VipPurchaseEntranceType RoleFilter;
    public static final VipPurchaseEntranceType SearchGuideMap;
    public static final VipPurchaseEntranceType SettingNoAd;
    public static final VipPurchaseEntranceType SuperFilter;
    public static final VipPurchaseEntranceType SuperFilterCommon;
    public static final VipPurchaseEntranceType SuperFilterInSearch;
    public static final VipPurchaseEntranceType SuperFilterMBTI;
    public static final VipPurchaseEntranceType SuperLikeFeed;
    public static final VipPurchaseEntranceType SuperLikeMatch;
    public static final VipPurchaseEntranceType SuperLikeMiniProfile;
    public static final VipPurchaseEntranceType SuperLikePostLimit;
    public static final VipPurchaseEntranceType SuperLikeProfile;
    public static final VipPurchaseEntranceType SuperLikeWeb;
    public static final VipPurchaseEntranceType UnAloha;
    public static final VipPurchaseEntranceType UnLimitSwipeCard;
    public static final VipPurchaseEntranceType VideoAvatarEdit;
    public static final VipPurchaseEntranceType ViewPrivatelyMessage;
    public static final VipPurchaseEntranceType ViewPrivatelyMessageDetail;
    public static final VipPurchaseEntranceType ViewPrivatelyPrivacySetting;
    public static final VipPurchaseEntranceType Visitor;
    public static final VipPurchaseEntranceType WealthLevelHide;
    public static final VipPurchaseEntranceType ZodiacFilter;

    @NotNull
    private String from;

    @NotNull
    private SensorPosition position;
    private int scene;

    private static final /* synthetic */ VipPurchaseEntranceType[] $values() {
        return new VipPurchaseEntranceType[]{Nearby, FeedNoAd, SettingNoAd, ContactFilter, ContactSuperFilter, FilterCommon, SuperFilterCommon, Filter, SuperFilter, SuperFilterMBTI, RoleFilter, ZodiacFilter, MBTIFilter, RcmdSuperFilterGuide, RcmdFilterGuide, RcmdSSVIPFilterGuide, MapFilter, NearByMapFilter, GuideMap, SearchGuideMap, NearByMapFloatFilter, Roaming, PrivacyHideActive, WealthLevelHide, PrivacyHideVipIcon, PrivacyHideLocation, PrivacyHideMe, HiddenFootmarkPrivacySetting, HiddenFootmark, HiddenDelFootmark, ViewPrivatelyMessage, ViewPrivatelyMessageDetail, ViewPrivatelyPrivacySetting, SuperLikeMatch, SuperLikeWeb, SuperLikeMiniProfile, SuperLikeProfile, SuperLikeFeed, SuperLikePostLimit, VideoAvatarEdit, PersonalAppIcon, MaskPartyPrivilege, NearbyCardHeart, DailyHeart, ContactManager, UnAloha, IntelligentFilter, IntelligentFilterInMatch, IntelligentFilterInSearch, SuperFilterInSearch, PersonalFrame, CustomChatBubble, DynEntrance, NotifyAlohaYou, MyAlohaGet, UnLimitSwipeCard, FeedSpread, Visitor, FeedTop, RainbowRecommend, AiIdentify, NearbyUnLock};
    }

    static {
        SensorPosition sensorPosition = SensorPosition.Nearby;
        Nearby = new VipPurchaseEntranceType("Nearby", 0, sensorPosition, "NEARBY_PEOPLE", CreateOrderScene.Nearby.getValue());
        SensorPosition sensorPosition2 = SensorPosition.Feed;
        FeedNoAd = new VipPurchaseEntranceType("FeedNoAd", 1, sensorPosition2, "POST_STREAM_REMOVE_AD", CreateOrderScene.FeedNoAd.getValue());
        SensorPosition sensorPosition3 = SensorPosition.Accessibility;
        CreateOrderScene createOrderScene = CreateOrderScene.Setting;
        SettingNoAd = new VipPurchaseEntranceType("SettingNoAd", 2, sensorPosition3, "AUXILIARY_FUNCTIONS_CLOSE_AD", createOrderScene.getValue());
        SensorPosition sensorPosition4 = SensorPosition.ContactFilter;
        CreateOrderScene createOrderScene2 = CreateOrderScene.Filter;
        ContactFilter = new VipPurchaseEntranceType("ContactFilter", 3, sensorPosition4, "", createOrderScene2.getValue());
        CreateOrderScene createOrderScene3 = CreateOrderScene.SuperFilter;
        ContactSuperFilter = new VipPurchaseEntranceType("ContactSuperFilter", 4, sensorPosition4, "", createOrderScene3.getValue());
        SensorPosition sensorPosition5 = SensorPosition.Unknown;
        FilterCommon = new VipPurchaseEntranceType("FilterCommon", 5, sensorPosition5, "", createOrderScene2.getValue());
        SuperFilterCommon = new VipPurchaseEntranceType("SuperFilterCommon", 6, sensorPosition5, "", createOrderScene3.getValue());
        SensorPosition sensorPosition6 = SensorPosition.MatchFilter;
        Filter = new VipPurchaseEntranceType("Filter", 7, sensorPosition6, "", createOrderScene2.getValue());
        SuperFilter = new VipPurchaseEntranceType("SuperFilter", 8, sensorPosition6, "", createOrderScene3.getValue());
        SuperFilterMBTI = new VipPurchaseEntranceType("SuperFilterMBTI", 9, sensorPosition6, "", createOrderScene3.getValue());
        RoleFilter = new VipPurchaseEntranceType("RoleFilter", 10, sensorPosition6, "", CreateOrderScene.Role.getValue());
        ZodiacFilter = new VipPurchaseEntranceType("ZodiacFilter", 11, sensorPosition6, "", CreateOrderScene.Zodiac.getValue());
        MBTIFilter = new VipPurchaseEntranceType("MBTIFilter", 12, sensorPosition6, "", CreateOrderScene.Mbti.getValue());
        SensorPosition sensorPosition7 = SensorPosition.RcmdFilterGuide;
        CreateOrderScene createOrderScene4 = CreateOrderScene.RcmdFilter;
        RcmdSuperFilterGuide = new VipPurchaseEntranceType("RcmdSuperFilterGuide", 13, sensorPosition7, "FULL_SCREEN_FILTER_GUIDE", createOrderScene4.getValue());
        RcmdFilterGuide = new VipPurchaseEntranceType("RcmdFilterGuide", 14, sensorPosition7, "FULL_SCREEN_FILTER_GUIDE", createOrderScene4.getValue());
        RcmdSSVIPFilterGuide = new VipPurchaseEntranceType("RcmdSSVIPFilterGuide", 15, sensorPosition7, "FULL_SCREEN_FILTER_GUIDE", createOrderScene4.getValue());
        CreateOrderScene createOrderScene5 = CreateOrderScene.MapFind;
        MapFilter = new VipPurchaseEntranceType("MapFilter", 16, sensorPosition6, "MATCH_FILTER_MAP_FIND", createOrderScene5.getValue());
        NearByMapFilter = new VipPurchaseEntranceType("NearByMapFilter", 17, sensorPosition, "NEARBY_MAP_FIND", createOrderScene5.getValue());
        SensorPosition sensorPosition8 = SensorPosition.Match;
        GuideMap = new VipPurchaseEntranceType("GuideMap", 18, sensorPosition8, "BETTER_MAP_FIND_GUIDE", CreateOrderScene.GuideMap.getValue());
        SensorPosition sensorPosition9 = SensorPosition.Search;
        SearchGuideMap = new VipPurchaseEntranceType("SearchGuideMap", 19, sensorPosition9, "SEARCH_MAP_FIND", CreateOrderScene.SearchGuideMap.getValue());
        NearByMapFloatFilter = new VipPurchaseEntranceType("NearByMapFloatFilter", 20, sensorPosition, "NEARBY_MAP_FIND_BUBBLE", createOrderScene5.getValue());
        Roaming = new VipPurchaseEntranceType("Roaming", 21, sensorPosition6, "ROAM", createOrderScene2.getValue());
        SensorPosition sensorPosition10 = SensorPosition.PrivacySetting;
        PrivacyHideActive = new VipPurchaseEntranceType("PrivacyHideActive", 22, sensorPosition10, "PRIVACY_SET_HIDE_ACT_TIME", createOrderScene.getValue());
        WealthLevelHide = new VipPurchaseEntranceType("WealthLevelHide", 23, sensorPosition10, "PRIVACY_SET_HIDE_WEALTH_LEVEL", createOrderScene.getValue());
        PrivacyHideVipIcon = new VipPurchaseEntranceType("PrivacyHideVipIcon", 24, sensorPosition10, "HIDE_VIP_ICON", createOrderScene.getValue());
        PrivacyHideLocation = new VipPurchaseEntranceType("PrivacyHideLocation", 25, sensorPosition10, "HIDE_DISTANCE", createOrderScene.getValue());
        PrivacyHideMe = new VipPurchaseEntranceType("PrivacyHideMe", 26, sensorPosition10, "CUSTOM_HIDE", createOrderScene.getValue());
        CreateOrderScene createOrderScene6 = CreateOrderScene.HiddenFootmark;
        HiddenFootmarkPrivacySetting = new VipPurchaseEntranceType("HiddenFootmarkPrivacySetting", 27, sensorPosition10, "SET_HIDE_VISITOR_RECORD", createOrderScene6.getValue());
        SensorPosition sensorPosition11 = SensorPosition.HideFootmark;
        HiddenFootmark = new VipPurchaseEntranceType("HiddenFootmark", 28, sensorPosition11, "VISITOR_RECORD_HIDE_VISITOR_RECORD", createOrderScene6.getValue());
        HiddenDelFootmark = new VipPurchaseEntranceType("HiddenDelFootmark", 29, sensorPosition11, "REMOVE_RECORD", createOrderScene6.getValue());
        SensorPosition sensorPosition12 = SensorPosition.Message;
        CreateOrderScene createOrderScene7 = CreateOrderScene.ViewPrivate;
        ViewPrivatelyMessage = new VipPurchaseEntranceType("ViewPrivatelyMessage", 30, sensorPosition12, "MESSAGE_SECRET_VIEW_MSG", createOrderScene7.getValue());
        ViewPrivatelyMessageDetail = new VipPurchaseEntranceType("ViewPrivatelyMessageDetail", 31, SensorPosition.MessageDetail, "MESSAGE_DETAIL_SECRET_VIEW_MSG", createOrderScene7.getValue());
        ViewPrivatelyPrivacySetting = new VipPurchaseEntranceType("ViewPrivatelyPrivacySetting", 32, sensorPosition10, "SET_SECRET_VIEW_MSG", createOrderScene.getValue());
        CreateOrderScene createOrderScene8 = CreateOrderScene.SuperLike;
        SuperLikeMatch = new VipPurchaseEntranceType("SuperLikeMatch", 33, sensorPosition8, "SUPER_LIKE", createOrderScene8.getValue());
        SensorPosition sensorPosition13 = SensorPosition.Web;
        SuperLikeWeb = new VipPurchaseEntranceType("SuperLikeWeb", 34, sensorPosition13, "SUPER_LIKE", createOrderScene8.getValue());
        SensorPosition sensorPosition14 = SensorPosition.MiniProfile;
        SuperLikeMiniProfile = new VipPurchaseEntranceType("SuperLikeMiniProfile", 35, sensorPosition14, "SUPER_LIKE", createOrderScene8.getValue());
        SuperLikeProfile = new VipPurchaseEntranceType("SuperLikeProfile", 36, SensorPosition.Profile, "SUPER_LIKE", createOrderScene8.getValue());
        SuperLikeFeed = new VipPurchaseEntranceType("SuperLikeFeed", 37, sensorPosition2, "SUPER_LIKE", createOrderScene8.getValue());
        SuperLikePostLimit = new VipPurchaseEntranceType("SuperLikePostLimit", 38, SensorPosition.PostLimit, "SUPER_LIKE", createOrderScene8.getValue());
        VideoAvatarEdit = new VipPurchaseEntranceType("VideoAvatarEdit", 39, SensorPosition.EditProfile, "DYNAMIC_AVATAR", CreateOrderScene.VideoAvatar.getValue());
        PersonalAppIcon = new VipPurchaseEntranceType("PersonalAppIcon", 40, SensorPosition.PersonalIcon, "PERSONAL_ICON", CreateOrderScene.PersonalIcon.getValue());
        MaskPartyPrivilege = new VipPurchaseEntranceType("MaskPartyPrivilege", 41, SensorPosition.MaskParty, "MASK_PARTY_PACKAGE", CreateOrderScene.MaskParty.getValue());
        CreateOrderScene createOrderScene9 = CreateOrderScene.DailyHeart;
        NearbyCardHeart = new VipPurchaseEntranceType("NearbyCardHeart", 42, sensorPosition14, "DAILY_HEART", createOrderScene9.getValue());
        DailyHeart = new VipPurchaseEntranceType("DailyHeart", 43, SensorPosition.DailyHeart, "DAILY_HEART", createOrderScene9.getValue());
        SensorPosition sensorPosition15 = SensorPosition.CONTACT_MANAGEMENT;
        CreateOrderScene createOrderScene10 = CreateOrderScene.ContactManager;
        ContactManager = new VipPurchaseEntranceType("ContactManager", 44, sensorPosition15, "CONTACT_MANAGEMENT", createOrderScene10.getValue());
        UnAloha = new VipPurchaseEntranceType("UnAloha", 45, SensorPosition.CancelAloha, "CANCEL_ALOHA_LIST", createOrderScene10.getValue());
        SensorPosition sensorPosition16 = SensorPosition.INTELLIGENT_FILTER;
        CreateOrderScene createOrderScene11 = CreateOrderScene.IntelligentFilter;
        IntelligentFilter = new VipPurchaseEntranceType("IntelligentFilter", 46, sensorPosition16, "INTELLIGENT_FILTER", createOrderScene11.getValue());
        IntelligentFilterInMatch = new VipPurchaseEntranceType("IntelligentFilterInMatch", 47, sensorPosition6, "INTELLIGENT_FILTER", createOrderScene11.getValue());
        IntelligentFilterInSearch = new VipPurchaseEntranceType("IntelligentFilterInSearch", 48, sensorPosition9, "NICKNAME_SEARCH_KEYWORD", createOrderScene11.getValue());
        SuperFilterInSearch = new VipPurchaseEntranceType("SuperFilterInSearch", 49, sensorPosition9, "", createOrderScene3.getValue());
        CreateOrderScene createOrderScene12 = CreateOrderScene.Web;
        PersonalFrame = new VipPurchaseEntranceType("PersonalFrame", 50, sensorPosition13, "PERSONAL_FRAME", createOrderScene12.getValue());
        CustomChatBubble = new VipPurchaseEntranceType("CustomChatBubble", 51, sensorPosition13, "CUSTOM_CHAT_BUBBLE", createOrderScene12.getValue());
        DynEntrance = new VipPurchaseEntranceType("DynEntrance", 52, sensorPosition13, "", createOrderScene12.getValue());
        SensorPosition sensorPosition17 = SensorPosition.NotifyAloha;
        CreateOrderScene createOrderScene13 = CreateOrderScene.WhoAlohaYou;
        NotifyAlohaYou = new VipPurchaseEntranceType("NotifyAlohaYou", 53, sensorPosition17, "WHO_ALOHA_YOU", createOrderScene13.getValue());
        MyAlohaGet = new VipPurchaseEntranceType("MyAlohaGet", 54, SensorPosition.MyAlohaGet, "WHO_ALOHA_YOU", createOrderScene13.getValue());
        UnLimitSwipeCard = new VipPurchaseEntranceType("UnLimitSwipeCard", 55, sensorPosition8, "UNLIMITED_ALOHA", CreateOrderScene.UnLimitSwipeCard.getValue());
        FeedSpread = new VipPurchaseEntranceType("FeedSpread", 56, sensorPosition13, "POST_SPREAD", createOrderScene12.getValue());
        Visitor = new VipPurchaseEntranceType("Visitor", 57, SensorPosition.MyVisitors, "VISITOR_PACKAGE", CreateOrderScene.Visitor.getValue());
        FeedTop = new VipPurchaseEntranceType("FeedTop", 58, SensorPosition.PostStream, "POST_TOP", CreateOrderScene.FeedTop.getValue());
        RainbowRecommend = new VipPurchaseEntranceType("RainbowRecommend", 59, SensorPosition.RainbowRecommend, "RAINBOW_A_PLUS_RECOMMEND", CreateOrderScene.RainbowRecommend.getValue());
        AiIdentify = new VipPurchaseEntranceType("AiIdentify", 60, SensorPosition.AiIdentify, "AI_FACE_IDENTITY", CreateOrderScene.AiIdentify.getValue());
        NearbyUnLock = new VipPurchaseEntranceType("NearbyUnLock", 61, sensorPosition12, "MESSAGE_NEARBY", CreateOrderScene.MessageUnlockNearby.getValue());
        $VALUES = $values();
    }

    private VipPurchaseEntranceType(String str, int i10, SensorPosition sensorPosition, String str2, int i11) {
        this.position = sensorPosition;
        this.from = str2;
        this.scene = i11;
    }

    public static VipPurchaseEntranceType valueOf(String str) {
        return (VipPurchaseEntranceType) Enum.valueOf(VipPurchaseEntranceType.class, str);
    }

    public static VipPurchaseEntranceType[] values() {
        return (VipPurchaseEntranceType[]) $VALUES.clone();
    }

    @NotNull
    public final String getFrom() {
        return this.from;
    }

    @NotNull
    public final SensorPosition getPosition() {
        return this.position;
    }

    public final int getScene() {
        return this.scene;
    }

    public final void setFrom(@NotNull String str) {
        kotlin.jvm.internal.s.i(str, "<set-?>");
        this.from = str;
    }

    public final void setPosition(@NotNull SensorPosition sensorPosition) {
        kotlin.jvm.internal.s.i(sensorPosition, "<set-?>");
        this.position = sensorPosition;
    }

    public final void setScene(int i10) {
        this.scene = i10;
    }
}
