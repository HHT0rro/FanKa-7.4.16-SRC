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
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.club.adapter.ClubListAdapter;
import com.cupidapp.live.club.model.ClubListResult;
import com.cupidapp.live.club.model.ClubModel;
import com.cupidapp.live.club.view.SettleInClubLayout;
import com.cupidapp.live.club.viewholder.ClubListTitleModel;
import com.cupidapp.live.club.viewholder.MyClubModel;
import com.cupidapp.live.club.viewmodel.ClubListViewModel;
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
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListFragment extends FKBaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f13575e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final List<ClubOrderType> f13576f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public ClubOrderType f13577g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public ClubModel f13578h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f13579i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f13580j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13581k = new LinkedHashMap();

    public ClubListFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.club.fragment.ClubListFragment$special$$inlined$viewModels$default$1
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
        this.f13575e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ClubListViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.club.fragment.ClubListFragment$special$$inlined$viewModels$default$2
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
        ClubOrderType clubOrderType = ClubOrderType.NotJoined;
        this.f13576f = kotlin.collections.s.m(clubOrderType, ClubOrderType.All);
        this.f13577g = clubOrderType;
        this.f13579i = kotlin.c.b(new Function0<ClubListAdapter>() { // from class: com.cupidapp.live.club.fragment.ClubListFragment$clubListAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ClubListAdapter invoke() {
                ClubOrderType clubOrderType2;
                final ClubListAdapter clubListAdapter = new ClubListAdapter();
                final ClubListFragment clubListFragment = ClubListFragment.this;
                clubListAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubListFragment$clubListAdapter$2$1$1
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
                        if (obj instanceof ClubModel) {
                            ClubModel clubModel = (ClubModel) obj;
                            ClubListFragment.this.f13578h = clubModel;
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, ClubListFragment.this.getContext(), clubModel.getJumpUrl(), null, 4, null);
                            clubListAdapter.w(clubModel);
                        }
                    }
                });
                clubListAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.settle_in_club_textview), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubListFragment$clubListAdapter$2$1$2
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
                        SettleInClubLayout.f13668c.a(ClubListFragment.this.getContext());
                    }
                })));
                clubListAdapter.D(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubListFragment$clubListAdapter$2$1$3

                    /* compiled from: ClubListFragment.kt */
                    @kotlin.d
                    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
                    public /* synthetic */ class a {

                        /* renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f13582a;

                        static {
                            int[] iArr = new int[ClubOrderType.values().length];
                            try {
                                iArr[ClubOrderType.NotJoined.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[ClubOrderType.All.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            f13582a = iArr;
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
                        ClubOrderType clubOrderType3;
                        ClubOrderType clubOrderType4;
                        ClubListFragment clubListFragment2 = ClubListFragment.this;
                        list = clubListFragment2.f13576f;
                        clubListFragment2.f13577g = (ClubOrderType) list.get(i10);
                        ClubListAdapter clubListAdapter2 = clubListAdapter;
                        clubOrderType3 = ClubListFragment.this.f13577g;
                        clubListAdapter2.C(clubOrderType3);
                        clubOrderType4 = ClubListFragment.this.f13577g;
                        int i11 = a.f13582a[clubOrderType4.ordinal()];
                        if (i11 == 1) {
                            SensorsLogKeyButtonClick.ClubList.NotJoin.click();
                        } else if (i11 == 2) {
                            SensorsLogKeyButtonClick.ClubList.AllClub.click();
                        }
                        ClubListFragment.this.onRefresh();
                    }
                });
                clubOrderType2 = clubListFragment.f13577g;
                clubListAdapter.C(clubOrderType2);
                RecyclerView club_list_recyclerview = (RecyclerView) clubListFragment.V0(R$id.club_list_recyclerview);
                kotlin.jvm.internal.s.h(club_list_recyclerview, "club_list_recyclerview");
                clubListAdapter.B(club_list_recyclerview);
                return clubListAdapter;
            }
        });
        this.f13580j = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.club.fragment.ClubListFragment$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final ClubListFragment clubListFragment = ClubListFragment.this;
                return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubListFragment$loadMoreListener$2.1
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
                        ClubListViewModel d12;
                        ClubOrderType clubOrderType2;
                        d12 = ClubListFragment.this.d1();
                        clubOrderType2 = ClubListFragment.this.f13577g;
                        d12.loadMoreClub(clubOrderType2.getType());
                    }
                });
            }
        });
    }

    public static final void f1(ClubListFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.V0(R$id.club_list_refresh_layout)).setRefreshing(false);
        this$0.c1().c(false);
        if (stateResult instanceof StateResult.c) {
            this$0.b1().j().clear();
            ClubListResult clubListResult = (ClubListResult) stateResult.getData();
            List<ClubModel> mineList = clubListResult != null ? clubListResult.getMineList() : null;
            if (!(mineList == null || mineList.isEmpty())) {
                this$0.b1().d(new MyClubModel(mineList));
            }
            ClubListResult clubListResult2 = (ClubListResult) stateResult.getData();
            List<ClubModel> sameCityList = clubListResult2 != null ? clubListResult2.getSameCityList() : null;
            if (!(sameCityList == null || sameCityList.isEmpty())) {
                ClubListAdapter b12 = this$0.b1();
                List<ClubOrderType> list = this$0.f13576f;
                ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
                Iterator<ClubOrderType> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    String string = this$0.getString(iterator2.next().getTitle());
                    kotlin.jvm.internal.s.h(string, "getString(it.title)");
                    arrayList.add(string);
                }
                String string2 = this$0.getString(this$0.f13577g.getTitle());
                kotlin.jvm.internal.s.h(string2, "getString(currentOrderType.title)");
                b12.d(new ClubListTitleModel(arrayList, string2, true, !(mineList == null || mineList.isEmpty()) ? 0 : z0.h.c(this$0, 16.0f)));
                this$0.b1().e(sameCityList);
                String nextCursorId = ((ClubListResult) stateResult.getData()).getNextCursorId();
                boolean z10 = !(nextCursorId == null || nextCursorId.length() == 0);
                this$0.b1().d(new FKFooterViewModel(z10, false, null, 0, z10 ? 80 : 20, -1, 14, null));
            }
            this$0.b1().notifyDataSetChanged();
            View club_fill_blank_view = this$0.V0(R$id.club_fill_blank_view);
            kotlin.jvm.internal.s.h(club_fill_blank_view, "club_fill_blank_view");
            club_fill_blank_view.setVisibility((sameCityList == null || sameCityList.isEmpty()) ^ true ? 0 : 8);
        }
    }

    public static final void g1(ClubListFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.k1(list);
        List<Object> j10 = this$0.b1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof MyClubModel) {
                arrayList.add(obj);
            }
        }
        MyClubModel myClubModel = (MyClubModel) CollectionsKt___CollectionsKt.V(arrayList);
        if (list == null || list.isEmpty()) {
            if (myClubModel != null) {
                this$0.b1().j().remove(myClubModel);
                this$0.b1().notifyItemRemoved(0);
                this$0.j1(false);
                return;
            }
            return;
        }
        if (myClubModel == null) {
            this$0.b1().j().add(0, new MyClubModel(list));
            this$0.b1().notifyItemInserted(0);
            this$0.j1(true);
        } else {
            myClubModel.setClubList(list);
            this$0.b1().notifyItemChanged(0);
        }
    }

    public static final void h1(ClubListFragment this$0, Pair pair) {
        FKFooterViewModel h10;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.c1().c(false);
        List<? extends Object> list = (List) pair.getFirst();
        boolean booleanValue = ((Boolean) pair.getSecond()).booleanValue();
        this$0.b1().e(list);
        if (booleanValue && (h10 = this$0.b1().h()) != null) {
            h10.setShowProgress(false);
            h10.setHeight(20);
        }
        this$0.b1().notifyDataSetChanged();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13581k.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13581k;
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

    public final ClubListAdapter b1() {
        return (ClubListAdapter) this.f13579i.getValue();
    }

    public final FKLoadMoreListener c1() {
        return (FKLoadMoreListener) this.f13580j.getValue();
    }

    public final ClubListViewModel d1() {
        return (ClubListViewModel) this.f13575e.getValue();
    }

    public final void e1() {
        d1().getClubListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubListFragment.f1(ClubListFragment.this, (StateResult) obj);
            }
        });
        d1().getMuClubLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubListFragment.g1(ClubListFragment.this, (List) obj);
            }
        });
        d1().getMoreClubListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubListFragment.h1(ClubListFragment.this, (Pair) obj);
            }
        });
    }

    public final void i1() {
        RecyclerView recyclerView = (RecyclerView) V0(R$id.club_list_recyclerview);
        recyclerView.setAdapter(b1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.addOnScrollListener(c1());
        ((FKSwipeRefreshLayout) V0(R$id.club_list_refresh_layout)).setOnRefreshListener(this);
    }

    public final void j1(boolean z10) {
        List<Object> j10 = b1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof ClubListTitleModel) {
                arrayList.add(obj);
            }
        }
        ClubListTitleModel clubListTitleModel = (ClubListTitleModel) CollectionsKt___CollectionsKt.V(arrayList);
        if (clubListTitleModel != null) {
            clubListTitleModel.setTopMargin(z10 ? 0 : z0.h.c(this, 16.0f));
            b1().notifyItemChanged(b1().j().indexOf(clubListTitleModel));
        }
    }

    public final void k1(List<ClubModel> list) {
        if (this.f13577g == ClubOrderType.NotJoined) {
            if ((list == null || list.isEmpty()) || this.f13578h == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
            Iterator<ClubModel> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().getGroupId());
            }
            ClubModel clubModel = this.f13578h;
            kotlin.jvm.internal.s.f(clubModel);
            if (arrayList.contains(clubModel.getGroupId())) {
                List<Object> j10 = b1().j();
                ClubModel clubModel2 = this.f13578h;
                kotlin.jvm.internal.s.f(clubModel2);
                if (j10.contains(clubModel2)) {
                    List<Object> j11 = b1().j();
                    ClubModel clubModel3 = this.f13578h;
                    kotlin.jvm.internal.s.f(clubModel3);
                    int indexOf = j11.indexOf(clubModel3);
                    b1().j().remove(indexOf);
                    b1().notifyItemRemoved(indexOf);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_club_list, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.ClubList);
        ((FKSwipeRefreshLayout) V0(R$id.club_list_refresh_layout)).setRefreshing(true);
        ClubListViewModel.getClubListData$default(d1(), null, this.f13577g.getType(), 1, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        List<Object> j10 = b1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof ClubModel) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            onRefresh();
        } else {
            d1().getMyClub();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        i1();
        e1();
    }
}
