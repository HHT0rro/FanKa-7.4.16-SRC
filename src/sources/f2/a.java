package f2;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.feed.model.CommentResult;
import com.cupidapp.live.feed.model.FeedFloatBubbleModel;
import com.cupidapp.live.feed.model.FeedLikeResult;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendAdTopModel;
import com.cupidapp.live.feed.model.FeedRecommendListResult;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.feed.model.FeedResultModel;
import com.cupidapp.live.feed.model.FeedSettingResult;
import com.cupidapp.live.feed.model.FeedTopIntroModel;
import com.cupidapp.live.feed.model.FeedTopResultModel;
import com.cupidapp.live.feed.model.HashTagFeedResult;
import com.cupidapp.live.feed.model.PostCommentModel;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.feed.model.PostLimitDetailResult;
import com.cupidapp.live.feed.model.PostLimitPublishModel;
import com.cupidapp.live.feed.model.RainbowRecommendResult;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.hashtag.model.HashTagAggregationModel;
import com.cupidapp.live.hashtag.model.HashTagInfoResult;
import com.cupidapp.live.hashtag.model.HashTagTowardNewResult;
import com.cupidapp.live.match.model.GuideModel;
import com.cupidapp.live.mediapicker.model.PasterModel;
import com.cupidapp.live.mentionuser.model.AtUserModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.s;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.b;

