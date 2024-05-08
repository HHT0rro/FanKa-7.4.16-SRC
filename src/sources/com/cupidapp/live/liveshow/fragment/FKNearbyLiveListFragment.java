package com.cupidapp.live.liveshow.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationRefreshTimeInterval;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.activity.LiveshowOpenSource;
import com.cupidapp.live.liveshow.model.LiveListResult;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.PermissionRequestLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;

/* compiled from: FKNearbyLiveListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKNearbyLiveListFragment extends FKBaseLiveListFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f15055k = new a(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15057j = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f15056i = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.liveshow.fragment.FKNearbyLiveListFragment$careLocation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            Bundle arguments = FKNearbyLiveListFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("CARE_LOCATION_PERMISSION") : false);
        }
    });

    /* compiled from: FKNearbyLiveListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKNearbyLiveListFragment a(boolean z10) {
            FKNearbyLiveListFragment fKNearbyLiveListFragment = new FKNearbyLiveListFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("CARE_LOCATION_PERMISSION", z10);
            fKNearbyLiveListFragment.setArguments(bundle);
            return fKNearbyLiveListFragment;
        }
    }

    public static /* synthetic */ void i1(FKNearbyLiveListFragment fKNearbyLiveListFragment, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        fKNearbyLiveListFragment.h1(str);
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f15057j.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.LiveNearby;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15057j;
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

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment
    public void W0(@Nullable String str) {
        if (g1() && str == null) {
            j1();
        } else {
            h1(str);
        }
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment
    public void c1(@NotNull LiveShowModel model, int i10) {
        s.i(model, "model");
        FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, getContext(), new FKLiveForViewerViewModel(model, LiveshowOpenSource.Nearby, new LiveInRoomSensorModel("LIVE_NEARBY", Integer.valueOf(i10), SensorScene.Live, SensorPosition.LiveNearby, null, null, 48, null), false, 8, null), false, 4, null);
    }

    public final void e1() {
        if (!g1()) {
            i1(this, null, 1, null);
            return;
        }
        if (Y0().n() <= 0) {
            if (LocationUtils.f12270h.d(getContext())) {
                ((FKSwipeRefreshLayout) T0(R$id.liveListRefreshLayout)).setEnabled(false);
                ((PermissionRequestLayout) T0(R$id.permissionRequestLayout)).setVisibility(0);
                k1();
            } else {
                ((FKSwipeRefreshLayout) T0(R$id.liveListRefreshLayout)).setEnabled(true);
                ((PermissionRequestLayout) T0(R$id.permissionRequestLayout)).setVisibility(8);
                FKBaseLiveListFragment.X0(this, null, 1, null);
            }
        }
    }

    public final boolean f1() {
        PermissionRequestLayout permissionRequestLayout = (PermissionRequestLayout) T0(R$id.permissionRequestLayout);
        Integer valueOf = permissionRequestLayout != null ? Integer.valueOf(permissionRequestLayout.getVisibility()) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }

    public final boolean g1() {
        return ((Boolean) this.f15056i.getValue()).booleanValue();
    }

    public final void h1(final String str) {
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        j.f12332a.a("getNearbyLiveList", "coordinate: " + ((Object) j10));
        if (str == null) {
            ((FKSwipeRefreshLayout) T0(R$id.liveListRefreshLayout)).setRefreshing(true);
        }
        Disposable disposed = a.C0826a.j(NetworkClient.f11868a.r(), j10.getLatitude(), j10.getLongitude(), str, 0, 8, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveListResult, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKNearbyLiveListFragment$getNearbyLiveList$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveListResult liveListResult) {
                m2622invoke(liveListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2622invoke(LiveListResult liveListResult) {
                LiveListResult liveListResult2 = liveListResult;
                FKNearbyLiveListFragment.this.V0(str, liveListResult2.getNextCursorId(), liveListResult2.getList());
                ((FKSwipeRefreshLayout) FKNearbyLiveListFragment.this.T0(R$id.liveListRefreshLayout)).setRefreshing(false);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.fragment.FKNearbyLiveListFragment$getNearbyLiveList$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                ((FKSwipeRefreshLayout) FKNearbyLiveListFragment.this.T0(R$id.liveListRefreshLayout)).setRefreshing(false);
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void j1() {
        LocationUtils.Companion companion = LocationUtils.f12270h;
        if (!companion.a().f() && !companion.a().q(LocationRefreshTimeInterval.NearbyLiveInterval.getInterval())) {
            i1(this, null, 1, null);
        } else {
            LocationUtils.o(companion.a(), getContext(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKNearbyLiveListFragment$resetLocationAndGetData$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKNearbyLiveListFragment.i1(FKNearbyLiveListFragment.this, null, 1, null);
                }
            }, new Function2<Integer, String, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKNearbyLiveListFragment$resetLocationAndGetData$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, String str) {
                    invoke2(num, str);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Integer num, @Nullable String str) {
                    FKNearbyLiveListFragment.i1(FKNearbyLiveListFragment.this, null, 1, null);
                }
            }, null, 8, null);
        }
    }

    public final void k1() {
        PermissionRequestLayout permissionRequestLayout = (PermissionRequestLayout) T0(R$id.permissionRequestLayout);
        if (permissionRequestLayout != null) {
            String string = getString(R$string.unable_get_your_location);
            s.h(string, "getString(R.string.unable_get_your_location)");
            String string2 = getString(R$string.no_have_location_permission);
            s.h(string2, "getString(R.string.no_have_location_permission)");
            PermissionType permissionType = PermissionType.LocationPermission;
            FragmentActivity activity = getActivity();
            s.g(activity, "null cannot be cast to non-null type com.cupidapp.live.MainActivity");
            permissionRequestLayout.b(string, string2, permissionType, true, ((MainActivity) activity).X1());
        }
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseLiveListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e1();
    }
}
