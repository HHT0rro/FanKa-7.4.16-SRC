package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* compiled from: InfoWindowDelegate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class av {

    /* renamed from: c, reason: collision with root package name */
    public Context f5015c;

    /* renamed from: e, reason: collision with root package name */
    private View f5017e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f5018f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f5019g;

    /* renamed from: i, reason: collision with root package name */
    private IInfoWindowAction f5021i;

    /* renamed from: j, reason: collision with root package name */
    private IInfoWindowAction f5022j;

    /* renamed from: k, reason: collision with root package name */
    private BaseOverlay f5023k;

    /* renamed from: a, reason: collision with root package name */
    public AMap.InfoWindowAdapter f5013a = null;

    /* renamed from: b, reason: collision with root package name */
    public AMap.CommonInfoWindowAdapter f5014b = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5016d = true;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f5020h = null;

    /* renamed from: l, reason: collision with root package name */
    private AMap.InfoWindowAdapter f5024l = new AMap.InfoWindowAdapter() { // from class: com.amap.api.col.3l.av.1
        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            try {
                if (av.this.f5020h == null) {
                    av avVar = av.this;
                    avVar.f5020h = dm.a(avVar.f5015c, "infowindow_bg.9.png");
                }
                if (av.this.f5017e == null) {
                    av.this.f5017e = new LinearLayout(av.this.f5015c);
                    av.this.f5017e.setBackground(av.this.f5020h);
                    av.this.f5018f = new TextView(av.this.f5015c);
                    av.this.f5018f.setText(marker.getTitle());
                    av.this.f5018f.setTextColor(-16777216);
                    av.this.f5019g = new TextView(av.this.f5015c);
                    av.this.f5019g.setTextColor(-16777216);
                    av.this.f5019g.setText(marker.getSnippet());
                    ((LinearLayout) av.this.f5017e).setOrientation(1);
                    ((LinearLayout) av.this.f5017e).addView(av.this.f5018f);
                    ((LinearLayout) av.this.f5017e).addView(av.this.f5019g);
                }
            } catch (Throwable th) {
                gy.b(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return av.this.f5017e;
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private AMap.CommonInfoWindowAdapter f5025m = new AMap.CommonInfoWindowAdapter() { // from class: com.amap.api.col.3l.av.2

        /* renamed from: b, reason: collision with root package name */
        private InfoWindowParams f5028b = null;

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public final InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.f5028b == null) {
                    this.f5028b = new InfoWindowParams();
                    if (av.this.f5020h == null) {
                        av avVar = av.this;
                        avVar.f5020h = dm.a(avVar.f5015c, "infowindow_bg.9.png");
                    }
                    av.this.f5017e = new LinearLayout(av.this.f5015c);
                    av.this.f5017e.setBackground(av.this.f5020h);
                    av.this.f5018f = new TextView(av.this.f5015c);
                    av.this.f5018f.setText("标题");
                    av.this.f5018f.setTextColor(-16777216);
                    av.this.f5019g = new TextView(av.this.f5015c);
                    av.this.f5019g.setTextColor(-16777216);
                    av.this.f5019g.setText("内容");
                    ((LinearLayout) av.this.f5017e).setOrientation(1);
                    ((LinearLayout) av.this.f5017e).addView(av.this.f5018f);
                    ((LinearLayout) av.this.f5017e).addView(av.this.f5019g);
                    this.f5028b.setInfoWindowType(2);
                    this.f5028b.setInfoWindow(av.this.f5017e);
                }
                return this.f5028b;
            } catch (Throwable th) {
                gy.b(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    };

    public av(Context context) {
        this.f5015c = context;
    }

    private synchronized IInfoWindowAction d() {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5013a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter) {
                return this.f5022j;
            }
            if (infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.f5022j;
            }
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5014b;
        if (commonInfoWindowAdapter != null && commonInfoWindowAdapter.getInfoWindowParams(null).getInfoWindowType() == 1) {
            return this.f5022j;
        }
        return this.f5021i;
    }

    public final long c(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5013a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5014b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0L;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public final void b(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f5022j = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final void a(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f5021i = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    private static boolean b(AMap.InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            return true;
        }
        Marker marker = new Marker(null, new MarkerOptions(), "check");
        return infoWindowAdapter.getInfoWindow(marker) == null && infoWindowAdapter.getInfoContents(marker) == null;
    }

    public final void c() {
        IInfoWindowAction d10 = d();
        if (d10 != null) {
            d10.hideInfoWindow();
        }
    }

    public final synchronized boolean a() {
        return this.f5016d;
    }

    public final View b(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5013a;
        if (infoWindowAdapter != null) {
            View infoContents = infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
            a(infoContents, basePointOverlay);
            return infoContents;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5014b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoContents2 = infoWindowParams.getInfoContents();
            a(infoContents2, basePointOverlay);
            return infoContents2;
        }
        InfoWindowParams infoWindowParams2 = this.f5025m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public final void a(String str, String str2) {
        TextView textView = this.f5018f;
        if (textView != null) {
            textView.requestLayout();
            this.f5018f.setText(str);
        }
        TextView textView2 = this.f5019g;
        if (textView2 != null) {
            textView2.requestLayout();
            this.f5019g.setText(str2);
        }
        View view = this.f5017e;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final synchronized void a(AMap.InfoWindowAdapter infoWindowAdapter) {
        this.f5013a = infoWindowAdapter;
        this.f5014b = null;
        if (b(infoWindowAdapter)) {
            this.f5013a = this.f5024l;
            this.f5016d = true;
        } else {
            this.f5016d = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f5022j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f5021i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final void b() {
        IInfoWindowAction d10 = d();
        if (d10 != null) {
            d10.redrawInfoWindow();
        }
    }

    public final synchronized void a(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.f5014b = commonInfoWindowAdapter;
        this.f5013a = null;
        if (commonInfoWindowAdapter == null) {
            this.f5014b = this.f5025m;
            this.f5016d = true;
        } else {
            this.f5016d = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f5022j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f5021i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    private static void a(View view, BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !dl.c()) {
            return;
        }
        String b4 = dx.b(view);
        if (TextUtils.isEmpty(b4)) {
            return;
        }
        dl.a().a(basePointOverlay.getPosition(), b4, "");
    }

    public final View a(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5013a;
        if (infoWindowAdapter != null) {
            View infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
            a(infoWindow, basePointOverlay);
            return infoWindow;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5014b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoWindow2 = infoWindowParams.getInfoWindow();
            a(infoWindow2, basePointOverlay);
            return infoWindow2;
        }
        InfoWindowParams infoWindowParams2 = this.f5025m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public final BaseOverlay a(MotionEvent motionEvent) {
        IInfoWindowAction d10 = d();
        if (d10 == null || !d10.onInfoWindowTap(motionEvent)) {
            return null;
        }
        return this.f5023k;
    }

    public final void a(BaseOverlayImp baseOverlayImp) throws RemoteException {
        IInfoWindowAction d10 = d();
        if (d10 != null) {
            d10.showInfoWindow(baseOverlayImp);
        }
    }

    public final void a(BaseOverlay baseOverlay) throws RemoteException {
        IInfoWindowAction d10 = d();
        if (d10 == null || !(baseOverlay instanceof BasePointOverlay)) {
            return;
        }
        d10.showInfoWindow((BasePointOverlay) baseOverlay);
        this.f5023k = baseOverlay;
    }
}
