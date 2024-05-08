package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends RenderViewHelperInterface {

    /* renamed from: a, reason: collision with root package name */
    private final String f44080a;

    /* renamed from: b, reason: collision with root package name */
    private final CustomHandler f44081b;

    /* renamed from: c, reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f44082c;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceView f44083d;

    /* renamed from: e, reason: collision with root package name */
    private final Size f44084e;

    /* renamed from: f, reason: collision with root package name */
    private final Size f44085f;

    /* renamed from: g, reason: collision with root package name */
    private GLConstants.GLScaleType f44086g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f44087h;

    /* renamed from: i, reason: collision with root package name */
    private final SurfaceHolder.Callback f44088i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnLayoutChangeListener f44089j;

    public f(SurfaceView surfaceView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "SurfaceViewRenderHelper_" + hashCode();
        this.f44080a = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f44081b = customHandler;
        this.f44084e = new Size();
        this.f44085f = new Size();
        this.f44086g = null;
        this.f44087h = false;
        this.f44088i = new SurfaceHolder.Callback() { // from class: com.tencent.liteav.videoconsumer.renderer.f.1
            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
                if (surfaceHolder != null) {
                    LiteavLog.i(f.this.f44080a, "surfaceChanged,format=%d,Size(%dx%d)", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
                    f.this.a(surfaceHolder.getSurface());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (surfaceHolder != null) {
                    Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                    LiteavLog.i(f.this.f44080a, "surfaceCreated,Size(%dx%d)", Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
                    f.this.a(surfaceHolder.getSurface());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                LiteavLog.i(f.this.f44080a, "surfaceDestroyed");
                f.this.a();
            }
        };
        this.f44089j = new View.OnLayoutChangeListener() { // from class: com.tencent.liteav.videoconsumer.renderer.f.2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (f.this.f44087h) {
                    if (f.this.f44085f.width == view.getWidth() && f.this.f44085f.height == view.getHeight()) {
                        return;
                    }
                    f.this.b();
                }
            }
        };
        this.f44082c = renderViewListener;
        if (surfaceView == null) {
            LiteavLog.w(str, "surfaceView is null.");
        } else {
            this.f44083d = surfaceView;
            customHandler.post(g.a(this, surfaceView));
        }
    }

    public static /* synthetic */ void b(f fVar) {
        SurfaceView surfaceView = fVar.f44083d;
        if (surfaceView == null) {
            LiteavLog.i(fVar.f44080a, "view is not available when surfaceView is null");
            return;
        }
        Surface surface = surfaceView.getHolder().getSurface();
        boolean z10 = surface != null && surface.isValid();
        if (z10 && fVar.f44083d.getWidth() != 0 && fVar.f44083d.getHeight() != 0 && fVar.f44083d.isShown()) {
            return;
        }
        String str = fVar.f44080a;
        SurfaceView surfaceView2 = fVar.f44083d;
        LiteavLog.i(str, "%s is not available when isShown:%b, surface isValid:%b", surfaceView2, Boolean.valueOf(surfaceView2.isShown()), Boolean.valueOf(z10));
    }

    public static /* synthetic */ void c(f fVar) {
        LiteavLog.i(fVar.f44080a, "release,mSurfaceView=" + ((Object) fVar.f44083d));
        if (fVar.f44083d == null) {
            return;
        }
        fVar.a();
        fVar.f44083d.getHolder().removeCallback(fVar.f44088i);
        fVar.f44083d = null;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void checkViewAvailability() {
        this.f44081b.post(i.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final Matrix getTransformMatrix(int i10, int i11) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, i10 / 2.0f, i11 / 2.0f);
        return matrix;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isUsingTextureView() {
        return false;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void release(boolean z10) {
        this.f44081b.post(h.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i10, int i11, boolean z10) {
        if (this.f44086g == gLScaleType && this.f44087h == z10) {
            Size size = this.f44084e;
            if (size.width == i10 && size.height == i11) {
                return;
            }
        }
        this.f44087h = z10;
        this.f44086g = gLScaleType;
        this.f44084e.set(i10, i11);
        if (this.f44087h) {
            this.f44081b.runOrPost(j.a(this));
        }
    }

    public static /* synthetic */ void a(f fVar, SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        if (holder.getSurface().isValid()) {
            Surface surface = holder.getSurface();
            Rect surfaceFrame = holder.getSurfaceFrame();
            LiteavLog.i(fVar.f44080a, "construct,surface=%s,Size(%dx%d)", surface, Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
            fVar.a(surface);
        } else {
            LiteavLog.i(fVar.f44080a, "construct,surfaceView not valid.");
        }
        holder.addCallback(fVar.f44088i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r0 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        r2 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        if (r0 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r9 = this;
            android.view.SurfaceView r0 = r9.f44083d
            if (r0 == 0) goto Lb8
            android.view.ViewParent r0 = r0.getParent()
            boolean r0 = r0 instanceof com.tencent.rtmp.ui.TXCloudVideoView
            if (r0 != 0) goto Le
            goto Lb8
        Le:
            android.view.SurfaceView r0 = r9.f44083d
            android.view.ViewParent r0 = r0.getParent()
            com.tencent.rtmp.ui.TXCloudVideoView r0 = (com.tencent.rtmp.ui.TXCloudVideoView) r0
            com.tencent.liteav.base.util.Size r1 = new com.tencent.liteav.base.util.Size
            int r2 = r0.getWidth()
            int r3 = r0.getHeight()
            r1.<init>(r2, r3)
            com.tencent.liteav.base.util.Size r2 = r9.f44084e
            boolean r2 = r2.isValid()
            if (r2 == 0) goto Lb8
            boolean r2 = r1.isValid()
            if (r2 != 0) goto L33
            goto Lb8
        L33:
            com.tencent.liteav.base.util.Size r2 = r9.f44085f
            boolean r2 = r2.isValid()
            if (r2 != 0) goto L40
            android.view.View$OnLayoutChangeListener r2 = r9.f44089j
            r0.addOnLayoutChangeListener(r2)
        L40:
            com.tencent.liteav.base.util.Size r0 = r9.f44085f
            r0.set(r1)
            double r2 = r1.aspectRatio()
            com.tencent.liteav.base.util.Size r0 = r9.f44084e
            double r4 = r0.aspectRatio()
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L64
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r0 = r9.f44086g
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.FIT_CENTER
            if (r0 != r8) goto L5f
        L5b:
            double r4 = r4 / r2
            r2 = r6
            r6 = r4
            goto L72
        L5f:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP
            if (r0 != r8) goto L71
            goto L6a
        L64:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r0 = r9.f44086g
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.FIT_CENTER
            if (r0 != r8) goto L6c
        L6a:
            double r2 = r2 / r4
            goto L72
        L6c:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP
            if (r0 != r8) goto L71
            goto L5b
        L71:
            r2 = r6
        L72:
            android.view.SurfaceView r0 = r9.f44083d
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            int r4 = r1.getWidth()
            double r4 = (double) r4
            double r4 = r4 * r6
            int r4 = (int) r4
            r0.width = r4
            int r1 = r1.getHeight()
            double r4 = (double) r1
            double r4 = r4 * r2
            int r1 = (int) r4
            r0.height = r1
            boolean r1 = r0 instanceof android.widget.FrameLayout.LayoutParams
            if (r1 == 0) goto L97
            r1 = r0
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r2 = 17
            r1.gravity = r2
        L97:
            android.view.SurfaceView r1 = r9.f44083d
            r1.setLayoutParams(r0)
            java.lang.String r1 = r9.f44080a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            int r4 = r0.width
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            r3 = 1
            int r0 = r0.height
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2[r3] = r0
            java.lang.String r0 = "adjust view size to %d*%d"
            com.tencent.liteav.base.util.LiteavLog.i(r1, r0, r2)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.renderer.f.b():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface) {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f44082c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f44082c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }
}
