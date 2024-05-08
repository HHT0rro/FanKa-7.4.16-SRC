package com.cupidapp.live.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.abtest.ABTestGroup;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ABTestKey;
import com.cupidapp.live.base.network.model.ABTestListResult;
import com.cupidapp.live.base.network.model.ABTestModel;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.NestingRecyclerView;
import com.cupidapp.live.base.view.SnackbarModel;
import com.cupidapp.live.base.web.WebStyleEnum;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.feed.FeedSort;
import com.cupidapp.live.feed.FeedType;
import com.cupidapp.live.feed.activity.OpenRainbowRecommendEvent;
import com.cupidapp.live.feed.activity.PostLimitDetailListActivity;
import com.cupidapp.live.feed.activity.PostLimitEditActivity;
import com.cupidapp.live.feed.activity.RainbowRecommendActivity;
import com.cupidapp.live.feed.adapter.FeedRainbowRecommendItemModel;
import com.cupidapp.live.feed.adapter.TrendFeedListAdapter;
import com.cupidapp.live.feed.event.PostLimitUploadSucEvent;
import com.cupidapp.live.feed.event.SuperLikeBtnShowEvent;
import com.cupidapp.live.feed.event.SwipeRefreshIsEnabledEvent;
import com.cupidapp.live.feed.event.UserPostLimitReadChangeEvent;
import com.cupidapp.live.feed.holder.FeedRainbowRecommendModel;
import com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder;
import com.cupidapp.live.feed.holder.OpenPostEditEvent;
import com.cupidapp.live.feed.holder.OpenPostLimitEvent;
import com.cupidapp.live.feed.model.FeedAlohaGuideModel;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendListModel;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.feed.model.FeedResultModel;
import com.cupidapp.live.feed.model.FeedSettingResult;
import com.cupidapp.live.feed.model.FeedShowCaseViewModel;
import com.cupidapp.live.feed.model.PostLimitFriendsModel;
import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import com.cupidapp.live.feed.model.TopCloseFriendEntranceModel;
import com.cupidapp.live.feed.model.TopFocusEntranceModel;
import com.cupidapp.live.feed.model.UserWithPostLimitStatusModel;
import com.cupidapp.live.liveshow.model.FeedTopLiveModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.RecommendLiveAndFeedModel;
import com.cupidapp.live.match.event.UserDataChangeEvent;
import com.cupidapp.live.mediapicker.event.ChangeFeedSortEvent;
import com.cupidapp.live.mediapicker.event.FeedSortSwitchEvent;
import com.cupidapp.live.mediapicker.event.TabRedDotEvent;
import com.cupidapp.live.mediapicker.helper.PublishManager;
import com.cupidapp.live.mediapicker.model.PublishViewModel;
import com.cupidapp.live.profile.event.UserManageViewEvent;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.PostLimitReadStatus;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.startup.express.FKExpressAdManager;
import com.cupidapp.live.startup.helper.ADMonitorHelper;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.layout.VipDiscountPromptLayout;
import com.cupidapp.live.vip.model.DiscountShowPlace;
import com.cupidapp.live.vip.model.VipDiscountPromptModel;
import com.cupidapp.live.vip.model.VipPurchaseSuccessEvent;
import com.cupidapp.live.vip.model.VipType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import f2.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.collections.m0;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.y;

