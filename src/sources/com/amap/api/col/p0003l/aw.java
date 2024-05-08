package com.amap.api.col.p0003l;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fr;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.base.ae.gmap.glyph.ReflectUtil;
import com.huawei.flexiblelayout.card.IndicatorCard;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: AMapReflectionLocationSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aw implements LocationSource {
    private Method A;
    private Method B;
    private Method C;
    private Method D;
    private Method E;
    private Method F;
    private Method G;
    private Method H;
    private Method I;
    private boolean J = false;
    private long K = 2000;
    private InvocationHandler L = new InvocationHandler() { // from class: com.amap.api.col.3l.aw.1
        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!TextUtils.equals(method.getName(), "onLocationChanged") || aw.this.f5030b == null || objArr == null || objArr.length != 1) {
                return null;
            }
            Object obj2 = objArr[0];
            Location location = (Location) obj2;
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            Object invokeMethod = ReflectUtil.invokeMethod(obj2, aw.this.f5044p, new Object[0]);
            if (invokeMethod instanceof Integer) {
                extras.putInt("errorCode", ((Integer) invokeMethod).intValue());
            }
            Object invokeMethod2 = ReflectUtil.invokeMethod(obj2, aw.this.f5045q, new Object[0]);
            if (invokeMethod2 instanceof String) {
                extras.putString(MyLocationStyle.ERROR_INFO, (String) invokeMethod2);
            }
            Object invokeMethod3 = ReflectUtil.invokeMethod(obj2, aw.this.f5046r, new Object[0]);
            if (invokeMethod3 instanceof Integer) {
                extras.putInt(MyLocationStyle.LOCATION_TYPE, ((Integer) invokeMethod3).intValue());
            }
            Object invokeMethod4 = ReflectUtil.invokeMethod(obj2, aw.this.f5047s, new Object[0]);
            if (invokeMethod4 instanceof Float) {
                extras.putFloat("Accuracy", ((Float) invokeMethod4).floatValue());
            }
            Object invokeMethod5 = ReflectUtil.invokeMethod(obj2, aw.this.f5048t, new Object[0]);
            if (invokeMethod5 instanceof String) {
                extras.putString("AdCode", (String) invokeMethod5);
            }
            Object invokeMethod6 = ReflectUtil.invokeMethod(obj2, aw.this.f5049u, new Object[0]);
            if (invokeMethod6 instanceof String) {
                extras.putString("Address", (String) invokeMethod6);
            }
            Object invokeMethod7 = ReflectUtil.invokeMethod(obj2, aw.this.f5050v, new Object[0]);
            if (invokeMethod7 instanceof String) {
                extras.putString("AoiName", (String) invokeMethod7);
            }
            Object invokeMethod8 = ReflectUtil.invokeMethod(obj2, aw.this.f5051w, new Object[0]);
            if (invokeMethod8 instanceof String) {
                extras.putString("City", (String) invokeMethod8);
            }
            Object invokeMethod9 = ReflectUtil.invokeMethod(obj2, aw.this.f5052x, new Object[0]);
            if (invokeMethod9 instanceof String) {
                extras.putString("CityCode", (String) invokeMethod9);
            }
            Object invokeMethod10 = ReflectUtil.invokeMethod(obj2, aw.this.f5053y, new Object[0]);
            if (invokeMethod10 instanceof String) {
                extras.putString("Country", (String) invokeMethod10);
            }
            Object invokeMethod11 = ReflectUtil.invokeMethod(obj2, aw.this.f5054z, new Object[0]);
            if (invokeMethod11 instanceof String) {
                extras.putString("District", (String) invokeMethod11);
            }
            Object invokeMethod12 = ReflectUtil.invokeMethod(obj2, aw.this.A, new Object[0]);
            if (invokeMethod12 instanceof String) {
                extras.putString("Street", (String) invokeMethod12);
            }
            Object invokeMethod13 = ReflectUtil.invokeMethod(obj2, aw.this.B, new Object[0]);
            if (invokeMethod13 instanceof String) {
                extras.putString("StreetNum", (String) invokeMethod13);
            }
            Object invokeMethod14 = ReflectUtil.invokeMethod(obj2, aw.this.C, new Object[0]);
            if (invokeMethod14 instanceof String) {
                extras.putString("PoiName", (String) invokeMethod14);
            }
            Object invokeMethod15 = ReflectUtil.invokeMethod(obj2, aw.this.D, new Object[0]);
            if (invokeMethod15 instanceof String) {
                extras.putString("Province", (String) invokeMethod15);
            }
            Object invokeMethod16 = ReflectUtil.invokeMethod(obj2, aw.this.E, new Object[0]);
            if (invokeMethod16 instanceof Float) {
                extras.putFloat("Speed", ((Float) invokeMethod16).floatValue());
            }
            Object invokeMethod17 = ReflectUtil.invokeMethod(obj2, aw.this.F, new Object[0]);
            if (invokeMethod17 instanceof String) {
                extras.putString("Floor", (String) invokeMethod17);
            }
            Object invokeMethod18 = ReflectUtil.invokeMethod(obj2, aw.this.G, new Object[0]);
            if (invokeMethod18 instanceof Float) {
                extras.putFloat("Bearing", ((Float) invokeMethod18).floatValue());
            }
            Object invokeMethod19 = ReflectUtil.invokeMethod(obj2, aw.this.H, new Object[0]);
            if (invokeMethod19 instanceof String) {
                extras.putString("BuildingId", (String) invokeMethod19);
            }
            Object invokeMethod20 = ReflectUtil.invokeMethod(obj2, aw.this.I, new Object[0]);
            if (invokeMethod20 instanceof Double) {
                extras.putDouble("Altitude", ((Double) invokeMethod20).doubleValue());
            }
            location.setExtras(extras);
            aw.this.f5030b.onLocationChanged(location);
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private Context f5029a;

    /* renamed from: b, reason: collision with root package name */
    private LocationSource.OnLocationChangedListener f5030b;

    /* renamed from: c, reason: collision with root package name */
    private Object f5031c;

    /* renamed from: d, reason: collision with root package name */
    private Object f5032d;

    /* renamed from: e, reason: collision with root package name */
    private Object f5033e;

    /* renamed from: f, reason: collision with root package name */
    private Method f5034f;

    /* renamed from: g, reason: collision with root package name */
    private Method f5035g;

    /* renamed from: h, reason: collision with root package name */
    private Method f5036h;

    /* renamed from: i, reason: collision with root package name */
    private Method f5037i;

    /* renamed from: j, reason: collision with root package name */
    private Method f5038j;

    /* renamed from: k, reason: collision with root package name */
    private Method f5039k;

    /* renamed from: l, reason: collision with root package name */
    private Method f5040l;

    /* renamed from: m, reason: collision with root package name */
    private Method f5041m;

    /* renamed from: n, reason: collision with root package name */
    private Method f5042n;

    /* renamed from: o, reason: collision with root package name */
    private Method f5043o;

    /* renamed from: p, reason: collision with root package name */
    private Method f5044p;

    /* renamed from: q, reason: collision with root package name */
    private Method f5045q;

    /* renamed from: r, reason: collision with root package name */
    private Method f5046r;

    /* renamed from: s, reason: collision with root package name */
    private Method f5047s;

    /* renamed from: t, reason: collision with root package name */
    private Method f5048t;

    /* renamed from: u, reason: collision with root package name */
    private Method f5049u;

    /* renamed from: v, reason: collision with root package name */
    private Method f5050v;

    /* renamed from: w, reason: collision with root package name */
    private Method f5051w;

    /* renamed from: x, reason: collision with root package name */
    private Method f5052x;

    /* renamed from: y, reason: collision with root package name */
    private Method f5053y;

    /* renamed from: z, reason: collision with root package name */
    private Method f5054z;

    public aw(Context context) {
        this.f5029a = context;
        a();
        b();
        c();
    }

    @Override // com.amap.api.maps.LocationSource
    public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.f5030b = onLocationChangedListener;
        if (fr.a(this.f5029a, dx.a()).f5947a == fr.c.SuccessCode && this.f5031c == null) {
            try {
                Object newInstance = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f5029a});
                this.f5031c = newInstance;
                if (newInstance == null) {
                    return;
                }
                this.f5032d = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClientOption", null, null);
                Object newProxyInstance = Proxy.newProxyInstance(aw.class.getClassLoader(), new Class[]{AMapLocationListener.class}, this.L);
                this.f5033e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f5031c, this.f5034f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f5032d, this.f5039k, Long.valueOf(this.K));
                ReflectUtil.invokeMethod(this.f5032d, this.f5040l, Boolean.valueOf(this.J));
                ReflectUtil.invokeMethod(this.f5032d, this.f5041m, ReflectUtil.getField("com.amap.api.location.AMapLocationClientOption$AMapLocationMode", null, "Hight_Accuracy"));
                ReflectUtil.invokeMethod(this.f5032d, this.f5042n, Boolean.FALSE);
                ReflectUtil.invokeMethod(this.f5031c, this.f5035g, this.f5032d);
                ReflectUtil.invokeMethod(this.f5031c, this.f5036h, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public final void deactivate() {
        this.f5030b = null;
        Object obj = this.f5031c;
        if (obj != null) {
            ReflectUtil.invokeMethod(obj, this.f5037i, new Object[0]);
            ReflectUtil.invokeMethod(this.f5031c, this.f5038j, new Object[0]);
        }
        this.f5031c = null;
    }

    private void b() {
        try {
            this.f5039k = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", IndicatorCard.f27800l, Long.TYPE);
            Class<Boolean> cls = Boolean.TYPE;
            this.f5040l = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setOnceLocation", cls);
            AMapLocationClientOption.AMapLocationMode aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
            this.f5041m = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setLocationMode", AMapLocationClientOption.AMapLocationMode.class);
            this.f5042n = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setNeedAddress", cls);
            this.f5043o = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "getInterval", new Class[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        try {
            this.f5044p = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorCode", new Class[0]);
            this.f5045q = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorInfo", new Class[0]);
            this.f5046r = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getLocationType", new Class[0]);
            this.f5047s = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAccuracy", new Class[0]);
            this.f5048t = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAdCode", new Class[0]);
            this.f5049u = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAddress", new Class[0]);
            this.f5050v = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAoiName", new Class[0]);
            this.f5051w = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCity", new Class[0]);
            this.f5052x = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCityCode", new Class[0]);
            this.f5053y = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCountry", new Class[0]);
            this.f5054z = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getDistrict", new Class[0]);
            this.A = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreet", new Class[0]);
            this.B = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreetNum", new Class[0]);
            this.C = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getPoiName", new Class[0]);
            this.D = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getProvince", new Class[0]);
            this.E = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getSpeed", new Class[0]);
            this.F = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getFloor", new Class[0]);
            this.G = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBearing", new Class[0]);
            this.H = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBuildingId", new Class[0]);
            this.I = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAltitude", new Class[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(long j10) {
        Object obj = this.f5032d;
        if (obj != null && this.f5031c != null) {
            Object invokeMethod = ReflectUtil.invokeMethod(obj, this.f5043o, new Object[0]);
            if ((invokeMethod instanceof Long) && ((Long) invokeMethod).longValue() != j10) {
                ReflectUtil.invokeMethod(this.f5032d, this.f5039k, Long.valueOf(j10));
                ReflectUtil.invokeMethod(this.f5031c, this.f5035g, this.f5032d);
            }
        }
        this.K = j10;
    }

    public final void a(int i10) {
        if (i10 != 1 && i10 != 0) {
            a(false);
        } else {
            a(true);
        }
    }

    private void a(boolean z10) {
        Object obj;
        if (this.f5032d != null && (obj = this.f5031c) != null) {
            try {
                ReflectUtil.invokeMethod(obj, this.f5038j, new Object[0]);
                this.f5031c = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f5029a});
                Object newProxyInstance = Proxy.newProxyInstance(aw.class.getClassLoader(), new Class[]{AMapLocationListener.class}, this.L);
                this.f5033e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f5031c, this.f5034f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f5032d, this.f5040l, Boolean.valueOf(z10));
                ReflectUtil.invokeMethod(this.f5032d, this.f5042n, Boolean.FALSE);
                if (!z10) {
                    ReflectUtil.invokeMethod(this.f5032d, this.f5039k, Long.valueOf(this.K));
                }
                ReflectUtil.invokeMethod(this.f5031c, this.f5035g, this.f5032d);
                ReflectUtil.invokeMethod(this.f5031c, this.f5036h, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.J = z10;
    }

    private void a() {
        try {
            this.f5034f = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationListener", AMapLocationListener.class);
            this.f5035g = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationOption", Class.forName("com.amap.api.location.AMapLocationClientOption"));
            this.f5036h = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "startLocation", new Class[0]);
            this.f5037i = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "stopLocation", new Class[0]);
            this.f5038j = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "onDestroy", new Class[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
