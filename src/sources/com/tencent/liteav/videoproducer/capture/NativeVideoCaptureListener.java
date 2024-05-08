package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class NativeVideoCaptureListener implements IVideoReporter, CaptureSourceInterface.CaptureSourceListener {
    private static final String TAG = "NativeVideoCaptureListener";
    private long mNativeHandler;

    @CalledByNative
    public NativeVideoCaptureListener(long j10) {
        this.mNativeHandler = j10;
    }

    private static native void nativeOnAutoFocusEnabled(long j10, boolean z10);

    private static native void nativeOnCaptureError(long j10, int i10, String str);

    private static native void nativeOnCaptureFirstFrame(long j10);

    private static native void nativeOnCapturePaused(long j10);

    private static native void nativeOnCaptureResumed(long j10);

    private static native void nativeOnCaptureStopped(long j10);

    private static native void nativeOnFrameAvailable(long j10, PixelFrame pixelFrame);

    private static native void nativeOnScreenDisplayOrientationChanged(long j10, int i10);

    private static native void nativeOnStartFinish(long j10, boolean z10);

    private static native void nativeOnZoomEnabled(long j10, boolean z10);

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void notifyError(h.a aVar, String str) {
        if (this.mNativeHandler == 0) {
            return;
        }
        int a10 = com.tencent.liteav.videobase.videobase.h.a(aVar);
        if (a10 != 0) {
            nativeOnCaptureError(this.mNativeHandler, a10, str);
            return;
        }
        LiteavLog.i(TAG, "notifyError error code:" + ((Object) aVar) + ", do not need transfer to LiteAvCode:" + a10);
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public void notifyEvent(h.b bVar, int i10, String str) {
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void notifyEvent(h.b bVar, Object obj, String str) {
        long j10 = this.mNativeHandler;
        if (j10 == 0) {
            return;
        }
        if (bVar == h.b.EVT_VIDEO_CAPTURE_FIRST_FRAME) {
            nativeOnCaptureFirstFrame(j10);
            return;
        }
        if (bVar == h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED) {
            nativeOnCapturePaused(j10);
        } else if (bVar == h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME) {
            nativeOnCaptureResumed(j10);
        } else {
            if (bVar == h.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS) {
                nativeOnCaptureStopped(j10);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void notifyWarning(h.c cVar, String str) {
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public synchronized void onCameraTouchEnable(boolean z10) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnAutoFocusEnabled(j10, !z10);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public synchronized void onCameraZoomEnable(boolean z10) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnZoomEnabled(j10, z10);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public synchronized void onCaptureError() {
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public synchronized void onCaptureFirstFrame() {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnCaptureFirstFrame(j10);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public synchronized void onFrameAvailable(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnFrameAvailable(j10, pixelFrame);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public synchronized void onScreenDisplayOrientationChanged(Rotation rotation) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnScreenDisplayOrientationChanged(j10, Rotation.a(rotation));
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public synchronized void onStartFinish(boolean z10) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnStartFinish(j10, z10);
        }
    }

    @CalledByNative
    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void updateStatus(com.tencent.liteav.videobase.videobase.i iVar, Object obj) {
    }

    @Override // com.tencent.liteav.videobase.videobase.IVideoReporter
    public synchronized void updateStatus(com.tencent.liteav.videobase.videobase.i iVar, int i10, Object obj) {
    }
}
