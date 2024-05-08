package com.cupidapp.live.match.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.filter.view.FilterItemModel;
import com.cupidapp.live.filter.view.FilterTabLayout;
import com.cupidapp.live.match.activity.MapFilterNewActivity;
import com.cupidapp.live.match.adapter.MatchFilterViewPagerAdapter;
import com.cupidapp.live.match.event.ChooseAreaResultEvent;
import com.cupidapp.live.match.event.RangSliderTouchStartEvent;
import com.cupidapp.live.match.event.RangSliserTouchEndEvent;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.FilterRcmdMBTIEvent;
import com.cupidapp.live.match.model.FilterRcmdMBTITypeModel;
import com.cupidapp.live.match.model.FilterTabKey;
import com.cupidapp.live.match.model.FilterTabModel;
import com.cupidapp.live.match.model.FilterUiModel;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.model.OpenMapFilterEvent;
import com.cupidapp.live.match.model.OptionFilterUiModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.model.UpdateFilterKeyWordEvent;
import com.cupidapp.live.match.viewmodel.MatchFilterViewModel;
import com.cupidapp.live.push.event.RouterUrlJumperSelectMainTabEvent;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterFragment extends FKBaseFragment implements com.cupidapp.live.filter.view.b {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f16692k = new a(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16698j = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f16693e = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(MatchFilterViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.fragment.MatchFilterFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            kotlin.jvm.internal.s.h(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            kotlin.jvm.internal.s.h(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.fragment.MatchFilterFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            kotlin.jvm.internal.s.h(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f16694f = kotlin.c.b(new Function0<MatchFilterTransModel>() { // from class: com.cupidapp.live.match.fragment.MatchFilterFragment$transModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final MatchFilterTransModel invoke() {
            Bundle arguments = MatchFilterFragment.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("data_trans") : null;
            if (serializable instanceof MatchFilterTransModel) {
                return (MatchFilterTransModel) serializable;
            }
            return null;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f16695g = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.match.fragment.MatchFilterFragment$purchaseManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = MatchFilterFragment.this.getContext();
            Lifecycle lifecycle = MatchFilterFragment.this.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "this.lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f16696h = kotlin.c.b(new Function0<MatchFilterViewPagerAdapter>() { // from class: com.cupidapp.live.match.fragment.MatchFilterFragment$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final MatchFilterViewPagerAdapter invoke() {
            MatchFilterTransModel a12;
            a12 = MatchFilterFragment.this.a1();
            return new MatchFilterViewPagerAdapter(a12 != null ? a12.getNeedPurchaseFirst() : true);
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f16697i = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.match.fragment.MatchFilterFragment$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(MatchFilterFragment.this);
        }
    });

    /* compiled from: MatchFilterFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MatchFilterFragment a(@NotNull MatchFilterTransModel model) {
            kotlin.jvm.internal.s.i(model, "model");
            MatchFilterFragment matchFilterFragment = new MatchFilterFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_trans", model);
            matchFilterFragment.setArguments(bundle);
            return matchFilterFragment;
        }
    }

    public static final void f1(MatchFilterFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.a) {
            this$0.Q0();
            return;
        }
        if (stateResult instanceof StateResult.b) {
            this$0.R0();
            return;
        }
        if (stateResult instanceof StateResult.c) {
            this$0.Q0();
            List list = (List) stateResult.getData();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                this$0.X0().j().clear();
                int i10 = 0;
                for (Object obj : list) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        kotlin.collections.s.s();
                    }
                    FilterUiModel filterUiModel = (FilterUiModel) obj;
                    MatchFilterTransModel a12 = this$0.a1();
                    String defaultTab = a12 != null ? a12.getDefaultTab() : null;
                    boolean z10 = true;
                    if (!(defaultTab == null || defaultTab.length() == 0) || !kotlin.jvm.internal.s.d(filterUiModel.getTabKey(), MatchFilterViewModel.Companion.a())) {
                        MatchFilterTransModel a13 = this$0.a1();
                        if (!kotlin.jvm.internal.s.d(a13 != null ? a13.getDefaultTab() : null, filterUiModel.getTabKey())) {
                            z10 = false;
                        }
                    }
                    arrayList.add(new FilterItemModel(filterUiModel.getTabName(), filterUiModel.getTabKey(), z10));
                    this$0.X0().j().add(filterUiModel);
                    i10 = i11;
                }
                this$0.X0().notifyDataSetChanged();
                ((FilterTabLayout) this$0.U0(R$id.filter_tab)).i(arrayList, this$0);
            }
        }
    }

    public static final void g1(MatchFilterFragment this$0, MatchSettingResult matchSettingResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        p1.g gVar = p1.g.f52734a;
        ConstantsResult q10 = gVar.q();
        if (q10 != null) {
            q10.setMatchFilterSettingType(matchSettingResult.getMatchFilterSettingType());
        }
        if (q10 != null) {
            q10.setNearbyFilterSettingType(matchSettingResult.getNearbyFilterSettingType());
        }
        gVar.b2(q10);
        gVar.l0().d(matchSettingResult);
        gVar.Y1(true);
        MatchFilterTransModel a12 = this$0.a1();
        if (a12 != null && a12.getBackToMainActivity()) {
            this$0.c1();
            return;
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.cupidapp.live.filter.view.b
    public void I0(@NotNull FilterItemModel tab) {
        SensorPosition sensorPosition;
        kotlin.jvm.internal.s.i(tab, "tab");
        Iterator<Object> iterator2 = X0().j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            }
            Object next = iterator2.next();
            if ((next instanceof FilterUiModel) && kotlin.jvm.internal.s.d(tab.getKey(), ((FilterUiModel) next).getTabKey())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 > -1) {
            ((ViewPager2) U0(R$id.filter_viewpager)).setCurrentItem(i10, false);
        }
        b1().changeMBTITestEntranceShow(kotlin.jvm.internal.s.d(tab.getKey(), FilterTabKey.MBTI.getValue()));
        GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
        MatchFilterTransModel a12 = a1();
        if (a12 == null || (sensorPosition = a12.getSensorPosition()) == null) {
            sensorPosition = SensorPosition.Unknown;
        }
        groupOthersLog.Q(sensorPosition.getValue(), tab.getKey());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16698j.clear();
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16698j;
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

    public final MatchFilterViewPagerAdapter X0() {
        return (MatchFilterViewPagerAdapter) this.f16696h.getValue();
    }

    public final PurchaseDialogManager Y0() {
        return (PurchaseDialogManager) this.f16695g.getValue();
    }

    public final xb.b Z0() {
        return (xb.b) this.f16697i.getValue();
    }

    public final MatchFilterTransModel a1() {
        return (MatchFilterTransModel) this.f16694f.getValue();
    }

    public final MatchFilterViewModel b1() {
        return (MatchFilterViewModel) this.f16693e.getValue();
    }

    public final void c1() {
        MainActivity.a.g(MainActivity.F, getContext(), null, null, false, null, null, 54, null);
        EventBus.c().o(new RouterUrlJumperSelectMainTabEvent(MainActivity.MainPagerType.Match));
    }

    public final void d1() {
        final Context context = getContext();
        if (context != null) {
            LocationUtils.f12270h.e(context, Z0(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.MatchFilterFragment$gotoMapFilterActivity$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MatchFilterTransModel a12;
                    CoordinateModel j10 = LocationUtils.f12270h.a().j();
                    Context context2 = context;
                    if (context2 != null) {
                        MatchFilterFragment matchFilterFragment = this;
                        MapFilterNewActivity.a aVar = MapFilterNewActivity.f16502z;
                        Double valueOf = Double.valueOf(j10.getLatitude());
                        Double valueOf2 = Double.valueOf(j10.getLongitude());
                        a12 = matchFilterFragment.a1();
                        aVar.a(context2, valueOf, valueOf2, a12 != null ? a12.getSensorPosition() : null, VipPurchaseEntranceType.MapFilter);
                    }
                }
            });
        }
    }

    public final void e1() {
        b1().getDoneBtnClickEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<SensorPosition, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.MatchFilterFragment$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SensorPosition sensorPosition) {
                invoke2(sensorPosition);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SensorPosition it) {
                kotlin.jvm.internal.s.i(it, "it");
                MatchFilterFragment.this.i1(it);
            }
        }));
        b1().getResultLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MatchFilterFragment.f1(MatchFilterFragment.this, (StateResult) obj);
            }
        });
        b1().getUploadSucResultLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.match.fragment.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MatchFilterFragment.g1(MatchFilterFragment.this, (MatchSettingResult) obj);
            }
        });
    }

    public final void h1() {
        int i10 = R$id.filter_viewpager;
        ((ViewPager2) U0(i10)).setUserInputEnabled(false);
        ((ViewPager2) U0(i10)).setAdapter(X0());
    }

    public final void i1(SensorPosition sensorPosition) {
        VipPurchaseEntranceType vipPurchaseEntranceType;
        MatchFilterTransModel a12 = a1();
        if (a12 != null && a12.getNeedPurchaseFirst()) {
            b1().uploadData(X0().j(), sensorPosition);
            return;
        }
        int checkNeedPurchase = b1().checkNeedPurchase(X0().j());
        if (checkNeedPurchase > PurchaseProductType.NO.getValue()) {
            if (checkNeedPurchase == PurchaseProductType.SVIP.getValue()) {
                vipPurchaseEntranceType = VipPurchaseEntranceType.RcmdSuperFilterGuide;
            } else {
                vipPurchaseEntranceType = checkNeedPurchase == PurchaseProductType.SSVIP.getValue() ? VipPurchaseEntranceType.RcmdSSVIPFilterGuide : VipPurchaseEntranceType.RcmdFilterGuide;
            }
            Y0().l(vipPurchaseEntranceType, null, checkNeedPurchase);
            return;
        }
        b1().uploadData(X0().j(), sensorPosition);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_match_filter, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowPurchaseDialogEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        Y0().l(event.getEntranceType(), event.getSensorFrom(), event.getProductType().getValue());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        h1();
        e1();
        MatchFilterViewModel b12 = b1();
        MatchFilterTransModel a12 = a1();
        b12.loadData(a12 != null ? a12.getFromNearBy() : false);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChooseAreaResultEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        X0().u(event.getRegion());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UpdateFilterKeyWordEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        X0().y(event.getWord());
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RangSliderTouchStartEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        X0().x();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RangSliserTouchEndEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        X0().w();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenMapFilterEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        d1();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FilterRcmdMBTIEvent event) {
        FilterTabModel filterTabModel;
        List<FilterOption> options;
        FilterRcmdMBTITypeModel filterRcmdMBTITypeModel;
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        Iterator<Object> iterator2 = X0().j().iterator2();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            }
            Object next = iterator2.next();
            if ((next instanceof OptionFilterUiModel) && kotlin.jvm.internal.s.d(((OptionFilterUiModel) next).getFilterTabModel().getKey(), FilterTabKey.MBTI.getValue())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 > 0) {
            OptionFilterUiModel optionFilterUiModel = (OptionFilterUiModel) X0().j().get(i10);
            if (optionFilterUiModel != null && (filterTabModel = optionFilterUiModel.getFilterTabModel()) != null && (options = filterTabModel.getOptions()) != null) {
                for (FilterOption filterOption : options) {
                    Iterator<FilterRcmdMBTITypeModel> iterator22 = event.getModel().getList().iterator2();
                    while (true) {
                        if (iterator22.hasNext()) {
                            filterRcmdMBTITypeModel = iterator22.next();
                            if (kotlin.jvm.internal.s.d(filterRcmdMBTITypeModel.getId(), filterOption.getId())) {
                                break;
                            }
                        } else {
                            filterRcmdMBTITypeModel = null;
                            break;
                        }
                    }
                    FilterRcmdMBTITypeModel filterRcmdMBTITypeModel2 = filterRcmdMBTITypeModel;
                    if (!kotlin.jvm.internal.s.d(filterOption.getTag(), filterRcmdMBTITypeModel2 != null ? filterRcmdMBTITypeModel2.getTag() : null)) {
                        filterOption.setTag(filterRcmdMBTITypeModel2 != null ? filterRcmdMBTITypeModel2.getTag() : null);
                        z10 = true;
                    }
                }
            }
            if (X0().f(i10) && z10) {
                X0().notifyItemChanged(i10);
            }
        }
    }
}
