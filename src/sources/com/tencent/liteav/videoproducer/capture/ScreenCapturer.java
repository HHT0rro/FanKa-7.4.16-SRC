package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.projection.MediaProjection;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.SystemUtil;
import com.tencent.liteav.base.util.w;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ScreenCapturer extends au implements SurfaceTexture.OnFrameAvailableListener, w.a, VirtualDisplayManager.VirtualDisplayListener {

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.l f44191f;

    /* renamed from: g, reason: collision with root package name */
    private final String f44192g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final Context f44193h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final IVideoReporter f44194i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private ScreenCaptureParams f44195j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private Size f44196k;

    /* renamed from: l, reason: collision with root package name */
    private Rotation f44197l;

    /* renamed from: m, reason: collision with root package name */
    private int f44198m;

    /* renamed from: n, reason: collision with root package name */
    private int f44199n;

    /* renamed from: o, reason: collision with root package name */
    private int f44200o;

    /* renamed from: p, reason: collision with root package name */
    private SurfaceTexture f44201p;

    /* renamed from: q, reason: collision with root package name */
    private Surface f44202q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.liteav.videobase.utils.g f44203r;

    /* renamed from: s, reason: collision with root package name */
    private com.tencent.liteav.base.util.w f44204s;

    /* renamed from: t, reason: collision with root package name */
    private MediaProjection f44205t;

    /* renamed from: u, reason: collision with root package name */
    private Rotation f44206u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f44207v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f44208w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f44209x;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ScreenCaptureParams extends CaptureSourceInterface.CaptureParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f44210a;

        /* renamed from: f, reason: collision with root package name */
        public MediaProjection f44211f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f44212g;

        public ScreenCaptureParams() {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof ScreenCaptureParams)) {
                return false;
            }
            ScreenCaptureParams screenCaptureParams = (ScreenCaptureParams) obj;
            return super.equals(obj) && this.f44210a == screenCaptureParams.f44210a && this.f44211f == screenCaptureParams.f44211f && this.f44212g == screenCaptureParams.f44212g;
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
        @NonNull
        public String toString() {
            return String.format(Locale.ENGLISH, "%s, autoRotate: %b, mediaProjcetion: %s", super.toString(), Boolean.valueOf(this.f44210a), this.f44211f);
        }

        public ScreenCaptureParams(ScreenCaptureParams screenCaptureParams) {
            super(screenCaptureParams);
            this.f44210a = screenCaptureParams.f44210a;
            this.f44211f = screenCaptureParams.f44211f;
            this.f44212g = screenCaptureParams.f44212g;
        }
    }

    public ScreenCapturer(@NonNull Context context, @NonNull Looper looper, @NonNull IVideoReporter iVideoReporter) {
        super(looper, iVideoReporter);
        this.f44192g = "ScreenCapturer_" + hashCode();
        Rotation rotation = Rotation.NORMAL;
        this.f44197l = rotation;
        this.f44200o = -1;
        this.f44206u = rotation;
        this.f44207v = false;
        this.f44208w = false;
        this.f44209x = false;
        this.f44193h = context.getApplicationContext();
        this.f44194i = iVideoReporter;
    }

    public static /* synthetic */ void c(ScreenCapturer screenCapturer) {
        LiteavLog.i(screenCapturer.f44192g, "Resume capture");
        if (screenCapturer.f44208w) {
            screenCapturer.f44194i.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME, (Object) null, "screen capture has been resumed");
        }
        screenCapturer.f44208w = false;
        com.tencent.liteav.videobase.utils.g gVar = screenCapturer.f44203r;
        if (gVar != null) {
            gVar.a();
        }
    }

    public static /* synthetic */ void d(ScreenCapturer screenCapturer) {
        LiteavLog.i(screenCapturer.f44192g, "Pause capture");
        if (!screenCapturer.f44208w) {
            screenCapturer.f44194i.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED, (Object) null, "screen capture has been interrupted");
        }
        screenCapturer.f44208w = true;
    }

    private void e() {
        if (this.f44191f == null) {
            this.f44191f = new com.tencent.liteav.videobase.frame.l();
        }
        if (this.f44196k == null) {
            i();
        }
        if (this.f44195j.f44210a) {
            this.f44206u = Rotation.a(SystemUtil.getDisplayRotationDegree());
            g();
            b(this.f44206u);
        } else {
            f();
        }
        this.f44200o = OpenGlUtils.generateTextureOES();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f44200o);
        this.f44201p = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f44201p.setDefaultBufferSize(this.f44198m, this.f44199n);
        this.f44202q = new Surface(this.f44201p);
        VirtualDisplayManager.a(this.f44193h).a(this.f44202q, this.f44198m, this.f44199n, this.f44205t, this.f44195j.f44212g, this);
        LiteavLog.i(this.f44192g, "Start virtual display, size: %dx%d", Integer.valueOf(this.f44198m), Integer.valueOf(this.f44199n));
    }

    private void f() {
        ScreenCaptureParams screenCaptureParams = this.f44195j;
        int i10 = screenCaptureParams.f44182c;
        int i11 = screenCaptureParams.f44183d;
        boolean z10 = i10 < i11;
        Size size = this.f44196k;
        int i12 = size.width;
        int i13 = size.height;
        boolean z11 = i12 < i13;
        if (i10 != i11 && z10 != z11) {
            this.f44198m = i13;
            this.f44199n = i12;
        } else {
            this.f44198m = i12;
            this.f44199n = i13;
        }
        String str = this.f44192g;
        StringBuilder sb2 = new StringBuilder("UpdateSurfaceSizeByCaptureParams, capture params size: ");
        ScreenCaptureParams screenCaptureParams2 = this.f44195j;
        sb2.append((Object) new Size(screenCaptureParams2.f44182c, screenCaptureParams2.f44183d));
        sb2.append(", surface final size:");
        sb2.append((Object) new Size(this.f44198m, this.f44199n));
        LiteavLog.i(str, sb2.toString());
    }

    private void g() {
        if (a(this.f44206u) != a(this.f44197l)) {
            Size size = this.f44196k;
            this.f44198m = size.height;
            this.f44199n = size.width;
        } else {
            Size size2 = this.f44196k;
            this.f44198m = size2.width;
            this.f44199n = size2.height;
        }
        LiteavLog.i(this.f44192g, "UpdateSurfaceSizeByDisplayOrientation, original display size:" + ((Object) this.f44196k) + " original rotation:" + ((Object) this.f44197l) + " , surface final size :" + ((Object) new Size(this.f44198m, this.f44199n)) + " current rotation:" + ((Object) this.f44206u));
    }

    private void h() {
        this.f44205t = null;
        VirtualDisplayManager.a(this.f44193h).a(this.f44202q);
        Surface surface = this.f44202q;
        if (surface != null) {
            surface.release();
            this.f44202q = null;
        }
        if (!c()) {
            LiteavLog.w(this.f44192g, "MakeCurrent error!");
            d();
            return;
        }
        com.tencent.liteav.videobase.frame.l lVar = this.f44191f;
        if (lVar != null) {
            lVar.b();
            this.f44191f = null;
        }
        SurfaceTexture surfaceTexture = this.f44201p;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.f44201p.release();
            this.f44201p = null;
        }
        OpenGlUtils.deleteTexture(this.f44200o);
        this.f44200o = -1;
        com.tencent.liteav.base.util.w wVar = this.f44204s;
        if (wVar != null) {
            wVar.a();
            this.f44204s = null;
        }
    }

    private void i() {
        this.f44197l = Rotation.a(SystemUtil.getDisplayRotationDegree());
        Size displaySize = SystemUtil.getDisplaySize();
        this.f44196k = displaySize;
        if (!displaySize.isValid()) {
            this.f44196k = a(this.f44197l) ? new Size(MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 1280) : new Size(1280, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH);
        }
        LiteavLog.i(this.f44192g, "get display size: " + ((Object) this.f44196k) + ", original rotation: " + ((Object) this.f44197l));
    }

    @Override // com.tencent.liteav.videoproducer.capture.au
    public final void a(CaptureSourceInterface.CaptureParams captureParams) {
        LiteavLog.i(this.f44192g, "Start capture %s", captureParams);
        if (this.f44317c == null) {
            LiteavLog.e(this.f44192g, "Start capture, mEGLCore is null");
            a(false);
            return;
        }
        ScreenCaptureParams screenCaptureParams = new ScreenCaptureParams((ScreenCaptureParams) captureParams);
        this.f44195j = screenCaptureParams;
        this.f44205t = screenCaptureParams.f44211f;
        if (!c()) {
            this.f44194i.notifyError(h.a.ERR_VIDEO_CAPTURE_SCREEN_CAPTURE_START_FAILED, "Start screen capture failed, params:" + ((Object) this.f44195j));
            a(false);
            return;
        }
        e();
    }

    @Override // com.tencent.liteav.videoproducer.capture.au
    public final void b() {
        LiteavLog.i(this.f44192g, "Stop capture");
        h();
        this.f44194i.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS, (Object) null, "Stop screen capture success");
        this.f44209x = false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.VirtualDisplayManager.VirtualDisplayListener
    public final void onCaptureError() {
        a(bf.a(this));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        a(bd.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.VirtualDisplayManager.VirtualDisplayListener
    public final void onStartFinish(boolean z10, boolean z11) {
        a(be.a(this, z10, z11));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034 A[RETURN] */
    @Override // com.tencent.liteav.base.util.w.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onTimeout() {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.ScreenCapturer.onTimeout():void");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void pause() {
        a(bb.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void resume() {
        a(bc.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.au, com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void stop() {
        b(az.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        a(ba.a(this, captureParams));
    }

    public static /* synthetic */ void b(ScreenCapturer screenCapturer) {
        if (screenCapturer.f44201p == null) {
            return;
        }
        screenCapturer.f44203r = new com.tencent.liteav.videobase.utils.g(screenCapturer.f44195j.f44181b);
        com.tencent.liteav.base.util.w wVar = new com.tencent.liteav.base.util.w(screenCapturer.f44315a.getLooper(), screenCapturer);
        screenCapturer.f44204s = wVar;
        wVar.a(0, 5);
        screenCapturer.f44201p.setOnFrameAvailableListener(null);
    }

    private void b(Rotation rotation) {
        CaptureSourceInterface.CaptureSourceListener captureSourceListener;
        if (this.f44195j.f44210a && (captureSourceListener = this.f44318d) != null) {
            captureSourceListener.onScreenDisplayOrientationChanged(rotation);
        }
    }

    public static /* synthetic */ void a(ScreenCapturer screenCapturer, CaptureSourceInterface.CaptureParams captureParams) {
        ScreenCaptureParams screenCaptureParams = screenCapturer.f44195j;
        if (screenCaptureParams != null && screenCaptureParams.equals(captureParams)) {
            LiteavLog.i(screenCapturer.f44192g, "UpdateParams %s is the same ", captureParams);
            return;
        }
        LiteavLog.i(screenCapturer.f44192g, "UpdateParams change from %s to %s", screenCapturer.f44195j, captureParams);
        ScreenCaptureParams screenCaptureParams2 = new ScreenCaptureParams((ScreenCaptureParams) captureParams);
        screenCapturer.f44195j = screenCaptureParams2;
        if (screenCapturer.f44201p == null) {
            LiteavLog.e(screenCapturer.f44192g, "Capturer not started");
            return;
        }
        screenCapturer.f44205t = screenCaptureParams2.f44211f;
        screenCapturer.h();
        screenCapturer.e();
    }

    public static /* synthetic */ void a(ScreenCapturer screenCapturer, boolean z10, boolean z11) {
        LiteavLog.i(screenCapturer.f44192g, "on Start finish, success: %b, isPermissionDenied: %b", Boolean.valueOf(z10), Boolean.valueOf(z11));
        screenCapturer.a(z10);
        if (z10) {
            if (screenCapturer.f44207v) {
                return;
            }
            screenCapturer.f44207v = true;
            screenCapturer.f44194i.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_START_SUCCESS, (Object) null, "Start screen capture success params:" + ((Object) screenCapturer.f44195j));
            return;
        }
        if (z11) {
            screenCapturer.f44194i.notifyError(h.a.ERR_VIDEO_CAPTURE_SCREEN_UNAUTHORIZED, "permission denied, Start screen capture failed, params:" + ((Object) screenCapturer.f44195j));
            return;
        }
        screenCapturer.f44194i.notifyError(h.a.ERR_VIDEO_CAPTURE_SCREEN_CAPTURE_START_FAILED, "Start screen capture failed, params:" + ((Object) screenCapturer.f44195j));
    }

    public static /* synthetic */ void a(ScreenCapturer screenCapturer) {
        LiteavLog.e(screenCapturer.f44192g, "capture error");
        CaptureSourceInterface.CaptureSourceListener captureSourceListener = screenCapturer.f44318d;
        if (captureSourceListener != null) {
            captureSourceListener.onCaptureError();
        }
        screenCapturer.f44194i.notifyEvent(h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED, (Object) null, "screen capture has been interrupted");
    }

    private static boolean a(Rotation rotation) {
        return rotation == null || rotation == Rotation.NORMAL || rotation == Rotation.ROTATION_180;
    }
}
