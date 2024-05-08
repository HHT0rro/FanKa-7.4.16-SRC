package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.c;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.i;
import com.autonavi.aps.amapapi.utils.j;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: GpsLocation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class h {

    /* renamed from: j, reason: collision with root package name */
    public static AMapLocation f6208j;

    /* renamed from: k, reason: collision with root package name */
    public static long f6209k;

    /* renamed from: l, reason: collision with root package name */
    public static Object f6210l = new Object();

    /* renamed from: q, reason: collision with root package name */
    public static long f6211q;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f6212t;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f6213u;

    /* renamed from: y, reason: collision with root package name */
    public static volatile AMapLocation f6214y;
    private GnssStatus.Callback F;

    /* renamed from: a, reason: collision with root package name */
    public Handler f6215a;

    /* renamed from: b, reason: collision with root package name */
    public LocationManager f6216b;

    /* renamed from: c, reason: collision with root package name */
    public AMapLocationClientOption f6217c;

    /* renamed from: f, reason: collision with root package name */
    public com.autonavi.aps.amapapi.filters.a f6220f;

    /* renamed from: z, reason: collision with root package name */
    private Context f6233z;
    private long A = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f6218d = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6219e = false;
    private int B = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f6221g = 240;

    /* renamed from: h, reason: collision with root package name */
    public int f6222h = 80;

    /* renamed from: i, reason: collision with root package name */
    public AMapLocation f6223i = null;

    /* renamed from: m, reason: collision with root package name */
    public long f6224m = 0;

    /* renamed from: n, reason: collision with root package name */
    public float f6225n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    public Object f6226o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public Object f6227p = new Object();
    private int C = 0;
    private GpsStatus D = null;
    private GpsStatus.Listener E = null;

    /* renamed from: r, reason: collision with root package name */
    public AMapLocationClientOption.GeoLanguage f6228r = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6229s = true;

    /* renamed from: v, reason: collision with root package name */
    public long f6230v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f6231w = 0;

    /* renamed from: x, reason: collision with root package name */
    public LocationListener f6232x = null;
    private String G = null;
    private boolean H = false;
    private int I = 0;
    private boolean J = false;

    /* compiled from: GpsLocation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private h f6236a;

        public a(h hVar) {
            this.f6236a = hVar;
        }

        public final void a() {
            this.f6236a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                d.a();
                h hVar = this.f6236a;
                if (hVar != null) {
                    hVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                h hVar = this.f6236a;
                if (hVar != null) {
                    hVar.a(str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i10, Bundle bundle) {
            try {
                h hVar = this.f6236a;
                if (hVar != null) {
                    hVar.a(i10);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public h(Context context, Handler handler) {
        this.f6220f = null;
        this.f6233z = context;
        this.f6215a = handler;
        try {
            this.f6216b = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            b.a(th, "GpsLocation", "<init>");
        }
        this.f6220f = new com.autonavi.aps.amapapi.filters.a();
    }

    private void d(AMapLocation aMapLocation) {
        if (this.f6215a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.f6215a.sendMessage(obtain);
        }
    }

    private void e(AMapLocation aMapLocation) {
        try {
            if (b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.f6217c.isOffset()) {
                DPoint a10 = e.a(this.f6233z, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(a10.getLatitude());
                aMapLocation.setLongitude(a10.getLongitude());
                aMapLocation.setOffset(this.f6217c.isOffset());
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    private void f(AMapLocation aMapLocation) {
        try {
            int i10 = this.C;
            if (i10 >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (i10 == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        if (this.f6216b == null) {
            return;
        }
        try {
            n();
            this.f6229s = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f6233z.getMainLooper();
            }
            Looper looper = myLooper;
            this.A = j.b();
            if (a(this.f6216b)) {
                try {
                    if (j.a() - f6211q >= 259200000) {
                        if (j.c(this.f6233z, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.f6216b.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                            f6211q = j.a();
                            SharedPreferences.Editor a10 = i.a(this.f6233z, "pref");
                            i.a(a10, "lagt", f6211q);
                            i.a(a10);
                            d.a();
                        } else {
                            b.a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder("GpsLocation | sendExtraCommand error: ").append(th.getMessage());
                    d.a();
                }
                if (this.f6232x == null) {
                    this.f6232x = new a(this);
                }
                if (this.f6217c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f6217c.getDeviceModeDistanceFilter() > 0.0f) {
                    this.f6216b.requestLocationUpdates(GeocodeSearch.GPS, this.f6217c.getInterval(), this.f6217c.getDeviceModeDistanceFilter(), this.f6232x, looper);
                } else {
                    this.f6216b.requestLocationUpdates(GeocodeSearch.GPS, 900L, 0.0f, this.f6232x, looper);
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    GnssStatus.Callback callback = new GnssStatus.Callback() { // from class: com.amap.api.col.3l.h.1
                        @Override // android.location.GnssStatus.Callback
                        public final void onFirstFix(int i10) {
                            h.l();
                        }

                        @Override // android.location.GnssStatus.Callback
                        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
                            h.this.a(gnssStatus);
                        }

                        @Override // android.location.GnssStatus.Callback
                        public final void onStarted() {
                            h.j();
                        }

                        @Override // android.location.GnssStatus.Callback
                        public final void onStopped() {
                            h.this.k();
                        }
                    };
                    this.F = callback;
                    this.f6216b.registerGnssStatusCallback(callback);
                } else {
                    GpsStatus.Listener listener = new GpsStatus.Listener() { // from class: com.amap.api.col.3l.h.2
                        @Override // android.location.GpsStatus.Listener
                        public final void onGpsStatusChanged(int i10) {
                            try {
                                h hVar = h.this;
                                LocationManager locationManager = hVar.f6216b;
                                if (locationManager == null) {
                                    return;
                                }
                                hVar.D = locationManager.getGpsStatus(hVar.D);
                                if (i10 == 1) {
                                    h.j();
                                    return;
                                }
                                if (i10 == 2) {
                                    h.this.k();
                                } else if (i10 == 3) {
                                    h.l();
                                } else {
                                    if (i10 != 4) {
                                        return;
                                    }
                                    h.this.m();
                                }
                            } catch (Throwable th2) {
                                new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th2.getMessage());
                                d.a();
                                b.a(th2, "GpsLocation", "onGpsStatusChanged");
                            }
                        }
                    };
                    this.E = listener;
                    this.f6216b.addGpsStatusListener(listener);
                    d.a();
                }
                a(8, 14, "no enough satellites#1401", this.f6217c.getHttpTimeOut());
                return;
            }
            d.a();
            a(8, 14, "no gps provider#1402", 0L);
        } catch (SecurityException e2) {
            d.a();
            this.f6229s = false;
            com.autonavi.aps.amapapi.utils.h.a((String) null, 2121);
            a(2, 12, e2.getMessage() + "#1201", 0L);
        } catch (Throwable th2) {
            new StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th2.getMessage());
            d.a();
            b.a(th2, "GpsLocation", "requestLocationUpdates part2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        d.a();
        this.C = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Iterable<GpsSatellite> satellites;
        int i10 = 0;
        try {
            GpsStatus gpsStatus = this.D;
            if (gpsStatus != null && (satellites = gpsStatus.getSatellites()) != null) {
                Iterator<GpsSatellite> iterator2 = satellites.iterator2();
                int maxSatellites = this.D.getMaxSatellites();
                while (iterator2.hasNext() && i10 < maxSatellites) {
                    if (iterator2.next().usedInFix()) {
                        i10++;
                    }
                }
            }
        } catch (Throwable th) {
            b.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        this.C = i10;
    }

    private void n() {
        if (j.b() - f6209k > 5000 || !j.a(f6208j)) {
            return;
        }
        if (this.f6217c.isMockEnable() || !f6208j.isMock()) {
            this.f6218d = j.b();
            c(f6208j);
        }
    }

    private static boolean o() {
        try {
            return ((Boolean) f.a(fv.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), fv.c("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private AMapLocation p() {
        float f10;
        float f11;
        try {
            if (j.a(this.f6223i) && com.autonavi.aps.amapapi.utils.a.k() && o()) {
                JSONObject jSONObject = new JSONObject((String) f.a(fv.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), fv.c("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class<?>[]) null));
                long optLong = jSONObject.optLong("time");
                if (!this.J) {
                    this.J = true;
                    com.autonavi.aps.amapapi.utils.h.a("useNaviLoc", "use NaviLoc");
                }
                if (j.a() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble("lat", ShadowDrawableWrapper.COS_45);
                    double optDouble2 = jSONObject.optDouble("lng", ShadowDrawableWrapper.COS_45);
                    float f12 = 0.0f;
                    try {
                        f10 = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f10 = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", ShadowDrawableWrapper.COS_45);
                    try {
                        f11 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f11 = 0.0f;
                    }
                    try {
                        f12 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException unused3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f10);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f11);
                    aMapLocation.setSpeed(f12);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    if (j.a(aMapLocation, this.f6223i) <= 300.0f) {
                        synchronized (this.f6227p) {
                            this.f6223i.setLongitude(optDouble2);
                            this.f6223i.setLatitude(optDouble);
                            this.f6223i.setAccuracy(f10);
                            this.f6223i.setBearing(f11);
                            this.f6223i.setSpeed(f12);
                            this.f6223i.setTime(optLong);
                            this.f6223i.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    private void c(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.f6217c.getLocationMode())) {
            if (this.f6217c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f6217c.getDeviceModeDistanceFilter() > 0.0f) {
                d(aMapLocation);
            } else if (j.b() - this.f6230v >= this.f6217c.getInterval() - 200) {
                this.f6230v = j.b();
                d(aMapLocation);
            }
        }
    }

    private AMapLocation g(AMapLocation aMapLocation) {
        if (!j.a(aMapLocation) || this.B < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.f6220f.a(aMapLocation);
    }

    private static void h(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.s()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long a10 = c.a(time, currentTimeMillis, com.autonavi.aps.amapapi.utils.a.t());
            if (a10 != time) {
                aMapLocation.setTime(a10);
                com.autonavi.aps.amapapi.utils.h.a(time, currentTimeMillis);
            }
        }
    }

    public final void b(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f6217c = aMapLocationClientOption;
        if (aMapLocationClientOption.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.f6215a) != null) {
            handler.removeMessages(8);
        }
        if (this.f6228r != this.f6217c.getGeoLanguage()) {
            synchronized (this.f6226o) {
                f6214y = null;
            }
        }
        this.f6228r = this.f6217c.getGeoLanguage();
    }

    public final boolean f() {
        AMapLocationClientOption aMapLocationClientOption = this.f6217c;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || j.b() - this.f6218d <= u.as) ? false : true;
    }

    public final int d() {
        LocationManager locationManager = this.f6216b;
        if (locationManager == null || !a(locationManager)) {
            return 1;
        }
        int i10 = Settings.Secure.getInt(this.f6233z.getContentResolver(), "location_mode", 0);
        if (i10 == 0) {
            return 2;
        }
        if (i10 == 2) {
            return 3;
        }
        return !this.f6229s ? 4 : 0;
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f6217c = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f6217c = new AMapLocationClientOption();
        }
        try {
            f6211q = i.a(this.f6233z, "pref", "lagt", f6211q);
        } catch (Throwable unused) {
        }
        i();
    }

    public final void c() {
        this.f6231w = 0;
    }

    private void b(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && this.f6215a != null) {
            long b4 = j.b();
            if (this.f6217c.getInterval() <= 8000 || b4 - this.f6230v > this.f6217c.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.f6226o) {
                    if (f6214y == null) {
                        this.f6215a.sendMessage(obtain);
                    } else if (j.a(aMapLocation, f6214y) > this.f6222h) {
                        this.f6215a.sendMessage(obtain);
                    }
                }
            }
        }
    }

    public final void a() {
        LocationManager locationManager = this.f6216b;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f6232x;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.f6232x).a();
                this.f6232x = null;
            }
        } catch (Throwable unused) {
        }
        try {
            GpsStatus.Listener listener = this.E;
            if (listener != null) {
                this.f6216b.removeGpsStatusListener(listener);
            }
        } catch (Throwable unused2) {
        }
        try {
            GnssStatus.Callback callback = this.F;
            if (callback != null) {
                this.f6216b.unregisterGnssStatusCallback(callback);
            }
        } catch (Throwable unused3) {
        }
        try {
            Handler handler = this.f6215a;
            if (handler != null) {
                handler.removeMessages(8);
            }
        } catch (Throwable unused4) {
        }
        this.C = 0;
        this.A = 0L;
        this.f6230v = 0L;
        this.f6218d = 0L;
        this.B = 0;
        this.f6231w = 0;
        this.f6220f.a();
        this.f6223i = null;
        this.f6224m = 0L;
        this.f6225n = 0.0f;
        this.G = null;
        this.J = false;
    }

    public final int e() {
        return this.C;
    }

    public final boolean b() {
        return j.b() - this.f6218d <= 2800;
    }

    private boolean b(String str) {
        try {
            ArrayList<String> b4 = j.b(str);
            ArrayList<String> b10 = j.b(this.G);
            if (b4.size() < 8 || b10.size() < 8) {
                return false;
            }
            return j.a(this.G, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GnssStatus gnssStatus) {
        int i10 = 0;
        if (gnssStatus != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    int satelliteCount = gnssStatus.getSatelliteCount();
                    int i11 = 0;
                    while (i10 < satelliteCount) {
                        try {
                            if (gnssStatus.usedInFix(i10)) {
                                i11++;
                            }
                            i10++;
                        } catch (Throwable th) {
                            th = th;
                            i10 = i11;
                            b.a(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                            this.C = i10;
                        }
                    }
                    i10 = i11;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.C = i10;
    }

    private static boolean a(LocationManager locationManager) {
        try {
            if (f6212t) {
                return f6213u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                f6213u = allProviders.contains(GeocodeSearch.GPS);
            } else {
                f6213u = false;
            }
            f6212t = true;
            return f6213u;
        } catch (Throwable th) {
            new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return f6213u;
        }
    }

    private void a(int i10, int i11, String str, long j10) {
        try {
            if (this.f6215a == null || this.f6217c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(GeocodeSearch.GPS);
            aMapLocation.setErrorCode(i11);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i10;
            this.f6215a.sendMessageDelayed(obtain, j10);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        Handler handler = this.f6215a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (j.a(aMapLocation)) {
                aMapLocation.setProvider(GeocodeSearch.GPS);
                aMapLocation.setLocationType(1);
                if (!this.f6219e && j.a(aMapLocation)) {
                    com.autonavi.aps.amapapi.utils.h.a(this.f6233z, j.b() - this.A, b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.f6219e = true;
                }
                if (j.a(aMapLocation, this.C)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.f6217c.isMockEnable()) {
                        int i10 = this.f6231w;
                        if (i10 > 3) {
                            com.autonavi.aps.amapapi.utils.h.a((String) null, 2152);
                            aMapLocation.setErrorCode(15);
                            aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                            aMapLocation.setLatitude(ShadowDrawableWrapper.COS_45);
                            aMapLocation.setLongitude(ShadowDrawableWrapper.COS_45);
                            aMapLocation.setAltitude(ShadowDrawableWrapper.COS_45);
                            aMapLocation.setSpeed(0.0f);
                            aMapLocation.setAccuracy(0.0f);
                            aMapLocation.setBearing(0.0f);
                            aMapLocation.setExtras(null);
                            c(aMapLocation);
                            return;
                        }
                        this.f6231w = i10 + 1;
                        return;
                    }
                } else {
                    this.f6231w = 0;
                }
                aMapLocation.setSatellites(this.C);
                e(aMapLocation);
                f(aMapLocation);
                h(aMapLocation);
                AMapLocation g3 = g(aMapLocation);
                a(g3);
                b(g3);
                synchronized (this.f6226o) {
                    a(g3, f6214y);
                }
                try {
                    if (j.a(g3)) {
                        if (this.f6223i != null) {
                            this.f6224m = location.getTime() - this.f6223i.getTime();
                            this.f6225n = j.a(this.f6223i, g3);
                        }
                        synchronized (this.f6227p) {
                            this.f6223i = g3.m1956clone();
                        }
                        this.G = null;
                        this.H = false;
                        this.I = 0;
                    }
                } catch (Throwable th) {
                    b.a(th, "GpsLocation", "onLocationChangedLast");
                }
                c(g3);
            }
        } catch (Throwable th2) {
            b.a(th2, "GpsLocation", "onLocationChanged");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                this.f6218d = 0L;
                this.C = 0;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        if (i10 == 0) {
            try {
                this.f6218d = 0L;
                this.C = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void a(AMapLocation aMapLocation) {
        if (j.a(aMapLocation)) {
            this.f6218d = j.b();
            synchronized (f6210l) {
                f6209k = j.b();
                f6208j = aMapLocation.m1956clone();
            }
            this.B++;
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f6221g = bundle.getInt("I_MAX_GEO_DIS");
                this.f6222h = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f6226o) {
                    f6214y = aMapLocation;
                }
            } catch (Throwable th) {
                b.a(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    private void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f6217c.isNeedAddress() || j.a(aMapLocation, aMapLocation2) >= this.f6221g) {
            return;
        }
        b.a(aMapLocation, aMapLocation2);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.h.a(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }
}
