package com.cupidapp.live.match.fragment;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b3.a;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.appdialog.model.RateScene;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationRefreshTimeInterval;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.NestingRecyclerView;
import com.cupidapp.live.filter.model.FilterTopOptionsUiModel;
import com.cupidapp.live.filter.model.FilterTopRangeUiModel;
import com.cupidapp.live.filter.model.FilterTopTabModel;
import com.cupidapp.live.filter.model.FilterTopTabUiBaseModel;
import com.cupidapp.live.filter.model.TabLayoutStyle;
import com.cupidapp.live.filter.util.ContactFilterRangeBarPopupHelper;
import com.cupidapp.live.filter.view.FilterTopTabLayout;
import com.cupidapp.live.match.activity.FKMatchFilterNewActivity;
import com.cupidapp.live.match.activity.MapFilterNewActivity;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.activity.NearMatchActivity;
import com.cupidapp.live.match.activity.NearbySuperBoostActivity;
import com.cupidapp.live.match.adapter.FKNearByAdapter;
import com.cupidapp.live.match.event.CloseNearbyUserProfileEvent;
import com.cupidapp.live.match.event.MapIsUsingEvent;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.helper.FKRequestLocationDialogHelper;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.MapDataModel;
import com.cupidapp.live.match.model.NearByTopTipModel;
import com.cupidapp.live.match.model.NearMatchModel;
import com.cupidapp.live.match.model.NearbyListModel;
import com.cupidapp.live.match.model.NearbyLocationFailedViewModel;
import com.cupidapp.live.match.model.NearbyNoBodyViewModel;
import com.cupidapp.live.match.model.NearbyResult;
import com.cupidapp.live.match.model.NearbySameCityRecommendViewModel;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.match.view.FKNearByPermissionRequestLayout;
import com.cupidapp.live.match.view.NearByExposureLayout;
import com.cupidapp.live.match.view.NearByMatchLayout;
import com.cupidapp.live.match.view.PlayOrStopSuperBoostAnimationEvent;
import com.cupidapp.live.match.view.TopTipLayout;
import com.cupidapp.live.superboost.dialog.SuperBoostManager;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.VipDiscountDescription;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.google.android.material.appbar.AppBarLayout;
import com.irisdt.client.others.OthersProtos;
import io.reactivex.Observable;
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
import kotlin.jvm.functions.Function2;
import okhttp3.FormBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKNearByFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKNearByFragment extends FKBaseFragment {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f16655f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16659j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16660k;

    /* renamed from: l, reason: collision with root package name */
    public float f16661l;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public AnimatorSet f16666q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public Disposable f16667r;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16669t = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f16654e = kotlin.c.b(new Function0<FKNearByAdapter>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$userListAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKNearByAdapter invoke() {
            return new FKNearByAdapter();
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f16656g = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FKNearByFragment fKNearByFragment = FKNearByFragment.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$loadMoreListener$2.1
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
                    String str;
                    String str2;
                    str = FKNearByFragment.this.f16655f;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    FKNearByFragment fKNearByFragment2 = FKNearByFragment.this;
                    str2 = fKNearByFragment2.f16655f;
                    fKNearByFragment2.Q1(str2);
                }
            });
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<NearbyUserModel> f16657h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f16658i = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = FKNearByFragment.this.getContext();
            Lifecycle lifecycle = FKNearByFragment.this.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f16662m = kotlin.c.b(new Function0<ValueAnimator>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$showMapFloatViewAnim$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ValueAnimator invoke() {
            return ValueAnimator.ofFloat(1.0f, 0.0f);
        }
    });

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final Lazy f16663n = kotlin.c.b(new Function0<ValueAnimator>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$hideMapFloatViewAnim$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ValueAnimator invoke() {
            return ValueAnimator.ofFloat(0.0f, 1.0f);
        }
    });

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public final Lazy f16664o = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(FKNearByFragment.this);
        }
    });

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public final List<ImageModel> f16665p = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public TabLayoutStyle f16668s = TabLayoutStyle.RED_BLACK;

    /* compiled from: FKNearByFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements VipDiscountDescription.a {
        public a() {
        }

        @Override // com.cupidapp.live.vip.VipDiscountDescription.a
        public void a(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ((LinearLayout) FKNearByFragment.this.X0(R$id.discountPromptLayout)).setVisibility(0);
            ((TextView) FKNearByFragment.this.X0(R$id.discountPromptTextView)).setText(str);
        }
    }

    /* compiled from: FKNearByFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.match.view.z {
        public b() {
        }

        @Override // com.cupidapp.live.match.view.z
        public void a() {
            NearbySuperBoostActivity.f16531v.a(FKNearByFragment.this.getContext());
        }

        @Override // com.cupidapp.live.match.view.z
        public void b() {
            SuperBoostManager.f18580a.j(FKNearByFragment.this.getContext(), FKNearByFragment.this.S1(), SensorPosition.Nearby.getValue(), null);
        }
    }

    /* compiled from: FKNearByFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements com.cupidapp.live.match.view.v {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MapDataModel f16673b;

        public c(MapDataModel mapDataModel) {
            this.f16673b = mapDataModel;
        }

        @Override // com.cupidapp.live.match.view.v
        public void a() {
            if (FKNearByFragment.this.f16659j) {
                FKNearByFragment.this.u2();
                return;
            }
            Context context = FKNearByFragment.this.getContext();
            if (context != null) {
                MapDataModel mapDataModel = this.f16673b;
                NearMatchActivity.f16524v.a(context, mapDataModel.getMatchList(), mapDataModel.getNextMatchCursorId(), FKNearByFragment.this.f16660k);
            }
        }
    }

    public static /* synthetic */ void R1(FKNearByFragment fKNearByFragment, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        fKNearByFragment.Q1(str);
    }

    public static final void a2(FKNearByFragment this$0, final View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if ((this$0.O1().isPaused() || !(this$0.O1().isRunning() || this$0.O1().isStarted())) && view.getTranslationX() < view.getWidth()) {
            this$0.V1().pause();
            final float translationX = view.getTranslationX();
            final int width = view.getWidth();
            this$0.O1().setDuration(300L);
            this$0.O1().addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.match.fragment.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FKNearByFragment.b2(View.this, translationX, width, valueAnimator);
                }
            });
            this$0.O1().start();
        }
    }

    public static final void b2(View view, float f10, int i10, ValueAnimator it) {
        kotlin.jvm.internal.s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.s.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        view.setTranslationX(f10 + (i10 * floatValue));
        if (floatValue == 1.0f) {
            view.setVisibility(8);
        }
    }

    public static final void h2(FKNearByFragment this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (!this$0.f16659j) {
            this$0.o2();
        } else {
            ((FKSwipeRefreshLayout) this$0.X0(R$id.nearbySwipeRefreshLayout)).setRefreshing(false);
        }
    }

    public static final void s2(FKNearByFragment this$0, final View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if ((this$0.V1().isPaused() || !(this$0.V1().isStarted() || this$0.V1().isRunning())) && view.getTranslationX() > 0.0f) {
            this$0.O1().pause();
            view.setVisibility(0);
            final float translationX = view.getTranslationX();
            this$0.V1().setDuration(300L);
            this$0.V1().addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.match.fragment.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FKNearByFragment.t2(View.this, translationX, valueAnimator);
                }
            });
            this$0.V1().start();
        }
    }

    public static final void t2(View view, float f10, ValueAnimator it) {
        kotlin.jvm.internal.s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.s.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setTranslationX(((Float) animatedValue).floatValue() * f10);
    }

    public final void F1() {
        LocationUtils.Companion companion = LocationUtils.f12270h;
        if (companion.d(getContext())) {
            ((FKSwipeRefreshLayout) X0(R$id.nearbySwipeRefreshLayout)).setEnabled(false);
            ((FKNearByPermissionRequestLayout) X0(R$id.nearbyLocationPermissionLayout)).setVisibility(0);
            q2();
            H1();
            return;
        }
        if (W1().n() <= 0) {
            ((FKSwipeRefreshLayout) X0(R$id.nearbySwipeRefreshLayout)).setEnabled(true);
            ((FKNearByPermissionRequestLayout) X0(R$id.nearbyLocationPermissionLayout)).setVisibility(8);
            if (companion.a().f()) {
                d2();
                return;
            } else {
                R1(this, null, 1, null);
                return;
            }
        }
        ((FKSwipeRefreshLayout) X0(R$id.nearbySwipeRefreshLayout)).setEnabled(true);
        ((FKNearByPermissionRequestLayout) X0(R$id.nearbyLocationPermissionLayout)).setVisibility(8);
        j2();
    }

    public final boolean G1(NearbyResult nearbyResult) {
        PurchaseProductType a10;
        if (nearbyResult.getMapData() == null) {
            a10 = PurchaseProductType.Companion.a(PurchaseProductType.VIP.getValue(), nearbyResult.getVipType());
        } else {
            a10 = PurchaseProductType.Companion.a(PurchaseProductType.SVIP.getValue(), nearbyResult.getVipType());
        }
        return a10 != PurchaseProductType.NO;
    }

    public final void H1() {
        if (this.f16660k) {
            this.f16668s = TabLayoutStyle.GOLD;
            ((FilterTopTabLayout) X0(R$id.filter_tab)).k(this.f16668s);
        } else {
            this.f16668s = TabLayoutStyle.RED_BLACK;
            ((FilterTopTabLayout) X0(R$id.filter_tab)).k(this.f16668s);
        }
        ((FilterTopTabLayout) X0(R$id.filter_tab)).setVisibility(0);
        Observable<Result<FilterTopTabModel>> r10 = NetworkClient.f11868a.N().r(0);
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = r10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FilterTopTabModel, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$checkShowFilterTab$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FilterTopTabModel filterTopTabModel) {
                m2709invoke(filterTopTabModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2709invoke(FilterTopTabModel filterTopTabModel) {
                TabLayoutStyle tabLayoutStyle;
                xb.b T1;
                FilterTopTabLayout filterTopTabLayout = (FilterTopTabLayout) FKNearByFragment.this.X0(R$id.filter_tab);
                tabLayoutStyle = FKNearByFragment.this.f16668s;
                SensorPosition O0 = FKNearByFragment.this.O0();
                T1 = FKNearByFragment.this.T1();
                filterTopTabLayout.l(filterTopTabModel, tabLayoutStyle, O0, "NEARBY_", T1);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        c2();
    }

    public final void I1() {
        Disposable disposed = NetworkClient.f11868a.A().n().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NearByTopTipModel, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$checkShowFloat$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NearByTopTipModel nearByTopTipModel) {
                m2710invoke(nearByTopTipModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2710invoke(NearByTopTipModel nearByTopTipModel) {
                ((TopTipLayout) FKNearByFragment.this.X0(R$id.top_tip)).f(nearByTopTipModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$checkShowFloat$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                ((TopTipLayout) FKNearByFragment.this.X0(R$id.top_tip)).e();
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void J1(boolean z10) {
        if (!z10) {
            int i10 = R$id.map_entrance;
            X0(i10).setVisibility(0);
            View map_entrance = X0(i10);
            kotlin.jvm.internal.s.h(map_entrance, "map_entrance");
            z0.y.d(map_entrance, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$checkShowMapEntrance$1
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
                    xb.b T1;
                    Context context = FKNearByFragment.this.getContext();
                    if (context != null) {
                        final FKNearByFragment fKNearByFragment = FKNearByFragment.this;
                        LocationUtils.Companion companion = LocationUtils.f12270h;
                        T1 = fKNearByFragment.T1();
                        companion.e(context, T1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$checkShowMapEntrance$1$1$1
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
                                CoordinateModel j10 = LocationUtils.f12270h.a().j();
                                Context context2 = FKNearByFragment.this.getContext();
                                if (context2 != null) {
                                    MapFilterNewActivity.f16502z.a(context2, Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude()), FKNearByFragment.this.O0(), VipPurchaseEntranceType.NearByMapFilter);
                                }
                            }
                        });
                    }
                }
            });
            return;
        }
        X0(R$id.map_entrance).setVisibility(8);
    }

    public final void K1() {
        if (isVisible()) {
            p2();
        }
    }

    public final void L1(MapDataModel mapDataModel) {
        if (mapDataModel == null) {
            this.f16660k = false;
            p1.g.f52734a.J2(VipPurchaseEntranceType.NearByMapFilter);
            EventBus.c().l(new MapIsUsingEvent(false));
            X0(R$id.location_new_use).setVisibility(8);
            J1(false);
            return;
        }
        this.f16660k = true;
        J1(true);
        EventBus.c().l(new MapIsUsingEvent(true));
        int i10 = R$id.location_new_use;
        X0(i10).setVisibility(0);
        TextView configMapTipView$lambda$6 = (TextView) X0(i10).findViewById(R$id.location_tip_pos);
        configMapTipView$lambda$6.setText(mapDataModel.getAddress());
        kotlin.jvm.internal.s.h(configMapTipView$lambda$6, "configMapTipView$lambda$6");
        z0.u.a(configMapTipView$lambda$6);
        View findViewById = X0(i10).findViewById(R$id.location_tip_close);
        kotlin.jvm.internal.s.h(findViewById, "location_new_use.findVie…(R.id.location_tip_close)");
        z0.y.d(findViewById, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$configMapTipView$2
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
                Observable<Result<Object>> u10 = NetworkClient.f11868a.A().u(null, null, null, null, null, null, true);
                final FKNearByFragment fKNearByFragment = FKNearByFragment.this;
                Disposable disposed = u10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$configMapTipView$2$invoke$$inlined$handle$default$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        p1.g.f52734a.J2(VipPurchaseEntranceType.NearByMapFilter);
                        FKNearByFragment.this.f16660k = false;
                        EventBus.c().l(new MapIsUsingEvent(false));
                        FKNearByFragment.this.o2();
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, fKNearByFragment)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (fKNearByFragment != null) {
                        fKNearByFragment.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
    }

    public final void M1() {
        W1().l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$configViewHolderClickEvent$1
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
                SensorScene U1;
                SensorScene U12;
                if (obj instanceof NearbyListModel) {
                    NearbyUserModel nearbyUser = ((NearbyListModel) obj).getNearbyUser();
                    if (!nearbyUser.getHide() && !FKNearByFragment.this.f16659j) {
                        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                        U1 = FKNearByFragment.this.U1();
                        groupSocialLog.u(U1.getValue(), nearbyUser.getId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                        NearByMiniProfileActivity.a aVar = NearByMiniProfileActivity.f16517r;
                        Context context = FKNearByFragment.this.getContext();
                        U12 = FKNearByFragment.this.U1();
                        aVar.a(context, nearbyUser, U12, (r27 & 8) != 0 ? false : FKNearByFragment.this.f16660k, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : SensorPosition.Nearby, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : false);
                        return;
                    }
                    FKNearByFragment.this.u2();
                }
            }
        });
        W1().l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.nearby_location_fail_retry_Btn), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$configViewHolderClickEvent$2
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
                if (obj instanceof NearbyLocationFailedViewModel) {
                    FKNearByFragment.this.d2();
                }
            }
        })));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16669t.clear();
    }

    public final void N1() {
        VipDiscountDescription.f18726b.b(this, new a());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.Nearby;
    }

    public final ValueAnimator O1() {
        return (ValueAnimator) this.f16663n.getValue();
    }

    public final FKLoadMoreListener P1() {
        return (FKLoadMoreListener) this.f16656g.getValue();
    }

    public final void Q1(final String str) {
        int i10 = R$id.nearbySwipeRefreshLayout;
        if (((FKSwipeRefreshLayout) X0(i10)) == null) {
            return;
        }
        if (str == null) {
            FKSwipeRefreshLayout fKSwipeRefreshLayout = (FKSwipeRefreshLayout) X0(i10);
            if (fKSwipeRefreshLayout != null) {
                fKSwipeRefreshLayout.setRefreshing(true);
            }
            RecyclerExposureHelper.a aVar = RecyclerExposureHelper.f12092j;
            aVar.d(ExposureScene.Nearby);
            aVar.d(ExposureScene.SuperBoost);
            aVar.d(ExposureScene.NearbyMatch);
        }
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        Disposable disposed = a.C0021a.b(NetworkClient.f11868a.A(), Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude()), 0, str, 4, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NearbyResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$getNearbyData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NearbyResult nearbyResult) {
                m2711invoke(nearbyResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2711invoke(NearbyResult nearbyResult) {
                FKLoadMoreListener P1;
                boolean G1;
                ArrayList<NearMatchModel> matchList;
                NearbyResult nearbyResult2 = nearbyResult;
                if (String.this == null) {
                    FKNearByFragment fKNearByFragment = this;
                    G1 = fKNearByFragment.G1(nearbyResult2);
                    fKNearByFragment.f16659j = G1;
                    this.L1(nearbyResult2.getMapData());
                    this.H1();
                    List<NearbyUserModel> superboostList = nearbyResult2.getSuperboostList();
                    if (superboostList != null && (superboostList.isEmpty() ^ true)) {
                        this.k2(nearbyResult2.getSuperboostList());
                    } else {
                        MapDataModel mapData = nearbyResult2.getMapData();
                        if ((mapData == null || (matchList = mapData.getMatchList()) == null || !(matchList.isEmpty() ^ true)) ? false : true) {
                            this.l2(nearbyResult2.getMapData());
                        } else {
                            ((RelativeLayout) this.X0(R$id.head)).setVisibility(8);
                        }
                    }
                }
                this.f16655f = nearbyResult2.getNextCursorId();
                if (nearbyResult2.getInsufficient()) {
                    this.g2(nearbyResult2.getMessage());
                } else if (this.f16659j) {
                    this.x2(nearbyResult2);
                } else {
                    this.Y1(nearbyResult2, String.this);
                }
                ((FKSwipeRefreshLayout) this.X0(R$id.nearbySwipeRefreshLayout)).setRefreshing(false);
                P1 = this.P1();
                P1.c(false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$getNearbyData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener P1;
                kotlin.jvm.internal.s.i(it, "it");
                ((FKSwipeRefreshLayout) FKNearByFragment.this.X0(R$id.nearbySwipeRefreshLayout)).setRefreshing(false);
                P1 = FKNearByFragment.this.P1();
                P1.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final PurchaseDialogManager S1() {
        return (PurchaseDialogManager) this.f16658i.getValue();
    }

    public final xb.b T1() {
        return (xb.b) this.f16664o.getValue();
    }

    public final SensorScene U1() {
        return this.f16660k ? SensorScene.MapFind : SensorScene.Nearby;
    }

    public final ValueAnimator V1() {
        return (ValueAnimator) this.f16662m.getValue();
    }

    public final FKNearByAdapter W1() {
        return (FKNearByAdapter) this.f16654e.getValue();
    }

    @Nullable
    public View X0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16669t;
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

    public final void X1() {
        final Context context = getContext();
        if (context != null) {
            LocationUtils.f12270h.e(context, T1(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$gotoMapFilterActivity$1$1
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
                    CoordinateModel j10 = LocationUtils.f12270h.a().j();
                    Context context2 = context;
                    if (context2 != null) {
                        MapFilterNewActivity.f16502z.a(context2, Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude()), this.O0(), VipPurchaseEntranceType.NearByMapFilter);
                    }
                }
            });
        }
    }

    public final void Y1(NearbyResult nearbyResult, String str) {
        boolean z10 = true;
        ((FKSwipeRefreshLayout) X0(R$id.nearbySwipeRefreshLayout)).setEnabled(true);
        ((RelativeLayout) X0(R$id.vipGuideLayout)).setVisibility(8);
        if (str == null) {
            this.f16657h.clear();
            W1().j().clear();
            W1().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
            p1.g.f52734a.O1();
        }
        int size = W1().j().size();
        List<List<NearbyUserModel>> sameCityList = nearbyResult.getSameCityList();
        if (!(sameCityList == null || sameCityList.isEmpty())) {
            W1().d(new NearbySameCityRecommendViewModel(nearbyResult.getSameCityList(), this.f16660k));
            W1().notifyDataSetChanged();
            Iterator<List<NearbyUserModel>> iterator2 = nearbyResult.getSameCityList().iterator2();
            while (iterator2.hasNext()) {
                this.f16657h.addAll(iterator2.next());
            }
        }
        List<NearbyUserModel> list = nearbyResult.getList();
        if (list != null) {
            FKNearByAdapter W1 = W1();
            ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
            Iterator<NearbyUserModel> iterator22 = list.iterator2();
            while (iterator22.hasNext()) {
                arrayList.add(new NearbyListModel(iterator22.next()));
            }
            W1.e(arrayList);
            this.f16657h.addAll(list);
        }
        String nextCursorId = nearbyResult.getNextCursorId();
        if (nextCursorId == null || nextCursorId.length() == 0) {
            Context context = getContext();
            String string = context != null ? context.getString(R$string.nearby_footer_title, Integer.valueOf(this.f16657h.size())) : null;
            FKFooterViewModel h10 = W1().h();
            if (h10 != null) {
                h10.modifyParam(false, true, string, -5658199);
            }
        } else {
            FKFooterViewModel h11 = W1().h();
            if (h11 != null) {
                FKFooterViewModel.modifyParam$default(h11, true, false, null, 0, 14, null);
            }
        }
        if (size > 0 && str != null) {
            String nextCursorId2 = nearbyResult.getNextCursorId();
            if (nextCursorId2 != null && nextCursorId2.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                W1().notifyItemRangeInserted(size - 1, W1().j().size() - size);
                return;
            }
        }
        W1().notifyDataSetChanged();
    }

    public final void Z1(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.cupidapp.live.match.fragment.h
                @Override // java.lang.Runnable
                public final void run() {
                    FKNearByFragment.a2(FKNearByFragment.this, view);
                }
            });
        }
    }

    public final void c2() {
        ((FilterTopTabLayout) X0(R$id.filter_tab)).setClickListener(new com.cupidapp.live.filter.view.a() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$initFilterTabClick$1
            @Override // com.cupidapp.live.filter.view.a
            public void a(@NotNull final FilterTopTabUiBaseModel model) {
                xb.b T1;
                kotlin.jvm.internal.s.i(model, "model");
                if (FKNearByFragment.this.f16659j) {
                    FKNearByFragment.this.u2();
                    return;
                }
                Context context = FKNearByFragment.this.getContext();
                if (context != null) {
                    final FKNearByFragment fKNearByFragment = FKNearByFragment.this;
                    LocationUtils.Companion companion = LocationUtils.f12270h;
                    T1 = fKNearByFragment.T1();
                    companion.e(context, T1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$initFilterTabClick$1$tabClick$1$1
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
                            ((FilterTopTabLayout) FKNearByFragment.this.X0(R$id.filter_tab)).u(model);
                        }
                    });
                }
            }

            @Override // com.cupidapp.live.filter.view.a
            public void b() {
                FKMatchFilterNewActivity.f16488t.a(FKNearByFragment.this.getContext(), true, false, "");
            }

            @Override // com.cupidapp.live.filter.view.a
            public void c(@NotNull FilterTopTabUiBaseModel model) {
                kotlin.jvm.internal.s.i(model, "model");
                FKNearByFragment.this.i2(model);
            }
        });
    }

    public final void d2() {
        W1().j().clear();
        for (int i10 = 0; i10 < 24; i10++) {
            W1().d(new NearbyListModel(new NearbyUserModel(null, false, false, false, false, false, null, null, null, null, true, false, false, null, null, null, null, false, false, false, null, 2095422, null)));
        }
        W1().notifyDataSetChanged();
        LocationUtils.o(LocationUtils.f12270h.a(), getContext(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$initNearbyData$2
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
                FKNearByFragment fKNearByFragment = FKNearByFragment.this;
                int i11 = R$id.nearbySwipeRefreshLayout;
                if (((FKSwipeRefreshLayout) fKNearByFragment.X0(i11)) == null) {
                    return;
                }
                ((FKSwipeRefreshLayout) FKNearByFragment.this.X0(i11)).setEnabled(true);
                FKNearByFragment.R1(FKNearByFragment.this, null, 1, null);
            }
        }, new Function2<Integer, String, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$initNearbyData$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, String str) {
                invoke2(num, str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num, @Nullable String str) {
                FKNearByAdapter W1;
                FKNearByAdapter W12;
                FKNearByAdapter W13;
                FKNearByFragment fKNearByFragment = FKNearByFragment.this;
                int i11 = R$id.nearbySwipeRefreshLayout;
                if (((FKSwipeRefreshLayout) fKNearByFragment.X0(i11)) == null) {
                    return;
                }
                W1 = FKNearByFragment.this.W1();
                W1.j().clear();
                W12 = FKNearByFragment.this.W1();
                W12.d(new NearbyLocationFailedViewModel(num));
                W13 = FKNearByFragment.this.W1();
                W13.notifyDataSetChanged();
                ((FKSwipeRefreshLayout) FKNearByFragment.this.X0(i11)).setEnabled(false);
            }
        }, null, 8, null);
    }

    public final void e2() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) getActivity(), W1().v(), 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$initRecyclerView$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                FKNearByAdapter W1;
                W1 = FKNearByFragment.this.W1();
                return W1.u(i10);
            }
        });
        int i10 = R$id.userRecyclerView;
        ((NestingRecyclerView) X0(i10)).setLayoutManager(gridLayoutManager);
        M1();
        ((NestingRecyclerView) X0(i10)).setAdapter(W1());
        ((NestingRecyclerView) X0(i10)).addItemDecoration(new MutableColumnDecoration(W1(), z0.h.c(this, 1.0f)));
        ((NestingRecyclerView) X0(i10)).addOnScrollListener(P1());
        P1().d(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$initRecyclerView$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
                List list;
                boolean f22;
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
                if (i12 > 0 && FKNearByFragment.this.f16659j) {
                    f22 = FKNearByFragment.this.f2();
                    if (f22) {
                        ((NestingRecyclerView) FKNearByFragment.this.X0(R$id.userRecyclerView)).stopScroll();
                        FKNearByFragment.this.u2();
                        return;
                    }
                }
                list = FKNearByFragment.this.f16665p;
                if (!list.isEmpty()) {
                    if (i12 > 2) {
                        FKNearByFragment fKNearByFragment = FKNearByFragment.this;
                        fKNearByFragment.Z1(fKNearByFragment.X0(R$id.float_ll));
                    } else if (i12 < -2) {
                        FKNearByFragment fKNearByFragment2 = FKNearByFragment.this;
                        int i13 = R$id.float_ll;
                        fKNearByFragment2.X0(i13).setVisibility(0);
                        FKNearByFragment fKNearByFragment3 = FKNearByFragment.this;
                        fKNearByFragment3.r2(fKNearByFragment3.X0(i13));
                    }
                }
            }
        });
        ((NestingRecyclerView) X0(i10)).addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$initRecyclerView$3
            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(@NotNull RecyclerView rv, @NotNull MotionEvent e2) {
                float f10;
                boolean f22;
                kotlin.jvm.internal.s.i(rv, "rv");
                kotlin.jvm.internal.s.i(e2, "e");
                int action = e2.getAction();
                if (action != 0) {
                    if (action != 2 || !FKNearByFragment.this.f16659j) {
                        return false;
                    }
                    float y10 = e2.getY();
                    f10 = FKNearByFragment.this.f16661l;
                    if (y10 - f10 >= 0.0f) {
                        return false;
                    }
                    f22 = FKNearByFragment.this.f2();
                    if (!f22) {
                        return false;
                    }
                    FKNearByFragment.this.u2();
                    return true;
                }
                FKNearByFragment.this.f16661l = e2.getY();
                return false;
            }
        });
        RecyclerView.ItemAnimator itemAnimator = ((NestingRecyclerView) X0(i10)).getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        FKNearByAdapter W1 = W1();
        ExposureScene exposureScene = ExposureScene.Nearby;
        NestingRecyclerView userRecyclerView = (NestingRecyclerView) X0(i10);
        kotlin.jvm.internal.s.h(userRecyclerView, "userRecyclerView");
        W1.t(new RecyclerExposureHelper(exposureScene, userRecyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$initRecyclerView$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> itemList) {
                SensorScene U1;
                kotlin.jvm.internal.s.i(itemList, "itemList");
                FKNearByFragment fKNearByFragment = FKNearByFragment.this;
                Iterator<h1.a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof NearbyListModel) {
                        NearbyListModel nearbyListModel = (NearbyListModel) a10;
                        if (!nearbyListModel.getNearbyUser().getHide()) {
                            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                            U1 = fKNearByFragment.U1();
                            String value = U1.getValue();
                            String id2 = nearbyListModel.getNearbyUser().getId();
                            String travelCity = nearbyListModel.getNearbyUser().getTravelCity();
                            boolean z10 = false;
                            if (travelCity != null) {
                                if (travelCity.length() > 0) {
                                    z10 = true;
                                }
                            }
                            groupSocialLog.w(value, id2, (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : z10);
                        }
                    }
                }
            }
        }, 28, null));
    }

    public final boolean f2() {
        RecyclerView.LayoutManager layoutManager = ((NestingRecyclerView) X0(R$id.userRecyclerView)).getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        return gridLayoutManager != null && gridLayoutManager.findLastCompletelyVisibleItemPosition() >= W1().v() * 4;
    }

    public final void g2(String str) {
        ((RelativeLayout) X0(R$id.vipGuideLayout)).setVisibility(8);
        W1().j().clear();
        W1().d(new NearbyNoBodyViewModel(str));
        W1().notifyDataSetChanged();
        GroupOthersLog.W(GroupOthersLog.f18702a, SensorPosition.Nearby, null, 2, null);
    }

    public final void i2(FilterTopTabUiBaseModel filterTopTabUiBaseModel) {
        FormBody.Builder builder = new FormBody.Builder(null, 1, 0 == true ? 1 : 0);
        String key = filterTopTabUiBaseModel.getKey();
        builder.add("scene", "0");
        builder.add("filterKey", key);
        if (filterTopTabUiBaseModel instanceof FilterTopRangeUiModel) {
            String str = key + "[]";
            FilterTopRangeUiModel filterTopRangeUiModel = (FilterTopRangeUiModel) filterTopTabUiBaseModel;
            RangeMatchFilterViewModel filterModel = filterTopRangeUiModel.getFilterModel();
            builder.add(str, String.valueOf(filterModel != null ? Integer.valueOf(filterModel.getMin()) : null));
            String str2 = key + "[]";
            RangeMatchFilterViewModel filterModel2 = filterTopRangeUiModel.getFilterModel();
            builder.add(str2, String.valueOf(filterModel2 != null ? Integer.valueOf(filterModel2.getMax()) : null));
        } else if (filterTopTabUiBaseModel instanceof FilterTopOptionsUiModel) {
            for (FilterOption filterOption : ((FilterTopOptionsUiModel) filterTopTabUiBaseModel).getOptions()) {
                if (filterOption.getChecked()) {
                    builder.add(key + "[]", filterOption.getId());
                }
            }
        }
        Disposable disposed = NetworkClient.f11868a.N().w(builder.build()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$postFilterTabs$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                p1.g.f52734a.c();
                FKNearByFragment.this.j2();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void j2() {
        if (((FKNearByPermissionRequestLayout) X0(R$id.nearbyLocationPermissionLayout)).getVisibility() == 0) {
            q2();
            return;
        }
        p1.g gVar = p1.g.f52734a;
        if (gVar.g0() != VipPurchaseEntranceType.NearByMapFilter || (com.cupidapp.live.profile.logic.c.f17839a.f() && gVar.b())) {
            p2();
        }
    }

    public final void k2(List<NearbyUserModel> list) {
        ((RelativeLayout) X0(R$id.head)).setVisibility(0);
        int i10 = R$id.exposure_layout;
        ((NearByExposureLayout) X0(i10)).setVisibility(0);
        ((NearByMatchLayout) X0(R$id.near_layout)).setVisibility(8);
        NearByExposureLayout nearByExposureLayout = (NearByExposureLayout) X0(i10);
        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
        Iterator<NearbyUserModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new NearbyListModel(iterator2.next()));
        }
        nearByExposureLayout.g(arrayList, new b());
    }

    public final void l2(MapDataModel mapDataModel) {
        ((RelativeLayout) X0(R$id.head)).setVisibility(0);
        int i10 = R$id.near_layout;
        ((NearByMatchLayout) X0(i10)).setVisibility(0);
        ((NearByExposureLayout) X0(R$id.exposure_layout)).setVisibility(8);
        NearByMatchLayout nearByMatchLayout = (NearByMatchLayout) X0(i10);
        List<NearMatchModel> matchList = mapDataModel.getMatchList();
        if (matchList == null) {
            matchList = kotlin.collections.s.j();
        }
        nearByMatchLayout.g(matchList, mapDataModel.getMatchCount(), new c(mapDataModel));
    }

    public final void m2(NearbyResult nearbyResult) {
        ((RelativeLayout) X0(R$id.vipGuideLayout)).setVisibility(0);
        int i10 = R$id.vipGuideButton;
        TextView vipGuideButton = (TextView) X0(i10);
        kotlin.jvm.internal.s.h(vipGuideButton, "vipGuideButton");
        z0.u.a(vipGuideButton);
        if (this.f16660k) {
            ((TextView) X0(i10)).setTextColor(-15066598);
            ((TextView) X0(i10)).setBackgroundResource(R$mipmap.near_svip_bg);
            if (nearbyResult.getVipType() == PurchaseProductType.VIP.getValue()) {
                ((TextView) X0(i10)).setText(getString(R$string.up_svip_unlock_map));
                return;
            } else {
                ((TextView) X0(i10)).setText(getString(R$string.purchase_svip_unlock_map));
                return;
            }
        }
        ((TextView) X0(i10)).setTextColor(-1);
        ((TextView) X0(i10)).setBackgroundResource(R$drawable.shape_red_bg_thirty_one_corners);
        TextView textView = (TextView) X0(i10);
        Context context = getContext();
        textView.setText(context != null ? context.getString(R$string.vip_guide_prompt, z0.q.b(nearbyResult.getFindCount())) : null);
    }

    public final void n2() {
        if (com.cupidapp.live.profile.logic.c.f17839a.f()) {
            j1.c cVar = j1.c.f50228a;
            SensorPosition sensorPosition = SensorPosition.Nearby;
            j1.c.b(cVar, sensorPosition, sensorPosition.getValue(), null, 4, null);
        } else {
            j1.c cVar2 = j1.c.f50228a;
            SensorPosition sensorPosition2 = SensorPosition.NotVipNearby;
            j1.c.b(cVar2, sensorPosition2, sensorPosition2.getValue(), null, 4, null);
        }
    }

    public final void o2() {
        LocationUtils.Companion companion = LocationUtils.f12270h;
        if (companion.a().q(LocationRefreshTimeInterval.NearbyInterval.getInterval())) {
            LocationUtils.o(companion.a(), getContext(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$resetLocationAndGetNearbyData$1
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
                    FKNearByFragment.R1(FKNearByFragment.this, null, 1, null);
                }
            }, new Function2<Integer, String, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$resetLocationAndGetNearbyData$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, String str) {
                    invoke2(num, str);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Integer num, @Nullable String str) {
                    FKNearByFragment.R1(FKNearByFragment.this, null, 1, null);
                }
            }, null, 8, null);
        } else {
            R1(this, null, 1, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z0.z.b(viewGroup, R$layout.fragment_nearby, false, 2, null);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AnimatorSet animatorSet = this.f16666q;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Disposable disposable = this.f16667r;
        if (disposable != null) {
            disposable.dispose();
        }
        V1().removeAllUpdateListeners();
        O1().removeAllUpdateListeners();
        TopTipLayout topTipLayout = (TopTipLayout) X0(R$id.top_tip);
        if (topTipLayout != null) {
            topTipLayout.e();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull CloseNearbyUserProfileEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        n2();
        Context context = getContext();
        if (context != null) {
            new FKAppRatingLayout(context).p(RateScene.LeaveNearbyFollow);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10) {
            n2();
            j2();
            v2();
        } else {
            int i10 = R$id.userRecyclerView;
            if (((NestingRecyclerView) X0(i10)).getScrollState() == 2) {
                ((NestingRecyclerView) X0(i10)).stopScroll();
            }
            w2();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (isVisible()) {
            w2();
        }
        ContactFilterRangeBarPopupHelper.f14616a.d();
        super.onPause();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!FKRxPermissionAlertDialog.f12016a.f()) {
            F1();
        }
        if (!isHidden()) {
            Fragment parentFragment = getParentFragment();
            boolean z10 = false;
            if (parentFragment != null && !parentFragment.isHidden()) {
                z10 = true;
            }
            if (z10 && !NearByMiniProfileFragment.f16699r.a()) {
                n2();
            }
        }
        if (isVisible()) {
            v2();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        I1();
        FKRequestLocationDialogHelper.f16752a.c(getContext(), T1(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$onViewCreated$1
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
                FKNearByFragment.this.F1();
            }
        });
        e2();
        ((FKSwipeRefreshLayout) X0(R$id.nearbySwipeRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.match.fragment.f
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FKNearByFragment.h2(FKNearByFragment.this);
            }
        });
        TextView vipGuideButton = (TextView) X0(R$id.vipGuideButton);
        kotlin.jvm.internal.s.h(vipGuideButton, "vipGuideButton");
        z0.y.d(vipGuideButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$onViewCreated$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                invoke2(view2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                SensorsLogKeyButtonClick.Nearby.OpenVipSeeNearbyUser.click();
                FKNearByFragment.this.u2();
            }
        });
        View float_ll = X0(R$id.float_ll);
        kotlin.jvm.internal.s.h(float_ll, "float_ll");
        z0.y.d(float_ll, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKNearByFragment$onViewCreated$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                invoke2(view2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
                    FKNearByFragment.this.X1();
                } else {
                    PurchaseDialogManager S1 = FKNearByFragment.this.S1();
                    VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.NearByMapFloatFilter;
                    PurchaseDialogManager.q(S1, vipPurchaseEntranceType, null, null, false, false, 30, null);
                    z3.d.f54832a.j(vipPurchaseEntranceType.getFrom());
                }
                GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.NEARBY_SEARCH_ON_MAP_BUBBLE, null, null, 6, null);
            }
        });
    }

    public final void p2() {
        ((NestingRecyclerView) X0(R$id.userRecyclerView)).scrollToPosition(0);
        o2();
        ((AppBarLayout) X0(R$id.appbarLayout)).setExpanded(true, false);
    }

    public final void q2() {
        FKNearByPermissionRequestLayout nearbyLocationPermissionLayout = (FKNearByPermissionRequestLayout) X0(R$id.nearbyLocationPermissionLayout);
        kotlin.jvm.internal.s.h(nearbyLocationPermissionLayout, "nearbyLocationPermissionLayout");
        String string = getString(R$string.authorize_app_permission);
        kotlin.jvm.internal.s.h(string, "getString(R.string.authorize_app_permission)");
        String string2 = getString(R$string.authorize_aloha_permission_match);
        kotlin.jvm.internal.s.h(string2, "getString(R.string.autho…e_aloha_permission_match)");
        PermissionType permissionType = PermissionType.LocationPermission;
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.s.g(activity, "null cannot be cast to non-null type com.cupidapp.live.MainActivity");
        FKNearByPermissionRequestLayout.c(nearbyLocationPermissionLayout, string, string2, permissionType, true, ((MainActivity) activity).X1(), false, 0, 96, null);
    }

    public final void r2(final View view) {
        if (view != null) {
            view.post(new Runnable() { // from class: com.cupidapp.live.match.fragment.g
                @Override // java.lang.Runnable
                public final void run() {
                    FKNearByFragment.s2(FKNearByFragment.this, view);
                }
            });
        }
    }

    public final void u2() {
        TopTipLayout topTipLayout = (TopTipLayout) X0(R$id.top_tip);
        if (topTipLayout != null) {
            topTipLayout.e();
        }
        if (this.f16660k) {
            PurchaseDialogManager.q(S1(), p1.g.f52734a.g0(), null, null, false, false, 30, null);
        } else {
            PurchaseDialogManager.j(S1(), VipPurchaseEntranceType.Nearby, null, null, false, 14, null);
        }
    }

    public final void v2() {
        EventBus.c().l(new PlayOrStopSuperBoostAnimationEvent(true));
    }

    public final void w2() {
        EventBus.c().l(new PlayOrStopSuperBoostAnimationEvent(false));
    }

    public final void x2(NearbyResult nearbyResult) {
        p1.g.f52734a.c();
        ((FKSwipeRefreshLayout) X0(R$id.nearbySwipeRefreshLayout)).setEnabled(false);
        W1().j().clear();
        List<NearbyUserModel> list = nearbyResult.getList();
        if (!(list == null || list.isEmpty())) {
            FKNearByAdapter W1 = W1();
            List<NearbyUserModel> list2 = nearbyResult.getList();
            ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list2, 10));
            Iterator<NearbyUserModel> iterator2 = list2.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new NearbyListModel(iterator2.next()));
            }
            W1.e(arrayList);
        }
        W1().notifyDataSetChanged();
        m2(nearbyResult);
        N1();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowPurchaseDialogEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        TopTipLayout topTipLayout = (TopTipLayout) X0(R$id.top_tip);
        if (topTipLayout != null) {
            topTipLayout.e();
        }
        if (this.f16660k) {
            S1().l(p1.g.f52734a.g0(), "", PurchaseProductType.SVIP.getValue());
        } else {
            S1().l(event.getEntranceType(), event.getSensorFrom(), event.getProductType().getValue());
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        R1(this, null, 1, null);
    }
}
