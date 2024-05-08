package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class NativeRenderViewListener implements RenderViewHelperInterface.RenderViewListener {
    private long mNativeHandler;

    @CalledByNative
    public NativeRenderViewListener(long j10) {
        this.mNativeHandler = j10;
    }

    private static native void nativeOnRequestRedraw(long j10, Bitmap bitmap);

    private static native void nativeOnSurfaceChanged(long j10, Surface surface, boolean z10);

    private static native void nativeOnSurfaceDestroy(long j10);

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onRequestRedraw(@NonNull Bitmap bitmap) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnRequestRedraw(j10, bitmap);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onSurfaceChanged(Surface surface, boolean z10) {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnSurfaceChanged(j10, surface, z10);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onSurfaceDestroy() {
        long j10 = this.mNativeHandler;
        if (j10 != 0) {
            nativeOnSurfaceDestroy(j10);
        }
    }

    @CalledByNative
    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }
}
