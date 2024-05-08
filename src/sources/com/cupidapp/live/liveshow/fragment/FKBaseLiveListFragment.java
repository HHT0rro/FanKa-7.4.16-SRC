package com.cupidapp.live.liveshow.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.NestingRecyclerView;
import com.cupidapp.live.liveshow.adapter.FKBaseLiveListAdapter;
import com.cupidapp.live.liveshow.fragment.d;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveTabConfigModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKBaseLiveListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKBaseLiveListFragment extends FKBaseFragment implements d {

    /* renamed from: f */
    @Nullable
    public String f14991f;

    /* renamed from: h */
    @NotNull
    public Map<Integer, View> f14993h = new LinkedHashMap();

    /* renamed from: e */
    @NotNull
    public final Lazy f14990e = kotlin.c.b(new Function0<FKBaseLiveListAdapter>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment$liveListAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKBaseLiveListAdapter invoke() {
            final FKBaseLiveListAdapter fKBaseLiveListAdapter = new FKBaseLiveListAdapter();
            final FKBaseLiveListFragment fKBaseLiveListFragment = FKBaseLiveListFragment.this;
            fKBaseLiveListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment$liveListAdapter$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (obj instanceof LiveShowModel) {
                        List<Object> j10 = FKBaseLiveListAdapter.this.j();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : j10) {
                            if (obj2 instanceof LiveShowModel) {
                                arrayList.add(obj2);
                            }
                        }
                        if (arrayList.contains(obj)) {
                            fKBaseLiveListFragment.c1((LiveShowModel) obj, arrayList.indexOf(obj) + 1);
                        }
                    }
                }
            });
            return fKBaseLiveListAdapter;
        }
    });

    /* renamed from: g */
    @NotNull
    public final Lazy f14992g = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FKBaseLiveListFragment fKBaseLiveListFragment = FKBaseLiveListFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment$loadMoreListener$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    String str2;
                    str = FKBaseLiveListFragment.this.f14991f;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    FKBaseLiveListFragment fKBaseLiveListFragment2 = FKBaseLiveListFragment.this;
                    str2 = fKBaseLiveListFragment2.f14991f;
                    fKBaseLiveListFragment2.W0(str2);
                }
            });
        }
    });

    public static /* synthetic */ void X0(FKBaseLiveListFragment fKBaseLiveListFragment, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLiveList");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        fKBaseLiveListFragment.W0(str);
    }

    public static final void b1(FKBaseLiveListFragment this$0) {
        s.i(this$0, "this$0");
        this$0.d1();
        X0(this$0, null, 1, null);
    }

    @Override // com.cupidapp.live.liveshow.fragment.d
    public void G0() {
        d1();
        FKSwipeRefreshLayout fKSwipeRefreshLayout = (FKSwipeRefreshLayout) T0(R$id.liveListRefreshLayout);
        if (fKSwipeRefreshLayout != null) {
            fKSwipeRefreshLayout.setRefreshing(true);
        }
        X0(this, null, 1, null);
    }

    @Override // com.cupidapp.live.liveshow.fragment.d
    public void K0() {
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) T0(R$id.liveListRecyclerView);
        if (nestingRecyclerView != null) {
            nestingRecyclerView.scrollToPosition(0);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14993h.clear();
    }

    @Override // com.cupidapp.live.liveshow.fragment.d
    public void O(@NotNull LiveTabConfigModel liveTabConfigModel) {
        d.a.a(this, liveTabConfigModel);
    }

    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14993h;
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

    public final void V0(@Nullable String str, @Nullable String str2, @Nullable List<LiveShowModel> list) {
        this.f14991f = str2;
        if (str == null) {
            Y0().j().clear();
            Y0().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
        }
        Y0().e(list);
        if (str2 == null || str2.length() == 0) {
            Y0().s();
        }
        Y0().notifyDataSetChanged();
        ((FKSwipeRefreshLayout) T0(R$id.liveListRefreshLayout)).setRefreshing(false);
        Z0().c(false);
    }

    public abstract void W0(@Nullable String str);

    @NotNull
    public final FKBaseLiveListAdapter Y0() {
        return (FKBaseLiveListAdapter) this.f14990e.getValue();
    }

    public final FKLoadMoreListener Z0() {
        return (FKLoadMoreListener) this.f14992g.getValue();
    }

    public final void a1() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment$initView$manager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                return FKBaseLiveListFragment.this.Y0().u(i10);
            }
        });
        FKBaseLiveListAdapter Y0 = Y0();
        int i10 = R$id.liveListRecyclerView;
        NestingRecyclerView liveListRecyclerView = (NestingRecyclerView) T0(i10);
        s.h(liveListRecyclerView, "liveListRecyclerView");
        Y0.y(liveListRecyclerView);
        NestingRecyclerView initView$lambda$1 = (NestingRecyclerView) T0(i10);
        initView$lambda$1.setAdapter(Y0());
        initView$lambda$1.setLayoutManager(gridLayoutManager);
        FKBaseLiveListAdapter Y02 = Y0();
        s.h(initView$lambda$1, "initView$lambda$1");
        initView$lambda$1.addItemDecoration(new MutableColumnDecoration(Y02, h.c(initView$lambda$1, 10.0f)));
        initView$lambda$1.addOnScrollListener(Z0());
        ((FKSwipeRefreshLayout) T0(R$id.liveListRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.liveshow.fragment.a
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FKBaseLiveListFragment.b1(FKBaseLiveListFragment.this);
            }
        });
    }

    public abstract void c1(@NotNull LiveShowModel liveShowModel, int i10);

    public final void d1() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.LiveNearby);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_base_live_list, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        a1();
    }
}
