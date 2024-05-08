package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.match.activity.SearchLocationActivity;
import com.cupidapp.live.match.model.AddressModel;
import com.cupidapp.live.match.model.TravelCountSelectUiModel;
import com.cupidapp.live.match.view.TravelConfirmDialog;
import com.cupidapp.live.match.view.TravelSelectCountDialog;
import com.cupidapp.live.match.view.TravelUseFailDialog;
import com.cupidapp.live.match.viewmodel.TravelMapViewModel;
import com.cupidapp.live.superboost.event.SuperBoostStateChangeEvent;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelMapActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TravelMapActivity extends FKBaseActivity implements AMap.OnCameraChangeListener {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f16565x = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public AMap f16566q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public LatLng f16567r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public LatLng f16568s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f16569t;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16572w = new LinkedHashMap();

    /* renamed from: u, reason: collision with root package name */
    public boolean f16570u = true;

    /* renamed from: v, reason: collision with root package name */
    public boolean f16571v = true;

    /* compiled from: TravelMapActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable String str) {
            kotlin.jvm.internal.s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) TravelMapActivity.class);
            intent.putExtra("SOURCE", str);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public TravelMapActivity() {
        final Function0 function0 = null;
        this.f16569t = new ViewModelLazy(kotlin.jvm.internal.v.b(TravelMapViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$special$$inlined$viewModels$default$3
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

    public static final void x1(TravelMapActivity this$0, Location location) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (location.getLatitude() == ShadowDrawableWrapper.COS_45) {
            if (location.getLongitude() == ShadowDrawableWrapper.COS_45) {
                return;
            }
        }
        LatLng latLng = this$0.f16568s;
        if (kotlin.jvm.internal.s.a(latLng != null ? Double.valueOf(latLng.latitude) : null, location.getLatitude())) {
            LatLng latLng2 = this$0.f16568s;
            if (kotlin.jvm.internal.s.a(latLng2 != null ? Double.valueOf(latLng2.longitude) : null, location.getLongitude())) {
                return;
            }
        }
        this$0.f16568s = new LatLng(location.getLatitude(), location.getLongitude());
        if (this$0.f16570u) {
            this$0.f16570u = false;
            AMap aMap = this$0.f16566q;
            if (aMap != null) {
                aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this$0.f16568s, 15.0f, 30.0f, 30.0f)));
            }
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.TravelMap;
    }

    public final void init() {
        if (this.f16566q == null) {
            this.f16566q = ((MapView) k1(R$id.filter_map)).getMap();
        }
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f16572w;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        AMap aMap;
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 11) {
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("location") : null;
            AddressModel addressModel = serializableExtra instanceof AddressModel ? (AddressModel) serializableExtra : null;
            if (addressModel == null || (aMap = this.f16566q) == null) {
                return;
            }
            Double latitude = addressModel.getLatitude();
            kotlin.jvm.internal.s.f(latitude);
            double doubleValue = latitude.doubleValue();
            Double longitude = addressModel.getLongitude();
            kotlin.jvm.internal.s.f(longitude);
            aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(doubleValue, longitude.doubleValue()), 15.0f));
        }
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChange(@Nullable CameraPosition cameraPosition) {
        ((TextView) k1(R$id.filter_tip)).setVisibility(4);
        s1(false);
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChangeFinish(@Nullable CameraPosition cameraPosition) {
        if (cameraPosition == null || kotlin.jvm.internal.s.d(this.f16567r, cameraPosition.target)) {
            return;
        }
        this.f16567r = cameraPosition.target;
        t1().changeLocation(cameraPosition);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_gaode_map_travel);
        ((MapView) k1(R$id.filter_map)).onCreate(bundle);
        init();
        w1();
        s1(false);
        y1();
        v1();
        TextView filter_map_btn = (TextView) k1(R$id.filter_map_btn);
        kotlin.jvm.internal.s.h(filter_map_btn, "filter_map_btn");
        z0.u.a(filter_map_btn);
        GroupOthersLog.d(GroupOthersLog.f18702a, Q0().getValue(), null, null, 6, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((MapView) k1(R$id.filter_map)).onDestroy();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((MapView) k1(R$id.filter_map)).onPause();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((MapView) k1(R$id.filter_map)).onResume();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        kotlin.jvm.internal.s.i(outState, "outState");
        super.onSaveInstanceState(outState);
        ((MapView) k1(R$id.filter_map)).onSaveInstanceState(outState);
    }

    public final void r1() {
        if (this.f16571v) {
            this.f16571v = false;
            int i10 = R$id.filter_tip;
            ((TextView) k1(i10)).setVisibility(0);
            ((TextView) k1(i10)).setText(getString(R$string.swipe_map_to_search));
        } else {
            ((TextView) k1(R$id.filter_tip)).setVisibility(4);
        }
        s1(true);
    }

    public final void s1(boolean z10) {
        if (z10) {
            int i10 = R$id.filter_map_btn;
            ((TextView) k1(i10)).setEnabled(true);
            ((TextView) k1(i10)).setClickable(true);
            ((TextView) k1(i10)).setTextColor(-15066598);
            ((TextView) k1(i10)).setBackgroundResource(R$drawable.rect_cor_26_sd_ffd300);
            return;
        }
        int i11 = R$id.filter_map_btn;
        ((TextView) k1(i11)).setEnabled(false);
        ((TextView) k1(i11)).setClickable(false);
        ((TextView) k1(i11)).setTextColor(-8618884);
        ((TextView) k1(i11)).setBackgroundResource(R$drawable.rect_cor_26_sd_c6c6c6);
    }

    public final TravelMapViewModel t1() {
        return (TravelMapViewModel) this.f16569t.getValue();
    }

    public final void u1() {
        SearchLocationActivity.a aVar = SearchLocationActivity.f16558u;
        LatLng latLng = this.f16568s;
        Double valueOf = latLng != null ? Double.valueOf(latLng.latitude) : null;
        LatLng latLng2 = this.f16568s;
        aVar.a(this, valueOf, latLng2 != null ? Double.valueOf(latLng2.longitude) : null, Q0().getValue(), 11);
    }

    public final void v1() {
        ImageView map_filter_back_img = (ImageView) k1(R$id.map_filter_back_img);
        kotlin.jvm.internal.s.h(map_filter_back_img, "map_filter_back_img");
        z0.y.d(map_filter_back_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initClickListener$1
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
                TravelMapActivity.this.finish();
            }
        });
        TextView filter_map_search_txt = (TextView) k1(R$id.filter_map_search_txt);
        kotlin.jvm.internal.s.h(filter_map_search_txt, "filter_map_search_txt");
        z0.y.d(filter_map_search_txt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initClickListener$2
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
                TravelMapActivity.this.u1();
            }
        });
        ImageView filter_my_location = (ImageView) k1(R$id.filter_my_location);
        kotlin.jvm.internal.s.h(filter_my_location, "filter_my_location");
        z0.y.d(filter_my_location, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initClickListener$3
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
                AMap aMap;
                LatLng latLng;
                aMap = TravelMapActivity.this.f16566q;
                if (aMap != null) {
                    latLng = TravelMapActivity.this.f16568s;
                    aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng, 15.0f, 30.0f, 30.0f)));
                }
            }
        });
        TextView filter_map_btn = (TextView) k1(R$id.filter_map_btn);
        kotlin.jvm.internal.s.h(filter_map_btn, "filter_map_btn");
        z0.y.d(filter_map_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initClickListener$4
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
                TravelMapViewModel t12;
                LatLng latLng;
                LatLng latLng2;
                LatLng latLng3;
                t12 = TravelMapActivity.this.t1();
                latLng = TravelMapActivity.this.f16567r;
                t12.saveMapFilterLocation(latLng);
                z3.d dVar = z3.d.f54832a;
                latLng2 = TravelMapActivity.this.f16567r;
                Double valueOf = latLng2 != null ? Double.valueOf(latLng2.latitude) : null;
                latLng3 = TravelMapActivity.this.f16567r;
                dVar.z(valueOf, latLng3 != null ? Double.valueOf(latLng3.longitude) : null, true);
            }
        });
    }

    public final void w1() {
        UiSettings uiSettings;
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.showMyLocation(true);
        myLocationStyle.interval(1L);
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R$mipmap.ic_my_location_mark_black));
        myLocationStyle.strokeWidth(0.0f);
        myLocationStyle.strokeColor(0);
        myLocationStyle.radiusFillColor(0);
        myLocationStyle.anchor(0.5f, 0.4f);
        AMap aMap = this.f16566q;
        if (aMap != null) {
            aMap.setMyLocationStyle(myLocationStyle.myLocationType(6));
        }
        AMap aMap2 = this.f16566q;
        if (aMap2 != null) {
            aMap2.setMyLocationEnabled(true);
        }
        AMap aMap3 = this.f16566q;
        UiSettings uiSettings2 = aMap3 != null ? aMap3.getUiSettings() : null;
        if (uiSettings2 != null) {
            uiSettings2.setZoomControlsEnabled(false);
        }
        AMap aMap4 = this.f16566q;
        UiSettings uiSettings3 = aMap4 != null ? aMap4.getUiSettings() : null;
        if (uiSettings3 != null) {
            uiSettings3.setMyLocationButtonEnabled(false);
        }
        AMap aMap5 = this.f16566q;
        UiSettings uiSettings4 = aMap5 != null ? aMap5.getUiSettings() : null;
        if (uiSettings4 != null) {
            uiSettings4.setLogoPosition(0);
        }
        AMap aMap6 = this.f16566q;
        if (aMap6 != null && (uiSettings = aMap6.getUiSettings()) != null) {
            uiSettings.setLogoBottomMargin(z0.h.c(this, 170.0f));
        }
        AMap aMap7 = this.f16566q;
        if (aMap7 != null) {
            aMap7.setOnCameraChangeListener(this);
        }
        AMap aMap8 = this.f16566q;
        if (aMap8 != null) {
            aMap8.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener() { // from class: com.cupidapp.live.match.activity.k0
                @Override // com.amap.api.maps.AMap.OnMyLocationChangeListener
                public final void onMyLocationChange(Location location) {
                    TravelMapActivity.x1(TravelMapActivity.this, location);
                }
            });
        }
    }

    public final void y1() {
        t1().getOpenWeb().observe(this, new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                kotlin.jvm.internal.s.i(it, "it");
                j.a.b(com.cupidapp.live.base.router.j.f12156c, TravelMapActivity.this, it, null, 4, null);
                TravelMapActivity.this.finish();
            }
        }));
        t1().getShowLoading().observe(this, new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                if (z10) {
                    TravelMapActivity.this.e1();
                } else {
                    TravelMapActivity.this.V0();
                }
            }
        }));
        t1().getSelectLocation().observe(this, new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                kotlin.jvm.internal.s.i(it, "it");
                TextView textView = (TextView) TravelMapActivity.this.k1(R$id.map_location_txt);
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
                String string = TravelMapActivity.this.getString(R$string.current_location);
                kotlin.jvm.internal.s.h(string, "getString(R.string.current_location)");
                String format = String.format(string, Arrays.copyOf(new Object[]{it}, 1));
                kotlin.jvm.internal.s.h(format, "format(format, *args)");
                textView.setText(format);
                TravelMapActivity.this.r1();
            }
        }));
        t1().getTwiceDialogEventLiveData().observe(this, new EventObserver(new Function1<Triple<? extends LatLng, ? extends RegeocodeAddress, ? extends Boolean>, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Triple<? extends LatLng, ? extends RegeocodeAddress, ? extends Boolean> triple) {
                invoke2((Triple<LatLng, RegeocodeAddress, Boolean>) triple);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final Triple<LatLng, RegeocodeAddress, Boolean> it) {
                kotlin.jvm.internal.s.i(it, "it");
                TravelConfirmDialog a10 = TravelConfirmDialog.f17004e.a(TravelMapActivity.this, it.getThird().booleanValue());
                final TravelMapActivity travelMapActivity = TravelMapActivity.this;
                a10.d(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$4.1
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
                        TravelMapViewModel t12;
                        t12 = TravelMapActivity.this.t1();
                        TravelMapViewModel.confirmUseTravel$default(t12, it.getFirst(), it.getSecond(), 0, 4, null);
                    }
                }).e();
            }
        }));
        t1().getUseSucEventLiveData().observe(this, new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                kotlin.jvm.internal.s.i(it, "it");
                com.cupidapp.live.base.view.h.f12779a.c(TravelMapActivity.this, R$string.use_success);
                EventBus.c().o(new SuperBoostStateChangeEvent());
                j.a.b(com.cupidapp.live.base.router.j.f12156c, TravelMapActivity.this, it, null, 4, null);
                TravelMapActivity.this.finish();
            }
        }));
        t1().getFailDialogEventLiveData().observe(this, new EventObserver(new Function1<kotlin.p, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$6
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
                TravelUseFailDialog.f17013d.a(TravelMapActivity.this).d();
            }
        }));
        t1().getSelectDialogEventLiveData().observe(this, new EventObserver(new Function1<TravelCountSelectUiModel, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(TravelCountSelectUiModel travelCountSelectUiModel) {
                invoke2(travelCountSelectUiModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final TravelCountSelectUiModel model) {
                kotlin.jvm.internal.s.i(model, "model");
                TravelSelectCountDialog e2 = TravelSelectCountDialog.f17008f.a(TravelMapActivity.this).e(model);
                final TravelMapActivity travelMapActivity = TravelMapActivity.this;
                e2.k(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.match.activity.TravelMapActivity$initObserve$7.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                        invoke(num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(int i10) {
                        TravelMapViewModel t12;
                        t12 = TravelMapActivity.this.t1();
                        t12.confirmUseTravel(model.getLatLng(), model.getAdress(), i10);
                    }
                }).l();
            }
        }));
    }
}
