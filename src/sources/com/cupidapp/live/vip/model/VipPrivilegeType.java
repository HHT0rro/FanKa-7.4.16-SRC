package com.cupidapp.live.vip.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'AdvancedFilter' uses external variables
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
/* compiled from: VipPurchaseGuideUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPrivilegeType {
    private static final /* synthetic */ VipPrivilegeType[] $VALUES;
    public static final VipPrivilegeType AddressBook;
    public static final VipPrivilegeType AdvancedFilter;
    public static final VipPrivilegeType AdvertisingPrivileges;
    public static final VipPrivilegeType AiIdentify;
    public static final VipPrivilegeType AlohaGet;
    public static final VipPrivilegeType ApproachVehicle;
    public static final VipPrivilegeType CardBorder;
    public static final VipPrivilegeType ChatBubble;
    public static final VipPrivilegeType CheckQuietly;
    public static final VipPrivilegeType CityRoaming;
    public static final VipPrivilegeType CustomStealth;
    public static final VipPrivilegeType CustomerService;
    public static final VipPrivilegeType DailyHeart;
    public static final VipPrivilegeType DynamicAvatar;
    public static final VipPrivilegeType DynamicPromotion;
    public static final VipPrivilegeType ExclusiveLogo;
    public static final VipPrivilegeType FeedTop;
    public static final VipPrivilegeType HideActiveTime;
    public static final VipPrivilegeType HideDistance;
    public static final VipPrivilegeType HideFootsteps;
    public static final VipPrivilegeType ItemCard;
    public static final VipPrivilegeType MapForPeople;
    public static final VipPrivilegeType MaskPartyPrivilege;
    public static final VipPrivilegeType PeopleNearby;
    public static final VipPrivilegeType PersonalIcon;
    public static final VipPrivilegeType PreciseScreening;
    public static final VipPrivilegeType RainbowRecommend;
    public static final VipPrivilegeType SmartFilter;
    public static final VipPrivilegeType SuperBoost;
    public static final VipPrivilegeType SuperLike;
    public static final VipPrivilegeType UnLimitSwipe;
    public static final VipPrivilegeType Visitor;
    public static final VipPrivilegeType WealthRank;

    @NotNull
    private final VipType belongToMinimumVipType;

    private static final /* synthetic */ VipPrivilegeType[] $values() {
        return new VipPrivilegeType[]{AdvancedFilter, MapForPeople, HideFootsteps, CheckQuietly, HideDistance, CustomStealth, SuperLike, PeopleNearby, AdvertisingPrivileges, HideActiveTime, PreciseScreening, CityRoaming, ApproachVehicle, ExclusiveLogo, FeedTop, DynamicAvatar, PersonalIcon, DailyHeart, MaskPartyPrivilege, WealthRank, SuperBoost, ItemCard, Visitor, DynamicPromotion, AddressBook, SmartFilter, CustomerService, CardBorder, ChatBubble, AlohaGet, UnLimitSwipe, AiIdentify, RainbowRecommend};
    }

    static {
        VipType vipType = VipType.SUPER;
        AdvancedFilter = new VipPrivilegeType("AdvancedFilter", 0, vipType);
        MapForPeople = new VipPrivilegeType("MapForPeople", 1, vipType);
        HideFootsteps = new VipPrivilegeType("HideFootsteps", 2, vipType);
        CheckQuietly = new VipPrivilegeType("CheckQuietly", 3, vipType);
        HideDistance = new VipPrivilegeType("HideDistance", 4, vipType);
        CustomStealth = new VipPrivilegeType("CustomStealth", 5, vipType);
        SuperLike = new VipPrivilegeType("SuperLike", 6, vipType);
        VipType vipType2 = VipType.NORMAL;
        PeopleNearby = new VipPrivilegeType("PeopleNearby", 7, vipType2);
        AdvertisingPrivileges = new VipPrivilegeType("AdvertisingPrivileges", 8, vipType2);
        HideActiveTime = new VipPrivilegeType("HideActiveTime", 9, vipType2);
        PreciseScreening = new VipPrivilegeType("PreciseScreening", 10, vipType2);
        CityRoaming = new VipPrivilegeType("CityRoaming", 11, vipType2);
        ApproachVehicle = new VipPrivilegeType("ApproachVehicle", 12, vipType2);
        ExclusiveLogo = new VipPrivilegeType("ExclusiveLogo", 13, vipType2);
        FeedTop = new VipPrivilegeType("FeedTop", 14, vipType2);
        DynamicAvatar = new VipPrivilegeType("DynamicAvatar", 15, vipType2);
        PersonalIcon = new VipPrivilegeType("PersonalIcon", 16, vipType2);
        DailyHeart = new VipPrivilegeType("DailyHeart", 17, vipType);
        MaskPartyPrivilege = new VipPrivilegeType("MaskPartyPrivilege", 18, vipType2);
        WealthRank = new VipPrivilegeType("WealthRank", 19, vipType2);
        VipType vipType3 = VipType.RAINBOW;
        SuperBoost = new VipPrivilegeType("SuperBoost", 20, vipType3);
        ItemCard = new VipPrivilegeType("ItemCard", 21, vipType3);
        Visitor = new VipPrivilegeType("Visitor", 22, vipType3);
        DynamicPromotion = new VipPrivilegeType("DynamicPromotion", 23, vipType3);
        AddressBook = new VipPrivilegeType("AddressBook", 24, vipType3);
        SmartFilter = new VipPrivilegeType("SmartFilter", 25, vipType3);
        CustomerService = new VipPrivilegeType("CustomerService", 26, vipType3);
        CardBorder = new VipPrivilegeType("CardBorder", 27, vipType3);
        ChatBubble = new VipPrivilegeType("ChatBubble", 28, vipType3);
        AlohaGet = new VipPrivilegeType("AlohaGet", 29, vipType);
        UnLimitSwipe = new VipPrivilegeType("UnLimitSwipe", 30, vipType2);
        AiIdentify = new VipPrivilegeType("AiIdentify", 31, vipType);
        RainbowRecommend = new VipPrivilegeType("RainbowRecommend", 32, vipType3);
        $VALUES = $values();
    }

    private VipPrivilegeType(String str, int i10, VipType vipType) {
        this.belongToMinimumVipType = vipType;
    }

    public static VipPrivilegeType valueOf(String str) {
        return (VipPrivilegeType) Enum.valueOf(VipPrivilegeType.class, str);
    }

    public static VipPrivilegeType[] values() {
        return (VipPrivilegeType[]) $VALUES.clone();
    }

    @NotNull
    public final VipType getBelongToMinimumVipType() {
        return this.belongToMinimumVipType;
    }
}
