package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentManager;
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
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.profile.activity.FriendPraiseActivity;
import com.cupidapp.live.profile.adapter.FriendPraiseDetailAdapter;
import com.cupidapp.live.profile.adapter.FriendPraiseDetailPageType;
import com.cupidapp.live.profile.model.FriendPraiseBundleData;
import com.cupidapp.live.profile.model.FriendPraiseDetailModel;
import com.cupidapp.live.profile.model.FriendPraiseResult;
import com.cupidapp.live.profile.model.FriendPraiseShareModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.view.FriendPraiseEmptyLayout;
import com.cupidapp.live.profile.viewmodel.FriendPraiseViewModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: FriendPraiseActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseActivity extends FKBaseActivity {

    @NotNull
    public static final a A = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17620q;

    /* renamed from: t, reason: collision with root package name */
    public boolean f17623t;

    /* renamed from: w, reason: collision with root package name */
    public boolean f17626w;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public FriendPraiseShareModel f17628y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17629z = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final FriendPraiseDetailAdapter f17621r = new FriendPraiseDetailAdapter();

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17622s = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$mReceivedLoadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FriendPraiseActivity friendPraiseActivity = FriendPraiseActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$mReceivedLoadMoreListener$2.1
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
                    FriendPraiseViewModel F1;
                    F1 = FriendPraiseActivity.this.F1();
                    F1.callReceivedFriendPraiseApi(true);
                }
            });
        }
    });

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final FriendPraiseDetailAdapter f17624u = new FriendPraiseDetailAdapter();

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public final Lazy f17625v = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$mSendLoadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FriendPraiseActivity friendPraiseActivity = FriendPraiseActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$mSendLoadMoreListener$2.1
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
                    FriendPraiseViewModel F1;
                    F1 = FriendPraiseActivity.this.F1();
                    F1.callSendFriendPraiseApi(true);
                }
            });
        }
    });

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public FriendPraisePageType f17627x = FriendPraisePageType.RECEIVED_PAGE;

    /* compiled from: FriendPraiseActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum FriendPraisePageType {
        RECEIVED_PAGE(0),
        SEND_PAGE(1);

        private final int value;

        FriendPraisePageType(int i10) {
            this.value = i10;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: FriendPraiseActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull FriendPraiseBundleData data) {
            kotlin.jvm.internal.s.i(data, "data");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) FriendPraiseActivity.class);
            z0.g.c(intent, data);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: FriendPraiseActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17630a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17631b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f17632c;

        static {
            int[] iArr = new int[FriendPraisePageType.values().length];
            try {
                iArr[FriendPraisePageType.RECEIVED_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FriendPraisePageType.SEND_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f17630a = iArr;
            int[] iArr2 = new int[FriendPraiseDetailPageType.values().length];
            try {
                iArr2[FriendPraiseDetailPageType.RECEIVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FriendPraiseDetailPageType.SEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f17631b = iArr2;
            int[] iArr3 = new int[SensorPosition.values().length];
            try {
                iArr3[SensorPosition.ReceivedPraise.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[SensorPosition.SendPraise.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f17632c = iArr3;
        }
    }

    public FriendPraiseActivity() {
        final Function0 function0 = null;
        this.f17620q = new ViewModelLazy(kotlin.jvm.internal.v.b(FriendPraiseViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$special$$inlined$viewModels$default$3
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

    public static final void I1(FriendPraiseActivity this$0, StateResult stateResult) {
        List<FriendPraiseDetailModel> list;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            FriendPraiseResult friendPraiseResult = (FriendPraiseResult) stateResult.getData();
            if (friendPraiseResult != null && (list = friendPraiseResult.getList()) != null) {
                Iterator<FriendPraiseDetailModel> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().setPageType(FriendPraiseDetailPageType.SEND);
                }
            }
            FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17624u;
            FriendPraiseResult friendPraiseResult2 = (FriendPraiseResult) stateResult.getData();
            friendPraiseDetailAdapter.u(friendPraiseResult2 != null ? friendPraiseResult2.getList() : null, stateResult.isLoadMore());
            if (kotlin.jvm.internal.s.d(stateResult.isLoadMore(), Boolean.FALSE) && this$0.f17627x == FriendPraisePageType.SEND_PAGE) {
                this$0.C1();
            }
        }
        ((FKSwipeRefreshLayout) this$0.s1(R$id.send_refresh_layout)).setRefreshing(false);
    }

    public static final void J1(FriendPraiseActivity this$0, FriendPraiseDetailModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17624u;
        kotlin.jvm.internal.s.h(it, "it");
        friendPraiseDetailAdapter.z(it);
    }

    public static final void K1(FriendPraiseActivity this$0, FriendPraiseDetailModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17624u;
        kotlin.jvm.internal.s.h(it, "it");
        friendPraiseDetailAdapter.v(it);
        if (this$0.f17627x == FriendPraisePageType.SEND_PAGE) {
            this$0.C1();
        }
        GroupSocialLog.f18708a.J(it.getId(), it.getUserId(), SensorPosition.SendPraise);
    }

    public static final void L1(FriendPraiseActivity this$0, StateResult stateResult) {
        List<FriendPraiseDetailModel> list;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            FriendPraiseResult friendPraiseResult = (FriendPraiseResult) stateResult.getData();
            this$0.f17628y = friendPraiseResult != null ? friendPraiseResult.getShare() : null;
            FriendPraiseResult friendPraiseResult2 = (FriendPraiseResult) stateResult.getData();
            if (friendPraiseResult2 != null && (list = friendPraiseResult2.getList()) != null) {
                Iterator<FriendPraiseDetailModel> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().setPageType(FriendPraiseDetailPageType.RECEIVED);
                }
            }
            FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17621r;
            FriendPraiseResult friendPraiseResult3 = (FriendPraiseResult) stateResult.getData();
            friendPraiseDetailAdapter.u(friendPraiseResult3 != null ? friendPraiseResult3.getList() : null, stateResult.isLoadMore());
            if (kotlin.jvm.internal.s.d(stateResult.isLoadMore(), Boolean.FALSE) && this$0.f17627x == FriendPraisePageType.RECEIVED_PAGE) {
                this$0.C1();
            }
        }
        ((FKSwipeRefreshLayout) this$0.s1(R$id.received_refresh_layout)).setRefreshing(false);
    }

    public static final void M1(FriendPraiseActivity this$0, FriendPraiseDetailModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17621r;
        kotlin.jvm.internal.s.h(it, "it");
        friendPraiseDetailAdapter.z(it);
    }

    public static final void N1(FriendPraiseActivity this$0, FriendPraiseDetailModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17621r;
        kotlin.jvm.internal.s.h(it, "it");
        friendPraiseDetailAdapter.v(it);
        if (this$0.f17627x == FriendPraisePageType.RECEIVED_PAGE) {
            this$0.C1();
        }
        GroupSocialLog.f18708a.J(it.getId(), it.getSenderId(), SensorPosition.ReceivedPraise);
    }

    public static final void O1(FriendPraiseActivity this$0, FriendPraiseDetailModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FriendPraiseDetailAdapter friendPraiseDetailAdapter = this$0.f17621r;
        kotlin.jvm.internal.s.h(it, "it");
        friendPraiseDetailAdapter.y(it);
    }

    public static final void Q1(FriendPraiseActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FriendPraiseViewModel.callReceivedFriendPraiseApi$default(this$0.F1(), false, 1, null);
    }

    public static final void R1(FriendPraiseActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FriendPraiseViewModel.callSendFriendPraiseApi$default(this$0.F1(), false, 1, null);
    }

    public final void B1() {
        ((FKTitleBarLayout) s1(R$id.friend_praise_title_bar)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$1
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
                FriendPraiseActivity.this.onBackPressed();
            }
        });
        FKUniversalButton share_to_friend_btn = (FKUniversalButton) s1(R$id.share_to_friend_btn);
        kotlin.jvm.internal.s.h(share_to_friend_btn, "share_to_friend_btn");
        z0.y.d(share_to_friend_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$2
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
                FriendPraiseActivity.this.W1();
            }
        });
        com.cupidapp.live.base.recyclerview.d l10 = this.f17621r.l();
        Integer valueOf = Integer.valueOf(R$id.praise_detail_praise_img);
        Integer valueOf2 = Integer.valueOf(R$id.praise_detail_more_img);
        Integer valueOf3 = Integer.valueOf(R$id.praise_detail_user_avatar_img);
        Integer valueOf4 = Integer.valueOf(R$id.praise_detail_user_name_text);
        l10.j(i0.h(kotlin.f.a(valueOf, new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$3
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
                FriendPraiseViewModel F1;
                if (obj instanceof FriendPraiseDetailModel) {
                    F1 = FriendPraiseActivity.this.F1();
                    F1.likeFriendPraise((FriendPraiseDetailModel) obj, true);
                }
            }
        }), kotlin.f.a(valueOf2, new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$4
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
                    FriendPraiseActivity.this.U1((FriendPraiseDetailModel) obj, true);
                }
            }
        }), kotlin.f.a(valueOf3, new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$5
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
                    FriendPraiseActivity.this.G1(((FriendPraiseDetailModel) obj).getSenderId(), true);
                }
            }
        }), kotlin.f.a(valueOf4, new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$6
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
                    FriendPraiseActivity.this.G1(((FriendPraiseDetailModel) obj).getSenderId(), true);
                }
            }
        })));
        this.f17624u.l().j(i0.h(kotlin.f.a(valueOf, new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$7
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
                FriendPraiseViewModel F1;
                if (obj instanceof FriendPraiseDetailModel) {
                    F1 = FriendPraiseActivity.this.F1();
                    F1.likeFriendPraise((FriendPraiseDetailModel) obj, false);
                }
            }
        }), kotlin.f.a(valueOf2, new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$8
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
                    FriendPraiseActivity.this.U1((FriendPraiseDetailModel) obj, false);
                }
            }
        }), kotlin.f.a(valueOf3, new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$9
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
                    FriendPraiseActivity.this.G1(((FriendPraiseDetailModel) obj).getUserId(), false);
                }
            }
        }), kotlin.f.a(valueOf4, new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$bindClickEvent$10
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
                    FriendPraiseActivity.this.G1(((FriendPraiseDetailModel) obj).getUserId(), false);
                }
            }
        })));
    }

    public final void C1() {
        int i10 = b.f17630a[this.f17627x.ordinal()];
        if (i10 == 1) {
            if (this.f17621r.w()) {
                V1(true);
                return;
            } else {
                T1(true);
                return;
            }
        }
        if (i10 != 2) {
            return;
        }
        if (this.f17624u.w()) {
            V1(false);
        } else {
            T1(false);
        }
    }

    public final FKLoadMoreListener D1() {
        return (FKLoadMoreListener) this.f17622s.getValue();
    }

    public final FKLoadMoreListener E1() {
        return (FKLoadMoreListener) this.f17625v.getValue();
    }

    public final FriendPraiseViewModel F1() {
        return (FriendPraiseViewModel) this.f17620q.getValue();
    }

    public final void G1(String str, final boolean z10) {
        if (str == null || str.length() == 0) {
            return;
        }
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$goToProfile$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                m2757invoke(profileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2757invoke(ProfileResult profileResult) {
                ViewProfilePrefer viewProfilePrefer;
                ProfileResult profileResult2 = profileResult;
                if (z10) {
                    viewProfilePrefer = ViewProfilePrefer.ReceivedFriendPraise;
                } else {
                    viewProfilePrefer = ViewProfilePrefer.SendFriendPraise;
                }
                UserProfileActivity.G.a(this, profileResult2.getUser(), new ProfileSensorContext(viewProfilePrefer.getValue(), null, profileResult2.getUser().getMe(), this.Q0(), null, null), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void H1() {
        F1().getReceivedLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FriendPraiseActivity.L1(FriendPraiseActivity.this, (StateResult) obj);
            }
        });
        F1().getReceivedUpdateItemData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FriendPraiseActivity.M1(FriendPraiseActivity.this, (FriendPraiseDetailModel) obj);
            }
        });
        F1().getReceivedDeleteItemData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FriendPraiseActivity.N1(FriendPraiseActivity.this, (FriendPraiseDetailModel) obj);
            }
        });
        F1().getReceivedShowInProfile().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FriendPraiseActivity.O1(FriendPraiseActivity.this, (FriendPraiseDetailModel) obj);
            }
        });
        F1().getSendLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FriendPraiseActivity.I1(FriendPraiseActivity.this, (StateResult) obj);
            }
        });
        F1().getSendUpdateItemData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FriendPraiseActivity.J1(FriendPraiseActivity.this, (FriendPraiseDetailModel) obj);
            }
        });
        F1().getSendDeleteItemData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FriendPraiseActivity.K1(FriendPraiseActivity.this, (FriendPraiseDetailModel) obj);
            }
        });
    }

    public final void P1() {
        FriendPraiseViewModel.callReceivedFriendPraiseApi$default(F1(), false, 1, null);
        FriendPraiseViewModel.callSendFriendPraiseApi$default(F1(), false, 1, null);
        List m10 = kotlin.collections.s.m(getString(R$string.i_received), getString(R$string.i_sent));
        int i10 = R$id.friend_praise_title_bar;
        FKTitleBarLayout friend_praise_title_bar = (FKTitleBarLayout) s1(i10);
        kotlin.jvm.internal.s.h(friend_praise_title_bar, "friend_praise_title_bar");
        FKTitleBarLayout.f(friend_praise_title_bar, new com.cupidapp.live.base.view.p(m10, 0.0f, 0, 0, false, 30, null), null, this.f17627x.getValue(), null, 8, null);
        ((FKTitleBarLayout) s1(i10)).setTabClickCallback(new Function2<Integer, Boolean, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$initView$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i11, boolean z10) {
                FriendPraiseActivity.FriendPraisePageType friendPraisePageType;
                friendPraisePageType = FriendPraiseActivity.this.f17627x;
                if (i11 != friendPraisePageType.getValue()) {
                    FriendPraiseActivity friendPraiseActivity = FriendPraiseActivity.this;
                    FriendPraiseActivity.FriendPraisePageType friendPraisePageType2 = FriendPraiseActivity.FriendPraisePageType.RECEIVED_PAGE;
                    if (i11 != friendPraisePageType2.getValue()) {
                        friendPraisePageType2 = FriendPraiseActivity.FriendPraisePageType.SEND_PAGE;
                        if (i11 != friendPraisePageType2.getValue()) {
                            friendPraisePageType2 = FriendPraiseActivity.this.f17627x;
                        }
                    }
                    friendPraiseActivity.f17627x = friendPraisePageType2;
                    FriendPraiseActivity.this.C1();
                    FriendPraiseActivity.this.S1();
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) s1(R$id.received_recycler_view);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.f17621r);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addOnScrollListener(D1());
        ((FKSwipeRefreshLayout) s1(R$id.received_refresh_layout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.profile.activity.q
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FriendPraiseActivity.Q1(FriendPraiseActivity.this);
            }
        });
        RecyclerView recyclerView2 = (RecyclerView) s1(R$id.send_recycler_view);
        recyclerView2.setItemAnimator(null);
        recyclerView2.setAdapter(this.f17624u);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.addOnScrollListener(E1());
        ((FKSwipeRefreshLayout) s1(R$id.send_refresh_layout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.profile.activity.p
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FriendPraiseActivity.R1(FriendPraiseActivity.this);
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        int i10 = b.f17630a[this.f17627x.ordinal()];
        if (i10 == 1) {
            return SensorPosition.ReceivedPraise;
        }
        if (i10 == 2) {
            return SensorPosition.SendPraise;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void S1() {
        if (this.f17623t && this.f17626w) {
            return;
        }
        SensorPosition Q0 = Q0();
        int i10 = b.f17632c[Q0.ordinal()];
        if (i10 == 1) {
            this.f17623t = true;
        } else if (i10 == 2) {
            this.f17626w = true;
        }
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        FriendPraiseBundleData friendPraiseBundleData = (FriendPraiseBundleData) z0.g.a(intent, FriendPraiseBundleData.class);
        SensorPosition source = friendPraiseBundleData != null ? friendPraiseBundleData.getSource() : null;
        j1.c.b(j1.c.f50228a, Q0, null, source != null ? source.getValue() : null, 2, null);
    }

    public final void T1(boolean z10) {
        ((FKSwipeRefreshLayout) s1(R$id.received_refresh_layout)).setVisibility(8);
        ((RecyclerView) s1(R$id.received_recycler_view)).setVisibility(8);
        ((FKSwipeRefreshLayout) s1(R$id.send_refresh_layout)).setVisibility(8);
        ((RecyclerView) s1(R$id.send_recycler_view)).setVisibility(8);
        ((FKUniversalButton) s1(R$id.share_to_friend_btn)).setVisibility(8);
        int i10 = R$id.feed_praise_empty_layout;
        ((FriendPraiseEmptyLayout) s1(i10)).setVisibility(0);
        ((FriendPraiseEmptyLayout) s1(i10)).d(z10, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$showEmptyLayout$1
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
                FriendPraiseActivity.this.W1();
            }
        });
    }

    public final void U1(final FriendPraiseDetailModel friendPraiseDetailModel, final boolean z10) {
        FKActionSheetItemModel fKActionSheetItemModel;
        ArrayList arrayList = new ArrayList();
        if (kotlin.jvm.internal.s.d(friendPraiseDetailModel.getHomePageDisplay(), Boolean.TRUE)) {
            fKActionSheetItemModel = new FKActionSheetItemModel(R$string.remove_profile_display, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$showMoreActionSheetDialog$profileDisplay$1
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
                    FriendPraiseViewModel F1;
                    F1 = FriendPraiseActivity.this.F1();
                    F1.showFriendPraiseInProfile(friendPraiseDetailModel, false);
                }
            }, 30, null);
        } else {
            fKActionSheetItemModel = new FKActionSheetItemModel(R$string.set_as_profile_display, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$showMoreActionSheetDialog$profileDisplay$2
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
                    FriendPraiseViewModel F1;
                    F1 = FriendPraiseActivity.this.F1();
                    F1.showFriendPraiseInProfile(friendPraiseDetailModel, true);
                }
            }, 30, null);
        }
        FKActionSheetItemModel fKActionSheetItemModel2 = new FKActionSheetItemModel(R$string.report, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$showMoreActionSheetDialog$report$1
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
        }, 30, null);
        FKActionSheetItemModel fKActionSheetItemModel3 = new FKActionSheetItemModel(R$string.delete_friend_praise, ActionSheetItemType.Warning, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FriendPraiseActivity$showMoreActionSheetDialog$delete$1
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
                FriendPraiseViewModel F1;
                F1 = FriendPraiseActivity.this.F1();
                F1.deleteFriendPraise(friendPraiseDetailModel, z10);
            }
        }, 28, null);
        int i10 = b.f17631b[friendPraiseDetailModel.getPageType().ordinal()];
        if (i10 == 1) {
            arrayList.add(fKActionSheetItemModel);
            arrayList.add(fKActionSheetItemModel2);
            arrayList.add(fKActionSheetItemModel3);
        } else if (i10 == 2) {
            arrayList.add(fKActionSheetItemModel3);
        }
        if (!arrayList.isEmpty()) {
            FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
        }
    }

    public final void V1(boolean z10) {
        RecyclerView received_recycler_view = (RecyclerView) s1(R$id.received_recycler_view);
        kotlin.jvm.internal.s.h(received_recycler_view, "received_recycler_view");
        received_recycler_view.setVisibility(z10 ? 0 : 8);
        FKSwipeRefreshLayout received_refresh_layout = (FKSwipeRefreshLayout) s1(R$id.received_refresh_layout);
        kotlin.jvm.internal.s.h(received_refresh_layout, "received_refresh_layout");
        received_refresh_layout.setVisibility(z10 ? 0 : 8);
        RecyclerView send_recycler_view = (RecyclerView) s1(R$id.send_recycler_view);
        kotlin.jvm.internal.s.h(send_recycler_view, "send_recycler_view");
        send_recycler_view.setVisibility(z10 ^ true ? 0 : 8);
        FKSwipeRefreshLayout send_refresh_layout = (FKSwipeRefreshLayout) s1(R$id.send_refresh_layout);
        kotlin.jvm.internal.s.h(send_refresh_layout, "send_refresh_layout");
        send_refresh_layout.setVisibility(z10 ^ true ? 0 : 8);
        ((FKUniversalButton) s1(R$id.share_to_friend_btn)).setVisibility(z10 ? 0 : 8);
        ((FriendPraiseEmptyLayout) s1(R$id.feed_praise_empty_layout)).setVisibility(8);
    }

    public final void W1() {
        SensorsLogKeyButtonClick.ReceivedFriendPraise.SHARE.click();
        User X = p1.g.f52734a.X();
        List m10 = kotlin.collections.s.m(SharePlatform.QQ, SharePlatform.QZone, SharePlatform.Weibo, SharePlatform.Copylink);
        FriendPraiseShareModel friendPraiseShareModel = this.f17628y;
        String url = friendPraiseShareModel != null ? friendPraiseShareModel.getUrl() : null;
        FriendPraiseShareModel friendPraiseShareModel2 = this.f17628y;
        String title = friendPraiseShareModel2 != null ? friendPraiseShareModel2.getTitle() : null;
        FriendPraiseShareModel friendPraiseShareModel3 = this.f17628y;
        String content = friendPraiseShareModel3 != null ? friendPraiseShareModel3.getContent() : null;
        FriendPraiseShareModel friendPraiseShareModel4 = this.f17628y;
        ShareModel shareModel = new ShareModel(X != null ? X.userId() : null, null, new ShareBuilder(url, title, content, friendPraiseShareModel4 != null ? friendPraiseShareModel4.getImg() : null, this, X != null ? X.userId() : null, null, X != null ? X.userId() : null, X != null ? X.userId() : null, X != null ? X.getName() : null, null, 0, null, null, null, 31808, null), null, null, SensorPosition.ReceivedPraise, null, null, m10, null, null, 1754, null);
        ShareBottomFragment a10 = ShareBottomFragment.f12224k.a();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.s.h(supportFragmentManager, "supportFragmentManager");
        ShareBottomFragment.w1(a10, supportFragmentManager, shareModel, null, 4, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_friend_praise);
        P1();
        H1();
        B1();
        S1();
    }

    @Nullable
    public View s1(int i10) {
        Map<Integer, View> map = this.f17629z;
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
}
