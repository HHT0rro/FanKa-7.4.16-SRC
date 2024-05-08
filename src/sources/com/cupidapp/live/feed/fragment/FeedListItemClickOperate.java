package com.cupidapp.live.feed.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.abtest.ABTestGroup;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.model.ABTestKey;
import com.cupidapp.live.base.network.model.ABTestListResult;
import com.cupidapp.live.base.network.model.ABTestModel;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.sensorslog.ShareBtnPos;
import com.cupidapp.live.base.share.fragment.FeedSpreadMenuBottomFragment;
import com.cupidapp.live.base.share.fragment.FeedSpreadMenuModel;
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.share.model.SpreadMenuType;
import com.cupidapp.live.base.share.model.State;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.SnackbarModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.feed.adapter.TrendFeedListAdapter;
import com.cupidapp.live.feed.event.ChangeFeedTabEvent;
import com.cupidapp.live.feed.helper.FeedClickEventHelper;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder;
import com.cupidapp.live.feed.holder.TrendFeedViewHolder;
import com.cupidapp.live.feed.layout.FeedTopBottomDialog;
import com.cupidapp.live.feed.layout.FeedUserInfoLayout;
import com.cupidapp.live.feed.model.FeedAlohaGuideModel;
import com.cupidapp.live.feed.model.FeedLikeResult;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.feed.model.PostBoostModel;
import com.cupidapp.live.feed.model.TopCloseFriendEntranceModel;
import com.cupidapp.live.feed.model.TopFocusEntranceModel;
import com.cupidapp.live.hashtag.list.HashTagListActivity;
import com.cupidapp.live.hashtag.list.HashTagListType;
import com.cupidapp.live.hashtag.model.HashTagRecommend;
import com.cupidapp.live.profile.activity.CloseFriendManagerActivity;
import com.cupidapp.live.profile.activity.FocusUserManageActivity;
import com.cupidapp.live.profile.activity.PrivateFeedActivity;
import com.cupidapp.live.profile.model.FocusResultModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.view.UserAlertDialogHelper;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: FeedListItemClickOperate.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedListItemClickOperate implements RecommendFeedEnterListViewHolder.b {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final FragmentActivity f14239b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final TrendFeedListAdapter f14240c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final Context f14241d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final FeedSensorContext f14242e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14243f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final FeedClickEventHelper f14244g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final i f14245h;

    /* compiled from: FeedListItemClickOperate.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements com.cupidapp.live.base.share.view.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FeedModel f14247b;

        public a(FeedModel feedModel) {
            this.f14247b = feedModel;
        }

        @Override // com.cupidapp.live.base.share.view.b
        public void a(@NotNull ShareItemHandledResult result) {
            kotlin.jvm.internal.s.i(result, "result");
            ShareBaseType type = result.getType();
            if ((type == SpreadMenuType.IGNORE_HIM || type == SpreadMenuType.NO_INTEREST) || type == SpreadMenuType.HATE_BMI) {
                com.cupidapp.live.base.view.h.f12779a.l(FeedListItemClickOperate.this.k(), R$string.reduce_recommend_to_you);
                FeedListItemClickOperate.this.D(this.f14247b);
            }
        }

        @Override // com.cupidapp.live.base.share.view.b
        public void b(@NotNull ShareBaseType type) {
            kotlin.jvm.internal.s.i(type, "type");
            if (type == SpreadMenuType.REPORT) {
                j.a.b(com.cupidapp.live.base.router.j.f12156c, FeedListItemClickOperate.this.k(), n0.f12353a.b(this.f14247b.getReportData(), FeedListItemClickOperate.this.n().getPosition(), this.f14247b.getUser().userId()), null, 4, null);
            }
        }
    }

    public FeedListItemClickOperate(@Nullable FragmentActivity fragmentActivity, @NotNull TrendFeedListAdapter feedAdapter, @Nullable Context context, @NotNull FeedSensorContext sensorContext, boolean z10, @NotNull FeedClickEventHelper feedClickEventHelper, @NotNull i listener) {
        kotlin.jvm.internal.s.i(feedAdapter, "feedAdapter");
        kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
        kotlin.jvm.internal.s.i(feedClickEventHelper, "feedClickEventHelper");
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f14239b = fragmentActivity;
        this.f14240c = feedAdapter;
        this.f14241d = context;
        this.f14242e = sensorContext;
        this.f14243f = z10;
        this.f14244g = feedClickEventHelper;
        this.f14245h = listener;
        feedAdapter.l().j(i(feedClickEventHelper));
    }

    public static /* synthetic */ void v(FeedListItemClickOperate feedListItemClickOperate, FeedModel feedModel, UserActionType userActionType, String str, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        feedListItemClickOperate.u(feedModel, userActionType, str);
    }

    public final void A(@NotNull User user) {
        View view;
        FeedUserInfoLayout feedUserInfoLayout;
        kotlin.jvm.internal.s.i(user, "user");
        int i10 = 0;
        for (Object obj : this.f14240c.j()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (obj instanceof FeedModel) {
                FeedModel feedModel = (FeedModel) obj;
                if (kotlin.jvm.internal.s.d(feedModel.getUser().userId(), user.userId())) {
                    feedModel.getUser().setSkipReceiveFeed(user.getSkipReceiveFeed());
                    feedModel.getUser().setAloha(user.getAloha());
                    feedModel.getUser().setSuperLikedByMe(user.getSuperLikedByMe());
                    feedModel.getUser().setSuperLikedByMeCombos(user.getSuperLikedByMeCombos());
                    feedModel.getUser().setCanSendInboxMessage(user.getCanSendInboxMessage());
                    feedModel.getUser().setFocus(user.getFocus());
                    feedModel.getUser().setCloseFriend(user.getCloseFriend());
                    TrendFeedViewHolder V = this.f14245h.V(i10);
                    if (V != null && (view = V.itemView) != null && (feedUserInfoLayout = (FeedUserInfoLayout) view.findViewById(R$id.feedUserInfoLayout)) != null) {
                        feedUserInfoLayout.setFeedUserInfo(feedModel);
                    }
                    this.f14240c.notifyItemChanged(i10);
                }
            }
            i10 = i11;
        }
    }

    public final void B(FeedModel feedModel, boolean z10) {
        Object obj;
        Iterator<Object> iterator2 = this.f14240c.j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if ((obj instanceof FeedModel) && kotlin.jvm.internal.s.d(((FeedModel) obj).getPostId(), feedModel.getPostId())) {
                    break;
                }
            }
        }
        FeedModel feedModel2 = obj instanceof FeedModel ? (FeedModel) obj : null;
        if (feedModel2 != null) {
            feedModel2.setDynamicTop(Boolean.valueOf(z10));
            int indexOf = this.f14240c.j().indexOf(feedModel2);
            if (indexOf >= 0) {
                this.f14240c.notifyItemChanged(indexOf);
            }
        }
    }

    public final void C(String str) {
        if (this.f14242e.getPosition() == SensorPosition.Feed) {
            List<Object> j10 = this.f14240c.j();
            ArrayList arrayList = new ArrayList();
            for (Object obj : j10) {
                if (obj instanceof FeedModel) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (kotlin.jvm.internal.s.d(((FeedModel) obj2).getUser().userId(), str)) {
                    arrayList2.add(obj2);
                }
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            this.f14240c.j().removeAll(arrayList2);
            this.f14240c.notifyDataSetChanged();
            return;
        }
        com.cupidapp.live.base.view.h.f12779a.c(this.f14241d, R$string.has_dont_look_him);
    }

    public final void D(FeedModel feedModel) {
        Iterator<Object> iterator2 = this.f14240c.j().iterator2();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            if ((next instanceof FeedModel) && kotlin.jvm.internal.s.d(((FeedModel) next).getPostId(), feedModel.getPostId())) {
                iterator2.remove();
                this.f14240c.notifyDataSetChanged();
                this.f14245h.k();
                this.f14245h.n0();
                return;
            }
        }
    }

    public final void E(final FeedModel feedModel, ShareBtnPos shareBtnPos) {
        FragmentManager supportFragmentManager;
        FollowPrefer followPrefer;
        ShareBuilder d10 = com.cupidapp.live.base.share.helper.d.f12255a.d(this.f14239b, feedModel, this.f14242e.getPosition(), shareBtnPos);
        List<ShareOperateType> o10 = o(feedModel);
        FragmentActivity fragmentActivity = this.f14239b;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
            return;
        }
        if (this.f14242e.getPosition() == SensorPosition.Feed) {
            followPrefer = FollowPrefer.Feed;
        } else {
            followPrefer = FollowPrefer.PostStream;
        }
        FollowPrefer followPrefer2 = followPrefer;
        ShareBottomFragment.f12224k.a().v1(supportFragmentManager, new ShareModel(feedModel.getUser().userId(), feedModel.getPostId(), d10, followPrefer2, o10, this.f14242e.getPosition(), Boolean.valueOf(feedModel.getUser().getSuperLikedByMe()), null, null, feedModel.getPostStatisticsSource(), null, 1408, null), new com.cupidapp.live.base.share.view.b() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$shareFeed$1$1
            @Override // com.cupidapp.live.base.share.view.b
            public void a(@NotNull ShareItemHandledResult result) {
                String string;
                String str;
                kotlin.jvm.internal.s.i(result, "result");
                if (result.getState() == State.SUCCESS) {
                    ShareBaseType type = result.getType();
                    if (type == ShareOperateType.DISLIKE_U) {
                        feedModel.getUser().setFocus(false);
                        feedModel.getUser().setAloha(false);
                        feedModel.getUser().setMatch(false);
                        feedModel.getUser().setCanSendInboxMessage(false);
                        feedModel.getUser().setSuperLikedByMe(false);
                        feedModel.getUser().setSuperLikedByMeCombos(0);
                        feedModel.getUser().setCloseFriend(false);
                        FeedListItemClickOperate.this.A(feedModel.getUser());
                        return;
                    }
                    if (type == ShareOperateType.DELETE) {
                        FeedListItemClickOperate.this.D(feedModel);
                        return;
                    }
                    if (type == ShareOperateType.DONT_LOOK_HIM) {
                        feedModel.getUser().setSkipReceiveFeed(true);
                        FeedListItemClickOperate.this.C(feedModel.getUser().userId());
                        return;
                    }
                    if (type == ShareOperateType.LOOK_HIM) {
                        feedModel.getUser().setSkipReceiveFeed(false);
                        com.cupidapp.live.base.view.h.f12779a.c(FeedListItemClickOperate.this.k(), R$string.has_cancel_dont_look);
                        return;
                    }
                    if (type == ShareOperateType.PRIVATE) {
                        FeedListItemClickOperate.this.D(feedModel);
                        com.cupidapp.live.base.view.g gVar = com.cupidapp.live.base.view.g.f12778a;
                        View findViewById = FeedListItemClickOperate.this.j().findViewById(16908290);
                        Context k10 = FeedListItemClickOperate.this.k();
                        if (k10 == null || (str = k10.getString(R$string.private_and_move)) == null) {
                            str = "";
                        }
                        String str2 = str;
                        Context k11 = FeedListItemClickOperate.this.k();
                        string = k11 != null ? k11.getString(R$string.see_right_now) : null;
                        Integer valueOf = Integer.valueOf(R$mipmap.icon_snack_lock);
                        final FeedListItemClickOperate feedListItemClickOperate = FeedListItemClickOperate.this;
                        gVar.d(findViewById, new SnackbarModel(str2, 0.0f, string, 0, null, 0.0f, null, null, valueOf, 0, 0, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$shareFeed$1$1$handled$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                                invoke2();
                                return kotlin.p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                FeedListItemClickOperate.this.s();
                            }
                        }, 1786, null));
                        return;
                    }
                    if (type == ShareOperateType.UN_PRIVATE) {
                        FeedListItemClickOperate.this.D(feedModel);
                        com.cupidapp.live.base.view.h.f12779a.l(FeedListItemClickOperate.this.k(), R$string.move_out);
                        return;
                    }
                    if (type == ShareOperateType.FEED_TOP) {
                        if (result.getData() instanceof String) {
                            Context k12 = FeedListItemClickOperate.this.k();
                            string = k12 != null ? k12.getString(R$string.feed_top_suc) : null;
                            com.cupidapp.live.base.view.h.f12779a.d(FeedListItemClickOperate.this.k(), z0.t.k(string + "\n\n" + result.getData(), com.cupidapp.live.base.utils.h.a(-1, 0.7f), new String[]{(String) result.getData()}, false, 4, null));
                        }
                        FeedListItemClickOperate.this.B(feedModel, true);
                        return;
                    }
                    if (type == ShareOperateType.FEED_CANCEL_TOP) {
                        if (result.getData() instanceof String) {
                            Context k13 = FeedListItemClickOperate.this.k();
                            com.cupidapp.live.base.view.h.f12779a.d(FeedListItemClickOperate.this.k(), k13 != null ? k13.getString(R$string.cancel_feed_top_suc) : null);
                        }
                        FeedListItemClickOperate.this.B(feedModel, false);
                        return;
                    }
                    if (type == ShareOperateType.FOCUS) {
                        if (result.getData() instanceof FocusResultModel) {
                            feedModel.getUser().setAloha(((FocusResultModel) result.getData()).getAloha());
                            feedModel.getUser().setMatch(((FocusResultModel) result.getData()).getMatch());
                            feedModel.getUser().setFocus(true);
                            FeedListItemClickOperate.this.A(feedModel.getUser());
                            GroupSocialLog.f18708a.Z(feedModel.getUser().userId(), FeedListItemClickOperate.this.n().getPosition(), FeedListItemClickOperate.this.n().getSource(), true);
                            return;
                        }
                        return;
                    }
                    if (type == ShareOperateType.UN_FOCUS) {
                        if (result.getData() instanceof FocusResultModel) {
                            feedModel.getUser().setAloha(((FocusResultModel) result.getData()).getAloha());
                            feedModel.getUser().setMatch(((FocusResultModel) result.getData()).getMatch());
                            feedModel.getUser().setFocus(false);
                            FeedListItemClickOperate.this.A(feedModel.getUser());
                            GroupSocialLog.f18708a.Z(feedModel.getUser().userId(), FeedListItemClickOperate.this.n().getPosition(), FeedListItemClickOperate.this.n().getSource(), false);
                            return;
                        }
                        return;
                    }
                    if (type == ShareOperateType.CLOSE_FRIEND) {
                        feedModel.getUser().setCloseFriend(true);
                        FeedListItemClickOperate.this.A(feedModel.getUser());
                        com.cupidapp.live.base.view.h.f12779a.l(FeedListItemClickOperate.this.k(), R$string.close_friend_suc);
                        GroupSocialLog.f18708a.Y(feedModel.getUser().userId(), FeedListItemClickOperate.this.n().getPosition(), FeedListItemClickOperate.this.n().getSource(), true);
                        return;
                    }
                    if (type == ShareOperateType.UN_CLOSE_FRIEND) {
                        feedModel.getUser().setCloseFriend(false);
                        FeedListItemClickOperate.this.A(feedModel.getUser());
                        com.cupidapp.live.base.view.h.f12779a.l(FeedListItemClickOperate.this.k(), R$string.un_close_friend_suc);
                        GroupSocialLog.f18708a.Y(feedModel.getUser().userId(), FeedListItemClickOperate.this.n().getPosition(), FeedListItemClickOperate.this.n().getSource(), false);
                        return;
                    }
                    return;
                }
                if (result.getState() == State.FAILURE) {
                    ShareBaseType type2 = result.getType();
                    if (type2 == ShareOperateType.FOCUS) {
                        if (result.getData() instanceof String) {
                            UserAlertDialogHelper userAlertDialogHelper = UserAlertDialogHelper.f17874a;
                            Context k14 = FeedListItemClickOperate.this.k();
                            SensorPosition position = FeedListItemClickOperate.this.n().getPosition();
                            String str3 = (String) result.getData();
                            PopupName popupName = PopupName.SPECIAL_ATTENTION_LIMIT;
                            final FeedListItemClickOperate feedListItemClickOperate2 = FeedListItemClickOperate.this;
                            userAlertDialogHelper.a(k14, position, str3, popupName, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$shareFeed$1$1$handled$2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                                    invoke2();
                                    return kotlin.p.f51048a;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    FeedListItemClickOperate.this.r();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (type2 == ShareOperateType.CLOSE_FRIEND) {
                        if (result.getData() instanceof String) {
                            UserAlertDialogHelper userAlertDialogHelper2 = UserAlertDialogHelper.f17874a;
                            Context k15 = FeedListItemClickOperate.this.k();
                            SensorPosition position2 = FeedListItemClickOperate.this.n().getPosition();
                            String str4 = (String) result.getData();
                            PopupName popupName2 = PopupName.CLOSE_FRIENDS_LIMIT;
                            final FeedListItemClickOperate feedListItemClickOperate3 = FeedListItemClickOperate.this;
                            userAlertDialogHelper2.a(k15, position2, str4, popupName2, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$shareFeed$1$1$handled$3
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                                    invoke2();
                                    return kotlin.p.f51048a;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    FeedListItemClickOperate.this.p();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (type2 == ShareOperateType.FEED_TOP && (result.getData() instanceof String)) {
                        Context k16 = FeedListItemClickOperate.this.k();
                        string = k16 != null ? k16.getString(R$string.feed_top_fail) : null;
                        com.cupidapp.live.base.view.h.f12779a.s(FeedListItemClickOperate.this.k(), z0.t.k(string + "\n\n" + result.getData(), com.cupidapp.live.base.utils.h.a(-1, 0.7f), new String[]{(String) result.getData()}, false, 4, null));
                    }
                }
            }

            @Override // com.cupidapp.live.base.share.view.b
            public void b(@NotNull ShareBaseType type) {
                kotlin.jvm.internal.s.i(type, "type");
                if (type instanceof SharePlatform) {
                    FeedListItemClickOperate.this.h(feedModel);
                    return;
                }
                if (type == ShareOperateType.DISINTEREST) {
                    if (FeedListItemClickOperate.this.l().j().contains(feedModel)) {
                        FeedListItemClickOperate.this.l().j().remove(feedModel);
                    }
                    FeedListItemClickOperate.this.l().notifyDataSetChanged();
                    FeedListItemClickOperate.this.m().k();
                    return;
                }
                if (type == ShareOperateType.REPORT) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, FeedListItemClickOperate.this.k(), n0.f12353a.b(feedModel.getReportData(), FeedListItemClickOperate.this.n().getPosition(), feedModel.getUser().userId()), null, 4, null);
                    return;
                }
                if (type == ShareOperateType.DISLIKE_U) {
                    SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                    SensorScene scene = FeedListItemClickOperate.this.n().getScene();
                    sensorsLogFeed.b(scene != null ? scene.getValue() : null, feedModel.getUser().userId(), FeedListItemClickOperate.this.n().getPosition(), feedModel.getUser().getSuperLikedByMe());
                    return;
                }
                if (type == ShareOperateType.DONT_LOOK_HIM) {
                    GroupSocialLog.f18708a.n(feedModel.getUser().userId(), FeedListItemClickOperate.this.n().getPosition(), FeedListItemClickOperate.this.n().getScene(), feedModel.getUser().getMatch(), feedModel.getUser().getAloha());
                    return;
                }
                if (type == ShareOperateType.LOOK_HIM) {
                    GroupSocialLog.f18708a.N(feedModel.getUser().userId(), FeedListItemClickOperate.this.n().getPosition(), FeedListItemClickOperate.this.n().getScene(), feedModel.getUser().getMatch(), feedModel.getUser().getAloha());
                    return;
                }
                if (type == ShareOperateType.PRIVATE) {
                    SensorsLogFeed.f12208a.x(feedModel.getPostId(), FeedListItemClickOperate.this.n().getPosition());
                    return;
                }
                if (type == ShareOperateType.UN_PRIVATE) {
                    SensorsLogFeed.f12208a.v(feedModel.getPostId(), FeedListItemClickOperate.this.n().getPosition());
                    return;
                }
                if (type == ShareOperateType.REDUCE_RECOMMEND) {
                    SensorsLogKeyButtonClick.FeedList.REDUCE_RECOMMENDATION_TO_ME.click();
                    return;
                }
                if (type == ShareOperateType.FEED_SPREAD) {
                    SensorsLogKeyButtonClick.FeedList.POST_SPREAD.click();
                } else if (type == ShareOperateType.FEED_TOP) {
                    SensorsLogFeed.f12208a.k(feedModel.getPostId(), FeedListItemClickOperate.this.n().getPosition());
                } else if (type == ShareOperateType.FEED_CANCEL_TOP) {
                    SensorsLogFeed.f12208a.a(feedModel.getPostId(), FeedListItemClickOperate.this.n().getPosition());
                }
            }
        });
    }

    public final void F(final FeedModel feedModel) {
        Observable<Result<ABTestListResult>> g3 = NetworkClient.f11868a.i().g(ABTestKey.FEED_SPREAD_MENU.getValue());
        Object obj = this.f14241d;
        com.cupidapp.live.base.network.g gVar = obj instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) obj : null;
        Disposable disposed = g3.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ABTestListResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$showSpreadMenu$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ABTestListResult aBTestListResult) {
                m2565invoke(aBTestListResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2565invoke(ABTestListResult aBTestListResult) {
                ABTestModel aBTestModel;
                ABTestModel aBTestModel2;
                List<ABTestModel> testResults = aBTestListResult.getTestResults();
                if (testResults != null) {
                    Iterator<ABTestModel> iterator2 = testResults.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            aBTestModel2 = null;
                            break;
                        } else {
                            aBTestModel2 = iterator2.next();
                            if (kotlin.jvm.internal.s.d(aBTestModel2.getName(), ABTestKey.FEED_SPREAD_MENU.getValue())) {
                                break;
                            }
                        }
                    }
                    aBTestModel = aBTestModel2;
                } else {
                    aBTestModel = null;
                }
                FeedListItemClickOperate.this.G(!kotlin.jvm.internal.s.d(aBTestModel != null ? aBTestModel.getResult() : null, ABTestGroup.A.getValue()), feedModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void G(boolean z10, FeedModel feedModel) {
        FragmentManager supportFragmentManager;
        FragmentActivity fragmentActivity = this.f14239b;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(SpreadMenuType.FEED_SPREAD);
        if (z10) {
            arrayList.add(SpreadMenuType.IGNORE_HIM);
        }
        arrayList.add(SpreadMenuType.NO_INTEREST);
        if (z10) {
            arrayList.add(SpreadMenuType.HATE_BMI);
            if (feedModel.haveAdTip()) {
                arrayList.add(SpreadMenuType.NO_FIND_HIM);
            }
        }
        arrayList.add(SpreadMenuType.REPORT);
        FeedSpreadMenuBottomFragment.f12218h.a().b1(supportFragmentManager, new FeedSpreadMenuModel(feedModel.getUser().userId(), feedModel.getPostId(), arrayList), new a(feedModel));
    }

    @Override // com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.b
    public void H0(@NotNull FeedRecommendResult model, boolean z10, @NotNull FeedSensorContext sensorContext) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
        if (model.getPost() == null) {
            return;
        }
        if (z10) {
            u(model.getPost(), UserActionType.Praise, model.getCallback());
            SensorsLogFeed.f12208a.m(model.getPost().getUser().userId(), model.getPost().getPostId(), sensorContext.getPosition(), sensorContext.getScene(), SensorsLogFeed.LikeCommentType.Feed, model.getPost().getUser().getAloha(), model.getPost().getStrategyId(), p1.g.f52734a.x());
            z(model.getPost());
        } else {
            u(model.getPost(), UserActionType.CancelPraise, model.getCallback());
            x(model.getPost());
            SensorsLogFeed.f12208a.n(sensorContext.getScene(), sensorContext.getPosition(), model.getPost().getPostId(), model.getPost().getUser().userId(), model.getPost().getUser().getAloha(), model.getPost().getStrategyId(), p1.g.f52734a.x());
        }
    }

    public final void h(final FeedModel feedModel) {
        v(this, feedModel, UserActionType.Share, null, 4, null);
        Observable<Result<Object>> q10 = NetworkClient.f11868a.l().q(feedModel.getPostId());
        Object obj = this.f14241d;
        FeedListItemClickOperate$feedShare$2 feedListItemClickOperate$feedShare$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$feedShare$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = obj instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) obj : null;
        Disposable disposed = q10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$feedShare$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj2) {
                invoke2(obj2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
                com.cupidapp.live.base.utils.j.f12332a.a("feedDetail", "share count add");
                FeedModel.this.share();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(feedListItemClickOperate$feedShare$2, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final Map<Integer, Function1<Object, kotlin.p>> i(FeedClickEventHelper feedClickEventHelper) {
        Map<Integer, Function1<Object, kotlin.p>> k10 = feedClickEventHelper.k();
        k10.putAll(i0.h(kotlin.f.a(Integer.valueOf(R$id.sponsorButton), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                FeedListItemClickOperate.this.w(obj, ShareBtnPos.ShareTopBtn);
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feedShareButton), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                FeedListItemClickOperate.this.w(obj, ShareBtnPos.ShareTopBtn);
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feedSpreadBtn), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                FeedListItemClickOperate.this.w(obj, ShareBtnPos.ShareTopBtn);
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feedVideoPlayButton), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedListItemClickOperate.this.m().z((FeedModel) obj);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.commentButton), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    FeedListItemClickOperate.this.q((FeedModel) obj, SensorsLogFeed.BtnName.COMMENT_BTN, false, true, true);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.seeAllHashTagTxt), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof HashTagRecommend) {
                    SensorsLogKeyButtonClick.FeedList.SeaAll.click();
                    SensorsLogFeed.f12208a.K(SensorScene.Feed);
                    Context k11 = FeedListItemClickOperate.this.k();
                    if (k11 != null) {
                        HashTagListActivity.f14718r.a(k11, HashTagListType.DATA_VIEW_HASHTAG, FeedListItemClickOperate.this.n());
                    }
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.focus_manage_root_rl), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof TopFocusEntranceModel) {
                    FeedListItemClickOperate.this.r();
                    GroupOthersLog.f18702a.o0(GroupOthersLog.TipsType.SPECIAL_ATTENTION, p1.g.f52734a.x());
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.close_friend_manage_root_rl), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof TopCloseFriendEntranceModel) {
                    FeedListItemClickOperate.this.p();
                    GroupOthersLog.f18702a.o0(GroupOthersLog.TipsType.CLOSE_FRIENDS, p1.g.f52734a.x());
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.no_follow_btn), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedAlohaGuideModel) {
                    SensorsLogFeed.f12208a.i();
                    Context k11 = FeedListItemClickOperate.this.k();
                    if (k11 != null) {
                        j.a.b(com.cupidapp.live.base.router.j.f12156c, k11, ((FeedAlohaGuideModel) obj).getFeedModel().getJumpUrl(), null, 4, null);
                    }
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feed_boost_img), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedModel) {
                    j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                    Context k11 = FeedListItemClickOperate.this.k();
                    PostBoostModel postBoostInfo = ((FeedModel) obj).getPostBoostInfo();
                    j.a.b(aVar, k11, postBoostInfo != null ? postBoostInfo.getPostBoostWebUrl() : null, null, 4, null);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.feed_top_tag), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$generateClickMap$11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (!(obj instanceof FeedModel) || com.cupidapp.live.profile.logic.c.f17839a.a(((FeedModel) obj).getUser().userId())) {
                    return;
                }
                FeedTopBottomDialog.f14489f.a(FeedListItemClickOperate.this.k()).e(FeedListItemClickOperate.this.n().getPosition()).f();
            }
        })));
        return k10;
    }

    @Nullable
    public final FragmentActivity j() {
        return this.f14239b;
    }

    @Nullable
    public final Context k() {
        return this.f14241d;
    }

    @NotNull
    public final TrendFeedListAdapter l() {
        return this.f14240c;
    }

    @NotNull
    public final i m() {
        return this.f14245h;
    }

    @Override // com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.b
    public void m0(@NotNull FeedRecommendResult model, @NotNull FeedSensorContext sensorContext) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
        FeedModel post = model.getPost();
        if (post != null) {
            u(post, UserActionType.Click, model.getCallback());
            com.cupidapp.live.feed.helper.k.f14350a.a(post, false, sensorContext, false, false, null, this.f14241d, model.getCallback());
        }
    }

    @NotNull
    public final FeedSensorContext n() {
        return this.f14242e;
    }

    public final List<ShareOperateType> o(FeedModel feedModel) {
        ConstantsUrlModel urlModel;
        ArrayList arrayList = new ArrayList();
        p1.g gVar = p1.g.f52734a;
        ConstantsResult q10 = gVar.q();
        if ((q10 == null || (urlModel = q10.getUrlModel()) == null || !urlModel.showFeedSpread()) ? false : true) {
            arrayList.add(ShareOperateType.FEED_SPREAD);
        }
        String userId = feedModel.getUser().userId();
        User X = gVar.X();
        if (kotlin.jvm.internal.s.d(userId, X != null ? X.userId() : null)) {
            arrayList.add(feedModel.getShareOperateType());
            if (kotlin.jvm.internal.s.d(feedModel.getDynamicTop(), Boolean.TRUE)) {
                arrayList.add(ShareOperateType.FEED_CANCEL_TOP);
            } else if (!feedModel.getPrivateFeed() && !feedModel.getCloseFriendOnly() && this.f14243f) {
                arrayList.add(ShareOperateType.FEED_TOP);
            }
            arrayList.add(ShareOperateType.DELETE);
        } else {
            if (feedModel.getUser().getFocus()) {
                arrayList.add(ShareOperateType.UN_FOCUS);
            } else {
                arrayList.add(ShareOperateType.FOCUS);
            }
            if (feedModel.getUser().getCloseFriend()) {
                arrayList.add(ShareOperateType.UN_CLOSE_FRIEND);
            } else if (feedModel.getUser().getMatch()) {
                arrayList.add(ShareOperateType.CLOSE_FRIEND);
            }
            if (feedModel.getUser().getAloha() || feedModel.getUser().getMatch()) {
                arrayList.add(!feedModel.getUser().getSkipReceiveFeed() ? ShareOperateType.DONT_LOOK_HIM : ShareOperateType.LOOK_HIM);
            }
            if (feedModel.getUser().getAloha()) {
                arrayList.add(ShareOperateType.DISLIKE_U);
            }
            if (feedModel.haveSponsor()) {
                arrayList.add(ShareOperateType.DISINTEREST);
            }
            arrayList.add(ShareOperateType.REPORT);
        }
        return arrayList;
    }

    public final void p() {
        Context context = this.f14241d;
        if (context != null) {
            CloseFriendManagerActivity.f17591r.a(context, this.f14242e);
        }
    }

    public final void q(@NotNull FeedModel model, @Nullable SensorsLogFeed.BtnName btnName, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.s.i(model, "model");
        v(this, model, UserActionType.Click, null, 4, null);
        SensorsLogFeed.f12208a.q(btnName);
        com.cupidapp.live.feed.helper.k.f14350a.a(model, z10, this.f14242e, z12, z11, null, this.f14241d, model.getPostStatisticsCallback());
    }

    public final void r() {
        Context context = this.f14241d;
        if (context != null) {
            FocusUserManageActivity.f17618r.a(context, this.f14242e);
        }
    }

    public final void s() {
        PrivateFeedActivity.f17650v.a(this.f14241d, this.f14242e);
    }

    public final void t(@NotNull String userId) {
        kotlin.jvm.internal.s.i(userId, "userId");
        Observable z10 = a.C0836a.z(NetworkClient.f11868a.N(), userId, null, null, false, null, 30, null);
        Object obj = this.f14241d;
        com.cupidapp.live.base.network.g gVar = obj instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) obj : null;
        Disposable disposed = z10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$gotoUserProfile$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                m2563invoke(profileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2563invoke(ProfileResult profileResult) {
                com.cupidapp.live.feed.helper.k.f14350a.b(FeedListItemClickOperate.this.k(), profileResult.getUser(), (r16 & 4) != 0 ? null : null, FeedListItemClickOperate.this.n(), (r16 & 16) != 0 ? false : false, (r16 & 32) != 0 ? null : null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void u(FeedModel feedModel, UserActionType userActionType, String str) {
        SensorPosition position = this.f14242e.getPosition();
        if (!TextUtils.isEmpty(feedModel.getStrategyId())) {
            position = SensorPosition.RecommendFeed;
        }
        SensorPosition sensorPosition = position;
        com.cupidapp.live.feed.helper.h hVar = com.cupidapp.live.feed.helper.h.f14329a;
        String postId = feedModel.getPostId();
        Integer tagId = feedModel.getTagId();
        SensorPosition source = this.f14242e.getSource();
        if (str == null) {
            str = feedModel.getPostStatisticsCallback();
        }
        hVar.e(postId, tagId, userActionType, sensorPosition, source, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : str);
    }

    public final void w(Object obj, ShareBtnPos shareBtnPos) {
        if (obj instanceof FeedModel) {
            FeedModel feedModel = (FeedModel) obj;
            if (!feedModel.canShowPostSpread(this.f14242e.getPosition()) && !feedModel.canShowAdSpread(this.f14242e.getPosition())) {
                E(feedModel, shareBtnPos);
            } else {
                F(feedModel);
            }
        }
    }

    public final void x(final FeedModel feedModel) {
        Observable<Result<Object>> D = NetworkClient.f11868a.l().D(feedModel.getPostId());
        Object obj = this.f14241d;
        com.cupidapp.live.base.network.g gVar = obj instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) obj : null;
        Disposable disposed = D.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$recommendEnterCancelFeedLike$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj2) {
                invoke2(obj2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
                FeedModel.this.cancelPraise();
                this.l().z();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.b
    public void y() {
        EventBus.c().l(new ChangeFeedTabEvent("Recommend"));
    }

    public final void z(final FeedModel feedModel) {
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.YouBlacklistedTheOtherPerson.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$recommendEnterFeedLike$errorCodeInterceptor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, FeedListItemClickOperate.this.k(), false, 2, null).n(str), 0, null, null, 7, null), null, 1, null);
            }
        }));
        Observable<Result<FeedLikeResult>> A = NetworkClient.f11868a.l().A(feedModel.getPostId());
        Object obj = this.f14241d;
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$recommendEnterFeedLike$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, FeedListItemClickOperate.this.k(), h10, null, 8, null);
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = obj instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) obj : null;
        Disposable disposed = A.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedLikeResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedListItemClickOperate$recommendEnterFeedLike$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedLikeResult feedLikeResult) {
                m2564invoke(feedLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2564invoke(FeedLikeResult feedLikeResult) {
                FeedModel.this.praise();
                this.l().z();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }
}
