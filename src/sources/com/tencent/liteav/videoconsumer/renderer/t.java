package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.BitmapUtils;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t extends r implements RenderViewHelperInterface.RenderViewListener {
    private final Size A;
    private TakeSnapshotListener B;
    private VideoRenderListener C;
    private boolean D;
    private Bitmap E;
    private final com.tencent.liteav.base.b.a F;

    @Nullable
    private a G;
    private List<PointF> H;
    private List<PointF> I;

    /* renamed from: a, reason: collision with root package name */
    private final String f44127a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final Handler f44128b;

    /* renamed from: c, reason: collision with root package name */
    private final CustomHandler f44129c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final IVideoReporter f44130d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.liteav.base.util.l f44131e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final com.tencent.liteav.base.util.l f44132f;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f44133g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final Size f44134h;

    /* renamed from: i, reason: collision with root package name */
    private Surface f44135i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f44136j;

    /* renamed from: k, reason: collision with root package name */
    private Object f44137k;

    /* renamed from: l, reason: collision with root package name */
    private EGLCore f44138l;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.liteav.videobase.frame.c f44139m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.j f44140n;

    /* renamed from: o, reason: collision with root package name */
    private final com.tencent.liteav.videobase.utils.m f44141o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.e f44142p;

    /* renamed from: q, reason: collision with root package name */
    private GLConstants.GLScaleType f44143q;

    /* renamed from: r, reason: collision with root package name */
    private Rotation f44144r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f44145s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f44146t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    private DisplayTarget f44147u;

    /* renamed from: v, reason: collision with root package name */
    private RenderViewHelperInterface f44148v;

    /* renamed from: w, reason: collision with root package name */
    private final Size f44149w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f44150x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f44151y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f44152z;

    public t(@NonNull Looper looper, @NonNull IVideoReporter iVideoReporter) {
        this.f44127a = "VideoRenderer_" + hashCode();
        this.f44128b = new Handler(Looper.getMainLooper());
        this.f44132f = new com.tencent.liteav.base.util.l(5);
        this.f44133g = new com.tencent.liteav.base.b.b();
        this.f44134h = new Size();
        this.f44135i = null;
        this.f44136j = false;
        this.f44138l = null;
        this.f44139m = new com.tencent.liteav.videobase.frame.c();
        this.f44141o = new com.tencent.liteav.videobase.utils.m();
        this.f44143q = GLConstants.GLScaleType.CENTER_CROP;
        this.f44144r = Rotation.NORMAL;
        this.f44145s = false;
        this.f44146t = false;
        this.f44149w = new Size();
        this.f44150x = false;
        this.f44151y = false;
        this.f44152z = false;
        this.A = new Size();
        this.D = false;
        this.F = new com.tencent.liteav.base.b.a(5000L);
        this.f44129c = new CustomHandler(looper);
        this.f44131e = null;
        this.f44130d = iVideoReporter;
    }

    public static /* synthetic */ void c(t tVar, boolean z10) {
        Surface surface;
        LiteavLog.i(tVar.f44127a, "Stop,clearLastImage=".concat(String.valueOf(z10)));
        if (!tVar.f44150x) {
            LiteavLog.w(tVar.f44127a, "renderer is not started!");
            return;
        }
        tVar.f44150x = false;
        tVar.B = null;
        tVar.c(z10);
        DisplayTarget displayTarget = tVar.f44147u;
        if (displayTarget != null && z10) {
            displayTarget.hideAll();
        }
        tVar.f44141o.b();
        tVar.a();
        if (tVar.f44136j && (surface = tVar.f44135i) != null) {
            surface.release();
            tVar.f44136j = false;
        }
        tVar.f44135i = null;
        tVar.f44134h.set(0, 0);
        tVar.f44149w.set(0, 0);
        tVar.f44151y = false;
    }

    private void d() {
        a aVar = this.G;
        if (aVar == null) {
            return;
        }
        aVar.a();
        this.G = null;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(VideoRenderListener videoRenderListener) {
        a(u.a(this, videoRenderListener));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void b(boolean z10) {
        a(ai.a(this, z10));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public final void onRequestRedraw(@NonNull Bitmap bitmap) {
        a(bitmap);
        a(z.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public final void onSurfaceChanged(Surface surface, boolean z10) {
        a(y.a(this, surface, z10));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public final void onSurfaceDestroy() {
        Runnable a10 = aa.a(this);
        com.tencent.liteav.base.util.l lVar = this.f44131e;
        if (lVar != null) {
            lVar.a(a10, 2000L);
        } else if (Looper.myLooper() == this.f44129c.getLooper()) {
            a10.run();
        } else {
            this.f44129c.runAndWaitDone(a10, 2000L);
        }
    }

    public static /* synthetic */ void a(t tVar, VideoRenderListener videoRenderListener) {
        LiteavLog.i(tVar.f44127a, "Start");
        if (tVar.f44150x) {
            LiteavLog.w(tVar.f44127a, "renderer is started!");
            return;
        }
        tVar.f44150x = true;
        tVar.C = videoRenderListener;
        Surface surface = tVar.f44135i;
        if (surface != null && videoRenderListener != null) {
            videoRenderListener.onRenderSurfaceChanged(surface);
        }
        DisplayTarget displayTarget = tVar.f44147u;
        if (displayTarget != null) {
            tVar.b(displayTarget, true);
        }
        tVar.F.f42750a = SystemClock.elapsedRealtime();
    }

    public static /* synthetic */ void b(t tVar, boolean z10) {
        if (tVar.f44145s != z10) {
            LiteavLog.i(tVar.f44127a, "setHorizontalMirror ".concat(String.valueOf(z10)));
        }
        tVar.f44145s = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DisplayTarget displayTarget, boolean z10) {
        LiteavLog.i(this.f44127a, "setDisplayViewInternal=" + ((Object) displayTarget) + ",clearLastImage=" + z10);
        boolean equals = CommonUtil.equals(this.f44147u, displayTarget);
        if (equals && displayTarget != null && this.f44148v != null) {
            LiteavLog.w(this.f44127a, "view is equal and RenderViewHelper is created.");
            return;
        }
        if (!equals) {
            this.D = true;
            DisplayTarget displayTarget2 = this.f44147u;
            if (displayTarget2 != null && z10) {
                displayTarget2.hideAll();
            }
        }
        c(z10);
        this.f44147u = displayTarget;
        if (displayTarget == null) {
            return;
        }
        displayTarget.showAll();
        this.f44148v = RenderViewHelperInterface.create(displayTarget, this);
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(boolean z10) {
        a(ac.a(this, z10));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(DisplayTarget displayTarget, boolean z10) {
        a(ad.a(this, displayTarget, z10));
    }

    private void b() {
        EGLCore eGLCore = this.f44138l;
        if (eGLCore == null) {
            return;
        }
        Size surfaceSize = eGLCore.getSurfaceSize();
        if (this.f44134h.equals(surfaceSize)) {
            return;
        }
        LiteavLog.i(this.f44133g.a("updateSurfaceSize"), this.f44127a, "surface size changed,old size=" + ((Object) this.f44134h) + ",new size=" + ((Object) surfaceSize), new Object[0]);
        this.f44134h.set(surfaceSize);
        if (this.f44135i != null) {
            IVideoReporter iVideoReporter = this.f44130d;
            com.tencent.liteav.videobase.videobase.i iVar = com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_RESOLUTION;
            Size size = this.f44134h;
            iVideoReporter.updateStatus(iVar, Integer.valueOf(size.height | (size.width << 16)));
        }
        VideoRenderListener videoRenderListener = this.C;
        if (videoRenderListener != null) {
            Size size2 = this.f44134h;
            videoRenderListener.onRenderTargetSizeChanged(size2.width, size2.height);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(TakeSnapshotListener takeSnapshotListener) {
        a(ae.a(this, takeSnapshotListener));
    }

    public static /* synthetic */ void a(t tVar, TakeSnapshotListener takeSnapshotListener) {
        LiteavLog.i(tVar.f44127a, "takeSnapshot ");
        tVar.B = takeSnapshotListener;
    }

    public static /* synthetic */ void c(t tVar) {
        RenderViewHelperInterface renderViewHelperInterface;
        PixelFrame a10 = tVar.f44141o.a();
        if (a10 == null) {
            LiteavLog.d(tVar.f44127a, "renderFrameInternal pixelFrame is null!");
            return;
        }
        tVar.f44149w.set(a10.getWidth(), a10.getHeight());
        FrameMetaData metaData = a10.getMetaData();
        if (metaData != null) {
            tVar.f44144r = metaData.getRenderRotation();
            tVar.f44145s = metaData.isRenderMirrorHorizontal();
            tVar.f44146t = metaData.isRenderMirrorVertical();
            tVar.f44149w.set(metaData.getCaptureRealSize());
        }
        if (tVar.F.a() && (renderViewHelperInterface = tVar.f44148v) != null) {
            renderViewHelperInterface.checkViewAvailability();
        }
        if (tVar.f44152z) {
            RenderViewHelperInterface renderViewHelperInterface2 = tVar.f44148v;
            if (renderViewHelperInterface2 != null) {
                renderViewHelperInterface2.updateVideoFrameInfo(tVar.f44143q, a10.getWidth(), a10.getHeight(), tVar.f44152z);
            }
            tVar.a(a10, VideoRenderListener.a.RENDER_WITH_HDR);
        } else if (tVar.f44148v == null) {
            tVar.a(a10, VideoRenderListener.a.RENDER_WITHOUT_VIEW);
        } else if (!tVar.b(a10)) {
            tVar.a(a10, VideoRenderListener.a.RENDER_FAILED);
            LiteavLog.e(tVar.f44133g.a("makeCurrent"), tVar.f44127a, "make current failed.", new Object[0]);
        } else {
            tVar.b();
            PixelFrame pixelFrame = new PixelFrame(a10);
            boolean z10 = tVar.f44145s;
            boolean z11 = tVar.f44146t;
            Rotation rotation = tVar.f44144r;
            pixelFrame.setRotation(Rotation.a((pixelFrame.getRotation().mValue + rotation.mValue) % 360));
            if (z10) {
                pixelFrame.setMirrorHorizontal(!pixelFrame.isMirrorHorizontal());
            }
            if (z11) {
                pixelFrame.setMirrorVertical(!pixelFrame.isMirrorVertical());
            }
            if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
                int width = pixelFrame.getWidth();
                pixelFrame.setWidth(pixelFrame.getHeight());
                pixelFrame.setHeight(width);
            }
            pixelFrame.setMirrorVertical(!pixelFrame.isMirrorVertical());
            if (pixelFrame.getRotation() != Rotation.NORMAL) {
                Rotation rotation2 = pixelFrame.getRotation();
                Rotation rotation3 = Rotation.ROTATION_180;
                if (rotation2 != rotation3) {
                    pixelFrame.setRotation(Rotation.a((pixelFrame.getRotation().mValue + rotation3.mValue) % 360));
                }
            }
            tVar.A.width = pixelFrame.getWidth();
            tVar.A.height = pixelFrame.getHeight();
            tVar.a(pixelFrame, tVar.f44143q);
            if (tVar.B != null) {
                OpenGlUtils.bindFramebuffer(36160, 0);
                Size size = tVar.f44134h;
                int i10 = size.width;
                int i11 = size.height;
                TakeSnapshotListener takeSnapshotListener = tVar.B;
                if (takeSnapshotListener != null) {
                    tVar.B = null;
                    ByteBuffer b4 = com.tencent.liteav.videobase.utils.j.b(i10 * i11 * 4);
                    if (b4 == null) {
                        LiteavLog.e(tVar.f44127a, "snapshotVideoFrameFromFrameBuffer, allocate direct buffer failed.");
                        takeSnapshotListener.onComplete(null);
                    } else {
                        b4.order(ByteOrder.nativeOrder());
                        b4.position(0);
                        GLES20.glReadPixels(0, 0, i10, i11, 6408, 5121, b4);
                        tVar.f44128b.post(x.a(tVar, tVar.f44148v, b4, i10, i11, takeSnapshotListener));
                    }
                }
            }
            if (tVar.c() && OpenGlUtils.getGLErrorCount() <= 0) {
                tVar.a(a10, VideoRenderListener.a.RENDER_ON_VIEW);
                if (tVar.D) {
                    tVar.f44130d.notifyEvent(h.b.EVT_VIDEO_RENDER_FIRST_FRAME_ON_VIEW, a10, (String) null);
                    tVar.D = false;
                }
            } else {
                tVar.a(a10, VideoRenderListener.a.RENDER_FAILED);
                LiteavLog.e(tVar.f44133g.a("renderFailed"), tVar.f44127a, "render frame failed.", new Object[0]);
            }
        }
        a10.release();
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(List<PointF> list, List<PointF> list2) {
        a(af.a(this, list, list2));
    }

    public static /* synthetic */ void a(t tVar, List list, List list2) {
        tVar.H = list;
        tVar.I = list2;
        if (!b((List<PointF>) list, (List<PointF>) list2)) {
            tVar.d();
            return;
        }
        a aVar = tVar.G;
        if (aVar != null) {
            aVar.a((List<PointF>) list, (List<PointF>) list2);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(GLConstants.GLScaleType gLScaleType) {
        a(ag.a(this, gLScaleType));
    }

    public t(@NonNull com.tencent.liteav.base.util.l lVar, @NonNull IVideoReporter iVideoReporter) {
        this.f44127a = "VideoRenderer_" + hashCode();
        this.f44128b = new Handler(Looper.getMainLooper());
        this.f44132f = new com.tencent.liteav.base.util.l(5);
        this.f44133g = new com.tencent.liteav.base.b.b();
        this.f44134h = new Size();
        this.f44135i = null;
        this.f44136j = false;
        this.f44138l = null;
        this.f44139m = new com.tencent.liteav.videobase.frame.c();
        this.f44141o = new com.tencent.liteav.videobase.utils.m();
        this.f44143q = GLConstants.GLScaleType.CENTER_CROP;
        this.f44144r = Rotation.NORMAL;
        this.f44145s = false;
        this.f44146t = false;
        this.f44149w = new Size();
        this.f44150x = false;
        this.f44151y = false;
        this.f44152z = false;
        this.A = new Size();
        this.D = false;
        this.F = new com.tencent.liteav.base.b.a(5000L);
        this.f44129c = null;
        this.f44131e = lVar;
        this.f44130d = iVideoReporter;
    }

    public static /* synthetic */ void a(t tVar, GLConstants.GLScaleType gLScaleType) {
        if (tVar.f44143q != gLScaleType) {
            LiteavLog.i(tVar.f44127a, "setScaleType ".concat(String.valueOf(gLScaleType)));
            tVar.f44143q = gLScaleType;
        }
    }

    private boolean b(@NonNull PixelFrame pixelFrame) {
        Object gLContext = pixelFrame.getGLContext();
        if (this.f44138l == null || !(gLContext == null || CommonUtil.equals(this.f44137k, gLContext))) {
            a();
            Object gLContext2 = pixelFrame.getGLContext();
            if (this.f44135i == null) {
                LiteavLog.e(this.f44133g.a("initGLNoSurface"), this.f44127a, "Initialize EGL failed because surface is null", new Object[0]);
            } else {
                try {
                    LiteavLog.i(this.f44133g.a("initGL"), this.f44127a, "initializeEGL surface=" + ((Object) this.f44135i) + ",size=" + ((Object) this.f44134h), new Object[0]);
                    EGLCore eGLCore = new EGLCore();
                    this.f44138l = eGLCore;
                    Surface surface = this.f44135i;
                    Size size = this.f44134h;
                    eGLCore.initialize(gLContext2, surface, size.width, size.height);
                    this.f44137k = gLContext2;
                    this.f44138l.makeCurrent();
                    if (this.f44142p == null) {
                        this.f44142p = new com.tencent.liteav.videobase.frame.e();
                    }
                    this.f44139m.a();
                } catch (com.tencent.liteav.videobase.egl.f e2) {
                    LiteavLog.e(this.f44133g.a("initGLError"), this.f44127a, "initializeEGL failed.", e2);
                    this.f44138l = null;
                    this.f44130d.notifyWarning(h.c.WARNING_VIDEO_RENDER_EGL_CORE_CREATE_FAILED, "VideoRender: create EGLCore fail:".concat(String.valueOf(e2)));
                }
            }
        }
        EGLCore eGLCore2 = this.f44138l;
        if (eGLCore2 == null) {
            return false;
        }
        try {
            eGLCore2.makeCurrent();
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e10) {
            LiteavLog.e(this.f44133g.a("makeCurrentForFrameError"), this.f44127a, "EGLCore makeCurrent failed.".concat(String.valueOf(e10)), new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(Rotation rotation) {
        a(ah.a(this, rotation));
    }

    public static /* synthetic */ void a(t tVar, Rotation rotation) {
        if (tVar.f44144r != rotation) {
            LiteavLog.i(tVar.f44127a, "setRenderRotation ".concat(String.valueOf(rotation)));
            tVar.f44144r = rotation;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(PixelFrame pixelFrame) {
        if (this.f44150x) {
            if (pixelFrame == null) {
                LiteavLog.w(this.f44127a, "renderFrame pixelFrame is null!");
                return;
            }
            if (!this.f44151y) {
                this.f44151y = true;
                LiteavLog.d(this.f44127a, "VideoRender receive first frame!");
            }
            this.f44141o.a(pixelFrame);
            a(v.a(this));
        }
    }

    public final void a(Runnable runnable) {
        com.tencent.liteav.base.util.l lVar = this.f44131e;
        if (lVar != null) {
            lVar.a(runnable);
        } else if (Looper.myLooper() == this.f44129c.getLooper()) {
            runnable.run();
        } else {
            this.f44129c.post(runnable);
        }
    }

    private void a() {
        if (this.f44138l == null) {
            return;
        }
        com.tencent.liteav.base.b.a a10 = this.f44133g.a("uninitGL");
        String str = this.f44127a;
        Object[] objArr = new Object[2];
        Surface surface = this.f44135i;
        objArr[0] = Integer.valueOf(surface != null ? surface.hashCode() : 0);
        objArr[1] = this.f44134h;
        LiteavLog.i(a10, str, "uninitializeEGL %d %s", objArr);
        try {
            this.f44138l.makeCurrent();
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f44133g.a("makeCurrentError"), this.f44127a, "uninitializeEGL EGLCore makeCurrent failed.".concat(String.valueOf(e2)), new Object[0]);
        }
        d();
        com.tencent.liteav.videobase.frame.j jVar = this.f44140n;
        if (jVar != null) {
            jVar.a();
            this.f44140n = null;
        }
        this.f44139m.d();
        com.tencent.liteav.videobase.frame.e eVar = this.f44142p;
        if (eVar != null) {
            eVar.a();
            this.f44142p.b();
            this.f44142p = null;
        }
        EGLCore.destroy(this.f44138l);
        this.f44138l = null;
    }

    public static /* synthetic */ void b(t tVar) {
        PixelFrame createFromBitmap;
        Bitmap a10 = tVar.a((Bitmap) null);
        if (a10 == null || (createFromBitmap = PixelFrame.createFromBitmap(a10)) == null || !tVar.b(createFromBitmap)) {
            return;
        }
        tVar.b();
        createFromBitmap.setMirrorVertical(true);
        tVar.a(createFromBitmap, tVar.f44143q);
        tVar.c();
    }

    private static boolean b(List<PointF> list, List<PointF> list2) {
        return list != null && list.size() == 4 && list2 != null && list2.size() == 4;
    }

    private void a(PixelFrame pixelFrame, VideoRenderListener.a aVar) {
        VideoRenderListener videoRenderListener = this.C;
        if (videoRenderListener != null) {
            videoRenderListener.onRenderFrame(pixelFrame, aVar);
        }
    }

    private void a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        RenderViewHelperInterface renderViewHelperInterface = this.f44148v;
        if (renderViewHelperInterface != null) {
            renderViewHelperInterface.updateVideoFrameInfo(this.f44143q, this.A.getWidth(), this.A.getHeight(), this.f44152z);
        }
        if (this.f44134h.isValid()) {
            if (this.f44148v instanceof k) {
                gLScaleType = GLConstants.GLScaleType.FILL;
            }
            if (b(this.H, this.I)) {
                if (this.G == null) {
                    com.tencent.liteav.videobase.frame.e eVar = this.f44142p;
                    Size size = this.f44134h;
                    a aVar = new a(eVar, size.width, size.height);
                    this.G = aVar;
                    aVar.a(this.H, this.I);
                }
                RenderViewHelperInterface renderViewHelperInterface2 = this.f44148v;
                if (renderViewHelperInterface2 != null) {
                    a aVar2 = this.G;
                    Size size2 = this.f44134h;
                    Matrix transformMatrix = renderViewHelperInterface2.getTransformMatrix(size2.width, size2.height);
                    if (!com.tencent.liteav.base.util.i.a(aVar2.f44045h, transformMatrix)) {
                        aVar2.f44045h = transformMatrix;
                        aVar2.f44048k = true;
                    }
                }
                a aVar3 = this.G;
                Size size3 = this.f44134h;
                int i10 = size3.width;
                int i11 = size3.height;
                Size size4 = aVar3.f44039b;
                if (size4.width != i10 || size4.height != i11) {
                    size4.set(i10, i11);
                    aVar3.f44048k = true;
                }
                a aVar4 = this.G;
                if (aVar4.f44039b.isValid()) {
                    if (aVar4.f44044g == null) {
                        LiteavLog.i(aVar4.f44038a, "create PixelFrameRenderer, size =" + ((Object) aVar4.f44039b));
                        Size size5 = aVar4.f44039b;
                        aVar4.f44044g = new com.tencent.liteav.videobase.frame.j(size5.width, size5.height);
                    }
                    Size size6 = aVar4.f44039b;
                    OpenGlUtils.glViewport(0, 0, size6.width, size6.height);
                    com.tencent.liteav.videobase.frame.e eVar2 = aVar4.f44040c;
                    Size size7 = aVar4.f44039b;
                    com.tencent.liteav.videobase.frame.d a10 = eVar2.a(size7.width, size7.height);
                    com.tencent.liteav.videobase.frame.j jVar = aVar4.f44044g;
                    Size size8 = aVar4.f44039b;
                    jVar.a(size8.width, size8.height);
                    aVar4.f44044g.a(pixelFrame, gLScaleType, a10);
                    com.tencent.liteav.videobase.b.b bVar = aVar4.f44041d;
                    if (bVar == null && bVar == null) {
                        com.tencent.liteav.videobase.b.b bVar2 = new com.tencent.liteav.videobase.b.b();
                        aVar4.f44041d = bVar2;
                        bVar2.initialize(aVar4.f44040c);
                        if (aVar4.f44042e == null || aVar4.f44043f == null) {
                            aVar4.f44042e = OpenGlUtils.createNormalCubeVerticesBuffer();
                            aVar4.f44043f = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
                        }
                    }
                    if (aVar4.f44048k) {
                        aVar4.b(aVar4.f44046i, aVar4.f44047j);
                        aVar4.f44048k = false;
                    }
                    aVar4.f44041d.onDraw(a10.a(), null, aVar4.f44042e, aVar4.f44043f);
                    a10.release();
                    return;
                }
                return;
            }
            Size size9 = this.f44134h;
            OpenGlUtils.glViewport(0, 0, size9.width, size9.height);
            if (this.f44140n == null) {
                LiteavLog.i(this.f44127a, "create PixelFrameRenderer, surfaceSize=" + ((Object) this.f44134h));
                Size size10 = this.f44134h;
                this.f44140n = new com.tencent.liteav.videobase.frame.j(size10.width, size10.height);
            }
            com.tencent.liteav.videobase.frame.j jVar2 = this.f44140n;
            Size size11 = this.f44134h;
            jVar2.a(size11.width, size11.height);
            this.f44140n.a(pixelFrame, gLScaleType, (com.tencent.liteav.videobase.frame.d) null);
        }
    }

    private boolean c() {
        try {
            this.f44138l.swapBuffers();
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f44133g.a("swapBuffers"), this.f44127a, "EGLCore swapBuffers failed.".concat(String.valueOf(e2)), new Object[0]);
            this.f44130d.notifyWarning(h.c.WARNING_VIDEO_RENDER_SWAP_BUFFER, "VideoRender: swapBuffer error:".concat(String.valueOf(e2)));
            return false;
        }
    }

    private void c(boolean z10) {
        RenderViewHelperInterface renderViewHelperInterface = this.f44148v;
        if (renderViewHelperInterface != null) {
            renderViewHelperInterface.release(z10);
            this.f44148v = null;
        }
    }

    public static /* synthetic */ void a(t tVar, RenderViewHelperInterface renderViewHelperInterface, ByteBuffer byteBuffer, int i10, int i11, TakeSnapshotListener takeSnapshotListener) {
        TextureView textureView = renderViewHelperInterface instanceof k ? ((k) renderViewHelperInterface).f44097a : null;
        tVar.f44132f.a(ab.a(tVar, byteBuffer, i10, i11, textureView != null ? textureView.getTransform(new Matrix()) : null, takeSnapshotListener));
    }

    private void a(Surface surface, boolean z10) {
        VideoRenderListener videoRenderListener;
        Surface surface2;
        if (com.tencent.liteav.base.util.i.a(this.f44135i, surface)) {
            LiteavLog.d(this.f44127a, "updateSurface same surface!");
            return;
        }
        a();
        if (this.f44136j && (surface2 = this.f44135i) != null) {
            surface2.release();
        }
        if (this.f44135i != surface && (videoRenderListener = this.C) != null) {
            videoRenderListener.onRenderSurfaceChanged(surface);
        }
        this.f44135i = surface;
        if (surface == null) {
            this.f44134h.set(0, 0);
        }
        this.f44136j = z10;
    }

    public static /* synthetic */ void a(t tVar, Surface surface, boolean z10) {
        LiteavLog.i(tVar.f44127a, "onSurfaceChanged surface: %s, oldSurface: %s, isNeedRelease: %b", surface, tVar.f44135i, Boolean.valueOf(z10));
        tVar.a(surface, z10);
    }

    private Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2;
        synchronized (this) {
            bitmap2 = this.E;
            this.E = bitmap;
        }
        return bitmap2;
    }

    public static /* synthetic */ void a(t tVar) {
        LiteavLog.i(tVar.f44127a, "onSurfaceDestroy " + ((Object) tVar.f44135i));
        tVar.a((Surface) null, tVar.f44136j);
    }

    public static /* synthetic */ void a(t tVar, ByteBuffer byteBuffer, int i10, int i11, Matrix matrix, TakeSnapshotListener takeSnapshotListener) {
        try {
            byteBuffer.position(0);
            Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            if (matrix == null) {
                matrix = new Matrix();
            }
            matrix.postScale(1.0f, -1.0f, i10 / 2.0f, i11 / 2.0f);
            takeSnapshotListener.onComplete(BitmapUtils.createBitmap(createBitmap, matrix, true));
        } catch (Throwable th) {
            LiteavLog.e(tVar.f44127a, "build snapshot bitmap failed.", th);
            takeSnapshotListener.onComplete(null);
        }
    }
}
