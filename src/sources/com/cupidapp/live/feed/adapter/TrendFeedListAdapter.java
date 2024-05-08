package com.cupidapp.live.feed.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.feed.FeedSort;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.helper.h;
import com.cupidapp.live.feed.helper.m;
import com.cupidapp.live.feed.holder.FeedAdViewHolder;
import com.cupidapp.live.feed.holder.FeedNoFollowUserViewHolder;
import com.cupidapp.live.feed.holder.FeedRainbowRecommendModel;
import com.cupidapp.live.feed.holder.FeedRainbowRecommendViewHolder;
import com.cupidapp.live.feed.holder.FeedShowCaseViewHolder;
import com.cupidapp.live.feed.holder.FeedTopLiveListViewHolder;
import com.cupidapp.live.feed.holder.LimitPostViewHolder;
import com.cupidapp.live.feed.holder.PromotionNearByGuideViewHolder;
import com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder;
import com.cupidapp.live.feed.holder.TopCloseFriendEntranceViewHolder;
import com.cupidapp.live.feed.holder.TopFocusEntranceViewHolder;
import com.cupidapp.live.feed.holder.TrendFeedViewHolder;
import com.cupidapp.live.feed.holder.c;
import com.cupidapp.live.feed.holder.f;
import com.cupidapp.live.feed.model.FKExpressAdModel;
import com.cupidapp.live.feed.model.FeedAlohaGuideModel;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendListModel;
import com.cupidapp.live.feed.model.FeedShowCaseViewModel;
import com.cupidapp.live.feed.model.PostLimitFriendsModel;
import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import com.cupidapp.live.feed.model.SponsorModel;
import com.cupidapp.live.feed.model.TopCloseFriendEntranceModel;
import com.cupidapp.live.feed.model.TopFocusEntranceModel;
import com.cupidapp.live.liveshow.model.FeedTopLiveModel;
import com.cupidapp.live.startup.helper.ADMonitorHelper;
import com.cupidapp.live.startup.model.FKExpressAdType;
import com.cupidapp.live.track.group.GroupSocialLog;
import h1.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: TrendFeedListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TrendFeedListAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f */
    @NotNull
    public final FeedSensorContext f14191f;

    /* renamed from: g */
    public final int f14192g;

    /* renamed from: h */
    @Nullable
    public final RecommendFeedEnterListViewHolder.b f14193h;

    /* renamed from: i */
    @NotNull
    public final c f14194i;

    /* renamed from: j */
    public boolean f14195j;

    /* renamed from: k */
    public int f14196k;

    /* renamed from: l */
    @Nullable
    public RecommendFeedEnterListViewHolder f14197l;

    /* renamed from: m */
    @Nullable
    public FeedTopLiveListViewHolder f14198m;

    /* renamed from: n */
    @NotNull
    public List<WeakReference<LimitPostViewHolder>> f14199n;

    /* renamed from: o */
    @Nullable
    public f f14200o;

    public TrendFeedListAdapter(@NotNull FeedSensorContext sensorContext, int i10, @Nullable RecommendFeedEnterListViewHolder.b bVar, @NotNull c baseFeedListener) {
        s.i(sensorContext, "sensorContext");
        s.i(baseFeedListener, "baseFeedListener");
        this.f14191f = sensorContext;
        this.f14192g = i10;
        this.f14193h = bVar;
        this.f14194i = baseFeedListener;
        this.f14195j = true;
        ArrayList arrayList = new ArrayList();
        this.f14199n = arrayList;
        arrayList.clear();
        List<Class<? extends Object>> k10 = k();
        k10.add(FeedModel.class);
        k10.add(FeedShowCaseViewModel.class);
        k10.add(FeedTopLiveModel.class);
        k10.add(FKExpressAdModel.class);
        k10.add(FeedRecommendListModel.class);
        k10.add(PostLimitFriendsModel.class);
        k10.add(FKEmptyViewModel.class);
        k10.add(TopCloseFriendEntranceModel.class);
        k10.add(FeedAlohaGuideModel.class);
        k10.add(PromotionNearByGuideModel.class);
        k10.add(FeedRainbowRecommendModel.class);
        k10.add(TopFocusEntranceModel.class);
        k10.add(FKFooterViewModel.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void E(TrendFeedListAdapter trendFeedListAdapter, RecyclerView recyclerView, ExposureScene exposureScene, Function2 function2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            exposureScene = ExposureScene.Feed;
        }
        if ((i10 & 4) != 0) {
            function2 = null;
        }
        trendFeedListAdapter.D(recyclerView, exposureScene, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: A */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder fKBaseRecyclerViewHolder;
        s.i(parent, "parent");
        switch (i10) {
            case 0:
                fKBaseRecyclerViewHolder = TrendFeedViewHolder.f14417m.a(parent, this.f14195j, this.f14194i, this.f14191f, this.f14192g);
                break;
            case 1:
                fKBaseRecyclerViewHolder = FeedShowCaseViewHolder.f14390c.a(parent);
                break;
            case 2:
                FeedTopLiveListViewHolder a10 = FeedTopLiveListViewHolder.f14392d.a(parent);
                this.f14198m = a10;
                s.f(a10);
                fKBaseRecyclerViewHolder = a10;
                break;
            case 3:
                fKBaseRecyclerViewHolder = FeedAdViewHolder.f14374c.a(parent);
                break;
            case 4:
                RecommendFeedEnterListViewHolder a11 = RecommendFeedEnterListViewHolder.f14409f.a(parent, new FeedSensorContext(SensorPosition.RecommendFeedEnter, this.f14191f.getSource(), this.f14191f.getOriginSource(), SensorScene.RecommendFeed), this.f14193h);
                this.f14197l = a11;
                s.f(a11);
                fKBaseRecyclerViewHolder = a11;
                break;
            case 5:
                FKBaseRecyclerViewHolder a12 = LimitPostViewHolder.f14398d.a(parent);
                this.f14199n.add(new WeakReference<>(a12));
                fKBaseRecyclerViewHolder = a12;
                break;
            case 6:
                fKBaseRecyclerViewHolder = FKEmptyListViewHolder.f12034c.a(parent);
                break;
            case 7:
                fKBaseRecyclerViewHolder = TopCloseFriendEntranceViewHolder.f14415c.a(parent);
                break;
            case 8:
                fKBaseRecyclerViewHolder = FeedNoFollowUserViewHolder.f14384c.a(parent);
                break;
            case 9:
                fKBaseRecyclerViewHolder = PromotionNearByGuideViewHolder.f14408c.a(parent);
                break;
            case 10:
                fKBaseRecyclerViewHolder = FeedRainbowRecommendViewHolder.f14385e.a(parent, this.f14200o);
                break;
            case 11:
                fKBaseRecyclerViewHolder = TopFocusEntranceViewHolder.f14416c.a(parent);
                break;
            default:
                fKBaseRecyclerViewHolder = FKFooterViewHolder.f12036c.a(parent);
                break;
        }
        fKBaseRecyclerViewHolder.k(l());
        return fKBaseRecyclerViewHolder;
    }

    public final void B() {
        this.f14196k = 0;
    }

    public final void C() {
        RecommendFeedEnterListViewHolder recommendFeedEnterListViewHolder = this.f14197l;
        if (recommendFeedEnterListViewHolder != null) {
            recommendFeedEnterListViewHolder.x();
        }
        FeedTopLiveListViewHolder feedTopLiveListViewHolder = this.f14198m;
        if (feedTopLiveListViewHolder != null) {
            feedTopLiveListViewHolder.u();
        }
        Iterator<WeakReference<LimitPostViewHolder>> iterator2 = this.f14199n.iterator2();
        while (iterator2.hasNext()) {
            LimitPostViewHolder limitPostViewHolder = iterator2.next().get();
            if (limitPostViewHolder != null) {
                limitPostViewHolder.x();
            }
        }
    }

    public final void D(@NotNull final RecyclerView recyclerView, @NotNull ExposureScene scene, @Nullable final Function2<? super Integer, ? super String, p> function2) {
        s.i(recyclerView, "recyclerView");
        s.i(scene, "scene");
        t(new RecyclerExposureHelper(scene, recyclerView, 0.0f, 0L, null, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.feed.adapter.TrendFeedListAdapter$setExposureHelper$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> itemList) {
                FeedSensorContext feedSensorContext;
                FeedSensorContext feedSensorContext2;
                int i10;
                int indexOf;
                FeedSensorContext feedSensorContext3;
                FeedSensorContext feedSensorContext4;
                int i11;
                FeedSensorContext feedSensorContext5;
                FeedSensorContext feedSensorContext6;
                int i12;
                FeedSensorContext feedSensorContext7;
                FeedSensorContext feedSensorContext8;
                FeedSensorContext feedSensorContext9;
                FeedSensorContext feedSensorContext10;
                int i13;
                s.i(itemList, "itemList");
                TrendFeedListAdapter trendFeedListAdapter = TrendFeedListAdapter.this;
                Function2<Integer, String, p> function22 = function2;
                RecyclerView recyclerView2 = recyclerView;
                for (a aVar : itemList) {
                    Object a10 = aVar.a();
                    if (a10 instanceof FeedModel) {
                        feedSensorContext7 = trendFeedListAdapter.f14191f;
                        SensorPosition position = feedSensorContext7.getPosition();
                        FeedModel feedModel = (FeedModel) a10;
                        if (!TextUtils.isEmpty(feedModel.getStrategyId())) {
                            position = SensorPosition.RecommendFeed;
                        }
                        SensorPosition sensorPosition = position;
                        h hVar = h.f14329a;
                        String postId = feedModel.getPostId();
                        Integer tagId = feedModel.getTagId();
                        UserActionType userActionType = UserActionType.Read;
                        feedSensorContext8 = trendFeedListAdapter.f14191f;
                        hVar.e(postId, tagId, userActionType, sensorPosition, feedSensorContext8.getSource(), (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : feedModel.getPostStatisticsCallback());
                        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                        String userId = feedModel.getUser().userId();
                        String postId2 = feedModel.getPostId();
                        feedSensorContext9 = trendFeedListAdapter.f14191f;
                        SensorPosition position2 = feedSensorContext9.getPosition();
                        feedSensorContext10 = trendFeedListAdapter.f14191f;
                        SensorScene scene2 = feedSensorContext10.getScene();
                        Boolean valueOf = Boolean.valueOf(feedModel.getUser().getAloha());
                        String url = feedModel.getUrl();
                        String strategyId = feedModel.getStrategyId();
                        FeedSort x10 = g.f52734a.x();
                        int d10 = aVar.d() + 1;
                        i13 = trendFeedListAdapter.f14196k;
                        sensorsLogFeed.D(userId, postId2, position2, scene2, valueOf, url, strategyId, x10, (r31 & 256) != 0 ? null : null, d10 - i13, (r31 & 1024) != 0 ? null : Boolean.valueOf(feedModel.isPostBoostSpread()), (r31 & 2048) != 0 ? null : feedModel.getDynamicTop(), (r31 & 4096) != 0 ? null : null);
                        GroupSocialLog.f18708a.w(SensorScene.Feed.getValue(), feedModel.getUser().userId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                        if (feedModel.haveSponsor()) {
                            ADMonitorHelper aDMonitorHelper = ADMonitorHelper.f18414a;
                            AppApplication h10 = AppApplication.f11612d.h();
                            SponsorModel sponsorExtraInfo = feedModel.getSponsorExtraInfo();
                            aDMonitorHelper.b(h10, sponsorExtraInfo != null ? sponsorExtraInfo.getShowTrackUrlList() : null);
                            if (function22 != null) {
                                function22.mo1743invoke(Integer.valueOf(FKExpressAdType.Sponsor.getType()), feedModel.getPostId());
                            }
                        }
                        if (!feedModel.checkHaveSponsorTip() && feedModel.haveAdTip()) {
                            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView2.findViewHolderForLayoutPosition(trendFeedListAdapter.j().indexOf(a10));
                            TrendFeedViewHolder trendFeedViewHolder = findViewHolderForLayoutPosition instanceof TrendFeedViewHolder ? (TrendFeedViewHolder) findViewHolderForLayoutPosition : null;
                            if (trendFeedViewHolder != null) {
                                trendFeedViewHolder.f0();
                            }
                        }
                    }
                    if (a10 instanceof FeedShowCaseViewModel) {
                        SensorsLogFeed sensorsLogFeed2 = SensorsLogFeed.f12208a;
                        FeedShowCaseViewModel feedShowCaseViewModel = (FeedShowCaseViewModel) a10;
                        String postId3 = feedShowCaseViewModel.getFeedModel().getPostId();
                        feedSensorContext5 = trendFeedListAdapter.f14191f;
                        SensorPosition position3 = feedSensorContext5.getPosition();
                        feedSensorContext6 = trendFeedListAdapter.f14191f;
                        SensorScene scene3 = feedSensorContext6.getScene();
                        String url2 = feedShowCaseViewModel.getFeedModel().getUrl();
                        String strategyId2 = feedShowCaseViewModel.getFeedModel().getStrategyId();
                        FeedSort x11 = g.f52734a.x();
                        int d11 = aVar.d() + 1;
                        i12 = trendFeedListAdapter.f14196k;
                        sensorsLogFeed2.D(null, postId3, position3, scene3, null, url2, strategyId2, x11, (r31 & 256) != 0 ? null : null, d11 - i12, (r31 & 1024) != 0 ? null : null, (r31 & 2048) != 0 ? null : null, (r31 & 4096) != 0 ? null : null);
                        ADMonitorHelper.f18414a.b(AppApplication.f11612d.h(), feedShowCaseViewModel.getFeedModel().getShowTrackUrlList());
                        m.f14354a.a(recyclerView2.getContext(), feedShowCaseViewModel.getFeedModel().getAdContextUrl());
                        if (function22 != null) {
                            function22.mo1743invoke(Integer.valueOf(FKExpressAdType.ShowCase.getType()), feedShowCaseViewModel.getFeedModel().getPostId());
                        }
                    }
                    if ((a10 instanceof FeedRecommendListModel) && (indexOf = trendFeedListAdapter.j().indexOf(a10)) >= 0) {
                        SensorsLogFeed sensorsLogFeed3 = SensorsLogFeed.f12208a;
                        feedSensorContext3 = trendFeedListAdapter.f14191f;
                        SensorPosition position4 = feedSensorContext3.getPosition();
                        feedSensorContext4 = trendFeedListAdapter.f14191f;
                        SensorScene scene4 = feedSensorContext4.getScene();
                        FeedSort x12 = g.f52734a.x();
                        int d12 = aVar.d() + 1;
                        i11 = trendFeedListAdapter.f14196k;
                        sensorsLogFeed3.D(null, null, position4, scene4, null, null, null, x12, (r31 & 256) != 0 ? null : null, d12 - i11, (r31 & 1024) != 0 ? null : null, (r31 & 2048) != 0 ? null : null, (r31 & 4096) != 0 ? null : null);
                        RecyclerView.ViewHolder findViewHolderForLayoutPosition2 = recyclerView2.findViewHolderForLayoutPosition(indexOf);
                        RecommendFeedEnterListViewHolder recommendFeedEnterListViewHolder = findViewHolderForLayoutPosition2 instanceof RecommendFeedEnterListViewHolder ? (RecommendFeedEnterListViewHolder) findViewHolderForLayoutPosition2 : null;
                        if (recommendFeedEnterListViewHolder != null) {
                            recommendFeedEnterListViewHolder.w();
                        }
                    }
                    if (a10 instanceof FKExpressAdModel) {
                        SensorsLogFeed sensorsLogFeed4 = SensorsLogFeed.f12208a;
                        feedSensorContext = trendFeedListAdapter.f14191f;
                        SensorPosition position5 = feedSensorContext.getPosition();
                        feedSensorContext2 = trendFeedListAdapter.f14191f;
                        SensorScene scene5 = feedSensorContext2.getScene();
                        FeedSort x13 = g.f52734a.x();
                        int d13 = aVar.d() + 1;
                        i10 = trendFeedListAdapter.f14196k;
                        sensorsLogFeed4.D(null, null, position5, scene5, null, null, null, x13, (r31 & 256) != 0 ? null : null, d13 - i10, (r31 & 1024) != 0 ? null : null, (r31 & 2048) != 0 ? null : null, (r31 & 4096) != 0 ? null : null);
                    }
                    if (a10 instanceof PostLimitFriendsModel) {
                        RecyclerView.ViewHolder findViewHolderForLayoutPosition3 = recyclerView2.findViewHolderForLayoutPosition(trendFeedListAdapter.j().indexOf(a10));
                        LimitPostViewHolder limitPostViewHolder = findViewHolderForLayoutPosition3 instanceof LimitPostViewHolder ? (LimitPostViewHolder) findViewHolderForLayoutPosition3 : null;
                        if (limitPostViewHolder != null) {
                            limitPostViewHolder.w();
                        }
                    }
                }
            }
        }, 28, null));
    }

    public final void F(@Nullable f fVar) {
        this.f14200o = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.f14199n.clear();
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onViewDetachedFromWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        TrendFeedViewHolder trendFeedViewHolder = holder instanceof TrendFeedViewHolder ? (TrendFeedViewHolder) holder : null;
        if (trendFeedViewHolder != null) {
            trendFeedViewHolder.U();
        }
    }

    public final void w(int i10) {
        this.f14196k += i10;
    }

    public final void x(boolean z10) {
        this.f14195j = z10;
    }

    public final int y() {
        return this.f14196k;
    }

    public final void z() {
        RecommendFeedEnterListViewHolder recommendFeedEnterListViewHolder = this.f14197l;
        if (recommendFeedEnterListViewHolder != null) {
            recommendFeedEnterListViewHolder.v();
        }
    }
}
