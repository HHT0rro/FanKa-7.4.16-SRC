package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.utils.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ac {
    private static Location B = null;
    private static final byte[] C = new byte[0];
    private static final String Code = "LocationUtils";
    private static final int D = 2;
    private static final int F = 1;
    private static LocationManager I = null;
    private static final int L = 1;
    private static long S = -1;
    private static final long V = 30000;
    private static String Z = null;

    /* renamed from: a, reason: collision with root package name */
    private static long f32580a = 1800000;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f32581b;

    private static void B(final Context context) {
        gl.V("LocationUtils", "loc_tag sendAsyncLocation go!");
        if (I(context)) {
            S = System.currentTimeMillis();
            gl.V("LocationUtils", "update lastRefreshTime");
            f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ac.Z(context);
                    } catch (Throwable th) {
                        gl.Z("LocationUtils", "loc_tag asyncLocation exception: " + th.getClass().getSimpleName());
                    }
                }
            });
        }
    }

    private static void C(final Context context) {
        gl.Code("LocationUtils", "loc_tag getLocationByKit");
        try {
            new ab(context, new ab.a() { // from class: com.huawei.openalliance.ad.utils.ac.5
                @Override // com.huawei.openalliance.ad.utils.ab.a
                public void Code() {
                    try {
                        ac.V(context, 2);
                    } catch (Throwable th) {
                        gl.V("LocationUtils", "onLocationAcquireFailed ex: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // com.huawei.openalliance.ad.utils.ab.a
                public void Code(android.location.Location location) {
                    try {
                        ac.Code(location);
                    } catch (Throwable th) {
                        gl.V("LocationUtils", "onLocationAcquired ex: %s", th.getClass().getSimpleName());
                    }
                }
            }).Code();
        } catch (Throwable th) {
            gl.Z("LocationUtils", "loc_tag getLocationByKit, exception = " + th.getClass().getSimpleName());
        }
    }

    public static Location Code(Context context, RequestOptions requestOptions, Location location) {
        boolean V2 = V(context, requestOptions);
        boolean z10 = false;
        gl.V("LocationUtils", "loc_tag media allow: %s", Boolean.valueOf(V2));
        com.huawei.openalliance.ad.beans.inner.b F2 = F(context);
        if (V2 && F2.Z()) {
            z10 = true;
        }
        Location location2 = null;
        if (!z10) {
            gl.V("LocationUtils", "loc_tag isLocationAvailable = false, return null");
        } else if (location == null) {
            B(context);
            Location location3 = B;
            if (location3 != null) {
                location2 = location3.Code();
            }
        } else {
            location2 = location.Code();
            location2.Code(Long.valueOf(System.currentTimeMillis()));
            location2.Code(1);
        }
        if (location2 == null) {
            location2 = new Location();
        }
        location2.Code(F2);
        return location2;
    }

    public static Location Code(android.location.Location location) {
        if (location == null) {
            return null;
        }
        synchronized (C) {
            if (B == null) {
                B = new Location();
            }
            B.Code(Double.valueOf(location.getLongitude()));
            B.V(Double.valueOf(location.getLatitude()));
            B.Code(Long.valueOf(System.currentTimeMillis()));
        }
        return B;
    }

    public static void Code(final Context context, RequestOptions requestOptions) {
        if (V(context, requestOptions) && I(context)) {
            if (gl.Code()) {
                gl.Code("LocationUtils", "loc_tag sendAsyncLocationByNative go!");
            }
            f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ac.F(context).Z()) {
                        ac.V(context, 1);
                    } else {
                        gl.V("LocationUtils", "loc_tag sendAsyncLocationByNative failed because switch is off");
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v8 */
    private static com.huawei.openalliance.ad.beans.inner.b D(Context context) {
        ?? r72;
        boolean I2 = ea.Code(context).I();
        boolean b4 = b(context);
        boolean z10 = false;
        try {
            r72 = a(context);
        } catch (Throwable th) {
            gl.Z("LocationUtils", "loc_tag hasLocationPermission = " + th.getClass().getSimpleName());
            r72 = 0;
        }
        if (gl.Code()) {
            gl.Code("LocationUtils", "loc_tag isBaseLocationSwitch = %s", Boolean.valueOf(I2));
            gl.Code("LocationUtils", "loc_tag isGpsSwitchOpen = %s", Boolean.valueOf(b4));
            gl.Code("LocationUtils", "loc_tag hasLocationPermission = %s", Boolean.valueOf((boolean) r72));
        }
        com.huawei.openalliance.ad.beans.inner.b bVar = new com.huawei.openalliance.ad.beans.inner.b();
        bVar.Code(I2 ? 1 : 0);
        bVar.V(b4 ? 1 : 0);
        bVar.I(r72);
        if (I2 && b4 && r72 != 0) {
            z10 = true;
        }
        bVar.V(z10);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.huawei.openalliance.ad.beans.inner.b F(Context context) {
        com.huawei.openalliance.ad.beans.inner.b D2 = D(context);
        boolean z10 = false;
        if (D2.B()) {
            boolean B2 = fr.Code(context).B();
            gl.Code("LocationUtils", "loc_tag isSdkServerLocationSwitch = %s", Boolean.valueOf(B2));
            z10 = B2;
        }
        D2.Code(z10);
        return D2;
    }

    private static boolean I(Context context) {
        long abs = Math.abs(System.currentTimeMillis() - S);
        f32580a = fr.Code(context).S();
        gl.Code("LocationUtils", "loc_tag isRefreshOk intervalRefreshTime = " + f32580a + ", intervalTime = " + abs);
        if (abs >= f32580a) {
            return true;
        }
        gl.Code("LocationUtils", "loc_tag isRefreshOk = false, too frequently (no ok)");
        return false;
    }

    private static boolean L(Context context) {
        String str;
        if (context == null) {
            str = "loc_tag isGpsSwitchOpen Context is null";
        } else {
            try {
                int i10 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                gl.V("LocationUtils", "loc_tag isGpsSwitchOpen locationMode is " + i10);
                return i10 == 3;
            } catch (Settings.SettingNotFoundException unused) {
                str = "loc_tag isGpsSwitchOpen SettingNotFoundException";
            }
        }
        gl.Z("LocationUtils", str);
        return false;
    }

    private static boolean S(Context context) {
        boolean z10;
        try {
            Class.forName("com.huawei.hms.location.LocationServices");
            Class.forName("com.huawei.hms.location.FusedLocationProviderClient");
            z10 = true;
        } catch (Throwable unused) {
            gl.Z("LocationUtils", "loc_tag check location sdk available error");
            z10 = false;
        }
        return z10 && e.Code(context, e.I(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, int i10) {
        gl.Code("LocationUtils", "loc_tag getLocationByNative");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        I = locationManager;
        if (locationManager == null) {
            gl.Z("LocationUtils", "loc_tag getLocationByNative, nativeLocationManager is null, return");
            return;
        }
        List<String> providers = locationManager.getProviders(true);
        String str = "network";
        if (!providers.contains("network")) {
            str = GeocodeSearch.GPS;
            if (!providers.contains(GeocodeSearch.GPS)) {
                gl.I("LocationUtils", "loc_tag nativeLocationProvider wrong, return");
                return;
            }
        }
        Z = str;
        if (gl.Code()) {
            gl.Code("LocationUtils", "loc_tag native location provider is: %s", Z);
        }
        try {
            String str2 = Z;
            if (str2 != null) {
                if (1 == i10) {
                    android.location.Location lastKnownLocation = I.getLastKnownLocation(str2);
                    if (lastKnownLocation == null) {
                        gl.I("LocationUtils", "loc_tag getLocationByNative, but location is null");
                        return;
                    } else {
                        gl.Code("LocationUtils", "loc_tag getLocationByNative getLastKnownLocation lat = %s, lon = %s", bc.Code(String.valueOf(lastKnownLocation.getLatitude())), bc.Code(String.valueOf(lastKnownLocation.getLongitude())));
                        Code(lastKnownLocation);
                        return;
                    }
                }
                if (2 != i10) {
                    gl.Code("LocationUtils", "loc_tag requestLocationByNative not correct type");
                    return;
                }
                gl.V("LocationUtils", "loc_tag getLocationByNative requestLocationUpdates");
                f32581b = false;
                final LocationListener locationListener = new LocationListener() { // from class: com.huawei.openalliance.ad.utils.ac.3
                    @Override // android.location.LocationListener
                    public void onLocationChanged(android.location.Location location) {
                        try {
                            if (location != null) {
                                gl.Code("LocationUtils", "loc_tag getLocationByNative Listener lat = %s, lon = %s", bc.Code(String.valueOf(location.getLatitude())), bc.Code(String.valueOf(location.getLongitude())));
                                ac.Code(location);
                            } else {
                                gl.I("LocationUtils", "loc_tag getLocationByNative Listener, but location is null");
                            }
                        } catch (Throwable th) {
                            gl.V("LocationUtils", "onLocationChanged ex: %s", th.getClass().getSimpleName());
                        }
                        ac.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderDisabled(String str3) {
                        gl.Code("LocationUtils", "loc_tag getLocationByNative onProviderDisabled");
                        ac.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderEnabled(String str3) {
                        gl.Code("LocationUtils", "loc_tag getLocationByNative onProviderEnabled");
                        ac.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onStatusChanged(String str3, int i11, Bundle bundle) {
                        gl.Code("LocationUtils", "loc_tag getLocationByNative onStatusChanged");
                        ac.V(this);
                    }
                };
                I.requestSingleUpdate(Z, locationListener, Looper.getMainLooper());
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ac.f32581b) {
                            return;
                        }
                        ac.V(locationListener);
                    }
                }, V);
            }
        } catch (Throwable th) {
            gl.Z("LocationUtils", "loc_tag getLocationByNative, exception = " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(LocationListener locationListener) {
        if (f32581b || I == null || locationListener == null) {
            return;
        }
        gl.V("LocationUtils", "loc_tag remove native location updates");
        try {
            I.removeUpdates(locationListener);
        } catch (Throwable th) {
            gl.V("LocationUtils", "loc_tag remove native location updates ex: %s", th.getClass().getSimpleName());
        }
        f32581b = true;
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean V(Context context, RequestOptions requestOptions) {
        Boolean I2;
        if (requestOptions == null || requestOptions.I() == null) {
            RequestOptions requestConfiguration = HiAd.getInstance(context).getRequestConfiguration();
            if (requestConfiguration == null || requestConfiguration.I() == null) {
                return true;
            }
            I2 = requestConfiguration.I();
        } else {
            I2 = requestOptions.I();
        }
        return I2.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z(Context context) {
        if (S(context)) {
            gl.V("LocationUtils", "loc_tag asyncLocation has location-sdk");
            try {
                C(context);
                return;
            } catch (Throwable th) {
                gl.I("LocationUtils", "loc_tag get location by kit error, " + th.getClass().getSimpleName());
                gl.Code(5, th);
            }
        } else {
            gl.V("LocationUtils", "loc_tag asyncLocation has not location-sdk");
        }
        V(context, 2);
    }

    private static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (!V()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.kuaishou.weapon.p0.g.f36121g);
        arrayList.add(com.kuaishou.weapon.p0.g.f36122h);
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            if (!al.Code(context, (String) iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(Context context) {
        try {
            return L(context);
        } catch (Throwable th) {
            gl.I("LocationUtils", "get location service switch exception: " + th.getClass().getSimpleName());
            return false;
        }
    }
}
