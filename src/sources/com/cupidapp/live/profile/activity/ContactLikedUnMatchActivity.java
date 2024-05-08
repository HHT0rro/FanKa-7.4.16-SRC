package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.adapter.LikedUnMatchAdapter;
import com.cupidapp.live.profile.model.BanUserModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.viewmodel.UnMatchViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactLikedUnMatchActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ContactLikedUnMatchActivity extends FKBaseActivity {

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public static final a f17593w = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17595r;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17599v = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17594q = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$isBanUser$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(ContactLikedUnMatchActivity.this.getIntent().getBooleanExtra("is_ban_user", false));
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17596s = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final ContactLikedUnMatchActivity contactLikedUnMatchActivity = ContactLikedUnMatchActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$loadMoreListener$2.1
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
                    UnMatchViewModel w12;
                    w12 = ContactLikedUnMatchActivity.this.w1();
                    w12.loadMore();
                }
            });
        }
    });

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f17597t = kotlin.c.b(new Function0<LikedUnMatchAdapter>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final LikedUnMatchAdapter invoke() {
            LikedUnMatchAdapter likedUnMatchAdapter = new LikedUnMatchAdapter();
            final ContactLikedUnMatchActivity contactLikedUnMatchActivity = ContactLikedUnMatchActivity.this;
            likedUnMatchAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$adapter$2$1$1
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
                    if (obj instanceof User) {
                        User user = (User) obj;
                        UserProfileActivity.a.b(UserProfileActivity.G, ContactLikedUnMatchActivity.this, user, new ProfileSensorContext(ViewProfilePrefer.FollowerToProfile.getValue(), null, user.getMe(), ContactLikedUnMatchActivity.this.Q0(), null, SensorScene.FollowingList), true, null, null, null, false, 240, null);
                    } else if (obj instanceof BanUserModel) {
                        ContactLikedUnMatchActivity.f17593w.a(ContactLikedUnMatchActivity.this, true);
                    }
                }
            });
            likedUnMatchAdapter.l().i(i0.h(kotlin.f.a(Integer.valueOf(R$id.item_match_select_cb), new Function3<Object, Boolean, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$adapter$2$1$2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj, Boolean bool, Integer num) {
                    invoke(obj, bool.booleanValue(), num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, boolean z10, int i10) {
                    LikedUnMatchAdapter t12;
                    LikedUnMatchAdapter t13;
                    if (obj instanceof User) {
                        if (z10) {
                            t13 = ContactLikedUnMatchActivity.this.t1();
                            t13.u(((User) obj).userId());
                        } else {
                            t12 = ContactLikedUnMatchActivity.this.t1();
                            t12.z(((User) obj).userId());
                        }
                        ContactLikedUnMatchActivity.this.s1();
                    }
                }
            })));
            return likedUnMatchAdapter;
        }
    });

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f17598u = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$purchaseManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            ContactLikedUnMatchActivity contactLikedUnMatchActivity = ContactLikedUnMatchActivity.this;
            Lifecycle lifecycle = contactLikedUnMatchActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(contactLikedUnMatchActivity, lifecycle);
        }
    });

    /* compiled from: ContactLikedUnMatchActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, boolean z10) {
            kotlin.jvm.internal.s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) ContactLikedUnMatchActivity.class);
            intent.putExtra("is_ban_user", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public ContactLikedUnMatchActivity() {
        final Function0 function0 = null;
        this.f17595r = new ViewModelLazy(kotlin.jvm.internal.v.b(UnMatchViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final ContactLikedUnMatchActivity contactLikedUnMatchActivity = ContactLikedUnMatchActivity.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        kotlin.jvm.internal.s.i(p02, "p0");
                        return new UnMatchViewModel(ContactLikedUnMatchActivity.this.E1() ? new com.cupidapp.live.profile.logic.a() : new com.cupidapp.live.profile.logic.b());
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$special$$inlined$viewModels$default$3
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

    public static final void A1(ContactLikedUnMatchActivity this$0, UnMatchViewModel.TitleUiModel titleUiModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = R$id.un_match_title;
        FKTitleBarLayout un_match_title = (FKTitleBarLayout) this$0.n1(i10);
        kotlin.jvm.internal.s.h(un_match_title, "un_match_title");
        FKTitleBarLayout.setSingleTitle$default(un_match_title, this$0.getString(titleUiModel.getTitleRes()), null, 2, null);
        ((FKTitleBarLayout) this$0.n1(i10)).setRightText(this$0.getString(titleUiModel.getRightContent()), titleUiModel.getRightColor(), ((FKTitleBarLayout) this$0.n1(i10)).getRightTextView().getVisibility(), false);
    }

    public static final void B1(ContactLikedUnMatchActivity this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            ((RelativeLayout) this$0.n1(R$id.select_manage_ll)).setVisibility(0);
            if (((Boolean) pair.getSecond()).booleanValue()) {
                this$0.t1().v(true);
                ((TextView) this$0.n1(R$id.un_follow_confirm_txt)).setVisibility(0);
            } else {
                this$0.t1().v(false);
                ((TextView) this$0.n1(R$id.un_follow_confirm_txt)).setVisibility(8);
            }
            SensorsLogKeyButtonClick.f12211a.c(this$0.Q0().getValue(), SensorsLogKeyButtonClick.ContactAlohaNotMatchBtn.BATCH_CANCEL_FOLLOW.getButtonName());
        } else {
            this$0.t1().v(false);
            ((RelativeLayout) this$0.n1(R$id.select_manage_ll)).setVisibility(8);
        }
        this$0.s1();
    }

    public static final void C1(ContactLikedUnMatchActivity this$0, StateResult it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (it instanceof StateResult.b) {
            if (kotlin.jvm.internal.s.d(it.isLoadMore(), Boolean.FALSE)) {
                ((FKSwipeRefreshLayout) this$0.n1(R$id.contact_un_match_refresh_layout)).setRefreshing(true);
                return;
            }
            return;
        }
        if (it instanceof StateResult.c) {
            kotlin.jvm.internal.s.h(it, "it");
            this$0.F1(it);
            ((FKSwipeRefreshLayout) this$0.n1(R$id.contact_un_match_refresh_layout)).setRefreshing(false);
            this$0.u1().c(false);
            return;
        }
        if (it instanceof StateResult.a) {
            ((FKSwipeRefreshLayout) this$0.n1(R$id.contact_un_match_refresh_layout)).setRefreshing(false);
            this$0.u1().c(false);
            if (kotlin.jvm.internal.s.d(it.isLoadMore(), Boolean.FALSE) && this$0.t1().j().isEmpty()) {
                ((FKTitleBarLayout) this$0.n1(R$id.un_match_title)).setRightTextViewVisible(false);
                this$0.t1().j().clear();
                this$0.t1().d(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_contact_search), Integer.valueOf(R$string.no_eligible_people), null, -12763843, null, null, null, false, null, null, 1012, null));
                this$0.t1().notifyDataSetChanged();
            }
        }
    }

    public static final void y1(ContactLikedUnMatchActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.w1().refresh();
    }

    public final void D1() {
        ((FKTitleBarLayout) n1(R$id.un_match_title)).setRightTextViewVisible(false);
        TextView un_follow_confirm_txt = (TextView) n1(R$id.un_follow_confirm_txt);
        kotlin.jvm.internal.s.h(un_follow_confirm_txt, "un_follow_confirm_txt");
        z0.u.a(un_follow_confirm_txt);
        int i10 = R$id.un_match_rv;
        ((RecyclerView) n1(i10)).setAdapter(t1());
        ((RecyclerView) n1(i10)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) n1(i10)).addOnScrollListener(u1());
    }

    public final boolean E1() {
        return ((Boolean) this.f17594q.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void F1(com.cupidapp.live.base.network.model.StateResult<java.util.List<com.cupidapp.live.profile.model.User>> r18) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity.F1(com.cupidapp.live.base.network.model.StateResult):void");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return E1() ? SensorPosition.ALOHA_NOT_MATCH_BAN : SensorPosition.ALOHA_NOT_MATCH;
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f17599v;
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
        setContentView(R$layout.activity_contact_un_match);
        D1();
        x1();
        z1();
        GroupOthersLog.d(GroupOthersLog.f18702a, Q0().getValue(), null, null, 6, null);
    }

    public final void s1() {
        boolean z10 = !t1().x().isEmpty();
        int i10 = R$id.un_follow_confirm_txt;
        ((TextView) n1(i10)).setEnabled(z10);
        if (z10) {
            ((TextView) n1(i10)).setTextColor(-49088);
            ((TextView) n1(i10)).setBackgroundResource(R$drawable.rect_corner_24_stroke_red);
        } else {
            ((TextView) n1(i10)).setTextColor(-5658199);
            ((TextView) n1(i10)).setBackgroundResource(R$drawable.rect_cor_24_sd_e9e9eb);
        }
    }

    public final LikedUnMatchAdapter t1() {
        return (LikedUnMatchAdapter) this.f17597t.getValue();
    }

    public final FKLoadMoreListener u1() {
        return (FKLoadMoreListener) this.f17596s.getValue();
    }

    public final PurchaseDialogManager v1() {
        return (PurchaseDialogManager) this.f17598u.getValue();
    }

    public final UnMatchViewModel w1() {
        return (UnMatchViewModel) this.f17595r.getValue();
    }

    public final void x1() {
        ((FKSwipeRefreshLayout) n1(R$id.contact_un_match_refresh_layout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.profile.activity.g
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ContactLikedUnMatchActivity.y1(ContactLikedUnMatchActivity.this);
            }
        });
        TextView un_follow_confirm_txt = (TextView) n1(R$id.un_follow_confirm_txt);
        kotlin.jvm.internal.s.h(un_follow_confirm_txt, "un_follow_confirm_txt");
        z0.y.d(un_follow_confirm_txt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$initEvent$2
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
                SensorsLogKeyButtonClick.f12211a.c(ContactLikedUnMatchActivity.this.Q0().getValue(), SensorsLogKeyButtonClick.ContactAlohaNotMatchBtn.CONFIRM.getButtonName());
                FKAlertDialog o10 = FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, ContactLikedUnMatchActivity.this, false, 2, null), R$string.confirm_un_follow_select_user, 0, 2, null);
                final ContactLikedUnMatchActivity contactLikedUnMatchActivity = ContactLikedUnMatchActivity.this;
                FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(o10, 2131886528, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$initEvent$2.1
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
                        UnMatchViewModel w12;
                        LikedUnMatchAdapter t12;
                        w12 = ContactLikedUnMatchActivity.this.w1();
                        t12 = ContactLikedUnMatchActivity.this.t1();
                        w12.unLikedUsers(t12.x());
                    }
                }, 2, null), 0, null, 3, null), null, 1, null);
            }
        });
        TextView select_clear_txt = (TextView) n1(R$id.select_clear_txt);
        kotlin.jvm.internal.s.h(select_clear_txt, "select_clear_txt");
        z0.y.d(select_clear_txt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$initEvent$3
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
                UnMatchViewModel w12;
                SensorsLogKeyButtonClick.f12211a.c(ContactLikedUnMatchActivity.this.Q0().getValue(), SensorsLogKeyButtonClick.ContactAlohaNotMatchBtn.CLEAN_LIST.getButtonName());
                FKAlertDialog c4 = FKAlertDialog.a.c(FKAlertDialog.f12698l, ContactLikedUnMatchActivity.this, false, 2, null);
                w12 = ContactLikedUnMatchActivity.this.w1();
                FKAlertDialog o10 = FKAlertDialog.o(c4, w12.getClearAllContent(), 0, 2, null);
                final ContactLikedUnMatchActivity contactLikedUnMatchActivity = ContactLikedUnMatchActivity.this;
                FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(o10, 2131886528, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$initEvent$3.1
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
                        UnMatchViewModel w13;
                        w13 = ContactLikedUnMatchActivity.this.w1();
                        w13.unLikeAllUsers();
                    }
                }, 2, null), 0, null, 3, null), null, 1, null);
            }
        });
        int i10 = R$id.un_match_title;
        ((FKTitleBarLayout) n1(i10)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$initEvent$4
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
                ContactLikedUnMatchActivity.this.onBackPressed();
            }
        });
        ((FKTitleBarLayout) n1(i10)).setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$initEvent$5
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
                PurchaseDialogManager v12;
                UnMatchViewModel w12;
                if (com.cupidapp.live.profile.logic.c.f17839a.b()) {
                    w12 = ContactLikedUnMatchActivity.this.w1();
                    w12.changeSelectState();
                } else {
                    v12 = ContactLikedUnMatchActivity.this.v1();
                    VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.ContactManager;
                    PurchaseDialogManager.o(v12, vipPurchaseEntranceType, vipPurchaseEntranceType.getFrom(), false, false, 12, null);
                }
            }
        });
    }

    public final void z1() {
        w1().getTitleLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactLikedUnMatchActivity.A1(ContactLikedUnMatchActivity.this, (UnMatchViewModel.TitleUiModel) obj);
            }
        });
        w1().getSelectState().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactLikedUnMatchActivity.B1(ContactLikedUnMatchActivity.this, (Pair) obj);
            }
        });
        w1().getListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactLikedUnMatchActivity.C1(ContactLikedUnMatchActivity.this, (StateResult) obj);
            }
        });
        w1().getUnFollowListSucLiveData().observe(this, new EventObserver(new Function1<List<? extends String>, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactLikedUnMatchActivity$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<String> list) {
                LikedUnMatchAdapter t12;
                UnMatchViewModel w12;
                LikedUnMatchAdapter t13;
                UnMatchViewModel w13;
                UnMatchViewModel w14;
                kotlin.jvm.internal.s.i(list, "list");
                t12 = ContactLikedUnMatchActivity.this.t1();
                t12.w(list);
                ContactLikedUnMatchActivity.this.s1();
                w12 = ContactLikedUnMatchActivity.this.w1();
                if (w12.canLoadMore()) {
                    FKLoadMoreListener.a aVar = FKLoadMoreListener.f12038d;
                    RecyclerView un_match_rv = (RecyclerView) ContactLikedUnMatchActivity.this.n1(R$id.un_match_rv);
                    kotlin.jvm.internal.s.h(un_match_rv, "un_match_rv");
                    if (aVar.a(un_match_rv)) {
                        w14 = ContactLikedUnMatchActivity.this.w1();
                        w14.loadMore();
                        return;
                    }
                    return;
                }
                t13 = ContactLikedUnMatchActivity.this.t1();
                if (t13.j().size() < 3) {
                    w13 = ContactLikedUnMatchActivity.this.w1();
                    w13.refresh();
                }
            }
        }));
    }
}
