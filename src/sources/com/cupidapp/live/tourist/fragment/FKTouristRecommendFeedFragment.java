package com.cupidapp.live.tourist.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.decoration.StaggeredGridDecoration;
import com.cupidapp.live.feed.adapter.RecommendFeedAdapter;
import com.cupidapp.live.setting.helper.PersonalizedRecommendHelper;
import com.cupidapp.live.tourist.model.FKTouristViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;
import z3.f;

/* compiled from: FKTouristRecommendFeedFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKTouristRecommendFeedFragment extends FKBaseFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f18681j = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18682e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public FeedSensorContext f18683f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f18684g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Function0<p> f18685h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18686i = new LinkedHashMap();

    /* compiled from: FKTouristRecommendFeedFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKTouristRecommendFeedFragment a(@NotNull Function0<p> jumpToLogin) {
            s.i(jumpToLogin, "jumpToLogin");
            FKTouristRecommendFeedFragment fKTouristRecommendFeedFragment = new FKTouristRecommendFeedFragment();
            fKTouristRecommendFeedFragment.f18685h = jumpToLogin;
            return fKTouristRecommendFeedFragment;
        }
    }

    public FKTouristRecommendFeedFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.tourist.fragment.FKTouristRecommendFeedFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f18682e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(FKTouristViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.tourist.fragment.FKTouristRecommendFeedFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        SensorPosition sensorPosition = SensorPosition.RecommendFeed;
        this.f18683f = new FeedSensorContext(sensorPosition, sensorPosition, null, SensorScene.RecommendFeed);
        this.f18684g = kotlin.c.b(new Function0<RecommendFeedAdapter>() { // from class: com.cupidapp.live.tourist.fragment.FKTouristRecommendFeedFragment$recommendFeedAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RecommendFeedAdapter invoke() {
                FeedSensorContext feedSensorContext;
                feedSensorContext = FKTouristRecommendFeedFragment.this.f18683f;
                RecommendFeedAdapter recommendFeedAdapter = new RecommendFeedAdapter(feedSensorContext);
                final FKTouristRecommendFeedFragment fKTouristRecommendFeedFragment = FKTouristRecommendFeedFragment.this;
                recommendFeedAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.tourist.fragment.FKTouristRecommendFeedFragment$recommendFeedAdapter$2$1$1
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
                        Function0 function02;
                        function02 = FKTouristRecommendFeedFragment.this.f18685h;
                        if (function02 != null) {
                            function02.invoke();
                        }
                    }
                });
                return recommendFeedAdapter;
            }
        });
    }

    public static final void b1(FKTouristRecommendFeedFragment this$0, List list) {
        s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.U0(R$id.recommend_feed_refresh_layout)).setRefreshing(false);
        this$0.Y0().j().clear();
        this$0.Y0().e(list);
        this$0.Y0().notifyDataSetChanged();
    }

    public static final void d1(FKTouristRecommendFeedFragment this$0) {
        s.i(this$0, "this$0");
        this$0.Z0().getRecommendPost();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18686i.clear();
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18686i;
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

    public final RecommendFeedAdapter Y0() {
        return (RecommendFeedAdapter) this.f18684g.getValue();
    }

    public final FKTouristViewModel Z0() {
        return (FKTouristViewModel) this.f18682e.getValue();
    }

    public final void a1() {
        Y0().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
        Z0().getRecommendPost();
        Z0().getRecommendFeedLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.tourist.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKTouristRecommendFeedFragment.b1(FKTouristRecommendFeedFragment.this, (List) obj);
            }
        });
    }

    public final void c1() {
        FKTitleBarLayout initView$lambda$0 = (FKTitleBarLayout) U0(R$id.recommend_feed_title_layout);
        s.h(initView$lambda$0, "initView$lambda$0");
        FKTitleBarLayout.f(initView$lambda$0, new com.cupidapp.live.base.view.p(kotlin.collections.s.m(getString(R$string.concern), getString(PersonalizedRecommendHelper.f18179a.b())), 0.0f, 0, 0, false, 30, null), null, 1, null, 8, null);
        RecyclerView initView$lambda$1 = (RecyclerView) U0(R$id.recommend_feed_recyclerview);
        initView$lambda$1.setAdapter(Y0());
        initView$lambda$1.setLayoutManager(new StaggeredGridLayoutManager(Y0().v(), 1));
        s.h(initView$lambda$1, "initView$lambda$1");
        int c4 = h.c(initView$lambda$1, 2.0f);
        initView$lambda$1.addItemDecoration(new StaggeredGridDecoration(c4, c4, c4, c4, c4));
        RecyclerView.ItemAnimator itemAnimator = initView$lambda$1.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        ((FKSwipeRefreshLayout) U0(R$id.recommend_feed_refresh_layout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.tourist.fragment.b
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FKTouristRecommendFeedFragment.d1(FKTouristRecommendFeedFragment.this);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z.b(viewGroup, R$layout.fragment_tourist_recommend_feed, false, 2, null);
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            return;
        }
        f.f54838a.b(SensorPosition.RecommendFeed);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isHidden()) {
            return;
        }
        f.f54838a.b(SensorPosition.RecommendFeed);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        c1();
        a1();
    }
}
