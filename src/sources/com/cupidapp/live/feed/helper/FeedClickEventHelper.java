package com.cupidapp.live.feed.helper;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.base.web.WebStyleEnum;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.feed.FeedSort;
import com.cupidapp.live.feed.activity.HashTagFeedListActivity;
import com.cupidapp.live.feed.holder.BaseFeedViewHolder;
import com.cupidapp.live.feed.model.CustomTag;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedPraiseGuideModel;
import com.cupidapp.live.feed.model.SponsorModel;
import com.cupidapp.live.hashtag.detail.HashTagMainActivity;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.view.UserAlertDialogHelper;
import com.cupidapp.live.push.model.PushAlertScene;
import com.cupidapp.live.push.model.PushAlertShowModel;
import com.cupidapp.live.startup.helper.ADMonitorHelper;
import com.cupidapp.live.superlike.view.SuperLikeDialogLayout;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.huawei.openalliance.ad.constant.ad;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: FeedClickEventHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedClickEventHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Lifecycle f14295a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Context f14296b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final RecyclerView f14297c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14298d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final FeedSensorContext f14299e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Map<String, Object> f14300f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f14301g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<Object>[] f14302h;

    /* compiled from: FeedClickEventHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14303a;

        static {
            int[] iArr = new int[SensorPosition.values().length];
            try {
                iArr[SensorPosition.Feed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorPosition.FeedDetail.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f14303a = iArr;
        }
    }

    public FeedClickEventHelper(@NotNull Lifecycle lifecycle, @Nullable Context context, @NotNull RecyclerView feedRecyclerView, boolean z10, @NotNull FeedSensorContext sensorsContext, @Nullable Map<String, ? extends Object> map, @Nullable String str, @NotNull List<Object>... modelList) {
        s.i(lifecycle, "lifecycle");
        s.i(feedRecyclerView, "feedRecyclerView");
        s.i(sensorsContext, "sensorsContext");
        s.i(modelList, "modelList");
        this.f14295a = lifecycle;
        this.f14296b = context;
        this.f14297c = feedRecyclerView;
        this.f14298d = z10;
        this.f14299e = sensorsContext;
        this.f14300f = map;
        this.f14301g = str;
        this.f14302h = modelList;
    }

    public final void h(@NotNull final FeedModel model) {
        s.i(model, "model");
        x2.a N = NetworkClient.f11868a.N();
        String userId = model.getUser().userId();
        FollowPrefer l10 = l();
        Observable o10 = a.C0836a.o(N, userId, null, null, l10 != null ? l10.getValue() : null, 0, model.getPostStatisticsSource(), null, null, 214, null);
        Object obj = this.f14296b;
        com.cupidapp.live.base.network.g gVar = obj instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) obj : null;
        Disposable disposed = o10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$alohaClick$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2571invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2571invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                FeedClickEventHelper.this.j(false, model, swipeCardUserLikeResult);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void i(FeedModel feedModel) {
        if (feedModel.getUser().getCanSendInboxMessage()) {
            q(feedModel);
        } else {
            s(feedModel);
        }
    }

    public final void j(boolean z10, FeedModel feedModel, SwipeCardUserLikeResult swipeCardUserLikeResult) {
        feedModel.getUser().setAloha(true);
        feedModel.getUser().setSuperLikedByMe(swipeCardUserLikeResult.getUser().getSuperLikedByMe());
        feedModel.getUser().setSuperLikedByMeCombos(swipeCardUserLikeResult.getUser().getSuperLikedByMeCombos());
        feedModel.getUser().setCanSendInboxMessage(swipeCardUserLikeResult.getUser().getCanSendInboxMessage());
        EventBus.c().o(new UserProfileDataChangeEvent(feedModel.getUser(), false));
        if (!z10) {
            com.cupidapp.live.base.view.h.f12779a.c(this.f14296b, R$string.have_follow);
        }
        GroupSocialLog.f18708a.B(true, SensorScene.Feed.getValue(), feedModel.getUser().userId(), (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : swipeCardUserLikeResult.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : z10, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : feedModel.getStrategyId(), (r52 & 8388608) != 0 ? null : null);
    }

    @NotNull
    public final Map<Integer, Function1<Object, p>> k() {
        return i0.h(kotlin.f.a(Integer.valueOf(R$id.userPhotoAHImageView), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedModel feedModel = (FeedModel) obj;
                    FeedClickEventHelper.this.t(feedModel);
                    GroupSocialLog.f18708a.u(SensorScene.Feed.getValue(), feedModel.getUser().userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feedUserNameTextView), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedClickEventHelper.this.t((FeedModel) obj);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feedAlohaButton), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedModel feedModel = (FeedModel) obj;
                    FeedClickEventHelper.this.o(feedModel, UserActionType.Praise);
                    FeedClickEventHelper.this.h(feedModel);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.hashtag_base_rl), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedClickEventHelper.this.n((FeedModel) obj);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.hashTagNameTextView), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedClickEventHelper.this.n((FeedModel) obj);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.customTagNameLayout), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                CustomTag customTag;
                String url;
                Context context;
                if (!(obj instanceof FeedModel) || (customTag = ((FeedModel) obj).getCustomTag()) == null || (url = customTag.getUrl()) == null) {
                    return;
                }
                FeedClickEventHelper feedClickEventHelper = FeedClickEventHelper.this;
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                context = feedClickEventHelper.f14296b;
                aVar.a(context, url, null);
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feedSponsorLayout), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                Context context;
                Context context2;
                if (obj instanceof FeedModel) {
                    FeedModel feedModel = (FeedModel) obj;
                    SponsorModel sponsorExtraInfo = feedModel.getSponsorExtraInfo();
                    SensorsLogFeed.f12208a.F(sponsorExtraInfo != null ? sponsorExtraInfo.getUrl() : null, feedModel.getPostId());
                    ADMonitorHelper aDMonitorHelper = ADMonitorHelper.f18414a;
                    context = FeedClickEventHelper.this.f14296b;
                    aDMonitorHelper.b(context, sponsorExtraInfo != null ? sponsorExtraInfo.getClickTrackUrlList() : null);
                    j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                    context2 = FeedClickEventHelper.this.f14296b;
                    aVar.a(context2, sponsorExtraInfo != null ? sponsorExtraInfo.getUrl() : null, new WebStyleViewModel(WebStyleEnum.CardStyle, false, null, 6, null));
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feedPraiseButton), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                List[] listArr;
                List list;
                if (obj instanceof FeedModel) {
                    listArr = FeedClickEventHelper.this.f14302h;
                    int i10 = 0;
                    int length = listArr.length;
                    while (true) {
                        if (i10 >= length) {
                            list = null;
                            break;
                        }
                        list = listArr[i10];
                        if (list.contains(obj)) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (list != null) {
                        FeedClickEventHelper.this.p((FeedModel) obj);
                    }
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.privateChatButton), new Function1<Object, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$getClickListenerMap$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedClickEventHelper.this.i((FeedModel) obj);
                }
            }
        }));
    }

    public final FollowPrefer l() {
        int i10 = a.f14303a[this.f14299e.getPosition().ordinal()];
        if (i10 == 1) {
            return FollowPrefer.Feed;
        }
        if (i10 != 2) {
            return null;
        }
        return FollowPrefer.FeedDetail;
    }

    public final int m(@NotNull FeedModel value) {
        s.i(value, "value");
        int length = this.f14302h.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = -1;
            if (i10 >= length) {
                return -1;
            }
            List<Object> list = this.f14302h[i10];
            Iterator<Object> iterator2 = list.iterator2();
            int i13 = 0;
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                if (s.d(iterator2.next(), value)) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
            if (i12 >= 0) {
                return i12 + i11;
            }
            i11 += list.size();
            i10++;
        }
    }

    public final void n(FeedModel feedModel) {
        HashTag hashtag = feedModel.getHashtag();
        if (hashtag != null) {
            SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
            SensorScene scene = this.f14299e.getScene();
            String postId = feedModel.getPostId();
            HashTag hashtag2 = feedModel.getHashtag();
            sensorsLogFeed.y(scene, postId, hashtag2 != null ? hashtag2.getItemId() : null);
            String jumpUrl = hashtag.getJumpUrl();
            if (jumpUrl == null || jumpUrl.length() == 0) {
                if (hashtag.getNew()) {
                    Context context = this.f14296b;
                    if (context != null) {
                        HashTagMainActivity.A.a(context, hashtag.getItemId(), hashtag.getName(), this.f14299e);
                        return;
                    }
                    return;
                }
                HashTagFeedListActivity.f14075z.a(this.f14296b, hashtag.getItemId(), new FeedSensorContext(SensorPosition.Hashtag, this.f14299e.getPosition(), this.f14299e.getSource(), SensorScene.Hashtag));
                return;
            }
            j.a.b(com.cupidapp.live.base.router.j.f12156c, this.f14296b, hashtag.getJumpUrl(), null, 4, null);
        }
    }

    public final void o(FeedModel feedModel, UserActionType userActionType) {
        SensorPosition position = this.f14299e.getPosition();
        if (!TextUtils.isEmpty(feedModel.getStrategyId())) {
            position = SensorPosition.RecommendFeed;
        }
        SensorPosition sensorPosition = position;
        h hVar = h.f14329a;
        String postId = feedModel.getPostId();
        Integer tagId = feedModel.getTagId();
        SensorPosition source = this.f14299e.getSource();
        String str = this.f14301g;
        hVar.e(postId, tagId, userActionType, sensorPosition, source, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : str == null ? feedModel.getPostStatisticsCallback() : str);
    }

    public final boolean p(@NotNull FeedModel model) {
        s.i(model, "model");
        o(model, model.getLiked() ? UserActionType.CancelPraise : UserActionType.Praise);
        int m10 = m(model);
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f14297c.findViewHolderForLayoutPosition(m10);
        BaseFeedViewHolder baseFeedViewHolder = findViewHolderForLayoutPosition instanceof BaseFeedViewHolder ? (BaseFeedViewHolder) findViewHolderForLayoutPosition : null;
        if (baseFeedViewHolder != null) {
            BaseFeedViewHolder.T(baseFeedViewHolder, model, true, 0.0f, 0.0f, 12, null);
        }
        FeedPraiseGuideModel A = p1.g.f52734a.A();
        if (A != null) {
            A.praiseButtonWasClicked(m10);
        }
        if (baseFeedViewHolder != null && model.getLiked()) {
            if (model.getUser().getFocus()) {
                r(FeedSort.Focus);
            } else if (model.getUser().getCloseFriend()) {
                r(FeedSort.CloseFriend);
            }
        }
        return baseFeedViewHolder != null;
    }

    public final void q(FeedModel feedModel) {
        ChatDetailActivity.f13276r.a(this.f14296b, new ChatBundleData(feedModel.getUser(), feedModel.getUser().userId(), this.f14299e, feedModel, false, false, true, false, false, ad.f32206s, null));
    }

    public final void r(@NotNull final FeedSort userFeedType) {
        s.i(userFeedType, "userFeedType");
        Context context = this.f14296b;
        if (context == null || r0.f12373a.a(context)) {
            return;
        }
        Observable<Result<PushAlertShowModel>> f10 = NetworkClient.f11868a.F().f(PushAlertScene.FeedScene.getValue());
        Object obj = this.f14296b;
        com.cupidapp.live.base.network.g gVar = obj instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) obj : null;
        Disposable disposed = f10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<PushAlertShowModel, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$showPushOpenAlertDialog$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PushAlertShowModel pushAlertShowModel) {
                m2572invoke(pushAlertShowModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2572invoke(PushAlertShowModel pushAlertShowModel) {
                Context context2;
                String string;
                Context context3;
                Context context4;
                PopupName popupName;
                Context context5;
                FeedSensorContext feedSensorContext;
                Context context6;
                if (pushAlertShowModel.getShow()) {
                    FeedSort feedSort = FeedSort.this;
                    FeedSort feedSort2 = FeedSort.Focus;
                    if (feedSort == feedSort2) {
                        context6 = this.f14296b;
                        string = context6.getString(R$string.focus);
                    } else {
                        context2 = this.f14296b;
                        string = context2.getString(R$string.close_friend);
                    }
                    s.h(string, "if (userFeedType == Feed…nd)\n                    }");
                    y yVar = y.f51038a;
                    context3 = this.f14296b;
                    String string2 = context3.getString(R$string.not_miss_feed);
                    s.h(string2, "context.getString(R.string.not_miss_feed)");
                    String format = String.format(string2, Arrays.copyOf(new Object[]{string}, 1));
                    s.h(format, "format(format, *args)");
                    context4 = this.f14296b;
                    String string3 = context4.getString(R$string.feed_push_open_tip);
                    s.h(string3, "context.getString(R.string.feed_push_open_tip)");
                    String format2 = String.format(string3, Arrays.copyOf(new Object[]{string}, 1));
                    s.h(format2, "format(format, *args)");
                    if (FeedSort.this == feedSort2) {
                        popupName = PopupName.SPECIAL_ATTENTION_PUSH_GUIDE;
                    } else {
                        popupName = PopupName.CLOSE_FRIENDS_PUSH_GUIDE;
                    }
                    PopupName popupName2 = popupName;
                    UserAlertDialogHelper userAlertDialogHelper = UserAlertDialogHelper.f17874a;
                    context5 = this.f14296b;
                    feedSensorContext = this.f14299e;
                    userAlertDialogHelper.b(context5, format, format2, popupName2, feedSensorContext.getPosition());
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void s(final FeedModel feedModel) {
        Context context = this.f14296b;
        if (context == null) {
            return;
        }
        SuperLikeDialogLayout.Companion companion = SuperLikeDialogLayout.f18632h;
        Lifecycle lifecycle = this.f14295a;
        String userId = feedModel.getUser().userId();
        FollowPrefer l10 = l();
        companion.b(context, lifecycle, userId, null, l10 != null ? l10.getValue() : null, VipPurchaseEntranceType.SuperLikeFeed, (r27 & 64) != 0 ? null : feedModel.getPostStatisticsSource(), this.f14299e.getPosition(), (r27 & 256) != 0 ? 1 : 0, new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.feed.helper.FeedClickEventHelper$superLikeUser$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                invoke2(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SwipeCardUserLikeResult it) {
                s.i(it, "it");
                FeedClickEventHelper.this.j(true, feedModel, it);
            }
        }, (r27 & 1024) != 0 ? null : null);
    }

    public final void t(@NotNull FeedModel model) {
        String value;
        s.i(model, "model");
        int i10 = a.f14303a[this.f14299e.getPosition().ordinal()];
        if (i10 == 1) {
            value = ViewProfilePrefer.FeedToProfile.getValue();
        } else if (i10 != 2) {
            value = ViewProfilePrefer.FeedToProfile.getValue();
        } else {
            value = ViewProfilePrefer.FeedDetailToProfile.getValue();
        }
        UserProfileActivity.G.a(this.f14296b, model.getUser(), new ProfileSensorContext(value, model.getPostId(), model.getUser().getMe(), this.f14299e.getPosition(), this.f14299e.getSource(), this.f14299e.getScene()), (r21 & 8) != 0 ? false : this.f14298d, (r21 & 16) != 0 ? null : this.f14300f, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : model.getPostStatisticsSource(), (r21 & 128) != 0 ? false : false);
    }

    public /* synthetic */ FeedClickEventHelper(Lifecycle lifecycle, Context context, RecyclerView recyclerView, boolean z10, FeedSensorContext feedSensorContext, Map map, String str, List[] listArr, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycle, context, recyclerView, (i10 & 8) != 0 ? true : z10, feedSensorContext, (i10 & 32) != 0 ? null : map, (i10 & 64) != 0 ? null : str, listArr);
    }
}
