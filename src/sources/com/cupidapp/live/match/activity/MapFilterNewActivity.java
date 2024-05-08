package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.cupidapp.live.MainActivity;
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
import com.cupidapp.live.match.view.MapGuideIntroDialog;
import com.cupidapp.live.match.viewmodel.MapFilterNewViewModel;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.as;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapFilterNewActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MapFilterNewActivity extends FKBaseActivity implements AMap.OnCameraChangeListener {

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public static final a f16502z = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public AMap f16503q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public LatLng f16504r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public LatLng f16505s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f16506t;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16511y = new LinkedHashMap();

    /* renamed from: u, reason: collision with root package name */
    public boolean f16507u = true;

    /* renamed from: v, reason: collision with root package name */
    public boolean f16508v = true;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public final Lazy f16509w = kotlin.c.b(new Function0<SensorPosition>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$source$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final SensorPosition invoke() {
            Serializable serializableExtra = MapFilterNewActivity.this.getIntent().getSerializableExtra("SOURCE");
            if (serializableExtra instanceof SensorPosition) {
                return (SensorPosition) serializableExtra;
            }
            return null;
        }
    });

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public final Lazy f16510x = kotlin.c.b(new Function0<VipPurchaseEntranceType>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$vipPurchaseEntranceType$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final VipPurchaseEntranceType invoke() {
            Serializable serializableExtra = MapFilterNewActivity.this.getIntent().getSerializableExtra("data_type");
            if (serializableExtra == null) {
                serializableExtra = VipPurchaseEntranceType.MapFilter;
            }
            kotlin.jvm.internal.s.g(serializableExtra, "null cannot be cast to non-null type com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType");
            return (VipPurchaseEntranceType) serializableExtra;
        }
    });

    /* compiled from: MapFilterNewActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable Double d10, @Nullable Double d11, @Nullable SensorPosition sensorPosition, @NotNull VipPurchaseEntranceType vipPurchaseEntranceType) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(vipPurchaseEntranceType, "vipPurchaseEntranceType");
            Intent intent = new Intent(context, (Class<?>) MapFilterNewActivity.class);
            intent.putExtra(as.at, d10);
            intent.putExtra(as.au, d11);
            intent.putExtra("SOURCE", sensorPosition);
            intent.putExtra("data_type", vipPurchaseEntranceType);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public MapFilterNewActivity() {
        final Function0 function0 = null;
        this.f16506t = new ViewModelLazy(kotlin.jvm.internal.v.b(MapFilterNewViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$special$$inlined$viewModels$default$3
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

    public static final void z1(MapFilterNewActivity this$0, Location location) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (location.getLatitude() == ShadowDrawableWrapper.COS_45) {
            if (location.getLongitude() == ShadowDrawableWrapper.COS_45) {
                return;
            }
        }
        LatLng latLng = this$0.f16505s;
        if (kotlin.jvm.internal.s.a(latLng != null ? Double.valueOf(latLng.latitude) : null, location.getLatitude())) {
            LatLng latLng2 = this$0.f16505s;
            if (kotlin.jvm.internal.s.a(latLng2 != null ? Double.valueOf(latLng2.longitude) : null, location.getLongitude())) {
                return;
            }
        }
        this$0.f16505s = new LatLng(location.getLatitude(), location.getLongitude());
        if (this$0.f16507u) {
            this$0.f16507u = false;
            AMap aMap = this$0.f16503q;
            if (aMap != null) {
                aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this$0.f16505s, 15.0f, 30.0f, 30.0f)));
            }
        }
    }

    public final void A1() {
        u1().getOpenNearByEvent().observe(this, new EventObserver(new Function1<kotlin.p, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$initObserve$1
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
                VipPurchaseEntranceType v12;
                kotlin.jvm.internal.s.i(it, "it");
                p1.g gVar = p1.g.f52734a;
                v12 = MapFilterNewActivity.this.v1();
                gVar.J2(v12);
                MainActivity.F.e("match", MapFilterNewActivity.this, "near");
            }
        }));
        u1().getShowLoading().observe(this, new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$initObserve$2
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
                    MapFilterNewActivity.this.e1();
                } else {
                    MapFilterNewActivity.this.V0();
                }
            }
        }));
        u1().getOpenWeb().observe(this, new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$initObserve$3
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, MapFilterNewActivity.this, it, null, 4, null);
            }
        }));
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.Map;
    }

    public final void init() {
        if (this.f16503q == null) {
            this.f16503q = ((MapView) k1(R$id.filter_map)).getMap();
        }
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f16511y;
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
        if (i11 == -1 && i10 == 222) {
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("location") : null;
            AddressModel addressModel = serializableExtra instanceof AddressModel ? (AddressModel) serializableExtra : null;
            if (addressModel == null || (aMap = this.f16503q) == null) {
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
        if (cameraPosition == null || kotlin.jvm.internal.s.d(this.f16504r, cameraPosition.target)) {
            return;
        }
        this.f16504r = cameraPosition.target;
        r1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_gaode_map_filter_new);
        ((MapView) k1(R$id.filter_map)).onCreate(bundle);
        TextView map_title = (TextView) k1(R$id.map_title);
        kotlin.jvm.internal.s.h(map_title, "map_title");
        z0.u.a(map_title);
        TextView travel_title = (TextView) k1(R$id.travel_title);
        kotlin.jvm.internal.s.h(travel_title, "travel_title");
        z0.u.a(travel_title);
        init();
        y1();
        s1(false);
        A1();
        x1();
        z3.d.f54832a.E(t1());
        p1.g gVar = p1.g.f52734a;
        if (kotlin.jvm.internal.s.d(gVar.f0(), Boolean.TRUE)) {
            gVar.I2(Boolean.FALSE);
            MapGuideIntroDialog.f16952d.a(this).d();
        }
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
        if (this.f16508v) {
            this.f16508v = false;
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
            int i10 = R$id.map_rl;
            ((RelativeLayout) k1(i10)).setEnabled(true);
            ((RelativeLayout) k1(i10)).setClickable(true);
            ((TextView) k1(R$id.map_title)).setTextColor(-84390);
            ((TextView) k1(R$id.map_sub_title)).setTextColor(-1493256614);
            ((ImageView) k1(R$id.map_icon)).setImageResource(R$mipmap.ic_map_btn);
            ((RelativeLayout) k1(i10)).setBackgroundResource(R$drawable.bg_map_btn);
            return;
        }
        int i11 = R$id.map_rl;
        ((RelativeLayout) k1(i11)).setEnabled(false);
        ((RelativeLayout) k1(i11)).setClickable(false);
        ((TextView) k1(R$id.map_title)).setTextColor(-8618884);
        ((TextView) k1(R$id.map_sub_title)).setTextColor(-8618884);
        ((ImageView) k1(R$id.map_icon)).setImageResource(R$mipmap.ic_map_gray_btn);
        ((RelativeLayout) k1(i11)).setBackgroundResource(R$drawable.rect_cor_8_sd_c6c6c6);
    }

    public final SensorPosition t1() {
        return (SensorPosition) this.f16509w.getValue();
    }

    public final MapFilterNewViewModel u1() {
        return (MapFilterNewViewModel) this.f16506t.getValue();
    }

    public final VipPurchaseEntranceType v1() {
        return (VipPurchaseEntranceType) this.f16510x.getValue();
    }

    public final void w1() {
        SearchLocationActivity.a aVar = SearchLocationActivity.f16558u;
        LatLng latLng = this.f16505s;
        Double valueOf = latLng != null ? Double.valueOf(latLng.latitude) : null;
        LatLng latLng2 = this.f16505s;
        aVar.a(this, valueOf, latLng2 != null ? Double.valueOf(latLng2.longitude) : null, Q0().getValue(), 222);
    }

    public final void x1() {
        ImageView map_filter_back_img = (ImageView) k1(R$id.map_filter_back_img);
        kotlin.jvm.internal.s.h(map_filter_back_img, "map_filter_back_img");
        z0.y.d(map_filter_back_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$initClickListener$1
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
                MapFilterNewActivity.this.finish();
            }
        });
        TextView filter_map_search_txt = (TextView) k1(R$id.filter_map_search_txt);
        kotlin.jvm.internal.s.h(filter_map_search_txt, "filter_map_search_txt");
        z0.y.d(filter_map_search_txt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$initClickListener$2
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
                MapFilterNewActivity.this.w1();
                z3.d.f54832a.C();
            }
        });
        ImageView filter_my_location = (ImageView) k1(R$id.filter_my_location);
        kotlin.jvm.internal.s.h(filter_my_location, "filter_my_location");
        z0.y.d(filter_my_location, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$initClickListener$3
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
                z3.d.f54832a.q();
                aMap = MapFilterNewActivity.this.f16503q;
                if (aMap != null) {
                    latLng = MapFilterNewActivity.this.f16505s;
                    aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng, 15.0f, 30.0f, 30.0f)));
                }
            }
        });
        RelativeLayout map_rl = (RelativeLayout) k1(R$id.map_rl);
        kotlin.jvm.internal.s.h(map_rl, "map_rl");
        z0.y.d(map_rl, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$initClickListener$4
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
                MapFilterNewViewModel u12;
                LatLng latLng;
                LatLng latLng2;
                LatLng latLng3;
                u12 = MapFilterNewActivity.this.u1();
                latLng = MapFilterNewActivity.this.f16504r;
                u12.saveMapFilterLocation(latLng);
                z3.d dVar = z3.d.f54832a;
                latLng2 = MapFilterNewActivity.this.f16504r;
                Double valueOf = latLng2 != null ? Double.valueOf(latLng2.latitude) : null;
                latLng3 = MapFilterNewActivity.this.f16504r;
                z3.d.A(dVar, valueOf, latLng3 != null ? Double.valueOf(latLng3.longitude) : null, false, 4, null);
            }
        });
        RelativeLayout travel_rl = (RelativeLayout) k1(R$id.travel_rl);
        kotlin.jvm.internal.s.h(travel_rl, "travel_rl");
        z0.y.d(travel_rl, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MapFilterNewActivity$initClickListener$5
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
                MapFilterNewViewModel u12;
                u12 = MapFilterNewActivity.this.u1();
                u12.openTravelPage();
            }
        });
    }

    public final void y1() {
        UiSettings uiSettings;
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.showMyLocation(true);
        myLocationStyle.interval(1L);
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R$mipmap.ic_my_location_mark_black));
        myLocationStyle.strokeWidth(0.0f);
        myLocationStyle.strokeColor(0);
        myLocationStyle.radiusFillColor(0);
        myLocationStyle.anchor(0.5f, 0.4f);
        AMap aMap = this.f16503q;
        if (aMap != null) {
            aMap.setMyLocationStyle(myLocationStyle.myLocationType(6));
        }
        AMap aMap2 = this.f16503q;
        if (aMap2 != null) {
            aMap2.setMyLocationEnabled(true);
        }
        AMap aMap3 = this.f16503q;
        UiSettings uiSettings2 = aMap3 != null ? aMap3.getUiSettings() : null;
        if (uiSettings2 != null) {
            uiSettings2.setZoomControlsEnabled(false);
        }
        AMap aMap4 = this.f16503q;
        UiSettings uiSettings3 = aMap4 != null ? aMap4.getUiSettings() : null;
        if (uiSettings3 != null) {
            uiSettings3.setMyLocationButtonEnabled(false);
        }
        AMap aMap5 = this.f16503q;
        UiSettings uiSettings4 = aMap5 != null ? aMap5.getUiSettings() : null;
        if (uiSettings4 != null) {
            uiSettings4.setLogoPosition(0);
        }
        AMap aMap6 = this.f16503q;
        if (aMap6 != null && (uiSettings = aMap6.getUiSettings()) != null) {
            uiSettings.setLogoBottomMargin(z0.h.c(this, 120.0f));
        }
        AMap aMap7 = this.f16503q;
        if (aMap7 != null) {
            aMap7.setOnCameraChangeListener(this);
        }
        AMap aMap8 = this.f16503q;
        if (aMap8 != null) {
            aMap8.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener() { // from class: com.cupidapp.live.match.activity.k
                @Override // com.amap.api.maps.AMap.OnMyLocationChangeListener
                public final void onMyLocationChange(Location location) {
                    MapFilterNewActivity.z1(MapFilterNewActivity.this, location);
                }
            });
        }
    }
}
