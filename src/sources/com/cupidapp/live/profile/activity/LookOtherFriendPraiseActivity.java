package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
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
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.adapter.FriendPraiseDetailAdapter;
import com.cupidapp.live.profile.adapter.FriendPraiseDetailPageType;
import com.cupidapp.live.profile.model.FriendPraiseDetailModel;
import com.cupidapp.live.profile.model.FriendPraiseResult;
import com.cupidapp.live.profile.model.LookOtherPraiseBundleData;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.view.FriendPraiseEditLayout;
import com.cupidapp.live.profile.view.FriendPraiseEmptyLayout;
import com.cupidapp.live.profile.viewmodel.LookOtherFriendPraiseViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: LookOtherFriendPraiseActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LookOtherFriendPraiseActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f17633v = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public LookOtherPraiseBundleData f17634q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17635r;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17638u = new LinkedHashMap();

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final FriendPraiseDetailAdapter f17636s = new FriendPraiseDetailAdapter();

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f17637t = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$mLoadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final LookOtherFriendPraiseActivity lookOtherFriendPraiseActivity = LookOtherFriendPraiseActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$mLoadMoreListener$2.1
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
                    LookOtherFriendPraiseViewModel u12;
                    u12 = LookOtherFriendPraiseActivity.this.u1();
                    u12.callOtherFriendPraiseApi(true);
                }
            });
        }
    });

    /* compiled from: LookOtherFriendPraiseActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull LookOtherPraiseBundleData data) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(data, "data");
            Intent intent = new Intent(context, (Class<?>) LookOtherFriendPraiseActivity.class);
            z0.g.c(intent, data);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public LookOtherFriendPraiseActivity() {
        final Function0 function0 = null;
        this.f17635r = new ViewModelLazy(kotlin.jvm.internal.v.b(LookOtherFriendPraiseViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$special$$inlined$viewModels$default$3
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

    public static final void B1(LookOtherFriendPraiseActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        LookOtherFriendPraiseViewModel.callOtherFriendPraiseApi$default(this$0.u1(), false, 1, null);
    }

    public static final void x1(LookOtherFriendPraiseActivity this$0, StateResult stateResult) {
        List<FriendPraiseDetailModel> list;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            FriendPraiseResult friendPraiseResult = (FriendPraiseResult) stateResult.getData();
            if (friendPraiseResult != null && (list = friendPraiseResult.getList()) != null) {
                Iterator<FriendPraiseDetailModel> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().setPageType(FriendPraiseDetailPageType.PRAISE_DETAIL);
                }
            }
            FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17636s;
            FriendPraiseResult friendPraiseResult2 = (FriendPraiseResult) stateResult.getData();
            friendPraiseDetailAdapter.u(friendPraiseResult2 != null ? friendPraiseResult2.getList() : null, stateResult.isLoadMore());
            if (kotlin.jvm.internal.s.d(stateResult.isLoadMore(), Boolean.FALSE)) {
                if (this$0.f17636s.w()) {
                    ((RecyclerView) this$0.n1(R$id.look_other_praise_recycler_view)).setVisibility(0);
                    ((FriendPraiseEmptyLayout) this$0.n1(R$id.look_other_praise_empty_layout)).setVisibility(8);
                } else {
                    ((RecyclerView) this$0.n1(R$id.look_other_praise_recycler_view)).setVisibility(4);
                    int i10 = R$id.look_other_praise_empty_layout;
                    ((FriendPraiseEmptyLayout) this$0.n1(i10)).setVisibility(0);
                    ((FriendPraiseEmptyLayout) this$0.n1(i10)).c(R$string.be_the_first_to_praise_him);
                }
            }
        }
        ((FKSwipeRefreshLayout) this$0.n1(R$id.look_other_praise_refresh_layout)).setRefreshing(false);
    }

    public static final void y1(LookOtherFriendPraiseActivity this$0, FriendPraiseDetailModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17636s;
        kotlin.jvm.internal.s.h(it, "it");
        friendPraiseDetailAdapter.z(it);
    }

    public static final void z1(LookOtherFriendPraiseActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        this$0.C1(it.booleanValue());
    }

    public final void A1(LookOtherPraiseBundleData lookOtherPraiseBundleData) {
        u1().initData(lookOtherPraiseBundleData);
        LookOtherFriendPraiseViewModel.callOtherFriendPraiseApi$default(u1(), false, 1, null);
        RecyclerView recyclerView = (RecyclerView) n1(R$id.look_other_praise_recycler_view);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.f17636s);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addOnScrollListener(t1());
        ((FKSwipeRefreshLayout) n1(R$id.look_other_praise_refresh_layout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.profile.activity.u
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                LookOtherFriendPraiseActivity.B1(LookOtherFriendPraiseActivity.this);
            }
        });
    }

    public final void C1(boolean z10) {
        LookOtherPraiseBundleData lookOtherPraiseBundleData = this.f17634q;
        String userId = lookOtherPraiseBundleData != null ? lookOtherPraiseBundleData.getUserId() : null;
        User X = p1.g.f52734a.X();
        if (kotlin.jvm.internal.s.d(userId, X != null ? X.userId() : null)) {
            ((FKUniversalButton) n1(R$id.write_about_him_btn)).setVisibility(4);
            ((TextView) n1(R$id.can_edit_praise_text)).setVisibility(0);
        } else if (z10) {
            ((FKUniversalButton) n1(R$id.write_about_him_btn)).setVisibility(0);
            ((TextView) n1(R$id.can_edit_praise_text)).setVisibility(8);
        } else {
            ((FKUniversalButton) n1(R$id.write_about_him_btn)).setVisibility(4);
            ((TextView) n1(R$id.can_edit_praise_text)).setVisibility(0);
        }
    }

    public final void D1(final FriendPraiseDetailModel friendPraiseDetailModel) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.report, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$showMoreActionSheetDialog$report$1
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, this, n0.f12353a.b(FriendPraiseDetailModel.this.getReportData(), this.Q0(), FriendPraiseDetailModel.this.getSenderId()), null, 4, null);
            }
        }, 30, null));
        FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PraiseDetail;
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f17638u;
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
        setContentView(R$layout.activity_look_other_friend_praise);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        LookOtherPraiseBundleData lookOtherPraiseBundleData = (LookOtherPraiseBundleData) z0.g.a(intent, LookOtherPraiseBundleData.class);
        if (lookOtherPraiseBundleData == null) {
            finish();
            return;
        }
        this.f17634q = lookOtherPraiseBundleData;
        A1(lookOtherPraiseBundleData);
        w1();
        s1();
        j1.c.b(j1.c.f50228a, Q0(), null, lookOtherPraiseBundleData.getSource().getValue(), 2, null);
    }

    public final void s1() {
        this.f17636s.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.praise_detail_praise_img), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$bindClickEvent$1
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
                LookOtherFriendPraiseViewModel u12;
                if (obj instanceof FriendPraiseDetailModel) {
                    u12 = LookOtherFriendPraiseActivity.this.u1();
                    u12.likeFriendPraise((FriendPraiseDetailModel) obj);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.praise_detail_more_img), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$bindClickEvent$2
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
                if (obj instanceof FriendPraiseDetailModel) {
                    LookOtherFriendPraiseActivity.this.D1((FriendPraiseDetailModel) obj);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.praise_detail_user_avatar_img), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$bindClickEvent$3
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
                if (obj instanceof FriendPraiseDetailModel) {
                    LookOtherFriendPraiseActivity.this.v1(((FriendPraiseDetailModel) obj).getSenderId());
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.praise_detail_user_name_text), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$bindClickEvent$4
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
                if (obj instanceof FriendPraiseDetailModel) {
                    LookOtherFriendPraiseActivity.this.v1(((FriendPraiseDetailModel) obj).getSenderId());
                }
            }
        })));
        ((FKTitleBarLayout) n1(R$id.look_other_praise_title_bar)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$bindClickEvent$5
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
                LookOtherFriendPraiseActivity.this.onBackPressed();
            }
        });
        FKUniversalButton write_about_him_btn = (FKUniversalButton) n1(R$id.write_about_him_btn);
        kotlin.jvm.internal.s.h(write_about_him_btn, "write_about_him_btn");
        z0.y.d(write_about_him_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$bindClickEvent$6
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
                LookOtherPraiseBundleData lookOtherPraiseBundleData;
                SensorsLogKeyButtonClick.LookOtherFriendPraise.EDIT.click();
                FriendPraiseEditLayout.Companion companion = FriendPraiseEditLayout.f17854h;
                LookOtherFriendPraiseActivity lookOtherFriendPraiseActivity = LookOtherFriendPraiseActivity.this;
                lookOtherPraiseBundleData = lookOtherFriendPraiseActivity.f17634q;
                companion.c(lookOtherFriendPraiseActivity, lookOtherPraiseBundleData != null ? lookOtherPraiseBundleData.getUserId() : null, LookOtherFriendPraiseActivity.this.Q0());
            }
        });
    }

    public final FKLoadMoreListener t1() {
        return (FKLoadMoreListener) this.f17637t.getValue();
    }

    public final LookOtherFriendPraiseViewModel u1() {
        return (LookOtherFriendPraiseViewModel) this.f17635r.getValue();
    }

    public final void v1(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.LookOtherFriendPraiseActivity$goToProfile$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                m2758invoke(profileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2758invoke(ProfileResult profileResult) {
                ProfileResult profileResult2 = profileResult;
                UserProfileActivity.a.b(UserProfileActivity.G, LookOtherFriendPraiseActivity.this, profileResult2.getUser(), new ProfileSensorContext(ViewProfilePrefer.FriendPraiseDetail.getValue(), null, profileResult2.getUser().getMe(), LookOtherFriendPraiseActivity.this.Q0(), null, null), false, null, null, null, false, 248, null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void w1() {
        u1().getOtherPraiseLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LookOtherFriendPraiseActivity.x1(LookOtherFriendPraiseActivity.this, (StateResult) obj);
            }
        });
        u1().getUpdateItemLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LookOtherFriendPraiseActivity.y1(LookOtherFriendPraiseActivity.this, (FriendPraiseDetailModel) obj);
            }
        });
        u1().getCanEditLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LookOtherFriendPraiseActivity.z1(LookOtherFriendPraiseActivity.this, (Boolean) obj);
            }
        });
    }
}
