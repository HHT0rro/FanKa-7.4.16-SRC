package com.tencent.liteav.videoproducer.capture;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class au extends CaptureSourceInterface {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final CustomHandler f44315a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f44316b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public EGLCore f44317c;

    /* renamed from: d, reason: collision with root package name */
    public CaptureSourceInterface.CaptureSourceListener f44318d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.e f44319e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f44320f = new com.tencent.liteav.base.b.b();

    public au(@NonNull Looper looper, @NonNull IVideoReporter iVideoReporter) {
        this.f44315a = new CustomHandler(looper);
        this.f44316b = iVideoReporter;
    }

    public static /* synthetic */ void a(au auVar, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj, CaptureSourceInterface.CaptureParams captureParams) {
        if (auVar.f44317c != null) {
            LiteavLog.w("GLCapturerSource", "capture source has already started!");
            return;
        }
        auVar.f44318d = captureSourceListener;
        EGLCore eGLCore = new EGLCore();
        auVar.f44317c = eGLCore;
        try {
            eGLCore.initialize(obj, null, 128, 128);
            auVar.f44317c.makeCurrent();
            auVar.f44319e = new com.tencent.liteav.videobase.frame.e();
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e("GLCapturerSource", "initializeEGL failed.", e2);
            auVar.f44316b.notifyError(h.a.ERR_VIDEO_CAPTURE_EGL_CORE_CREATE_FAILED, "create EGLCore failed, errorCode:" + e2.mErrorCode);
            auVar.f44317c = null;
        }
        auVar.a(captureParams);
    }

    public abstract void a(CaptureSourceInterface.CaptureParams captureParams);

    public abstract void b();

    public final void b(Runnable runnable) {
        if (this.f44315a.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f44315a.runAndWaitDone(runnable);
        }
    }

    public final boolean c() {
        EGLCore eGLCore = this.f44317c;
        if (eGLCore == null) {
            LiteavLog.e(this.f44320f.a("makeCurrentNull"), "GLCapturerSource", "makeCurrent on mEGLCore is null", new Object[0]);
            return false;
        }
        try {
            eGLCore.makeCurrent();
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f44320f.a("makeCurrentError"), "GLCapturerSource", "make current failed.", e2);
            this.f44316b.notifyError(h.a.ERR_VIDEO_CAPTURE_OPENGL_ERROR, "OpenGL report error, errorCode:" + e2.mErrorCode);
            return false;
        }
    }

    public final void d() {
        CaptureSourceInterface.CaptureSourceListener captureSourceListener = this.f44318d;
        if (captureSourceListener != null) {
            captureSourceListener.onCaptureError();
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void setCaptureCloudConfig(CaptureCloudConfig captureCloudConfig) {
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void start(Object obj, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        a(av.a(this, captureSourceListener, obj, captureParams));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void stop() {
        a(aw.a(this));
    }

    public final void a() {
        if (this.f44317c == null) {
            LiteavLog.w("GLCapturerSource", "capture source has already stopped!");
            return;
        }
        b();
        EGLCore eGLCore = this.f44317c;
        if (eGLCore != null) {
            try {
                eGLCore.makeCurrent();
                com.tencent.liteav.videobase.frame.e eVar = this.f44319e;
                if (eVar != null) {
                    eVar.b();
                    this.f44319e = null;
                }
            } catch (com.tencent.liteav.videobase.egl.f e2) {
                LiteavLog.e(this.f44320f.a("unintError"), "GLCapturerSource", "EGLCore destroy failed.", e2);
            }
            EGLCore.destroy(this.f44317c);
            this.f44317c = null;
        }
        this.f44318d = null;
    }

    public final void a(Runnable runnable) {
        if (this.f44315a.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.f44315a.post(runnable);
        }
    }

    public final void a(boolean z10) {
        CaptureSourceInterface.CaptureSourceListener captureSourceListener = this.f44318d;
        if (captureSourceListener != null) {
            captureSourceListener.onStartFinish(z10);
        }
    }
}
