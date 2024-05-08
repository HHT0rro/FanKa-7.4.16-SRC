package com.cupidapp.live.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.extension.DateFormatPattern;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.model.AdFreqControlResult;
import com.cupidapp.live.base.network.model.AdType;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.CanScrollLinearLayoutManager;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.NestingRecyclerView;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.feed.adapter.TrendFeedListAdapter;
import com.cupidapp.live.feed.event.ChangeFeedTabEvent;
import com.cupidapp.live.feed.helper.FeedClickEventHelper;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder;
import com.cupidapp.live.feed.holder.TrendFeedViewHolder;
import com.cupidapp.live.feed.model.FKExpressAdModel;
import com.cupidapp.live.feed.model.FeedAlohaGuideModel;
import com.cupidapp.live.feed.model.FeedLikeResult;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.feed.model.FeedShowCaseViewModel;
import com.cupidapp.live.feed.model.FeedZoomGuideModel;
import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import com.cupidapp.live.feed.model.SponsorModel;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.startup.express.FKExpressAdManager;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.z;

/* compiled from: BaseFeedListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class BaseFeedListFragment extends FKBaseFragment implements RecommendFeedEnterListViewHolder.b, i {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f14202f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public FKExpressAdManager f14203g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14204h;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.feed.helper.j f14209m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f14210n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.liveshow.miniwindow.a f14211o;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public j f14213q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public FeedListItemClickOperate f14214r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14215s = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f14201e = kotlin.c.b(new Function0<TrendFeedListAdapter>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$feedAdapter$2

        /* compiled from: BaseFeedListFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a implements com.cupidapp.live.feed.holder.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BaseFeedListFragment f14219a;

            public a(BaseFeedListFragment baseFeedListFragment) {
                this.f14219a = baseFeedListFragment;
            }

            @Override // com.cupidapp.live.feed.holder.c
            public void a(@NotNull FeedModel model) {
                FeedListItemClickOperate feedListItemClickOperate;
                kotlin.jvm.internal.s.i(model, "model");
                feedListItemClickOperate = this.f14219a.f14214r;
                if (feedListItemClickOperate != null) {
                    feedListItemClickOperate.q(model, SensorsLogFeed.BtnName.DESCRIBE, false, false, false);
                }
            }

            @Override // com.cupidapp.live.feed.holder.c
            public void b(@NotNull String userId) {
                FeedListItemClickOperate feedListItemClickOperate;
                kotlin.jvm.internal.s.i(userId, "userId");
                feedListItemClickOperate = this.f14219a.f14214r;
                if (feedListItemClickOperate != null) {
                    feedListItemClickOperate.t(userId);
                }
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final TrendFeedListAdapter invoke() {
            FeedSensorContext s12 = BaseFeedListFragment.this.s1();
            int t12 = BaseFeedListFragment.this.t1();
            BaseFeedListFragment baseFeedListFragment = BaseFeedListFragment.this;
            return new TrendFeedListAdapter(s12, t12, baseFeedListFragment, new a(baseFeedListFragment));
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f14205i = kotlin.c.b(new Function0<Integer>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$videoAutoPlayMinHeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf(-z0.h.c(BaseFeedListFragment.this, 52.0f));
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f14206j = kotlin.c.b(new Function0<Integer>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$videoAutoPlayMaxHeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf(((z0.h.k(BaseFeedListFragment.this) * 3) / 5) - z0.h.c(BaseFeedListFragment.this, 100.0f));
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f14207k = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final BaseFeedListFragment baseFeedListFragment = BaseFeedListFragment.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$loadMoreListener$2.1
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
                    String o12 = BaseFeedListFragment.this.o1();
                    if (o12 == null || o12.length() == 0) {
                        return;
                    }
                    BaseFeedListFragment baseFeedListFragment2 = BaseFeedListFragment.this;
                    baseFeedListFragment2.C1(baseFeedListFragment2.o1());
                }
            });
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public int f14208l = -1;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public final Lazy f14212p = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = BaseFeedListFragment.this.getContext();
            Lifecycle lifecycle = BaseFeedListFragment.this.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* compiled from: BaseFeedListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements View.OnLayoutChangeListener {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f14217c;

        public a(boolean z10) {
            this.f14217c = z10;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View v2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            kotlin.jvm.internal.s.i(v2, "v");
            if (BaseFeedListFragment.this.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                BaseFeedListFragment.this.S1();
            }
            if (this.f14217c) {
                BaseFeedListFragment.this.N1();
            }
            try {
                ((NestingRecyclerView) BaseFeedListFragment.this.W0(R$id.feedRecyclerView)).removeOnLayoutChangeListener(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: BaseFeedListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.liveshow.miniwindow.a {
        public b() {
        }

        @Override // com.cupidapp.live.liveshow.miniwindow.a
        public void a(boolean z10) {
            try {
                NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) BaseFeedListFragment.this.W0(R$id.feedRecyclerView);
                RecyclerView.LayoutManager layoutManager = nestingRecyclerView != null ? nestingRecyclerView.getLayoutManager() : null;
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                Integer valueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()) : null;
                Integer valueOf2 = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()) : null;
                if (valueOf == null || valueOf2 == null) {
                    return;
                }
                List x02 = CollectionsKt___CollectionsKt.x0(new IntRange(valueOf.intValue(), valueOf2.intValue()));
                BaseFeedListFragment baseFeedListFragment = BaseFeedListFragment.this;
                Iterator<E> iterator2 = x02.iterator2();
                while (iterator2.hasNext()) {
                    int intValue = ((Number) iterator2.next()).intValue();
                    NestingRecyclerView nestingRecyclerView2 = (NestingRecyclerView) baseFeedListFragment.W0(R$id.feedRecyclerView);
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = nestingRecyclerView2 != null ? nestingRecyclerView2.findViewHolderForAdapterPosition(intValue) : null;
                    TrendFeedViewHolder trendFeedViewHolder = findViewHolderForAdapterPosition instanceof TrendFeedViewHolder ? (TrendFeedViewHolder) findViewHolderForAdapterPosition : null;
                    if (trendFeedViewHolder != null) {
                        trendFeedViewHolder.t(z10);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static final void A1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void D1(BaseFeedListFragment baseFeedListFragment, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadFeedData");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        baseFeedListFragment.C1(str);
    }

    public static final void K1(int i10, BaseFeedListFragment this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int y10 = i10 + this$0.n1().y();
        Object W = CollectionsKt___CollectionsKt.W(this$0.n1().j(), y10);
        FKExpressAdModel fKExpressAdModel = W instanceof FKExpressAdModel ? (FKExpressAdModel) W : null;
        if (fKExpressAdModel != null) {
            this$0.n1().j().remove(fKExpressAdModel);
            this$0.n1().notifyItemRemoved(y10);
        }
    }

    public static final void g1(BaseFeedListFragment this$0, int i10, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(view, "$view");
        Object W = CollectionsKt___CollectionsKt.W(this$0.n1().j(), i10);
        FKExpressAdModel fKExpressAdModel = W instanceof FKExpressAdModel ? (FKExpressAdModel) W : null;
        if (fKExpressAdModel != null) {
            fKExpressAdModel.setView(view);
        }
        this$0.n1().notifyItemChanged(i10);
    }

    public static /* synthetic */ void l1(BaseFeedListFragment baseFeedListFragment, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: feedAdapterNotifyDataSetChangedWithAutoPlayVideo");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        baseFeedListFragment.k1(z10);
    }

    public abstract void C1(@Nullable String str);

    public final void E1() {
        SensorsLogKeyButtonClick.FeedList.Vip.click();
        if (com.cupidapp.live.vip.c.f18740a.g()) {
            return;
        }
        String s2 = v.s(System.currentTimeMillis(), DateFormatPattern.YYYYMMDD);
        p1.g gVar = p1.g.f52734a;
        if (kotlin.jvm.internal.s.d(s2, gVar.m().c())) {
            return;
        }
        gVar.m().d(s2);
        PurchaseDialogManager.j(r1(), VipPurchaseEntranceType.FeedNoAd, null, null, false, 14, null);
    }

    public final void F1() {
        com.cupidapp.live.feed.helper.j jVar = this.f14209m;
        if (jVar != null) {
            jVar.j();
        }
    }

    public final void G1(final FeedModel feedModel) {
        Observable<Result<Object>> D = NetworkClient.f11868a.l().D(feedModel.getPostId());
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = D.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$recommendEnterCancelFeedLike$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FeedModel.this.cancelPraise();
                this.n1().z();
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
    public void H0(@NotNull FeedRecommendResult model, boolean z10, @NotNull FeedSensorContext sensorContext) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
        if (model.getPost() == null) {
            return;
        }
        if (z10) {
            y1(model.getPost(), UserActionType.Praise, model.getCallback());
            SensorsLogFeed.f12208a.m(model.getPost().getUser().userId(), model.getPost().getPostId(), sensorContext.getPosition(), sensorContext.getScene(), SensorsLogFeed.LikeCommentType.Feed, model.getPost().getUser().getAloha(), model.getPost().getStrategyId(), p1.g.f52734a.x());
            H1(model.getPost());
        } else {
            y1(model.getPost(), UserActionType.CancelPraise, model.getCallback());
            G1(model.getPost());
            SensorsLogFeed.f12208a.n(sensorContext.getScene(), sensorContext.getPosition(), model.getPost().getPostId(), model.getPost().getUser().userId(), model.getPost().getUser().getAloha(), model.getPost().getStrategyId(), p1.g.f52734a.x());
        }
    }

    public final void H1(final FeedModel feedModel) {
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.YouBlacklistedTheOtherPerson.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$recommendEnterFeedLike$errorCodeInterceptor$1
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
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, BaseFeedListFragment.this.getContext(), false, 2, null).n(str), 0, null, null, 7, null), null, 1, null);
            }
        }));
        Observable<Result<FeedLikeResult>> A = NetworkClient.f11868a.l().A(feedModel.getPostId());
        Object context = getContext();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$recommendEnterFeedLike$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, BaseFeedListFragment.this.getContext(), h10, null, 8, null);
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = A.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedLikeResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$recommendEnterFeedLike$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedLikeResult feedLikeResult) {
                m2558invoke(feedLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2558invoke(FeedLikeResult feedLikeResult) {
                FeedModel.this.praise();
                this.n1().z();
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

    public final void I1(@NotNull User user) {
        kotlin.jvm.internal.s.i(user, "user");
        FeedListItemClickOperate feedListItemClickOperate = this.f14214r;
        if (feedListItemClickOperate != null) {
            feedListItemClickOperate.A(user);
        }
    }

    public final void J1(final int i10) {
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) W0(R$id.feedRecyclerView);
        if (nestingRecyclerView != null) {
            nestingRecyclerView.post(new Runnable() { // from class: com.cupidapp.live.feed.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFeedListFragment.K1(i10, this);
                }
            });
        }
    }

    public final void L1(int i10) {
        this.f14208l = i10;
        if (n1().n() > i10) {
            Object obj = n1().j().get(i10);
            if (obj instanceof FeedModel) {
                FeedModel feedModel = (FeedModel) obj;
                if (feedModel.haveSponsor()) {
                    SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                    SponsorModel sponsorExtraInfo = feedModel.getSponsorExtraInfo();
                    sensorsLogFeed.G(sponsorExtraInfo != null ? sponsorExtraInfo.getUrl() : null, feedModel.getPostId());
                    return;
                }
                return;
            }
            if (obj instanceof FeedShowCaseViewModel) {
                FeedShowCaseViewModel feedShowCaseViewModel = (FeedShowCaseViewModel) obj;
                SensorsLogFeed.f12208a.g(feedShowCaseViewModel.getFeedModel().getUrl(), feedShowCaseViewModel.getFeedModel().getPostId(), s1().getPosition());
            } else if (obj instanceof FeedAlohaGuideModel) {
                SensorsLogFeed.f12208a.j();
            } else if (obj instanceof PromotionNearByGuideModel) {
                GroupOthersLog.L(GroupOthersLog.f18702a, s1().getPosition(), ((PromotionNearByGuideModel) obj).getTrackName(), null, 4, null);
            }
        }
    }

    public final void M1() {
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) W0(R$id.feedRecyclerView);
        RecyclerView.LayoutManager layoutManager = nestingRecyclerView != null ? nestingRecyclerView.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        Integer valueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()) : null;
        if (valueOf == null || valueOf.intValue() == -1) {
            return;
        }
        if (valueOf.intValue() != this.f14208l) {
            L1(valueOf.intValue());
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14215s.clear();
    }

    public final void N1() {
        int intValue;
        int intValue2;
        int i10 = R$id.feedRecyclerView;
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) W0(i10);
        RecyclerView.LayoutManager layoutManager = nestingRecyclerView != null ? nestingRecyclerView.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        Integer valueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()) : null;
        NestingRecyclerView nestingRecyclerView2 = (NestingRecyclerView) W0(i10);
        RecyclerView.LayoutManager layoutManager2 = nestingRecyclerView2 != null ? nestingRecyclerView2.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager2 = layoutManager2 instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager2 : null;
        Integer valueOf2 = linearLayoutManager2 != null ? Integer.valueOf(linearLayoutManager2.findLastVisibleItemPosition()) : null;
        if (valueOf == null || valueOf.intValue() == -1 || valueOf2 == null || valueOf2.intValue() == -1 || (intValue = valueOf.intValue()) > (intValue2 = valueOf2.intValue())) {
            return;
        }
        while (true) {
            L1(intValue);
            if (intValue == intValue2) {
                return;
            } else {
                intValue++;
            }
        }
    }

    public final void O1() {
        com.cupidapp.live.feed.helper.j jVar = this.f14209m;
        if (jVar != null) {
            jVar.m();
        }
    }

    public final void P1(@Nullable String str) {
        this.f14202f = str;
    }

    public final void Q1(@Nullable j jVar) {
        this.f14213q = jVar;
    }

    public abstract boolean R1();

    public final void S1() {
        com.cupidapp.live.feed.helper.j jVar = this.f14209m;
        if (jVar != null) {
            jVar.k();
        }
    }

    public final void T1() {
        com.cupidapp.live.feed.helper.j jVar = this.f14209m;
        if (jVar != null) {
            jVar.o();
        }
    }

    @Override // com.cupidapp.live.feed.fragment.i
    @Nullable
    public TrendFeedViewHolder V(int i10) {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((NestingRecyclerView) W0(R$id.feedRecyclerView)).findViewHolderForLayoutPosition(i10);
        if (findViewHolderForLayoutPosition instanceof TrendFeedViewHolder) {
            return (TrendFeedViewHolder) findViewHolderForLayoutPosition;
        }
        return null;
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14215s;
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

    public final void f1(final View view, int i10) {
        NestingRecyclerView nestingRecyclerView;
        final int y10 = i10 + n1().y();
        if (y10 < n1().j().size() && (nestingRecyclerView = (NestingRecyclerView) W0(R$id.feedRecyclerView)) != null) {
            nestingRecyclerView.post(new Runnable() { // from class: com.cupidapp.live.feed.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFeedListFragment.g1(BaseFeedListFragment.this, y10, view);
                }
            });
        }
    }

    public final void h1(boolean z10) {
        ((NestingRecyclerView) W0(R$id.feedRecyclerView)).addOnLayoutChangeListener(new a(z10));
    }

    public abstract boolean i1();

    public final void j1(int i10, String str) {
        Disposable disposed = NetworkClient.f11868a.l().H(i10, str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$expressAdExposure$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.feed.fragment.i
    public void k() {
        h1(false);
    }

    public final void k1(boolean z10) {
        h1(z10);
        n1().notifyDataSetChanged();
    }

    @Override // com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.b
    public void m0(@NotNull FeedRecommendResult model, @NotNull FeedSensorContext sensorContext) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
        FeedModel post = model.getPost();
        if (post != null) {
            y1(post, UserActionType.Click, model.getCallback());
            com.cupidapp.live.feed.helper.k.f14350a.a(post, false, sensorContext, false, false, null, getContext(), model.getCallback());
        }
    }

    @Nullable
    public final FeedModel m1() {
        com.cupidapp.live.feed.helper.j jVar = this.f14209m;
        if (jVar != null) {
            return jVar.d();
        }
        return null;
    }

    @Override // com.cupidapp.live.feed.fragment.i
    public void n0() {
        if (n1().j().size() == 0 || (CollectionsKt___CollectionsKt.f0(n1().j()) instanceof FKFooterViewModel)) {
            D1(this, null, 1, null);
        }
    }

    @NotNull
    public final TrendFeedListAdapter n1() {
        return (TrendFeedListAdapter) this.f14201e.getValue();
    }

    @Nullable
    public final String o1() {
        return this.f14202f;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z.b(viewGroup, R$layout.fragment_feed_list, false, 2, null);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FKExpressAdManager fKExpressAdManager = this.f14203g;
        if (fKExpressAdManager != null) {
            fKExpressAdManager.k();
        }
        FKLiveMiniWindow.f15074m.a().c0(this.f14211o);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f14210n = true;
        FKExpressAdManager fKExpressAdManager = this.f14203g;
        if (fKExpressAdManager != null) {
            fKExpressAdManager.l();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f14210n) {
            this.f14210n = false;
            FKExpressAdManager fKExpressAdManager = this.f14203g;
            if (fKExpressAdManager != null) {
                fKExpressAdManager.m();
            }
        }
        if (this.f14204h) {
            this.f14204h = false;
            Fragment parentFragment = getParentFragment();
            if ((parentFragment == null || parentFragment.isVisible()) ? false : true) {
                return;
            }
            h1(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f14204h = true;
        T1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        n1().x(i1());
        b bVar = new b();
        this.f14211o = bVar;
        FKLiveMiniWindow.f15074m.a().z(bVar);
        Lifecycle lifecycle = getLifecycle();
        kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
        Context context = getContext();
        int i10 = R$id.feedRecyclerView;
        NestingRecyclerView feedRecyclerView = (NestingRecyclerView) W0(i10);
        kotlin.jvm.internal.s.h(feedRecyclerView, "feedRecyclerView");
        this.f14214r = new FeedListItemClickOperate(getActivity(), n1(), getContext(), s1(), R1(), new FeedClickEventHelper(lifecycle, context, feedRecyclerView, i1(), s1(), null, null, new List[]{n1().j()}, 96, null), this);
        TrendFeedListAdapter n12 = n1();
        NestingRecyclerView feedRecyclerView2 = (NestingRecyclerView) W0(i10);
        kotlin.jvm.internal.s.h(feedRecyclerView2, "feedRecyclerView");
        n12.D(feedRecyclerView2, ExposureScene.Feed, new Function2<Integer, String, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$onViewCreated$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return kotlin.p.f51048a;
            }

            public final void invoke(int i11, @NotNull String adId) {
                kotlin.jvm.internal.s.i(adId, "adId");
                BaseFeedListFragment.this.j1(i11, adId);
            }
        });
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) W0(i10);
        Context context2 = nestingRecyclerView.getContext();
        kotlin.jvm.internal.s.h(context2, "context");
        nestingRecyclerView.setLayoutManager(new CanScrollLinearLayoutManager(context2, 0, false, 6, null));
        nestingRecyclerView.setAdapter(n1());
        RecyclerView.ItemAnimator itemAnimator = nestingRecyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        Context context3 = nestingRecyclerView.getContext();
        kotlin.jvm.internal.s.h(context3, "context");
        kotlin.jvm.internal.s.h(nestingRecyclerView, "this");
        this.f14209m = new com.cupidapp.live.feed.helper.j(context3, nestingRecyclerView, u1(), v1(), n1().j());
        FeedZoomGuideModel D = p1.g.f52734a.D();
        if (D != null) {
            D.initFeedZoomGuideShowPosition(t1());
        }
        nestingRecyclerView.addOnScrollListener(p1());
        p1().d(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$onViewCreated$4$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
                com.cupidapp.live.feed.helper.j jVar;
                com.cupidapp.live.feed.helper.j jVar2;
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
                if (i11 == 0) {
                    jVar = BaseFeedListFragment.this.f14209m;
                    if (jVar != null) {
                        jVar.k();
                    }
                    jVar2 = BaseFeedListFragment.this.f14209m;
                    if (jVar2 != null) {
                        jVar2.c();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
                com.cupidapp.live.feed.helper.j jVar;
                com.cupidapp.live.feed.helper.j jVar2;
                j jVar3;
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
                jVar = BaseFeedListFragment.this.f14209m;
                if (jVar != null) {
                    jVar.a();
                }
                jVar2 = BaseFeedListFragment.this.f14209m;
                if (jVar2 != null) {
                    jVar2.b();
                }
                if (i12 != 0) {
                    BaseFeedListFragment.this.M1();
                }
                jVar3 = BaseFeedListFragment.this.f14213q;
                if (jVar3 != null) {
                    jVar3.C(i12);
                }
            }
        });
        ((FKSwipeRefreshLayout) W0(R$id.feedSwipeRefreshLayout)).setEnabled(false);
        this.f14210n = false;
    }

    @NotNull
    public final FKLoadMoreListener p1() {
        return (FKLoadMoreListener) this.f14207k.getValue();
    }

    @Nullable
    public final FKExpressAdManager q1() {
        return this.f14203g;
    }

    @NotNull
    public final PurchaseDialogManager r1() {
        return (PurchaseDialogManager) this.f14212p.getValue();
    }

    @NotNull
    public abstract FeedSensorContext s1();

    public abstract int t1();

    public final int u1() {
        return ((Number) this.f14206j.getValue()).intValue();
    }

    public final int v1() {
        return ((Number) this.f14205i.getValue()).intValue();
    }

    public final void w1() {
        FeedListItemClickOperate feedListItemClickOperate = this.f14214r;
        if (feedListItemClickOperate != null) {
            feedListItemClickOperate.p();
        }
    }

    public final void x1() {
        FeedListItemClickOperate feedListItemClickOperate = this.f14214r;
        if (feedListItemClickOperate != null) {
            feedListItemClickOperate.r();
        }
    }

    @Override // com.cupidapp.live.feed.holder.RecommendFeedEnterListViewHolder.b
    public void y() {
        EventBus.c().l(new ChangeFeedTabEvent("Recommend"));
    }

    public final void y1(FeedModel feedModel, UserActionType userActionType, String str) {
        SensorPosition position = s1().getPosition();
        if (!TextUtils.isEmpty(feedModel.getStrategyId())) {
            position = SensorPosition.RecommendFeed;
        }
        SensorPosition sensorPosition = position;
        com.cupidapp.live.feed.helper.h hVar = com.cupidapp.live.feed.helper.h.f14329a;
        String postId = feedModel.getPostId();
        Integer tagId = feedModel.getTagId();
        SensorPosition source = s1().getSource();
        if (str == null) {
            str = feedModel.getPostStatisticsCallback();
        }
        hVar.e(postId, tagId, userActionType, sensorPosition, source, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : str);
    }

    @Override // com.cupidapp.live.feed.fragment.i
    public void z(@NotNull FeedModel postModel) {
        com.cupidapp.live.feed.helper.j jVar;
        kotlin.jvm.internal.s.i(postModel, "postModel");
        if (!n1().j().contains(postModel) || (jVar = this.f14209m) == null) {
            return;
        }
        jVar.l(postModel);
    }

    public final void z1(@NotNull final SensorPosition sensorPosition, final int i10) {
        kotlin.jvm.internal.s.i(sensorPosition, "sensorPosition");
        if (!com.cupidapp.live.vip.c.f18740a.i() && FKExpressAdManager.f18315g.a(sensorPosition)) {
            n1().d(new FKExpressAdModel(null, 1, null));
            if (this.f14203g == null) {
                this.f14203g = new FKExpressAdManager(new WeakReference(getActivity()), new Function2<View, Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$loadExpressAd$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(View view, Integer num) {
                        invoke(view, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@NotNull View view, int i11) {
                        kotlin.jvm.internal.s.i(view, "view");
                        BaseFeedListFragment.this.f1(view, i11);
                    }
                }, new Function2<Integer, Boolean, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$loadExpressAd$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, Boolean bool) {
                        invoke(num.intValue(), bool.booleanValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(int i11, boolean z10) {
                        BaseFeedListFragment.this.J1(i11);
                        if (z10) {
                            BaseFeedListFragment.this.E1();
                        }
                    }
                });
            }
            Observable timeout = NetworkClient.f11868a.i().k(AdType.Express.getType()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).timeout(500L, TimeUnit.MILLISECONDS);
            final Function1<AdFreqControlResult, kotlin.p> function1 = new Function1<AdFreqControlResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$loadExpressAd$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(AdFreqControlResult adFreqControlResult) {
                    invoke2(adFreqControlResult);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AdFreqControlResult adFreqControlResult) {
                    if (!adFreqControlResult.getHitControl()) {
                        FKExpressAdManager q12 = BaseFeedListFragment.this.q1();
                        if (q12 != null) {
                            q12.o(i10, sensorPosition);
                            return;
                        }
                        return;
                    }
                    BaseFeedListFragment.this.J1(i10);
                }
            };
            Consumer consumer = new Consumer() { // from class: com.cupidapp.live.feed.fragment.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BaseFeedListFragment.A1(Function1.this, obj);
                }
            };
            final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.BaseFeedListFragment$loadExpressAd$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    FKExpressAdManager q12 = BaseFeedListFragment.this.q1();
                    if (q12 != null) {
                        q12.o(i10, sensorPosition);
                    }
                }
            };
            Disposable subscribe = timeout.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.feed.fragment.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BaseFeedListFragment.B1(Function1.this, obj);
                }
            });
            kotlin.jvm.internal.s.h(subscribe, "this");
            H(subscribe);
        }
    }
}
