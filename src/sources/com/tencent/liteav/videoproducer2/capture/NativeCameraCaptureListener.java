package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeCameraCaptureListener implements SurfaceTexture.OnFrameAvailableListener, CameraEventCallback {

    @NonNull
    private final CustomHandler mCallbackHandler = new CustomHandler(Looper.myLooper());
    private long mNativeHandle;

    @CalledByNative
    public NativeCameraCaptureListener(long j10) {
        this.mNativeHandle = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnCameraError(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnFrameAvailable(long j10, SurfaceTexture surfaceTexture);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void runInNative(Runnable runnable) {
        if (this.mNativeHandle != 0) {
            runnable.run();
        }
    }

    @CalledByNative
    public Handler getCallbackHandler() {
        return this.mCallbackHandler;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraEventCallback
    public void onCameraError(CameraControllerInterface cameraControllerInterface) {
        this.mCallbackHandler.runOrPost(a.a(this));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mCallbackHandler.runOrPost(b.a(this, surfaceTexture));
    }

    @CalledByNative
    public synchronized void resetNativeHandle() {
        this.mNativeHandle = 0L;
    }
}
