package com.tencent.liteav.videoconsumer.consumer;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.d;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends com.tencent.liteav.videoconsumer.renderer.r implements d.a {

    /* renamed from: b, reason: collision with root package name */
    public final int f43673b;

    /* renamed from: c, reason: collision with root package name */
    public Object f43674c;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.liteav.videobase.videobase.d f43679h;

    /* renamed from: i, reason: collision with root package name */
    private VideoRenderListener f43680i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.j f43681j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.e f43682k;

    /* renamed from: a, reason: collision with root package name */
    public final String f43672a = "CustomRenderProcess_" + hashCode();

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f43675d = new com.tencent.liteav.base.b.b();

    /* renamed from: e, reason: collision with root package name */
    private EGLCore f43676e = null;

    /* renamed from: f, reason: collision with root package name */
    private GLConstants.PixelFormatType f43677f = GLConstants.PixelFormatType.RGBA;

    /* renamed from: g, reason: collision with root package name */
    private GLConstants.PixelBufferType f43678g = GLConstants.PixelBufferType.TEXTURE_2D;

    /* renamed from: l, reason: collision with root package name */
    private int f43683l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f43684m = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f43685n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f43686o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f43687p = false;

    /* renamed from: q, reason: collision with root package name */
    private Rotation f43688q = Rotation.NORMAL;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.tencent.liteav.videoconsumer.consumer.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class EnumC0642a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f43689a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f43690b = 2;

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ int[] f43691c = {1, 2};
    }

    public a(int i10) {
        this.f43673b = i10;
    }

    private boolean e() {
        EGLCore eGLCore = this.f43676e;
        if (eGLCore != null) {
            try {
                eGLCore.makeCurrent();
                return true;
            } catch (com.tencent.liteav.videobase.egl.f e2) {
                LiteavLog.e(this.f43675d.a("makeCurrentError"), this.f43672a, "customRenderFrame makeCurrent error ".concat(String.valueOf(e2)), new Object[0]);
            }
        }
        return false;
    }

    public final void a() {
        LiteavLog.i(this.f43672a, "Uninit Opengl Components");
        d();
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(List<PointF> list, List<PointF> list2) {
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void b(boolean z10) {
        if (this.f43686o != z10) {
            LiteavLog.i(this.f43672a, "setHorizontalMirror ".concat(String.valueOf(z10)));
        }
        this.f43686o = z10;
    }

    public final void c() {
        if (this.f43676e != null) {
            return;
        }
        try {
            LiteavLog.i(this.f43675d.a("initGL"), this.f43672a, "egl init sharedContext = " + this.f43674c, new Object[0]);
            EGLCore eGLCore = new EGLCore();
            this.f43676e = eGLCore;
            eGLCore.initialize(this.f43674c, null, 128, 128);
            this.f43676e.makeCurrent();
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f43675d.a("initError"), this.f43672a, "egl initialize failed.", e2);
            this.f43676e = null;
        }
    }

    public final void d() {
        EGLCore eGLCore = this.f43676e;
        if (eGLCore == null) {
            return;
        }
        try {
            eGLCore.makeCurrent();
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f43675d.a("make"), this.f43672a, "uninitializedEGL makeCurrent error ".concat(String.valueOf(e2)), new Object[0]);
        }
        LiteavLog.i(this.f43675d.a("uninitGL"), this.f43672a, "egl uninitializedEGL", new Object[0]);
        com.tencent.liteav.videobase.frame.j jVar = this.f43681j;
        if (jVar != null) {
            jVar.a();
            this.f43681j = null;
        }
        com.tencent.liteav.videobase.frame.e eVar = this.f43682k;
        if (eVar != null) {
            eVar.a();
            this.f43682k.b();
            this.f43682k = null;
        }
        com.tencent.liteav.videobase.videobase.d dVar = this.f43679h;
        if (dVar != null) {
            dVar.a(0, this);
            this.f43679h.a();
            this.f43679h = null;
        }
        EGLCore.destroy(this.f43676e);
        this.f43676e = null;
    }

    public final void finalize() throws Throwable {
        super.finalize();
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(VideoRenderListener videoRenderListener) {
        LiteavLog.i(this.f43672a, "Start");
        this.f43680i = videoRenderListener;
    }

    public final Object b() {
        int i10 = EnumC0642a.f43689a;
        EGLCore eGLCore = this.f43676e;
        if (eGLCore != null) {
            return eGLCore.getEglContext();
        }
        return null;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(boolean z10) {
        LiteavLog.i(this.f43672a, "Stop");
        this.f43680i = null;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(GLConstants.GLScaleType gLScaleType) {
        LiteavLog.i(this.f43672a, "setScaleType " + ((Object) gLScaleType) + " not support");
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(Rotation rotation) {
        if (this.f43688q != rotation) {
            LiteavLog.i(this.f43672a, "setRenderRotation ".concat(String.valueOf(rotation)));
        }
        this.f43688q = rotation;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(DisplayTarget displayTarget, boolean z10) {
        LiteavLog.i(this.f43672a, "setDisplayView not support");
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(PixelFrame pixelFrame) {
        if (this.f43680i == null) {
            return;
        }
        if (pixelFrame == null) {
            LiteavLog.w(this.f43675d.a("renderFrame"), this.f43672a, "renderFrame: pixelFrame is null.", new Object[0]);
            return;
        }
        PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
        FrameMetaData metaData = pixelFrame2.getMetaData();
        if (metaData != null) {
            this.f43688q = metaData.getRenderRotation();
            this.f43686o = metaData.isRenderMirrorHorizontal();
            this.f43687p = metaData.isRenderMirrorVertical();
        }
        pixelFrame2.setRotation(Rotation.a((pixelFrame2.getRotation().mValue + this.f43688q.mValue) % 360));
        if (this.f43686o) {
            pixelFrame2.setMirrorHorizontal(!pixelFrame2.isMirrorHorizontal());
        }
        if (this.f43687p) {
            pixelFrame2.setMirrorVertical(!pixelFrame2.isMirrorVertical());
        }
        Rotation rotation = this.f43688q;
        if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
            int width = pixelFrame2.getWidth();
            pixelFrame2.setWidth(pixelFrame2.getHeight());
            pixelFrame2.setHeight(width);
        }
        int i10 = this.f43673b;
        int i11 = EnumC0642a.f43689a;
        if (i10 == i11 && (this.f43676e == null || !CommonUtil.equals(b(), pixelFrame2.getGLContext()))) {
            LiteavLog.i(this.f43675d.a("contextCompare"), this.f43672a, "EGLCore context is not equal frame context or eglcore is null", new Object[0]);
            return;
        }
        if (this.f43673b != i11 && (this.f43676e == null || this.f43674c != pixelFrame2.getGLContext())) {
            LiteavLog.i(this.f43675d.a("recreateEGLCore"), this.f43672a, "recreate EGLCore.", new Object[0]);
            this.f43674c = pixelFrame2.getGLContext();
            d();
            c();
        }
        if (!e()) {
            a(pixelFrame2, VideoRenderListener.a.RENDER_FAILED);
            return;
        }
        if (this.f43684m != pixelFrame2.getHeight() || this.f43683l != pixelFrame2.getWidth()) {
            this.f43683l = pixelFrame2.getWidth();
            this.f43684m = pixelFrame2.getHeight();
            this.f43685n = true;
        }
        if (this.f43681j == null) {
            this.f43681j = new com.tencent.liteav.videobase.frame.j(this.f43683l, this.f43684m);
        }
        this.f43681j.a(this.f43683l, this.f43684m);
        if (this.f43682k == null) {
            this.f43682k = new com.tencent.liteav.videobase.frame.e();
        }
        com.tencent.liteav.videobase.frame.d a10 = this.f43682k.a(this.f43683l, this.f43684m);
        PixelFrame pixelFrame3 = new PixelFrame(pixelFrame2);
        if (a10 == null) {
            pixelFrame3.setMirrorVertical(!pixelFrame3.isMirrorVertical());
            if (pixelFrame3.getRotation() != Rotation.NORMAL) {
                Rotation rotation2 = pixelFrame3.getRotation();
                Rotation rotation3 = Rotation.ROTATION_180;
                if (rotation2 != rotation3) {
                    pixelFrame3.setRotation(Rotation.a((pixelFrame3.getRotation().mValue + rotation3.mValue) % 360));
                }
            }
        }
        com.tencent.liteav.videobase.frame.j jVar = this.f43681j;
        if (jVar != null) {
            jVar.a(pixelFrame3, GLConstants.GLScaleType.CENTER_CROP, a10);
        }
        a10.a(pixelFrame2.getConsumerChainTimestamp());
        long timestamp = pixelFrame2.getTimestamp();
        if (this.f43682k == null) {
            this.f43682k = new com.tencent.liteav.videobase.frame.e();
        }
        if (this.f43679h == null) {
            com.tencent.liteav.videobase.videobase.d dVar = new com.tencent.liteav.videobase.videobase.d();
            this.f43679h = dVar;
            dVar.a(this.f43682k);
            this.f43685n = true;
        }
        if (this.f43685n) {
            this.f43685n = false;
            this.f43679h.a(0, this);
            this.f43679h.a(new com.tencent.liteav.videobase.videobase.a(this.f43683l, this.f43684m), this.f43678g, this.f43677f, 0, this);
        }
        this.f43679h.a(timestamp, a10);
        a10.release();
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.r
    public final void a(TakeSnapshotListener takeSnapshotListener) {
        if (takeSnapshotListener != null) {
            takeSnapshotListener.onComplete(null);
        }
    }

    public final void a(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType) {
        if (pixelFormatType == this.f43677f && pixelBufferType == this.f43678g) {
            return;
        }
        this.f43685n = true;
        this.f43677f = pixelFormatType;
        this.f43678g = pixelBufferType;
        LiteavLog.i(this.f43672a, "set custom render type pixelFormatType = " + ((Object) this.f43677f) + " pixelBufferType = " + ((Object) this.f43678g));
    }

    private void a(PixelFrame pixelFrame, VideoRenderListener.a aVar) {
        VideoRenderListener videoRenderListener = this.f43680i;
        if (videoRenderListener != null) {
            videoRenderListener.onRenderFrame(pixelFrame, aVar);
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.d.a
    public final void a(int i10, @NonNull PixelFrame pixelFrame) {
        boolean z10 = OpenGlUtils.getGLErrorCount() > 0;
        PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
        pixelFrame2.setRotation(Rotation.NORMAL);
        if (z10) {
            a(pixelFrame2, VideoRenderListener.a.RENDER_FAILED);
            LiteavLog.e(this.f43675d.a("renderFailed"), this.f43672a, "render frame failed.", new Object[0]);
        } else {
            a(pixelFrame2, VideoRenderListener.a.RENDER_WITHOUT_VIEW);
        }
    }
}
