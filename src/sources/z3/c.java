package z3;

import android.content.Context;
import com.cupidapp.live.base.safe.ImeiHelper;
import com.cupidapp.live.profile.model.User;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.protobuf.Message;
import com.irisdt.Irisdt;
import com.irisdt.biz.Abtest;
import com.irisdt.biz.Apm;
import com.irisdt.biz.Client;
import com.irisdt.biz.Common;
import com.irisdt.biz.Dau;
import com.irisdt.client.CommonExtraProtos;
import com.irisdt.client.advertisement.AdvertisementProtos;
import com.irisdt.client.chat.ChatProtos;
import com.irisdt.client.increment.IncrementProtos;
import com.irisdt.client.live.LiveProtos;
import com.irisdt.client.login.LoginAndRegisterProtos;
import com.irisdt.client.others.OthersProtos;
import com.irisdt.client.post.PostAndSocialProtos;
import com.irisdt.client.recharge.RechargeProtos;
import com.irisdt.client.visitor.VisitorProtos;
import io.grpc.internal.GrpcUtil;
import java.util.Locale;
import kotlin.jvm.internal.s;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: GroupEventTrack.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a */
    @NotNull
    public static final c f54829a = new c();

    /* renamed from: b */
    @NotNull
    public static final Regex f54830b = new Regex("[a-zA-Z]*[ ]*:(([ ]*null[ ]*)|([ ]{2}))");

    /* renamed from: c */
    @NotNull
    public static final String f54831c = "JGCIrO/pSYY9HPR3Wr5Whg==";

    public static /* synthetic */ void A(c cVar, OthersProtos.Event event, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Boolean bool, Boolean bool2, Boolean bool3, String str15, String str16, Integer num, Integer num2, Integer num3, Integer num4, OthersProtos.Enum_type enum_type, String str17, OthersProtos.SortType sortType, String str18, String str19, Integer num5, Long l10, String str20, Integer num6, Integer num7, String str21, Integer num8, String str22, String str23, String str24, String str25, String str26, String str27, String str28, int i10, int i11, Object obj) {
        cVar.z(event, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : str8, (i10 & 512) != 0 ? null : str9, (i10 & 1024) != 0 ? null : str10, (i10 & 2048) != 0 ? null : str11, (i10 & 4096) != 0 ? null : str12, (i10 & 8192) != 0 ? null : str13, (i10 & 16384) != 0 ? null : str14, (i10 & 32768) != 0 ? null : bool, (i10 & 65536) != 0 ? null : bool2, (i10 & 131072) != 0 ? null : bool3, (i10 & 262144) != 0 ? null : str15, (i10 & 524288) != 0 ? null : str16, (i10 & 1048576) != 0 ? null : num, (i10 & 2097152) != 0 ? null : num2, (i10 & 4194304) != 0 ? null : num3, (i10 & 8388608) != 0 ? null : num4, (i10 & 16777216) != 0 ? null : enum_type, (i10 & 33554432) != 0 ? null : str17, (i10 & 67108864) != 0 ? null : sortType, (i10 & 134217728) != 0 ? null : str18, (i10 & 268435456) != 0 ? null : str19, (i10 & 536870912) != 0 ? null : num5, (i10 & 1073741824) != 0 ? null : l10, (i10 & Integer.MIN_VALUE) != 0 ? null : str20, (i11 & 1) != 0 ? null : num6, (i11 & 2) != 0 ? null : num7, (i11 & 4) != 0 ? null : str21, (i11 & 8) != 0 ? null : num8, (i11 & 16) != 0 ? null : str22, (i11 & 32) != 0 ? null : str23, (i11 & 64) != 0 ? null : str24, (i11 & 128) != 0 ? null : str25, (i11 & 256) != 0 ? null : str26, (i11 & 512) != 0 ? null : str27, (i11 & 1024) != 0 ? null : str28);
    }

    public static /* synthetic */ void C(c cVar, PostAndSocialProtos.Event event, String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, String str9, PostAndSocialProtos.Type type, String str10, String str11, String str12, Integer num3, String str13, String str14, String str15, Boolean bool2, String str16, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Integer num4, String str18, String str19, String str20, Integer num5, String str21, PostAndSocialProtos.Enum_type enum_type, Boolean bool6, String str22, Integer num6, String str23, String str24, boolean z10, String str25, String str26, Integer num7, Integer num8, Long l10, Boolean bool7, Boolean bool8, Boolean bool9, Integer num9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, String str27, Integer num10, Integer num11, String str28, String str29, String str30, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, String str31, String str32, Boolean bool18, String str33, String str34, Boolean bool19, int i10, int i11, int i12, Object obj) {
        cVar.B(event, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : bool, (i10 & 32) != 0 ? null : str4, (i10 & 64) != 0 ? null : str5, (i10 & 128) != 0 ? null : str6, (i10 & 256) != 0 ? null : str7, (i10 & 512) != 0 ? null : str8, (i10 & 1024) != 0 ? null : num, (i10 & 2048) != 0 ? null : num2, (i10 & 4096) != 0 ? null : str9, (i10 & 8192) != 0 ? null : type, (i10 & 16384) != 0 ? null : str10, (i10 & 32768) != 0 ? null : str11, (i10 & 65536) != 0 ? null : str12, (i10 & 131072) != 0 ? null : num3, (i10 & 262144) != 0 ? null : str13, (i10 & 524288) != 0 ? null : str14, (i10 & 1048576) != 0 ? null : str15, (i10 & 2097152) != 0 ? null : bool2, (i10 & 4194304) != 0 ? null : str16, (i10 & 8388608) != 0 ? null : str17, (i10 & 16777216) != 0 ? null : bool3, (i10 & 33554432) != 0 ? null : bool4, (i10 & 67108864) != 0 ? null : bool5, (i10 & 134217728) != 0 ? null : num4, (i10 & 268435456) != 0 ? null : str18, (i10 & 536870912) != 0 ? null : str19, (i10 & 1073741824) != 0 ? null : str20, (i10 & Integer.MIN_VALUE) != 0 ? null : num5, (i11 & 1) != 0 ? null : str21, (i11 & 2) != 0 ? null : enum_type, (i11 & 4) != 0 ? null : bool6, (i11 & 8) != 0 ? null : str22, (i11 & 16) != 0 ? null : num6, (i11 & 32) != 0 ? null : str23, (i11 & 64) != 0 ? null : str24, (i11 & 128) != 0 ? false : z10, (i11 & 256) != 0 ? null : str25, (i11 & 512) != 0 ? null : str26, (i11 & 1024) != 0 ? null : num7, (i11 & 2048) != 0 ? null : num8, (i11 & 4096) != 0 ? null : l10, (i11 & 8192) != 0 ? null : bool7, (i11 & 16384) != 0 ? null : bool8, (i11 & 32768) != 0 ? null : bool9, (i11 & 65536) != 0 ? null : num9, (i11 & 131072) != 0 ? null : bool10, (i11 & 262144) != 0 ? null : bool11, (i11 & 524288) != 0 ? null : bool12, (i11 & 1048576) != 0 ? null : bool13, (i11 & 2097152) != 0 ? null : str27, (i11 & 4194304) != 0 ? null : num10, (i11 & 8388608) != 0 ? null : num11, (i11 & 16777216) != 0 ? null : str28, (i11 & 33554432) != 0 ? null : str29, (i11 & 67108864) != 0 ? null : str30, (i11 & 134217728) != 0 ? null : bool14, (i11 & 268435456) != 0 ? null : bool15, (i11 & 536870912) != 0 ? null : bool16, (i11 & 1073741824) != 0 ? null : bool17, (i11 & Integer.MIN_VALUE) != 0 ? null : str31, (i12 & 1) != 0 ? null : str32, (i12 & 2) != 0 ? null : bool18, (i12 & 4) != 0 ? null : str33, (i12 & 8) != 0 ? null : str34, (i12 & 16) != 0 ? null : bool19);
    }

    public static /* synthetic */ void q(c cVar, AdvertisementProtos.Event event, String str, String str2, Boolean bool, String str3, Float f10, String str4, String str5, String str6, String str7, String str8, Integer num, Boolean bool2, String str9, Integer num2, String str10, Integer num3, String str11, String str12, String str13, String str14, String str15, Boolean bool3, String str16, Long l10, Boolean bool4, Integer num4, Long l11, String str17, Boolean bool5, int i10, Object obj) {
        cVar.p(event, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : bool, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : f10, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? null : str5, (i10 & 256) != 0 ? null : str6, (i10 & 512) != 0 ? null : str7, (i10 & 1024) != 0 ? null : str8, (i10 & 2048) != 0 ? null : num, (i10 & 4096) != 0 ? null : bool2, (i10 & 8192) != 0 ? null : str9, (i10 & 16384) != 0 ? null : num2, (i10 & 32768) != 0 ? null : str10, (i10 & 65536) != 0 ? null : num3, (i10 & 131072) != 0 ? null : str11, (i10 & 262144) != 0 ? null : str12, (i10 & 524288) != 0 ? null : str13, (i10 & 1048576) != 0 ? null : str14, (i10 & 2097152) != 0 ? null : str15, (i10 & 4194304) != 0 ? null : bool3, (i10 & 8388608) != 0 ? null : str16, (i10 & 16777216) != 0 ? null : l10, (i10 & 33554432) != 0 ? null : bool4, (i10 & 67108864) != 0 ? null : num4, (i10 & 134217728) != 0 ? null : l11, (i10 & 268435456) != 0 ? null : str17, (i10 & 536870912) == 0 ? bool5 : null);
    }

    public static /* synthetic */ void w(c cVar, LiveProtos.Event event, LiveProtos.Type type, String str, String str2, Integer num, String str3, String str4, Boolean bool, Integer num2, Float f10, String str5, String str6, String str7, Integer num3, Boolean bool2, LiveProtos.Result result, String str8, String str9, LiveProtos.CoverType coverType, String str10, String str11, String str12, Double d10, String str13, String str14, Boolean bool3, String str15, Boolean bool4, Integer num4, Integer num5, String str16, String str17, Integer num6, String str18, Boolean bool5, String str19, String str20, String str21, String str22, int i10, int i11, Object obj) {
        cVar.v(event, (i10 & 2) != 0 ? null : type, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? null : bool, (i10 & 256) != 0 ? null : num2, (i10 & 512) != 0 ? null : f10, (i10 & 1024) != 0 ? null : str5, (i10 & 2048) != 0 ? null : str6, (i10 & 4096) != 0 ? null : str7, (i10 & 8192) != 0 ? null : num3, (i10 & 16384) != 0 ? null : bool2, (i10 & 32768) != 0 ? null : result, (i10 & 65536) != 0 ? null : str8, (i10 & 131072) != 0 ? null : str9, (i10 & 262144) != 0 ? null : coverType, (i10 & 524288) != 0 ? null : str10, (i10 & 1048576) != 0 ? null : str11, (i10 & 2097152) != 0 ? null : str12, (i10 & 4194304) != 0 ? null : d10, (i10 & 8388608) != 0 ? null : str13, (i10 & 16777216) != 0 ? null : str14, (i10 & 33554432) != 0 ? null : bool3, (i10 & 67108864) != 0 ? null : str15, (i10 & 134217728) != 0 ? null : bool4, (i10 & 268435456) != 0 ? null : num4, (i10 & 536870912) != 0 ? null : num5, (i10 & 1073741824) != 0 ? null : str16, (i10 & Integer.MIN_VALUE) != 0 ? null : str17, (i11 & 1) != 0 ? null : num6, (i11 & 2) != 0 ? null : str18, (i11 & 4) != 0 ? null : bool5, (i11 & 8) != 0 ? null : str19, (i11 & 16) != 0 ? null : str20, (i11 & 32) != 0 ? null : str21, (i11 & 64) == 0 ? str22 : null);
    }

    public final void B(@NotNull PostAndSocialProtos.Event event, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Integer num, @Nullable Integer num2, @Nullable String str9, @Nullable PostAndSocialProtos.Type type, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable Integer num3, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable Boolean bool2, @Nullable String str16, @Nullable String str17, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Integer num4, @Nullable String str18, @Nullable String str19, @Nullable String str20, @Nullable Integer num5, @Nullable String str21, @Nullable PostAndSocialProtos.Enum_type enum_type, @Nullable Boolean bool6, @Nullable String str22, @Nullable Integer num6, @Nullable String str23, @Nullable String str24, boolean z10, @Nullable String str25, @Nullable String str26, @Nullable Integer num7, @Nullable Integer num8, @Nullable Long l10, @Nullable Boolean bool7, @Nullable Boolean bool8, @Nullable Boolean bool9, @Nullable Integer num9, @Nullable Boolean bool10, @Nullable Boolean bool11, @Nullable Boolean bool12, @Nullable Boolean bool13, @Nullable String str27, @Nullable Integer num10, @Nullable Integer num11, @Nullable String str28, @Nullable String str29, @Nullable String str30, @Nullable Boolean bool14, @Nullable Boolean bool15, @Nullable Boolean bool16, @Nullable Boolean bool17, @Nullable String str31, @Nullable String str32, @Nullable Boolean bool18, @Nullable String str33, @Nullable String str34, @Nullable Boolean bool19) {
        s.i(event, "event");
        PostAndSocialProtos.PostAndSocialProto builder = PostAndSocialProtos.PostAndSocialProto.newBuilder().setEvent(event).setIsTravel(f(bool19)).setName(h(str)).setFrom(h(str2)).setTargetUid(h(str3)).setIsTrue(f(bool)).setIsShow(f(bool6)).setContent(h(str4)).setTopic(h(str5)).setPostId(h(str6)).setScene(h(str7)).setPosition(h(str8)).setNum(num != null ? num.intValue() : 0).setIndex(num2 != null ? num2.intValue() : 0).setId(h(str9)).setType(type == null ? PostAndSocialProtos.Type.UNKNOWN_TYPE : type).setEnumType(enum_type == null ? PostAndSocialProtos.Enum_type.UNKNOWN_ENUM_TYPE : enum_type).setSubType(h(str10)).setExpId(h(str11)).setRetrieveId(h(str12)).setTime(num3 != null ? num3.intValue() : 0).setDistance(h(str13)).setHigh(h(str14)).setWeight(h(str15)).setIsRecommend(f(bool2)).setIsCloseFriend(f(bool5)).setOwnerUid(h(str16)).setModeId(h(str17)).setIsFollow(f(bool3)).setIsSuperLike(f(bool4)).setIsSuccess(f(bool9)).setCoverNum(num4 != null ? num4.intValue() : 0).setIsSpecialAttention(f(bool8)).setImageId(h(str18)).setMatchExpId(h(str19)).setMatchRetrieveId(h(str20)).setMatchStrategyId(h(str21)).setPermission(num5 != null ? num5.intValue() : 0).setInfo(h(str22)).setVideoNum(num6 != null ? num6.intValue() : 0).setVideoId(h(str23)).setIsLikeMe(z10).setOnlineShowType(h(str25)).setMaskNum(num7 != null ? num7.intValue() : 0).setVoiceNum(num8 != null ? num8.intValue() : 0).setCostTime(l10 != null ? l10.longValue() : 0L).setIsLiveShow(f(bool7)).setCardNum(num9 != null ? num9.intValue() : 0).setRelation(h(str24)).setMsgType(h(str26)).setIsSuperBoost(f(bool10)).setHasPicture(f(bool11)).setHasText(f(bool12)).setHasStatus(f(bool13)).setReason(h(str27)).setCount(num10 != null ? num10.intValue() : 0).setGameType(h(str28)).setShowType(h(str29)).setIsWealthShow(f(bool14)).setCancelType(h(str30)).setIsPostSpread(f(bool15)).setIsPostTop(f(bool16)).setSuperLikeCnt(num11 != null ? num11.intValue() : 0).setIsSsvipExposure(f(bool17)).setConstellationContent(h(str31)).setCardType(h(str32)).setIsLimitTime(f(bool18)).setMbti(h(str33)).setTitle(h(str34)).build();
        s.h(builder, "builder");
        j(builder);
    }

    public final void D(@NotNull RechargeProtos.Event event, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        s.i(event, "event");
        RechargeProtos.RechargeProto builder = RechargeProtos.RechargeProto.newBuilder().setEvent(event).setPosition(h(str)).setLevel(h(str2)).setNum(num != null ? num.intValue() : 0).setName(h(str3)).setType(h(str4)).setContent(h(str5)).build();
        s.h(builder, "builder");
        j(builder);
    }

    public final void F(@NotNull VisitorProtos.Event event, @Nullable String str) {
        s.i(event, "event");
        VisitorProtos.VisitorProto builder = VisitorProtos.VisitorProto.newBuilder().setEvent(event).setPosition(str).build();
        s.h(builder, "builder");
        j(builder);
    }

    public final void a(@Nullable String str, int i10, @Nullable String str2, long j10, long j11, @Nullable String str3, @Nullable Throwable th) {
        if (th != null) {
            Apm apm = Irisdt.getApm();
            if (apm != null) {
                apm.httpFailed(str, i10, str2, th, j11, str3);
                return;
            }
            return;
        }
        Apm apm2 = Irisdt.getApm();
        if (apm2 != null) {
            apm2.httpSuccess(str, i10, str2, j10, j11, str3);
        }
    }

    public final void b() {
        Dau dau = Irisdt.getDau();
        if (dau != null) {
            dau.login();
        }
    }

    public final void c(@Nullable String str) {
        Dau dau = Irisdt.getDau();
        if (dau != null) {
            dau.logout(str);
        }
    }

    @NotNull
    public final String d(@NotNull String key, @NotNull String defaultValue) {
        s.i(key, "key");
        s.i(defaultValue, "defaultValue");
        Abtest abtest = Irisdt.getAbtest();
        String abConfig = abtest != null ? abtest.getAbConfig(key, defaultValue) : null;
        return abConfig == null ? defaultValue : abConfig;
    }

    public final boolean e(@NotNull String key, boolean z10) {
        s.i(key, "key");
        Abtest abtest = Irisdt.getAbtest();
        return abtest != null ? abtest.getAbConfig(key, z10) : z10;
    }

    public final boolean f(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final double g(Double d10) {
        return d10 != null ? d10.doubleValue() : ShadowDrawableWrapper.COS_45;
    }

    public final String h(String str) {
        return str == null ? "" : str;
    }

    public void i(@NotNull Context context) {
        s.i(context, "context");
        Irisdt.init(context, "finka.irisdt.cn", GrpcUtil.DEFAULT_PORT_SSL, null);
        if (Irisdt.isInited()) {
            Irisdt.getDau().setLogEnable(false);
            Irisdt.getDau().setLocalCacheEnable(true);
            Irisdt.getClient().setEnable(true);
            Irisdt.getClient().setLogEnable(false);
            Common common = Irisdt.getCommon();
            com.cupidapp.live.base.network.a aVar = com.cupidapp.live.base.network.a.f11902a;
            common.setChannel(aVar.r()).setPlatform("android_china");
            Irisdt.getApm().setEnable(true);
            Irisdt.getApm().setLogEnable(false);
            Irisdt.getPage().setEnable(true);
            Irisdt.getPage().setLogEnable(false);
            Irisdt.getAbtest().setEnable(true);
            Irisdt.getAbtest().setLogEnable(false);
            Irisdt.getAbtest().initConfig(f54831c, aVar.t());
        }
    }

    public final void j(Message message) {
        Client client = Irisdt.getClient();
        if (client != null) {
            User X = g.f52734a.X();
            client.send(message, 0L, X != null ? X.userId() : null);
        }
    }

    public void k(@Nullable String str) {
        Common common = Irisdt.getCommon();
        if (common != null) {
            common.setUidStr(str);
        }
    }

    public final void l(int i10, boolean z10, boolean z11, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5) {
        CommonExtraProtos.VIP_TYPE vip_type;
        if (i10 == 0) {
            vip_type = CommonExtraProtos.VIP_TYPE.NORMAL;
        } else if (i10 == 1) {
            vip_type = CommonExtraProtos.VIP_TYPE.VIP;
        } else if (i10 == 2) {
            vip_type = CommonExtraProtos.VIP_TYPE.SVIP;
        } else if (i10 != 3) {
            vip_type = CommonExtraProtos.VIP_TYPE.UNKNOWN_VIP_TYPE;
        } else {
            vip_type = CommonExtraProtos.VIP_TYPE.SSVIP;
        }
        CommonExtraProtos.CommonExtraProto build = CommonExtraProtos.CommonExtraProto.newBuilder().setVipType(vip_type).setIsVisitor(z10).setIsFake(z11).setSuperLikeCnt(num != null ? num.intValue() : 0).setVipCnt(num2 != null ? num2.intValue() : 0).setSvipCnt(num3 != null ? num3.intValue() : 0).setVisitorCnt(num4 != null ? num4.intValue() : 0).setSsvipCnt(num5 != null ? num5.intValue() : 0).setOaid(h(g.f52734a.f().c())).setImei(h(ImeiHelper.f12176a.f())).setUa(h(f1.c.b())).setAndroidId(h(com.cupidapp.live.base.network.a.f11902a.n())).build();
        Common common = Irisdt.getCommon();
        if (common != null) {
            common.setExtra(build);
        }
    }

    public final void m(@Nullable String str) {
        Abtest abtest = Irisdt.getAbtest();
        if (abtest != null) {
            abtest.setDecisionId(str);
        }
    }

    public final void n(@NotNull String latitude, @NotNull String longitude) {
        Common lat;
        s.i(latitude, "latitude");
        s.i(longitude, "longitude");
        Common common = Irisdt.getCommon();
        if (common == null || (lat = common.setLat(latitude)) == null) {
            return;
        }
        lat.setLon(longitude);
    }

    public final void o(@NotNull String shumengId) {
        s.i(shumengId, "shumengId");
        Common common = Irisdt.getCommon();
        if (common != null) {
            common.setShumengId(shumengId);
        }
    }

    public final void p(@NotNull AdvertisementProtos.Event event, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable Float f10, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Integer num, @Nullable Boolean bool2, @Nullable String str9, @Nullable Integer num2, @Nullable String str10, @Nullable Integer num3, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable Boolean bool3, @Nullable String str16, @Nullable Long l10, @Nullable Boolean bool4, @Nullable Integer num4, @Nullable Long l11, @Nullable String str17, @Nullable Boolean bool5) {
        s.i(event, "event");
        AdvertisementProtos.AdvertisementProto builder = AdvertisementProtos.AdvertisementProto.newBuilder().setEvent(event).setType(h(str)).setId(h(str2)).setIsTrue(f(bool)).setReason(h(str3)).setTime(f10 != null ? f10.floatValue() : 0.0f).setContent(h(str4)).setUrl(h(str5)).setPostId(h(str6)).setName(h(str7)).setPosition(h(str8)).setIndex(num != null ? num.intValue() : 0).setIsFull(f(bool2)).setReqId(h(str9)).setNum(num2 != null ? num2.intValue() : 0).setRequestId(h(str10)).setRequestTimes(num3 != null ? num3.intValue() : 0).setAdId(h(str11)).setAdSource(h(str12)).setCodeId(h(str13)).setAdType(h(str14)).setRequestType(h(str15)).setIsSuccess(f(bool3)).setSuccessType(h(str16)).setCostTime(l10 != null ? l10.longValue() : 0L).setIsCompliance(f(bool4)).setAdPrice(num4 != null ? num4.intValue() : 0).setShowTime(l11 != null ? l11.longValue() : 0L).setEndType(h(str17)).setIsCache(f(bool5)).build();
        s.h(builder, "builder");
        j(builder);
    }

    public final void r(@NotNull ChatProtos.Event event, @Nullable ChatProtos.Enum_type enum_type, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        s.i(event, "event");
        ChatProtos.ChatProto.Builder event2 = ChatProtos.ChatProto.newBuilder().setEvent(event);
        if (enum_type == null) {
            enum_type = ChatProtos.Enum_type.UNKNOWN_ENUM_TYPE;
        }
        ChatProtos.ChatProto builder = event2.setEnumType(enum_type).setTargetUid(h(str)).setNum(num != null ? num.intValue() : 0).setId(h(str2)).setContent(h(str3)).setUrl(h(str4)).setType(h(str5)).setMessageId(h(str6)).build();
        s.h(builder, "builder");
        j(builder);
    }

    public final void t(@NotNull IncrementProtos.Event event, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable IncrementProtos.Enum_type enum_type, @Nullable String str5, @Nullable Double d10, @Nullable Double d11, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable IncrementProtos.Sub_type sub_type, @Nullable IncrementProtos.Buy_type buy_type, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable Integer num, @Nullable String str17, @Nullable Integer num2, @Nullable String str18, @Nullable IncrementProtos.Enum_type enum_type2, @Nullable IncrementProtos.Enum_type enum_type3, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6) {
        s.i(event, "event");
        IncrementProtos.IncrementProto builder = IncrementProtos.IncrementProto.newBuilder().setEvent(event).setTime(num != null ? num.intValue() : 0).setNum(num2 != null ? num2.intValue() : 0).setActiveTime(h(str17)).setContent(h(str)).setFrom(h(str2)).setInfo(h(str15)).setLevel(h(str3)).setType(h(str4)).setName(h(str6)).setIsTrue(f(bool)).setPosition(h(str5)).setLatitude(g(d10)).setLongitude(g(d11)).setLocation(h(str7)).setRole(h(str8)).setConstellation(h(str9)).setAge(h(str10)).setMbti(h(str11)).setHeight(h(str12)).setWeight(h(str13)).setEnumType(enum_type == null ? IncrementProtos.Enum_type.UNKNOWN_ENUM_TYPE : enum_type).setBuyType(buy_type == null ? IncrementProtos.Buy_type.UNKNOWN_BUY_TYPE : buy_type).setSubType(sub_type == null ? IncrementProtos.Sub_type.UNKNOWN_SUB_TYPE : sub_type).setId(h(str14)).setDefaultTag(enum_type2 == null ? IncrementProtos.Enum_type.UNKNOWN_ENUM_TYPE : enum_type2).setShowType(enum_type3 == null ? IncrementProtos.Enum_type.UNKNOWN_ENUM_TYPE : enum_type3).setCouponId(h(str16)).setPrice(h(str18)).setIsSingle(f(bool2)).setIsPopular(f(bool4)).setIsTravel(f(bool5)).setIsHighMatchRate(f(bool6)).setIsNew(f(bool3)).build();
        s.h(builder, "builder");
        j(builder);
    }

    public final void v(@NotNull LiveProtos.Event event, @Nullable LiveProtos.Type type, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Integer num2, @Nullable Float f10, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Integer num3, @Nullable Boolean bool2, @Nullable LiveProtos.Result result, @Nullable String str8, @Nullable String str9, @Nullable LiveProtos.CoverType coverType, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable Double d10, @Nullable String str13, @Nullable String str14, @Nullable Boolean bool3, @Nullable String str15, @Nullable Boolean bool4, @Nullable Integer num4, @Nullable Integer num5, @Nullable String str16, @Nullable String str17, @Nullable Integer num6, @Nullable String str18, @Nullable Boolean bool5, @Nullable String str19, @Nullable String str20, @Nullable String str21, @Nullable String str22) {
        String str23;
        s.i(event, "event");
        LiveProtos.LiveProto.Builder isLiveShow = LiveProtos.LiveProto.newBuilder().setEvent(event).setType(type == null ? LiveProtos.Type.UNKNOWN_TYPE : type).setLiveId(h(str)).setAnchorUid(h(str2)).setNum(num != null ? num.intValue() : 0).setId(h(str3)).setTitle(h(str4)).setIsTrue(f(bool)).setTime(num2 != null ? num2.intValue() : 0).setWorth(f10 != null ? f10.floatValue() : 0.0f).setContent(h(str5)).setFrom(h(str6)).setScene(h(str7)).setCount(num3 != null ? num3.intValue() : 0).setIsBool(f(bool2)).setResult(result == null ? LiveProtos.Result.UNKNOWN_RESULT : result).setStatus(h(str8)).setSource(h(str9)).setTagType(h(str10)).setCoverType(coverType == null ? LiveProtos.CoverType.UNKNOWN_COVER_TYPE : coverType).setUserType(h(str11)).setScore(g(d10)).setName(h(str13)).setUserTag(h(str12)).setIsLiveShow(f(bool3));
        if (str14 != null) {
            Locale locale = Locale.getDefault();
            s.h(locale, "getDefault()");
            str23 = str14.toUpperCase(locale);
            s.h(str23, "this as java.lang.String).toUpperCase(locale)");
        } else {
            str23 = null;
        }
        LiveProtos.LiveProto builder = isLiveShow.setConnectType(h(str23)).setRedPacketType(h(str15)).setIsTrigger(f(bool4)).setLevel(num4 != null ? num4.intValue() : 0).setTimes(num5 != null ? num5.intValue() : 0).setActivityFirst(h(str16)).setActivitySecond(h(str17)).setIndex(num6 != null ? num6.intValue() : 0).setSku(h(str18)).setIsFirst(f(bool5)).setGrade(h(str19)).setReason(h(str20)).setRequestId(h(str21)).setTargetUid(h(str22)).build();
        s.h(builder, "builder");
        j(builder);
    }

    public final void x(@NotNull LoginAndRegisterProtos.Event event, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Boolean bool, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Long l10, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable LoginAndRegisterProtos.Enum_type enum_type) {
        s.i(event, "event");
        LoginAndRegisterProtos.LoginAndRegisterProto builder = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setPhone(h(str)).setAccount(h(str2)).setName(h(str3)).setBirthday(h(str4)).setType(h(str5)).setReason(h(str6)).setIsTrue(f(bool)).setContent(h(str7)).setMode(h(str8)).setPosition(h(str9)).setTime(l10 != null ? l10.longValue() : 0L).setTargetUid(h(str11)).setTaskType(h(str12)).setSubType(h(str13)).setId(h(str10)).setAccountType(h(str14)).setEnumType(enum_type == null ? LoginAndRegisterProtos.Enum_type.UNKNOWN_ENUM_TYPE : enum_type).build();
        s.h(builder, "builder");
        j(builder);
    }

    public final void z(@NotNull OthersProtos.Event event, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str15, @Nullable String str16, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable OthersProtos.Enum_type enum_type, @Nullable String str17, @Nullable OthersProtos.SortType sortType, @Nullable String str18, @Nullable String str19, @Nullable Integer num5, @Nullable Long l10, @Nullable String str20, @Nullable Integer num6, @Nullable Integer num7, @Nullable String str21, @Nullable Integer num8, @Nullable String str22, @Nullable String str23, @Nullable String str24, @Nullable String str25, @Nullable String str26, @Nullable String str27, @Nullable String str28) {
        s.i(event, "event");
        OthersProtos.OthersProto builder = OthersProtos.OthersProto.newBuilder().setEvent(event).setTime(num4 != null ? num4.intValue() : 0).setUrl(h(str)).setTargetUrl(h(str2)).setType(h(str3)).setContent(h(str4)).setScene(h(str5)).setId(h(str6)).setChannel(h(str7)).setStage(h(str8)).setName(h(str9)).setTargetUid(h(str10)).setLiveId(h(str11)).setAnchorUid(h(str12)).setPostId(h(str13)).setPosition(h(str14)).setIsTrue(f(bool)).setIsActive(f(bool2)).setIsFirst(f(bool3)).setMode(h(str15)).setReason(h(str16)).setNum(num != null ? num.intValue() : 0).setNum2(num2 != null ? num2.intValue() : 0).setNum3(num3 != null ? num3.intValue() : 0).setEnumType(enum_type == null ? OthersProtos.Enum_type.UNKNOWN_ENUM_TYPE : enum_type).setPage(h(str17)).setSortType(sortType == null ? OthersProtos.SortType.UNKNOWN_SORT_TYPE : sortType).setFrom(h(str18)).setTaskType(num5 != null ? num5.intValue() : 0).setCostTime(l10 != null ? l10.longValue() : 0L).setAdResult(h(str20)).setOriginalPage(h(str19)).setWidth(num6 != null ? num6.intValue() : 0).setHigh(num7 != null ? num7.intValue() : 0).setLonLat(h(str21)).setLocationType(num8 != null ? num8.intValue() : 99999).setDeviceId(h(str22)).setPrecision(h(str23)).setProvider(h(str24)).setLocationTime(h(str25)).setCallBackTime(h(str26)).setAddress(h(str27)).setDescription(h(str28)).build();
        s.h(builder, "builder");
        j(builder);
    }
}
