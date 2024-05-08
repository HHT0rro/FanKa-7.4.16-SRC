package com.amap.api.col.p0003l;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* compiled from: AMapGLSurfaceView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class n extends GLSurfaceView implements IGLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6887a;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f6888b;

    /* renamed from: c, reason: collision with root package name */
    private GLMapRender f6889c;

    public n(Context context, boolean z10) {
        this(context, z10, (byte) 0);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        dz.a(dy.f5397c, "AMapGLSurfaceView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f6889c;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
        onResume();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        dz.a(dy.f5397c, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            GLMapRender gLMapRender = this.f6889c;
            if (gLMapRender != null) {
                gLMapRender.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
        dz.a(dy.f5397c, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                GLMapRender gLMapRender = this.f6889c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                dx.a(th);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        dz.a(dy.f5397c, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.f6889c.mSurfacedestoryed);
        if (!this.f6889c.mSurfacedestoryed) {
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (n.this.f6889c != null) {
                        try {
                            n.this.f6889c.onSurfaceDestory();
                        } catch (Throwable th) {
                            th.printStackTrace();
                            dx.a(th);
                        }
                    }
                }
            });
            int i10 = 0;
            while (!this.f6889c.mSurfacedestoryed) {
                int i11 = i10 + 1;
                if (i10 >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
                i10 = i11;
            }
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        dz.a(dy.f5397c, "AMapGLSurfaceView onPause");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f6888b.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        dz.a(dy.f5397c, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(String.valueOf(i10)));
        try {
            if (i10 == 8 || i10 == 4) {
                GLMapRender gLMapRender = this.f6889c;
                if (gLMapRender != null) {
                    gLMapRender.renderPause();
                    this.f6887a = false;
                }
            } else {
                if (i10 != 0) {
                    return;
                }
                GLMapRender gLMapRender2 = this.f6889c;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderResume();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(dh dhVar) {
        super.setEGLConfigChooser((GLSurfaceView.EGLConfigChooser) dhVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(di diVar) {
        super.setEGLContextFactory((GLSurfaceView.EGLContextFactory) diVar);
    }

    @Override // android.opengl.GLSurfaceView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f6889c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    private n(Context context, boolean z10, byte b4) {
        super(context, null);
        this.f6888b = null;
        this.f6889c = null;
        this.f6887a = false;
        dj.a(this);
        this.f6888b = new l(this, context, z10);
    }

    public final IAMapDelegate a() {
        return this.f6888b;
    }
}
