package com.cupidapp.live.feed.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.as;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MapActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f14086t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public AMap f14087q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public LatLng f14088r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14089s = new LinkedHashMap();

    /* compiled from: MapActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable String str, @Nullable Double d10, @Nullable Double d11, @Nullable Boolean bool) {
            Intent intent = new Intent(context, (Class<?>) MapActivity.class);
            intent.putExtra("locationName", str);
            intent.putExtra(as.at, d10);
            intent.putExtra(as.au, d11);
            intent.putExtra("venueAbroad", bool);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public final void init() {
        if (this.f14087q == null) {
            this.f14087q = ((MapView) j1(R$id.mapView)).getMap();
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f14089s;
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

    public final void k1() {
        double doubleExtra = getIntent().getDoubleExtra(as.at, ShadowDrawableWrapper.COS_45);
        double doubleExtra2 = getIntent().getDoubleExtra(as.au, ShadowDrawableWrapper.COS_45);
        boolean booleanExtra = getIntent().getBooleanExtra("venueAbroad", false);
        this.f14088r = new LatLng(doubleExtra, doubleExtra2);
        AMap aMap = this.f14087q;
        Marker addMarker = aMap != null ? aMap.addMarker(new MarkerOptions().position(this.f14088r).icon(BitmapDescriptorFactory.defaultMarker(210.0f)).draggable(true)) : null;
        if (booleanExtra) {
            AMap aMap2 = this.f14087q;
            if (aMap2 != null) {
                aMap2.animateCamera(CameraUpdateFactory.newLatLngZoom(this.f14088r, 9.0f));
            }
        } else {
            AMap aMap3 = this.f14087q;
            if (aMap3 != null) {
                aMap3.animateCamera(CameraUpdateFactory.newLatLngZoom(this.f14088r, 15.0f));
            }
        }
        if (addMarker != null) {
            addMarker.showInfoWindow();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_gaode_map);
        int i10 = R$id.mapTitleBarLayout;
        FKTitleBarLayout mapTitleBarLayout = (FKTitleBarLayout) j1(i10);
        kotlin.jvm.internal.s.h(mapTitleBarLayout, "mapTitleBarLayout");
        FKTitleBarLayout.setSingleTitle$default(mapTitleBarLayout, getIntent().getStringExtra("locationName"), null, 2, null);
        ((FKTitleBarLayout) j1(i10)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.MapActivity$onCreate$1
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
                MapActivity.this.finish();
            }
        });
        ((MapView) j1(R$id.mapView)).onCreate(bundle);
        init();
        k1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((MapView) j1(R$id.mapView)).onDestroy();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((MapView) j1(R$id.mapView)).onPause();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((MapView) j1(R$id.mapView)).onResume();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        kotlin.jvm.internal.s.i(outState, "outState");
        super.onSaveInstanceState(outState);
        ((MapView) j1(R$id.mapView)).onSaveInstanceState(outState);
    }
}
