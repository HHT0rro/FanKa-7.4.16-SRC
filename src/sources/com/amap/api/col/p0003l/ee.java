package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: CompassView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ee extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f5441a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f5442b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f5443c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f5444d;

    /* renamed from: e, reason: collision with root package name */
    public IAMapDelegate f5445e;

    /* renamed from: f, reason: collision with root package name */
    public Matrix f5446f;

    public ee(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f5446f = new Matrix();
        this.f5445e = iAMapDelegate;
        try {
            Bitmap a10 = dx.a(context, "maps_dav_compass_needle_large.png");
            this.f5443c = a10;
            this.f5442b = dx.a(a10, w.f6962a * 0.8f);
            Bitmap a11 = dx.a(this.f5443c, w.f6962a * 0.7f);
            this.f5443c = a11;
            Bitmap bitmap = this.f5442b;
            if (bitmap != null && a11 != null) {
                this.f5441a = Bitmap.createBitmap(bitmap.getWidth(), this.f5442b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f5441a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.f5443c, (this.f5442b.getWidth() - this.f5443c.getWidth()) / 2.0f, (this.f5442b.getHeight() - this.f5443c.getHeight()) / 2.0f, paint);
                ImageView imageView = new ImageView(context);
                this.f5444d = imageView;
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                this.f5444d.setImageBitmap(this.f5441a);
                this.f5444d.setClickable(true);
                b();
                this.f5444d.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.3l.ee.1
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        try {
                        } catch (Throwable th) {
                            gy.b(th, "CompassView", "onTouch");
                            th.printStackTrace();
                        }
                        if (!ee.this.f5445e.isMaploaded()) {
                            return false;
                        }
                        if (motionEvent.getAction() == 0) {
                            ee eeVar = ee.this;
                            eeVar.f5444d.setImageBitmap(eeVar.f5442b);
                        } else if (motionEvent.getAction() == 1) {
                            ee eeVar2 = ee.this;
                            eeVar2.f5444d.setImageBitmap(eeVar2.f5441a);
                            CameraPosition cameraPosition = ee.this.f5445e.getCameraPosition();
                            ee.this.f5445e.animateCamera(al.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                        }
                        return false;
                    }
                });
                addView(this.f5444d);
            }
        } catch (Throwable th) {
            gy.b(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f5441a;
            if (bitmap != null) {
                dx.a(bitmap);
            }
            Bitmap bitmap2 = this.f5442b;
            if (bitmap2 != null) {
                dx.a(bitmap2);
            }
            Bitmap bitmap3 = this.f5443c;
            if (bitmap3 != null) {
                dx.a(bitmap3);
            }
            Matrix matrix = this.f5446f;
            if (matrix != null) {
                matrix.reset();
                this.f5446f = null;
            }
            this.f5443c = null;
            this.f5441a = null;
            this.f5442b = null;
        } catch (Throwable th) {
            gy.b(th, "CompassView", LandingPageUtHelper.XAD_UT_LP_DESTROY);
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            IAMapDelegate iAMapDelegate = this.f5445e;
            if (iAMapDelegate == null || this.f5444d == null) {
                return;
            }
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float cameraDegree = this.f5445e.getCameraDegree(engineIDWithType);
            float mapAngle = this.f5445e.getMapAngle(engineIDWithType);
            if (this.f5446f == null) {
                this.f5446f = new Matrix();
            }
            this.f5446f.reset();
            this.f5446f.postRotate(-mapAngle, this.f5444d.getDrawable().getBounds().width() / 2.0f, this.f5444d.getDrawable().getBounds().height() / 2.0f);
            this.f5446f.postScale(1.0f, (float) Math.cos((cameraDegree * 3.141592653589793d) / 180.0d), this.f5444d.getDrawable().getBounds().width() / 2.0f, this.f5444d.getDrawable().getBounds().height() / 2.0f);
            this.f5444d.setImageMatrix(this.f5446f);
        } catch (Throwable th) {
            gy.b(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }

    public final void a(boolean z10) {
        if (z10) {
            setVisibility(0);
            b();
        } else {
            setVisibility(8);
        }
    }
}
