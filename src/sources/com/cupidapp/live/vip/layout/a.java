package com.cupidapp.live.vip.layout;

import android.content.Context;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.MaskPartyAddTimesModel;
import com.cupidapp.live.base.network.model.SocialGameConfigModel;
import com.cupidapp.live.vip.model.VipPrivilegeType;
import com.cupidapp.live.vip.model.VipPurchaseGuideUiModel;
import com.cupidapp.live.vip.model.VipType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.r;
import kotlin.collections.s;
import org.jetbrains.annotations.NotNull;
import p1.g;

/* compiled from: VipCircularBannerHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f18806a = new a();

    /* compiled from: VipCircularBannerHelper.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.vip.layout.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class C0174a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18807a;

        static {
            int[] iArr = new int[VipType.values().length];
            try {
                iArr[VipType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VipType.SUPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VipType.RAINBOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VipType.VISITOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f18807a = iArr;
        }
    }

    public final List<VipPurchaseGuideUiModel> a(Context context) {
        MaskPartyAddTimesModel audioGameRoom;
        MaskPartyAddTimesModel maskRoom;
        List m10 = s.m(VipPurchaseEntranceType.Nearby, VipPurchaseEntranceType.NearbyUnLock, VipPurchaseEntranceType.DynEntrance);
        String string = context.getString(R$string.nearby_title);
        kotlin.jvm.internal.s.h(string, "context.getString(R.string.nearby_title)");
        String string2 = context.getString(R$string.nearby_content);
        kotlin.jvm.internal.s.h(string2, "context.getString(R.string.nearby_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel = new VipPurchaseGuideUiModel(m10, R$mipmap.icon_vip_nearby, string, string2, VipPrivilegeType.PeopleNearby, null, null, null, 224, null);
        List m11 = s.m(VipPurchaseEntranceType.FeedNoAd, VipPurchaseEntranceType.SettingNoAd);
        String string3 = context.getString(R$string.vip_forbid_ad);
        kotlin.jvm.internal.s.h(string3, "context.getString(R.string.vip_forbid_ad)");
        String string4 = context.getString(R$string.noAd_content);
        kotlin.jvm.internal.s.h(string4, "context.getString(R.string.noAd_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel2 = new VipPurchaseGuideUiModel(m11, R$mipmap.icon_vip_noad, string3, string4, VipPrivilegeType.AdvertisingPrivileges, null, null, null, 224, null);
        List m12 = s.m(VipPurchaseEntranceType.Filter, VipPurchaseEntranceType.FilterCommon, VipPurchaseEntranceType.ContactFilter, VipPurchaseEntranceType.RcmdFilterGuide);
        String string5 = context.getString(R$string.filter_title);
        kotlin.jvm.internal.s.h(string5, "context.getString(R.string.filter_title)");
        String string6 = context.getString(R$string.filter_content);
        kotlin.jvm.internal.s.h(string6, "context.getString(R.string.filter_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel3 = new VipPurchaseGuideUiModel(m12, R$mipmap.icon_vip_filter, string5, string6, VipPrivilegeType.PreciseScreening, null, null, null, 224, null);
        List e2 = r.e(VipPurchaseEntranceType.Roaming);
        String string7 = context.getString(R$string.roaming_title);
        kotlin.jvm.internal.s.h(string7, "context.getString(R.string.roaming_title)");
        String string8 = context.getString(R$string.roaming_content);
        kotlin.jvm.internal.s.h(string8, "context.getString(R.string.roaming_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel4 = new VipPurchaseGuideUiModel(e2, R$mipmap.icon_vip_roaming, string7, string8, VipPrivilegeType.CityRoaming, null, null, null, 224, null);
        List e10 = r.e(VipPurchaseEntranceType.PrivacyHideActive);
        String string9 = context.getString(R$string.privacy_title);
        kotlin.jvm.internal.s.h(string9, "context.getString(R.string.privacy_title)");
        String string10 = context.getString(R$string.privacy_content);
        kotlin.jvm.internal.s.h(string10, "context.getString(R.string.privacy_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel5 = new VipPurchaseGuideUiModel(e10, R$mipmap.icon_vip_privacy, string9, string10, VipPrivilegeType.HideActiveTime, null, null, null, 224, null);
        String string11 = context.getString(R$string.enter_car_title);
        kotlin.jvm.internal.s.h(string11, "context.getString(R.string.enter_car_title)");
        String string12 = context.getString(R$string.enter_car_content);
        kotlin.jvm.internal.s.h(string12, "context.getString(R.string.enter_car_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel6 = new VipPurchaseGuideUiModel(null, R$mipmap.icon_vip_enter_car, string11, string12, VipPrivilegeType.ApproachVehicle, null, null, null, 224, null);
        List e11 = r.e(VipPurchaseEntranceType.VideoAvatarEdit);
        String string13 = context.getString(R$string.video_avatar);
        kotlin.jvm.internal.s.h(string13, "context.getString(R.string.video_avatar)");
        String string14 = context.getString(R$string.video_avatar_content);
        kotlin.jvm.internal.s.h(string14, "context.getString(R.string.video_avatar_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel7 = new VipPurchaseGuideUiModel(e11, R$mipmap.icon_vip_dynamic_avatar, string13, string14, VipPrivilegeType.DynamicAvatar, null, Integer.valueOf(R$mipmap.icon_vip_dynamic_avatar_logo), null, 160, null);
        List e12 = r.e(VipPurchaseEntranceType.PrivacyHideVipIcon);
        String string15 = context.getString(R$string.exclusive_logo);
        kotlin.jvm.internal.s.h(string15, "context.getString(R.string.exclusive_logo)");
        String string16 = context.getString(R$string.rainbow_vip_exclusive_logo_content);
        kotlin.jvm.internal.s.h(string16, "context.getString(R.stri…p_exclusive_logo_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel8 = new VipPurchaseGuideUiModel(e12, R$mipmap.icon_vip_guide_bg, string15, string16, VipPrivilegeType.ExclusiveLogo, null, Integer.valueOf(R$mipmap.icon_vip_exclusive_logo), null, 160, null);
        List e13 = r.e(VipPurchaseEntranceType.FeedTop);
        String string17 = context.getString(R$string.feed_set_top);
        kotlin.jvm.internal.s.h(string17, "context.getString(R.string.feed_set_top)");
        String string18 = context.getString(R$string.feed_top_content);
        kotlin.jvm.internal.s.h(string18, "context.getString(R.string.feed_top_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel9 = new VipPurchaseGuideUiModel(e13, R$mipmap.icon_vip_feed_top, string17, string18, VipPrivilegeType.FeedTop, null, null, null, 224, null);
        List e14 = r.e(VipPurchaseEntranceType.WealthLevelHide);
        String string19 = context.getString(R$string.wealth_rank);
        kotlin.jvm.internal.s.h(string19, "context.getString(R.string.wealth_rank)");
        String string20 = context.getString(R$string.wealth_rank_content);
        kotlin.jvm.internal.s.h(string20, "context.getString(R.string.wealth_rank_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel10 = new VipPurchaseGuideUiModel(e14, R$mipmap.icon_vip_guide_bg, string19, string20, VipPrivilegeType.WealthRank, null, Integer.valueOf(R$mipmap.icon_svip_wealth), null, 160, null);
        List e15 = r.e(VipPurchaseEntranceType.PersonalAppIcon);
        String string21 = context.getString(R$string.personal_icon);
        kotlin.jvm.internal.s.h(string21, "context.getString(R.string.personal_icon)");
        String string22 = context.getString(R$string.personal_icon_des);
        kotlin.jvm.internal.s.h(string22, "context.getString(R.string.personal_icon_des)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel11 = new VipPurchaseGuideUiModel(e15, R$mipmap.icon_vip_personal_icon, string21, string22, VipPrivilegeType.PersonalIcon, null, null, null, 224, null);
        ConstantsResult q10 = g.f52734a.q();
        SocialGameConfigModel vasConf = q10 != null ? q10.getVasConf() : null;
        List e16 = r.e(VipPurchaseEntranceType.MaskPartyPrivilege);
        String string23 = context.getString(R$string.mask_party_privilege);
        kotlin.jvm.internal.s.h(string23, "context.getString(R.string.mask_party_privilege)");
        Object[] objArr = new Object[2];
        Object obj = " ";
        objArr[0] = (vasConf == null || (maskRoom = vasConf.getMaskRoom()) == null) ? " " : Integer.valueOf(maskRoom.getVipDailyAdditionalTimes());
        if (vasConf != null && (audioGameRoom = vasConf.getAudioGameRoom()) != null) {
            obj = Integer.valueOf(audioGameRoom.getVipDailyAdditionalTimes());
        }
        objArr[1] = obj;
        String string24 = context.getString(R$string.mask_party_privilege_content, objArr);
        kotlin.jvm.internal.s.h(string24, "context.getString(\n     …LACE_HOLDER\n            )");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel12 = new VipPurchaseGuideUiModel(e16, R$mipmap.icon_vip_mask_party, string23, string24, VipPrivilegeType.MaskPartyPrivilege, null, null, null, 224, null);
        List e17 = r.e(VipPurchaseEntranceType.UnLimitSwipeCard);
        String string25 = context.getString(R$string.un_limit_swipe);
        kotlin.jvm.internal.s.h(string25, "context.getString(R.string.un_limit_swipe)");
        String string26 = context.getString(R$string.un_limit_swipe_content);
        kotlin.jvm.internal.s.h(string26, "context.getString(R.string.un_limit_swipe_content)");
        return s.n(new VipPurchaseGuideUiModel(e17, R$mipmap.icon_vip_swipe, string25, string26, VipPrivilegeType.UnLimitSwipe, null, null, null, 224, null), vipPurchaseGuideUiModel, vipPurchaseGuideUiModel3, vipPurchaseGuideUiModel4, vipPurchaseGuideUiModel7, vipPurchaseGuideUiModel12, vipPurchaseGuideUiModel5, vipPurchaseGuideUiModel8, vipPurchaseGuideUiModel9, vipPurchaseGuideUiModel6, vipPurchaseGuideUiModel11, vipPurchaseGuideUiModel10, vipPurchaseGuideUiModel2);
    }

    public final List<VipPurchaseGuideUiModel> b(Context context) {
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel;
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel2;
        VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.DynEntrance;
        List e2 = r.e(vipPurchaseEntranceType);
        String string = context.getString(R$string.feed_spread);
        kotlin.jvm.internal.s.h(string, "context.getString(R.string.feed_spread)");
        String string2 = context.getString(R$string.rainbow_vip_dynamic_guide_content);
        kotlin.jvm.internal.s.h(string2, "context.getString(R.stri…ip_dynamic_guide_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel3 = new VipPurchaseGuideUiModel(e2, R$mipmap.icon_rainbow_vip_dynamic_promotion, string, string2, VipPrivilegeType.DynamicPromotion, null, null, null, 224, null);
        List m10 = s.m(VipPurchaseEntranceType.ContactManager, VipPurchaseEntranceType.UnAloha, vipPurchaseEntranceType);
        String string3 = context.getString(R$string.un_match_user_manage);
        kotlin.jvm.internal.s.h(string3, "context.getString(R.string.un_match_user_manage)");
        String string4 = context.getString(R$string.rainbow_vip_contact_manage_content);
        kotlin.jvm.internal.s.h(string4, "context.getString(R.stri…p_contact_manage_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel4 = new VipPurchaseGuideUiModel(m10, R$mipmap.icon_rainbow_vip_address_book, string3, string4, VipPrivilegeType.AddressBook, null, null, null, 224, null);
        List e10 = r.e(VipPurchaseEntranceType.AiIdentify);
        String string5 = context.getString(R$string.ai_identify);
        kotlin.jvm.internal.s.h(string5, "context.getString(R.string.ai_identify)");
        String string6 = context.getString(R$string.ai_identify_intro);
        kotlin.jvm.internal.s.h(string6, "context.getString(R.string.ai_identify_intro)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel5 = new VipPurchaseGuideUiModel(e10, R$mipmap.icon_rainbow_vip_ai, string5, string6, VipPrivilegeType.AiIdentify, null, null, null, 224, null);
        List m11 = s.m(VipPurchaseEntranceType.IntelligentFilter, VipPurchaseEntranceType.IntelligentFilterInSearch, VipPurchaseEntranceType.IntelligentFilterInMatch, VipPurchaseEntranceType.RcmdSSVIPFilterGuide);
        String string7 = context.getString(R$string.smart_filter);
        kotlin.jvm.internal.s.h(string7, "context.getString(R.string.smart_filter)");
        String string8 = context.getString(R$string.rainbow_vip_smart_filter_content);
        kotlin.jvm.internal.s.h(string8, "context.getString(R.stri…vip_smart_filter_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel6 = new VipPurchaseGuideUiModel(m11, R$mipmap.icon_rainbow_vip_smart_filter, string7, string8, VipPrivilegeType.SmartFilter, null, null, null, 224, null);
        List m12 = s.m(VipPurchaseEntranceType.SuperLikeMatch, VipPurchaseEntranceType.SuperLikeFeed, VipPurchaseEntranceType.SuperLikeWeb, VipPurchaseEntranceType.SuperLikeMiniProfile, VipPurchaseEntranceType.SuperLikeProfile, VipPurchaseEntranceType.SuperLikePostLimit);
        String string9 = context.getString(R$string.unlimit_super_like);
        kotlin.jvm.internal.s.h(string9, "context.getString(R.string.unlimit_super_like)");
        String string10 = context.getString(R$string.rainbow_vip_super_like_content);
        kotlin.jvm.internal.s.h(string10, "context.getString(R.stri…w_vip_super_like_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel7 = new VipPurchaseGuideUiModel(m12, R$mipmap.icon_svip_superlike, string9, string10, VipPrivilegeType.SuperLike, null, null, null, 224, null);
        String string11 = context.getString(R$string.exclusive_customer_service);
        kotlin.jvm.internal.s.h(string11, "context.getString(R.stri…clusive_customer_service)");
        String string12 = context.getString(R$string.rainbow_vip_customer_service_content);
        kotlin.jvm.internal.s.h(string12, "context.getString(R.stri…customer_service_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel8 = new VipPurchaseGuideUiModel(null, R$mipmap.icon_rainbow_vip_customer_service, string11, string12, VipPrivilegeType.CustomerService, null, null, null, 224, null);
        List e11 = r.e(vipPurchaseEntranceType);
        String string13 = context.getString(R$string.exclusive_card_frame);
        kotlin.jvm.internal.s.h(string13, "context.getString(R.string.exclusive_card_frame)");
        String string14 = context.getString(R$string.rainbow_vip_card_frame_content);
        kotlin.jvm.internal.s.h(string14, "context.getString(R.stri…w_vip_card_frame_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel9 = new VipPurchaseGuideUiModel(e11, R$mipmap.icon_rainbow_vip_card_border, string13, string14, VipPrivilegeType.CardBorder, null, null, null, 224, null);
        List e12 = r.e(vipPurchaseEntranceType);
        String string15 = context.getString(R$string.chat_bubble);
        kotlin.jvm.internal.s.h(string15, "context.getString(R.string.chat_bubble)");
        String string16 = context.getString(R$string.rainbow_vip_chat_bubble_content);
        kotlin.jvm.internal.s.h(string16, "context.getString(R.stri…_vip_chat_bubble_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel10 = new VipPurchaseGuideUiModel(e12, R$mipmap.icon_rainbow_vip_chat_bubble, string15, string16, VipPrivilegeType.ChatBubble, null, null, null, 224, null);
        String string17 = context.getString(R$string.exposure);
        kotlin.jvm.internal.s.h(string17, "context.getString(R.string.exposure)");
        String string18 = context.getString(R$string.rainbow_vip_superboost_guide_content);
        kotlin.jvm.internal.s.h(string18, "context.getString(R.stri…superboost_guide_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel11 = new VipPurchaseGuideUiModel(null, R$mipmap.icon_rainbow_vip_superboost, string17, string18, VipPrivilegeType.SuperBoost, null, Integer.valueOf(R$mipmap.icon_rainbow_superboost), null, 160, null);
        String string19 = context.getString(R$string.mask_party_item_card);
        kotlin.jvm.internal.s.h(string19, "context.getString(R.string.mask_party_item_card)");
        String string20 = context.getString(R$string.rainbow_vip_item_card_guide_content);
        kotlin.jvm.internal.s.h(string20, "context.getString(R.stri…_item_card_guide_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel12 = new VipPurchaseGuideUiModel(null, R$mipmap.icon_rainbow_vip_item_card, string19, string20, VipPrivilegeType.ItemCard, null, null, null, 224, null);
        List e13 = r.e(VipPurchaseEntranceType.Visitor);
        String string21 = context.getString(R$string.visitor_privilege_pack);
        kotlin.jvm.internal.s.h(string21, "context.getString(R.string.visitor_privilege_pack)");
        String string22 = context.getString(R$string.rainbow_vip_visitor_guide_content);
        kotlin.jvm.internal.s.h(string22, "context.getString(R.stri…ip_visitor_guide_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel13 = new VipPurchaseGuideUiModel(e13, R$mipmap.icon_rainbow_vip_visitor, string21, string22, VipPrivilegeType.Visitor, null, null, null, 224, null);
        if (g.f52734a.s1()) {
            List m13 = s.m(VipPurchaseEntranceType.MyAlohaGet, VipPurchaseEntranceType.NotifyAlohaYou);
            String string23 = context.getString(R$string.who_like_you);
            kotlin.jvm.internal.s.h(string23, "context.getString(R.string.who_like_you)");
            String string24 = context.getString(R$string.who_like_you_content);
            vipPurchaseGuideUiModel = vipPurchaseGuideUiModel13;
            kotlin.jvm.internal.s.h(string24, "context.getString(R.string.who_like_you_content)");
            vipPurchaseGuideUiModel2 = new VipPurchaseGuideUiModel(m13, R$mipmap.icon_svip_aloha, string23, string24, VipPrivilegeType.AlohaGet, null, Integer.valueOf(R$mipmap.icon_aloha_get_number), null, 160, null);
        } else {
            vipPurchaseGuideUiModel = vipPurchaseGuideUiModel13;
            vipPurchaseGuideUiModel2 = null;
        }
        List e14 = r.e(VipPurchaseEntranceType.UnLimitSwipeCard);
        String string25 = context.getString(R$string.un_limit_swipe);
        kotlin.jvm.internal.s.h(string25, "context.getString(R.string.un_limit_swipe)");
        String string26 = context.getString(R$string.un_limit_swipe_content);
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel14 = vipPurchaseGuideUiModel2;
        kotlin.jvm.internal.s.h(string26, "context.getString(R.string.un_limit_swipe_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel15 = new VipPurchaseGuideUiModel(e14, R$mipmap.icon_svip_swipe, string25, string26, VipPrivilegeType.UnLimitSwipe, null, null, null, 224, null);
        List m14 = s.m(VipPurchaseEntranceType.SuperFilter, VipPurchaseEntranceType.SuperFilterCommon, VipPurchaseEntranceType.ContactSuperFilter, VipPurchaseEntranceType.RcmdSuperFilterGuide);
        String string27 = context.getString(R$string.super_filter_title);
        kotlin.jvm.internal.s.h(string27, "context.getString(R.string.super_filter_title)");
        String string28 = context.getString(R$string.super_filter_content);
        kotlin.jvm.internal.s.h(string28, "context.getString(R.string.super_filter_content)");
        VipPrivilegeType vipPrivilegeType = VipPrivilegeType.AdvancedFilter;
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel16 = new VipPurchaseGuideUiModel(m14, R$mipmap.icon_svip_gaojishaixuan, string27, string28, vipPrivilegeType, null, null, null, 224, null);
        List m15 = s.m(VipPurchaseEntranceType.MapFilter, VipPurchaseEntranceType.NearByMapFilter, VipPurchaseEntranceType.GuideMap, VipPurchaseEntranceType.SearchGuideMap, vipPurchaseEntranceType);
        String string29 = context.getString(R$string.map_filter_title);
        kotlin.jvm.internal.s.h(string29, "context.getString(R.string.map_filter_title)");
        String string30 = context.getString(R$string.map_filter_content);
        kotlin.jvm.internal.s.h(string30, "context.getString(R.string.map_filter_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel17 = new VipPurchaseGuideUiModel(m15, R$mipmap.icon_svip_map, string29, string30, VipPrivilegeType.MapForPeople, null, null, null, 224, null);
        List m16 = s.m(VipPurchaseEntranceType.Nearby, VipPurchaseEntranceType.NearbyUnLock, vipPurchaseEntranceType);
        String string31 = context.getString(R$string.nearby_title);
        kotlin.jvm.internal.s.h(string31, "context.getString(R.string.nearby_title)");
        String string32 = context.getString(R$string.nearby_content);
        kotlin.jvm.internal.s.h(string32, "context.getString(R.string.nearby_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel18 = new VipPurchaseGuideUiModel(m16, R$mipmap.icon_svip_nearby, string31, string32, VipPrivilegeType.PeopleNearby, null, null, null, 224, null);
        List m17 = s.m(VipPurchaseEntranceType.Filter, VipPurchaseEntranceType.FilterCommon, VipPurchaseEntranceType.ContactFilter, VipPurchaseEntranceType.RcmdFilterGuide);
        String string33 = context.getString(R$string.filter_title);
        kotlin.jvm.internal.s.h(string33, "context.getString(R.string.filter_title)");
        String string34 = context.getString(R$string.filter_content);
        kotlin.jvm.internal.s.h(string34, "context.getString(R.string.filter_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel19 = new VipPurchaseGuideUiModel(m17, R$mipmap.icon_svip_filter, string33, string34, VipPrivilegeType.PreciseScreening, null, null, null, 224, null);
        List e15 = r.e(VipPurchaseEntranceType.Roaming);
        String string35 = context.getString(R$string.roaming_title);
        kotlin.jvm.internal.s.h(string35, "context.getString(R.string.roaming_title)");
        String string36 = context.getString(R$string.roaming_content);
        kotlin.jvm.internal.s.h(string36, "context.getString(R.string.roaming_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel20 = new VipPurchaseGuideUiModel(e15, R$mipmap.icon_svip_roaming, string35, string36, VipPrivilegeType.CityRoaming, null, null, null, 224, null);
        List e16 = r.e(VipPurchaseEntranceType.VideoAvatarEdit);
        String string37 = context.getString(R$string.video_avatar);
        kotlin.jvm.internal.s.h(string37, "context.getString(R.string.video_avatar)");
        String string38 = context.getString(R$string.video_avatar_content);
        kotlin.jvm.internal.s.h(string38, "context.getString(R.string.video_avatar_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel21 = new VipPurchaseGuideUiModel(e16, R$mipmap.icon_svip_dynamic_avatar, string37, string38, VipPrivilegeType.DynamicAvatar, null, Integer.valueOf(R$mipmap.icon_svip_dynamic_avatar_logo), null, 160, null);
        List m18 = s.m(VipPurchaseEntranceType.NearbyCardHeart, VipPurchaseEntranceType.DailyHeart);
        String string39 = context.getString(R$string.heart_beat);
        kotlin.jvm.internal.s.h(string39, "context.getString(R.string.heart_beat)");
        String string40 = context.getString(R$string.heart_beat_des);
        kotlin.jvm.internal.s.h(string40, "context.getString(R.string.heart_beat_des)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel22 = new VipPurchaseGuideUiModel(m18, R$mipmap.icon_svip_heart, string39, string40, VipPrivilegeType.DailyHeart, null, null, null, 224, null);
        List e17 = r.e(VipPurchaseEntranceType.MaskPartyPrivilege);
        String string41 = context.getString(R$string.mask_party_privilege);
        kotlin.jvm.internal.s.h(string41, "context.getString(R.string.mask_party_privilege)");
        String string42 = context.getString(R$string.rainbow_vip_mask_party_content);
        kotlin.jvm.internal.s.h(string42, "context.getString(R.stri…w_vip_mask_party_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel23 = new VipPurchaseGuideUiModel(e17, R$mipmap.icon_svip_mask_party, string41, string42, VipPrivilegeType.MaskPartyPrivilege, null, null, null, 224, null);
        List m19 = s.m(VipPurchaseEntranceType.HiddenFootmark, VipPurchaseEntranceType.HiddenFootmarkPrivacySetting);
        String string43 = context.getString(R$string.hide_title);
        kotlin.jvm.internal.s.h(string43, "context.getString(R.string.hide_title)");
        String string44 = context.getString(R$string.hide_content);
        kotlin.jvm.internal.s.h(string44, "context.getString(R.string.hide_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel24 = new VipPurchaseGuideUiModel(m19, R$mipmap.icon_svip_footprint, string43, string44, VipPrivilegeType.HideFootsteps, null, null, null, 224, null);
        List m20 = s.m(VipPurchaseEntranceType.ViewPrivatelyMessage, VipPurchaseEntranceType.ViewPrivatelyMessageDetail, VipPurchaseEntranceType.ViewPrivatelyPrivacySetting);
        String string45 = context.getString(R$string.quiet_msg);
        kotlin.jvm.internal.s.h(string45, "context.getString(R.string.quiet_msg)");
        String string46 = context.getString(R$string.quiet_content);
        kotlin.jvm.internal.s.h(string46, "context.getString(R.string.quiet_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel25 = new VipPurchaseGuideUiModel(m20, R$mipmap.icon_svip_quiet, string45, string46, VipPrivilegeType.CheckQuietly, null, null, null, 224, null);
        List e18 = r.e(VipPurchaseEntranceType.PrivacyHideLocation);
        String string47 = context.getString(R$string.hide_my_location);
        kotlin.jvm.internal.s.h(string47, "context.getString(R.string.hide_my_location)");
        String string48 = context.getString(R$string.hide_my_location_content);
        kotlin.jvm.internal.s.h(string48, "context.getString(R.stri…hide_my_location_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel26 = new VipPurchaseGuideUiModel(e18, R$mipmap.icon_svip_location, string47, string48, VipPrivilegeType.HideDistance, null, null, null, 224, null);
        List e19 = r.e(VipPurchaseEntranceType.PrivacyHideMe);
        String string49 = context.getString(R$string.hide_me_in_match_and_nearby);
        kotlin.jvm.internal.s.h(string49, "context.getString(R.stri…e_me_in_match_and_nearby)");
        String string50 = context.getString(R$string.hide_me_content);
        kotlin.jvm.internal.s.h(string50, "context.getString(R.string.hide_me_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel27 = new VipPurchaseGuideUiModel(e19, R$mipmap.icon_svip_guide_bg, string49, string50, VipPrivilegeType.CustomStealth, null, Integer.valueOf(R$mipmap.icon_svip_hide), null, 160, null);
        List m21 = s.m(VipPurchaseEntranceType.SuperFilterMBTI, VipPurchaseEntranceType.MBTIFilter, VipPurchaseEntranceType.SuperFilterInSearch);
        String string51 = context.getString(R$string.mbti_filter_title);
        kotlin.jvm.internal.s.h(string51, "context.getString(R.string.mbti_filter_title)");
        String string52 = context.getString(R$string.mbti_filter_con);
        kotlin.jvm.internal.s.h(string52, "context.getString(R.string.mbti_filter_con)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel28 = new VipPurchaseGuideUiModel(m21, R$mipmap.ic_purchase_mbti, string51, string52, vipPrivilegeType, null, null, null, 224, null);
        List e20 = r.e(VipPurchaseEntranceType.PrivacyHideActive);
        String string53 = context.getString(R$string.privacy_title);
        kotlin.jvm.internal.s.h(string53, "context.getString(R.string.privacy_title)");
        String string54 = context.getString(R$string.privacy_content);
        kotlin.jvm.internal.s.h(string54, "context.getString(R.string.privacy_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel29 = new VipPurchaseGuideUiModel(e20, R$mipmap.icon_svip_privacy, string53, string54, VipPrivilegeType.HideActiveTime, null, null, null, 224, null);
        List e21 = r.e(VipPurchaseEntranceType.PrivacyHideVipIcon);
        String string55 = context.getString(R$string.exclusive_logo);
        kotlin.jvm.internal.s.h(string55, "context.getString(R.string.exclusive_logo)");
        String string56 = context.getString(R$string.rainbow_vip_exclusive_logo_content);
        kotlin.jvm.internal.s.h(string56, "context.getString(R.stri…p_exclusive_logo_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel30 = new VipPurchaseGuideUiModel(e21, R$mipmap.icon_svip_guide_bg, string55, string56, VipPrivilegeType.ExclusiveLogo, null, Integer.valueOf(R$mipmap.icon_rainbow_vip_exclusive_logo), null, 160, null);
        List e22 = r.e(VipPurchaseEntranceType.FeedTop);
        String string57 = context.getString(R$string.feed_set_top);
        kotlin.jvm.internal.s.h(string57, "context.getString(R.string.feed_set_top)");
        String string58 = context.getString(R$string.feed_top_content);
        kotlin.jvm.internal.s.h(string58, "context.getString(R.string.feed_top_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel31 = new VipPurchaseGuideUiModel(e22, R$mipmap.icon_svip_feed_top, string57, string58, VipPrivilegeType.FeedTop, null, null, null, 224, null);
        String string59 = context.getString(R$string.enter_car_title);
        kotlin.jvm.internal.s.h(string59, "context.getString(R.string.enter_car_title)");
        String string60 = context.getString(R$string.enter_car_content);
        kotlin.jvm.internal.s.h(string60, "context.getString(R.string.enter_car_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel32 = new VipPurchaseGuideUiModel(null, R$mipmap.icon_rainbow_vip_enter_car, string59, string60, VipPrivilegeType.ApproachVehicle, null, null, null, 224, null);
        List e23 = r.e(VipPurchaseEntranceType.PersonalAppIcon);
        String string61 = context.getString(R$string.personal_icon);
        kotlin.jvm.internal.s.h(string61, "context.getString(R.string.personal_icon)");
        String string62 = context.getString(R$string.personal_icon_des);
        kotlin.jvm.internal.s.h(string62, "context.getString(R.string.personal_icon_des)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel33 = new VipPurchaseGuideUiModel(e23, R$mipmap.icon_svip_personal_icon, string61, string62, VipPrivilegeType.PersonalIcon, null, null, null, 224, null);
        List e24 = r.e(VipPurchaseEntranceType.WealthLevelHide);
        String string63 = context.getString(R$string.wealth_rank);
        kotlin.jvm.internal.s.h(string63, "context.getString(R.string.wealth_rank)");
        String string64 = context.getString(R$string.wealth_rank_content);
        kotlin.jvm.internal.s.h(string64, "context.getString(R.string.wealth_rank_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel34 = new VipPurchaseGuideUiModel(e24, R$mipmap.icon_svip_guide_bg, string63, string64, VipPrivilegeType.WealthRank, null, Integer.valueOf(R$mipmap.icon_svip_wealth), null, 160, null);
        List m22 = s.m(VipPurchaseEntranceType.FeedNoAd, VipPurchaseEntranceType.SettingNoAd);
        String string65 = context.getString(R$string.vip_forbid_ad);
        kotlin.jvm.internal.s.h(string65, "context.getString(R.string.vip_forbid_ad)");
        String string66 = context.getString(R$string.noAd_content);
        kotlin.jvm.internal.s.h(string66, "context.getString(R.string.noAd_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel35 = new VipPurchaseGuideUiModel(m22, R$mipmap.icon_svip_noad, string65, string66, VipPrivilegeType.AdvertisingPrivileges, context.getString(R$string.advertising_privileges_note), null, null, 192, null);
        List m23 = s.m(VipPurchaseEntranceType.RainbowRecommend, vipPurchaseEntranceType);
        String string67 = context.getString(R$string.exclusive_traffic_exposure);
        kotlin.jvm.internal.s.h(string67, "context.getString(R.stri…clusive_traffic_exposure)");
        String string68 = context.getString(R$string.exclusive_traffic_exposure_content);
        kotlin.jvm.internal.s.h(string68, "context.getString(R.stri…traffic_exposure_content)");
        return s.n(new VipPurchaseGuideUiModel(m23, R$mipmap.icon_rainbow_recommend, string67, string68, VipPrivilegeType.RainbowRecommend, null, null, null, 224, null), vipPurchaseGuideUiModel3, vipPurchaseGuideUiModel4, vipPurchaseGuideUiModel5, vipPurchaseGuideUiModel6, vipPurchaseGuideUiModel7, vipPurchaseGuideUiModel8, vipPurchaseGuideUiModel9, vipPurchaseGuideUiModel10, vipPurchaseGuideUiModel11, vipPurchaseGuideUiModel12, vipPurchaseGuideUiModel, vipPurchaseGuideUiModel14, vipPurchaseGuideUiModel15, vipPurchaseGuideUiModel16, vipPurchaseGuideUiModel17, vipPurchaseGuideUiModel18, vipPurchaseGuideUiModel19, vipPurchaseGuideUiModel20, vipPurchaseGuideUiModel21, vipPurchaseGuideUiModel22, vipPurchaseGuideUiModel23, vipPurchaseGuideUiModel24, vipPurchaseGuideUiModel25, vipPurchaseGuideUiModel26, vipPurchaseGuideUiModel27, vipPurchaseGuideUiModel28, vipPurchaseGuideUiModel29, vipPurchaseGuideUiModel30, vipPurchaseGuideUiModel31, vipPurchaseGuideUiModel32, vipPurchaseGuideUiModel33, vipPurchaseGuideUiModel34, vipPurchaseGuideUiModel35);
    }

    public final List<VipPurchaseGuideUiModel> c(Context context) {
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel;
        MaskPartyAddTimesModel audioGameRoom;
        MaskPartyAddTimesModel maskRoom;
        List m10 = s.m(VipPurchaseEntranceType.SuperFilter, VipPurchaseEntranceType.SuperFilterCommon, VipPurchaseEntranceType.ContactSuperFilter, VipPurchaseEntranceType.RoleFilter, VipPurchaseEntranceType.ZodiacFilter, VipPurchaseEntranceType.RcmdSuperFilterGuide);
        String string = context.getString(R$string.super_filter_title);
        kotlin.jvm.internal.s.h(string, "context.getString(R.string.super_filter_title)");
        String string2 = context.getString(R$string.super_filter_content);
        kotlin.jvm.internal.s.h(string2, "context.getString(R.string.super_filter_content)");
        VipPrivilegeType vipPrivilegeType = VipPrivilegeType.AdvancedFilter;
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel2 = new VipPurchaseGuideUiModel(m10, R$mipmap.icon_svip_gaojishaixuan, string, string2, vipPrivilegeType, null, null, null, 224, null);
        VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.DynEntrance;
        List m11 = s.m(VipPurchaseEntranceType.MapFilter, VipPurchaseEntranceType.NearByMapFilter, VipPurchaseEntranceType.GuideMap, VipPurchaseEntranceType.SearchGuideMap, vipPurchaseEntranceType);
        String string3 = context.getString(R$string.map_filter_title);
        kotlin.jvm.internal.s.h(string3, "context.getString(R.string.map_filter_title)");
        String string4 = context.getString(R$string.map_filter_content);
        kotlin.jvm.internal.s.h(string4, "context.getString(R.string.map_filter_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel3 = new VipPurchaseGuideUiModel(m11, R$mipmap.icon_svip_map, string3, string4, VipPrivilegeType.MapForPeople, null, null, null, 224, null);
        List m12 = s.m(VipPurchaseEntranceType.HiddenFootmark, VipPurchaseEntranceType.HiddenFootmarkPrivacySetting);
        String string5 = context.getString(R$string.hide_title);
        kotlin.jvm.internal.s.h(string5, "context.getString(R.string.hide_title)");
        String string6 = context.getString(R$string.hide_content);
        kotlin.jvm.internal.s.h(string6, "context.getString(R.string.hide_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel4 = new VipPurchaseGuideUiModel(m12, R$mipmap.icon_svip_footprint, string5, string6, VipPrivilegeType.HideFootsteps, null, null, null, 224, null);
        List m13 = s.m(VipPurchaseEntranceType.ViewPrivatelyMessage, VipPurchaseEntranceType.ViewPrivatelyMessageDetail, VipPurchaseEntranceType.ViewPrivatelyPrivacySetting);
        String string7 = context.getString(R$string.quiet_msg);
        kotlin.jvm.internal.s.h(string7, "context.getString(R.string.quiet_msg)");
        String string8 = context.getString(R$string.quiet_content);
        kotlin.jvm.internal.s.h(string8, "context.getString(R.string.quiet_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel5 = new VipPurchaseGuideUiModel(m13, R$mipmap.icon_svip_quiet, string7, string8, VipPrivilegeType.CheckQuietly, null, null, null, 224, null);
        List e2 = r.e(VipPurchaseEntranceType.PrivacyHideLocation);
        String string9 = context.getString(R$string.hide_my_location);
        kotlin.jvm.internal.s.h(string9, "context.getString(R.string.hide_my_location)");
        String string10 = context.getString(R$string.hide_my_location_content);
        kotlin.jvm.internal.s.h(string10, "context.getString(R.stri…hide_my_location_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel6 = new VipPurchaseGuideUiModel(e2, R$mipmap.icon_svip_location, string9, string10, VipPrivilegeType.HideDistance, null, null, null, 224, null);
        List m14 = s.m(VipPurchaseEntranceType.PrivacyHideMe, vipPurchaseEntranceType);
        String string11 = context.getString(R$string.hide_me_in_match_and_nearby);
        kotlin.jvm.internal.s.h(string11, "context.getString(R.stri…e_me_in_match_and_nearby)");
        String string12 = context.getString(R$string.hide_me_content);
        kotlin.jvm.internal.s.h(string12, "context.getString(R.string.hide_me_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel7 = new VipPurchaseGuideUiModel(m14, R$mipmap.icon_svip_guide_bg, string11, string12, VipPrivilegeType.CustomStealth, null, Integer.valueOf(R$mipmap.icon_svip_hide), null, 160, null);
        List m15 = s.m(VipPurchaseEntranceType.SuperFilterMBTI, VipPurchaseEntranceType.MBTIFilter, VipPurchaseEntranceType.SuperFilterInSearch);
        String string13 = context.getString(R$string.mbti_filter_title);
        kotlin.jvm.internal.s.h(string13, "context.getString(R.string.mbti_filter_title)");
        String string14 = context.getString(R$string.mbti_filter_con);
        kotlin.jvm.internal.s.h(string14, "context.getString(R.string.mbti_filter_con)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel8 = new VipPurchaseGuideUiModel(m15, R$mipmap.ic_purchase_mbti, string13, string14, vipPrivilegeType, null, null, null, 224, null);
        List m16 = s.m(VipPurchaseEntranceType.SuperLikeMatch, VipPurchaseEntranceType.SuperLikeFeed, VipPurchaseEntranceType.SuperLikeWeb, VipPurchaseEntranceType.SuperLikeMiniProfile, VipPurchaseEntranceType.SuperLikeProfile, VipPurchaseEntranceType.SuperLikePostLimit);
        String string15 = context.getString(R$string.super_like_five_month);
        kotlin.jvm.internal.s.h(string15, "context.getString(R.string.super_like_five_month)");
        String string16 = context.getString(R$string.super_like_content);
        kotlin.jvm.internal.s.h(string16, "context.getString(R.string.super_like_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel9 = new VipPurchaseGuideUiModel(m16, R$mipmap.icon_svip_superlike, string15, string16, VipPrivilegeType.SuperLike, null, null, null, 224, null);
        List m17 = s.m(VipPurchaseEntranceType.NearbyCardHeart, VipPurchaseEntranceType.DailyHeart);
        String string17 = context.getString(R$string.heart_beat);
        kotlin.jvm.internal.s.h(string17, "context.getString(R.string.heart_beat)");
        String string18 = context.getString(R$string.heart_beat_des);
        kotlin.jvm.internal.s.h(string18, "context.getString(R.string.heart_beat_des)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel10 = new VipPurchaseGuideUiModel(m17, R$mipmap.icon_svip_heart, string17, string18, VipPrivilegeType.DailyHeart, null, null, null, 224, null);
        List m18 = s.m(VipPurchaseEntranceType.Nearby, VipPurchaseEntranceType.NearbyUnLock, vipPurchaseEntranceType);
        String string19 = context.getString(R$string.nearby_title);
        kotlin.jvm.internal.s.h(string19, "context.getString(R.string.nearby_title)");
        String string20 = context.getString(R$string.nearby_content);
        kotlin.jvm.internal.s.h(string20, "context.getString(R.string.nearby_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel11 = new VipPurchaseGuideUiModel(m18, R$mipmap.icon_svip_nearby, string19, string20, VipPrivilegeType.PeopleNearby, null, null, null, 224, null);
        List m19 = s.m(VipPurchaseEntranceType.FeedNoAd, VipPurchaseEntranceType.SettingNoAd);
        String string21 = context.getString(R$string.vip_forbid_ad);
        kotlin.jvm.internal.s.h(string21, "context.getString(R.string.vip_forbid_ad)");
        String string22 = context.getString(R$string.noAd_content);
        kotlin.jvm.internal.s.h(string22, "context.getString(R.string.noAd_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel12 = new VipPurchaseGuideUiModel(m19, R$mipmap.icon_svip_noad, string21, string22, VipPrivilegeType.AdvertisingPrivileges, context.getString(R$string.advertising_privileges_note), null, null, 192, null);
        List m20 = s.m(VipPurchaseEntranceType.Filter, VipPurchaseEntranceType.FilterCommon, VipPurchaseEntranceType.ContactFilter, VipPurchaseEntranceType.RcmdFilterGuide);
        String string23 = context.getString(R$string.filter_title);
        kotlin.jvm.internal.s.h(string23, "context.getString(R.string.filter_title)");
        String string24 = context.getString(R$string.filter_content);
        kotlin.jvm.internal.s.h(string24, "context.getString(R.string.filter_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel13 = new VipPurchaseGuideUiModel(m20, R$mipmap.icon_svip_filter, string23, string24, VipPrivilegeType.PreciseScreening, null, null, null, 224, null);
        List e10 = r.e(VipPurchaseEntranceType.Roaming);
        String string25 = context.getString(R$string.roaming_title);
        kotlin.jvm.internal.s.h(string25, "context.getString(R.string.roaming_title)");
        String string26 = context.getString(R$string.roaming_content);
        kotlin.jvm.internal.s.h(string26, "context.getString(R.string.roaming_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel14 = new VipPurchaseGuideUiModel(e10, R$mipmap.icon_svip_roaming, string25, string26, VipPrivilegeType.CityRoaming, null, null, null, 224, null);
        List e11 = r.e(VipPurchaseEntranceType.PrivacyHideActive);
        String string27 = context.getString(R$string.privacy_title);
        kotlin.jvm.internal.s.h(string27, "context.getString(R.string.privacy_title)");
        String string28 = context.getString(R$string.privacy_content);
        kotlin.jvm.internal.s.h(string28, "context.getString(R.string.privacy_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel15 = new VipPurchaseGuideUiModel(e11, R$mipmap.icon_svip_privacy, string27, string28, VipPrivilegeType.HideActiveTime, null, null, null, 224, null);
        String string29 = context.getString(R$string.enter_car_title);
        kotlin.jvm.internal.s.h(string29, "context.getString(R.string.enter_car_title)");
        String string30 = context.getString(R$string.enter_car_content);
        kotlin.jvm.internal.s.h(string30, "context.getString(R.string.enter_car_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel16 = new VipPurchaseGuideUiModel(null, R$mipmap.icon_svip_enter_car, string29, string30, VipPrivilegeType.ApproachVehicle, null, null, null, 224, null);
        List e12 = r.e(VipPurchaseEntranceType.VideoAvatarEdit);
        String string31 = context.getString(R$string.video_avatar);
        kotlin.jvm.internal.s.h(string31, "context.getString(R.string.video_avatar)");
        String string32 = context.getString(R$string.video_avatar_content);
        kotlin.jvm.internal.s.h(string32, "context.getString(R.string.video_avatar_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel17 = new VipPurchaseGuideUiModel(e12, R$mipmap.icon_svip_dynamic_avatar, string31, string32, VipPrivilegeType.DynamicAvatar, null, Integer.valueOf(R$mipmap.icon_svip_dynamic_avatar_logo), null, 160, null);
        List e13 = r.e(VipPurchaseEntranceType.WealthLevelHide);
        String string33 = context.getString(R$string.wealth_rank);
        kotlin.jvm.internal.s.h(string33, "context.getString(R.string.wealth_rank)");
        String string34 = context.getString(R$string.wealth_rank_content);
        kotlin.jvm.internal.s.h(string34, "context.getString(R.string.wealth_rank_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel18 = new VipPurchaseGuideUiModel(e13, R$mipmap.icon_svip_guide_bg, string33, string34, VipPrivilegeType.WealthRank, null, Integer.valueOf(R$mipmap.icon_svip_wealth), null, 160, null);
        List e14 = r.e(VipPurchaseEntranceType.PrivacyHideVipIcon);
        String string35 = context.getString(R$string.exclusive_logo);
        kotlin.jvm.internal.s.h(string35, "context.getString(R.string.exclusive_logo)");
        String string36 = context.getString(R$string.rainbow_vip_exclusive_logo_content);
        kotlin.jvm.internal.s.h(string36, "context.getString(R.stri…p_exclusive_logo_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel19 = new VipPurchaseGuideUiModel(e14, R$mipmap.icon_svip_guide_bg, string35, string36, VipPrivilegeType.ExclusiveLogo, null, Integer.valueOf(R$mipmap.icon_svip_exclusive_logo), null, 160, null);
        List e15 = r.e(VipPurchaseEntranceType.FeedTop);
        String string37 = context.getString(R$string.feed_set_top);
        kotlin.jvm.internal.s.h(string37, "context.getString(R.string.feed_set_top)");
        String string38 = context.getString(R$string.feed_top_content);
        kotlin.jvm.internal.s.h(string38, "context.getString(R.string.feed_top_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel20 = new VipPurchaseGuideUiModel(e15, R$mipmap.icon_svip_feed_top, string37, string38, VipPrivilegeType.FeedTop, null, null, null, 224, null);
        List e16 = r.e(VipPurchaseEntranceType.PersonalAppIcon);
        String string39 = context.getString(R$string.personal_icon);
        kotlin.jvm.internal.s.h(string39, "context.getString(R.string.personal_icon)");
        String string40 = context.getString(R$string.personal_icon_des);
        kotlin.jvm.internal.s.h(string40, "context.getString(R.string.personal_icon_des)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel21 = new VipPurchaseGuideUiModel(e16, R$mipmap.icon_svip_personal_icon, string39, string40, VipPrivilegeType.PersonalIcon, null, null, null, 224, null);
        g gVar = g.f52734a;
        ConstantsResult q10 = gVar.q();
        SocialGameConfigModel vasConf = q10 != null ? q10.getVasConf() : null;
        List e17 = r.e(VipPurchaseEntranceType.MaskPartyPrivilege);
        String string41 = context.getString(R$string.mask_party_privilege);
        kotlin.jvm.internal.s.h(string41, "context.getString(R.string.mask_party_privilege)");
        Object[] objArr = new Object[2];
        Object obj = " ";
        objArr[0] = (vasConf == null || (maskRoom = vasConf.getMaskRoom()) == null) ? " " : Integer.valueOf(maskRoom.getSvipDailyAdditionalTimes());
        if (vasConf != null && (audioGameRoom = vasConf.getAudioGameRoom()) != null) {
            obj = Integer.valueOf(audioGameRoom.getSvipDailyAdditionalTimes());
        }
        objArr[1] = obj;
        String string42 = context.getString(R$string.mask_party_privilege_content, objArr);
        kotlin.jvm.internal.s.h(string42, "context.getString(\n     …LACE_HOLDER\n            )");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel22 = new VipPurchaseGuideUiModel(e17, R$mipmap.icon_svip_mask_party, string41, string42, VipPrivilegeType.MaskPartyPrivilege, null, null, null, 224, null);
        if (gVar.s1()) {
            List m21 = s.m(VipPurchaseEntranceType.MyAlohaGet, VipPurchaseEntranceType.NotifyAlohaYou);
            String string43 = context.getString(R$string.who_like_you);
            kotlin.jvm.internal.s.h(string43, "context.getString(R.string.who_like_you)");
            String string44 = context.getString(R$string.who_like_you_content);
            kotlin.jvm.internal.s.h(string44, "context.getString(R.string.who_like_you_content)");
            vipPurchaseGuideUiModel = new VipPurchaseGuideUiModel(m21, R$mipmap.icon_svip_aloha, string43, string44, VipPrivilegeType.AlohaGet, null, Integer.valueOf(R$mipmap.icon_aloha_get_number), null, 160, null);
        } else {
            vipPurchaseGuideUiModel = null;
        }
        List e18 = r.e(VipPurchaseEntranceType.UnLimitSwipeCard);
        String string45 = context.getString(R$string.un_limit_swipe);
        kotlin.jvm.internal.s.h(string45, "context.getString(R.string.un_limit_swipe)");
        String string46 = context.getString(R$string.un_limit_swipe_content);
        kotlin.jvm.internal.s.h(string46, "context.getString(R.string.un_limit_swipe_content)");
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel23 = new VipPurchaseGuideUiModel(e18, R$mipmap.icon_svip_swipe, string45, string46, VipPrivilegeType.UnLimitSwipe, null, null, null, 224, null);
        List e19 = r.e(VipPurchaseEntranceType.AiIdentify);
        String string47 = context.getString(R$string.ai_identify);
        kotlin.jvm.internal.s.h(string47, "context.getString(R.string.ai_identify)");
        String string48 = context.getString(R$string.ai_identify_intro);
        kotlin.jvm.internal.s.h(string48, "context.getString(R.string.ai_identify_intro)");
        return s.n(new VipPurchaseGuideUiModel(e19, R$mipmap.icon_svip_ai, string47, string48, VipPrivilegeType.AiIdentify, null, null, null, 224, null), vipPurchaseGuideUiModel, vipPurchaseGuideUiModel23, vipPurchaseGuideUiModel2, vipPurchaseGuideUiModel3, vipPurchaseGuideUiModel9, vipPurchaseGuideUiModel11, vipPurchaseGuideUiModel13, vipPurchaseGuideUiModel14, vipPurchaseGuideUiModel17, vipPurchaseGuideUiModel10, vipPurchaseGuideUiModel22, vipPurchaseGuideUiModel4, vipPurchaseGuideUiModel5, vipPurchaseGuideUiModel6, vipPurchaseGuideUiModel7, vipPurchaseGuideUiModel8, vipPurchaseGuideUiModel15, vipPurchaseGuideUiModel19, vipPurchaseGuideUiModel20, vipPurchaseGuideUiModel16, vipPurchaseGuideUiModel21, vipPurchaseGuideUiModel18, vipPurchaseGuideUiModel12);
    }

    @NotNull
    public final List<VipPurchaseGuideUiModel> d(@NotNull Context context, @NotNull VipType vipType) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(vipType, "vipType");
        int i10 = C0174a.f18807a[vipType.ordinal()];
        if (i10 == 1) {
            return a(context);
        }
        if (i10 == 2) {
            return c(context);
        }
        if (i10 == 3) {
            return b(context);
        }
        if (i10 == 4) {
            return e(context);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final List<VipPurchaseGuideUiModel> e(Context context) {
        List e2 = r.e(VipPurchaseEntranceType.Visitor);
        String string = context.getString(R$string.visitor_privilege_pack);
        kotlin.jvm.internal.s.h(string, "context.getString(R.string.visitor_privilege_pack)");
        String string2 = context.getString(R$string.rainbow_vip_visitor_guide_content);
        kotlin.jvm.internal.s.h(string2, "context.getString(R.stri…ip_visitor_guide_content)");
        return s.o(new VipPurchaseGuideUiModel(e2, R$mipmap.icon_visitor, string, string2, VipPrivilegeType.Visitor, null, null, null, 224, null));
    }
}