/* compiled from: FeedService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: FeedService.kt */
    @d
    /* renamed from: f2.a$a */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0731a {
        public static /* synthetic */ Observable a(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeFriendFeedV4");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 21;
            }
            return aVar.M(str, i10);
        }

        public static /* synthetic */ Observable b(a aVar, String str, String str2, String str3, int i10, String str4, int i11, Object obj) {
            if (obj == null) {
                return aVar.p(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? 20 : i10, (i11 & 16) != 0 ? null : str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: commentList");
        }

        public static /* synthetic */ Observable c(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedLiked");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.o(str, i10);
        }

        public static /* synthetic */ Observable d(a aVar, String str, String str2, String str3, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedRecommendList");
            }
            if ((i11 & 8) != 0) {
                i10 = 21;
            }
            return aVar.a0(str, str2, str3, i10);
        }

        public static /* synthetic */ Observable e(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedTagList");
            }
            if ((i11 & 2) != 0) {
                i10 = 21;
            }
            return aVar.I(str, i10);
        }

        public static /* synthetic */ Observable f(a aVar, String str, int i10, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedUser");
            }
            if ((i11 & 2) != 0) {
                i10 = 21;
            }
            if ((i11 & 4) != 0) {
                str2 = null;
            }
            return aVar.s(str, i10, str2);
        }

        public static /* synthetic */ Observable g(a aVar, String str, int i10, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedV4");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 21;
            }
            if ((i11 & 4) != 0) {
                str2 = null;
            }
            return aVar.G(str, i10, str2);
        }

        public static /* synthetic */ Observable h(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: focusFeedV4");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 21;
            }
            return aVar.n(str, i10);
        }

        public static /* synthetic */ Observable i(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSpecialExposure");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.Y(str, i10);
        }

        public static /* synthetic */ Observable j(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hashTagFeedList");
            }
            if ((i11 & 4) != 0) {
                i10 = 21;
            }
            return aVar.k(str, str2, i10);
        }

        public static /* synthetic */ Observable k(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hashTagFeedListPageTurning");
            }
            if ((i11 & 4) != 0) {
                i10 = 21;
            }
            return aVar.w(str, str2, i10);
        }

        public static /* synthetic */ Observable l(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hashTagHot");
            }
            if ((i11 & 4) != 0) {
                i10 = 8;
            }
            return aVar.j(str, str2, i10);
        }

        public static /* synthetic */ Observable m(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hashTagNew");
            }
            if ((i11 & 4) != 0) {
                i10 = 8;
            }
            return aVar.f(str, str2, i10);
        }

        public static /* synthetic */ Observable n(a aVar, boolean z10, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postLimitPrivateList");
            }
            if ((i11 & 2) != 0) {
                str = null;
            }
            if ((i11 & 4) != 0) {
                str2 = null;
            }
            if ((i11 & 8) != 0) {
                i10 = 21;
            }
            return aVar.l(z10, str, str2, i10);
        }

        public static /* synthetic */ Observable o(a aVar, String str, String str2, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postViewer");
            }
            if ((i11 & 2) != 0) {
                str2 = null;
            }
            if ((i11 & 4) != 0) {
                i10 = 20;
            }
            return aVar.e(str, str2, i10);
        }

        public static /* synthetic */ Observable p(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: privateFeedList");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.X(str, i10);
        }
    }

    @o("/v1/feed/like")
    @e
    @NotNull
    Observable<Result<FeedLikeResult>> A(@c("postId") @NotNull String str);

    @f("/sticker/list")
    @NotNull
    Observable<Result<ListResult<PasterModel>>> B();

    @o("/post/limit/publish")
    @e
    @NotNull
    Observable<Result<PostLimitPublishModel>> C(@c("imageId") @NotNull String str, @c("contents[]") @Nullable List<String> list, @c("chatStatus") @Nullable Integer num);

    @o("/v1/feed/like/cancel")
    @e
    @NotNull
    Observable<Result<Object>> D(@c("postId") @NotNull String str);

    @o("/feed/dynamicTop/set")
    @e
    @NotNull
    Observable<Result<FeedTopResultModel>> E(@c("postId") @NotNull String str, @c("dynamicTop") boolean z10);

    @o("/post/limit/del")
    @e
    @NotNull
    Observable<Result<Object>> F(@c("postLimitId") @NotNull String str);

    @f("/feed/v5")
    @NotNull
    Observable<Result<FeedResultModel>> G(@t("cursor") @Nullable String str, @t("count") int i10, @t("feedSortType") @Nullable String str2);

    @o("/ad/exposure/count/feed")
    @e
    @NotNull
    Observable<Result<Object>> H(@c("type") int i10, @c("idStr") @NotNull String str);

    @f("/feed/tag/picker")
    @NotNull
    Observable<Result<ListResult<HashTag>>> I(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/feed/detail/v3/multi")
    @NotNull
    Observable<Result<ListResult<FeedModel>>> J(@t("postId") @Nullable String str);

    @f("/post/rcmd/list")
    @NotNull
    Observable<Result<FeedRecommendListResult>> K(@t("cursor") @Nullable String str);

    @f("/guide/match/v2")
    @NotNull
    Observable<Result<GuideModel>> L();

    @f("/v1/close-friend/feed")
    @NotNull
    Observable<Result<FeedResultModel>> M(@t("cursor") @Nullable String str, @t("count") int i10);

    @o("/user/setting/special-exposure")
    @e
    @NotNull
    Observable<Result<Object>> N(@c("status") boolean z10);

    @f("/post/rcmd/comment-post-rcmd")
    @NotNull
    Observable<Result<ListResult<FeedModel>>> O(@t("cursor") @Nullable String str, @t("postId") @Nullable String str2);

    @f("/hashtag/towardNew")
    @NotNull
    Observable<Result<HashTagTowardNewResult>> P();

    @o("/feed/superboost/skip-bmi/add")
    @e
    @NotNull
    Observable<Result<Object>> Q(@c("postId") @NotNull String str);

    @o("/feed/post-boost/reduce-rcmd")
    @e
    @NotNull
    Observable<Result<Object>> R(@c("postId") @NotNull String str);

    @o("/feed/private/set")
    @e
    @NotNull
    Observable<Result<Object>> S(@c("postId") @NotNull String str, @c("add") boolean z10);

    @o("/comment/like")
    @e
    @NotNull
    Observable<Result<Object>> T(@c("postId") @NotNull String str, @c("commentId") @NotNull String str2);

    @f("/user/setting/feed")
    @NotNull
    Observable<Result<FeedSettingResult>> U();

    @o("/feed/v4/action")
    @e
    @NotNull
    b<Result<Object>> V(@c("jsonArray") @NotNull String str);

    @f("/feed/at/list")
    @NotNull
    Observable<Result<AtUserModel>> W();

    @f("/feed/private/list")
    @NotNull
    Observable<Result<ListResult<FeedModel>>> X(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/vas/special-exposure")
    @NotNull
    Observable<Result<RainbowRecommendResult>> Y(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/post/limit/detail")
    @NotNull
    Observable<Result<PostLimitDetailResult>> Z(@t("postLimitId") @NotNull String str, @t("messageId") @Nullable String str2);

    @f("/feed/dynamicTop/bottom/window")
    @NotNull
    Observable<Result<FeedTopIntroModel>> a();

    @f("/post/rcmd/list/{tag}")
    @NotNull
    Observable<Result<ListResult<FeedRecommendResult>>> a0(@s("tag") @NotNull String str, @t("tab") @Nullable String str2, @t("cursor") @Nullable String str3, @t("count") int i10);

    @o("/feed/sponsor/hide")
    @e
    @NotNull
    Observable<Result<Object>> b(@c("postId") @NotNull String str);

    @o("/feed/superboost/skip-user/add")
    @e
    @NotNull
    Observable<Result<Object>> b0(@c("postId") @NotNull String str);

    @f("/post/rcmd/info/{tag}")
    @NotNull
    Observable<Result<FeedRecommendAdTopModel>> c(@s("tag") @NotNull String str);

    @o("/feed/superboost/not/interest")
    @e
    @NotNull
    Observable<Result<Object>> d(@c("postId") @NotNull String str, @c("type") @Nullable String str2);

    @f("/post/limit/viewers")
    @NotNull
    Observable<Result<ListResult<User>>> e(@t("postLimitId") @NotNull String str, @t("cursor") @Nullable String str2, @t("count") int i10);

    @f("/hashtag/post/new")
    @NotNull
    Observable<Result<ListResult<FeedModel>>> f(@t("hashtagId") @NotNull String str, @t("cursor") @Nullable String str2, @t("count") int i10);

    @o("/v1/feed/delete")
    @e
    @NotNull
    Observable<Result<Object>> g(@c("postId") @NotNull String str);

    @o("/comment/like/cancel")
    @e
    @NotNull
    Observable<Result<Object>> h(@c("postId") @NotNull String str, @c("commentId") @NotNull String str2);

    @o("/post/limit/read")
    @e
    @NotNull
    Observable<Result<Object>> i(@c("postLimitId") @NotNull String str, @c("authorId") @NotNull String str2);

    @f("/hashtag/post/hot")
    @NotNull
    Observable<Result<ListResult<FeedModel>>> j(@t("hashtagId") @NotNull String str, @t("cursor") @Nullable String str2, @t("count") int i10);

    @f("/hashtag/post/v4/multi")
    @NotNull
    Observable<Result<HashTagFeedResult>> k(@t("itemId") @NotNull String str, @t("cursor") @Nullable String str2, @t("count") int i10);

    @f("/post/limit/user")
    @NotNull
    Observable<Result<ListResult<PostLimitDetailModel>>> l(@t("limited") boolean z10, @t("userId") @Nullable String str, @t("cursor") @Nullable String str2, @t("count") int i10);

    @f("/feed/v5/floatBubble")
    @NotNull
    Observable<Result<FeedFloatBubbleModel>> m();

    @f("/v1/focus/feed/list")
    @NotNull
    Observable<Result<FeedResultModel>> n(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/feed/liked/v3/multi")
    @NotNull
    Observable<Result<ListResult<FeedModel>>> o(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/feed/v4/comment")
    @NotNull
    Observable<Result<ListResult<PostCommentModel>>> p(@t("postId") @NotNull String str, @t("cursor") @Nullable String str2, @t("commentId") @Nullable String str3, @t("count") int i10, @t("relatedCommentId") @Nullable String str4);

    @o("/feed/share")
    @e
    @NotNull
    Observable<Result<Object>> q(@c("postId") @NotNull String str);

    @o("/v1/feed/comment/delete")
    @e
    @NotNull
    Observable<Result<Object>> r(@c("postId") @NotNull String str, @c("commentId") @NotNull String str2);

    @o("/feed/user/v3/multi")
    @e
    @NotNull
    Observable<Result<ListResult<FeedModel>>> s(@c("uid") @Nullable String str, @c("count") int i10, @c("cursor") @Nullable String str2);

    @f("/hashtag/info")
    @NotNull
    Observable<Result<HashTagInfoResult>> t(@t("hashtagId") @NotNull String str);

    @o("/feed/comment/v3")
    @e
    @NotNull
    Observable<Result<CommentResult>> u(@c("postId") @NotNull String str, @c("replyCommentId") @Nullable String str2, @c("comment") @NotNull String str3, @c("replaceAtList") @Nullable String str4);

    @o("/user/setting/feed")
    @e
    @NotNull
    Observable<Result<Object>> v(@c("feedSortType") @NotNull String str);

    @f("/hashtag/post/v4")
    @NotNull
    Observable<Result<ListResult<FeedModel>>> w(@t("itemId") @NotNull String str, @t("cursor") @Nullable String str2, @t("count") int i10);

    @o("/post/limit/user/list")
    @e
    @NotNull
    Observable<Result<ListResult<List<PostLimitDetailModel>>>> x(@c("userIds[]") @NotNull List<String> list);

    @f("/sticker/record")
    @NotNull
    Completable y();

    @f("/hashtag/aggregation")
    @NotNull
    Observable<Result<ListResult<HashTagAggregationModel>>> z();
}
