package x2;

import com.cupidapp.live.ai.model.AiIdentifyGraphModel;
import com.cupidapp.live.ai.model.AiIdentifyModel;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.ProfileInfoResult;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.ProfileTaskResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.RewardDetailModel;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.web.model.FaceInfoModel;
import com.cupidapp.live.chat.model.UserMatchListResult;
import com.cupidapp.live.chat.service.NewMatchListResult;
import com.cupidapp.live.filter.model.FilterTopTabModel;
import com.cupidapp.live.main.model.SearchResult;
import com.cupidapp.live.main.model.UserAccountResult;
import com.cupidapp.live.main.model.UserModifyResult;
import com.cupidapp.live.match.model.ExposureEntranceModel;
import com.cupidapp.live.profile.model.AlohaCancelListModel;
import com.cupidapp.live.profile.model.CloseFriendListModel;
import com.cupidapp.live.profile.model.CompatResult;
import com.cupidapp.live.profile.model.FKStoryLabelListModel;
import com.cupidapp.live.profile.model.FocusResultModel;
import com.cupidapp.live.profile.model.FocusUserListModel;
import com.cupidapp.live.profile.model.FriendPraiseResult;
import com.cupidapp.live.profile.model.ProfileComplementResult;
import com.cupidapp.live.profile.model.ProfileSpecModifyResult;
import com.cupidapp.live.profile.model.SuperLikeGuideResult;
import com.cupidapp.live.profile.model.UnfollowNotifyModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserListResult;
import com.cupidapp.live.setting.model.BindMobileResult;
import com.cupidapp.live.setting.model.FootMarkResult;
import com.cupidapp.live.setting.model.PrivacySettingDataResult;
import com.cupidapp.live.superboost.model.DirectSuperBoostFilterModel;
import com.cupidapp.live.superboost.model.RemainAssetsResult;
import com.cupidapp.live.superboost.model.SuperBoostRemainAssetsResult;
import com.cupidapp.live.superlike.model.FollowType;
import com.cupidapp.live.superlike.model.SuperLikeNumModel;
import com.cupidapp.live.visitors.model.FootmarkModel;
import com.cupidapp.live.visitors.model.VisitorsResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.s;
import ne.t;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {

    /* compiled from: UserService.kt */
    @d
    /* renamed from: x2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0836a {
        public static /* synthetic */ Observable a(a aVar, String str, boolean z10, String str2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: focus");
            }
            if ((i10 & 4) != 0) {
                str2 = null;
            }
            return aVar.b0(str, z10, str2);
        }

        public static /* synthetic */ Observable b(a aVar, int i10, String str, int i11, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: myFriendPraise");
            }
            if ((i12 & 2) != 0) {
                str = null;
            }
            if ((i12 & 4) != 0) {
                i11 = 20;
            }
            return aVar.i(i10, str, i11);
        }

        public static /* synthetic */ Observable c(a aVar, String str, boolean z10, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: otherFriendPraise");
            }
            if ((i11 & 4) != 0) {
                str2 = null;
            }
            if ((i11 & 8) != 0) {
                i10 = 20;
            }
            return aVar.t0(str, z10, str2, i10);
        }

        public static /* synthetic */ Observable d(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postPraiseUserList");
            }
            if ((i11 & 2) != 0) {
                str2 = null;
            }
            if ((i11 & 4) != 0) {
                i10 = 30;
            }
            return aVar.Y(str, str2, i10);
        }

        public static /* synthetic */ Observable e(a aVar, String str, Integer num, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchUser");
            }
            if ((i10 & 2) != 0) {
                num = null;
            }
            return aVar.u0(str, num);
        }

        public static /* synthetic */ Observable f(a aVar, Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, String str, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPrivacy");
            }
            if ((i10 & 1) != 0) {
                num = null;
            }
            if ((i10 & 2) != 0) {
                bool = null;
            }
            if ((i10 & 4) != 0) {
                bool2 = null;
            }
            if ((i10 & 8) != 0) {
                bool3 = null;
            }
            if ((i10 & 16) != 0) {
                bool4 = null;
            }
            if ((i10 & 32) != 0) {
                bool5 = null;
            }
            if ((i10 & 64) != 0) {
                bool6 = null;
            }
            if ((i10 & 128) != 0) {
                str = null;
            }
            if ((i10 & 256) != 0) {
                bool7 = null;
            }
            if ((i10 & 512) != 0) {
                bool8 = null;
            }
            if ((i10 & 1024) != 0) {
                bool9 = null;
            }
            if ((i10 & 2048) != 0) {
                bool10 = null;
            }
            return aVar.a0(num, bool, bool2, bool3, bool4, bool5, bool6, str, bool7, bool8, bool9, bool10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable g(a aVar, List list, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unLikeUnMatchedUsers");
            }
            if ((i11 & 1) != 0) {
                list = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return aVar.c0(list, i10);
        }

        public static /* synthetic */ Observable h(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userBlackList");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.q(str, i10);
        }

        public static /* synthetic */ Observable i(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userLikedUnMatch");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.m(str, i10);
        }

        public static /* synthetic */ Observable j(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userLikedUnMatchBan");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.q0(str, i10);
        }

        public static /* synthetic */ Observable k(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchActive");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.C0(str, i10);
        }

        public static /* synthetic */ Observable l(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchBan");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.E0(str, i10);
        }

        public static /* synthetic */ Observable m(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchClosest");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.f(str, i10);
        }

        public static /* synthetic */ Observable n(a aVar, String str, String str2, String str3, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchDisLike");
            }
            if ((i10 & 4) != 0) {
                str3 = null;
            }
            return aVar.D0(str, str2, str3);
        }

        public static /* synthetic */ Observable o(a aVar, String str, String str2, String str3, String str4, int i10, String str5, Integer num, String str6, int i11, Object obj) {
            if (obj == null) {
                return aVar.L0(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? FollowType.Default.getValue() : i10, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : num, (i11 & 128) == 0 ? str6 : null);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLike");
        }

        public static /* synthetic */ Observable p(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLikedActive");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.S(str, i10);
        }

        public static /* synthetic */ Observable q(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLikedBan");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.e0(str, i10);
        }

        public static /* synthetic */ Observable r(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLikedClosest");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.b(str, i10);
        }

        public static /* synthetic */ Observable s(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLikedMeActive");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.M(str, i10);
        }

        public static /* synthetic */ Observable t(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLikedMeBan");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.j(str, i10);
        }

        public static /* synthetic */ Observable u(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLikedMeClosest");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.Q(str, i10);
        }

        public static /* synthetic */ Observable v(a aVar, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLikedMeNewest");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            return aVar.a(str);
        }

        public static /* synthetic */ Observable w(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchLikedNewest");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.V(str, i10);
        }

        public static /* synthetic */ Observable x(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userMatchNewest");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.K0(str, i10);
        }

        public static /* synthetic */ Observable y(a aVar, String str, String str2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userProfileModify");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            return aVar.J0(str, str2);
        }

        public static /* synthetic */ Observable z(a aVar, String str, Boolean bool, String str2, boolean z10, String str3, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userProfileView");
            }
            if ((i10 & 2) != 0) {
                bool = Boolean.FALSE;
            }
            return aVar.o(str, bool, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? null : str3);
        }
    }

    @f("/user/profile/new/task")
    @NotNull
    Observable<Result<ProfileTaskResult>> A();

    @o("/user/profile/avatar-multi/modify")
    @e
    @NotNull
    Observable<Result<UserModifyResult>> A0(@c("imageIds[]") @Nullable List<String> list, @c("videoId") @Nullable String str, @c("videoImageId") @Nullable String str2);

    @f("/billing/assets/{productType}")
    @NotNull
    Observable<Result<RemainAssetsResult>> B(@s("productType") @NotNull String str);

    @o("/user/account/bind-mobile")
    @e
    @NotNull
    Observable<Result<BindMobileResult>> B0(@c("number") @Nullable String str, @c("code") @Nullable String str2);

    @f("/profile/info/v2")
    @NotNull
    Observable<Result<ProfileInfoResult>> C();

    @o("/user/match/active/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> C0(@c("cursor") @Nullable String str, @c("count") int i10);

    @o("/user/profile/task/reward")
    @e
    @NotNull
    Observable<Result<Object>> D(@c("taskId") @NotNull String str, @c("taskType") @Nullable String str2);

    @o("/user/match/dislike/v3")
    @e
    @NotNull
    Observable<Result<SwipeCardUserLikeResult>> D0(@c("userId") @NotNull String str, @c("recommendContext") @Nullable String str2, @c("refer") @Nullable String str3);

    @o("/vas/footmark/del")
    @e
    @NotNull
    Observable<Result<FootMarkResult>> E(@c("footmarkUserId") @Nullable String str);

    @o("/user/match/ban")
    @e
    @NotNull
    Observable<Result<ListResult<User>>> E0(@c("cursor") @Nullable String str, @c("count") int i10);

    @f("/user/account")
    @NotNull
    Observable<Result<UserAccountResult>> F();

    @f("/v1/user/setting/privacy")
    @NotNull
    Observable<Result<PrivacySettingDataResult>> F0();

    @f("/v1/nonage/face-info")
    @NotNull
    Observable<Result<FaceInfoModel>> G();

    @o("/user/profile/update/ad-status")
    @e
    @NotNull
    Observable<Result<Object>> G0(@c("adStatus") @NotNull String str);

    @f("/vas/footmark/hide")
    @NotNull
    Observable<Result<FootMarkResult>> H();

    @o("/v1/user/blacklist/unblock")
    @e
    @NotNull
    Observable<Result<Object>> H0(@c("userId") @NotNull String str);

    @o("/user/praise/submit")
    @e
    @NotNull
    Observable<Result<Object>> I(@c("toUserId") @NotNull String str, @c("content") @NotNull String str2, @c("anonymous") boolean z10);

    @o("/user/praise/home/page/show")
    @e
    @NotNull
    Observable<Result<Object>> I0(@c("id") @NotNull String str, @c("homePageDisplay") boolean z10);

    @f("/vas/superboost/targeted-option")
    @NotNull
    Observable<Result<DirectSuperBoostFilterModel>> J();

    @o("/user/profile/modify/v4")
    @e
    @NotNull
    Observable<Result<UserModifyResult>> J0(@c("name") @Nullable String str, @c("summary") @Nullable String str2);

    @o("/user/account/password/forget")
    @NotNull
    Observable<Result<Object>> K();

    @o("/user/match/newest/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> K0(@c("cursor") @Nullable String str, @c("count") int i10);

    @f("/vas/relation/setting/address-book")
    @NotNull
    Observable<Result<UnfollowNotifyModel>> L();

    @o("/user/match/like/v4")
    @e
    @NotNull
    Observable<Result<SwipeCardUserLikeResult>> L0(@c("userId") @Nullable String str, @c("recommendContext") @Nullable String str2, @c("liveShowId") @Nullable String str3, @c("refer") @Nullable String str4, @c("alohaType") int i10, @c("postStatisticsSource") @Nullable String str5, @c("combos") @Nullable Integer num, @c("voiceRoomId") @Nullable String str6);

    @o("/user/match/likedme/v3/active/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> M(@c("cursor") @Nullable String str, @c("count") int i10);

    @f("/feed/skip-user/list")
    @NotNull
    Observable<Result<ListResult<User>>> M0(@t("cursor") @Nullable String str);

    @o("/vas/superboost/use")
    @NotNull
    Observable<Result<Object>> N(@ne.a @NotNull FormBody formBody);

    @f("/inbox/match/newest")
    @NotNull
    Observable<Result<NewMatchListResult>> N0();

    @o("/feed/skip-user/remove")
    @e
    @NotNull
    Observable<Result<Object>> O(@c("userId") @NotNull String str);

    @o("/v1/close-friend")
    @e
    @NotNull
    Observable<Result<Object>> O0(@c("userId") @NotNull String str, @c("add") boolean z10);

    @o("/feed/skip-user/add")
    @e
    @NotNull
    Observable<Result<Object>> P(@c("userId") @NotNull String str);

    @o("/v1/nonage/face/callback")
    @e
    @NotNull
    Observable<Result<Object>> P0(@c("orderNo") @Nullable String str, @c("success") boolean z10, @c("errJson") @Nullable String str2);

    @o("/user/match/likedme/v3/closest/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> Q(@c("cursor") @Nullable String str, @c("count") int i10);

    @f("/vas/superboost/travelboost/marketing-info")
    @NotNull
    Observable<Result<ExposureEntranceModel>> Q0();

    @f("/v1/close-friend/list")
    @NotNull
    Observable<Result<CloseFriendListModel>> R(@t("cursor") @Nullable String str);

    @o("/user/setting/quick/login/edit")
    @e
    @NotNull
    Observable<Result<Object>> R0(@c("useQuickLogin") boolean z10);

    @o("/user/match/liked/v3/active/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> S(@c("cursor") @Nullable String str, @c("count") int i10);

    @o("/live/cancel-ban")
    @e
    @NotNull
    Observable<Result<Object>> T(@c("liveShowId") @NotNull String str, @c("userId") @NotNull String str2);

    @f("/vas/superLike/num/check")
    @NotNull
    Observable<Result<SuperLikeNumModel>> U();

    @o("/user/match/liked/v3/newest/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> V(@c("cursor") @Nullable String str, @c("count") int i10);

    @f("/vas/superboost/guide")
    @NotNull
    Observable<Result<SuperLikeGuideResult>> W();

    @o("/user/account/reset-password")
    @e
    @NotNull
    Observable<Result<Object>> X(@c("oldPasswordMd5") @Nullable String str, @c("code") @Nullable String str2, @c("passwordMd5") @Nullable String str3);

    @f("/feed/like/v3")
    @NotNull
    Observable<Result<ListResult<User>>> Y(@t("postId") @NotNull String str, @t("cursor") @Nullable String str2, @t("count") int i10);

    @o("/user/profile/avatar/window/show")
    @e
    @NotNull
    Observable<Result<Object>> Z(@c("scene") @NotNull String str);

    @o("/user/match/likedme/v3/newest/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> a(@c("cursor") @Nullable String str);

    @o("/v1/user/setting/privacy")
    @e
    @NotNull
    Observable<Result<PrivacySettingDataResult>> a0(@c("matchExcludeDistanceKm") @Nullable Integer num, @c("hiddenActive") @Nullable Boolean bool, @c("hidden") @Nullable Boolean bool2, @c("hiddenFootmark") @Nullable Boolean bool3, @c("stealthMessage") @Nullable Boolean bool4, @c("vipIconHide") @Nullable Boolean bool5, @c("openPersonalizedRecommendation") @Nullable Boolean bool6, @c("customAppIcon") @Nullable String str, @c("hideBalanceLevel") @Nullable Boolean bool7, @c("aiGraphHide") @Nullable Boolean bool8, @c("expireTextRemind") @Nullable Boolean bool9, @c("notInNearbyForBoot") @Nullable Boolean bool10);

    @o("/user/match/liked/v3/closest/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> b(@c("cursor") @Nullable String str, @c("count") int i10);

    @o("/user/focus/relation")
    @e
    @NotNull
    Observable<Result<FocusResultModel>> b0(@c("userId") @NotNull String str, @c("focus") boolean z10, @c("postStatisticsSource") @Nullable String str2);

    @f("/user/profile/label")
    @NotNull
    Observable<Result<ListResult<FKStoryLabelListModel>>> c();

    @o("/vas/relation/liked/unfollow")
    @e
    @NotNull
    Observable<Result<Object>> c0(@c("userIds[]") @Nullable List<String> list, @c("mode") int i10);

    @o("/user/match/clearNewMatch")
    @e
    @NotNull
    Observable<Result<UserMatchListResult>> d(@c("userId") @NotNull String str);

    @f("/user/account/verify-code")
    @NotNull
    Observable<Result<Object>> d0(@t("number") @Nullable String str);

    @f("/vas/footmark/list")
    @NotNull
    Observable<Result<ListResult<FootmarkModel>>> e(@t("cursor") @Nullable String str);

    @o("/user/match/liked/ban")
    @e
    @NotNull
    Observable<Result<ListResult<User>>> e0(@c("cursor") @Nullable String str, @c("count") int i10);

    @o("/user/match/closest/v3")
    @e
    @NotNull
    Observable<Result<UserListResult>> f(@c("cursor") @Nullable String str, @c("count") int i10);

    @o("/v1/user/setting/ad/edit")
    @e
    @NotNull
    Observable<Result<Object>> f0(@c("setting") boolean z10);

    @o("/vas/relation/setting/address-book")
    @e
    @NotNull
    Observable<Result<Object>> g(@c("unfollowNotifyRange") int i10);

    @f("/billing/assets/superboost-all")
    @NotNull
    Observable<Result<SuperBoostRemainAssetsResult>> g0();

    @o("/v1/user/blacklist/block")
    @e
    @NotNull
    Observable<Result<Object>> h(@c("userId") @NotNull String str);

    @f("/vas/superLike/guide")
    @NotNull
    Observable<Result<SuperLikeGuideResult>> h0(@t("sceneType") int i10, @t("userId") @Nullable String str);

    @f("/user/praise/myPraise")
    @NotNull
    Observable<Result<FriendPraiseResult>> i(@t("type") int i10, @t("cursor") @Nullable String str, @t("count") int i11);

    @o("/connect/bind/weixin")
    @e
    @NotNull
    Observable<Result<Object>> i0(@c("code") @NotNull String str);

    @o("/user/match/likedme/ban")
    @e
    @NotNull
    Observable<Result<ListResult<User>>> j(@c("cursor") @Nullable String str, @c("count") int i10);

    @o("/profile/info/card/red-dot/click")
    @e
    @NotNull
    Observable<Result<Object>> j0(@c("configKey") @NotNull String str);

    @o("/user/praise/like")
    @e
    @NotNull
    Observable<Result<Object>> k(@c("id") @NotNull String str, @c("cancel") boolean z10);

    @o("/user/account/first-reset-password")
    @e
    @NotNull
    Observable<Result<Object>> k0(@c("passwordMd5") @Nullable String str);

    @o("/user/profile/spec/delete")
    @e
    @NotNull
    Observable<Result<ProfileSpecModifyResult>> l(@c("itemId") @NotNull String str);

    @o("/user/profile/label")
    @e
    @NotNull
    Observable<Result<Object>> l0(@c("labelId") @NotNull String str, @c("content") @NotNull String str2);

    @f("/vas/relation/liked/unmatched")
    @NotNull
    Observable<Result<UserListResult>> m(@t("cursor") @Nullable String str, @t("count") int i10);

    @o("/user/profile/label/order")
    @e
    @NotNull
    Observable<Result<Object>> m0(@c("labelIds[]") @NotNull List<String> list);

    @f("/vas/ai-graph/info")
    @NotNull
    Observable<Result<AiIdentifyGraphModel>> n();

    @o("/v1/user/unauth")
    @NotNull
    Observable<Result<Object>> n0();

    @f("/user/profile/view/v3")
    @NotNull
    Observable<Result<ProfileResult>> o(@t("userId") @NotNull String str, @t("forUpdate") @Nullable Boolean bool, @t("source") @Nullable String str2, @t("isUsingMap") boolean z10, @t("postStatisticsSource") @Nullable String str3);

    @f("/user/profile/task/reward/detail")
    @NotNull
    Observable<Result<RewardDetailModel>> o0(@t("taskId") @NotNull String str, @t("taskType") @Nullable String str2);

    @f("/user/focus/relation/list")
    @NotNull
    Observable<Result<FocusUserListModel>> p();

    @o("/user/account/verify-password")
    @e
    @NotNull
    Observable<Result<Object>> p0(@c("passwordMd5") @Nullable String str);

    @f("/user/blacklist/v3")
    @NotNull
    Observable<Result<ListResult<User>>> q(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/vas/relation/liked/ban")
    @NotNull
    Observable<Result<UserListResult>> q0(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/user/setting/filter")
    @NotNull
    Observable<Result<FilterTopTabModel>> r(@t("scene") int i10);

    @o("/user/profile/spec/modify")
    @e
    @NotNull
    Observable<Result<ProfileSpecModifyResult>> r0(@c("itemId") @NotNull String str, @c("value[]") @NotNull List<String> list);

    @o("/live/kick/out")
    @e
    @NotNull
    Observable<Result<Object>> s(@c("liveShowId") @NotNull String str, @c("userId") @NotNull String str2);

    @f("/user/profile/complement/view")
    @NotNull
    Observable<Result<ProfileComplementResult>> s0();

    @o("/live/ban")
    @e
    @NotNull
    Observable<Result<Object>> t(@c("liveShowId") @NotNull String str, @c("userId") @NotNull String str2);

    @f("/user/praise/othersPraise")
    @NotNull
    Observable<Result<FriendPraiseResult>> t0(@t("userId") @NotNull String str, @t("fromShare") boolean z10, @t("cursor") @Nullable String str2, @t("count") int i10);

    @f("/vas/relation/liked/aloha-cancel")
    @NotNull
    Observable<Result<AlohaCancelListModel>> u(@t("cursor") @Nullable String str);

    @o("/search/user")
    @e
    @NotNull
    Observable<Result<SearchResult>> u0(@c("keyword") @NotNull String str, @c("count") @Nullable Integer num);

    @f("/vas/visitor/by-type")
    @NotNull
    Observable<Result<VisitorsResult>> v(@t("type") @Nullable String str);

    @f("/v1/close-friend/count")
    @NotNull
    Observable<Result<j3.a>> v0();

    @o("/user/setting/single/filter")
    @NotNull
    Observable<Result<Object>> w(@ne.a @NotNull FormBody formBody);

    @o("/user/praise/delete")
    @e
    @NotNull
    Observable<Result<Object>> w0(@c("id") @NotNull String str);

    @o("/vas/ai-graph")
    @NotNull
    Observable<Result<AiIdentifyModel>> x(@ne.a @NotNull RequestBody requestBody);

    @o("/vas/footmark/hide")
    @e
    @NotNull
    Observable<Result<Object>> x0(@c("hiddenFootmark") boolean z10);

    @o("/user/profile/complement")
    @NotNull
    Observable<Result<CompatResult>> y(@ne.a @NotNull FormBody formBody);

    @o("/user/setting/privacy/stealthMessage")
    @e
    @NotNull
    Observable<Result<Object>> y0(@c("stealthMessage") boolean z10);

    @o("/live/admin/add")
    @e
    @NotNull
    Observable<Result<Object>> z(@c("adminId") @NotNull String str);

    @f("/vas/visitor")
    @NotNull
    Observable<Result<VisitorsResult>> z0();
}
