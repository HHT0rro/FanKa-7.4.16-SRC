package com.cupidapp.live.feed.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.decoration.StaggeredGridDecoration;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.adapter.FeedClassifyModel;
import com.cupidapp.live.feed.adapter.RecommendFeedAdapter;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.holder.AdTagPostUiModel;
import com.cupidapp.live.feed.holder.FeedClassifyListModel;
import com.cupidapp.live.feed.model.FeedLikeResult;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRcmdType;
import com.cupidapp.live.feed.model.FeedRecommendListResult;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.liveshow.model.AdModel;
import com.cupidapp.live.liveshow.model.AdViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedRecommendFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRecommendFragment extends FKBaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public FeedSensorContext f14250e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f14251f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f14252g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f14253h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14254i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public j f14255j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14256k = new LinkedHashMap();

    public FeedRecommendFragment() {
        SensorPosition sensorPosition = SensorPosition.RecommendFeed;
        this.f14250e = new FeedSensorContext(sensorPosition, sensorPosition, null, SensorScene.RecommendFeed);
        this.f14251f = kotlin.c.b(new Function0<RecommendFeedAdapter>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$recommendFeedAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RecommendFeedAdapter invoke() {
                FeedSensorContext feedSensorContext;
                feedSensorContext = FeedRecommendFragment.this.f14250e;
                return new RecommendFeedAdapter(feedSensorContext);
            }
        });
        this.f14253h = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final FeedRecommendFragment feedRecommendFragment = FeedRecommendFragment.this;
                return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$loadMoreListener$2.1
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
                        String str;
                        String str2;
                        str = FeedRecommendFragment.this.f14252g;
                        if (str == null || str.length() == 0) {
                            return;
                        }
                        FeedRecommendFragment feedRecommendFragment2 = FeedRecommendFragment.this;
                        str2 = feedRecommendFragment2.f14252g;
                        feedRecommendFragment2.m1(str2);
                    }
                });
            }
        });
    }

    public static /* synthetic */ void n1(FeedRecommendFragment feedRecommendFragment, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        feedRecommendFragment.m1(str);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14256k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.RecommendFeed;
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14256k;
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

    public final void e1(final FeedModel feedModel, final int i10) {
        Observable<Result<Object>> D = NetworkClient.f11868a.l().D(feedModel.getPostId());
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = D.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$cancelFeedLike$$inlined$handleByContext$default$1
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
                RecommendFeedAdapter h12;
                FeedModel.this.cancelPraise();
                h12 = this.h1();
                h12.notifyItemChanged(i10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        SensorsLogFeed.f12208a.n(this.f14250e.getScene(), this.f14250e.getPosition(), feedModel.getPostId(), feedModel.getUser().userId(), feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
    }

    public final void f1(final FeedModel feedModel, final int i10) {
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.YouBlacklistedTheOtherPerson.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$feedLike$errorCodeInterceptor$1
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
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, FeedRecommendFragment.this.getContext(), false, 2, null).n(str), 0, null, null, 7, null), null, 1, null);
            }
        }));
        Observable<Result<FeedLikeResult>> A = NetworkClient.f11868a.l().A(feedModel.getPostId());
        Object context = getContext();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$feedLike$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, FeedRecommendFragment.this.getContext(), h10, null, 8, null);
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = A.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedLikeResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$feedLike$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedLikeResult feedLikeResult) {
                m2566invoke(feedLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2566invoke(FeedLikeResult feedLikeResult) {
                RecommendFeedAdapter h12;
                FeedModel.this.praise();
                h12 = this.h1();
                h12.notifyItemChanged(i10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        SensorsLogFeed.f12208a.m(feedModel.getUser().userId(), feedModel.getPostId(), this.f14250e.getPosition(), this.f14250e.getScene(), SensorsLogFeed.LikeCommentType.Feed, feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
    }

    public final FKLoadMoreListener g1() {
        return (FKLoadMoreListener) this.f14253h.getValue();
    }

    public final RecommendFeedAdapter h1() {
        return (RecommendFeedAdapter) this.f14251f.getValue();
    }

    public final void i1(FeedModel feedModel, UserActionType userActionType, String str) {
        com.cupidapp.live.feed.helper.h hVar = com.cupidapp.live.feed.helper.h.f14329a;
        String postId = feedModel.getPostId();
        Integer tagId = feedModel.getTagId();
        SensorPosition position = this.f14250e.getPosition();
        SensorPosition source = this.f14250e.getSource();
        if (str == null) {
            str = feedModel.getPostStatisticsCallback();
        }
        hVar.e(postId, tagId, userActionType, position, source, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : str);
    }

    public final void j1() {
        h1().l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$initAdapterClickListener$1
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
                if (obj instanceof FeedRecommendResult) {
                    FeedRecommendResult feedRecommendResult = (FeedRecommendResult) obj;
                    FeedModel post = feedRecommendResult.getPost();
                    if (post != null) {
                        FeedRecommendFragment feedRecommendFragment = FeedRecommendFragment.this;
                        feedRecommendFragment.r1(post, feedRecommendResult.getCallback());
                        feedRecommendFragment.i1(post, UserActionType.Click, feedRecommendResult.getCallback());
                        return;
                    }
                    return;
                }
                if (obj instanceof AdTagPostUiModel) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, FeedRecommendFragment.this.getContext(), ((AdTagPostUiModel) obj).getJumpUrl(), null, 4, null);
                }
            }
        });
        h1().l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.recommendCoverImageView), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$initAdapterClickListener$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                FeedRecommendResult feedRecommendResult;
                FeedModel post;
                if (!(obj instanceof FeedRecommendResult) || (post = (feedRecommendResult = (FeedRecommendResult) obj).getPost()) == null) {
                    return;
                }
                FeedRecommendFragment feedRecommendFragment = FeedRecommendFragment.this;
                feedRecommendFragment.r1(post, feedRecommendResult.getCallback());
                feedRecommendFragment.i1(post, UserActionType.Click, feedRecommendResult.getCallback());
            }
        }), kotlin.f.a(Integer.valueOf(R$id.linkcountTxt), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$initAdapterClickListener$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                FeedRecommendResult feedRecommendResult;
                FeedModel post;
                if (!(obj instanceof FeedRecommendResult) || (post = (feedRecommendResult = (FeedRecommendResult) obj).getPost()) == null) {
                    return;
                }
                FeedRecommendFragment feedRecommendFragment = FeedRecommendFragment.this;
                if (post.getLiked()) {
                    feedRecommendFragment.e1(post, i10);
                    feedRecommendFragment.i1(post, UserActionType.CancelPraise, feedRecommendResult.getCallback());
                } else {
                    feedRecommendFragment.f1(post, i10);
                    feedRecommendFragment.i1(post, UserActionType.Praise, feedRecommendResult.getCallback());
                }
            }
        })));
    }

    public final void k1() {
        int i10 = R$id.recommendFeedRefreshLayout;
        ((FKSwipeRefreshLayout) S0(i10)).setOnRefreshListener(this);
        ((FKSwipeRefreshLayout) S0(i10)).setProgressViewOffset(false, 0, z0.h.c(this, 70.0f));
        ((FKSwipeRefreshLayout) S0(i10)).setColorSchemeColors(-15066598);
    }

    public final void l1() {
        j1();
        RecommendFeedAdapter h12 = h1();
        int i10 = R$id.recommendFeedRecyclerView;
        RecyclerView recommendFeedRecyclerView = (RecyclerView) S0(i10);
        kotlin.jvm.internal.s.h(recommendFeedRecyclerView, "recommendFeedRecyclerView");
        RecommendFeedAdapter.A(h12, recommendFeedRecyclerView, ExposureScene.FeedRecommend, null, null, 12, null);
        RecyclerView initView$lambda$0 = (RecyclerView) S0(i10);
        initView$lambda$0.setAdapter(h1());
        initView$lambda$0.setLayoutManager(new StaggeredGridLayoutManager(h1().v(), 1));
        kotlin.jvm.internal.s.h(initView$lambda$0, "initView$lambda$0");
        int c4 = z0.h.c(initView$lambda$0, 2.0f);
        initView$lambda$0.addItemDecoration(new StaggeredGridDecoration(c4, c4, c4, c4, c4));
        RecyclerView.ItemAnimator itemAnimator = initView$lambda$0.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        initView$lambda$0.addOnScrollListener(g1());
        g1().d(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$initView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i11) {
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
                j jVar;
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
                jVar = FeedRecommendFragment.this.f14255j;
                if (jVar != null) {
                    jVar.C(i12);
                }
            }
        });
    }

    public final void m1(final String str) {
        Disposable disposed = NetworkClient.f11868a.l().K(str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedRecommendListResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$loadFeedData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedRecommendListResult feedRecommendListResult) {
                m2567invoke(feedRecommendListResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2567invoke(FeedRecommendListResult feedRecommendListResult) {
                RecommendFeedAdapter h12;
                RecommendFeedAdapter h13;
                RecommendFeedAdapter h14;
                FKLoadMoreListener g12;
                RecommendFeedAdapter h15;
                RecommendFeedAdapter h16;
                RecommendFeedAdapter h17;
                RecommendFeedAdapter h18;
                RecommendFeedAdapter h19;
                RecommendFeedAdapter h110;
                RecommendFeedAdapter h111;
                RecommendFeedAdapter h112;
                RecommendFeedAdapter h113;
                FeedRecommendListResult feedRecommendListResult2 = feedRecommendListResult;
                h12 = FeedRecommendFragment.this.h1();
                int n10 = h12.n();
                if (str == null) {
                    ((FKSwipeRefreshLayout) FeedRecommendFragment.this.S0(R$id.recommendFeedRefreshLayout)).setRefreshing(false);
                    h19 = FeedRecommendFragment.this.h1();
                    h19.j().clear();
                    h110 = FeedRecommendFragment.this.h1();
                    h110.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                    List<AdModel> adList = feedRecommendListResult2.getAdList();
                    if (!(adList == null || adList.isEmpty())) {
                        h113 = FeedRecommendFragment.this.h1();
                        h113.d(new AdViewModel(feedRecommendListResult2.getAdList()));
                    }
                    List<FeedClassifyModel> tagList = feedRecommendListResult2.getTagList();
                    if (!(tagList == null || tagList.isEmpty())) {
                        h112 = FeedRecommendFragment.this.h1();
                        h112.d(new FeedClassifyListModel(feedRecommendListResult2.getTagList()));
                    }
                    List<FeedRecommendResult> list = feedRecommendListResult2.getList();
                    if (list == null || list.isEmpty()) {
                        h111 = FeedRecommendFragment.this.h1();
                        h111.d(new FKEmptyViewModel(null, Integer.valueOf(R$string.empty_recommend_feed_placeholder), null, null, null, null, null, false, null, null, 1021, null));
                    }
                }
                List<FeedRecommendResult> list2 = feedRecommendListResult2.getList();
                if (!(list2 == null || list2.isEmpty())) {
                    for (FeedRecommendResult feedRecommendResult : feedRecommendListResult2.getList()) {
                        if (kotlin.jvm.internal.s.d(feedRecommendResult.getType(), FeedRcmdType.AdTagPost.getValue())) {
                            h17 = FeedRecommendFragment.this.h1();
                            h17.d(new AdTagPostUiModel(feedRecommendResult.getImage(), feedRecommendResult.getTabList(), feedRecommendResult.getJumpUrl()));
                        } else {
                            FeedModel post = feedRecommendResult.getPost();
                            if ((post != null ? post.getImageListFirst() : null) != null) {
                                h18 = FeedRecommendFragment.this.h1();
                                h18.d(feedRecommendResult);
                            }
                        }
                    }
                }
                String nextCursorId = feedRecommendListResult2.getNextCursorId();
                if (nextCursorId == null || nextCursorId.length() == 0) {
                    h16 = FeedRecommendFragment.this.h1();
                    FKFooterViewModel h10 = h16.h();
                    if (h10 != null) {
                        h10.setShowProgress(false);
                    }
                }
                if (str == null) {
                    h15 = FeedRecommendFragment.this.h1();
                    h15.notifyDataSetChanged();
                } else {
                    h13 = FeedRecommendFragment.this.h1();
                    int size = h13.j().size() - n10;
                    h14 = FeedRecommendFragment.this.h1();
                    h14.notifyItemRangeChanged(n10, size);
                }
                g12 = FeedRecommendFragment.this.g1();
                g12.c(false);
                FeedRecommendFragment.this.f14252g = feedRecommendListResult2.getNextCursorId();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.FeedRecommendFragment$loadFeedData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener g12;
                kotlin.jvm.internal.s.i(it, "it");
                if (String.this == null) {
                    ((FKSwipeRefreshLayout) this.S0(R$id.recommendFeedRefreshLayout)).setRefreshing(false);
                }
                g12 = this.g1();
                g12.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void o1() {
        RecyclerView recyclerView = (RecyclerView) S0(R$id.recommendFeedRecyclerView);
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_recommend_feed, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.FeedRecommend);
        ((FKSwipeRefreshLayout) S0(R$id.recommendFeedRefreshLayout)).setRefreshing(true);
        n1(this, null, 1, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f14254i) {
            return;
        }
        this.f14254i = true;
        n1(this, null, 1, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        l1();
        k1();
    }

    public final void p1() {
        if (((RecyclerView) S0(R$id.recommendFeedRecyclerView)) == null) {
            return;
        }
        o1();
        onRefresh();
    }

    public final void q1(@Nullable j jVar) {
        this.f14255j = jVar;
    }

    public final void r1(FeedModel feedModel, String str) {
        FeedDetailActivity.Q.a(getContext(), feedModel, false, new FeedSensorContext(SensorPosition.FeedDetail, this.f14250e.getPosition(), this.f14250e.getSource(), this.f14250e.getScene()), (r25 & 16) != 0 ? false : false, (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? null : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : str, (r25 & 512) != 0 ? null : null);
    }
}