/* compiled from: TrendFeedListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TrendFeedListFragment extends BaseFeedListFragment implements SwipeRefreshLayout.OnRefreshListener, com.cupidapp.live.mediapicker.helper.d {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final FeedSensorContext f14264t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14265u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public Disposable f14266v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14267w = new LinkedHashMap();

    /* compiled from: TrendFeedListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14268a;

        static {
            int[] iArr = new int[FeedSort.values().length];
            try {
                iArr[FeedSort.CloseFriend.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeedSort.Focus.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f14268a = iArr;
        }
    }

    public TrendFeedListFragment() {
        SensorPosition sensorPosition = SensorPosition.Feed;
        this.f14264t = new FeedSensorContext(sensorPosition, sensorPosition, null, SensorScene.Feed);
    }

    public static final Result A2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    public static final Result B2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    public static final Result C2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (Result) tmp0.invoke(obj);
    }

    public static final RecommendLiveAndFeedModel D2(Result recommendLiveResult, Result feedResult, Result testResult) {
        String str;
        List<ABTestModel> testResults;
        ABTestModel aBTestModel;
        kotlin.jvm.internal.s.i(recommendLiveResult, "recommendLiveResult");
        kotlin.jvm.internal.s.i(feedResult, "feedResult");
        kotlin.jvm.internal.s.i(testResult, "testResult");
        FeedTopLiveModel feedTopLiveModel = (FeedTopLiveModel) recommendLiveResult.getData();
        if (feedTopLiveModel != null) {
            ABTestListResult aBTestListResult = (ABTestListResult) testResult.getData();
            if (aBTestListResult != null && (testResults = aBTestListResult.getTestResults()) != null) {
                Iterator<ABTestModel> iterator2 = testResults.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        aBTestModel = null;
                        break;
                    }
                    aBTestModel = iterator2.next();
                    if (kotlin.jvm.internal.s.d(aBTestModel.getName(), ABTestKey.FEED_LIVE_ENTRANCE_TEST.getValue())) {
                        break;
                    }
                }
                ABTestModel aBTestModel2 = aBTestModel;
                if (aBTestModel2 != null) {
                    str = aBTestModel2.getResult();
                    feedTopLiveModel.setUseNewUi(kotlin.jvm.internal.s.d(str, ABTestGroup.B.getValue()));
                }
            }
            str = null;
            feedTopLiveModel.setUseNewUi(kotlin.jvm.internal.s.d(str, ABTestGroup.B.getValue()));
        }
        FeedTopLiveModel feedTopLiveModel2 = (FeedTopLiveModel) recommendLiveResult.getData();
        FeedResultModel feedResultModel = (FeedResultModel) feedResult.getData();
        FeedResultModel feedResultModel2 = (FeedResultModel) feedResult.getData();
        return new RecommendLiveAndFeedModel(feedTopLiveModel2, feedResultModel, feedResultModel2 != null ? feedResultModel2.getNextCursorId() : null);
    }

    public static final void E2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final FeedSettingResult u2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (FeedSettingResult) tmp0.invoke(obj);
    }

    public static final void v2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void w2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    public void C1(@Nullable String str) {
        Disposable disposed = s2(str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedResultModel, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$loadFeedData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedResultModel feedResultModel) {
                m2568invoke(feedResultModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2568invoke(FeedResultModel feedResultModel) {
                FeedResultModel feedResultModel2 = feedResultModel;
                TrendFeedListFragment.this.P1(feedResultModel2.getNextCursorId());
                TrendFeedListFragment.this.I2(feedResultModel2);
                BaseFeedListFragment.l1(TrendFeedListFragment.this, false, 1, null);
                TrendFeedListFragment.this.p1().c(false);
                ((FKSwipeRefreshLayout) TrendFeedListFragment.this.W0(R$id.feedSwipeRefreshLayout)).setRefreshing(false);
                TrendFeedListFragment trendFeedListFragment = TrendFeedListFragment.this;
                Boolean redDot = feedResultModel2.getRedDot();
                trendFeedListFragment.m2(redDot != null ? redDot.booleanValue() : false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$loadFeedData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                TrendFeedListFragment.this.p1().c(false);
                ((FKSwipeRefreshLayout) TrendFeedListFragment.this.W0(R$id.feedSwipeRefreshLayout)).setRefreshing(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void F2() {
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) W0(R$id.feedRecyclerView);
        if (nestingRecyclerView != null) {
            nestingRecyclerView.scrollToPosition(0);
        }
    }

    @Override // com.cupidapp.live.mediapicker.helper.d
    public void G(@NotNull PublishViewModel item) {
        kotlin.jvm.internal.s.i(item, "item");
        F2();
    }

    public final void G2(boolean z10) {
        List<FeedRainbowRecommendItemModel> recommendList;
        List<Object> j10 = n1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FeedRainbowRecommendModel) {
                arrayList.add(obj);
            }
        }
        FeedRainbowRecommendModel feedRainbowRecommendModel = (FeedRainbowRecommendModel) CollectionsKt___CollectionsKt.V(arrayList);
        FeedRainbowRecommendItemModel feedRainbowRecommendItemModel = null;
        if (feedRainbowRecommendModel != null && (recommendList = feedRainbowRecommendModel.getRecommendList()) != null) {
            Iterator<FeedRainbowRecommendItemModel> iterator2 = recommendList.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                FeedRainbowRecommendItemModel next = iterator2.next();
                if (kotlin.jvm.internal.s.d(next.getUser().getMe(), Boolean.TRUE)) {
                    feedRainbowRecommendItemModel = next;
                    break;
                }
            }
            feedRainbowRecommendItemModel = feedRainbowRecommendItemModel;
        }
        if (feedRainbowRecommendItemModel != null) {
            feedRainbowRecommendItemModel.setOpenRecommend(z10);
            n1().notifyItemChanged(n1().j().indexOf(feedRainbowRecommendModel));
        }
    }

    public final void H2(Set<String> set, boolean z10, boolean z11) {
        if (!(set == null || set.isEmpty()) || z10 || z11) {
            int i10 = 0;
            for (Object obj : n1().j()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                if (obj instanceof PostLimitFriendsModel) {
                    boolean z12 = false;
                    for (UserWithPostLimitStatusModel userWithPostLimitStatusModel : ((PostLimitFriendsModel) obj).getData()) {
                        com.cupidapp.live.profile.logic.c cVar = com.cupidapp.live.profile.logic.c.f17839a;
                        if (cVar.a(userWithPostLimitStatusModel.getId()) && z11) {
                            userWithPostLimitStatusModel.setReadStatus(PostLimitReadStatus.NoPostLimit.getValue());
                        } else if (cVar.a(userWithPostLimitStatusModel.getId()) && z10) {
                            userWithPostLimitStatusModel.setReadStatus(PostLimitReadStatus.UnRead.getValue());
                        } else if ((set != null && set.contains(userWithPostLimitStatusModel.getId())) && userWithPostLimitStatusModel.getReadStatus() != null) {
                            Integer readStatus = userWithPostLimitStatusModel.getReadStatus();
                            PostLimitReadStatus postLimitReadStatus = PostLimitReadStatus.Read;
                            if (!kotlin.jvm.internal.s.d(readStatus, postLimitReadStatus.getValue())) {
                                userWithPostLimitStatusModel.setReadStatus(postLimitReadStatus.getValue());
                            }
                        }
                        z12 = true;
                    }
                    if (z12) {
                        n1().notifyItemChanged(i10);
                    }
                }
                i10 = i11;
            }
        }
    }

    public final void I2(FeedResultModel feedResultModel) {
        List<FeedModel> list = feedResultModel.getList();
        if (list != null) {
            int i10 = 0;
            for (FeedModel feedModel : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                FeedModel feedModel2 = feedModel;
                if (kotlin.jvm.internal.s.d(feedModel2.getType(), FeedType.RecommendFeed.getValue())) {
                    List<List<FeedRecommendResult>> recoList = feedResultModel.getRecoList();
                    boolean z10 = true;
                    if (!(recoList == null || recoList.isEmpty())) {
                        List<List<FeedRecommendResult>> recoList2 = feedResultModel.getRecoList();
                        ArrayList arrayList = null;
                        List list2 = recoList2 != null ? (List) CollectionsKt___CollectionsKt.V(recoList2) : null;
                        if (!(list2 == null || list2.isEmpty())) {
                            List<List<FeedRecommendResult>> recoList3 = feedResultModel.getRecoList();
                            kotlin.jvm.internal.s.f(recoList3);
                            List<FeedRecommendResult> remove = recoList3.remove(0);
                            if (remove != null) {
                                arrayList = new ArrayList();
                                for (FeedRecommendResult feedRecommendResult : remove) {
                                    if (feedRecommendResult.getPost() != null) {
                                        arrayList.add(feedRecommendResult);
                                    }
                                }
                            }
                            if (arrayList != null && !arrayList.isEmpty()) {
                                z10 = false;
                            }
                            if (!z10) {
                                n1().d(new FeedRecommendListModel(arrayList));
                            }
                        }
                    }
                } else if (kotlin.jvm.internal.s.d(feedModel2.getType(), FeedType.ShowCase.getValue())) {
                    n1().d(new FeedShowCaseViewModel(feedModel2));
                } else if (kotlin.jvm.internal.s.d(feedModel2.getType(), FeedType.ProgramAd.getValue())) {
                    z1(SensorPosition.Feed, i10);
                } else if (kotlin.jvm.internal.s.d(FeedType.PostLimit.getValue(), feedModel2.getType())) {
                    List<UserWithPostLimitStatusModel> list3 = feedModel2.getList();
                    if (list3 != null) {
                        n1().d(new PostLimitFriendsModel(feedModel2.getTitle(), list3, feedModel2.getRcmdType()));
                    }
                } else if (kotlin.jvm.internal.s.d(feedModel2.getType(), FeedType.PostSpecialExposure.getValue())) {
                    List<UserWithPostLimitStatusModel> list4 = feedModel2.getList();
                    if (list4 != null) {
                        TrendFeedListAdapter n12 = n1();
                        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.t(list4, 10));
                        Iterator<UserWithPostLimitStatusModel> iterator2 = list4.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList2.add(new FeedRainbowRecommendItemModel(iterator2.next(), kotlin.jvm.internal.s.d(feedModel2.getSpecialExposureSetting(), Boolean.TRUE)));
                        }
                        n12.d(new FeedRainbowRecommendModel(arrayList2));
                    }
                } else if (kotlin.jvm.internal.s.d(FeedType.FeedAlohaGuide.getValue(), feedModel2.getType())) {
                    n1().d(new FeedAlohaGuideModel(feedModel2));
                } else if (kotlin.jvm.internal.s.d(FeedType.MatchNearByGuide.getValue(), feedModel2.getType())) {
                    PromotionNearByGuideModel guide = feedModel2.getGuide();
                    if (guide != null) {
                        n1().d(guide);
                    }
                } else if (feedModel2.getUser() != null) {
                    n1().d(feedModel2);
                }
                i10 = i11;
            }
        }
    }

    public final void J2() {
        RecyclerExposureHelper.a aVar = RecyclerExposureHelper.f12092j;
        aVar.d(ExposureScene.Feed);
        aVar.d(ExposureScene.FeedLimit);
        aVar.d(ExposureScene.FeedRecommendLive);
        aVar.d(ExposureScene.RecommendFeedEnter);
        aVar.d(ExposureScene.RainbowRecommend);
    }

    public final void K2() {
        if (((NestingRecyclerView) W0(R$id.feedRecyclerView)) == null) {
            return;
        }
        T1();
        F2();
        onRefresh();
    }

    public final void L2(FeedSort feedSort) {
        p1.g.f52734a.h2(feedSort);
        EventBus.c().l(new ChangeFeedSortEvent());
    }

    public final void M2() {
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 != null ? kotlin.jvm.internal.s.d(q10.getVasPolling(), Boolean.TRUE) : false) {
            Disposable disposed = NetworkClient.f11868a.p().a().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<VipDiscountPromptModel, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$showDiscountPrompt$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(VipDiscountPromptModel vipDiscountPromptModel) {
                    m2570invoke(vipDiscountPromptModel);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2570invoke(VipDiscountPromptModel vipDiscountPromptModel) {
                    ((VipDiscountPromptLayout) TrendFeedListFragment.this.W0(R$id.vip_discount_prompt_layout)).b(vipDiscountPromptModel, DiscountShowPlace.Feed);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$showDiscountPrompt$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    return Boolean.TRUE;
                }
            }, this)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                H(disposed);
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14267w.clear();
    }

    public final void N2(String str, int i10) {
        com.cupidapp.live.base.view.g.f12778a.d(getView(), new SnackbarModel(str, 12.0f, null, 0, null, 0.0f, null, null, Integer.valueOf(i10), 0, 0, null, 1784, null));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.Feed;
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    public boolean R1() {
        return false;
    }

    @Override // com.cupidapp.live.mediapicker.helper.d
    public void U(@NotNull PublishViewModel item) {
        kotlin.jvm.internal.s.i(item, "item");
        K2();
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14267w;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.mediapicker.helper.d
    public void i0(@NotNull PublishViewModel item) {
        kotlin.jvm.internal.s.i(item, "item");
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    public boolean i1() {
        return true;
    }

    public final void l2(boolean z10) {
        p1.g.f52734a.g2(Boolean.valueOf(z10));
        EventBus.c().l(new FeedSortSwitchEvent());
    }

    public final void m2(boolean z10) {
        if (this.f14265u != z10) {
            EventBus.c().l(new TabRedDotEvent(z10, SensorPosition.RecommendFeed));
        }
        this.f14265u = z10;
    }

    public final void n2(FeedSort feedSort) {
        L2(feedSort);
        o2();
        Observable<Result<Object>> v2 = NetworkClient.f11868a.l().v(feedSort.getValue());
        Object context = getContext();
        TrendFeedListFragment$changeSortLoadData$2 trendFeedListFragment$changeSortLoadData$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$changeSortLoadData$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = v2.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$changeSortLoadData$$inlined$handleByContext$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(trendFeedListFragment$changeSortLoadData$2, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        onRefresh();
    }

    public final void o2() {
        n1().j().clear();
        n1().B();
        n1().notifyDataSetChanged();
        ((LinearLayout) W0(R$id.feedEmptyPromptLl)).setVisibility(8);
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        PublishManager.f17234a.g(this);
        super.onDestroy();
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Disposable disposable = this.f14266v;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        I1(event.getUser());
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        EventBus.c().l(new com.cupidapp.live.feed.layout.i(false));
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        int i10 = R$id.feedSwipeRefreshLayout;
        if (((FKSwipeRefreshLayout) W0(i10)) == null) {
            return;
        }
        J2();
        FKSwipeRefreshLayout fKSwipeRefreshLayout = (FKSwipeRefreshLayout) W0(i10);
        if (fKSwipeRefreshLayout != null) {
            fKSwipeRefreshLayout.setRefreshing(true);
        }
        t2();
        n1().C();
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        EventBus.c().l(new com.cupidapp.live.feed.layout.i(true));
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        n1().l().d().putAll(i0.h(kotlin.f.a(Integer.valueOf(R$id.showCaseLayout), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$onViewCreated$1
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
                if (obj instanceof FeedShowCaseViewModel) {
                    FeedShowCaseViewModel feedShowCaseViewModel = (FeedShowCaseViewModel) obj;
                    SensorsLogFeed.f12208a.f(feedShowCaseViewModel.getFeedModel().getUrl(), feedShowCaseViewModel.getFeedModel().getPostId(), TrendFeedListFragment.this.O0());
                    ADMonitorHelper.f18414a.b(TrendFeedListFragment.this.getContext(), feedShowCaseViewModel.getFeedModel().getClickTrackUrlList());
                    com.cupidapp.live.base.router.j.f12156c.a(TrendFeedListFragment.this.getContext(), feedShowCaseViewModel.getFeedModel().getUrl(), new WebStyleViewModel(WebStyleEnum.CardStyle, false, null, 6, null));
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.see_more_textview), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$onViewCreated$2
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
                if (obj instanceof FeedRainbowRecommendModel) {
                    RainbowRecommendActivity.f14128x.a(TrendFeedListFragment.this.getContext());
                }
            }
        })));
        n1().F(new com.cupidapp.live.feed.holder.f() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$onViewCreated$3
            @Override // com.cupidapp.live.feed.holder.f
            public void a() {
                User X = p1.g.f52734a.X();
                if (X != null && X.isSsvip()) {
                    RainbowRecommendActivity.f14128x.a(TrendFeedListFragment.this.getContext());
                } else {
                    PurchaseDialogManager.o(TrendFeedListFragment.this.r1(), VipPurchaseEntranceType.RainbowRecommend, null, false, false, 14, null);
                }
                SensorsLogKeyButtonClick.FeedList.StartRecommend.click();
            }

            @Override // com.cupidapp.live.feed.holder.f
            public void b(@NotNull final String userId) {
                kotlin.jvm.internal.s.i(userId, "userId");
                Observable o10 = a.C0836a.o(NetworkClient.f11868a.N(), userId, null, null, FollowPrefer.PostSpecialExposure.getValue(), 0, null, null, null, 246, null);
                final TrendFeedListFragment trendFeedListFragment = TrendFeedListFragment.this;
                Disposable disposed = o10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$onViewCreated$3$alohaClick$$inlined$handle$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                        m2569invoke(swipeCardUserLikeResult);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2569invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                        List<Object> j10 = TrendFeedListFragment.this.n1().j();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : j10) {
                            if (obj instanceof FeedRainbowRecommendModel) {
                                arrayList.add(obj);
                            }
                        }
                        FeedRainbowRecommendModel feedRainbowRecommendModel = (FeedRainbowRecommendModel) CollectionsKt___CollectionsKt.V(arrayList);
                        if (feedRainbowRecommendModel != null) {
                            RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((NestingRecyclerView) TrendFeedListFragment.this.W0(R$id.feedRecyclerView)).findViewHolderForLayoutPosition(TrendFeedListFragment.this.n1().j().indexOf(feedRainbowRecommendModel));
                            FeedRainbowRecommendViewHolder feedRainbowRecommendViewHolder = findViewHolderForLayoutPosition instanceof FeedRainbowRecommendViewHolder ? (FeedRainbowRecommendViewHolder) findViewHolderForLayoutPosition : null;
                            if (feedRainbowRecommendViewHolder != null) {
                                feedRainbowRecommendViewHolder.u(userId, true);
                            }
                        }
                        GroupSocialLog.f18708a.B(true, SensorScene.FeedRainbowRecommend.getValue(), userId, (r52 & 8) != 0 ? 1 : 0, (r52 & 16) != 0 ? null : null, (r52 & 32) != 0 ? null : null, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : Boolean.TRUE, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, trendFeedListFragment)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (trendFeedListFragment != null) {
                        trendFeedListFragment.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
        t2();
        PublishManager.f17234a.c(this);
        x2();
    }

    public final void p2(@NotNull FeedSort sort) {
        kotlin.jvm.internal.s.i(sort, "sort");
        if (((FKSwipeRefreshLayout) W0(R$id.feedSwipeRefreshLayout)) == null) {
            return;
        }
        n2(sort);
        SensorsLogFeed.f12208a.I(sort);
    }

    public final void q2(final FeedSort feedSort) {
        List<Object> j10 = n1().j();
        ArrayList arrayList = new ArrayList();
        Iterator<Object> iterator2 = j10.iterator2();
        while (true) {
            boolean z10 = true;
            if (!iterator2.hasNext()) {
                break;
            }
            Object next = iterator2.next();
            if (!(next instanceof FeedModel) && !(next instanceof FeedShowCaseViewModel) && !(next instanceof FeedRecommendListModel) && !(next instanceof FeedAlohaGuideModel) && !(next instanceof PromotionNearByGuideModel) && !(next instanceof FeedRainbowRecommendModel)) {
                z10 = false;
            }
            if (z10) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            ((LinearLayout) W0(R$id.feedEmptyPromptLl)).setVisibility(0);
            int i10 = R$id.feedEmptyPromptBtn;
            ((TextView) W0(i10)).getPaint().setFakeBoldText(true);
            int i11 = feedSort == null ? -1 : a.f14268a[feedSort.ordinal()];
            if (i11 == 1) {
                if (p1.g.f52734a.n() > 0) {
                    ((TextView) W0(R$id.feedEmptyPromptTxt)).setText(R$string.no_close_friend_feed);
                    ((TextView) W0(i10)).setVisibility(8);
                    return;
                }
                ((TextView) W0(R$id.feedEmptyPromptTxt)).setText(R$string.no_close_friend_in_feed);
                ((TextView) W0(i10)).setVisibility(0);
                ((TextView) W0(i10)).setText(R$string.add_close_friend);
                TextView feedEmptyPromptBtn = (TextView) W0(i10);
                kotlin.jvm.internal.s.h(feedEmptyPromptBtn, "feedEmptyPromptBtn");
                y.d(feedEmptyPromptBtn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$configFeedEmptyPromptTextView$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                        invoke2(view);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view) {
                        TrendFeedListFragment.this.w1();
                        GroupOthersLog.f18702a.o0(GroupOthersLog.TipsType.CLOSE_FRIENDS, feedSort);
                    }
                });
                GroupOthersLog.f18702a.q0(GroupOthersLog.TipsType.CLOSE_FRIENDS, feedSort);
                return;
            }
            if (i11 != 2) {
                ((TextView) W0(R$id.feedEmptyPromptTxt)).setText(R$string.empty_feed_list_prompt);
                ((TextView) W0(i10)).setVisibility(8);
                return;
            }
            if (p1.g.f52734a.F() > 0) {
                ((TextView) W0(R$id.feedEmptyPromptTxt)).setText(R$string.no_focus_feed);
                ((TextView) W0(i10)).setVisibility(8);
                return;
            }
            ((TextView) W0(R$id.feedEmptyPromptTxt)).setText(R$string.no_focus_in_feed);
            ((TextView) W0(i10)).setVisibility(0);
            ((TextView) W0(i10)).setText(R$string.add_focus);
            TextView feedEmptyPromptBtn2 = (TextView) W0(i10);
            kotlin.jvm.internal.s.h(feedEmptyPromptBtn2, "feedEmptyPromptBtn");
            y.d(feedEmptyPromptBtn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$configFeedEmptyPromptTextView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                    invoke2(view);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    TrendFeedListFragment.this.x1();
                    GroupOthersLog.f18702a.o0(GroupOthersLog.TipsType.SPECIAL_ATTENTION, feedSort);
                }
            });
            GroupOthersLog.f18702a.q0(GroupOthersLog.TipsType.SPECIAL_ATTENTION, feedSort);
            return;
        }
        ((LinearLayout) W0(R$id.feedEmptyPromptLl)).setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b A[LOOP:0: B:2:0x000e->B:18:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[EDGE_INSN: B:19:0x005f->B:20:0x005f BREAK  A[LOOP:0: B:2:0x000e->B:18:0x005b], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r2() {
        /*
            r7 = this;
            com.cupidapp.live.feed.adapter.TrendFeedListAdapter r0 = r7.n1()
            java.util.List r0 = r0.j()
            java.util.Iterator r0 = r0.iterator2()
            r1 = 0
            r2 = 0
        Le:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L5e
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof com.cupidapp.live.feed.model.PostLimitFriendsModel
            if (r4 == 0) goto L57
            com.cupidapp.live.profile.logic.c r4 = com.cupidapp.live.profile.logic.c.f17839a
            com.cupidapp.live.feed.model.PostLimitFriendsModel r3 = (com.cupidapp.live.feed.model.PostLimitFriendsModel) r3
            java.util.List r5 = r3.getData()
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.V(r5)
            com.cupidapp.live.feed.model.UserWithPostLimitStatusModel r5 = (com.cupidapp.live.feed.model.UserWithPostLimitStatusModel) r5
            r6 = 0
            if (r5 == 0) goto L32
            java.lang.String r5 = r5.getId()
            goto L33
        L32:
            r5 = r6
        L33:
            boolean r4 = r4.a(r5)
            if (r4 == 0) goto L57
            java.util.List r3 = r3.getData()
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.V(r3)
            com.cupidapp.live.feed.model.UserWithPostLimitStatusModel r3 = (com.cupidapp.live.feed.model.UserWithPostLimitStatusModel) r3
            if (r3 == 0) goto L49
            java.lang.Integer r6 = r3.getReadStatus()
        L49:
            com.cupidapp.live.profile.model.PostLimitReadStatus r3 = com.cupidapp.live.profile.model.PostLimitReadStatus.NoPostLimit
            java.lang.Integer r3 = r3.getValue()
            boolean r3 = kotlin.jvm.internal.s.d(r6, r3)
            if (r3 == 0) goto L57
            r3 = 1
            goto L58
        L57:
            r3 = 0
        L58:
            if (r3 == 0) goto L5b
            goto L5f
        L5b:
            int r2 = r2 + 1
            goto Le
        L5e:
            r2 = -1
        L5f:
            p1.g r0 = p1.g.f52734a
            com.cupidapp.live.feed.model.FeedPostLimitGuideModel r0 = r0.z()
            if (r0 != 0) goto L68
            goto L6b
        L68:
            r0.setShowPosition(r2)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.fragment.TrendFeedListFragment.r2():void");
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    @NotNull
    public FeedSensorContext s1() {
        return this.f14264t;
    }

    public final Observable<Result<FeedResultModel>> s2(String str) {
        p1.g gVar = p1.g.f52734a;
        FeedSort x10 = gVar.x();
        int i10 = x10 == null ? -1 : a.f14268a[x10.ordinal()];
        if (i10 == 1) {
            return a.C0731a.a(NetworkClient.f11868a.l(), str, 0, 2, null);
        }
        if (i10 != 2) {
            f2.a l10 = NetworkClient.f11868a.l();
            FeedSort x11 = gVar.x();
            return a.C0731a.g(l10, str, 0, x11 != null ? x11.getValue() : null, 2, null);
        }
        return a.C0731a.h(NetworkClient.f11868a.l(), str, 0, 2, null);
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    public int t1() {
        return 0;
    }

    public final void t2() {
        Observable onErrorReturn;
        p1.g gVar = p1.g.f52734a;
        if (gVar.x() != null && kotlin.jvm.internal.s.d(gVar.w(), Boolean.TRUE)) {
            FeedSort x10 = gVar.x();
            String value = x10 != null ? x10.getValue() : null;
            Boolean w3 = gVar.w();
            onErrorReturn = Observable.just(new FeedSettingResult(value, w3 != null ? w3.booleanValue() : false));
        } else {
            Observable<R> flatMap = NetworkClient.f11868a.l().U().flatMap(new com.cupidapp.live.base.network.i());
            final TrendFeedListFragment$initData$1 trendFeedListFragment$initData$1 = new Function1<Throwable, FeedSettingResult>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$initData$1
                @Override // kotlin.jvm.functions.Function1
                public final FeedSettingResult invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    return new FeedSettingResult(null, false);
                }
            };
            onErrorReturn = flatMap.onErrorReturn(new Function() { // from class: com.cupidapp.live.feed.fragment.s
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    FeedSettingResult u22;
                    u22 = TrendFeedListFragment.u2(Function1.this, obj);
                    return u22;
                }
            });
        }
        Observable observeOn = onErrorReturn.observeOn(AndroidSchedulers.mainThread());
        final Function1<FeedSettingResult, kotlin.p> function1 = new Function1<FeedSettingResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$initData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedSettingResult feedSettingResult) {
                invoke2(feedSettingResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeedSettingResult feedSettingResult) {
                TrendFeedListFragment.this.L2(feedSettingResult.getSortType());
                TrendFeedListFragment.this.l2(feedSettingResult.getFeedSortSwitch());
                TrendFeedListFragment.this.y2();
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.feed.fragment.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TrendFeedListFragment.v2(Function1.this, obj);
            }
        };
        final TrendFeedListFragment$initData$3 trendFeedListFragment$initData$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$initData$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.feed.fragment.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TrendFeedListFragment.w2(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(subscribe, "private fun initData() {…       })\n        )\n    }");
        H(subscribe);
    }

    public final void x2() {
        int i10 = R$id.feedSwipeRefreshLayout;
        ((FKSwipeRefreshLayout) W0(i10)).setEnabled(true);
        ((FKSwipeRefreshLayout) W0(i10)).setOnRefreshListener(this);
        ((FKSwipeRefreshLayout) W0(i10)).setProgressViewOffset(false, 0, z0.h.c(this, 70.0f));
    }

    public final void y2() {
        Observable<Result<FeedTopLiveModel>> onErrorReturn;
        Observable<Result<ABTestListResult>> onErrorReturn2;
        Disposable disposable;
        Disposable disposable2 = this.f14266v;
        if (disposable2 != null) {
            boolean z10 = false;
            if (disposable2 != null && !disposable2.isDisposed()) {
                z10 = true;
            }
            if (z10 && (disposable = this.f14266v) != null) {
                disposable.dispose();
            }
        }
        final FeedSort x10 = p1.g.f52734a.x();
        FeedSort feedSort = FeedSort.Intimacy;
        if (x10 != feedSort && x10 != FeedSort.Time) {
            onErrorReturn = Observable.just(new Result(null, false, null, null, null, null, null, 127, null));
        } else {
            Observable<Result<FeedTopLiveModel>> P = NetworkClient.f11868a.r().P();
            final TrendFeedListFragment$loadRecommendLiveAndFeedData$recommendLiveObservable$1 trendFeedListFragment$loadRecommendLiveAndFeedData$recommendLiveObservable$1 = new Function1<Throwable, Result<? extends FeedTopLiveModel>>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$loadRecommendLiveAndFeedData$recommendLiveObservable$1
                @Override // kotlin.jvm.functions.Function1
                public final Result<FeedTopLiveModel> invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    return new Result<>(null, false, null, null, null, null, null, 127, null);
                }
            };
            onErrorReturn = P.onErrorReturn(new Function() { // from class: com.cupidapp.live.feed.fragment.t
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Result A2;
                    A2 = TrendFeedListFragment.A2(Function1.this, obj);
                    return A2;
                }
            });
        }
        if (x10 != feedSort && x10 != FeedSort.Time) {
            onErrorReturn2 = Observable.just(new Result(null, false, null, null, null, null, null, 127, null));
        } else {
            Observable<Result<ABTestListResult>> g3 = NetworkClient.f11868a.i().g(ABTestKey.FEED_LIVE_ENTRANCE_TEST.getValue());
            final TrendFeedListFragment$loadRecommendLiveAndFeedData$recommendLiveUiTest$1 trendFeedListFragment$loadRecommendLiveAndFeedData$recommendLiveUiTest$1 = new Function1<Throwable, Result<? extends ABTestListResult>>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$loadRecommendLiveAndFeedData$recommendLiveUiTest$1
                @Override // kotlin.jvm.functions.Function1
                public final Result<ABTestListResult> invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    return new Result<>(null, false, null, null, null, null, null, 127, null);
                }
            };
            onErrorReturn2 = g3.onErrorReturn(new Function() { // from class: com.cupidapp.live.feed.fragment.q
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Result B2;
                    B2 = TrendFeedListFragment.B2(Function1.this, obj);
                    return B2;
                }
            });
        }
        Observable<Result<FeedResultModel>> s2 = s2(null);
        final TrendFeedListFragment$loadRecommendLiveAndFeedData$feedObservable$1 trendFeedListFragment$loadRecommendLiveAndFeedData$feedObservable$1 = new Function1<Throwable, Result<? extends FeedResultModel>>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$loadRecommendLiveAndFeedData$feedObservable$1
            @Override // kotlin.jvm.functions.Function1
            public final Result<FeedResultModel> invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return new Result<>(null, false, null, null, null, null, null, 127, null);
            }
        };
        Observable observeOn = Observable.zip(onErrorReturn, s2.onErrorReturn(new Function() { // from class: com.cupidapp.live.feed.fragment.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Result C2;
                C2 = TrendFeedListFragment.C2(Function1.this, obj);
                return C2;
            }
        }), onErrorReturn2, new Function3() { // from class: com.cupidapp.live.feed.fragment.p
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                RecommendLiveAndFeedModel D2;
                D2 = TrendFeedListFragment.D2((Result) obj, (Result) obj2, (Result) obj3);
                return D2;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<RecommendLiveAndFeedModel, kotlin.p> function1 = new Function1<RecommendLiveAndFeedModel, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$loadRecommendLiveAndFeedData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(RecommendLiveAndFeedModel recommendLiveAndFeedModel) {
                invoke2(recommendLiveAndFeedModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RecommendLiveAndFeedModel recommendLiveAndFeedModel) {
                Integer closeFriendCount;
                Boolean redDot;
                Integer focusCount;
                TrendFeedListFragment.this.P1(recommendLiveAndFeedModel.getNextCursorId());
                TrendFeedListFragment.this.n1().j().clear();
                TrendFeedListFragment.this.n1().B();
                FeedSort feedSort2 = x10;
                boolean z11 = false;
                if (feedSort2 == FeedSort.Focus) {
                    p1.g gVar = p1.g.f52734a;
                    FeedResultModel feedResultModel = recommendLiveAndFeedModel.getFeedResultModel();
                    gVar.p2((feedResultModel == null || (focusCount = feedResultModel.getFocusCount()) == null) ? 0 : focusCount.intValue());
                    FeedResultModel feedResultModel2 = recommendLiveAndFeedModel.getFeedResultModel();
                    List<FeedModel> list = feedResultModel2 != null ? feedResultModel2.getList() : null;
                    if (!(list == null || list.isEmpty()) || gVar.F() != 0) {
                        TrendFeedListFragment.this.n1().w(1);
                        TrendFeedListAdapter n12 = TrendFeedListFragment.this.n1();
                        FeedResultModel feedResultModel3 = recommendLiveAndFeedModel.getFeedResultModel();
                        n12.d(new TopFocusEntranceModel(feedResultModel3 != null ? feedResultModel3.getFocusCount() : null));
                        GroupOthersLog.f18702a.q0(GroupOthersLog.TipsType.SPECIAL_ATTENTION, x10);
                    }
                } else if (feedSort2 == FeedSort.CloseFriend) {
                    p1.g gVar2 = p1.g.f52734a;
                    FeedResultModel feedResultModel4 = recommendLiveAndFeedModel.getFeedResultModel();
                    gVar2.Z1((feedResultModel4 == null || (closeFriendCount = feedResultModel4.getCloseFriendCount()) == null) ? 0 : closeFriendCount.intValue());
                    FeedResultModel feedResultModel5 = recommendLiveAndFeedModel.getFeedResultModel();
                    List<FeedModel> list2 = feedResultModel5 != null ? feedResultModel5.getList() : null;
                    if (!(list2 == null || list2.isEmpty()) || gVar2.n() != 0) {
                        TrendFeedListFragment.this.n1().w(1);
                        TrendFeedListAdapter n13 = TrendFeedListFragment.this.n1();
                        FeedResultModel feedResultModel6 = recommendLiveAndFeedModel.getFeedResultModel();
                        n13.d(new TopCloseFriendEntranceModel(feedResultModel6 != null ? feedResultModel6.getCloseFriendCount() : null));
                        GroupOthersLog.f18702a.q0(GroupOthersLog.TipsType.CLOSE_FRIENDS, x10);
                    }
                }
                FeedTopLiveModel recommendLive = recommendLiveAndFeedModel.getRecommendLive();
                List<LiveShowModel> list3 = recommendLive != null ? recommendLive.getList() : null;
                if (!(list3 == null || list3.isEmpty())) {
                    TrendFeedListFragment.this.n1().w(1);
                    FeedTopLiveModel recommendLive2 = recommendLiveAndFeedModel.getRecommendLive();
                    if (recommendLive2 != null) {
                        TrendFeedListFragment.this.n1().d(recommendLive2);
                    }
                }
                p1.g gVar3 = p1.g.f52734a;
                if (gVar3.J()) {
                    gVar3.t2(false);
                }
                FeedResultModel feedResultModel7 = recommendLiveAndFeedModel.getFeedResultModel();
                if (feedResultModel7 != null) {
                    TrendFeedListFragment trendFeedListFragment = TrendFeedListFragment.this;
                    FKExpressAdManager q12 = trendFeedListFragment.q1();
                    if (q12 != null) {
                        q12.k();
                    }
                    trendFeedListFragment.I2(feedResultModel7);
                }
                TrendFeedListFragment.this.k1(true);
                TrendFeedListFragment.this.q2(x10);
                TrendFeedListFragment.this.p1().c(false);
                ((FKSwipeRefreshLayout) TrendFeedListFragment.this.W0(R$id.feedSwipeRefreshLayout)).setRefreshing(false);
                TrendFeedListFragment trendFeedListFragment2 = TrendFeedListFragment.this;
                FeedResultModel feedResultModel8 = recommendLiveAndFeedModel.getFeedResultModel();
                if (feedResultModel8 != null && (redDot = feedResultModel8.getRedDot()) != null) {
                    z11 = redDot.booleanValue();
                }
                trendFeedListFragment2.m2(z11);
                TrendFeedListFragment.this.r2();
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.feed.fragment.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TrendFeedListFragment.E2(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.TrendFeedListFragment$loadRecommendLiveAndFeedData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                TrendFeedListFragment.this.p1().c(false);
                ((FKSwipeRefreshLayout) TrendFeedListFragment.this.W0(R$id.feedSwipeRefreshLayout)).setRefreshing(false);
                TrendFeedListFragment trendFeedListFragment = TrendFeedListFragment.this;
                String string = trendFeedListFragment.getString(R$string.load_failed_refresh);
                kotlin.jvm.internal.s.h(string, "getString(R.string.load_failed_refresh)");
                trendFeedListFragment.N2(string, R$mipmap.ic_tip_warn);
                SensorsLogFeed.f12208a.p();
            }
        };
        this.f14266v = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.feed.fragment.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TrendFeedListFragment.z2(Function1.this, obj);
            }
        });
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SwipeRefreshIsEnabledEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        ((FKSwipeRefreshLayout) W0(R$id.feedSwipeRefreshLayout)).setEnabled(event.isEnabled());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenPostEditEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        PostLimitEditActivity.a.b(PostLimitEditActivity.E, getContext(), this.f14264t, null, 4, null);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenPostLimitEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        Context context = getContext();
        if (context != null) {
            PostLimitDetailListActivity.a aVar = PostLimitDetailListActivity.f14096x;
            List<String> userIds = event.getUserIds();
            kotlin.jvm.internal.s.g(userIds, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
            aVar.a(context, (ArrayList) userIds, event.getPos(), this.f14264t);
        }
        SensorsLogFeed.f12208a.t(SensorPosition.Feed, (String) CollectionsKt___CollectionsKt.W(event.getUserIds(), event.getPos()), (r16 & 4) != 0 ? null : event.getStrategyId(), (r16 & 8) != 0 ? null : Integer.valueOf(event.getPos() + 1), (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserPostLimitReadChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        H2(event.getReadUserIds(), event.isUploadedPostLimit(), event.isDelAllMyPostLimit());
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SuperLikeBtnShowEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        onRefresh();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PostLimitUploadSucEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        H2(m0.d(), true, false);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserManageViewEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        if (event.getPosition() == SensorPosition.CloseFriend && p1.g.f52734a.x() == FeedSort.CloseFriend) {
            if (event.getDataChanged()) {
                K2();
            }
        } else if (event.getPosition() == SensorPosition.Focus) {
            p1.g gVar = p1.g.f52734a;
            if (gVar.x() == FeedSort.Intimacy || gVar.x() == FeedSort.Focus) {
                K2();
            }
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserDataChangeEvent event) {
        List<FeedRainbowRecommendItemModel> recommendList;
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        List<Object> j10 = n1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FeedRainbowRecommendModel) {
                arrayList.add(obj);
            }
        }
        FeedRainbowRecommendModel feedRainbowRecommendModel = (FeedRainbowRecommendModel) CollectionsKt___CollectionsKt.V(arrayList);
        FeedRainbowRecommendItemModel feedRainbowRecommendItemModel = null;
        if (feedRainbowRecommendModel != null && (recommendList = feedRainbowRecommendModel.getRecommendList()) != null) {
            Iterator<FeedRainbowRecommendItemModel> iterator2 = recommendList.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                FeedRainbowRecommendItemModel next = iterator2.next();
                if (kotlin.jvm.internal.s.d(next.getUser().getId(), event.getUserId())) {
                    feedRainbowRecommendItemModel = next;
                    break;
                }
            }
            feedRainbowRecommendItemModel = feedRainbowRecommendItemModel;
        }
        if (feedRainbowRecommendItemModel != null) {
            feedRainbowRecommendItemModel.getUser().setAloha(Boolean.valueOf(event.getAloha()));
            n1().notifyItemChanged(n1().j().indexOf(feedRainbowRecommendModel));
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenRainbowRecommendEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        G2(event.getOpen());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull VipPurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (event.getVipType() == VipType.RAINBOW) {
            G2(true);
        }
    }
}
