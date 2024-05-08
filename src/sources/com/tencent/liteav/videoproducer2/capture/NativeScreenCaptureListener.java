package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeScreenCaptureListener implements SurfaceTexture.OnFrameAvailableListener, VirtualDisplayManager.VirtualDisplayListener {

    @NonNull
    private final CustomHandler mCallbackHandler = new CustomHandler(Looper.myLooper());
    private long mNativeHandle;

    @CalledByNative
    public NativeScreenCaptureListener(long j10) {
        this.mNativeHandle = j10;
    }

    private static native void nativeOnCaptureError(long j10);

    private static native void nativeOnFrameAvailable(long j10, SurfaceTexture surfaceTexture);

    private static native void nativeOnStartFinish(long j10, boolean z10, boolean z11);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyCaptureError() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeOnCaptureError(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyFrameAvailable(SurfaceTexture surfaceTexture) {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeOnFrameAvailable(j10, surfaceTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyStartFinish(boolean z10, boolean z11) {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeOnStartFinish(j10, z10, z11);
        }
    }

    @CalledByNative
    public Handler getCallbackHandler() {
        return this.mCallbackHandler;
    }

    @Override // com.tencent.liteav.videoproducer.capture.VirtualDisplayManager.VirtualDisplayListener
    public void onCaptureError() {
        this.mCallbackHandler.runOrPost(g.a(this));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mCallbackHandler.runOrPost(e.a(this, surfaceTexture));
    }

    @Override // com.tencent.liteav.videoproducer.capture.VirtualDisplayManager.VirtualDisplayListener
    public void onStartFinish(boolean z10, boolean z11) {
        this.mCallbackHandler.runOrPost(f.a(this, z10, z11));
    }

    @CalledByNative
    public synchronized void resetNativeHandle() {
        this.mNativeHandle = 0L;
    }
}
