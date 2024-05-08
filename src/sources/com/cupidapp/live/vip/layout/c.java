package com.cupidapp.live.vip.layout;

import android.content.Context;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.MaskPartyAddTimesModel;
import com.cupidapp.live.base.network.model.SocialGameConfigModel;
import com.cupidapp.live.vip.model.VipFunctionUiModel;
import com.cupidapp.live.vip.model.VipType;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import p1.g;

/* compiled from: VipFunctionHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f18809a = new c();

    /* compiled from: VipFunctionHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18810a;

        static {
            int[] iArr = new int[VipType.values().length];
            try {
                iArr[VipType.SUPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VipType.RAINBOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18810a = iArr;
        }
    }

    @NotNull
    public final List<VipFunctionUiModel> a(@NotNull Context context, @NotNull VipType vipType) {
        s.i(context, "context");
        s.i(vipType, "vipType");
        int i10 = a.f18810a[vipType.ordinal()];
        if (i10 == 1) {
            return f(context);
        }
        if (i10 != 2) {
            return h(context);
        }
        return d(context);
    }

    public final List<VipFunctionUiModel> b(Context context) {
        String string = context.getString(R$string.nearby_title);
        s.h(string, "context.getString(R.string.nearby_title)");
        String string2 = context.getString(R$string.nearby_content);
        s.h(string2, "context.getString(R.string.nearby_content)");
        VipType vipType = VipType.NORMAL;
        String string3 = context.getString(R$string.filter_title);
        s.h(string3, "context.getString(R.string.filter_title)");
        String string4 = context.getString(R$string.filter_content);
        s.h(string4, "context.getString(R.string.filter_content)");
        String string5 = context.getString(R$string.privacy_title);
        s.h(string5, "context.getString(R.string.privacy_title)");
        String string6 = context.getString(R$string.privacy_content);
        s.h(string6, "context.getString(R.string.privacy_content)");
        String string7 = context.getString(R$string.roaming_title);
        s.h(string7, "context.getString(R.string.roaming_title)");
        String string8 = context.getString(R$string.roaming_content);
        s.h(string8, "context.getString(R.string.roaming_content)");
        String string9 = context.getString(R$string.vip_forbid_ad);
        s.h(string9, "context.getString(R.string.vip_forbid_ad)");
        String string10 = context.getString(R$string.noAd_content);
        s.h(string10, "context.getString(R.string.noAd_content)");
        String string11 = context.getString(R$string.video_avatar);
        s.h(string11, "context.getString(R.string.video_avatar)");
        String string12 = context.getString(R$string.video_avatar_content);
        s.h(string12, "context.getString(R.string.video_avatar_content)");
        return kotlin.collections.s.m(new VipFunctionUiModel(string, R$mipmap.vip_ic_fujinderen, string2, R$mipmap.vip_popup_aplus_fujinderen, false, vipType, null, 64, null), new VipFunctionUiModel(string3, R$mipmap.vip_ic_jingqueshaixuan, string4, R$mipmap.vip_popup_aplus_jingqueshaixuan, false, vipType, null, 64, null), new VipFunctionUiModel(string5, R$mipmap.vip_ic_yincanghuoyueshijian, string6, R$mipmap.vip_popup_aplus_yincanghuoyueshijian, true, vipType, null, 64, null), new VipFunctionUiModel(string7, R$mipmap.vip_ic_chengshimanyou, string8, R$mipmap.vip_popup_aplus_chengshimanyou, false, vipType, null, 64, null), new VipFunctionUiModel(string9, R$mipmap.vip_ic_guanggaotequan, string10, R$mipmap.vip_popup_aplus_guanggaotequan, true, vipType, null, 64, null), new VipFunctionUiModel(string11, R$mipmap.vip_ic_dongtaitouxiang, string12, R$mipmap.vip_popup_aplus_dongtaitouxiang, false, vipType, null, 64, null));
    }

    public final List<VipFunctionUiModel> c(Context context) {
        String string = context.getString(R$string.exclusive_traffic_exposure);
        s.h(string, "context.getString(R.stri…clusive_traffic_exposure)");
        String string2 = context.getString(R$string.exclusive_traffic_exposure_content);
        s.h(string2, "context.getString(R.stri…traffic_exposure_content)");
        VipType vipType = VipType.RAINBOW;
        String string3 = context.getString(R$string.un_match_user_manage);
        s.h(string3, "context.getString(R.string.un_match_user_manage)");
        String string4 = context.getString(R$string.rainbow_vip_contact_manage_content);
        s.h(string4, "context.getString(R.stri…p_contact_manage_content)");
        String string5 = context.getString(R$string.unlimit_super_like);
        s.h(string5, "context.getString(R.string.unlimit_super_like)");
        String string6 = context.getString(R$string.rainbow_vip_super_like_content);
        s.h(string6, "context.getString(R.stri…w_vip_super_like_content)");
        String string7 = context.getString(R$string.hide_my_location);
        s.h(string7, "context.getString(R.string.hide_my_location)");
        String string8 = context.getString(R$string.hide_my_location_content);
        s.h(string8, "context.getString(R.stri…hide_my_location_content)");
        String string9 = context.getString(R$string.nearby_title);
        s.h(string9, "context.getString(R.string.nearby_title)");
        String string10 = context.getString(R$string.nearby_content);
        s.h(string10, "context.getString(R.string.nearby_content)");
        String string11 = context.getString(R$string.map_filter_title);
        s.h(string11, "context.getString(R.string.map_filter_title)");
        String string12 = context.getString(R$string.map_filter_content);
        s.h(string12, "context.getString(R.string.map_filter_content)");
        String string13 = context.getString(R$string.roaming_title);
        s.h(string13, "context.getString(R.string.roaming_title)");
        String string14 = context.getString(R$string.roaming_content);
        s.h(string14, "context.getString(R.string.roaming_content)");
        String string15 = context.getString(R$string.quiet_msg);
        s.h(string15, "context.getString(R.string.quiet_msg)");
        String string16 = context.getString(R$string.quiet_content);
        s.h(string16, "context.getString(R.string.quiet_content)");
        String string17 = context.getString(R$string.super_filter_title);
        s.h(string17, "context.getString(R.string.super_filter_title)");
        String string18 = context.getString(R$string.super_filter_content);
        s.h(string18, "context.getString(R.string.super_filter_content)");
        String string19 = context.getString(R$string.filter_title);
        s.h(string19, "context.getString(R.string.filter_title)");
        String string20 = context.getString(R$string.filter_content);
        s.h(string20, "context.getString(R.string.filter_content)");
        String string21 = context.getString(R$string.hide_me_in_match_and_nearby);
        s.h(string21, "context.getString(R.stri…e_me_in_match_and_nearby)");
        String string22 = context.getString(R$string.hide_me_content);
        s.h(string22, "context.getString(R.string.hide_me_content)");
        String string23 = context.getString(R$string.vip_forbid_ad);
        s.h(string23, "context.getString(R.string.vip_forbid_ad)");
        String string24 = context.getString(R$string.noAd_content);
        s.h(string24, "context.getString(R.string.noAd_content)");
        return kotlin.collections.s.m(new VipFunctionUiModel(string, R$mipmap.ssvip_ic_zhuanshuliuliangbaoguang, string2, R$mipmap.ssvip_popup_aplus_zhuanshubaoguang, false, vipType, null, 64, null), new VipFunctionUiModel(string3, R$mipmap.ssvip_ic_yijianquguan, string4, R$mipmap.ssvip_popup_aplus_tongxunluguanli, false, vipType, null, 64, null), new VipFunctionUiModel(string5, R$mipmap.ssvip_ic_chaojixihuan, string6, R$mipmap.ssvip_popup_aplus_chaojixihuan, false, vipType, null, 64, null), new VipFunctionUiModel(string7, R$mipmap.ssvip_ic_yincangjuli, string8, R$mipmap.ssvip_popup_aplus_yincangjuli, true, vipType, null, 64, null), new VipFunctionUiModel(string9, R$mipmap.ssvip_ic_fujinderen, string10, R$mipmap.ssvip_popup_aplus_fujinderen, false, vipType, null, 64, null), new VipFunctionUiModel(string11, R$mipmap.ssvip_ic_dituzhaoren, string12, R$mipmap.ssvip_popup_aplus_dituzhaoren, false, vipType, null, 64, null), new VipFunctionUiModel(string13, R$mipmap.ssvip_ic_chengshimanyou, string14, R$mipmap.ssvip_popup_aplus_chengshimanyou, false, vipType, null, 64, null), new VipFunctionUiModel(string15, R$mipmap.ssvip_ic_qiaoqiaochakan, string16, R$mipmap.ssvip_popup_aplus_qiaoqiaochakan, true, vipType, null, 64, null), new VipFunctionUiModel(string17, R$mipmap.ssvip_ic_gaojishaixuan, string18, R$mipmap.ssvip_popup_aplus_gaojishaixuan, false, vipType, null, 64, null), new VipFunctionUiModel(string19, R$mipmap.ssvip_ic_jingqueshaixuan, string20, R$mipmap.ssvip_popup_aplus_jingqueshaixuan, false, vipType, null, 64, null), new VipFunctionUiModel(string21, R$mipmap.ssvip_ic_zidingyiyinshen, string22, R$mipmap.ssvip_popup_aplus_zidingyiyinshen, true, vipType, null, 64, null), new VipFunctionUiModel(string23, R$mipmap.ssvip_ic_guanggaotequan, string24, R$mipmap.ssvip_popup_aplus_guanggaotequan, true, vipType, null, 64, null));
    }

    public final List<VipFunctionUiModel> d(Context context) {
        String string = context.getString(R$string.exclusive_traffic_exposure);
        s.h(string, "context.getString(R.stri…clusive_traffic_exposure)");
        String string2 = context.getString(R$string.exclusive_traffic_exposure_content);
        s.h(string2, "context.getString(R.stri…traffic_exposure_content)");
        VipType vipType = VipType.RAINBOW;
        String string3 = context.getString(R$string.smart_filter);
        s.h(string3, "context.getString(R.string.smart_filter)");
        String string4 = context.getString(R$string.rainbow_vip_smart_filter_content);
        s.h(string4, "context.getString(R.stri…vip_smart_filter_content)");
        String string5 = context.getString(R$string.feed_set_top);
        s.h(string5, "context.getString(R.string.feed_set_top)");
        String string6 = context.getString(R$string.feed_top_content);
        s.h(string6, "context.getString(R.string.feed_top_content)");
        String string7 = context.getString(R$string.video_avatar);
        s.h(string7, "context.getString(R.string.video_avatar)");
        String string8 = context.getString(R$string.video_avatar_content);
        s.h(string8, "context.getString(R.string.video_avatar_content)");
        return kotlin.collections.s.m(new VipFunctionUiModel(string, R$mipmap.ssvip_ic_zhuanshuliuliangbaoguang_highlight, string2, R$mipmap.ssvip_popup_aplus_zhuanshubaoguang, false, vipType, context.getString(R$string.rcmd_on_line_time)), new VipFunctionUiModel(string3, R$mipmap.ssvip_ic_zhinengshaixuan_highlight, string4, R$mipmap.ssvip_popup_aplus_zhinengshaixuan, false, vipType, context.getString(R$string.smart_filter_online_time)), new VipFunctionUiModel(string5, R$mipmap.ssvip_ic_dongtaizhiding_highlight, string6, R$mipmap.ssvip_popup_aplus_dongtaizhiding, false, vipType, null, 64, null), new VipFunctionUiModel(string7, R$mipmap.ssvip_ic_dongtaitouxiang_highlight, string8, R$mipmap.ssvip_popup_aplus_dongtaitouxiang, false, vipType, null, 64, null));
    }

    public final List<VipFunctionUiModel> e(Context context) {
        String string = context.getString(R$string.nearby_title);
        s.h(string, "context.getString(R.string.nearby_title)");
        String string2 = context.getString(R$string.nearby_content);
        s.h(string2, "context.getString(R.string.nearby_content)");
        VipType vipType = VipType.SUPER;
        String string3 = context.getString(R$string.map_filter_title);
        s.h(string3, "context.getString(R.string.map_filter_title)");
        String string4 = context.getString(R$string.map_filter_content);
        s.h(string4, "context.getString(R.string.map_filter_content)");
        String string5 = context.getString(R$string.hide_my_location);
        s.h(string5, "context.getString(R.string.hide_my_location)");
        String string6 = context.getString(R$string.hide_my_location_content);
        s.h(string6, "context.getString(R.stri…hide_my_location_content)");
        String string7 = context.getString(R$string.roaming_title);
        s.h(string7, "context.getString(R.string.roaming_title)");
        String string8 = context.getString(R$string.roaming_content);
        s.h(string8, "context.getString(R.string.roaming_content)");
        String string9 = context.getString(R$string.quiet_msg);
        s.h(string9, "context.getString(R.string.quiet_msg)");
        String string10 = context.getString(R$string.quiet_content);
        s.h(string10, "context.getString(R.string.quiet_content)");
        String string11 = context.getString(R$string.super_filter_title);
        s.h(string11, "context.getString(R.string.super_filter_title)");
        String string12 = context.getString(R$string.super_filter_content);
        s.h(string12, "context.getString(R.string.super_filter_content)");
        String string13 = context.getString(R$string.filter_title);
        s.h(string13, "context.getString(R.string.filter_title)");
        String string14 = context.getString(R$string.filter_content);
        s.h(string14, "context.getString(R.string.filter_content)");
        String string15 = context.getString(R$string.hide_me_in_match_and_nearby);
        s.h(string15, "context.getString(R.stri…e_me_in_match_and_nearby)");
        String string16 = context.getString(R$string.hide_me_content);
        s.h(string16, "context.getString(R.string.hide_me_content)");
        String string17 = context.getString(R$string.vip_forbid_ad);
        s.h(string17, "context.getString(R.string.vip_forbid_ad)");
        String string18 = context.getString(R$string.noAd_content);
        s.h(string18, "context.getString(R.string.noAd_content)");
        return kotlin.collections.s.m(new VipFunctionUiModel(string, R$mipmap.svip_aplus_fujinderen, string2, R$mipmap.svip_popup_aplus_fujinderen, false, vipType, null, 64, null), new VipFunctionUiModel(string3, R$mipmap.svip_aplus_dituzhaoren, string4, R$mipmap.svip_popup_aplus_dituzhaoren, false, vipType, null, 64, null), new VipFunctionUiModel(string5, R$mipmap.svip_aplus_yincangjuli, string6, R$mipmap.svip_popup_aplus_yincangjuli, true, vipType, null, 64, null), new VipFunctionUiModel(string7, R$mipmap.svip_aplus_chengshimanyou, string8, R$mipmap.svip_popup_aplus_chengshimanyou, false, vipType, null, 64, null), new VipFunctionUiModel(string9, R$mipmap.svip_aplus_qiaoqiaochakan, string10, R$mipmap.svip_popup_aplus_qiaoqiaochakan, true, vipType, null, 64, null), new VipFunctionUiModel(string11, R$mipmap.svip_aplus_gaojishaixuan, string12, R$mipmap.svip_popup_aplus_gaojishaixuan, false, vipType, null, 64, null), new VipFunctionUiModel(string13, R$mipmap.svip_aplus_jingqueshaixuan, string14, R$mipmap.svip_popup_aplus_jingqueshaixuan, false, vipType, null, 64, null), new VipFunctionUiModel(string15, R$mipmap.svip_aplus_zidingyiyinshen, string16, R$mipmap.ssvip_popup_aplus_zidingyiyinshen, true, vipType, null, 64, null), new VipFunctionUiModel(string17, R$mipmap.svip_aplus_guanggaotequan, string18, R$mipmap.svip_popup_aplus_guanggaotequan, true, vipType, null, 64, null));
    }

    public final List<VipFunctionUiModel> f(Context context) {
        MaskPartyAddTimesModel audioGameRoom;
        MaskPartyAddTimesModel maskRoom;
        ConstantsResult q10 = g.f52734a.q();
        SocialGameConfigModel vasConf = q10 != null ? q10.getVasConf() : null;
        VipFunctionUiModel[] vipFunctionUiModelArr = new VipFunctionUiModel[4];
        String string = context.getString(R$string.feed_set_top);
        s.h(string, "context.getString(R.string.feed_set_top)");
        String string2 = context.getString(R$string.feed_top_content);
        s.h(string2, "context.getString(R.string.feed_top_content)");
        VipType vipType = VipType.SUPER;
        vipFunctionUiModelArr[0] = new VipFunctionUiModel(string, R$mipmap.svip_ic_dongtaizhiding_highlight, string2, R$mipmap.svip_popup_aplus_dongtaizhiding, false, vipType, null, 64, null);
        String string3 = context.getString(R$string.video_avatar);
        s.h(string3, "context.getString(R.string.video_avatar)");
        String string4 = context.getString(R$string.video_avatar_content);
        s.h(string4, "context.getString(R.string.video_avatar_content)");
        vipFunctionUiModelArr[1] = new VipFunctionUiModel(string3, R$mipmap.svip_ic_dongtaitouxiang_highlight, string4, R$mipmap.svip_popup_aplus_dongtaitouxiang, false, vipType, null, 64, null);
        String string5 = context.getString(R$string.personal_icon);
        s.h(string5, "context.getString(R.string.personal_icon)");
        String string6 = context.getString(R$string.personal_icon_des);
        s.h(string6, "context.getString(R.string.personal_icon_des)");
        vipFunctionUiModelArr[2] = new VipFunctionUiModel(string5, R$mipmap.svip_ic_gexingtubiao_highlight, string6, R$mipmap.svip_popup_aplus_gexingtubiao, false, vipType, null, 64, null);
        String string7 = context.getString(R$string.mask_party_privilege);
        s.h(string7, "context.getString(R.string.mask_party_privilege)");
        Object[] objArr = new Object[2];
        Object obj = "";
        objArr[0] = (vasConf == null || (maskRoom = vasConf.getMaskRoom()) == null) ? "" : Integer.valueOf(maskRoom.getSvipDailyAdditionalTimes());
        if (vasConf != null && (audioGameRoom = vasConf.getAudioGameRoom()) != null) {
            obj = Integer.valueOf(audioGameRoom.getSvipDailyAdditionalTimes());
        }
        objArr[1] = obj;
        String string8 = context.getString(R$string.mask_party_privilege_content, objArr);
        s.h(string8, "context.getString(\n     …es ?:\"\"\n                )");
        vipFunctionUiModelArr[3] = new VipFunctionUiModel(string7, R$mipmap.svip_ic_mengmianpaiduitequan_highlight, string8, R$mipmap.svip_popup_aplus_mengmianpaiduitequan, false, vipType, null, 64, null);
        return kotlin.collections.s.m(vipFunctionUiModelArr);
    }

    @NotNull
    public final List<VipFunctionUiModel> g(@NotNull Context context, @NotNull VipType vipType) {
        s.i(context, "context");
        s.i(vipType, "vipType");
        int i10 = a.f18810a[vipType.ordinal()];
        if (i10 == 1) {
            return e(context);
        }
        if (i10 != 2) {
            return b(context);
        }
        return c(context);
    }

    @NotNull
    public final List<VipFunctionUiModel> h(@NotNull Context context) {
        MaskPartyAddTimesModel audioGameRoom;
        MaskPartyAddTimesModel maskRoom;
        s.i(context, "context");
        ConstantsResult q10 = g.f52734a.q();
        SocialGameConfigModel vasConf = q10 != null ? q10.getVasConf() : null;
        VipFunctionUiModel[] vipFunctionUiModelArr = new VipFunctionUiModel[4];
        String string = context.getString(R$string.feed_set_top);
        s.h(string, "context.getString(R.string.feed_set_top)");
        String string2 = context.getString(R$string.feed_top_content);
        s.h(string2, "context.getString(R.string.feed_top_content)");
        VipType vipType = VipType.NORMAL;
        vipFunctionUiModelArr[0] = new VipFunctionUiModel(string, R$mipmap.vip_ic_dongtaizhiding_highlight, string2, R$mipmap.vip_popup_aplus_dongtaizhiding, false, vipType, null, 64, null);
        String string3 = context.getString(R$string.video_avatar);
        s.h(string3, "context.getString(R.string.video_avatar)");
        String string4 = context.getString(R$string.video_avatar_content);
        s.h(string4, "context.getString(R.string.video_avatar_content)");
        vipFunctionUiModelArr[1] = new VipFunctionUiModel(string3, R$mipmap.vip_ic_dongtaitouxiang_highlight, string4, R$mipmap.vip_popup_aplus_dongtaitouxiang, false, vipType, null, 64, null);
        String string5 = context.getString(R$string.personal_icon);
        s.h(string5, "context.getString(R.string.personal_icon)");
        String string6 = context.getString(R$string.personal_icon_des);
        s.h(string6, "context.getString(R.string.personal_icon_des)");
        vipFunctionUiModelArr[2] = new VipFunctionUiModel(string5, R$mipmap.vip_ic_gexingtubiao_highlight, string6, R$mipmap.vip_popup_aplus_gexingtubiao, false, vipType, null, 64, null);
        String string7 = context.getString(R$string.mask_party_privilege);
        s.h(string7, "context.getString(R.string.mask_party_privilege)");
        Object[] objArr = new Object[2];
        Object obj = "";
        objArr[0] = (vasConf == null || (maskRoom = vasConf.getMaskRoom()) == null) ? "" : Integer.valueOf(maskRoom.getVipDailyAdditionalTimes());
        if (vasConf != null && (audioGameRoom = vasConf.getAudioGameRoom()) != null) {
            obj = Integer.valueOf(audioGameRoom.getVipDailyAdditionalTimes());
        }
        objArr[1] = obj;
        String string8 = context.getString(R$string.mask_party_privilege_content, objArr);
        s.h(string8, "context.getString(\n     …s ?: \"\"\n                )");
        vipFunctionUiModelArr[3] = new VipFunctionUiModel(string7, R$mipmap.vip_ic_mengmianpaiduitequan_highlight, string8, R$mipmap.vip_popup_aplus_mengmianpaiduitequan, false, vipType, null, 64, null);
        return kotlin.collections.s.m(vipFunctionUiModelArr);
    }
}
