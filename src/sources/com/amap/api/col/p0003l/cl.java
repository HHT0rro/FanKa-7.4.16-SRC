package com.amap.api.col.p0003l;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* compiled from: MyLocationOverlay.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cl {

    /* renamed from: b, reason: collision with root package name */
    public ValueAnimator f5193b;

    /* renamed from: e, reason: collision with root package name */
    private IAMapDelegate f5196e;

    /* renamed from: f, reason: collision with root package name */
    private Marker f5197f;

    /* renamed from: g, reason: collision with root package name */
    private Circle f5198g;

    /* renamed from: i, reason: collision with root package name */
    private LatLng f5200i;

    /* renamed from: j, reason: collision with root package name */
    private double f5201j;

    /* renamed from: k, reason: collision with root package name */
    private Context f5202k;

    /* renamed from: l, reason: collision with root package name */
    private ae f5203l;

    /* renamed from: h, reason: collision with root package name */
    private MyLocationStyle f5199h = new MyLocationStyle();

    /* renamed from: m, reason: collision with root package name */
    private int f5204m = 4;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5205n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5206o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5207p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5208q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5209r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5210s = false;

    /* renamed from: a, reason: collision with root package name */
    public a f5192a = null;

    /* renamed from: c, reason: collision with root package name */
    public Animator.AnimatorListener f5194c = new Animator.AnimatorListener() { // from class: com.amap.api.col.3l.cl.1
        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            cl.this.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f5195d = new ValueAnimator.AnimatorUpdateListener() { // from class: com.amap.api.col.3l.cl.2
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (cl.this.f5198g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    cl.this.f5198g.setCenter(latLng);
                    cl.this.f5197f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    /* compiled from: MyLocationOverlay.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f10, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d10 = latLng.latitude;
            double d11 = f10;
            double d12 = d10 + ((latLng2.latitude - d10) * d11);
            double d13 = latLng.longitude;
            return new LatLng(d12, d13 + (d11 * (latLng2.longitude - d13)));
        }
    }

    public cl(IAMapDelegate iAMapDelegate, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f5202k = applicationContext;
        this.f5196e = iAMapDelegate;
        this.f5203l = new ae(applicationContext, iAMapDelegate);
        a(4, true);
    }

    private void g() {
        this.f5203l.b();
    }

    private void h() {
        b(0.0f);
    }

    private void i() {
        j();
    }

    private void j() {
        IAMapDelegate iAMapDelegate = this.f5196e;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(al.d(0.0f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f5200i != null && this.f5206o) {
            if (this.f5207p && this.f5205n) {
                return;
            }
            this.f5205n = true;
            try {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = this.f5200i;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.f5196e.animateCamera(al.a(obtain));
            } catch (Throwable th) {
                gy.b(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void l() {
        MyLocationStyle myLocationStyle = this.f5199h;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.f5199h = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        } else if (myLocationStyle.getMyLocationIcon() == null || this.f5199h.getMyLocationIcon().getBitmap() == null) {
            this.f5199h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        n();
    }

    private void m() {
        Circle circle = this.f5198g;
        if (circle != null) {
            try {
                this.f5196e.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                gy.b(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.f5198g = null;
        }
        Marker marker = this.f5197f;
        if (marker != null) {
            marker.remove();
            this.f5197f = null;
            this.f5203l.a((Marker) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0115 A[Catch: all -> 0x012a, TryCatch #0 {all -> 0x012a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0017, B:7:0x001c, B:9:0x002a, B:10:0x0035, B:12:0x0043, B:13:0x004e, B:15:0x005c, B:16:0x0067, B:18:0x006b, B:19:0x0070, B:20:0x007c, B:22:0x0081, B:23:0x0092, B:25:0x0096, B:27:0x00a4, B:29:0x00c5, B:31:0x00cd, B:34:0x00da, B:36:0x00e2, B:38:0x00fa, B:39:0x0111, B:41:0x0115, B:42:0x0106, B:43:0x00b4, B:44:0x011f), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.cl.n():void");
    }

    public final String d() {
        Marker marker = this.f5197f;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public final String e() throws RemoteException {
        Circle circle = this.f5198g;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public final void f() {
        this.f5198g = null;
        this.f5197f = null;
    }

    private void c(float f10) {
        if (this.f5208q) {
            float f11 = f10 % 360.0f;
            if (f11 > 180.0f) {
                f11 -= 360.0f;
            } else if (f11 < -180.0f) {
                f11 += 360.0f;
            }
            Marker marker = this.f5197f;
            if (marker != null) {
                marker.setRotateAngle(-f11);
            }
        }
    }

    public final void a(MyLocationStyle myLocationStyle) {
        try {
            this.f5199h = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.f5199h.isMyLocationShowing()) {
                this.f5203l.a(false);
                this.f5204m = this.f5199h.getMyLocationType();
                return;
            }
            l();
            Marker marker = this.f5197f;
            if (marker == null && this.f5198g == null) {
                return;
            }
            this.f5203l.a(marker);
            a(this.f5199h.getMyLocationType());
        } catch (Throwable th) {
            gy.b(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final void b() {
        ae aeVar;
        if (this.f5204m != 3 || (aeVar = this.f5203l) == null) {
            return;
        }
        aeVar.a();
    }

    private void b(float f10) {
        IAMapDelegate iAMapDelegate = this.f5196e;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(al.c(f10));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c() throws RemoteException {
        m();
        if (this.f5203l != null) {
            g();
            this.f5203l = null;
        }
    }

    public final MyLocationStyle a() {
        return this.f5199h;
    }

    private void a(int i10) {
        a(i10, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r4 != 7) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r4, boolean r5) {
        /*
            r3 = this;
            r3.f5204m = r4
            r0 = 0
            r3.f5205n = r0
            r3.f5207p = r0
            r3.f5206o = r0
            r3.f5209r = r0
            r3.f5210s = r0
            r1 = 1
            if (r4 == r1) goto L36
            r2 = 2
            if (r4 == r2) goto L31
            r2 = 3
            if (r4 == r2) goto L2c
            r2 = 4
            if (r4 == r2) goto L25
            r2 = 5
            if (r4 == r2) goto L20
            r2 = 7
            if (r4 == r2) goto L2e
            goto L3c
        L20:
            r3.f5209r = r1
            r3.f5208q = r0
            goto L3c
        L25:
            r3.f5206o = r1
            r3.f5209r = r1
            r3.f5208q = r0
            goto L3c
        L2c:
            r3.f5206o = r1
        L2e:
            r3.f5210s = r1
            goto L3c
        L31:
            r3.f5206o = r1
            r3.f5208q = r1
            goto L3c
        L36:
            r3.f5206o = r1
            r3.f5207p = r1
            r3.f5208q = r1
        L3c:
            boolean r4 = r3.f5209r
            if (r4 != 0) goto L56
            boolean r4 = r3.f5210s
            if (r4 == 0) goto L45
            goto L56
        L45:
            com.amap.api.maps.model.Marker r4 = r3.f5197f
            if (r4 == 0) goto L4c
            r4.setFlat(r0)
        L4c:
            r3.i()
            r3.h()
            r3.g()
            goto L88
        L56:
            boolean r4 = r3.f5210s
            if (r4 == 0) goto L77
            com.amap.api.col.3l.ae r4 = r3.f5203l
            r4.a(r1)
            if (r5 != 0) goto L71
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r4 = r3.f5196e     // Catch: java.lang.Throwable -> L6d
            r5 = 1099431936(0x41880000, float:17.0)
            com.autonavi.amap.mapcore.AbstractCameraUpdateMessage r5 = com.amap.api.col.p0003l.al.a(r5)     // Catch: java.lang.Throwable -> L6d
            r4.moveCamera(r5)     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r4 = move-exception
            r4.printStackTrace()
        L71:
            r4 = 1110704128(0x42340000, float:45.0)
            r3.b(r4)
            goto L7c
        L77:
            com.amap.api.col.3l.ae r4 = r3.f5203l
            r4.a(r0)
        L7c:
            com.amap.api.col.3l.ae r4 = r3.f5203l
            r4.a()
            com.amap.api.maps.model.Marker r4 = r3.f5197f
            if (r4 == 0) goto L88
            r4.setFlat(r1)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.cl.a(int, boolean):void");
    }

    public final void a(Location location) {
        if (location == null) {
            return;
        }
        a(this.f5199h.isMyLocationShowing());
        if (this.f5199h.isMyLocationShowing()) {
            this.f5200i = new LatLng(location.getLatitude(), location.getLongitude());
            this.f5201j = location.getAccuracy();
            if (this.f5197f == null && this.f5198g == null) {
                l();
            }
            Circle circle = this.f5198g;
            if (circle != null) {
                try {
                    double d10 = this.f5201j;
                    if (d10 != -1.0d) {
                        circle.setRadius(d10);
                    }
                } catch (Throwable th) {
                    gy.b(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            c(location.getBearing());
            if (!this.f5200i.equals(this.f5197f.getPosition())) {
                a(this.f5200i);
            } else {
                k();
            }
        }
    }

    private void a(boolean z10) {
        Circle circle = this.f5198g;
        if (circle != null && circle.isVisible() != z10) {
            this.f5198g.setVisible(z10);
        }
        Marker marker = this.f5197f;
        if (marker == null || marker.isVisible() == z10) {
            return;
        }
        this.f5197f.setVisible(z10);
    }

    public final void a(float f10) {
        Marker marker = this.f5197f;
        if (marker != null) {
            marker.setRotateAngle(f10);
        }
    }

    private void a(LatLng latLng) {
        LatLng position = this.f5197f.getPosition();
        if (position == null) {
            position = new LatLng(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        }
        if (this.f5192a == null) {
            this.f5192a = new a();
        }
        ValueAnimator valueAnimator = this.f5193b;
        if (valueAnimator == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new a(), position, latLng);
            this.f5193b = ofObject;
            ofObject.addListener(this.f5194c);
            this.f5193b.addUpdateListener(this.f5195d);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.f5193b.setEvaluator(this.f5192a);
        }
        if (position.latitude == ShadowDrawableWrapper.COS_45 && position.longitude == ShadowDrawableWrapper.COS_45) {
            this.f5193b.setDuration(1L);
        } else {
            this.f5193b.setDuration(1000L);
        }
        this.f5193b.start();
    }
}
