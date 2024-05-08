package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.match.adapter.FKNearByAdapter;
import com.cupidapp.live.match.model.NearbyListModel;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.viewmodel.NearbySuperBoostViewModel;
import com.cupidapp.live.superboost.dialog.SuperBoostManager;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearbySuperBoostActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbySuperBoostActivity extends FKBaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f16531v = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16532q;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16536u = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16533r = kotlin.c.b(new Function0<FKNearByAdapter>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$superBoostAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKNearByAdapter invoke() {
            FKNearByAdapter fKNearByAdapter = new FKNearByAdapter();
            final NearbySuperBoostActivity nearbySuperBoostActivity = NearbySuperBoostActivity.this;
            fKNearByAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$superBoostAdapter$2$1$1
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
                    if (obj instanceof NearbyListModel) {
                        NearbyListModel nearbyListModel = (NearbyListModel) obj;
                        NearByMiniProfileActivity.f16517r.a(NearbySuperBoostActivity.this, nearbyListModel.getNearbyUser(), SensorScene.SuperBoost, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : SensorPosition.SuperExposure, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : nearbyListModel.getNearbyUser().getFromSpecialExposure());
                    }
                }
            });
            return fKNearByAdapter;
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f16534s = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final NearbySuperBoostActivity nearbySuperBoostActivity = NearbySuperBoostActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$loadMoreListener$2.1
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
                    NearbySuperBoostViewModel t12;
                    t12 = NearbySuperBoostActivity.this.t1();
                    t12.loadMoreSuperBoost();
                }
            });
        }
    });

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f16535t = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            NearbySuperBoostActivity nearbySuperBoostActivity = NearbySuperBoostActivity.this;
            Lifecycle lifecycle = nearbySuperBoostActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(nearbySuperBoostActivity, lifecycle);
        }
    });

    /* compiled from: NearbySuperBoostActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            Intent intent = new Intent(context, (Class<?>) NearbySuperBoostActivity.class);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public NearbySuperBoostActivity() {
        final Function0 function0 = null;
        this.f16532q = new ViewModelLazy(kotlin.jvm.internal.v.b(NearbySuperBoostViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$special$$inlined$viewModels$default$3
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

    public static final void v1(NearbySuperBoostActivity this$0, StateResult stateResult) {
        ArrayList arrayList;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.l1(R$id.super_boost_refresh_layout)).setRefreshing(false);
        this$0.q1().c(false);
        if (stateResult instanceof StateResult.c) {
            this$0.s1().j().clear();
            ListResult listResult = (ListResult) stateResult.getData();
            List list = listResult != null ? listResult.getList() : null;
            FKNearByAdapter s12 = this$0.s1();
            if (list != null) {
                arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
                Iterator<E> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(new NearbyListModel((NearbyUserModel) iterator2.next()));
                }
            } else {
                arrayList = null;
            }
            s12.e(arrayList);
            ListResult listResult2 = (ListResult) stateResult.getData();
            String nextCursorId = listResult2 != null ? listResult2.getNextCursorId() : null;
            if (!(nextCursorId == null || nextCursorId.length() == 0)) {
                this$0.s1().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
            }
            this$0.s1().notifyDataSetChanged();
        }
    }

    public static final void w1(NearbySuperBoostActivity this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.q1().c(false);
        List list = (List) pair.getFirst();
        boolean booleanValue = ((Boolean) pair.getSecond()).booleanValue();
        FKNearByAdapter s12 = this$0.s1();
        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
        Iterator<E> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new NearbyListModel((NearbyUserModel) iterator2.next()));
        }
        s12.e(arrayList);
        if (booleanValue) {
            this$0.s1().s();
        }
        this$0.s1().notifyDataSetChanged();
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f16536u;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_nearby_super_boost);
        p0.c(this, true, 0, 2, null);
        x1();
        p1();
        u1();
        onRefresh();
        j1.c.b(j1.c.f50228a, SensorPosition.SuperExposure, null, SensorPosition.Nearby.getValue(), 2, null);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.SuperBoost);
        NearbySuperBoostViewModel.getNearbySuperBoost$default(t1(), null, 1, null);
    }

    public final void p1() {
        ((FKTitleBarLayout) l1(R$id.super_boost_title_layout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$bindClickEvent$1
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
                NearbySuperBoostActivity.this.onBackPressed();
            }
        });
        FKUniversalButton open_super_boost_button = (FKUniversalButton) l1(R$id.open_super_boost_button);
        kotlin.jvm.internal.s.h(open_super_boost_button, "open_super_boost_button");
        z0.y.d(open_super_boost_button, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$bindClickEvent$2
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
                PurchaseDialogManager r12;
                SuperBoostManager superBoostManager = SuperBoostManager.f18580a;
                NearbySuperBoostActivity nearbySuperBoostActivity = NearbySuperBoostActivity.this;
                r12 = nearbySuperBoostActivity.r1();
                superBoostManager.j(nearbySuperBoostActivity, r12, SensorPosition.Nearby.getValue(), null);
                SensorsLogKeyButtonClick.SuperExposure.StartSuperExposure.click();
            }
        });
    }

    public final FKLoadMoreListener q1() {
        return (FKLoadMoreListener) this.f16534s.getValue();
    }

    public final PurchaseDialogManager r1() {
        return (PurchaseDialogManager) this.f16535t.getValue();
    }

    public final FKNearByAdapter s1() {
        return (FKNearByAdapter) this.f16533r.getValue();
    }

    public final NearbySuperBoostViewModel t1() {
        return (NearbySuperBoostViewModel) this.f16532q.getValue();
    }

    public final void u1() {
        t1().getSuperBoostUserListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbySuperBoostActivity.v1(NearbySuperBoostActivity.this, (StateResult) obj);
            }
        });
        t1().getMoreSuperBoostLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbySuperBoostActivity.w1(NearbySuperBoostActivity.this, (Pair) obj);
            }
        });
    }

    public final void x1() {
        FKNearByAdapter s12 = s1();
        ExposureScene exposureScene = ExposureScene.SuperBoost;
        int i10 = R$id.super_boost_recyclerview;
        RecyclerView super_boost_recyclerview = (RecyclerView) l1(i10);
        kotlin.jvm.internal.s.h(super_boost_recyclerview, "super_boost_recyclerview");
        s12.t(new RecyclerExposureHelper(exposureScene, super_boost_recyclerview, 0.0f, 0L, null, new Function1<List<? extends h1.a>, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$initView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> list) {
                kotlin.jvm.internal.s.i(list, "list");
                Iterator<h1.a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof NearbyListModel) {
                        NearbyListModel nearbyListModel = (NearbyListModel) a10;
                        GroupSocialLog.f18708a.w(SensorScene.SuperBoost.getValue(), nearbyListModel.getNearbyUser().getId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : nearbyListModel.getNearbyUser().getFromSpecialExposure(), (r29 & 2048) != 0 ? false : false);
                    }
                }
            }
        }, 28, null));
        RecyclerView recyclerView = (RecyclerView) l1(i10);
        recyclerView.setAdapter(s1());
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) this, s1().v(), 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$initView$2$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i11) {
                FKNearByAdapter s13;
                s13 = NearbySuperBoostActivity.this.s1();
                return s13.u(i11);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(q1());
        q1().d(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.match.activity.NearbySuperBoostActivity$initView$2$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i11, int i12) {
                kotlin.jvm.internal.s.i(recyclerView2, "recyclerView");
                if (i12 > 0) {
                    FKUniversalButton open_super_boost_button = (FKUniversalButton) NearbySuperBoostActivity.this.l1(R$id.open_super_boost_button);
                    kotlin.jvm.internal.s.h(open_super_boost_button, "open_super_boost_button");
                    open_super_boost_button.setVisibility(8);
                } else if (i12 < 0) {
                    FKUniversalButton open_super_boost_button2 = (FKUniversalButton) NearbySuperBoostActivity.this.l1(R$id.open_super_boost_button);
                    kotlin.jvm.internal.s.h(open_super_boost_button2, "open_super_boost_button");
                    open_super_boost_button2.setVisibility(0);
                }
            }
        });
        ((FKSwipeRefreshLayout) l1(R$id.super_boost_refresh_layout)).setOnRefreshListener(this);
    }
}
