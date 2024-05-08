package com.cupidapp.live.club.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.club.adapter.ActivityListAdapter;
import com.cupidapp.live.club.model.ActivityListResult;
import com.cupidapp.live.club.model.ActivityModel;
import com.cupidapp.live.club.model.ClubBannerModel;
import com.cupidapp.live.club.model.ClubWonderfulActModel;
import com.cupidapp.live.club.viewholder.ActivityTopMenuModel;
import com.cupidapp.live.club.viewholder.ClubListTitleModel;
import com.cupidapp.live.club.viewholder.EmptyListModel;
import com.cupidapp.live.club.viewmodel.ClubListViewModel;
import com.cupidapp.live.scan.activity.ScanCodeActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActivityListFragment extends FKBaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: n */
    @NotNull
    public static final a f13535n = new a(null);

    /* renamed from: e */
    public boolean f13536e;

    /* renamed from: f */
    @Nullable
    public d f13537f;

    /* renamed from: h */
    @NotNull
    public final Lazy f13539h;

    /* renamed from: i */
    @NotNull
    public final List<ActivityOrderType> f13540i;

    /* renamed from: j */
    @NotNull
    public ActivityOrderType f13541j;

    /* renamed from: k */
    @NotNull
    public final Lazy f13542k;

    /* renamed from: l */
    @NotNull
    public final Lazy f13543l;

    /* renamed from: m */
    @NotNull
    public Map<Integer, View> f13544m = new LinkedHashMap();

    /* renamed from: g */
    @NotNull
    public final Lazy f13538g = kotlin.c.b(new Function0<SensorPosition>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$position$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SensorPosition invoke() {
            SensorPosition sensorPosition;
            Bundle arguments = ActivityListFragment.this.getArguments();
            return (arguments == null || (sensorPosition = (SensorPosition) z0.g.b(arguments, SensorPosition.class)) == null) ? SensorPosition.ClubActivity : sensorPosition;
        }
    });

    /* compiled from: ActivityListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ActivityListFragment b(a aVar, SensorPosition sensorPosition, d dVar, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                dVar = null;
            }
            return aVar.a(sensorPosition, dVar);
        }

        @NotNull
        public final ActivityListFragment a(@NotNull SensorPosition position, @Nullable d dVar) {
            kotlin.jvm.internal.s.i(position, "position");
            ActivityListFragment activityListFragment = new ActivityListFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, position);
            activityListFragment.setArguments(bundle);
            activityListFragment.f13537f = dVar;
            return activityListFragment;
        }
    }

    public ActivityListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$special$$inlined$viewModels$default$1
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
        this.f13539h = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ClubListViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f13540i = new ArrayList();
        this.f13541j = ActivityOrderType.RecommendOrder;
        this.f13542k = kotlin.c.b(new Function0<ActivityListAdapter>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$activityAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ActivityListAdapter invoke() {
                SensorPosition f12;
                ActivityOrderType activityOrderType;
                f12 = ActivityListFragment.this.f1();
                final ActivityListAdapter activityListAdapter = new ActivityListAdapter(f12);
                final ActivityListFragment activityListFragment = ActivityListFragment.this;
                activityListAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$activityAdapter$2$1$1
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
                    public final void invoke2(@Nullable Object obj) {
                        SensorPosition f13;
                        if (obj instanceof ActivityModel) {
                            ActivityModel activityModel = (ActivityModel) obj;
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, ActivityListFragment.this.getContext(), activityModel.getJumpUrl(), null, 4, null);
                            ActivityListAdapter activityListAdapter2 = activityListAdapter;
                            f13 = ActivityListFragment.this.f1();
                            activityListAdapter2.x(activityModel, f13);
                        }
                    }
                });
                activityListAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.activity_order_layout), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$activityAdapter$2$1$2
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
                        if (obj instanceof ActivityTopMenuModel) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, ActivityListFragment.this.getContext(), ((ActivityTopMenuModel) obj).getPayOrderListUrl(), null, 4, null);
                            ActivityListFragment.this.m1(SensorsLogKeyButtonClick.ClubActivityBtn.ActivityOrder);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.activity_scan_layout), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$activityAdapter$2$1$3
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
                        if (obj instanceof ActivityTopMenuModel) {
                            ActivityTopMenuModel activityTopMenuModel = (ActivityTopMenuModel) obj;
                            String myCoinUrl = activityTopMenuModel.getMyCoinUrl();
                            if (myCoinUrl == null || myCoinUrl.length() == 0) {
                                ScanCodeActivity.a.c(ScanCodeActivity.f17907u, ActivityListFragment.this.getContext(), null, 2, null);
                                ActivityListFragment.this.m1(SensorsLogKeyButtonClick.ClubActivityBtn.RichScan);
                            } else {
                                j.a.b(com.cupidapp.live.base.router.j.f12156c, ActivityListFragment.this.getContext(), activityTopMenuModel.getMyCoinUrl(), null, 4, null);
                                ActivityListFragment.this.m1(SensorsLogKeyButtonClick.ClubActivityBtn.MyCoin);
                            }
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.activity_medal_layout), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$activityAdapter$2$1$4
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
                        if (obj instanceof ActivityTopMenuModel) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, ActivityListFragment.this.getContext(), ((ActivityTopMenuModel) obj).getMedalListUrl(), null, 4, null);
                            ActivityListFragment.this.m1(SensorsLogKeyButtonClick.ClubActivityBtn.ActivityMedal);
                        }
                    }
                })));
                activityListAdapter.H(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$activityAdapter$2$1$5

                    /* compiled from: ActivityListFragment.kt */
                    @kotlin.d
                    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
                    public /* synthetic */ class a {

                        /* renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f13545a;

                        static {
                            int[] iArr = new int[ActivityOrderType.values().length];
                            try {
                                iArr[ActivityOrderType.RecommendOrder.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[ActivityOrderType.DistanceOrder.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            f13545a = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                        invoke(num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(int i10) {
                        List list;
                        ActivityOrderType activityOrderType2;
                        ActivityOrderType activityOrderType3;
                        ActivityListFragment activityListFragment2 = ActivityListFragment.this;
                        list = activityListFragment2.f13540i;
                        activityListFragment2.f13541j = (ActivityOrderType) list.get(i10);
                        ActivityListAdapter activityListAdapter2 = activityListAdapter;
                        activityOrderType2 = ActivityListFragment.this.f13541j;
                        activityListAdapter2.G(activityOrderType2);
                        activityOrderType3 = ActivityListFragment.this.f13541j;
                        int i11 = a.f13545a[activityOrderType3.ordinal()];
                        if (i11 == 1) {
                            SensorsLogKeyButtonClick.ClubActivity.Newest.click();
                        } else if (i11 == 2) {
                            SensorsLogKeyButtonClick.ClubActivity.Shortest.click();
                        }
                        ActivityListFragment.o1(ActivityListFragment.this, false, 1, null);
                    }
                });
                activityOrderType = activityListFragment.f13541j;
                activityListAdapter.G(activityOrderType);
                return activityListAdapter;
            }
        });
        this.f13543l = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final ActivityListFragment activityListFragment = ActivityListFragment.this;
                return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ActivityListFragment$loadMoreListener$2.1
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
                        ClubListViewModel g12;
                        ActivityOrderType activityOrderType;
                        g12 = ActivityListFragment.this.g1();
                        activityOrderType = ActivityListFragment.this.f13541j;
                        g12.loadMoreActivity(activityOrderType.getType());
                    }
                });
            }
        });
    }

    public static final void i1(ActivityListFragment this$0, StateResult stateResult) {
        Pair pair;
        ClubWonderfulActModel clubWonderfulActModel;
        ClubWonderfulActModel clubWonderfulActModel2;
        Boolean activityOrderUnread;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.V0(R$id.activity_list_refresh_layout)).setRefreshing(false);
        this$0.e1().c(false);
        if (stateResult instanceof StateResult.c) {
            RecyclerExposureHelper.f12092j.d(ExposureScene.ClubBannerList);
            this$0.d1().j().clear();
            Pair pair2 = (Pair) stateResult.getData();
            ActivityListResult activityListResult = pair2 != null ? (ActivityListResult) pair2.getSecond() : null;
            this$0.d1().D();
            this$0.d1().y();
            this$0.d1().d(new ActivityTopMenuModel((activityListResult == null || (activityOrderUnread = activityListResult.getActivityOrderUnread()) == null) ? false : activityOrderUnread.booleanValue(), activityListResult != null ? activityListResult.getPayOrderListUrl() : null, activityListResult != null ? activityListResult.getMedalListUrl() : null, activityListResult != null ? activityListResult.getMyCoinUrl() : null));
            Pair pair3 = (Pair) stateResult.getData();
            List<ClubBannerModel> list = (pair3 == null || (clubWonderfulActModel2 = (ClubWonderfulActModel) pair3.getFirst()) == null) ? null : clubWonderfulActModel2.getList();
            if (!(list == null || list.isEmpty()) && (pair = (Pair) stateResult.getData()) != null && (clubWonderfulActModel = (ClubWonderfulActModel) pair.getFirst()) != null) {
                this$0.d1().d(clubWonderfulActModel);
                this$0.d1().y();
            }
            ActivityListAdapter d12 = this$0.d1();
            List<ActivityOrderType> list2 = this$0.f13540i;
            ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list2, 10));
            Iterator<ActivityOrderType> iterator2 = list2.iterator2();
            while (iterator2.hasNext()) {
                String string = this$0.getString(iterator2.next().getTitle());
                kotlin.jvm.internal.s.h(string, "getString(it.title)");
                arrayList.add(string);
            }
            String string2 = this$0.getString(this$0.f13541j.getTitle());
            kotlin.jvm.internal.s.h(string2, "getString(currentOrderType.title)");
            d12.d(new ClubListTitleModel(arrayList, string2, false, 0, 12, null));
            this$0.d1().y();
            List<ActivityModel> recentList = activityListResult != null ? activityListResult.getRecentList() : null;
            if (recentList == null || recentList.isEmpty()) {
                this$0.d1().d(new EmptyListModel(R$mipmap.icon_empty_activity, R$string.empty_activity_prompt, z0.h.k(this$0) - z0.h.c(this$0, 115.0f)));
            } else {
                ActivityListAdapter d13 = this$0.d1();
                kotlin.jvm.internal.s.f(activityListResult);
                d13.e(activityListResult.getRecentList());
                String nextCursorId = activityListResult.getNextCursorId();
                boolean z10 = !(nextCursorId == null || nextCursorId.length() == 0);
                this$0.d1().d(new FKFooterViewModel(z10, false, null, 0, z10 ? 80 : 20, -1, 14, null));
            }
            this$0.d1().notifyDataSetChanged();
            View activity_fill_blank_view = this$0.V0(R$id.activity_fill_blank_view);
            kotlin.jvm.internal.s.h(activity_fill_blank_view, "activity_fill_blank_view");
            activity_fill_blank_view.setVisibility(0);
        }
    }

    public static final void j1(ActivityListFragment this$0, Pair pair) {
        FKFooterViewModel h10;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.e1().c(false);
        List<? extends Object> list = (List) pair.getFirst();
        boolean booleanValue = ((Boolean) pair.getSecond()).booleanValue();
        this$0.d1().e(list);
        if (booleanValue && (h10 = this$0.d1().h()) != null) {
            h10.setShowProgress(false);
            h10.setHeight(20);
        }
        this$0.d1().notifyDataSetChanged();
    }

    public static final void k1(ActivityListFragment this$0, Boolean bool) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(bool, "new");
        this$0.p1(bool.booleanValue());
        d dVar = this$0.f13537f;
        if (dVar != null) {
            dVar.E0(bool.booleanValue());
        }
    }

    public static /* synthetic */ void o1(ActivityListFragment activityListFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        activityListFragment.n1(z10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13544m.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13544m;
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

    public final ActivityListAdapter d1() {
        return (ActivityListAdapter) this.f13542k.getValue();
    }

    public final FKLoadMoreListener e1() {
        return (FKLoadMoreListener) this.f13543l.getValue();
    }

    public final SensorPosition f1() {
        return (SensorPosition) this.f13538g.getValue();
    }

    public final ClubListViewModel g1() {
        return (ClubListViewModel) this.f13539h.getValue();
    }

    public final void h1() {
        g1().getActivityListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActivityListFragment.i1(ActivityListFragment.this, (StateResult) obj);
            }
        });
        g1().getMoreActivityListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActivityListFragment.j1(ActivityListFragment.this, (Pair) obj);
            }
        });
        g1().getNewActivityOrder().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActivityListFragment.k1(ActivityListFragment.this, (Boolean) obj);
            }
        });
    }

    public final void l1() {
        int i10 = R$id.activity_list_recyclerview;
        RecyclerView recyclerView = (RecyclerView) V0(i10);
        recyclerView.setAdapter(d1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.addOnScrollListener(e1());
        ActivityListAdapter d12 = d1();
        RecyclerView activity_list_recyclerview = (RecyclerView) V0(i10);
        kotlin.jvm.internal.s.h(activity_list_recyclerview, "activity_list_recyclerview");
        d12.F(activity_list_recyclerview, f1());
        ((FKSwipeRefreshLayout) V0(R$id.activity_list_refresh_layout)).setOnRefreshListener(this);
        this.f13540i.clear();
        this.f13540i.add(ActivityOrderType.RecommendOrder);
        if (!LocationUtils.f12270h.a().f()) {
            this.f13540i.add(1, ActivityOrderType.DistanceOrder);
        }
        this.f13540i.add(ActivityOrderType.CommentCountOrder);
    }

    public final void m1(SensorsLogKeyButtonClick.ClubActivityBtn clubActivityBtn) {
        SensorsLogKeyButtonClick.f12211a.c(f1().getValue(), clubActivityBtn.getButtonName());
    }

    public final void n1(boolean z10) {
        RecyclerExposureHelper.f12092j.d(ExposureScene.ActivityList);
        ((FKSwipeRefreshLayout) V0(R$id.activity_list_refresh_layout)).setRefreshing(true);
        if (z10) {
            ((RecyclerView) V0(R$id.activity_list_recyclerview)).scrollToPosition(0);
        }
        g1().getActivityListData(this.f13541j.getType(), z10);
        d1().E();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_activity_list, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        n1(true);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        List<Object> j10 = d1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof ActivityModel) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            onRefresh();
            return;
        }
        Fragment parentFragment = getParentFragment();
        if ((parentFragment == null || parentFragment.isVisible()) ? false : true) {
            return;
        }
        if (this.f13536e) {
            this.f13536e = false;
            q1();
        } else {
            g1().m2525getNewActivityOrder();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        l1();
        h1();
    }

    public final void p1(boolean z10) {
        List<Object> j10 = d1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof ActivityTopMenuModel) {
                arrayList.add(obj);
            }
        }
        ActivityTopMenuModel activityTopMenuModel = (ActivityTopMenuModel) CollectionsKt___CollectionsKt.V(arrayList);
        if (activityTopMenuModel != null) {
            activityTopMenuModel.setNewOrder(z10);
            d1().notifyItemChanged(0);
        }
    }

    public final void q1() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.ActivityList);
        ((FKSwipeRefreshLayout) V0(R$id.activity_list_refresh_layout)).setRefreshing(true);
        ((RecyclerView) V0(R$id.activity_list_recyclerview)).scrollToPosition(0);
        this.f13541j = ActivityOrderType.RecommendOrder;
        g1().getActivityListData(this.f13541j.getType(), true);
        d1().E();
    }

    public final void r1(boolean z10) {
        this.f13536e = z10;
    }
}
