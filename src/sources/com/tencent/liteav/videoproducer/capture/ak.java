package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.f;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ak extends CaptureSourceInterface {

    /* renamed from: a, reason: collision with root package name */
    public CaptureSourceInterface f44278a;

    /* renamed from: b, reason: collision with root package name */
    private VirtualCamera f44279b;

    /* renamed from: c, reason: collision with root package name */
    private VirtualCamera.VirtualCameraParams f44280c;

    /* renamed from: d, reason: collision with root package name */
    private CaptureSourceInterface.CaptureParams f44281d;

    /* renamed from: e, reason: collision with root package name */
    private CaptureSourceInterface.CaptureSourceListener f44282e;

    /* renamed from: f, reason: collision with root package name */
    private final Looper f44283f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f44284g;

    /* renamed from: h, reason: collision with root package name */
    private final IVideoReporter f44285h;

    /* renamed from: i, reason: collision with root package name */
    private Object f44286i;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    private final CustomHandler f44288k;

    /* renamed from: j, reason: collision with root package name */
    private boolean f44287j = false;

    /* renamed from: l, reason: collision with root package name */
    private a f44289l = a.STOPED;

    /* renamed from: m, reason: collision with root package name */
    private boolean f44290m = false;

    /* renamed from: o, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureSourceListener f44292o = new AnonymousClass1();

    /* renamed from: n, reason: collision with root package name */
    private final com.tencent.liteav.videobase.utils.f f44291n = new com.tencent.liteav.videobase.utils.f("CaptureController", new f.a(this) { // from class: com.tencent.liteav.videoproducer.capture.al

        /* renamed from: a, reason: collision with root package name */
        private final ak f44298a;

        {
            this.f44298a = this;
        }

        @Override // com.tencent.liteav.videobase.utils.f.a
        public final void a(double d10) {
            this.f44298a.f44285h.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CAPTURE_REAL_FRAME_RATE, Double.valueOf(d10));
        }
    });

    /* renamed from: com.tencent.liteav.videoproducer.capture.ak$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 implements CaptureSourceInterface.CaptureSourceListener {
        public AnonymousClass1() {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onCameraTouchEnable(boolean z10) {
            if (ak.this.f44282e != null) {
                ak.this.f44282e.onCameraTouchEnable(z10);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onCameraZoomEnable(boolean z10) {
            if (ak.this.f44282e != null) {
                ak.this.f44282e.onCameraZoomEnable(z10);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onCaptureError() {
            if (ak.this.f44282e != null) {
                ak.this.f44282e.onCaptureError();
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onCaptureFirstFrame() {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onFrameAvailable(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
            if (!ak.this.f44290m) {
                ak.f(ak.this);
                LiteavLog.i("CaptureController", "CaptureController received first frame.");
            }
            if (pixelFrame != null) {
                ak.this.a(as.a(this));
            }
            if (ak.this.f44282e != null) {
                ak.this.f44282e.onFrameAvailable(ak.this, pixelFrame);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onScreenDisplayOrientationChanged(Rotation rotation) {
            if (ak.this.f44282e != null) {
                ak.this.f44282e.onScreenDisplayOrientationChanged(rotation);
            }
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
        public final void onStartFinish(boolean z10) {
            if (ak.this.f44282e != null) {
                ak.this.f44282e.onStartFinish(z10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        STOPED,
        STARTED,
        PAUSED
    }

    public ak(@NonNull Context context, @NonNull Looper looper, @NonNull IVideoReporter iVideoReporter) {
        this.f44284g = context.getApplicationContext();
        this.f44283f = looper;
        this.f44285h = iVideoReporter;
        this.f44288k = new CustomHandler(looper);
    }

    public static /* synthetic */ void b(ak akVar) {
        if (akVar.f44289l != a.PAUSED) {
            LiteavLog.w("CaptureController", "resume capture but mStatus is " + ((Object) akVar.f44289l));
            return;
        }
        akVar.f44289l = a.STARTED;
        VirtualCamera virtualCamera = akVar.f44279b;
        if (virtualCamera != null) {
            virtualCamera.stop();
            akVar.f44279b = null;
        }
        CaptureSourceInterface captureSourceInterface = akVar.f44278a;
        if (captureSourceInterface != null) {
            captureSourceInterface.resume();
        }
    }

    public static /* synthetic */ void c(ak akVar) {
        if (akVar.f44289l != a.STARTED) {
            LiteavLog.w("CaptureController", "pause capture but mStatus is " + ((Object) akVar.f44289l));
            return;
        }
        akVar.f44289l = a.PAUSED;
        CaptureSourceInterface captureSourceInterface = akVar.f44278a;
        if (captureSourceInterface != null) {
            captureSourceInterface.pause();
        }
        if (akVar.f44287j) {
            if (akVar.f44280c == null) {
                CaptureSourceInterface.CaptureParams captureParams = akVar.f44281d;
                akVar.a((Bitmap) null, 5, captureParams.f44182c, captureParams.f44183d);
            } else {
                akVar.f44279b = new VirtualCamera(akVar.f44283f, akVar.f44285h);
            }
            VirtualCamera virtualCamera = akVar.f44279b;
            if (virtualCamera != null) {
                virtualCamera.start(akVar.f44286i, akVar.f44280c, akVar.f44292o);
                return;
            }
            return;
        }
        akVar.f44291n.b();
    }

    public static /* synthetic */ boolean f(ak akVar) {
        akVar.f44290m = true;
        return true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void pause() {
        LiteavLog.i("CaptureController", "pause");
        a(ao.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void resume() {
        LiteavLog.i("CaptureController", "resume");
        a(ap.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void setCaptureCloudConfig(CaptureCloudConfig captureCloudConfig) {
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void start(Object obj, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        LiteavLog.i("CaptureController", "Start params = " + captureParams.toString() + ", glContext=" + obj);
        a(an.a(this, captureParams, captureSourceListener, obj));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void stop() {
        LiteavLog.i("CaptureController", "Stop");
        a(aq.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        a(ar.a(this, captureParams));
    }

    public final void a(Bitmap bitmap, int i10, int i11, int i12) {
        LiteavLog.i("CaptureController", "setVirtualCameraParams fps = " + i10 + ",width=" + i11 + ",height=" + i12 + ",bm=" + ((Object) bitmap));
        a(am.a(this, bitmap, i10, i12, i11));
    }

    public static /* synthetic */ void a(ak akVar, Bitmap bitmap, int i10, int i11, int i12) {
        VirtualCamera.VirtualCameraParams virtualCameraParams = new VirtualCamera.VirtualCameraParams();
        akVar.f44280c = virtualCameraParams;
        virtualCameraParams.f44220a = bitmap;
        virtualCameraParams.f44181b = i10;
        virtualCameraParams.f44183d = i11;
        virtualCameraParams.f44182c = i12;
        VirtualCamera virtualCamera = akVar.f44279b;
        if (virtualCamera != null) {
            virtualCamera.stop();
        }
        akVar.f44279b = new VirtualCamera(akVar.f44283f, akVar.f44285h);
        akVar.f44287j = true;
    }

    public static /* synthetic */ void a(ak akVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj) {
        if (akVar.f44289l != a.STOPED) {
            LiteavLog.w("CaptureController", "Start capture but mStatus is " + ((Object) akVar.f44289l));
            return;
        }
        akVar.f44291n.b();
        akVar.f44289l = a.STARTED;
        if (captureParams instanceof CameraCaptureParams) {
            akVar.f44278a = new t(akVar.f44285h, akVar.f44283f);
        } else if (captureParams instanceof ScreenCapturer.ScreenCaptureParams) {
            akVar.f44278a = new ScreenCapturer(akVar.f44284g, akVar.f44283f, akVar.f44285h);
        } else {
            LiteavLog.w("CaptureController", "initCaptureSource： param is VirtualCameraParams");
        }
        akVar.f44282e = captureSourceListener;
        akVar.f44281d = captureParams;
        akVar.f44286i = obj;
        CaptureSourceInterface captureSourceInterface = akVar.f44278a;
        if (captureSourceInterface != null) {
            captureSourceInterface.start(obj, captureParams, akVar.f44292o);
        }
    }

    public static /* synthetic */ void a(ak akVar) {
        a aVar = akVar.f44289l;
        a aVar2 = a.STOPED;
        if (aVar == aVar2) {
            LiteavLog.w("CaptureController", "Stop capture but mStatus is stoped");
            return;
        }
        akVar.f44289l = aVar2;
        CaptureSourceInterface captureSourceInterface = akVar.f44278a;
        if (captureSourceInterface != null) {
            captureSourceInterface.stop();
            akVar.f44278a = null;
        }
        VirtualCamera virtualCamera = akVar.f44279b;
        if (virtualCamera != null) {
            virtualCamera.stop();
            akVar.f44279b = null;
        }
        akVar.f44290m = false;
        akVar.f44291n.b();
    }

    public static /* synthetic */ void a(ak akVar, CaptureSourceInterface.CaptureParams captureParams) {
        VirtualCamera virtualCamera;
        CaptureSourceInterface captureSourceInterface = akVar.f44278a;
        if (captureSourceInterface == null) {
            return;
        }
        akVar.f44281d = captureParams;
        a aVar = akVar.f44289l;
        if (aVar == a.STARTED) {
            captureSourceInterface.updateParams(captureParams);
            return;
        }
        if (aVar == a.PAUSED) {
            captureSourceInterface.updateParams(captureParams);
            if (!akVar.f44287j || (virtualCamera = akVar.f44279b) == null) {
                return;
            }
            virtualCamera.updateParams(akVar.f44281d);
        }
    }

    public final void a(Runnable runnable) {
        if (Looper.myLooper() == this.f44288k.getLooper()) {
            runnable.run();
        } else {
            this.f44288k.post(runnable);
        }
    }
}
