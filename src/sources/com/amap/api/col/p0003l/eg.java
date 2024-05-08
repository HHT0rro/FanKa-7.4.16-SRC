package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: LocationView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eg extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f5476a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f5477b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f5478c;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap f5479d;

    /* renamed from: e, reason: collision with root package name */
    public Bitmap f5480e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f5481f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f5482g;

    /* renamed from: h, reason: collision with root package name */
    public IAMapDelegate f5483h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5484i;

    public eg(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f5484i = false;
        this.f5483h = iAMapDelegate;
        try {
            Bitmap a10 = dx.a(context, "location_selected.png");
            this.f5479d = a10;
            this.f5476a = dx.a(a10, w.f6962a);
            Bitmap a11 = dx.a(context, "location_pressed.png");
            this.f5480e = a11;
            this.f5477b = dx.a(a11, w.f6962a);
            Bitmap a12 = dx.a(context, "location_unselected.png");
            this.f5481f = a12;
            this.f5478c = dx.a(a12, w.f6962a);
            ImageView imageView = new ImageView(context);
            this.f5482g = imageView;
            imageView.setImageBitmap(this.f5476a);
            this.f5482g.setClickable(true);
            this.f5482g.setPadding(0, 20, 20, 0);
            this.f5482g.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.3l.eg.1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!eg.this.f5484i) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        eg egVar = eg.this;
                        egVar.f5482g.setImageBitmap(egVar.f5477b);
                    } else if (motionEvent.getAction() == 1) {
                        try {
                            eg egVar2 = eg.this;
                            egVar2.f5482g.setImageBitmap(egVar2.f5476a);
                            eg.this.f5483h.setMyLocationEnabled(true);
                            Location myLocation = eg.this.f5483h.getMyLocation();
                            if (myLocation == null) {
                                return false;
                            }
                            LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                            eg.this.f5483h.showMyLocationOverlay(myLocation);
                            IAMapDelegate iAMapDelegate2 = eg.this.f5483h;
                            iAMapDelegate2.moveCamera(al.a(latLng, iAMapDelegate2.getZoomLevel()));
                        } catch (Throwable th) {
                            gy.b(th, "LocationView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                    return false;
                }
            });
            addView(this.f5482g);
        } catch (Throwable th) {
            gy.b(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f5476a;
            if (bitmap != null) {
                dx.a(bitmap);
            }
            Bitmap bitmap2 = this.f5477b;
            if (bitmap2 != null) {
                dx.a(bitmap2);
            }
            if (this.f5477b != null) {
                dx.a(this.f5478c);
            }
            this.f5476a = null;
            this.f5477b = null;
            this.f5478c = null;
            Bitmap bitmap3 = this.f5479d;
            if (bitmap3 != null) {
                dx.a(bitmap3);
                this.f5479d = null;
            }
            Bitmap bitmap4 = this.f5480e;
            if (bitmap4 != null) {
                dx.a(bitmap4);
                this.f5480e = null;
            }
            Bitmap bitmap5 = this.f5481f;
            if (bitmap5 != null) {
                dx.a(bitmap5);
                this.f5481f = null;
            }
        } catch (Throwable th) {
            gy.b(th, "LocationView", LandingPageUtHelper.XAD_UT_LP_DESTROY);
            th.printStackTrace();
        }
    }

    public final void a(boolean z10) {
        this.f5484i = z10;
        try {
            if (z10) {
                this.f5482g.setImageBitmap(this.f5476a);
            } else {
                this.f5482g.setImageBitmap(this.f5478c);
            }
            this.f5482g.invalidate();
        } catch (Throwable th) {
            gy.b(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }
}
