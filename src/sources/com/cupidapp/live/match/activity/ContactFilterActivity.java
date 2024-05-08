package com.cupidapp.live.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.alibaba.wireless.security.SecExceptionCode;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.filter.util.ContactFilterRangeBarPopupHelper;
import com.cupidapp.live.match.adapter.FKMatchFilterAdapter;
import com.cupidapp.live.match.event.ChooseAreaResultEvent;
import com.cupidapp.live.match.event.RangSliderTouchStartEvent;
import com.cupidapp.live.match.event.RangSliserTouchEndEvent;
import com.cupidapp.live.match.model.CityFilterModel;
import com.cupidapp.live.match.model.RegionModel;
import com.cupidapp.live.match.viewmodel.ContactFilterViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
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

/* compiled from: ContactFilterActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ContactFilterActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f16483u = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f16486s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16487t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final FKMatchFilterAdapter f16484q = new FKMatchFilterAdapter();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16485r = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.match.activity.ContactFilterActivity$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            ContactFilterActivity contactFilterActivity = ContactFilterActivity.this;
            Lifecycle lifecycle = contactFilterActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(contactFilterActivity, lifecycle);
        }
    });

    /* compiled from: ContactFilterActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Fragment fragment) {
            if (fragment == null) {
                return;
            }
            fragment.startActivityForResult(new Intent(fragment.getContext(), (Class<?>) ContactFilterActivity.class), SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED);
            FKBaseActivity.f11750o.b(fragment.getContext(), R$anim.anim_activity_bottom_to_top, R$anim.anmi_stop);
        }
    }

    public ContactFilterActivity() {
        final Function0 function0 = null;
        this.f16486s = new ViewModelLazy(kotlin.jvm.internal.v.b(ContactFilterViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.ContactFilterActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.ContactFilterActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.ContactFilterActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                kotlin.jvm.internal.s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void s1(ContactFilterActivity this$0, StateResult stateResult) {
        List<? extends Object> list;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            this$0.e1();
            return;
        }
        this$0.V0();
        if (!(stateResult instanceof StateResult.c) || (list = (List) stateResult.getData()) == null) {
            return;
        }
        this$0.f16484q.j().clear();
        this$0.f16484q.e(list);
        this$0.f16484q.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 62, null));
        this$0.f16484q.notifyDataSetChanged();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.ContactFilter;
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f16487t;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void o1() {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) k1(R$id.matchFilterTitleLayout);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.ContactFilterActivity$bindEvent$1$1
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
                ContactFilterActivity.this.finish();
            }
        });
        fKTitleBarLayout.setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.ContactFilterActivity$bindEvent$1$2
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
                ContactFilterViewModel q12;
                FKBaseRecyclerViewAdapter fKBaseRecyclerViewAdapter;
                q12 = ContactFilterActivity.this.q1();
                fKBaseRecyclerViewAdapter = ContactFilterActivity.this.f16484q;
                q12.uploadData(fKBaseRecyclerViewAdapter.j(), ContactFilterActivity.this.Q0());
            }
        });
        this.f16484q.l().d().put(Integer.valueOf(R$id.city_filter_other_city_layout), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.ContactFilterActivity$bindEvent$2$1
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
                boolean t12;
                if (obj instanceof CityFilterModel) {
                    GroupOthersLog.f18702a.Q(ContactFilterActivity.this.Q0().getValue(), "CITY");
                    t12 = ContactFilterActivity.this.t1();
                    if (t12) {
                        return;
                    }
                    String string = ContactFilterActivity.this.getString(R$string.city_filter);
                    kotlin.jvm.internal.s.h(string, "getString(R.string.city_filter)");
                    CityFilterModel cityFilterModel = (CityFilterModel) obj;
                    List<RegionModel> hotCities = cityFilterModel.getHotCities();
                    List<RegionModel> regions = cityFilterModel.getRegions();
                    RegionModel regionModel = null;
                    if (cityFilterModel.getFilterRegion() != null && cityFilterModel.getSelectedRegion() != null) {
                        String filterRegion = cityFilterModel.getFilterRegion();
                        kotlin.jvm.internal.s.f(filterRegion);
                        String selectedRegion = cityFilterModel.getSelectedRegion();
                        kotlin.jvm.internal.s.f(selectedRegion);
                        regionModel = new RegionModel(filterRegion, selectedRegion, null);
                    }
                    AreaListActivity.f16481r.b(ContactFilterActivity.this, new CitiesModel(string, hotCities, regions, false, regionModel));
                }
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(R$anim.anmi_stop, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        setContentView(R$layout.activity_match_filter);
        FKTitleBarLayout matchFilterTitleLayout = (FKTitleBarLayout) k1(R$id.matchFilterTitleLayout);
        kotlin.jvm.internal.s.h(matchFilterTitleLayout, "matchFilterTitleLayout");
        FKTitleBarLayout.setSingleTitle$default(matchFilterTitleLayout, getString(R$string.filter), null, 2, null);
        int i10 = R$id.recyclerView;
        ((RecyclerView) k1(i10)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) k1(i10)).setAdapter(this.f16484q);
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) k1(i10)).getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        r1();
        q1().initData();
        o1();
        j1.c.b(j1.c.f50228a, Q0(), null, null, 6, null);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull a3.a event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (event.a()) {
            PurchaseDialogManager.q(p1(), VipPurchaseEntranceType.ContactSuperFilter, getString(R$string.contact_sensor, new Object[]{event.b()}), null, false, false, 28, null);
        } else {
            PurchaseDialogManager.j(p1(), VipPurchaseEntranceType.ContactFilter, getString(R$string.contact_sensor, new Object[]{event.b()}), null, false, 12, null);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ContactFilterRangeBarPopupHelper.f14616a.d();
    }

    public final PurchaseDialogManager p1() {
        return (PurchaseDialogManager) this.f16485r.getValue();
    }

    public final ContactFilterViewModel q1() {
        return (ContactFilterViewModel) this.f16486s.getValue();
    }

    public final void r1() {
        q1().getListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactFilterActivity.s1(ContactFilterActivity.this, (StateResult) obj);
            }
        });
        q1().getFilterSucEventLiveData().observe(this, new EventObserver(new Function1<kotlin.p, kotlin.p>() { // from class: com.cupidapp.live.match.activity.ContactFilterActivity$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(kotlin.p pVar) {
                invoke2(pVar);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull kotlin.p it) {
                kotlin.jvm.internal.s.i(it, "it");
                ContactFilterActivity.this.setResult(-1, new Intent());
                ContactFilterActivity.this.finish();
            }
        }));
    }

    public final boolean t1() {
        User X = p1.g.f52734a.X();
        boolean pro = X != null ? X.getPro() : false;
        if (com.cupidapp.live.profile.logic.c.f17839a.f() || pro || this.f16484q.u()) {
            return false;
        }
        PurchaseDialogManager p12 = p1();
        VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.Roaming;
        vipPurchaseEntranceType.setPosition(Q0());
        vipPurchaseEntranceType.setFrom("CONTACTS_CITY");
        PurchaseDialogManager.j(p12, vipPurchaseEntranceType, null, null, false, 14, null);
        return true;
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RangSliderTouchStartEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        ((RecyclerView) k1(R$id.recyclerView)).setLayoutFrozen(true);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RangSliserTouchEndEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        ((RecyclerView) k1(R$id.recyclerView)).setLayoutFrozen(false);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        q1().initData();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChooseAreaResultEvent event) {
        Object obj;
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        Iterator<Object> iterator2 = this.f16484q.j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if (obj instanceof CityFilterModel) {
                    break;
                }
            }
        }
        CityFilterModel cityFilterModel = obj instanceof CityFilterModel ? (CityFilterModel) obj : null;
        if (cityFilterModel != null) {
            RegionModel region = event.getRegion();
            cityFilterModel.setFilterRegion(region != null ? region.getCode() : null);
            RegionModel region2 = event.getRegion();
            cityFilterModel.setSelectedRegion(region2 != null ? region2.getName() : null);
        }
        this.f16484q.notifyDataSetChanged();
    }
}
