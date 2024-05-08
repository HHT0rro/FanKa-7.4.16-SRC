package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.j;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TestChangeLocationActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TestChangeLocationActivity extends FKBaseActivity implements AMap.OnCameraChangeListener {

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public static final a f18021w = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public AMap f18022q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public LatLng f18023r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public LatLng f18024s;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18027v = new LinkedHashMap();

    /* renamed from: t, reason: collision with root package name */
    public boolean f18025t = true;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f18026u = kotlin.c.b(new Function0<GeocodeSearch>() { // from class: com.cupidapp.live.setting.activity.TestChangeLocationActivity$geocoderSearch$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final GeocodeSearch invoke() {
            return new GeocodeSearch(TestChangeLocationActivity.this);
        }
    });

    /* compiled from: TestChangeLocationActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) TestChangeLocationActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static final void t1(TestChangeLocationActivity this$0, Location location) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (location.getLatitude() == ShadowDrawableWrapper.COS_45) {
            if (location.getLongitude() == ShadowDrawableWrapper.COS_45) {
                return;
            }
        }
        LatLng latLng = this$0.f18024s;
        if (kotlin.jvm.internal.s.a(latLng != null ? Double.valueOf(latLng.latitude) : null, location.getLatitude())) {
            LatLng latLng2 = this$0.f18024s;
            if (kotlin.jvm.internal.s.a(latLng2 != null ? Double.valueOf(latLng2.longitude) : null, location.getLongitude())) {
                return;
            }
        }
        this$0.f18024s = new LatLng(location.getLatitude(), location.getLongitude());
        if (this$0.f18025t) {
            this$0.f18025t = false;
            AMap aMap = this$0.f18022q;
            if (aMap != null) {
                aMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this$0.f18024s, 10.0f, 30.0f, 30.0f)));
            }
        }
    }

    public static final RegeocodeAddress v1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (RegeocodeAddress) tmp0.invoke(obj);
    }

    public static final void w1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void x1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f18027v;
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

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChange(@Nullable CameraPosition cameraPosition) {
        q1(false);
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChangeFinish(@Nullable CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return;
        }
        if (!kotlin.jvm.internal.s.d(this.f18023r, cameraPosition.target)) {
            LatLng latLng = cameraPosition.target;
            this.f18023r = latLng;
            kotlin.jvm.internal.s.h(latLng, "cameraPosition.target");
            u1(latLng);
        }
        q1(true);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_change_location);
        ImageView map_test_back_img = (ImageView) n1(R$id.map_test_back_img);
        kotlin.jvm.internal.s.h(map_test_back_img, "map_test_back_img");
        z0.y.d(map_test_back_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.TestChangeLocationActivity$onCreate$1
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
                TestChangeLocationActivity.this.onBackPressed();
            }
        });
        int i10 = R$id.test_map;
        ((MapView) n1(i10)).onCreate(bundle);
        if (this.f18022q == null) {
            this.f18022q = ((MapView) n1(i10)).getMap();
        }
        s1();
        TextView test_map_btn = (TextView) n1(R$id.test_map_btn);
        kotlin.jvm.internal.s.h(test_map_btn, "test_map_btn");
        z0.y.d(test_map_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.TestChangeLocationActivity$onCreate$2
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
                LatLng latLng;
                LatLng latLng2;
                LatLng latLng3;
                j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
                latLng = TestChangeLocationActivity.this.f18023r;
                aVar.a("locationchangeto", "currentPosition:" + ((Object) latLng));
                p1.g gVar = p1.g.f52734a;
                latLng2 = TestChangeLocationActivity.this.f18023r;
                double d10 = ShadowDrawableWrapper.COS_45;
                double d11 = latLng2 != null ? latLng2.latitude : 0.0d;
                latLng3 = TestChangeLocationActivity.this.f18023r;
                if (latLng3 != null) {
                    d10 = latLng3.longitude;
                }
                gVar.c2(new CoordinateModel(d11, d10));
                TestChangeLocationActivity.this.finish();
            }
        });
        TextView test_clear_btn = (TextView) n1(R$id.test_clear_btn);
        kotlin.jvm.internal.s.h(test_clear_btn, "test_clear_btn");
        z0.y.d(test_clear_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.TestChangeLocationActivity$onCreate$3
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
                p1.g.f52734a.c2(null);
                com.cupidapp.live.base.view.h.f12779a.m(TestChangeLocationActivity.this, "已更改为默认地址");
                TestChangeLocationActivity.this.finish();
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((MapView) n1(R$id.test_map)).onDestroy();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((MapView) n1(R$id.test_map)).onPause();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((MapView) n1(R$id.test_map)).onResume();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        kotlin.jvm.internal.s.i(outState, "outState");
        super.onSaveInstanceState(outState);
        ((MapView) n1(R$id.test_map)).onSaveInstanceState(outState);
    }

    public final void q1(boolean z10) {
        if (z10) {
            int i10 = R$id.test_map_btn;
            ((TextView) n1(i10)).setEnabled(true);
            ((TextView) n1(i10)).setClickable(true);
            ((TextView) n1(i10)).setTextColor(-1);
            ((TextView) n1(i10)).setBackgroundResource(R$drawable.shape_prime_red_bg_round_corners);
            return;
        }
        int i11 = R$id.test_map_btn;
        ((TextView) n1(i11)).setEnabled(false);
        ((TextView) n1(i11)).setClickable(false);
        ((TextView) n1(i11)).setTextColor(-8618884);
        ((TextView) n1(i11)).setBackgroundResource(R$drawable.shape_gray_bg_round_corners);
    }

    public final GeocodeSearch r1() {
        return (GeocodeSearch) this.f18026u.getValue();
    }

    public final void s1() {
        UiSettings uiSettings;
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.showMyLocation(true);
        myLocationStyle.interval(1L);
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R$mipmap.ic_my_location_mark));
        myLocationStyle.strokeWidth(0.0f);
        myLocationStyle.strokeColor(0);
        myLocationStyle.radiusFillColor(0);
        myLocationStyle.anchor(0.5f, 0.4f);
        AMap aMap = this.f18022q;
        if (aMap != null) {
            aMap.setMyLocationStyle(myLocationStyle.myLocationType(6));
        }
        AMap aMap2 = this.f18022q;
        if (aMap2 != null) {
            aMap2.setMyLocationEnabled(true);
        }
        AMap aMap3 = this.f18022q;
        UiSettings uiSettings2 = aMap3 != null ? aMap3.getUiSettings() : null;
        if (uiSettings2 != null) {
            uiSettings2.setZoomControlsEnabled(false);
        }
        AMap aMap4 = this.f18022q;
        UiSettings uiSettings3 = aMap4 != null ? aMap4.getUiSettings() : null;
        if (uiSettings3 != null) {
            uiSettings3.setMyLocationButtonEnabled(false);
        }
        AMap aMap5 = this.f18022q;
        UiSettings uiSettings4 = aMap5 != null ? aMap5.getUiSettings() : null;
        if (uiSettings4 != null) {
            uiSettings4.setLogoPosition(0);
        }
        AMap aMap6 = this.f18022q;
        if (aMap6 != null && (uiSettings = aMap6.getUiSettings()) != null) {
            uiSettings.setLogoBottomMargin(z0.h.c(this, 120.0f));
        }
        CoordinateModel r10 = p1.g.f52734a.r();
        AMap aMap7 = this.f18022q;
        if (aMap7 != null) {
            aMap7.setOnCameraChangeListener(this);
        }
        AMap aMap8 = this.f18022q;
        if (aMap8 != null) {
            aMap8.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener() { // from class: com.cupidapp.live.setting.activity.u
                @Override // com.amap.api.maps.AMap.OnMyLocationChangeListener
                public final void onMyLocationChange(Location location) {
                    TestChangeLocationActivity.t1(TestChangeLocationActivity.this, location);
                }
            });
        }
        if (r10 != null) {
            this.f18024s = new LatLng(r10.getLatitude(), r10.getLongitude());
            this.f18025t = false;
            AMap aMap9 = this.f18022q;
            if (aMap9 != null) {
                aMap9.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this.f18024s, 10.0f, 30.0f, 30.0f)));
            }
        }
    }

    public final void u1(final LatLng latLng) {
        Flowable onBackpressureLatest = Flowable.just(latLng).subscribeOn(Schedulers.io()).onBackpressureLatest();
        final Function1<LatLng, RegeocodeAddress> function1 = new Function1<LatLng, RegeocodeAddress>() { // from class: com.cupidapp.live.setting.activity.TestChangeLocationActivity$saveLocation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RegeocodeAddress invoke(@NotNull LatLng it) {
                GeocodeSearch r12;
                kotlin.jvm.internal.s.i(it, "it");
                LatLng latLng2 = LatLng.this;
                RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(latLng2.latitude, latLng2.longitude), 200.0f, GeocodeSearch.AMAP);
                r12 = this.r1();
                return r12.getFromLocation(regeocodeQuery);
            }
        };
        Flowable observeOn = onBackpressureLatest.map(new Function() { // from class: com.cupidapp.live.setting.activity.x
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RegeocodeAddress v12;
                v12 = TestChangeLocationActivity.v1(Function1.this, obj);
                return v12;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<RegeocodeAddress, kotlin.p> function12 = new Function1<RegeocodeAddress, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.TestChangeLocationActivity$saveLocation$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(RegeocodeAddress regeocodeAddress) {
                invoke2(regeocodeAddress);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RegeocodeAddress regeocodeAddress) {
                ((TextView) TestChangeLocationActivity.this.n1(R$id.test_map_btn)).setText("选择" + regeocodeAddress.getFormatAddress());
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.setting.activity.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TestChangeLocationActivity.w1(Function1.this, obj);
            }
        };
        final TestChangeLocationActivity$saveLocation$3 testChangeLocationActivity$saveLocation$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.TestChangeLocationActivity$saveLocation$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.setting.activity.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TestChangeLocationActivity.x1(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(subscribe, "private fun saveLocation…            }, {}))\n    }");
        H(subscribe);
    }
}
