package com.cupidapp.live.profile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.notify.adapter.FollowYouPurchaseAdapter;
import com.cupidapp.live.notify.logic.FollowYouUserNeedPurchaseViewModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: FollowYouUserNeedPurchaseListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FollowYouUserNeedPurchaseListFragment extends FKBaseFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f17750i = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f17753g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17754h = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17751e = kotlin.c.b(new Function0<FollowYouPurchaseAdapter>() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FollowYouPurchaseAdapter invoke() {
            FollowYouPurchaseAdapter followYouPurchaseAdapter = new FollowYouPurchaseAdapter();
            final FollowYouUserNeedPurchaseListFragment followYouUserNeedPurchaseListFragment = FollowYouUserNeedPurchaseListFragment.this;
            followYouPurchaseAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$adapter$2$1$1
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
                    if (obj instanceof User) {
                        User user = (User) obj;
                        if (user.getShowMosaic()) {
                            FollowYouUserNeedPurchaseListFragment.this.n1();
                        } else {
                            FollowYouUserNeedPurchaseListFragment.this.m1(user);
                        }
                    }
                }
            });
            followYouPurchaseAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.followImageButton), new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$adapter$2$1$2
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
                    FollowYouUserNeedPurchaseViewModel e12;
                    if (obj instanceof User) {
                        e12 = FollowYouUserNeedPurchaseListFragment.this.e1();
                        e12.followUser(((User) obj).userId());
                    }
                }
            })));
            return followYouPurchaseAdapter;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f17752f = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = FollowYouUserNeedPurchaseListFragment.this.getContext();
            Lifecycle lifecycle = FollowYouUserNeedPurchaseListFragment.this.getLifecycle();
            s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* compiled from: FollowYouUserNeedPurchaseListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FollowYouUserNeedPurchaseListFragment a() {
            return new FollowYouUserNeedPurchaseListFragment();
        }
    }

    public FollowYouUserNeedPurchaseListFragment() {
        FollowYouUserNeedPurchaseListFragment$viewModel$2 followYouUserNeedPurchaseListFragment$viewModel$2 = new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        s.i(p02, "p0");
                        return new FollowYouUserNeedPurchaseViewModel();
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        };
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$special$$inlined$viewModels$default$1
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
        this.f17753g = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(FollowYouUserNeedPurchaseViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, followYouUserNeedPurchaseListFragment$viewModel$2);
    }

    public static final void g1(FollowYouUserNeedPurchaseListFragment this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.W0(R$id.follow_you_rl)).setRefreshing(false);
        if (stateResult instanceof StateResult.c) {
            this$0.c1().j().clear();
            this$0.c1().e((List) stateResult.getData());
            this$0.c1().notifyDataSetChanged();
        } else if (stateResult instanceof StateResult.a) {
            Collection collection = (Collection) stateResult.getData();
            if (collection == null || collection.isEmpty()) {
                return;
            }
            this$0.c1().j().clear();
            this$0.c1().e((List) stateResult.getData());
            this$0.c1().notifyDataSetChanged();
        }
    }

    public static final void h1(FollowYouUserNeedPurchaseListFragment this$0, User user) {
        Object obj;
        s.i(this$0, "this$0");
        Iterator<Object> iterator2 = this$0.c1().j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if ((obj instanceof User) && s.d(((User) obj).userId(), user.userId())) {
                    break;
                }
            }
        }
        if (obj == null || !(obj instanceof User)) {
            return;
        }
        User user2 = (User) obj;
        user2.setAloha(user.getAloha());
        user2.setMatch(user.getMatch());
        this$0.c1().y(user2);
    }

    public static final void i1(final FollowYouUserNeedPurchaseListFragment this$0, Boolean it) {
        s.i(this$0, "this$0");
        s.h(it, "it");
        if (it.booleanValue()) {
            int i10 = R$id.follow_you_buy_btn;
            ((TextView) this$0.W0(i10)).setVisibility(0);
            ((FrameLayout) this$0.W0(R$id.follow_you_buy_rl)).setVisibility(0);
            TextView follow_you_buy_btn = (TextView) this$0.W0(i10);
            s.h(follow_you_buy_btn, "follow_you_buy_btn");
            u.a(follow_you_buy_btn);
            TextView follow_you_buy_btn2 = (TextView) this$0.W0(i10);
            s.h(follow_you_buy_btn2, "follow_you_buy_btn");
            y.d(follow_you_buy_btn2, new Function1<View, p>() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$initObserve$3$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    FollowYouUserNeedPurchaseListFragment.this.n1();
                }
            });
            return;
        }
        ((TextView) this$0.W0(R$id.follow_you_buy_btn)).setVisibility(8);
        ((FrameLayout) this$0.W0(R$id.follow_you_buy_rl)).setVisibility(8);
    }

    public static final void k1(FollowYouUserNeedPurchaseListFragment this$0) {
        s.i(this$0, "this$0");
        this$0.e1().loadData();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17754h.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.MyAlohaGet;
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17754h;
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

    public final FollowYouPurchaseAdapter c1() {
        return (FollowYouPurchaseAdapter) this.f17751e.getValue();
    }

    public final PurchaseDialogManager d1() {
        return (PurchaseDialogManager) this.f17752f.getValue();
    }

    public final FollowYouUserNeedPurchaseViewModel e1() {
        return (FollowYouUserNeedPurchaseViewModel) this.f17753g.getValue();
    }

    public final void f1() {
        e1().getListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.profile.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FollowYouUserNeedPurchaseListFragment.g1(FollowYouUserNeedPurchaseListFragment.this, (StateResult) obj);
            }
        });
        e1().getUserFollowed().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.profile.fragment.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FollowYouUserNeedPurchaseListFragment.h1(FollowYouUserNeedPurchaseListFragment.this, (User) obj);
            }
        });
        e1().getShowBuyBtn().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.profile.fragment.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FollowYouUserNeedPurchaseListFragment.i1(FollowYouUserNeedPurchaseListFragment.this, (Boolean) obj);
            }
        });
    }

    public final void j1() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), c1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$initView$manager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                FollowYouPurchaseAdapter c12;
                c12 = FollowYouUserNeedPurchaseListFragment.this.c1();
                return c12.u(i10);
            }
        });
        int i10 = R$id.follow_you_rv;
        ((RecyclerView) W0(i10)).setLayoutManager(gridLayoutManager);
        ((RecyclerView) W0(i10)).setAdapter(c1());
        ((RecyclerView) W0(i10)).addItemDecoration(new MutableColumnDecoration(c1(), z0.h.c(this, 8.0f)));
        ((FKSwipeRefreshLayout) W0(R$id.follow_you_rl)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.profile.fragment.h
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FollowYouUserNeedPurchaseListFragment.k1(FollowYouUserNeedPurchaseListFragment.this);
            }
        });
        ((RecyclerView) W0(i10)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment$initView$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
                FollowYouUserNeedPurchaseViewModel e12;
                boolean l12;
                s.i(recyclerView, "recyclerView");
                if (i12 > 0) {
                    e12 = FollowYouUserNeedPurchaseListFragment.this.e1();
                    if (s.d(e12.getShowBuyBtn().getValue(), Boolean.TRUE)) {
                        l12 = FollowYouUserNeedPurchaseListFragment.this.l1();
                        if (l12) {
                            ((RecyclerView) FollowYouUserNeedPurchaseListFragment.this.W0(R$id.follow_you_rv)).stopScroll();
                            FollowYouUserNeedPurchaseListFragment.this.n1();
                        }
                    }
                }
            }
        });
        FollowYouPurchaseAdapter c12 = c1();
        RecyclerView follow_you_rv = (RecyclerView) W0(i10);
        s.h(follow_you_rv, "follow_you_rv");
        c12.z(follow_you_rv);
    }

    public final boolean l1() {
        return !((RecyclerView) W0(R$id.follow_you_rv)).canScrollVertically(1);
    }

    public final void m1(User user) {
        String value = ViewProfilePrefer.FollowerToProfile.getValue();
        boolean me2 = user.getMe();
        SensorPosition sensorPosition = SensorPosition.MyAlohaGet;
        SensorScene sensorScene = SensorScene.FollowerList;
        UserProfileActivity.a.b(UserProfileActivity.G, getContext(), user, new ProfileSensorContext(value, null, me2, sensorPosition, null, sensorScene), true, null, null, null, false, 240, null);
        GroupSocialLog.f18708a.u(sensorScene.getValue(), user.userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
    }

    public final void n1() {
        PurchaseDialogManager.q(d1(), VipPurchaseEntranceType.MyAlohaGet, null, null, false, false, 30, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_follow_you_need_purchase, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        e1().loadData();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        j1();
        f1();
        e1().loadData();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        e1().refreshFollowButton(event.getUser());
    }
}
