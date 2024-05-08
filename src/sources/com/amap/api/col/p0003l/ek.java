package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManagerPolicyConstants;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.huawei.hms.framework.common.ExceptionCode;

/* compiled from: ScaleView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ek extends View {

    /* renamed from: a, reason: collision with root package name */
    private String f5523a;

    /* renamed from: b, reason: collision with root package name */
    private int f5524b;

    /* renamed from: c, reason: collision with root package name */
    private IAMapDelegate f5525c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f5526d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f5527e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f5528f;

    /* renamed from: g, reason: collision with root package name */
    private IPoint f5529g;

    /* renamed from: h, reason: collision with root package name */
    private float f5530h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f5531i;

    public ek(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f5523a = "";
        this.f5524b = 0;
        this.f5530h = 0.0f;
        this.f5531i = new int[]{ExceptionCode.CRASH_EXCEPTION, 5000000, WindowManagerPolicyConstants.WINDOW_FREEZE_LAYER, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.f5525c = iAMapDelegate;
        this.f5526d = new Paint();
        this.f5528f = new Rect();
        this.f5526d.setAntiAlias(true);
        this.f5526d.setColor(-16777216);
        this.f5526d.setStrokeWidth(w.f6962a * 2.0f);
        this.f5526d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.f5527e = paint;
        paint.setAntiAlias(true);
        this.f5527e.setColor(-16777216);
        this.f5527e.setTextSize(w.f6962a * 20.0f);
        this.f5530h = dr.a(context, 1.0f);
        this.f5529g = new IPoint();
    }

    public final void a() {
        this.f5526d = null;
        this.f5527e = null;
        this.f5528f = null;
        this.f5523a = null;
        this.f5529g = null;
    }

    public final void b() {
        IAMapDelegate iAMapDelegate = this.f5525c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.f5525c.getPreciseLevel(engineIDWithType);
            this.f5525c.getGeoCenter(engineIDWithType, this.f5529g);
            if (this.f5529g == null) {
                return;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) r0).x, ((Point) r0).y, 20);
            float mapZoomScale = this.f5525c.getMapZoomScale();
            double cos = (float) ((((Math.cos((pixelsToLatLong.f9304y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d));
            int i10 = (int) (r5[r1] / (cos * mapZoomScale));
            String a10 = dx.a(this.f5531i[(int) preciseLevel]);
            a(i10);
            a(a10);
            pixelsToLatLong.recycle();
            invalidate();
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Point waterMarkerPositon;
        String str = this.f5523a;
        if (str == null || "".equals(str) || this.f5524b == 0 || (waterMarkerPositon = this.f5525c.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.f5527e;
        String str2 = this.f5523a;
        paint.getTextBounds(str2, 0, str2.length(), this.f5528f);
        int i10 = waterMarkerPositon.x;
        int height = (waterMarkerPositon.y - this.f5528f.height()) + 5;
        canvas.drawText(this.f5523a, ((this.f5524b - this.f5528f.width()) / 2) + i10, height, this.f5527e);
        float f10 = i10;
        float height2 = height + (this.f5528f.height() - 5);
        canvas.drawLine(f10, height2 - (this.f5530h * 2.0f), f10, height2 + w.f6962a, this.f5526d);
        canvas.drawLine(f10, height2, this.f5524b + i10, height2, this.f5526d);
        int i11 = this.f5524b;
        canvas.drawLine(i10 + i11, height2 - (this.f5530h * 2.0f), i10 + i11, height2 + w.f6962a, this.f5526d);
    }

    private void a(String str) {
        this.f5523a = str;
    }

    private void a(int i10) {
        this.f5524b = i10;
    }

    public final void a(boolean z10) {
        if (z10) {
            setVisibility(0);
            b();
        } else {
            a("");
            a(0);
            setVisibility(8);
        }
    }
}
