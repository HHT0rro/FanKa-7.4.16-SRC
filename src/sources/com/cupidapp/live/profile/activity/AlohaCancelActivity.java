package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.adapter.AlohaCancelAdapter;
import com.cupidapp.live.profile.model.AlohaCancelUserModel;
import com.cupidapp.live.profile.viewmodel.AlohaCancelViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AlohaCancelActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AlohaCancelActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f17585v = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17586q;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17590u = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17587r = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final AlohaCancelActivity alohaCancelActivity = AlohaCancelActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$loadMoreListener$2.1
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
                    AlohaCancelViewModel t12;
                    t12 = AlohaCancelActivity.this.t1();
                    t12.loadMore();
                }
            });
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17588s = kotlin.c.b(new Function0<AlohaCancelAdapter>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AlohaCancelAdapter invoke() {
            AlohaCancelAdapter alohaCancelAdapter = new AlohaCancelAdapter();
            final AlohaCancelActivity alohaCancelActivity = AlohaCancelActivity.this;
            alohaCancelAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$adapter$2$1$1
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
                    if (obj instanceof AlohaCancelUserModel) {
                        AlohaCancelUserModel alohaCancelUserModel = (AlohaCancelUserModel) obj;
                        UserProfileActivity.a.b(UserProfileActivity.G, AlohaCancelActivity.this, alohaCancelUserModel.getUser(), new ProfileSensorContext(ViewProfilePrefer.MatchUserListToProfile.getValue(), null, alohaCancelUserModel.getUser().getMe(), AlohaCancelActivity.this.Q0(), null, SensorScene.FollowingList), false, null, null, null, false, 240, null);
                    }
                }
            });
            return alohaCancelAdapter;
        }
    });

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f17589t = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$purchaseManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            AlohaCancelActivity alohaCancelActivity = AlohaCancelActivity.this;
            Lifecycle lifecycle = alohaCancelActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(alohaCancelActivity, lifecycle);
        }
    });

    /* compiled from: AlohaCancelActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            context.startActivity(new Intent(context, (Class<?>) AlohaCancelActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public AlohaCancelActivity() {
        final Function0 function0 = null;
        this.f17586q = new ViewModelLazy(kotlin.jvm.internal.v.b(AlohaCancelViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$special$$inlined$viewModels$default$3
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

    public static final void v1(AlohaCancelActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.t1().refresh();
    }

    public static final void x1(final AlohaCancelActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        if (it.booleanValue()) {
            int i10 = R$id.un_aloha_buy_btn;
            ((TextView) this$0.m1(i10)).setVisibility(0);
            TextView un_aloha_buy_btn = (TextView) this$0.m1(i10);
            kotlin.jvm.internal.s.h(un_aloha_buy_btn, "un_aloha_buy_btn");
            z0.u.a(un_aloha_buy_btn);
            TextView un_aloha_buy_btn2 = (TextView) this$0.m1(i10);
            kotlin.jvm.internal.s.h(un_aloha_buy_btn2, "un_aloha_buy_btn");
            z0.y.d(un_aloha_buy_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$initObserve$1$1
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
                    AlohaCancelActivity.this.B1();
                }
            });
            return;
        }
        ((TextView) this$0.m1(R$id.un_aloha_buy_btn)).setVisibility(8);
    }

    public static final void y1(AlohaCancelActivity this$0, StateResult it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (it instanceof StateResult.b) {
            if (kotlin.jvm.internal.s.d(it.isLoadMore(), Boolean.FALSE)) {
                ((FKSwipeRefreshLayout) this$0.m1(R$id.un_aloha_refresh_layout)).setRefreshing(true);
                return;
            }
            return;
        }
        if (it instanceof StateResult.c) {
            kotlin.jvm.internal.s.h(it, "it");
            this$0.A1(it);
            ((FKSwipeRefreshLayout) this$0.m1(R$id.un_aloha_refresh_layout)).setRefreshing(false);
            this$0.r1().c(false);
            return;
        }
        if (it instanceof StateResult.a) {
            ((FKSwipeRefreshLayout) this$0.m1(R$id.un_aloha_refresh_layout)).setRefreshing(false);
            this$0.r1().c(false);
            if (kotlin.jvm.internal.s.d(it.isLoadMore(), Boolean.FALSE) && this$0.p1().j().isEmpty()) {
                this$0.p1().j().clear();
                this$0.p1().d(this$0.q1());
                this$0.p1().notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1(com.cupidapp.live.base.network.model.StateResult<java.util.List<com.cupidapp.live.profile.model.AlohaCancelUserModel>> r12) {
        /*
            r11 = this;
            java.lang.Boolean r0 = r12.isLoadMore()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.s.d(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L3a
            com.cupidapp.live.profile.adapter.AlohaCancelAdapter r0 = r11.p1()
            java.util.List r0 = r0.j()
            r0.clear()
            java.lang.Object r0 = r12.getData()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L2a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L28
            goto L2a
        L28:
            r0 = 0
            goto L2b
        L2a:
            r0 = 1
        L2b:
            if (r0 == 0) goto L3a
            com.cupidapp.live.profile.adapter.AlohaCancelAdapter r0 = r11.p1()
            com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel r3 = r11.q1()
            r0.d(r3)
            r0 = 1
            goto L3b
        L3a:
            r0 = 0
        L3b:
            com.cupidapp.live.profile.adapter.AlohaCancelAdapter r3 = r11.p1()
            r3.s()
            java.lang.Object r3 = r12.getData()
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L52
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L51
            goto L52
        L51:
            r1 = 0
        L52:
            if (r1 != 0) goto L61
            com.cupidapp.live.profile.adapter.AlohaCancelAdapter r1 = r11.p1()
            java.lang.Object r12 = r12.getData()
            java.util.List r12 = (java.util.List) r12
            r1.e(r12)
        L61:
            com.cupidapp.live.profile.viewmodel.AlohaCancelViewModel r12 = r11.t1()
            boolean r12 = r12.canLoadMore()
            r1 = 1106247680(0x41f00000, float:30.0)
            if (r12 == 0) goto L87
            com.cupidapp.live.profile.adapter.AlohaCancelAdapter r12 = r11.p1()
            com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel r0 = new com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel
            r3 = 1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            int r8 = z0.h.c(r11, r1)
            r9 = 30
            r10 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r12.d(r0)
            goto La2
        L87:
            if (r0 != 0) goto La2
            com.cupidapp.live.profile.adapter.AlohaCancelAdapter r12 = r11.p1()
            com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel r0 = new com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            int r8 = z0.h.c(r11, r1)
            r9 = 30
            r10 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r12.d(r0)
        La2:
            com.cupidapp.live.profile.adapter.AlohaCancelAdapter r12 = r11.p1()
            r12.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.profile.activity.AlohaCancelActivity.A1(com.cupidapp.live.base.network.model.StateResult):void");
    }

    public final void B1() {
        SensorsLogKeyButtonClick.CancelAloha.UpdateToRainbow.click();
        PurchaseDialogManager s12 = s1();
        VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.UnAloha;
        PurchaseDialogManager.o(s12, vipPurchaseEntranceType, vipPurchaseEntranceType.getFrom(), false, false, 12, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.CancelAloha;
    }

    @Nullable
    public View m1(int i10) {
        Map<Integer, View> map = this.f17590u;
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
        setContentView(R$layout.activity_un_aloha_me);
        z1();
        u1();
        w1();
        GroupOthersLog.d(GroupOthersLog.f18702a, Q0().getValue(), null, null, 6, null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        t1().refresh();
    }

    public final AlohaCancelAdapter p1() {
        return (AlohaCancelAdapter) this.f17588s.getValue();
    }

    public final FKEmptyViewModel q1() {
        return new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_filter_no_person), Integer.valueOf(R$string.no_eligible_people), null, -15066598, null, null, null, false, null, null, 1012, null);
    }

    public final FKLoadMoreListener r1() {
        return (FKLoadMoreListener) this.f17587r.getValue();
    }

    public final PurchaseDialogManager s1() {
        return (PurchaseDialogManager) this.f17589t.getValue();
    }

    public final AlohaCancelViewModel t1() {
        return (AlohaCancelViewModel) this.f17586q.getValue();
    }

    public final void u1() {
        ((FKSwipeRefreshLayout) m1(R$id.un_aloha_refresh_layout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.profile.activity.c
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                AlohaCancelActivity.v1(AlohaCancelActivity.this);
            }
        });
    }

    public final void w1() {
        t1().getShowBuyBtn().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AlohaCancelActivity.x1(AlohaCancelActivity.this, (Boolean) obj);
            }
        });
        t1().getListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AlohaCancelActivity.y1(AlohaCancelActivity.this, (StateResult) obj);
            }
        });
    }

    public final void z1() {
        int i10 = R$id.un_aloha_rv;
        ((RecyclerView) m1(i10)).setAdapter(p1());
        ((RecyclerView) m1(i10)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) m1(i10)).addOnScrollListener(r1());
        ((FKTitleBarLayout) m1(R$id.un_aloha_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.AlohaCancelActivity$initView$1
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
                AlohaCancelActivity.this.onBackPressed();
            }
        });
    }
}
