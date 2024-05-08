package com.cupidapp.live.base.utils;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationGoogleUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d0 {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f12303g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f12304a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Function1<LatLng, kotlin.p> f12305b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Function0<kotlin.p> f12306c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public LocationManager f12307d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f12308e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f12309f;

    /* compiled from: LocationGoogleUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LocationGoogleUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public final class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NotNull Location location) {
            boolean z10;
            kotlin.jvm.internal.s.i(location, "location");
            List<Address> arrayList = new ArrayList<>();
            try {
                arrayList = new Geocoder(d0.this.f12304a).getFromLocation(location.getLatitude(), location.getLongitude(), 8);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Address address = null;
            if (arrayList != null) {
                ListIterator<Address> listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    Address previous = listIterator.previous();
                    Address address2 = previous;
                    try {
                        address2.getLatitude();
                        address2.getLongitude();
                        z10 = true;
                    } catch (Exception unused) {
                        z10 = false;
                    }
                    if (z10) {
                        address = previous;
                        break;
                    }
                }
                address = address;
            }
            if (address != null) {
                GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                groupOthersLog.O("谷歌", Double.valueOf(address.getLongitude()), Double.valueOf(address.getLatitude()), address.getFeatureName(), (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null);
                CoordinateConverter coordinateConverter = new CoordinateConverter(d0.this.f12304a);
                coordinateConverter.from(CoordinateConverter.CoordType.GPS);
                coordinateConverter.coord(new LatLng(address.getLatitude(), address.getLongitude()));
                LatLng convert = coordinateConverter.convert();
                kotlin.jvm.internal.s.h(convert, "converter.convert()");
                Function1<LatLng, kotlin.p> c4 = d0.this.c();
                if (c4 != null) {
                    c4.invoke(convert);
                }
                d0.this.g();
                groupOthersLog.O("谷歌转高德", Double.valueOf(address.getLongitude()), Double.valueOf(address.getLatitude()), "", (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null);
                return;
            }
            Function0<kotlin.p> b4 = d0.this.b();
            if (b4 != null) {
                b4.invoke();
            }
            d0.this.g();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@NotNull String provider) {
            kotlin.jvm.internal.s.i(provider, "provider");
            j.f12332a.c("GPS-Info", "onProviderDisabled");
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NotNull String provider) {
            kotlin.jvm.internal.s.i(provider, "provider");
            j.f12332a.c("GPS-Info", "onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(@NotNull String provider, int i10, @NotNull Bundle extras) {
            kotlin.jvm.internal.s.i(provider, "provider");
            kotlin.jvm.internal.s.i(extras, "extras");
            j.f12332a.c("GPS-Info", "onStatusChanged");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(@NotNull Context context, @Nullable Function1<? super LatLng, kotlin.p> function1, @Nullable Function0<kotlin.p> function0) {
        kotlin.jvm.internal.s.i(context, "context");
        this.f12304a = context;
        this.f12305b = function1;
        this.f12306c = function0;
        e();
    }

    @Nullable
    public final Function0<kotlin.p> b() {
        return this.f12306c;
    }

    @Nullable
    public final Function1<LatLng, kotlin.p> c() {
        return this.f12305b;
    }

    public final kotlin.p d() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setPowerRequirement(2);
        LocationManager locationManager = this.f12307d;
        kotlin.jvm.internal.s.f(locationManager);
        this.f12309f = locationManager.getBestProvider(criteria, false);
        this.f12308e = new b();
        return kotlin.p.f51048a;
    }

    public final void e() {
        Object systemService = this.f12304a.getSystemService("location");
        kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        this.f12307d = locationManager;
        kotlin.jvm.internal.s.f(locationManager);
        if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
            d();
        }
    }

    public final void f() {
        if (ContextCompat.checkSelfPermission(this.f12304a, com.kuaishou.weapon.p0.g.f36121g) != 0 && ContextCompat.checkSelfPermission(this.f12304a, com.kuaishou.weapon.p0.g.f36122h) != 0) {
            com.cupidapp.live.base.view.h.f12779a.t("请给予定位权限");
            return;
        }
        j.f12332a.c("GPS-Info", "startLocation: ");
        LocationManager locationManager = this.f12307d;
        kotlin.jvm.internal.s.f(locationManager);
        String str = this.f12309f;
        kotlin.jvm.internal.s.f(str);
        b bVar = this.f12308e;
        kotlin.jvm.internal.s.f(bVar);
        locationManager.requestLocationUpdates(str, 0L, 0.0f, bVar);
    }

    public final void g() {
        j.f12332a.c("GPS-Info", "stopLocation: ");
        LocationManager locationManager = this.f12307d;
        kotlin.jvm.internal.s.f(locationManager);
        b bVar = this.f12308e;
        kotlin.jvm.internal.s.f(bVar);
        locationManager.removeUpdates(bVar);
    }
}
