package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.col.p0003l.ef;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* compiled from: MapOverlayViewGroup.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eh extends ViewGroup implements ei {

    /* renamed from: a, reason: collision with root package name */
    public ej f5486a;

    /* renamed from: b, reason: collision with root package name */
    public av f5487b;

    /* renamed from: c, reason: collision with root package name */
    private IAMapDelegate f5488c;

    /* renamed from: d, reason: collision with root package name */
    private IGlOverlayLayer f5489d;

    /* renamed from: e, reason: collision with root package name */
    private Context f5490e;

    /* renamed from: f, reason: collision with root package name */
    private el f5491f;

    /* renamed from: g, reason: collision with root package name */
    private eg f5492g;

    /* renamed from: h, reason: collision with root package name */
    private ee f5493h;

    /* renamed from: i, reason: collision with root package name */
    private ek f5494i;

    /* renamed from: j, reason: collision with root package name */
    private ed f5495j;

    /* renamed from: k, reason: collision with root package name */
    private ef f5496k;

    /* renamed from: l, reason: collision with root package name */
    private em f5497l;

    /* renamed from: m, reason: collision with root package name */
    private View f5498m;

    /* renamed from: n, reason: collision with root package name */
    private BasePointOverlay f5499n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f5500o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5501p;

    /* renamed from: q, reason: collision with root package name */
    private View f5502q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5503r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5504s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f5505t;

    /* compiled from: MapOverlayViewGroup.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public FPoint f5512a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5513b;

        /* renamed from: c, reason: collision with root package name */
        public int f5514c;

        /* renamed from: d, reason: collision with root package name */
        public int f5515d;

        /* renamed from: e, reason: collision with root package name */
        public int f5516e;

        public a(FPoint fPoint, int i10) {
            this(-2, -2, ((PointF) fPoint).x, ((PointF) fPoint).y, 0, 0, i10);
        }

        public a(int i10, int i11, float f10, float f11, int i12, int i13, int i14) {
            super(i10, i11);
            FPoint fPoint = new FPoint();
            this.f5512a = fPoint;
            this.f5513b = false;
            ((PointF) fPoint).x = f10;
            ((PointF) fPoint).y = f11;
            this.f5514c = i12;
            this.f5515d = i13;
            this.f5516e = i14;
        }
    }

    public eh(Context context, IAMapDelegate iAMapDelegate, IGlOverlayLayer iGlOverlayLayer) {
        super(context);
        this.f5500o = null;
        int i10 = 1;
        this.f5501p = true;
        this.f5504s = true;
        this.f5505t = true;
        try {
            this.f5489d = iGlOverlayLayer;
            this.f5488c = iAMapDelegate;
            this.f5490e = context;
            this.f5486a = new ej();
            this.f5495j = new ed(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.f5488c.getGLMapView() != null) {
                addView(this.f5488c.getGLMapView(), 0, layoutParams);
            } else {
                i10 = 0;
            }
            addView(this.f5495j, i10, layoutParams);
            if (this.f5504s) {
                return;
            }
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
    }

    public static /* synthetic */ View f(eh ehVar) {
        ehVar.f5498m = null;
        return null;
    }

    private void k() {
        ek ekVar = this.f5494i;
        if (ekVar == null) {
            this.f5486a.a(this, new Object[0]);
        } else {
            if (ekVar == null || ekVar.getVisibility() != 0) {
                return;
            }
            this.f5494i.postInvalidate();
        }
    }

    private void l() {
        em emVar = this.f5497l;
        if (emVar != null) {
            emVar.a();
        }
        ek ekVar = this.f5494i;
        if (ekVar != null) {
            ekVar.a();
        }
        el elVar = this.f5491f;
        if (elVar != null) {
            elVar.a();
        }
        eg egVar = this.f5492g;
        if (egVar != null) {
            egVar.a();
        }
        ee eeVar = this.f5493h;
        if (eeVar != null) {
            eeVar.a();
        }
        ef efVar = this.f5496k;
        if (efVar != null) {
            efVar.a();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void g(Boolean bool) {
        el elVar = this.f5491f;
        if (elVar == null) {
            this.f5486a.a(this, bool);
            return;
        }
        if (elVar != null && bool.booleanValue()) {
            this.f5491f.a(true);
            return;
        }
        el elVar2 = this.f5491f;
        if (elVar2 != null) {
            elVar2.a(false);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void h() {
        ee eeVar = this.f5493h;
        if (eeVar == null) {
            this.f5486a.a(this, new Object[0]);
        } else {
            eeVar.b();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void hideInfoWindow() {
        try {
            IAMapDelegate iAMapDelegate = this.f5488c;
            if (iAMapDelegate == null || iAMapDelegate.getMainHandler() == null) {
                return;
            }
            this.f5488c.getMainHandler().post(new Runnable() { // from class: com.amap.api.col.3l.eh.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (eh.this.f5498m != null) {
                        eh.this.f5498m.clearFocus();
                        eh ehVar = eh.this;
                        ehVar.removeView(ehVar.f5498m);
                        dx.a(eh.this.f5498m.getBackground());
                        dx.a(eh.this.f5500o);
                        eh.f(eh.this);
                    }
                }
            });
            BasePointOverlay basePointOverlay = this.f5499n;
            if (basePointOverlay != null) {
                this.f5489d.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.FALSE});
            }
            this.f5499n = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void i(Boolean bool) {
        ef efVar = this.f5496k;
        if (efVar == null) {
            this.f5486a.a(this, bool);
        } else {
            efVar.a(bool.booleanValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final View j() {
        return this;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        return (this.f5498m == null || this.f5499n == null || !dx.a(new Rect(this.f5498m.getLeft(), this.f5498m.getTop(), this.f5498m.getRight(), this.f5498m.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        try {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof a) {
                        a(childAt, (a) childAt.getLayoutParams());
                    } else {
                        a(childAt, childAt.getLayoutParams());
                    }
                }
            }
            el elVar = this.f5491f;
            if (elVar != null) {
                elVar.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        try {
            BasePointOverlay basePointOverlay = this.f5499n;
            if (basePointOverlay != null && this.f5489d.checkInBounds(basePointOverlay.getId())) {
                if (this.f5501p) {
                    FPoint obtain = FPoint.obtain();
                    this.f5489d.getMarkerInfoWindowOffset(this.f5499n.getId(), obtain);
                    int i10 = (int) ((PointF) obtain).x;
                    int i11 = (int) (((PointF) obtain).y + 2.0f);
                    obtain.recycle();
                    View a10 = a(this.f5499n);
                    if (a10 == null) {
                        View view = this.f5498m;
                        if (view == null || view.getVisibility() != 0) {
                            return;
                        }
                        hideInfoWindow();
                        return;
                    }
                    FPoint obtain2 = FPoint.obtain();
                    this.f5489d.getOverlayScreenPos(this.f5499n.getId(), obtain2);
                    a(a10, (int) ((PointF) obtain2).x, (int) ((PointF) obtain2).y, i10, i11);
                    View view2 = this.f5498m;
                    if (view2 != null) {
                        a aVar = (a) view2.getLayoutParams();
                        if (aVar != null) {
                            aVar.f5512a = FPoint.obtain(((PointF) obtain2).x, ((PointF) obtain2).y);
                            aVar.f5514c = i10;
                            aVar.f5515d = i11;
                        }
                        onLayout(false, 0, 0, 0, 0);
                        if (this.f5487b.a()) {
                            this.f5487b.a(this.f5499n.getTitle(), this.f5499n.getSnippet());
                        }
                        if (this.f5498m.getVisibility() == 8) {
                            this.f5498m.setVisibility(0);
                        }
                    }
                    obtain2.recycle();
                    return;
                }
                return;
            }
            View view3 = this.f5498m;
            if (view3 == null || view3.getVisibility() != 0) {
                return;
            }
            this.f5498m.setVisibility(8);
        } catch (Throwable th) {
            gy.b(th, "MapOverlayViewGroup", "redrawInfoWindow");
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(av avVar) {
        this.f5487b = avVar;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            av avVar = this.f5487b;
            if (!(avVar != null && avVar.a() && basePointOverlay.getTitle() == null && basePointOverlay.getSnippet() == null) && basePointOverlay.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay2 = this.f5499n;
                if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                    hideInfoWindow();
                }
                if (this.f5487b != null) {
                    this.f5499n = basePointOverlay;
                    this.f5503r = true;
                    this.f5489d.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        el elVar = new el(context);
        this.f5491f = elVar;
        elVar.c(this.f5505t);
        this.f5494i = new ek(context, this.f5488c);
        this.f5496k = new ef(context);
        this.f5497l = new em(context, this.f5488c);
        this.f5492g = new eg(context, this.f5488c);
        this.f5493h = new ee(context, this.f5488c);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f5491f, layoutParams);
        addView(this.f5494i, layoutParams);
        addView(this.f5496k, new ViewGroup.LayoutParams(-2, -2));
        addView(this.f5497l, new a(new FPoint(0.0f, 0.0f), 83));
        addView(this.f5492g, new a(FPoint.obtain(0.0f, 0.0f), 83));
        addView(this.f5493h, new a(FPoint.obtain(0.0f, 0.0f), 51));
        this.f5493h.setVisibility(8);
        this.f5488c.setMapWidgetListener(new AMapWidgetListener() { // from class: com.amap.api.col.3l.eh.1
            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public final void invalidateCompassView() {
                if (eh.this.f5493h == null) {
                    return;
                }
                eh.this.f5493h.post(new Runnable() { // from class: com.amap.api.col.3l.eh.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        eh.this.f5493h.b();
                    }
                });
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public final void invalidateScaleView() {
                if (eh.this.f5494i == null) {
                    return;
                }
                eh.this.f5494i.post(new Runnable() { // from class: com.amap.api.col.3l.eh.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        eh.this.f5494i.b();
                    }
                });
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public final void invalidateZoomController(final float f10) {
                if (eh.this.f5497l == null) {
                    return;
                }
                eh.this.f5497l.post(new Runnable() { // from class: com.amap.api.col.3l.eh.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        eh.this.f5497l.a(f10);
                    }
                });
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public final void setFrontViewVisibility(boolean z10) {
            }
        });
        try {
            if (this.f5488c.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.f5492g.setVisibility(8);
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void b(Boolean bool) {
        em emVar = this.f5497l;
        if (emVar == null) {
            this.f5486a.a(this, bool);
        } else {
            emVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void c(Boolean bool) {
        if (this.f5492g == null) {
            this.f5486a.a(this, bool);
        } else if (bool.booleanValue()) {
            this.f5492g.setVisibility(0);
        } else {
            this.f5492g.setVisibility(8);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void d(Boolean bool) {
        ee eeVar = this.f5493h;
        if (eeVar == null) {
            this.f5486a.a(this, bool);
        } else {
            eeVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void e(Boolean bool) {
        ek ekVar = this.f5494i;
        if (ekVar == null) {
            this.f5486a.a(this, bool);
        } else {
            ekVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void f(Boolean bool) {
        el elVar = this.f5491f;
        if (elVar == null) {
            this.f5486a.a(this, bool);
        } else {
            elVar.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void h(Boolean bool) {
        eg egVar = this.f5492g;
        if (egVar == null) {
            this.f5486a.a(this, bool);
        } else {
            egVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void i() {
        Context context;
        if (!this.f5504s || (context = this.f5490e) == null) {
            return;
        }
        a(context);
        ej ejVar = this.f5486a;
        if (ejVar != null) {
            ejVar.a();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void b(Integer num) {
        el elVar = this.f5491f;
        if (elVar == null) {
            this.f5486a.a(this, num);
        } else if (elVar != null) {
            elVar.a(num.intValue());
            this.f5491f.postInvalidate();
            k();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void d(Integer num) {
        el elVar = this.f5491f;
        if (elVar == null) {
            this.f5486a.a(this, num);
        } else if (elVar != null) {
            elVar.c(num.intValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final ef e() {
        return this.f5496k;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final el f() {
        return this.f5491f;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void c(Integer num) {
        el elVar = this.f5491f;
        if (elVar == null) {
            this.f5486a.a(this, num);
        } else if (elVar != null) {
            elVar.b(num.intValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void g() {
        hideInfoWindow();
        dx.a(this.f5500o);
        l();
        removeAllViews();
        this.f5502q = null;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final ed d() {
        return this.f5495j;
    }

    @Override // com.amap.api.col.p0003l.ei
    public final boolean b() {
        el elVar = this.f5491f;
        if (elVar != null) {
            return elVar.d();
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            av avVar = this.f5487b;
            if (!(avVar != null && avVar.a() && baseOverlayImp.getTitle() == null && baseOverlayImp.getSnippet() == null) && baseOverlayImp.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay = this.f5499n;
                if (basePointOverlay != null && !basePointOverlay.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.f5487b != null) {
                    baseOverlayImp.setInfoWindowShown(true);
                    this.f5503r = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void c() {
        el elVar = this.f5491f;
        if (elVar == null) {
            this.f5486a.a(this, new Object[0]);
        } else if (elVar != null) {
            elVar.c();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Boolean bool) {
        ef efVar = this.f5496k;
        if (efVar == null) {
            this.f5486a.a(this, bool);
        } else if (efVar != null && bool.booleanValue() && this.f5488c.canShowIndoorSwitch()) {
            this.f5496k.a(true);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(String str, Boolean bool, Integer num) {
        if (this.f5491f == null) {
            this.f5486a.a(this, str, bool, num);
            return;
        }
        if (num.intValue() == 2) {
            this.f5491f.b(bool.booleanValue());
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f5491f.a(str, num.intValue());
            this.f5491f.d(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Float f10) {
        em emVar = this.f5497l;
        if (emVar == null) {
            this.f5486a.a(this, f10);
        } else if (emVar != null) {
            emVar.a(f10.floatValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Integer num) {
        em emVar = this.f5497l;
        if (emVar == null) {
            this.f5486a.a(this, num);
        } else if (emVar != null) {
            emVar.a(num.intValue());
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final float a(int i10) {
        if (this.f5491f == null) {
            return 0.0f;
        }
        k();
        return this.f5491f.d(i10);
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Integer num, Float f10) {
        el elVar = this.f5491f;
        if (elVar == null) {
            this.f5486a.a(this, num, f10);
        } else if (elVar != null) {
            elVar.a(num.intValue(), f10.floatValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final Point a() {
        el elVar = this.f5491f;
        if (elVar == null) {
            return null;
        }
        return elVar.b();
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(CameraPosition cameraPosition) {
        if (this.f5491f == null) {
            this.f5486a.a(this, cameraPosition);
            return;
        }
        if (this.f5488c.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                LatLng latLng = cameraPosition.target;
                if (!dq.a(latLng.latitude, latLng.longitude)) {
                    this.f5491f.setVisibility(8);
                    return;
                }
            }
            if (this.f5488c.getMaskLayerType() == -1) {
                this.f5491f.setVisibility(0);
            }
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(boolean z10) {
        el elVar = this.f5491f;
        if (elVar != null) {
            elVar.c(z10);
        }
        this.f5505t = z10;
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof ef) {
            a(view, iArr[0], iArr[1], 20, (this.f5488c.getWaterMarkerPositon().y - 80) - iArr[1], 51);
        } else {
            a(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    private void a(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, aVar.width, aVar.height, iArr);
        if (view instanceof em) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), aVar.f5516e);
            return;
        }
        if (view instanceof eg) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], aVar.f5516e);
            return;
        }
        if (view instanceof ee) {
            a(view, iArr[0], iArr[1], 0, 0, aVar.f5516e);
            return;
        }
        if (aVar.f5512a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.f5488c.getMapConfig();
            GLMapState mapProjection = this.f5488c.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                FPoint fPoint = aVar.f5512a;
                ((Point) obtain).x = (int) ((PointF) fPoint).x;
                ((Point) obtain).y = (int) ((PointF) fPoint).y;
            }
            int i10 = ((Point) obtain).x + aVar.f5514c;
            ((Point) obtain).x = i10;
            int i11 = ((Point) obtain).y + aVar.f5515d;
            ((Point) obtain).y = i11;
            a(view, iArr[0], iArr[1], i10, i11, aVar.f5516e);
            obtain.recycle();
        }
    }

    private View a(BasePointOverlay basePointOverlay) throws RemoteException {
        View view;
        View view2;
        View view3 = null;
        if (basePointOverlay instanceof Marker) {
            try {
                if (this.f5500o == null) {
                    this.f5500o = dm.a(this.f5490e, "infowindow_bg.9.png");
                }
            } catch (Throwable th) {
                gy.b(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            try {
                if (this.f5503r) {
                    view = this.f5487b.a(basePointOverlay);
                    if (view == null) {
                        try {
                            view = this.f5487b.b(basePointOverlay);
                        } catch (Throwable th2) {
                            th = th2;
                            view3 = view;
                            gy.b(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f5502q = view;
                    this.f5503r = false;
                } else {
                    view = this.f5502q;
                }
                if (view != null) {
                    view3 = view;
                } else {
                    if (!this.f5487b.a()) {
                        return null;
                    }
                    view3 = this.f5487b.a(basePointOverlay);
                }
                if (view3 != null && view3.getBackground() == null) {
                    view3.setBackground(this.f5500o);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            try {
                if (this.f5500o == null) {
                    this.f5500o = dm.a(this.f5490e, "infowindow_bg.9.png");
                }
            } catch (Throwable th4) {
                gy.b(th4, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th4.printStackTrace();
            }
            try {
                if (this.f5503r) {
                    view2 = this.f5487b.a(basePointOverlay);
                    if (view2 == null) {
                        try {
                            view2 = this.f5487b.b(basePointOverlay);
                        } catch (Throwable th5) {
                            th = th5;
                            view3 = view2;
                            gy.b(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f5502q = view2;
                    this.f5503r = false;
                } else {
                    view2 = this.f5502q;
                }
                if (view2 != null) {
                    view3 = view2;
                } else {
                    if (!this.f5487b.a()) {
                        return null;
                    }
                    view3 = this.f5487b.a(basePointOverlay);
                }
                if (view3.getBackground() == null) {
                    view3.setBackground(this.f5500o);
                }
                return view3;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return view3;
    }

    private void a(View view, int i10, int i11, int i12, int i13) throws RemoteException {
        int i14;
        int i15;
        if (view == null) {
            return;
        }
        View view2 = this.f5498m;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.f5498m);
        }
        this.f5498m = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.f5498m.setDrawingCacheEnabled(true);
        this.f5498m.setDrawingCacheQuality(0);
        if (layoutParams != null) {
            int i16 = layoutParams.width;
            i15 = layoutParams.height;
            i14 = i16;
        } else {
            i14 = -2;
            i15 = -2;
        }
        addView(this.f5498m, new a(i14, i15, i10, i11, i12, i13, 81));
    }

    private void a(View view, int i10, int i11, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i10 <= 0 || i11 <= 0) {
            view.measure(0, 0);
        }
        if (i10 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i10 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i10;
        }
        if (i11 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i11 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i11;
        }
    }

    private void a(View view, int i10, int i11, int i12, int i13, int i14) {
        int i15;
        int i16 = i14 & 7;
        int i17 = i14 & 112;
        if (i16 == 5) {
            i12 -= i10;
        } else if (i16 == 1) {
            i12 -= i10 / 2;
        }
        if (i17 == 80) {
            i13 -= i11;
        } else {
            if (i17 == 17) {
                i15 = i11 / 2;
            } else if (i17 == 16) {
                i13 /= 2;
                i15 = i11 / 2;
            }
            i13 -= i15;
        }
        view.layout(i12, i13, i12 + i10, i13 + i11);
        if (view instanceof IGLSurfaceView) {
            this.f5488c.changeSize(i10, i11);
        }
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.f5498m;
        if (view == null || this.f5499n == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.f5498m.getLeft(), this.f5498m.getTop(), new Paint());
    }

    @Override // com.amap.api.col.p0003l.ei
    public final void a(ef.a aVar) {
        ef efVar = this.f5496k;
        if (efVar == null) {
            this.f5486a.a(this, aVar);
        } else {
            efVar.a(aVar);
        }
    }
}
