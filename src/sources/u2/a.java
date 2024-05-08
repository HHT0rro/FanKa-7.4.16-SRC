package u2;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.liveshow.fanclub.model.AutoLightUpResult;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubResult;
import com.cupidapp.live.liveshow.model.CheckLiveResult;
import com.cupidapp.live.liveshow.model.CommentResult;
import com.cupidapp.live.liveshow.model.FKLiveCoverModel;
import com.cupidapp.live.liveshow.model.FeedTopLiveModel;
import com.cupidapp.live.liveshow.model.FollowAnchorModel;
import com.cupidapp.live.liveshow.model.GiftCollectionModel;
import com.cupidapp.live.liveshow.model.GiftListResult;
import com.cupidapp.live.liveshow.model.HeatIntroModel;
import com.cupidapp.live.liveshow.model.LiveBeautyResourceResult;
import com.cupidapp.live.liveshow.model.LiveConnectAcceptResult;
import com.cupidapp.live.liveshow.model.LiveConnectRequestCheckResult;
import com.cupidapp.live.liveshow.model.LiveConnectRequestResult;
import com.cupidapp.live.liveshow.model.LiveEndModel;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuResult;
import com.cupidapp.live.liveshow.model.LiveListResult;
import com.cupidapp.live.liveshow.model.LiveMenuUnreadModel;
import com.cupidapp.live.liveshow.model.LivePkCenterResult;
import com.cupidapp.live.liveshow.model.LivePkFriendListResult;
import com.cupidapp.live.liveshow.model.LivePkRequestResult;
import com.cupidapp.live.liveshow.model.LivePushModel;
import com.cupidapp.live.liveshow.model.LiveReserveResult;
import com.cupidapp.live.liveshow.model.LiveSeatResult;
import com.cupidapp.live.liveshow.model.LiveSettingModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowNextListResult;
import com.cupidapp.live.liveshow.model.LiveShowPkWarResult;
import com.cupidapp.live.liveshow.model.LiveShowRankTagListModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.LiveShowShakeResult;
import com.cupidapp.live.liveshow.model.LiveShowViewerResult;
import com.cupidapp.live.liveshow.model.LiveStickerResult;
import com.cupidapp.live.liveshow.model.LiveTabConfigResult;
import com.cupidapp.live.liveshow.model.PropCardResult;
import com.cupidapp.live.liveshow.model.QuickGiftModel;
import com.cupidapp.live.liveshow.model.SendGiftResult;
import com.cupidapp.live.liveshow.model.StarChallengeChestReceiveModel;
import com.cupidapp.live.liveshow.model.SummaryDataResult;
import com.cupidapp.live.liveshow.model.UserProfileInfoResult;
import com.cupidapp.live.liveshow.pk.model.AcceptInvitingResult;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorListResult;
import com.cupidapp.live.liveshow.pk.model.MultiPkPrepareModel;
import com.cupidapp.live.liveshow.pk.model.SendInvitationModel;
import com.cupidapp.live.liveshow.pk.model.StartMultiPkResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveShowService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: LiveShowService.kt */
    @d
    /* renamed from: u2.a$a */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0826a {
        public static /* synthetic */ Observable a(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: followLive");
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.z0(str, i10);
        }

        public static /* synthetic */ Observable b(a aVar, Integer num, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generalLive");
            }
            if ((i11 & 4) != 0) {
                i10 = 20;
            }
            return aVar.h0(num, str, i10);
        }

        public static /* synthetic */ Observable c(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLiveModuleMore");
            }
            if ((i11 & 4) != 0) {
                i10 = 30;
            }
            return aVar.Q(str, str2, i10);
        }

        public static /* synthetic */ Observable d(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLiveStickers");
            }
            if ((i11 & 2) != 0) {
                i10 = 3;
            }
            return aVar.J(str, i10);
        }

        public static /* synthetic */ Observable e(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hotLive");
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.F(str, i10);
        }

        public static /* synthetic */ Observable f(a aVar, String str, String str2, Integer num, boolean z10, String str3, int i10, Integer num2, Integer num3, int i11, Object obj) {
            if (obj == null) {
                return aVar.w(str, str2, (i11 & 4) != 0 ? null : num, (i11 & 8) != 0 ? false : z10, (i11 & 16) != 0 ? null : str3, i10, (i11 & 64) != 0 ? null : num2, (i11 & 128) != 0 ? null : num3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: liveGift");
        }

        public static /* synthetic */ Observable g(a aVar, String str, String str2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: liveInfo");
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            return aVar.r0(str, str2);
        }

        public static /* synthetic */ Observable h(a aVar, String str, String str2, Boolean bool, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: liveOpen");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                bool = null;
            }
            return aVar.t(str, str2, bool);
        }

        public static /* synthetic */ Observable i(a aVar, Boolean bool, Boolean bool2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: liveUserSetting");
            }
            if ((i10 & 1) != 0) {
                bool = null;
            }
            if ((i10 & 2) != 0) {
                bool2 = null;
            }
            return aVar.q0(bool, bool2);
        }

        public static /* synthetic */ Observable j(a aVar, double d10, double d11, String str, int i10, int i11, Object obj) {
            if (obj == null) {
                return aVar.B(d10, d11, str, (i11 & 8) != 0 ? 30 : i10);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nearbyLive");
        }

        public static /* synthetic */ Observable k(a aVar, Double d10, Double d11, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recommendLive");
            }
            if ((i11 & 8) != 0) {
                i10 = 30;
            }
            return aVar.K(d10, d11, str, i10);
        }

        public static /* synthetic */ Observable l(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userProfileInfo");
            }
            if ((i11 & 2) != 0) {
                str2 = null;
            }
            if ((i11 & 4) != 0) {
                i10 = 0;
            }
            return aVar.D(str, str2, i10);
        }
    }

    @o("/recommend/live/tabConfig")
    @e
    @NotNull
    Observable<Result<LiveTabConfigResult>> A(@c("location") boolean z10);

    @f("/live/agreement")
    @NotNull
    Observable<Result<CheckLiveResult>> A0();

    @o("/recommend/nearby")
    @e
    @NotNull
    Observable<Result<LiveListResult>> B(@c("latitude") double d10, @c("longitude") double d11, @c("cursor") @Nullable String str, @c("count") int i10);

    @f("/live/gift/quick")
    @NotNull
    Observable<Result<QuickGiftModel>> B0();

    @o("/live/connect/accept")
    @e
    @NotNull
    Observable<Result<LiveConnectAcceptResult>> C(@c("liveShowId") @Nullable String str, @c("requestId") @Nullable String str2, @c("userId") @Nullable String str3);

    @o("/live/gift/quick")
    @e
    @NotNull
    Observable<Result<SendGiftResult>> C0(@c("liveShowId") @NotNull String str, @c("giftId") @NotNull String str2, @c("rushId") int i10, @c("discountedPrice") @Nullable Integer num);

    @f("/user/profile-info")
    @NotNull
    Observable<Result<UserProfileInfoResult>> D(@t("userId") @Nullable String str, @t("liveShowId") @Nullable String str2, @t("context") int i10);

    @o("/live/horn")
    @e
    @NotNull
    Observable<Result<Object>> D0(@c("liveShowId") @NotNull String str, @c("message") @NotNull String str2);

    @o("/live/close")
    @e
    @NotNull
    Observable<Result<SummaryDataResult>> E(@c("liveShowId") @NotNull String str);

    @f("/live/follow/guide")
    @NotNull
    Observable<Result<FollowAnchorModel>> E0();

    @o("/recommend/live")
    @e
    @NotNull
    Observable<Result<LiveListResult>> F(@c("cursor") @Nullable String str, @c("count") int i10);

    @o("/live/red-packet/click")
    @NotNull
    Observable<Result<Object>> F0();

    @o("/live/connect/close")
    @e
    @NotNull
    Observable<Result<Object>> G(@c("liveShowId") @NotNull String str, @c("accompanyLiveShowId") @NotNull String str2);

    @f("/live/room/pull-elements")
    @NotNull
    Observable<Result<GiftCollectionModel>> G0(@t("liveShowId") @NotNull String str);

    @o("/live/pk/multiplayer/invite/agree")
    @e
    @NotNull
    Observable<Result<AcceptInvitingResult>> H(@c("liveShowId") @NotNull String str, @c("pkPrepareId") @NotNull String str2);

    @o("/live/activity/select")
    @e
    @NotNull
    Observable<Result<Object>> H0(@c("ids[]") @NotNull List<String> list);

    @o("/live/comment")
    @e
    @NotNull
    Observable<Result<CommentResult>> I(@c("liveShowId") @NotNull String str, @c("message") @NotNull String str2, @c("isBarrage") boolean z10);

    @o("/live/pull-gift")
    @e
    @NotNull
    Observable<Result<GiftListResult>> I0(@c("liveShowId") @NotNull String str);

    @f("/live/anchor/grade/privilege/lighten/child/list")
    @NotNull
    Observable<Result<LiveStickerResult>> J(@t("userId") @NotNull String str, @t("privilegeType") int i10);

    @o("live/connect/success")
    @e
    @NotNull
    Observable<Result<Object>> J0(@c("liveShowId") @Nullable String str, @c("success") boolean z10, @c("userId") @Nullable String str2);

    @o("/recommend/live/rcmd")
    @e
    @NotNull
    Observable<Result<LiveListResult>> K(@c("latitude") @Nullable Double d10, @c("longitude") @Nullable Double d11, @c("cursor") @Nullable String str, @c("count") int i10);

    @o("/live/pk/appoint/request")
    @e
    @NotNull
    Observable<Result<LivePkRequestResult>> K0(@c("liveShowId") @NotNull String str, @c("pkLiveShowId") @NotNull String str2, @c("cancel") boolean z10);

    @o("/live/pk/multiplayer/close-audio")
    @e
    @NotNull
    Observable<Result<Object>> L(@c("liveShowId") @NotNull String str, @c("pkLiveShowId") @NotNull String str2, @c("close") boolean z10);

    @o("/live/pk/multiplayer/invite/send")
    @e
    @NotNull
    Observable<Result<SendInvitationModel>> L0(@c("liveShowId") @NotNull String str, @c("pkLiveShowId") @NotNull String str2, @c("pkPrepareId") @NotNull String str3);

    @o("/live/share")
    @e
    @NotNull
    Observable<Result<Object>> M(@c("userId") @Nullable String str, @c("liveShowId") @Nullable String str2);

    @o("/live/pk/appoint/accept")
    @e
    @NotNull
    Observable<Result<Object>> M0(@c("liveShowId") @NotNull String str, @c("accept") boolean z10);

    @f("/live/fanclub/missions")
    @NotNull
    Observable<Result<FKFanClubResult>> N(@t("anchorId") @NotNull String str);

    @o("/live/pk/multiplayer/invite/cancel")
    @e
    @NotNull
    Observable<Result<Object>> N0(@c("liveShowId") @NotNull String str, @c("pkLiveShowId") @NotNull String str2, @c("pkPrepareId") @NotNull String str3);

    @o("/live/parcel/useProp")
    @e
    @NotNull
    Observable<Result<PropCardResult>> O(@c("liveShowId") @NotNull String str, @c("userId") @NotNull String str2, @c("parcelId") @NotNull String str3);

    @f("/live/pk/center")
    @NotNull
    Observable<Result<LivePkCenterResult>> O0();

    @f("/recommend/other")
    @NotNull
    Observable<Result<FeedTopLiveModel>> P();

    @o("/recommend/live/module/more")
    @e
    @NotNull
    Observable<Result<ListResult<LiveShowModel>>> Q(@c("id") @NotNull String str, @c("cursor") @Nullable String str2, @c("count") int i10);

    @o("/live/connect/request")
    @e
    @NotNull
    Observable<Result<LiveConnectRequestResult>> R(@c("liveShowId") @Nullable String str, @c("connectType") @Nullable String str2);

    @f("/live/pk/info")
    @NotNull
    Observable<Result<LiveShowPkWarResult>> S(@t("liveShowId") @NotNull String str);

    @o("/live/reserve")
    @NotNull
    Observable<Result<LiveReserveResult>> T();

    @o("/live/stream-follow/complete")
    @e
    @NotNull
    Observable<Result<Object>> U(@c("liveShowId") @NotNull String str);

    @o("/live/share/stat/click")
    @e
    @NotNull
    Observable<Result<Object>> V(@c("userId") @NotNull String str, @c("liveShowId") @Nullable String str2, @c("shareby") @Nullable String str3, @c("channel") @Nullable String str4);

    @f("/live/push/enable/time")
    @NotNull
    Observable<Result<LivePushModel>> W();

    @f("/live/room/data")
    @NotNull
    Observable<Result<LiveShowRankTagListModel>> X(@t("liveShowId") @NotNull String str, @t("messageKey") @Nullable String str2);

    @o("/live/promotion/click")
    @e
    @NotNull
    Observable<Result<Object>> Y(@c("configId") @NotNull String str);

    @f("/live/fanclub/mission-summary")
    @NotNull
    Observable<Result<FKFanClubResult>> Z();

    @o("/live/connect/accompany/start-push")
    @e
    @NotNull
    Observable<Result<Object>> a(@c("liveShowId") @Nullable String str, @c("accompanyLiveId") @Nullable String str2);

    @f("/live/connect/request/list")
    @NotNull
    Observable<Result<LiveShowViewerResult>> a0(@t("liveShowId") @Nullable String str);

    @o("/live/view/leave")
    @e
    @NotNull
    Observable<Result<Object>> b(@c("liveShowId") @NotNull String str);

    @f("/live/pk/check")
    @NotNull
    Observable<Result<Object>> b0();

    @o("/live/pk/appoint/reject")
    @e
    @NotNull
    Observable<Result<Object>> c(@c("liveShowId") @NotNull String str, @c("pkLiveShowId") @NotNull String str2);

    @o("/live/pk/multiplayer/end-pk")
    @e
    @NotNull
    Observable<Result<Object>> c0(@c("liveShowId") @NotNull String str, @c("pkPairId") @NotNull String str2);

    @o("/live/cover/update")
    @e
    @NotNull
    Observable<Result<Object>> d(@c("coverId") @NotNull String str);

    @o("/live/share/stat")
    @e
    @NotNull
    Observable<Result<Object>> d0(@c("userId") @Nullable String str, @c("liveShowId") @Nullable String str2, @c("channel") @Nullable String str3);

    @f("/live/seat")
    @NotNull
    Observable<Result<ListResult<LiveSeatResult>>> e(@t("liveShowId") @Nullable String str);

    @o("/live/pk/appoint/pair")
    @e
    @NotNull
    Observable<Result<Object>> e0(@c("liveShowId") @NotNull String str, @c("pkLiveShowId") @NotNull String str2);

    @f("/live/user-setting")
    @NotNull
    Observable<Result<LiveSettingModel>> f();

    @o("/live/connect/request/close")
    @e
    @NotNull
    Observable<Result<Object>> f0(@c("liveShowId") @Nullable String str, @c("close") @Nullable Boolean bool);

    @o("/live/pk/request")
    @e
    @NotNull
    Observable<Result<LivePkRequestResult>> g(@c("liveShowId") @NotNull String str, @c("cancel") boolean z10);

    @o("/live/view/v3")
    @e
    @NotNull
    Observable<Result<LiveShowResult>> g0(@c("liveShowId") @NotNull String str, @c("recommendId") @Nullable String str2, @c("onlyReturnView") @Nullable Boolean bool);

    @f("/live/fanclub/members")
    @NotNull
    Observable<Result<FKFanClubResult>> h(@t("anchorId") @NotNull String str);

    @o("/recommend/live/universal")
    @e
    @NotNull
    Observable<Result<LiveListResult>> h0(@c("id") @Nullable Integer num, @c("cursor") @Nullable String str, @c("count") int i10);

    @f("/live/menu/unread")
    @NotNull
    Observable<Result<LiveMenuUnreadModel>> i();

    @f("/live/anchor/resource/list")
    @NotNull
    Observable<Result<LiveBeautyResourceResult>> i0();

    @o("/live/fanclub/rename")
    @e
    @NotNull
    Observable<Result<Object>> j(@c("anchorId") @NotNull String str, @c("name") @NotNull String str2);

    @o("/live/pk/endInteract")
    @e
    @NotNull
    Observable<Result<Object>> j0(@c("matchId") @NotNull String str, @c("liveShowId") @NotNull String str2);

    @o("/live/connect/request/cancel")
    @e
    @NotNull
    Observable<Result<Object>> k(@c("liveShowId") @Nullable String str);

    @o("/live/fanclub/set-auto-light-up")
    @e
    @NotNull
    Observable<Result<AutoLightUpResult>> k0(@c("anchorId") @NotNull String str, @c("open") boolean z10);

    @f("/live/menu/viewer ")
    @NotNull
    Observable<Result<LiveFunctionMenuResult>> l();

    @o("/recommend/live/next")
    @e
    @NotNull
    Observable<Result<LiveShowNextListResult>> l0(@c("viewed[]") @NotNull List<String> list, @c("source") @Nullable String str, @c("data") @Nullable String str2);

    @o("/live/pk/multiplayer/prepare-cancel")
    @e
    @NotNull
    Observable<Result<Object>> m(@c("liveShowId") @NotNull String str, @c("pkPrepareId") @NotNull String str2);

    @o("/live/pk/closeAudio")
    @e
    @NotNull
    Observable<Result<Object>> m0(@c("liveShowId") @NotNull String str, @c("pkLiveShowId") @NotNull String str2, @c("close") boolean z10);

    @o("/live/parcel/useGift")
    @e
    @NotNull
    Observable<Result<Object>> n(@c("liveShowId") @NotNull String str, @c("userId") @NotNull String str2, @c("parcelId") @NotNull String str3, @c("count") int i10, @c("rushId") @Nullable Integer num, @c("rush") boolean z10, @c("rushCount") @Nullable Integer num2);

    @o("/live/sticker/del")
    @e
    @NotNull
    Observable<Result<Object>> n0(@c("liveShowId") @NotNull String str);

    @f("/live/heat/intro")
    @NotNull
    Observable<Result<HeatIntroModel>> o();

    @o("/live/star-challenge/claim")
    @e
    @NotNull
    Observable<Result<StarChallengeChestReceiveModel>> o0(@c("id") @NotNull String str);

    @f("/vas/visitor/live-record")
    @NotNull
    Observable<Result<Object>> p(@t("userId") @NotNull String str);

    @o("/live/pk/multiplayer/start-pk")
    @e
    @NotNull
    Observable<Result<StartMultiPkResult>> p0(@c("liveShowId") @NotNull String str, @c("pkPrepareId") @NotNull String str2);

    @o("/agreement/live/confirm")
    @e
    @NotNull
    Observable<Result<Object>> q(@c("version") int i10);

    @o("/live/user-setting/toggle")
    @e
    @NotNull
    Observable<Result<Object>> q0(@c("giftExpirationReminder") @Nullable Boolean bool, @c("stealthWatching") @Nullable Boolean bool2);

    @f("/live/pk/appoint/list")
    @NotNull
    Observable<Result<LivePkFriendListResult>> r(@t("liveShowId") @NotNull String str);

    @f("/live/info/v3")
    @NotNull
    Observable<Result<LiveShowResult>> r0(@t("liveShowId") @Nullable String str, @t("recommendId") @Nullable String str2);

    @f("/live/menu/anchor")
    @NotNull
    Observable<Result<LiveFunctionMenuResult>> s();

    @o("/live/gift/click")
    @e
    @NotNull
    Observable<Result<Object>> s0(@c("giftId") @NotNull String str);

    @o("/live/open/v3")
    @e
    @NotNull
    Observable<Result<LiveShowResult>> t(@c("title") @Nullable String str, @c("imageId") @Nullable String str2, @c("unPush") @Nullable Boolean bool);

    @o("/live/pk/endPk")
    @e
    @NotNull
    Observable<Result<Object>> t0(@c("matchId") @NotNull String str, @c("liveShowId") @NotNull String str2);

    @o("/live/pk/multiplayer/list")
    @e
    @NotNull
    Observable<Result<MultiPkAnchorListResult>> u(@c("liveShowId") @NotNull String str, @c("pkPrepareId") @NotNull String str2);

    @f("/live/cover")
    @NotNull
    Observable<Result<FKLiveCoverModel>> u0();

    @o("/live/sticker/update")
    @e
    @NotNull
    Observable<Result<Object>> v(@c("liveShowId") @NotNull String str, @c("stickerId") @NotNull String str2, @c("content") @Nullable String str3, @c("xVal") double d10, @c("yVal") double d11);

    @o("/live/pk/multiplayer/invite/reject")
    @e
    @NotNull
    Observable<Result<Object>> v0(@c("liveShowId") @NotNull String str, @c("pkPrepareId") @NotNull String str2);

    @o("/live/gift")
    @e
    @NotNull
    Observable<Result<SendGiftResult>> w(@c("liveShowId") @NotNull String str, @c("giftId") @NotNull String str2, @c("rushId") @Nullable Integer num, @c("rush") boolean z10, @c("parcelId") @Nullable String str3, @c("count") int i10, @c("rushCount") @Nullable Integer num2, @c("level") @Nullable Integer num3);

    @f("/live/connect/request/check/v2")
    @NotNull
    Observable<Result<LiveConnectRequestCheckResult>> w0(@t("liveShowId") @NotNull String str);

    @o("/live/close/info")
    @e
    @NotNull
    Observable<Result<LiveEndModel>> x(@c("liveShowId") @NotNull String str);

    @f("/live/fanclub")
    @NotNull
    Observable<Result<FKFanClubResult>> x0(@t("anchorId") @NotNull String str);

    @o("/live/pk/multiplayer/prepare")
    @e
    @NotNull
    Observable<Result<MultiPkPrepareModel>> y(@c("liveShowId") @NotNull String str);

    @o("/live/pk/multiplayer/mix-stream-done")
    @e
    @NotNull
    Observable<Result<Object>> y0(@c("pkPrepareId") @NotNull String str, @c("liveShowId") @NotNull String str2);

    @o("/shake/live")
    @e
    @NotNull
    Observable<Result<LiveShowShakeResult>> z(@c("shakeId") @NotNull String str);

    @o("recommend/followInTab")
    @e
    @NotNull
    Observable<Result<LiveListResult>> z0(@c("cursor") @Nullable String str, @c("count") int i10);
}
