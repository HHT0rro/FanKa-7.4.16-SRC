package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import com.autonavi.aps.amapapi.utils.j;
import java.util.List;

/* compiled from: CoarseLocation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static volatile AMapLocation f6000a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f6001b = "CoarseLocation";

    /* renamed from: q, reason: collision with root package name */
    private static long f6002q;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f6003r;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f6004s;

    /* renamed from: t, reason: collision with root package name */
    private static boolean f6005t;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f6006u;

    /* renamed from: f, reason: collision with root package name */
    private com.autonavi.aps.amapapi.filters.a f6010f;

    /* renamed from: j, reason: collision with root package name */
    private Handler f6014j;

    /* renamed from: k, reason: collision with root package name */
    private Context f6015k;

    /* renamed from: n, reason: collision with root package name */
    private LocationManager f6018n;

    /* renamed from: o, reason: collision with root package name */
    private AMapLocationClientOption f6019o;

    /* renamed from: c, reason: collision with root package name */
    private long f6007c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6008d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f6009e = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f6011g = 240;

    /* renamed from: h, reason: collision with root package name */
    private int f6012h = 80;

    /* renamed from: i, reason: collision with root package name */
    private int f6013i = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f6016l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f6017m = 0;

    /* renamed from: p, reason: collision with root package name */
    private Object f6020p = new Object();

    /* renamed from: v, reason: collision with root package name */
    private boolean f6021v = true;

    /* renamed from: w, reason: collision with root package name */
    private AMapLocationClientOption.GeoLanguage f6022w = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: x, reason: collision with root package name */
    private LocationListener f6023x = null;

    /* compiled from: CoarseLocation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private g f6024a;

        public a(g gVar) {
            this.f6024a = gVar;
        }

        public final void a() {
            this.f6024a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                g gVar = this.f6024a;
                if (gVar != null) {
                    gVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                g gVar = this.f6024a;
                if (gVar != null) {
                    gVar.g();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                d.a();
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i10, Bundle bundle) {
            try {
                g gVar = this.f6024a;
                if (gVar != null) {
                    gVar.a(i10);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public g(Context context, Handler handler) {
        this.f6010f = null;
        this.f6015k = context;
        this.f6014j = handler;
        try {
            this.f6018n = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            b.a(th, f6001b, "<init>");
        }
        this.f6010f = new com.autonavi.aps.amapapi.filters.a();
    }

    private boolean c() {
        boolean z10 = true;
        try {
            if (j.c() >= 28) {
                if (this.f6018n == null) {
                    this.f6018n = (LocationManager) this.f6015k.getApplicationContext().getSystemService("location");
                }
                z10 = ((Boolean) f.a(this.f6018n, "isLocationEnabled", new Object[0])).booleanValue();
            }
            if (j.c() >= 24 && j.c() < 28) {
                if (Settings.Secure.getInt(this.f6015k.getContentResolver(), "location_mode", 0) == 0) {
                    return false;
                }
            }
        } catch (Throwable unused) {
            d.a();
        }
        return z10;
    }

    private void d() {
        c(a(12, "定位服务没有开启，请在设置中打开定位服务开关#1206"));
    }

    private void e() {
        c(a(20, "模糊权限下不支持连续定位#2006"));
    }

    private void f() {
        if (this.f6018n == null) {
            return;
        }
        try {
            this.f6021v = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f6015k.getMainLooper();
            }
            this.f6007c = j.b();
            if (b(this.f6018n)) {
                if (this.f6023x == null) {
                    this.f6023x = new a(this);
                }
                this.f6018n.requestLocationUpdates("network", this.f6019o.getInterval(), this.f6019o.getDeviceModeDistanceFilter(), this.f6023x, myLooper);
            }
            if (a(this.f6018n)) {
                try {
                    if (j.a() - f6002q >= 259200000) {
                        if (j.c(this.f6015k, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.f6018n.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                            f6002q = j.a();
                            SharedPreferences.Editor a10 = i.a(this.f6015k, "pref");
                            i.a(a10, "lagt", f6002q);
                            i.a(a10);
                            d.a();
                        } else {
                            b.a(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder("CoarseLocation | sendExtraCommand error: ").append(th.getMessage());
                    d.a();
                }
                if (this.f6023x == null) {
                    this.f6023x = new a(this);
                }
                this.f6018n.requestLocationUpdates(GeocodeSearch.GPS, this.f6019o.getInterval(), this.f6019o.getDeviceModeDistanceFilter(), this.f6023x, myLooper);
                d.a();
            }
            if (f6004s || f6006u) {
                a(100, "系统返回定位结果超时#2002", this.f6019o.getHttpTimeOut());
            }
            if (f6004s || f6006u) {
                return;
            }
            d.a();
            a(100, "系统定位当前不可用#2003", 0L);
        } catch (SecurityException e2) {
            d.a();
            this.f6021v = false;
            h.a((String) null, 2121);
            a(101, e2.getMessage() + "#2004", 0L);
        } catch (Throwable th2) {
            new StringBuilder("CoarseLocation | requestLocationUpdates error: ").append(th2.getMessage());
            d.a();
            b.a(th2, "CoarseLocation", "requestLocationUpdates part2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            d.a();
            this.f6013i = 0;
        } catch (Throwable unused) {
        }
    }

    public final void b(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f6019o = aMapLocationClientOption;
        new StringBuilder("option: ").append(this.f6019o.toString());
        d.a();
        this.f6014j.removeMessages(100);
        if (this.f6022w != this.f6019o.getGeoLanguage()) {
            synchronized (this.f6020p) {
                f6000a = null;
            }
        }
        this.f6022w = this.f6019o.getGeoLanguage();
    }

    private static void g(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.s()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long a10 = c.a(time, currentTimeMillis, com.autonavi.aps.amapapi.utils.a.t());
            if (a10 != time) {
                aMapLocation.setTime(a10);
                h.a(time, currentTimeMillis);
            }
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f6019o = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f6019o = new AMapLocationClientOption();
        }
        new StringBuilder("option: ").append(this.f6019o.toString());
        d.a();
        if (!this.f6019o.isOnceLocation()) {
            e();
        } else if (!c()) {
            d();
        } else {
            try {
                f6002q = i.a(this.f6015k, "pref", "lagt", f6002q);
            } catch (Throwable unused) {
            }
            f();
        }
    }

    private void d(AMapLocation aMapLocation) {
        if (this.f6014j != null) {
            d.a();
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 101;
            this.f6014j.sendMessage(obtain);
        }
    }

    private void e(AMapLocation aMapLocation) {
        try {
            if (b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.f6019o.isOffset()) {
                DPoint a10 = e.a(this.f6015k, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(a10.getLatitude());
                aMapLocation.setLongitude(a10.getLongitude());
                aMapLocation.setOffset(this.f6019o.isOffset());
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        } catch (Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
            new StringBuilder("CoarseLocation | offset error: ").append(th.getMessage());
            d.a();
        }
    }

    private void c(AMapLocation aMapLocation) {
        if (this.f6019o.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f6019o.getDeviceModeDistanceFilter() > 0.0f) {
            d(aMapLocation);
        } else if (j.b() - this.f6016l >= this.f6019o.getInterval() - 200) {
            this.f6016l = j.b();
            d(aMapLocation);
        }
    }

    private static boolean b(LocationManager locationManager) {
        try {
            if (f6005t) {
                return f6006u;
            }
            boolean isProviderEnabled = locationManager.isProviderEnabled("network");
            f6006u = isProviderEnabled;
            f6005t = true;
            return isProviderEnabled;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return f6006u;
        }
    }

    private static com.autonavi.aps.amapapi.model.a a(int i10, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i10);
        aVar.setLocationDetail(str);
        return aVar;
    }

    private static int b(Location location) {
        Bundle extras = location.getExtras();
        int i10 = extras != null ? extras.getInt("satellites") : 0;
        d.b();
        return i10;
    }

    public final void a() {
        d.a();
        LocationManager locationManager = this.f6018n;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f6023x;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.f6023x).a();
                this.f6023x = null;
                d.a();
            }
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | removeUpdates error ").append(th.getMessage());
            d.a();
        }
        try {
            Handler handler = this.f6014j;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (Throwable unused) {
        }
        this.f6013i = 0;
        this.f6007c = 0L;
        this.f6016l = 0L;
        this.f6009e = 0;
        this.f6017m = 0;
        this.f6010f.a();
    }

    private void b(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && this.f6014j != null) {
            long b4 = j.b();
            if (this.f6019o.getInterval() <= 8000 || b4 - this.f6016l > this.f6019o.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 102;
                synchronized (this.f6020p) {
                    if (f6000a == null) {
                        this.f6014j.sendMessage(obtain);
                    } else if (j.a(aMapLocation, f6000a) > this.f6012h) {
                        this.f6014j.sendMessage(obtain);
                    }
                }
            }
        }
    }

    private static boolean a(LocationManager locationManager) {
        try {
            if (f6003r) {
                return f6004s;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                f6004s = allProviders.contains(GeocodeSearch.GPS);
            } else {
                f6004s = false;
            }
            f6003r = true;
            return f6004s;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return f6004s;
        }
    }

    public final int b() {
        LocationManager locationManager = this.f6018n;
        if (locationManager == null || !a(locationManager)) {
            return 1;
        }
        int i10 = Settings.Secure.getInt(this.f6015k.getContentResolver(), "location_mode", 0);
        if (i10 == 0) {
            return 2;
        }
        if (i10 == 2) {
            return 3;
        }
        return !this.f6021v ? 4 : 0;
    }

    private void a(int i10, String str, long j10) {
        try {
            if (this.f6014j != null) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(20);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(11);
                obtain.obj = aMapLocation;
                obtain.what = i10;
                this.f6014j.sendMessageDelayed(obtain, j10);
            }
        } catch (Throwable unused) {
            d.b();
        }
    }

    private AMapLocation f(AMapLocation aMapLocation) {
        if (!j.a(aMapLocation) || this.f6009e < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.f6010f.a(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b A[Catch: all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:8:0x000c, B:11:0x0018, B:13:0x0024, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:19:0x0059, B:25:0x0075, B:27:0x007b, B:29:0x008a, B:31:0x008f, B:33:0x00bb, B:35:0x00c1, B:36:0x00dc, B:40:0x00e3, B:45:0x00e9, B:46:0x00bf, B:52:0x002a, B:38:0x00dd, B:39:0x00e2), top: B:7:0x000c, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf A[Catch: all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:8:0x000c, B:11:0x0018, B:13:0x0024, B:14:0x002f, B:16:0x0039, B:18:0x003f, B:19:0x0059, B:25:0x0075, B:27:0x007b, B:29:0x008a, B:31:0x008f, B:33:0x00bb, B:35:0x00c1, B:36:0x00dc, B:40:0x00e3, B:45:0x00e9, B:46:0x00bf, B:52:0x002a, B:38:0x00dd, B:39:0x00e2), top: B:7:0x000c, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.location.Location r10) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.g.a(android.location.Location):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        if (i10 == 0) {
            try {
                d.a();
                this.f6013i = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void a(AMapLocation aMapLocation) {
        if (j.a(aMapLocation)) {
            this.f6009e++;
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f6011g = bundle.getInt("I_MAX_GEO_DIS");
                this.f6012h = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f6020p) {
                    f6000a = aMapLocation;
                }
            } catch (Throwable th) {
                b.a(th, "CoarseLocation", "setLastGeoLocation");
            }
        }
    }

    private void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f6019o.isNeedAddress() || j.a(aMapLocation, aMapLocation2) >= this.f6011g) {
            return;
        }
        b.a(aMapLocation, aMapLocation2);
    }
}
