package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.w;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t extends CaptureSourceInterface {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final Handler f44428a;

    /* renamed from: b, reason: collision with root package name */
    private final IVideoReporter f44429b;

    /* renamed from: c, reason: collision with root package name */
    private CaptureSourceInterface.CaptureSourceListener f44430c;

    /* renamed from: g, reason: collision with root package name */
    private CameraCaptureParams f44434g;

    /* renamed from: j, reason: collision with root package name */
    private final com.tencent.liteav.base.util.w f44437j;

    /* renamed from: l, reason: collision with root package name */
    private final w.a f44439l;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f44431d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private boolean f44432e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f44433f = false;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicLong f44435h = new AtomicLong(0);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicLong f44436i = new AtomicLong(0);

    /* renamed from: k, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureSourceListener f44438k = new AnonymousClass1();

    public t(@NonNull IVideoReporter iVideoReporter, @NonNull Looper looper) {
        w.a aVar = new w.a() { // from class: com.tencent.liteav.videoproducer.capture.t.2
            @Override // com.tencent.liteav.base.util.w.a
            public final void onTimeout() {
                long j10 = t.this.f44436i.get();
                if (t.this.f44431d.get() || j10 == 0 || SystemClock.elapsedRealtime() - j10 <= 5000) {
                    return;
                }
                t.this.f44429b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_CAMERA_STUCK, (Object) null, "");
                t.this.f44436i.set(0L);
            }
        };
        this.f44439l = aVar;
        this.f44429b = iVideoReporter;
        this.f44428a = new CustomHandler(looper);
        this.f44437j = new com.tencent.liteav.base.util.w(Looper.getMainLooper(), aVar);
    }

    public static /* synthetic */ void c(t tVar) {
        tVar.f44430c = null;
        CameraCaptureSingleton.getInstance().removeListener(tVar.f44438k);
        tVar.f44431d.set(true);
        tVar.f44432e = false;
        tVar.f44433f = false;
        tVar.f44435h.set(0L);
        tVar.f44437j.a();
        CameraCaptureSingleton.getInstance().stopAndWaitDone(2000);
    }

    public static /* synthetic */ boolean j(t tVar) {
        tVar.f44433f = true;
        return true;
    }

    public final void a(Runnable runnable) {
        if (this.f44428a != null) {
            if (Looper.myLooper() == this.f44428a.getLooper()) {
                runnable.run();
            } else {
                this.f44428a.post(runnable);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void pause() {
        LiteavLog.i("CameraCapturer", "pause");
        this.f44436i.set(0L);
        a(ab.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void resume() {
        LiteavLog.i("CameraCapturer", "resume");
        this.f44436i.set(SystemClock.elapsedRealtime());
        a(u.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void setCaptureCloudConfig(CaptureCloudConfig captureCloudConfig) {
        a(v.a(captureCloudConfig));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void start(Object obj, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        LiteavLog.i("CameraCapturer", "Start: ");
        this.f44435h.set(SystemClock.elapsedRealtime());
        this.f44436i.set(SystemClock.elapsedRealtime());
        a(y.a(this, captureParams, captureSourceListener, obj));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void stop() {
        LiteavLog.i("CameraCapturer", "Stop");
        a(z.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        LiteavLog.i("CameraCapturer", "updateParams");
        a(aa.a(this, captureParams));
    }

    public static Rotation b() {
        return CameraCaptureSingleton.getInstance().getCameraRotation();
    }

    /* renamed from: com.tencent.liteav.videoproducer.capture.t$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 implements CaptureSourceInterface.CaptureSourceListener {
        public AnonymousClass1() {
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1) {
            if (t.this.f44429b != null) {
                t.this.f44429b.notifyError(h.a.ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE, "create EGLCore failed");
            }
            if (t.this.f44430c != null) {
                t.this.f44430c.onCaptureError();
            }
        }

        public static /* synthetic */ void b(AnonymousClass1 anonymousClass1, boolean z10) {
            if (t.this.f44430c != null) {
                t.this.f44430c.onCameraTouchEnable(z10);
            }
        }

        public static /* synthetic */ void c(AnonymousClass1 anonymousClass1, boolean z10) {
            t.a(t.this, z10);
            if (t.this.f44430c != null) {
                t.this.f44430c.onStartFinish(z10);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onCameraTouchEnable(boolean z10) {
            t.this.a(af.a(this, z10));
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onCameraZoomEnable(boolean z10) {
            t.this.a(ag.a(this, z10));
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onCaptureError() {
            t.this.a(ae.a(this));
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onCaptureFirstFrame() {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onFrameAvailable(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
            if (pixelFrame == null) {
                return;
            }
            pixelFrame.retain();
            t.this.a(ad.a(this, pixelFrame));
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onScreenDisplayOrientationChanged(Rotation rotation) {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onStartFinish(boolean z10) {
            t.this.a(ac.a(this, z10));
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, boolean z10) {
            if (t.this.f44430c != null) {
                t.this.f44430c.onCameraZoomEnable(z10);
            }
        }

        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, PixelFrame pixelFrame) {
            t.this.f44436i.set(SystemClock.elapsedRealtime());
            long j10 = t.this.f44435h.get();
            if (j10 != 0) {
                t.this.f44429b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CAMERA_START_COST, Long.valueOf(SystemClock.elapsedRealtime() - j10));
                t.this.f44435h.set(0L);
            }
            if (!t.this.f44431d.get() && t.this.f44430c != null) {
                if (!t.this.f44433f) {
                    t.j(t.this);
                    t.this.f44430c.onCaptureFirstFrame();
                }
                t.this.f44430c.onFrameAvailable(t.this, pixelFrame);
            }
            pixelFrame.release();
        }
    }

    public static /* synthetic */ void b(t tVar) {
        if (tVar.f44431d.get()) {
            return;
        }
        tVar.f44431d.set(true);
        CameraCaptureSingleton.getInstance().pause();
    }

    public static boolean a() {
        return !CameraCaptureSingleton.getInstance().isAutoFocusEnabled();
    }

    public final void a(int i10, int i11) {
        a(w.a(i10, i11));
    }

    public final void a(float f10) {
        LiteavLog.i("CameraCapturer", "setZoom: ".concat(String.valueOf(f10)));
        a(x.a(f10));
    }

    public static /* synthetic */ void a(t tVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj) {
        tVar.f44431d.set(false);
        tVar.f44434g = new CameraCaptureParams((CameraCaptureParams) captureParams);
        tVar.f44437j.a(0, 1000);
        tVar.f44430c = captureSourceListener;
        CameraCaptureSingleton.getInstance().start(obj, tVar.f44434g, tVar.f44438k);
        tVar.f44434g.f44172a = null;
    }

    public static /* synthetic */ void a(t tVar, CaptureSourceInterface.CaptureParams captureParams) {
        tVar.f44434g = new CameraCaptureParams((CameraCaptureParams) captureParams);
        if (tVar.f44431d.get()) {
            tVar.f44432e = true;
        } else {
            CameraCaptureSingleton.getInstance().updateParams(tVar.f44434g);
            tVar.f44434g.f44172a = null;
        }
    }

    public static /* synthetic */ void a(t tVar) {
        if (tVar.f44431d.get()) {
            tVar.f44431d.set(false);
            if (tVar.f44432e) {
                tVar.f44432e = false;
                CameraCaptureSingleton.getInstance().updateParams(tVar.f44434g);
                tVar.f44434g.f44172a = null;
                return;
            }
            CameraCaptureSingleton.getInstance().resume();
        }
    }

    public static /* synthetic */ void a(t tVar, boolean z10) {
        if (tVar.f44429b != null) {
            CameraControllerInterface.a cameraAPIType = CameraCaptureSingleton.getInstance().getCameraAPIType();
            if (z10) {
                tVar.f44429b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_CAMERA_START_SUCCESS, (Object) null, "cameraAPIType " + ((Object) cameraAPIType) + " params:" + ((Object) tVar.f44434g));
                return;
            }
            h.a aVar = h.a.ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE;
            Context applicationContext = ContextUtils.getApplicationContext();
            boolean z11 = true;
            if (applicationContext != null && LiteavSystemInfo.getSystemOSVersionInt() >= 23 && applicationContext.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0) {
                z11 = false;
            }
            if (!z11) {
                LiteavLog.i("CameraCapturer", "has no camera authorized");
                aVar = h.a.ERR_VIDEO_CAPTURE_CAMERA_NOT_AUTHORIZED;
            }
            tVar.f44429b.notifyError(aVar, "cameraAPIType " + ((Object) cameraAPIType) + " params:" + ((Object) tVar.f44434g));
            tVar.f44429b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CAMERA_START_ERROR_TYPE, Integer.valueOf(aVar.mValue));
        }
    }
}
