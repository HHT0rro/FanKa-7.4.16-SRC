package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

/* compiled from: AMapGLTextureView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class o extends y implements IGLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6891a;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f6892b;

    /* renamed from: c, reason: collision with root package name */
    private GLMapRender f6893c;

    public o(Context context, boolean z10) {
        super(context);
        this.f6892b = null;
        this.f6893c = null;
        this.f6891a = false;
        dj.a(this);
        this.f6892b = new l(this, context, z10);
    }

    @Override // com.amap.api.col.p0003l.y
    public final void b() {
        dz.a(dy.f5397c, "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.f6893c.mSurfacedestoryed);
        if (!this.f6893c.mSurfacedestoryed) {
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.o.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (o.this.f6893c != null) {
                            o.this.f6893c.onSurfaceDestory();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        dx.a(th);
                    }
                }
            });
            int i10 = 0;
            while (!this.f6893c.mSurfacedestoryed) {
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
        super.b();
    }

    @Override // com.amap.api.col.p0003l.y
    public final void c() {
        super.c();
        dz.a(dy.f5397c, "AMapGLTextureView onResume");
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.y, android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        dz.a(dy.f5397c, "AMapGLTextureView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f6893c;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        c();
    }

    @Override // com.amap.api.col.p0003l.y, android.view.View
    public final void onDetachedFromWindow() {
        dz.a(dy.f5397c, "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            return;
        }
        b();
        try {
            GLMapRender gLMapRender = this.f6893c;
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
        dz.a(dy.f5397c, "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            b();
            try {
                GLMapRender gLMapRender = this.f6893c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.amap.api.col.p0003l.y, android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        dz.a(dy.f5397c, "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f6892b.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i10);
        dz.a(dy.f5397c, "AMapGLTextureView onWindowVisibilityChanged visibility ".concat(String.valueOf(i10)));
        try {
            if (i10 != 8 && i10 != 4) {
                if (i10 != 0 || (gLMapRender = this.f6893c) == null) {
                    return;
                }
                gLMapRender.renderResume();
                return;
            }
            GLMapRender gLMapRender2 = this.f6893c;
            if (gLMapRender2 != null) {
                gLMapRender2.renderPause();
                this.f6891a = false;
            }
            requestRender();
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(dh dhVar) {
        super.a(dhVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(di diVar) {
        super.a(diVar);
    }

    @Override // com.amap.api.col.p0003l.y, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f6893c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z10) {
    }

    public final IAMapDelegate a() {
        return this.f6892b;
    }
}
