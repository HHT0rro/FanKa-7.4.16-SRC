package com.cupidapp.live.feed.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.decoration.StaggeredGridDecoration;
import com.cupidapp.live.feed.adapter.RecommendFeedAdapter;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import com.cupidapp.live.feed.viewmodel.ClassifyFeedViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedClassifyFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedClassifyFragment extends FKBaseFragment {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f14030l = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public boolean f14031e;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f14035i;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14037k = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f14032f = kotlin.c.b(new Function0<ClassifyFeedViewModel>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyFragment$viewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ClassifyFeedViewModel invoke() {
            ViewModel viewModel = new ViewModelProvider(FeedClassifyFragment.this).get(ClassifyFeedViewModel.class);
            FeedClassifyFragment feedClassifyFragment = FeedClassifyFragment.this;
            ClassifyFeedViewModel classifyFeedViewModel = (ClassifyFeedViewModel) viewModel;
            Bundle arguments = feedClassifyFragment.getArguments();
            String string = arguments != null ? arguments.getString("tag_id") : null;
            Bundle arguments2 = feedClassifyFragment.getArguments();
            classifyFeedViewModel.initData(string, arguments2 != null ? arguments2.getString("tab_name") : null);
            return classifyFeedViewModel;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f14033g = kotlin.c.b(new Function0<FeedSensorContext>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyFragment$sensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FeedSensorContext invoke() {
            Bundle arguments = FeedClassifyFragment.this.getArguments();
            FeedSensorContext feedSensorContext = (FeedSensorContext) (arguments != null ? arguments.getSerializable("sensorContext") : null);
            return feedSensorContext == null ? new FeedSensorContext(SensorPosition.FindPageCategory, SensorPosition.Unknown, null, null) : feedSensorContext;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f14034h = kotlin.c.b(new Function0<RecommendFeedAdapter>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyFragment$feedAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final RecommendFeedAdapter invoke() {
            FeedSensorContext e12;
            e12 = FeedClassifyFragment.this.e1();
            RecommendFeedAdapter recommendFeedAdapter = new RecommendFeedAdapter(e12);
            final FeedClassifyFragment feedClassifyFragment = FeedClassifyFragment.this;
            recommendFeedAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyFragment$feedAdapter$2$1$1
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
                        FeedClassifyFragment.this.l1(feedRecommendResult);
                        FeedClassifyFragment.this.g1(feedRecommendResult, UserActionType.Click);
                    }
                }
            });
            recommendFeedAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.linkcountTxt), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyFragment$feedAdapter$2$1$2
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
                    ClassifyFeedViewModel f12;
                    if (obj instanceof FeedRecommendResult) {
                        f12 = FeedClassifyFragment.this.f1();
                        FeedRecommendResult feedRecommendResult = (FeedRecommendResult) obj;
                        f12.likeFeed(feedRecommendResult.getPost(), i10);
                        FeedClassifyFragment.this.k1(feedRecommendResult.getPost());
                        FeedClassifyFragment feedClassifyFragment2 = FeedClassifyFragment.this;
                        FeedModel post = feedRecommendResult.getPost();
                        feedClassifyFragment2.g1(feedRecommendResult, post != null && post.getLiked() ? UserActionType.CancelPraise : UserActionType.Praise);
                    }
                }
            })));
            return recommendFeedAdapter;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f14036j = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FeedClassifyFragment feedClassifyFragment = FeedClassifyFragment.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyFragment$loadMoreListener$2.1
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
                    ClassifyFeedViewModel f12;
                    String str2;
                    str = FeedClassifyFragment.this.f14035i;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    f12 = FeedClassifyFragment.this.f1();
                    str2 = FeedClassifyFragment.this.f14035i;
                    f12.loadFeedRcmdList(str2, true);
                }
            });
        }
    });

    /* compiled from: FeedClassifyFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedClassifyFragment a(@NotNull String tagId, @Nullable String str, @NotNull FeedSensorContext sensorContext) {
            kotlin.jvm.internal.s.i(tagId, "tagId");
            kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
            FeedClassifyFragment feedClassifyFragment = new FeedClassifyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("tag_id", tagId);
            bundle.putString("tab_name", str);
            bundle.putSerializable("sensorContext", sensorContext);
            feedClassifyFragment.setArguments(bundle);
            return feedClassifyFragment;
        }
    }

    public static final void i1(FeedClassifyFragment this$0, StateResult stateResult) {
        FKFooterViewModel h10;
        ArrayList arrayList;
        List list;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.U0(R$id.classify_feed_refresh)).setRefreshing(false);
        if (stateResult instanceof StateResult.c) {
            boolean z10 = !kotlin.jvm.internal.s.d(stateResult.isLoadMore(), Boolean.TRUE);
            ListResult listResult = (ListResult) stateResult.getData();
            if (z10) {
                this$0.c1().j().clear();
                List list2 = listResult != null ? listResult.getList() : null;
                if (list2 == null || list2.isEmpty()) {
                    this$0.c1().d(new FKEmptyViewModel(null, Integer.valueOf(R$string.empty_recommend_feed_placeholder), null, null, null, null, null, false, null, null, 1021, null));
                } else {
                    this$0.c1().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                }
            }
            List list3 = listResult != null ? listResult.getList() : null;
            if (!(list3 == null || list3.isEmpty())) {
                RecommendFeedAdapter c12 = this$0.c1();
                if (listResult == null || (list = listResult.getList()) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Object obj : list) {
                        FeedModel post = ((FeedRecommendResult) obj).getPost();
                        if ((post != null ? post.getImageListFirst() : null) != null) {
                            arrayList.add(obj);
                        }
                    }
                }
                c12.e(arrayList);
            }
            if ((listResult != null ? listResult.getNextCursorId() : null) == null && (h10 = this$0.c1().h()) != null) {
                h10.setShowProgress(false);
            }
            this$0.c1().notifyDataSetChanged();
            this$0.f14035i = listResult != null ? listResult.getNextCursorId() : null;
            this$0.d1().c(false);
            return;
        }
        if (stateResult instanceof StateResult.a) {
            this$0.d1().c(false);
        }
    }

    public static final void j1(FeedClassifyFragment this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        RecyclerExposureHelper.f12092j.d(ExposureScene.ClassifyFeed);
        this$0.f1().loadFeedRcmdList(null, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14037k.clear();
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14037k;
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

    public final RecommendFeedAdapter c1() {
        return (RecommendFeedAdapter) this.f14034h.getValue();
    }

    public final FKLoadMoreListener d1() {
        return (FKLoadMoreListener) this.f14036j.getValue();
    }

    public final FeedSensorContext e1() {
        return (FeedSensorContext) this.f14033g.getValue();
    }

    public final ClassifyFeedViewModel f1() {
        return (ClassifyFeedViewModel) this.f14032f.getValue();
    }

    public final void g1(FeedRecommendResult feedRecommendResult, UserActionType userActionType) {
        if (feedRecommendResult.getPost() == null) {
            return;
        }
        com.cupidapp.live.feed.helper.h hVar = com.cupidapp.live.feed.helper.h.f14329a;
        String postId = feedRecommendResult.getPost().getPostId();
        Integer tagId = feedRecommendResult.getPost().getTagId();
        SensorPosition position = e1().getPosition();
        SensorPosition source = e1().getSource();
        String callback = feedRecommendResult.getCallback();
        hVar.e(postId, tagId, userActionType, position, source, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : callback == null ? feedRecommendResult.getPost().getPostStatisticsCallback() : callback);
    }

    public final void h1() {
        f1().getClassifyFeedListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.feed.activity.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedClassifyFragment.i1(FeedClassifyFragment.this, (StateResult) obj);
            }
        });
        f1().getPraiseFeedEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10) {
                RecommendFeedAdapter c12;
                c12 = FeedClassifyFragment.this.c1();
                c12.notifyItemChanged(i10);
            }
        }));
    }

    public final void k1(FeedModel feedModel) {
        if (feedModel == null) {
            return;
        }
        if (feedModel.getLiked()) {
            SensorsLogFeed.f12208a.n(e1().getScene(), e1().getPosition(), feedModel.getPostId(), feedModel.getUser().userId(), feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
        } else {
            SensorsLogFeed.f12208a.m(feedModel.getUser().userId(), feedModel.getPostId(), e1().getPosition(), e1().getScene(), SensorsLogFeed.LikeCommentType.Feed, feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
        }
    }

    public final void l1(FeedRecommendResult feedRecommendResult) {
        if (feedRecommendResult.getPost() == null) {
            return;
        }
        FeedDetailActivity.Q.a(getContext(), feedRecommendResult.getPost(), false, new FeedSensorContext(SensorPosition.FeedDetail, e1().getPosition(), e1().getSource(), e1().getScene()), (r25 & 16) != 0 ? false : false, (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? null : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : feedRecommendResult.getCallback(), (r25 & 512) != 0 ? null : null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_classify, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GroupOthersLog.f18702a.c(e1().getPosition().getValue(), f1().getTab(), e1().getSource().getValue());
        if (this.f14031e) {
            return;
        }
        this.f14031e = true;
        RecommendFeedAdapter c12 = c1();
        RecyclerView classify_feed_recyclerview = (RecyclerView) U0(R$id.classify_feed_recyclerview);
        kotlin.jvm.internal.s.h(classify_feed_recyclerview, "classify_feed_recyclerview");
        c12.z(classify_feed_recyclerview, ExposureScene.ClassifyFeed, f1().getTab(), f1().getTag());
        ((FKSwipeRefreshLayout) U0(R$id.classify_feed_refresh)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.feed.activity.d
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FeedClassifyFragment.j1(FeedClassifyFragment.this);
            }
        });
        h1();
        f1().loadFeedRcmdList(null, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView onViewCreated$lambda$0 = (RecyclerView) U0(R$id.classify_feed_recyclerview);
        onViewCreated$lambda$0.setAdapter(c1());
        onViewCreated$lambda$0.setLayoutManager(new StaggeredGridLayoutManager(c1().v(), 1));
        kotlin.jvm.internal.s.h(onViewCreated$lambda$0, "onViewCreated$lambda$0");
        int c4 = z0.h.c(onViewCreated$lambda$0, 2.0f);
        onViewCreated$lambda$0.addItemDecoration(new StaggeredGridDecoration(c4, c4, c4, c4, c4));
        RecyclerView.ItemAnimator itemAnimator = onViewCreated$lambda$0.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        onViewCreated$lambda$0.addOnScrollListener(d1());
    }
}
