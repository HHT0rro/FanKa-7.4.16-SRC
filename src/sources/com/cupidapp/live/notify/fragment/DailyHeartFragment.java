package com.cupidapp.live.notify.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.event.UserDataChangeEvent;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.view.TipUiModel;
import com.cupidapp.live.notify.adapter.DailyHeartAdapter;
import com.cupidapp.live.notify.logic.DailyHeartViewModel;
import com.cupidapp.live.notify.model.DailyHeartModel;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: DailyHeartFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DailyHeartFragment extends FKBaseFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f17536g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17537h = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17534e = kotlin.c.b(new Function0<DailyHeartAdapter>() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final DailyHeartAdapter invoke() {
            DailyHeartAdapter dailyHeartAdapter = new DailyHeartAdapter();
            final DailyHeartFragment dailyHeartFragment = DailyHeartFragment.this;
            dailyHeartAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$adapter$2$1$1
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
                    if (obj instanceof DailyHeartModel) {
                        DailyHeartModel dailyHeartModel = (DailyHeartModel) obj;
                        if (dailyHeartModel.getMosaic()) {
                            DailyHeartFragment.this.m1();
                        } else {
                            DailyHeartFragment.this.n1(dailyHeartModel);
                        }
                    }
                }
            });
            dailyHeartAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.followImageButton), new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$adapter$2$1$2
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
                    DailyHeartViewModel e12;
                    DailyHeartViewModel e13;
                    e12 = DailyHeartFragment.this.e1();
                    if (e12.getSVipRequired()) {
                        DailyHeartFragment.this.m1();
                    } else if (obj instanceof DailyHeartModel) {
                        e13 = DailyHeartFragment.this.e1();
                        e13.followUser(((DailyHeartModel) obj).getFromUser().getId());
                    }
                }
            })));
            return dailyHeartAdapter;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f17535f = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = DailyHeartFragment.this.getContext();
            Lifecycle lifecycle = DailyHeartFragment.this.getLifecycle();
            s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    public DailyHeartFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$special$$inlined$viewModels$default$1
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
        this.f17536g = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(DailyHeartViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$special$$inlined$viewModels$default$2
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
        }, null);
    }

    public static final void g1(DailyHeartFragment this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.W0(R$id.heart_beat_rl)).setRefreshing(false);
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

    public static final void h1(DailyHeartFragment this$0, String str) {
        s.i(this$0, "this$0");
        Iterator<Object> iterator2 = this$0.c1().j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            }
            Object next = iterator2.next();
            if ((next instanceof DailyHeartModel) && s.d(((DailyHeartModel) next).getFromUser().getId(), str)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            this$0.c1().j().remove(i10);
            this$0.c1().notifyDataSetChanged();
        }
        if (this$0.c1().j().size() <= 1) {
            this$0.e1().loadData();
        }
    }

    public static final void i1(final DailyHeartFragment this$0, Boolean it) {
        s.i(this$0, "this$0");
        s.h(it, "it");
        if (it.booleanValue()) {
            int i10 = R$id.heart_beat_buy_btn;
            ((TextView) this$0.W0(i10)).setVisibility(0);
            ((FrameLayout) this$0.W0(R$id.heart_beat_buy_rl)).setVisibility(0);
            TextView heart_beat_buy_btn = (TextView) this$0.W0(i10);
            s.h(heart_beat_buy_btn, "heart_beat_buy_btn");
            u.a(heart_beat_buy_btn);
            TextView heart_beat_buy_btn2 = (TextView) this$0.W0(i10);
            s.h(heart_beat_buy_btn2, "heart_beat_buy_btn");
            y.d(heart_beat_buy_btn2, new Function1<View, p>() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$initObserve$3$1
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
                    DailyHeartFragment.this.m1();
                    SensorsLogKeyButtonClick.DailyHeart.UNLOCK.click();
                }
            });
            return;
        }
        ((TextView) this$0.W0(R$id.heart_beat_buy_btn)).setVisibility(8);
        ((FrameLayout) this$0.W0(R$id.heart_beat_buy_rl)).setVisibility(8);
    }

    public static final void k1(DailyHeartFragment this$0) {
        s.i(this$0, "this$0");
        this$0.e1().loadData();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17537h.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.DailyHeart;
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17537h;
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

    public final DailyHeartAdapter c1() {
        return (DailyHeartAdapter) this.f17534e.getValue();
    }

    public final PurchaseDialogManager d1() {
        return (PurchaseDialogManager) this.f17535f.getValue();
    }

    public final DailyHeartViewModel e1() {
        return (DailyHeartViewModel) this.f17536g.getValue();
    }

    public final void f1() {
        e1().getListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.notify.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailyHeartFragment.g1(DailyHeartFragment.this, (StateResult) obj);
            }
        });
        e1().getUserFollowed().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.notify.fragment.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailyHeartFragment.h1(DailyHeartFragment.this, (String) obj);
            }
        });
        e1().getShowBuyBtn().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.notify.fragment.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DailyHeartFragment.i1(DailyHeartFragment.this, (Boolean) obj);
            }
        });
    }

    public final void j1() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), c1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$initView$manager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                DailyHeartAdapter c12;
                c12 = DailyHeartFragment.this.c1();
                return c12.u(i10);
            }
        });
        int i10 = R$id.heart_beat_rv;
        ((RecyclerView) W0(i10)).setLayoutManager(gridLayoutManager);
        ((RecyclerView) W0(i10)).setAdapter(c1());
        ((RecyclerView) W0(i10)).addItemDecoration(new MutableColumnDecoration(c1(), z0.h.c(this, 4.0f)));
        ((FKSwipeRefreshLayout) W0(R$id.heart_beat_rl)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.notify.fragment.n
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                DailyHeartFragment.k1(DailyHeartFragment.this);
            }
        });
        ((RecyclerView) W0(i10)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.notify.fragment.DailyHeartFragment$initView$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
                DailyHeartViewModel e12;
                boolean l12;
                s.i(recyclerView, "recyclerView");
                if (i12 > 0) {
                    e12 = DailyHeartFragment.this.e1();
                    if (e12.getSVipRequired()) {
                        l12 = DailyHeartFragment.this.l1();
                        if (l12) {
                            ((RecyclerView) DailyHeartFragment.this.W0(R$id.heart_beat_rv)).stopScroll();
                            DailyHeartFragment.this.m1();
                        }
                    }
                }
            }
        });
    }

    public final boolean l1() {
        return !((RecyclerView) W0(R$id.heart_beat_rv)).canScrollVertically(1);
    }

    public final void m1() {
        PurchaseDialogManager.q(d1(), VipPurchaseEntranceType.DailyHeart, null, null, false, false, 30, null);
    }

    public final void n1(DailyHeartModel dailyHeartModel) {
        TipUiModel tipUiModel;
        Context context = getContext();
        if (context != null) {
            NearByMiniProfileActivity.a aVar = NearByMiniProfileActivity.f16517r;
            NearbyUserModel fromUser = dailyHeartModel.getFromUser();
            SensorScene sensorScene = SensorScene.DailyHeart;
            String remainTime = dailyHeartModel.getRemainTime();
            if (remainTime != null) {
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
                String string = getString(R$string.not_show_time);
                s.h(string, "getString(R.string.not_show_time)");
                String format = String.format(string, Arrays.copyOf(new Object[]{remainTime}, 1));
                s.h(format, "format(format, *args)");
                tipUiModel = new TipUiModel(format, R$drawable.shape_black_alpha_50_bg_6_corners, ContextCompat.getColor(context, R$color.app_white));
            } else {
                tipUiModel = null;
            }
            aVar.a(context, fromUser, sensorScene, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : tipUiModel, (r27 & 32) != 0 ? false : e1().getSVipRequired(), (r27 & 64) != 0 ? null : VipPurchaseEntranceType.DailyHeart, (r27 & 128) != 0 ? null : SensorPosition.DailyHeart, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_heart_beat, viewGroup, false);
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
    public void onResume() {
        super.onResume();
        if (c1().j().size() <= 0) {
            e1().loadData();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        j1();
        f1();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserDataChangeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        e1().loadData();
    }
}
