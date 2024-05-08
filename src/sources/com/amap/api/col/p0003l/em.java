package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.p0003l.eh;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ZoomControllerView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class em extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f5558a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f5559b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f5560c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f5561d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f5562e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f5563f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f5564g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f5565h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f5566i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f5567j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f5568k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f5569l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f5570m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f5571n;

    /* renamed from: o, reason: collision with root package name */
    private IAMapDelegate f5572o;

    public em(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f5572o = iAMapDelegate;
        try {
            Bitmap a10 = dx.a(context, "zoomin_selected.png");
            this.f5564g = a10;
            this.f5558a = dx.a(a10, w.f6962a);
            Bitmap a11 = dx.a(context, "zoomin_unselected.png");
            this.f5565h = a11;
            this.f5559b = dx.a(a11, w.f6962a);
            Bitmap a12 = dx.a(context, "zoomout_selected.png");
            this.f5566i = a12;
            this.f5560c = dx.a(a12, w.f6962a);
            Bitmap a13 = dx.a(context, "zoomout_unselected.png");
            this.f5567j = a13;
            this.f5561d = dx.a(a13, w.f6962a);
            Bitmap a14 = dx.a(context, "zoomin_pressed.png");
            this.f5568k = a14;
            this.f5562e = dx.a(a14, w.f6962a);
            Bitmap a15 = dx.a(context, "zoomout_pressed.png");
            this.f5569l = a15;
            this.f5563f = dx.a(a15, w.f6962a);
            ImageView imageView = new ImageView(context);
            this.f5570m = imageView;
            imageView.setImageBitmap(this.f5558a);
            this.f5570m.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.f5571n = imageView2;
            imageView2.setImageBitmap(this.f5560c);
            this.f5571n.setClickable(true);
            this.f5570m.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.3l.em.1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (em.this.f5572o.getZoomLevel() < em.this.f5572o.getMaxZoomLevel() && em.this.f5572o.isMaploaded()) {
                        if (motionEvent.getAction() == 0) {
                            em.this.f5570m.setImageBitmap(em.this.f5562e);
                        } else if (motionEvent.getAction() == 1) {
                            em.this.f5570m.setImageBitmap(em.this.f5558a);
                            try {
                                em.this.f5572o.animateCamera(al.a());
                            } catch (RemoteException e2) {
                                gy.b(e2, "ZoomControllerView", "zoomin ontouch");
                                e2.printStackTrace();
                            }
                        }
                        return false;
                    }
                    return false;
                }
            });
            this.f5571n.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.3l.em.2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                    } catch (Throwable th) {
                        gy.b(th, "ZoomControllerView", "zoomout ontouch");
                        th.printStackTrace();
                    }
                    if (em.this.f5572o.getZoomLevel() > em.this.f5572o.getMinZoomLevel() && em.this.f5572o.isMaploaded()) {
                        if (motionEvent.getAction() == 0) {
                            em.this.f5571n.setImageBitmap(em.this.f5563f);
                        } else if (motionEvent.getAction() == 1) {
                            em.this.f5571n.setImageBitmap(em.this.f5560c);
                            em.this.f5572o.animateCamera(al.b());
                        }
                        return false;
                    }
                    return false;
                }
            });
            this.f5570m.setPadding(0, 0, 20, -2);
            this.f5571n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.f5570m);
            addView(this.f5571n);
        } catch (Throwable th) {
            gy.b(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            dx.a(this.f5558a);
            dx.a(this.f5559b);
            dx.a(this.f5560c);
            dx.a(this.f5561d);
            dx.a(this.f5562e);
            dx.a(this.f5563f);
            this.f5558a = null;
            this.f5559b = null;
            this.f5560c = null;
            this.f5561d = null;
            this.f5562e = null;
            this.f5563f = null;
            Bitmap bitmap = this.f5564g;
            if (bitmap != null) {
                dx.a(bitmap);
                this.f5564g = null;
            }
            Bitmap bitmap2 = this.f5565h;
            if (bitmap2 != null) {
                dx.a(bitmap2);
                this.f5565h = null;
            }
            Bitmap bitmap3 = this.f5566i;
            if (bitmap3 != null) {
                dx.a(bitmap3);
                this.f5566i = null;
            }
            Bitmap bitmap4 = this.f5567j;
            if (bitmap4 != null) {
                dx.a(bitmap4);
                this.f5564g = null;
            }
            Bitmap bitmap5 = this.f5568k;
            if (bitmap5 != null) {
                dx.a(bitmap5);
                this.f5568k = null;
            }
            Bitmap bitmap6 = this.f5569l;
            if (bitmap6 != null) {
                dx.a(bitmap6);
                this.f5569l = null;
            }
            this.f5570m = null;
            this.f5571n = null;
        } catch (Throwable th) {
            gy.b(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public final void a(float f10) {
        try {
            if (f10 < this.f5572o.getMaxZoomLevel() && f10 > this.f5572o.getMinZoomLevel()) {
                this.f5570m.setImageBitmap(this.f5558a);
                this.f5571n.setImageBitmap(this.f5560c);
            } else if (f10 == this.f5572o.getMinZoomLevel()) {
                this.f5571n.setImageBitmap(this.f5561d);
                this.f5570m.setImageBitmap(this.f5558a);
            } else if (f10 == this.f5572o.getMaxZoomLevel()) {
                this.f5570m.setImageBitmap(this.f5559b);
                this.f5571n.setImageBitmap(this.f5560c);
            }
        } catch (Throwable th) {
            gy.b(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void a(int i10) {
        try {
            eh.a aVar = (eh.a) getLayoutParams();
            if (i10 == 1) {
                aVar.f5516e = 16;
            } else if (i10 == 2) {
                aVar.f5516e = 80;
            }
            setLayoutParams(aVar);
        } catch (Throwable th) {
            gy.b(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public final void a(boolean z10) {
        if (z10) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
